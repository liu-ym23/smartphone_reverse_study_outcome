package com.bytedance.pia.core.bridge.methods;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("worker")
    private String f6990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("message")
    private JsonObject f6991b;

    public i0(String r5, JsonObject r10) {
        this.f6990a = r5;
        this.f6991b = r10;
    }
}
