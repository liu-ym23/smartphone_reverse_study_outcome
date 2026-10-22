package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.h;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u0016\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u0000\u0012\u0002\b\u00030\u0002H\u0016R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\u0010R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0010R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001c\u0010\u0010R'\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\b\u001a\u0004\b \u0010\u0010R5\u0010&\u001a\u001c\u0012\u0004\u0012\u00020\u0000\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010#0\"0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\b\u001a\u0004\b%\u0010\u0010¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/k0;", "Lcom/bytedance/android/anya/r;", "toBusinessState", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardItem;", "diyCardList$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getDiyCardList", "()Lcom/bytedance/android/anya/t0;", "diyCardList", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "originId$delegate", "getOriginId", "()Lcom/bytedance/android/anya/r0;", "originId", "Lcom/bytedance/android/live/base/model/message/a5;", "buttonText$delegate", "getButtonText", "buttonText", BuildConfig.FLAVOR, "schema$delegate", "getSchema", "schema", BuildConfig.FLAVOR, "buttonVisibility$delegate", "getButtonVisibility", "buttonVisibility", BuildConfig.FLAVOR, "selectedPosition$delegate", "getSelectedPosition", "selectedPosition", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftMarketingInfo$delegate", "getGiftMarketingInfo", "giftMarketingInfo", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftDIYViewState extends MVIState<GiftDIYViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty buttonText$delegate;
    private final ReadOnlyProperty buttonVisibility$delegate;
    private final ReadOnlyProperty diyCardList$delegate;
    private final ReadOnlyProperty giftMarketingInfo$delegate;
    private final ReadOnlyProperty originId$delegate;
    private final ReadOnlyProperty schema$delegate;
    private final ReadOnlyProperty selectedPosition$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftDIYViewState.class, "diyCardList", "getDiyCardList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYViewState.class, "originId", "getOriginId()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYViewState.class, "buttonText", "getButtonText()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYViewState.class, "schema", "getSchema()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYViewState.class, "buttonVisibility", "getButtonVisibility()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYViewState.class, "selectedPosition", "getSelectedPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYViewState.class, "giftMarketingInfo", "getGiftMarketingInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftDIYViewState, a5> getButtonText() {
        return (r0) this.buttonText$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftDIYViewState, Boolean> getButtonVisibility() {
        return (r0) this.buttonVisibility$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final t0<GiftDIYViewState, GiftDIYCardItem> getDiyCardList() {
        return (t0) this.diyCardList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftDIYViewState, Map<String, Object>> getGiftMarketingInfo() {
        return (r0) this.giftMarketingInfo$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<GiftDIYViewState, Long> getOriginId() {
        return (r0) this.originId$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftDIYViewState, String> getSchema() {
        return (r0) this.schema$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftDIYViewState, Integer> getSelectedPosition() {
        return (r0) this.selectedPosition$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public GiftDIYViewState() {
        List r0 = CollectionsKt.emptyList();
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        u r1 = new u(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.diyCardList$delegate = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(0L, r5, r6);
        ((c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.originId$delegate = r7;
        vh7.c r8 = f.c(a5.class);
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        r r11 = new r(r8, r9, r10);
        ((c) r11).a = r4[2].getName();
        r10.invoke(r11);
        this.buttonText$delegate = r11;
        Function1 r13 = ((MVIState) this).propertyChangeCallback;
        Function1 r14 = ((MVIState) this).propertyAddedCallback;
        r r15 = new r(BuildConfig.FLAVOR, r13, r14);
        ((c) r15).a = r4[3].getName();
        r14.invoke(r15);
        this.schema$delegate = r15;
        Boolean r16 = Boolean.FALSE;
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        r r19 = new r(r16, r17, r18);
        ((c) r19).a = r4[4].getName();
        r18.invoke(r19);
        this.buttonVisibility$delegate = r19;
        Function1 r20 = ((MVIState) this).propertyChangeCallback;
        Function1 r21 = ((MVIState) this).propertyAddedCallback;
        r r23 = new r(-1, r20, r21);
        ((c) r23).a = r4[5].getName();
        r21.invoke(r23);
        this.selectedPosition$delegate = r23;
        Map r24 = MapsKt.emptyMap();
        Function1 r25 = ((MVIState) this).propertyChangeCallback;
        Function1 r26 = ((MVIState) this).propertyAddedCallback;
        r r27 = new r(r24, r25, r26);
        ((c) r27).a = r4[6].getName();
        r26.invoke(r27);
        this.giftMarketingInfo$delegate = r27;
    }

    public com.bytedance.android.anya.r toBusinessState(k0<GiftDIYViewState, ?> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toBusinessState");
        t0<GiftDIYViewState, GiftDIYCardItem> r0 = getDiyCardList();
        r5.getClass();
        int r6 = h.a(r0);
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L10;
        if (((Boolean) h.b(((GiftDIYCardItem) k0.d(getDiyCardList(), r1)).getSelected())).booleanValue() == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return new GiftDIYCardBusinessState.DIYSelected((GiftDIYCardItem) k0.d(getDiyCardList(), r1), r1, ((Number) h.b(getOriginId())).longValue());
    L10:
        return GiftDIYCardBusinessState.Idle.INSTANCE;
    }
}
