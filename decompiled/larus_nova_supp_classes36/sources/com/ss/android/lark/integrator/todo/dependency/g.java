package com.ss.android.lark.integrator.todo.dependency;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements g7c.n {
    public g() {
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void d() {
    }

    public final void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void f(Context r2, ContainerType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "filter");
    }

    public final void g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final Intent c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(IOfflineExtraParser.ParserType.TODO, "pageName");
        return new Intent();
    }
}
