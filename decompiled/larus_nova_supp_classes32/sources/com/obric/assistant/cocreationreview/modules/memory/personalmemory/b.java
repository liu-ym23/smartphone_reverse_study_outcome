package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import android.content.Context;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.j1;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k1;
import com.obric.assistant.cocreationreview.l0;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.v5;
import com.obric.assistant.cocreationreview.w5;
import hda.e1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements l0 {
    public static final b b = null;
    public final /* synthetic */ v5<g> a;

    static {
        b = new b();
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final e5 a(Context r2) {
        return this.a.a(r2);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final w5 c(j5 r8, com.obric.assistant.cocreationreview.a r9, a5 r10, boolean r11, com.obric.assistant.cocreationreview.b r12) {
        Intrinsics.checkNotNullParameter(r8, "buildContext");
        Intrinsics.checkNotNullParameter(r9, "record");
        Intrinsics.checkNotNullParameter(r10, "feedback");
        Intrinsics.checkNotNullParameter(r12, "feedbackState");
        return this.a.c(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final String d(com.obric.assistant.cocreationreview.a r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return this.a.d(r2);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final ModuleKey e() {
        return this.a.e();
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final l5 b() {
        return this.a.a;
    }

    public b() {
        this.a = new v5(c.a, d.a, e.b, a.a);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final void f(com.obric.assistant.cocreationreview.a r2, Vote r3, j1 r4, k1 r5) {
        Intrinsics.checkNotNullParameter(r2, "record");
        Intrinsics.checkNotNullParameter(r3, "vote");
        Intrinsics.checkNotNullParameter(r4, "defaultAction");
        Intrinsics.checkNotNullParameter(r5, "showDetailAction");
        List<e1> r0 = null;
        if ((r2 instanceof g) == false) goto L5;
        g r6 = (g) r2;
    L6:
        if (r6 == null) goto L10;
        e1 r7 = r6.j;
        if (r7 == null) goto L10;
        r0 = r7.r;
    L10:
        if (r0 != null) goto L13;
        r0 = CollectionsKt.emptyList();
    L13:
        if (r0.size() <= 1) goto L15;
        r5.invoke();
        return;
    L15:
        r4.invoke();
        return;
    L5:
        r6 = null;
        goto L6
    }
}
