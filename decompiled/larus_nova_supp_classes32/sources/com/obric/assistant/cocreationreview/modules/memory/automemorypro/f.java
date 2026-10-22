package com.obric.assistant.cocreationreview.modules.memory.automemorypro;

import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.c1;
import hda.e1;
import hda.p0;
import hda.s0;
import hda.t1;
import hda.u;
import hda.u0;
import hda.u1;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends s0<i> {
    public static final f b = null;

    static {
        b = new f();
    }

    public f() {
        super(c.a);
    }

    public static String m(e1 r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(new JSONObject(r2.s));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L9;
        r3 = null;
    L9:
        JSONObject r4 = (JSONObject) r3;
        if (r4 != null) goto L12;
        return null;
    L12:
        String r1 = p0.b(r4, "ruleTitle");
        if (r1 != null) goto L24;
        r1 = p0.b(r4, "rule_title");
        if (r1 != null) goto L24;
        r1 = p0.b(r4, "ruleName");
        if (r1 != null) goto L24;
        r1 = p0.b(r4, "rule");
        if (r1 != null) goto L24;
        r1 = p0.b(r4, "taskName");
        if (r1 != null) goto L24;
        r1 = p0.b(r4, "memoryTaskName");
    L24:
        return c1.a(r1);
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String n(String r9) {
        String r10 = CollectionsKt.joinToString$default(StringsKt.lines(r9), " ", null, null, 0, null, new e(), 30, null);
        return StringsKt.trim(new Regex("\\s+").replace(r10, " ")).toString();
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.k;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return u0.b(r3.j);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.d;
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final String e(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.h;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.g;
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final List i(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return CollectionsKt.plus(super.i(r3), CollectionsKt.listOfNotNull(u1.b(r3.j)));
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final int j(com.obric.assistant.cocreationreview.a r3) {
        i r4 = (i) r3;
        Intrinsics.checkNotNullParameter(r4, "record");
        e1 r5 = r4.j;
        Intrinsics.checkNotNullParameter(r5, "uiModel");
        return RangesKt.coerceIn(u1.a(r5) - 1, 0, 2);
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r2) {
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.e;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r14, a5 r15) {
        i r16 = (i) r14;
        Intrinsics.checkNotNullParameter(r16, "record");
        Intrinsics.checkNotNullParameter(r15, "feedback");
        int r0 = u.a;
        l5 r1 = c.a;
        String r2 = r16.a;
        String r3 = r16.g;
        String r4 = r16.d;
        e1 r6 = r16.j;
        return u.f(r1, r2, r3, r4, r15, r6, true, t1.a(r6.g, null), new AutoMemoryProRecordPresenter$detailView$1(this), new AutoMemoryProRecordPresenter$detailView$2(this), null, 4224);
    }
}
