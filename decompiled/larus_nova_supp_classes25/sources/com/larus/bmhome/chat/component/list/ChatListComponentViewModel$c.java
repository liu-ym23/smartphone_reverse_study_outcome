package com.larus.bmhome.chat.component.list;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o99.a;
import q99.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponentViewModel$c implements a {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    public final void d() {
    }

    public final void e(d r1) {
    }

    public final void h() {
    }

    public final void i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatListComponentViewModel$c(Function1<? super Boolean, Unit> r1) {
        this.a = r1;
    }

    public final Bundle b(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return r2;
    }

    public final hq9.n3 f(hq9.n3 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        return r2;
    }

    public final void a(q99.m r3, q99.l r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("ChatListComponentViewModel", "#onFailure error :" + r4 + ' ');
        this.a.invoke(Boolean.FALSE);
    }

    public final void c(q99.e r1, q99.a r2) {
        a.a.a(r1, r2);
    }

    public final void g(q99.m r2, q99.n r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "result");
        FLogger.a.i("ChatListComponentViewModel", "#onSuccess message");
        this.a.invoke(Boolean.TRUE);
    }

    public final void j(q99.e r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "delivery");
        Intrinsics.checkNotNullParameter(r1, "delivery");
    }
}
