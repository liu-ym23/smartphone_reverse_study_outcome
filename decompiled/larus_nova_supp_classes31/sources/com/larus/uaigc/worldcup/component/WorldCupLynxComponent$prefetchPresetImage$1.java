package com.larus.uaigc.worldcup.component;

import com.bytedance.keva.Keva;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.uaigc.lynx.pocket.SendMsgPocket;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.worldcup.component.WorldCupLynxComponent$prefetchPresetImage$1", f = "WorldCupLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WorldCupLynxComponent$prefetchPresetImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pocket $pocket;
    int label;
    final /* synthetic */ WorldCupLynxComponent this$0;

    public WorldCupLynxComponent$prefetchPresetImage$1(Pocket r1, WorldCupLynxComponent r2, Continuation<? super WorldCupLynxComponent$prefetchPresetImage$1> r3) {
        this.$pocket = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WorldCupLynxComponent$prefetchPresetImage$1(this.$pocket, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r8);
        SendMsgPocket r9 = this.$pocket.getSendMsgPocket();
        if (r9 == null) goto L18;
        final String r10 = r9.getPresetImageUri();
        if (r10 == null) goto L18;
        final WorldCupLynxComponent r0 = this.this$0;
        Pocket r1 = this.$pocket;
        FLogger r2 = FLogger.a;
        r2.i(r0.m, "[prefetchPresetImage] imageUri: ".concat(r10));
        Keva r3 = e0a.b.a;
        Intrinsics.checkNotNullParameter(r10, "key");
        String r4 = e0a.b.a.getString(r10, null);
        r2.i(r0.m, "[prefetchPresetImage] cachedPath: " + r4);
        if (m5.c(r4) == false) goto L12;
        r2.i(r0.m, "[prefetchPresetImage] cachedPath is exists, skip download");
        return Unit.INSTANCE;
    L12:
        SendMsgPocket r5 = r1.getSendMsgPocket();
        if (r5 == null) goto L18;
        String r6 = r5.getPresetImageUrl();
        if (r6 == null) goto L18;
        r2.i(r0.m, "[prefetchPresetImage] download imageUrl: ".concat(r6));
        ImageSave.j(ImageSave.a, r6, r10, new r(r0, r10));
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
