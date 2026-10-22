package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.platform.model.album.AlbumSelectionMediaType;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.CreationAlbumPipelinePrewarmer$handleSelectionChanged$1$task$1", f = "CreationAlbumPipelinePrewarmer.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
final class CreationAlbumPipelinePrewarmer$handleSelectionChanged$1$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.bmhome.resource.access.b0>, Object> {
    final /* synthetic */ String $identifier;
    final /* synthetic */ kq9.d $item;
    int label;
    final /* synthetic */ CreationAlbumPipelinePrewarmer this$0;

    public CreationAlbumPipelinePrewarmer$handleSelectionChanged$1$task$1(CreationAlbumPipelinePrewarmer r1, kq9.d r2, String r3, Continuation<? super CreationAlbumPipelinePrewarmer$handleSelectionChanged$1$task$1> r4) {
        this.this$0 = r1;
        this.$item = r2;
        this.$identifier = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationAlbumPipelinePrewarmer$handleSelectionChanged$1$task$1(this.this$0, this.$item, this.$identifier, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.bmhome.resource.access.b0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        com.larus.bmhome.resource.access.z r2 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15 CancellationException -> L25
    L13:
        com.larus.bmhome.resource.access.b0 r11 = (com.larus.bmhome.resource.access.b0) r10;     // Catch: Throwable -> L15 CancellationException -> L25
    L16:
        CreationAlbumPipelinePrewarmer r3 = this.this$0;
        String r4 = this.$identifier;
        AlbumSelectionMediaType r5 = this.$item.b;
        if (r11 == null) goto L19;
        r2 = r11.snapshot();
    L19:
        com.larus.bmhome.resource.access.z r6 = r2;
        if (r11 != null) goto L22;
        String r7 = "failed";
    L23:
        String r8 = r7;
        int r9 = CreationAlbumPipelinePrewarmer.g;
        r3.getClass();
        CreationAlbumPipelinePrewarmer.d(r4, r5, r6, "start", r8, null);
        return r11;
    L22:
        r7 = "success";
        goto L23
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        Function3<kq9.d, String, Continuation<? super com.larus.bmhome.resource.access.b0>, Object> r12 = this.this$0.a;     // Catch: Throwable -> L15 CancellationException -> L25
        kq9.d r13 = this.$item;     // Catch: Throwable -> L15 CancellationException -> L25
        String r14 = this.$identifier;     // Catch: Throwable -> L15 CancellationException -> L25
        this.label = 1;     // Catch: Throwable -> L15 CancellationException -> L25
        r10 = r12.invoke(r13, r14, this);     // Catch: Throwable -> L15 CancellationException -> L25
        if (r10 != r0) goto L13;
        return r0;
    L25:
        e = move-exception;
        throw e;
    L15:
        r11 = null;
        goto L16
    }
}
