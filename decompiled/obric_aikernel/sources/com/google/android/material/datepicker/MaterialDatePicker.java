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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
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

    @Nullable
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;

    @Nullable
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;

    @Nullable
    private DateSelector<S> dateSelector;
    private boolean edgeToEdgeEnabled;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonText;

    @StringRes
    private int negativeButtonTextResId;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners;
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners;
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners;
    private final LinkedHashSet<f<? super S>> onPositiveButtonClickListeners;

    @StyleRes
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence positiveButtonText;

    @StringRes
    private int positiveButtonTextResId;
    private CharSequence titleText;

    @StringRes
    private int titleTextResId;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialDatePicker f3176c;

        a(MaterialDatePicker r10) {
            this.f3176c = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            Iterator r11 = MaterialDatePicker.access$000(this.f3176c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((f) r11.next()).a(this.f3176c.getSelection());
            goto L4
        L6:
            this.f3176c.dismiss();
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialDatePicker f3177c;

        b(MaterialDatePicker r10) {
            this.f3177c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            Iterator r11 = MaterialDatePicker.access$100(this.f3177c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((View.OnClickListener) r11.next()).onClick(r10);
            goto L4
        L6:
            this.f3177c.dismiss();
        }
    }

    class c extends h<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialDatePicker f3178a;

        c(MaterialDatePicker r10) {
            this.f3178a = r10;
        }

        @Override // com.google.android.material.datepicker.h
        public void a() {
            MaterialDatePicker.access$400(this.f3178a).setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.h
        public void b(S r10) {
            MaterialDatePicker.access$200(this.f3178a);
            MaterialDatePicker.access$400(this.f3178a).setEnabled(MaterialDatePicker.access$300(this.f3178a).isSelectionComplete());
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialDatePicker f3179c;

        d(MaterialDatePicker r10) {
            this.f3179c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            MaterialDatePicker.access$400(this.f3179c).setEnabled(MaterialDatePicker.access$300(this.f3179c).isSelectionComplete());
            MaterialDatePicker.access$500(this.f3179c).toggle();
            MaterialDatePicker r11 = this.f3179c;
            MaterialDatePicker.access$600(r11, MaterialDatePicker.access$500(r11));
            MaterialDatePicker.access$700(this.f3179c);
        }
    }

    public static final class e<S> {
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

    static /* synthetic */ LinkedHashSet access$000(MaterialDatePicker r10) {
        return r10.onPositiveButtonClickListeners;
    }

    static /* synthetic */ LinkedHashSet access$100(MaterialDatePicker r10) {
        return r10.onNegativeButtonClickListeners;
    }

    static /* synthetic */ void access$200(MaterialDatePicker r10) {
        r10.updateHeader();
    }

    static /* synthetic */ DateSelector access$300(MaterialDatePicker r10) {
        return r10.getDateSelector();
    }

    static /* synthetic */ Button access$400(MaterialDatePicker r10) {
        return r10.confirmButton;
    }

    static /* synthetic */ CheckableImageButton access$500(MaterialDatePicker r10) {
        return r10.headerToggleButton;
    }

    static /* synthetic */ void access$600(MaterialDatePicker r10, CheckableImageButton r11) {
        r10.updateToggleContentDescription(r11);
    }

    static /* synthetic */ void access$700(MaterialDatePicker r10) {
        r10.startPickerFragment();
    }

    @NonNull
    private static Drawable createHeaderToggleDrawable(Context r10) {
        StateListDrawable r11 = new StateListDrawable();
        r11.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(r10, q5.e.material_ic_calendar_black_24dp));
        r11.addState(new int[0], AppCompatResources.getDrawable(r10, q5.e.material_ic_edit_black_24dp));
        return r11;
    }

    private void enableEdgeToEdgeIfNeeded(Window r10) {
        if (this.edgeToEdgeEnabled == false) goto L5;
        return;
    L5:
        final View r11 = requireView().findViewById(q5.f.fullscreen_header);
        com.google.android.material.internal.e.a(r10, true, ViewUtils.d(r11), null);
        final int r12 = r11.getPaddingTop();
        final int r13 = r11.getLayoutParams().height;
        ViewCompat.setOnApplyWindowInsetsListener(r11, new AnonymousClass3(this, r13, r11, r12));
        this.edgeToEdgeEnabled = true;
    }

    private DateSelector<S> getDateSelector() {
        if (this.dateSelector != null) goto L6;
        this.dateSelector = (DateSelector) getArguments().getParcelable(DATE_SELECTOR_KEY);
    L6:
        return this.dateSelector;
    }

    private static int getPaddedPickerWidth(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        int r12 = r11.getDimensionPixelOffset(q5.d.mtrl_calendar_content_padding);
        int r13 = Month.current().daysInWeek;
        return ((r12 * 2) + (r11.getDimensionPixelSize(q5.d.mtrl_calendar_day_width) * r13)) + ((r13 - 1) * r11.getDimensionPixelOffset(q5.d.mtrl_calendar_month_horizontal_padding));
    }

    private int getThemeResId(Context r10) {
        int r11 = this.overrideThemeResId;
        if (r11 == 0) goto L6;
        return r11;
    L6:
        return getDateSelector().getDefaultThemeResId(r10);
    }

    private void initHeaderToggle(Context r10) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(r10));
        CheckableImageButton r11 = this.headerToggleButton;
        if (this.inputMode == 0) goto L5;
        boolean r12 = true;
    L6:
        r11.setChecked(r12);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new d(this));
        return;
    L5:
        r12 = false;
        goto L6
    }

    static boolean isFullscreen(@NonNull Context r10) {
        return readMaterialCalendarStyleBoolean(r10, R.attr.windowFullscreen);
    }

    static boolean isNestedScrollable(@NonNull Context r10) {
        return readMaterialCalendarStyleBoolean(r10, q5.b.nestedScrollable);
    }

    @NonNull
    static <S> MaterialDatePicker<S> newInstance(@NonNull e<S> r10) {
        new MaterialDatePicker();
        new Bundle();
        throw null;
    }

    static boolean readMaterialCalendarStyleBoolean(@NonNull Context r10, int r11) {
        TypedArray r12 = r10.obtainStyledAttributes(com.google.android.material.resources.b.d(r10, q5.b.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{r11});
        boolean r13 = r12.getBoolean(0, false);
        r12.recycle();
        return r13;
    }

    private void startPickerFragment() {
        int r10 = getThemeResId(requireContext());
        this.calendar = MaterialCalendar.newInstance(getDateSelector(), r10, this.calendarConstraints);
        if (this.headerToggleButton.isChecked() == false) goto L5;
        PickerFragment<S> r11 = MaterialTextInputPicker.newInstance(getDateSelector(), r10, this.calendarConstraints);
    L6:
        this.pickerFragment = r11;
        updateHeader();
        FragmentTransaction r12 = getChildFragmentManager().beginTransaction();
        r12.replace(q5.f.mtrl_calendar_frame, this.pickerFragment);
        r12.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new c(this));
        return;
    L5:
        r11 = this.calendar;
        goto L6
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return j.o().getTimeInMillis();
    }

    private void updateHeader() {
        String r10 = getHeaderText();
        this.headerSelectionText.setContentDescription(String.format(getString(q5.j.mtrl_picker_announce_current_selection), new Object[]{r10}));
        this.headerSelectionText.setText(r10);
    }

    private void updateToggleContentDescription(@NonNull CheckableImageButton r10) {
        boolean r11 = this.headerToggleButton.isChecked();
        Context r12 = r10.getContext();
        if (r11 == false) goto L5;
        int r13 = q5.j.mtrl_picker_toggle_to_calendar_input_mode;
    L6:
        String r14 = r12.getString(r13);
        this.headerToggleButton.setContentDescription(r14);
        return;
    L5:
        r13 = q5.j.mtrl_picker_toggle_to_text_input_mode;
        goto L6
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r10) {
        return this.onCancelListeners.add(r10);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r10) {
        return this.onDismissListeners.add(r10);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r10) {
        return this.onNegativeButtonClickListeners.add(r10);
    }

    public boolean addOnPositiveButtonClickListener(f<? super S> r10) {
        return this.onPositiveButtonClickListeners.add(r10);
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
        return getDateSelector().getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnCancelListener> r11 = this.onCancelListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onCancel(r10);
        goto L4
    L6:
        super.onCancel(r10);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        if (r10 != null) goto L5;
        r10 = getArguments();
    L5:
        this.overrideThemeResId = r10.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) r10.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r10.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.titleTextResId = r10.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = r10.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = r10.getInt(INPUT_MODE_KEY);
        this.positiveButtonTextResId = r10.getInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY);
        this.positiveButtonText = r10.getCharSequence(POSITIVE_BUTTON_TEXT_KEY);
        this.negativeButtonTextResId = r10.getInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY);
        this.negativeButtonText = r10.getCharSequence(NEGATIVE_BUTTON_TEXT_KEY);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r10) {
        Dialog r11 = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context r12 = r11.getContext();
        this.fullscreen = isFullscreen(r12);
        int r13 = com.google.android.material.resources.b.d(r12, q5.b.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(r12, null, q5.b.materialCalendarStyle, k.Widget_MaterialComponents_MaterialCalendar);
        this.background = r14;
        r14.initializeElevationOverlay(r12);
        this.background.setFillColor(ColorStateList.valueOf(r13));
        this.background.setElevation(ViewCompat.getElevation(r11.getWindow().getDecorView()));
        return r11;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        if (this.fullscreen == false) goto L5;
        int r13 = q5.h.mtrl_picker_fullscreen;
    L6:
        View r14 = r10.inflate(r13, r11);
        Context r15 = r14.getContext();
        if (this.fullscreen == false) goto L9;
        View r16 = r14.findViewById(q5.f.mtrl_calendar_frame);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(getPaddedPickerWidth(r15), -2);
    L10:
        r16.setLayoutParams(r17);
        TextView r18 = (TextView) r14.findViewById(q5.f.mtrl_picker_header_selection_text);
        this.headerSelectionText = r18;
        ViewCompat.setAccessibilityLiveRegion(r18, 1);
        this.headerToggleButton = (CheckableImageButton) r14.findViewById(q5.f.mtrl_picker_header_toggle);
        TextView r19 = (TextView) r14.findViewById(q5.f.mtrl_picker_title_text);
        CharSequence r20 = this.titleText;
        if (r20 == null) goto L13;
        r19.setText(r20);
    L14:
        initHeaderToggle(r15);
        this.confirmButton = (Button) r14.findViewById(q5.f.confirm_button);
        if (getDateSelector().isSelectionComplete() == false) goto L17;
        this.confirmButton.setEnabled(true);
    L18:
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        CharSequence r21 = this.positiveButtonText;
        if (r21 == null) goto L21;
        this.confirmButton.setText(r21);
    L24:
        this.confirmButton.setOnClickListener(new a(this));
        Button r22 = (Button) r14.findViewById(q5.f.cancel_button);
        r22.setTag(CANCEL_BUTTON_TAG);
        CharSequence r23 = this.negativeButtonText;
        if (r23 == null) goto L27;
        r22.setText(r23);
    L30:
        r22.setOnClickListener(new b(this));
        return r14;
    L27:
        int r24 = this.negativeButtonTextResId;
        if (r24 == 0) goto L30;
        r22.setText(r24);
        goto L30
    L21:
        int r25 = this.positiveButtonTextResId;
        if (r25 == 0) goto L24;
        this.confirmButton.setText(r25);
        goto L24
    L17:
        this.confirmButton.setEnabled(false);
        goto L18
    L13:
        r19.setText(this.titleTextResId);
        goto L14
    L9:
        r16 = r14.findViewById(q5.f.mtrl_calendar_main_pane);
        r17 = new LinearLayout.LayoutParams(getPaddedPickerWidth(r15), -1);
        goto L10
    L5:
        r13 = q5.h.mtrl_picker_dialog;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnDismissListener> r11 = this.onDismissListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onDismiss(r10);
        goto L4
    L6:
        ViewGroup r12 = (ViewGroup) getView();
        if (r12 == null) goto L9;
        r12.removeAllViews();
    L9:
        super.onDismiss(r10);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        r10.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        r10.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints.b r11 = new CalendarConstraints.b(this.calendarConstraints);
        if (this.calendar.getCurrentMonth() == null) goto L5;
        r11.b(this.calendar.getCurrentMonth().timeInMillis);
    L5:
        r10.putParcelable(CALENDAR_CONSTRAINTS_KEY, r11.a());
        r10.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        r10.putCharSequence(TITLE_TEXT_KEY, this.titleText);
        r10.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, this.positiveButtonTextResId);
        r10.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, this.positiveButtonText);
        r10.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, this.negativeButtonTextResId);
        r10.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, this.negativeButtonText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window r10 = requireDialog().getWindow();
        if (this.fullscreen == false) goto L5;
        r10.setLayout(-1, -1);
        r10.setBackgroundDrawable(this.background);
        enableEdgeToEdgeIfNeeded(r10);
    L6:
        startPickerFragment();
        return;
    L5:
        r10.setLayout(-2, -2);
        int r11 = getResources().getDimensionPixelOffset(q5.d.mtrl_calendar_dialog_background_inset);
        Rect r12 = new Rect(r11, r11, r11, r11);
        r10.setBackgroundDrawable(new InsetDrawable(this.background, r11, r11, r11, r11));
        r10.getDecorView().setOnTouchListener(new u5.a(requireDialog(), r12));
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r10) {
        return this.onCancelListeners.remove(r10);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r10) {
        return this.onDismissListeners.remove(r10);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r10) {
        return this.onNegativeButtonClickListeners.remove(r10);
    }

    public boolean removeOnPositiveButtonClickListener(f<? super S> r10) {
        return this.onPositiveButtonClickListeners.remove(r10);
    }
}
