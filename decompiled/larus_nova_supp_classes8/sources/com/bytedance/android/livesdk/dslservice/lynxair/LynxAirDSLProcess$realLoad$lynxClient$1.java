package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.m;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q1;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxAirDSLProcess$realLoad$lynxClient$1 extends q1 {
    public final /* synthetic */ q a;

    public LynxAirDSLProcess$realLoad$lynxClient$1(q r1) {
        this.a = r1;
    }

    public final void onTemplateBundleReady(TemplateBundle r6) {
        Intrinsics.checkNotNullParameter(r6, "bundle");
        cu1.a r0 = cu1.a.b;
        q r1 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        boolean r3 = true;
        if (r1.c.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L13:
        r0.b().put(r1, r6);
    L14:
        m.h.d(new LynxAirDSLProcess$realLoad$lynxClient$1$onTemplateBundleReady$1(this));
        return;
    L8:
        if (r1.b.length() == 0) goto L11;
        r3 = false;
    L11:
        if (r3 == false) goto L13;
    L5:
        r2 = false;
        goto L6
    }
}
