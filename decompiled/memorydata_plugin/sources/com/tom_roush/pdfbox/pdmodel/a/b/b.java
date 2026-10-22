package com.tom_roush.pdfbox.pdmodel.a.b;

import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.common.c;
import com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;

/* JADX INFO: loaded from: classes6.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final d f16159a;

    public b() {
        this.f16159a = new d();
    }

    public b(d r1) {
        this.f16159a = r1;
    }

    public static b a(d r2) {
        com.tom_roush.pdfbox.a.b r0 = r2.l(i.iz);
        if (i.fx.equals(r0) == false) goto L7;
        return new PDOptionalContentGroup(r2);
    L7:
        if (i.fz.equals(r0) == false) goto L11;
        return new com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent.a(r2);
    L11:
        return new b(r2);
    }

    public d a() {
        return this.f16159a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
