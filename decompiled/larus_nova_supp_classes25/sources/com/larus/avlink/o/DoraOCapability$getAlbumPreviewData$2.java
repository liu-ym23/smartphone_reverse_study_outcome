package com.larus.avlink.o;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.e;
import com.larus.avlink.gallery.executor.MediaSyncExecutor;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;
import w88.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/api/DoraOAlbumPreviewData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.o.DoraOCapability$getAlbumPreviewData$2", f = "DoraOCapability.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
final class DoraOCapability$getAlbumPreviewData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    final /* synthetic */ int $limit;
    int label;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((MediaMetadata) r4).getCreateTime()), Long.valueOf(((MediaMetadata) r3).getCreateTime()));
        }
    }

    public DoraOCapability$getAlbumPreviewData$2(int r1, Continuation<? super DoraOCapability$getAlbumPreviewData$2> r2) {
        this.$limit = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraOCapability$getAlbumPreviewData$2(this.$limit, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        List r10 = (List) r9;
        FLogger.a.i("DoraOCapability", "getAlbumPreviewData: metadata count=" + r10.size());
        ArrayList r2 = new ArrayList();
        Iterator r3 = r10.iterator();
    L12:
        int r4 = 0;
        if (r3.hasNext() == false) goto L24;
        Object r5 = r3.next();
        MediaMetadata r6 = (MediaMetadata) r5;
        int r7 = d.a;
        if (r6.getLifecycleState() != MediaLifecycleState.COMPLETED) goto L22;
        String r8 = r6.getFinalFilePath();
        if (r8 != null) goto L20;
        r4 = 1;
        goto L22
    L20:
        r4 = !new PolarisFileWrapper(r8).exists() ? 1 : 0;
    L22:
        if ((r4 ^ 1) == 0) goto L12;
        r2.add(r5);
        goto L12
    L24:
        Pair r11 = null;
        if (r2.size() == r10.size()) goto L27;
        MediaSyncExecutor r12 = MediaSyncExecutor.a;
        MediaSyncExecutor.c(null);
    L27:
        List r13 = SequencesKt.toList(SequencesKt.take(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.sortedWith(r2, new a())), new com.larus.avlink.o.a()), this.$limit));
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r14 == null) goto L32;
        VisionService r15 = r14.V();
        if (r15 == null) goto L32;
        r11 = r15.l();
    L32:
        int r16 = r2.size();
        if (r11 == null) goto L35;
        int r17 = ((Number) r11.getFirst()).intValue();
    L36:
        if (r11 == null) goto L39;
        r4 = ((Number) r11.getSecond()).intValue();
    L39:
        return new g(r13, r16, r17, r4);
    L35:
        r17 = 0;
        goto L36
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        e.a.getClass();
        e.a();
        AlbumDataBaseHelper r18 = AlbumDataBaseHelper.a;
        this.label = 1;
        r9 = r18.m(this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
