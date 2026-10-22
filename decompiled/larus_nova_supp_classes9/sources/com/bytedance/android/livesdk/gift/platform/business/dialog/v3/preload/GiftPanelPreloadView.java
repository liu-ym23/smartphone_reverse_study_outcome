package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\u0001\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelPreloadView;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "layoutId", "I", "getLayoutId", "()I", "count", "getCount", "setCount", "(I)V", BuildConfig.FLAVOR, "supportTouchDown", "Z", "getSupportTouchDown", "()Z", "onlyTouchDown", "getOnlyTouchDown", "isPanelView", "isGiftItemView", "hasParent", "getHasParent", "maxCount", "getMaxCount", "Companion", "a", "GiftOnlineReceiverView", "GiftOnlineReceiverViewOld", "GroupLiveView", "GiftComboView", "ComboViewOpt", "GiftVerticalListView", "GiftTabView", "GiftRechargeView", "GiftTopView", "GiftActivityTopView", "GiftCustomBarTopView", "GiftDetailTopView", "GiftDIYTopView", "GiftGroupTopView", "GiftLynxGrowthTouchView", "GiftMarketingTopView", "GiftMinorsNoticeView", "GiftSeriesTopView", "GiftBuffCardTopView", "GiftLynxCarnivalTopView", "GiftDefaultTopView", "VerticalPageItem", "TabViewHolder", "GridViewHolderItem", "TopicViewPageItem", "GiftSearchView", "GiftGuideViewHolderItem", "GiftMostlyUsedHeaderViewHolderItem", "GiftDynamicPanel", "SendGiftView", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPanelPreloadView extends Enum<GiftPanelPreloadView> {
    public static final GiftPanelPreloadView ComboViewOpt = null;
    public static final a Companion = null;
    public static final GiftPanelPreloadView GiftActivityTopView = null;
    public static final GiftPanelPreloadView GiftBuffCardTopView = null;
    public static final GiftPanelPreloadView GiftComboView = null;
    public static final GiftPanelPreloadView GiftCustomBarTopView = null;
    public static final GiftPanelPreloadView GiftDIYTopView = null;
    public static final GiftPanelPreloadView GiftDefaultTopView = null;
    public static final GiftPanelPreloadView GiftDetailTopView = null;
    public static final GiftPanelPreloadView GiftDynamicPanel = null;
    public static final GiftPanelPreloadView GiftGroupTopView = null;
    public static final GiftPanelPreloadView GiftGuideViewHolderItem = null;
    public static final GiftPanelPreloadView GiftLynxCarnivalTopView = null;
    public static final GiftPanelPreloadView GiftLynxGrowthTouchView = null;
    public static final GiftPanelPreloadView GiftMarketingTopView = null;
    public static final GiftPanelPreloadView GiftMinorsNoticeView = null;
    public static final GiftPanelPreloadView GiftMostlyUsedHeaderViewHolderItem = null;
    public static final GiftPanelPreloadView GiftOnlineReceiverView = null;
    public static final GiftPanelPreloadView GiftOnlineReceiverViewOld = null;
    public static final GiftPanelPreloadView GiftRechargeView = null;
    public static final GiftPanelPreloadView GiftSearchView = null;
    public static final GiftPanelPreloadView GiftSeriesTopView = null;
    public static final GiftPanelPreloadView GiftTabView = null;
    public static final GiftPanelPreloadView GiftTopView = null;
    public static final GiftPanelPreloadView GiftVerticalListView = null;
    public static final GiftPanelPreloadView GridViewHolderItem = null;
    public static final GiftPanelPreloadView GroupLiveView = null;
    public static final GiftPanelPreloadView SendGiftView = null;
    public static final GiftPanelPreloadView TabViewHolder = null;
    public static final GiftPanelPreloadView TopicViewPageItem = null;
    public static final GiftPanelPreloadView VerticalPageItem = null;
    public static final /* synthetic */ GiftPanelPreloadView[] a = null;
    public static final Lazy b = null;
    private int count;
    private final boolean hasParent;
    private final boolean isGiftItemView;
    private final boolean isPanelView;
    private final int layoutId;
    private final int maxCount;
    private final boolean onlyTouchDown;
    private final boolean supportTouchDown;

    public static final class a {
        public a() {
        }
    }

    public GiftPanelPreloadView() {
        throw null;
    }

    public static GiftPanelPreloadView valueOf(String r1) {
        return (GiftPanelPreloadView) r27.a.a(GiftPanelPreloadView.class, r1);
    }

    public static GiftPanelPreloadView[] values() {
        return (GiftPanelPreloadView[]) a.clone();
    }

    static {
        GiftPanelPreloadView[] r0 = new GiftPanelPreloadView[30];
        GiftPanelPreloadView r14 = new GiftPanelPreloadView("GiftOnlineReceiverView", 0, 2131565766, 1, false, false, false, false, false, 0, 252, null);
        GiftOnlineReceiverView = r14;
        r0[0] = r14;
        GiftPanelPreloadView r1 = new GiftPanelPreloadView("GiftOnlineReceiverViewOld", 1, 2131565767, 1, false, false, false, false, false, 0, 252, null);
        GiftOnlineReceiverViewOld = r1;
        r0[1] = r1;
        GiftPanelPreloadView r2 = new GiftPanelPreloadView("GroupLiveView", 2, 2131565476, 1, false, false, false, false, false, 0, 252, null);
        GroupLiveView = r2;
        r0[2] = r2;
        GiftPanelPreloadView r3 = new GiftPanelPreloadView("GiftComboView", 3, 2131565236, 1, false, false, false, false, false, 2, 124, null);
        GiftComboView = r3;
        r0[3] = r3;
        GiftPanelPreloadView r4 = new GiftPanelPreloadView("ComboViewOpt", 4, 2131565234, 1, false, false, false, false, false, 2, 124, null);
        ComboViewOpt = r4;
        r0[4] = r4;
        if (v.e() == false) goto L5;
        int r7 = 2131567031;
    L6:
        GiftPanelPreloadView r5 = new GiftPanelPreloadView("GiftVerticalListView", 5, r7, 1, false, false, false, false, false, 0, 252, null);
        GiftVerticalListView = r5;
        r0[5] = r5;
        if (v.e() == false) goto L9;
        int r8 = 2131565251;
    L10:
        GiftPanelPreloadView r6 = new GiftPanelPreloadView("GiftTabView", 6, r8, 1, false, !v.e(), false, false, false, 0, 244, null);
        GiftTabView = r6;
        r0[6] = r6;
        GiftPanelPreloadView r9 = new GiftPanelPreloadView("GiftRechargeView", 7, 2131565245, 1, false, true, false, false, false, 0, 244, null);
        GiftRechargeView = r9;
        r0[7] = r9;
        GiftPanelPreloadView r10 = new GiftPanelPreloadView("GiftTopView", 8, 2131565253, 1, false, false, false, false, false, 0, 252, null);
        GiftTopView = r10;
        r0[8] = r10;
        if (v.e() == false) goto L13;
        int r11 = 2131566114;
    L14:
        GiftPanelPreloadView r13 = new GiftPanelPreloadView("GiftActivityTopView", 9, r11, 1, false, false, false, false, false, 0, 252, null);
        GiftActivityTopView = r13;
        r0[9] = r13;
        GiftPanelPreloadView r15 = new GiftPanelPreloadView("GiftCustomBarTopView", 10, 2131565348, 1, false, false, false, false, false, 0, 252, null);
        GiftCustomBarTopView = r15;
        r0[10] = r15;
        GiftPanelPreloadView r16 = new GiftPanelPreloadView("GiftDetailTopView", 11, 2131565785, 1, false, false, false, false, false, 0, 252, null);
        GiftDetailTopView = r16;
        r0[11] = r16;
        GiftPanelPreloadView r17 = new GiftPanelPreloadView("GiftDIYTopView", 12, 2131567541, 1, false, false, false, false, false, 0, 252, null);
        GiftDIYTopView = r17;
        r0[12] = r17;
        GiftPanelPreloadView r18 = new GiftPanelPreloadView("GiftGroupTopView", 13, 2131567543, 1, false, false, false, false, false, 0, 252, null);
        GiftGroupTopView = r18;
        r0[13] = r18;
        GiftPanelPreloadView r19 = new GiftPanelPreloadView("GiftLynxGrowthTouchView", 14, 2131566143, 1, false, false, false, false, false, 0, 248, null);
        GiftLynxGrowthTouchView = r19;
        r0[14] = r19;
        GiftPanelPreloadView r20 = new GiftPanelPreloadView("GiftMarketingTopView", 15, 2131567544, 1, false, false, false, false, false, 0, 248, null);
        GiftMarketingTopView = r20;
        r0[15] = r20;
        GiftPanelPreloadView r21 = new GiftPanelPreloadView("GiftMinorsNoticeView", 16, 2131568010, 1, false, false, false, false, false, 0, 252, null);
        GiftMinorsNoticeView = r21;
        r0[16] = r21;
        GiftPanelPreloadView r23 = new GiftPanelPreloadView("GiftSeriesTopView", 17, 2131567545, 1, false, false, false, false, false, 0, 248, null);
        GiftSeriesTopView = r23;
        r0[17] = r23;
        GiftPanelPreloadView r24 = new GiftPanelPreloadView("GiftBuffCardTopView", 18, 2131567537, 1, false, false, false, false, false, 0, 248, null);
        GiftBuffCardTopView = r24;
        r0[18] = r24;
        GiftPanelPreloadView r25 = new GiftPanelPreloadView("GiftLynxCarnivalTopView", 19, 2131567538, 1, false, false, false, false, false, 0, 248, null);
        GiftLynxCarnivalTopView = r25;
        r0[19] = r25;
        GiftPanelPreloadView r26 = new GiftPanelPreloadView("GiftDefaultTopView", 20, 2131567534, 1, false, false, false, false, false, 0, 252, null);
        GiftDefaultTopView = r26;
        r0[20] = r26;
        c0.d.getClass();
        GiftPanelPreloadView r27 = new GiftPanelPreloadView("VerticalPageItem", 21, 2131567032, GiftPreloadSettingsKt.a().i(), false, false, false, false, false, 0, 252, null);
        VerticalPageItem = r27;
        r0[21] = r27;
        GiftPanelPreloadView r28 = new GiftPanelPreloadView("TabViewHolder", 22, 2131566118, 5, false, false, false, false, false, 7, 44, null);
        TabViewHolder = r28;
        r0[22] = r28;
        GiftPanelPreloadView r29 = new GiftPanelPreloadView("GridViewHolderItem", 23, 2131565255, 12, false, false, false, true, false, c0.c.e(), 76, null);
        GridViewHolderItem = r29;
        r0[23] = r29;
        GiftPanelPreloadView r30 = new GiftPanelPreloadView("TopicViewPageItem", 24, 2131567033, 1, false, false, false, false, false, 0, 252, null);
        TopicViewPageItem = r30;
        r0[24] = r30;
        GiftPanelPreloadView r31 = new GiftPanelPreloadView("GiftSearchView", 25, 2131565247, 1, false, false, false, false, false, 0, 252, null);
        GiftSearchView = r31;
        r0[25] = r31;
        GiftPanelPreloadView r33 = new GiftPanelPreloadView("GiftGuideViewHolderItem", 26, 2131566126, 1, false, false, false, false, false, 0, 252, null);
        GiftGuideViewHolderItem = r33;
        r0[26] = r33;
        GiftPanelPreloadView r34 = new GiftPanelPreloadView("GiftMostlyUsedHeaderViewHolderItem", 27, 2131565258, 1, false, false, false, false, false, 0, 252, null);
        GiftMostlyUsedHeaderViewHolderItem = r34;
        r0[27] = r34;
        GiftPanelPreloadView r35 = new GiftPanelPreloadView("GiftDynamicPanel", 28, 2131566122, 1, false, false, false, false, false, 0, 252, null);
        GiftDynamicPanel = r35;
        r0[28] = r35;
        GiftPanelPreloadView r36 = new GiftPanelPreloadView("SendGiftView", 29, 2131565265, 1, false, false, false, false, false, 0, 252, null);
        SendGiftView = r36;
        r0[29] = r36;
        a = r0;
        Companion = new a();
        b = LazyKt.lazy(GiftPanelPreloadView$Companion$allViews$2.INSTANCE);
        return;
    L13:
        r11 = 2131566113;
        goto L14
    L9:
        r8 = 2131565250;
        goto L10
    L5:
        r7 = 2131567030;
        goto L6
    }

    public static final /* synthetic */ Lazy access$getAllViews$cp() {
        return b;
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getHasParent() {
        return this.hasParent;
    }

    public final int getLayoutId() {
        return this.layoutId;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final boolean getOnlyTouchDown() {
        return this.onlyTouchDown;
    }

    public final boolean getSupportTouchDown() {
        return this.supportTouchDown;
    }

    public final boolean isGiftItemView() {
        return this.isGiftItemView;
    }

    public final boolean isPanelView() {
        return this.isPanelView;
    }

    public final void setCount(int r1) {
        this.count = r1;
    }

    public GiftPanelPreloadView(String r3, int r4, int r5, int r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L6;
        r7 = true;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r8 = false;
    L9:
        if ((r14 & 16) == 0) goto L12;
        r9 = true;
    L12:
        if ((r14 & 32) == 0) goto L15;
        r10 = false;
    L15:
        if ((r14 & 64) == 0) goto L18;
        r11 = true;
    L18:
        if ((r14 & 128) == 0) goto L20;
        r13 = r6;
    L20:
        super(r3, r4);
        this.layoutId = r5;
        this.count = r6;
        this.supportTouchDown = r7;
        this.onlyTouchDown = r8;
        this.isPanelView = r9;
        this.isGiftItemView = r10;
        this.hasParent = r11;
        this.maxCount = r13;
    }
}
