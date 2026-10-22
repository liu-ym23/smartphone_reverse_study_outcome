package com.tom_roush.fontbox.g.a;

import android.util.Log;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f16025a;

    public c() {
        this.f16025a = null;
    }

    private void a(File r7, List<URI> r8) {
        List<URI> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r7.isDirectory() == true) goto L5;
        return;
    L5:
        File[] r10 = r7.listFiles();
        if (r10 != null) goto L8;
        return;
    L8:
        int r0 = r10.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L26;
        File r2 = r10[r1];
        if (r2.isDirectory() == false) goto L17;
        if (r2.getName().startsWith(".") == true) goto L25;
        a(r2, r9);
    L25:
        r1 = r1 + 1;
        goto L9
    L17:
        if (PDFBoxConfig.b() == false) goto L20;
        Log.d("PdfBox-Android", "checkFontfile check " + r2);
    L20:
        if (a(r2) == false) goto L25;
        if (PDFBoxConfig.b() == false) goto L24;
        Log.d("PdfBox-Android", "checkFontfile found " + r2);
    L24:
        r9.add(r2.toURI());
        goto L25
    }

    private boolean a(File r1) {
        String r0 = r1.getName().toLowerCase(Locale.US);
        if (r0.endsWith(".ttf") == true) goto L11;
        if (r0.endsWith(".otf") == true) goto L11;
        if (r0.endsWith(".pfb") == true) goto L11;
        if (r0.endsWith(".ttc") == true) goto L11;
    L13:
        return false;
    L11:
        if (r0.startsWith("fonts.") == true) goto L13;
        return true;
    }

    private b b() {
        if (System.getProperty("java.vendor").equals("The Android Project") == true) goto L5;
        String r1 = System.getProperty("os.name");
        if (r1.startsWith("Windows") == false) goto L11;
        return new h();
    L11:
        if (r1.startsWith("Mac") == false) goto L15;
        return new d();
    L15:
        if (r1.startsWith("OS/400") == false) goto L19;
        return new f();
    L19:
        return new g();
    L5:
        return new a();
    }

    public List<URI> a() {
        if (this.f16025a != null) goto L5;
        this.f16025a = b();
    L5:
        List<File> r0 = this.f16025a.b();
        ArrayList r1 = new ArrayList();
        Iterator<File> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        a((File) ZeusTransformUtils.preCheckCast(r2.next(), File.class, "com.obric.memorydata.plugin"), r1);
        goto L7
    L9:
        return r1;
    }
}
