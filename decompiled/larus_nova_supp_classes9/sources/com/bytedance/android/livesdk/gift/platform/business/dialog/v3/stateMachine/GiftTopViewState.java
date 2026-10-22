package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.u0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001^B\u0007¢\u0006\u0004\b\\\u0010]R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\rR'\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020 0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\rR'\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020$0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\rR'\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\rR'\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020,0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\rR'\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002000\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\rR'\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002040\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\rR'\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002080\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010\rR'\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020<0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010\rR'\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020@0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0005\u001a\u0004\bB\u0010\rR'\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020D0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0005\u001a\u0004\bF\u0010\rR'\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020H0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0005\u001a\u0004\bJ\u0010\rR'\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020L0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bN\u0010\rR'\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020P0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0005\u001a\u0004\bR\u0010\rR'\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020T0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0005\u001a\u0004\bV\u0010\rR'\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020X0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0005\u001a\u0004\bZ\u0010\r¨\u0006_"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState$Mode;", "mode$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getMode", "()Lcom/bytedance/android/anya/r0;", "mode", "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopEmptyState;", "emptySate$delegate", "getEmptySate", "()Lcom/bytedance/android/anya/u0;", "emptySate", BuildConfig.FLAVOR, "visibility$delegate", "getVisibility", "visibility", "showAnim$delegate", "getShowAnim", "showAnim", "marketingHiddenAnim$delegate", "getMarketingHiddenAnim", "marketingHiddenAnim", "showDetail$delegate", "getShowDetail", "showDetail", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardViewState;", "buffCardViewState$delegate", "getBuffCardViewState", "buffCardViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftLynxGrowthTouchState;", "lynxGrowthTouchState$delegate", "getLynxGrowthTouchState", "lynxGrowthTouchState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopDetailState;", "topDetailState$delegate", "getTopDetailState", "topDetailState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYViewState;", "diyCardViewState$delegate", "getDiyCardViewState", "diyCardViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupViewState;", "groupViewState$delegate", "getGroupViewState", "groupViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftCustomBarViewState;", "customBarViewState$delegate", "getCustomBarViewState", "customBarViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopActivityState;", "activityState$delegate", "getActivityState", "activityState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopSeriesViewState;", "giftSeriesViewState$delegate", "getGiftSeriesViewState", "giftSeriesViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftMVICarnivalViewState;", "giftCarnivalViewState$delegate", "getGiftCarnivalViewState", "giftCarnivalViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopMarketingViewState;", "giftTopMarketingViewState$delegate", "getGiftTopMarketingViewState", "giftTopMarketingViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopBuffContainerViewState;", "giftBuffContainerViewState$delegate", "getGiftBuffContainerViewState", "giftBuffContainerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopDIYContainerViewState;", "giftDIYContainerViewState$delegate", "getGiftDIYContainerViewState", "giftDIYContainerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopGroupContainerViewState;", "giftGroupContainerViewState$delegate", "getGiftGroupContainerViewState", "giftGroupContainerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopCarouselViewState;", "giftCarouselViewState$delegate", "getGiftCarouselViewState", "giftCarouselViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopBannerContainerViewState;", "giftBannerViewState$delegate", "getGiftBannerViewState", "giftBannerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopCollectionViewState;", "giftCollectionViewState$delegate", "getGiftCollectionViewState", "giftCollectionViewState", "<init>", "()V", "Mode", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopViewState extends MVIState<GiftTopViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty activityState$delegate;
    private final ReadOnlyProperty buffCardViewState$delegate;
    private final ReadOnlyProperty customBarViewState$delegate;
    private final ReadOnlyProperty diyCardViewState$delegate;
    private final ReadOnlyProperty emptySate$delegate;
    private final ReadOnlyProperty giftBannerViewState$delegate;
    private final ReadOnlyProperty giftBuffContainerViewState$delegate;
    private final ReadOnlyProperty giftCarnivalViewState$delegate;
    private final ReadOnlyProperty giftCarouselViewState$delegate;
    private final ReadOnlyProperty giftCollectionViewState$delegate;
    private final ReadOnlyProperty giftDIYContainerViewState$delegate;
    private final ReadOnlyProperty giftGroupContainerViewState$delegate;
    private final ReadOnlyProperty giftSeriesViewState$delegate;
    private final ReadOnlyProperty giftTopMarketingViewState$delegate;
    private final ReadOnlyProperty groupViewState$delegate;
    private final ReadOnlyProperty lynxGrowthTouchState$delegate;
    private final ReadOnlyProperty marketingHiddenAnim$delegate;
    private final ReadOnlyProperty mode$delegate;
    private final ReadOnlyProperty showAnim$delegate;
    private final ReadOnlyProperty showDetail$delegate;
    private final ReadOnlyProperty topDetailState$delegate;
    private final ReadOnlyProperty visibility$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState$Mode;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "Detail", "FansClub", "BuffCard", "IGift", "BagEntrance", "CustomGiftBagEntrance", "LynxGrowthTouch", "Group", "Default", "DIY", "Activity", "AuthFusion", "Series", "Marketing", "Carnival", "BuffContainer", "DIYContainer", "GroupContainer", "Carousel", "Banner", "Collection", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode Activity = null;
        public static final Mode AuthFusion = null;
        public static final Mode BagEntrance = null;
        public static final Mode Banner = null;
        public static final Mode BuffCard = null;
        public static final Mode BuffContainer = null;
        public static final Mode Carnival = null;
        public static final Mode Carousel = null;
        public static final Mode Collection = null;
        public static final Mode CustomGiftBagEntrance = null;
        public static final Mode DIY = null;
        public static final Mode DIYContainer = null;
        public static final Mode Default = null;
        public static final Mode Detail = null;
        public static final Mode FansClub = null;
        public static final Mode Group = null;
        public static final Mode GroupContainer = null;
        public static final Mode IGift = null;
        public static final Mode LynxGrowthTouch = null;
        public static final Mode Marketing = null;
        public static final Mode Series = null;

        static {
            Mode r1 = new Mode("Detail", 0);
            Detail = r1;
            Mode r2 = new Mode("FansClub", 1);
            FansClub = r2;
            Mode r3 = new Mode("BuffCard", 2);
            BuffCard = r3;
            Mode r4 = new Mode("IGift", 3);
            IGift = r4;
            Mode r5 = new Mode("BagEntrance", 4);
            BagEntrance = r5;
            Mode r6 = new Mode("CustomGiftBagEntrance", 5);
            CustomGiftBagEntrance = r6;
            Mode r7 = new Mode("LynxGrowthTouch", 6);
            LynxGrowthTouch = r7;
            Mode r8 = new Mode("Group", 7);
            Group = r8;
            Mode r9 = new Mode("Default", 8);
            Default = r9;
            Mode r10 = new Mode("DIY", 9);
            DIY = r10;
            Mode r11 = new Mode("Activity", 10);
            Activity = r11;
            Mode r13 = new Mode("AuthFusion", 11);
            AuthFusion = r13;
            Mode r14 = new Mode("Series", 12);
            Series = r14;
            Mode r15 = new Mode("Marketing", 13);
            Marketing = r15;
            Mode r16 = new Mode("Carnival", 14);
            Carnival = r16;
            Mode r17 = new Mode("BuffContainer", 15);
            BuffContainer = r17;
            Mode r18 = new Mode("DIYContainer", 16);
            DIYContainer = r18;
            Mode r19 = new Mode("GroupContainer", 17);
            GroupContainer = r19;
            Mode r20 = new Mode("Carousel", 18);
            Carousel = r20;
            Mode r21 = new Mode("Banner", 19);
            Banner = r21;
            Mode r23 = new Mode("Collection", 20);
            Collection = r23;
            $VALUES = new Mode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23};
        }

        public static Mode valueOf(String r1) {
            return (Mode) a.a(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "mode", "getMode()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "emptySate", "getEmptySate()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "visibility", "getVisibility()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "showAnim", "getShowAnim()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "marketingHiddenAnim", "getMarketingHiddenAnim()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "showDetail", "getShowDetail()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "buffCardViewState", "getBuffCardViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "lynxGrowthTouchState", "getLynxGrowthTouchState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "topDetailState", "getTopDetailState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "diyCardViewState", "getDiyCardViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "groupViewState", "getGroupViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "customBarViewState", "getCustomBarViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "activityState", "getActivityState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftSeriesViewState", "getGiftSeriesViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftCarnivalViewState", "getGiftCarnivalViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftTopMarketingViewState", "getGiftTopMarketingViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftBuffContainerViewState", "getGiftBuffContainerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftDIYContainerViewState", "getGiftDIYContainerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftGroupContainerViewState", "getGiftGroupContainerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftCarouselViewState", "getGiftCarouselViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftBannerViewState", "getGiftBannerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftCollectionViewState", "getGiftCollectionViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final u0<GiftTopViewState, GiftTopActivityState> getActivityState() {
        return (u0) this.activityState$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final u0<GiftTopViewState, GiftBuffCardViewState> getBuffCardViewState() {
        return (u0) this.buffCardViewState$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final u0<GiftTopViewState, GiftCustomBarViewState> getCustomBarViewState() {
        return (u0) this.customBarViewState$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public final u0<GiftTopViewState, GiftDIYViewState> getDiyCardViewState() {
        return (u0) this.diyCardViewState$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final u0<GiftTopViewState, GiftTopEmptyState> getEmptySate() {
        return (u0) this.emptySate$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final u0<GiftTopViewState, GiftTopBannerContainerViewState> getGiftBannerViewState() {
        return (u0) this.giftBannerViewState$delegate.getValue(this, $$delegatedProperties[20]);
    }

    public final u0<GiftTopViewState, GiftTopBuffContainerViewState> getGiftBuffContainerViewState() {
        return (u0) this.giftBuffContainerViewState$delegate.getValue(this, $$delegatedProperties[16]);
    }

    public final u0<GiftTopViewState, GiftMVICarnivalViewState> getGiftCarnivalViewState() {
        return (u0) this.giftCarnivalViewState$delegate.getValue(this, $$delegatedProperties[14]);
    }

    public final u0<GiftTopViewState, GiftTopCarouselViewState> getGiftCarouselViewState() {
        return (u0) this.giftCarouselViewState$delegate.getValue(this, $$delegatedProperties[19]);
    }

    public final u0<GiftTopViewState, GiftTopCollectionViewState> getGiftCollectionViewState() {
        return (u0) this.giftCollectionViewState$delegate.getValue(this, $$delegatedProperties[21]);
    }

    public final u0<GiftTopViewState, GiftTopDIYContainerViewState> getGiftDIYContainerViewState() {
        return (u0) this.giftDIYContainerViewState$delegate.getValue(this, $$delegatedProperties[17]);
    }

    public final u0<GiftTopViewState, GiftTopGroupContainerViewState> getGiftGroupContainerViewState() {
        return (u0) this.giftGroupContainerViewState$delegate.getValue(this, $$delegatedProperties[18]);
    }

    public final u0<GiftTopViewState, GiftTopSeriesViewState> getGiftSeriesViewState() {
        return (u0) this.giftSeriesViewState$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final u0<GiftTopViewState, GiftTopMarketingViewState> getGiftTopMarketingViewState() {
        return (u0) this.giftTopMarketingViewState$delegate.getValue(this, $$delegatedProperties[15]);
    }

    public final u0<GiftTopViewState, GiftGroupViewState> getGroupViewState() {
        return (u0) this.groupViewState$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final u0<GiftTopViewState, GiftLynxGrowthTouchState> getLynxGrowthTouchState() {
        return (u0) this.lynxGrowthTouchState$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final r0<GiftTopViewState, Boolean> getMarketingHiddenAnim() {
        return (r0) this.marketingHiddenAnim$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<GiftTopViewState, Mode> getMode() {
        return (r0) this.mode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftTopViewState, Boolean> getShowAnim() {
        return (r0) this.showAnim$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftTopViewState, Boolean> getShowDetail() {
        return (r0) this.showDetail$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final u0<GiftTopViewState, GiftTopDetailState> getTopDetailState() {
        return (u0) this.topDetailState$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final r0<GiftTopViewState, Boolean> getVisibility() {
        return (r0) this.visibility$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public GiftTopViewState() {
        Mode r0 = Mode.Default;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.mode$delegate = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r7 = new SubStatePropertyImpl(GiftTopEmptyState.class, null, r5, r6);
        ((c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.emptySate$delegate = r7;
        Boolean r8 = Boolean.TRUE;
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        r r11 = new r(r8, r9, r10);
        ((c) r11).a = r4[2].getName();
        r10.invoke(r11);
        this.visibility$delegate = r11;
        Boolean r13 = Boolean.FALSE;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(r13, r14, r15);
        ((c) r16).a = r4[3].getName();
        r15.invoke(r16);
        this.showAnim$delegate = r16;
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        r r19 = new r(r13, r17, r18);
        ((c) r19).a = r4[4].getName();
        r18.invoke(r19);
        this.marketingHiddenAnim$delegate = r19;
        Function1 r20 = ((MVIState) this).propertyChangeCallback;
        Function1 r21 = ((MVIState) this).propertyAddedCallback;
        r r23 = new r(r13, r20, r21);
        ((c) r23).a = r4[5].getName();
        r21.invoke(r23);
        this.showDetail$delegate = r23;
        Function1 r24 = ((MVIState) this).propertyChangeCallback;
        Function1 r25 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r26 = new SubStatePropertyImpl(GiftBuffCardViewState.class, null, r24, r25);
        ((c) r26).a = r4[6].getName();
        r25.invoke(r26);
        this.buffCardViewState$delegate = r26;
        Function1 r27 = ((MVIState) this).propertyChangeCallback;
        Function1 r28 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r29 = new SubStatePropertyImpl(GiftLynxGrowthTouchState.class, null, r27, r28);
        ((c) r29).a = r4[7].getName();
        r28.invoke(r29);
        this.lynxGrowthTouchState$delegate = r29;
        Function1 r30 = ((MVIState) this).propertyChangeCallback;
        Function1 r31 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r33 = new SubStatePropertyImpl(GiftTopDetailState.class, null, r30, r31);
        ((c) r33).a = r4[8].getName();
        r31.invoke(r33);
        this.topDetailState$delegate = r33;
        Function1 r34 = ((MVIState) this).propertyChangeCallback;
        Function1 r35 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r36 = new SubStatePropertyImpl(GiftDIYViewState.class, null, r34, r35);
        ((c) r36).a = r4[9].getName();
        r35.invoke(r36);
        this.diyCardViewState$delegate = r36;
        Function1 r37 = ((MVIState) this).propertyChangeCallback;
        Function1 r38 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r39 = new SubStatePropertyImpl(GiftGroupViewState.class, null, r37, r38);
        ((c) r39).a = r4[10].getName();
        r38.invoke(r39);
        this.groupViewState$delegate = r39;
        Function1 r40 = ((MVIState) this).propertyChangeCallback;
        Function1 r41 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r43 = new SubStatePropertyImpl(GiftCustomBarViewState.class, null, r40, r41);
        ((c) r43).a = r4[11].getName();
        r41.invoke(r43);
        this.customBarViewState$delegate = r43;
        Function1 r44 = ((MVIState) this).propertyChangeCallback;
        Function1 r45 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r46 = new SubStatePropertyImpl(GiftTopActivityState.class, null, r44, r45);
        ((c) r46).a = r4[12].getName();
        r45.invoke(r46);
        this.activityState$delegate = r46;
        Function1 r47 = ((MVIState) this).propertyChangeCallback;
        Function1 r48 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r49 = new SubStatePropertyImpl(GiftTopSeriesViewState.class, null, r47, r48);
        ((c) r49).a = r4[13].getName();
        r48.invoke(r49);
        this.giftSeriesViewState$delegate = r49;
        Function1 r50 = ((MVIState) this).propertyChangeCallback;
        Function1 r51 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r53 = new SubStatePropertyImpl(GiftMVICarnivalViewState.class, null, r50, r51);
        ((c) r53).a = r4[14].getName();
        r51.invoke(r53);
        this.giftCarnivalViewState$delegate = r53;
        Function1 r54 = ((MVIState) this).propertyChangeCallback;
        Function1 r55 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r56 = new SubStatePropertyImpl(GiftTopMarketingViewState.class, null, r54, r55);
        ((c) r56).a = r4[15].getName();
        r55.invoke(r56);
        this.giftTopMarketingViewState$delegate = r56;
        Function1 r57 = ((MVIState) this).propertyChangeCallback;
        Function1 r58 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r59 = new SubStatePropertyImpl(GiftTopBuffContainerViewState.class, null, r57, r58);
        ((c) r59).a = r4[16].getName();
        r58.invoke(r59);
        this.giftBuffContainerViewState$delegate = r59;
        Function1 r60 = ((MVIState) this).propertyChangeCallback;
        Function1 r61 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r63 = new SubStatePropertyImpl(GiftTopDIYContainerViewState.class, null, r60, r61);
        ((c) r63).a = r4[17].getName();
        r61.invoke(r63);
        this.giftDIYContainerViewState$delegate = r63;
        Function1 r64 = ((MVIState) this).propertyChangeCallback;
        Function1 r65 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r66 = new SubStatePropertyImpl(GiftTopGroupContainerViewState.class, null, r64, r65);
        ((c) r66).a = r4[18].getName();
        r65.invoke(r66);
        this.giftGroupContainerViewState$delegate = r66;
        Function1 r67 = ((MVIState) this).propertyChangeCallback;
        Function1 r68 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r69 = new SubStatePropertyImpl(GiftTopCarouselViewState.class, null, r67, r68);
        ((c) r69).a = r4[19].getName();
        r68.invoke(r69);
        this.giftCarouselViewState$delegate = r69;
        Function1 r70 = ((MVIState) this).propertyChangeCallback;
        Function1 r71 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r73 = new SubStatePropertyImpl(GiftTopBannerContainerViewState.class, null, r70, r71);
        ((c) r73).a = r4[20].getName();
        r71.invoke(r73);
        this.giftBannerViewState$delegate = r73;
        Function1 r74 = ((MVIState) this).propertyChangeCallback;
        Function1 r75 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r76 = new SubStatePropertyImpl(GiftTopCollectionViewState.class, null, r74, r75);
        ((c) r76).a = r4[21].getName();
        r75.invoke(r76);
        this.giftCollectionViewState$delegate = r76;
    }
}
