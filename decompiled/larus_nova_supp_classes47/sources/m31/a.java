package m31;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.multianchor.player.utils.LiveType;
import kotlin.jvm.internal.Intrinsics;
import rc0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(LiveType r2, DeviceType r3) {
        Intrinsics.checkNotNullParameter(r2, "live");
        Intrinsics.checkNotNullParameter(r3, "device");
        if (n.a(r3) == false) goto L8;
        b03.a r4 = b03.a.a;
        if (b03.a.b() == true) goto L8;
        return false;
    L8:
        if (r2 != LiveType.PC_LIVE) goto L11;
        return true;
    L11:
        if (r2 != LiveType.VIDEO) goto L14;
        return true;
    L14:
        if (r2 != LiveType.AUDIO) goto L17;
        return true;
    L17:
        if (r2 != LiveType.SCREEN_RECORD) goto L19;
        return true;
    L19:
        return false;
    }
}
