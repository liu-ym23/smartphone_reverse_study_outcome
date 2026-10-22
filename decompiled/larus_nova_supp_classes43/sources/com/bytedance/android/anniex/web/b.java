package com.bytedance.android.anniex.web;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.base.h;
import ib.f;
import kotlin.jvm.internal.Intrinsics;
import t36.j;
import v36.e;
import y36.i;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends c26.c {
    public final /* synthetic */ AnnieXWebKit b;
    public final /* synthetic */ f c;

    public final Bitmap getDefaultVideoPoster() {
        AnnieXWebModel r0 = this.b.c;
        if (r0 == null) goto L7;
        j r1 = r0.h;
        if (r1 == null) goto L7;
        t36.f r10 = r1.d;
    L9:
        if ((r10 instanceof e) == false) goto L11;
        e r11 = (e) r10;
    L12:
        if (r11 == null) goto L19;
        i r12 = r11.g;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("hideSystemVideoPoster");
        r12 = null;
    L17:
        if (r12 == null) goto L19;
        boolean r13 = Intrinsics.areEqual(r12.b, Boolean.TRUE);
    L20:
        if (r13 == true) goto L22;
        super/*b36.j*/.getDefaultVideoPoster();
        throw null;
    L22:
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    L19:
        r13 = false;
        goto L20
    L11:
        r11 = null;
    L7:
        r10 = null;
        goto L9
    }

    public b(AnnieXWebKit r1, f r10) {
        this.b = r1;
        this.c = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onProgressChanged(WebView r1, int r10) {
        super/*android.webkit.WebChromeClient*/.onProgressChanged(r1, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onReceivedTitle(WebView r10, String r11) {
        if (r11 == null) goto L42;
        AnnieXWebKit r0 = this.b;
        f r1 = this.c;
        if (r11.length() > 32) goto L42;
        AnnieXWebModel r12 = r0.c;
        f.a r13 = null;
        boolean r14 = false;
        if (r12 == null) goto L13;
        j r15 = r12.h;
        if (r15 == null) goto L13;
        t36.d r16 = r15.a;
        if (r16 == null) goto L13;
        boolean r17 = h.h0(r16);
        Object r18 = ((i) new p(r16, "title", null)).b;
    L14:
        AnnieXWebModel r19 = r0.c;
        if (r19 == null) goto L19;
        j r20 = r19.h;
        if (r20 == null) goto L19;
        t36.f r21 = r20.d;
    L21:
        if ((r21 instanceof e) == false) goto L23;
        e r22 = (e) r21;
    L24:
        if (r22 == null) goto L31;
        i r23 = r22.m;
        if (r23 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("useWebviewTitle");
        r23 = null;
    L29:
        if (r23 == null) goto L31;
        r14 = Intrinsics.areEqual(r23.b, Boolean.TRUE);
    L31:
        if (r17 == true) goto L34;
        if (r18 != null) goto L42;
        if (r14 == false) goto L42;
    L34:
        ia.h r24 = (ia.h) r0.D.c(ia.h.class);
        if (r24 == null) goto L38;
        r24.setTitle(r11);
    L38:
        if ((r1 instanceof f.a) == false) goto L40;
        r13 = (f.a) r1;
    L40:
        if (r13 == null) goto L42;
        r13.b(String.valueOf(r0.u), r0.e, r11);
        goto L42
    L23:
        r22 = null;
    L19:
        r21 = null;
    L13:
        r18 = null;
        r17 = false;
    L42:
        super/*android.webkit.WebChromeClient*/.onReceivedTitle(r10, r11);
    }
}
