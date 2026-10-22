package fa8;

import android.media.AudioTrack;
import com.larus.avlink.n1;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements AudioTrack.OnPlaybackPositionUpdateListener {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r2) {
        Intrinsics.checkNotNullParameter(r2, "track");
    }

    public h(f r1) {
        this.a = r1;
        this.b = "reply end with empty buffers";
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r4) {
        Intrinsics.checkNotNullParameter(r4, "track");
        f r5 = this.a;
        ReentrantLock r0 = r5.h;
        String r1 = this.b;
        r0.lock();
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (r5.g == true) goto L6;
    L10:
        boolean r6 = false;
    L11:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r0.unlock();
        if (r6 == false) goto L21;
        n1.d("StereoAudioPlayer", "[" + this.b + "]:onMarkerReached play end.");
        u68.a.b.a.a(this.a.j);
        return;
    L21:
        return;
    L6:
        if (r5.k == false) goto L10;
        if (r5.m == false) goto L10;
        r6 = r5.c(r1);     // Catch: Throwable -> L16
        goto L11
    }
}
