package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.h;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.livesdk.gift.model.h1;
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
import vz1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u0000\u0012\u0002\b\u00030\u0002H\u0016R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\u0010R5\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\u0000\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00160\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\u0010R'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/k0;", "Lcom/bytedance/android/anya/r;", "toBusinessState", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardItem;", "buffCardList$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getBuffCardList", "()Lcom/bytedance/android/anya/t0;", "buffCardList", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "selectedPosition$delegate", "getSelectedPosition", "()Lcom/bytedance/android/anya/r0;", "selectedPosition", "Lvz1/e;", "originGiftModel$delegate", "getOriginGiftModel", "originGiftModel", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftMarketingInfo$delegate", "getGiftMarketingInfo", "giftMarketingInfo", "originGiftType$delegate", "getOriginGiftType", "originGiftType", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftBuffCardViewState extends MVIState<GiftBuffCardViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty buffCardList$delegate;
    private final ReadOnlyProperty giftMarketingInfo$delegate;
    private final ReadOnlyProperty originGiftModel$delegate;
    private final ReadOnlyProperty originGiftType$delegate;
    private final ReadOnlyProperty selectedPosition$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftBuffCardViewState.class, "buffCardList", "getBuffCardList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftBuffCardViewState.class, "selectedPosition", "getSelectedPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftBuffCardViewState.class, "originGiftModel", "getOriginGiftModel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftBuffCardViewState.class, "giftMarketingInfo", "getGiftMarketingInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftBuffCardViewState.class, "originGiftType", "getOriginGiftType()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final t0<GiftBuffCardViewState, GiftBuffCardItem> getBuffCardList() {
        return (t0) this.buffCardList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftBuffCardViewState, Map<String, Object>> getGiftMarketingInfo() {
        return (r0) this.giftMarketingInfo$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftBuffCardViewState, e> getOriginGiftModel() {
        return (r0) this.originGiftModel$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftBuffCardViewState, Integer> getOriginGiftType() {
        return (r0) this.originGiftType$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<GiftBuffCardViewState, Integer> getSelectedPosition() {
        return (r0) this.selectedPosition$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftBuffCardViewState() {
        List r1 = CollectionsKt.emptyList();
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        u r2 = new u(r1, r3, r4);
        KCallable[] r5 = $$delegatedProperties;
        ((c) r2).a = r5[0].getName();
        r4.invoke(r2);
        this.buffCardList$delegate = r2;
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(-1, r6, r7);
        ((c) r8).a = r5[1].getName();
        r7.invoke(r8);
        this.selectedPosition$delegate = r8;
        e r9 = new e((h1) f.c(h1.class), 0, null, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 67108862);
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((c) r13).a = r5[2].getName();
        r11.invoke(r13);
        this.originGiftModel$delegate = r13;
        Map r14 = MapsKt.emptyMap();
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(r14, r15, r16);
        ((c) r17).a = r5[3].getName();
        r16.invoke(r17);
        this.giftMarketingInfo$delegate = r17;
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        r r20 = new r(0, r18, r19);
        ((c) r20).a = r5[4].getName();
        r19.invoke(r20);
        this.originGiftType$delegate = r20;
    }

    public com.bytedance.android.anya.r toBusinessState(k0<GiftBuffCardViewState, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toBusinessState");
        t0<GiftBuffCardViewState, GiftBuffCardItem> r0 = getBuffCardList();
        r3.getClass();
        int r4 = h.a(r0);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L10;
        if (((Boolean) h.b(((GiftBuffCardItem) k0.d(getBuffCardList(), r1)).getSelected())).booleanValue() == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return new GiftBuffCardBusinessState.BuffSelected((GiftBuffCardItem) k0.d(getBuffCardList(), r1), r1);
    L10:
        return GiftBuffCardBusinessState.Idle.INSTANCE;
    }
}
