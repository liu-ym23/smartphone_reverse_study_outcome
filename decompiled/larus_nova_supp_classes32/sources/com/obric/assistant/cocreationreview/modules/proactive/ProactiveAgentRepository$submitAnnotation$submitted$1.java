package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.s5;
import com.obric.memorydata.sdk.proactive.ProactiveInspirationDto;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository$submitAnnotation$submitted$1", f = "ProactiveAgentProvider.kt", i = {}, l = {463}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveAgentRepository$submitAnnotation$submitted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ q $record;
    final /* synthetic */ s5 $request;
    int label;

    public ProactiveAgentRepository$submitAnnotation$submitted$1(Context r1, q r2, s5 r3, Continuation<? super ProactiveAgentRepository$submitAnnotation$submitted$1> r4) {
        this.$context = r1;
        this.$record = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ProactiveAgentRepository$submitAnnotation$submitted$1(this.$context, this.$record, this.$request, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        return r18;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        ska.b.a.bindService(this.$context, "com.larus.nova");
        q r1 = this.$record;
        s5 r4 = this.$request;
        Intrinsics.checkNotNullParameter(r1, "record");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r6 = StringsKt.removePrefix(r1.a, "proactive:");
        if (Intrinsics.areEqual(r6, r1.a) == false) goto L11;
    L13:
        boolean r7 = false;
    L14:
        String r8 = null;
        if (r7 == true) goto L18;
        r6 = null;
    L18:
        if (r6 != null) goto L36;
        r6 = StringsKt.trim(r1.d).toString();
        if (StringsKt.isBlank(r6) == false) goto L23;
        r6 = StringsKt.trim(r1.c).toString();
    L23:
        if (StringsKt.isBlank(r6) == false) goto L34;
        String r9 = StringsKt.trim(r1.e).toString();
        if ((!StringsKt.isBlank(r9)) == true) goto L28;
        r9 = null;
    L28:
        if (r9 == null) goto L30;
        r8 = r9 + ':' + r1.f;
    L30:
        if (r8 != null) goto L32;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L34
    L32:
        r6 = r8;
    L34:
        if (StringsKt.isBlank(r6) == false) goto L36;
        r6 = "created:" + r1.f;
    L36:
        String r10 = r6;
        String r11 = r1.e;
        String r12 = r1.c;
        int r13 = r1.s;
        Vote r14 = r4.d;
        Intrinsics.checkNotNullParameter(r14, "vote");
        int r15 = m.a.a[r14.ordinal()];
        if (r15 != 1) goto L39;
        String r16 = "LIKE";
    L44:
        String r17 = r16;
        Intrinsics.checkNotNullParameter(r4, "request");
        JSONObject r5 = new JSONObject().put("vote", r4.d.getRaw()).put("reasons", new JSONArray(CollectionsKt.toList(r4.e))).put("comment", r4.f);
        Integer r19 = r4.j;
        if (r19 == null) goto L47;
        r5.put("feedbackValue", r19.intValue());
    L47:
        ProactiveInspirationDto r110 = new ProactiveInspirationDto(r10, r11, r12, r13, r17, r5.toString(), r1.f, r4.j);
        this.label = 1;
        JSONObject r3 = new JSONObject().put("inspirationId", r110.a).put("taskId", r110.b).put("recommendId", r110.c).put("recommendStatus", r110.d).put("feedbackAction", r110.e);
        Object r20 = r110.f;
        if (r20 != null) goto L50;
        r20 = JSONObject.NULL;
    L50:
        JSONObject r21 = r3.put("userFeedback", r20).put("created", r110.g);
        Object r22 = r110.h;
        if (r22 != null) goto L53;
        r22 = JSONObject.NULL;
    L53:
        r21.put("feedbackValue", r22);
        Intrinsics.checkNotNull(r21);
        String r23 = ska.b.a("submitAiProactiveAnnotation", "feedbackJson", r21.toString());
        if (r23 != null) goto L68;
        boolean r111 = false;
    L64:
        Boolean r24 = Boxing.boxBoolean(r111);
        if (r24 != r2) goto L70;
        return r2;
    L70:
        return r24;
    L68:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L57
        Object r26 = Result.constructor-impl(Boxing.boxBoolean(new JSONObject(r23).optBoolean("accepted", false)));     // Catch: Throwable -> L57
    L59:
        Boolean r27 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r26) == false) goto L62;
        r26 = r27;
    L62:
        r111 = ((Boolean) r26).booleanValue();
    L57:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L59
    L39:
        if (r15 != 2) goto L42;
        r16 = "DISLIKE";
        goto L44
    L42:
        throw new NoWhenBranchMatchedException();
    L11:
        if ((!StringsKt.isBlank(r6)) == false) goto L13;
        r7 = true;
        goto L14
    }
}
