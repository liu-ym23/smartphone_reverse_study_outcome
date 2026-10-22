package n8b;

import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T, R> implements Function {
    public static final d<T, R> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r6) {
        x r7 = (s) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        if ((r7 instanceof x) == false) goto L6;
        return Single.just(r7.c);
    L6:
        if ((r7 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
        com.bytedance.lark.rustclient.api.c r8 = (com.bytedance.lark.rustclient.api.c) r7;
        p r0 = r8.c;
        LarkError r1 = r0.b;
        Integer r2 = null;
        if (r1 == null) goto L12;
        LarkError.ErrorDetails r3 = r1.details;
        if (r3 == null) goto L12;
        String r4 = r3.x_tt_logid;
    L13:
        if (r1 == null) goto L15;
        r2 = r1.code;
    L15:
        String r5 = r0.c();
        int r9 = ScsLogger.a;
        ScsLogger.c("ConditionalAccessNetDependency", "getDeviceApplySwitchDataV2 error, logId: " + r4 + ", errorCode: " + r2 + ", error is " + r5);
        return Single.error(r8.c.b());
    L12:
        r4 = null;
        goto L13
    L18:
        throw new NoWhenBranchMatchedException();
    }
}
