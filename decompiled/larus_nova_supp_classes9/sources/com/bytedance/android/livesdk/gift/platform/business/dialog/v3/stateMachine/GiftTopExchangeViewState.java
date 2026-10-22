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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopExchangeViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "giftPanelType$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getGiftPanelType", "()Lcom/bytedance/android/anya/r0;", "giftPanelType", BuildConfig.FLAVOR, "hideCashExchange$delegate", "getHideCashExchange", "hideCashExchange", "hideCombineExchange$delegate", "getHideCombineExchange", "hideCombineExchange", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopExchangeViewState extends MVIState<GiftTopExchangeViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty giftPanelType$delegate;
    private final ReadOnlyProperty hideCashExchange$delegate;
    private final ReadOnlyProperty hideCombineExchange$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTopExchangeViewState.class, "giftPanelType", "getGiftPanelType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopExchangeViewState.class, "hideCashExchange", "getHideCashExchange()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopExchangeViewState.class, "hideCombineExchange", "getHideCombineExchange()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftTopExchangeViewState, Integer> getGiftPanelType() {
        return (r0) this.giftPanelType$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftTopExchangeViewState, Boolean> getHideCashExchange() {
        return (r0) this.hideCashExchange$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftTopExchangeViewState, Boolean> getHideCombineExchange() {
        return (r0) this.hideCombineExchange$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public GiftTopExchangeViewState() {
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        r r2 = new r(0, r3, r4);
        KCallable[] r1 = $$delegatedProperties;
        ((c) r2).a = r1[0].getName();
        r4.invoke(r2);
        this.giftPanelType$delegate = r2;
        Boolean r0 = Boolean.TRUE;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r0, r5, r6);
        ((c) r7).a = r1[1].getName();
        r6.invoke(r7);
        this.hideCashExchange$delegate = r7;
        Boolean r8 = Boolean.FALSE;
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        r r11 = new r(r8, r9, r10);
        ((c) r11).a = r1[2].getName();
        r10.invoke(r11);
        this.hideCombineExchange$delegate = r11;
    }
}
