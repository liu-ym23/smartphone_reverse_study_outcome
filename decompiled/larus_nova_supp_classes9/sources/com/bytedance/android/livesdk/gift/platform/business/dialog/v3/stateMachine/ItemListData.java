package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import vh7.f;
import vz1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b%\u0010&R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R'\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001d0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R'\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemStatus;", "itemStatus$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getItemStatus", "()Lcom/bytedance/android/anya/r0;", "itemStatus", BuildConfig.FLAVOR, "visualStatus$delegate", "getVisualStatus", "visualStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectedStatus$delegate", "getSelectedStatus", "selectedStatus", "Lvz1/e;", "itemData$delegate", "getItemData", "itemData", BuildConfig.FLAVOR, "isLoadingItem$delegate", "isLoadingItem", "showSweepAnim$delegate", "getShowSweepAnim", "showSweepAnim", "isGuideItem$delegate", "isGuideItem", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemDataType;", "itemDataType$delegate", "getItemDataType", "itemDataType", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PinTopState;", "pinTopStatus$delegate", "getPinTopStatus", "pinTopStatus", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemListData extends MVIState<ItemListData> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty isGuideItem$delegate;
    private final ReadOnlyProperty isLoadingItem$delegate;
    private final ReadOnlyProperty itemData$delegate;
    private final ReadOnlyProperty itemDataType$delegate;
    private final ReadOnlyProperty itemStatus$delegate;
    private final ReadOnlyProperty pinTopStatus$delegate;
    private final ReadOnlyProperty selectedStatus$delegate;
    private final ReadOnlyProperty showSweepAnim$delegate;
    private final ReadOnlyProperty visualStatus$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ItemListData.class, "itemStatus", "getItemStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "visualStatus", "getVisualStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "selectedStatus", "getSelectedStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "itemData", "getItemData()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "isLoadingItem", "isLoadingItem()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "showSweepAnim", "getShowSweepAnim()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "isGuideItem", "isGuideItem()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "itemDataType", "getItemDataType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "pinTopStatus", "getPinTopStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<ItemListData, e> getItemData() {
        return (r0) this.itemData$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<ItemListData, ItemDataType> getItemDataType() {
        return (r0) this.itemDataType$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final r0<ItemListData, ItemStatus> getItemStatus() {
        return (r0) this.itemStatus$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<ItemListData, PinTopState> getPinTopStatus() {
        return (r0) this.pinTopStatus$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final r0<ItemListData, SelectedStatus> getSelectedStatus() {
        return (r0) this.selectedStatus$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<ItemListData, Boolean> getShowSweepAnim() {
        return (r0) this.showSweepAnim$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<ItemListData, Integer> getVisualStatus() {
        return (r0) this.visualStatus$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<ItemListData, Boolean> isGuideItem() {
        return (r0) this.isGuideItem$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<ItemListData, Boolean> isLoadingItem() {
        return (r0) this.isLoadingItem$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public ItemListData() {
        ItemStatus r1 = ItemStatus.IDLE;
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        r r2 = new r(r1, r3, r4);
        KCallable[] r5 = $$delegatedProperties;
        ((c) r2).a = r5[0].getName();
        r4.invoke(r2);
        this.itemStatus$delegate = r2;
        Integer r6 = Integer.valueOf(VisualStatus.INSTANCE.getIDLE());
        Function1 r7 = ((MVIState) this).propertyChangeCallback;
        Function1 r8 = ((MVIState) this).propertyAddedCallback;
        r r9 = new r(r6, r7, r8);
        ((c) r9).a = r5[1].getName();
        r8.invoke(r9);
        this.visualStatus$delegate = r9;
        SelectedStatus r10 = SelectedStatus.IDLE;
        Function1 r11 = ((MVIState) this).propertyChangeCallback;
        Function1 r13 = ((MVIState) this).propertyAddedCallback;
        r r14 = new r(r10, r11, r13);
        ((c) r14).a = r5[2].getName();
        r13.invoke(r14);
        this.selectedStatus$delegate = r14;
        e r15 = new e((h1) f.c(h1.class), 0, null, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 67108862);
        Function1 r16 = ((MVIState) this).propertyChangeCallback;
        Function1 r17 = ((MVIState) this).propertyAddedCallback;
        r r18 = new r(r15, r16, r17);
        ((c) r18).a = r5[3].getName();
        r17.invoke(r18);
        this.itemData$delegate = r18;
        Boolean r19 = Boolean.FALSE;
        Function1 r20 = ((MVIState) this).propertyChangeCallback;
        Function1 r21 = ((MVIState) this).propertyAddedCallback;
        r r23 = new r(r19, r20, r21);
        ((c) r23).a = r5[4].getName();
        r21.invoke(r23);
        this.isLoadingItem$delegate = r23;
        Function1 r24 = ((MVIState) this).propertyChangeCallback;
        Function1 r25 = ((MVIState) this).propertyAddedCallback;
        r r26 = new r(r19, r24, r25);
        ((c) r26).a = r5[5].getName();
        r25.invoke(r26);
        this.showSweepAnim$delegate = r26;
        Function1 r27 = ((MVIState) this).propertyChangeCallback;
        Function1 r28 = ((MVIState) this).propertyAddedCallback;
        r r29 = new r(r19, r27, r28);
        ((c) r29).a = r5[6].getName();
        r28.invoke(r29);
        this.isGuideItem$delegate = r29;
        ItemDataType r30 = ItemDataType.NORMAL_ITEM;
        Function1 r31 = ((MVIState) this).propertyChangeCallback;
        Function1 r33 = ((MVIState) this).propertyAddedCallback;
        r r34 = new r(r30, r31, r33);
        ((c) r34).a = r5[7].getName();
        r33.invoke(r34);
        this.itemDataType$delegate = r34;
        PinTopState r35 = PinTopState.Companion.getDEFAULT_PIN_TOP_STATE();
        Function1 r36 = ((MVIState) this).propertyChangeCallback;
        Function1 r37 = ((MVIState) this).propertyAddedCallback;
        r r38 = new r(r35, r36, r37);
        ((c) r38).a = r5[8].getName();
        r37.invoke(r38);
        this.pinTopStatus$delegate = r38;
    }
}
