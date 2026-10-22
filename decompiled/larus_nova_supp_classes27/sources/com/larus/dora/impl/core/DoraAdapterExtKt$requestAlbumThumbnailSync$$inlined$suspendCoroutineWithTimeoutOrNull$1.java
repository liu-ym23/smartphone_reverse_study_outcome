package com.larus.dora.impl.core;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import pk4.n;
import yj4.f;
import yj4.g;
import yj4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$suspendCoroutineWithTimeoutOrNull$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt$requestAlbumThumbnailSync$$inlined$suspendCoroutineWithTimeoutOrNull$1", f = "DoraAdapterExt.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class DoraAdapterExtKt$requestAlbumThumbnailSync$$inlined$suspendCoroutineWithTimeoutOrNull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super yj4.b>, Object> {
    final /* synthetic */ String $uid$inlined;
    Object L$0;
    int label;

    public DoraAdapterExtKt$requestAlbumThumbnailSync$$inlined$suspendCoroutineWithTimeoutOrNull$1(Continuation r1, String r2) {
        this.$uid$inlined = r2;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraAdapterExtKt$requestAlbumThumbnailSync$$inlined$suspendCoroutineWithTimeoutOrNull$1(r3, this.$uid$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super yj4.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L17:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        this.label = 1;
        kotlinx.coroutines.j r14 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r14.C();
        int r2 = g.a;
        f r3 = f.a.a;
        c r4 = new c(r3, r14);
        r3.getClass();
        ((CopyOnWriteArraySet) h.D2).add(r4);
        g49.d.d("DoraAdapterExt", "requestAlbumThumbnail: start");
        String r5 = this.$uid$inlined;
        pk4.j.a("DoraGlass", "requestAlbumThumbnail: uid=" + r5);
        if (TextUtils.isEmpty(r5) == true) goto L12;
        byte[] r6 = new String(r5.toCharArray()).getBytes(StandardCharsets.UTF_8);
        byte[] r7 = n.u(new byte[]{1, (byte) r6.length}, r6);
        pk4.j.d("DoraGlass", "requestAlbumThumbnail: uid=" + r5 + ", ret=" + h.C2.i(2, 15, n.u(new byte[]{1, (byte) r7.length}, r7)));
    L12:
        r14.i(new b(r3, r4));
        r13 = r14.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r13 != r0) goto L17;
        return r0;
    }
}
