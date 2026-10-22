package com.larus.avlink.gallery.migration;

import com.bytedance.keva.Keva;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/avlink/gallery/model/MediaMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.migration.AlbumMetadataMigrationHelper$loadAllFromKeva$2", f = "AlbumMetadataMigrationHelper.kt", i = {0}, l = {83}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class AlbumMetadataMigrationHelper$loadAllFromKeva$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MediaMetadata>>, Object> {
    Object L$0;
    Object L$1;
    int label;

    public AlbumMetadataMigrationHelper$loadAllFromKeva$2(Continuation<? super AlbumMetadataMigrationHelper$loadAllFromKeva$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AlbumMetadataMigrationHelper$loadAllFromKeva$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<MediaMetadata>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007f -> B:24:0x0085). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L11;
        Iterator r0 = (Iterator) this.L$1;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L8
        List r4 = r3;
        Object r5 = r1;
        Iterator r6 = r0;
        AlbumMetadataMigrationHelper$loadAllFromKeva$2 r7 = this;
    L24:
        MediaMetadata r11 = (MediaMetadata) r10;     // Catch: Exception -> L8
        if (r11 == null) goto L27;
        r4.add(r11);     // Catch: Exception -> L8
    L27:
        AlbumMetadataMigrationHelper$loadAllFromKeva$2 r12 = r7;
        Iterator r8 = r6;
        r1 = r5;
        List r9 = r4;
    L19:
        if (r8.hasNext() == false) goto L28;
        String r13 = (String) r8.next();     // Catch: Exception -> L8
        Lazy r14 = AlbumMetadataMigrationHelper.a;     // Catch: Exception -> L8
        r12.L$0 = r9;     // Catch: Exception -> L8
        r12.L$1 = r8;     // Catch: Exception -> L8
        r12.label = 1;     // Catch: Exception -> L8
        Object r15 = BuildersKt.withContext(Dispatchers.getIO(), new AlbumMetadataMigrationHelper$loadMetadataFromKeva$2(r13, null), r12);     // Catch: Exception -> L8
        if (r15 != r1) goto L23;
        return r1;
    L23:
        Iterator r16 = r8;
        r7 = r12;
        r10 = r15;
        r4 = r9;
        r5 = r1;
        r6 = r16;
        goto L24
    L28:
        return r9;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        String r17 = ((Keva) AlbumMetadataMigrationHelper.a.getValue()).getString("media_index_all", "[]");     // Catch: Exception -> L8
        if (Intrinsics.areEqual(r17, "[]") == false) goto L16;
        List r18 = CollectionsKt.emptyList();     // Catch: Exception -> L8
    L17:
        r9 = new ArrayList();     // Catch: Exception -> L8
        r8 = r18.iterator();     // Catch: Exception -> L8
        r12 = this;
        goto L19
    L16:
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L8
        r18 = AlbumMetadataMigrationHelper.a(r17);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        FLogger.a.e("AlbumMetadataMigrationHelper", "Error loading all metadata from Keva: " + e.getMessage(), e);
        return CollectionsKt.emptyList();
    }
}
