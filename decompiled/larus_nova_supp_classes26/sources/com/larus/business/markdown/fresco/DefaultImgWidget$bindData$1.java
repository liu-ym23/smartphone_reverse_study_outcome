package com.larus.business.markdown.fresco;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.image.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.business.markdown.fresco.DefaultImgWidget$bindData$1", f = "DefaultImgWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultImgWidget$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.business.markdown.api.extplugin.image.c $span;
    final /* synthetic */ Spanned $text;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ DefaultImgWidget this$0;

    public DefaultImgWidget$bindData$1(DefaultImgWidget r1, com.larus.business.markdown.api.extplugin.image.c r2, Spanned r3, TextView r4, Continuation<? super DefaultImgWidget$bindData$1> r5) {
        this.this$0 = r1;
        this.$span = r2;
        this.$text = r3;
        this.$textView = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DefaultImgWidget$bindData$1(this.this$0, this.$span, this.$text, this.$textView, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r21);
        final DefaultImgWidget r10 = this.this$0;
        final com.larus.business.markdown.api.extplugin.image.c r9 = this.$span;
        Spanned r0 = this.$text;
        final TextView r13 = this.$textView;
        int r2 = DefaultImgWidget.i;
        r10.removeAllViews();
        boolean r4 = false;
        ConstraintLayout r3 = LayoutInflater.from(r10.getContext()).inflate(2131563624, r10, false);
        r10.addView(r3);
        final SimpleDraweeView r6 = r3.findViewById(2131368407);
        if (r6 == null) goto L30;
        ConstraintLayout r5 = r3;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 == null) goto L28;
        r7.width = -1;
        r7.height = -1;
        r5.setLayoutParams(r7);
        r10.c(r0, r9);
        final int r1 = r10.c.getWidth();
        final int r8 = r10.c.getHeight();
        r6.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r9.f()));     // Catch: Throwable -> L20
        r6.setOnLongClickListener(new a(r13));     // Catch: Throwable -> L20
        final g r11 = new g(r6, r13, r9, r10.f, r10.g, r10.h, r1, r8);     // Catch: Throwable -> L20
        com.larus.business.markdown.api.extplugin.image.b r12 = r10.a;     // Catch: Throwable -> L20
        if (r12 == null) goto L12;
        r12.b();     // Catch: Throwable -> L20
        r4 = true;
    L12:
        if (r4 == false) goto L14;
        r10.a.c(r11);     // Catch: Throwable -> L20
        com.larus.business.markdown.api.extplugin.image.c r14 = r9;
        boolean r15 = true;
    L25:
        r10.setOutlineProvider(new d(r14.f()));
        r10.setClipToOutline(r15);
        return Unit.INSTANCE;
    L14:
        final Ref.ObjectRef r16 = new Ref.ObjectRef();     // Catch: Throwable -> L20
        r15 = true;
        r14 = r9;
        Function0<Unit> r17 = new DefaultImgWidget$bindImage$2(r9, r1, r8, r6, r10, r16, r11);     // Catch: Throwable -> L18
        r16.element = r17;     // Catch: Throwable -> L18
        r17.invoke();     // Catch: Throwable -> L18
    L18:
        th = th;
    L22:
        com.larus.business.markdown.api.depend.d r18 = IMarkdownLoggerKt.a();
        if (r18 == null) goto L25;
        r18.e("DefaultImgWidget", "error:" + th.getMessage() + ",url:" + r14.getUrl());
    L20:
        th = th;
        r14 = r9;
        r15 = true;
        goto L22
    L28:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L30:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(2131368407)));
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
