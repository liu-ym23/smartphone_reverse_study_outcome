package com.larus.bmhome.chat.markdown.imagetool;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public f() {
    }

    public static fh8.f b(tb8.a r3, fh8.f r4, final Function0 r5) {
        Intrinsics.checkNotNullParameter(r4, "commonInputData");
        Intrinsics.checkNotNullParameter(r5, "refreshCallback");
        fh8.g r6 = fh8.h.a(r4);
        Function0<Unit> r1 = null;
        if (r3 == null) goto L5;
        fh8.d r2 = r3.f;
    L6:
        if (r3 == null) goto L8;
        r1 = r3.d;
    L8:
        r6.p = new fh8.c(r2, r1);
        r6.i = new d(r5);
        return r6.a();
    L5:
        r2 = null;
        goto L6
    }

    public static int a(Context r10, Message r11, Integer r12, Boolean r13, Boolean r14, View r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "message");
        return w.c(w.a, r10, r11, r12, r13, Intrinsics.areEqual(r14, Boolean.TRUE), false, null, r15, 64);
    }
}
