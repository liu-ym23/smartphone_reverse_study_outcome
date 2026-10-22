package oh;

import android.net.Uri;
import com.bytedance.pia.core.setting.Settings;
import com.lynx.tasm.p;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20578a = null;

    static {
        f20578a = new f();
    }

    public static boolean a(Uri r5) {
        if (r5 != null) goto L5;
    L56:
        return false;
    L5:
        if (com.bytedance.pia.core.utils.j.z(r5) == false) goto L56;
        com.bytedance.pia.core.setting.a r10 = com.bytedance.pia.core.setting.a.f;
        Lazy r11 = Settings.B;
        if (p.a().q() == true) goto L11;
        return false;
    L11:
        if (p.a().c(r5) == true) goto L14;
        return false;
    L14:
        if (p.a().f(r5) == false) goto L17;
        return false;
    L17:
        if (r5.getBooleanQueryParameter("__pia_manifest__", false) == false) goto L20;
        return true;
    L20:
        if (p.a().r() == false) goto L41;
        if (Settings.D == false) goto L39;
        com.bytedance.pia.core.setting.b.f7084a.a(r5);
        if (com.bytedance.pia.core.setting.d.f7088a == false) goto L39;
        String r12 = com.bytedance.pia.core.utils.j.k(r5, null);
        if (r12 == null) goto L36;
        if (com.bytedance.pia.core.setting.d.f7089b.contains(r12) == true) goto L39;
        if (com.bytedance.pia.core.setting.d.f7090c.contains(r12) == true) goto L39;
    L36:
        if (r5.getBooleanQueryParameter("_pia_", false) == true) goto L39;
        return false;
    L39:
        return true;
    L41:
        if (r5.getBooleanQueryParameter("_pia_", false) == false) goto L56;
        if (Settings.D == false) goto L55;
        com.bytedance.pia.core.setting.b.f7084a.a(r5);
        if (com.bytedance.pia.core.setting.d.f7088a == false) goto L55;
        String r13 = com.bytedance.pia.core.utils.j.k(r5, null);
        if (r13 == null) goto L56;
        if (com.bytedance.pia.core.setting.d.f7089b.contains(r13) == true) goto L55;
        if (com.bytedance.pia.core.setting.d.f7090c.contains(r13) == false) goto L56;
    L55:
        return true;
    }
}
