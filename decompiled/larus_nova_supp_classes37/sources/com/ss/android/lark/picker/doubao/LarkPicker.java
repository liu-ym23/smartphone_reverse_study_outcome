package com.ss.android.lark.picker.doubao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.CustomSearchResultItem;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.picker.config.AddressBookConfig;
import com.ss.android.lark.picker.config.DoubaoConfig;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.NavigationConfig;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterProvider;
import com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationItemState;
import com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView;
import com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher;
import com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoPickerCommonItemViewBridgeFactory;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import ktb.b;
import ktb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 z2\u00020\u0001:\u0001zB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u00104\u001a\u00020/2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010AJ\u0006\u0010B\u001a\u00020/J\u000e\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u0011J#\u0010H\u001a\u00020/2\n\b\u0003\u0010I\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020\u0011J\u0016\u0010O\u001a\u00020/2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010QJ\u000e\u0010R\u001a\u00020/2\u0006\u0010S\u001a\u00020\u0011J\u0018\u0010T\u001a\u00020/2\u0006\u0010U\u001a\u00020\u00112\b\b\u0002\u0010V\u001a\u00020\u0011J\u0006\u0010W\u001a\u00020/J\u0006\u0010X\u001a\u00020\u0011J\u0006\u0010Y\u001a\u00020/J\u0018\u0010Z\u001a\u00020/2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\b\u0010[\u001a\u00020/H\u0002J\u0010\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020'H\u0002J\u0018\u0010^\u001a\u00020/2\u0006\u0010_\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\"H\u0002J\b\u0010a\u001a\u00020/H\u0002J\b\u0010b\u001a\u00020/H\u0002J\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020.H\u0002J\b\u0010f\u001a\u00020/H\u0002J\u0018\u0010g\u001a\u00020/2\u0006\u0010e\u001a\u00020.2\u0006\u0010h\u001a\u00020\u0011H\u0002J\b\u0010i\u001a\u00020/H\u0002J\u0018\u0010j\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010k\u001a\u00020%H\u0002J\u0010\u0010l\u001a\u00020/2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020/2\u0006\u0010p\u001a\u00020.H\u0002J\u0018\u0010q\u001a\u00020\"2\u0006\u0010r\u001a\u00020\"2\u0006\u0010k\u001a\u00020%H\u0002J\b\u0010s\u001a\u00020/H\u0002J\b\u0010t\u001a\u00020/H\u0002J\u0012\u0010u\u001a\u00020/2\b\b\u0001\u0010v\u001a\u00020%H\u0002J\u0010\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020xH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006{"}, d2 = {"Lcom/ss/android/lark/picker/doubao/LarkPicker;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "picker", "Lcom/ss/android/lark/picker/Picker;", "contentContainer", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "bottomBarContainer", "imePlaceholder", "Landroid/view/View;", "hasSelected", "", "selectedText", "Landroid/widget/TextView;", "bottomBarActionButton", "selectedAvatarList", "Landroidx/recyclerview/widget/RecyclerView;", "selectedAvatarAdapter", "Lcom/ss/android/lark/picker/doubao/LarkPickerSelectedAvatarAdapter;", "organizationPickerView", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView;", "organizationEntryView", "organizationSearchWatcher", "Landroid/text/TextWatcher;", "doubaoConfig", "Lcom/ss/android/lark/picker/config/DoubaoConfig;", "configuredRequiredIds", "", "", "selectedItemIdsByType", "", "", "configuredNavigation", "Lcom/ss/android/lark/picker/config/NavigationConfig;", "isDepartmentSelectable", "isOrganizationEnabled", "chatterTagEnricher", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;", "onItemClickListener", "Lkotlin/Function1;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "init", "activity", "Landroidx/fragment/app/FragmentActivity;", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "setCustomBinder", "binder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "attachCustomSearchResultItem", "customItem", "Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "attachSearchResultAdapter", "adapter", "Lcom/ss/android/lark/picker/base/widget/SearchResultAdapter;", "clearCustomSearchResultItems", "setPickModeChangeListener", "listener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickModeChangeListener;", "setConsumeResultLayoutClickWhenEmpty", "consume", "attachRecommendEmptyViewConfig", "emptyIconResId", "emptyHintText", "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "resetFocus", "needResetKeyboardNavigation", "resetSelectedData", "selected", "", "defaultMode", "withAnimation", "switchMultipleStatus", "multiple", "isForce", "clearInputViewFocus", "onBackPressed", "destroy", "injectInternalBinderAndResolver", "applyConfiguredTitleBar", "configureTitleBar", "navigation", "updateOrganizationTitle", "showing", "organizationTitle", "attachOrganizationEntry", "dismissSearchKeyboard", "resolveOrganizationItemState", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "info", "refreshOrganizationSelection", "handleOrganizationItemClick", "shouldSelect", "attachConfiguredBottomBar", "updateBottomBar", "selectedCount", "updateSelectedAvatarList", "config", "Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "onSelectedAvatarClick", "item", "formatSelectedCountHintTemplate", "template", "setupWindowInsetsListener", "requestApplyInsetsWhenAttached", "applyTitleBarLeftIcon", "iconRes", "dp2px", "", "dp", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LarkPicker extends FrameLayout {
    public static final Companion Companion = null;
    private static final float SEARCH_BAR_TEXT_SIZE_SP = 17.0f;
    private static final float SEARCH_ICON_SIZE_DP = 20.0f;
    public static final String TAG = "DoubaoPicker";
    private static final float TOP_CORNER_RADIUS_DP = 24.0f;
    private TextView bottomBarActionButton;
    private final FrameLayout bottomBarContainer;
    private DoubaoChatterTagEnricher chatterTagEnricher;
    private NavigationConfig configuredNavigation;
    private Set<String> configuredRequiredIds;
    private final FrameLayout contentContainer;
    private DoubaoConfig doubaoConfig;
    private boolean hasSelected;
    private final View imePlaceholder;
    private boolean isDepartmentSelectable;
    private boolean isOrganizationEnabled;
    private Function1<? super SearchBaseInfo, Unit> onItemClickListener;
    private View organizationEntryView;
    private DoubaoOrganizationPickerView organizationPickerView;
    private TextWatcher organizationSearchWatcher;
    private final Picker picker;
    private LarkPickerSelectedAvatarAdapter selectedAvatarAdapter;
    private RecyclerView selectedAvatarList;
    private Map<Integer, ? extends Set<String>> selectedItemIdsByType;
    private TextView selectedText;
    private final CommonTitleBar titleBar;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/doubao/LarkPicker$Companion;", "", "<init>", "()V", "TAG", "", "TOP_CORNER_RADIUS_DP", "", "SEARCH_BAR_TEXT_SIZE_SP", "SEARCH_ICON_SIZE_DP", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void applyConfiguredTitleBar() {
        NavigationConfig r0 = this.configuredNavigation;
        if (r0 != null) goto L6;
        this.titleBar.setVisibility(8);
        return;
    L6:
        configureTitleBar(r0);
        boolean r2 = false;
        this.titleBar.setVisibility(0);
        CommonTitleBar r1 = this.titleBar;
        String r3 = r0.getTitle();
        if (r3 != null) goto L9;
    L10:
        r2 = true;
    L11:
        if (r2 == false) goto L14;
        r3 = null;
    L14:
        if (r3 != null) goto L16;
        r3 = UIHelper.getString(2131892188);
    L16:
        r1.setTitle(r3);
        return;
    L9:
        if (r3.length() != 0) goto L11;
        goto L10
    }

    private final void attachConfiguredBottomBar() {
        DoubaoConfig.BottomBarConfig r0 = this.doubaoConfig.getBottomBarConfig();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r4 = false;
        View r1 = LayoutInflater.from(getContext()).inflate(2131563354, this.bottomBarContainer, false);
        this.bottomBarContainer.removeAllViews();
        this.bottomBarContainer.addView(r1);
        RecyclerView r2 = r1.findViewById(2131362385);
        if (r0.getShowSelectedAvatarList() == false) goto L8;
        r2.setLayoutManager(new LinearLayoutManager(r2.getContext(), 0, false));
        r2.setItemAnimator(null);
        LarkPickerSelectedAvatarAdapter r3 = new LarkPickerSelectedAvatarAdapter(new LarkPicker$attachConfiguredBottomBar$1$1(this));
        r2.setAdapter(r3);
        this.selectedAvatarAdapter = r3;
    L9:
        this.selectedAvatarList = r2;
        TextView r5 = (TextView) r1.findViewById(2131362386);
        this.selectedText = r5;
        if (r5 == null) goto L12;
        r5.setClickable(false);
    L12:
        TextView r6 = this.selectedText;
        if (r6 == null) goto L15;
        r6.setFocusable(false);
    L15:
        TextView r7 = (TextView) r1.findViewById(2131362382);
        this.bottomBarActionButton = r7;
        if (r7 == null) goto L18;
        r7.setOnClickListener(new AnonymousClass2(this));
    L18:
        setupWindowInsetsListener();
        requestApplyInsetsWhenAttached();
        int r8 = this.picker.getSelectedList().size();
        if (r8 <= 0) goto L21;
        r4 = true;
    L21:
        this.hasSelected = r4;
        updateBottomBar(r4, r8);
        return;
    L8:
        r2.setVisibility(8);
        goto L9
    }

    private final void attachOrganizationEntry() {
        if (this.organizationEntryView == null) goto L5;
        return;
    L5:
        c r0 = (c) PluginServiceLoader.loadFirstOrNull(c.class);
        if (r0 != null) goto L8;
        return;
    L8:
        final String r4 = UIHelper.getString(2131892268);
        View r1 = LayoutInflater.from(getContext()).inflate(2131568163, this.picker, false);
        ((TextView) r1.findViewById(2131381667)).setText(r4);
        final DoubaoOrganizationPickerView r14 = new DoubaoOrganizationPickerView(getContext(), null, 2, null);
        b r3 = r0.getContactOpenRepository();
        Intrinsics.checkNotNull(r4);
        r14.bind(r3, r4, UIHelper.getString(2131891629), UIHelper.getString(2131889979), this.isDepartmentSelectable, this.picker.isMultipleSelect(), new LarkPicker$attachOrganizationEntry$organizationView$1$1(this), new LarkPicker$attachOrganizationEntry$organizationView$1$2(this), new LarkPicker$attachOrganizationEntry$organizationView$1$3(this, r4), new LarkPicker$attachOrganizationEntry$organizationView$1$4(this));
        this.contentContainer.addView(r14, new FrameLayout.LayoutParams(-1, -1));
        TextWatcher r2 = new LarkPicker$attachOrganizationEntry$watcher$1(r14);
        this.picker.getSearchInputView().getInputEditText().addTextChangedListener(r2);
        this.organizationSearchWatcher = r2;
        r1.setOnClickListener(new AnonymousClass1(this, r14));
        Picker r5 = this.picker;
        Intrinsics.checkNotNull(r1);
        r5.attachTopCustomView(r1, false);
        this.organizationEntryView = r1;
        this.organizationPickerView = r14;
    }

    private final void dismissSearchKeyboard() {
        SearchInputView r0 = this.picker.getSearchInputView();
        EditText r1 = r0.getInputEditText();
        KeyboardUtils.hideKeyboard(getContext(), r1);
        r1.clearFocus();
        r0.clearFocus();
    }

    private final void refreshOrganizationSelection() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r1 = this.picker.getSelectedList().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        SearchBaseInfo r2 = (SearchBaseInfo) r1.next();
        Integer r3 = Integer.valueOf(r2.getType());
        Object r4 = r0.get(r3);
        if (r4 != null) goto L8;
        r4 = new LinkedHashSet();
        r0.put(r3, r4);
    L8:
        ((Set) r4).add(r2.getId());
        goto L4
    L9:
        this.selectedItemIdsByType = r0;
        DoubaoOrganizationPickerView r5 = this.organizationPickerView;
        if (r5 == null) goto L16;
        r5.refreshSelection();
        return;
    }

    private final void setupWindowInsetsListener() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new C03651(this));
    }

    public final void clearCustomSearchResultItems() {
        this.picker.clearCustomSearchResultItems();
    }

    public final void clearInputViewFocus() {
        this.picker.getSearchInputView().clearFocus();
    }

    public final void destroy() {
        TextWatcher r0 = this.organizationSearchWatcher;
        if (r0 == null) goto L5;
        this.picker.getSearchInputView().getInputEditText().removeTextChangedListener(r0);
    L5:
        this.organizationSearchWatcher = null;
        DoubaoOrganizationPickerView r1 = this.organizationPickerView;
        if (r1 == null) goto L8;
        r1.destroy();
    L8:
        this.organizationPickerView = null;
        this.organizationEntryView = null;
        DoubaoChatterTagEnricher r2 = this.chatterTagEnricher;
        if (r2 == null) goto L11;
        r2.destroy();
    L11:
        this.chatterTagEnricher = null;
        this.selectedAvatarAdapter = null;
        this.selectedAvatarList = null;
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        this.picker.destroy();
    }

    public final boolean onBackPressed() {
        DoubaoOrganizationPickerView r0 = this.organizationPickerView;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.onBackPressed() != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void requestApplyInsetsWhenAttached() {
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        ViewCompat.requestApplyInsets(this);
        return;
    L6:
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC03641(this));
    }

    public final Function1<SearchBaseInfo, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public static final /* synthetic */ void access$dismissSearchKeyboard(LarkPicker r0) {
        r0.dismissSearchKeyboard();
    }

    public static final /* synthetic */ FrameLayout access$getBottomBarContainer$p(LarkPicker r0) {
        return r0.bottomBarContainer;
    }

    public static final /* synthetic */ DoubaoConfig access$getDoubaoConfig$p(LarkPicker r0) {
        return r0.doubaoConfig;
    }

    public static final /* synthetic */ View access$getImePlaceholder$p(LarkPicker r0) {
        return r0.imePlaceholder;
    }

    public static final /* synthetic */ DoubaoOrganizationPickerView access$getOrganizationPickerView$p(LarkPicker r0) {
        return r0.organizationPickerView;
    }

    public static final /* synthetic */ Picker access$getPicker$p(LarkPicker r0) {
        return r0.picker;
    }

    public static final /* synthetic */ void access$refreshOrganizationSelection(LarkPicker r0) {
        r0.refreshOrganizationSelection();
    }

    private final void applyTitleBarLeftIcon(int r6) {
        Drawable r0 = AppCompatResources.getDrawable(getContext(), 2131231958);
        if (r0 != null) goto L5;
        return;
    L5:
        Drawable r7 = AppCompatResources.getDrawable(getContext(), r6);
        if (r7 == null) goto L12;
        Drawable r8 = DrawableCompat.wrap(r7).mutate();
        DrawableCompat.setTint(r8, ContextCompat.getColor(getContext(), 2131103136));
        if (r8 == null) goto L13;
        LayerDrawable r2 = new LayerDrawable(new Drawable[]{r0, new InsetDrawable(r8, (int) dp2px(8.0f))});
        int r9 = (int) dp2px(36.0f);
        r2.setBounds(0, 0, r9, r9);
        this.titleBar.setLeftText("");
        this.titleBar.getLeftText().setCompoundDrawables(r2, null, null, null);
        this.titleBar.setLeftTextPadding(18, 0, 0, 0);
        return;
    L13:
        return;
    }

    private final void configureTitleBar(final NavigationConfig r4) {
        this.titleBar.setBackgroundColor(ContextCompat.getColor(getContext(), 2131102028));
        TextView r0 = this.titleBar.getCenterText();
        r0.setTextSize(2, SEARCH_BAR_TEXT_SIZE_SP);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131102040));
        Integer r1 = r4.getCancelIcon();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        applyTitleBarLeftIcon(r2);
        this.titleBar.setLeftClickListener(new ViewOnClickListenerC03622(r4));
        return;
    L5:
        r2 = 2131235904;
        goto L6
    }

    private final float dp2px(float r1) {
        return UIHelper.dp2px(r1);
    }

    private final void onSelectedAvatarClick(SearchBaseInfo r3) {
        if (resolveOrganizationItemState(r3).isEnabled() == true) goto L6;
        return;
    L6:
        if (this.picker.getBusinessConsumeDelegate().onBusinessConsumeItemClick(r3) == true) goto L8;
        this.picker.doItemClick(r3, false, 0);
        this.picker.refreshResult();
        this.picker.refreshDefault();
    L8:
        refreshOrganizationSelection();
    }

    private final DoubaoOrganizationItemState resolveOrganizationItemState(SearchBaseInfo r5) {
        boolean r1 = false;
        if (this.configuredRequiredIds.contains(r5.getId()) == true) goto L5;
        SearchResultView.CheckBoxBindStatus r0 = this.picker.getBusinessConsumeDelegate().onBusinessBindItemCheckBox(r5);
        if (r0.isConsume() == true) goto L9;
        Set<String> r2 = this.selectedItemIdsByType.get(Integer.valueOf(r5.getType()));
        if (r2 == null) goto L16;
        if (r2.contains(r5.getId()) != true) goto L16;
        r1 = true;
    L16:
        return new DoubaoOrganizationItemState(r1, true);
    L9:
        return new DoubaoOrganizationItemState(r0.isChecked(), r0.isEnabled());
    L5:
        return new DoubaoOrganizationItemState(true, false);
    }

    private final void updateSelectedAvatarList(DoubaoConfig.BottomBarConfig r4) {
        RecyclerView r0 = this.selectedAvatarList;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = 8;
        if (r4.getShowSelectedAvatarList() == true) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        List<? extends SearchBaseInfo> r5 = this.picker.getSelectedList();
        LarkPickerSelectedAvatarAdapter r2 = this.selectedAvatarAdapter;
        if (r2 == null) goto L13;
        r2.submitList(r5);
    L13:
        if (r5.isEmpty() == true) goto L16;
        r1 = 0;
    L16:
        r0.setVisibility(r1);
    }

    public final void attachCustomSearchResultItem(CustomSearchResultItem r2) {
        Intrinsics.checkNotNullParameter(r2, "customItem");
        this.picker.attachCustomSearchResultItem(r2);
    }

    public final void attachSearchResultAdapter(SearchResultAdapter r2) {
        this.picker.attachSearchResultAdapter(r2);
    }

    public final void defaultMode(boolean r2) {
        this.picker.defaultMode(r2);
    }

    public final void resetFocus(boolean r2) {
        this.picker.resetFocus(r2);
    }

    public final void resetSelectedData(List<? extends SearchBaseInfo> r2) {
        Picker r0 = this.picker;
        if (r2 == null) goto L5;
        List<? extends SearchBaseInfo> r3 = CollectionsKt.toMutableList(r2);
    L6:
        r0.resetSelectedData(r3);
        int r4 = this.picker.getSelectedList().size();
        if (r4 <= 0) goto L9;
        boolean r1 = true;
    L10:
        this.hasSelected = r1;
        updateBottomBar(r1, r4);
        refreshOrganizationSelection();
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void setConsumeResultLayoutClickWhenEmpty(boolean r2) {
        this.picker.attachConsumeResultLayoutClickWhenEmpty(r2);
    }

    public final void setCustomBinder(ICustomBinder r2) {
        Intrinsics.checkNotNullParameter(r2, "binder");
        this.picker.setCustomBinder(r2);
    }

    public final void setOnItemClickListener(Function1<? super SearchBaseInfo, Unit> r1) {
        this.onItemClickListener = r1;
    }

    public final void setPickModeChangeListener(BasePicker.IOnPickModeChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.picker.setPickModeChangeListener(r2);
    }

    public LarkPicker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.doubaoConfig = new DoubaoConfig();
        this.configuredRequiredIds = SetsKt.emptySet();
        this.selectedItemIdsByType = MapsKt.emptyMap();
        LayoutInflater.from(r2).inflate(2131568176, this);
        this.picker = (Picker) findViewById(2131382265);
        this.contentContainer = (FrameLayout) findViewById(2131377170);
        this.titleBar = findViewById(2131377172);
        this.bottomBarContainer = (FrameLayout) findViewById(2131377169);
        this.imePlaceholder = findViewById(2131377171);
    }

    public static final /* synthetic */ void access$onSelectedAvatarClick(LarkPicker r0, SearchBaseInfo r1) {
        r0.onSelectedAvatarClick(r1);
    }

    public static final /* synthetic */ DoubaoOrganizationItemState access$resolveOrganizationItemState(LarkPicker r0, SearchBaseInfo r1) {
        return r0.resolveOrganizationItemState(r1);
    }

    public static final /* synthetic */ void access$setConfiguredRequiredIds$p(LarkPicker r0, Set r1) {
        r0.configuredRequiredIds = r1;
    }

    public static final /* synthetic */ void access$setHasSelected$p(LarkPicker r0, boolean r1) {
        r0.hasSelected = r1;
    }

    private final String formatSelectedCountHintTemplate(String r7, int r8) {
        String r9 = String.valueOf(r8);
        MatchResult r0 = Regex.find$default(new Regex("\\{\\{\\s*num\\s*\\}\\}"), r7, 0, 2, null);
        Regex r4 = new Regex("%(\\d+\\$)?s");
        MatchResult r1 = Regex.find$default(r4, r7, 0, 2, null);
        if (r0 == null) goto L8;
        if (r1 != null) goto L6;
    L7:
        String r10 = UIHelper.mustacheFormat(r7, "num", r9);
        Intrinsics.checkNotNull(r10);
        return r10;
    L6:
        if (r0.getRange().getFirst() <= r1.getRange().getFirst()) goto L7;
    L8:
        if (r1 != null) goto L10;
        return r7;
    L10:
        return r4.replaceFirst(r7, r9);
    }

    private final void handleOrganizationItemClick(SearchBaseInfo r3, boolean r4) {
        if (r3.getType() != 17) goto L8;
        if (this.isDepartmentSelectable == true) goto L8;
        return;
    L8:
        if (resolveOrganizationItemState(r3).isEnabled() == true) goto L11;
        return;
    L11:
        if (this.picker.getBusinessConsumeDelegate().onBusinessConsumeItemClick(r3) == true) goto L15;
        this.picker.doItemClick(r3, r4, 0);
        Function1<? super SearchBaseInfo, Unit> r5 = this.onItemClickListener;
        if (r5 == null) goto L15;
        r5.invoke(r3);
    L15:
        refreshOrganizationSelection();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.picker.doubao.LarkPicker$injectInternalBinderAndResolver$onItemClickHandler$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.picker.doubao.LarkPicker$injectInternalBinderAndResolver$doubaoBinder$1] */
    private final void injectInternalBinderAndResolver(final FragmentActivity r4, PickerConfig r5) {
        final ?? r0 = new LarkPicker$injectInternalBinderAndResolver$onItemClickHandler$1(this);
        final DoubaoPickerCommonItemViewBridgeFactory r1 = new DoubaoPickerCommonItemViewBridgeFactory(this.chatterTagEnricher);
        final ?? r2 = new LarkPicker$injectInternalBinderAndResolver$doubaoBinder$1(r4, r0, r1);
        final LarkPicker$injectInternalBinderAndResolver$doubaoResolver$1 r6 = LarkPicker$injectInternalBinderAndResolver$doubaoResolver$1.INSTANCE;
        r5.extra(new C03631(this, r2, r6));
    }

    private final void updateBottomBar(boolean r4, int r5) {
        DoubaoConfig.BottomBarConfig r0 = this.doubaoConfig.getBottomBarConfig();
        if (r0 != null) goto L5;
        return;
    L5:
        updateSelectedAvatarList(r0);
        if (r4 == false) goto L8;
    L11:
        this.bottomBarContainer.setVisibility(0);
        TextView r1 = this.selectedText;
        if (r1 == null) goto L20;
        String r2 = r0.getSelectedTextTemplate();
        if (r2 == null) goto L18;
        String r3 = formatSelectedCountHintTemplate(r2, r5);
        if (r3 == null) goto L18;
    L19:
        r1.setText(r3);
    L18:
        r3 = String.valueOf(r5);
    L20:
        TextView r6 = this.bottomBarActionButton;
        if (r6 == null) goto L32;
        String r7 = r0.getActionText();
        if (r7 != null) goto L26;
        r7 = UIHelper.mustacheFormat(2131892073, "count", String.valueOf(r5));
    L26:
        r6.setText(r7);
        r6.setEnabled(r4);
        if (r4 == false) goto L29;
        float r8 = 1.0f;
    L30:
        r6.setAlpha(r8);
        return;
    L29:
        r8 = 0.4f;
        goto L30
    L32:
        return;
    L8:
        if (r0.getShowWhenEmpty() == true) goto L11;
        this.bottomBarContainer.setVisibility(8);
    }

    private final void updateOrganizationTitle(boolean r2, String r3) {
        if (r2 == false) goto L5;
        this.titleBar.setVisibility(0);
        this.titleBar.setTitle(r3);
        applyTitleBarLeftIcon(2131235903);
        this.titleBar.setLeftClickListener(new ViewOnClickListenerC03661(this));
        return;
    L5:
        applyConfiguredTitleBar();
    }

    public final void attachRecommendEmptyViewConfig(Integer r2, CharSequence r3) {
        this.picker.attachRecommendEmptyViewConfig(r2, r3);
    }

    public final void init(FragmentActivity r11, PickerConfig r12) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "pickerConfig");
        DoubaoChatterTagEnricher r0 = this.chatterTagEnricher;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        DoubaoLocalChatterProvider r2 = (DoubaoLocalChatterProvider) PluginServiceLoader.loadFirstOrNull(DoubaoLocalChatterProvider.class);
        NavigationConfig r1 = null;
        if (r2 == null) goto L8;
        DoubaoChatterTagEnricher r9 = new DoubaoChatterTagEnricher(r2, null, null, 0, 14, null);
    L9:
        this.chatterTagEnricher = r9;
        DoubaoConfig r3 = r12.getDoubaoConfig();
        if (r3 != null) goto L12;
        r3 = new DoubaoConfig();
    L12:
        this.doubaoConfig = r3;
        if ((r12 instanceof NavPickerConfig) == false) goto L17;
        r1 = ((NavPickerConfig) r12).getNavigationConfig();
        if (r1 != null) goto L17;
        r1 = new NavigationConfig();
    L17:
        this.configuredNavigation = r1;
        this.isOrganizationEnabled = false;
        this.isDepartmentSelectable = false;
        AddressBookConfig r4 = r12.consumeAddressBookConfig();
        if (r4 == null) goto L20;
        this.isOrganizationEnabled = true;
        this.isDepartmentSelectable = r4.isDepartmentSelectable();
    L20:
        injectInternalBinderAndResolver(r11, r12);
        r12.searcherExtra(AnonymousClass4.INSTANCE);
        this.picker.init2(r12);
        refreshOrganizationSelection();
        this.picker.setDefaultContainerHideKeyboardOnTouch(false);
        SearchInputView r13 = this.picker.getSearchInputView();
        r13.setSearchEditTextCornerRadius(dp2px(16.0f));
        r13.setSearchEditTextTextSizeSp(SEARCH_BAR_TEXT_SIZE_SP);
        r13.setSearchIconRes(2131233996);
        r13.setSearchIconSize(UIHelper.dp2px(SEARCH_ICON_SIZE_DP));
        r13.setSearchEditTextBackgroundColor(ContextCompat.getColor(r11, 2131102026));
        r13.setSearchInputContainerBackgroundColor(ContextCompat.getColor(r11, 2131102028));
        this.picker.attachSearchEmptyViewConfig(0, UIHelper.getString(2131892376));
        this.picker.setOnSelectedStatusChangeListener(new AnonymousClass6(this));
        this.picker.selectedRvBg2Doubao();
        applyConfiguredTitleBar();
        attachConfiguredBottomBar();
        if (this.isOrganizationEnabled == false) goto L24;
        attachOrganizationEntry();
        return;
    L24:
        return;
    L8:
        r9 = null;
        goto L9
    }

    public final void switchMultipleStatus(boolean r2, boolean r3) {
        this.picker.switchMultipleStatus(r2, r3);
        DoubaoOrganizationPickerView r4 = this.organizationPickerView;
        if (r4 == null) goto L6;
        r4.updateMultipleSelect(this.picker.isMultipleSelect());
        return;
    }

    public static final /* synthetic */ void access$handleOrganizationItemClick(LarkPicker r0, SearchBaseInfo r1, boolean r2) {
        r0.handleOrganizationItemClick(r1, r2);
    }

    public static final /* synthetic */ void access$updateBottomBar(LarkPicker r0, boolean r1, int r2) {
        r0.updateBottomBar(r1, r2);
    }

    public static final /* synthetic */ void access$updateOrganizationTitle(LarkPicker r0, boolean r1, String r2) {
        r0.updateOrganizationTitle(r1, r2);
    }

    public /* synthetic */ LarkPicker(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ void attachRecommendEmptyViewConfig$default(LarkPicker r1, Integer r2, CharSequence r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.attachRecommendEmptyViewConfig(r2, r3);
    }

    public static /* synthetic */ void switchMultipleStatus$default(LarkPicker r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.switchMultipleStatus(r1, r2);
    }
}
