package com.larus.doc.impl;

import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class t1 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ DocServiceImpl b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;

    public /* synthetic */ t1(String r1, DocServiceImpl r2, int r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = null;
        this.h = null;
        this.i = r7;
    }

    public final Object invoke() {
        String r8 = this.a;
        DocServiceImpl r0 = this.b;
        int r1 = this.c;
        String r2 = this.d;
        String r3 = this.e;
        String r4 = this.f;
        String r5 = this.g;
        String r6 = this.h;
        String r7 = this.i;
        int r9 = DocServiceImpl.c;
        IDocSdkServiceV2 r10 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r10 == null) goto L7;
        r0.getClass();
        boolean r11 = r10.tryPrefetchData(r8, DocServiceImpl.a(r8, r1, r2, r3, r4, r5, r6, r7));
        boolean r12 = true;
        if (r11 != true) goto L7;
    L9:
        return Boolean.valueOf(r12);
    L7:
        r12 = false;
        goto L9
    }
}
