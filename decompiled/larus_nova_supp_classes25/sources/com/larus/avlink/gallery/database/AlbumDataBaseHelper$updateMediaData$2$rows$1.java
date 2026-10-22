package com.larus.avlink.gallery.database;

import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.database.AlbumDataBaseHelper$updateMediaData$2$rows$1", f = "AlbumDataBaseHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlbumDataBaseHelper$updateMediaData$2$rows$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ MediaMetadata $mediaMetadata;
    int label;

    public AlbumDataBaseHelper$updateMediaData$2$rows$1(MediaMetadata r1, Continuation<? super AlbumDataBaseHelper$updateMediaData$2$rows$1> r2) {
        this.$mediaMetadata = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AlbumDataBaseHelper$updateMediaData$2$rows$1(this.$mediaMetadata, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        b r4 = AlbumDatabase.a.a().c();
        AlbumDataBaseHelper r0 = AlbumDataBaseHelper.a;
        MediaMetadata r1 = this.$mediaMetadata;
        r0.getClass();
        return Boxing.boxInt(r4.a(AlbumDataBaseHelper.k(r1)));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
