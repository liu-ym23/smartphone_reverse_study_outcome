package com.larus.bmhome.chat.markdown.code;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1", f = "ClickableMarkdownCodeView.kt", i = {}, l = {1219}, m = "invokeSuspend", n = {}, s = {})
final class ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClickableMarkdownCodeView this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1$1", f = "ClickableMarkdownCodeView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $ok;
        final /* synthetic */ String $saveDir;
        final /* synthetic */ String $savePath;
        int label;
        final /* synthetic */ ClickableMarkdownCodeView this$0;

        public AnonymousClass1(boolean r1, String r2, String r3, ClickableMarkdownCodeView r4, Continuation<? super AnonymousClass1> r5) {
            this.$ok = r1;
            this.$saveDir = r2;
            this.$savePath = r3;
            this.this$0 = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$ok, this.$saveDir, this.$savePath, this.this$0, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r4);
            if (this.$ok == true) goto L7;
        L9:
            t19.s r5 = t19.s.a;
            Context r1 = this.this$0.getContext();
            r5.getClass();
            t19.s.b(r1, 2131908982, false);
        L11:
            return Unit.INSTANCE;
        L7:
            if (this.$saveDir == null) goto L9;
            String r6 = this.$saveDir + File.separator + this.$savePath;
            i1.f(AppHost.a.getApplication(), r6, true);
            ImageSave.a.getClass();
            ImageSave.g(r6);
            t19.s r7 = t19.s.a;
            Context r2 = this.this$0.getContext();
            r7.getClass();
            t19.s.o(r2, 2131908983, false);
            goto L11
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1(Bitmap r1, ClickableMarkdownCodeView r2, Continuation<? super ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1> r3) {
        this.$bitmap = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1 r0 = new ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1(this.$bitmap, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        String r6 = AppHost.a.getAppName() + System.currentTimeMillis() + ".jpeg";
        String r5 = i1.b();
        Bitmap r12 = this.$bitmap;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r13 = Result.constructor-impl(Boxing.boxBoolean(i1.e(r12, r5, r6)));     // Catch: Throwable -> L11
    L13:
        Boolean r3 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r13) == false) goto L16;
        r13 = r3;
    L16:
        boolean r4 = ((Boolean) r13).booleanValue();
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r7 = new AnonymousClass1(r4, r5, r6, this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r14, r7, this) != r0) goto L20;
        return r0;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
