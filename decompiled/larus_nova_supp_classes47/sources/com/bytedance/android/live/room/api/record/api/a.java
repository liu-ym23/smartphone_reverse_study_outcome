package com.bytedance.android.live.room.api.record.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.ugm.api.webcast_replay_biz.ActionAuditResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/room/api/record/api/a;", "", "", "result", "Ljava/lang/String;", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "action", "getAction", "setAction", Constants.Keys.DATA, "getData", "setData", "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("action")
    protected String action;

    @SerializedName(Constants.Keys.DATA)
    protected String data;

    @SerializedName("result")
    protected String result;

    public a() {
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.result = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.action = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.data = am3.h.c(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final boolean a() {
        return Intrinsics.areEqual("pass", this.result);
    }

    public final void setResult(String r1) {
        this.result = r1;
    }
}
