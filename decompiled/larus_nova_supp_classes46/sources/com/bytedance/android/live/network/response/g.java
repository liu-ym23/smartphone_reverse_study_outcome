package com.bytedance.android.live.network.response;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class g<T> {
    public transient RequestError a;

    @SerializedName("data")
    public T data;

    @SerializedName("extra")
    public Object extra;

    @SerializedName("status_code")
    public int statusCode;

    public g() {
    }
}
