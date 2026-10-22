package x19;

import com.larus.common_ui.video.VideoPlayView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static boolean a;
    public static long b;

    static {
        a = true;
    }

    public static void a() {
        b = 0;
        a = true;
    }

    public static long b(VideoPlayView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "videoView");
        if (r3 == false) goto L5;
        long r4 = r2.getDuration();
    L7:
        return r4 - b;
    L5:
        r4 = r2.getCurrentPlaybackTime();
        goto L7
    }
}
