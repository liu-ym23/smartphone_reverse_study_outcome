package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUserInfoViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "availableDiamonds$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getAvailableDiamonds", "()Lcom/bytedance/android/anya/r0;", "availableDiamonds", "Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", "payGrade$delegate", "getPayGrade", "payGrade", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectGiftHonorData;", "giftSelectData$delegate", "getGiftSelectData", "giftSelectData", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftUserInfoViewState extends MVIState<GiftUserInfoViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty availableDiamonds$delegate;
    private final ReadOnlyProperty giftSelectData$delegate;
    private final ReadOnlyProperty payGrade$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftUserInfoViewState.class, "availableDiamonds", "getAvailableDiamonds()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftUserInfoViewState.class, "payGrade", "getPayGrade()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftUserInfoViewState.class, "giftSelectData", "getGiftSelectData()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftUserInfoViewState, Long> getAvailableDiamonds() {
        return (r0) this.availableDiamonds$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftUserInfoViewState, SelectGiftHonorData> getGiftSelectData() {
        return (r0) this.giftSelectData$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftUserInfoViewState, PayGrade> getPayGrade() {
        return (r0) this.payGrade$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftUserInfoViewState() {
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        r r2 = new r(0L, r3, r4);
        KCallable[] r1 = $$delegatedProperties;
        ((c) r2).a = r1[0].getName();
        r4.invoke(r2);
        this.availableDiamonds$delegate = r2;
        PayGrade r5 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((c) r8).a = r1[1].getName();
        r7.invoke(r8);
        this.payGrade$delegate = r8;
        SelectGiftHonorData r9 = new SelectGiftHonorData(null, 0, 3, null);
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((c) r13).a = r1[2].getName();
        r11.invoke(r13);
        this.giftSelectData$delegate = r13;
    }
}
