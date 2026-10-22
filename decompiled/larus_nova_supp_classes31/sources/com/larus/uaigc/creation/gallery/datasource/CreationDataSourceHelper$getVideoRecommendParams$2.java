package com.larus.uaigc.creation.gallery.datasource;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper$getVideoRecommendParams$2", f = "CreationDataSourceHelper.kt", i = {}, l = {806}, m = "invokeSuspend", n = {}, s = {})
final class CreationDataSourceHelper$getVideoRecommendParams$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ Message $curMessage;
    int label;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    public CreationDataSourceHelper$getVideoRecommendParams$2(Message r1, Continuation<? super CreationDataSourceHelper$getVideoRecommendParams$2> r2) {
        this.$curMessage = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDataSourceHelper$getVideoRecommendParams$2(this.$curMessage, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super JSONObject> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        Message r11 = (Message) r10;
    L17:
        if (r11 == null) goto L43;
        Map r12 = r11.getExt();
        if (r12 == null) goto L43;
        String r13 = (String) r12.get("creation_template");
        if (r13 == null) goto L43;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L37
        zd9.h r5 = zd9.h.a;     // Catch: Throwable -> L37
        if (StringsKt.isBlank(r13) == false) goto L63;
    L24:
        Object r14 = null;
    L35:
        Object r15 = Result.constructor-impl((Map) r14);     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r15) == false) goto L42;
        r15 = null;
    L42:
        Map r16 = (Map) r15;
    L44:
        JSONObject r0 = new JSONObject();
        if (r16 == null) goto L47;
        String r6 = (String) r16.get("recommend_from");
    L49:
        if (r16 == null) goto L51;
        String r7 = (String) r16.get("from_template_id");
    L53:
        if (r16 == null) goto L55;
        String r8 = (String) r16.get("template_rec_extra");
    L57:
        if (r16 == null) goto L59;
        r4 = (String) r16.get("template_rec_req_id");
    L59:
        r0.put("recommend_from", r6);
        r0.put("from_template_id", r7);
        r0.put("template_rec_req_id", r4);
        r0.put("template_rec_extra", r8);
        return r0;
    L55:
        r8 = null;
        goto L57
    L51:
        r7 = null;
        goto L53
    L47:
        r6 = null;
        goto L49
    L63:
        r5.getClass();     // Catch: Throwable -> L27
        r14 = Result.constructor-impl(zd9.h.b.fromJson(r13, new a().getType()));     // Catch: Throwable -> L27
    L29:
        Throwable r9 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L37
        if (r9 == null) goto L33;
        c0 r17 = c0.b;     // Catch: Throwable -> L37
        StringBuilder r18 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r9, "<this>");     // Catch: Throwable -> L37
        r18.append(ExceptionsKt.stackTraceToString(r9));     // Catch: Throwable -> L37
        r17.e("GsonHolder", r18.toString());     // Catch: Throwable -> L37
    L33:
        if (Result.isFailure-impl(r14) == false) goto L35;
    L27:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L37
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L43:
        r16 = null;
        goto L44
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Message r110 = this.$curMessage;
        if (r110 == null) goto L16;
        String r111 = r110.getReplyId();
        if (r111 == null) goto L16;
        IChatRepoService r21 = RepoDispatcherDelegate.b.e();
        this.label = 1;
        r10 = r21.E1(r111, this);
        if (r10 != r1) goto L15;
        return r1;
    L16:
        r11 = null;
        goto L17
    }
}
