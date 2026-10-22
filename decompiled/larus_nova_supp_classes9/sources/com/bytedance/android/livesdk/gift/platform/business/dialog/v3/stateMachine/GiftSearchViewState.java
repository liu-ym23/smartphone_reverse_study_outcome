package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.h;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.anya.u0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
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
import vz1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u0000\u0012\u0002\b\u00030\u0002H\u0016R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/k0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchBusinessState;", "toBusinessState", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "show$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getShow", "()Lcom/bytedance/android/anya/r0;", "show", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "searchItemDataList$delegate", "getSearchItemDataList", "()Lcom/bytedance/android/anya/t0;", "searchItemDataList", "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftComboState;", "comboState$delegate", "getComboState", "()Lcom/bytedance/android/anya/u0;", "comboState", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftSearchViewState extends MVIState<GiftSearchViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty comboState$delegate;
    private final ReadOnlyProperty searchItemDataList$delegate;
    private final ReadOnlyProperty show$delegate;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ComboState.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[ComboState.IDLE.ordinal()] = 1;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftSearchViewState.class, "show", "getShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftSearchViewState.class, "searchItemDataList", "getSearchItemDataList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftSearchViewState.class, "comboState", "getComboState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final u0<GiftSearchViewState, GiftComboState> getComboState() {
        return (u0) this.comboState$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final t0<GiftSearchViewState, ItemListData> getSearchItemDataList() {
        return (t0) this.searchItemDataList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftSearchViewState, Boolean> getShow() {
        return (r0) this.show$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public GiftSearchViewState() {
        Boolean r0 = Boolean.FALSE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.show$delegate = r1;
        List r5 = CollectionsKt.emptyList();
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        u r8 = new u(r5, r6, r7);
        ((c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.searchItemDataList$delegate = r8;
        GiftComboState r9 = new GiftComboState();
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r13 = new SubStatePropertyImpl(GiftComboState.class, r9, r10, r11);
        ((c) r13).a = r4[2].getName();
        r11.invoke(r13);
        this.comboState$delegate = r13;
    }

    /* JADX INFO: renamed from: toBusinessState, reason: collision with other method in class */
    public GiftSearchBusinessState m177toBusinessState(k0<GiftSearchViewState, ?> r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$toBusinessState");
        SelectedStatus r0 = SelectedStatus.IDLE;
        int r1 = VisualStatus.INSTANCE.getIDLE();
        t0<GiftSearchViewState, ItemListData> r2 = getSearchItemDataList();
        r11.getClass();
        int r13 = h.a(r2);
        e r3 = null;
        int r4 = 0;
        int r5 = -1;
    L3:
        if (r4 >= r13) goto L16;
        ItemListData r6 = (ItemListData) k0.d(getSearchItemDataList(), r4);
        ItemStatus r7 = (ItemStatus) h.b(r6.getItemStatus());
        if (r7 != ItemStatus.SELECTED) goto L7;
    L8:
        if (r5 != (-1)) goto L11;
        e r8 = (e) h.b(r6.getItemData());
        SelectedStatus r9 = (SelectedStatus) h.b(r6.getSelectedStatus());
        r5 = r4;
        r3 = r8;
        r0 = r9;
        r1 = ((Number) h.b(r6.getVisualStatus())).intValue();
    L13:
        r4 = r4 + 1;
        goto L3
    L11:
        if (v.a() == true) goto L15;
        ALogger.e("GiftSearchViewState", "more than one search selected: " + r4 + " and " + r5);
        goto L13
    L15:
        throw new IllegalStateException("more than one search selected: " + r4 + " and " + r5);
    L7:
        if (r7 != ItemStatus.GONE) goto L13;
    L16:
        if (r5 != (-1)) goto L20;
        return new GiftSearchBusinessState.Idle();
    L20:
        if (WhenMappings.$EnumSwitchMapping$0[((ComboState) h.b(((GiftComboState) h.b(getComboState())).getComboStatus())).ordinal()] == 1) goto L23;
        return new GiftSearchBusinessState.GiftCombo(r5, ((Number) h.b(((GiftComboState) h.b(getComboState())).getComboNum())).intValue(), (ComboState) h.b(((GiftComboState) h.b(getComboState())).getComboStatus()), r3);
    L23:
        return new GiftSearchBusinessState.GiftSelected(r5, r3, r0, r1);
    }

    public /* bridge */ /* synthetic */ com.bytedance.android.anya.r toBusinessState(k0 r1) {
        return m177toBusinessState(r1);
    }
}
