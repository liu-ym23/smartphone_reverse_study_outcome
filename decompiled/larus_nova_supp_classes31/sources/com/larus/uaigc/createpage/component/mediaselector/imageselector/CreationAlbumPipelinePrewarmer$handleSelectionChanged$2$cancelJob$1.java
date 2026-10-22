package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.CreationAlbumPipelinePrewarmer$handleSelectionChanged$2$cancelJob$1", f = "CreationAlbumPipelinePrewarmer.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, s = {})
final class CreationAlbumPipelinePrewarmer$handleSelectionChanged$2$cancelJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationAlbumPipelinePrewarmer.b $entry;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $uriKey;
    int label;
    final /* synthetic */ CreationAlbumPipelinePrewarmer this$0;

    public CreationAlbumPipelinePrewarmer$handleSelectionChanged$2$cancelJob$1(CreationAlbumPipelinePrewarmer r1, String r2, String r3, CreationAlbumPipelinePrewarmer.b r4, Continuation<? super CreationAlbumPipelinePrewarmer$handleSelectionChanged$2$cancelJob$1> r5) {
        this.this$0 = r1;
        this.$sessionId = r2;
        this.$uriKey = r3;
        this.$entry = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationAlbumPipelinePrewarmer$handleSelectionChanged$2$cancelJob$1(this.this$0, this.$sessionId, this.$uriKey, this.$entry, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        CreationAlbumPipelinePrewarmer r8 = this.this$0;
        String r3 = this.$sessionId;
        String r4 = this.$uriKey;
        CreationAlbumPipelinePrewarmer.b r5 = this.$entry;
        Object r6 = r8.c;
        monitor-enter(r6);
    L30:
        th = move-exception;
        throw th;
    L14:
        if (Intrinsics.areEqual(r8.d, r3) == true) goto L16;
    L24:
        r2 = false;
    L25:
        monitor-exit(r6);
        if (r2 == false) goto L29;
        r8.b(CollectionsKt.listOf(r5), ResourceCancelReason.USER_CANCEL);
    L29:
        return Unit.INSTANCE;
    L16:
        if (((LinkedHashMap) r8.e).get(r4) != r5) goto L24;
        if (r5.d == true) goto L24;
        if (r5.e != CreationAlbumPipelinePrewarmer.TaskOwner.ALBUM_SELECTION) goto L24;
        r8.e.remove(r4);     // Catch: Throwable -> L30
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(10000, this) != r0) goto L11;
        return r0;
    }
}
