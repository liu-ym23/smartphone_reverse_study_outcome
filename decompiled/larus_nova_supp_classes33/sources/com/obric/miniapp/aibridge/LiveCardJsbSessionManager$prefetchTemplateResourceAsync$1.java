package com.obric.miniapp.aibridge;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.aibridge.LiveCardJsbSessionManager$prefetchTemplateResourceAsync$1", f = "LiveCardJsbMethods.kt", i = {0}, l = {160}, m = "invokeSuspend", n = {"start"}, s = {"J$0"})
public final class LiveCardJsbSessionManager$prefetchTemplateResourceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $kind;
    final /* synthetic */ String $packageId;
    final /* synthetic */ String $sessionKey;
    final /* synthetic */ String $tag;
    final /* synthetic */ String $templateId;
    final /* synthetic */ String $widgetId;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    public LiveCardJsbSessionManager$prefetchTemplateResourceAsync$1(String r1, String r2, String r3, String r4, String r5, String r6, Continuation<? super LiveCardJsbSessionManager$prefetchTemplateResourceAsync$1> r7) {
        this.$sessionKey = r1;
        this.$tag = r2;
        this.$kind = r3;
        this.$templateId = r4;
        this.$packageId = r5;
        this.$widgetId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        LiveCardJsbSessionManager$prefetchTemplateResourceAsync$1 r8 = new LiveCardJsbSessionManager$prefetchTemplateResourceAsync$1(this.$sessionKey, this.$tag, this.$kind, this.$templateId, this.$packageId, this.$widgetId, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        long r3 = this.J$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L8
    L17:
        Object r12 = Result.constructor-impl((Widget) r11);     // Catch: Throwable -> L8
    L22:
        String r5 = null;
        if (Result.isFailure-impl(r12) == false) goto L25;
        r12 = null;
    L25:
        Widget r13 = (Widget) r12;
        long r6 = System.currentTimeMillis() - r3;
        LiveCardJsbSessionManager r4 = LiveCardJsbSessionManager.a;
        String r7 = this.$sessionKey;
        String r8 = this.$tag;
        StringBuilder r9 = new StringBuilder("kind=");
        r9.append(this.$kind);
        r9.append(" templateId=");
        r9.append(this.$templateId);
        r9.append(" ok=");
        if (r13 == null) goto L28;
        r2 = true;
    L28:
        r9.append(r2);
        r9.append(" costMs=");
        r9.append(r6);
        r9.append(" resFrom=");
        if (r13 == null) goto L31;
        r5 = ((AIPackage) r13).B;
    L31:
        if (r5 != null) goto L33;
        r5 = "";
    L33:
        r9.append(r5);
        r9.append(" version=");
        if (r13 == null) goto L36;
        long r10 = ((AIPackage) r13).c;
    L37:
        r9.append(r10);
        String r14 = r9.toString();
        r4.getClass();
        LiveCardJsbSessionManager.n("show.prefetch", r7, r8, r14);
        if (r13 == null) goto L41;
        final String r15 = this.$tag;
        final String r16 = this.$sessionKey;
        final String r17 = "prefetch:" + this.$kind;
        LiveCardJsbSessionManager.c.post(new k(r15, r16, r17));
    L41:
        return Unit.INSTANCE;
    L36:
        r10 = -1;
    L8:
        th = th;
        long r18 = r3;
    L21:
        Result.Companion r19 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        r3 = r18;
        goto L22
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        r18 = System.currentTimeMillis();
        String r111 = this.$packageId;
        String r20 = this.$widgetId;
        String r21 = this.$tag;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L20
        AIManager r23 = AIManager.a;     // Catch: Throwable -> L20
        Map r24 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_livecard_session", r21)});     // Catch: Throwable -> L20
        this.J$0 = r18;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        r11 = r23.E(r111, r20, r24, this);     // Catch: Throwable -> L20
        if (r11 != r0) goto L16;
        return r0;
    L16:
        r3 = r18;
    L20:
        th = th;
        goto L21
    }
}
