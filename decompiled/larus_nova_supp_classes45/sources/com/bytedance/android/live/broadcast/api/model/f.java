package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.anchor.AnchorPermissionStatusResponse.ApplyRule")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/f;", "", "", "ruleId", "I", "getRuleId", "()I", "setRuleId", "(I)V", "status", "getStatus", "setStatus", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "extra", "getExtra", "setExtra", "<init>", "()V", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("extra")
    protected String extra;

    @SerializedName("rule_id")
    protected int ruleId;

    @SerializedName("status")
    protected int status;

    @SerializedName("title")
    protected String title;

    public static final class a {
    }

    static {
    }

    public f() {
        this.title = "";
        this.extra = "";
    }

    public f(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.ruleId = r5.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.status = r5.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.title = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.extra = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.title != null) goto L22;
        this.title = "";
    L22:
        if (this.extra != null) goto L40;
        this.extra = "";
        return;
    }
}
