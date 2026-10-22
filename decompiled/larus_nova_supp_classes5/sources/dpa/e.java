package dpa;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class e {

    @SerializedName("disable_android_key_store")
    public boolean disable_android_key_store;

    @SerializedName("disable_crypto")
    public boolean disable_crypto;

    @SerializedName("enabled")
    public boolean enabled;

    @SerializedName(EffectConfiguration.KEY_VERSION)
    public int version;

    public e() {
    }
}
