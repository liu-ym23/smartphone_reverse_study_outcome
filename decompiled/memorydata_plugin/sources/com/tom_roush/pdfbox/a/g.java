package com.tom_roush.pdfbox.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.tom_roush.pdfbox.filter.i> f16052a;

    private g(InputStream r3, List<com.tom_roush.pdfbox.filter.i> r4) {
        List<com.tom_roush.pdfbox.filter.i> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        super(r3);
        this.f16052a = r5;
    }

    static g a(List<com.tom_roush.pdfbox.filter.j> r9, d r10, InputStream r11, com.tom_roush.pdfbox.io.i r12, com.tom_roush.pdfbox.filter.h r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList(r14.size());
        if (r14.size() > 1) goto L9;
    L13:
        int r2 = 0;
        InputStream r4 = r11;
    L15:
        if (r2 >= r14.size()) goto L21;
        if (r12 == null) goto L18;
        final com.tom_roush.pdfbox.io.c r15 = r12.e();
        r0.add(((com.tom_roush.pdfbox.filter.j) ZeusTransformUtils.preCheckCast(r14.get(r2), com.tom_roush.pdfbox.filter.j.class, "com.obric.memorydata.plugin")).a(r4, new com.tom_roush.pdfbox.io.f(r15), r10, r2, r13));
        InputStream r3 = new AnonymousClass1(r15, r15);
    L19:
        r4 = r3;
        r2 = r2 + 1;
        goto L15
    L18:
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();
        r0.add(((com.tom_roush.pdfbox.filter.j) ZeusTransformUtils.preCheckCast(r14.get(r2), com.tom_roush.pdfbox.filter.j.class, "com.obric.memorydata.plugin")).a(r4, r16, r10, r2, r13));
        r3 = new ByteArrayInputStream(r16.toByteArray());
        goto L19
    L21:
        return new g(r4, r0);
    L9:
        if (new HashSet(r14).size() == r14.size()) goto L13;
        throw new IOException("Duplicate");
    L5:
        return new g(r11, Collections.emptyList());
    }

    public com.tom_roush.pdfbox.filter.i a() {
        if (this.f16052a.isEmpty() == true) goto L5;
        List<com.tom_roush.pdfbox.filter.i> r2 = this.f16052a;
        return (com.tom_roush.pdfbox.filter.i) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), com.tom_roush.pdfbox.filter.i.class, "com.obric.memorydata.plugin");
    L5:
        return com.tom_roush.pdfbox.filter.i.f16107a;
    }
}
