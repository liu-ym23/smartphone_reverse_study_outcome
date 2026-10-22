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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    static final Object CANCEL_BUTTON_TAG = null;
    static final Object CONFIRM_BUTTON_TAG = null;
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_KEY = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_RES_ID_KEY = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
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

    @Nullable
    private DayViewDecorator dayViewDecorator;
    private boolean edgeToEdgeEnabled;

    @Nullable
    private CharSequence fullTitleText;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private TextView headerTitleTextView;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonContentDescription;

    @StringRes
    private int negativeButtonContentDescriptionResId;
    private CharSequence negativeButtonText;

    @StringRes
    private int negativeButtonTextResId;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners;
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners;
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners;
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners;

    @StyleRes
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence positiveButtonContentDescription;

    @StringRes
    private int positiveButtonContentDescriptionResId;
    private CharSequence positiveButtonText;

    @StringRes
    private int positiveButtonTextResId;

    @Nullable
    private CharSequence singleLineTitleText;
    private CharSequence titleText;

    @StringRes
    private int titleTextResId;

    public static final class Builder<S> {
        CalendarConstraints calendarConstraints;
        final DateSelector<S> dateSelector;

        @Nullable
        DayViewDecorator dayViewDecorator;
        int inputMode;
        CharSequence negativeButtonContentDescription;
        int negativeButtonContentDescriptionResId;
        CharSequence negativeButtonText;
        int negativeButtonTextResId;
        int overrideThemeResId;
        CharSequence positiveButtonContentDescription;
        int positiveButtonContentDescriptionResId;
        CharSequence positiveButtonText;
        int positiveButtonTextResId;

        @Nullable
        S selection;
        CharSequence titleText;
        int titleTextResId;

        private Builder(DateSelector<S> r5) {
            this.overrideThemeResId = 0;
            this.titleTextResId = 0;
            this.titleText = null;
            this.positiveButtonTextResId = 0;
            this.positiveButtonText = null;
            this.positiveButtonContentDescriptionResId = 0;
            this.positiveButtonContentDescription = null;
            this.negativeButtonTextResId = 0;
            this.negativeButtonText = null;
            this.negativeButtonContentDescriptionResId = 0;
            this.negativeButtonContentDescription = null;
            this.selection = null;
            this.inputMode = 0;
            this.dateSelector = r5;
        }

        private Month createDefaultOpenAt() {
            if (this.dateSelector.getSelectedDays().isEmpty() == true) goto L7;
            Month r5 = Month.create(this.dateSelector.getSelectedDays().iterator().next().longValue());
            if (monthInValidRange(r5, this.calendarConstraints) == false) goto L7;
            return r5;
        L7:
            Month r10 = Month.current();
            if (monthInValidRange(r10, this.calendarConstraints) == false) goto L11;
            return r10;
        L11:
            return this.calendarConstraints.getStart();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> r5) {
            return new Builder(r5);
        }

        @NonNull
        public static Builder<Long> datePicker() {
            return new Builder(new SingleDateSelector());
        }

        @NonNull
        public static Builder<Pair<Long, Long>> dateRangePicker() {
            return new Builder(new RangeDateSelector());
        }

        private static boolean monthInValidRange(Month r5, CalendarConstraints r10) {
            if (r5.compareTo2(r10.getStart()) >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r5.compareTo2(r10.getEnd()) > 0) goto L7;
            return true;
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            if (this.calendarConstraints != null) goto L6;
            this.calendarConstraints = new CalendarConstraints.Builder().build();
        L6:
            if (this.titleTextResId != 0) goto L8;
            this.titleTextResId = this.dateSelector.getDefaultTitleResId();
        L8:
            S r5 = this.selection;
            if (r5 == null) goto L12;
            this.dateSelector.setSelection(r5);
        L12:
            if (this.calendarConstraints.getOpenAt() != null) goto L15;
            this.calendarConstraints.setOpenAt(createDefaultOpenAt());
        L15:
            return MaterialDatePicker.newInstance(this);
        }

        @NonNull
        public Builder<S> setCalendarConstraints(CalendarConstraints r5) {
            this.calendarConstraints = r5;
            return this;
        }

        @NonNull
        public Builder<S> setDayViewDecorator(@Nullable DayViewDecorator r5) {
            this.dayViewDecorator = r5;
            return this;
        }

        @NonNull
        public Builder<S> setInputMode(int r5) {
            this.inputMode = r5;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonContentDescription(@StringRes int r5) {
            this.negativeButtonContentDescriptionResId = r5;
            this.negativeButtonContentDescription = null;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonText(@StringRes int r5) {
            this.negativeButtonTextResId = r5;
            this.negativeButtonText = null;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonContentDescription(@StringRes int r5) {
            this.positiveButtonContentDescriptionResId = r5;
            this.positiveButtonContentDescription = null;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonText(@StringRes int r5) {
            this.positiveButtonTextResId = r5;
            this.positiveButtonText = null;
            return this;
        }

        @NonNull
        public Builder<S> setSelection(S r5) {
            this.selection = r5;
            return this;
        }

        @NonNull
        public Builder<S> setTextInputFormat(@Nullable SimpleDateFormat r5) {
            this.dateSelector.setTextInputFormat(r5);
            return this;
        }

        @NonNull
        public Builder<S> setTheme(@StyleRes int r5) {
            this.overrideThemeResId = r5;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@StringRes int r5) {
            this.titleTextResId = r5;
            this.titleText = null;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonContentDescription(@Nullable CharSequence r5) {
            this.negativeButtonContentDescription = r5;
            this.negativeButtonContentDescriptionResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonText(@Nullable CharSequence r5) {
            this.negativeButtonText = r5;
            this.negativeButtonTextResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonContentDescription(@Nullable CharSequence r5) {
            this.positiveButtonContentDescription = r5;
            this.positiveButtonContentDescriptionResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonText(@Nullable CharSequence r5) {
            this.positiveButtonText = r5;
            this.positiveButtonTextResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@Nullable CharSequence r5) {
            this.titleText = r5;
            this.titleTextResId = 0;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
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

    public static /* synthetic */ LinkedHashSet access$000(MaterialDatePicker r5) {
        return r5.onPositiveButtonClickListeners;
    }

    public static /* synthetic */ LinkedHashSet access$100(MaterialDatePicker r5) {
        return r5.onNegativeButtonClickListeners;
    }

    public static /* synthetic */ DateSelector access$200(MaterialDatePicker r5) {
        return r5.getDateSelector();
    }

    public static /* synthetic */ Button access$300(MaterialDatePicker r5) {
        return r5.confirmButton;
    }

    public static /* synthetic */ void b(MaterialDatePicker r5, View r10) {
        r5.lambda$initHeaderToggle$0(r10);
    }

    @NonNull
    private static Drawable createHeaderToggleDrawable(Context r5) {
        StateListDrawable r10 = new StateListDrawable();
        r10.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(r5, com.google.android.material.R.drawable.material_ic_calendar_black_24dp));
        r10.addState(new int[0], AppCompatResources.getDrawable(r5, com.google.android.material.R.drawable.material_ic_edit_black_24dp));
        return r10;
    }

    private void enableEdgeToEdgeIfNeeded(Window r5) {
        if (this.edgeToEdgeEnabled == false) goto L5;
        return;
    L5:
        final View r10 = requireView().findViewById(com.google.android.material.R.id.fullscreen_header);
        EdgeToEdgeUtils.applyEdgeToEdge(r5, true, ViewUtils.getBackgroundColor(r10), null);
        final int r11 = r10.getPaddingTop();
        final int r12 = r10.getLayoutParams().height;
        ViewCompat.setOnApplyWindowInsetsListener(r10, new AnonymousClass3(this, r12, r10, r11));
        this.edgeToEdgeEnabled = true;
    }

    private DateSelector<S> getDateSelector() {
        if (this.dateSelector != null) goto L6;
        this.dateSelector = (DateSelector) getArguments().getParcelable(DATE_SELECTOR_KEY);
    L6:
        return this.dateSelector;
    }

    @Nullable
    private static CharSequence getFirstLineBySeparator(@Nullable CharSequence r5) {
        if (r5 == null) goto L7;
        String[] r10 = TextUtils.split(String.valueOf(r5), "\n");
        if (r10.length > 1) goto L6;
        return r5;
    L6:
        return r10[0];
    L7:
        return null;
    }

    private String getHeaderContentDescription() {
        return getDateSelector().getSelectionContentDescription(requireContext());
    }

    private static int getPaddedPickerWidth(@NonNull Context r5) {
        Resources r10 = r5.getResources();
        int r11 = r10.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_content_padding);
        int r12 = Month.current().daysInWeek;
        int r13 = r10.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_width) * r12;
        return ((r12 - 1) * r10.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_horizontal_padding)) + (r13 + (r11 * 2));
    }

    private int getThemeResId(Context r5) {
        int r10 = this.overrideThemeResId;
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return getDateSelector().getDefaultThemeResId(r5);
    }

    private void initHeaderToggle(Context r5) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(r5));
        CheckableImageButton r10 = this.headerToggleButton;
        if (this.inputMode == 0) goto L5;
        boolean r11 = true;
    L6:
        r10.setChecked(r11);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new ar.a(this, 9));
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static boolean isFullscreen(@NonNull Context r5) {
        return readMaterialCalendarStyleBoolean(r5, R.attr.windowFullscreen);
    }

    private boolean isLandscape() {
        if (getResources().getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNestedScrollable(@NonNull Context r5) {
        return readMaterialCalendarStyleBoolean(r5, com.google.android.material.R.attr.nestedScrollable);
    }

    private /* synthetic */ void lambda$initHeaderToggle$0(View r5) {
        this.confirmButton.setEnabled(getDateSelector().isSelectionComplete());
        this.headerToggleButton.toggle();
        int r10 = 1;
        if (this.inputMode != 1) goto L5;
        r10 = 0;
    L5:
        this.inputMode = r10;
        updateToggleContentDescription(this.headerToggleButton);
        startPickerFragment();
    }

    @NonNull
    public static <S> MaterialDatePicker<S> newInstance(@NonNull Builder<S> r5) {
        MaterialDatePicker<S> r10 = new MaterialDatePicker();
        Bundle r11 = new Bundle();
        r11.putInt(OVERRIDE_THEME_RES_ID, r5.overrideThemeResId);
        r11.putParcelable(DATE_SELECTOR_KEY, r5.dateSelector);
        r11.putParcelable(CALENDAR_CONSTRAINTS_KEY, r5.calendarConstraints);
        r11.putParcelable(DAY_VIEW_DECORATOR_KEY, r5.dayViewDecorator);
        r11.putInt(TITLE_TEXT_RES_ID_KEY, r5.titleTextResId);
        r11.putCharSequence(TITLE_TEXT_KEY, r5.titleText);
        r11.putInt(INPUT_MODE_KEY, r5.inputMode);
        r11.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, r5.positiveButtonTextResId);
        r11.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, r5.positiveButtonText);
        r11.putInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, r5.positiveButtonContentDescriptionResId);
        r11.putCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY, r5.positiveButtonContentDescription);
        r11.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, r5.negativeButtonTextResId);
        r11.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, r5.negativeButtonText);
        r11.putInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, r5.negativeButtonContentDescriptionResId);
        r11.putCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY, r5.negativeButtonContentDescription);
        r10.setArguments(r11);
        return r10;
    }

    public static boolean readMaterialCalendarStyleBoolean(@NonNull Context r5, int r10) {
        TypedArray r11 = r5.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(r5, com.google.android.material.R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{r10});
        boolean r12 = r11.getBoolean(0, false);
        r11.recycle();
        return r12;
    }

    private void startPickerFragment() {
        int r5 = getThemeResId(requireContext());
        MaterialTextInputPicker r10 = MaterialCalendar.newInstance(getDateSelector(), r5, this.calendarConstraints, this.dayViewDecorator);
        this.calendar = r10;
        if (this.inputMode != 1) goto L5;
        r10 = MaterialTextInputPicker.newInstance(getDateSelector(), r5, this.calendarConstraints);
    L5:
        this.pickerFragment = r10;
        updateTitle();
        updateHeader(getHeaderText());
        FragmentTransaction r11 = getChildFragmentManager().beginTransaction();
        r11.replace(com.google.android.material.R.id.mtrl_calendar_frame, this.pickerFragment);
        r11.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new AnonymousClass4(this));
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    private void updateTitle() {
        TextView r5 = this.headerTitleTextView;
        if (this.inputMode == 1) goto L5;
    L7:
        CharSequence r10 = this.fullTitleText;
    L8:
        r5.setText(r10);
        return;
    L5:
        if (isLandscape() == false) goto L7;
        r10 = this.singleLineTitleText;
        goto L8
    }

    private void updateToggleContentDescription(@NonNull CheckableImageButton r5) {
        if (this.inputMode != 1) goto L5;
        String r10 = r5.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_calendar_input_mode);
    L6:
        this.headerToggleButton.setContentDescription(r10);
        return;
    L5:
        r10 = r5.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_text_input_mode);
        goto L6
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r5) {
        return this.onCancelListeners.add(r5);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r5) {
        return this.onDismissListeners.add(r5);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r5) {
        return this.onNegativeButtonClickListeners.add(r5);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r5) {
        return this.onPositiveButtonClickListeners.add(r5);
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

    public int getInputMode() {
        return this.inputMode;
    }

    @Nullable
    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r5) {
        Iterator<DialogInterface.OnCancelListener> r10 = this.onCancelListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onCancel(r5);
        goto L4
    L6:
        super.onCancel(r5);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        if (r5 != null) goto L5;
        r5 = getArguments();
    L5:
        this.overrideThemeResId = r5.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) r5.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r5.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) r5.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.titleTextResId = r5.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = r5.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = r5.getInt(INPUT_MODE_KEY);
        this.positiveButtonTextResId = r5.getInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY);
        this.positiveButtonText = r5.getCharSequence(POSITIVE_BUTTON_TEXT_KEY);
        this.positiveButtonContentDescriptionResId = r5.getInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY);
        this.positiveButtonContentDescription = r5.getCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY);
        this.negativeButtonTextResId = r5.getInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY);
        this.negativeButtonText = r5.getCharSequence(NEGATIVE_BUTTON_TEXT_KEY);
        this.negativeButtonContentDescriptionResId = r5.getInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY);
        this.negativeButtonContentDescription = r5.getCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY);
        CharSequence r10 = this.titleText;
        if (r10 != null) goto L9;
        r10 = requireContext().getResources().getText(this.titleTextResId);
    L9:
        this.fullTitleText = r10;
        this.singleLineTitleText = getFirstLineBySeparator(r10);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r10) {
        Dialog r11 = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context r5 = r11.getContext();
        this.fullscreen = isFullscreen(r5);
        this.background = new MaterialShapeDrawable(r5, null, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray r12 = r5.obtainStyledAttributes(null, com.google.android.material.R.styleable.MaterialCalendar, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.R.style.Widget_MaterialComponents_MaterialCalendar);
        int r13 = r12.getColor(com.google.android.material.R.styleable.MaterialCalendar_backgroundTint, 0);
        r12.recycle();
        this.background.initializeElevationOverlay(r5);
        this.background.setFillColor(ColorStateList.valueOf(r13));
        this.background.setElevation(ViewCompat.getElevation(r11.getWindow().getDecorView()));
        return r11;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r5, @Nullable ViewGroup r10, @Nullable Bundle r11) {
        if (this.fullscreen == false) goto L5;
        int r12 = com.google.android.material.R.layout.mtrl_picker_fullscreen;
    L6:
        View r13 = r5.inflate(r12, r10);
        Context r14 = r13.getContext();
        DayViewDecorator r15 = this.dayViewDecorator;
        if (r15 == null) goto L10;
        r15.initialize(r14);
    L10:
        if (this.fullscreen == false) goto L12;
        r13.findViewById(com.google.android.material.R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r14), -2));
    L13:
        TextView r16 = (TextView) r13.findViewById(com.google.android.material.R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = r16;
        ViewCompat.setAccessibilityLiveRegion(r16, 1);
        this.headerToggleButton = (CheckableImageButton) r13.findViewById(com.google.android.material.R.id.mtrl_picker_header_toggle);
        this.headerTitleTextView = (TextView) r13.findViewById(com.google.android.material.R.id.mtrl_picker_title_text);
        initHeaderToggle(r14);
        this.confirmButton = (Button) r13.findViewById(com.google.android.material.R.id.confirm_button);
        if (getDateSelector().isSelectionComplete() == false) goto L16;
        this.confirmButton.setEnabled(true);
    L17:
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        CharSequence r17 = this.positiveButtonText;
        if (r17 == null) goto L20;
        this.confirmButton.setText(r17);
    L23:
        CharSequence r18 = this.positiveButtonContentDescription;
        if (r18 == null) goto L27;
        this.confirmButton.setContentDescription(r18);
    L29:
        this.confirmButton.setOnClickListener(new AnonymousClass1(this));
        Button r19 = (Button) r13.findViewById(com.google.android.material.R.id.cancel_button);
        r19.setTag(CANCEL_BUTTON_TAG);
        CharSequence r20 = this.negativeButtonText;
        if (r20 == null) goto L32;
        r19.setText(r20);
    L35:
        CharSequence r21 = this.negativeButtonContentDescription;
        if (r21 == null) goto L39;
        r19.setContentDescription(r21);
    L41:
        r19.setOnClickListener(new AnonymousClass2(this));
        return r13;
    L39:
        if (this.negativeButtonContentDescriptionResId == 0) goto L41;
        r19.setContentDescription(getContext().getResources().getText(this.negativeButtonContentDescriptionResId));
        goto L41
    L32:
        int r22 = this.negativeButtonTextResId;
        if (r22 == 0) goto L35;
        r19.setText(r22);
        goto L35
    L27:
        if (this.positiveButtonContentDescriptionResId == 0) goto L29;
        this.confirmButton.setContentDescription(getContext().getResources().getText(this.positiveButtonContentDescriptionResId));
        goto L29
    L20:
        int r23 = this.positiveButtonTextResId;
        if (r23 == 0) goto L23;
        this.confirmButton.setText(r23);
        goto L23
    L16:
        this.confirmButton.setEnabled(false);
        goto L17
    L12:
        r13.findViewById(com.google.android.material.R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r14), -1));
        goto L13
    L5:
        r12 = com.google.android.material.R.layout.mtrl_picker_dialog;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r5) {
        Iterator<DialogInterface.OnDismissListener> r10 = this.onDismissListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onDismiss(r5);
        goto L4
    L6:
        ViewGroup r11 = (ViewGroup) getView();
        if (r11 == null) goto L9;
        r11.removeAllViews();
    L9:
        super.onDismiss(r5);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle r5) {
        super.onSaveInstanceState(r5);
        r5.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        r5.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints.Builder r10 = new CalendarConstraints.Builder(this.calendarConstraints);
        MaterialCalendar<S> r11 = this.calendar;
        if (r11 != null) goto L5;
        Month r12 = null;
    L6:
        if (r12 == null) goto L8;
        r10.setOpenAt(r12.timeInMillis);
    L8:
        r5.putParcelable(CALENDAR_CONSTRAINTS_KEY, r10.build());
        r5.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        r5.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        r5.putCharSequence(TITLE_TEXT_KEY, this.titleText);
        r5.putInt(INPUT_MODE_KEY, this.inputMode);
        r5.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, this.positiveButtonTextResId);
        r5.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, this.positiveButtonText);
        r5.putInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, this.positiveButtonContentDescriptionResId);
        r5.putCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY, this.positiveButtonContentDescription);
        r5.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, this.negativeButtonTextResId);
        r5.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, this.negativeButtonText);
        r5.putInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, this.negativeButtonContentDescriptionResId);
        r5.putCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY, this.negativeButtonContentDescription);
        return;
    L5:
        r12 = r11.getCurrentMonth();
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window r5 = requireDialog().getWindow();
        if (this.fullscreen == false) goto L5;
        r5.setLayout(-1, -1);
        r5.setBackgroundDrawable(this.background);
        enableEdgeToEdgeIfNeeded(r5);
    L6:
        startPickerFragment();
        return;
    L5:
        r5.setLayout(-2, -2);
        int r10 = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_dialog_background_inset);
        Rect r11 = new Rect(r10, r10, r10, r10);
        r5.setBackgroundDrawable(new InsetDrawable(this.background, r10, r10, r10, r10));
        r5.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), r11));
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r5) {
        return this.onCancelListeners.remove(r5);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r5) {
        return this.onDismissListeners.remove(r5);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r5) {
        return this.onNegativeButtonClickListeners.remove(r5);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r5) {
        return this.onPositiveButtonClickListeners.remove(r5);
    }

    @VisibleForTesting
    public void updateHeader(String r5) {
        this.headerSelectionText.setContentDescription(getHeaderContentDescription());
        this.headerSelectionText.setText(r5);
    }
}
