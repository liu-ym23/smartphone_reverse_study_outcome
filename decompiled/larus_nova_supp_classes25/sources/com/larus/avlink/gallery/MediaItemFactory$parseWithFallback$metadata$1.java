package com.larus.avlink.gallery;

import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/gallery/model/MediaMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.MediaItemFactory$parseWithFallback$metadata$1", f = "MediaItemFactory.kt", i = {}, l = {DoraCallStateCode.DOUBAO_FOCUS_CHANGED}, m = "invokeSuspend", n = {}, s = {})
final class MediaItemFactory$parseWithFallback$metadata$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaMetadata>, Object> {
    final /* synthetic */ File $file;
    int label;

    public MediaItemFactory$parseWithFallback$metadata$1(File r1, Continuation<? super MediaItemFactory$parseWithFallback$metadata$1> r2) {
        this.$file = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaItemFactory$parseWithFallback$metadata$1(this.$file, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super MediaMetadata> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        AlbumDataBaseHelper r5 = AlbumDataBaseHelper.a;
        String r2 = this.$file.getAbsolutePath();
        this.label = 1;
        r4 = r5.p(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
