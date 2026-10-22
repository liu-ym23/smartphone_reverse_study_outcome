package com.larus.bmhome.music.widget;

import android.content.Context;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$loadCoverImage$3", f = "LyricsToSongCardView.kt", i = {}, l = {1033}, m = "invokeSuspend", n = {}, s = {})
final class LyricsToSongCardView$loadCoverImage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MusicCreationContent $musicCreationContent;
    int label;
    final /* synthetic */ LyricsToSongCardView this$0;

    public LyricsToSongCardView$loadCoverImage$3(MusicCreationContent r1, LyricsToSongCardView r2, Continuation<? super LyricsToSongCardView$loadCoverImage$3> r3) {
        this.$musicCreationContent = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LyricsToSongCardView$loadCoverImage$3(this.$musicCreationContent, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Image r12 = this.$musicCreationContent.getCover();
        if (r12 == null) goto L27;
        ImageObj r13 = r12.imageOri;
        if (r13 == null) goto L27;
        String r14 = r13.url;
        if (r14 == null) goto L27;
        FLogger.a.i("LyricsToSong", "[loadCoverImage] prefetchToBitmapCache url:".concat(r14));
        Image r15 = this.$musicCreationContent.getCover();
        if (r15 == null) goto L20;
        ImageObj r16 = r15.imageOri;
        if (r16 == null) goto L20;
        String r17 = r16.url;
    L21:
        String r3 = r17;
        Context r5 = this.this$0.getContext();
        this.label = 1;
        if (ImageLoaderKt.A(r3, "chat.music", r5, null, null, this, 56) != r0) goto L25;
        return r0;
    L20:
        r17 = null;
    L27:
        return Unit.INSTANCE;
    }
}
