package com.google.android.material.timepicker;

import ai.j0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String NEGATIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String NEGATIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String POSITIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String POSITIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";

    @Nullable
    private TimePickerPresenter activePresenter;
    private Button cancelButton;
    private final Set<DialogInterface.OnCancelListener> cancelListeners;

    @DrawableRes
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners;
    private int inputMode;

    @DrawableRes
    private int keyboardIcon;
    private MaterialButton modeButton;
    private final Set<View.OnClickListener> negativeButtonListeners;
    private CharSequence negativeButtonText;

    @StringRes
    private int negativeButtonTextResId;
    private int overrideThemeResId;
    private final Set<View.OnClickListener> positiveButtonListeners;
    private CharSequence positiveButtonText;

    @StringRes
    private int positiveButtonTextResId;
    private ViewStub textInputStub;
    private TimeModel time;

    @Nullable
    private TimePickerClockPresenter timePickerClockPresenter;

    @Nullable
    private TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;

    @StringRes
    private int titleResId;
    private CharSequence titleText;

    public static final class Builder {

        @Nullable
        private Integer inputMode;
        private CharSequence negativeButtonText;

        @StringRes
        private int negativeButtonTextResId;
        private int overrideThemeResId;
        private CharSequence positiveButtonText;

        @StringRes
        private int positiveButtonTextResId;
        private TimeModel time;
        private CharSequence titleText;

        @StringRes
        private int titleTextResId;

        public Builder() {
            this.time = new TimeModel();
            this.titleTextResId = 0;
            this.positiveButtonTextResId = 0;
            this.negativeButtonTextResId = 0;
            this.overrideThemeResId = 0;
        }

        public static /* synthetic */ TimeModel access$000(Builder r5) {
            return r5.time;
        }

        public static /* synthetic */ Integer access$100(Builder r5) {
            return r5.inputMode;
        }

        public static /* synthetic */ int access$200(Builder r5) {
            return r5.titleTextResId;
        }

        public static /* synthetic */ CharSequence access$300(Builder r5) {
            return r5.titleText;
        }

        public static /* synthetic */ int access$400(Builder r5) {
            return r5.positiveButtonTextResId;
        }

        public static /* synthetic */ CharSequence access$500(Builder r5) {
            return r5.positiveButtonText;
        }

        public static /* synthetic */ int access$600(Builder r5) {
            return r5.negativeButtonTextResId;
        }

        public static /* synthetic */ CharSequence access$700(Builder r5) {
            return r5.negativeButtonText;
        }

        public static /* synthetic */ int access$800(Builder r5) {
            return r5.overrideThemeResId;
        }

        @NonNull
        public MaterialTimePicker build() {
            return MaterialTimePicker.access$1400(this);
        }

        @NonNull
        public Builder setHour(@IntRange(from = 0, to = 23) int r5) {
            this.time.setHourOfDay(r5);
            return this;
        }

        @NonNull
        public Builder setInputMode(int r5) {
            this.inputMode = Integer.valueOf(r5);
            return this;
        }

        @NonNull
        public Builder setMinute(@IntRange(from = 0, to = 59) int r5) {
            this.time.setMinute(r5);
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@StringRes int r5) {
            this.negativeButtonTextResId = r5;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@StringRes int r5) {
            this.positiveButtonTextResId = r5;
            return this;
        }

        @NonNull
        public Builder setTheme(@StyleRes int r5) {
            this.overrideThemeResId = r5;
            return this;
        }

        @NonNull
        public Builder setTimeFormat(int r5) {
            TimeModel r10 = this.time;
            int r11 = r10.hour;
            int r12 = r10.minute;
            TimeModel r13 = new TimeModel(r5);
            this.time = r13;
            r13.setMinute(r12);
            this.time.setHourOfDay(r11);
            return this;
        }

        @NonNull
        public Builder setTitleText(@StringRes int r5) {
            this.titleTextResId = r5;
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@Nullable CharSequence r5) {
            this.negativeButtonText = r5;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@Nullable CharSequence r5) {
            this.positiveButtonText = r5;
            return this;
        }

        @NonNull
        public Builder setTitleText(@Nullable CharSequence r5) {
            this.titleText = r5;
            return this;
        }
    }

    public MaterialTimePicker() {
        this.positiveButtonListeners = new LinkedHashSet();
        this.negativeButtonListeners = new LinkedHashSet();
        this.cancelListeners = new LinkedHashSet();
        this.dismissListeners = new LinkedHashSet();
        this.titleResId = 0;
        this.positiveButtonTextResId = 0;
        this.negativeButtonTextResId = 0;
        this.inputMode = 0;
        this.overrideThemeResId = 0;
    }

    public static /* synthetic */ Set access$1000(MaterialTimePicker r5) {
        return r5.negativeButtonListeners;
    }

    public static /* synthetic */ int access$1100(MaterialTimePicker r5) {
        return r5.inputMode;
    }

    public static /* synthetic */ int access$1102(MaterialTimePicker r5, int r10) {
        r5.inputMode = r10;
        return r10;
    }

    public static /* synthetic */ MaterialButton access$1200(MaterialTimePicker r5) {
        return r5.modeButton;
    }

    public static /* synthetic */ void access$1300(MaterialTimePicker r5, MaterialButton r10) {
        r5.updateInputMode(r10);
    }

    public static /* synthetic */ MaterialTimePicker access$1400(Builder r5) {
        return newInstance(r5);
    }

    public static /* synthetic */ Set access$900(MaterialTimePicker r5) {
        return r5.positiveButtonListeners;
    }

    public static /* synthetic */ void b(MaterialTimePicker r5) {
        r5.lambda$onViewCreated$0();
    }

    private Pair<Integer, Integer> dataForMode(int r5) {
        if (r5 == 0) goto L10;
        if (r5 != 1) goto L8;
        return new Pair(Integer.valueOf(this.clockIcon), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
    L8:
        throw new IllegalArgumentException(j0.g(r5, "no icon for mode: "));
    L10:
        return new Pair(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
    }

    private int getThemeResId() {
        int r5 = this.overrideThemeResId;
        if (r5 == 0) goto L5;
        return r5;
    L5:
        TypedValue r10 = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (r10 != null) goto L9;
        return 0;
    L9:
        return r10.data;
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int r5, @NonNull TimePickerView r10, @NonNull ViewStub r11) {
        if (r5 != 0) goto L9;
        TimePickerClockPresenter r12 = this.timePickerClockPresenter;
        if (r12 != null) goto L6;
        r12 = new TimePickerClockPresenter(r10, this.time);
    L6:
        this.timePickerClockPresenter = r12;
        return r12;
    L9:
        if (this.timePickerTextInputPresenter != null) goto L11;
        this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) r11.inflate(), this.time);
    L11:
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    private /* synthetic */ void lambda$onViewCreated$0() {
        TimePickerPresenter r5 = this.activePresenter;
        if ((r5 instanceof TimePickerTextInputPresenter) == false) goto L6;
        ((TimePickerTextInputPresenter) r5).resetChecked();
        return;
    }

    @NonNull
    private static MaterialTimePicker newInstance(@NonNull Builder r5) {
        MaterialTimePicker r10 = new MaterialTimePicker();
        Bundle r11 = new Bundle();
        r11.putParcelable(TIME_MODEL_EXTRA, Builder.access$000(r5));
        if (Builder.access$100(r5) == null) goto L5;
        r11.putInt(INPUT_MODE_EXTRA, Builder.access$100(r5).intValue());
    L5:
        r11.putInt(TITLE_RES_EXTRA, Builder.access$200(r5));
        if (Builder.access$300(r5) == null) goto L8;
        r11.putCharSequence(TITLE_TEXT_EXTRA, Builder.access$300(r5));
    L8:
        r11.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, Builder.access$400(r5));
        if (Builder.access$500(r5) == null) goto L11;
        r11.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, Builder.access$500(r5));
    L11:
        r11.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, Builder.access$600(r5));
        if (Builder.access$700(r5) == null) goto L14;
        r11.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, Builder.access$700(r5));
    L14:
        r11.putInt(OVERRIDE_THEME_RES_ID, Builder.access$800(r5));
        r10.setArguments(r11);
        return r10;
    }

    private void restoreState(@Nullable Bundle r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        TimeModel r10 = (TimeModel) r5.getParcelable(TIME_MODEL_EXTRA);
        this.time = r10;
        if (r10 != null) goto L7;
        this.time = new TimeModel();
    L7:
        int r11 = 1;
        if (this.time.format == 1) goto L11;
        r11 = 0;
    L11:
        this.inputMode = r5.getInt(INPUT_MODE_EXTRA, r11);
        this.titleResId = r5.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = r5.getCharSequence(TITLE_TEXT_EXTRA);
        this.positiveButtonTextResId = r5.getInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.positiveButtonText = r5.getCharSequence(POSITIVE_BUTTON_TEXT_EXTRA);
        this.negativeButtonTextResId = r5.getInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.negativeButtonText = r5.getCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA);
        this.overrideThemeResId = r5.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    private void updateCancelButtonVisibility() {
        Button r5 = this.cancelButton;
        if (r5 != null) goto L5;
        return;
    L5:
        if (isCancelable() == false) goto L7;
        int r10 = 0;
    L8:
        r5.setVisibility(r10);
        return;
    L7:
        r10 = 8;
        goto L8
    }

    private void updateInputMode(MaterialButton r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.timePickerView != null) goto L6;
        return;
    L6:
        if (this.textInputStub == null) goto L15;
        TimePickerPresenter r10 = this.activePresenter;
        if (r10 == null) goto L11;
        r10.hide();
    L11:
        TimePickerPresenter r11 = initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
        this.activePresenter = r11;
        r11.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> r12 = dataForMode(this.inputMode);
        r5.setIconResource(((Integer) r12.first).intValue());
        r5.setContentDescription(getResources().getString(((Integer) r12.second).intValue()));
        r5.sendAccessibilityEvent(4);
        return;
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener r5) {
        return this.cancelListeners.add(r5);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener r5) {
        return this.dismissListeners.add(r5);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener r5) {
        return this.negativeButtonListeners.add(r5);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener r5) {
        return this.positiveButtonListeners.add(r5);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    @IntRange(from = 0, to = 23)
    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @IntRange(from = 0, to = 59)
    public int getMinute() {
        return this.time.minute;
    }

    @Nullable
    public TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r5) {
        Iterator<DialogInterface.OnCancelListener> r10 = this.cancelListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onCancel(r5);
        goto L4
    L6:
        super.onCancel(r5);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        if (r5 != null) goto L5;
        r5 = getArguments();
    L5:
        restoreState(r5);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r10) {
        Dialog r11 = new Dialog(requireContext(), getThemeResId());
        Context r5 = r11.getContext();
        MaterialShapeDrawable r12 = new MaterialShapeDrawable(r5, null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray r13 = r5.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.clockIcon = r13.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = r13.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        int r14 = r13.getColor(R.styleable.MaterialTimePicker_backgroundTint, 0);
        r13.recycle();
        r12.initializeElevationOverlay(r5);
        r12.setFillColor(ColorStateList.valueOf(r14));
        Window r15 = r11.getWindow();
        r15.setBackgroundDrawable(r12);
        r15.requestFeature(1);
        r15.setLayout(-2, -2);
        r12.setElevation(ViewCompat.getElevation(r15.getDecorView()));
        return r11;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r5, @Nullable ViewGroup r10, @Nullable Bundle r11) {
        ViewGroup r12 = (ViewGroup) r5.inflate(R.layout.material_timepicker_dialog, r10);
        TimePickerView r13 = (TimePickerView) r12.findViewById(R.id.material_timepicker_view);
        this.timePickerView = r13;
        r13.setOnDoubleTapListener(this);
        this.textInputStub = (ViewStub) r12.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) r12.findViewById(R.id.material_timepicker_mode_button);
        TextView r14 = (TextView) r12.findViewById(R.id.header_title);
        int r15 = this.titleResId;
        if (r15 == 0) goto L6;
        r14.setText(r15);
    L8:
        updateInputMode(this.modeButton);
        Button r16 = (Button) r12.findViewById(R.id.material_timepicker_ok_button);
        r16.setOnClickListener(new AnonymousClass1(this));
        int r17 = this.positiveButtonTextResId;
        if (r17 == 0) goto L12;
        r16.setText(r17);
    L14:
        Button r18 = (Button) r12.findViewById(R.id.material_timepicker_cancel_button);
        this.cancelButton = r18;
        r18.setOnClickListener(new AnonymousClass2(this));
        int r19 = this.negativeButtonTextResId;
        if (r19 == 0) goto L18;
        this.cancelButton.setText(r19);
    L20:
        updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new AnonymousClass3(this));
        return r12;
    L18:
        if (TextUtils.isEmpty(this.negativeButtonText) == true) goto L20;
        this.cancelButton.setText(this.negativeButtonText);
        goto L20
    L12:
        if (TextUtils.isEmpty(this.positiveButtonText) == true) goto L14;
        r16.setText(this.positiveButtonText);
        goto L14
    L6:
        if (TextUtils.isEmpty(this.titleText) == true) goto L8;
        r14.setText(this.titleText);
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        TimePickerView r5 = this.timePickerView;
        if (r5 == null) goto L6;
        r5.setOnDoubleTapListener(null);
        this.timePickerView = null;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r5) {
        Iterator<DialogInterface.OnDismissListener> r10 = this.dismissListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onDismiss(r5);
        goto L4
    L6:
        super.onDismiss(r5);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDoubleTap() {
        this.inputMode = 1;
        updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.resetChecked();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r5) {
        super.onSaveInstanceState(r5);
        r5.putParcelable(TIME_MODEL_EXTRA, this.time);
        r5.putInt(INPUT_MODE_EXTRA, this.inputMode);
        r5.putInt(TITLE_RES_EXTRA, this.titleResId);
        r5.putCharSequence(TITLE_TEXT_EXTRA, this.titleText);
        r5.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, this.positiveButtonTextResId);
        r5.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, this.positiveButtonText);
        r5.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, this.negativeButtonTextResId);
        r5.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, this.negativeButtonText);
        r5.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View r5, @Nullable Bundle r10) {
        super.onViewCreated(r5, r10);
        if ((this.activePresenter instanceof TimePickerTextInputPresenter) == false) goto L6;
        r5.postDelayed(new b(this, 1), 100);
        return;
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener r5) {
        return this.cancelListeners.remove(r5);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener r5) {
        return this.dismissListeners.remove(r5);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener r5) {
        return this.negativeButtonListeners.remove(r5);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener r5) {
        return this.positiveButtonListeners.remove(r5);
    }

    @VisibleForTesting
    public void setActivePresenter(@Nullable TimePickerPresenter r5) {
        this.activePresenter = r5;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean r5) {
        super.setCancelable(r5);
        updateCancelButtonVisibility();
    }

    public void setHour(@IntRange(from = 0, to = 23) int r5) {
        this.time.setHour(r5);
        TimePickerPresenter r10 = this.activePresenter;
        if (r10 == null) goto L6;
        r10.invalidate();
        return;
    }

    public void setMinute(@IntRange(from = 0, to = 59) int r5) {
        this.time.setMinute(r5);
        TimePickerPresenter r10 = this.activePresenter;
        if (r10 == null) goto L6;
        r10.invalidate();
        return;
    }
}
