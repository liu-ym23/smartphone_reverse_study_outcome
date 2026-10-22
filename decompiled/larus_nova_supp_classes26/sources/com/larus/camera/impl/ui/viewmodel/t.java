package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    public static final t a = null;
    public static final int b = 0;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public t() {
    }

    static {
        a = new t();
        ImFileUtil.a.getClass();
        b = ImFileUtil.n();
        c = LazyKt.lazy(new p());
        d = LazyKt.lazy(new q());
        e = LazyKt.lazy(new r());
        f = LazyKt.lazy(new s());
    }

    public static CameraMultiBitmapLruCache d() {
        return (CameraMultiBitmapLruCache) d.getValue();
    }

    public static List f() {
        return (List) c.getValue();
    }

    public static void h() {
        FLogger.a.i("CameraMultiCaptureOutputManager", "onDestroy, size:" + f().size());
        Iterator r0 = f().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        OutputParam r1 = (OutputParam) r0.next();
        i(r1.getImageParam().getMarkedMaskBitmap());
        r1.getImageParam().setMarkedMaskBitmap(null);
        goto L4
    L6:
        d().a.evictAll();
        ((CameraMultiBitmapLruCache) f.getValue()).a.evictAll();
        f().clear();
    }

    public static int e() {
        return f().size();
    }

    public static OutputParam b(OutputParam r3) {
        FLogger.a.i("CameraMultiCaptureOutputManager", "clearMarkedMaskBitmap, param:" + r3);
        if (r3 != null) goto L5;
    L14:
        return null;
    L5:
        if (r3.getPath().length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L14;
        if (r3.isVideo() == true) goto L14;
        return k(r3, null);
    L7:
        r1 = false;
        goto L8
    }

    public static Bitmap c(OutputParam r2) {
        if (r2 != null) goto L4;
    L11:
        FLogger.a.i("CameraMultiCaptureOutputManager", "[getBitmap] output invalid");
        return null;
    L4:
        if (r2.getPath().length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L11;
        return d().a(g(r2));
    L6:
        r0 = false;
        goto L7
    }

    public static String g(OutputParam r3) {
        Intrinsics.checkNotNullParameter(r3, "outputParam");
        if (r3.isVideo() == false) goto L9;
        if (r3.isFromAlbum() == true) goto L9;
        return r3.getPath();
    L9:
        return r3.getPath() + '_' + r3.getCreateTime();
    }

    public static void i(Bitmap r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isRecycled() == true) goto L9;
        ((CameraMultiBitmapLruCache) f.getValue()).b("mark_mask_" + System.currentTimeMillis() + '_' + r4.hashCode(), r4);
        return;
    }

    public final void delete(OutputParam r9) {
        FLogger.a.i("CameraMultiCaptureOutputManager", "[delete] outputParam:" + r9);
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.getPath().length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L30;
        Iterator r1 = f().iterator();
    L12:
        if (r1.hasNext() == false) goto L21;
        OutputParam r2 = (OutputParam) r1.next();
        if (Intrinsics.areEqual(r2.getPath(), r9.getPath()) == false) goto L12;
        if (r2.getCreateTime() != r9.getCreateTime()) goto L12;
        CameraMultiBitmapLruCache r10 = d();
        String r3 = g(r2);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        Bitmap r11 = (Bitmap) r10.a.remove(r3);
        if (r11 == null) goto L20;
        ((CameraMultiBitmapLruCache) e.getValue()).b(String.valueOf(System.currentTimeMillis()), r11);
    L20:
        i(r2.getImageParam().getMarkedMaskBitmap());
        r2.getImageParam().setMarkedMaskBitmap(null);
        r1.remove();
    L21:
        FLogger.a.i("CameraMultiCaptureOutputManager", "[delete] size:" + f().size());
        return;
    L30:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public static OutputParam j(OutputParam r11, Bitmap r12) {
        FLogger r0 = FLogger.a;
        r0.i("CameraMultiCaptureOutputManager", "updateBitmap, param:" + r11 + ", bitmap:" + r12);
        if (r11 != null) goto L5;
    L52:
        return null;
    L5:
        if (r11.getPath().length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L52;
        if (r12 == null) goto L52;
        String r4 = g(r11);
        if (Intrinsics.areEqual(d().a(r4), r12) == false) goto L15;
        r0.i("CameraMultiCaptureOutputManager", "updateBitmap, bitmap not changed");
        return null;
    L15:
        Iterator r1 = f().iterator();
    L17:
        if (r1.hasNext() == false) goto L31;
        Object r2 = r1.next();
        OutputParam r6 = (OutputParam) r2;
        if (r6.getPath().length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L24;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == false) goto L17;
    L32:
        OutputParam r5 = (OutputParam) r2;
        if (r11.isVideo() == true) goto L48;
        if (r5 == null) goto L38;
        ImageParam r13 = r5.getImageParam();
        if (r13 == null) goto L38;
        r13.setBitmapChangedTime(System.currentTimeMillis());
    L38:
        if (r5 == null) goto L42;
        ImageParam r14 = r5.getImageParam();
        if (r14 == null) goto L42;
        Bitmap r15 = r14.getMarkedMaskBitmap();
    L43:
        i(r15);
        if (r5 == null) goto L48;
        ImageParam r16 = r5.getImageParam();
        if (r16 == null) goto L48;
        r16.setMarkedMaskBitmap(null);
    L42:
        r15 = null;
    L48:
        Bitmap r17 = d().b(r4, r12);
        if (r17 == null) goto L51;
        ((CameraMultiBitmapLruCache) e.getValue()).b(String.valueOf(System.currentTimeMillis()), r17);
    L51:
        return r5;
    L24:
        if (Intrinsics.areEqual(r6.getPath(), r11.getPath()) == false) goto L28;
        if (r6.getCreateTime() != r11.getCreateTime()) goto L28;
        r8 = true;
        goto L29
    L21:
        r7 = false;
        goto L22
    L31:
        r2 = null;
        goto L32
    L7:
        r3 = false;
        goto L8
    }

    public static OutputParam k(OutputParam r9, Bitmap r10) {
        Iterator r0 = f().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Object r1 = r0.next();
        OutputParam r2 = (OutputParam) r1;
        boolean r4 = false;
        if (r2.getPath().length() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L15;
        if (Intrinsics.areEqual(r2.getPath(), r9.getPath()) == false) goto L15;
        if (r2.getCreateTime() != r9.getCreateTime()) goto L15;
        r4 = true;
    L15:
        if (r4 == false) goto L4;
    L18:
        OutputParam r5 = (OutputParam) r1;
        if (r5 == null) goto L23;
        ImageParam r11 = r5.getImageParam();
        if (r11 == null) goto L23;
        r11.setBitmapChangedTime(System.currentTimeMillis());
    L23:
        if (r5 == null) goto L29;
        ImageParam r12 = r5.getImageParam();
        if (r12 == null) goto L29;
        Bitmap r6 = r12.getMarkedMaskBitmap();
        r12.setMarkedMaskBitmap(r10);
        if (r6 == r10) goto L29;
        i(r6);
    L29:
        return r5;
    L8:
        r3 = false;
        goto L9
    L17:
        r1 = null;
        goto L18
    }

    public static OutputParam l(OutputParam r10, int r11) {
        if (r10 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Object r3 = null;
        if (r2 == false) goto L11;
        return null;
    L11:
        Iterator r4 = f().iterator();
    L13:
        if (r4.hasNext() == false) goto L31;
        Object r5 = r4.next();
        OutputParam r6 = (OutputParam) r5;
        if (r6.getPath().length() <= 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L28;
        String r8 = r6.getPath();
        if (r10 == null) goto L22;
        String r9 = r10.getPath();
    L24:
        if (Intrinsics.areEqual(r8, r9) == false) goto L28;
        if (r6.getImageParam().getCreatedTime() != r10.getImageParam().getCreatedTime()) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L13;
        r3 = r5;
        goto L31
    L22:
        r9 = null;
    L28:
        r12 = false;
        goto L29
    L17:
        r7 = false;
    L31:
        OutputParam r13 = (OutputParam) r3;
        if (r13 == null) goto L36;
        ImageParam r14 = r13.getImageParam();
        if (r14 == null) goto L36;
        r14.setRotation(r11);
    L36:
        return r13;
    L5:
        if (r10.isVideo() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static void a(OutputParam r11, Bitmap r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "from");
        FLogger.a.i("CameraMultiCaptureOutputManager", "[add], param:" + r11 + ", from:" + r13);
        if (r11 == null) goto L5;
        String r14 = r11.getPath();
    L7:
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        if (r15 == false) goto L15;
        return;
    L15:
        if (r11 == null) goto L44;
        String r16 = g(r11);
        if (r12 != null) goto L19;
    L21:
        Iterator r3 = f().iterator();
        int r4 = 0;
    L23:
        if (r3.hasNext() == false) goto L33;
        OutputParam r5 = (OutputParam) r3.next();
        if (Intrinsics.areEqual(r5.getPath(), r11.getPath()) == true) goto L27;
    L29:
        boolean r6 = false;
    L30:
        if (r6 == true) goto L34;
        r4 = r4 + 1;
    L34:
        if (r4 == (-1)) goto L36;
        FLogger.a.i("CameraMultiCaptureOutputManager", "[add] update current:" + ListProtector.get(f(), r4));
        ListProtector.set(f(), r4, r11);
    L37:
        if (r12 == null) goto L45;
        Bitmap r17 = d().b(r16, r12);
        if (r17 == null) goto L46;
        ((CameraMultiBitmapLruCache) e.getValue()).b(String.valueOf(System.currentTimeMillis()), r17);
        return;
    L46:
        return;
    L45:
        return;
    L36:
        FLogger r0 = FLogger.a;
        r0.i("CameraMultiCaptureOutputManager", "[add] new entry");
        f().add(r11);
        r0.i("CameraMultiCaptureOutputManager", "[add] size:" + f().size());
        goto L37
    L27:
        if (r5.getCreateTime() != r11.getCreateTime()) goto L29;
        r6 = true;
        goto L30
    L33:
        r4 = -1;
        goto L34
    L19:
        if (Intrinsics.areEqual(d().a(r16), r12) == false) goto L21;
        return;
    L44:
        return;
    L9:
        if (r14.length() == 0) goto L12;
        r15 = false;
        goto L13
    L5:
        r14 = null;
        goto L7
    }
}
