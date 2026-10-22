package com.obric.oui.stepper;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes2.dex */
public class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0135a f7457c;

    /* JADX INFO: renamed from: com.obric.oui.stepper.a$a, reason: collision with other inner class name */
    interface InterfaceC0135a {
        void a(int r10);
    }

    public a(int r10, int r11, InterfaceC0135a r12) {
        this.f7455a = r10;
        this.f7456b = r11;
        this.f7457c = r12;
    }

    private boolean a(int r10, int r11, int r12) {
        if (r11 <= r10) goto L7;
        if (r12 < r10) goto L11;
        if (r12 > r11) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r12 < r11) goto L11;
        if (r12 > r10) goto L11;
        return true;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r10, int r11, int r12, Spanned r13, int r14, int r15) {
        int r16 = Integer.parseInt(r13.toString() + r10.toString());     // Catch: NumberFormatException -> L11
        if (a(this.f7455a, this.f7456b, r16) == false) goto L6;
        return null;
    L6:
        InterfaceC0135a r17 = this.f7457c;     // Catch: NumberFormatException -> L11
        if (r17 == null) goto L14;
        r17.a(r16);     // Catch: NumberFormatException -> L11
        return "";
    L14:
        return "";
    L15:
        return "";
    }
}
