package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import py.k;
import vh7.c;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardItem;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/model/n;", "diyCardInfo$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getDiyCardInfo", "()Lcom/bytedance/android/anya/r0;", "diyCardInfo", BuildConfig.FLAVOR, "selected$delegate", "getSelected", "selected", "Lpy/k;", "giftIcon$delegate", "getGiftIcon", "giftIcon", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/DIYCardSelectType;", "selectType$delegate", "getSelectType", "selectType", "showRemindDot$delegate", "getShowRemindDot", "showRemindDot", BuildConfig.FLAVOR, "expireTime$delegate", "getExpireTime", "expireTime", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftDIYCardItem extends MVIState<GiftDIYCardItem> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty diyCardInfo$delegate;
    private final ReadOnlyProperty expireTime$delegate;
    private final ReadOnlyProperty giftIcon$delegate;
    private final ReadOnlyProperty selectType$delegate;
    private final ReadOnlyProperty selected$delegate;
    private final ReadOnlyProperty showRemindDot$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "diyCardInfo", "getDiyCardInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "selected", "getSelected()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "giftIcon", "getGiftIcon()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "selectType", "getSelectType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "showRemindDot", "getShowRemindDot()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "expireTime", "getExpireTime()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftDIYCardItem, n> getDiyCardInfo() {
        return (r0) this.diyCardInfo$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftDIYCardItem, String> getExpireTime() {
        return (r0) this.expireTime$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<GiftDIYCardItem, k> getGiftIcon() {
        return (r0) this.giftIcon$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftDIYCardItem, DIYCardSelectType> getSelectType() {
        return (r0) this.selectType$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftDIYCardItem, Boolean> getSelected() {
        return (r0) this.selected$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftDIYCardItem, Boolean> getShowRemindDot() {
        return (r0) this.showRemindDot$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public GiftDIYCardItem() {
        c r0 = f.c(n.class);
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((com.bytedance.android.anya.internal.c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.diyCardInfo$delegate = r1;
        Boolean r5 = Boolean.FALSE;
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((com.bytedance.android.anya.internal.c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.selected$delegate = r8;
        c r9 = f.c(k.class);
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((com.bytedance.android.anya.internal.c) r13).a = r4[2].getName();
        r11.invoke(r13);
        this.giftIcon$delegate = r13;
        DIYCardSelectType r14 = DIYCardSelectType.IDLE;
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(r14, r15, r16);
        ((com.bytedance.android.anya.internal.c) r17).a = r4[3].getName();
        r16.invoke(r17);
        this.selectType$delegate = r17;
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        r r20 = new r(r5, r18, r19);
        ((com.bytedance.android.anya.internal.c) r20).a = r4[4].getName();
        r19.invoke(r20);
        this.showRemindDot$delegate = r20;
        Function1 r21 = ((MVIState) this).propertyChangeCallback;
        Function1 r23 = ((MVIState) this).propertyAddedCallback;
        r r24 = new r(BuildConfig.FLAVOR, r21, r23);
        ((com.bytedance.android.anya.internal.c) r24).a = r4[5].getName();
        r23.invoke(r24);
        this.expireTime$delegate = r24;
    }
}
