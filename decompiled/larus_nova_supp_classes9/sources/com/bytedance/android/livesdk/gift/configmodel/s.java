package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/s;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "togetherSendPredownload", "Z", "b", "()Z", "setTogetherSendPredownload", "(Z)V", "anchorPredownload", "a", "setAnchorPredownload", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("anchor_receive")
    private boolean anchorPredownload;

    @SerializedName("together_send")
    private boolean togetherSendPredownload;

    public s() {
        this.togetherSendPredownload = true;
    }

    public final boolean a() {
        return this.anchorPredownload;
    }

    public final boolean b() {
        return this.togetherSendPredownload;
    }
}
