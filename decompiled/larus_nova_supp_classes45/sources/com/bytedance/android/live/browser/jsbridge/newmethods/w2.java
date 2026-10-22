package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/w2;", "", "", "exposure", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setExposure", "(Ljava/lang/Boolean;)V", "", "key", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "owner", "getOwner", "setOwner", "desc", "getDesc", "setDesc", "defaultValue", "a", "setDefaultValue", "", "valueType", "Ljava/lang/Integer;", "getValueType", "()Ljava/lang/Integer;", "setValueType", "(Ljava/lang/Integer;)V", "isSticky", "d", "setSticky", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w2 {

    @SerializedName("defaultValue")
    private String defaultValue;

    @SerializedName("desc")
    private String desc;

    @SerializedName("exposure")
    private Boolean exposure;

    @SerializedName("isSticky")
    private Boolean isSticky;

    @SerializedName("key")
    private String key;

    @SerializedName("owner")
    private String owner;

    @SerializedName("valueType")
    private Integer valueType;

    public w2() {
    }

    public final String a() {
        return this.defaultValue;
    }

    public final Boolean b() {
        return this.exposure;
    }

    public final String c() {
        return this.key;
    }

    public final Boolean d() {
        return this.isSticky;
    }
}
