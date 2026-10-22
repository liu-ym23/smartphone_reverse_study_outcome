package com.larus.bmhome.music.widget;

import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$shuffleAction$1", f = "MusicPlayerDetailFragment.kt", i = {}, l = {754}, m = "invokeSuspend", n = {}, s = {})
public final class MusicPlayerDetailFragment$shuffleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.music.player.j $newMusicState;
    final /* synthetic */ boolean $next;
    final /* synthetic */ MusicCreationContent $nextState;
    final /* synthetic */ boolean $previous;
    int label;

    public MusicPlayerDetailFragment$shuffleAction$1(com.larus.bmhome.music.player.j r1, boolean r2, boolean r3, MusicCreationContent r4, Continuation<? super MusicPlayerDetailFragment$shuffleAction$1> r5) {
        this.$newMusicState = r1;
        this.$next = r2;
        this.$previous = r3;
        this.$nextState = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MusicPlayerDetailFragment$shuffleAction$1(this.$newMusicState, this.$next, this.$previous, this.$nextState, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ad9.b r7 = this.$newMusicState.g;
        if (r7 == null) goto L23;
        MutableSharedFlow r8 = r7.b();
        if (r8 == null) goto L23;
        if (this.$next == false) goto L16;
        int r3 = 1;
    L19:
        ad9.b.b r2 = new ad9.b.b(r3, this.$nextState);
        this.label = 1;
        if (r8.emit(r2, this) != r0) goto L23;
        return r0;
    L16:
        if (this.$previous == false) goto L18;
        r3 = -1;
        goto L19
    L18:
        r3 = 0;
        goto L19
    }
}
