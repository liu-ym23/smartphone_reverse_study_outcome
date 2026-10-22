package dpa;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class g {

    @SerializedName("collect_android_id")
    public boolean collect_android_id;

    @SerializedName("collect_iccid")
    public boolean collect_iccid;

    @SerializedName("collect_imei")
    public boolean collect_imei;

    @SerializedName("collect_mac")
    public boolean collect_mac;

    @SerializedName("enabled")
    public boolean enabled;

    @SerializedName("min_report_interval")
    public int min_report_interval;

    @SerializedName("report_interval")
    public int report_interval;

    @SerializedName(EffectConfiguration.KEY_VERSION)
    public int version;

    public g() {
    }
}
