package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/yb;", "", "", "emojiId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setEmojiId", "(Ljava/lang/String;)V", "", "ratioType", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setRatioType", "(Ljava/lang/Integer;)V", "type", "getType", "setType", "messageSource", "c", "setMessageSource", "Lcom/google/gson/JsonObject;", "extraParams", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setExtraParams", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class yb {

    @SerializedName("emojiId")
    private String emojiId;

    @SerializedName("extraParams")
    private JsonObject extraParams;

    @SerializedName("messageSource")
    private String messageSource;

    @SerializedName("ratioType")
    private Integer ratioType;

    @SerializedName("type")
    private Integer type;

    public yb() {
    }

    public final String a() {
        return this.emojiId;
    }

    public final JsonObject b() {
        return this.extraParams;
    }

    public final String c() {
        return this.messageSource;
    }

    public final Integer d() {
        return this.ratioType;
    }

    public final Integer getType() {
        return this.type;
    }
}
