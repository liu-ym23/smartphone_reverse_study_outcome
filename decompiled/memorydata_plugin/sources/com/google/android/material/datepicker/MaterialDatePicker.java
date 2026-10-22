package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    static final Object CANCEL_BUTTON_TAG = null;
    static final Object CONFIRM_BUTTON_TAG = null;
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String NEGATIVE_BUTTON_TEXT_KEY = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_RES_ID_KEY = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String POSITIVE_BUTTON_TEXT_KEY = "POSITIVE_BUTTON_TEXT_KEY";
    private static final String POSITIVE_BUTTON_TEXT_RES_ID_KEY = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    static final Object TOGGLE_BUTTON_TAG = null;
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;
    private DateSelector<S> dateSelector;
    private boolean edgeToEdgeEnabled;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonText;
    private int negativeButtonTextResId;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners;
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners;
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners;
    private final LinkedHashSet<f<? super S>> onPositiveButtonClickListeners;
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence positiveButtonText;
    private int positiveButtonTextResId;
    private CharSequence titleText;
    private int titleTextResId;

    public static final class a<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DateSelector<S> f3866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3867b;
        CalendarConstraints c;
        int d;
        CharSequence e;
        int f;
        CharSequence g;
        int h;
        CharSequence i;
        int j;
    }

    static {
        CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
        CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
        TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    }

    public MaterialDatePicker() {
        this.onPositiveButtonClickListeners = new LinkedHashSet();
        this.onNegativeButtonClickListeners = new LinkedHashSet();
        this.onCancelListeners = new LinkedHashSet();
        this.onDismissListeners = new LinkedHashSet();
    }

    static /* synthetic */ LinkedHashSet access$000(MaterialDatePicker r0) {
        return r0.onPositiveButtonClickListeners;
    }

    static /* synthetic */ LinkedHashSet access$100(MaterialDatePicker r0) {
        return r0.onNegativeButtonClickListeners;
    }

    static /* synthetic */ void access$200(MaterialDatePicker r0) {
        r0.updateHeader();
    }

    static /* synthetic */ DateSelector access$300(MaterialDatePicker r0) {
        return r0.getDateSelector();
    }

    static /* synthetic */ Button access$400(MaterialDatePicker r0) {
        return r0.confirmButton;
    }

    static /* synthetic */ CheckableImageButton access$500(MaterialDatePicker r0) {
        return r0.headerToggleButton;
    }

    static /* synthetic */ void access$600(MaterialDatePicker r0, CheckableImageButton r1) {
        r0.updateToggleContentDescription(r1);
    }

    static /* synthetic */ void access$700(MaterialDatePicker r0) {
        r0.startPickerFragment();
    }

    private static Drawable createHeaderToggleDrawable(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        StateListDrawable r0 = new StateListDrawable();
        r0.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.drawable.material_ic_calendar_black_24dp, "drawable", "material_ic_calendar_black_24dp")));
        r0.addState(new int[0], AppCompatResources.getDrawable(r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.drawable.material_ic_edit_black_24dp, "drawable", "material_ic_edit_black_24dp")));
        return r0;
    }

    private void enableEdgeToEdgeIfNeeded(Window r5) {
        if (this.edgeToEdgeEnabled == false) goto L5;
        return;
    L5:
        final View r0 = requireView().findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.fullscreen_header, OaidModel.KEY_ID, "fullscreen_header"));
        com.google.android.material.internal.e.a(r5, true, r.h(r0), null);
        final int r6 = r0.getPaddingTop();
        final int r1 = r0.getLayoutParams().height;
        ViewCompat.setOnApplyWindowInsetsListener(r0, new AnonymousClass3(this, r1, r0, r6));
        this.edgeToEdgeEnabled = true;
    }

    private DateSelector<S> getDateSelector() {
        if (this.dateSelector != null) goto L6;
        this.dateSelector = (DateSelector) ZeusTransformUtils.preCheckCast(getArguments().getParcelable(DATE_SELECTOR_KEY), DateSelector.class, "com.obric.memorydata.plugin");
    L6:
        return this.dateSelector;
    }

    private static int getPaddedPickerWidth(Context r6) {
        Resources r7 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        int r0 = r7.getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.mtrl_calendar_content_padding, "dimen", "mtrl_calendar_content_padding"));
        int r2 = Month.current().daysInWeek;
        return ((r0 * 2) + (r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.mtrl_calendar_day_width, "dimen", "mtrl_calendar_day_width")) * r2)) + ((r2 - 1) * r7.getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.mtrl_calendar_month_horizontal_padding, "dimen", "mtrl_calendar_month_horizontal_padding")));
    }

    private int getThemeResId(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        int r0 = this.overrideThemeResId;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return getDateSelector().getDefaultThemeResId(r4);
    }

    private void initHeaderToggle(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(r4));
        CheckableImageButton r5 = this.headerToggleButton;
        if (this.inputMode == 0) goto L5;
        boolean r0 = true;
    L6:
        r5.setChecked(r0);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new AnonymousClass5(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    static boolean isFullscreen(Context r2) {
        return readMaterialCalendarStyleBoolean((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), R.attr.windowFullscreen);
    }

    static boolean isNestedScrollable(Context r3) {
        return readMaterialCalendarStyleBoolean((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.nestedScrollable, "attr", "nestedScrollable"));
    }

    static <S> MaterialDatePicker<S> newInstance(a<S> r4) {
        MaterialDatePicker<S> r0 = new MaterialDatePicker();
        Bundle r1 = new Bundle();
        r1.putInt(OVERRIDE_THEME_RES_ID, r4.f3867b);
        r1.putParcelable(DATE_SELECTOR_KEY, r4.f3866a);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r4.c);
        r1.putInt(TITLE_TEXT_RES_ID_KEY, r4.d);
        r1.putCharSequence(TITLE_TEXT_KEY, r4.e);
        r1.putInt(INPUT_MODE_KEY, r4.j);
        r1.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, r4.f);
        r1.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, r4.g);
        r1.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, r4.h);
        r1.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, r4.i);
        r0.setArguments(r1);
        return r0;
    }

    static boolean readMaterialCalendarStyleBoolean(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        TypedArray r6 = r5.obtainStyledAttributes(com.google.android.material.resources.b.a(r5, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.materialCalendarStyle, "attr", "materialCalendarStyle"), MaterialCalendar.class.getCanonicalName()), new int[]{r4});
        boolean r7 = r6.getBoolean(0, false);
        r6.recycle();
        return r7;
    }

    private void startPickerFragment() {
        int r0 = getThemeResId((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.calendar = MaterialCalendar.newInstance(getDateSelector(), r0, this.calendarConstraints);
        if (this.headerToggleButton.isChecked() == false) goto L5;
        PickerFragment<S> r1 = MaterialTextInputPicker.newInstance(getDateSelector(), r0, this.calendarConstraints);
    L6:
        this.pickerFragment = r1;
        updateHeader();
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();
        r2.replace(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_calendar_frame, OaidModel.KEY_ID, "mtrl_calendar_frame"), this.pickerFragment);
        r2.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new AnonymousClass4(this));
        return;
    L5:
        r1 = this.calendar;
        goto L6
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return j.b().getTimeInMillis();
    }

    private void updateHeader() {
        String r0 = getHeaderText();
        this.headerSelectionText.setContentDescription(String.format(getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.mtrl_picker_announce_current_selection, TypedValues.Custom.S_STRING, "mtrl_picker_announce_current_selection")), new Object[]{r0}));
        this.headerSelectionText.setText(r0);
    }

    private void updateToggleContentDescription(CheckableImageButton r4) {
        boolean r0 = this.headerToggleButton.isChecked();
        Context r5 = ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin");
        if (r0 == false) goto L5;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin");
        int r1 = com.obric.memorydata.plugin.R.string.mtrl_picker_toggle_to_calendar_input_mode;
        String r2 = "mtrl_picker_toggle_to_calendar_input_mode";
    L6:
        String r7 = r6.getString(ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r2));
        this.headerToggleButton.setContentDescription(r7);
        return;
    L5:
        r6 = (Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin");
        r1 = com.obric.memorydata.plugin.R.string.mtrl_picker_toggle_to_text_input_mode;
        r2 = "mtrl_picker_toggle_to_text_input_mode";
        goto L6
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r3) {
        DialogInterface.OnCancelListener r4 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
        return this.onCancelListeners.add(r4);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
        return this.onDismissListeners.add(r4);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        return this.onNegativeButtonClickListeners.add(r4);
    }

    public boolean addOnPositiveButtonClickListener(f<? super S> r3) {
        f<? super S> r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        return this.onPositiveButtonClickListeners.add(r4);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public String getHeaderText() {
        return getDateSelector().getSelectionDisplayString((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.memorydata.plugin");
        Iterator<DialogInterface.OnCancelListener> r0 = this.onCancelListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((DialogInterface.OnCancelListener) ZeusTransformUtils.preCheckCast(r0.next(), DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin")).onCancel(r6);
        goto L4
    L6:
        super.onCancel(r6);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (r4 != null) goto L5;
        r4 = getArguments();
    L5:
        this.overrideThemeResId = r4.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) ZeusTransformUtils.preCheckCast(r4.getParcelable(DATE_SELECTOR_KEY), DateSelector.class, "com.obric.memorydata.plugin");
        this.calendarConstraints = (CalendarConstraints) ZeusTransformUtils.preCheckCast(r4.getParcelable(CALENDAR_CONSTRAINTS_KEY), CalendarConstraints.class, "com.obric.memorydata.plugin");
        this.titleTextResId = r4.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = r4.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = r4.getInt(INPUT_MODE_KEY);
        this.positiveButtonTextResId = r4.getInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY);
        this.positiveButtonText = r4.getCharSequence(POSITIVE_BUTTON_TEXT_KEY);
        this.negativeButtonTextResId = r4.getInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY);
        this.negativeButtonText = r4.getCharSequence(NEGATIVE_BUTTON_TEXT_KEY);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r8) {
        Dialog r9 = new Dialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), getThemeResId((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.fullscreen = isFullscreen(r0);
        int r1 = com.google.android.material.resources.b.a(r0, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.colorSurface, "attr", "colorSurface"), MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable r3 = new MaterialShapeDrawable(r0, null, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.materialCalendarStyle, "attr", "materialCalendarStyle"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.Widget_MaterialComponents_MaterialCalendar, "style", "Widget_MaterialComponents_MaterialCalendar"));
        this.background = r3;
        r3.initializeElevationOverlay(r0);
        this.background.setFillColor(ColorStateList.valueOf(r1));
        this.background.setElevation(ViewCompat.getElevation(r9.getWindow().getDecorView()));
        return r9;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        if (this.fullscreen == false) goto L5;
        int r9 = com.obric.memorydata.plugin.R.layout.mtrl_picker_fullscreen;
        String r1 = "mtrl_picker_fullscreen";
    L6:
        View r10 = ZeusTransformUtils.inflate(r6, ZeusTransformUtils.mapRes(r9, "layout", r1), r7, "com.obric.memorydata.plugin");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (this.fullscreen == false) goto L9;
        View r12 = r10.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_calendar_frame, OaidModel.KEY_ID, "mtrl_calendar_frame"));
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(getPaddedPickerWidth(r11), -2);
    L10:
        r12.setLayoutParams(r2);
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_picker_header_selection_text, OaidModel.KEY_ID, "mtrl_picker_header_selection_text")), TextView.class, "com.obric.memorydata.plugin");
        this.headerSelectionText = r13;
        ViewCompat.setAccessibilityLiveRegion(r13, 1);
        this.headerToggleButton = (CheckableImageButton) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_picker_header_toggle, OaidModel.KEY_ID, "mtrl_picker_header_toggle")), CheckableImageButton.class, "com.obric.memorydata.plugin");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_picker_title_text, OaidModel.KEY_ID, "mtrl_picker_title_text")), TextView.class, "com.obric.memorydata.plugin");
        CharSequence r3 = this.titleText;
        if (r3 == null) goto L13;
        r14.setText(r3);
    L14:
        initHeaderToggle(r11);
        this.confirmButton = (Button) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.confirm_button, OaidModel.KEY_ID, "confirm_button")), Button.class, "com.obric.memorydata.plugin");
        if (getDateSelector().isSelectionComplete() == false) goto L17;
        this.confirmButton.setEnabled(true);
    L18:
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        CharSequence r15 = this.positiveButtonText;
        if (r15 == null) goto L21;
        this.confirmButton.setText(r15);
    L24:
        this.confirmButton.setOnClickListener(new AnonymousClass1(this));
        Button r16 = (Button) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.cancel_button, OaidModel.KEY_ID, "cancel_button")), Button.class, "com.obric.memorydata.plugin");
        r16.setTag(CANCEL_BUTTON_TAG);
        CharSequence r17 = this.negativeButtonText;
        if (r17 == null) goto L27;
        r16.setText(r17);
    L30:
        r16.setOnClickListener(new AnonymousClass2(this));
        return r10;
    L27:
        int r18 = this.negativeButtonTextResId;
        if (r18 == 0) goto L30;
        r16.setText(r18);
        goto L30
    L21:
        int r19 = this.positiveButtonTextResId;
        if (r19 == 0) goto L24;
        this.confirmButton.setText(r19);
        goto L24
    L17:
        this.confirmButton.setEnabled(false);
        goto L18
    L13:
        r14.setText(this.titleTextResId);
        goto L14
    L9:
        r12 = r10.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_calendar_main_pane, OaidModel.KEY_ID, "mtrl_calendar_main_pane"));
        r2 = new LinearLayout.LayoutParams(getPaddedPickerWidth(r11), -1);
        goto L10
    L5:
        r9 = com.obric.memorydata.plugin.R.layout.mtrl_picker_dialog;
        r1 = "mtrl_picker_dialog";
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.memorydata.plugin");
        Iterator<DialogInterface.OnDismissListener> r0 = this.onDismissListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) ZeusTransformUtils.preCheckCast(r0.next(), DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin")).onDismiss(r6);
        goto L4
    L6:
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(getView(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        super.onDismiss(r6);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        r4.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        r4.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints.a r0 = new CalendarConstraints.a(this.calendarConstraints);
        if (this.calendar.getCurrentMonth() == null) goto L5;
        r0.a(this.calendar.getCurrentMonth().timeInMillis);
    L5:
        r4.putParcelable(CALENDAR_CONSTRAINTS_KEY, r0.a());
        r4.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        r4.putCharSequence(TITLE_TEXT_KEY, this.titleText);
        r4.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, this.positiveButtonTextResId);
        r4.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, this.positiveButtonText);
        r4.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, this.negativeButtonTextResId);
        r4.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, this.negativeButtonText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window r0 = requireDialog().getWindow();
        if (this.fullscreen == false) goto L5;
        r0.setLayout(-1, -1);
        r0.setBackgroundDrawable(this.background);
        enableEdgeToEdgeIfNeeded(r0);
    L6:
        startPickerFragment();
        return;
    L5:
        r0.setLayout(-2, -2);
        int r8 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.mtrl_calendar_dialog_background_inset, "dimen", "mtrl_calendar_dialog_background_inset"));
        Rect r1 = new Rect(r8, r8, r8, r8);
        r0.setBackgroundDrawable(new InsetDrawable(this.background, r8, r8, r8, r8));
        r0.getDecorView().setOnTouchListener(new com.google.android.material.dialog.a(requireDialog(), r1));
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r3) {
        DialogInterface.OnCancelListener r4 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
        return this.onCancelListeners.remove(r4);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
        return this.onDismissListeners.remove(r4);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        return this.onNegativeButtonClickListeners.remove(r4);
    }

    public boolean removeOnPositiveButtonClickListener(f<? super S> r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        return this.onPositiveButtonClickListeners.remove(r4);
    }
}
