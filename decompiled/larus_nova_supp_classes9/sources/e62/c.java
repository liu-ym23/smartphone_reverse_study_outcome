package e62;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        HorizontalPlayEvent r0 = new HorizontalPlayEvent(1, "source_for_chat_channel_panel_request_landscape");     // Catch: Throwable -> L4
        r0.rotationType = 1;     // Catch: Throwable -> L4
        xs2.b.a().post(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
