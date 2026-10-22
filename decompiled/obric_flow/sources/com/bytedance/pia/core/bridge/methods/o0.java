package com.bytedance.pia.core.bridge.methods;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;

/* JADX INFO: loaded from: classes2.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("url")
    private String f7008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("name")
    private String f7009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("location")
    private String f7010c;

    @SerializedName(LynxResourceModule.PARAMS_KEY)
    private JsonElement d;

    @SerializedName("execute_time_limit")
    private Long e;

    public o0() {
    }

    public static /* synthetic */ String a(o0 r5) {
        return r5.f7008a;
    }

    public static /* synthetic */ String b(o0 r5) {
        return r5.f7009b;
    }

    public static /* synthetic */ Long c(o0 r5) {
        return r5.e;
    }

    public static /* synthetic */ JsonElement d(o0 r5) {
        return r5.d;
    }

    public static /* synthetic */ String e(o0 r5) {
        return r5.f7010c;
    }
}
