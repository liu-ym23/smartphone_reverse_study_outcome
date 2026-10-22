package com.larksuite.component.ignition.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class BlurProcessor {
    public static final BlurProcessor a = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ int c;
        public final /* synthetic */ i<Bitmap> d;
        public final /* synthetic */ float e;

        public a(Context r1, Bitmap r2, int r3, j r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            Objects.toString(ThreadMethodProxy.currentThread());
            RenderScript r0 = RenderScript.create(this.a);
            Bitmap r1 = Bitmap.createBitmap(this.b.getWidth() / this.c, this.b.getHeight() / this.c, Bitmap.Config.ARGB_8888);
            Canvas r2 = new Canvas(r1);
            int r3 = this.c;
            r2.scale(1.0f / r3, 1.0f / r3);
            r2.drawBitmap(this.b, 0.0f, 0.0f, new Paint(2));
            Bitmap r4 = Bitmap.createBitmap(r1.getWidth(), r1.getHeight(), Bitmap.Config.ARGB_8888);
            Allocation r5 = Allocation.createFromBitmap(r0, r1);
            Allocation r6 = Allocation.createFromBitmap(r0, r4);
            ScriptIntrinsicBlur r7 = ScriptIntrinsicBlur.create(r0, Element.U8_4(r0));
            r7.setRadius(this.e);
            r7.setInput(r5);
            r7.forEach(r6);
            r6.copyTo(r4);
            r0.destroy();
            this.d.resumeWith(Result.constructor-impl(r4));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = new BlurProcessor();
    }

    public BlurProcessor() {
    }

    public final Object b(Context r5, Bitmap r6, int r7, Continuation<? super Drawable> r8) {
        if ((r8 instanceof BlurProcessor$process$1) == false) goto L7;
        BlurProcessor$process$1 r0 = (BlurProcessor$process$1) r8;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.I$0;
        r5 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L17:
        Bitmap r10 = (Bitmap) r9;
        new Canvas(r10).drawColor(r7);
        return new BitmapDrawable(r5.getResources(), r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.L$0 = r5;
        r0.I$0 = r7;
        r0.label = 1;
        r9 = a(r5, r6, 25.0f, 6, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new BlurProcessor$process$1(this, r8);
        goto L8
    }

    public static Object a(Context r9, Bitmap r10, float r11, int r12, Continuation r13) {
        j r6 = new j(IntrinsicsKt.intercepted(r13), 1);
        r6.C();
        CoreThreadPool.getDefault().getFixedThreadPool().submit(new a(r9, r10, r12, r6, r11));
        Object r14 = r6.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L5:
        return r14;
    }
}
