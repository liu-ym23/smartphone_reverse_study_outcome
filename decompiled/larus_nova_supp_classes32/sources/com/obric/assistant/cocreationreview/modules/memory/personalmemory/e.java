package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.e1;
import hda.j0;
import hda.s0;
import hda.u;
import hda.u1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends s0<g> {
    public static final e b = null;

    static {
        b = new e();
    }

    public e() {
        super(c.a);
    }

    public static List m(e1 r5) {
        j0[] r0 = new j0[2];
        String r1 = r5.g;
        j0 r4 = null;
        if ((!StringsKt.isBlank(r1)) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        r4 = new j0("内容时间", r1);
    L8:
        r0[0] = r4;
        if (r5.q > 0) goto L11;
        String r6 = "新增";
    L12:
        r0[1] = new j0("状态", r6);
        return CollectionsKt.listOfNotNull(r0);
    L11:
        r6 = "更新";
        goto L12
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.k;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r15) {
        g r16 = (g) r15;
        Intrinsics.checkNotNullParameter(r16, "record");
        String r0 = r16.f;
        String r17 = r16.g;
        com.obric.assistant.cocreationreview.c[] r1 = new com.obric.assistant.cocreationreview.c[2];
        com.obric.assistant.cocreationreview.c r3 = null;
        if (r0 != null) goto L5;
    L10:
        com.obric.assistant.cocreationreview.c r13 = null;
    L11:
        r1[0] = r13;
        if (r17 != null) goto L14;
    L19:
        r1[1] = r3;
        return CollectionsKt.listOfNotNull(r1);
    L14:
        if ((!StringsKt.isBlank(r17)) == true) goto L17;
        r17 = null;
    L17:
        if (r17 == null) goto L19;
        r3 = new com.obric.assistant.cocreationreview.c("子类 ".concat(r17), CardTemplateTagTone.NEUTRAL, null, null, null, null, null, 252);
        goto L19
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r13 = new com.obric.assistant.cocreationreview.c("分类 ".concat(r0), CardTemplateTagTone.NEUTRAL, null, null, null, null, null, 252);
        goto L11
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.d;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.h;
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final List i(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return CollectionsKt.plus(super.i(r3), CollectionsKt.listOfNotNull(u1.b(r3.j)));
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final int j(com.obric.assistant.cocreationreview.a r3) {
        g r4 = (g) r3;
        Intrinsics.checkNotNullParameter(r4, "record");
        e1 r5 = r4.j;
        Intrinsics.checkNotNullParameter(r5, "uiModel");
        return RangesKt.coerceIn(u1.a(r5) - 1, 0, 2);
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.e;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(com.obric.assistant.cocreationreview.a r2) {
        Intrinsics.checkNotNullParameter((g) r2, "record");
        return null;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r14, a5 r15) {
        g r16 = (g) r14;
        Intrinsics.checkNotNullParameter(r16, "record");
        Intrinsics.checkNotNullParameter(r15, "feedback");
        int r0 = u.a;
        l5 r1 = c.a;
        String r2 = r16.a;
        String r3 = r16.h;
        String r4 = r16.d;
        e1 r6 = r16.j;
        return u.f(r1, r2, r3, r4, r15, r6, true, m(r6), new PersonalMemoryRecordPresenter$detailView$1(this), null, null, 7168);
    }
}
