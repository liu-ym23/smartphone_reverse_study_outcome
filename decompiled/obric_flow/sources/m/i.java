package m;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f19880a = false;

    static {
        String r5 = "Mi_R_".concat(i.class.getSimpleName());
        boolean r10 = "true".equals((String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"ro.vendor.feature.zte_feature_ct_ai", "false"}));     // Catch: Exception -> L6
        Log.d(r5, "getCustomCTAIFeature: " + r10);     // Catch: Exception -> L9
    L7:
        f19880a = r10;
        return;
    L6:
        r10 = false;
        goto L7
    }
}
