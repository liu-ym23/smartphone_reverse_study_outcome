package com.suite.lark.platform.component.cta;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int f = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final com.suite.lark.platform.component.cta.model.a e;

    public static final class a {
    }

    static {
    }

    public b(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "featureKey");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r5, "checkpointUserId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new com.suite.lark.platform.component.cta.model.a();
    }

    public static final void a(b r7, Context r8, goc.b r9, goc.b.d r10, goc.a r11) {
        r7.getClass();
        goc.b.a r12 = r10.a();
        if (r12 == null) goto L5;
        String r13 = r12.a();
    L6:
        String r0 = "";
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        if (r13.length() <= 0) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L15;
        ((eoc.a) ClaymoreServiceLoader.loadFirst(eoc.a.class)).a();
    L15:
        if (r11 == null) goto L20;
        String r15 = r10.e();
        if (r15 != null) goto L19;
        r15 = "";
    L19:
        r11.a(r15);
    L20:
        goc.b.g r16 = r9.b();
        if (r16 == null) goto L35;
        goc.b.h r17 = r16.b();
        if (r17 == null) goto L36;
        int r18 = moc.a.a;
        String r1 = r7.a;
        String r2 = r7.b;
        String r19 = r17.b();
        if (r19 != null) goto L28;
        String r3 = "";
    L29:
        boolean r4 = r17.a();
        boolean r5 = r17.d();
        r r20 = r.c3;
        String r21 = r10.e();
        if (r21 == null) goto L33;
        r0 = r21;
    L33:
        moc.a.a(r1, r2, r3, r4, r5, r20.a(r0));
        return;
    L28:
        r3 = r19;
        goto L29
    L36:
        return;
    L35:
        return;
    L12:
        r14 = false;
        goto L13
    L5:
        r13 = null;
        goto L6
    }
}
