package com.obric.oui.stepper;

import android.text.InputFilter;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14500b;
    private InterfaceC0777a c;

    /* JADX INFO: renamed from: com.obric.oui.stepper.a$a, reason: collision with other inner class name */
    interface InterfaceC0777a {
        void onBeyondLimit(int r1);
    }

    public a(int r3, int r4, InterfaceC0777a r5) {
        InterfaceC0777a r6 = (InterfaceC0777a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0777a.class, "com.obric.memorydata.plugin");
        this.f14499a = r3;
        this.f14500b = r4;
        this.c = r6;
    }

    private boolean a(int r2, int r3, int r4) {
        if (r3 <= r2) goto L7;
        if (r4 < r2) goto L11;
        if (r4 > r3) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r4 < r3) goto L11;
        if (r4 > r2) goto L11;
        return true;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        int r8 = Integer.parseInt(((Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.memorydata.plugin")).toString() + r7.toString());     // Catch: NumberFormatException -> L12
        if (a(this.f14499a, this.f14500b, r8) == false) goto L7;
        return null;
    L7:
        InterfaceC0777a r0 = this.c;     // Catch: NumberFormatException -> L12
        if (r0 == null) goto L15;
        r0.onBeyondLimit(r8);     // Catch: NumberFormatException -> L12
        return "";
    L15:
        return "";
    L16:
        return "";
    }
}
