package com.bytedance.awemeopen.infra.plugs.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {

    public static class a extends BasePostprocessor {
        public final /* synthetic */ l64.b a;

        public a(l64.b r1) {
            this.a = r1;
        }

        public final CloseableReference<Bitmap> process(Bitmap r3, PlatformBitmapFactory r4) {
            CloseableReference r5 = r4.createBitmap(r3.getWidth(), r3.getHeight());
            c.e(r3, (Bitmap) r5.get(), this.a.q);     // Catch: Throwable -> L6
            CloseableReference<Bitmap> r6 = CloseableReference.cloneOrNull(r5);     // Catch: Throwable -> L6
            CloseableReference.closeSafely(r5);
            return r6;
        L6:
            th = move-exception;
            CloseableReference.closeSafely(r5);
            throw th;
        }

        public final void process(Bitmap r1, Bitmap r2) {
            super.process(r1, r2);
        }
    }

    public static class b extends BaseControllerListener<ImageInfo> {
        public final l64.a a;
        public boolean b;

        public b(l64.a r1, l64.b r2) {
            this.b = false;
            this.a = r1;
        }

        public final void onFailure(String r2, Throwable r3) {
            if (this.b == false) goto L5;
            return;
        L5:
            this.b = true;
            l64.a r4 = this.a;
            if (r4 == null) goto L9;
            r4.onFail(new Exception(r3));
            return;
        }

        public final void onIntermediateImageSet(String r1, Object r2) {
            super.onIntermediateImageSet(r1, (ImageInfo) r2);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if (this.b == true) goto L15;
            this.b = true;
            l64.a r5 = this.a;
            if (r5 == null) goto L8;
            r5.onSuccess();
        L8:
            if (r3 != null) goto L10;
            return;
        L10:
            if ((r3 instanceof AnimatedDrawable2) == false) goto L14;
            ((AnimatedDrawable2) r3).setAnimationListener(new f(this));
            return;
        L14:
            return;
        }
    }

    public static Bitmap a(Bitmap r11, l64.b r12) {
        float r0 = r12.l / r11.getWidth();
        float r1 = r12.m / r11.getHeight();
        int r2 = r11.getWidth();
        int r3 = r11.getHeight();
        Matrix r9 = new Matrix();
        if (r0 <= r1) goto L5;
        int r4 = (int) Math.ceil(r11.getHeight() * (r1 / r0));
        int r5 = (r11.getHeight() - r4) / 2;
        int r6 = r5;
        int r7 = r2;
        int r8 = r4;
        int r10 = 0;
        r1 = r12.m / r4;
    L6:
        r9.preScale(r0, r1);
        return Bitmap.createBitmap(r11, r10, r6, r7, r8, r9, true);
    L5:
        int r13 = (int) Math.ceil(r11.getWidth() * (r0 / r1));
        int r14 = (r11.getWidth() - r13) / 2;
        r10 = r14;
        r7 = r13;
        r8 = r3;
        r6 = 0;
        r0 = r12.l / r13;
        goto L6
    }

    public static void d(Context r6, l64.b r7) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.awemeopen.infra.plugs.fresco.c.d(android.content.Context, l64.b):void");
    }

    public static void b(Bitmap r5, Bitmap r6, l64.b r7) {
        Canvas r0 = new Canvas(r6);
        Paint r8 = new Paint();
        r8.setAntiAlias(true);
        r8.setColor(-12434878);
        Rect r1 = new Rect(0, 0, r5.getWidth(), r5.getHeight());
        if (r7.q == 0) goto L5;
        RectF r2 = new RectF(r1);
        float r9 = r7.q;
        r0.drawRoundRect(r2, r9, r9, r8);
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    L5:
        r0.drawBitmap(r5, r1, r1, r8);
    }

    public static void e(Bitmap r5, Bitmap r6, int r7) {
        Canvas r0 = new Canvas(r6);
        Paint r8 = new Paint();
        Rect r1 = new Rect(0, 0, r5.getWidth(), r5.getHeight());
        RectF r2 = new RectF(r1);
        float r9 = r7;
        r8.setAntiAlias(true);
        r0.drawARGB(0, 0, 0, 0);
        r8.setColor(-12434878);
        r0.drawRoundRect(r2, r9, r9, r8);
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r0.drawBitmap(r5, r1, r1, r8);
    }

    public static void c(Bitmap r6, Bitmap r7, int r8, int r9, l64.b r10) {
        float r0 = r9 / r6.getWidth();
        float r1 = r8 / r6.getHeight();
        Matrix r2 = new Matrix();
        Canvas r3 = new Canvas(r7);
        Paint r11 = new Paint();
        r11.setAntiAlias(true);
        r3.drawARGB(0, 0, 0, 0);
        r11.setColor(-12434878);
        r2.postScale(r0, r1);
        if (r10.q == 0) goto L5;
        RectF r12 = new RectF(new Rect(0, 0, r9, r8));
        float r13 = r10.q;
        r3.drawRoundRect(r12, r13, r13, r11);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    L5:
        r3.drawBitmap(r6, r2, r11);
    }
}
