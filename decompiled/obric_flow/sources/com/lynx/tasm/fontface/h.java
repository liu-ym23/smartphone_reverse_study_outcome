package com.lynx.tasm.fontface;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10872c;

    public h(String r5, String r10, float r11) {
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        this.f10870a = r5;
        this.f10871b = r11;
        this.f10872c = r10;
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r10 = (h) r5;
        String r11 = r10.f10872c;
        if (TextUtils.equals(this.f10872c, r11) == true) goto L11;
    L15:
        return false;
    L11:
        if (Float.compare(this.f10871b, r10.f10871b) != 0) goto L15;
        if (TextUtils.equals(this.f10870a, r10.f10870a) == false) goto L15;
        return true;
    }

    public final int hashCode() {
        int r5 = this.f10870a.hashCode() * 31;
        int r10 = (Float.floatToIntBits(this.f10871b) + r5) * 31;
        String r11 = this.f10872c;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }
}
