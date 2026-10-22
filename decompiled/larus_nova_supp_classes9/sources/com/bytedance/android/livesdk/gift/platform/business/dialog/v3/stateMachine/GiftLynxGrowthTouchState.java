package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R5\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0000\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftLynxGrowthTouchState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "touchPositionsStr$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getTouchPositionsStr", "()Lcom/bytedance/android/anya/r0;", "touchPositionsStr", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "userHonorMap$delegate", "getUserHonorMap", "userHonorMap", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectGiftHonorData;", "giftSelectData$delegate", "getGiftSelectData", "giftSelectData", "Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", "payGrade$delegate", "getPayGrade", "payGrade", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftLynxGrowthTouchState extends MVIState<GiftLynxGrowthTouchState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty giftSelectData$delegate;
    private final ReadOnlyProperty payGrade$delegate;
    private final ReadOnlyProperty touchPositionsStr$delegate;
    private final ReadOnlyProperty userHonorMap$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftLynxGrowthTouchState.class, "touchPositionsStr", "getTouchPositionsStr()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftLynxGrowthTouchState.class, "userHonorMap", "getUserHonorMap()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftLynxGrowthTouchState.class, "giftSelectData", "getGiftSelectData()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftLynxGrowthTouchState.class, "payGrade", "getPayGrade()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftLynxGrowthTouchState, SelectGiftHonorData> getGiftSelectData() {
        return (r0) this.giftSelectData$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftLynxGrowthTouchState, PayGrade> getPayGrade() {
        return (r0) this.payGrade$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftLynxGrowthTouchState, String> getTouchPositionsStr() {
        return (r0) this.touchPositionsStr$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftLynxGrowthTouchState, Map<String, Object>> getUserHonorMap() {
        return (r0) this.userHonorMap$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftLynxGrowthTouchState() {
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(BuildConfig.FLAVOR, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.touchPositionsStr$delegate = r1;
        LinkedHashMap r5 = new LinkedHashMap();
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.userHonorMap$delegate = r8;
        SelectGiftHonorData r9 = new SelectGiftHonorData(null, 0, 3, null);
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((c) r13).a = r4[2].getName();
        r11.invoke(r13);
        this.giftSelectData$delegate = r13;
        PayGrade r14 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(r14, r15, r16);
        ((c) r17).a = r4[3].getName();
        r16.invoke(r17);
        this.payGrade$delegate = r17;
    }
}
