package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.w4;
import com.obric.assistant.cocreationreview.y4;
import com.obric.assistant.cocreationreview.z4;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l extends w4<q> {
    public static final l b = null;

    static {
        b = new l();
    }

    public l() {
        l5 r0 = e.a;
        super(i.a());
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final boolean a(com.obric.assistant.cocreationreview.a r2) {
        Intrinsics.checkNotNullParameter((q) r2, "record");
        return true;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        q r3 = (q) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.y;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r2) {
        Intrinsics.checkNotNullParameter((q) r2, "record");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r2) {
        q r3 = (q) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.g;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r2) {
        q r3 = (q) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.j;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r2) {
        q r3 = (q) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.h;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(com.obric.assistant.cocreationreview.a r2) {
        Intrinsics.checkNotNullParameter((q) r2, "record");
        return null;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r12, a5 r13) {
        final q r14 = (q) r12;
        Intrinsics.checkNotNullParameter(r14, "record");
        Intrinsics.checkNotNullParameter(r13, "feedback");
        String r3 = r14.a;
        StringBuilder r1 = new StringBuilder();
        l5 r2 = e.a;
        r1.append(i.a().b);
        r1.append("详情");
        String r4 = r1.toString();
        Intrinsics.checkNotNullParameter(r14, "record");
        String r5 = r14.j;
        Intrinsics.checkNotNullParameter(r14, "record");
        String r6 = null;
        com.obric.assistant.cocreationreview.e r7 = new com.obric.assistant.cocreationreview.e(r5, null, r14.g);
        y4[] r0 = new y4[3];
        r0[0] = new y4.a("建议内容", null, new k(r14));
        r0[1] = new y4.c("推荐原因", r14.k);
        String r15 = r14.q;
        if (r15 == null) goto L5;
        r6 = StringsKt.trim(r15).toString();
    L5:
        if (r6 != null) goto L8;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        if (StringsKt.isBlank(r6) == false) goto L10;
        r6 = "暂无依据";
    L10:
        r0[2] = new y4.c("依据", r6);
        return new z4.a(r3, r4, r7, r13, CollectionsKt.listOf(r0), null, null, 224);
    }
}
