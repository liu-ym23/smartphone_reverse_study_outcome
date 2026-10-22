package com.larus.dora.impl.device.ailab.keywords;

import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.ailab.t;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler$handleWakeupKeywordsJson$1", f = "DoraWakeupKeywordsHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWakeupKeywordsHandler$handleWakeupKeywordsJson$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraWakeupKeywords $doraWakeupKeywords;
    int label;

    public DoraWakeupKeywordsHandler$handleWakeupKeywordsJson$1(DoraWakeupKeywords r1, Continuation<? super DoraWakeupKeywordsHandler$handleWakeupKeywordsJson$1> r2) {
        this.$doraWakeupKeywords = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraWakeupKeywordsHandler$handleWakeupKeywordsJson$1(this.$doraWakeupKeywords, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r8);
        int r9 = a.a;
        DoraWakeupKeywords r10 = this.$doraWakeupKeywords;
        Intrinsics.checkNotNullParameter(r10, "wakeupKeywords");
        Lazy<String> r0 = t.h;
        String r1 = a.a(r10, t.a.a());
        String r2 = "on";
        if (Intrinsics.areEqual(r1, "on") == false) goto L8;
        String r3 = "off";
    L11:
        DoraBuryPointManager r4 = DoraBuryPointManager.a;
        Pair[] r5 = new Pair[4];
        if (DoraAdapterExtKt.p(kj4.a.g()) == true) goto L15;
        r2 = "off";
    L15:
        r5[0] = TuplesKt.to("switch", r2);
        r5[1] = TuplesKt.to("owen_switch", a.a(r10, t.a.b()));
        r5[2] = TuplesKt.to("bi_syllable_switch", r1);
        r5[3] = TuplesKt.to("syllable_switch", r3);
        r4.L("dora_agent_settings_result", MapsKt.mapOf(r5));
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r1, "off") == false) goto L10;
        r3 = "on";
        goto L11
    L10:
        r3 = "none";
        goto L11
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
