package com.suite.lark.platform.component.cta;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements foc.e {
    public final /* synthetic */ goc.b.g a;
    public final /* synthetic */ b b;

    public c(Context r1, goc.b.g r2, b r3) {
        this.a = r2;
        this.b = r3;
    }

    @Override // foc.e
    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        ((eoc.a) ClaymoreServiceLoader.loadFirst(eoc.a.class)).b();
        goc.b.h r9 = this.a.b();
        if (r9 != null) goto L5;
        return;
    L5:
        int r0 = moc.a.a;
        b r1 = this.b;
        String r2 = r1.a;
        String r3 = r1.b;
        String r4 = r9.b();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        moc.a.a(r2, r3, r4, r9.a(), r9.d(), r.M2);
    }
}
