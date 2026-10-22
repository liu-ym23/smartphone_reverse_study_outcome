package com.larus.bmhome.music.edit;

import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Image;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicInfoEditHelper$editCover$2", f = "MusicInfoEditHelper.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
final class MusicInfoEditHelper$editCover$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ Image $image;
    final /* synthetic */ Fragment $this_editCover;
    int label;

    public MusicInfoEditHelper$editCover$2(Fragment r1, Image r2, a r3, Continuation<? super MusicInfoEditHelper$editCover$2> r4) {
        this.$this_editCover = r1;
        this.$image = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MusicInfoEditHelper$editCover$2(this.$this_editCover, this.$image, this.$callback, r5);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MusicInfoEditHelper r7 = MusicInfoEditHelper.a;
        Fragment r2 = this.$this_editCover;
        Image r3 = this.$image;
        a r4 = this.$callback;
        this.label = 1;
        if (MusicInfoEditHelper.a(r7, r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
