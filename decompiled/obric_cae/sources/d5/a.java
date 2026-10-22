package d5;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f6782b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6783a;

    public a() {
        if (System.getProperty("java.vm.name") != null) goto L6;
    L7:
        if (System.getProperty("ro.yunos.version") == null) goto L10;
    L9:
        boolean r8 = true;
    L11:
        if (r8 == false) goto L19;
        String r10 = a("ro.aliyun.clouduuid");
        this.f6783a = r10;
        if (TextUtils.isEmpty(r10) == false) goto L20;
        this.f6783a = a("ro.sys.aliyun.clouduuid");
        return;
    L20:
        return;
    L19:
        return;
    L6:
        if (System.getProperty("java.vm.name").toLowerCase().contains("lemur") == true) goto L9;
    L10:
        r8 = false;
        goto L11
    }

    public static String a(String r8) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, "false"});
    L5:
        return "false";
    }
}
