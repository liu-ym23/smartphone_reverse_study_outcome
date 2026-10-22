package com.bytedance.ai.applet.login;

import android.app.Activity;
import com.bytedance.ai.widget.WidgetManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.McpLoginManager$loadAddShowWidget$1", f = "McpLoginManager.kt", i = {0, 0}, l = {520}, m = "invokeSuspend", n = {"$this$launch", "widgetManager"}, s = {"L$0", "L$1"})
final class McpLoginManager$loadAddShowWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $appletId;
    final /* synthetic */ h5.k $renderContext;
    final /* synthetic */ String $widgetId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public McpLoginManager$loadAddShowWidget$1(h5.k r1, String r10, String r11, Activity r12, Continuation<? super McpLoginManager$loadAddShowWidget$1> r13) {
        this.$renderContext = r1;
        this.$appletId = r10;
        this.$widgetId = r11;
        this.$activity = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        McpLoginManager$loadAddShowWidget$1 r12 = new McpLoginManager$loadAddShowWidget$1(this.$renderContext, this.$appletId, this.$widgetId, this.$activity, r11);
        r12.L$0 = r10;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15, types: [l2.a] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.ai.applet.login.f] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ai.widget.WidgetManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [l2.a] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        ?? r11 = (l2.a) this.L$1;
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L8
        r11 = r11;
    L18:
        com.bytedance.ai.widget.contianer.h r13 = (com.bytedance.ai.widget.contianer.h) r10;     // Catch: Exception -> L8
        ?? r14 = r11;
    L24:
        if (r13 != null) goto L28;
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "loadAddShowWidget: widgetView is null");
        return Unit.INSTANCE;
    L28:
        if (p.c.get() != null) goto L30;
        p.c = new WeakReference(new f(this.$activity));
    L30:
        f r15 = p.c.get();
        if (r15 != 0) goto L34;
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "loadAddShowWidget: cannot get drawerContainer");
        return Unit.INSTANCE;
    L34:
        r15.f();
        r15.a(r14, r13);
        r15.b(this.$activity);
        r15.d(null);
        return Unit.INSTANCE;
    L8:
        e = e;
        ?? r16 = r11;
    L22:
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "loadAddShowWidget: 创建失败", e);
        ?? r17 = r16;
    L23:
        r13 = null;
        r14 = r17;
        goto L24
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        r16 = WidgetManager.h.b();
        r17 = r16;
        if (r16 == 0) goto L23;
        h5.k r19 = this.$renderContext;     // Catch: Exception -> L21
        String r20 = this.$appletId;     // Catch: Exception -> L21
        String r21 = this.$widgetId;     // Catch: Exception -> L21
        this.L$0 = r18;     // Catch: Exception -> L21
        this.L$1 = r16;     // Catch: Exception -> L21
        this.label = 1;     // Catch: Exception -> L21
        r10 = r16.i(r19, r20, r21, this);     // Catch: Exception -> L21
        if (r10 != r0) goto L17;
        return r0;
    L17:
        r11 = r16;
    L21:
        e = e;
        goto L22
    }
}
