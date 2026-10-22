package ndb;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class d {

    @SerializedName("fg_Interface_type")
    public String fgInterfaceType;

    @SerializedName("fg_key")
    public String fgKey;

    @SerializedName("fg_value_client")
    public String fgValueClient;

    @SerializedName("fg_value_server")
    public String fgValueServer;

    @SerializedName("pv")
    public int pv;

    public d() {
    }

    public final String a() {
        return "FeatureGatingUseBean{fg_key=" + this.fgKey + ", fg_value_client=" + this.fgValueClient + ", fg_value_server=" + this.fgValueServer + ", fg_Interface_type=" + this.fgInterfaceType + '}';
    }
}
