package com.bytedance.android.livesdk.interactivity.publicscreen.panel.model;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/model/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "msgId", "Ljava/lang/Long;", "getMsgId", "()Ljava/lang/Long;", "setMsgId", "(Ljava/lang/Long;)V", BuildConfig.FLAVOR, "isSuccess", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setSuccess", "(Ljava/lang/Integer;)V", "version", "getVersion", "setVersion", "Lcom/bytedance/android/live/base/model/data/b;", "chatStatus", "Lcom/bytedance/android/live/base/model/data/b;", "a", "()Lcom/bytedance/android/live/base/model/data/b;", "setChatStatus", "(Lcom/bytedance/android/live/base/model/data/b;)V", BuildConfig.FLAVOR, "toast", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("status")
    protected com.bytedance.android.live.base.model.data.b chatStatus;

    @SerializedName("option_success")
    protected Integer isSuccess;

    @SerializedName("msg_id")
    protected Long msgId;

    @SerializedName("toast")
    protected String toast;

    @SerializedName("version")
    protected Long version;

    public a() {
        this.msgId = 0L;
        this.isSuccess = 0;
        this.version = 0L;
    }

    public final com.bytedance.android.live.base.model.data.b a() {
        return this.chatStatus;
    }

    public final String b() {
        return this.toast;
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.msgId = Long.valueOf(r5.j());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.isSuccess = Integer.valueOf(r5.i());
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.chatStatus = new com.bytedance.android.live.base.model.data.b(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.version = Long.valueOf(r5.j());
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.toast = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
        if (this.msgId != null) goto L25;
        this.msgId = 0L;
    L25:
        if (this.isSuccess != null) goto L28;
        this.isSuccess = 0;
    L28:
        if (this.version != null) goto L49;
        this.version = 0L;
        return;
    }
}
