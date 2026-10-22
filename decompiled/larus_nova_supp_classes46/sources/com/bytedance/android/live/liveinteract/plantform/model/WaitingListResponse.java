package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b$\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bO\u0010PR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\"\u00107\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R\"\u0010:\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b:\u0010\r\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R\"\u0010=\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b=\u0010\r\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010\u0011R\"\u0010@\u001a\u00020-8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b@\u0010/\u001a\u0004\bA\u00101\"\u0004\bB\u00103R\"\u0010C\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bC\u0010\r\u001a\u0004\bD\u0010\u000f\"\u0004\bE\u0010\u0011R\"\u0010F\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0014\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018R\"\u0010I\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bI\u0010\r\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010\u0011R\"\u0010L\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0014\u001a\u0004\bM\u0010\u0016\"\u0004\bN\u0010\u0018¨\u0006Q"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/m0;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListUser;", "mWaitingUserInfo", "Ljava/util/List;", "getMWaitingUserInfo", "()Ljava/util/List;", "setMWaitingUserInfo", "(Ljava/util/List;)V", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "", "totalCount", "J", "getTotalCount", "()J", "setTotalCount", "(J)V", "", "nextCursor", "Ljava/lang/String;", "getNextCursor", "()Ljava/lang/String;", "setNextCursor", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "displayText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getDisplayText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setDisplayText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "waitingUser", "Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListUser;", "getWaitingUser", "()Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListUser;", "setWaitingUser", "(Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListUser;)V", "", "sortStrategy", "I", "getSortStrategy", "()I", "setSortStrategy", "(I)V", "now", "getNow", "setNow", "addPriceAudienceNum", "getAddPriceAudienceNum", "setAddPriceAudienceNum", "showPaidLinkGuide", "getShowPaidLinkGuide", "setShowPaidLinkGuide", "hasPreApply", "getHasPreApply", "setHasPreApply", "waitingListType", "getWaitingListType", "setWaitingListType", "showPaidListTab", "getShowPaidListTab", "setShowPaidListTab", "paidListTotalCount", "getPaidListTotalCount", "setPaidListTotalCount", "openPaidQueue", "getOpenPaidQueue", "setOpenPaidQueue", "normalListTotalCount", "getNormalListTotalCount", "setNormalListTotalCount", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WaitingListResponse extends FlexModelBase<m0> implements m0, vh7.h {

    @SerializedName("add_price_audience_num")
    protected long addPriceAudienceNum;

    @SerializedName("display_text")
    protected Text displayText;

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("has_prepare_apply")
    protected boolean hasPreApply;

    @SerializedName("user")
    protected List<WaitingListUser> mWaitingUserInfo;

    @SerializedName("next_cursor")
    protected String nextCursor;

    @SerializedName("normal_list_total_count")
    protected long normalListTotalCount;

    @SerializedName("now")
    protected long now;

    @SerializedName("open_paid_queue")
    protected boolean openPaidQueue;

    @SerializedName("paid_list_total_count")
    protected long paidListTotalCount;

    @SerializedName("show_paid_linkmic_guide")
    protected boolean showPaidLinkGuide;

    @SerializedName("show_paid_list_tab")
    protected boolean showPaidListTab;

    @SerializedName("sort_strategy")
    protected int sortStrategy;

    @SerializedName("total_count")
    protected long totalCount;

    @SerializedName("type")
    protected int waitingListType;

    @SerializedName("waiting_user")
    protected WaitingListUser waitingUser;

    public WaitingListResponse() {
        super(m0.class);
        this.mWaitingUserInfo = new ArrayList();
        this.nextCursor = "";
        this.waitingListType = WaitingListType.NORMAL.ordinal();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public /* bridge */ /* synthetic */ a5 getDisplayText() {
        return m257getDisplayText();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public /* bridge */ /* synthetic */ n0 getWaitingUser() {
        return getWaitingUser();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public long getAddPriceAudienceNum() {
        return this.addPriceAudienceNum;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public boolean getHasMore() {
        return this.hasMore;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public boolean getHasPreApply() {
        return this.hasPreApply;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public List<WaitingListUser> getMWaitingUserInfo() {
        return this.mWaitingUserInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public String getNextCursor() {
        return this.nextCursor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public long getNormalListTotalCount() {
        return this.normalListTotalCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public long getNow() {
        return this.now;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public boolean getOpenPaidQueue() {
        return this.openPaidQueue;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public long getPaidListTotalCount() {
        return this.paidListTotalCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public boolean getShowPaidLinkGuide() {
        return this.showPaidLinkGuide;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public boolean getShowPaidListTab() {
        return this.showPaidListTab;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public int getSortStrategy() {
        return this.sortStrategy;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public long getTotalCount() {
        return this.totalCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public int getWaitingListType() {
        return this.waitingListType;
    }

    /* JADX INFO: renamed from: getDisplayText, reason: collision with other method in class */
    public Text m257getDisplayText() {
        return this.displayText;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.m0
    public WaitingListUser getWaitingUser() {
        return this.waitingUser;
    }

    public WaitingListResponse(am3.g r6) {
        super(m0.class);
        this.mWaitingUserInfo = new ArrayList();
        boolean r0 = false;
        setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L24;
        am3.g.a r4 = decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L7;
        };
    L8:
        this.normalListTotalCount = r6.j();
        goto L3
    L9:
        this.showPaidLinkGuide = am3.h.a(r6);
        goto L3
    L10:
        this.openPaidQueue = am3.h.a(r6);
        goto L3
    L11:
        this.paidListTotalCount = r6.j();
        goto L3
    L12:
        this.showPaidListTab = am3.h.a(r6);
        goto L3
    L13:
        this.waitingListType = r6.i();
        r0 = r0 | true;
        goto L3
    L14:
        this.hasPreApply = am3.h.a(r6);
        goto L3
    L15:
        this.addPriceAudienceNum = r6.j();
        goto L3
    L16:
        this.now = r6.j();
        goto L3
    L17:
        this.sortStrategy = r6.i();
        goto L3
    L18:
        this.waitingUser = new WaitingListUser(r6);
        goto L3
    L19:
        this.displayText = _Text_ProtoDecoder.decodeStatic(r6);
        goto L3
    L20:
        this.nextCursor = am3.h.c(r6);
        goto L3
    L21:
        this.totalCount = r6.j();
        goto L3
    L22:
        this.hasMore = am3.h.a(r6);
        goto L3
    L23:
        this.mWaitingUserInfo.add(new WaitingListUser(r6));
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L24:
        r6.d(r1);
        setThreadSafe(true);
        if (this.mWaitingUserInfo.isEmpty() == false) goto L28;
        this.mWaitingUserInfo = new ArrayList();
    L28:
        if (this.nextCursor != null) goto L31;
        this.nextCursor = "";
    L31:
        if ((true & r0) == true) goto L70;
        this.waitingListType = WaitingListType.NORMAL.ordinal();
        return;
    }

    public void setAddPriceAudienceNum(long r1) {
        this.addPriceAudienceNum = r1;
    }

    public void setDisplayText(Text r1) {
        this.displayText = r1;
    }

    public void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public void setHasPreApply(boolean r1) {
        this.hasPreApply = r1;
    }

    public void setMWaitingUserInfo(List<WaitingListUser> r1) {
        this.mWaitingUserInfo = r1;
    }

    public void setNextCursor(String r1) {
        this.nextCursor = r1;
    }

    public void setNormalListTotalCount(long r1) {
        this.normalListTotalCount = r1;
    }

    public void setNow(long r1) {
        this.now = r1;
    }

    public void setOpenPaidQueue(boolean r1) {
        this.openPaidQueue = r1;
    }

    public void setPaidListTotalCount(long r1) {
        this.paidListTotalCount = r1;
    }

    public void setShowPaidLinkGuide(boolean r1) {
        this.showPaidLinkGuide = r1;
    }

    public void setShowPaidListTab(boolean r1) {
        this.showPaidListTab = r1;
    }

    public void setSortStrategy(int r1) {
        this.sortStrategy = r1;
    }

    public void setTotalCount(long r1) {
        this.totalCount = r1;
    }

    public void setWaitingListType(int r1) {
        this.waitingListType = r1;
    }

    public void setWaitingUser(WaitingListUser r1) {
        this.waitingUser = r1;
    }
}
