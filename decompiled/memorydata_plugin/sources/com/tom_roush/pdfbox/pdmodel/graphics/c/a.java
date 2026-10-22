package com.tom_roush.pdfbox.pdmodel.graphics.c;

import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.a.n;
import com.tom_roush.pdfbox.pdmodel.common.h;
import com.tom_roush.pdfbox.pdmodel.graphics.d;
import com.tom_roush.pdfbox.pdmodel.k;
import com.tom_roush.pdfbox.util.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a extends d implements com.tom_roush.pdfbox.contentstream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f16268a;

    public a(n r3, k r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        super(r3, i.dn);
        this.f16268a = r5;
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public InputStream a() {
        return k_().h();
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public h b() {
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(k_().a(i.S), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new h(r2);
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public c c() {
        return c.a(k_().a(i.eQ));
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public com.tom_roush.pdfbox.pdmodel.i getResources() {
        com.tom_roush.pdfbox.a.d r0 = k_().d(i.gU);
        if (r0 == null) goto L7;
        return new com.tom_roush.pdfbox.pdmodel.i(r0, this.f16268a);
    L7:
        if (k_().m(i.gU) == true) goto L9;
        return null;
    L9:
        return new com.tom_roush.pdfbox.pdmodel.i();
    }
}
