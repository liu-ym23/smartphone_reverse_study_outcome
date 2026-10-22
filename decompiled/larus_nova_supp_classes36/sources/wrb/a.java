package wrb;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final HashMap<String, String> a = null;
    public static final HashMap<String, String> b = null;
    public static final HashMap<String, String> c = null;

    static {
        HashMap<String, String> r0 = new HashMap();
        a = r0;
        b = new HashMap();
        HashMap<String, String> r1 = new HashMap();
        c = r1;
        r0.put("integrator", "com.ss.android.lark.integrator.ccm.WikiModuleProvider.WikiModule");
        r0.put("integrator", "com.ss.android.lark.integrator.ccm.spacekit.LarkSpacekitModule");
        r0.put("drive", "com.ss.android.lark.drive.DriveModule");
        r1.put("org.koin", "com.ss.android.lark.integrator.ccm.spacekit.LarkSpacekitModule");
        r1.put("com.bytedance.ee.bear", "com.ss.android.lark.integrator.ccm.spacekit.LarkSpacekitModule");
    }
}
