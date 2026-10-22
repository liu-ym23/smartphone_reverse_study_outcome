package j8b;

import com.bytedance.lark.policy.model.ResponseType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T, R> implements Function {
    public static final f<T, R> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r4) {
        com.ss.android.lark.security.compliance.infra.network.h r5 = (com.ss.android.lark.security.compliance.infra.network.h) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        j r6 = (j) r5.d;
        if (r6 == null) goto L5;
        ResponseType r0 = ResponseType.REMOTE;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r6.a = r0;
        r6.a().put("CCM_FILE_DOWNLOAD", r6.a().get("CCM_EXPORT"));
        return r6;
    L5:
        return null;
    }
}
