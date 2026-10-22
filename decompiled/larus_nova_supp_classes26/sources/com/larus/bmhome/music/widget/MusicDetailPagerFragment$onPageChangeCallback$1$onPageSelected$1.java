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
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicDetailPagerFragment$onPageChangeCallback$1$onPageSelected$1", f = "MusicDetailPagerFragment.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class MusicDetailPagerFragment$onPageChangeCallback$1$onPageSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ MusicDetailPagerFragment this$0;

    public MusicDetailPagerFragment$onPageChangeCallback$1$onPageSelected$1(MusicDetailPagerFragment r1, int r2, Continuation<? super MusicDetailPagerFragment$onPageChangeCallback$1$onPageSelected$1> r3) {
        this.this$0 = r1;
        this.$position = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicDetailPagerFragment$onPageChangeCallback$1$onPageSelected$1(this.this$0, this.$position, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MusicDetailPagerFragment.MusicDetailPagerAdapter r8 = this.this$0.j;
        if (r8 == null) goto L22;
        MusicCreationContent r9 = r8.z2(this.$position);
        if (r9 == null) goto L22;
        int r2 = this.$position;
        MusicDetailPagerFragment r3 = this.this$0;
        MutableSharedFlow r4 = r9.getPlayList().b();
        int r5 = r3.k;
        if (r2 <= r5) goto L15;
        int r6 = 1;
    L18:
        ad9.b.b r10 = new ad9.b.b(r6, r9);
        this.label = 1;
        if (r4.emit(r10, this) != r0) goto L22;
        return r0;
    L15:
        if (r2 >= r5) goto L17;
        r6 = -1;
        goto L18
    L17:
        r6 = 0;
        goto L18
    }
}
