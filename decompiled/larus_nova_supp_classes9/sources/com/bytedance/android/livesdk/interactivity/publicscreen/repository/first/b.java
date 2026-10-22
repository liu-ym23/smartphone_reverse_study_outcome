package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.livesdk.interactivity.publicscreen.utils.i;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r42.n;
import r42.o;
import r42.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements o {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // r42.o
    public final void a(n r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        i.b.getClass();
        i.v();
        c r0 = this.a;
        p r1 = r7.a;
        String r8 = r7.b;
        r0.getClass();
        int r2 = r42.a.a;
        StringBuilder r3 = new StringBuilder("on fetch first history messages done, has history message: ");
        boolean r4 = false;
        if (r1 == null) goto L9;
        List<tlc.d> r5 = r1.a;
        if (r5 == null) goto L9;
        if ((!r5.isEmpty()) != true) goto L9;
        boolean r6 = true;
    L10:
        r3.append(r6);
        r42.a.c(r3.toString());
        a r9 = r0.h;
        if (r1 == null) goto L13;
        r4 = true;
    L13:
        r9.a = r4;
        if (r8 == null) goto L16;
        String r10 = StringsKt.take(r8, 10);
    L17:
        r9.b = r10;
        r0.c = r1;
        r0.e = true;
        r0.b();
        return;
    L16:
        r10 = null;
    L9:
        r6 = false;
        goto L10
    }
}
