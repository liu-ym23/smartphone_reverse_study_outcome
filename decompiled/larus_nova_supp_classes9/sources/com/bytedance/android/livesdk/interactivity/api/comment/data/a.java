package com.bytedance.android.livesdk.interactivity.api.comment.data;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "msgId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "content", "a", "setContent", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "e", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", BuildConfig.FLAVOR, "showIdentity", "I", "d", "()I", "setShowIdentity", "(I)V", "Lpy/k;", "identityLabel", "Lpy/k;", "b", "()Lpy/k;", "setIdentityLabel", "(Lpy/k;)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("identity_label")
    protected k identityLabel;

    @SerializedName("msg_id")
    protected String msgId;

    @SerializedName("show_identity")
    protected int showIdentity;

    @SerializedName("user")
    protected IBaseUser user;

    public a() {
    }

    public final String a() {
        return this.content;
    }

    public final k b() {
        return this.identityLabel;
    }

    public final String c() {
        return this.msgId;
    }

    public final int d() {
        return this.showIdentity;
    }

    public final IBaseUser e() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public a(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.msgId = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.content = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.user = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.showIdentity = r5.i();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.identityLabel = vh7.f.a(r5, k.class);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
