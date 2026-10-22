package com.obric.memorydata.recommend.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.context.data.FestivalThroughData;
import com.obric.memorydata.recommend.databinding.FragmentContextListFragmentBinding;
import com.obric.memorydata.recommend.databinding.ItemContextBinding;
import com.obric.memorydata.recommend.databinding.ItemContextValueBinding;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.memorydata.utils.r;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020'H\u0002J\u0016\u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0002J\u0018\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0013H\u0003J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/ContextListFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", ContextListFragment.ARG_POSITION, "", "getPosition", "()I", "position$delegate", "Lkotlin/Lazy;", "binding", "Lcom/obric/memorydata/recommend/databinding/FragmentContextListFragmentBinding;", "memoryTab", "Lcom/obric/memorydata/recommend/ui/list/MemoryTab;", "getMemoryTab", "()Lcom/obric/memorydata/recommend/ui/list/MemoryTab;", "memoryTab$delegate", "typeToTitle", "", "Lcom/obric/memorydata/recommend/ui/list/ContextGroupType;", "", "typeToSubItemTypes", "", "Lcom/obric/memorydata/recommend/ui/list/ContextItemType;", "subItemTypeToTitle", "subItemTypeToItemView", "", "Lcom/obric/memorydata/recommend/databinding/ItemContextValueBinding;", "subItemTypeToLoader", "Lcom/obric/memorydata/recommend/context/ContextLoader;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshList", "setupContent", Constants.KEY_LIST, "setupItemView", "Lcom/obric/memorydata/recommend/databinding/ItemContextBinding;", "type", "getDisplayRealtimeStatus", "getDisplayUserCommonMessage", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextListFragment extends BaseFragment {
    private static final String ARG_POSITION = "position";
    public static final a Companion = null;
    private static final String TAG = "ContextFragment";
    private FragmentContextListFragmentBinding binding;
    private final Lazy memoryTab$delegate;
    private final Lazy position$delegate;
    private final Map<ContextItemType, ItemContextValueBinding> subItemTypeToItemView;
    private final Map<ContextItemType, com.obric.memorydata.recommend.context.a> subItemTypeToLoader;
    private final Map<ContextItemType, String> subItemTypeToTitle;
    private final Map<ContextGroupType, List<ContextItemType>> typeToSubItemTypes;
    private final Map<ContextGroupType, String> typeToTitle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/ContextListFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "newInstance", "Lcom/obric/memorydata/recommend/ui/list/ContextListFragment;", ContextListFragment.ARG_POSITION, "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ContextListFragment a(int r3) {
            ContextListFragment r2 = new ContextListFragment();
            Bundle r0 = new Bundle();
            r0.putInt(ContextListFragment.ARG_POSITION, r3);
            r2.setArguments(r0);
            return r2;
        }
    }

    static {
        Companion = new a(null);
    }

    public ContextListFragment() {
        this.position$delegate = LazyKt.lazy(new $$Lambda$ContextListFragment$chlNfd6ItikU7OQbSPhtZUwE(this));
        this.memoryTab$delegate = LazyKt.lazy(new $$Lambda$ContextListFragment$GKQvHTG8fCHHFRohtWAUGYd844w(this));
        this.typeToTitle = MapsKt.mapOf(new Pair[]{TuplesKt.to(ContextGroupType.DAY_TYPE, "日期"), TuplesKt.to(ContextGroupType.LOCATION, "地点"), TuplesKt.to(ContextGroupType.MOVEMENT_TYPE, IRecommendSettings.ProfileTag.OTHER), TuplesKt.to(ContextGroupType.HOME_AND_COMPANY_LOCATION, InfoCommonMemoryEntity.InfoKeyType.ADDRESS), TuplesKt.to(ContextGroupType.COMMUTE_TIME, "通勤"), TuplesKt.to(ContextGroupType.SLEEP_TIME, "时间"), TuplesKt.to(ContextGroupType.FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY, "日期")});
        this.typeToSubItemTypes = MapsKt.mapOf(new Pair[]{TuplesKt.to(ContextGroupType.DAY_TYPE, CollectionsKt.listOf(ContextItemType.DAY_TYPE)), TuplesKt.to(ContextGroupType.LOCATION, CollectionsKt.listOf(new ContextItemType[]{ContextItemType.LOCATION_TYPE, ContextItemType.LOCATION})), TuplesKt.to(ContextGroupType.MOVEMENT_TYPE, CollectionsKt.listOf(ContextItemType.MOVEMENT_TYPE)), TuplesKt.to(ContextGroupType.HOME_AND_COMPANY_LOCATION, CollectionsKt.listOf(new ContextItemType[]{ContextItemType.HOME_LOCATIONS, ContextItemType.COMPANY_LOCATIONS})), TuplesKt.to(ContextGroupType.COMMUTE_TIME, CollectionsKt.listOf(new ContextItemType[]{ContextItemType.LEAVE_HOME_TIME, ContextItemType.ARRIVE_COMPANY_TIME, ContextItemType.LEAVE_COMPANY_TIME, ContextItemType.ARRIVE_HOME_TIME})), TuplesKt.to(ContextGroupType.SLEEP_TIME, CollectionsKt.listOf(new ContextItemType[]{ContextItemType.SLEEP_TIME, ContextItemType.WAKEUP_TIME})), TuplesKt.to(ContextGroupType.FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY, CollectionsKt.listOf(new ContextItemType[]{ContextItemType.FESTIVAL, ContextItemType.ANNIVERSARY}))});
        this.subItemTypeToTitle = MapsKt.mapOf(new Pair[]{TuplesKt.to(ContextItemType.DAY_TYPE, "日期类型"), TuplesKt.to(ContextItemType.LOCATION_TYPE, "场景"), TuplesKt.to(ContextItemType.LOCATION, InfoCommonMemoryEntity.InfoKeyType.ADDRESS), TuplesKt.to(ContextItemType.MOVEMENT_TYPE, "移动状态"), TuplesKt.to(ContextItemType.HOME_LOCATIONS, "家"), TuplesKt.to(ContextItemType.COMPANY_LOCATIONS, "公司"), TuplesKt.to(ContextItemType.LEAVE_HOME_TIME, "通常离开家的时间"), TuplesKt.to(ContextItemType.ARRIVE_COMPANY_TIME, "通常到达公司的时间"), TuplesKt.to(ContextItemType.LEAVE_COMPANY_TIME, "通常离开公司的时间"), TuplesKt.to(ContextItemType.ARRIVE_HOME_TIME, "通常到达家的时间"), TuplesKt.to(ContextItemType.SLEEP_TIME, "入睡时间"), TuplesKt.to(ContextItemType.WAKEUP_TIME, "醒来时间")});
        this.subItemTypeToItemView = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.subItemTypeToLoader = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private final List<ContextGroupType> getDisplayRealtimeStatus() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        return CollectionsKt.listOf(new ContextGroupType[]{ContextGroupType.DAY_TYPE, ContextGroupType.LOCATION, ContextGroupType.MOVEMENT_TYPE});
    L6:
        return CollectionsKt.listOf(new ContextGroupType[]{ContextGroupType.DAY_TYPE, ContextGroupType.MOVEMENT_TYPE});
    }

    private final List<ContextGroupType> getDisplayUserCommonMessage() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        return CollectionsKt.listOf(new ContextGroupType[]{ContextGroupType.HOME_AND_COMPANY_LOCATION, ContextGroupType.SLEEP_TIME, ContextGroupType.COMMUTE_TIME, ContextGroupType.FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY});
    L6:
        return CollectionsKt.listOf(ContextGroupType.FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY);
    }

    private final MemoryTab getMemoryTab() {
        return (MemoryTab) ZeusTransformUtils.preCheckCast(this.memoryTab$delegate.getValue(), MemoryTab.class, "com.obric.memorydata.plugin");
    }

    private final int getPosition() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.position$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static /* synthetic */ void lambda$9LSlpmkwBhNu8IqKJZjBYnAg0AY(ContextListFragment r0) {
        refreshList$lambda$4(r0);
    }

    public static /* synthetic */ Unit lambda$ChPIBx5cTeMaEzoApYvuJBXsrZY(Map.Entry r0, String r1) {
        return refreshList$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ MemoryTab lambda$GKQvHTG8fCHHFRohtWAUGYd844w(ContextListFragment r0) {
        return memoryTab_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$M-3RX_05zNetBxngZu8wRBuQsJg, reason: not valid java name */
    public static /* synthetic */ void m1141lambda$M3RX_05zNetBxngZu8wRBuQsJg(ItemContextBinding r0, ContextListFragment r1) {
        setupItemView$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit lambda$NafY4hivgxZ8kBFqDV9B8wAXSZI(List r0, ItemContextBinding r1, ContextListFragment r2) {
        return setupItemView$lambda$7$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$Oq2O_NgWiLzwjD5Ro5D_oysaWZ8(Map.Entry r0, String r1) {
        return refreshList$lambda$4$lambda$3$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$chlNfd6-It-ikU-7OQbSPhtZUwE, reason: not valid java name */
    public static /* synthetic */ int m1142lambda$chlNfd6ItikU7OQbSPhtZUwE(ContextListFragment r0) {
        return position_delegate$lambda$0(r0);
    }

    private static final MemoryTab memoryTab_delegate$lambda$1(ContextListFragment r1) {
        return MemoryTab.Companion.a(r1.getPosition());
    }

    private static final int position_delegate$lambda$0(ContextListFragment r1) {
        Bundle r2 = r1.getArguments();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getInt(ARG_POSITION);
    }

    private final void refreshList() {
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$ContextListFragment$9LSlpmkwBhNu8IqKJZjBYnAg0AY(this));
    }

    private static final void refreshList$lambda$4(ContextListFragment r6) {
        Iterator<Map.Entry<ContextItemType, ItemContextValueBinding>> r0 = r6.subItemTypeToItemView.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        final Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(TAG, "key: " + r1.getKey() + " value: " + r1.getValue());
        com.obric.memorydata.recommend.context.a r2 = (com.obric.memorydata.recommend.context.a) ZeusTransformUtils.preCheckCast(r6.subItemTypeToLoader.get(r1.getKey()), com.obric.memorydata.recommend.context.a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        r2 = new com.obric.memorydata.recommend.context.a((ContextItemType) ZeusTransformUtils.preCheckCast(r1.getKey(), ContextItemType.class, "com.obric.memorydata.plugin"), new $$Lambda$ContextListFragment$ChPIBx5cTeMaEzoApYvuJBXsrZY(r1));
    L8:
        r6.subItemTypeToLoader.put((ContextItemType) r1.getKey(), r2);
        r2.a();
        goto L4
    }

    private static final Unit refreshList$lambda$4$lambda$3(Map.Entry r4, final String r5) {
        final Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        RunLog.INSTANCE.debug(TAG, "onLoadFinish key: " + r6.getKey() + " value: " + r5);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        com.obric.memorydata.utils.j.a(new $$Lambda$ContextListFragment$Oq2O_NgWiLzwjD5Ro5D_oysaWZ8(r6, r5));
        return Unit.INSTANCE;
    L8:
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }

    private static final Unit refreshList$lambda$4$lambda$3$lambda$2(Map.Entry r2, String r3) {
        ((ItemContextValueBinding) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), ItemContextValueBinding.class, "com.obric.memorydata.plugin")).tvRight.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final void setupContent(List<? extends ContextGroupType> r7) {
        Iterator r8 = ((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        ContextGroupType r0 = (ContextGroupType) ZeusTransformUtils.preCheckCast(r8.next(), ContextGroupType.class, "com.obric.memorydata.plugin");
        ItemContextBinding r2 = ItemContextBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r2, "inflate(...)");
        r2.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.typeToTitle.get(r0), CharSequence.class, "com.obric.memorydata.plugin"));
        setupItemView(r2, r0);
        FragmentContextListFragmentBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        r1.contextList.addView((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private final void setupItemView(final ItemContextBinding r9, ContextGroupType r10) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.typeToSubItemTypes.get(r10), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "setupItemView, subItemTypes is null", null, 4, null);
        return;
    L7:
        if (r10 != ContextGroupType.FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY) goto L10;
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$ContextListFragment$M3RX_05zNetBxngZu8wRBuQsJg(r9, this));
        return;
    L10:
        Iterator r11 = r0.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        ContextItemType r1 = (ContextItemType) ZeusTransformUtils.preCheckCast(r11.next(), ContextItemType.class, "com.obric.memorydata.plugin");
        ItemContextValueBinding r2 = ItemContextValueBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r2, "inflate(...)");
        LinearLayout r3 = r9.linearLayout;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin");
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-1, -2);
        r5.setMargins(0, 16, 0, 0);
        Unit r6 = Unit.INSTANCE;
        r3.addView(r4, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.subItemTypeToItemView.put(r1, r2);
        r2.tvLeft.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.subItemTypeToTitle.get(r1), CharSequence.class, "com.obric.memorydata.plugin"));
        r2.tvRight.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.recommend_context_loading_text, TypedValues.Custom.S_STRING, "recommend_context_loading_text")), CharSequence.class, "com.obric.memorydata.plugin"));
        goto L12
    }

    private static final void setupItemView$lambda$7(final ItemContextBinding r3, final ContextListFragment r4) {
        final List r0 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.context.b.b(30).getSecond(), List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.utils.j.a(new $$Lambda$ContextListFragment$NafY4hivgxZ8kBFqDV9B8wAXSZI(r0, r3, r4));
    }

    private static final Unit setupItemView$lambda$7$lambda$6(List r9, ItemContextBinding r10, ContextListFragment r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r12.isEmpty() == false) goto L6;
        r10.getRoot().setVisibility(8);
        return Unit.INSTANCE;
    L6:
        r10.linearLayout.setVisibility(0);
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L15;
        FestivalThroughData r0 = (FestivalThroughData) ZeusTransformUtils.preCheckCast(r13.next(), FestivalThroughData.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(TAG, "data: " + r0);
        ItemContextValueBinding r3 = ItemContextValueBinding.inflate(r11.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r3, "inflate(...)");
        LinearLayout r4 = r10.linearLayout;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r3.getRoot(), View.class, "com.obric.memorydata.plugin");
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(-1, -2);
        r6.setMargins(0, 16, 0, 0);
        Unit r7 = Unit.INSTANCE;
        r4.addView(r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r3.tvLeft.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0.getName(), CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r8 = r3.tvRight;
        if (r0.getType() != 1) goto L12;
        String r1 = r.f(r0.getStartTime()) + '-' + r.f(r0.getEndTime());
    L13:
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L8
    L12:
        r1 = r.f(r0.getStartTime());
        goto L13
    L15:
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FragmentContextListFragmentBinding r4 = FragmentContextListFragmentBinding.inflate(r1, r2, false);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.binding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        ConstraintLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        RunLog.INSTANCE.debug(TAG, "onViewCreated: " + getMemoryTab());
        if (getMemoryTab() != MemoryTab.REALTIME_STATUS) goto L7;
        List<ContextGroupType> r4 = getDisplayRealtimeStatus();
    L5:
        setupContent(r4);
        refreshList();
        return;
    L7:
        if (getMemoryTab() != MemoryTab.COMMON) goto L10;
        r4 = getDisplayUserCommonMessage();
        goto L5
    }
}
