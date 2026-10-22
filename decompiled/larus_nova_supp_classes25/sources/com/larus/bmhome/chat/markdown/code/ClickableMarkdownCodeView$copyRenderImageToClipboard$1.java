package com.larus.bmhome.chat.markdown.code;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$copyRenderImageToClipboard$1", f = "ClickableMarkdownCodeView.kt", i = {0, 0}, l = {1270, 1277}, m = "invokeSuspend", n = {"$this$launch", "cacheFile"}, s = {"L$0", "L$1"})
final class ClickableMarkdownCodeView$copyRenderImageToClipboard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Bitmap $bitmap;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$copyRenderImageToClipboard$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$copyRenderImageToClipboard$1$2", f = "ClickableMarkdownCodeView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ Uri $contentUri;
        int label;

        public AnonymousClass2(Uri r1, Context r2, Continuation<? super AnonymousClass2> r3) {
            this.$contentUri = r1;
            this.$appContext = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$contentUri, this.$appContext, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r5);
            if (this.$contentUri != null) goto L8;
            t19.s r6 = t19.s.a;
            Context r1 = this.$appContext;
            r6.getClass();
            t19.s.b(r1, 2131908982, false);
            return Unit.INSTANCE;
        L8:
            ClipData r7 = ClipData.newUri(this.$appContext.getContentResolver(), "image", this.$contentUri);
            IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r2 == null) goto L11;
            r2.d0();
            i1 r3 = i1.a;
            Context r4 = this.$appContext;
            Intrinsics.checkNotNull(r4);
            Intrinsics.checkNotNull(r7);
            r3.i(r4, r7, "bpea-code-render-image-copy");
        L11:
            t19.s r8 = t19.s.a;
            Context r9 = this.$appContext;
            r8.getClass();
            t19.s.o(r9, 2131910467, false);
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ClickableMarkdownCodeView$copyRenderImageToClipboard$1(Context r1, Bitmap r2, Continuation<? super ClickableMarkdownCodeView$copyRenderImageToClipboard$1> r3) {
        this.$appContext = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ClickableMarkdownCodeView$copyRenderImageToClipboard$1 r0 = new ClickableMarkdownCodeView$copyRenderImageToClipboard$1(this.$appContext, this.$bitmap, r5);
        r0.L$0 = r4;
        return r0;
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
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L57:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        File r2 = (File) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L12
    L36:
        Object r12 = Result.constructor-impl((Uri) r11);     // Catch: Throwable -> L12
    L41:
        File r5 = r2;
        Throwable r4 = Result.exceptionOrNull-impl(r12);
        if (r4 == null) goto L45;
        FLogger.a.e("MarkdownCodeView", "copyRenderImageToClipboard export fail", r4);
    L45:
        if (Result.isFailure-impl(r12) == false) goto L47;
        r12 = null;
    L47:
        Uri r13 = (Uri) r12;
    L61:
        Result.constructor-impl(Boxing.boxBoolean(r5.delete()));     // Catch: Throwable -> L51
    L53:
        MainCoroutineDispatcher r6 = Dispatchers.getMain();
        AnonymousClass2 r7 = new AnonymousClass2(r13, this.$appContext, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(r6, r7, this) != r0) goto L57;
        return r0;
    L51:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L12:
        th = th;
    L40:
        Result.Companion r9 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L14:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        String r10 = AppHost.a.getAppName() + System.currentTimeMillis() + ".png";
        r5 = new PolarisFileWrapper(this.$appContext.getCacheDir(), r10);
        Bitmap r15 = this.$bitmap;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L24
        PolarisFileOutputStreamWrapper r17 = new PolarisFileOutputStreamWrapper(r5);     // Catch: Throwable -> L24
        boolean r18 = r15.compress(Bitmap.CompressFormat.PNG, 100, r17);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L24
        Object r19 = Result.constructor-impl(Boxing.boxBoolean(r18));     // Catch: Throwable -> L24
    L26:
        Boolean r20 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r19) == false) goto L29;
        r19 = r20;
    L29:
        boolean r21 = ((Boolean) r19).booleanValue();
        this.$bitmap.recycle();
        if (r21 == false) goto L48;
        Context r22 = this.$appContext;
        ImageSave r23 = ImageSave.a;     // Catch: Throwable -> L38
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L38
        String r24 = r5.getAbsolutePath();     // Catch: Throwable -> L38
        this.L$0 = r14;     // Catch: Throwable -> L38
        this.L$1 = r5;     // Catch: Throwable -> L38
        this.label = 1;     // Catch: Throwable -> L38
        r11 = ImageSave.l(r23, r22, r24, r10, this);     // Catch: Throwable -> L38
        if (r11 != r0) goto L35;
        return r0;
    L35:
        r2 = r5;
    L38:
        th = th;
        r2 = r5;
        goto L40
    L48:
        r13 = null;
        goto L61
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
