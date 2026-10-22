package q52;

import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void b(d r1) {
        Intrinsics.checkNotNullParameter(r1, "messageManager");
        if ((r1 instanceof e) == true) goto L5;
        return;
    L5:
        if (((e) r1).isPaused() == false) goto L7;
        EpisodeInteractivityTracer.c("resume message manager");
    L8:
        r1.startMessage();
        return;
    L7:
        EpisodeInteractivityTracer.c("start message manager");
        goto L8
    }

    @JvmStatic
    public static final void a(d r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "messageManager");
        Intrinsics.checkNotNullParameter(r2, "cursor");
        if ((r1 instanceof e) == false) goto L11;
        amc.e r3 = ((e) r1).q();
        if ((r3 instanceof a) == true) goto L7;
        r3 = null;
    L7:
        a r4 = (a) r3;
        if (r4 == null) goto L12;
        r4.a(r2);
        return;
    L12:
        return;
    }
}
