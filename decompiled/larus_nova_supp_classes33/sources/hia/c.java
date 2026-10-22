package hia;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final AtomicReference<a> a = null;
    public static final CopyOnWriteArraySet<hga.a> b = null;

    static {
        a = new AtomicReference(null);
        b = new CopyOnWriteArraySet();
    }

    public static void a(a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        AtomicReference<a> r0 = a;
    L6:
        if (r0.compareAndSet(r2, null) == true) goto L10;
        if (r0.get() == r2) goto L6;
        return;
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
        a r0 = a.getAndSet(null);
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger.a.i("ObricContTalkSessionStore", "stopCurrentImmediately: reason=".concat(r3));
        r0.c();
    }
}
