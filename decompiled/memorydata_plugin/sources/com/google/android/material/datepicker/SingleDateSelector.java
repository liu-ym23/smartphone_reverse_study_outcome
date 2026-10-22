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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Pair;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.internal.r;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = null;
    private Long selectedItem;

    static {
        CREATOR = new AnonymousClass2();
    }

    public SingleDateSelector() {
    }

    static /* synthetic */ void access$000(SingleDateSelector r0) {
        r0.clearSelection();
    }

    static /* synthetic */ Long access$102(SingleDateSelector r0, Long r1) {
        r0.selectedItem = r1;
        return r1;
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r3) {
        return com.google.android.material.resources.b.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.materialCalendarTheme, "attr", "materialCalendarTheme"), MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return ZeusTransformUtils.mapRes(R.string.mtrl_picker_date_header_title, TypedValues.Custom.S_STRING, "mtrl_picker_date_header_title");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList r0 = new ArrayList();
        Long r1 = this.selectedItem;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        return r0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ Long getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context r4) {
        Resources r5 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        Long r3 = this.selectedItem;
        if (r3 == null) goto L5;
        String r6 = d.b(r3.longValue());
        return r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_date_header_selected, TypedValues.Custom.S_STRING, "mtrl_picker_date_header_selected"), new Object[]{r6});
    L5:
        return r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_date_header_unselected, TypedValues.Custom.S_STRING, "mtrl_picker_date_header_unselected"));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        if (this.selectedItem == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater r11, ViewGroup r12, Bundle r13, final CalendarConstraints r14, final h<Long> r15) {
        View r16 = ZeusTransformUtils.inflate(r11, ZeusTransformUtils.mapRes(R.layout.mtrl_picker_text_input_date, "layout", "mtrl_picker_text_input_date"), r12, false, "com.obric.memorydata.plugin");
        final TextInputLayout r7 = (TextInputLayout) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_picker_text_input_date, OaidModel.KEY_ID, "mtrl_picker_text_input_date")), TextInputLayout.class, "com.obric.memorydata.plugin");
        EditText r17 = r7.getEditText();
        if (com.google.android.material.internal.f.d() == false) goto L5;
        r17.setInputType(17);
    L5:
        final SimpleDateFormat r6 = j.d();
        final String r5 = j.a(ZeusTransformUtils.getResources(r16, "com.obric.memorydata.plugin"), r6);
        r7.setPlaceholderText(r5);
        Long r18 = this.selectedItem;
        if (r18 == null) goto L8;
        r17.setText(r6.format(r18));
    L8:
        r17.addTextChangedListener(new AnonymousClass1(this, r5, r6, r7, r14, r15));
        r.b(r17);
        return r16;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r1) {
        this.selectedItem = Long.valueOf(r1);
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(Long r3) {
        if (r3 != null) goto L4;
        Long r4 = null;
    L5:
        this.selectedItem = r4;
        return;
    L4:
        r4 = Long.valueOf(j.a(r3.longValue()));
        goto L5
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* synthetic */ void setSelection(Long r3) {
        setSelection2((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeValue(this.selectedItem);
    }
}
