package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.h;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u0000\u0012\u0002\b\u00030\u0002H\u0016R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\nR'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\nR'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/k0;", "Lcom/bytedance/android/anya/r;", "toBusinessState", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "tabType$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getTabType", "()Lcom/bytedance/android/anya/r0;", "tabType", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabItem;", "giftTabItemList$delegate", "getGiftTabItemList", "()Lcom/bytedance/android/anya/t0;", "giftTabItemList", "selectPosition$delegate", "getSelectPosition", "selectPosition", "marginEdgeWidth$delegate", "getMarginEdgeWidth", "marginEdgeWidth", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchConfigData;", "giftSearchConfig$delegate", "getGiftSearchConfig", "giftSearchConfig", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTabViewState extends MVIState<GiftTabViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty giftSearchConfig$delegate;
    private final ReadOnlyProperty giftTabItemList$delegate;
    private final ReadOnlyProperty marginEdgeWidth$delegate;
    private final ReadOnlyProperty selectPosition$delegate;
    private final ReadOnlyProperty tabType$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTabViewState.class, "tabType", "getTabType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabViewState.class, "giftTabItemList", "getGiftTabItemList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabViewState.class, "selectPosition", "getSelectPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabViewState.class, "marginEdgeWidth", "getMarginEdgeWidth()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabViewState.class, "giftSearchConfig", "getGiftSearchConfig()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftTabViewState, GiftSearchConfigData> getGiftSearchConfig() {
        return (r0) this.giftSearchConfig$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final t0<GiftTabViewState, GiftTabItem> getGiftTabItemList() {
        return (t0) this.giftTabItemList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftTabViewState, Integer> getMarginEdgeWidth() {
        return (r0) this.marginEdgeWidth$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftTabViewState, Integer> getSelectPosition() {
        return (r0) this.selectPosition$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftTabViewState, Integer> getTabType() {
        return (r0) this.tabType$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public GiftTabViewState() {
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        r r2 = new r(0, r3, r4);
        KCallable[] r5 = $$delegatedProperties;
        ((c) r2).a = r5[0].getName();
        r4.invoke(r2);
        this.tabType$delegate = r2;
        List r6 = CollectionsKt.emptyList();
        Function1 r7 = ((MVIState) this).propertyChangeCallback;
        Function1 r8 = ((MVIState) this).propertyAddedCallback;
        u r9 = new u(r6, r7, r8);
        ((c) r9).a = r5[1].getName();
        r8.invoke(r9);
        this.giftTabItemList$delegate = r9;
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(-1, r10, r11);
        ((c) r13).a = r5[2].getName();
        r11.invoke(r13);
        this.selectPosition$delegate = r13;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(0, r14, r15);
        ((c) r16).a = r5[3].getName();
        r15.invoke(r16);
        this.marginEdgeWidth$delegate = r16;
        GiftSearchConfigData r1 = new GiftSearchConfigData(null, null, false, false);
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(r1, r17, r18);
        ((c) r0).a = r5[4].getName();
        r18.invoke(r0);
        this.giftSearchConfig$delegate = r0;
    }

    public com.bytedance.android.anya.r toBusinessState(k0<GiftTabViewState, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toBusinessState");
        t0<GiftTabViewState, GiftTabItem> r0 = getGiftTabItemList();
        r3.getClass();
        int r4 = h.a(r0);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L10;
        if (((Boolean) h.b(((GiftTabItem) k0.d(getGiftTabItemList(), r1)).getSelected())).booleanValue() == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return new GiftTabBusinessState.TabSelected(r1);
    L10:
        return GiftTabBusinessState.Idle.INSTANCE;
    }
}
