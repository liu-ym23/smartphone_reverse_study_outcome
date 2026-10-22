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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u0000\u0012\u0002\b\u00030\u0002H\u0016R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftVerticalState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/k0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", "toBusinessState", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PagerListData;", "panelList$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getPanelList", "()Lcom/bytedance/android/anya/t0;", "panelList", "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftComboState;", "comboState$delegate", "getComboState", "()Lcom/bytedance/android/anya/u0;", "comboState", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "currentPagePosition$delegate", "getCurrentPagePosition", "()Lcom/bytedance/android/anya/r0;", "currentPagePosition", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelDataExtra;", "panelDataExtra$delegate", "getPanelDataExtra", "panelDataExtra", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftVerticalState extends MVIState<GiftVerticalState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty comboState$delegate;
    private final ReadOnlyProperty currentPagePosition$delegate;
    private final ReadOnlyProperty panelDataExtra$delegate;
    private final ReadOnlyProperty panelList$delegate;

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
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftVerticalState.class, "panelList", "getPanelList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftVerticalState.class, "comboState", "getComboState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftVerticalState.class, "currentPagePosition", "getCurrentPagePosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftVerticalState.class, "panelDataExtra", "getPanelDataExtra()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final u0<GiftVerticalState, GiftComboState> getComboState() {
        return (u0) this.comboState$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftVerticalState, Integer> getCurrentPagePosition() {
        return (r0) this.currentPagePosition$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftVerticalState, GiftPanelDataExtra> getPanelDataExtra() {
        return (r0) this.panelDataExtra$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final t0<GiftVerticalState, PagerListData> getPanelList() {
        return (t0) this.panelList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public GiftVerticalState() {
        List r0 = CollectionsKt.emptyList();
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        u r1 = new u(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.panelList$delegate = r1;
        GiftComboState r5 = new GiftComboState();
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r8 = new SubStatePropertyImpl(GiftComboState.class, r5, r6, r7);
        ((c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.comboState$delegate = r8;
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        r r11 = new r(0, r9, r10);
        ((c) r11).a = r4[2].getName();
        r10.invoke(r11);
        this.currentPagePosition$delegate = r11;
        GiftPanelDataExtra r13 = new GiftPanelDataExtra(0, 0, 0, null, 15, null);
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(r13, r14, r15);
        ((c) r16).a = r4[3].getName();
        r15.invoke(r16);
        this.panelDataExtra$delegate = r16;
    }

    /* JADX INFO: renamed from: toBusinessState, reason: collision with other method in class */
    public GiftListBusinessState m178toBusinessState(k0<GiftVerticalState, ?> r24) {
        Intrinsics.checkNotNullParameter(r24, "$this$toBusinessState");
        SelectedStatus r0 = SelectedStatus.IDLE;
        int r2 = VisualStatus.INSTANCE.getIDLE();
        t0<GiftVerticalState, PagerListData> r3 = getPanelList();
        r24.getClass();
        int r1 = h.a(r3);
        long r4 = -1;
        SelectedStatus r13 = r0;
        int r17 = r2;
        e r18 = null;
        int r5 = 0;
        int r14 = -1;
        int r15 = -1;
        int r19 = -1;
        int r20 = -1;
    L3:
        if (r5 >= r1) goto L59;
        t0<PagerListData, ItemListData> r6 = ((PagerListData) k0.d(getPanelList(), r5)).getItemDataList();
        long r8 = ((Number) h.b(((PagerListData) k0.d(getPanelList(), r5)).getSelectedTopicId())).longValue();
        int r7 = h.a(r6);
        int r10 = 0;
    L6:
        if (r10 >= r7) goto L20;
        ItemListData r16 = (ItemListData) k0.d(r6, r10);
        ItemStatus r9 = (ItemStatus) h.b(r16.getItemStatus());
        if (r9 == ItemStatus.SELECTED) goto L12;
        if (r9 == ItemStatus.GONE) goto L12;
    L17:
        r10 = r10 + 1;
    L12:
        if (r15 == (-1)) goto L13;
        if (v.a() == true) goto L19;
        ALogger.e("GiftVerticalState", "more than one selected: " + r10 + " and " + r15);
        goto L17
    L19:
        throw new IllegalStateException("more than one selected: " + r10 + " and " + r15);
    L13:
        r18 = (e) h.b(r16.getItemData());
        r13 = (SelectedStatus) h.b(r16.getSelectedStatus());
        r17 = ((Number) h.b(r16.getVisualStatus())).intValue();
        r14 = r5;
        r4 = r8;
        r15 = r10;
        r19 = -1;
        r20 = -1;
    L20:
        int r11 = h.a(((PagerListData) k0.d(getPanelList(), r5)).getTopicPagerListData());
        int r21 = 0;
    L22:
        if (r21 >= r11) goto L39;
        TopicPagerListData r23 = (TopicPagerListData) k0.d(((PagerListData) k0.d(getPanelList(), r5)).getTopicPagerListData(), r21);
        int r25 = h.a(r23.getItemDataList());
        int r110 = 0;
    L24:
        if (r110 >= r25) goto L38;
        ItemListData r111 = (ItemListData) k0.d(r23.getItemDataList(), r110);
        int r26 = r1;
        int r27 = r11;
        if (((ItemStatus) h.b(r111.getItemStatus())) == ItemStatus.SELECTED) goto L30;
        if (((ItemStatus) h.b(r111.getItemStatus())) == ItemStatus.GONE) goto L30;
    L35:
        r110 = r110 + 1;
        r11 = r27;
        r1 = r26;
    L30:
        if (r15 != (-1)) goto L33;
        r18 = (e) h.b(r111.getItemData());
        r13 = (SelectedStatus) h.b(r111.getSelectedStatus());
        r17 = ((Number) h.b(r111.getVisualStatus())).intValue();
        r14 = r5;
        r4 = ((Number) h.b(r23.getTopicId())).intValue();
        r20 = r21;
        r15 = r110;
        r19 = -1;
        goto L35
    L33:
        if (v.a() == true) goto L37;
        ALogger.e("GiftVerticalState", "more than one selected: page is " + r5 + ", topic is " + r21 + ", selected position is " + r15);
        goto L35
    L37:
        throw new IllegalStateException("more than one selected: page is " + r5 + ", topic is " + r21 + ", selected position is " + r15);
    L38:
        r21 = r21 + 1;
        goto L22
    L39:
        int r28 = r1;
        int r29 = h.a(((PagerListData) k0.d(getPanelList(), r5)).getCounterDataList());
        int r30 = 0;
    L40:
        if (r30 >= r29) goto L57;
        CounterData r31 = (CounterData) k0.d(((PagerListData) k0.d(getPanelList(), r5)).getCounterDataList(), r30);
        int r33 = h.a(r31.getItemDataList());
        int r34 = 0;
    L42:
        if (r34 >= r33) goto L56;
        ItemListData r112 = (ItemListData) k0.d(r31.getItemDataList(), r34);
        int r210 = r29;
        if (((ItemStatus) h.b(r112.getItemStatus())) == ItemStatus.SELECTED) goto L48;
        if (((ItemStatus) h.b(r112.getItemStatus())) == ItemStatus.GONE) goto L48;
    L53:
        r34 = r34 + 1;
        r29 = r210;
    L48:
        if (r15 != (-1)) goto L51;
        e r35 = (e) h.b(r112.getItemData());
        r13 = (SelectedStatus) h.b(r112.getSelectedStatus());
        r14 = r5;
        r18 = r35;
        r19 = r30;
        r15 = r34;
        r17 = ((Number) h.b(r112.getVisualStatus())).intValue();
        goto L53
    L51:
        if (v.a() == true) goto L55;
        ALogger.e("GiftVerticalState", "more than one selected: page is " + r5 + ", counter is " + r30 + ", selected position is " + r15);
        goto L53
    L55:
        throw new IllegalStateException("more than one selected: page is " + r5 + ", counter is " + r30 + ", selected position is " + r15);
    L56:
        r30 = r30 + 1;
        goto L40
    L57:
        r5 = r5 + 1;
        r1 = r28;
        goto L3
    L59:
        if (r15 != (-1)) goto L63;
        return new GiftListBusinessState.Idle();
    L63:
        if (WhenMappings.$EnumSwitchMapping$0[((ComboState) h.b(((GiftComboState) h.b(getComboState())).getComboStatus())).ordinal()] == 1) goto L66;
        return new GiftListBusinessState.GiftCombo(r14, r15, ((Number) h.b(((GiftComboState) h.b(getComboState())).getComboNum())).intValue(), (ComboState) h.b(((GiftComboState) h.b(getComboState())).getComboStatus()), r18, r19, r20);
    L66:
        return new GiftListBusinessState.GiftSelected(r14, r15, r18, r13, r19, r20, r4, r17);
    }

    public /* bridge */ /* synthetic */ com.bytedance.android.anya.r toBusinessState(k0 r1) {
        return m178toBusinessState(r1);
    }
}
