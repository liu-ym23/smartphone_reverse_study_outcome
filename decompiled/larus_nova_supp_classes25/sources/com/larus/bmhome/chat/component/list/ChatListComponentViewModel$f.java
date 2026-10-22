package com.larus.bmhome.chat.component.list;

import android.app.Application;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import o99.a;
import q99.d;
import tx9.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponentViewModel$f implements a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public final void d() {
    }

    public final void e(d r1) {
    }

    public final void h() {
    }

    public final void i() {
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
        if (this.a == false) goto L5;
        t19.s r5 = t19.s.a;
        Application r6 = AppHost.a.getApplication();
        r5.getClass();
        t19.s.b(r6, 2131907052, false);
    L5:
        z1.a(this.b, this.c, "dislike", Boolean.FALSE);
    }

    public final void c(q99.e r1, q99.a r2) {
        a.a.a(r1, r2);
    }

    public final void g(q99.m r3, q99.n r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "result");
        FLogger.a.i("ChatListComponentViewModel", "#onSuccess message");
        if (this.a == false) goto L5;
        t19.s r5 = t19.s.a;
        Application r6 = AppHost.a.getApplication();
        r5.getClass();
        t19.s.o(r6, 2131901665, false);
    L5:
        z1.a(this.b, this.c, "dislike", Boolean.TRUE);
    }

    public final void j(q99.e r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "delivery");
        Intrinsics.checkNotNullParameter(r1, "delivery");
    }

    public ChatListComponentViewModel$f(boolean r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
