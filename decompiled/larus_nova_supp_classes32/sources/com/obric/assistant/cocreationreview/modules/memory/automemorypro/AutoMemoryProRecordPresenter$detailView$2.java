package com.obric.assistant.cocreationreview.modules.memory.automemorypro;

import hda.c1;
import hda.e1;
import hda.p0;
import hda.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AutoMemoryProRecordPresenter$detailView$2 extends FunctionReferenceImpl implements Function1<e1, List<? extends v>> {
    public AutoMemoryProRecordPresenter$detailView$2(Object r8) {
        super(1, r8, f.class, "autoMemoryProTaskSections", "autoMemoryProTaskSections(Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewUiModel;)Ljava/util/List;", 0);
    }

    public final List<v> invoke(e1 r18) {
        Intrinsics.checkNotNullParameter(r18, "p0");
        f r2 = (f) ((CallableReference) this).receiver;
        f r3 = f.b;
        v[] r4 = new v[2];
        r2.getClass();
        String r7 = f.m(r18);
        v r5 = null;
        if (r7 == null) goto L5;
        v r11 = new v("记忆任务", r7, null, null, 12);
    L6:
        r4[0] = r11;
        String r6 = c1.a(r18.c);
        if (r6 != null) goto L9;
        String r10 = null;
    L54:
        if (r10 == null) goto L56;
        r5 = new v("记忆摘要", r10, null, null, 12);
    L56:
        r4[1] = r5;
        return CollectionsKt.listOfNotNull(r4);
    L9:
        String r8 = f.m(r18);
        if (r8 == null) goto L16;
        String r9 = f.n(r8);
        if (r9 == null) goto L16;
        if ((!StringsKt.isBlank(r9)) == false) goto L16;
    L58:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L19
        Object r0 = Result.constructor-impl(new JSONObject(r18.s));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r0) == false) goto L24;
        r0 = null;
    L24:
        JSONObject r1 = (JSONObject) r0;
        if (r1 == null) goto L48;
        String r13 = p0.b(r1, "taskSubtitle");
        if (r13 != null) goto L36;
        r13 = p0.b(r1, "displaySubtitle");
        if (r13 != null) goto L36;
        r13 = p0.b(r1, "cardSubtitle");
        if (r13 != null) goto L36;
        r13 = p0.b(r1, "realSubtitle");
        if (r13 != null) goto L36;
        r13 = p0.b(r1, "subtitle");
    L36:
        String r14 = c1.a(r13);
        if (r14 == null) goto L48;
        String r15 = f.n(r14);
        if (r15 == null) goto L48;
        if ((!StringsKt.isBlank(r15)) == true) goto L43;
    L45:
        boolean r16 = false;
    L46:
        if (r16 == false) goto L48;
    L49:
        String r17 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{r6, r15}), "\n", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r17)) == true) goto L53;
        r17 = null;
    L53:
        r10 = r17;
        goto L54
    L43:
        if (Intrinsics.areEqual(r15, r9) == true) goto L45;
        r16 = true;
    L48:
        r15 = null;
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        r9 = null;
        goto L58
    L5:
        r11 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((e1) r1);
    }
}
