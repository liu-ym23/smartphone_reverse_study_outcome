package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.revenue.model.extension.main.b;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDSNoticeState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "blockShow$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getBlockShow", "()Lcom/bytedance/android/anya/r0;", "blockShow", "shouldShow$delegate", "getShouldShow", "shouldShow", "hasReceiverWidget$delegate", "getHasReceiverWidget", "hasReceiverWidget", "Lcom/bytedance/android/live/revenue/model/extension/main/b;", "giftDSNoticeInfo$delegate", "getGiftDSNoticeInfo", "giftDSNoticeInfo", BuildConfig.FLAVOR, "dsHeight$delegate", "getDsHeight", "dsHeight", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftDSNoticeState extends MVIState<GiftDSNoticeState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty blockShow$delegate;
    private final ReadOnlyProperty dsHeight$delegate;
    private final ReadOnlyProperty giftDSNoticeInfo$delegate;
    private final ReadOnlyProperty hasReceiverWidget$delegate;
    private final ReadOnlyProperty shouldShow$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftDSNoticeState.class, "blockShow", "getBlockShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDSNoticeState.class, "shouldShow", "getShouldShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDSNoticeState.class, "hasReceiverWidget", "getHasReceiverWidget()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDSNoticeState.class, "giftDSNoticeInfo", "getGiftDSNoticeInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDSNoticeState.class, "dsHeight", "getDsHeight()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftDSNoticeState, Boolean> getBlockShow() {
        return (r0) this.blockShow$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftDSNoticeState, Integer> getDsHeight() {
        return (r0) this.dsHeight$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<GiftDSNoticeState, b> getGiftDSNoticeInfo() {
        return (r0) this.giftDSNoticeInfo$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftDSNoticeState, Boolean> getHasReceiverWidget() {
        return (r0) this.hasReceiverWidget$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftDSNoticeState, Boolean> getShouldShow() {
        return (r0) this.shouldShow$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftDSNoticeState() {
        Boolean r0 = Boolean.FALSE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.blockShow$delegate = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r0, r5, r6);
        ((c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.shouldShow$delegate = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        r r10 = new r(r0, r8, r9);
        ((c) r10).a = r4[2].getName();
        r9.invoke(r10);
        this.hasReceiverWidget$delegate = r10;
        vh7.c r11 = f.c(b.class);
        Function1 r13 = ((MVIState) this).propertyChangeCallback;
        Function1 r14 = ((MVIState) this).propertyAddedCallback;
        r r15 = new r(r11, r13, r14);
        ((c) r15).a = r4[3].getName();
        r14.invoke(r15);
        this.giftDSNoticeInfo$delegate = r15;
        Function1 r16 = ((MVIState) this).propertyChangeCallback;
        Function1 r17 = ((MVIState) this).propertyAddedCallback;
        r r18 = new r(0, r16, r17);
        ((c) r18).a = r4[4].getName();
        r17.invoke(r18);
        this.dsHeight$delegate = r18;
    }
}
