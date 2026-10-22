package fa8;

import android.media.AudioTrack;
import com.larus.audio.call.plugins.v0;
import com.larus.avlink.n1;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final v0 a;
    public volatile AudioTrack b;
    public volatile int c;
    public final fa8.a d;
    public final fa8.a e;
    public PthreadThreadV2 f;
    public volatile boolean g;
    public final ReentrantLock h;
    public final Condition i;
    public final com.larus.audio.call.play.f j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile long o;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if ((!this.k) == false) goto L6;
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
        n1.d("StereoAudioPlayer", "Begin new play segment. " + b());
        return;
    }

    public final String b() {
        return "running=" + this.g + ", active=" + this.k + ", firstFrameMarkerRegistered=" + this.l + ", playEndMarkerRegistered=" + this.m + ", replyEnd=" + this.n + ", writtenFrames=" + this.o + ", leftSize=" + this.d.b + ", rightSize=" + this.e.b;
    }

    public final void d() {
        AudioTrack r1 = this.b;
        if (r1 != null) goto L5;
    L11:
        this.b = null;
        ReentrantLock r2 = this.h;
        r2.lock();
        n1.d("StereoAudioPlayer", "Release player resources. " + b());     // Catch: Throwable -> L15
        fa8.a r0 = this.d;     // Catch: Throwable -> L15
        r0.a.clear();     // Catch: Throwable -> L15
        r0.b = 0;     // Catch: Throwable -> L15
        fa8.a r3 = this.e;     // Catch: Throwable -> L15
        r3.a.clear();     // Catch: Throwable -> L15
        r3.b = 0;     // Catch: Throwable -> L15
        this.k = false;     // Catch: Throwable -> L15
        this.l = false;     // Catch: Throwable -> L15
        this.m = false;     // Catch: Throwable -> L15
        this.n = false;     // Catch: Throwable -> L15
        this.o = 0;     // Catch: Throwable -> L15
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r2.unlock();
        return;
    L15:
        th = move-exception;
        r2.unlock();
        throw th;
    L5:
        if (r1.getPlayState() == 3) goto L7;
    L10:
        r1.flush();
        r1.release();
        goto L11
    L7:
        if (fna.g.d() == true) goto L9;
        r1.stop();
        goto L10
    L9:
        r1.stop();
        gna.a.a(r1.hashCode());
        goto L10
    }

    public f(v0 r1) {
        this.a = r1;
        this.d = new fa8.a();
        this.e = new fa8.a();
        ReentrantLock r2 = new ReentrantLock();
        this.h = r2;
        this.i = r2.newCondition();
        this.j = new com.larus.audio.call.play.f();
    }

    public final boolean c(String r5) {
        if (this.k == true) goto L6;
        n1.d("StereoAudioPlayer", "Skip ending segment from " + r5 + " because no active segment. " + b());
        return false;
    L6:
        n1.d("StereoAudioPlayer", "End play segment from " + r5 + ". " + b());
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        return true;
    }

    public final void e(AudioTrack r3) {
        n1.d("StereoAudioPlayer", "[simultaneous_interpret]:setPositionNotification");
        r3.setNotificationMarkerPosition(r3.getPlaybackHeadPosition() + 1);
        r3.setPlaybackPositionUpdateListener(new g(this));
    }

    public final void f(AudioTrack r6) {
        int r0 = Math.max(r6.getPlaybackHeadPosition() + 1, (int) RangesKt.coerceAtMost(this.o, 2147483647L));
        n1.d("StereoAudioPlayer", "[reply end with empty buffers]:setPlayEndPositionNotification marker=" + r0);
        r6.setNotificationMarkerPosition(r0);
        r6.setPlaybackPositionUpdateListener(new h(this));
    }
}
