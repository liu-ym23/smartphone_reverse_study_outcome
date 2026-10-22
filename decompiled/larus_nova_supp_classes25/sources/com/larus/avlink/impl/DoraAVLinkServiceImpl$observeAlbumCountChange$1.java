package com.larus.avlink.impl;

import com.larus.avlink.gallery.thumbnail.ThumbnailManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import w88.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/larus/avlink/api/DoraOAlbumCount;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.impl.DoraAVLinkServiceImpl$observeAlbumCountChange$1", f = "DoraAVLinkServiceImpl.kt", i = {}, l = {1077}, m = "invokeSuspend", n = {}, s = {})
public final class DoraAVLinkServiceImpl$observeAlbumCountChange$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super e>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements com.larus.avlink.gallery.thumbnail.a {
        public final /* synthetic */ kotlinx.coroutines.channels.k<e> a;

        public a(kotlinx.coroutines.channels.k<? super e> r1) {
            this.a = r1;
        }

        @Override // com.larus.avlink.gallery.thumbnail.a
        public final void a(int r3, int r4) {
            this.a.trySend-JP2dKIU(new e(r3, r4));
        }
    }

    public DoraAVLinkServiceImpl$observeAlbumCountChange$1(Continuation<? super DoraAVLinkServiceImpl$observeAlbumCountChange$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraAVLinkServiceImpl$observeAlbumCountChange$1 r0 = new DoraAVLinkServiceImpl$observeAlbumCountChange$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<? super e> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) this.L$0;
        final a r2 = new a(r6);
        ThumbnailManager r3 = ThumbnailManager.a;
        ThumbnailManager.g(r2);
        Function0 r4 = new i(r2);
        this.label = 1;
        if (ProduceKt.a(r6, r4, this) != r0) goto L12;
        return r0;
    }
}
