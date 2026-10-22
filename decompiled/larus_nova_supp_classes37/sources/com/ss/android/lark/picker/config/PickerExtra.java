package com.ss.android.lark.picker.config;

import android.view.View;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.binder.CommonBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomViewTypeResolver;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridgeFactory;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.constants.PickerUseCategory;
import com.ss.android.lark.picker.base.widget.constants.PickerUsePage;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterDelegate;
import com.ss.android.lark.picker.extra.SelectedPreviewStyle;
import com.ss.android.lark.search.dto.EntityType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001a\u0010%\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010(\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001a\u0010*\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR\u001c\u0010Z\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010T\"\u0004\b\\\u0010VR\u001c\u0010]\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010T\"\u0004\b_\u0010VR\u001c\u0010`\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010T\"\u0004\bb\u0010VR\u001c\u0010c\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010T\"\u0004\be\u0010VR\u001c\u0010f\u001a\u0004\u0018\u00010gX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR,\u0010l\u001a\u0014\u0012\u0004\u0012\u00020n\u0012\b\u0012\u0006\u0012\u0002\b\u00030o\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010t\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001d\u0010{\u001a\u0004\u0018\u00010|X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\"\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R(\u0010\u0087\u0001\u001a\r\u0012\u0007\b\u0001\u0012\u00030\u0088\u0001\u0018\u00010uX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010x\"\u0005\b\u008a\u0001\u0010zR5\u0010\u008b\u0001\u001a\u001a\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001\u0018\u00010uX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010x\"\u0005\b\u008f\u0001\u0010zR%\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010uX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010x\"\u0005\b\u0092\u0001\u0010zR\u001d\u0010\u0093\u0001\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u001b\"\u0005\b\u0094\u0001\u0010\u001dR\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001d\u0010\u009b\u0001\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0013\"\u0005\b\u009d\u0001\u0010\u0015R\u001d\u0010\u009e\u0001\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010\u001b\"\u0005\b \u0001\u0010\u001dR\u001d\u0010¡\u0001\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u001b\"\u0005\b£\u0001\u0010\u001dR\u001f\u0010¤\u0001\u001a\u00020nX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001¨\u0006©\u0001"}, d2 = {"Lcom/ss/android/lark/picker/config/PickerExtra;", "", "<init>", "()V", "page", "Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;", "getPage", "()Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;", "setPage", "(Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;)V", "category", "Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;", "getCategory", "()Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;", "setCategory", "(Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;)V", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "searchHint", "getSearchHint", "setSearchHint", "isEnableAutoPopupKeyboard", "", "()Z", "setEnableAutoPopupKeyboard", "(Z)V", "isMultiSelect", "setMultiSelect", "isEnableChatPreview", "setEnableChatPreview", "disableRightViewHolder", "getDisableRightViewHolder", "setDisableRightViewHolder", "forceRefreshResultNotifyDataSetChanged", "getForceRefreshResultNotifyDataSetChanged", "setForceRefreshResultNotifyDataSetChanged", "isEnableCancelBtn", "setEnableCancelBtn", "enableAutoFocus", "getEnableAutoFocus", "setEnableAutoFocus", "onPickListener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotify;", "getOnPickListener", "()Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotify;", "setOnPickListener", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotify;)V", "onPickListenerV2", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotifyV2;", "getOnPickListenerV2", "()Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotifyV2;", "setOnPickListenerV2", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotifyV2;)V", "onCancelListener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnCancelListener;", "getOnCancelListener", "()Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnCancelListener;", "setOnCancelListener", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnCancelListener;)V", "onSelectModeChangeListener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnSelectModeChangeListener;", "getOnSelectModeChangeListener", "()Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnSelectModeChangeListener;", "setOnSelectModeChangeListener", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnSelectModeChangeListener;)V", "onFocusListener", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusListener", "()Landroid/view/View$OnFocusChangeListener;", "setOnFocusListener", "(Landroid/view/View$OnFocusChangeListener;)V", "selectedPreviewStyle", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "getSelectedPreviewStyle", "()Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "setSelectedPreviewStyle", "(Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;)V", "customSelectedPreviewView", "Landroid/view/View;", "getCustomSelectedPreviewView", "()Landroid/view/View;", "setCustomSelectedPreviewView", "(Landroid/view/View;)V", "customHeaderView", "getCustomHeaderView", "setCustomHeaderView", "customTopView", "getCustomTopView", "setCustomTopView", "customCenterView", "getCustomCenterView", "setCustomCenterView", "customResultHeaderView", "getCustomResultHeaderView", "setCustomResultHeaderView", "customRecommendView", "getCustomRecommendView", "setCustomRecommendView", "customBinder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "getCustomBinder", "()Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "setCustomBinder", "(Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;)V", "customBinders", "", "", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "getCustomBinders", "()Ljava/util/Map;", "setCustomBinders", "(Ljava/util/Map;)V", "customViewTypeResolvers", "", "Lcom/ss/android/lark/picker/base/view/binder/ICustomViewTypeResolver;", "getCustomViewTypeResolvers", "()Ljava/util/List;", "setCustomViewTypeResolvers", "(Ljava/util/List;)V", "itemViewBridgeFactory", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;", "getItemViewBridgeFactory", "()Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;", "setItemViewBridgeFactory", "(Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;)V", "itemConsumer", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "getItemConsumer", "()Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "setItemConsumer", "(Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;)V", "preSelectedItems", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getPreSelectedItems", "setPreSelectedItems", "preSelectedIds", "Lkotlin/Pair;", "Lcom/ss/android/lark/search/dto/EntityType;", "getPreSelectedIds", "setPreSelectedIds", "requiredList", "getRequiredList", "setRequiredList", "isEnableLightStyleOfChatCount", "setEnableLightStyleOfChatCount", "delegateReporter", "Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterDelegate;", "getDelegateReporter", "()Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterDelegate;", "setDelegateReporter", "(Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterDelegate;)V", "initDepartmentId", "getInitDepartmentId", "setInitDepartmentId", "enableSearchHistory", "getEnableSearchHistory", "setEnableSearchHistory", "shouldShowSelectedView", "getShouldShowSelectedView", "setShouldShowSelectedView", "maxSelectCount", "getMaxSelectCount", "()I", "setMaxSelectCount", "(I)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerExtra {
    private PickerUseCategory category;
    private transient ICustomBinder customBinder;
    private transient Map<Integer, ? extends CommonBinder<?>> customBinders;
    private transient View customCenterView;
    private transient View customHeaderView;
    private transient View customRecommendView;
    private transient View customResultHeaderView;
    private transient View customSelectedPreviewView;
    private transient View customTopView;
    private transient List<? extends ICustomViewTypeResolver> customViewTypeResolvers;
    private transient PickerReporterDelegate delegateReporter;
    private boolean disableRightViewHolder;
    private boolean enableAutoFocus;
    private boolean enableSearchHistory;
    private boolean forceRefreshResultNotifyDataSetChanged;
    private String initDepartmentId;
    private boolean isEnableAutoPopupKeyboard;
    private boolean isEnableCancelBtn;
    private boolean isEnableChatPreview;
    private boolean isEnableLightStyleOfChatCount;
    private boolean isMultiSelect;
    private transient SearchResultView.IOnBusinessConsumeItem itemConsumer;
    private transient IItemViewBridgeFactory itemViewBridgeFactory;
    private int maxSelectCount;
    private transient BasePicker.IOnCancelListener onCancelListener;
    private transient View.OnFocusChangeListener onFocusListener;
    private transient BasePicker.IOnPickNotify onPickListener;
    private transient BasePicker.IOnPickNotifyV2 onPickListenerV2;
    private transient BasePicker.IOnSelectModeChangeListener onSelectModeChangeListener;
    private PickerUsePage page;
    private transient List<? extends Pair<String, ? extends EntityType>> preSelectedIds;
    private transient List<? extends SearchBaseInfo> preSelectedItems;
    private List<String> requiredList;
    private String scene;
    private String searchHint;
    private SelectedPreviewStyle selectedPreviewStyle;
    private boolean shouldShowSelectedView;

    public PickerExtra() {
        this.page = PickerUsePage.UNKNOWN;
        this.category = PickerUseCategory.UNKNOWN;
        this.scene = PickerReporterConstants.VALUE.SCENE.OTHERS;
        this.disableRightViewHolder = true;
        this.enableAutoFocus = true;
        this.selectedPreviewStyle = SelectedPreviewStyle.PreviewList.INSTANCE;
        this.initDepartmentId = "";
        this.shouldShowSelectedView = true;
    }

    public final PickerUseCategory getCategory() {
        return this.category;
    }

    public final ICustomBinder getCustomBinder() {
        return this.customBinder;
    }

    public final Map<Integer, CommonBinder<?>> getCustomBinders() {
        return this.customBinders;
    }

    public final View getCustomCenterView() {
        return this.customCenterView;
    }

    public final View getCustomHeaderView() {
        return this.customHeaderView;
    }

    public final View getCustomRecommendView() {
        return this.customRecommendView;
    }

    public final View getCustomResultHeaderView() {
        return this.customResultHeaderView;
    }

    public final View getCustomSelectedPreviewView() {
        return this.customSelectedPreviewView;
    }

    public final View getCustomTopView() {
        return this.customTopView;
    }

    public final List<ICustomViewTypeResolver> getCustomViewTypeResolvers() {
        return this.customViewTypeResolvers;
    }

    public final PickerReporterDelegate getDelegateReporter() {
        return this.delegateReporter;
    }

    public final boolean getDisableRightViewHolder() {
        return this.disableRightViewHolder;
    }

    public final boolean getEnableAutoFocus() {
        return this.enableAutoFocus;
    }

    public final boolean getEnableSearchHistory() {
        return this.enableSearchHistory;
    }

    public final boolean getForceRefreshResultNotifyDataSetChanged() {
        return this.forceRefreshResultNotifyDataSetChanged;
    }

    public final String getInitDepartmentId() {
        return this.initDepartmentId;
    }

    public final SearchResultView.IOnBusinessConsumeItem getItemConsumer() {
        return this.itemConsumer;
    }

    public final IItemViewBridgeFactory getItemViewBridgeFactory() {
        return this.itemViewBridgeFactory;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final BasePicker.IOnCancelListener getOnCancelListener() {
        return this.onCancelListener;
    }

    public final View.OnFocusChangeListener getOnFocusListener() {
        return this.onFocusListener;
    }

    public final BasePicker.IOnPickNotify getOnPickListener() {
        return this.onPickListener;
    }

    public final BasePicker.IOnPickNotifyV2 getOnPickListenerV2() {
        return this.onPickListenerV2;
    }

    public final BasePicker.IOnSelectModeChangeListener getOnSelectModeChangeListener() {
        return this.onSelectModeChangeListener;
    }

    public final PickerUsePage getPage() {
        return this.page;
    }

    public final List<Pair<String, EntityType>> getPreSelectedIds() {
        return this.preSelectedIds;
    }

    public final List<SearchBaseInfo> getPreSelectedItems() {
        return this.preSelectedItems;
    }

    public final List<String> getRequiredList() {
        return this.requiredList;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final SelectedPreviewStyle getSelectedPreviewStyle() {
        return this.selectedPreviewStyle;
    }

    public final boolean getShouldShowSelectedView() {
        return this.shouldShowSelectedView;
    }

    public final boolean isEnableAutoPopupKeyboard() {
        return this.isEnableAutoPopupKeyboard;
    }

    public final boolean isEnableCancelBtn() {
        return this.isEnableCancelBtn;
    }

    public final boolean isEnableChatPreview() {
        return this.isEnableChatPreview;
    }

    public final boolean isEnableLightStyleOfChatCount() {
        return this.isEnableLightStyleOfChatCount;
    }

    public final boolean isMultiSelect() {
        return this.isMultiSelect;
    }

    public final void setCategory(PickerUseCategory r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.category = r2;
    }

    public final void setCustomBinder(ICustomBinder r1) {
        this.customBinder = r1;
    }

    public final void setCustomBinders(Map<Integer, ? extends CommonBinder<?>> r1) {
        this.customBinders = r1;
    }

    public final void setCustomCenterView(View r1) {
        this.customCenterView = r1;
    }

    public final void setCustomHeaderView(View r1) {
        this.customHeaderView = r1;
    }

    public final void setCustomRecommendView(View r1) {
        this.customRecommendView = r1;
    }

    public final void setCustomResultHeaderView(View r1) {
        this.customResultHeaderView = r1;
    }

    public final void setCustomSelectedPreviewView(View r1) {
        this.customSelectedPreviewView = r1;
    }

    public final void setCustomTopView(View r1) {
        this.customTopView = r1;
    }

    public final void setCustomViewTypeResolvers(List<? extends ICustomViewTypeResolver> r1) {
        this.customViewTypeResolvers = r1;
    }

    public final void setDelegateReporter(PickerReporterDelegate r1) {
        this.delegateReporter = r1;
    }

    public final void setDisableRightViewHolder(boolean r1) {
        this.disableRightViewHolder = r1;
    }

    public final void setEnableAutoFocus(boolean r1) {
        this.enableAutoFocus = r1;
    }

    public final void setEnableAutoPopupKeyboard(boolean r1) {
        this.isEnableAutoPopupKeyboard = r1;
    }

    public final void setEnableCancelBtn(boolean r1) {
        this.isEnableCancelBtn = r1;
    }

    public final void setEnableChatPreview(boolean r1) {
        this.isEnableChatPreview = r1;
    }

    public final void setEnableLightStyleOfChatCount(boolean r1) {
        this.isEnableLightStyleOfChatCount = r1;
    }

    public final void setEnableSearchHistory(boolean r1) {
        this.enableSearchHistory = r1;
    }

    public final void setForceRefreshResultNotifyDataSetChanged(boolean r1) {
        this.forceRefreshResultNotifyDataSetChanged = r1;
    }

    public final void setInitDepartmentId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.initDepartmentId = r2;
    }

    public final void setItemConsumer(SearchResultView.IOnBusinessConsumeItem r1) {
        this.itemConsumer = r1;
    }

    public final void setItemViewBridgeFactory(IItemViewBridgeFactory r1) {
        this.itemViewBridgeFactory = r1;
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }

    public final void setMultiSelect(boolean r1) {
        this.isMultiSelect = r1;
    }

    public final void setOnCancelListener(BasePicker.IOnCancelListener r1) {
        this.onCancelListener = r1;
    }

    public final void setOnFocusListener(View.OnFocusChangeListener r1) {
        this.onFocusListener = r1;
    }

    public final void setOnPickListener(BasePicker.IOnPickNotify r1) {
        this.onPickListener = r1;
    }

    public final void setOnPickListenerV2(BasePicker.IOnPickNotifyV2 r1) {
        this.onPickListenerV2 = r1;
    }

    public final void setOnSelectModeChangeListener(BasePicker.IOnSelectModeChangeListener r1) {
        this.onSelectModeChangeListener = r1;
    }

    public final void setPage(PickerUsePage r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.page = r2;
    }

    public final void setPreSelectedIds(List<? extends Pair<String, ? extends EntityType>> r1) {
        this.preSelectedIds = r1;
    }

    public final void setPreSelectedItems(List<? extends SearchBaseInfo> r1) {
        this.preSelectedItems = r1;
    }

    public final void setRequiredList(List<String> r1) {
        this.requiredList = r1;
    }

    public final void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    public final void setSearchHint(String r1) {
        this.searchHint = r1;
    }

    public final void setSelectedPreviewStyle(SelectedPreviewStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectedPreviewStyle = r2;
    }

    public final void setShouldShowSelectedView(boolean r1) {
        this.shouldShowSelectedView = r1;
    }
}
