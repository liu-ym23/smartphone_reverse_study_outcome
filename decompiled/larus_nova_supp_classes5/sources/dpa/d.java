package dpa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static volatile h a;

    public static c a() {
        if (a == null) goto L5;
        c r0 = a.a();
        if (r0.azerothGlobalSettings != null) goto L10;
        b r1 = new b();
        r1.global_function_switch = true;
        r0.azerothGlobalSettings = r1;
    L10:
        if (r0.testConf != null) goto L13;
        i r2 = new i();
        r2.msg = "hello from local default!";
        r2.version = 0;
        r0.testConf = r2;
    L13:
        if (r0.envReportSetting != null) goto L16;
        g r3 = new g();
        r3.enabled = true;
        r3.version = 0;
        r3.report_interval = 24;
        r3.collect_android_id = false;
        r3.collect_iccid = false;
        r3.collect_imei = false;
        r3.collect_mac = false;
        r3.min_report_interval = 28800;
        r0.envReportSetting = r3;
    L16:
        if (r0.dailyReportSetting != null) goto L19;
        f r4 = new f();
        r4.enabled = true;
        r0.dailyReportSetting = r4;
    L19:
        if (r0.cryptoSetting != null) goto L22;
        e r5 = new e();
        r5.enabled = true;
        r5.version = 0;
        r5.disable_crypto = false;
        r5.disable_android_key_store = false;
        r0.cryptoSetting = r5;
    L22:
        if (r0.aKexgSetting != null) goto L24;
        a r6 = new a();
        r6.downgrade = false;
        r0.aKexgSetting = r6;
    L24:
        return r0;
    L5:
        return c.a();
    }
}
