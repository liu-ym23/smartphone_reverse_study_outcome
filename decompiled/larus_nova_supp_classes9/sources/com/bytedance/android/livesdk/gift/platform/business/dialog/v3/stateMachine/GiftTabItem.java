package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabItem;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "title$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getTitle", "()Lcom/bytedance/android/anya/r0;", "title", BuildConfig.FLAVOR, "orderIcon$delegate", "getOrderIcon", "orderIcon", "orderRule$delegate", "getOrderRule", "orderRule", BuildConfig.FLAVOR, "selected$delegate", "getSelected", "selected", "showRedDot$delegate", "getShowRedDot", "showRedDot", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/TopicLabelStatus;", "topicLabelIconStatus$delegate", "getTopicLabelIconStatus", "topicLabelIconStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideState;", "scrollGuideState$delegate", "getScrollGuideState", "scrollGuideState", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTabItem extends MVIState<GiftTabItem> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty orderIcon$delegate;
    private final ReadOnlyProperty orderRule$delegate;
    private final ReadOnlyProperty scrollGuideState$delegate;
    private final ReadOnlyProperty selected$delegate;
    private final ReadOnlyProperty showRedDot$delegate;
    private final ReadOnlyProperty title$delegate;
    private final ReadOnlyProperty topicLabelIconStatus$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTabItem.class, "title", "getTitle()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabItem.class, "orderIcon", "getOrderIcon()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabItem.class, "orderRule", "getOrderRule()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabItem.class, "selected", "getSelected()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabItem.class, "showRedDot", "getShowRedDot()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabItem.class, "topicLabelIconStatus", "getTopicLabelIconStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTabItem.class, "scrollGuideState", "getScrollGuideState()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftTabItem, Integer> getOrderIcon() {
        return (r0) this.orderIcon$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftTabItem, Integer> getOrderRule() {
        return (r0) this.orderRule$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftTabItem, ScrollGuideState> getScrollGuideState() {
        return (r0) this.scrollGuideState$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<GiftTabItem, Boolean> getSelected() {
        return (r0) this.selected$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftTabItem, Boolean> getShowRedDot() {
        return (r0) this.showRedDot$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<GiftTabItem, String> getTitle() {
        return (r0) this.title$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftTabItem, TopicLabelStatus> getTopicLabelIconStatus() {
        return (r0) this.topicLabelIconStatus$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public GiftTabItem() {
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(BuildConfig.FLAVOR, r1, r2);
        KCallable[] r3 = $$delegatedProperties;
        ((c) r0).a = r3[0].getName();
        r2.invoke(r0);
        this.title$delegate = r0;
        Function1 r4 = ((MVIState) this).propertyChangeCallback;
        Function1 r5 = ((MVIState) this).propertyAddedCallback;
        r r6 = new r(0, r4, r5);
        ((c) r6).a = r3[1].getName();
        r5.invoke(r6);
        this.orderIcon$delegate = r6;
        Function1 r7 = ((MVIState) this).propertyChangeCallback;
        Function1 r8 = ((MVIState) this).propertyAddedCallback;
        r r9 = new r(0, r7, r8);
        ((c) r9).a = r3[2].getName();
        r8.invoke(r9);
        this.orderRule$delegate = r9;
        Boolean r10 = Boolean.FALSE;
        Function1 r11 = ((MVIState) this).propertyChangeCallback;
        Function1 r13 = ((MVIState) this).propertyAddedCallback;
        r r14 = new r(r10, r11, r13);
        ((c) r14).a = r3[3].getName();
        r13.invoke(r14);
        this.selected$delegate = r14;
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(r10, r15, r16);
        ((c) r17).a = r3[4].getName();
        r16.invoke(r17);
        this.showRedDot$delegate = r17;
        TopicLabelStatus r18 = TopicLabelStatus.ARROW_GONE;
        Function1 r19 = ((MVIState) this).propertyChangeCallback;
        Function1 r20 = ((MVIState) this).propertyAddedCallback;
        r r21 = new r(r18, r19, r20);
        ((c) r21).a = r3[5].getName();
        r20.invoke(r21);
        this.topicLabelIconStatus$delegate = r21;
        ScrollGuideState r23 = new ScrollGuideState(null, null, null, 7, null);
        Function1 r24 = ((MVIState) this).propertyChangeCallback;
        Function1 r25 = ((MVIState) this).propertyAddedCallback;
        r r26 = new r(r23, r24, r25);
        ((c) r26).a = r3[6].getName();
        r25.invoke(r26);
        this.scrollGuideState$delegate = r26;
    }
}
