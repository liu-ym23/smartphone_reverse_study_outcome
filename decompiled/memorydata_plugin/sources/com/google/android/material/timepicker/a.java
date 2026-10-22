package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4202a;

    public a(int r1) {
        this.f4202a = r1;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r3, int r4, int r5, Spanned r6, int r7, int r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder((Spanned) ZeusTransformUtils.wrapperContextForParams(r6, Spanned.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L9
        r0.replace(r7, r8, r9.subSequence(r4, r5).toString());     // Catch: NumberFormatException -> L9
        if (Integer.parseInt(r0.toString()) > this.f4202a) goto L7;
        return null;
    L7:
        return "";
    L12:
        return "";
    }
}
