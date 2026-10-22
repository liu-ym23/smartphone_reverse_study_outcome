package com.bytedance.android.anniex.worker;

import com.bytedance.forest.model.Response;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/bytedance/forest/model/Response;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXJSWorkerManager$fetchJSFromGecko$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ Function5<Boolean, String, String, String, String, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnieXJSWorkerManager$fetchJSFromGecko$1(Function5<? super Boolean, ? super String, ? super String, ? super String, ? super String, Unit> r1) {
        this.$callback = r1;
        super(1);
    }

    public final void invoke(Response r12) {
        Intrinsics.checkNotNullParameter(r12, "response");
        StringBuilder r1 = new StringBuilder();
        r1.append(r12.s.a);
        r1.append(r12.s);
        String r10 = r1.toString();
        String r11 = null;
        byte[] r13 = r12.j();     // Catch: Exception -> L11
        if (r13 != null) goto L34;
        String r14 = null;
    L10:
        String r15 = r14;
    L17:
        if (r15 != null) goto L19;
        HybridLogger.i("AnnieXJSWorkerManager", "fetch js from gecko failed", null, 12);
        this.$callback.invoke(Boolean.FALSE, null, "fetch js from gecko failed msg: " + r10, null, null);
        return;
    L19:
        if (r13 == null) goto L21;
        AnnieXJSWorkerManager.a r16 = AnnieXJSWorkerManager.a(r13);
    L22:
        if (r16 == null) goto L26;
        boolean r17 = true;
        if (true != r16.a) goto L26;
    L27:
        if (r17 == false) goto L29;
        this.$callback.invoke(Boolean.TRUE, r15, null, String.valueOf(r12.B), r16.b);
        return;
    L29:
        HybridLogger.i("AnnieXJSWorkerManager", "js file md5 check failed", null, 12);
        Function5<Boolean, String, String, String, String, Unit> r18 = this.$callback;
        Boolean r19 = Boolean.FALSE;
        String r20 = String.valueOf(r12.B);
        if (r16 == null) goto L32;
        r11 = r16.b;
    L32:
        r18.invoke(r19, null, "js file md5 check failed", r20, r11);
        return;
    L26:
        r17 = false;
        goto L27
    L21:
        r16 = null;
        goto L22
    L34:
        r14 = new String(r13, Charsets.UTF_8);     // Catch: Exception -> L7
    L7:
        e = e;
    L13:
        String r21 = e.getMessage();
        if (r21 == null) goto L16;
        HybridLogger.i("AnnieXJSWorkerManager", r21, null, 12);
        r10 = r21;
    L16:
        r15 = null;
    L11:
        e = e;
        r13 = null;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Response) r1);
        return Unit.INSTANCE;
    }
}
