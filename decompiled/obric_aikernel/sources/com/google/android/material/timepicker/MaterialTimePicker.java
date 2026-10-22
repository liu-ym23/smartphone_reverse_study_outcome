package com.google.android.material.timepicker;

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
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import q5.f;
import q5.h;
import q5.j;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.e {
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
    private com.google.android.material.timepicker.b activePresenter;
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

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialTimePicker f4045c;

        a(MaterialTimePicker r10) {
            this.f4045c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            Iterator r11 = MaterialTimePicker.access$900(this.f4045c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((View.OnClickListener) r11.next()).onClick(r10);
            goto L4
        L6:
            this.f4045c.dismiss();
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialTimePicker f4046c;

        b(MaterialTimePicker r10) {
            this.f4046c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            Iterator r11 = MaterialTimePicker.access$1000(this.f4046c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((View.OnClickListener) r11.next()).onClick(r10);
            goto L4
        L6:
            this.f4046c.dismiss();
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialTimePicker f4047c;

        c(MaterialTimePicker r10) {
            this.f4047c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            MaterialTimePicker r11 = this.f4047c;
            if (MaterialTimePicker.access$1100(r11) != 0) goto L5;
            int r12 = 1;
        L6:
            MaterialTimePicker.access$1102(r11, r12);
            MaterialTimePicker r13 = this.f4047c;
            MaterialTimePicker.access$1300(r13, MaterialTimePicker.access$1200(r13));
            return;
        L5:
            r12 = 0;
            goto L6
        }
    }

    public static final class d {
        static /* synthetic */ TimeModel a(d r10) {
            throw null;
        }

        static /* synthetic */ int b(d r10) {
            throw null;
        }

        static /* synthetic */ int c(d r10) {
            throw null;
        }

        static /* synthetic */ CharSequence d(d r10) {
            throw null;
        }

        static /* synthetic */ int e(d r10) {
            throw null;
        }

        static /* synthetic */ CharSequence f(d r10) {
            throw null;
        }

        static /* synthetic */ int g(d r10) {
            throw null;
        }

        static /* synthetic */ CharSequence h(d r10) {
            throw null;
        }

        static /* synthetic */ int i(d r10) {
            throw null;
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

    static /* synthetic */ Set access$1000(MaterialTimePicker r10) {
        return r10.negativeButtonListeners;
    }

    static /* synthetic */ int access$1100(MaterialTimePicker r10) {
        return r10.inputMode;
    }

    static /* synthetic */ int access$1102(MaterialTimePicker r10, int r11) {
        r10.inputMode = r11;
        return r11;
    }

    static /* synthetic */ MaterialButton access$1200(MaterialTimePicker r10) {
        return r10.modeButton;
    }

    static /* synthetic */ void access$1300(MaterialTimePicker r10, MaterialButton r11) {
        r10.updateInputMode(r11);
    }

    static /* synthetic */ MaterialTimePicker access$1400(d r10) {
        return newInstance(r10);
    }

    static /* synthetic */ Set access$900(MaterialTimePicker r10) {
        return r10.positiveButtonListeners;
    }

    private Pair<Integer, Integer> dataForMode(int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return new Pair(Integer.valueOf(this.clockIcon), Integer.valueOf(j.material_timepicker_clock_mode_description));
    L8:
        throw new IllegalArgumentException("no icon for mode: " + r10);
    L10:
        return new Pair(Integer.valueOf(this.keyboardIcon), Integer.valueOf(j.material_timepicker_text_input_mode_description));
    }

    private int getThemeResId() {
        int r10 = this.overrideThemeResId;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        TypedValue r11 = com.google.android.material.resources.b.a(requireContext(), q5.b.materialTimePickerTheme);
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.data;
    }

    private com.google.android.material.timepicker.b initializeOrRetrieveActivePresenterForMode(int r10, @NonNull TimePickerView r11, @NonNull ViewStub r12) {
        if (r10 != 0) goto L9;
        TimePickerClockPresenter r13 = this.timePickerClockPresenter;
        if (r13 != null) goto L6;
        r13 = new TimePickerClockPresenter(r11, this.time);
    L6:
        this.timePickerClockPresenter = r13;
        return r13;
    L9:
        if (this.timePickerTextInputPresenter != null) goto L11;
        this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) r12.inflate(), this.time);
    L11:
        this.timePickerTextInputPresenter.e();
        return this.timePickerTextInputPresenter;
    }

    @NonNull
    private static MaterialTimePicker newInstance(@NonNull d r10) {
        MaterialTimePicker r11 = new MaterialTimePicker();
        Bundle r12 = new Bundle();
        r12.putParcelable(TIME_MODEL_EXTRA, d.a(r10));
        r12.putInt(INPUT_MODE_EXTRA, d.b(r10));
        r12.putInt(TITLE_RES_EXTRA, d.c(r10));
        if (d.d(r10) == null) goto L5;
        r12.putCharSequence(TITLE_TEXT_EXTRA, d.d(r10));
    L5:
        r12.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, d.e(r10));
        if (d.f(r10) == null) goto L8;
        r12.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, d.f(r10));
    L8:
        r12.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, d.g(r10));
        if (d.h(r10) == null) goto L11;
        r12.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, d.h(r10));
    L11:
        r12.putInt(OVERRIDE_THEME_RES_ID, d.i(r10));
        r11.setArguments(r12);
        return r11;
    }

    private void restoreState(@Nullable Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        TimeModel r11 = (TimeModel) r10.getParcelable(TIME_MODEL_EXTRA);
        this.time = r11;
        if (r11 != null) goto L7;
        this.time = new TimeModel();
    L7:
        this.inputMode = r10.getInt(INPUT_MODE_EXTRA, 0);
        this.titleResId = r10.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = r10.getCharSequence(TITLE_TEXT_EXTRA);
        this.positiveButtonTextResId = r10.getInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.positiveButtonText = r10.getCharSequence(POSITIVE_BUTTON_TEXT_EXTRA);
        this.negativeButtonTextResId = r10.getInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.negativeButtonText = r10.getCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA);
        this.overrideThemeResId = r10.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    private void updateCancelButtonVisibility() {
        Button r10 = this.cancelButton;
        if (r10 != null) goto L5;
        return;
    L5:
        if (isCancelable() == false) goto L7;
        int r11 = 0;
    L8:
        r10.setVisibility(r11);
        return;
    L7:
        r11 = 8;
        goto L8
    }

    private void updateInputMode(MaterialButton r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.timePickerView != null) goto L6;
        return;
    L6:
        if (this.textInputStub == null) goto L15;
        com.google.android.material.timepicker.b r11 = this.activePresenter;
        if (r11 == null) goto L11;
        r11.d();
    L11:
        com.google.android.material.timepicker.b r12 = initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
        this.activePresenter = r12;
        r12.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> r13 = dataForMode(this.inputMode);
        r10.setIconResource(((Integer) r13.first).intValue());
        r10.setContentDescription(getResources().getString(((Integer) r13.second).intValue()));
        r10.sendAccessibilityEvent(4);
        return;
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener r10) {
        return this.cancelListeners.add(r10);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener r10) {
        return this.dismissListeners.add(r10);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.negativeButtonListeners.add(r10);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.positiveButtonListeners.add(r10);
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
    TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnCancelListener> r11 = this.cancelListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onCancel(r10);
        goto L4
    L6:
        super.onCancel(r10);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        if (r10 != null) goto L5;
        r10 = getArguments();
    L5:
        restoreState(r10);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r10) {
        Dialog r11 = new Dialog(requireContext(), getThemeResId());
        Context r12 = r11.getContext();
        int r13 = com.google.android.material.resources.b.d(r12, q5.b.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int r14 = q5.b.materialTimePickerStyle;
        int r15 = k.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable r16 = new MaterialShapeDrawable(r12, null, r14, r15);
        TypedArray r17 = r12.obtainStyledAttributes(null, l.MaterialTimePicker, r14, r15);
        this.clockIcon = r17.getResourceId(l.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = r17.getResourceId(l.MaterialTimePicker_keyboardIcon, 0);
        r17.recycle();
        r16.initializeElevationOverlay(r12);
        r16.setFillColor(ColorStateList.valueOf(r13));
        Window r18 = r11.getWindow();
        r18.setBackgroundDrawable(r16);
        r18.requestFeature(1);
        r18.setLayout(-2, -2);
        r16.setElevation(ViewCompat.getElevation(r18.getDecorView()));
        return r11;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        ViewGroup r13 = (ViewGroup) r10.inflate(h.material_timepicker_dialog, r11);
        TimePickerView r14 = (TimePickerView) r13.findViewById(f.material_timepicker_view);
        this.timePickerView = r14;
        r14.setOnDoubleTapListener(this);
        this.textInputStub = (ViewStub) r13.findViewById(f.material_textinput_timepicker);
        this.modeButton = (MaterialButton) r13.findViewById(f.material_timepicker_mode_button);
        TextView r15 = (TextView) r13.findViewById(f.header_title);
        int r16 = this.titleResId;
        if (r16 == 0) goto L6;
        r15.setText(r16);
    L8:
        updateInputMode(this.modeButton);
        Button r17 = (Button) r13.findViewById(f.material_timepicker_ok_button);
        r17.setOnClickListener(new a(this));
        int r18 = this.positiveButtonTextResId;
        if (r18 == 0) goto L12;
        r17.setText(r18);
    L14:
        Button r19 = (Button) r13.findViewById(f.material_timepicker_cancel_button);
        this.cancelButton = r19;
        r19.setOnClickListener(new b(this));
        int r20 = this.negativeButtonTextResId;
        if (r20 == 0) goto L18;
        this.cancelButton.setText(r20);
    L20:
        updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new c(this));
        return r13;
    L18:
        if (TextUtils.isEmpty(this.negativeButtonText) == true) goto L20;
        this.cancelButton.setText(this.negativeButtonText);
        goto L20
    L12:
        if (TextUtils.isEmpty(this.positiveButtonText) == true) goto L14;
        r17.setText(this.positiveButtonText);
        goto L14
    L6:
        if (TextUtils.isEmpty(this.titleText) == true) goto L8;
        r15.setText(this.titleText);
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        TimePickerView r10 = this.timePickerView;
        if (r10 == null) goto L6;
        r10.setOnDoubleTapListener(null);
        this.timePickerView = null;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnDismissListener> r11 = this.dismissListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onDismiss(r10);
        goto L4
    L6:
        super.onDismiss(r10);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.e
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDoubleTap() {
        this.inputMode = 1;
        updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.h();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        r10.putParcelable(TIME_MODEL_EXTRA, this.time);
        r10.putInt(INPUT_MODE_EXTRA, this.inputMode);
        r10.putInt(TITLE_RES_EXTRA, this.titleResId);
        r10.putCharSequence(TITLE_TEXT_EXTRA, this.titleText);
        r10.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, this.positiveButtonTextResId);
        r10.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, this.positiveButtonText);
        r10.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, this.negativeButtonTextResId);
        r10.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, this.negativeButtonText);
        r10.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener r10) {
        return this.cancelListeners.remove(r10);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener r10) {
        return this.dismissListeners.remove(r10);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.negativeButtonListeners.remove(r10);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.positiveButtonListeners.remove(r10);
    }

    @VisibleForTesting
    void setActivePresenter(@Nullable com.google.android.material.timepicker.b r10) {
        this.activePresenter = r10;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean r10) {
        super.setCancelable(r10);
        updateCancelButtonVisibility();
    }

    public void setHour(@IntRange(from = 0, to = 23) int r10) {
        this.time.setHour(r10);
        com.google.android.material.timepicker.b r11 = this.activePresenter;
        if (r11 == null) goto L6;
        r11.invalidate();
        return;
    }

    public void setMinute(@IntRange(from = 0, to = 59) int r10) {
        this.time.setMinute(r10);
        com.google.android.material.timepicker.b r11 = this.activePresenter;
        if (r11 == null) goto L6;
        r11.invalidate();
        return;
    }
}
