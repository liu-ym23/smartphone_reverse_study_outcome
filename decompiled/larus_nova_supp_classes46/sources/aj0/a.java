package aj0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import java.util.Map;
import je0.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final boolean c(int r1) {
        if (r1 != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean d() {
        return c(d.f());
    }

    public static boolean e() {
        int r0 = d.f();
        Integer r1 = d.h();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L7:
        if (r0 == 16) goto L9;
        return false;
    L9:
        if (r2 != 58) goto L11;
    L12:
        return true;
    L11:
        if (r2 == 56) goto L12;
        return false;
    L5:
        r2 = 0;
        goto L7
    }

    public static final boolean b(IRoom r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getAnchorABMap();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("cross_link_support_enlarge_guest");
    L8:
        return Intrinsics.areEqual(r3, "1");
    L6:
        r3 = null;
        goto L8
    }

    public static final boolean a(int r1, IRoom r2) {
        if (e() == true) goto L5;
    L9:
        return false;
    L5:
        if (b(r2) == false) goto L9;
        if (r1 != VideoShowMode.AUDIO.getType()) goto L9;
        return true;
    }
}
