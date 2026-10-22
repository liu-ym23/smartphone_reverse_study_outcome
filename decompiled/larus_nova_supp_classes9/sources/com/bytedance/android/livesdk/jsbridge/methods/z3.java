package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/z3;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventName", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "params", "Lcom/google/gson/JsonObject;", "f", "()Lcom/google/gson/JsonObject;", "setParams", "(Lcom/google/gson/JsonObject;)V", "btm", "b", "setBtm", BuildConfig.FLAVOR, "enter_new_page", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "setEnter_new_page", "(Ljava/lang/Boolean;)V", "add_btm_chain", "a", "setAdd_btm_chain", BuildConfig.FLAVOR, "chain_length", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setChain_length", "(Ljava/lang/Integer;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z3 {

    @SerializedName("add_btm_chain")
    private Boolean add_btm_chain;

    @SerializedName("btm")
    private String btm;

    @SerializedName("chain_length")
    private Integer chain_length;

    @SerializedName("enter_new_page")
    private Boolean enter_new_page;

    @SerializedName("eventName")
    private String eventName;

    @SerializedName("params")
    private JsonObject params;

    public z3() {
    }

    public final Boolean a() {
        return this.add_btm_chain;
    }

    public final String b() {
        return this.btm;
    }

    public final Integer c() {
        return this.chain_length;
    }

    public final Boolean d() {
        return this.enter_new_page;
    }

    public final String e() {
        return this.eventName;
    }

    public final JsonObject f() {
        return this.params;
    }
}
