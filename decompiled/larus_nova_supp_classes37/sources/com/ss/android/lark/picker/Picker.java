package com.ss.android.lark.picker;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.statistics.PickerTracker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.binder.CommonBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomViewTypeResolver;
import com.ss.android.lark.picker.base.view.recommend.DefaultRecommendView;
import com.ss.android.lark.picker.base.widget.AbsChatterPicker;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency;
import com.ss.android.lark.picker.base.widget.params.BasePickerParams;
import com.ss.android.lark.picker.base.widget.params.ChatterPickerParams;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterDelegate;
import com.ss.android.lark.picker.base.widget.scenario.PermissionGroupListFragment;
import com.ss.android.lark.picker.base.widget.scenario.PersonnelTypeListFragment;
import com.ss.android.lark.picker.base.widget.scenario.ScenarioEntriesFragment;
import com.ss.android.lark.picker.base.widget.scenario.ScenarioSelectionDelegate;
import com.ss.android.lark.picker.base.widget.utils.FG;
import com.ss.android.lark.picker.config.AddressBookConfig;
import com.ss.android.lark.picker.config.Chatter;
import com.ss.android.lark.picker.config.ChatterExtra;
import com.ss.android.lark.picker.config.DepartmentSelectableScene;
import com.ss.android.lark.picker.config.Entity;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.config.PickerExtra;
import com.ss.android.lark.picker.config.RecommendListConfig;
import com.ss.android.lark.picker.config.ScenarioConfig;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.picker.config.TopExtra;
import com.ss.android.lark.picker.config.UserGroupVisibility;
import com.ss.android.lark.picker.extra.SelectedPreviewStyle;
import com.ss.android.lark.picker.plugin.PickerPlugin;
import com.ss.android.lark.picker.plugin.SearchHistoryPlugin;
import com.ss.android.lark.picker.preview.SelectedPreviewView;
import com.ss.android.lark.picker.scenario.ScenarioDataPuller;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.search.dto.EntityType;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchUserTeamInfo;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002abB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u0010'\u001a\u00020(2\u0006\u0010'\u001a\u00020\u000eJ\b\u0010)\u001a\u00020(H\u0014J\b\u0010*\u001a\u00020(H\u0014J\u0010\u0010+\u001a\u00020(2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0006\u0010,\u001a\u00020(J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u001eH\u0014J\u0018\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020(H\u0002J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020(H\u0002J\b\u0010?\u001a\u00020.H\u0002J\b\u0010@\u001a\u00020(H\u0002J\b\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020(H\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020EH\u0002J \u0010F\u001a\u00020(2\u0006\u0010D\u001a\u00020E2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020PH\u0002J#\u0010Q\u001a\u00020(2\n\b\u0003\u0010R\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020(H\u0002J\u0010\u0010V\u001a\u00020(2\u0006\u0010W\u001a\u00020.H\u0002J\u0010\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020\u0011H\u0002J\u0010\u0010Z\u001a\u00020(2\u0006\u0010Y\u001a\u00020\u0011H\u0002J\b\u0010[\u001a\u00020(H\u0016J\u0016\u0010\\\u001a\u00020(2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u0010H\u0014J\u0010\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020^H\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u0006c"}, d2 = {"Lcom/ss/android/lark/picker/Picker;", "Lcom/ss/android/lark/picker/base/widget/AbsChatterPicker;", "Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams;", "Lcom/ss/android/lark/picker/IPicker;", "Lcom/ss/android/lark/picker/config/PickerConfig;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "config", "pickerScene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "reloadListeners", "", "Lcom/ss/android/lark/picker/Picker$IReloadListener;", "recommendListView", "Lcom/ss/android/lark/picker/base/view/recommend/DefaultRecommendView;", "recommendEmptyIconResId", "", "Ljava/lang/Integer;", "recommendEmptyHintText", "", "pickerTracker", "Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "pickerInitTime", "", "pickerRecommendRequestId", "", "plugins", "Lcom/ss/android/lark/picker/plugin/PickerPlugin;", "viewModel", "Lcom/ss/android/lark/picker/PickerViewModel;", "getViewModel", "()Lcom/ss/android/lark/picker/PickerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "scene", "", "onAttachedToWindow", "onDetachedFromWindow", "init", "search", "spotLightSupportable", "", "pickerParams", "initialSearch", "queryKey", "reload", "isReloadSearch", "isReloadRecommend", "getChatterPickerParams", "Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams$Builder;", "configDependency", "configStatistics", "configInputView", "configCustomView", "configSelectedPreviewStyle", "selectedPreviewStyle", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "configSelect", "isMaxSelectReached", "showMaxSelectToast", "configOthers", "configRecommendView", "initScenarioEntriesView", "cfg", "Lcom/ss/android/lark/picker/config/ScenarioConfig;", "loadScenarioEntriesData", "personnelTypeListFragment", "Lcom/ss/android/lark/picker/base/widget/scenario/PersonnelTypeListFragment;", "permissionGroupListFragment", "Lcom/ss/android/lark/picker/base/widget/scenario/PermissionGroupListFragment;", "initOrganizationFragment", "addressBookConfig", "Lcom/ss/android/lark/picker/config/AddressBookConfig;", "initRecommendListView", "recommendListConfig", "Lcom/ss/android/lark/picker/config/RecommendListConfig;", "attachRecommendEmptyViewConfig", "emptyIconResId", "emptyHintText", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "configResultView", "configMultiSelect", "isMultiSelect", "addReloadListener", "listener", "removeReloadListener", "refreshDefault", "onSearchSuccess", "infoList", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onSearchHistoryRecordNeeded", "baseInfo", "Companion", "IReloadListener", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class Picker extends AbsChatterPicker<ChatterPickerParams, Picker> implements IPicker<PickerConfig> {
    public static final Companion Companion = null;
    public static final String TAG = "Picker";
    private PickerConfig config;
    private final long pickerInitTime;
    private String pickerRecommendRequestId;
    private PickerStatistics.Scene pickerScene;
    private PickerTracker pickerTracker;
    private final List<PickerPlugin> plugins;
    private CharSequence recommendEmptyHintText;
    private Integer recommendEmptyIconResId;
    private DefaultRecommendView recommendListView;
    private final List<IReloadListener> reloadListeners;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/Picker$Companion;", "", "<init>", "()V", "TAG", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/Picker$IReloadListener;", "", "onReload", "", "reloadSearch", "", "reloadRecommend", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IReloadListener {
        void onReload(boolean r1, boolean r2);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void configCustomView() {
        PickerConfig r0 = this.config;
        if (r0 != null) goto L6;
        Log.e(TAG, "configCustomView: config is null");
        return;
    L6:
        PickerExtra r1 = r0.getExtra$picker_release();
        if (r1 == null) goto L30;
        View r2 = r1.getCustomResultHeaderView();
        if (r2 == null) goto L11;
        setHeadCustomView(r2);
    L11:
        View r3 = r1.getCustomHeaderView();
        if (r3 == null) goto L14;
        Picker r4 = (Picker) attachHeaderCustomView(r3);
    L14:
        View r5 = r1.getCustomTopView();
        if (r5 == null) goto L17;
        Picker r6 = (Picker) BasePicker.attachTopCustomView$default(this, r5, false, 2, null);
    L17:
        View r7 = r1.getCustomCenterView();
        if (r7 == null) goto L20;
        Picker r8 = (Picker) attachCenterCustomView(r7);
    L20:
        View r9 = r1.getCustomSelectedPreviewView();
        if (r9 != null) goto L23;
    L24:
        configSelectedPreviewStyle(r1.getSelectedPreviewStyle());
        Unit r10 = Unit.INSTANCE;
    L25:
        View r11 = r1.getCustomRecommendView();
        if (r11 == null) goto L28;
        Picker r12 = (Picker) attachRecommendView(r11);
    L28:
        Picker r13 = (Picker) attachSoftInputInitPopup(r1.isEnableAutoPopupKeyboard());
        return;
    L23:
        if (((Picker) attachSelectedCustomView(r9)) != null) goto L25;
    }

    private final void configDependency() {
        final PickerConfig r0 = this.config;
        if (r0 != null) goto L6;
        Log.e(TAG, "configDependency: config is null");
        return;
    L6:
        attachDependency(new AnonymousClass1(r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void configInputView() {
        PickerConfig r0 = this.config;
        if (r0 != null) goto L6;
        Log.e(TAG, "configInputView: config is null");
        return;
    L6:
        PickerExtra r1 = r0.getExtra$picker_release();
        if (r1 == null) goto L19;
        String r2 = r1.getSearchHint();
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
        attachSearchHintText(r2);
    L17:
        Picker r4 = (Picker) attachSoftInputInitPopup(r1.isEnableAutoPopupKeyboard());
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    }

    private final void configOthers() {
        PickerConfig r0 = this.config;
        if (r0 != null) goto L6;
        Log.e(TAG, "configOthers: config is null");
        return;
    L6:
        PickerExtra r1 = r0.getExtra$picker_release();
        if (r1 == null) goto L25;
        SearchResultView.IOnBusinessConsumeItem r2 = r1.getItemConsumer();
        if (r2 == null) goto L11;
        Picker r3 = attachOnBusinessConsumeItem(r2);
    L11:
        ICustomBinder r4 = r1.getCustomBinder();
        if (r4 == null) goto L14;
        setCustomBinder(r4);
    L14:
        List<ICustomViewTypeResolver> r5 = r1.getCustomViewTypeResolvers();
        if (r5 == null) goto L17;
        setCustomViewTypeResolvers(r5);
    L17:
        Map<Integer, CommonBinder<?>> r6 = r1.getCustomBinders();
        if (r6 == null) goto L20;
        registerSearchCustomBinders(r6);
    L20:
        attachForceRefreshResultNotifyDataSetChanged(r1.getForceRefreshResultNotifyDataSetChanged());
        attachIsEnableChatPreview(r1.isEnableChatPreview());
        attachChatCountStyle(r1.isEnableLightStyleOfChatCount());
        enableCancelView(r1.isEnableCancelBtn());
        attachOnCancelListener(r1.getOnCancelListener());
        attachInitDepartmentId(r1.getInitDepartmentId());
        View.OnFocusChangeListener r7 = r1.getOnFocusListener();
        if (r7 == null) goto L23;
        SearchInputView r8 = getMSearchInputView();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "onFocusChangeListener");
        r7.onFocusChange(r8, r8.isFocused());
        ((ArrayList) r8.i).add(r7);
    L23:
        attachEnableAutoFocus(r1.getEnableAutoFocus());
        return;
    }

    private final void configRecommendView() {
        Iterator<T> r0 = this.plugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        PickerPlugin r2 = (PickerPlugin) r0.next();
        PickerViewModel r4 = getViewModel();
        PickerConfig r1 = this.config;
        if (r1 == null) goto L8;
        PickerExtra r3 = r1.getExtra$picker_release();
    L9:
        r2.apply(this, r4, r3, this.recommendEmptyIconResId, this.recommendEmptyHintText);
        goto L4
    L8:
        r3 = null;
        goto L9
    L10:
        PickerConfig r5 = this.config;
        if (r5 == null) goto L25;
        RecommendListConfig r6 = r5.getRecommendListConfig$picker_release();
        if (r6 == null) goto L15;
        initRecommendListView(r6);
    L15:
        AddressBookConfig r7 = r5.getAddressBookConfig$picker_release();
        if (r7 == null) goto L18;
        initOrganizationFragment(r7);
    L18:
        ScenarioConfig r8 = r5.getScenarioConfig$picker_release();
        if (r8 == null) goto L26;
        initScenarioEntriesView(r8);
        return;
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void configSelect() {
        PickerConfig r0 = this.config;
        if (r0 != null) goto L6;
        Log.e(TAG, "configSelectStatus: config is null");
        return;
    L6:
        PickerExtra r1 = r0.getExtra$picker_release();
        if (r1 == null) goto L29;
        configMultiSelect(r1.isMultiSelect());
        List<Pair<String, EntityType>> r2 = r1.getPreSelectedIds();
        if (r2 == null) goto L11;
        updatePreSelectedListByIds(r2);
    L11:
        List<SearchBaseInfo> r3 = r1.getPreSelectedItems();
        if (r3 == null) goto L14;
        updatePreSelectedList(r3);
    L14:
        BasePicker.IOnSelectModeChangeListener r4 = r1.getOnSelectModeChangeListener();
        if (r4 == null) goto L17;
        addSelectModeChangeListener(r4);
    L17:
        final BasePicker.IOnPickNotify r5 = r1.getOnPickListener();
        if (r5 == null) goto L20;
        Picker r6 = (Picker) attachOnPickerNotify(new Picker$configSelect$1$4$listenerInner$1(r5, this));
    L20:
        final BasePicker.IOnPickNotifyV2 r7 = r1.getOnPickListenerV2();
        if (r7 == null) goto L24;
        addOnPickNotifyV2(new Picker$configSelect$1$5$listenerInnerV2$1(r7, this));
    L24:
        if (r1.isMultiSelect() == true) goto L26;
        return;
    L26:
        if (r1.getMaxSelectCount() <= 0) goto L31;
        attachOnBusinessConsumeItem(new Picker$configSelect$1$6(this));
        return;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void configStatistics() {
        PickerConfig r0 = this.config;
        if (r0 != null) goto L6;
        Log.e(TAG, "configStatistics: config is null");
        return;
    L6:
        PickerExtra r1 = r0.getExtra$picker_release();
        if (r1 == null) goto L12;
        attachScene(r1.getScene());
        attachUseCategory(r1.getCategory());
        attachUsePage(r1.getPage());
        PickerReporterDelegate r2 = r1.getDelegateReporter();
        if (r2 == null) goto L13;
        Picker r3 = (Picker) attachReporterDelegate(r2);
        return;
    L13:
        return;
    }

    private final ChatterPickerParams.Builder getChatterPickerParams() {
        return new ChatterPickerParams.Builder().attachNeedSearchOuterUser(true).attachEnableExternalGroup(true).attachEmailContact(true).attachEmailSharedAccount(true).attachEnablePublicGroup(true).attachEnableSecretGroup(true).attachEnableMeetingGroup(true);
    }

    private final PickerViewModel getViewModel() {
        return (PickerViewModel) this.viewModel$delegate.getValue();
    }

    private final boolean isMaxSelectReached() {
        PickerConfig r0 = this.config;
        if (r0 == null) goto L7;
        PickerExtra r1 = r0.getExtra$picker_release();
        if (r1 == null) goto L7;
        int r2 = r1.getMaxSelectCount();
    L8:
        if (r2 > 0) goto L10;
        return false;
    L10:
        if (getSelectedList().size() < r2) goto L14;
        return true;
    L14:
        return false;
    L7:
        r2 = 0;
        goto L8
    }

    private final void showMaxSelectToast() {
        PickerConfig r0 = this.config;
        if (r0 == null) goto L7;
        PickerExtra r1 = r0.getExtra$picker_release();
        if (r1 == null) goto L7;
        int r2 = r1.getMaxSelectCount();
    L8:
        if (r2 > 0) goto L10;
        return;
    L10:
        UDToast.makeToast(getContext(), 2131890296, 2131256189).show();
        return;
    L7:
        r2 = 0;
        goto L8
    }

    private final void configResultView() {
        SearchResultView r0 = getMSearchResultView();
        PickerConfig r1 = this.config;
        if (r1 == null) goto L7;
        PickerExtra r2 = r1.getExtra$picker_release();
        if (r2 == null) goto L7;
        boolean r3 = r2.getDisableRightViewHolder();
    L8:
        r0.setDisableRightViewHolder(r3);
        r0.setDisableExtraInfoSummary(true);
        return;
    L7:
        r3 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        PickerTracker r0 = this.pickerTracker;
        if (r0 == null) goto L6;
        r0.trackShow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PickerTracker r0 = this.pickerTracker;
        if (r0 == null) goto L6;
        r0.trackDestroy();
        return;
    }

    @Override // com.ss.android.lark.picker.base.widget.AbsChatterPicker, com.ss.android.lark.picker.base.widget.BasePicker
    public void refreshDefault() {
        super.refreshDefault();
        DefaultRecommendView r0 = this.recommendListView;
        if (r0 == null) goto L6;
        r0.refreshSelected(getSelectedList(), getForceNotifyDataSetChangedOnRefreshResult());
        return;
    }

    public final void search() {
        initialSearch(getMSearchQuery());
    }

    public Picker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ ChatterPickerParams.Builder access$getChatterPickerParams(Picker r0) {
        return r0.getChatterPickerParams();
    }

    public static final /* synthetic */ PickerConfig access$getConfig$p(Picker r0) {
        return r0.config;
    }

    public static final /* synthetic */ PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsSelectorController access$getMIContactsSelectorController(Picker r0) {
        return r0.getMIContactsSelectorController();
    }

    public static final /* synthetic */ long access$getPickerInitTime$p(Picker r2) {
        return r2.pickerInitTime;
    }

    public static final /* synthetic */ String access$getPickerRecommendRequestId$p(Picker r0) {
        return r0.pickerRecommendRequestId;
    }

    public static final /* synthetic */ PickerTracker access$getPickerTracker$p(Picker r0) {
        return r0.pickerTracker;
    }

    public static final /* synthetic */ String access$getScene(Picker r0) {
        return r0.getScene();
    }

    public static final /* synthetic */ boolean access$isMaxSelectReached(Picker r0) {
        return r0.isMaxSelectReached();
    }

    public static final /* synthetic */ void access$showMaxSelectToast(Picker r0) {
        r0.showMaxSelectToast();
    }

    private final void addReloadListener(IReloadListener r2) {
        this.reloadListeners.add(r2);
    }

    private final void configMultiSelect(boolean r4) {
        BasePicker.switchMultipleStatus$default(this, r4, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, com.ss.android.lark.picker.preview.SelectedPreviewView] */
    private final void configSelectedPreviewStyle(SelectedPreviewStyle r3) {
        if ((r3 instanceof SelectedPreviewStyle.SelectedNumber) == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L9;
        final ?? r0 = new SelectedPreviewView(getContext());
        r0.setOnNumberUpdateListener(((SelectedPreviewStyle.SelectedNumber) r3).getUpdateListener());
        r0.refreshSelectedData(getMSelectedList());
        r0.setOnClickListener(new Picker$configSelectedPreviewStyle$2$1$1(this));
        addOnPickNotifyV2(new Picker$configSelectedPreviewStyle$2$1$2(r0));
        Picker r4 = (Picker) attachSelectedCustomView(r0);
        return;
    }

    private final void initOrganizationFragment(AddressBookConfig r6) {
        final int r0 = 0;
        attachDisableChatter(false);
        attachAddChatterFromChatAndDepartment(r6.isDepartmentSelectable());
        if (r6.getDepartmentSelectableScene() != DepartmentSelectableScene.ALL_DEPARTMENT) goto L5;
        boolean r1 = true;
    L6:
        attachIsDepartmentSelectableWhenVisible(r1);
        attachHasEnterpriseEmail(r6.getNeedEnterpriseEmail());
        attachPermissions(r6.getPermissions().getChatterOUPermissions());
        UserGroupVisibility r2 = r6.getUserGroupVisibility();
        if ((r2 instanceof UserGroupVisibility.Visible) == false) goto L9;
        UserGroupScene r3 = ((UserGroupVisibility.Visible) r2).getScene();
    L10:
        attachUserGroup(r3);
        initOrganizationFragment(Long.valueOf(this.pickerInitTime), this.pickerTracker);
        Sequence r7 = MapsKt.asSequence(r6.getEntriesVisibility$picker_release());
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L17;
        Object r9 = r8.next();
        if (((Boolean) ((Map.Entry) r9).getValue()).booleanValue() == true) goto L15;
        r5.add(r9);
        goto L12
    L15:
        r4.add(r9);
        goto L12
    L17:
        Pair r10 = new Pair(r4, r5);
        Iterator r11 = ((Iterable) r10.getFirst()).iterator();
        final int r12 = 0;
    L19:
        if (r11.hasNext() == false) goto L21;
        r12 = r12 | ((Number) ((Map.Entry) r11.next()).getKey()).intValue();
        goto L19
    L21:
        Iterator r13 = ((Iterable) r10.getSecond()).iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        r0 = r0 | ((Number) ((Map.Entry) r13.next()).getKey()).intValue();
        goto L23
    L25:
        post(new Picker$initOrganizationFragment$3$1(this, r12, r0));
        initOrgItemConsumer(3);
        return;
    L9:
        r3 = UserGroupScene.NONE;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private final void initRecommendListView(final RecommendListConfig r9) {
        final DefaultRecommendView r0 = new DefaultRecommendView(getContext());
        r0.grayTitleColor();
        r0.setBackgroundColor(r0.getResources().getColor(2131100548));
        this.recommendListView = r0;
        getMDefaultViewContainer().removeAllViews();
        getMDefaultViewContainer().addView(r0);
        r0.setRecommendEmptyViewConfig(this.recommendEmptyIconResId, this.recommendEmptyHintText);
        r0.erasePadding();
        r0.setEnableNoMoreFooter(r9.getEnableNoMoreFooter$picker_release());
        r0.setOnBusinessConsumeItem(getItemConsumeDelegate());
        r0.setDataPuller(new Picker$initRecommendListView$1$1(this, r9, r0));
        r0.setProfileClickListener(new Picker$initRecommendListView$1$2(this));
        r0.setClickHandler(new Picker$initRecommendListView$1$3(this));
        PickerConfig r10 = this.config;
        if (r10 == null) goto L15;
        PickerExtra r11 = r10.getExtra$picker_release();
        if (r11 == null) goto L15;
        r0.switchMultiple(r11.isMultiSelect());
        r0.setEnableChatPreview(r11.isEnableChatPreview());
        r0.setScene(r11.getScene());
        r0.setOnBusinessConsumeItem(r11.getItemConsumer());
        r0.setDisableRightViewHolder(r11.getDisableRightViewHolder());
        ICustomBinder r1 = r11.getCustomBinder();
        if (r1 == null) goto L9;
        r0.setCustomBinder(r1);
    L9:
        List<ICustomViewTypeResolver> r2 = r11.getCustomViewTypeResolvers();
        if (r2 == null) goto L12;
        setCustomViewTypeResolvers(r2);
    L12:
        Map<Integer, CommonBinder<?>> r12 = r11.getCustomBinders();
        if (r12 == null) goto L15;
        r0.registerCustomBinders(r12);
    L15:
        r0.setAllowEmpty(true);
        addReloadListener(new Picker$initRecommendListView$1$5(r0));
        addSelectModeChangeListener(new Picker$initRecommendListView$1$6(r0));
        DefaultRecommendView.refresh$default(r0, false, true, true, true, true, 1, null);
    }

    private final void initScenarioEntriesView(ScenarioConfig r5) {
        ScenarioSelectionDelegate r0 = new Picker$initScenarioEntriesView$delegate$1(this);
        ScenarioEntriesFragment r1 = new ScenarioEntriesFragment();
        r1.setShowPersonnelTypeEntry(r5.getShowPersonnelTypeEntry());
        r1.setShowPermissionGroupEntry(r5.getShowPermissionGroupEntry());
        r1.setOnPersonnelTypeClick(new Picker$initScenarioEntriesView$entriesFragment$1$1(this));
        r1.setOnPermissionGroupClick(new Picker$initScenarioEntriesView$entriesFragment$1$2(this));
        PersonnelTypeListFragment r2 = new PersonnelTypeListFragment();
        r2.setSelectionDelegate(r0);
        PermissionGroupListFragment r3 = new PermissionGroupListFragment();
        r3.setSelectionDelegate(r0);
        attachScenarioFragments(r1, r2, r3);
        loadScenarioEntriesData(r5, r2, r3);
        showScenarioEntries();
    }

    private final void removeReloadListener(IReloadListener r2) {
        this.reloadListeners.remove(r2);
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(final PickerConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Log.i(TAG, "config: " + ConfigSerializationKt.serialize(r4));
        this.config = r4;
        getViewModel().setConfigDelegate(new C03171(r4));
        SearcherConfig r0 = r4.getSearcherConfig$picker_release();
        if (r0 == null) goto L7;
        TopExtra r1 = r0.getExtra();
        if (r1 == null) goto L7;
        r1.setSpotlightTag(this.pickerScene.getValue());
    L7:
        setMSearchLifecycleObserver(getViewModel().getSearcher());
        if (spotLightSupportable(null) == false) goto L10;
        Log.i(TAG, "spotlight searcher init");
        setMSearchLifecycleObserver4Spotlight(getViewModel().getSpotlightSearcher());
    L10:
        attachOnPickerParamsLoader(new AnonymousClass2(this, r4));
        setPickerV2(true);
        setClearWhenSingleSelect(false);
        configDependency();
        configStatistics();
        configSelect();
        configCustomView();
        configOthers();
        configInputView();
        configRecommendView();
        configResultView();
        attachComplete(false);
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public void initialSearch(String r3) {
        Intrinsics.checkNotNullParameter(r3, "queryKey");
        getViewModel().setConfigDelegate(new C03181(this));
        super.initialSearch(r3);
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public void onSearchHistoryRecordNeeded(SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "baseInfo");
        PickerConfig r0 = this.config;
        boolean r1 = false;
        if (r0 == null) goto L9;
        PickerExtra r2 = r0.getExtra$picker_release();
        if (r2 == null) goto L9;
        if (r2.getEnableSearchHistory() != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L15;
        SearchHistoryPlugin r3 = new SearchHistoryPlugin();
        Context r4 = getContext();
        String r6 = r5.getTitle();
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r3.updateSearchHistory(r4, new SearchHistoryPlugin.SearchHistoryBean(r6, r5.getId()));
        return;
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public void onSearchSuccess(List<SearchBaseInfo> r12) {
        Intrinsics.checkNotNullParameter(r12, "infoList");
        super.onSearchSuccess(r12);
        PickerConfig r0 = this.config;
        int r1 = 0;
        if (r0 == null) goto L20;
        SearcherConfig r2 = r0.getSearcherConfig$picker_release();
        if (r2 == null) goto L20;
        Map<KClass<?>, Entity<?, ?, ?>> r3 = r2.getEntities();
        if (r3 == null) goto L20;
        Entity<?, ?, ?> r4 = r3.get(Reflection.getOrCreateKotlinClass(Chatter.class));
        if (r4 == null) goto L20;
        if ((r4 instanceof Chatter) == false) goto L13;
        Chatter r5 = (Chatter) r4;
    L14:
        if (r5 == null) goto L20;
        ChatterExtra r6 = r5.getExtra();
        if (r6 == null) goto L20;
        if (r6.getAppendUserTeam() != true) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == true) goto L23;
        return;
    L23:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r12.iterator();
    L25:
        if (r9.hasNext() == false) goto L42;
        Object r10 = r9.next();
        int r11 = r1 + 1;
        if (r1 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        SearchChatterInfo r13 = (SearchBaseInfo) r10;
        if ((r13 instanceof SearchChatterInfo) == false) goto L41;
        if ((r13 instanceof SearchUserTeamInfo) == true) goto L41;
        Integer r14 = Integer.valueOf(r1);
        SearchUserTeamInfo.a r15 = SearchUserTeamInfo.Companion;
        SearchChatterInfo r16 = r13;
        String r17 = UIHelper.getString(2131890302);
        String r18 = r16.getTitle();
        String r19 = "";
        if (r18 != null) goto L36;
        r18 = "";
    L36:
        String r20 = ICUUtils.icuFormat(r17, AppbrandHostConstants.Schema_Meta.NAME, r18);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "chatter");
        Intrinsics.checkNotNullParameter(r20, "teamTitle");
        SearchUserTeamInfo r21 = new SearchUserTeamInfo();
        String r22 = r16.getId();
        if (r22 == null) goto L40;
        r19 = r22;
    L40:
        r21.setOriginChatterId(r19);
        r21.setId("team_" + r16.getId());
        r21.setTitle(r20);
        r21.setSubTitle(r16.getSubTitle());
        r21.setAvatarKey(r16.getAvatarKey());
        r21.setAvatarUrl(r16.getAvatarUrl());
        r21.setTitleTagList(r16.getTitleTagList());
        r21.setSubTitleTagList(r16.getSubTitleTagList());
        r8.add(TuplesKt.to(r14, r21));
    L41:
        r1 = r11;
        goto L25
    L42:
        Iterator r23 = CollectionsKt.asReversedMutable(r8).iterator();
    L44:
        if (r23.hasNext() == false) goto L46;
        Pair r24 = (Pair) r23.next();
        ListProtector.add(r12, ((Number) r24.component1()).intValue() + 1, (SearchUserTeamInfo) r24.component2());
        goto L44
    L46:
        return;
    L13:
        r5 = null;
    L20:
        r7 = false;
        goto L21
    }

    public final void scene(PickerStatistics.Scene r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.pickerScene = r3;
        this.pickerTracker = new PickerTracker(PickerStatistics.INSTANCE.getBizByScene(r3), r3.getValue());
    }

    @Override // com.ss.android.lark.picker.base.widget.AbsChatterPicker
    public boolean spotLightSupportable(ChatterPickerParams r4) {
        if (FG.enable$default(FG.FG_SPOTLIGHT, false, 2, null) == false) goto L17;
        PickerConfig r5 = this.config;
        if (r5 == null) goto L13;
        SearcherConfig r6 = r5.getSearcherConfig$picker_release();
        if (r6 == null) goto L13;
        TopExtra r7 = r6.getExtra();
        if (r7 == null) goto L13;
        if (r7.getEnableSpotlight() != true) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        r8 = false;
        goto L14
    L17:
        return false;
    }

    @Override // com.ss.android.lark.picker.IPicker
    public /* bridge */ /* synthetic */ void init(PickerConfig r1) {
        init2(r1);
    }

    @Override // com.ss.android.lark.picker.base.widget.AbsChatterPicker, com.ss.android.lark.picker.base.widget.BasePicker
    public /* bridge */ /* synthetic */ boolean spotLightSupportable(BasePickerParams r1) {
        return spotLightSupportable((ChatterPickerParams) r1);
    }

    public Picker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.pickerScene = PickerStatistics.Scene.Unknown;
        this.reloadListeners = new ArrayList();
        this.pickerInitTime = SystemClock.elapsedRealtime();
        this.pickerRecommendRequestId = "";
        this.plugins = CollectionsKt.mutableListOf(new PickerPlugin[]{new SearchHistoryPlugin()});
        this.viewModel$delegate = LazyKt.lazy(new Picker$viewModel$2(this));
    }

    public static final /* synthetic */ void access$setPickerRecommendRequestId$p(Picker r0, String r1) {
        r0.pickerRecommendRequestId = r1;
    }

    public final void attachRecommendEmptyViewConfig(Integer r1, CharSequence r2) {
        this.recommendEmptyIconResId = r1;
        this.recommendEmptyHintText = r2;
    }

    @Override // com.ss.android.lark.picker.IPicker
    public void reload(boolean r3, boolean r4) {
        if (r3 == true) goto L4;
    L6:
        Iterator<T> r0 = this.reloadListeners.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ((IReloadListener) r0.next()).onReload(r3, r4);
        goto L8
    L10:
        return;
    L4:
        if ((!StringsKt.isBlank(getMSearchQuery())) == false) goto L6;
        search();
        goto L6
    }

    private final void loadScenarioEntriesData(ScenarioConfig r3, final PersonnelTypeListFragment r4, final PermissionGroupListFragment r5) {
        if (r3.getShowPersonnelTypeEntry() == false) goto L6;
        ScenarioDataPuller.INSTANCE.loadPersonnelTypes(new C03191(this, r4));
    L6:
        if (r3.getShowPermissionGroupEntry() == false) goto L9;
        ScenarioDataPuller.INSTANCE.loadPermissionGroups(new C03202(this, r5));
        return;
    }

    public static final /* synthetic */ void access$dealSelectAndDeselected(Picker r0, SearchBaseInfo r1, boolean r2, BasePicker.PickSourceType r3) {
        r0.dealSelectAndDeselected(r1, r2, r3);
    }

    public static /* synthetic */ void attachRecommendEmptyViewConfig$default(Picker r1, Integer r2, CharSequence r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.attachRecommendEmptyViewConfig(r2, r3);
    }
}
