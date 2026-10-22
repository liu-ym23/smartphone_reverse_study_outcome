package com.larus.camera.impl.edulibs.camera.internal;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.camera.impl.edulibs.camera.internal.idl.DetectionType;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ i<kx8.c> c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ DetectionType e;
    public final /* synthetic */ Integer f;
    public final /* synthetic */ Long g;
    public final /* synthetic */ int h;
    public final /* synthetic */ SceneType i;

    public a(Bitmap r1, boolean r2, j r3, boolean r4, DetectionType r5, Integer r6, Long r7, int r8, SceneType r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final void a() {
        Bitmap r3 = null;
        Object r4 = null;
        r3 = null;
        r3 = null;
        kx8.c r2 = new kx8.c(null);
        int r0 = Math.min(this.a.getWidth(), this.a.getHeight());
        float r5 = r0;
        if (r5 <= 720.0f) goto L19;
        float r7 = 720.0f / r5;
        b.a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.d("EduImageHelper", "resizeBitmap scaleFactor " + r7 + " shortSide " + r0);
        Bitmap r1 = this.a;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Bitmap.createScaledBitmap(r1, (int) (r1.getWidth() * r7), (int) (r1.getHeight() * r7), false));     // Catch: Throwable -> L7
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L13;
        b.a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.e("EduImageHelper", "resizeBitmap error", r9);
        r7 = 1.0f;
    L13:
        if (Result.isFailure-impl(r8) == false) goto L15;
        r8 = null;
    L15:
        Bitmap r10 = (Bitmap) r8;
        if (r10 != null) goto L18;
        r10 = this.a;
    L18:
        Bitmap r11 = r10;
    L20:
        b.a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.d("EduImageHelper", "after resize: w=" + r11.getWidth() + ",h=" + r11.getHeight());
        boolean r12 = this.d;
        DetectionType r13 = this.e;
        Integer r14 = this.f;
        Long r15 = this.g;
        int r16 = this.h;
        SceneType r17 = this.i;
        boolean r18 = this.b;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L23
        com.larus.camera.impl.edulibs.camera.internal.util.c.a.getClass();     // Catch: Throwable -> L23
        Object r20 = Result.constructor-impl(com.larus.camera.impl.edulibs.camera.internal.util.c.a(r11, r12, r13, r14, r15, r16, r17, r18));     // Catch: Throwable -> L23
    L25:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L29;
        b.a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.e("EduImageHelper", "clip question error", r21);
        r2.j = "net error";
    L29:
        if (Result.isFailure-impl(r20) == false) goto L31;
        r20 = null;
    L31:
        ox8.e r22 = (ox8.e) r20;
        if (r22 == null) goto L61;
        boolean r23 = true;
        r2.i = true;
        b.a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.i("EduImageHelper", "get response:trace=" + r22.j() + ", detection=" + r22.c() + ", orientation=" + r22.f());
        if (this.b == false) goto L57;
        String r24 = r22.e();
        if (r24 == null) goto L57;
        if (r24.length() > 0) goto L41;
        r23 = false;
    L41:
        if (r23 == true) goto L44;
        r24 = null;
    L44:
        if (r24 == null) goto L57;
        Object r25 = Result.constructor-impl(com.larus.camera.impl.edulibs.camera.internal.util.a.a(r24));     // Catch: Throwable -> L47
    L49:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L53;
        b.a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.e("EduImageHelper", "clipQuestion: decode dewarp image error", r26);
    L53:
        if (Result.isFailure-impl(r25) == true) goto L56;
        r4 = r25;
    L56:
        r3 = (Bitmap) r4;
    L47:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L57:
        r2.h = r3;
        if (r3 == null) goto L60;
        FLogger.a.i("EduImageHelper", "clipQuestion dewarpBitmap width=" + r3.getWidth() + " height=" + r3.getHeight());
        b r28 = b.a;
        ox8.e r29 = ox8.e.a(r22, 0, null, null, null, 16319);
        int r30 = r3.getWidth();
        int r31 = r3.getHeight();
        r28.getClass();
        b.b(r2, r29, 1.0f, r30, r31);
    L62:
        this.c.resumeWith(Result.constructor-impl(r2));
        return;
    L60:
        b r32 = b.a;
        int r33 = this.a.getWidth();
        int r34 = this.a.getHeight();
        r32.getClass();
        b.b(r2, r22, r7, r33, r34);
        goto L62
    L61:
        r2.j = "empty response";
        b.a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.i("EduImageHelper", "response is null");
    L23:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L19:
        r11 = this.a;
        r7 = 1.0f;
        goto L20
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
