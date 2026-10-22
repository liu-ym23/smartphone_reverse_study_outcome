package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$readBitmapIntoImageView$1", f = "FirstScreenStatistic.kt", i = {1}, l = {1112, 1117, 1123, 1131, 1155}, m = "invokeSuspend", n = {"bitmap"}, s = {"L$0"})
final class FirstScreenStatistic$readBitmapIntoImageView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ String $cleanUrl;
    final /* synthetic */ HashMap $extra;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ String $md5Name;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.imagex.FirstScreenStatistic$readBitmapIntoImageView$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$readBitmapIntoImageView$1$1", f = "FirstScreenStatistic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FirstScreenStatistic$readBitmapIntoImageView$1 this$0;

        public AnonymousClass1(FirstScreenStatistic$readBitmapIntoImageView$1 r1, Continuation r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "completion");
            return new AnonymousClass1(this.this$0, r11);
        }

        public final Object invoke(Object r1, Object r10) {
            return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            this.this$0.$callback.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FirstScreenStatistic$readBitmapIntoImageView$1(ImageView r1, String r10, HashMap r11, Function1 r12, String r13, Continuation r14) {
        this.$imageView = r1;
        this.$cleanUrl = r10;
        this.$extra = r11;
        this.$callback = r12;
        this.$md5Name = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        FirstScreenStatistic$readBitmapIntoImageView$1 r0 = new FirstScreenStatistic$readBitmapIntoImageView$1(this.$imageView, this.$cleanUrl, this.$extra, this.$callback, this.$md5Name, r11);
        r0.L$0 = r10;
        return r0;
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L14;
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L14;
        if (r11 == 4) goto L14;
        if (r11 != 5) goto L11;
        ResultKt.throwOnFailure(r17);
    L64:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Ref.ObjectRef r0 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L32
        Ref.ObjectRef r14 = r0;
        Object r1 = r17;
    L38:
        r14.element = (Bitmap) r1;     // Catch: Throwable -> L32
        if (((Bitmap) r12.element) != null) goto L46;
        FirstScreenStatistic r13 = FirstScreenStatistic.S;     // Catch: Throwable -> L32
        HashMap r15 = this.$extra;     // Catch: Throwable -> L32
        r13.getClass();     // Catch: Throwable -> L32
        FirstScreenStatistic.n("readBitmapInfoImageView", "wait Bitmap null", null, r15);     // Catch: Throwable -> L32
        if (FirstScreenStatistic.o == false) goto L43;
        this.$callback.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L32
    L52:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L56:
        if (Result.isFailure-impl(r16) == false) goto L64;
        FirstScreenStatistic r18 = FirstScreenStatistic.S;
        Throwable r19 = Result.exceptionOrNull-impl(r16);
        HashMap r20 = this.$extra;
        r18.getClass();
        FirstScreenStatistic.n("readBitmapInfoImageView", "run error", r19, r20);
        if (FirstScreenStatistic.o == false) goto L60;
        this.$callback.invoke(Boxing.boxBoolean(false));
        goto L64
    L60:
        MainCoroutineDispatcher r21 = Dispatchers.getMain();
        AnonymousClass1 r22 = new AnonymousClass1(this, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 5;
        if (BuildersKt.withContext(r21, r22, this) != r10) goto L64;
        return r10;
    L43:
        MainCoroutineDispatcher r23 = Dispatchers.getMain();     // Catch: Throwable -> L32
        FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$2 r24 = new FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$2(null, this, r12);     // Catch: Throwable -> L32
        this.L$0 = null;     // Catch: Throwable -> L32
        this.L$1 = null;     // Catch: Throwable -> L32
        this.label = 3;     // Catch: Throwable -> L32
        if (BuildersKt.withContext(r23, r24, this) != r10) goto L52;
        return r10;
    L46:
        dm.a.a("FirstScreenStatistic").a("readBitmapInfoImageView success getBitmap");     // Catch: Throwable -> L32
        p0 r25 = FirstScreenStatistic.N.get(this.$md5Name);     // Catch: Throwable -> L32
        if (r25 == null) goto L49;
        r25.d = System.currentTimeMillis();     // Catch: Throwable -> L32
    L49:
        MainCoroutineDispatcher r26 = Dispatchers.getMain();     // Catch: Throwable -> L32
        FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$3 r27 = new FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$3(null, this, r12);     // Catch: Throwable -> L32
        this.L$0 = null;     // Catch: Throwable -> L32
        this.L$1 = null;     // Catch: Throwable -> L32
        this.label = 4;     // Catch: Throwable -> L32
        if (BuildersKt.withContext(r26, r27, this) != r10) goto L52;
        return r10;
    L14:
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L32
        goto L52
    L16:
        ResultKt.throwOnFailure(r17);
        CoroutineScope r28 = (CoroutineScope) this.L$0;
        FirstScreenStatistic r29 = FirstScreenStatistic.S;
        String r110 = FirstScreenStatistic.L.get(this.$imageView);
        if (r110 != null) goto L20;
        r110 = "";
    L20:
        if ((!Intrinsics.areEqual(r110, this.$cleanUrl)) == false) goto L23;
        this.$extra.put("newUrl", r110);
        HashMap r30 = this.$extra;
        r29.getClass();
        FirstScreenStatistic.n("readBitmapInfoImageView", "imageView url changed in io thread", null, r30);
        this.$callback.invoke(null);
        return Unit.INSTANCE;
    L23:
        r14 = new Ref.ObjectRef();
        r14.element = null;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        Deferred<Bitmap> r31 = FirstScreenStatistic.P.get(this.$md5Name);     // Catch: Throwable -> L32
        if (r31 != null) goto L34;
        HashMap r32 = this.$extra;     // Catch: Throwable -> L32
        r29.getClass();     // Catch: Throwable -> L32
        FirstScreenStatistic.n("readBitmapInfoImageView", "no bitmap task", null, r32);     // Catch: Throwable -> L32
        dm.a.a("FirstScreenStatistic").b("md5 " + this.$md5Name + " url " + this.$cleanUrl + " task == null ? true " + FirstScreenStatistic.K.contains(this.$md5Name), null);     // Catch: Throwable -> L32
        if (FirstScreenStatistic.o == false) goto L29;
        this.$callback.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L32
        goto L52
    L29:
        MainCoroutineDispatcher r33 = Dispatchers.getMain();     // Catch: Throwable -> L32
        FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$1 r34 = new FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$1(null, this, r14);     // Catch: Throwable -> L32
        this.label = 1;     // Catch: Throwable -> L32
        if (BuildersKt.withContext(r33, r34, this) != r10) goto L52;
        return r10;
    L34:
        this.L$0 = r14;     // Catch: Throwable -> L32
        this.L$1 = r14;     // Catch: Throwable -> L32
        this.label = 2;     // Catch: Throwable -> L32
        r1 = r31.await(this);     // Catch: Throwable -> L32
        if (r1 != r10) goto L37;
        return r10;
    L37:
        r12 = r14;
    L32:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    }
}
