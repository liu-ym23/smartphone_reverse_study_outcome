package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.data.EventParamInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/l;", "", "", "paramKey", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setParamKey", "(Ljava/lang/String;)V", "", "paramType", "I", "b", "()I", "setParamType", "(I)V", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("ParamKeyName")
    protected String paramKey;

    @SerializedName("ParamType")
    protected int paramType;

    public l() {
        this.paramType = 3;
    }

    public final String a() {
        return this.paramKey;
    }

    public final int b() {
        return this.paramType;
    }

    public l(am3.g r7) {
        long r0 = r7.c();
        boolean r2 = false;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L11;
        if (r3 != 1) goto L7;
        this.paramKey = am3.h.c(r7);
        goto L3
    L7:
        if (r3 != 2) goto L8;
        this.paramType = r7.i();
        r2 = r2 | true;
        goto L3
    L8:
        am3.h.e(r7);
        goto L3
    L11:
        r7.d(r0);
        if ((r2 & true) == true) goto L24;
        this.paramType = 3;
        return;
    }
}
