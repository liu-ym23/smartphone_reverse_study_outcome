package com.obric.assistant.cocreationreview.modules.proactive;

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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements l0 {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final l5 b() {
        i r0 = i.a;
        return i.a();
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final ModuleKey e() {
        return b().a;
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final e5 a(Context r2) {
        return j.a.a(r2);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final String d(com.obric.assistant.cocreationreview.a r6) {
        Intrinsics.checkNotNullParameter(r6, "record");
        return new v5(b(), j.a, l.b, b.a).d(r6);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final void f(com.obric.assistant.cocreationreview.a r1, Vote r2, j1 r3, k1 r4) {
        l0.a.a(r1, r2, r3, r4);
    }

    @Override // com.obric.assistant.cocreationreview.l0
    public final w5 c(j5 r8, com.obric.assistant.cocreationreview.a r9, a5 r10, boolean r11, com.obric.assistant.cocreationreview.b r12) {
        Intrinsics.checkNotNullParameter(r8, "buildContext");
        Intrinsics.checkNotNullParameter(r9, "record");
        Intrinsics.checkNotNullParameter(r10, "feedback");
        Intrinsics.checkNotNullParameter(r12, "feedbackState");
        return new v5(b(), j.a, l.b, b.a).c(r8, r9, r10, r11, r12);
    }
}
