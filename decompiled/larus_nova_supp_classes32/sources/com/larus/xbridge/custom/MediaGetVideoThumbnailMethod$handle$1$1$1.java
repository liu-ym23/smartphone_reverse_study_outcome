package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.MediaGetVideoThumbnailMethod$handle$1$1$1", f = "MediaGetVideoThumbnailMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaGetVideoThumbnailMethod$handle$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ Pair<String, String> $pair;
    int label;
    final /* synthetic */ s1 this$0;

    public MediaGetVideoThumbnailMethod$handle$1$1$1(s1 r1, IvyBridgeMethod.a r2, Pair<String, String> r3, Continuation<? super MediaGetVideoThumbnailMethod$handle$1$1$1> r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$pair = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaGetVideoThumbnailMethod$handle$1$1$1(this.this$0, this.$callback, this.$pair, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r6);
        s1 r7 = this.this$0;
        IvyBridgeMethod.a r0 = this.$callback;
        LinkedHashMap r1 = new LinkedHashMap();
        Pair<String, String> r2 = this.$pair;
        String r3 = (String) r2.getFirst();
        if (r3 == null) goto L7;
        r1.put("base64", r3);
    L7:
        String r4 = (String) r2.getSecond();
        if (r4 == null) goto L10;
        r1.put("tmpPath", r4);
    L10:
        Unit r5 = Unit.INSTANCE;
        bx7.c.d(r7, r0, r1);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
