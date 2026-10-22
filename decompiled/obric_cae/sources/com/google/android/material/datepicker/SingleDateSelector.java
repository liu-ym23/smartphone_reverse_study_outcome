package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.cae.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f4633a;

    public class a implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        public final SingleDateSelector createFromParcel(Parcel r8) {
            SingleDateSelector r10 = new SingleDateSelector();
            r10.f4633a = (Long) r8.readValue(Long.class.getClassLoader());
            return r10;
        }

        @Override // android.os.Parcelable.Creator
        public final SingleDateSelector[] newArray(int r8) {
            return new SingleDateSelector[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public SingleDateSelector() {
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String a(Context r8) {
        Resources r10 = r8.getResources();
        Long r11 = this.f4633a;
        if (r11 != null) goto L5;
        String r12 = r10.getString(R.string.mtrl_picker_announce_current_selection_none);
    L7:
        return r10.getString(R.string.mtrl_picker_announce_current_selection, new Object[]{r12});
    L5:
        r12 = f.d(r11.longValue(), Locale.getDefault());
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int b(Context r8) {
        return x9.b.c(r8, R.attr.materialCalendarTheme, r.class.getCanonicalName()).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String d(Context r8) {
        Resources r10 = r8.getResources();
        Long r11 = this.f4633a;
        if (r11 != null) goto L7;
        return r10.getString(R.string.mtrl_picker_date_header_unselected);
    L7:
        return r10.getString(R.string.mtrl_picker_date_header_selected, new Object[]{f.d(r11.longValue(), Locale.getDefault())});
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList e() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final View f(LayoutInflater r10, ViewGroup r11, CalendarConstraints r12, u.a r13) {
        View r14 = r10.inflate(R.layout.mtrl_picker_text_input_date, r11, false);
        TextInputLayout r8 = (TextInputLayout) r14.findViewById(R.id.mtrl_picker_text_input_date);
        EditText r15 = r8.getEditText();
        if (l6.a.c0() == false) goto L5;
        r15.setInputType(17);
    L5:
        SimpleDateFormat r16 = g0.d();
        String r17 = g0.e(r14.getResources(), r16);
        r8.setPlaceholderText(r17);
        Long r18 = this.f4633a;
        if (r18 == null) goto L8;
        r15.setText(r16.format(r18));
    L8:
        r15.addTextChangedListener(new c0(this, r17, r16, r8, r12, r13, r8));
        DateSelector.g(new EditText[]{r15});
        return r14;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean h() {
        if (this.f4633a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList i() {
        ArrayList r8 = new ArrayList();
        Long r10 = this.f4633a;
        if (r10 == null) goto L5;
        r8.add(r10);
    L5:
        return r8;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Long p() {
        return this.f4633a;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void r(long r8) {
        this.f4633a = Long.valueOf(r8);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeValue(this.f4633a);
    }
}
