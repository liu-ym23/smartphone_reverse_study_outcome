package com.larus.voicecall.impl.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.facebook.imagepipeline.postprocessors.BlurPostProcessor;
import com.larus.utils.e1;
import com.miui.easygo.sdk.constant.EasyGoCode;
import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.video.ViewPortContainerView$3$onMaskModeEnter$1", f = "ViewPortSwitcher.kt", i = {}, l = {504, EasyGoCode.InitializedErrCode.PERMISSION_DENIED}, m = "invokeSuspend", n = {}, s = {})
public final class ViewPortContainerView$3$onMaskModeEnter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ViewPortContainerView this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.video.ViewPortContainerView$3$onMaskModeEnter$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.video.ViewPortContainerView$3$onMaskModeEnter$1$1", f = "ViewPortSwitcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $contentBitmap;
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ ViewPortContainerView this$0;

        public AnonymousClass1(ViewPortContainerView r1, Bitmap r2, Context r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$contentBitmap = r2;
            this.$context = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$contentBitmap, this.$context, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            View r5 = this.this$0.c;
            if (this.$contentBitmap == null) goto L7;
            BitmapDrawable r0 = new BitmapDrawable(this.$context.getResources(), this.$contentBitmap);
        L8:
            r5.setBackground(r0);
            e1.x(this.this$0.c);
            return Unit.INSTANCE;
        L7:
            r0 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ViewPortContainerView$3$onMaskModeEnter$1(ViewPortContainerView r1, Context r2, Continuation<? super ViewPortContainerView$3$onMaskModeEnter$1> r3) {
        this.this$0 = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ViewPortContainerView$3$onMaskModeEnter$1(this.this$0, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        Bitmap r9 = (Bitmap) r8;
        if (r9 == null) goto L16;
        new BlurPostProcessor(8, this.$context).process(r9);
    L16:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, r9, this.$context, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L20;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        float r10 = this.this$0.b.getWidth() * this.this$0.getScaleX();
        float r4 = this.this$0.b.getHeight() * this.this$0.getScaleX();
        ViewPortContainerView r5 = this.this$0;
        this.label = 1;
        r8 = ViewPortContainerView.a(r5, r10, r4, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
