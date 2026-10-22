package com.obric.matrix.sdk.push.cross_process;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import jka.b;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Deprecated(message = "待移除")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/MessageServiceV2;", "Lcom/obric/matrix/sdk/push/cross_process/CrossProcessService;", "Lcom/obric/matrix/sdk/push/a;", "<init>", "()V", "sdk_push_release"}, k = 1, mv = {1, 6, 0})
public abstract class MessageServiceV2 extends CrossProcessService implements com.obric.matrix.sdk.push.a {

    public static final class a implements b {
        public final /* synthetic */ MessageServiceV2 a;

        public a(MessageServiceV2 r1) {
            this.a = r1;
        }

        @Override // jka.b
        public final void a(String r3, List r4) {
            Intrinsics.checkNotNullParameter(r3, "originPkgName");
            if (r4 != null) goto L5;
        L21:
            kka.b.b("message service v2 args is null or size < 2");
            return;
        L5:
            if (r4.size() < 2) goto L21;
            Object r5 = ListProtector.get(r4, 0);     // Catch: Throwable -> L18
            if (r5 == null) goto L17;
            String r6 = (String) r5;     // Catch: Throwable -> L18
            Object r7 = ListProtector.get(r4, 1);     // Catch: Throwable -> L18
            if (r7 == null) goto L15;
            MessageServiceV2 r0 = this.a;     // Catch: Throwable -> L18
            Intrinsics.checkNotNullParameter(r6, "msgId");     // Catch: Throwable -> L18
            Intrinsics.checkNotNullParameter((String) r7, "data");     // Catch: Throwable -> L18
            r0.b();     // Catch: Throwable -> L18
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            kka.b.b("message service v2 error: " + th);
        }
    }

    @Override // com.obric.matrix.sdk.push.cross_process.CrossProcessService
    public final void c() {
        com.obric.matrix.push.common.cross_process.CrossProcessService r0 = ika.a.a.a(this);
        com.obric.matrix.push.common.cross_process.CrossProcessService r1 = r0;
        r1.d(new a(this));
    }

    public MessageServiceV2() {
    }
}
