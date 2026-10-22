package com.larus.camera.impl.edulibs.camera.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.lightning.edu.ei.edgealgorithm.InferenceHelper;
import com.lightning.edu.ei.edgealgorithm.Params;
import com.lightning.edu.ei.edgealgorithm.Result;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final a c = null;
    public static WeakReference<c> d;
    public InferenceHelper a;
    public Params b;

    public static final class a {
        public a() {
        }

        public final synchronized c a(Context r4) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r4, "context");     // Catch: Throwable -> L16
            WeakReference<c> r0 = c.d;     // Catch: Throwable -> L16
            if (r0 == null) goto L6;
            c r1 = r0.get();     // Catch: Throwable -> L16
        L7:
            if (r1 != null) goto L13;
            c.d = new WeakReference(new c(r4));     // Catch: Throwable -> L16
            LinkedHashMap<Object, Object> r5 = f.a;     // Catch: Throwable -> L16
            LinkedHashMap<Object, Object> r6 = f.a;     // Catch: Throwable -> L16
            WeakReference<c> r2 = c.d;     // Catch: Throwable -> L16
            if (r2 == null) goto L11;
            c r3 = r2.get();     // Catch: Throwable -> L16
        L12:
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L16
            r6.put(r3, null);     // Catch: Throwable -> L16
            goto L13
        L11:
            r3 = null;
        L13:
            WeakReference<c> r7 = c.d;     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L16
            c r8 = r7.get();     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L16
            c r9 = r8;     // Catch: Throwable -> L16
            monitor-exit(this);
            return r9;
        L6:
            r1 = null;
        L16:
            th = move-exception;
            throw th;
        }
    }

    static {
        c = new a();
    }

    public c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        String r0 = String.valueOf(r5.getExternalCacheDir());
        this.b = InferenceHelper.getVaildParams();
        this.a = InferenceHelper.initModel(r5.getAssets(), 1, 0, r0, this.b);
    }

    public final Result a(Context r10, Bitmap r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bitmap");
        Params r0 = InferenceHelper.getVaildParams();
        Params r1 = this.b;
        int r3 = 1;
        if (r1 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        boolean r5 = !r4;
        if (r1 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        boolean r7 = !r6;
        if (r1 != null) goto L17;
    L19:
        boolean r8 = false;
    L20:
        boolean r9 = !r8;
        if (r1 != null) goto L23;
    L25:
        boolean r12 = false;
    L26:
        boolean r13 = !r12;
        if (r1 != null) goto L29;
    L31:
        boolean r2 = false;
    L32:
        boolean r14 = !r2;
        if (r5 == true) goto L40;
        if (r7 == true) goto L40;
        if (r9 == true) goto L40;
        if (r14 == true) goto L40;
        if (r13 == true) goto L40;
        boolean r15 = false;
    L41:
        this.b = r0;
        if (this.a != null) goto L44;
        this.a = InferenceHelper.initModel(r10.getAssets(), 1, 0, String.valueOf(r10.getExternalCacheDir()), this.b);
    L46:
        InferenceHelper r16 = this.a;
        Params r17 = new Params();
        Params r18 = this.b;
        if (r18 == null) goto L49;
        int r19 = r18.blur_status;
    L50:
        r17.blur_status = r19;
        if (r18 == null) goto L53;
        int r20 = r18.dark_status;
    L54:
        r17.dark_status = r20;
        if (r18 == null) goto L57;
        int r21 = r18.orientation_status;
    L58:
        r17.orientation_status = r21;
        if (r18 == null) goto L61;
        int r22 = r18.scene_status;
    L62:
        r17.scene_status = r22;
        if (r18 == null) goto L65;
        r3 = r18.questions_status;
    L65:
        r17.questions_status = r3;
        if (r16 != null) goto L68;
        return null;
    L68:
        return r16.runPredict(r11, r17);
    L61:
        r22 = 1;
        goto L62
    L57:
        r21 = 1;
        goto L58
    L53:
        r20 = 1;
        goto L54
    L49:
        r19 = 1;
        goto L50
    L44:
        if (r15 == false) goto L46;
        String r23 = String.valueOf(r10.getExternalCacheDir());
        this.a = null;
        this.a = InferenceHelper.initModel(r10.getAssets(), 1, 0, r23, this.b);
    L40:
        r15 = true;
        goto L41
    L29:
        if (r0.questions_status != r1.questions_status) goto L31;
        r2 = true;
        goto L32
    L23:
        if (r0.scene_status != r1.scene_status) goto L25;
        r12 = true;
        goto L26
    L17:
        if (r0.orientation_status != r1.orientation_status) goto L19;
        r8 = true;
        goto L20
    L11:
        if (r0.dark_status != r1.dark_status) goto L13;
        r6 = true;
        goto L14
    L5:
        if (r0.blur_status != r1.blur_status) goto L7;
        r4 = true;
        goto L8
    }
}
