package q48;

import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i implements IALogActiveUploadObserver {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function3 b;

    public /* synthetic */ i(Function1 r1, Function3 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void flushAlogDataToFile() {
        Function1 r0 = this.a;
        Function3 r1 = this.b;
        ALog.asyncFlush();     // Catch: Exception -> L5
        ObricAlogServiceDelegate.b.e();     // Catch: Exception -> L5
        Thread.sleep(1000);     // Catch: Exception -> L5
        return;
    L6:
        if (r0 == null) goto L8;
        r0.invoke(Boolean.FALSE);
    L8:
        if (r1 == null) goto L13;
        r1.invoke(Boolean.FALSE, 0, "");
        return;
    }
}
