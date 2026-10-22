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
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
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

    class a extends h<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialTextInputPicker f3180a;

        a(MaterialTextInputPicker r10) {
            this.f3180a = r10;
        }

        @Override // com.google.android.material.datepicker.h
        public void a() {
            Iterator<h<S>> r10 = this.f3180a.onSelectionChangedListeners.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r10.next().a();
            goto L4
        }

        @Override // com.google.android.material.datepicker.h
        public void b(S r10) {
            Iterator<h<S>> r11 = this.f3180a.onSelectionChangedListeners.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            r11.next().b(r10);
            goto L4
        }
    }

    public MaterialTextInputPicker() {
    }

    @NonNull
    static <T> MaterialTextInputPicker<T> newInstance(DateSelector<T> r10, @StyleRes int r11, @NonNull CalendarConstraints r12) {
        MaterialTextInputPicker<T> r13 = new MaterialTextInputPicker();
        Bundle r14 = new Bundle();
        r14.putInt(THEME_RES_ID_KEY, r11);
        r14.putParcelable(DATE_SELECTOR_KEY, r10);
        r14.putParcelable(CALENDAR_CONSTRAINTS_KEY, r12);
        r13.setArguments(r14);
        return r13;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @NonNull
    public DateSelector<S> getDateSelector() {
        DateSelector<S> r10 = this.dateSelector;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        if (r10 != null) goto L5;
        r10 = getArguments();
    L5:
        this.themeResId = r10.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) r10.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r10.getParcelable(CALENDAR_CONSTRAINTS_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        LayoutInflater r13 = r10.cloneInContext(new ContextThemeWrapper(getContext(), this.themeResId));
        return this.dateSelector.onCreateTextInputView(r13, r11, r12, this.calendarConstraints, new a(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        r10.putInt(THEME_RES_ID_KEY, this.themeResId);
        r10.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        r10.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
    }
}
