package ty9;

import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final MutableSharedFlow<CreationSendUiEvent> a = null;
    public static final a1 b = null;

    static {
        MutableSharedFlow<CreationSendUiEvent> r0 = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        a = r0;
        b = e.a(r0);
    }

    public static void a(CreationSendUiEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (a.tryEmit(r3) == true) goto L6;
        FLogger.a.w("CreationSendUiEventBus", "post event failed, cvsId:" + r3.getCvsId() + ", requestId:" + r3.getRequestId());
        return;
    }
}
