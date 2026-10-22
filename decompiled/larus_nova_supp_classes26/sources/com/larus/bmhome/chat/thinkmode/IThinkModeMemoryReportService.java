package com.larus.bmhome.chat.thinkmode;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/thinkmode/IThinkModeMemoryReportService;", "", "report", "", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "behaviorSource", "Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;", "conversationSource", "Lcom/larus/bmhome/chat/thinkmode/ConversationSource;", "agentMode", "", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;Lcom/larus/bmhome/chat/thinkmode/ConversationSource;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IThinkModeMemoryReportService {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final Lazy<IThinkModeMemoryReportService> b = null;

        public Companion() {
        }

        static {
            a = new Companion();
            b = LazyKt.lazy(new a());
        }

        public final Object a(ReplyOption r9, BehaviorSource r10, ConversationSource r11, Integer r12, Continuation<? super Boolean> r13) {
            if ((r13 instanceof IThinkModeMemoryReportService$Companion$report$1) == false) goto L7;
            IThinkModeMemoryReportService$Companion$report$1 r0 = (IThinkModeMemoryReportService$Companion$report$1) r13;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            IThinkModeMemoryReportService$Companion$report$1 r6 = r0;
            Object r14 = r6.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r6.label;
            if (r3 == 0) goto L18;
            if (r3 != 1) goto L17;
            r11 = (ConversationSource) r6.L$1;
            r10 = (BehaviorSource) r6.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        L28:
            boolean r15 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L14
        L30:
            Object r16 = Result.constructor-impl(Boxing.boxBoolean(r15));     // Catch: Throwable -> L14
        L33:
            Throwable r17 = Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L36;
            FLogger.a.w("ThinkModeMemoryReport", "think mode memory report failed, source=" + r10 + ", conversationSource=" + r11, r17);
        L36:
            Boolean r18 = Boxing.boxBoolean(false);
            if (Result.isFailure-impl(r16) == true) goto L39;
            return r16;
        L39:
            return r18;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r14);
            if (r10 == BehaviorSource.UNKNOWN) goto L41;
            if (r11 == ConversationSource.UNKNOWN) goto L41;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L14
            IThinkModeMemoryReportService r4 = (IThinkModeMemoryReportService) b.getValue();     // Catch: Throwable -> L14
            if (r4 == null) goto L29;
            r6.L$0 = r10;     // Catch: Throwable -> L14
            r6.L$1 = r11;     // Catch: Throwable -> L14
            r6.label = 1;     // Catch: Throwable -> L14
            r14 = r4.a(r9, r10, r11, r12, r6);     // Catch: Throwable -> L14
            if (r14 != r2) goto L28;
            return r2;
        L29:
            r15 = false;
        L41:
            return Boxing.boxBoolean(false);
        L14:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
        L7:
            r0 = new IThinkModeMemoryReportService$Companion$report$1(this, r13);
            goto L8
        }
    }

    static {
        a = Companion.a;
    }

    Object a(ReplyOption r1, BehaviorSource r2, ConversationSource r3, Integer r4, Continuation<? super Boolean> r5);
}
