package dpa;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class c {

    @SerializedName("akexg")
    public a aKexgSetting;

    @SerializedName("global_settings")
    public b azerothGlobalSettings;

    @SerializedName("crypto")
    public e cryptoSetting;

    @SerializedName("daily_report")
    public f dailyReportSetting;

    @SerializedName("env_report")
    public g envReportSetting;

    @SerializedName("test_json_conf")
    public i testConf;

    public c() {
    }

    public static c a() {
        c r0 = new c();
        b r1 = new b();
        r1.global_function_switch = true;
        r0.azerothGlobalSettings = r1;
        i r2 = new i();
        r2.msg = "hello from local default!";
        r2.version = 0;
        r0.testConf = r2;
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
        f r4 = new f();
        r4.enabled = true;
        r0.dailyReportSetting = r4;
        e r5 = new e();
        r5.enabled = true;
        r5.version = 0;
        r5.disable_crypto = false;
        r5.disable_android_key_store = false;
        r0.cryptoSetting = r5;
        a r6 = new a();
        r6.downgrade = false;
        r0.aKexgSetting = r6;
        return r0;
    }

    public final String toString() {
        return "AzerothSettings{global_function_switch=" + this.azerothGlobalSettings.global_function_switch + ", envReportSetting.version=" + this.envReportSetting.version + ", dailyReportSetting.enabled=" + this.dailyReportSetting.enabled + ", cryptoSetting.version=" + this.cryptoSetting.version + ", aKexgSetting.downgrade=" + this.aKexgSetting.downgrade + '}';
    }
}
