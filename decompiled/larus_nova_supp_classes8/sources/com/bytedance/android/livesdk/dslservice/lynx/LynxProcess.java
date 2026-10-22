package com.bytedance.android.livesdk.dslservice.lynx;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.anniex.api.c;
import com.bytedance.android.anniex.api.d;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.livesdk.dslservice.util.f;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateData;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ra.b;
import yt1.h;
import yt1.k;
import yt1.l;
import yt1.m;
import yt1.n;
import yt1.o;
import yt1.q;
import yt1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxProcess implements n {
    public LynxProcess() {
    }

    @Override // yt1.n
    public final void a(q r1, k r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
    }

    @Override // yt1.n
    public final boolean b(String r1, q r2) {
        return false;
    }

    @Override // yt1.n
    public final void e(q r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter("", "data");
    }

    @Override // yt1.n
    public final void f(Context r1, l r2, ArrayList<h> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // yt1.n
    public final void g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // yt1.n
    public final void release() {
    }

    @Override // yt1.n
    public final k c(final o r34, String r35, Context r36, r r37, m r38) {
        Intrinsics.checkNotNullParameter(r34, "template");
        Intrinsics.checkNotNullParameter(r35, "data");
        Intrinsics.checkNotNullParameter(r36, "context");
        String r2 = r34.c.b;
        boolean r4 = false;
        if (r2 != null) goto L5;
    L10:
        long r6 = System.currentTimeMillis();
        String r3 = r34.c.b;
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        Uri r9 = UriProtector.parse(r3);
        boolean r27 = Intrinsics.areEqual("1", UriProtector.getQueryParameter(r9, "air_strict_mode"));
        boolean r28 = Intrinsics.areEqual("1", UriProtector.getQueryParameter(r9, "enable_code_cache"));
        boolean r5 = Intrinsics.areEqual("1", UriProtector.getQueryParameter(r9, "compact_mode"));
        if (r35.length() != 0) goto L16;
        r4 = true;
    L16:
        if (r4 == false) goto L18;
        Map r7 = MapsKt.emptyMap();
    L19:
        TemplateData r8 = TemplateData.fromMap(r7);
        ra.a r10 = d.i(new d("webcast", null, new b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, r27, r28, null, false, 0.0f, 15204351), 10), r9, true, r8, r5, 40);
        com.bytedance.android.anniex.assemble.a r11 = com.bytedance.android.anniex.assemble.a.a;
        AnnieXLynxView r1 = c.a(r36, r10);
        r1.E(r10, Long.valueOf(r6));
        r1.A(r10, null, new LynxProcess$getLifecycleObserve$1(r34.b.a, r38));
        int r12 = a.e;
        q r0 = r34.b;
        Intrinsics.checkNotNullParameter(r0, "key");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        a r13 = new a(r1, r0);
        r13.c = r37;
        return r13;
    L18:
        r7 = com.bytedance.android.livesdk.dsl.util.c.g(r35);
        goto L19
    L5:
        if (r2.length() != 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 != true) goto L10;
        com.bytedance.android.livesdk.dslservice.util.n r15 = com.bytedance.android.livesdk.dslservice.util.n.e;
        Function1<f, Unit> r16 = new LynxProcess$loadTemplate$1(r34);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "initBlock");
        r15.e(2, r16);
        goto L10
    L7:
        r14 = false;
        goto L8
    }

    @Override // yt1.n
    public final k d(o r8, String r9, ViewGroup r10, r r11, m r12) {
        Intrinsics.checkNotNullParameter(r8, "template");
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        k r13 = c(r8, r9, r10.getContext(), r11, r12);
        r10.addView(((a) r13).d);
        return r13;
    }
}
