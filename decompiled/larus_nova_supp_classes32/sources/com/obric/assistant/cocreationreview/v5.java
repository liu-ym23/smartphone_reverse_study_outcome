package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.view.View;
import com.obric.assistant.cocreationreview.a;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v5<R extends a> implements l0 {
    public final l5 a;
    public final m5 b;
    public final n5<R> c;
    public final x5<R> d;

    @Override // com.obric.assistant.cocreationreview.l0
    public final ModuleKey e() {
        return b().a;
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final l5 b() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final e5 a(Context r2) {
        return this.b.a(r2);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final String d(a r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        n5<R> r0 = this.c;
        g(r2);
        return r0.b(r2);
    }

    public final void g(a r4) {
        if (r4.b() != e()) goto L7;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type R of com.obric.assistant.cocreationreview.TypedCocreationModuleFeature");
        return;
    L7:
        throw new IllegalArgumentException("record module " + r4.b().getRaw() + " does not match feature " + e().getRaw());
    }

    public v5(l5 r2, m5 r3, w4 r4, k5 r5) {
        Intrinsics.checkNotNullParameter(r2, "moduleMeta");
        Intrinsics.checkNotNullParameter(r3, "providerFactory");
        Intrinsics.checkNotNullParameter(r4, "presenter");
        Intrinsics.checkNotNullParameter(r5, "domainContentRenderer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new x5(r4, r5);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final void f(a r1, Vote r2, j1 r3, k1 r4) {
        l0.a.a(r1, r2, r3, r4);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final w5 c(j5 r18, a r19, a5 r20, boolean r21, b r22) {
        Intrinsics.checkNotNullParameter(r18, "buildContext");
        Intrinsics.checkNotNullParameter(r19, "record");
        Intrinsics.checkNotNullParameter(r20, "feedback");
        Intrinsics.checkNotNullParameter(r22, "feedbackState");
        x5<R> r8 = this.d;
        g(r19);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r18, "buildContext");
        Intrinsics.checkNotNullParameter(r19, "record");
        Intrinsics.checkNotNullParameter(r20, "feedback");
        Intrinsics.checkNotNullParameter(r22, "feedbackState");
        String r3 = r19.a();
        int r4 = RangesKt.coerceAtLeast(r8.a.j(r19), 0);
        e r6 = new e(r8.a.h(r19), r8.a.e(r19), r8.a.d(r19));
        List<d> r7 = r8.a.i(r19);
        View r9 = r8.b.a(r18, r19);
        boolean r10 = r8.a.g(r19);
        List<c> r11 = r8.a.c(r19);
        z4.a r13 = r8.a.f(r19, r20);
        boolean r14 = r8.a.a(r19);
        return new w5(r3, r4, r6, r20, r21, r7, r9, r10, r11, r13, r22, CollectionsKt.emptyList(), r14);
    }
}
