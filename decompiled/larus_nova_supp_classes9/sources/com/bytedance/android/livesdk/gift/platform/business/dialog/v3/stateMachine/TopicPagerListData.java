package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/TopicPagerListData;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "tabType$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getTabType", "()Lcom/bytedance/android/anya/r0;", "tabType", BuildConfig.FLAVOR, "hasMoreData$delegate", "getHasMoreData", "hasMoreData", BuildConfig.FLAVOR, "emptyListDescription$delegate", "getEmptyListDescription", "emptyListDescription", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "itemDataList$delegate", "getItemDataList", "()Lcom/bytedance/android/anya/t0;", "itemDataList", "topicId$delegate", "getTopicId", "topicId", "visibility$delegate", "getVisibility", "visibility", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopicPagerListData extends MVIState<TopicPagerListData> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty emptyListDescription$delegate;
    private final ReadOnlyProperty hasMoreData$delegate;
    private final ReadOnlyProperty itemDataList$delegate;
    private final ReadOnlyProperty tabType$delegate;
    private final ReadOnlyProperty topicId$delegate;
    private final ReadOnlyProperty visibility$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TopicPagerListData.class, "tabType", "getTabType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(TopicPagerListData.class, "hasMoreData", "getHasMoreData()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(TopicPagerListData.class, "emptyListDescription", "getEmptyListDescription()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(TopicPagerListData.class, "itemDataList", "getItemDataList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(TopicPagerListData.class, "topicId", "getTopicId()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(TopicPagerListData.class, "visibility", "getVisibility()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<TopicPagerListData, String> getEmptyListDescription() {
        return (r0) this.emptyListDescription$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<TopicPagerListData, Boolean> getHasMoreData() {
        return (r0) this.hasMoreData$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final t0<TopicPagerListData, ItemListData> getItemDataList() {
        return (t0) this.itemDataList$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<TopicPagerListData, Integer> getTabType() {
        return (r0) this.tabType$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<TopicPagerListData, Integer> getTopicId() {
        return (r0) this.topicId$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<TopicPagerListData, Boolean> getVisibility() {
        return (r0) this.visibility$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public TopicPagerListData() {
        Function1 r3 = ((MVIState) this).propertyChangeCallback;
        Function1 r4 = ((MVIState) this).propertyAddedCallback;
        r r2 = new r(0, r3, r4);
        KCallable[] r1 = $$delegatedProperties;
        ((c) r2).a = r1[0].getName();
        r4.invoke(r2);
        this.tabType$delegate = r2;
        Boolean r0 = Boolean.FALSE;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r0, r5, r6);
        ((c) r7).a = r1[1].getName();
        r6.invoke(r7);
        this.hasMoreData$delegate = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        r r10 = new r(BuildConfig.FLAVOR, r8, r9);
        ((c) r10).a = r1[2].getName();
        r9.invoke(r10);
        this.emptyListDescription$delegate = r10;
        List r11 = CollectionsKt.emptyList();
        Function1 r13 = ((MVIState) this).propertyChangeCallback;
        Function1 r14 = ((MVIState) this).propertyAddedCallback;
        u r15 = new u(r11, r13, r14);
        ((c) r15).a = r1[3].getName();
        r14.invoke(r15);
        this.itemDataList$delegate = r15;
        Function1 r16 = ((MVIState) this).propertyChangeCallback;
        Function1 r17 = ((MVIState) this).propertyAddedCallback;
        r r18 = new r(-1, r16, r17);
        ((c) r18).a = r1[4].getName();
        r17.invoke(r18);
        this.topicId$delegate = r18;
        Boolean r19 = Boolean.TRUE;
        Function1 r20 = ((MVIState) this).propertyChangeCallback;
        Function1 r21 = ((MVIState) this).propertyAddedCallback;
        r r23 = new r(r19, r20, r21);
        ((c) r23).a = r1[5].getName();
        r21.invoke(r23);
        this.visibility$delegate = r23;
    }
}
