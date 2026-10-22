package com.larus.avlink.gallery.migration;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.InvalidLegacyDataException;
import com.larus.avlink.gallery.storage.m;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/gallery/model/MediaMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.migration.AlbumMetadataMigrationHelper$loadMetadataFromKeva$2", f = "AlbumMetadataMigrationHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AlbumMetadataMigrationHelper$loadMetadataFromKeva$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaMetadata>, Object> {
    final /* synthetic */ String $fileId;
    int label;

    public AlbumMetadataMigrationHelper$loadMetadataFromKeva$2(String r1, Continuation<? super AlbumMetadataMigrationHelper$loadMetadataFromKeva$2> r2) {
        this.$fileId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AlbumMetadataMigrationHelper$loadMetadataFromKeva$2(this.$fileId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super MediaMetadata> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r7);
        String r2 = "media_" + this.$fileId;     // Catch: Exception -> L12
        String r3 = ((Keva) AlbumMetadataMigrationHelper.a.getValue()).getString(r2, null);     // Catch: Exception -> L12
        if (r3 == null) goto L20;
        Gson r4 = m.a;     // Catch: InvalidLegacyDataException -> L9 Exception -> L12
        Intrinsics.checkNotNullParameter(r3, "json");     // Catch: InvalidLegacyDataException -> L9 Exception -> L12
    L21:
        return (MediaMetadata) GsonProtectorUtils.fromJson(m.b, r3, MediaMetadata.class);
    L9:
        e = move-exception;
        FLogger.a.w("AlbumMetadataMigrationHelper", "Detected invalid legacy data, deleting: " + e.getFileId() + ", reason: " + e.getMessage());     // Catch: Exception -> L12
        ((Keva) AlbumMetadataMigrationHelper.a.getValue()).erase(r2);     // Catch: Exception -> L12
        return null;
    L20:
        return null;
    L12:
        e = move-exception;
        FLogger.a.e("AlbumMetadataMigrationHelper", "Error reading metadata from Keva: " + e.getMessage(), e);
        return null;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
