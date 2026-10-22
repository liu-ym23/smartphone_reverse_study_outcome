package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.ListResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bB\u0010CR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR;\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR;\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR;\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR+\u0010 \u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010'\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0007\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R/\u0010.\u001a\u0004\u0018\u00010(2\b\u0010\u0005\u001a\u0004\u0018\u00010(8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0007\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u00102\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0007\u001a\u0004\b0\u0010$\"\u0004\b1\u0010&R+\u00109\u001a\u0002032\u0006\u0010\u0005\u001a\u0002038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0007\u001a\u0004\b5\u00106\"\u0004\b7\u00108R+\u0010=\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0007\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR+\u0010A\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0007\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001f¨\u0006D"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/PlayerInfoListDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/a1;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "<set-?>", "playerInfo$delegate", "Ljava/lang/Object;", "getPlayerInfo", "()Ljava/util/List;", "setPlayerInfo", "(Ljava/util/List;)V", "playerInfo", "friends$delegate", "getFriends", "setFriends", "friends", "aiGuests$delegate", "getAiGuests", "setAiGuests", "aiGuests", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "lockedPositions$delegate", "getLockedPositions", "setLockedPositions", "lockedPositions", "", "hasMore$delegate", "getHasMore", "()Z", "setHasMore", "(Z)V", "hasMore", "", "totalCount$delegate", "getTotalCount", "()J", "setTotalCount", "(J)V", "totalCount", "", "nextCursor$delegate", "getNextCursor", "()Ljava/lang/String;", "setNextCursor", "(Ljava/lang/String;)V", "nextCursor", "now$delegate", "getNow", "setNow", "now", "", "sortStrategy$delegate", "getSortStrategy", "()I", "setSortStrategy", "(I)V", "sortStrategy", "showPaidLinkGuide$delegate", "getShowPaidLinkGuide", "setShowPaidLinkGuide", "showPaidLinkGuide", "hasPreApply$delegate", "getHasPreApply", "setHasPreApply", "hasPreApply", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayerInfoListDataFlexImpl extends FlexModelBase<a1> implements a1, vh7.h {

    @SerializedName("ai_guest")
    protected List<? extends ILinkPlayerInfoBridge> _$$aiGuests;

    @SerializedName("friends")
    protected List<? extends ILinkPlayerInfoBridge> _$$friends;

    @SerializedName("has_more")
    protected boolean _$$hasMore;

    @SerializedName("has_prepare_apply")
    protected boolean _$$hasPreApply;

    @SerializedName("locked_positions")
    protected List<? extends LinkmicPositionItem> _$$lockedPositions;

    @SerializedName("next_cursor")
    protected String _$$nextCursor;

    @SerializedName("now")
    protected long _$$now;

    @SerializedName("user")
    protected List<? extends ILinkPlayerInfoBridge> _$$playerInfo;

    @SerializedName("show_paid_linkmic_guide")
    protected boolean _$$showPaidLinkGuide;

    @SerializedName("sort_strategy")
    protected int _$$sortStrategy;

    @SerializedName("total_count")
    protected long _$$totalCount;

    public PlayerInfoListDataFlexImpl() {
        super(a1.class);
        this._$$hasMore = false;
        this._$$showPaidLinkGuide = false;
        this._$$hasPreApply = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final List<ILinkPlayerInfoBridge> getAiGuests() {
        return this._$$aiGuests;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final List<ILinkPlayerInfoBridge> getFriends() {
        return this._$$friends;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final boolean getHasMore() {
        return this._$$hasMore;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final boolean getHasPreApply() {
        return this._$$hasPreApply;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final List<LinkmicPositionItem> getLockedPositions() {
        return this._$$lockedPositions;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final String getNextCursor() {
        return this._$$nextCursor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final long getNow() {
        return this._$$now;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final List<ILinkPlayerInfoBridge> getPlayerInfo() {
        return this._$$playerInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final boolean getShowPaidLinkGuide() {
        return this._$$showPaidLinkGuide;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final int getSortStrategy() {
        return this._$$sortStrategy;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final long getTotalCount() {
        return this._$$totalCount;
    }

    public PlayerInfoListDataFlexImpl(am3.g r7) {
        super(a1.class);
        this._$$playerInfo = new ArrayList();
        this._$$friends = new ArrayList();
        this._$$aiGuests = new ArrayList();
        this._$$lockedPositions = new ArrayList();
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L21;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L7;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        List r6 = this._$$aiGuests;
    L19:
        Class r8 = ILinkPlayerInfoBridge.class;
    L20:
        r6.add(vh7.f.a(r7, r8));
        goto L3
    L9:
        r6 = this._$$friends;
        goto L19
    L10:
        this._$$hasPreApply = am3.h.a(r7);
        r3 = r3 | 32;
        goto L3
    L11:
        this._$$showPaidLinkGuide = am3.h.a(r7);
        r3 = r3 | 16;
        goto L3
    L12:
        this._$$now = r7.j();
        r3 = r3 | 4;
        goto L3
    L13:
        this._$$sortStrategy = r7.i();
        r3 = r3 | 8;
        goto L3
    L14:
        this._$$nextCursor = am3.h.c(r7);
        goto L3
    L15:
        r6 = this._$$lockedPositions;
        r8 = LinkmicPositionItem.class;
        goto L20
    L16:
        this._$$totalCount = r7.j();
        r3 = r3 | 2;
        goto L3
    L17:
        this._$$hasMore = am3.h.a(r7);
        r3 = r3 | 1;
        goto L3
    L18:
        r6 = this._$$playerInfo;
        goto L19
    L7:
        am3.h.d(r5, r7);
        goto L3
    L21:
        r7.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L25;
        this._$$hasMore = false;
    L25:
        if ((r3 & 16) != 0) goto L28;
        this._$$showPaidLinkGuide = false;
    L28:
        if ((r3 & 32) != 0) goto L54;
        this._$$hasPreApply = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setAiGuests(List<? extends ILinkPlayerInfoBridge> r1) {
        this._$$aiGuests = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setFriends(List<? extends ILinkPlayerInfoBridge> r1) {
        this._$$friends = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setHasMore(boolean r1) {
        this._$$hasMore = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setHasPreApply(boolean r1) {
        this._$$hasPreApply = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setLockedPositions(List<? extends LinkmicPositionItem> r1) {
        this._$$lockedPositions = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setNextCursor(String r1) {
        this._$$nextCursor = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setNow(long r1) {
        this._$$now = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setPlayerInfo(List<? extends ILinkPlayerInfoBridge> r1) {
        this._$$playerInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setShowPaidLinkGuide(boolean r1) {
        this._$$showPaidLinkGuide = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setSortStrategy(int r1) {
        this._$$sortStrategy = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.a1
    public final void setTotalCount(long r1) {
        this._$$totalCount = r1;
    }
}
