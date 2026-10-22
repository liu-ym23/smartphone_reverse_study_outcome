package com.bytedance.ai.model.widgets;

import com.bytedance.ai.model.objects.PageInfo;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxEngineAssem$initLynxView$3", f = "LynxEngineAssem.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
public final class LynxEngineAssem$initLynxView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LynxEngineAssem this$0;

    public LynxEngineAssem$initLynxView$3(LynxEngineAssem r1, Continuation<? super LynxEngineAssem$initLynxView$3> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LynxEngineAssem$initLynxView$3(this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r10 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        TemplateBundle r12 = (TemplateBundle) r11;
        LynxEngineAssem r13 = this.this$0;
        int r14 = LynxEngineAssem.r;
        r13.getClass();
        if (r12 != null) goto L14;
    L57:
        com.bytedance.ai.utils.g.a.e("LynxEngineAssem", "renderTemplate: bundle is NUll or NOT valid");
    L58:
        r10 = false;
    L59:
        if (r10 == true) goto L62;
        com.bytedance.ai.utils.g.a.e("LynxEngineAssem", "renderTemplate failed");
    L62:
        return Unit.INSTANCE;
    L14:
        if (r12.i() == false) goto L57;
        k2.b r15 = r13.t();
        if (r15 == null) goto L56;
        String r16 = r15.b;
        if (r16 == null) goto L56;
        com.bytedance.ai.lynx.g r17 = r13.j;
        if (r17 == null) goto L59;
        TemplateData r18 = TemplateData.empty();
        String r19 = null;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L33
        k2.b r21 = r13.t();     // Catch: Throwable -> L33
        if (r21 == null) goto L30;
        k2.j r22 = r21.n;     // Catch: Throwable -> L33
        if (r22 == null) goto L30;
        String r23 = r22.viewContext();     // Catch: Throwable -> L33
        if (r23 == null) goto L30;
        JSONObject r24 = new JSONObject(r23);     // Catch: Throwable -> L33
    L31:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r25) == false) goto L38;
        r25 = null;
    L38:
        Object r26 = (JSONObject) r25;
        if (r26 != null) goto L41;
        r26 = new LinkedHashMap();
    L41:
        r18.put("viewContext", r26);
        k2.b r27 = r13.t();
        if (r27 == null) goto L63;
        k2.j r28 = r27.n;
        if (r28 == null) goto L63;
        PageInfo r29 = r28.getPageInfo();
        if (r29 == null) goto L63;
        r19 = r29.getPageData();
    L63:
    L54:
        com.bytedance.ai.utils.g.a.e("LynxEngineAssem", "parse viewData error: " + r19);
    L55:
        LynxEngineAssem.c r30 = r13.q;
        int r110 = com.bytedance.ai.lynx.g.l;
        r17.i(r16, r12, r18, r30, null);
        goto L59
    L49:
        if (r19 != null) goto L51;
        String r31 = "";
    L52:
        r18.put("viewData", new JSONObject(r31));     // Catch: JSONException -> L54
        goto L55
    L51:
        r31 = r19;
    L30:
        r24 = null;
    L33:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L56:
        com.bytedance.ai.utils.g.a.e("LynxEngineAssem", "renderTemplate: template url is null");
        goto L58
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        LynxEngineAssem r111 = this.this$0;
        this.label = 1;
        r11 = LynxEngineAssem.s(r111, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
