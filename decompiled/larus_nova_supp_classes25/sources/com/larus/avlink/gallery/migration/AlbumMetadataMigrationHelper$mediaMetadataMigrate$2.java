package com.larus.avlink.gallery.migration;

import com.bytedance.keva.Keva;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.migration.AlbumMetadataMigrationHelper$mediaMetadataMigrate$2", f = "AlbumMetadataMigrationHelper.kt", i = {0, 1, 3}, l = {MessageCellStateTransformerType.SUMMARY_CARD, MessageCellStateTransformerType.BLOCK, MessageCellStateTransformerType.WELCOME_BACK_CELL, MessageCellStateTransformerType.SPACER}, m = "invokeSuspend", n = {"startTime", "metadataList", "newMetadataList"}, s = {"J$0", "L$0", "L$0"})
public final class AlbumMetadataMigrationHelper$mediaMetadataMigrate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    int label;

    public AlbumMetadataMigrationHelper$mediaMetadataMigrate$2(Continuation<? super AlbumMetadataMigrationHelper$mediaMetadataMigrate$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AlbumMetadataMigrationHelper$mediaMetadataMigrate$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L13;
        if (r2 != 4) goto L12;
        List<MediaMetadata> r1 = (List) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Exception -> L51
    L41:
        FLogger.a.i("AlbumMetadataMigrationHelper", "Migrated " + r1.size() + " media metadata to database");     // Catch: Exception -> L51
    L43:
        ((Keva) AlbumMetadataMigrationHelper.a.getValue()).clear();     // Catch: Exception -> L51
        ((Keva) AlbumMetadataMigrationHelper.b.getValue()).clear();     // Catch: Exception -> L51
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L51
        String r3 = AccountService.a.getUserId();     // Catch: Exception -> L51
        if (r3.length() != 0) goto L46;
        boolean r4 = true;
    L47:
        if (r4 == false) goto L49;
        r3 = "default";
    L49:
        ((Keva) GalleryStoragePolicyManager.c.getValue()).storeBoolean("dora_gallery_storage_database_migrated_".concat(r3), true);     // Catch: Exception -> L51
    L54:
        return Unit.INSTANCE;
    L46:
        r4 = false;
        goto L47
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r23);     // Catch: Exception -> L51
        Object r5 = r23;
    L35:
        List<MediaMetadata> r6 = (List) r5;     // Catch: Exception -> L51
        if ((!r6.isEmpty()) == false) goto L42;
        AlbumDataBaseHelper r7 = AlbumDataBaseHelper.a;     // Catch: Exception -> L51
        this.L$0 = r6;     // Catch: Exception -> L51
        this.label = 4;     // Catch: Exception -> L51
        if (r7.i(r6, this) != r0) goto L40;
        return r0;
    L40:
        r1 = r6;
        goto L41
    L42:
        FLogger.a.i("AlbumMetadataMigrationHelper", "mediaMetadataMigrate: empty newMetadataList, skip");     // Catch: Exception -> L51
        goto L43
    L15:
        List<MediaMetadata> r8 = (List) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Exception -> L51
    L31:
        FLogger.a.i("AlbumMetadataMigrationHelper", "Migrated " + r8.size() + " media metadata to database");     // Catch: Exception -> L51
        goto L43
    L18:
        long r11 = this.J$0;
        ResultKt.throwOnFailure(r23);     // Catch: Exception -> L51
        Object r9 = r23;
    L25:
        List<MediaMetadata> r10 = (List) r9;     // Catch: Exception -> L51
        AlbumDataBaseHelper r13 = AlbumDataBaseHelper.a;     // Catch: Exception -> L51
        int r16 = r10.size();     // Catch: Exception -> L51
        long r17 = System.currentTimeMillis() - r11;     // Catch: Exception -> L51
        r13.getClass();     // Catch: Exception -> L51
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L51
        AlbumDataBaseHelper.l("batch_load", "album", r16, r17, 1, GalleryStoragePolicyManager.m() ? 1 : 0, "");     // Catch: Exception -> L51
        if ((!r10.isEmpty()) == false) goto L32;
        this.L$0 = r10;     // Catch: Exception -> L51
        this.label = 2;     // Catch: Exception -> L51
        if (r13.i(r10, this) != r0) goto L30;
        return r0;
    L30:
        r8 = r10;
        goto L31
    L32:
        FLogger.a.i("AlbumMetadataMigrationHelper", "mediaMetadataMigrate: empty metadataList, check once again");     // Catch: Exception -> L51
        Lazy r12 = AlbumMetadataMigrationHelper.a;     // Catch: Exception -> L51
        this.label = 3;     // Catch: Exception -> L51
        r5 = BuildersKt.withContext(Dispatchers.getIO(), new AlbumMetadataMigrationHelper$loadAllFromKeva$2(null), this);     // Catch: Exception -> L51
        if (r5 != r0) goto L35;
        return r0;
    L21:
        ResultKt.throwOnFailure(r23);
        r11 = System.currentTimeMillis();     // Catch: Exception -> L51
        Lazy r14 = AlbumMetadataMigrationHelper.a;     // Catch: Exception -> L51
        this.J$0 = r11;     // Catch: Exception -> L51
        this.label = 1;     // Catch: Exception -> L51
        r9 = BuildersKt.withContext(Dispatchers.getIO(), new AlbumMetadataMigrationHelper$loadAllFromKeva$2(null), this);     // Catch: Exception -> L51
        if (r9 != r0) goto L25;
        return r0;
    L51:
        e = move-exception;
        FLogger.a.e("AlbumMetadataMigrationHelper", "Error migrating media metadata: " + e.getMessage(), e);
        goto L54
    }
}
