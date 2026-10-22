package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.u0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\bA\u0010BR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00190\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R'\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001d0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R'\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020%0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007R'\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007R'\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020-0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007R'\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002010\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R'\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002050\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0005\u001a\u0004\b7\u0010\u0007R'\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002090\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0005\u001a\u0004\b;\u0010\u0007R'\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020=0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0005\u001a\u0004\b?\u0010\u0007¨\u0006C"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverViewState;", "receiverState$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getReceiverState", "()Lcom/bytedance/android/anya/u0;", "receiverState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabViewState;", "tabState$delegate", "getTabState", "tabState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRechargeViewState;", "rechargeState$delegate", "getRechargeState", "rechargeState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListViewState;", "listState$delegate", "getListState", "listState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState;", "topState$delegate", "getTopState", "topState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftMinorsNoticeState;", "noticeState$delegate", "getNoticeState", "noticeState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDSNoticeState;", "dsNoticeState$delegate", "getDsNoticeState", "dsNoticeState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopExchangeViewState;", "topExchangeState$delegate", "getTopExchangeState", "topExchangeState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopPanelViewState;", "giftTopPanelState$delegate", "getGiftTopPanelState", "giftTopPanelState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUserInfoViewState;", "userInfoState$delegate", "getUserInfoState", "userInfoState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopicState;", "topicState$delegate", "getTopicState", "topicState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDynamicPanelState;", "giftDynamicPanelState$delegate", "getGiftDynamicPanelState", "giftDynamicPanelState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDetailViewState;", "giftDetailViewState$delegate", "getGiftDetailViewState", "giftDetailViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GroupViewState;", "groupViewState$delegate", "getGroupViewState", "groupViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchViewState;", "searchViewState$delegate", "getSearchViewState", "searchViewState", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPanelState extends MVIState<GiftPanelState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty dsNoticeState$delegate;
    private final ReadOnlyProperty giftDetailViewState$delegate;
    private final ReadOnlyProperty giftDynamicPanelState$delegate;
    private final ReadOnlyProperty giftTopPanelState$delegate;
    private final ReadOnlyProperty groupViewState$delegate;
    private final ReadOnlyProperty listState$delegate;
    private final ReadOnlyProperty noticeState$delegate;
    private final ReadOnlyProperty receiverState$delegate;
    private final ReadOnlyProperty rechargeState$delegate;
    private final ReadOnlyProperty searchViewState$delegate;
    private final ReadOnlyProperty tabState$delegate;
    private final ReadOnlyProperty topExchangeState$delegate;
    private final ReadOnlyProperty topState$delegate;
    private final ReadOnlyProperty topicState$delegate;
    private final ReadOnlyProperty userInfoState$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "receiverState", "getReceiverState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "tabState", "getTabState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "rechargeState", "getRechargeState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "listState", "getListState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "topState", "getTopState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "noticeState", "getNoticeState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "dsNoticeState", "getDsNoticeState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "topExchangeState", "getTopExchangeState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "giftTopPanelState", "getGiftTopPanelState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "userInfoState", "getUserInfoState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "topicState", "getTopicState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "giftDynamicPanelState", "getGiftDynamicPanelState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "giftDetailViewState", "getGiftDetailViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "groupViewState", "getGroupViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelState.class, "searchViewState", "getSearchViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final u0<GiftPanelState, GiftDSNoticeState> getDsNoticeState() {
        return (u0) this.dsNoticeState$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final u0<GiftPanelState, GiftDetailViewState> getGiftDetailViewState() {
        return (u0) this.giftDetailViewState$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final u0<GiftPanelState, GiftDynamicPanelState> getGiftDynamicPanelState() {
        return (u0) this.giftDynamicPanelState$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public final u0<GiftPanelState, GiftTopPanelViewState> getGiftTopPanelState() {
        return (u0) this.giftTopPanelState$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final u0<GiftPanelState, GroupViewState> getGroupViewState() {
        return (u0) this.groupViewState$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final u0<GiftPanelState, GiftListViewState> getListState() {
        return (u0) this.listState$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final u0<GiftPanelState, GiftMinorsNoticeState> getNoticeState() {
        return (u0) this.noticeState$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final u0<GiftPanelState, GiftReceiverViewState> getReceiverState() {
        return (u0) this.receiverState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final u0<GiftPanelState, GiftRechargeViewState> getRechargeState() {
        return (u0) this.rechargeState$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final u0<GiftPanelState, GiftSearchViewState> getSearchViewState() {
        return (u0) this.searchViewState$delegate.getValue(this, $$delegatedProperties[14]);
    }

    public final u0<GiftPanelState, GiftTabViewState> getTabState() {
        return (u0) this.tabState$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final u0<GiftPanelState, GiftTopExchangeViewState> getTopExchangeState() {
        return (u0) this.topExchangeState$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final u0<GiftPanelState, GiftTopViewState> getTopState() {
        return (u0) this.topState$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final u0<GiftPanelState, GiftTopicState> getTopicState() {
        return (u0) this.topicState$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final u0<GiftPanelState, GiftUserInfoViewState> getUserInfoState() {
        return (u0) this.userInfoState$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public GiftPanelState() {
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r1 = new SubStatePropertyImpl(GiftReceiverViewState.class, null, r2, r3);
        KCallable[] r0 = $$delegatedProperties;
        ((c) r1).a = r0[0].getName();
        r3.invoke(r1);
        this.receiverState$delegate = r1;
        Function1 r4 = ((MVIState) this).propertyChangeCallback;
        Function1 r5 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r6 = new SubStatePropertyImpl(GiftTabViewState.class, null, r4, r5);
        ((c) r6).a = r0[1].getName();
        r5.invoke(r6);
        this.tabState$delegate = r6;
        Function1 r7 = ((MVIState) this).propertyChangeCallback;
        Function1 r8 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r9 = new SubStatePropertyImpl(GiftRechargeViewState.class, null, r7, r8);
        ((c) r9).a = r0[2].getName();
        r8.invoke(r9);
        this.rechargeState$delegate = r9;
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r13 = new SubStatePropertyImpl(GiftListViewState.class, null, r10, r11);
        ((c) r13).a = r0[3].getName();
        r11.invoke(r13);
        this.listState$delegate = r13;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r16 = new SubStatePropertyImpl(GiftTopViewState.class, null, r14, r15);
        ((c) r16).a = r0[4].getName();
        r15.invoke(r16);
        this.topState$delegate = r16;
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r19 = new SubStatePropertyImpl(GiftMinorsNoticeState.class, null, r17, r18);
        ((c) r19).a = r0[5].getName();
        r18.invoke(r19);
        this.noticeState$delegate = r19;
        Function1 r20 = ((MVIState) this).propertyChangeCallback;
        Function1 r21 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r23 = new SubStatePropertyImpl(GiftDSNoticeState.class, null, r20, r21);
        ((c) r23).a = r0[6].getName();
        r21.invoke(r23);
        this.dsNoticeState$delegate = r23;
        Function1 r24 = ((MVIState) this).propertyChangeCallback;
        Function1 r25 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r26 = new SubStatePropertyImpl(GiftTopExchangeViewState.class, null, r24, r25);
        ((c) r26).a = r0[7].getName();
        r25.invoke(r26);
        this.topExchangeState$delegate = r26;
        Function1 r27 = ((MVIState) this).propertyChangeCallback;
        Function1 r28 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r29 = new SubStatePropertyImpl(GiftTopPanelViewState.class, null, r27, r28);
        ((c) r29).a = r0[8].getName();
        r28.invoke(r29);
        this.giftTopPanelState$delegate = r29;
        Function1 r30 = ((MVIState) this).propertyChangeCallback;
        Function1 r31 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r33 = new SubStatePropertyImpl(GiftUserInfoViewState.class, null, r30, r31);
        ((c) r33).a = r0[9].getName();
        r31.invoke(r33);
        this.userInfoState$delegate = r33;
        Function1 r34 = ((MVIState) this).propertyChangeCallback;
        Function1 r35 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r36 = new SubStatePropertyImpl(GiftTopicState.class, null, r34, r35);
        ((c) r36).a = r0[10].getName();
        r35.invoke(r36);
        this.topicState$delegate = r36;
        Function1 r37 = ((MVIState) this).propertyChangeCallback;
        Function1 r38 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r39 = new SubStatePropertyImpl(GiftDynamicPanelState.class, null, r37, r38);
        ((c) r39).a = r0[11].getName();
        r38.invoke(r39);
        this.giftDynamicPanelState$delegate = r39;
        Function1 r40 = ((MVIState) this).propertyChangeCallback;
        Function1 r41 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r43 = new SubStatePropertyImpl(GiftDetailViewState.class, null, r40, r41);
        ((c) r43).a = r0[12].getName();
        r41.invoke(r43);
        this.giftDetailViewState$delegate = r43;
        Function1 r44 = ((MVIState) this).propertyChangeCallback;
        Function1 r45 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r46 = new SubStatePropertyImpl(GroupViewState.class, null, r44, r45);
        ((c) r46).a = r0[13].getName();
        r45.invoke(r46);
        this.groupViewState$delegate = r46;
        Function1 r47 = ((MVIState) this).propertyChangeCallback;
        Function1 r48 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r49 = new SubStatePropertyImpl(GiftSearchViewState.class, null, r47, r48);
        ((c) r49).a = r0[14].getName();
        r48.invoke(r49);
        this.searchViewState$delegate = r49;
    }
}
