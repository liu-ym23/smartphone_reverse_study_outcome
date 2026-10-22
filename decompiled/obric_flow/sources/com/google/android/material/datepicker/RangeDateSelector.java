package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = null;

    @Nullable
    private CharSequence error;
    private final String invalidRangeEndError;
    private String invalidRangeStartError;

    @Nullable
    private Long proposedTextEnd;

    @Nullable
    private Long proposedTextStart;

    @Nullable
    private Long selectedEndItem;

    @Nullable
    private Long selectedStartItem;

    @Nullable
    private SimpleDateFormat textInputFormat;

    static {
        CREATOR = new AnonymousClass3();
    }

    public RangeDateSelector() {
        this.invalidRangeEndError = " ";
        this.selectedStartItem = null;
        this.selectedEndItem = null;
        this.proposedTextStart = null;
        this.proposedTextEnd = null;
    }

    public static /* synthetic */ Long access$002(RangeDateSelector r5, Long r10) {
        r5.proposedTextStart = r10;
        return r10;
    }

    public static /* synthetic */ void access$100(RangeDateSelector r5, TextInputLayout r10, TextInputLayout r11, OnSelectionChangedListener r12) {
        r5.updateIfValidTextProposal(r10, r11, r12);
    }

    public static /* synthetic */ Long access$202(RangeDateSelector r5, Long r10) {
        r5.proposedTextEnd = r10;
        return r10;
    }

    public static /* synthetic */ Long access$302(RangeDateSelector r5, Long r10) {
        r5.selectedStartItem = r10;
        return r10;
    }

    public static /* synthetic */ Long access$402(RangeDateSelector r5, Long r10) {
        r5.selectedEndItem = r10;
        return r10;
    }

    private void clearInvalidRange(@NonNull TextInputLayout r5, @NonNull TextInputLayout r10) {
        if (r5.getError() == null) goto L8;
        if (this.invalidRangeStartError.contentEquals(r5.getError()) == false) goto L8;
        r5.setError(null);
    L8:
        if (r10.getError() != null) goto L10;
        return;
    L10:
        if (" ".contentEquals(r10.getError()) == false) goto L14;
        r10.setError(null);
        return;
    }

    private boolean isValidRange(long r5, long r10) {
        if (r5 > r10) goto L5;
        return true;
    L5:
        return false;
    }

    private void setInvalidRange(@NonNull TextInputLayout r5, @NonNull TextInputLayout r10) {
        r5.setError(this.invalidRangeStartError);
        r10.setError(" ");
    }

    private void updateError(@NonNull TextInputLayout r5, @NonNull TextInputLayout r10) {
        if (TextUtils.isEmpty(r5.getError()) == true) goto L6;
        this.error = r5.getError();
        return;
    L6:
        if (TextUtils.isEmpty(r10.getError()) == true) goto L8;
        this.error = r10.getError();
        return;
    L8:
        this.error = null;
    }

    private void updateIfValidTextProposal(@NonNull TextInputLayout r5, @NonNull TextInputLayout r10, @NonNull OnSelectionChangedListener<Pair<Long, Long>> r11) {
        Long r12 = this.proposedTextStart;
        if (r12 != null) goto L5;
    L11:
        clearInvalidRange(r5, r10);
        r11.onIncompleteSelectionChanged();
    L12:
        updateError(r5, r10);
        return;
    L5:
        if (this.proposedTextEnd == null) goto L11;
        if (isValidRange(r12.longValue(), this.proposedTextEnd.longValue()) == false) goto L10;
        this.selectedStartItem = this.proposedTextStart;
        this.selectedEndItem = this.proposedTextEnd;
        r11.onSelectionChanged(getSelection());
        goto L12
    L10:
        setInvalidRange(r5, r10);
        r11.onIncompleteSelectionChanged();
        goto L12
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context r5) {
        Resources r10 = r5.getResources();
        DisplayMetrics r11 = r10.getDisplayMetrics();
        int r12 = r10.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis);
        if (Math.min(r11.widthPixels, r11.heightPixels) <= r12) goto L5;
        int r13 = R.attr.materialCalendarTheme;
    L7:
        return MaterialAttributes.resolveOrThrow(r5, r13, MaterialDatePicker.class.getCanonicalName());
    L5:
        r13 = R.attr.materialCalendarFullscreenTheme;
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
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
        Long r10 = this.selectedStartItem;
        if (r10 == null) goto L5;
        r5.add(r10);
    L5:
        Long r11 = this.selectedEndItem;
        if (r11 == null) goto L8;
        r5.add(r11);
    L8:
        return r5;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        ArrayList r5 = new ArrayList();
        r5.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return r5;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public /* bridge */ /* synthetic */ Pair<Long, Long> getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionContentDescription(@NonNull Context r5) {
        Resources r10 = r5.getResources();
        Pair<String, String> r11 = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem);
        String r12 = r11.first;
        if (r12 != null) goto L5;
        String r13 = r10.getString(R.string.mtrl_picker_announce_current_selection_none);
    L6:
        String r14 = r11.second;
        if (r14 != null) goto L9;
        String r15 = r10.getString(R.string.mtrl_picker_announce_current_selection_none);
    L11:
        return r10.getString(R.string.mtrl_picker_announce_current_range_selection, new Object[]{r13, r15});
    L9:
        r15 = r14;
        goto L11
    L5:
        r13 = r12;
        goto L6
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context r5) {
        Resources r10 = r5.getResources();
        Long r11 = this.selectedStartItem;
        if (r11 == null) goto L5;
    L8:
        Long r12 = this.selectedEndItem;
        if (r12 == null) goto L11;
        if (r11 == null) goto L14;
        Pair<String, String> r13 = DateStrings.getDateRangeString(r11, r12);
        return r10.getString(R.string.mtrl_picker_range_header_selected, new Object[]{r13.first, r13.second});
    L14:
        return r10.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{DateStrings.getDateString(r12.longValue())});
    L11:
        return r10.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{DateStrings.getDateString(r11.longValue())});
    L5:
        if (this.selectedEndItem != null) goto L8;
        return r10.getString(R.string.mtrl_picker_range_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long r5 = this.selectedStartItem;
        if (r5 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.selectedEndItem == null) goto L9;
        if (isValidRange(r5.longValue(), this.selectedEndItem.longValue()) == false) goto L9;
        return true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater r18, @Nullable ViewGroup r19, @Nullable Bundle r20, final CalendarConstraints r21, @NonNull final OnSelectionChangedListener<Pair<Long, Long>> r22) {
        boolean r5 = false;
        View r10 = r18.inflate(R.layout.mtrl_picker_text_input_date_range, r19, false);
        final TextInputLayout r11 = (TextInputLayout) r10.findViewById(R.id.mtrl_picker_text_input_range_start);
        final TextInputLayout r12 = (TextInputLayout) r10.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText r13 = r11.getEditText();
        EditText r14 = r12.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters() == false) goto L5;
        r13.setInputType(17);
        r14.setInputType(17);
    L5:
        this.invalidRangeStartError = r10.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat r15 = this.textInputFormat;
        if (r15 == null) goto L8;
        r5 = true;
    L8:
        if (r5 == false) goto L10;
    L9:
        final SimpleDateFormat r16 = r15;
        Long r17 = this.selectedStartItem;
        if (r17 == null) goto L14;
        r13.setText(r16.format(r17));
        this.proposedTextStart = this.selectedStartItem;
    L14:
        Long r23 = this.selectedEndItem;
        if (r23 == null) goto L17;
        r14.setText(r16.format(r23));
        this.proposedTextEnd = this.selectedEndItem;
    L17:
        if (r5 == false) goto L20;
        String r24 = r16.toPattern();
    L19:
        final String r25 = r24;
        r11.setPlaceholderText(r25);
        r12.setPlaceholderText(r25);
        r13.addTextChangedListener(new AnonymousClass1(this, r25, r16, r11, r21, r11, r12, r22));
        r14.addTextChangedListener(new AnonymousClass2(this, r25, r16, r12, r21, r11, r12, r22));
        DateSelector.showKeyboardWithAutoHideBehavior(new EditText[]{r13, r14});
        return r10;
    L20:
        r24 = UtcDates.getDefaultTextInputHint(r10.getResources(), r16);
        goto L19
    L10:
        r15 = UtcDates.getDefaultTextInputFormat();
        goto L9
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r5) {
        Long r10 = this.selectedStartItem;
        if (r10 != null) goto L6;
        this.selectedStartItem = Long.valueOf(r5);
        return;
    L6:
        if (this.selectedEndItem == null) goto L8;
    L10:
        this.selectedEndItem = null;
        this.selectedStartItem = Long.valueOf(r5);
        return;
    L8:
        if (isValidRange(r10.longValue(), r5) == false) goto L10;
        this.selectedEndItem = Long.valueOf(r5);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(@NonNull Pair<Long, Long> r5) {
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
        r5.writeValue(this.selectedStartItem);
        r5.writeValue(this.selectedEndItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair(this.selectedStartItem, this.selectedEndItem);
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(@NonNull Pair<Long, Long> r5) {
        Long r10 = r5.first;
        if (r10 != null) goto L5;
    L7:
        Long r11 = r5.first;
        Long r12 = null;
        if (r11 != null) goto L10;
        Long r13 = null;
    L11:
        this.selectedStartItem = r13;
        Long r14 = r5.second;
        if (r14 == null) goto L15;
        r12 = Long.valueOf(UtcDates.canonicalYearMonthDay(r14.longValue()));
    L15:
        this.selectedEndItem = r12;
        return;
    L10:
        r13 = Long.valueOf(UtcDates.canonicalYearMonthDay(r11.longValue()));
        goto L11
    L5:
        if (r5.second == null) goto L7;
        Preconditions.checkArgument(isValidRange(r10.longValue(), r5.second.longValue()));
        goto L7
    }
}
