package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.message.IObricForegroundWidgetSyncService;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/messenger/stub/ObricForegroundWidgetSyncServiceImpl;", "Lcom/obric/assistant/spi/message/IObricForegroundWidgetSyncService;", "<init>", "()V", "awaitWidgetUpdatesBeforeConversationPull", NameKeys.UnloadStrategy_No_Strategy, "conversationId", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricForegroundWidgetSyncServiceImpl implements IObricForegroundWidgetSyncService {

    public static final class a {
    }

    static {
    }

    public ObricForegroundWidgetSyncServiceImpl() {
    }

    public final Object a(String r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1) == false) goto L7;
        ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1 r0 = (ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L24
    L20:
        Boolean r11 = (Boolean) r10;     // Catch: Throwable -> L24
        if (r11 == null) goto L28;
        r4 = r11.booleanValue();     // Catch: Throwable -> L24
    L28:
        FLogger.a.i("ObricForegroundWidgetSyncServiceImpl", "foreground widget sync finished before conversation pull, conversationId=" + r8 + ", success=" + r4);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$widgetSyncSucceeded$1 r12 = new ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$widgetSyncSucceeded$1(r8, null);     // Catch: Throwable -> L24
        r0.L$0 = r8;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        r10 = TimeoutKt.c(2000, r12, r0);     // Catch: Throwable -> L24
        if (r10 != r2) goto L20;
        return r2;
    L24:
        th = move-exception;
        if ((th instanceof CancellationException) == true) goto L30;
        FLogger.a.e("ObricForegroundWidgetSyncServiceImpl", "foreground widget sync failed before conversation pull, conversationId=" + r8, th);
        goto L28
    L30:
        throw th;
    L7:
        r0 = new ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1(this, r9);
        goto L8
    }
}
