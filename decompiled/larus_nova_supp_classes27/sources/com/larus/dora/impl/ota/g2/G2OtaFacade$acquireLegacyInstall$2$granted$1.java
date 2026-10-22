package com.larus.dora.impl.ota.g2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/dora/impl/ota/g2/OtaEngineState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.G2OtaFacade$acquireLegacyInstall$2$granted$1", f = "G2OtaFacade.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class G2OtaFacade$acquireLegacyInstall$2$granted$1 extends SuspendLambda implements Function2<b5, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $requestId;
    /* synthetic */ Object L$0;
    int label;

    public G2OtaFacade$acquireLegacyInstall$2$granted$1(String r1, Continuation<? super G2OtaFacade$acquireLegacyInstall$2$granted$1> r2) {
        this.$requestId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        G2OtaFacade$acquireLegacyInstall$2$granted$1 r0 = new G2OtaFacade$acquireLegacyInstall$2$granted$1(this.$requestId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(b5 r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b5) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r5);
        b5 r6 = (b5) this.L$0;
        t4 r0 = r6.h();
        if (r0 == null) goto L7;
        String r1 = r0.e();
    L8:
        boolean r2 = true;
        if (Intrinsics.areEqual(r1, this.$requestId) == true) goto L25;
        List r7 = r6.i();
        String r3 = this.$requestId;
        if ((r7 instanceof Collection) == true) goto L13;
    L15:
        Iterator r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(((u4) r8.next()).e(), r3) == false) goto L17;
        boolean r9 = false;
    L21:
        if (r9 == true) goto L25;
        r2 = false;
    L14:
        r9 = true;
        goto L21
    L13:
        if (r7.isEmpty() == false) goto L15;
    L25:
        return Boxing.boxBoolean(r2);
    L7:
        r1 = null;
        goto L8
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
