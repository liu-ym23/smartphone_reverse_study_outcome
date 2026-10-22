package com.bytedance.ai.model.widgets;

import android.os.Trace;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxViewFloatingPage$createRealPage$3", f = "LynxViewFloatingPage.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
final class LynxViewFloatingPage$createRealPage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LynxViewFloatingPage this$0;

    public LynxViewFloatingPage$createRealPage$3(LynxViewFloatingPage r1, Continuation<? super LynxViewFloatingPage$createRealPage$3> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LynxViewFloatingPage$createRealPage$3(this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r10 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        TemplateBundle r11 = (TemplateBundle) r14;
        LynxViewFloatingPage r15 = this.this$0;
        int r12 = LynxViewFloatingPage.l;
        r15.getClass();
        if (r11 != null) goto L14;
    L55:
        com.bytedance.ai.utils.g.a.e("LynxViewFloatingPage", "renderTemplate: bundle is NUll or NOT valid");
    L56:
        r10 = false;
    L57:
        if (r10 == true) goto L60;
        com.bytedance.ai.utils.g.a.e("LynxViewFloatingPage", "renderTemplate failed");
    L60:
        return Unit.INSTANCE;
    L14:
        if (r11.i() == false) goto L55;
        String r13 = r15.getPageInfo().getPageUrl();
        if (r13 == null) goto L54;
        Trace.beginSection("renderTemplateBundle");
        com.bytedance.ai.lynx.g r16 = r15.a;
        if (r16 == null) goto L53;
        TemplateData r17 = TemplateData.empty();
        ReadableMap r18 = r15.getPageInfo().getContext();
        String r19 = "";
        if (r18 == null) goto L23;
        String r20 = r18.getString("msgId", "");
    L24:
        if (r20 != null) goto L26;
    L29:
        boolean r110 = true;
    L30:
        if (r110 == false) goto L34;
        r20 = r15.getPageInfo().getMessageId();
        if (r20 != null) goto L34;
        r20 = "";
    L34:
        Pair[] r111 = new Pair[6];
        r111[0] = TuplesKt.to("viewId", r15.getPageID());
        String r21 = r15.getAppletId();
        if (r21 != null) goto L37;
        r21 = "";
    L37:
        r111[1] = TuplesKt.to("appletId", r21);
        String r22 = r15.getPageInfo().getPageName();
        if (r22 != null) goto L40;
        r22 = "";
    L40:
        r111[2] = TuplesKt.to("pageName", r22);
        r111[3] = TuplesKt.to("botId", r15.getPageInfo().getBotId());
        r111[4] = TuplesKt.to("msgId", r20);
        String r23 = r15.getPageInfo().getReplyFor();
        if (r23 != null) goto L43;
        r23 = "";
    L43:
        r111[5] = TuplesKt.to("replyFor", r23);
        r17.put("viewContext", MapsKt.mutableMapOf(r111));
        String r24 = r15.getPageInfo().getPageData();     // Catch: JSONException -> L50
        if (r24 == null) goto L48;
        r19 = r24;
    L48:
        r17.put("viewData", new JSONObject(r19));     // Catch: JSONException -> L50
    L52:
        LynxViewFloatingPage.c r25 = r15.k;
        int r112 = com.bytedance.ai.lynx.g.l;
        r16.i(r13, r11, r17, r25, null);
    L50:
        e = move-exception;
        com.bytedance.ai.utils.g r26 = com.bytedance.ai.utils.g.a;
        r26.e("LynxViewFloatingPage", "parse viewData error: " + e);
        r26.e("LynxViewFloatingPage", "parse viewData error: " + r15.getPageInfo().getPageData());
        goto L52
    L26:
        if (r20.length() == 0) goto L29;
        r110 = false;
        goto L30
    L23:
        r20 = null;
    L53:
        Trace.endSection();
        goto L57
    L54:
        com.bytedance.ai.utils.g.a.e("LynxViewFloatingPage", "renderTemplate: template url is null");
        goto L56
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        LynxViewFloatingPage r113 = this.this$0;
        this.label = 1;
        r14 = LynxViewFloatingPage.h(r113, this);
        if (r14 != r0) goto L11;
        return r0;
    }
}
