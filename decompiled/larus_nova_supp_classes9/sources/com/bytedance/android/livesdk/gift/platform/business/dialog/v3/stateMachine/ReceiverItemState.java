package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ReceiverItemState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ReceiverUIType;", "receiverUIType$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getReceiverUIType", "()Lcom/bytedance/android/anya/r0;", "receiverUIType", BuildConfig.FLAVOR, "isSelected$delegate", "isSelected", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "receiver$delegate", "getReceiver", "receiver", BuildConfig.FLAVOR, "receiverName$delegate", "getReceiverName", "receiverName", "Lpy/k;", "avatarImg$delegate", "getAvatarImg", "avatarImg", "statusImg$delegate", "getStatusImg", "statusImg", "statusLabel$delegate", "getStatusLabel", "statusLabel", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReceiverItemState extends MVIState<ReceiverItemState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty avatarImg$delegate;
    private final ReadOnlyProperty isSelected$delegate;
    private final ReadOnlyProperty receiver$delegate;
    private final ReadOnlyProperty receiverName$delegate;
    private final ReadOnlyProperty receiverUIType$delegate;
    private final ReadOnlyProperty statusImg$delegate;
    private final ReadOnlyProperty statusLabel$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ReceiverItemState.class, "receiverUIType", "getReceiverUIType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ReceiverItemState.class, "isSelected", "isSelected()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ReceiverItemState.class, "receiver", "getReceiver()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ReceiverItemState.class, "receiverName", "getReceiverName()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ReceiverItemState.class, "avatarImg", "getAvatarImg()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ReceiverItemState.class, "statusImg", "getStatusImg()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ReceiverItemState.class, "statusLabel", "getStatusLabel()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<ReceiverItemState, k> getAvatarImg() {
        return (r0) this.avatarImg$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<ReceiverItemState, IBaseUser> getReceiver() {
        return (r0) this.receiver$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<ReceiverItemState, String> getReceiverName() {
        return (r0) this.receiverName$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<ReceiverItemState, ReceiverUIType> getReceiverUIType() {
        return (r0) this.receiverUIType$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<ReceiverItemState, k> getStatusImg() {
        return (r0) this.statusImg$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<ReceiverItemState, String> getStatusLabel() {
        return (r0) this.statusLabel$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<ReceiverItemState, Boolean> isSelected() {
        return (r0) this.isSelected$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public ReceiverItemState() {
        ReceiverUIType r0 = ReceiverUIType.MultiReceiver;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.receiverUIType$delegate = r1;
        Boolean r5 = Boolean.FALSE;
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.isSelected$delegate = r8;
        vh7.c r9 = f.c(IBaseUser.class);
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((c) r13).a = r4[2].getName();
        r11.invoke(r13);
        this.receiver$delegate = r13;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(BuildConfig.FLAVOR, r14, r15);
        ((c) r16).a = r4[3].getName();
        r15.invoke(r16);
        this.receiverName$delegate = r16;
        vh7.c r17 = f.c(k.class);
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        r r20 = new r(r17, r18, r19);
        ((c) r20).a = r4[4].getName();
        r19.invoke(r20);
        this.avatarImg$delegate = r20;
        vh7.c r21 = f.c(k.class);
        Function1 r23 = ((MVIState) this).propertyChangeCallback;
        Function1 r24 = ((MVIState) this).propertyAddedCallback;
        r r25 = new r(r21, r23, r24);
        ((c) r25).a = r4[5].getName();
        r24.invoke(r25);
        this.statusImg$delegate = r25;
        Function1 r26 = ((MVIState) this).propertyChangeCallback;
        Function1 r27 = ((MVIState) this).propertyAddedCallback;
        r r28 = new r(BuildConfig.FLAVOR, r26, r27);
        ((c) r28).a = r4[6].getName();
        r27.invoke(r28);
        this.statusLabel$delegate = r28;
    }
}
