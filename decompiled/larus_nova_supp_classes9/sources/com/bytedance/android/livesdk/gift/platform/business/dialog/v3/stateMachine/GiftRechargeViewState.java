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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRechargeViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RechargeViewParams;", "rechargeViewParams$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getRechargeViewParams", "()Lcom/bytedance/android/anya/r0;", "rechargeViewParams", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RechargeIconParams;", "iconViewParams$delegate", "getIconViewParams", "iconViewParams", BuildConfig.FLAVOR, "showIncomeToCoins$delegate", "getShowIncomeToCoins", "showIncomeToCoins", "showExchangeDouyinDiamond$delegate", "getShowExchangeDouyinDiamond", "showExchangeDouyinDiamond", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftRechargeViewState extends MVIState<GiftRechargeViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty iconViewParams$delegate;
    private final ReadOnlyProperty rechargeViewParams$delegate;
    private final ReadOnlyProperty showExchangeDouyinDiamond$delegate;
    private final ReadOnlyProperty showIncomeToCoins$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftRechargeViewState.class, "rechargeViewParams", "getRechargeViewParams()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftRechargeViewState.class, "iconViewParams", "getIconViewParams()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftRechargeViewState.class, "showIncomeToCoins", "getShowIncomeToCoins()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftRechargeViewState.class, "showExchangeDouyinDiamond", "getShowExchangeDouyinDiamond()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftRechargeViewState, RechargeIconParams> getIconViewParams() {
        return (r0) this.iconViewParams$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftRechargeViewState, RechargeViewParams> getRechargeViewParams() {
        return (r0) this.rechargeViewParams$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftRechargeViewState, Boolean> getShowExchangeDouyinDiamond() {
        return (r0) this.showExchangeDouyinDiamond$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftRechargeViewState, Boolean> getShowIncomeToCoins() {
        return (r0) this.showIncomeToCoins$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public GiftRechargeViewState() {
        RechargeViewParams r8 = new RechargeViewParams(null, 0, 0.0f, null, false, 31, null);
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(r8, r1, r2);
        KCallable[] r3 = $$delegatedProperties;
        ((c) r0).a = r3[0].getName();
        r2.invoke(r0);
        this.rechargeViewParams$delegate = r0;
        RechargeIconParams r4 = new RechargeIconParams(null, 0, 0, 7, null);
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r4, r5, r6);
        ((c) r7).a = r3[1].getName();
        r6.invoke(r7);
        this.iconViewParams$delegate = r7;
        Boolean r9 = Boolean.FALSE;
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((c) r13).a = r3[2].getName();
        r11.invoke(r13);
        this.showIncomeToCoins$delegate = r13;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(r9, r14, r15);
        ((c) r16).a = r3[3].getName();
        r15.invoke(r16);
        this.showExchangeDouyinDiamond$delegate = r16;
    }
}
