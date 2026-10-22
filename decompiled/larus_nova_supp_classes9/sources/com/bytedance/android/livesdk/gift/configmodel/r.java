package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/r;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "renewGuideList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setRenewGuideList", "(Ljava/util/List;)V", "renewedText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setRenewedText", "(Ljava/lang/String;)V", "rightBtnText", "e", "setRightBtnText", "rightBtnSchema", "d", "setRightBtnSchema", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("renew_guide_list")
    private List<String> renewGuideList;

    @SerializedName("renewed_text")
    private String renewedText;

    @SerializedName("right_btn_schema")
    private String rightBtnSchema;

    @SerializedName("right_btn_text")
    private String rightBtnText;

    public r() {
        this.renewGuideList = CollectionsKt.emptyList();
        this.renewedText = BuildConfig.FLAVOR;
        this.rightBtnText = BuildConfig.FLAVOR;
        this.rightBtnSchema = BuildConfig.FLAVOR;
    }

    public final boolean a() {
        return this.enable;
    }

    public final List<String> b() {
        return this.renewGuideList;
    }

    public final String c() {
        return this.renewedText;
    }

    public final String d() {
        return this.rightBtnSchema;
    }

    public final String e() {
        return this.rightBtnText;
    }
}
