package com.tom_roush.fontbox.f;

import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15973b;

    public ae() {
        this(false);
    }

    public ae(boolean r2) {
        this(r2, false);
    }

    public ae(boolean r2, boolean r3) {
        this.f15972a = false;
        this.f15973b = false;
        this.f15972a = r2;
        this.f15973b = r3;
    }

    private af a(ah r6, ad r7) {
        String r0 = r7.a(4);
        if (r0.equals("cmap") == false) goto L6;
        af r5 = new e(r6);
    L51:
        r5.a(r0);
        r5.a(r7.k());
        r5.c(r7.k());
        r5.b(r7.k());
        if (r5.h() == 0) goto L54;
        return r5;
    L54:
        if (r0.equals("glyf") == true) goto L58;
        return null;
    L58:
        return r5;
    L6:
        if (r0.equals("glyf") == false) goto L9;
        r5 = new j(r6);
        goto L51
    L9:
        if (r0.equals("head") == false) goto L12;
        r5 = new k(r6);
        goto L51
    L12:
        if (r0.equals("hhea") == false) goto L15;
        r5 = new l(r6);
        goto L51
    L15:
        if (r0.equals("hmtx") == false) goto L18;
        r5 = new m(r6);
        goto L51
    L18:
        if (r0.equals("loca") == false) goto L21;
        r5 = new n(r6);
        goto L51
    L21:
        if (r0.equals("maxp") == false) goto L24;
        r5 = new q(r6);
        goto L51
    L24:
        if (r0.equals(ActivityLifecycle.NAME) == false) goto L27;
        r5 = new t(r6);
        goto L51
    L27:
        if (r0.equals("OS/2") == false) goto L30;
        r5 = new u(r6);
        goto L51
    L30:
        if (r0.equals(CozeCloudExt.API_KEY_HTTP_POST_METHOD) == false) goto L33;
        r5 = new z(r6);
        goto L51
    L33:
        if (r0.equals("DSIG") == false) goto L36;
        r5 = new f(r6);
        goto L51
    L36:
        if (r0.equals("kern") == false) goto L39;
        r5 = new p(r6);
        goto L51
    L39:
        if (r0.equals("vhea") == false) goto L42;
        r5 = new ai(r6);
        goto L51
    L42:
        if (r0.equals("vmtx") == false) goto L45;
        r5 = new aj(r6);
        goto L51
    L45:
        if (r0.equals("VORG") == false) goto L48;
        r5 = new ak(r6);
        goto L51
    L48:
        if (r0.equals("GSUB") == false) goto L50;
        r5 = new i(r6);
        goto L51
    L50:
        r5 = a(r6, r0);
        goto L51
    }

    private void a(ah r5) {
        Iterator<af> r0 = r5.g().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        af r1 = (af) ZeusTransformUtils.preCheckCast(r0.next(), af.class, "com.obric.memorydata.plugin");
        if (r1.k() == true) goto L4;
        r5.c(r1);
        goto L4
    L8:
        boolean r2 = r5.f15978a.containsKey("CFF ");
        if (a() == false) goto L12;
        if (r2 == false) goto L12;
        boolean r3 = true;
    L14:
        if (r5.m() == null) goto L63;
        if (r5.n() == null) goto L61;
        if (r5.l() == null) goto L59;
        if (r5.j() == null) goto L22;
    L26:
        if (r3 == true) goto L40;
        if (r2 == false) goto L29;
        String r4 = "; this an OpenType CFF font, but we expected a TrueType font here";
    L31:
        if (r5.p() == null) goto L38;
        if (r5.e() != null) goto L40;
        throw new IOException("'glyf' table is mandatory" + r4);
    L38:
        throw new IOException("'loca' table is mandatory" + r4);
    L29:
        r4 = "";
    L40:
        if (r5.i() != null) goto L47;
        if (this.f15972a == true) goto L47;
        throw new IOException("'name' table is mandatory");
    L47:
        if (r5.o() == null) goto L57;
        if (this.f15972a == false) goto L51;
        return;
    L51:
        if (r5.q() == null) goto L54;
        return;
    L54:
        throw new IOException("'cmap' table is mandatory");
    L57:
        throw new IOException("'hmtx' table is mandatory");
    L22:
        if (this.f15972a == true) goto L26;
        throw new IOException("'post' table is mandatory");
    L59:
        throw new IOException("'maxp' table is mandatory");
    L61:
        throw new IOException("'hhea' table is mandatory");
    L63:
        throw new IOException("'head' table is mandatory");
    L12:
        r3 = false;
        goto L14
    }

    public af a(ah r1, String r2) {
        return new af(r1);
    }

    public boolean a() {
        return false;
    }

    public ah b(File r3) {
        aa r0 = new aa(r3, "r");
        return d(r0);
    L5:
        e = move-exception;
        r0.close();
        throw e;
    }

    public ah b(InputStream r2) {
        return d(new r(r2));
    }

    ah c(ad r1) {
        return new ah(r1);
    }

    ah d(ad r9) {
        ah r0 = c(r9);
        r0.a(r9.h());
        int r1 = r9.d();
        r9.d();
        r9.d();
        r9.d();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        af r3 = a(r0, r9);
        if (r3 == null) goto L10;
        if ((r3.i() + r3.h()) <= r0.t()) goto L9;
        Log.w("PdfBox-Android", "Skip table '" + r3.j() + "' which goes past the file size; offset: " + r3.i() + ", size: " + r3.h() + ", font size: " + r0.t());
        goto L10
    L9:
        r0.a(r3);
    L10:
        r2 = r2 + 1;
        goto L3
    L12:
        if (this.f15973b == true) goto L14;
        a(r0);
    L14:
        return r0;
    }
}
