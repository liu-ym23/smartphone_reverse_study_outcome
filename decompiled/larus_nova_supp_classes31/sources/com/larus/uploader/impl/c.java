package com.larus.uploader.impl;

import com.ss.bduploader.BDImageXUploader;
import kotlin.jvm.internal.Intrinsics;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final void a(BDImageXUploader r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == null) goto L17;
        r2.setFilePrefix(r3.d());
        r2.setUploadDomain(r3.c());
        mr9.b r0 = r3.a();
        String r1 = null;
        if (r0 == null) goto L7;
        String r4 = r0.a();
    L8:
        r2.setTopAccessKey(r4);
        mr9.b r5 = r3.a();
        if (r5 == null) goto L11;
        String r6 = r5.c();
    L12:
        r2.setTopSecretKey(r6);
        mr9.b r7 = r3.a();
        if (r7 == null) goto L15;
        r1 = r7.d();
    L15:
        r2.setTopSessionToken(r1);
        r2.setServiceID(r3.b());
        return;
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    }
}
