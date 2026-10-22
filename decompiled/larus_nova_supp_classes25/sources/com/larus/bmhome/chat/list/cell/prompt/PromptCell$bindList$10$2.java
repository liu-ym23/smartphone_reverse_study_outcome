package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.podcast.IFlowPodcastService;
import com.larus.podcast.api.PodcastClickSource;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$bindList$10$2", f = "PromptCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PromptCell$bindList$10$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ PromptContent.SuggestV2 $suggest;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ PromptCell this$0;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    public PromptCell$bindList$10$2(Message r1, View r2, PromptCell r3, PromptContent.SuggestV2 r4, Continuation<? super PromptCell$bindList$10$2> r5) {
        this.$data = r1;
        this.$view = r2;
        this.this$0 = r3;
        this.$suggest = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PromptCell$bindList$10$2(this.$data, this.$view, this.this$0, this.$suggest, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = "";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L62;
        ResultKt.throwOnFailure(r14);
        PromptContent.SuggestV2 r15 = this.$suggest;
        boolean r3 = true;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L31
        zd9.h r6 = zd9.h.a;     // Catch: Throwable -> L31
        String r16 = r15.getExtra();     // Catch: Throwable -> L31
        if (r16 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L63;
    L23:
        Object r17 = null;
    L24:
        Map r18 = (Map) r17;     // Catch: Throwable -> L31
        if (r18 == null) goto L28;
        String r19 = (String) r18.get("message_id");     // Catch: Throwable -> L31
        if (r19 == null) goto L28;
    L29:
        Object r110 = Result.constructor-impl(r19);     // Catch: Throwable -> L31
    L33:
        PromptContent.SuggestV2 r1 = this.$suggest;
        Throwable r8 = Result.exceptionOrNull-impl(r110);
        if (r8 == null) goto L37;
        FLogger.a.e("WcbSugPromptCell", "onPromptSelected: handle podcast suggest click, serialize extra failed, " + r1.getExtra(), r8);
    L37:
        if (Result.isFailure-impl(r110) == true) goto L40;
        r0 = r110;
    L40:
        String r10 = (String) r0;
        if (r10.length() != 0) goto L43;
        boolean r111 = true;
    L44:
        if (r111 == false) goto L47;
        FLogger.a.i("WcbSugPromptCell", "onPromptSelected: handle podcast suggest click, but messageId is null");
        return Unit.INSTANCE;
    L47:
        String r11 = this.$data.getConversationId();
        if (r11 != null) goto L50;
    L53:
        if (r3 == false) goto L56;
        FLogger.a.i("WcbSugPromptCell", "onPromptSelected: handle podcast suggest click, but conversationId is null");
        return Unit.INSTANCE;
    L56:
        IFlowPodcastService r112 = (IFlowPodcastService) ServiceManager.get().getService(IFlowPodcastService.class);
        if (r112 == null) goto L60;
        r112.b(new vr9.a(this.$view.getContext(), LifecycleOwnerKt.getLifecycleScope(this.this$0), r10, r11, PodcastClickSource.SuggestPrompt), null, null);
    L60:
        return Unit.INSTANCE;
    L50:
        if (r11.length() == 0) goto L53;
        r3 = false;
        goto L53
    L43:
        r111 = false;
    L28:
        r19 = "";
        goto L29
    L63:
        r6.getClass();     // Catch: Throwable -> L16
        r17 = Result.constructor-impl(zd9.h.b.fromJson(r16, new a().getType()));     // Catch: Throwable -> L16
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L31
        if (r9 == null) goto L22;
        com.larus.im.internal.delegate.c0 r12 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L31
        StringBuilder r13 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L31
        Intrinsics.checkNotNullParameter(r9, "<this>");     // Catch: Throwable -> L31
        r13.append(ExceptionsKt.stackTraceToString(r9));     // Catch: Throwable -> L31
        r12.e("GsonHolder", r13.toString());     // Catch: Throwable -> L31
    L22:
        if (Result.isFailure-impl(r17) == false) goto L24;
    L16:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L31
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
        goto L18
    L8:
        if (StringsKt.isBlank(r16) == true) goto L11;
        r7 = false;
    L31:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L62:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
