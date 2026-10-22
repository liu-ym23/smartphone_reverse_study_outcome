package com.larus.uaigc.createpage.bussiness.remove;

import android.graphics.Bitmap;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.createpage.bussiness.remove.widget.GesturePaletteView;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doFinish$1$1$1$1$jobList$3", f = "ImageRemoveFragment.kt", i = {}, l = {662}, m = "invokeSuspend", n = {}, s = {})
public final class ImageRemoveFragment$doFinish$1$1$1$1$jobList$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageEditDataWithMask $resultData;
    final /* synthetic */ Bitmap $viewBitmap;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$doFinish$1$1$1$1$jobList$3(ImageRemoveFragment r1, ImageEditDataWithMask r2, Bitmap r3, Continuation<? super ImageRemoveFragment$doFinish$1$1$1$1$jobList$3> r4) {
        this.this$0 = r1;
        this.$resultData = r2;
        this.$viewBitmap = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageRemoveFragment$doFinish$1$1$1$1$jobList$3(this.this$0, this.$resultData, this.$viewBitmap, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
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
        Long r3 = null;
        String r4 = null;
        r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L75:
        File r8 = (File) r7;
        ImageEditDataWithMask r2 = this.$resultData;
        if (r8 == null) goto L78;
        r4 = r8.getPath();
    L78:
        r2.setOriImgFilePath(r4);
    L80:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MediaAttachment r9 = this.this$0.i;
        if (r9 == null) goto L11;
        String r10 = r9.getUri();
    L13:
        if (o0.d(r10) == false) goto L72;
        ImageRemoveFragment r11 = this.this$0;
        if (r11.k == true) goto L52;
        MediaAttachment r12 = r11.i;
        if (r12 == null) goto L23;
        ImageUploadInfo r13 = r12.getImageUploadInfo();
        if (r13 == null) goto L23;
        Long r14 = r13.getWidth();
        if (r14 == null) goto L23;
        Integer r15 = Boxing.boxInt((int) r14.longValue());
    L24:
        LarusFragmentImageRemoveBinding r5 = this.this$0.d;
        if (r5 == null) goto L31;
        GesturePaletteView r6 = r5.h;
        if (r6 == null) goto L31;
        Bitmap r16 = r6.getViewBitmap();
        if (r16 == null) goto L31;
        Integer r17 = Boxing.boxInt(r16.getWidth());
    L33:
        if (Intrinsics.areEqual(r15, r17) == false) goto L72;
        MediaAttachment r18 = this.this$0.i;
        if (r18 == null) goto L41;
        ImageUploadInfo r19 = r18.getImageUploadInfo();
        if (r19 == null) goto L41;
        Long r20 = r19.getHeight();
        if (r20 == null) goto L41;
        Integer r21 = Boxing.boxInt((int) r20.longValue());
    L42:
        LarusFragmentImageRemoveBinding r22 = this.this$0.d;
        if (r22 == null) goto L49;
        GesturePaletteView r23 = r22.h;
        if (r23 == null) goto L49;
        Bitmap r24 = r23.getViewBitmap();
        if (r24 == null) goto L49;
        Integer r25 = Boxing.boxInt(r24.getHeight());
    L51:
        if (Intrinsics.areEqual(r21, r25) == false) goto L72;
    L49:
        r25 = null;
    L41:
        r21 = null;
    L31:
        r17 = null;
    L23:
        r15 = null;
    L52:
        ImageEditDataWithMask r26 = this.$resultData;
        MediaAttachment r27 = this.this$0.i;
        if (r27 == null) goto L55;
        String r28 = r27.getUri();
    L56:
        r26.setOriImgUri(r28);
        ImageEditDataWithMask r29 = this.$resultData;
        MediaAttachment r30 = this.this$0.i;
        if (r30 == null) goto L59;
        String r31 = r30.getUrl();
    L60:
        r29.setOriImgUrl(r31);
        ImageEditDataWithMask r32 = this.$resultData;
        MediaAttachment r33 = this.this$0.i;
        if (r33 == null) goto L65;
        ImageUploadInfo r34 = r33.getImageUploadInfo();
        if (r34 == null) goto L65;
        Long r35 = r34.getWidth();
    L66:
        MediaAttachment r36 = this.this$0.i;
        if (r36 == null) goto L71;
        ImageUploadInfo r37 = r36.getImageUploadInfo();
        if (r37 == null) goto L71;
        r3 = r37.getHeight();
    L71:
        r32.setImageUploadInfo(new ImageUploadInfo(r35, r3));
    L65:
        r35 = null;
        goto L66
    L59:
        r31 = null;
        goto L60
    L55:
        r28 = null;
    L72:
        ImageRemoveFragment r38 = this.this$0;
        Bitmap r39 = this.$viewBitmap;
        this.label = 1;
        r7 = ImageRemoveFragment.T90(r38, r39, this);
        if (r7 != r0) goto L75;
        return r0;
    L11:
        r10 = null;
        goto L13
    }
}
