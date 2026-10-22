package com.ss.android.lark.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.NavigationConfig;
import com.ss.android.lark.picker.config.PickerExtra;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00019B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0006\u0010\u001c\u001a\u00020\u0010J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u0006\u0010\"\u001a\u00020\u0019J\u0012\u0010#\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J(\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0012H\u0002J&\u0010-\u001a\u00020\u0019*\u00020\u000b2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010+H\u0002J,\u00101\u001a\u00020\u0019*\u00020\u000b2\u0006\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00122\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006:"}, d2 = {"Lcom/ss/android/lark/picker/NavPicker;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/picker/IPicker;", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "navigationBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "picker", "Lcom/ss/android/lark/picker/Picker;", "config", "isInSubPage", "", "currentFragmentType", "", "selectedList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getSelectedList", "()Ljava/util/List;", "scene", "", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "init", "onBackPressed", "updateTitleForFragmentType", "type", "navConfig", "Lcom/ss/android/lark/picker/config/NavigationConfig;", "applyTitle", "destroy", "initNavigationBar", "changeSelectMode", "changeNavBarStyle", "isEnableSingle2Multi", "isEnableMulti2Single", "isMultipleSelect", "isConfirmableWhenNotSelected", "getConfirmText", "", "selectedNumber", "changeBackButton", "isCancelState", "isSubPage", "cancelText", "changeActionButton", "isShow", "isEnable", "actionMode", "Lcom/ss/android/lark/picker/NavPicker$ActionMode;", "reload", "isReloadSearch", "isReloadRecommend", "ActionMode", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class NavPicker extends FrameLayout implements IPicker<NavPickerConfig> {
    private NavPickerConfig config;
    private int currentFragmentType;
    private boolean isInSubPage;
    private final CommonTitleBar navigationBar;
    private final Picker picker;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/NavPicker$ActionMode;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE_CHOICE", "MULTIPLE_CHOICE", "DONE", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum ActionMode extends Enum<ActionMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ActionMode[] $VALUES = null;
        public static final ActionMode DONE = null;
        public static final ActionMode MULTIPLE_CHOICE = null;
        public static final ActionMode SINGLE_CHOICE = null;

        private static final /* synthetic */ ActionMode[] $values() {
            return new ActionMode[]{SINGLE_CHOICE, MULTIPLE_CHOICE, DONE};
        }

        public static EnumEntries<ActionMode> getEntries() {
            return $ENTRIES;
        }

        static {
            SINGLE_CHOICE = new ActionMode("SINGLE_CHOICE", 0);
            MULTIPLE_CHOICE = new ActionMode("MULTIPLE_CHOICE", 1);
            DONE = new ActionMode("DONE", 2);
            ActionMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static ActionMode[] values() {
            return (ActionMode[]) $VALUES.clone();
        }

        public static ActionMode valueOf(String r1) {
            return (ActionMode) a.a(ActionMode.class, r1);
        }

        private ActionMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ActionMode.values().length];
            r0[ActionMode.SINGLE_CHOICE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ActionMode.MULTIPLE_CHOICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ActionMode.DONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public NavPicker(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AttributeSet r0 = null;
        this(r3, r0, 2, r0);
    }

    private final void applyTitle() {
        NavPickerConfig r0 = this.config;
        String r1 = null;
        if (r0 == null) goto L5;
        NavigationConfig r2 = r0.getNavigationConfig();
    L6:
        if (r2 == null) goto L8;
        r1 = r2.getTitle();
    L8:
        boolean r3 = false;
        if (r1 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        String r5 = "";
        if (r4 == false) goto L18;
        String r6 = UIUtils.getString(getContext(), 2131892188);
    L21:
        int r7 = this.currentFragmentType;
        if (r7 != 11) goto L24;
        r6 = UIUtils.getString(getContext(), 2131890297);
        Intrinsics.checkNotNull(r6);
    L28:
        if (r2 == null) goto L33;
        String r8 = r2.getSubTitle();
        if (r8 == null) goto L33;
        r5 = r8;
    L33:
        CommonTitleBar r9 = this.navigationBar;
        if (r5.length() <= 0) goto L36;
        boolean r10 = true;
    L37:
        r9.setSubTitleVisible(r10);
        CommonTitleBar r11 = this.navigationBar;
        if (r5.length() != 0) goto L40;
        r3 = true;
    L40:
        if (r3 == true) goto L43;
        r6 = r6 + '\n' + r5;
    L43:
        r11.setTitle(r6);
        return;
    L36:
        r10 = false;
        goto L37
    L24:
        if (r7 == 12) goto L26;
        Intrinsics.checkNotNull(r6);
        goto L28
    L26:
        r6 = UIUtils.getString(getContext(), 2131890298);
        Intrinsics.checkNotNull(r6);
        goto L28
    L18:
        r6 = r2.getTitle();
        if (r6 != null) goto L21;
        r6 = "";
        goto L21
    L11:
        if (r1.length() == 0) goto L14;
        r4 = false;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    private final void changeSelectMode() {
        this.picker.switchMultipleStatus(!this.picker.isMultipleSelect(), true);
    }

    private final List<SearchBaseInfo> getSelectedList() {
        return this.picker.getMSelectedList();
    }

    public final void destroy() {
        this.picker.destroy();
    }

    public final boolean onBackPressed() {
        return this.picker.onBackPressed();
    }

    public static final /* synthetic */ void access$changeSelectMode(NavPicker r0) {
        r0.changeSelectMode();
    }

    public static final /* synthetic */ NavPickerConfig access$getConfig$p(NavPicker r0) {
        return r0.config;
    }

    public static final /* synthetic */ Picker access$getPicker$p(NavPicker r0) {
        return r0.picker;
    }

    public static final /* synthetic */ List access$getSelectedList(NavPicker r0) {
        return r0.getSelectedList();
    }

    private final String getConfirmText(int r5) {
        NavPickerConfig r0 = this.config;
        if (r0 == null) goto L7;
        NavigationConfig r1 = r0.getNavigationConfig();
        if (r1 == null) goto L7;
        String r2 = r1.getConfirmButtonText();
    L8:
        boolean r3 = true;
        if (r2 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        r2 = UIUtils.getString(getContext(), 2131891623);
    L17:
        NavPickerConfig r6 = this.config;
        if (r6 == null) goto L24;
        NavigationConfig r7 = r6.getNavigationConfig();
        if (r7 == null) goto L24;
        if (r7.getShowSelectedCount() == true) goto L24;
    L25:
        if (r3 == true) goto L29;
        if (r5 > 0) goto L28;
        return r2;
    L28:
        return r2 + '(' + r5 + ')';
    L29:
        return r2;
    L24:
        r3 = false;
        goto L25
    L11:
        if (r2.length() == 0) goto L14;
        r4 = false;
    L7:
        r2 = null;
        goto L8
    }

    private final void initNavigationBar(final NavigationConfig r5) {
        if (r5 == null) goto L6;
        Integer r0 = r5.getSubTitleColor();
        if (r0 == null) goto L6;
        int r1 = r0.intValue();
    L7:
        if (r5 == null) goto L11;
        Integer r2 = r5.getCancelIcon();
        if (r2 == null) goto L11;
        int r3 = r2.intValue();
    L12:
        this.navigationBar.setSubTitleColor(r1);
        this.navigationBar.setLeftImageResource(r3);
        applyTitle();
        this.navigationBar.setLeftClickListener(new ViewOnClickListenerC03161(this, r5));
        CommonTitleBar r4 = this.navigationBar;
        final String r6 = UIUtils.getString(getContext(), 2131892181);
        r4.addAction(new AnonymousClass2(this, r5, r6));
        if (r5 == null) goto L15;
        this.navigationBar.setImmersive(r5.isImmersive());
    L15:
        this.picker.addOnPickNotifyV2(new AnonymousClass4(this));
        boolean r7 = false;
        if (r5 == null) goto L18;
        boolean r8 = r5.isEnableSingle2Multi();
    L19:
        if (r5 == null) goto L21;
        boolean r9 = r5.isEnableMulti2Single();
    L22:
        NavPickerConfig r10 = this.config;
        if (r10 == null) goto L27;
        PickerExtra r11 = r10.getExtra$picker_release();
        if (r11 == null) goto L27;
        boolean r12 = r11.isMultiSelect();
    L28:
        if (r5 == null) goto L30;
        r7 = r5.isConfirmableWhenNotSelected();
    L30:
        changeNavBarStyle(r8, r9, r12, r7);
        return;
    L27:
        r12 = false;
        goto L28
    L21:
        r9 = false;
        goto L22
    L18:
        r8 = false;
    L11:
        r3 = CommonTitleBarConstants.ICON_CLOSE;
    L6:
        r1 = UIUtils.getColor(getContext(), 2131106607);
        goto L7
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(final NavPickerConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.config = r3;
        final BasePicker.IOnSelectModeChangeListener r0 = r3.getExtra$picker_release().getOnSelectModeChangeListener();
        BasePicker.IOnSelectModeChangeListener r1 = new NavPicker$init$selectModeWarpListener$1(this, r3, r0);
        r3.getExtra$picker_release().setOnSelectModeChangeListener(r1);
        initNavigationBar(r3.getNavigationConfig());
        this.picker.init2(r3);
        this.picker.setOnFragmentTypeChangeListener(new AnonymousClass1(this, r3));
    }

    public final void scene(PickerStatistics.Scene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.picker.scene(r2);
    }

    @Override // com.ss.android.lark.picker.IPicker
    public /* bridge */ /* synthetic */ void init(NavPickerConfig r1) {
        init2(r1);
    }

    public NavPicker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.currentFragmentType = 1;
        LayoutInflater.from(r2).inflate(2131568178, this);
        this.navigationBar = findViewById(2131382273);
        this.picker = (Picker) findViewById(2131382265);
    }

    private final void updateTitleForFragmentType(int r4, NavigationConfig r5) {
        this.currentFragmentType = r4;
        boolean r1 = false;
        if (r4 != 11) goto L5;
    L8:
        boolean r6 = true;
    L9:
        this.isInSubPage = r6;
        applyTitle();
        CommonTitleBar r7 = this.navigationBar;
        if (r5 != null) goto L12;
    L14:
        boolean r0 = false;
    L15:
        if (r0 == true) goto L17;
    L19:
        boolean r2 = this.isInSubPage;
        if (r5 == null) goto L22;
        String r8 = r5.getCancelText();
    L23:
        changeBackButton(r7, r1, r2, r8);
        return;
    L22:
        r8 = null;
        goto L23
    L17:
        if (this.picker.isMultipleSelect() == false) goto L19;
        r1 = true;
        goto L19
    L12:
        if (r5.isEnableMulti2Single() != true) goto L14;
        r0 = true;
        goto L15
    L5:
        if (r4 == 12) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.ss.android.lark.picker.IPicker
    public void reload(boolean r2, boolean r3) {
        this.picker.reload(r2, r3);
    }

    public static final /* synthetic */ void access$updateTitleForFragmentType(NavPicker r0, int r1, NavigationConfig r2) {
        r0.updateTitleForFragmentType(r1, r2);
    }

    public /* synthetic */ NavPicker(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    private final void changeBackButton(CommonTitleBar r1, boolean r2, boolean r3, String r4) {
        if (r2 == false) goto L4;
        r1.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        return;
    L4:
        if (r3 == true) goto L13;
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L13;
        r1.setLeftTextOnly(r4);
        return;
    L7:
        if (r4.length() == 0) goto L10;
        r5 = false;
    L13:
        r1.setLeftText("");
        if (r3 == false) goto L16;
        int r6 = CommonTitleBarConstants.ICON_BACK;
    L17:
        r1.setLeftImageResource(r6);
        return;
    L16:
        r6 = CommonTitleBarConstants.ICON_CLOSE;
        goto L17
    }

    private final void changeNavBarStyle(boolean r7, boolean r8, boolean r9, boolean r10) {
        boolean r1 = true;
        boolean r0 = !getSelectedList().isEmpty();
        TextView r2 = this.navigationBar.getRightText();
        r2.setVisibility(0);
        r2.setEnabled(true);
        CommonTitleBar r3 = this.navigationBar;
        if (r8 == false) goto L6;
        if (r9 == false) goto L6;
    L7:
        boolean r4 = this.isInSubPage;
        NavPickerConfig r5 = this.config;
        if (r5 == null) goto L12;
        NavigationConfig r6 = r5.getNavigationConfig();
        if (r6 == null) goto L12;
        String r11 = r6.getCancelText();
    L13:
        changeBackButton(r3, r1, r4, r11);
        if (r9 == false) goto L18;
        if (r0 == false) goto L17;
        changeActionButton(this.navigationBar, true, true, getSelectedList().size(), ActionMode.DONE);
        return;
    L17:
        changeActionButton(this.navigationBar, true, r10, getSelectedList().size(), ActionMode.DONE);
        return;
    L18:
        if (r7 == false) goto L20;
        changeActionButton(this.navigationBar, true, true, getSelectedList().size(), ActionMode.MULTIPLE_CHOICE);
        return;
    L20:
        changeActionButton(this.navigationBar, false, true, getSelectedList().size(), ActionMode.DONE);
        return;
    L12:
        r11 = null;
    L6:
        r1 = false;
        goto L7
    }

    public static final /* synthetic */ void access$changeNavBarStyle(NavPicker r0, boolean r1, boolean r2, boolean r3, boolean r4) {
        r0.changeNavBarStyle(r1, r2, r3, r4);
    }

    private final void changeActionButton(CommonTitleBar r2, boolean r3, boolean r4, int r5, ActionMode r6) {
        TextView r0 = r2.getRightText();
        if (r3 == false) goto L5;
        int r7 = 0;
    L6:
        r0.setVisibility(r7);
        r0.setEnabled(r4);
        if (r4 == false) goto L9;
        float r8 = 1.0f;
    L10:
        r0.setAlpha(r8);
        int r9 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r9 != 1) goto L13;
        Pair r10 = TuplesKt.to(Integer.valueOf(UIUtils.getColor(r2.getContext(), 2131106622)), UIUtils.getString(r2.getContext(), 2131892187));
    L21:
        int r11 = ((Number) r10.component1()).intValue();
        String r12 = (String) r10.component2();
        r0.setTextColor(r11);
        r0.setText(r12);
        return;
    L13:
        if (r9 != 2) goto L15;
        r10 = TuplesKt.to(Integer.valueOf(UIUtils.getColor(r2.getContext(), 2131106622)), UIUtils.getString(r2.getContext(), 2131892181));
        goto L21
    L15:
        if (r9 != 3) goto L18;
        r10 = TuplesKt.to(Integer.valueOf(UIUtils.getColor(r2.getContext(), 2131105568)), getConfirmText(r5));
        goto L21
    L18:
        throw new NoWhenBranchMatchedException();
    L9:
        r8 = 0.6f;
        goto L10
    L5:
        r7 = 8;
        goto L6
    }
}
