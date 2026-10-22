package com.ss.android.lark.chat.configurator;

import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.biz.im.api.extension.scroll.b {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a(String r2, ScrollEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "event");
    }

    public final void b(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.c(r1, r2);
    }

    public final void c(String r2, ScrollEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "event");
        this.a.c();
    }

    public final void d(String r2, ScrollEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "event");
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.b(r2, r3);
    }

    public final void e(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.a(r1, r2);
    }
}
