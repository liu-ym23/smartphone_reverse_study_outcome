package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = null;
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

    class a extends com.google.android.material.datepicker.c {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3183l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3184m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ h f3185n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ RangeDateSelector f3186o;

        a(RangeDateSelector r10, String r11, DateFormat r12, TextInputLayout r13, CalendarConstraints r14, TextInputLayout r15, TextInputLayout r16, h r17) {
            this.f3186o = r10;
            this.f3183l = r15;
            this.f3184m = r16;
            this.f3185n = r17;
            super(r11, r12, r13, r14);
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.access$002(this.f3186o, null);
            RangeDateSelector.access$100(this.f3186o, this.f3183l, this.f3184m, this.f3185n);
        }

        @Override // com.google.android.material.datepicker.c
        void f(@Nullable Long r10) {
            RangeDateSelector.access$002(this.f3186o, r10);
            RangeDateSelector.access$100(this.f3186o, this.f3183l, this.f3184m, this.f3185n);
        }
    }

    class b extends com.google.android.material.datepicker.c {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3187l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f3188m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ h f3189n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ RangeDateSelector f3190o;

        b(RangeDateSelector r10, String r11, DateFormat r12, TextInputLayout r13, CalendarConstraints r14, TextInputLayout r15, TextInputLayout r16, h r17) {
            this.f3190o = r10;
            this.f3187l = r15;
            this.f3188m = r16;
            this.f3189n = r17;
            super(r11, r12, r13, r14);
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.access$202(this.f3190o, null);
            RangeDateSelector.access$100(this.f3190o, this.f3187l, this.f3188m, this.f3189n);
        }

        @Override // com.google.android.material.datepicker.c
        void f(@Nullable Long r10) {
            RangeDateSelector.access$202(this.f3190o, r10);
            RangeDateSelector.access$100(this.f3190o, this.f3187l, this.f3188m, this.f3189n);
        }
    }

    class c implements Parcelable.Creator<RangeDateSelector> {
        c() {
        }

        @NonNull
        public RangeDateSelector a(@NonNull Parcel r10) {
            RangeDateSelector r11 = new RangeDateSelector();
            RangeDateSelector.access$302(r11, (Long) r10.readValue(Long.class.getClassLoader()));
            RangeDateSelector.access$402(r11, (Long) r10.readValue(Long.class.getClassLoader()));
            return r11;
        }

        @NonNull
        public RangeDateSelector[] b(int r10) {
            return new RangeDateSelector[r10];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ RangeDateSelector createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ RangeDateSelector[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new c();
    }

    public RangeDateSelector() {
        this.invalidRangeEndError = " ";
        this.selectedStartItem = null;
        this.selectedEndItem = null;
        this.proposedTextStart = null;
        this.proposedTextEnd = null;
    }

    static /* synthetic */ Long access$002(RangeDateSelector r10, Long r11) {
        r10.proposedTextStart = r11;
        return r11;
    }

    static /* synthetic */ void access$100(RangeDateSelector r10, TextInputLayout r11, TextInputLayout r12, h r13) {
        r10.updateIfValidTextProposal(r11, r12, r13);
    }

    static /* synthetic */ Long access$202(RangeDateSelector r10, Long r11) {
        r10.proposedTextEnd = r11;
        return r11;
    }

    static /* synthetic */ Long access$302(RangeDateSelector r10, Long r11) {
        r10.selectedStartItem = r11;
        return r11;
    }

    static /* synthetic */ Long access$402(RangeDateSelector r10, Long r11) {
        r10.selectedEndItem = r11;
        return r11;
    }

    private void clearInvalidRange(@NonNull TextInputLayout r10, @NonNull TextInputLayout r11) {
        if (r10.getError() == null) goto L8;
        if (this.invalidRangeStartError.contentEquals(r10.getError()) == false) goto L8;
        r10.setError(null);
    L8:
        if (r11.getError() != null) goto L10;
        return;
    L10:
        if (" ".contentEquals(r11.getError()) == false) goto L14;
        r11.setError(null);
        return;
    }

    private boolean isValidRange(long r10, long r11) {
        if (r10 > r11) goto L5;
        return true;
    L5:
        return false;
    }

    private void setInvalidRange(@NonNull TextInputLayout r10, @NonNull TextInputLayout r11) {
        r10.setError(this.invalidRangeStartError);
        r11.setError(" ");
    }

    private void updateIfValidTextProposal(@NonNull TextInputLayout r10, @NonNull TextInputLayout r11, @NonNull h<Pair<Long, Long>> r12) {
        Long r13 = this.proposedTextStart;
        if (r13 != null) goto L5;
    L12:
        clearInvalidRange(r10, r11);
        r12.a();
        return;
    L5:
        if (this.proposedTextEnd == null) goto L12;
        if (isValidRange(r13.longValue(), this.proposedTextEnd.longValue()) == false) goto L10;
        this.selectedStartItem = this.proposedTextStart;
        this.selectedEndItem = this.proposedTextEnd;
        r12.b(getSelection());
        return;
    L10:
        setInvalidRange(r10, r11);
        r12.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        DisplayMetrics r12 = r11.getDisplayMetrics();
        int r13 = r11.getDimensionPixelSize(q5.d.mtrl_calendar_maximum_default_fullscreen_minor_axis);
        if (Math.min(r12.widthPixels, r12.heightPixels) <= r13) goto L5;
        int r14 = q5.b.materialCalendarTheme;
    L7:
        return com.google.android.material.resources.b.d(r10, r14, MaterialDatePicker.class.getCanonicalName());
    L5:
        r14 = q5.b.materialCalendarFullscreenTheme;
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return q5.j.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList r10 = new ArrayList();
        Long r11 = this.selectedStartItem;
        if (r11 == null) goto L5;
        r10.add(r11);
    L5:
        Long r12 = this.selectedEndItem;
        if (r12 == null) goto L8;
        r10.add(r12);
    L8:
        return r10;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem == null) goto L10;
        if (this.selectedEndItem == null) goto L10;
        ArrayList r10 = new ArrayList();
        r10.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return r10;
    L10:
        return new ArrayList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public /* bridge */ /* synthetic */ Pair<Long, Long> getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        Long r12 = this.selectedStartItem;
        if (r12 == null) goto L5;
    L8:
        Long r13 = this.selectedEndItem;
        if (r13 == null) goto L11;
        if (r12 == null) goto L14;
        Pair<String, String> r14 = d.a(r12, r13);
        return r11.getString(q5.j.mtrl_picker_range_header_selected, new Object[]{r14.first, r14.second});
    L14:
        return r11.getString(q5.j.mtrl_picker_range_header_only_end_selected, new Object[]{d.c(r13.longValue())});
    L11:
        return r11.getString(q5.j.mtrl_picker_range_header_only_start_selected, new Object[]{d.c(r12.longValue())});
    L5:
        if (this.selectedEndItem != null) goto L8;
        return r11.getString(q5.j.mtrl_picker_range_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long r10 = this.selectedStartItem;
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.selectedEndItem == null) goto L9;
        if (isValidRange(r10.longValue(), this.selectedEndItem.longValue()) == false) goto L9;
        return true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater r18, @Nullable ViewGroup r19, @Nullable Bundle r20, CalendarConstraints r21, @NonNull h<Pair<Long, Long>> r22) {
        View r10 = r18.inflate(q5.h.mtrl_picker_text_input_date_range, r19, false);
        TextInputLayout r11 = (TextInputLayout) r10.findViewById(q5.f.mtrl_picker_text_input_range_start);
        TextInputLayout r12 = (TextInputLayout) r10.findViewById(q5.f.mtrl_picker_text_input_range_end);
        EditText r13 = r11.getEditText();
        EditText r14 = r12.getEditText();
        if (com.google.android.material.internal.f.a() == false) goto L5;
        r13.setInputType(17);
        r14.setInputType(17);
    L5:
        this.invalidRangeStartError = r10.getResources().getString(q5.j.mtrl_picker_invalid_range);
        SimpleDateFormat r15 = j.k();
        Long r16 = this.selectedStartItem;
        if (r16 == null) goto L8;
        r13.setText(r15.format(r16));
        this.proposedTextStart = this.selectedStartItem;
    L8:
        Long r17 = this.selectedEndItem;
        if (r17 == null) goto L11;
        r14.setText(r15.format(r17));
        this.proposedTextEnd = this.selectedEndItem;
    L11:
        String r23 = j.l(r10.getResources(), r15);
        r11.setPlaceholderText(r23);
        r12.setPlaceholderText(r23);
        r13.addTextChangedListener(new a(this, r23, r15, r11, r21, r11, r12, r22));
        r14.addTextChangedListener(new b(this, r23, r15, r12, r21, r11, r12, r22));
        ViewUtils.l(r13);
        return r10;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r10) {
        Long r11 = this.selectedStartItem;
        if (r11 != null) goto L6;
    L4:
        this.selectedStartItem = Long.valueOf(r10);
        return;
    L6:
        if (this.selectedEndItem == null) goto L8;
    L10:
        this.selectedEndItem = null;
        goto L4
    L8:
        if (isValidRange(r11.longValue(), r10) == false) goto L10;
        this.selectedEndItem = Long.valueOf(r10);
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(@NonNull Pair<Long, Long> r10) {
        Long r11 = r10.first;
        if (r11 != null) goto L5;
    L7:
        Long r12 = r10.first;
        Long r13 = null;
        if (r12 != null) goto L10;
        Long r14 = null;
    L11:
        this.selectedStartItem = r14;
        Long r15 = r10.second;
        if (r15 == null) goto L15;
        r13 = Long.valueOf(j.a(r15.longValue()));
    L15:
        this.selectedEndItem = r13;
        return;
    L10:
        r14 = Long.valueOf(j.a(r12.longValue()));
        goto L11
    L5:
        if (r10.second == null) goto L7;
        Preconditions.checkArgument(isValidRange(r11.longValue(), r10.second.longValue()));
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(@NonNull Pair<Long, Long> r10) {
        setSelection2(r10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeValue(this.selectedStartItem);
        r10.writeValue(this.selectedEndItem);
    }
}
