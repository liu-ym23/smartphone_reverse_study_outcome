package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkmicAudiencePairUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/PairUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/h0;", "Lcom/bytedance/android/live/liveinteract/plantform/model/PairUser$a;", "_guest", "Lcom/bytedance/android/live/liveinteract/plantform/model/PairUser$a;", "get_guest", "()Lcom/bytedance/android/live/liveinteract/plantform/model/PairUser$a;", "set_guest", "(Lcom/bytedance/android/live/liveinteract/plantform/model/PairUser$a;)V", "_investor", "get_investor", "set_investor", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "realGuest", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "realInvestor", "getGuest", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "guest", "getInvestor", "investor", "<init>", "()V", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PairUser extends FlexModelBase<h0> implements h0, vh7.h {

    @SerializedName("guest")
    protected a _guest;

    @SerializedName("investor")
    protected a _investor;
    private ILinkPlayerInfoBridge realGuest;
    private ILinkPlayerInfoBridge realInvestor;

    @ProtoMessage("webcast.data.LinkmicAudiencePairUserInfo")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/PairUser$a;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("user")
        protected IBaseUser user;

        public a() {
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.user = vh7.f.a(r5, IBaseUser.class);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
        }
    }

    public PairUser() {
        super(h0.class);
    }

    public PairUser(am3.g r6) {
        super(h0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._guest = new a(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._investor = new a(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.h0
    public ILinkPlayerInfoBridge getGuest() {
        if (this.realGuest != null) goto L8;
        if (this._guest == null) goto L8;
        LinkPlayerInfo r0 = new LinkPlayerInfo();
        this.realGuest = r0;
        a r1 = this._guest;
        Intrinsics.checkNotNull(r1);
        r0.setUser(r1.user);
    L8:
        return this.realGuest;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.h0
    public ILinkPlayerInfoBridge getInvestor() {
        if (this.realInvestor != null) goto L8;
        if (this._investor == null) goto L8;
        LinkPlayerInfo r0 = new LinkPlayerInfo();
        this.realInvestor = r0;
        a r1 = this._investor;
        Intrinsics.checkNotNull(r1);
        r0.setUser(r1.user);
    L8:
        return this.realInvestor;
    }

    public final a get_guest() {
        return this._guest;
    }

    public final a get_investor() {
        return this._investor;
    }

    public final void set_guest(a r1) {
        this._guest = r1;
    }

    public final void set_investor(a r1) {
        this._investor = r1;
    }
}
