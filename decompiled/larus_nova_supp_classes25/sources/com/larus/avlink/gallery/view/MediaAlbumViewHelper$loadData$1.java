package com.larus.avlink.gallery.view;

import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.image.loader.ImageLoaderKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$loadData$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {544, 568}, m = "invokeSuspend", n = {}, s = {})
public final class MediaAlbumViewHelper$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MediaAlbumViewHelper this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MediaAlbumViewHelper$loadData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$loadData$1$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Pair<Integer, Integer> $diffResult;
        final /* synthetic */ List<com.larus.bmhome.bigimg.t1> $mediaItems;
        final /* synthetic */ int $totalCount;
        int label;
        final /* synthetic */ MediaAlbumViewHelper this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(MediaAlbumViewHelper r1, List<? extends com.larus.bmhome.bigimg.t1> r2, int r3, Pair<Integer, Integer> r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$mediaItems = r2;
            this.$totalCount = r3;
            this.$diffResult = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$mediaItems, this.$totalCount, this.$diffResult, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L34;
            ResultKt.throwOnFailure(r19);
            final MediaAlbumViewHelper r1 = this.this$0;
            final List<com.larus.bmhome.bigimg.t1> r2 = this.$mediaItems;
            Pair<Integer, Integer> r3 = this.$diffResult;
            int r4 = 0;
            if (r3 == null) goto L7;
            int r5 = ((Number) r3.getFirst()).intValue();
        L8:
            Pair<Integer, Integer> r6 = this.$diffResult;
            if (r6 == null) goto L11;
            int r7 = ((Number) r6.getSecond()).intValue();
        L12:
            r1.h = r2;
            r1.h(r5, r7);
            if (r2.isEmpty() == false) goto L16;
            r1.c.p.setVisibility(8);
            r1.c.j.setVisibility(0);
        L31:
            r1.i(r5, r7);
            return Unit.INSTANCE;
        L16:
            r1.c.p.setVisibility(0);
            r1.c.j.setVisibility(8);
            Iterator r8 = ((List) r1.d.getValue()).iterator();
            final int r9 = 0;
        L18:
            if (r8.hasNext() == false) goto L31;
            Object r10 = r8.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L22;
            CollectionsKt.throwIndexOverflow();
        L22:
            final GenericDraweeView r12 = (ImageViewWithLastMotion) r10;
            TextView r13 = (TextView) ListProtector.get((List) r1.e.getValue(), r9);
            if (r9 >= r2.size()) goto L29;
            yt8.p r14 = (com.larus.bmhome.bigimg.t1) ListProtector.get(r2, r9);
            r12.setVisibility(r4);
            if ((r14 instanceof yt8.p) == false) goto L27;
            r13.setVisibility(r4);
            int r15 = AlbumUtils.a;
            r13.setText(AlbumUtils.d((long) (r14.k / ((double) 1000))));
        L28:
            ImageLoaderKt.x(r12, UriProtector.parse("file://" + r14.getPath()), "dora_device_management_album", null, new d0(r12), 4);
            r12.setOnClickListener(new e0(r1, r2, r9));
        L30:
            r9 = r11;
            r7 = r7;
            r4 = 0;
            goto L18
        L27:
            r13.setVisibility(8);
            goto L28
        L29:
            r7 = r7;
            r12.setVisibility(4);
            r12.setOnClickListener(null);
            r13.setVisibility(8);
            goto L30
        L11:
            r7 = 0;
            goto L12
        L7:
            r5 = 0;
            goto L8
        L34:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((MediaMetadata) r4).getCreateTime()), Long.valueOf(((MediaMetadata) r3).getCreateTime()));
        }
    }

    public MediaAlbumViewHelper$loadData$1(MediaAlbumViewHelper r1, Continuation<? super MediaAlbumViewHelper$loadData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaAlbumViewHelper$loadData$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L25
    L28:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L25
    L16:
        List r13 = (List) r12;     // Catch: Exception -> L25
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "Total metadata count: " + r13.size());     // Catch: Exception -> L25
        int r8 = r13.size();     // Catch: Exception -> L25
        List r7 = SequencesKt.toList(SequencesKt.take(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.sortedWith(r13, new a())), new j0()), 5));     // Catch: Exception -> L25
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L25
        if (r14 == null) goto L21;
        VisionService r15 = r14.V();     // Catch: Exception -> L25
        if (r15 == null) goto L21;
        Pair r16 = r15.l();     // Catch: Exception -> L25
    L22:
        Pair r9 = r16;
        MainCoroutineDispatcher r17 = Dispatchers.getMain();     // Catch: Exception -> L25
        AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r7, r8, r9, null);     // Catch: Exception -> L25
        this.label = 2;     // Catch: Exception -> L25
        if (BuildersKt.withContext(r17, r0, this) != r1) goto L28;
        return r1;
    L21:
        r16 = null;
        goto L22
    L12:
        ResultKt.throwOnFailure(r12);
        com.larus.avlink.gallery.e.a.getClass();     // Catch: Exception -> L25
        com.larus.avlink.gallery.e.a();     // Catch: Exception -> L25
        AlbumDataBaseHelper r18 = AlbumDataBaseHelper.a;     // Catch: Exception -> L25
        this.label = 1;     // Catch: Exception -> L25
        r12 = r18.m(this);     // Catch: Exception -> L25
        if (r12 != r1) goto L16;
        return r1;
    L25:
        e = move-exception;
        com.larus.avlink.n1.c("MediaAlbumViewHelper", "Error loading data", e);
        e.printStackTrace();
        goto L28
    }
}
