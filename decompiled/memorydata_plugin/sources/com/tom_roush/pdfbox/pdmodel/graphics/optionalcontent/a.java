package com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent;

import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.a.b.b;

/* JADX INFO: loaded from: classes6.dex */
public class a extends b {
    public a() {
        this.f16159a.a(i.iz, i.fz);
    }

    public a(d r2) {
        super(r2);
        if (r2.l(i.iz).equals(i.fz) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Provided dictionary is not of type '" + i.fz + "'");
    }
}
