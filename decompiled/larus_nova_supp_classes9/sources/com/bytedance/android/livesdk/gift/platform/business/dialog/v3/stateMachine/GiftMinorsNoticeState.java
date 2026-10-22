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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftMinorsNoticeState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "shouldShow$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getShouldShow", "()Lcom/bytedance/android/anya/r0;", "shouldShow", "blockShow$delegate", "getBlockShow", "blockShow", "hasReceiverWidget$delegate", "getHasReceiverWidget", "hasReceiverWidget", "needChangeLayout$delegate", "getNeedChangeLayout", "needChangeLayout", "showAnchorEffectCloseNotice$delegate", "getShowAnchorEffectCloseNotice", "showAnchorEffectCloseNotice", BuildConfig.FLAVOR, "anchorEffectCloseNotice$delegate", "getAnchorEffectCloseNotice", "anchorEffectCloseNotice", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftMinorsNoticeState extends MVIState<GiftMinorsNoticeState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty anchorEffectCloseNotice$delegate;
    private final ReadOnlyProperty blockShow$delegate;
    private final ReadOnlyProperty hasReceiverWidget$delegate;
    private final ReadOnlyProperty needChangeLayout$delegate;
    private final ReadOnlyProperty shouldShow$delegate;
    private final ReadOnlyProperty showAnchorEffectCloseNotice$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftMinorsNoticeState.class, "shouldShow", "getShouldShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftMinorsNoticeState.class, "blockShow", "getBlockShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftMinorsNoticeState.class, "hasReceiverWidget", "getHasReceiverWidget()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftMinorsNoticeState.class, "needChangeLayout", "getNeedChangeLayout()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftMinorsNoticeState.class, "showAnchorEffectCloseNotice", "getShowAnchorEffectCloseNotice()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftMinorsNoticeState.class, "anchorEffectCloseNotice", "getAnchorEffectCloseNotice()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftMinorsNoticeState, String> getAnchorEffectCloseNotice() {
        return (r0) this.anchorEffectCloseNotice$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<GiftMinorsNoticeState, Boolean> getBlockShow() {
        return (r0) this.blockShow$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftMinorsNoticeState, Boolean> getHasReceiverWidget() {
        return (r0) this.hasReceiverWidget$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftMinorsNoticeState, Boolean> getNeedChangeLayout() {
        return (r0) this.needChangeLayout$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftMinorsNoticeState, Boolean> getShouldShow() {
        return (r0) this.shouldShow$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftMinorsNoticeState, Boolean> getShowAnchorEffectCloseNotice() {
        return (r0) this.showAnchorEffectCloseNotice$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public GiftMinorsNoticeState() {
        Boolean r0 = Boolean.FALSE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.shouldShow$delegate = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r0, r5, r6);
        ((c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.blockShow$delegate = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        r r10 = new r(r0, r8, r9);
        ((c) r10).a = r4[2].getName();
        r9.invoke(r10);
        this.hasReceiverWidget$delegate = r10;
        Function1 r11 = ((MVIState) this).propertyChangeCallback;
        Function1 r13 = ((MVIState) this).propertyAddedCallback;
        r r14 = new r(r0, r11, r13);
        ((c) r14).a = r4[3].getName();
        r13.invoke(r14);
        this.needChangeLayout$delegate = r14;
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(r0, r15, r16);
        ((c) r17).a = r4[4].getName();
        r16.invoke(r17);
        this.showAnchorEffectCloseNotice$delegate = r17;
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        r r20 = new r(BuildConfig.FLAVOR, r18, r19);
        ((c) r20).a = r4[5].getName();
        r19.invoke(r20);
        this.anchorEffectCloseNotice$delegate = r20;
    }
}
