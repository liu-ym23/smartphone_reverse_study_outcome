package com.larus.bmhome.bigimg;

import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z implements j19.g {
    public final /* synthetic */ BigImageLocalPhotoViewerDialog a;

    public final void S80(int r1) {
    }

    public z(BigImageLocalPhotoViewerDialog r1) {
        this.a = r1;
    }

    public final void onPageSelected(int r5) {
        BigImageLocalPhotoViewerDialog r0 = this.a;
        int r1 = BigImageLocalPhotoViewerDialog.H;
        r0.r(r5);
        this.a.o(r5);
        BigImageLocalPhotoViewerDialog r2 = this.a;
        if (r2.s == false) goto L5;
        r2.q(r5);
    L5:
        BigImageLocalPhotoViewerDialog r3 = this.a;
        int r4 = r3.B;
        if (r4 != r5) goto L8;
    L15:
        r3.B = r5;
        return;
    L8:
        if (r4 == (-1)) goto L15;
        if (r5 <= r4) goto L12;
        String r6 = "next";
    L13:
        com.larus.platform.service.o r7 = com.larus.platform.service.o.a;
        JSONObject r8 = r3.h(((PhotoViewerDialog) r3).f);
        r8.put("status", r6);
        Unit r9 = Unit.INSTANCE;
        r7.reportEvent("slide", r8);
        this.a.B = r5;
        return;
    L12:
        r6 = "previous";
        goto L13
    }

    public final void onPageSelected(int r4, boolean r5) {
        ((CustomPhotoViewerDialog) this.a).n.C2(r4);
        FLogger.a.i("BigImagePhotoViewer", "onPageSelected pos: " + r4 + ", byScroll: " + r5);
        if (r5 == false) goto L6;
        BigImageLocalPhotoViewerDialog r6 = this.a;
        int r0 = BigImageLocalPhotoViewerDialog.H;
        r6.p(r4, "slide");
        this.a.getClass();
        return;
    }
}
