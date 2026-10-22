package fa8;

import android.media.AudioTrack;
import com.larus.avlink.n1;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements AudioTrack.OnPlaybackPositionUpdateListener {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r2) {
        Intrinsics.checkNotNullParameter(r2, "track");
    }

    public g(f r1) {
        this.a = r1;
        this.b = "simultaneous_interpret";
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r3) {
        Intrinsics.checkNotNullParameter(r3, "track");
        f r4 = this.a;
        ReentrantLock r0 = r4.h;
        r0.lock();
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (r4.g == true) goto L6;
    L10:
        boolean r5 = false;
    L11:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r0.unlock();
        if (r5 == false) goto L21;
        n1.d("StereoAudioPlayer", "[" + this.b + "]:onMarkerReached first frame.");
        this.a.j.c();
        return;
    L21:
        return;
    L6:
        if (r4.k == false) goto L10;
        if (r4.l == false) goto L10;
        r5 = true;
        goto L11
    }
}
