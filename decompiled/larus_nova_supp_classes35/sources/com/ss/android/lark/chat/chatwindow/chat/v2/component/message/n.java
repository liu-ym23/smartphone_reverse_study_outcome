package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements mya.h {
    public final /* synthetic */ Map<Class<? extends mya.g>, List<mya.g>> a;

    public final <T extends mya.g> void a(Class<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "handlerApiClass");
        Intrinsics.checkNotNullParameter(r3, "handlerInstance");
    }

    public final <T extends mya.g> T b(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlerApiClass");
        return null;
    }

    public final <T extends mya.g> boolean d(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlerApiClass");
        return false;
    }

    public final void e(mya.h r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
    }

    public final Map<Class<? extends mya.g>, List<mya.g>> f() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(Map<Class<? extends mya.g>, ? extends List<mya.g>> r1) {
        this.a = r1;
    }

    public final <T extends mya.g> List<T> c(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlerApiClass");
        return new ArrayList();
    }
}
