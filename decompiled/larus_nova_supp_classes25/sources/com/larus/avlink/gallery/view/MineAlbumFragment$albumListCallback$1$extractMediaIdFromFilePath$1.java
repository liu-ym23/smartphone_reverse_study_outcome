package com.larus.avlink.gallery.view;

import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$albumListCallback$1$extractMediaIdFromFilePath$1", f = "MineAlbumFragment.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
final class MineAlbumFragment$albumListCallback$1$extractMediaIdFromFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $filePath;
    int label;

    public MineAlbumFragment$albumListCallback$1$extractMediaIdFromFilePath$1(String r1, Continuation<? super MineAlbumFragment$albumListCallback$1$extractMediaIdFromFilePath$1> r2) {
        this.$filePath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MineAlbumFragment$albumListCallback$1$extractMediaIdFromFilePath$1(this.$filePath, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Exception -> L24
    L13:
        MediaMetadata r6 = (MediaMetadata) r5;     // Catch: Exception -> L24
        if (r6 == null) goto L21;
        Long r2 = r6.getSystemGalleryId();     // Catch: Exception -> L24
        if (r2 == null) goto L21;
        String r3 = r2.toString();     // Catch: Exception -> L24
        if (r3 == null) goto L21;
        return r3;
    L21:
        if (r6 == null) goto L31;
        return r6.getUniqId();
    L31:
        return null;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        AlbumDataBaseHelper r7 = AlbumDataBaseHelper.a;     // Catch: Exception -> L24
        String r4 = this.$filePath;     // Catch: Exception -> L24
        this.label = 1;     // Catch: Exception -> L24
        r5 = r7.p(r4, this);     // Catch: Exception -> L24
        if (r5 != r0) goto L13;
        return r0;
    L24:
        com.larus.avlink.gallery.i.a r8 = com.larus.avlink.gallery.i.c(StringsKt.substringAfterLast$default(this.$filePath, "/", null, 2, null));
        if (r8 != null) goto L27;
        return null;
    L27:
        return Boxing.boxLong(r8.a).toString();
    }
}
