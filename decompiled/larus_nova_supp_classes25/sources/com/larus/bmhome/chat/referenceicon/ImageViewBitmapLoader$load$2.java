package com.larus.bmhome.chat.referenceicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.referenceicon.ImageViewBitmapLoader$load$2", f = "ImageViewBitmapLoader.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class ImageViewBitmapLoader$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ boolean $acceptDrawable;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<ImageView, Unit> $request;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    public static final class a implements Function1<Throwable, Unit> {
        public final /* synthetic */ ImageViewBitmapLoader.a a;

        public a(ImageViewBitmapLoader.a r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.b = null;
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<Bitmap, Unit> {
        public final /* synthetic */ i<Bitmap> a;

        public b(j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            Intrinsics.checkNotNullParameter(r3, "bitmap");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageViewBitmapLoader$load$2(Context r1, boolean r2, Function1<? super ImageView, Unit> r3, Continuation<? super ImageViewBitmapLoader$load$2> r4) {
        this.$context = r1;
        this.$acceptDrawable = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageViewBitmapLoader$load$2(this.$context, this.$acceptDrawable, this.$request, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Function1 r2 = (Function1) this.L$1;
        Context r3 = (Context) this.L$0;
        ResultKt.throwOnFailure(r7);
    L20:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Context r8 = this.$context;
        boolean r4 = this.$acceptDrawable;
        Function1<ImageView, Unit> r5 = this.$request;
        this.L$0 = r8;
        this.L$1 = r5;
        this.Z$0 = r4;
        this.label = 1;
        j r6 = new j(IntrinsicsKt.intercepted(this), 1);
        r6.C();
        ImageViewBitmapLoader.a r9 = new ImageViewBitmapLoader.a(r8.getApplicationContext(), r4, new b(r6));
        r6.i(new a(r9));
        r5.invoke(r9);     // Catch: Throwable -> L11
    L15:
        r7 = r6.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(this);
    L18:
        if (r7 != r0) goto L20;
        return r0;
    L11:
        th = move-exception;
        r9.b = null;
        if (r6.isActive() == false) goto L15;
        Result.Companion r10 = Result.Companion;
        r6.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
        goto L15
    }
}
