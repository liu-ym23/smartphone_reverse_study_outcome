package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = null;

    @Nullable
    private Long selectedItem;

    class a extends c {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ h f3191l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ SingleDateSelector f3192m;

        a(SingleDateSelector r10, String r11, DateFormat r12, TextInputLayout r13, CalendarConstraints r14, h r15) {
            this.f3192m = r10;
            this.f3191l = r15;
            super(r11, r12, r13, r14);
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            this.f3191l.a();
        }

        @Override // com.google.android.material.datepicker.c
        void f(@Nullable Long r10) {
            if (r10 != null) goto L4;
            SingleDateSelector.access$000(this.f3192m);
        L5:
            this.f3191l.b(this.f3192m.getSelection());
            return;
        L4:
            this.f3192m.select(r10.longValue());
            goto L5
        }
    }

    class b implements Parcelable.Creator<SingleDateSelector> {
        b() {
        }

        @NonNull
        public SingleDateSelector a(@NonNull Parcel r10) {
            SingleDateSelector r11 = new SingleDateSelector();
            SingleDateSelector.access$102(r11, (Long) r10.readValue(Long.class.getClassLoader()));
            return r11;
        }

        @NonNull
        public SingleDateSelector[] b(int r10) {
            return new SingleDateSelector[r10];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ SingleDateSelector createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ SingleDateSelector[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new b();
    }

    public SingleDateSelector() {
    }

    static /* synthetic */ void access$000(SingleDateSelector r10) {
        r10.clearSelection();
    }

    static /* synthetic */ Long access$102(SingleDateSelector r10, Long r11) {
        r10.selectedItem = r11;
        return r11;
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r10) {
        return com.google.android.material.resources.b.d(r10, q5.b.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return q5.j.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList r10 = new ArrayList();
        Long r11 = this.selectedItem;
        if (r11 == null) goto L5;
        r10.add(r11);
    L5:
        return r10;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public /* bridge */ /* synthetic */ Long getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        Long r12 = this.selectedItem;
        if (r12 == null) goto L5;
        String r13 = d.j(r12.longValue());
        return r11.getString(q5.j.mtrl_picker_date_header_selected, new Object[]{r13});
    L5:
        return r11.getString(q5.j.mtrl_picker_date_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        if (this.selectedItem == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12, CalendarConstraints r13, @NonNull h<Long> r14) {
        View r15 = r10.inflate(q5.h.mtrl_picker_text_input_date, r11, false);
        TextInputLayout r16 = (TextInputLayout) r15.findViewById(q5.f.mtrl_picker_text_input_date);
        EditText r17 = r16.getEditText();
        if (com.google.android.material.internal.f.a() == false) goto L5;
        r17.setInputType(17);
    L5:
        SimpleDateFormat r18 = j.k();
        String r19 = j.l(r15.getResources(), r18);
        r16.setPlaceholderText(r19);
        Long r110 = this.selectedItem;
        if (r110 == null) goto L8;
        r17.setText(r18.format(r110));
    L8:
        r17.addTextChangedListener(new a(this, r19, r18, r16, r13, r14));
        ViewUtils.l(r17);
        return r15;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r10) {
        this.selectedItem = Long.valueOf(r10);
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(@Nullable Long r10) {
        if (r10 != null) goto L4;
        Long r11 = null;
    L5:
        this.selectedItem = r11;
        return;
    L4:
        r11 = Long.valueOf(j.a(r10.longValue()));
        goto L5
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(@Nullable Long r10) {
        setSelection2(r10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeValue(this.selectedItem);
    }
}
