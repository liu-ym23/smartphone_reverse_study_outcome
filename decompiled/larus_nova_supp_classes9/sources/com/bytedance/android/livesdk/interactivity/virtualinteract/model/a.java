package com.bytedance.android.livesdk.interactivity.virtualinteract.model;

import am3.g;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.anchor.VirtualGameCreateActorResponse.Data")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "status", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", BuildConfig.FLAVOR, "actorId", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "setActorId", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "text", "Lcom/bytedance/android/livesdkapi/message/Text;", "e", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", BuildConfig.FLAVOR, "fail", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setFail", "(Ljava/lang/Boolean;)V", BuildConfig.FLAVOR, "failReason", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFailReason", "(Ljava/lang/String;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("actor_id")
    protected Long actorId;

    @SerializedName("fail_to_create")
    protected Boolean fail;

    @SerializedName("fail_reason")
    protected String failReason;

    @SerializedName("status")
    protected Integer status;

    @SerializedName("display_text")
    protected Text text;

    public a() {
    }

    public final Long a() {
        return this.actorId;
    }

    public final Boolean b() {
        return this.fail;
    }

    public final String c() {
        return this.failReason;
    }

    public final Integer d() {
        return this.status;
    }

    public final Text e() {
        return this.text;
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.status = Integer.valueOf(r5.i());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.actorId = Long.valueOf(r5.j());
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.text = _Text_ProtoDecoder.decodeStatic(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.fail = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.failReason = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
