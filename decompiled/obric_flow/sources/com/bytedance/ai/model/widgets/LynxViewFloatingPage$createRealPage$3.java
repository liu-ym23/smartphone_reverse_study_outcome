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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxViewFloatingPage$createRealPage$3", f = "LynxViewFloatingPage.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
final class LynxViewFloatingPage$createRealPage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxViewFloatingPage f2314b;

    public LynxViewFloatingPage$createRealPage$3(LynxViewFloatingPage r5, Continuation r10) {
        this.f2314b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new LynxViewFloatingPage$createRealPage$3(this.f2314b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        LynxViewFloatingPage r11 = this.f2314b;
        return new LynxViewFloatingPage$createRealPage$3(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2313a;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r11 = r19;
    L11:
        TemplateBundle r12 = (TemplateBundle) r11;
        LynxViewFloatingPage r13 = this.f2314b;
        r13.getClass();
        if (r12 != null) goto L14;
    L58:
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L61;
        r14.e("LynxViewFloatingPage", "renderTemplate: bundle is NUll or NOT valid");
    L61:
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L65;
        r15.e("LynxViewFloatingPage", "renderTemplate failed");
    L65:
        return Unit.INSTANCE;
    L14:
        if (r12.d() == false) goto L58;
        String r16 = r13.f2330b.getPageUrl();
        if (r16 == null) goto L55;
        Trace.beginSection("renderTemplateBundle");
        com.bytedance.ai.lynx.g r17 = r13.e;
        if (r17 == null) goto L54;
        TemplateData r18 = new TemplateData();
        ReadableMap r20 = r13.f2330b.getContext();
        String r21 = "";
        if (r20 == null) goto L23;
        String r22 = r20.getString("msgId", "");
    L24:
        if (r22 != null) goto L26;
    L27:
        r22 = r13.f2330b.getMessageId();
        if (r22 != null) goto L30;
        r22 = "";
    L30:
        Pair r110 = TuplesKt.to("viewId", r13.f2331c);
        String r111 = r13.getAppletId();
        if (r111 != null) goto L33;
        r111 = "";
    L33:
        Pair r112 = TuplesKt.to("appletId", r111);
        String r113 = r13.f2330b.getPageName();
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        Pair r114 = TuplesKt.to("pageName", r113);
        Pair r115 = TuplesKt.to("botId", r13.f2330b.getBotId());
        Pair r116 = TuplesKt.to("msgId", r22);
        String r23 = r13.f2330b.getReplyFor();
        if (r23 != null) goto L39;
        r23 = "";
    L39:
        r18.i("viewContext", MapsKt.mutableMapOf(new Pair[]{r110, r112, r114, r115, r116, TuplesKt.to("replyFor", r23)}));
        String r24 = r13.f2330b.getPageData();     // Catch: JSONException -> L46
        if (r24 == null) goto L44;
        r21 = r24;
    L44:
        r18.i("viewData", new JSONObject(r21));     // Catch: JSONException -> L46
    L53:
        r17.b(r16, r12, r18, r13.f2309o);
    L46:
        e = move-exception;
        String r25 = "parse viewData error: " + e;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L50;
        r26.e("LynxViewFloatingPage", r25);
    L50:
        String r27 = "parse viewData error: " + r13.f2330b.getPageData();
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L53;
        r28.e("LynxViewFloatingPage", r27);
        goto L53
    L26:
        if (r22.length() != 0) goto L30;
    L23:
        r22 = null;
    L54:
        Trace.endSection();
        goto L65
    L55:
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L61;
        r29.e("LynxViewFloatingPage", "renderTemplate: template url is null");
        goto L61
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        LynxViewFloatingPage r30 = this.f2314b;
        this.f2313a = 1;
        r11 = LynxViewFloatingPage.i(r30, this);
        if (r11 != r5) goto L11;
        return r5;
    }
}
