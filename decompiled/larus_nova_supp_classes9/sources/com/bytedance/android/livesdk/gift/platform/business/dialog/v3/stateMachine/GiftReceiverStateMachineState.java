package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\"\u0010#R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00190\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR'\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftReceiverStateMachineState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "nickname$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getNickname", "()Lcom/bytedance/android/anya/r0;", "nickname", "Lpy/k;", "avatarThumb$delegate", "getAvatarThumb", "avatarThumb", BuildConfig.FLAVOR, "avatarVisibility$delegate", "getAvatarVisibility", "avatarVisibility", "background$delegate", "getBackground", "background", BuildConfig.FLAVOR, "showNotice$delegate", "getShowNotice", "showNotice", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ReceiverItemState;", "receiverItemList$delegate", "getReceiverItemList", "()Lcom/bytedance/android/anya/t0;", "receiverItemList", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ReceiverUIType;", "receiverUIType$delegate", "getReceiverUIType", "receiverUIType", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftReceiverStateMachineState extends MVIState<GiftReceiverStateMachineState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty avatarThumb$delegate;
    private final ReadOnlyProperty avatarVisibility$delegate;
    private final ReadOnlyProperty background$delegate;
    private final ReadOnlyProperty nickname$delegate;
    private final ReadOnlyProperty receiverItemList$delegate;
    private final ReadOnlyProperty receiverUIType$delegate;
    private final ReadOnlyProperty showNotice$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftReceiverStateMachineState.class, "nickname", "getNickname()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverStateMachineState.class, "avatarThumb", "getAvatarThumb()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverStateMachineState.class, "avatarVisibility", "getAvatarVisibility()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverStateMachineState.class, "background", "getBackground()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverStateMachineState.class, "showNotice", "getShowNotice()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverStateMachineState.class, "receiverItemList", "getReceiverItemList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftReceiverStateMachineState.class, "receiverUIType", "getReceiverUIType()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftReceiverStateMachineState, k> getAvatarThumb() {
        return (r0) this.avatarThumb$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftReceiverStateMachineState, Integer> getAvatarVisibility() {
        return (r0) this.avatarVisibility$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftReceiverStateMachineState, k> getBackground() {
        return (r0) this.background$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftReceiverStateMachineState, String> getNickname() {
        return (r0) this.nickname$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final t0<GiftReceiverStateMachineState, ReceiverItemState> getReceiverItemList() {
        return (t0) this.receiverItemList$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<GiftReceiverStateMachineState, ReceiverUIType> getReceiverUIType() {
        return (r0) this.receiverUIType$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<GiftReceiverStateMachineState, Boolean> getShowNotice() {
        return (r0) this.showNotice$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public GiftReceiverStateMachineState() {
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(BuildConfig.FLAVOR, r1, r2);
        KCallable[] r3 = $$delegatedProperties;
        ((c) r0).a = r3[0].getName();
        r2.invoke(r0);
        this.nickname$delegate = r0;
        vh7.c r4 = f.c(k.class);
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r4, r5, r6);
        ((c) r7).a = r3[1].getName();
        r6.invoke(r7);
        this.avatarThumb$delegate = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        r r10 = new r(0, r8, r9);
        ((c) r10).a = r3[2].getName();
        r9.invoke(r10);
        this.avatarVisibility$delegate = r10;
        vh7.c r11 = f.c(k.class);
        Function1 r13 = ((MVIState) this).propertyChangeCallback;
        Function1 r14 = ((MVIState) this).propertyAddedCallback;
        r r15 = new r(r11, r13, r14);
        ((c) r15).a = r3[3].getName();
        r14.invoke(r15);
        this.background$delegate = r15;
        Boolean r16 = Boolean.FALSE;
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        r r19 = new r(r16, r17, r18);
        ((c) r19).a = r3[4].getName();
        r18.invoke(r19);
        this.showNotice$delegate = r19;
        List r20 = CollectionsKt.emptyList();
        Function1 r21 = ((MVIState) this).propertyChangeCallback;
        Function1 r23 = ((MVIState) this).propertyAddedCallback;
        u r24 = new u(r20, r21, r23);
        ((c) r24).a = r3[5].getName();
        r23.invoke(r24);
        this.receiverItemList$delegate = r24;
        ReceiverUIType r25 = ReceiverUIType.SingleReceiver;
        Function1 r26 = ((MVIState) this).propertyChangeCallback;
        Function1 r27 = ((MVIState) this).propertyAddedCallback;
        r r28 = new r(r25, r26, r27);
        ((c) r28).a = r3[6].getName();
        r27.invoke(r28);
        this.receiverUIType$delegate = r28;
    }
}
