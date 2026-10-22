package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.multilink.base.model.k0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleRandomMatchMatchingContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/k0;", "", "subtitle", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "setSubtitle", "(Ljava/lang/String;)V", "openingTimeTitle", "getOpeningTimeTitle", "setOpeningTimeTitle", "", "matchingExpectedTime", "J", "getMatchingExpectedTime", "()J", "setMatchingExpectedTime", "(J)V", "", "isMatching", "Z", "()Z", "setMatching", "(Z)V", "operatorUserId", "Ljava/lang/Long;", "getOperatorUserId", "()Ljava/lang/Long;", "setOperatorUserId", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleRandomMatchMatchingContent extends FlexModelBase<k0> implements k0, h {

    @SerializedName("is_matching")
    protected boolean isMatching;

    @SerializedName("matching_expected_time")
    protected long matchingExpectedTime;

    @SerializedName("opening_time_title")
    protected String openingTimeTitle;
    private Long operatorUserId;

    @SerializedName("subtitle")
    protected String subtitle;

    @SerializedName("anchor_user")
    protected IBaseUser user;

    public RoomBattleRandomMatchMatchingContent() {
        super(k0.class);
    }

    public long getMatchingExpectedTime() {
        return this.matchingExpectedTime;
    }

    public String getOpeningTimeTitle() {
        return this.openingTimeTitle;
    }

    public Long getOperatorUserId() {
        return this.operatorUserId;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    public boolean isMatching() {
        return this.isMatching;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public RoomBattleRandomMatchMatchingContent(g r6) {
        super(k0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.subtitle = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.openingTimeTitle = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.matchingExpectedTime = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.isMatching = am3.h.a(r6);
        goto L3
    L14:
        if (r2 != 6) goto L15;
        this.user = f.a(r6, IBaseUser.class);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setMatching(boolean r1) {
        this.isMatching = r1;
    }

    public void setMatchingExpectedTime(long r1) {
        this.matchingExpectedTime = r1;
    }

    public void setOpeningTimeTitle(String r1) {
        this.openingTimeTitle = r1;
    }

    public void setOperatorUserId(Long r1) {
        this.operatorUserId = r1;
    }

    public void setSubtitle(String r1) {
        this.subtitle = r1;
    }

    public final void setUser(IBaseUser r1) {
        this.user = r1;
    }
}
