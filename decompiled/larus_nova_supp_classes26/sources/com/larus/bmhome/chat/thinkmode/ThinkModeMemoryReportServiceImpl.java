package com.larus.bmhome.chat.thinkmode;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/thinkmode/ThinkModeMemoryReportServiceImpl;", "Lcom/larus/bmhome/chat/thinkmode/IThinkModeMemoryReportService;", "<init>", "()V", "report", "", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "behaviorSource", "Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;", "conversationSource", "Lcom/larus/bmhome/chat/thinkmode/ConversationSource;", "agentMode", "", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;Lcom/larus/bmhome/chat/thinkmode/ConversationSource;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThinkModeMemoryReportServiceImpl implements IThinkModeMemoryReportService {

    public static final class a {
    }

    static {
    }

    public ThinkModeMemoryReportServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService
    public final Object a(ReplyOption r20, BehaviorSource r21, ConversationSource r22, Integer r23, Continuation<? super Boolean> r24) {
        if ((r24 instanceof ThinkModeMemoryReportServiceImpl$report$1) == false) goto L7;
        ThinkModeMemoryReportServiceImpl$report$1 r1 = (ThinkModeMemoryReportServiceImpl$report$1) r24;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ThinkModeMemoryReportServiceImpl$report$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        Object r16 = null;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L62
    L60:
        Object r5 = Result.constructor-impl((com.larus.network.http.a) r0);     // Catch: Throwable -> L62
    L64:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L68;
        FLogger.a.w("ThinkModeMemoryReport", "think mode memory report failed", r6);
    L68:
        if (Result.isFailure-impl(r5) == true) goto L72;
        r16 = r5;
    L72:
        return Boxing.boxBoolean(((com.larus.network.http.a) r16) instanceof y);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        boolean r7 = false;
        if (r21 != BehaviorSource.UNKNOWN) goto L18;
    L73:
        FLogger.a.w("ThinkModeMemoryReport", "skip report with unknown source");
        return Boxing.boxBoolean(false);
    L18:
        if (r22 == ConversationSource.UNKNOWN) goto L73;
        ModelItemIdentity r8 = r20.getModel();
        JSONObject r9 = new JSONObject();
        Integer r10 = Boxing.boxInt(r8.getDeprecatedItemId());
        if (r10.intValue() <= 0) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == true) goto L27;
        r10 = null;
    L27:
        if (r10 == null) goto L29;
        r9.put("item_id", String.valueOf(r10.intValue()));
    L29:
        String r12 = r8.getKey();
        if (r12 != null) goto L32;
    L40:
        JSONObject r14 = new JSONObject();
        String r15 = r20.getModeId();
        if (r15 != null) goto L43;
        r15 = "";
    L43:
        r14.put("mode_id", r15);
        r14.put("model_item", r9);
        Integer r17 = r20.getReasoningEffort();
        if (r17 == null) goto L46;
        int r18 = r17.intValue();
    L47:
        r14.put("model_reasoning_effort", r18);
        if (r23 != null) goto L50;
    L57:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L62
        JSONObject r25 = new JSONObject();     // Catch: Throwable -> L62
        r25.put("memory_scene", "new_chat");     // Catch: Throwable -> L62
        r25.put("memory_item", r14);     // Catch: Throwable -> L62
        r25.put("behavior_source", r21.getValue());     // Catch: Throwable -> L62
        r25.put("conversation_source", r22.getValue());     // Catch: Throwable -> L62
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L62
        r13.label = 1;     // Catch: Throwable -> L62
        r0 = HttpExtKt.k("Social", Object.class, "/alice/slot/action_bar_v3/thinkmode_memory_report", r25, null, null, true, null, null, null, r13, 944);     // Catch: Throwable -> L62
        if (r0 != r3) goto L60;
        return r3;
    L50:
        if (r23.intValue() == AgentMode.UNKNOWN.getValue()) goto L52;
        r7 = true;
    L52:
        if (r7 == false) goto L54;
        Integer r27 = r23;
    L55:
        if (r27 == null) goto L57;
        r14.put("agent_mode", r27.intValue());
        goto L57
    L54:
        r27 = null;
        goto L55
    L46:
        r18 = 0;
        goto L47
    L32:
        if (r12.length() <= 0) goto L34;
        boolean r28 = true;
    L35:
        if (r28 == true) goto L38;
        r12 = null;
    L38:
        if (r12 == null) goto L40;
        r9.put("model_item_key", r12);
        goto L40
    L34:
        r28 = false;
        goto L35
    L23:
        r11 = false;
    L62:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r1 = new ThinkModeMemoryReportServiceImpl$report$1(this, r24);
        goto L8
    }
}
