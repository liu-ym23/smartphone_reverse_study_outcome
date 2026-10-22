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
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftCustomBarViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "giftName$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getGiftName", "()Lcom/bytedance/android/anya/r0;", "giftName", "Lpy/k;", "giftImage$delegate", "getGiftImage", "giftImage", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/CustomData;", "customData$delegate", "getCustomData", "customData", BuildConfig.FLAVOR, "isSelected$delegate", "isSelected", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftCustomBarViewState extends MVIState<GiftCustomBarViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty customData$delegate;
    private final ReadOnlyProperty giftImage$delegate;
    private final ReadOnlyProperty giftName$delegate;
    private final ReadOnlyProperty isSelected$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftCustomBarViewState.class, "giftName", "getGiftName()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftCustomBarViewState.class, "giftImage", "getGiftImage()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftCustomBarViewState.class, "customData", "getCustomData()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftCustomBarViewState.class, "isSelected", "isSelected()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftCustomBarViewState, CustomData> getCustomData() {
        return (r0) this.customData$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftCustomBarViewState, k> getGiftImage() {
        return (r0) this.giftImage$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftCustomBarViewState, String> getGiftName() {
        return (r0) this.giftName$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftCustomBarViewState, Boolean> isSelected() {
        return (r0) this.isSelected$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public GiftCustomBarViewState() {
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(BuildConfig.FLAVOR, r1, r2);
        KCallable[] r3 = $$delegatedProperties;
        ((c) r0).a = r3[0].getName();
        r2.invoke(r0);
        this.giftName$delegate = r0;
        vh7.c r4 = f.c(k.class);
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r4, r5, r6);
        ((c) r7).a = r3[1].getName();
        r6.invoke(r7);
        this.giftImage$delegate = r7;
        CustomData r8 = new CustomData(null, 0, 3, null);
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        r r11 = new r(r8, r9, r10);
        ((c) r11).a = r3[2].getName();
        r10.invoke(r11);
        this.customData$delegate = r11;
        Boolean r13 = Boolean.FALSE;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(r13, r14, r15);
        ((c) r16).a = r3[3].getName();
        r15.invoke(r16);
        this.isSelected$delegate = r16;
    }
}
