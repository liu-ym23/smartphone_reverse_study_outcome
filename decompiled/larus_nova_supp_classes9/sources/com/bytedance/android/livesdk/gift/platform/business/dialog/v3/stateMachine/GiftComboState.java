package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftComboState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "comboStatus$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getComboStatus", "()Lcom/bytedance/android/anya/r0;", "comboStatus", BuildConfig.FLAVOR, "positionX$delegate", "getPositionX", "positionX", "positionY$delegate", "getPositionY", "positionY", "comboNum$delegate", "getComboNum", "comboNum", BuildConfig.FLAVOR, "isSingleTap$delegate", "isSingleTap", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftComboState extends MVIState<GiftComboState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty comboNum$delegate;
    private final ReadOnlyProperty comboStatus$delegate;
    private final ReadOnlyProperty isSingleTap$delegate;
    private final ReadOnlyProperty positionX$delegate;
    private final ReadOnlyProperty positionY$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftComboState.class, "comboStatus", "getComboStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftComboState.class, "positionX", "getPositionX()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftComboState.class, "positionY", "getPositionY()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftComboState.class, "comboNum", "getComboNum()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftComboState.class, "isSingleTap", "isSingleTap()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftComboState, Integer> getComboNum() {
        return (r0) this.comboNum$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftComboState, ComboState> getComboStatus() {
        return (r0) this.comboStatus$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftComboState, Integer> getPositionX() {
        return (r0) this.positionX$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftComboState, Integer> getPositionY() {
        return (r0) this.positionY$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftComboState, Boolean> isSingleTap() {
        return (r0) this.isSingleTap$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public GiftComboState() {
        ComboState r0 = ComboState.IDLE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.comboStatus$delegate = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(0, r5, r6);
        ((c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.positionX$delegate = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        r r10 = new r(0, r8, r9);
        ((c) r10).a = r4[2].getName();
        r9.invoke(r10);
        this.positionY$delegate = r10;
        Function1 r11 = ((MVIState) this).propertyChangeCallback;
        Function1 r13 = ((MVIState) this).propertyAddedCallback;
        r r14 = new r(0, r11, r13);
        ((c) r14).a = r4[3].getName();
        r13.invoke(r14);
        this.comboNum$delegate = r14;
        Boolean r15 = Boolean.FALSE;
        Function1 r16 = ((MVIState) this).propertyChangeCallback;
        Function1 r17 = ((MVIState) this).propertyAddedCallback;
        r r18 = new r(r15, r16, r17);
        ((c) r18).a = r4[4].getName();
        r17.invoke(r18);
        this.isSingleTap$delegate = r18;
    }
}
