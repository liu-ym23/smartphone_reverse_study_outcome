package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import py.k;
import vh7.f;
import vz1.b;
import vz1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/CounterData;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lvz1/b;", "bgColorModel$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getBgColorModel", "()Lcom/bytedance/android/anya/r0;", "bgColorModel", "Lvz1/c;", "h5EntranceModel$delegate", "getH5EntranceModel", "h5EntranceModel", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "itemDataList$delegate", "getItemDataList", "()Lcom/bytedance/android/anya/t0;", "itemDataList", "Lpy/k;", "counterHeaderImg$delegate", "getCounterHeaderImg", "counterHeaderImg", "counterEntranceIconImg$delegate", "getCounterEntranceIconImg", "counterEntranceIconImg", BuildConfig.FLAVOR, "sectionName$delegate", "getSectionName", "sectionName", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounterData extends MVIState<CounterData> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty bgColorModel$delegate;
    private final ReadOnlyProperty counterEntranceIconImg$delegate;
    private final ReadOnlyProperty counterHeaderImg$delegate;
    private final ReadOnlyProperty h5EntranceModel$delegate;
    private final ReadOnlyProperty itemDataList$delegate;
    private final ReadOnlyProperty sectionName$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CounterData.class, "bgColorModel", "getBgColorModel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(CounterData.class, "h5EntranceModel", "getH5EntranceModel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(CounterData.class, "itemDataList", "getItemDataList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(CounterData.class, "counterHeaderImg", "getCounterHeaderImg()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(CounterData.class, "counterEntranceIconImg", "getCounterEntranceIconImg()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(CounterData.class, "sectionName", "getSectionName()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<CounterData, b> getBgColorModel() {
        return (r0) this.bgColorModel$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<CounterData, k> getCounterEntranceIconImg() {
        return (r0) this.counterEntranceIconImg$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<CounterData, k> getCounterHeaderImg() {
        return (r0) this.counterHeaderImg$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<CounterData, c> getH5EntranceModel() {
        return (r0) this.h5EntranceModel$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final t0<CounterData, ItemListData> getItemDataList() {
        return (t0) this.itemDataList$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<CounterData, String> getSectionName() {
        return (r0) this.sectionName$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public CounterData() {
        b r0 = new b(0);
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        r r2 = new r(r0, r3, r4);
        KCallable[] r1 = $$delegatedProperties;
        ((com.bytedance.android.anya.internal.c) r2).a = r1[0].getName();
        r4.invoke(r2);
        this.bgColorModel$delegate = r2;
        c r5 = new c(0);
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((com.bytedance.android.anya.internal.c) r8).a = r1[1].getName();
        r7.invoke(r8);
        this.h5EntranceModel$delegate = r8;
        List r9 = CollectionsKt.emptyList();
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        u r13 = new u(r9, r10, r11);
        ((com.bytedance.android.anya.internal.c) r13).a = r1[2].getName();
        r11.invoke(r13);
        this.itemDataList$delegate = r13;
        vh7.c r14 = f.c(k.class);
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(r14, r15, r16);
        ((com.bytedance.android.anya.internal.c) r17).a = r1[3].getName();
        r16.invoke(r17);
        this.counterHeaderImg$delegate = r17;
        vh7.c r18 = f.c(k.class);
        Function1 r19 = ((MVIState) this).propertyChangeCallback;
        Function1 r20 = ((MVIState) this).propertyAddedCallback;
        r r21 = new r(r18, r19, r20);
        ((com.bytedance.android.anya.internal.c) r21).a = r1[4].getName();
        r20.invoke(r21);
        this.counterEntranceIconImg$delegate = r21;
        Function1 r23 = ((MVIState) this).propertyChangeCallback;
        Function1 r24 = ((MVIState) this).propertyAddedCallback;
        r r25 = new r(BuildConfig.FLAVOR, r23, r24);
        ((com.bytedance.android.anya.internal.c) r25).a = r1[5].getName();
        r24.invoke(r25);
        this.sectionName$delegate = r25;
    }
}
