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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u0000\u0012\u0002\b\u00030\u0002H\u0016R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\u0010R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0010R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/k0;", "Lcom/bytedance/android/anya/r;", "toBusinessState", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItem;", "groupItemList$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getGroupItemList", "()Lcom/bytedance/android/anya/t0;", "groupItemList", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "selectedPosition$delegate", "getSelectedPosition", "()Lcom/bytedance/android/anya/r0;", "selectedPosition", "Lvz1/e;", "iconModel$delegate", "getIconModel", "iconModel", "comboStartAnimPosition$delegate", "getComboStartAnimPosition", "comboStartAnimPosition", "comboEndAnimPosition$delegate", "getComboEndAnimPosition", "comboEndAnimPosition", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftGroupViewState extends MVIState<GiftGroupViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty comboEndAnimPosition$delegate;
    private final ReadOnlyProperty comboStartAnimPosition$delegate;
    private final ReadOnlyProperty groupItemList$delegate;
    private final ReadOnlyProperty iconModel$delegate;
    private final ReadOnlyProperty selectedPosition$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftGroupViewState.class, "groupItemList", "getGroupItemList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupViewState.class, "selectedPosition", "getSelectedPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupViewState.class, "iconModel", "getIconModel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupViewState.class, "comboStartAnimPosition", "getComboStartAnimPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupViewState.class, "comboEndAnimPosition", "getComboEndAnimPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftGroupViewState, Integer> getComboEndAnimPosition() {
        return (r0) this.comboEndAnimPosition$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<GiftGroupViewState, Integer> getComboStartAnimPosition() {
        return (r0) this.comboStartAnimPosition$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final t0<GiftGroupViewState, GiftGroupItem> getGroupItemList() {
        return (t0) this.groupItemList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftGroupViewState, e> getIconModel() {
        return (r0) this.iconModel$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftGroupViewState, Integer> getSelectedPosition() {
        return (r0) this.selectedPosition$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftGroupViewState() {
        List r1 = CollectionsKt.emptyList();
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        u r2 = new u(r1, r3, r4);
        KCallable[] r5 = $$delegatedProperties;
        ((c) r2).a = r5[0].getName();
        r4.invoke(r2);
        this.groupItemList$delegate = r2;
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
        this.iconModel$delegate = r13;
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(-1, r14, r15);
        ((c) r16).a = r5[3].getName();
        r15.invoke(r16);
        this.comboStartAnimPosition$delegate = r16;
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        r r19 = new r(-1, r17, r18);
        ((c) r19).a = r5[4].getName();
        r18.invoke(r19);
        this.comboEndAnimPosition$delegate = r19;
    }

    public com.bytedance.android.anya.r toBusinessState(k0<GiftGroupViewState, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toBusinessState");
        t0<GiftGroupViewState, GiftGroupItem> r0 = getGroupItemList();
        r3.getClass();
        int r4 = h.a(r0);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L10;
        if (((Number) h.b(((GiftGroupItem) k0.d(getGroupItemList(), r1)).getComboCount())).intValue() != 0) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return new GiftGroupItemBusinessState.GroupCombo(r1, ((Number) h.b(((GiftGroupItem) k0.d(getGroupItemList(), r1)).getComboCount())).intValue());
    L10:
        return GiftGroupItemBusinessState.Idle.INSTANCE;
    }
}
