package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.fansclub.GetFansclubHomepageResult.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010(R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010!R\u001d\u0010&\u001a\u0004\u0018\u00010\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IGetFansclubHomepageResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IGetFansclubHomepageResult;", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubInfoHomePageFlexImpl;", "clubInfo$delegate", "Ljava/lang/Object;", "getClubInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubInfoHomePageFlexImpl;", "clubInfo", "Lcom/bytedance/android/live/profit/fansclub/backend/IUserFansclubInfoHomePageFlexImpl;", "userInfo$delegate", "getUserInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IUserFansclubInfoHomePageFlexImpl;", "userInfo", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentiveFlexImpl;", "participateIncentive$delegate", "getParticipateIncentive", "()Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentiveFlexImpl;", "participateIncentive", "", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "Lcom/bytedance/android/live/profit/fansclub/backend/IGuardInfoFlexImpl;", "guardInfo$delegate", "getGuardInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IGuardInfoFlexImpl;", "guardInfo", "", "isGroupLive$delegate", "isGroupLive", "()Ljava/lang/Boolean;", "Lcom/bytedance/android/live/profit/fansclub/backend/IGroupLiveInfoFlexImpl;", "groupLiveInfo$delegate", "getGroupLiveInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IGroupLiveInfoFlexImpl;", "groupLiveInfo", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IGetFansclubHomepageResultFlexImpl extends FlexModelBase<IGetFansclubHomepageResult> implements IGetFansclubHomepageResult, h {

    @SerializedName("club_info")
    protected IFansclubInfoHomePageFlexImpl _$$clubInfo;

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("group_live_info")
    protected IGroupLiveInfoFlexImpl _$$groupLiveInfo;

    @SerializedName("guard_info")
    protected IGuardInfoFlexImpl _$$guardInfo;

    @SerializedName("is_group_live")
    protected Boolean _$$isGroupLive;

    @SerializedName("participate_incentive")
    protected IFansclubParticipateIncentiveFlexImpl _$$participateIncentive;

    @SerializedName("user_info")
    protected IUserFansclubInfoHomePageFlexImpl _$$userInfo;

    public IGetFansclubHomepageResultFlexImpl() {
        super(IGetFansclubHomepageResult.class);
    }

    public IGetFansclubHomepageResultFlexImpl(g r12) {
        super(IGetFansclubHomepageResult.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L42;
        g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$clubInfo = new IFansclubInfoHomePageFlexImpl(r12);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$userInfo = new IUserFansclubInfoHomePageFlexImpl(r12);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$participateIncentive = new IFansclubParticipateIncentiveFlexImpl(r12);
        goto L3
    L12:
        if (r2 != 5) goto L14;
        long r7 = r12.c();
        String r3 = null;
        String r6 = null;
    L24:
        int r9 = r12.f();
        if (r9 == (-1)) goto L31;
        if (r9 != 1) goto L27;
        r3 = am3.h.c(r12);
        goto L24
    L27:
        if (r9 != 2) goto L28;
        r6 = am3.h.c(r12);
        goto L24
    L28:
        am3.h.e(r12);
        goto L24
    L31:
        r12.d(r7);
        Map<String, String> r4 = this._$$extra;
        if (r3 == null) goto L38;
        if (r6 == null) goto L36;
        r4.put(r3, r6);
        goto L3
    L36:
        throw new IllegalStateException("Value must not be null");
    L38:
        throw new IllegalStateException("Key must not be null");
    L14:
        if (r2 != 7) goto L16;
        this._$$guardInfo = new IGuardInfoFlexImpl(r12);
        goto L3
    L16:
        if (r2 != 11) goto L18;
        this._$$isGroupLive = Boolean.valueOf(am3.h.a(r12));
        goto L3
    L18:
        if (r2 != 12) goto L19;
        this._$$groupLiveInfo = new IGroupLiveInfoFlexImpl(r12);
        goto L3
    L19:
        am3.h.d(r5, r12);
        goto L3
    L42:
        r12.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public /* bridge */ /* synthetic */ IFansclubInfoHomePage getClubInfo() {
        return getClubInfo();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public /* bridge */ /* synthetic */ IGroupLiveInfo getGroupLiveInfo() {
        return getGroupLiveInfo();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public /* bridge */ /* synthetic */ IGuardInfo getGuardInfo() {
        return getGuardInfo();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public /* bridge */ /* synthetic */ IFansclubParticipateIncentive getParticipateIncentive() {
        return getParticipateIncentive();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public /* bridge */ /* synthetic */ IUserFansclubInfoHomePage getUserInfo() {
        return getUserInfo();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public final Boolean isGroupLive() {
        return this._$$isGroupLive;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public final IFansclubInfoHomePageFlexImpl getClubInfo() {
        return this._$$clubInfo;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public final IGroupLiveInfoFlexImpl getGroupLiveInfo() {
        return this._$$groupLiveInfo;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public final IGuardInfoFlexImpl getGuardInfo() {
        return this._$$guardInfo;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public final IFansclubParticipateIncentiveFlexImpl getParticipateIncentive() {
        return this._$$participateIncentive;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult
    public final IUserFansclubInfoHomePageFlexImpl getUserInfo() {
        return this._$$userInfo;
    }
}
