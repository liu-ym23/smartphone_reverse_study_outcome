package com.bytedance.android.livesdk.dslservice.lynxair;

import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.livesdk.dsl.recyclerview.i;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.lynx.tasm.q1;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.q;
import yt1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends com.bytedance.android.livesdk.dslservice.a {
    public static final /* synthetic */ int i = 0;
    public r c;
    public com.bytedance.android.livesdk.dslservice.lynxair.jsb.c d;
    public q1 e;
    public String f;
    public final AnnieXLynxView g;
    public final q h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dslservice.lynxair.a$a, reason: collision with other inner class name */
    public static final class C0300a {
    }

    static {
    }

    @Override // yt1.k
    public final void release() {
        com.bytedance.android.livesdk.dslservice.util.r.a(this.g);
        this.g.destroy();
        Function2<? super q, ? super k, Unit> r0 = this.a;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(this.h, this);
    L5:
        this.c = null;
        this.d = null;
    }

    @Override // yt1.k
    public final View getView() {
        return this.g;
    }

    @Override // yt1.k
    public final void a(i r2) {
        com.bytedance.android.livesdk.dslservice.lynxair.jsb.c r0 = this.d;
        if (r0 == null) goto L6;
        r0.a = r2;
        return;
    }

    public a(AnnieXLynxView r2, q r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.g = r2;
        this.h = r3;
    }

    @Override // yt1.k
    public final void b(au1.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "lifeType");
        r r0 = this.c;
        if (r0 != null) goto L5;
    L6:
        if (r4 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r3, au1.a.b.b) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r3, au1.a.c.b) == false) goto L14;
        this.g.H();
        return;
    L14:
        if (Intrinsics.areEqual(r3, au1.a.C0001a.b) == false) goto L19;
        this.g.F();
        return;
    L19:
        return;
    L5:
        if (r0.b == true) goto L8;
        goto L6
    }

    @Override // yt1.k
    public final void c(String r4, Map<String, ? extends Object> r5, int r6) {
        long r0 = System.currentTimeMillis();
        LynxViewUtilKt.a(this.g, r4, r5, r6);
        long r7 = System.currentTimeMillis() - r0;
        m.h.i(r7, this.h.a, "bindData");
    }
}
