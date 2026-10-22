package com.bytedance.bdlocation.network.model;

import android.aimedia.a;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class BaseResp {

    @b("StatusCode")
    public int statusCode;

    @b("StatusMessage")
    public String statusMessage;

    public BaseResp() {
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("BaseResp{statusMessage='");
        r8.append(this.statusMessage);
        r8.append("', statusCode=");
        return a.f(r8, this.statusCode, '}');
    }
}
