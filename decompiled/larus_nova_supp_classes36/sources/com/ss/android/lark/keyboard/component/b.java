package com.ss.android.lark.keyboard.component;

import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.biz.im.api.extension.scroll.b {
    public final /* synthetic */ Function0<Unit> a;

    public b(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void a(String r2, ScrollEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "event");
        Function0<Unit> r4 = this.a;
        if (r4 == null) goto L6;
        r4.invoke();
        return;
    }

    public final void b(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.c(r1, r2);
    }

    public final void c(String r2, ScrollEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "event");
    }

    public final void d(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.b(r1, r2);
    }

    public final void e(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.a(r1, r2);
    }
}
