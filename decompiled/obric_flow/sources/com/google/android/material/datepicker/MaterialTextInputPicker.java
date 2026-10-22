package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";

    @Nullable
    private CalendarConstraints calendarConstraints;

    @Nullable
    private DateSelector<S> dateSelector;

    @StyleRes
    private int themeResId;

    public MaterialTextInputPicker() {
    }

    @NonNull
    public static <T> MaterialTextInputPicker<T> newInstance(DateSelector<T> r5, @StyleRes int r10, @NonNull CalendarConstraints r11) {
        MaterialTextInputPicker<T> r12 = new MaterialTextInputPicker();
        Bundle r13 = new Bundle();
        r13.putInt(THEME_RES_ID_KEY, r10);
        r13.putParcelable(DATE_SELECTOR_KEY, r5);
        r13.putParcelable(CALENDAR_CONSTRAINTS_KEY, r11);
        r12.setArguments(r13);
        return r12;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @NonNull
    public DateSelector<S> getDateSelector() {
        DateSelector<S> r5 = this.dateSelector;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        if (r5 != null) goto L5;
        r5 = getArguments();
    L5:
        this.themeResId = r5.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) r5.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r5.getParcelable(CALENDAR_CONSTRAINTS_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        LayoutInflater r5 = r10.cloneInContext(new ContextThemeWrapper(getContext(), this.themeResId));
        return this.dateSelector.onCreateTextInputView(r5, r11, r12, this.calendarConstraints, new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r5) {
        super.onSaveInstanceState(r5);
        r5.putInt(THEME_RES_ID_KEY, this.themeResId);
        r5.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        r5.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
    }
}
