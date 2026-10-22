package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.h5;
import com.obric.memorydata.sdk.proactive.ProactiveAllPageSnapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/proactive/ProactiveAllPageSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository$loadSnapshot$1$snapshot$1", f = "ProactiveAgentProvider.kt", i = {}, l = {397, 405}, m = "invokeSuspend", n = {}, s = {})
public final class ProactiveAgentRepository$loadSnapshot$1$snapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ProactiveAllPageSnapshot>, Object> {
    final /* synthetic */ Ref.BooleanRef $loadedByWindowApi;
    final /* synthetic */ h5 $window;
    int label;

    public ProactiveAgentRepository$loadSnapshot$1$snapshot$1(h5 r1, Ref.BooleanRef r2, Continuation<? super ProactiveAgentRepository$loadSnapshot$1$snapshot$1> r3) {
        this.$window = r1;
        this.$loadedByWindowApi = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProactiveAgentRepository$loadSnapshot$1$snapshot$1(this.$window, this.$loadedByWindowApi, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ProactiveAllPageSnapshot> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        ProactiveAllPageSnapshot r2 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L28:
        return (ProactiveAllPageSnapshot) r12;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L16:
        ProactiveAllPageSnapshot r13 = (ProactiveAllPageSnapshot) r12;
        if (r13 == null) goto L19;
        this.$loadedByWindowApi.element = true;
        return r13;
    L19:
        ska.b.a.getClass();
        String r14 = ska.b.a("loadAiProactiveAllRecommendationsSnapshot", "requestJson", "{}");
        if (r14 == null) goto L22;
        r2 = ska.b.e(r14);
    L22:
        if (r2 != null) goto L24;
        r2 = new ProactiveAllPageSnapshot(0, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false);
    L24:
        kotlinx.coroutines.flow.n r15 = new kotlinx.coroutines.flow.n(r2);
        this.label = 2;
        r12 = kotlinx.coroutines.flow.e.v(r15, this);
        if (r12 != r0) goto L28;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        ska.b r16 = ska.b.a;
        h5 r3 = this.$window;
        long r6 = r3.a;
        long r8 = r3.b;
        this.label = 1;
        r16.getClass();
        String r17 = ska.b.a("loadAiProactiveRecommendationsSnapshot", "requestJson", new JSONObject().put("earliestTimeMillis", r6).put("latestTimeMillis", r8).toString());
        if (r17 == null) goto L13;
        r12 = ska.b.e(r17);
    L14:
        if (r12 != r0) goto L16;
        return r0;
    L13:
        r12 = null;
        goto L14
    }
}
