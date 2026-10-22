package com.ss.android.common.applog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class m0 {
    public static final m0 h = null;
    public static final m0 i = null;
    public final String[] a;
    public final String b;
    public final String[] c;
    public final String[] d;
    public final String[] e;
    public final String[] f;
    public final String g;

    static {
        m0 r8 = new m0(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}, new String[]{"https://log.snssdk.com/service/2/device_register/", "https://log.snssdk.com/service/2/device_register/"}, new String[]{"https://ichannel.snssdk.com/service/2/app_alert_check/"}, "https://log.zijieapi.com/service/2/log_settings/", new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, "https://log.zijieapi.com/service/2/log_settings/");
        h = r8;
        i = r8;
    }

    public final String toString() {
        return super.toString() + ":\nmApplogURL : " + this.a + "\nmApplogTimelyUrl : " + this.c + "\nmDeviceRegisterUrl : " + this.e + "\nmAppActiveUrl : " + this.d + "\nmApplogSettingsUrl : " + this.b + "\n\nmApplogFallbackUrl : " + this.f + "\nmApplogSettingsFallbackUrl : " + this.g + "\nmUserProfileUrl : https://dpprofile.snssdk.com\n\n\n\n";
    }

    public m0(String[] r1, String[] r2, String[] r3, String[] r4, String r5, String[] r6, String r7) {
        this.a = r1;
        this.b = r5;
        this.c = r2;
        this.d = r4;
        this.e = r3;
        this.f = r6;
        this.g = r7;
    }
}
