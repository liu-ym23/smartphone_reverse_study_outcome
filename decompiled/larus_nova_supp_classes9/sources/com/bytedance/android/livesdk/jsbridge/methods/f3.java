package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/f3;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "params", "c", "setParams", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f3 {

    @SerializedName("eventName")
    private String eventName;

    @SerializedName("extra")
    private JsonObject extra;

    @SerializedName("params")
    private JsonObject params;

    public f3() {
    }

    public final String a() {
        return this.eventName;
    }

    public final JsonObject b() {
        return this.extra;
    }

    public final JsonObject c() {
        return this.params;
    }
}
