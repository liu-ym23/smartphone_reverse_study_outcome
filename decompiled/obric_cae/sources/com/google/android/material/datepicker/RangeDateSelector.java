package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.cae.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<i0.c<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f4629b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f4630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f4631n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f4632o;

    public class a implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector createFromParcel(Parcel r8) {
            RangeDateSelector r10 = new RangeDateSelector();
            r10.f4629b = (Long) r8.readValue(Long.class.getClassLoader());
            r10.f4630m = (Long) r8.readValue(Long.class.getClassLoader());
            return r10;
        }

        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector[] newArray(int r8) {
            return new RangeDateSelector[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public RangeDateSelector() {
        this.f4629b = null;
        this.f4630m = null;
        this.f4631n = null;
        this.f4632o = null;
    }

    public static void t(RangeDateSelector r8, TextInputLayout r10, TextInputLayout r11, y r12) {
        Long r13 = r8.f4631n;
        if (r13 == null) goto L15;
        if (r8.f4632o == null) goto L15;
        if (r13.longValue() > r8.f4632o.longValue()) goto L10;
        boolean r14 = true;
    L11:
        if (r14 == false) goto L13;
        Long r15 = r8.f4631n;
        r8.f4629b = r15;
        Long r16 = r8.f4632o;
        r8.f4630m = r16;
        r12.b(new i0.c(r15, r16));
    L26:
        if (TextUtils.isEmpty(r10.getError()) == true) goto L29;
        r10.getError();
        return;
    L29:
        if (TextUtils.isEmpty(r11.getError()) == true) goto L33;
        r11.getError();
        return;
    L33:
        return;
    L13:
        r10.setError(r8.f4628a);
        r11.setError(" ");
    L24:
        r12.a();
        goto L26
    L10:
        r14 = false;
    L15:
        if (r10.getError() == null) goto L20;
        if (r8.f4628a.contentEquals(r10.getError()) == false) goto L20;
        r10.setError(null);
    L20:
        if (r11.getError() == null) goto L24;
        if (" ".contentEquals(r11.getError()) == false) goto L24;
        r11.setError(null);
        goto L24
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String a(Context r8) {
        Resources r10 = r8.getResources();
        i0.c<String, String> r11 = f.a(this.f4629b, this.f4630m);
        String r12 = r11.f8079a;
        if (r12 != null) goto L5;
        String r13 = r10.getString(R.string.mtrl_picker_announce_current_selection_none);
    L6:
        String r14 = r11.f8080b;
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
    public final int b(Context r8) {
        Resources r10 = r8.getResources();
        DisplayMetrics r11 = r10.getDisplayMetrics();
        int r12 = r10.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis);
        if (Math.min(r11.widthPixels, r11.heightPixels) <= r12) goto L5;
        int r13 = R.attr.materialCalendarTheme;
    L7:
        return x9.b.c(r8, r13, r.class.getCanonicalName()).data;
    L5:
        r13 = R.attr.materialCalendarFullscreenTheme;
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String d(Context r8) {
        Resources r10 = r8.getResources();
        Long r11 = this.f4629b;
        if (r11 == null) goto L5;
    L8:
        Long r12 = this.f4630m;
        if (r12 == null) goto L11;
        if (r11 == null) goto L14;
        i0.c<String, String> r13 = f.a(r11, r12);
        return r10.getString(R.string.mtrl_picker_range_header_selected, new Object[]{r13.f8079a, r13.f8080b});
    L14:
        return r10.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{f.b(r12.longValue())});
    L11:
        return r10.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{f.b(r11.longValue())});
    L5:
        if (this.f4630m != null) goto L8;
        return r10.getString(R.string.mtrl_picker_range_header_unselected);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList e() {
        ArrayList r8 = new ArrayList();
        r8.add(new i0.c(this.f4629b, this.f4630m));
        return r8;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final View f(LayoutInflater r18, ViewGroup r19, CalendarConstraints r20, u.a r21) {
        View r10 = r18.inflate(R.layout.mtrl_picker_text_input_date_range, r19, false);
        TextInputLayout r11 = (TextInputLayout) r10.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout r12 = (TextInputLayout) r10.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText r13 = r11.getEditText();
        EditText r14 = r12.getEditText();
        if (l6.a.c0() == false) goto L5;
        r13.setInputType(17);
        r14.setInputType(17);
    L5:
        this.f4628a = r10.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat r15 = g0.d();
        Long r8 = this.f4629b;
        if (r8 == null) goto L8;
        r13.setText(r15.format(r8));
        this.f4631n = this.f4629b;
    L8:
        Long r16 = this.f4630m;
        if (r16 == null) goto L11;
        r14.setText(r15.format(r16));
        this.f4632o = this.f4630m;
    L11:
        String r17 = g0.e(r10.getResources(), r15);
        r11.setPlaceholderText(r17);
        r12.setPlaceholderText(r17);
        r13.addTextChangedListener(new a0(this, r17, r15, r11, r20, r11, r12, r21));
        r14.addTextChangedListener(new b0(this, r17, r15, r12, r20, r11, r12, r21));
        DateSelector.g(new EditText[]{r13, r14});
        return r10;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean h() {
        Long r8 = this.f4629b;
        if (r8 != null) goto L5;
        return false;
    L5:
        if (this.f4630m != null) goto L7;
        return false;
    L7:
        if (r8.longValue() > this.f4630m.longValue()) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == true) goto L12;
        return false;
    L12:
        return true;
    L9:
        r10 = false;
        goto L10
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList i() {
        ArrayList r8 = new ArrayList();
        Long r10 = this.f4629b;
        if (r10 == null) goto L5;
        r8.add(r10);
    L5:
        Long r11 = this.f4630m;
        if (r11 == null) goto L8;
        r8.add(r11);
    L8:
        return r8;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final i0.c<Long, Long> p() {
        return new i0.c(this.f4629b, this.f4630m);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void r(long r8) {
        Long r10 = this.f4629b;
        if (r10 != null) goto L6;
    L14:
        this.f4629b = Long.valueOf(r8);
        return;
    L6:
        if (this.f4630m == null) goto L8;
    L13:
        this.f4630m = null;
        goto L14
    L8:
        if (r10.longValue() > r8) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
        this.f4630m = Long.valueOf(r8);
        return;
    L10:
        r11 = false;
        goto L11
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeValue(this.f4629b);
        r8.writeValue(this.f4630m);
    }
}
