package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private CalendarConstraints calendarConstraints;
    private DateSelector<S> dateSelector;
    private int themeResId;

    public MaterialTextInputPicker() {
    }

    static <T> MaterialTextInputPicker<T> newInstance(DateSelector<T> r3, int r4, CalendarConstraints r5) {
        DateSelector r6 = (DateSelector) ZeusTransformUtils.wrapperContextForParams(r3, DateSelector.class, "com.obric.memorydata.plugin");
        MaterialTextInputPicker<T> r0 = new MaterialTextInputPicker();
        Bundle r1 = new Bundle();
        r1.putInt(THEME_RES_ID_KEY, r4);
        r1.putParcelable(DATE_SELECTOR_KEY, r6);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r5);
        r0.setArguments(r1);
        return r0;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public DateSelector<S> getDateSelector() {
        DateSelector<S> r1 = this.dateSelector;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (r4 != null) goto L5;
        r4 = getArguments();
    L5:
        this.themeResId = r4.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) ZeusTransformUtils.preCheckCast(r4.getParcelable(DATE_SELECTOR_KEY), DateSelector.class, "com.obric.memorydata.plugin");
        this.calendarConstraints = (CalendarConstraints) ZeusTransformUtils.preCheckCast(r4.getParcelable(CALENDAR_CONSTRAINTS_KEY), CalendarConstraints.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        LayoutInflater r4 = r10.cloneInContext(new ContextThemeWrapper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.themeResId));
        return this.dateSelector.onCreateTextInputView(r4, r11, r12, this.calendarConstraints, new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putInt(THEME_RES_ID_KEY, this.themeResId);
        r3.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        r3.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
    }
}
