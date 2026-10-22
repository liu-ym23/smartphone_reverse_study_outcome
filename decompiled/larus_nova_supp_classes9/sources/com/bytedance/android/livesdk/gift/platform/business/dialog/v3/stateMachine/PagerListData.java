package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import android.net.Uri;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b6\u00107R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\rR'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\rR'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001b0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\rR'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R'\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\rR'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\rR'\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\rR'\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\rR'\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020.0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\rR'\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\r¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PagerListData;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "itemDataList$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getItemDataList", "()Lcom/bytedance/android/anya/t0;", "itemDataList", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "tabType$delegate", "getTabType", "()Lcom/bytedance/android/anya/r0;", "tabType", BuildConfig.FLAVOR, "emptyListDescription$delegate", "getEmptyListDescription", "emptyListDescription", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/CounterData;", "counterDataList$delegate", "getCounterDataList", "counterDataList", BuildConfig.FLAVOR, "hasMoreData$delegate", "getHasMoreData", "hasMoreData", BuildConfig.FLAVOR, "selectedTopicId$delegate", "getSelectedTopicId", "selectedTopicId", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/TopicPagerListData;", "topicPagerListData$delegate", "getTopicPagerListData", "topicPagerListData", "currentTopicPagerPosition$delegate", "getCurrentTopicPagerPosition", "currentTopicPagerPosition", "canSlideTopic$delegate", "getCanSlideTopic", "canSlideTopic", "isTopicPage$delegate", "isTopicPage", "hasHeader$delegate", "getHasHeader", "hasHeader", "Landroid/net/Uri;", "pageSchemaUri$delegate", "getPageSchemaUri", "pageSchemaUri", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftLynxPageConfig;", "pageLynxConfig$delegate", "getPageLynxConfig", "pageLynxConfig", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PagerListData extends MVIState<PagerListData> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty canSlideTopic$delegate;
    private final ReadOnlyProperty counterDataList$delegate;
    private final ReadOnlyProperty currentTopicPagerPosition$delegate;
    private final ReadOnlyProperty emptyListDescription$delegate;
    private final ReadOnlyProperty hasHeader$delegate;
    private final ReadOnlyProperty hasMoreData$delegate;
    private final ReadOnlyProperty isTopicPage$delegate;
    private final ReadOnlyProperty itemDataList$delegate;
    private final ReadOnlyProperty pageLynxConfig$delegate;
    private final ReadOnlyProperty pageSchemaUri$delegate;
    private final ReadOnlyProperty selectedTopicId$delegate;
    private final ReadOnlyProperty tabType$delegate;
    private final ReadOnlyProperty topicPagerListData$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PagerListData.class, "itemDataList", "getItemDataList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "tabType", "getTabType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "emptyListDescription", "getEmptyListDescription()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "counterDataList", "getCounterDataList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "hasMoreData", "getHasMoreData()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "selectedTopicId", "getSelectedTopicId()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "topicPagerListData", "getTopicPagerListData()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "currentTopicPagerPosition", "getCurrentTopicPagerPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "canSlideTopic", "getCanSlideTopic()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "isTopicPage", "isTopicPage()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "hasHeader", "getHasHeader()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "pageSchemaUri", "getPageSchemaUri()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "pageLynxConfig", "getPageLynxConfig()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<PagerListData, Boolean> getCanSlideTopic() {
        return (r0) this.canSlideTopic$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final t0<PagerListData, CounterData> getCounterDataList() {
        return (t0) this.counterDataList$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<PagerListData, Integer> getCurrentTopicPagerPosition() {
        return (r0) this.currentTopicPagerPosition$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final r0<PagerListData, String> getEmptyListDescription() {
        return (r0) this.emptyListDescription$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<PagerListData, Boolean> getHasHeader() {
        return (r0) this.hasHeader$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final r0<PagerListData, Boolean> getHasMoreData() {
        return (r0) this.hasMoreData$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final t0<PagerListData, ItemListData> getItemDataList() {
        return (t0) this.itemDataList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<PagerListData, GiftLynxPageConfig> getPageLynxConfig() {
        return (r0) this.pageLynxConfig$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final r0<PagerListData, Uri> getPageSchemaUri() {
        return (r0) this.pageSchemaUri$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public final r0<PagerListData, Long> getSelectedTopicId() {
        return (r0) this.selectedTopicId$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<PagerListData, Integer> getTabType() {
        return (r0) this.tabType$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final t0<PagerListData, TopicPagerListData> getTopicPagerListData() {
        return (t0) this.topicPagerListData$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<PagerListData, Boolean> isTopicPage() {
        return (r0) this.isTopicPage$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public PagerListData() {
        List r0 = CollectionsKt.emptyList();
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        u r1 = new u(r0, r2, r3);
        KCallable[] r4 = $$delegatedProperties;
        ((c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.itemDataList$delegate = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(0, r5, r6);
        ((c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.tabType$delegate = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        r r10 = new r(BuildConfig.FLAVOR, r8, r9);
        ((c) r10).a = r4[2].getName();
        r9.invoke(r10);
        this.emptyListDescription$delegate = r10;
        List r11 = CollectionsKt.emptyList();
        Function1 r13 = ((MVIState) this).propertyChangeCallback;
        Function1 r14 = ((MVIState) this).propertyAddedCallback;
        u r15 = new u(r11, r13, r14);
        ((c) r15).a = r4[3].getName();
        r14.invoke(r15);
        this.counterDataList$delegate = r15;
        Boolean r16 = Boolean.FALSE;
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        r r19 = new r(r16, r17, r18);
        ((c) r19).a = r4[4].getName();
        r18.invoke(r19);
        this.hasMoreData$delegate = r19;
        Function1 r20 = ((MVIState) this).propertyChangeCallback;
        Function1 r21 = ((MVIState) this).propertyAddedCallback;
        r r23 = new r(-1L, r20, r21);
        ((c) r23).a = r4[5].getName();
        r21.invoke(r23);
        this.selectedTopicId$delegate = r23;
        List r24 = CollectionsKt.listOf(new TopicPagerListData());
        Function1 r25 = ((MVIState) this).propertyChangeCallback;
        Function1 r26 = ((MVIState) this).propertyAddedCallback;
        u r27 = new u(r24, r25, r26);
        ((c) r27).a = r4[6].getName();
        r26.invoke(r27);
        this.topicPagerListData$delegate = r27;
        Function1 r28 = ((MVIState) this).propertyChangeCallback;
        Function1 r29 = ((MVIState) this).propertyAddedCallback;
        r r30 = new r(-1, r28, r29);
        ((c) r30).a = r4[7].getName();
        r29.invoke(r30);
        this.currentTopicPagerPosition$delegate = r30;
        Function1 r31 = ((MVIState) this).propertyChangeCallback;
        Function1 r33 = ((MVIState) this).propertyAddedCallback;
        r r34 = new r(r16, r31, r33);
        ((c) r34).a = r4[8].getName();
        r33.invoke(r34);
        this.canSlideTopic$delegate = r34;
        Function1 r35 = ((MVIState) this).propertyChangeCallback;
        Function1 r36 = ((MVIState) this).propertyAddedCallback;
        r r37 = new r(r16, r35, r36);
        ((c) r37).a = r4[9].getName();
        r36.invoke(r37);
        this.isTopicPage$delegate = r37;
        Function1 r38 = ((MVIState) this).propertyChangeCallback;
        Function1 r39 = ((MVIState) this).propertyAddedCallback;
        r r40 = new r(r16, r38, r39);
        ((c) r40).a = r4[10].getName();
        r39.invoke(r40);
        this.hasHeader$delegate = r40;
        Uri r41 = Uri.EMPTY;
        Function1 r43 = ((MVIState) this).propertyChangeCallback;
        Function1 r44 = ((MVIState) this).propertyAddedCallback;
        r r45 = new r(r41, r43, r44);
        ((c) r45).a = r4[11].getName();
        r44.invoke(r45);
        this.pageSchemaUri$delegate = r45;
        GiftLynxPageConfig r46 = new GiftLynxPageConfig(null, null, 3, null);
        Function1 r47 = ((MVIState) this).propertyChangeCallback;
        Function1 r48 = ((MVIState) this).propertyAddedCallback;
        r r49 = new r(r46, r47, r48);
        ((c) r49).a = r4[12].getName();
        r48.invoke(r49);
        this.pageLynxConfig$delegate = r49;
    }
}
