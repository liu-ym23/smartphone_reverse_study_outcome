package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.fansclub.GetFansclubHomepageResult.Data.UserFansclubInfoHomePage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010!\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IUserFansclubInfoHomePageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IUserFansclubInfoHomePage;", "", "intimacy$delegate", "Ljava/lang/Object;", "getIntimacy", "()Ljava/lang/Long;", "intimacy", "level$delegate", "getLevel", "level", "nextLevelIntimacy$delegate", "getNextLevelIntimacy", "nextLevelIntimacy", "levelAfterLightUp$delegate", "getLevelAfterLightUp", "levelAfterLightUp", "", "status$delegate", "getStatus", "()Ljava/lang/Integer;", "status", "temporaryIntimacy$delegate", "getTemporaryIntimacy", "temporaryIntimacy", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubBadgeFlexImpl;", "badge$delegate", "getBadge", "()Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubBadgeFlexImpl;", "badge", "autoLightDownTime$delegate", "getAutoLightDownTime", "autoLightDownTime", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IUserFansclubInfoHomePageFlexImpl extends FlexModelBase<IUserFansclubInfoHomePage> implements IUserFansclubInfoHomePage, h {

    @SerializedName("auto_light_down_time")
    protected Long _$$autoLightDownTime;

    @SerializedName("badge")
    protected IFansclubBadgeFlexImpl _$$badge;

    @SerializedName("intimacy")
    protected Long _$$intimacy;

    @SerializedName("level")
    protected Long _$$level;

    @SerializedName("level_after_light_up")
    protected Long _$$levelAfterLightUp;

    @SerializedName("next_level_intimacy")
    protected Long _$$nextLevelIntimacy;

    @SerializedName("status")
    protected Integer _$$status;

    @SerializedName("temporary_intimacy")
    protected Long _$$temporaryIntimacy;

    public IUserFansclubInfoHomePageFlexImpl() {
        super(IUserFansclubInfoHomePage.class);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public /* bridge */ /* synthetic */ IFansclubBadge getBadge() {
        return getBadge();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final Long getAutoLightDownTime() {
        return this._$$autoLightDownTime;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final Long getIntimacy() {
        return this._$$intimacy;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final Long getLevel() {
        return this._$$level;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final Long getLevelAfterLightUp() {
        return this._$$levelAfterLightUp;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final Long getNextLevelIntimacy() {
        return this._$$nextLevelIntimacy;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final Integer getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final Long getTemporaryIntimacy() {
        return this._$$temporaryIntimacy;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage
    public final IFansclubBadgeFlexImpl getBadge() {
        return this._$$badge;
    }

    public IUserFansclubInfoHomePageFlexImpl(g r5) {
        super(IUserFansclubInfoHomePage.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$autoLightDownTime = Long.valueOf(r5.j());
        goto L3
    L9:
        this._$$badge = new IFansclubBadgeFlexImpl(r5);
        goto L3
    L10:
        this._$$temporaryIntimacy = Long.valueOf(r5.j());
        goto L3
    L11:
        this._$$status = Integer.valueOf(r5.i());
        goto L3
    L12:
        this._$$levelAfterLightUp = Long.valueOf(r5.j());
        goto L3
    L13:
        this._$$nextLevelIntimacy = Long.valueOf(r5.j());
        goto L3
    L14:
        this._$$level = Long.valueOf(r5.j());
        goto L3
    L15:
        this._$$intimacy = Long.valueOf(r5.j());
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L16:
        r5.d(r0);
        setThreadSafe(true);
    }
}
