package n8b;

import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ long a;

    public e(long r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        x r8 = (s) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        Integer r1 = null;
        if ((r8 instanceof x) == false) goto L6;
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        FileAuthMonitor.f(0, System.currentTimeMillis() - this.a, null, null);
        return Single.just(r8.c);
    L6:
        if ((r8 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
        com.bytedance.lark.rustclient.api.c r9 = (com.bytedance.lark.rustclient.api.c) r8;
        p r2 = r9.c;
        LarkError r3 = r2.b;
        if (r3 == null) goto L12;
        LarkError.ErrorDetails r4 = r3.details;
        if (r4 == null) goto L12;
        String r5 = r4.x_tt_logid;
    L13:
        if (r3 == null) goto L15;
        r1 = r3.code;
    L15:
        String r6 = r2.c();
        int r10 = ScsLogger.a;
        ScsLogger.c("ConditionalAccessNetDependency", "getDisplayTemplate error, logId: " + r5 + ", errorCode: " + r1 + ", error is " + r6);
        FileAuthMonitor.UpdateTrigger[] r11 = FileAuthMonitor.a;
        FileAuthMonitor.f(1, System.currentTimeMillis() - this.a, r1, r6);
        return Single.error(r9.c.b());
    L12:
        r5 = null;
        goto L13
    L18:
        throw new NoWhenBranchMatchedException();
    }
}
