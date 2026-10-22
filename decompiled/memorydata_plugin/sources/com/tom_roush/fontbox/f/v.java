package com.tom_roush.fontbox.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class v extends ae {
    public v() {
    }

    public v(boolean r2) {
        this(r2, false);
    }

    public v(boolean r1, boolean r2) {
        super(r1, r2);
    }

    @Override // com.tom_roush.fontbox.f.ae
    public af a(ah r2, String r3) {
        if (r3.equals("BASE") == true) goto L20;
        if (r3.equals("GDEF") == true) goto L20;
        if (r3.equals("GPOS") == true) goto L20;
        if (r3.equals("GSUB") == true) goto L20;
        if (r3.equals("JSTF") == true) goto L20;
        if (r3.equals("CFF ") == false) goto L18;
        return new b(r2);
    L18:
        return super.a(r2, r3);
    L20:
        return new w(r2);
    }

    x a(ad r2) {
        return (x) ZeusTransformUtils.preCheckCast(super.d(r2), x.class, "com.obric.memorydata.plugin");
    }

    public x a(File r2) {
        return (x) ZeusTransformUtils.preCheckCast(super.b(r2), x.class, "com.obric.memorydata.plugin");
    }

    public x a(InputStream r2) {
        return (x) ZeusTransformUtils.preCheckCast(super.b(r2), x.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.fontbox.f.ae
    public boolean a() {
        return true;
    }

    @Override // com.tom_roush.fontbox.f.ae
    public /* synthetic */ ah b(File r1) {
        return a(r1);
    }

    @Override // com.tom_roush.fontbox.f.ae
    public /* synthetic */ ah b(InputStream r1) {
        return a(r1);
    }

    x b(ad r1) {
        return new x(r1);
    }

    @Override // com.tom_roush.fontbox.f.ae
    /* synthetic */ ah c(ad r1) {
        return b(r1);
    }

    @Override // com.tom_roush.fontbox.f.ae
    /* synthetic */ ah d(ad r1) {
        return a(r1);
    }
}
