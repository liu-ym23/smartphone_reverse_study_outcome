package fha;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements IIMCallback<Message> {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;

    public final boolean mustInMain() {
        return false;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger r0 = FLogger.a;
        this.a.getClass();
        r0.w("[AudioPlayStateHandler]", "handleTtsStartFromBizExtra, getMessageById failed: " + r5 + ", fallback to unknown, messageId=" + this.b);
        a r6 = this.a;
        String r1 = this.b;
        Object r2 = this.c;
        Object r3 = r6.a;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r6.c(r1, r2) == true) goto L8;
        monitor-exit(r3);
        return;
    L8:
        r6.j(r1);     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r3);
    }

    public final void onSuccess(Object r5) {
        Message r6 = (Message) r5;
        Intrinsics.checkNotNullParameter(r6, WindowEvent.Params.RESULT);
        a r0 = this.a;
        String r1 = this.b;
        Object r2 = this.c;
        Object r3 = r0.a;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r0.c(r1, r2) == true) goto L8;
        monitor-exit(r3);
        return;
    L8:
        r0.k(r6);     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r3);
    }

    public b(a r1, String r2, Object r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
