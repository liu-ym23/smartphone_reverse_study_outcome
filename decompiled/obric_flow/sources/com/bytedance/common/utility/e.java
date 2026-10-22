package com.bytedance.common.utility;

import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Printer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f3956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f3957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f3958c;
    public boolean d;
    public boolean e;

    @Override // android.util.Printer
    public final void println(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        char r5 = r10.charAt(0);
        ArrayList r11 = this.f3958c;
        ArrayList r12 = this.f3956a;
        if (r5 != '>') goto L17;
        if (this.e == false) goto L17;
        Iterator r13 = r11.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Printer r14 = (Printer) r13.next();
        if (r12.contains(r14) == true) goto L11;
        r12.add(r14);
        goto L11
    L15:
        r11.clear();
        this.e = false;
    L17:
        if (r12.size() <= 5) goto L19;
        Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
    L19:
        Iterator r15 = r12.iterator();
    L21:
        if (r15.hasNext() == false) goto L26;
        Printer r16 = (Printer) r15.next();
        if (r16 == null) goto L21;
        r16.println(r10);
        goto L21
    L26:
        if (r10.charAt(0) == '<') goto L28;
        return;
    L28:
        if (this.d == false) goto L47;
        ArrayList r17 = this.f3957b;
        Iterator r18 = r17.iterator();
    L31:
        if (r18.hasNext() == false) goto L33;
        Printer r19 = (Printer) r18.next();
        r12.remove(r19);
        r11.remove(r19);
        goto L31
    L33:
        r17.clear();
        this.d = false;
        return;
    }
}
