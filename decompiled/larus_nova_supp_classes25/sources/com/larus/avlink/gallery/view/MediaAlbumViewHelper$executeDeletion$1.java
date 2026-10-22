package com.larus.avlink.gallery.view;

import android.content.Context;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$executeDeletion$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {727}, m = "invokeSuspend", n = {}, s = {})
final class MediaAlbumViewHelper$executeDeletion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $confirmCallback;
    final /* synthetic */ boolean $deleteFromAlbum;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ MediaAlbumViewHelper this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MediaAlbumViewHelper$executeDeletion$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$executeDeletion$1$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $confirmCallback;
        int label;
        final /* synthetic */ MediaAlbumViewHelper this$0;

        public AnonymousClass1(Function0<Unit> r1, MediaAlbumViewHelper r2, Continuation<? super AnonymousClass1> r3) {
            this.$confirmCallback = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$confirmCallback, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.$confirmCallback.invoke();
            MediaAlbumViewHelper r4 = this.this$0;
            int r0 = MediaAlbumViewHelper.r;
            r4.c();
            t19.s r5 = t19.s.a;
            Context r1 = this.this$0.a;
            String r2 = r1.getString(2131899737);
            r5.getClass();
            t19.s.p(r1, r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MediaAlbumViewHelper$executeDeletion$1(String r1, boolean r2, Function0<Unit> r3, MediaAlbumViewHelper r4, Continuation<? super MediaAlbumViewHelper$executeDeletion$1> r5) {
        this.$path = r1;
        this.$deleteFromAlbum = r2;
        this.$confirmCallback = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MediaAlbumViewHelper$executeDeletion$1(this.$path, this.$deleteFromAlbum, this.$confirmCallback, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L13
    L17:
    L16:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        String r8 = StringsKt.removePrefix(this.$path, "file://");     // Catch: Exception -> L13
        int r2 = AlbumUtils.a;     // Catch: Exception -> L13
        AlbumUtils.b(CollectionsKt.listOf(r8), this.$deleteFromAlbum);     // Catch: Exception -> L13
        MainCoroutineDispatcher r9 = Dispatchers.getMain();     // Catch: Exception -> L13
        AnonymousClass1 r3 = new AnonymousClass1(this.$confirmCallback, this.this$0, null);     // Catch: Exception -> L13
        this.label = 1;     // Catch: Exception -> L13
        if (BuildersKt.withContext(r9, r3, this) != r0) goto L17;
        return r0;
    L13:
        e = move-exception;
        com.larus.avlink.n1.c("MediaAlbumViewHelper", "Delete failed", e);
        goto L16
    }
}
