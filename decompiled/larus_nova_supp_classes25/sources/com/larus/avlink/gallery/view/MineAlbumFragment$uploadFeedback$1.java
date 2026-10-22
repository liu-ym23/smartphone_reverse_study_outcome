package com.larus.avlink.gallery.view;

import android.content.Context;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$uploadFeedback$1", f = "MineAlbumFragment.kt", i = {0, 0}, l = {345, 352}, m = "invokeSuspend", n = {"destination$iv$iv", "filePath"}, s = {"L$0", "L$2"})
final class MineAlbumFragment$uploadFeedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $selectedPaths;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MineAlbumFragment this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MineAlbumFragment$uploadFeedback$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$uploadFeedback$1$1", f = "MineAlbumFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $list;
        int label;
        final /* synthetic */ MineAlbumFragment this$0;

        public AnonymousClass1(MineAlbumFragment r1, List<String> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$list = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$list, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.gallery.view.s1] */
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r5);
            IDoraAVLinkService r6 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
            if (r6 == null) goto L8;
            Context r0 = this.this$0.getContext();
            List<String> r1 = this.$list;
            final MineAlbumFragment r2 = this.this$0;
            r6.V0(r0, r1, new s1(r2));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MineAlbumFragment$uploadFeedback$1(List<String> r1, MineAlbumFragment r2, Continuation<? super MineAlbumFragment$uploadFeedback$1> r3) {
        this.$selectedPaths = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MineAlbumFragment$uploadFeedback$1(this.$selectedPaths, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:43:0x006f). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L40:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$2;
        Iterator r5 = (Iterator) this.L$1;
        Collection r6 = (Collection) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L12
        Collection r7 = r6;
        Iterator r8 = r5;
        String r9 = r2;
        Object r3 = r0;
        MineAlbumFragment$uploadFeedback$1 r4 = this;
    L43:
        MediaMetadata r14 = (MediaMetadata) r13;     // Catch: Exception -> L26
        if (r14 == null) goto L31;
        String r15 = r14.getUniqId();     // Catch: Exception -> L26
    L32:
        Iterator r10 = r8;
        Collection r11 = r7;
        if (r15 == null) goto L35;
        r11.add(r15);
    L35:
        MineAlbumFragment$uploadFeedback$1 r16 = r4;
        r0 = r3;
    L16:
        if (r10.hasNext() == false) goto L36;
        String r12 = (String) r10.next();
        AlbumDataBaseHelper r17 = AlbumDataBaseHelper.a;     // Catch: Exception -> L28
        r16.L$0 = r11;     // Catch: Exception -> L28
        r16.L$1 = r10;     // Catch: Exception -> L28
        r16.L$2 = r12;     // Catch: Exception -> L28
        r16.label = 1;     // Catch: Exception -> L28
        Object r18 = r17.p(r12, r16);     // Catch: Exception -> L28
        if (r18 != r0) goto L21;
        return r0;
    L21:
        Object r19 = r0;
        r4 = r16;
        r13 = r18;
        r7 = r11;
        r8 = r10;
        r9 = r12;
        r3 = r19;
    L28:
        e = move-exception;
        Object r110 = r0;
        r4 = r16;
        Exception e = e;
        r7 = r11;
        r8 = r10;
        r9 = r12;
        r3 = r110;
    L30:
        FLogger.a.e("MineAlbumFragment", "Error querying uniqId for " + r9 + ": " + e.getMessage(), e);
    L31:
        r15 = null;
        goto L32
    L36:
        MainCoroutineDispatcher r20 = Dispatchers.getMain();
        AnonymousClass1 r21 = new AnonymousClass1(r16.this$0, (List) r11, null);
        r16.L$0 = null;
        r16.L$1 = null;
        r16.L$2 = null;
        r16.label = 2;
        if (BuildersKt.withContext(r20, r21, r16) != r0) goto L40;
        return r0;
    L47:
        r15 = null;
    L26:
        e = e;
    L12:
        e = e;
        r7 = r6;
        r8 = r5;
        r9 = r2;
        r3 = r0;
        r4 = this;
        goto L30
    L14:
        ResultKt.throwOnFailure(r13);
        List<String> r111 = this.$selectedPaths;
        ArrayList r22 = new ArrayList();
        r10 = r111.iterator();
        r11 = r22;
        r16 = this;
        goto L16
    }
}
