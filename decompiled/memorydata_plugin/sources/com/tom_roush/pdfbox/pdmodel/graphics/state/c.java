package com.tom_roush.pdfbox.pdmodel.graphics.state;

import android.util.Log;
import com.tom_roush.pdfbox.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f16277b;
    private com.tom_roush.pdfbox.pdmodel.graphics.c.b c;
    private com.tom_roush.pdfbox.a.a d;
    private com.tom_roush.pdfbox.pdmodel.common.function.a e;
    private com.tom_roush.pdfbox.util.c f;

    public c(com.tom_roush.pdfbox.a.d r2) {
        this.f16277b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f16276a = r2;
    }

    public static c a(com.tom_roush.pdfbox.a.b r4) {
        if (ZeusTransformUtils.instanceOf(r4, i.class) == false) goto L11;
        if (i.fq.equals(r4) == false) goto L7;
        return null;
    L7:
        StringBuilder r0 = new StringBuilder();
    L8:
        Log.w("PdfBox-Android", r0.append("Invalid SMask ").append(r4).toString());
        return null;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.d.class) == true) goto L13;
        r0 = new StringBuilder();
        goto L8
    L13:
        return new c((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16276a;
    }

    void a(com.tom_roush.pdfbox.util.c r1) {
        this.f = r1;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
