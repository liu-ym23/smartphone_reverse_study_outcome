package com.larus.bmhome.view.actionbar.edit.kmp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class KmpInstructionEditorViewFactory$commandDispatcher$2$7 extends FunctionReferenceImpl implements Function1<com.larus.bmhome.actionbar.model.c, Map<String, String>> {
    public KmpInstructionEditorViewFactory$commandDispatcher$2$7(Object r8) {
        super(1, r8, KmpInstructionEditorViewFactory.class, "parseQueryExt", "parseQueryExt(Lcom/larus/bmhome/actionbar/model/ActionBarCommandOption;)Ljava/util/Map;", 0);
    }

    public final Map<String, String> invoke(com.larus.bmhome.actionbar.model.c r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        KmpInstructionEditorViewFactory r0 = (KmpInstructionEditorViewFactory) ((CallableReference) this).receiver;
        int r1 = KmpInstructionEditorViewFactory.p;
        r0.getClass();
        LinkedHashMap r2 = new LinkedHashMap();
        HashMap r6 = r5.c;
        if (r6 == null) goto L5;
        String r7 = (String) r6.get("query_ext");
    L6:
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        if (r7.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L37;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L22
        JSONObject r8 = new JSONObject(r7);     // Catch: Throwable -> L22
        Iterator<String> r9 = r8.keys();     // Catch: Throwable -> L22
    L16:
        if (r9.hasNext() == false) goto L20;
        String r10 = r9.next();     // Catch: Throwable -> L22
        Object r11 = r8.opt(r10);     // Catch: Throwable -> L22
        if (r11 == null) goto L16;
        r2.put(r10, r11.toString());     // Catch: Throwable -> L22
        goto L16
    L20:
        Object r12 = Result.constructor-impl(r2);     // Catch: Throwable -> L22
    L24:
        Object r13 = r2;
        if (Result.isFailure-impl(r12) == true) goto L29;
        r13 = r12;
    L29:
        return (Map) r13;
    L22:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L37:
        return r2;
    L11:
        r3 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((com.larus.bmhome.actionbar.model.c) r1);
    }
}
