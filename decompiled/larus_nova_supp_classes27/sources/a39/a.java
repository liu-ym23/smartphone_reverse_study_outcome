package a39;

import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowHiddenReason;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a(ContextWindowHiddenReason r3, ContextWindowEnterFrom r4) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        FLogger.a.i("ContextWindowTracker", "entry hidden reason=" + r3.name() + " enterFrom=" + r4.getWireValue());
    }
}
