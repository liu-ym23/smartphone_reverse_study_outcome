package com.larus.dora.impl.serviceimpl;

import android.text.TextUtils;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yj4.a;
import yj4.f;
import yj4.g;
import yj4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.VisionService$init$1$onDoraLinkStateChanged$1", f = "VisionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VisionService$init$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VisionService this$0;

    public VisionService$init$1$onDoraLinkStateChanged$1(VisionService r1, Continuation<? super VisionService$init$1$onDoraLinkStateChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VisionService$init$1$onDoraLinkStateChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r12);
        String r13 = AccountService.a.getUserId();
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r13, "uid");
        FLogger.a.i("VisionService", "requestAlbumState");
        int r0 = g.a;
        f r1 = f.a.a;
        r1.getClass();
        pk4.j.a("DoraGlass", "requestAlbumState: uid=".concat(r13));
        int r4 = 0;
        Integer r5 = null;
        if (TextUtils.isEmpty(r13) == false) goto L7;
        a r14 = null;
    L8:
        if (r14 == null) goto L10;
        Integer r2 = Integer.valueOf(r14.a);
    L11:
        if (r14 == null) goto L14;
        r5 = Integer.valueOf(r14.b);
    L14:
        if (r2 == null) goto L16;
        int r3 = r2.intValue();
    L17:
        Integer r6 = Boxing.boxInt(r3);
        if (r5 == null) goto L20;
        r4 = r5.intValue();
    L20:
        Pair r15 = new Pair(r6, Boxing.boxInt(r4));
        VisionService.e(this.this$0, ((Number) r15.getFirst()).intValue(), ((Number) r15.getSecond()).intValue());
        return Unit.INSTANCE;
    L16:
        r3 = 0;
        goto L17
    L10:
        r2 = null;
        goto L11
    L7:
        byte[] r7 = new String(r13.toCharArray()).getBytes(StandardCharsets.UTF_8);
        pk4.j.d("DoraGlass", "requestAlbumState: uid=" + r13 + ", ret=" + h.C2.i(2, 13, pk4.n.u(pk4.n.u(new byte[]{1, (byte) r7.length}, r7), new byte[]{2, 0, 3, 0})) + ", " + r1.g);
        r14 = r1.g;
        goto L8
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
