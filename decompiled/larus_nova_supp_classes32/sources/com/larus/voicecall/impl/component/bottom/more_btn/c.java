package com.larus.voicecall.impl.component.bottom.more_btn;

import android.view.View;
import com.larus.voicecall.impl.video.VideoPreviewState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w3a.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class c {
    public final d a;
    public final a b;

    public static final class a implements w3a.i {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // w3a.i
        public final void a(w3a.h r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if ((r2 instanceof o) == false) goto L6;
            this.a.h(((o) r2).a);
            return;
        L6:
            if ((r2 instanceof w3a.l) == false) goto L10;
            this.a.g(((w3a.l) r2).a);
            return;
        }
    }

    public abstract String b();

    public void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public void d() {
    }

    public void g(boolean r1) {
    }

    public void h(VideoPreviewState r2) {
        Intrinsics.checkNotNullParameter(r2, "newState");
    }

    public final e3a.a a() {
        w3a.k r0 = this.a.c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public void e() {
        w3a.k r0 = this.a.c();
        if (r0 == null) goto L6;
        r0.c(this.b);
        return;
    }

    public void f() {
        w3a.k r0 = this.a.c();
        if (r0 == null) goto L6;
        a r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.e.remove(r1);
        return;
    }

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r2;
        this.b = new a(this);
    }

    public final void i(c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Function1<c, Unit> r0 = this.a.a();
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }
}
