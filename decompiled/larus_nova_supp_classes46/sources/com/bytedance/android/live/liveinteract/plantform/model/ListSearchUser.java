package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ListSearchUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/u;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "", "searchType", "I", "getSearchType", "()I", "setSearchType", "(I)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "waitingInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "getWaitingInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "setWaitingInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/n0;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "inviteInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getInviteInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "setInviteInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ListSearchUser extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("invite_user")
    protected ILinkPlayerInfoBridge inviteInfo;

    @SerializedName("search_type")
    protected int searchType;

    @SerializedName("waiting_user")
    protected n0 waitingInfo;

    public ListSearchUser() {
        super(u.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.u
    public IBaseUser getUser() {
        if (getSearchType() != 1) goto L7;
        n0 r0 = getWaitingInfo();
        if (r0 != null) goto L12;
        return null;
    L12:
        return r0.getUserFlex();
    L7:
        ILinkPlayerInfoBridge r1 = getInviteInfo();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getUser();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.u
    public ILinkPlayerInfoBridge getInviteInfo() {
        return this.inviteInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.u
    public int getSearchType() {
        return this.searchType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.u
    public n0 getWaitingInfo() {
        return this.waitingInfo;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.liveinteract.plantform.model.n0, java.lang.Object] */
    public ListSearchUser(am3.g r6) {
        super(u.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.searchType = r6.i();
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this.waitingInfo = vh7.f.a(r6, n0.class);
        goto L3
    L10:
        if (r2 != 4) goto L11;
        this.inviteInfo = vh7.f.a(r6, ILinkPlayerInfoBridge.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.u
    public void setInviteInfo(ILinkPlayerInfoBridge r1) {
        this.inviteInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.u
    public void setSearchType(int r1) {
        this.searchType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.u
    public void setWaitingInfo(n0 r1) {
        this.waitingInfo = r1;
    }
}
