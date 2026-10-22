package com.ss.android.common.applog;

/* JADX INFO: loaded from: classes6.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f15051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final af f15052b = null;
    final String[] c;
    final String d;
    final String[] e;
    final String[] f;
    final String[] g;
    final String[] h;
    final String i;
    final String j;

    static {
        af r9 = new af(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}, new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"}, new String[]{"https://log.snssdk.com/service/2/device_register/", "https://log.snssdk.com/service/2/device_register/"}, new String[]{"https://ichannel.snssdk.com/service/2/app_alert_check/"}, "https://log.snssdk.com/service/2/log_settings/", new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}, "https://log.snssdk.com/service/2/log_settings/", "https://dpprofile.snssdk.com");
        f15051a = r9;
        f15052b = r9;
    }

    public af(String[] r1, String[] r2, String[] r3, String[] r4, String r5, String[] r6, String r7, String r8) {
        this.c = r1;
        this.d = r5;
        this.e = r2;
        this.f = r4;
        this.g = r3;
        this.h = r6;
        this.i = r7;
        this.j = r8;
    }

    public String toString() {
        return super.toString() + ":\nmApplogURL : " + this.c + "\nmApplogTimelyUrl : " + this.e + "\nmDeviceRegisterUrl : " + this.g + "\nmAppActiveUrl : " + this.f + "\nmApplogSettingsUrl : " + this.d + "\n\nmApplogFallbackUrl : " + this.h + "\nmApplogSettingsFallbackUrl : " + this.i + "\nmUserProfileUrl : " + this.j + "\n\n\n\n";
    }
}
