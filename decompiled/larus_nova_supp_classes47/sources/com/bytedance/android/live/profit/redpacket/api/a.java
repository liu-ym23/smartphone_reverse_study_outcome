package com.bytedance.android.live.profit.redpacket.api;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/api/a;", "", "", "succeed", "Z", "getSucceed", "()Z", "setSucceed", "(Z)V", "expired", "getExpired", "setExpired", "Lpy/k;", "image", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "diamondCount", "I", "getDiamondCount", "()I", "setDiamondCount", "(I)V", "", "Lcom/bytedance/android/live/profit/redpacket/api/a$a;", "rushedList", "Ljava/util/List;", "getRushedList", "()Ljava/util/List;", "setRushedList", "(Ljava/util/List;)V", "<init>", "()V", "a", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("diamond_count")
    protected int diamondCount;

    @SerializedName("expired")
    protected boolean expired;

    @SerializedName("image")
    protected k image;

    @SerializedName("rushed_list")
    protected List<C0046a> rushedList;

    @SerializedName("succeed")
    protected boolean succeed;

    @SerializedName("text")
    protected String text;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.redpacket.api.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/api/a$a;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "Lpy/k;", "image", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "nickName", "getNickName", "setNickName", "labelImage", "getLabelImage", "setLabelImage", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0046a implements h {

        @SerializedName("image")
        protected k image;

        @SerializedName("label_image")
        protected k labelImage;

        @SerializedName("nick_name")
        protected String nickName;

        @SerializedName("text")
        protected String text;

        @SerializedName("user")
        protected IBaseUser user;

        public C0046a() {
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
        /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
        public C0046a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            this.text = am3.h.c(r5);
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.user = f.a(r5, IBaseUser.class);
            goto L3
        L10:
            if (r2 != 3) goto L12;
            this.image = f.a(r5, k.class);
            goto L3
        L12:
            if (r2 != 4) goto L14;
            this.nickName = am3.h.c(r5);
            goto L3
        L14:
            if (r2 != 8) goto L15;
            this.labelImage = f.a(r5, k.class);
            goto L3
        L15:
            am3.h.e(r5);
            goto L3
        L21:
            r5.d(r0);
        }
    }

    public a() {
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public a(g r5) {
        this.rushedList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L24;
        if (r2 != 1) goto L8;
        this.succeed = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.expired = am3.h.a(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.diamondCount = (int) r5.j();
        goto L3
    L12:
        if (r2 != 5) goto L14;
        this.image = f.a(r5, k.class);
        goto L3
    L14:
        if (r2 != 6) goto L16;
        this.text = am3.h.c(r5);
        goto L3
    L16:
        if (r2 != 7) goto L17;
        this.rushedList.add(new C0046a(r5));
        goto L3
    L17:
        am3.h.e(r5);
        goto L3
    L24:
        r5.d(r0);
    }
}
