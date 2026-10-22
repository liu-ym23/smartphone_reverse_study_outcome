package com.larus.uaigc.creation.detail.image;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.datasource.DataSource;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import hq9.v1;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$prefetchToCreationBitmapCache$1", f = "BigImageDetailFragment.kt", i = {}, l = {275, 279}, m = "invokeSuspend", n = {}, s = {})
final class BigImageDetailFragment$prefetchToCreationBitmapCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$prefetchToCreationBitmapCache$1(BigImageDetailFragment r1, Continuation<? super BigImageDetailFragment$prefetchToCreationBitmapCache$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BigImageDetailFragment$prefetchToCreationBitmapCache$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L41:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L21:
        DataSource r14 = (DataSource) r13;
    L22:
        v1 r15 = z2.a.getCreationShareSettings().a();
        if (r15 != null) goto L25;
    L27:
        r4 = false;
    L28:
        if (r4 == false) goto L41;
        ImageAdapter r16 = this.this$0.d;
        if (r16 == null) goto L41;
        List r17 = r16.b;
        if (r17 == null) goto L41;
        n1 r18 = (n1) ListProtector.get(r17, 0);
        if (r18 == null) goto L41;
        String r3 = r18.e;
        if (r3 == null) goto L41;
        this.label = 2;
        if (ImageLoaderKt.A(r3, "creation_share", null, null, null, this, 60) != r0) goto L41;
        return r0;
    L25:
        if (r15.c() != true) goto L27;
    L10:
        ResultKt.throwOnFailure(r13);
        ImageAdapter r19 = this.this$0.d;
        if (r19 == null) goto L22;
        List r110 = r19.b;
        if (r110 == null) goto L22;
        n1 r111 = (n1) ListProtector.get(r110, 0);
        if (r111 == null) goto L22;
        String r5 = r111.d;
        if (r5 == null) goto L22;
        this.label = 1;
        r13 = ImageLoaderKt.A(r5, "creation_share", null, null, null, this, 60);
        if (r13 != r0) goto L21;
        return r0;
    }
}
