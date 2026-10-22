package v89;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Function2 b;

    public /* synthetic */ j(Ref.BooleanRef r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref.BooleanRef r0 = this.a;
        Function2 r1 = this.b;
        if (r0.element == true) goto L6;
        FLogger.a.e("FlowTransferRedirect", "[timeout] JS did not respond in 2500ms, fallback");
        r1.invoke(null, "timeout");
        return;
    }
}
