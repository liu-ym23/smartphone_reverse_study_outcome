package com.larus.uaigc.createpage.bussiness.remove;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.createpage.bussiness.remove.widget.GesturePaletteView;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doFinish$1$1$1$1$jobList$2", f = "ImageRemoveFragment.kt", i = {}, l = {643, 645, 648}, m = "invokeSuspend", n = {}, s = {})
public final class ImageRemoveFragment$doFinish$1$1$1$1$jobList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $maskBitmap;
    final /* synthetic */ ImageEditDataWithMask $resultData;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$doFinish$1$1$1$1$jobList$2(ImageRemoveFragment r1, Bitmap r2, ImageEditDataWithMask r3, Continuation<? super ImageRemoveFragment$doFinish$1$1$1$1$jobList$2> r4) {
        this.this$0 = r1;
        this.$maskBitmap = r2;
        this.$resultData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageRemoveFragment$doFinish$1$1$1$1$jobList$2(this.this$0, this.$maskBitmap, this.$resultData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r5 = null;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r14);
    L81:
        File r15 = (File) r14;
    L82:
        ImageEditDataWithMask r2 = this.$resultData;
        if (r15 == null) goto L85;
        r5 = r15.getPath();
    L85:
        r2.setMaskImgFilePath(r5);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
    L77:
        r15 = (File) r14;
        goto L82
    L11:
        ResultKt.throwOnFailure(r14);
    L73:
        r15 = (File) r14;
        goto L82
    L12:
        ResultKt.throwOnFailure(r14);
        ImageRemoveFragment r16 = this.this$0;
        if (r16.k == false) goto L78;
        MediaAttachment r17 = r16.i;
        if (r17 == null) goto L21;
        ImageUploadInfo r18 = r17.getImageUploadInfo();
        if (r18 == null) goto L21;
        Long r19 = r18.getWidth();
        if (r19 == null) goto L21;
        Integer r110 = Boxing.boxInt((int) r19.longValue());
    L22:
        LarusFragmentImageRemoveBinding r3 = this.this$0.d;
        if (r3 == null) goto L29;
        GesturePaletteView r4 = r3.h;
        if (r4 == null) goto L29;
        Bitmap r6 = r4.getViewBitmap();
        if (r6 == null) goto L29;
        Integer r7 = Boxing.boxInt(r6.getWidth());
    L31:
        if (Intrinsics.areEqual(r110, r7) == false) goto L50;
        MediaAttachment r111 = this.this$0.i;
        if (r111 == null) goto L39;
        ImageUploadInfo r112 = r111.getImageUploadInfo();
        if (r112 == null) goto L39;
        Long r113 = r112.getHeight();
        if (r113 == null) goto L39;
        Integer r114 = Boxing.boxInt((int) r113.longValue());
    L40:
        LarusFragmentImageRemoveBinding r8 = this.this$0.d;
        if (r8 == null) goto L47;
        GesturePaletteView r9 = r8.h;
        if (r9 == null) goto L47;
        Bitmap r10 = r9.getViewBitmap();
        if (r10 == null) goto L47;
        Integer r11 = Boxing.boxInt(r10.getHeight());
    L49:
        if (Intrinsics.areEqual(r114, r11) == true) goto L78;
    L47:
        r11 = null;
    L39:
        r114 = null;
    L50:
        MediaAttachment r115 = this.this$0.i;
        int r12 = 0;
        if (r115 == null) goto L57;
        ImageUploadInfo r116 = r115.getImageUploadInfo();
        if (r116 == null) goto L57;
        Long r117 = r116.getWidth();
        if (r117 == null) goto L57;
        int r118 = (int) r117.longValue();
    L58:
        MediaAttachment r13 = this.this$0.i;
        if (r13 == null) goto L65;
        ImageUploadInfo r20 = r13.getImageUploadInfo();
        if (r20 == null) goto L65;
        Long r21 = r20.getHeight();
        if (r21 == null) goto L65;
        r12 = (int) r21.longValue();
    L65:
        if (r118 <= 0) goto L74;
        if (r12 <= 0) goto L74;
        ImageRemoveFragment r22 = this.this$0;
        Bitmap r23 = this.$maskBitmap;
        r22.getClass();
        float r119 = r118 / r23.getWidth();
        float r24 = r12 / r23.getHeight();
        Matrix r120 = new Matrix();
        r120.postScale(r119, r24);
        Bitmap r121 = Bitmap.createBitmap(r23, 0, 0, r23.getWidth(), r23.getHeight(), r120, true);
        if (Intrinsics.areEqual(r23, r121) == true) goto L70;
        r23.recycle();
    L70:
        ImageRemoveFragment r25 = this.this$0;
        this.label = 1;
        r14 = ImageRemoveFragment.T90(r25, r121, this);
        if (r14 != r0) goto L73;
        return r0;
    L74:
        ImageRemoveFragment r122 = this.this$0;
        Bitmap r26 = this.$maskBitmap;
        this.label = 2;
        r14 = ImageRemoveFragment.T90(r122, r26, this);
        if (r14 != r0) goto L77;
        return r0;
    L57:
        r118 = 0;
    L29:
        r7 = null;
    L21:
        r110 = null;
    L78:
        ImageRemoveFragment r123 = this.this$0;
        Bitmap r27 = this.$maskBitmap;
        this.label = 3;
        r14 = ImageRemoveFragment.T90(r123, r27, this);
        if (r14 != r0) goto L81;
        return r0;
    }
}
