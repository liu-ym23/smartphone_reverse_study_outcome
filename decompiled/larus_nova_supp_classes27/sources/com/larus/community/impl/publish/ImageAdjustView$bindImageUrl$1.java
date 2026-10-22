package com.larus.community.impl.publish;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.ImageAdjustView$bindImageUrl$1", f = "ImageAdjustView.kt", i = {0}, l = {50}, m = "invokeSuspend", n = {"temp"}, s = {"L$0"})
final class ImageAdjustView$bindImageUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ boolean $showVideoPlayIcon;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImageAdjustView this$0;

    public ImageAdjustView$bindImageUrl$1(ImageAdjustView r1, String r2, boolean r3, Continuation<? super ImageAdjustView$bindImageUrl$1> r4) {
        this.this$0 = r1;
        this.$imageUrl = r2;
        this.$showVideoPlayIcon = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageAdjustView$bindImageUrl$1(this.this$0, this.$imageUrl, this.$showVideoPlayIcon, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v14, types: [android.view.ViewGroup, com.larus.community.impl.publish.ImageAdjustView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ImageAdjustView r2 = (ImageAdjustView) this.L$1;
        CloseableReference<CloseableImage> r3 = (CloseableReference) this.L$0;
        ResultKt.throwOnFailure(r7);
    L12:
        r2.c = (CloseableReference) r7;
        ImageAdjustView r8 = this.this$0;
        CloseableReference<CloseableImage> r4 = r8.c;
        Integer r5 = null;
        if (r4 == null) goto L15;
        CloseableImage r6 = (CloseableImage) r4.get();
    L17:
        if ((r6 instanceof CloseableStaticBitmap) == false) goto L19;
        CloseableStaticBitmap r9 = (CloseableStaticBitmap) r6;
    L20:
        if (r9 == null) goto L22;
        Bitmap r10 = r9.getUnderlyingBitmap();
    L23:
        r8.b = r10;
        ImageAdjustView r11 = this.this$0;
        Bitmap r12 = r11.b;
        if (r12 == null) goto L29;
        if (r12.isRecycled() == true) goto L29;
        r11.a.b.setImageBitmap(r11.b);
        CloseableReference.closeSafely(r3);
    L29:
        if (this.$showVideoPlayIcon == false) goto L31;
        e1.x(this.this$0.a.d);
        e1.o(this.this$0.a.c);
    L32:
        ?? r13 = this.this$0;
        r13.R5(r13.b, r13.getWidth(), this.this$0.getHeight());
        boolean r14 = m29.a.a;
        StringBuilder r15 = new StringBuilder("bindData bitmap: width");
        Bitmap r16 = this.this$0.b;
        if (r16 == null) goto L35;
        Integer r17 = Boxing.boxInt(r16.getWidth());
    L36:
        r15.append(r17);
        r15.append(",height:");
        Bitmap r18 = this.this$0.b;
        if (r18 == null) goto L39;
        r5 = Boxing.boxInt(r18.getHeight());
    L39:
        r15.append(r5);
        m29.a.c("ImageAdjustView", r15.toString());
        return Unit.INSTANCE;
    L35:
        r17 = null;
        goto L36
    L31:
        e1.o(this.this$0.a.d);
        e1.x(this.this$0.a.c);
        goto L32
    L22:
        r10 = null;
        goto L23
    L19:
        r9 = null;
        goto L20
    L15:
        r6 = null;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ImageAdjustView r20 = this.this$0;
        r3 = r20.c;
        String r21 = this.$imageUrl;
        Function1 r22 = new f0();
        this.L$0 = r3;
        this.L$1 = r20;
        this.label = 1;
        Object r23 = ImageLoaderKt.i(r21, "ImageAdjustView", r22, this, 28);
        if (r23 != r0) goto L11;
        return r0;
    L11:
        r2 = r20;
        r7 = r23;
        goto L12
    }
}
