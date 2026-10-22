package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import vh7.c;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItem;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/model/h0;", "groupInfo$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getGroupInfo", "()Lcom/bytedance/android/anya/r0;", "groupInfo", BuildConfig.FLAVOR, "selected$delegate", "getSelected", "selected", BuildConfig.FLAVOR, "comboCount$delegate", "getComboCount", "comboCount", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupMostlyUsedInfo;", "mostlyUsedInfo$delegate", "getMostlyUsedInfo", "mostlyUsedInfo", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftGroupItem extends MVIState<GiftGroupItem> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty comboCount$delegate;
    private final ReadOnlyProperty groupInfo$delegate;
    private final ReadOnlyProperty mostlyUsedInfo$delegate;
    private final ReadOnlyProperty selected$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftGroupItem.class, "groupInfo", "getGroupInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupItem.class, "selected", "getSelected()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupItem.class, "comboCount", "getComboCount()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupItem.class, "mostlyUsedInfo", "getMostlyUsedInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftGroupItem, Integer> getComboCount() {
        return (r0) this.comboCount$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftGroupItem, h0> getGroupInfo() {
        return (r0) this.groupInfo$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftGroupItem, GiftGroupMostlyUsedInfo> getMostlyUsedInfo() {
        return (r0) this.mostlyUsedInfo$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftGroupItem, Boolean> getSelected() {
        return (r0) this.selected$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public GiftGroupItem() {
        c r0 = f.c(h0.class);
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((com.bytedance.android.anya.internal.c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.groupInfo$delegate = r1;
        Boolean r5 = Boolean.FALSE;
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((com.bytedance.android.anya.internal.c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.selected$delegate = r8;
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        r r11 = new r(0, r9, r10);
        ((com.bytedance.android.anya.internal.c) r11).a = r4[2].getName();
        r10.invoke(r11);
        this.comboCount$delegate = r11;
        GiftGroupMostlyUsedInfo r13 = new GiftGroupMostlyUsedInfo(false, false, false);
        Function1 r14 = ((MVIState) this).propertyChangeCallback;
        Function1 r15 = ((MVIState) this).propertyAddedCallback;
        r r16 = new r(r13, r14, r15);
        ((com.bytedance.android.anya.internal.c) r16).a = r4[3].getName();
        r15.invoke(r16);
        this.mostlyUsedInfo$delegate = r16;
    }
}
