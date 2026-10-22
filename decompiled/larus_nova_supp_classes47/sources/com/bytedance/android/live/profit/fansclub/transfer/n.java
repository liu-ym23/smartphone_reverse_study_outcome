package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b,\u0010-R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/transfer/n;", "", "", "fansClubUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFansClubUrl", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "anchor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getAnchor", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setAnchor", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "Lcom/bytedance/android/live/profit/fansclub/transfer/p;", "userFansClubInfo", "Lcom/bytedance/android/live/profit/fansclub/transfer/p;", "getUserFansClubInfo", "()Lcom/bytedance/android/live/profit/fansclub/transfer/p;", "setUserFansClubInfo", "(Lcom/bytedance/android/live/profit/fansclub/transfer/p;)V", "Lcom/bytedance/android/live/profit/fansclub/transfer/l;", "fansClubInfo", "Lcom/bytedance/android/live/profit/fansclub/transfer/l;", "a", "()Lcom/bytedance/android/live/profit/fansclub/transfer/l;", "setFansClubInfo", "(Lcom/bytedance/android/live/profit/fansclub/transfer/l;)V", "Lcom/bytedance/android/live/profit/fansclub/transfer/o;", "participateIncentive", "Lcom/bytedance/android/live/profit/fansclub/transfer/o;", "getParticipateIncentive", "()Lcom/bytedance/android/live/profit/fansclub/transfer/o;", "setParticipateIncentive", "(Lcom/bytedance/android/live/profit/fansclub/transfer/o;)V", "", "scene", "I", "c", "()I", "setScene", "(I)V", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n implements vh7.h {
    public static final /* synthetic */ int a = 0;

    @SerializedName("anchor_info")
    protected IBaseUser anchor;

    @SerializedName("club_info")
    protected l fansClubInfo;

    @SerializedName("fansclub_schema")
    protected String fansClubUrl;

    @SerializedName("participate_incentive")
    protected o participateIncentive;

    @SerializedName("scene")
    protected int scene;

    @SerializedName("user_fansclub_info")
    protected p userFansClubInfo;

    public static final class a {
    }

    static {
    }

    public n() {
    }

    public final l a() {
        return this.fansClubInfo;
    }

    public final String b() {
        return this.fansClubUrl;
    }

    public final int c() {
        return this.scene;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.profit.fansclub.transfer.o, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public n(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L24;
        if (r2 != 1) goto L8;
        this.fansClubInfo = new l(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.userFansClubInfo = new p(r5);
        goto L3
    L10:
        if (r2 != 7) goto L12;
        this.fansClubUrl = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 8) goto L14;
        this.anchor = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L14:
        if (r2 != 17) goto L16;
        this.scene = r5.i();
        goto L3
    L16:
        if (r2 != 22) goto L17;
        this.participateIncentive = vh7.f.a(r5, o.class);
        goto L3
    L17:
        am3.h.e(r5);
        goto L3
    L24:
        r5.d(r0);
    }
}
