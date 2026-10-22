package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = null;

    @Nullable
    private CharSequence error;

    @Nullable
    private Long selectedItem;

    @Nullable
    private SimpleDateFormat textInputFormat;

    static {
        CREATOR = new AnonymousClass2();
    }

    public SingleDateSelector() {
    }

    public static /* synthetic */ void access$000(SingleDateSelector r5) {
        r5.clearSelection();
    }

    public static /* synthetic */ CharSequence access$102(SingleDateSelector r5, CharSequence r10) {
        r5.error = r10;
        return r10;
    }

    public static /* synthetic */ Long access$202(SingleDateSelector r5, Long r10) {
        r5.selectedItem = r10;
        return r10;
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r5) {
        return MaterialAttributes.resolveOrThrow(r5, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public String getError() {
        if (TextUtils.isEmpty(this.error) == false) goto L6;
        return null;
    L6:
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList r5 = new ArrayList();
        Long r10 = this.selectedItem;
        if (r10 == null) goto L5;
        r5.add(r10);
    L5:
        return r5;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public /* bridge */ /* synthetic */ Long getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionContentDescription(@NonNull Context r5) {
        Resources r10 = r5.getResources();
        Long r11 = this.selectedItem;
        if (r11 != null) goto L5;
        String r12 = r10.getString(R.string.mtrl_picker_announce_current_selection_none);
    L7:
        return r10.getString(R.string.mtrl_picker_announce_current_selection, new Object[]{r12});
    L5:
        r12 = DateStrings.getYearMonthDay(r11.longValue());
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context r5) {
        Resources r10 = r5.getResources();
        Long r11 = this.selectedItem;
        if (r11 == null) goto L5;
        String r12 = DateStrings.getYearMonthDay(r11.longValue());
        return r10.getString(R.string.mtrl_picker_date_header_selected, new Object[]{r12});
    L5:
        return r10.getString(R.string.mtrl_picker_date_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        if (this.selectedItem == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12, final CalendarConstraints r13, @NonNull final OnSelectionChangedListener<Long> r14) {
        boolean r5 = false;
        View r15 = r10.inflate(R.layout.mtrl_picker_text_input_date, r11, false);
        final TextInputLayout r16 = (TextInputLayout) r15.findViewById(R.id.mtrl_picker_text_input_date);
        EditText r17 = r16.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters() == false) goto L5;
        r17.setInputType(17);
    L5:
        SimpleDateFormat r18 = this.textInputFormat;
        if (r18 == null) goto L8;
        r5 = true;
    L8:
        if (r5 == false) goto L10;
    L9:
        final SimpleDateFormat r19 = r18;
        if (r5 == false) goto L14;
        String r110 = r19.toPattern();
    L13:
        final String r20 = r110;
        r16.setPlaceholderText(r20);
        Long r111 = this.selectedItem;
        if (r111 == null) goto L18;
        r17.setText(r19.format(r111));
    L18:
        r17.addTextChangedListener(new AnonymousClass1(this, r20, r19, r16, r13, r14, r16));
        DateSelector.showKeyboardWithAutoHideBehavior(new EditText[]{r17});
        return r15;
    L14:
        r110 = UtcDates.getDefaultTextInputHint(r15.getResources(), r19);
        goto L13
    L10:
        r18 = UtcDates.getDefaultTextInputFormat();
        goto L9
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r5) {
        this.selectedItem = Long.valueOf(r5);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(@Nullable Long r5) {
        setSelection2(r5);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(@Nullable SimpleDateFormat r5) {
        if (r5 == null) goto L4;
        r5 = (SimpleDateFormat) UtcDates.getNormalizedFormat(r5);
    L4:
        this.textInputFormat = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r5, int r10) {
        r5.writeValue(this.selectedItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public Long getSelection() {
        return this.selectedItem;
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(@Nullable Long r5) {
        if (r5 != null) goto L4;
        Long r10 = null;
    L5:
        this.selectedItem = r10;
        return;
    L4:
        r10 = Long.valueOf(UtcDates.canonicalYearMonthDay(r5.longValue()));
        goto L5
    }
}
