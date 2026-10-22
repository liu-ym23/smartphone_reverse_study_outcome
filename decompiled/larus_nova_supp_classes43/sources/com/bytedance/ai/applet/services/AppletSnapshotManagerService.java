package com.bytedance.ai.applet.services;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletSnapshotManagerService {
    public static final AppletSnapshotManagerService a = null;
    public static final Object b = null;
    public static final LinkedHashMap<String, b> c = null;
    public static final Handler d = null;
    public static final c e = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/services/AppletSnapshotManagerService$SnapshotTooLargeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "<init>", "(Ljava/lang/String;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SnapshotTooLargeException extends RuntimeException {
        public SnapshotTooLargeException(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            super(r10);
        }
    }

    public static final class a extends ByteArrayOutputStream {
        public final int a;

        public a() {
            this.a = 8388608;
        }

        public final void a(int r10) {
            if ((((long) ((ByteArrayOutputStream) this).count) + ((long) r10)) > this.a) goto L6;
            return;
        L6:
            throw new SnapshotTooLargeException("compressed snapshot exceeds " + this.a + " bytes");
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
        public final void write(int r10) {
            a(1);
            super.write(r10);
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
        public final void write(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "buffer");
            a(r12);
            super.write(r10, r11, r12);
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final int f;
        public final long g;

        public b(String r10, String r11, String r12, String r13, int r14, int r15, long r16) {
            Intrinsics.checkNotNullParameter(r10, "snapshotId");
            Intrinsics.checkNotNullParameter(r12, "imageBase64");
            Intrinsics.checkNotNullParameter(r13, "mimeType");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
        }
    }

    public AppletSnapshotManagerService() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ai.applet.services.c] */
    static {
        a = new AppletSnapshotManagerService();
        b = new Object();
        c = new LinkedHashMap();
        d = new Handler(Looper.getMainLooper());
        e = new c();
    }

    public static void h() {
        d.removeCallbacks(e);
        Iterator<T> r0 = c.values().iterator();
        if (r0.hasNext() == true) goto L5;
        Long r1 = null;
    L12:
        if (r1 == null) goto L20;
        long r10 = r1.longValue();
        com.bytedance.ai.applet.base.log.b r11 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "scheduleNextExpirationLocked: earliestExpireAtMillis=" + r10);
        d.postAtTime(e, r10);
        return;
    L20:
        return;
    L5:
        Long r12 = Long.valueOf(((b) r0.next()).g + 30000);
    L7:
        if (r0.hasNext() == false) goto L11;
        Long r13 = Long.valueOf(((b) r0.next()).g + 30000);
        if (r12.compareTo(r13) <= 0) goto L7;
        r12 = r13;
        goto L7
    L11:
        r1 = r12;
        goto L12
    }

    public static void g() {
        long r0 = SystemClock.uptimeMillis();
        Iterator<Map.Entry<String, b>> r10 = c.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        b r11 = r10.next().getValue();
        if ((r0 - r11.g) < 30000) goto L4;
        com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "removeExpiredLocked: snapshotId=" + r11.a + ", createdAtMillis=" + r11.g);
        r10.remove();
        goto L4
    }

    public static void f(b r10) {
        Object r0 = b;
        monitor-enter(r0);
        g();     // Catch: Throwable -> L20
        c.remove(r10.a);     // Catch: Throwable -> L20
    L5:
        LinkedHashMap<String, b> r1 = c;     // Catch: Throwable -> L20
        if (r1.size() < 10) goto L8;
        r1.remove((String) ((Map.Entry) CollectionsKt.first(r1.entrySet())).getKey());     // Catch: Throwable -> L20
    L8:
        LinkedHashMap<String, b> r11 = c;     // Catch: Throwable -> L20
        if ((!r11.isEmpty()) == false) goto L17;
        Iterator<T> r12 = r11.values().iterator();     // Catch: Throwable -> L20
        long r13 = 0;
    L12:
        if (r12.hasNext() == false) goto L15;
        r13 = r13 + (((long) ((b) r12.next()).c.length()) * 2);     // Catch: Throwable -> L20
        goto L12
    L15:
        if ((r13 + (((long) r10.c.length()) * 2)) <= 25165824) goto L17;
        LinkedHashMap<String, b> r14 = c;     // Catch: Throwable -> L20
        r14.remove((String) ((Map.Entry) CollectionsKt.first(r14.entrySet())).getKey());     // Catch: Throwable -> L20
    L17:
        c.put(r10.a, r10);     // Catch: Throwable -> L20
        h();     // Catch: Throwable -> L20
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean a(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "snapshotId");
        Intrinsics.checkNotNullParameter(r14, "messageId");
        if (StringsKt.isBlank(r13) == false) goto L7;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "associate failed: snapshotId is blank", null);
        return false;
    L7:
        if (StringsKt.isBlank(r14) == false) goto L10;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "associate failed: messageId is blank", null);
        return false;
    L10:
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "associate: snapshotId=" + r13 + ", messageId=" + r14);
        Object r1 = b;
        monitor-enter(r1);
        g();     // Catch: Throwable -> L21
        LinkedHashMap<String, b> r10 = c;     // Catch: Throwable -> L21
        b r11 = r10.get(r13);     // Catch: Throwable -> L21
        if (r11 != null) goto L17;
        h();     // Catch: Throwable -> L21
        monitor-exit(r1);
        return false;
    L17:
        Intrinsics.checkNotNullParameter(r14, "messageId");     // Catch: Throwable -> L21
        r10.put(r13, new b(r11.a, r14, r11.c, r11.d, r11.e, r11.f, r11.g));     // Catch: Throwable -> L21
        h();     // Catch: Throwable -> L21
        monitor-exit(r1);
        return true;
    L21:
        th = move-exception;
        throw th;
    }

    public static d b(View r22, String r23) {
        Intrinsics.checkNotNullParameter(r22, "view");
        Intrinsics.checkNotNullParameter(r23, "snapshotId");
        if (StringsKt.isBlank(r23) == false) goto L7;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: snapshotId is blank", null);
        return null;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: must be called on the main thread", null);
        return null;
    L10:
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: snapshotId=" + r23);
        Bitmap r15 = e(r22, r23);     // Catch: Throwable -> L27
        if (r15 != null) goto L41;
        StringBuilder r0 = new StringBuilder("capture: finish, snapshotId=");
    L21:
        r0.append(r23);
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", r0.toString());
        return null;
    L41:
        byte[] r10 = d(r15, r23);     // Catch: Throwable -> L23
        if (r10 != null) goto L18;
        r15.recycle();
        r0 = new StringBuilder("capture: finish, snapshotId=");
        goto L21
    L18:
        if (r10.length <= 8388608) goto L25;
        com.bytedance.ai.applet.base.log.a.d("AppletSnapshotManagerService", "capture skipped: snapshot is too large, snapshotId=" + r23 + ", bytes=" + r10.length, null);     // Catch: Throwable -> L23
        r15.recycle();
        r0 = new StringBuilder("capture: finish, snapshotId=");
        goto L21
    L25:
        b r11 = new b(r23, null, Base64.encodeToString(r10, 2), "image/webp", r15.getWidth(), r15.getHeight(), SystemClock.uptimeMillis());     // Catch: Throwable -> L23
        f(r11);     // Catch: Throwable -> L23
        d r12 = new d(r11.a, r11.d, r11.c, r11.e, r11.f);     // Catch: Throwable -> L23
        r15.recycle();
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: finish, snapshotId=".concat(r23));
        return r12;
    L23:
        th = th;
    L42:
        com.bytedance.ai.applet.base.log.b r13 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L34
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed, snapshotId=" + r23, th);     // Catch: Throwable -> L34
        if (r15 == null) goto L32;
        r15.recycle();
    L32:
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: finish, snapshotId=" + r23);
        return null;
    L34:
        th = move-exception;
        if (r15 == null) goto L37;
        r15.recycle();
    L37:
        com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: finish, snapshotId=" + r23);
        throw th;
    L27:
        th = th;
        r15 = null;
        goto L42
    }

    public static void c(View r10, List r11) {
        if (r10.getVisibility() == 0) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.getTag(2131363169), Boolean.TRUE) == false) goto L10;
        ((ArrayList) r11).add(r10);
        return;
    L10:
        if ((r10 instanceof ViewGroup) == false) goto L14;
        ViewGroup r12 = (ViewGroup) r10;
        int r0 = r12.getChildCount();
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L16;
        c(r12.getChildAt(r1), r11);
        r1 = r1 + 1;
        goto L12
    L16:
        return;
    }

    public static byte[] d(Bitmap r10, String r11) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Bitmap.CompressFormat r1 = Bitmap.CompressFormat.WEBP_LOSSLESS;
    L6:
        a r12 = new a();
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L8:
        if (r10.compress(r1, 100, r12) == true) goto L12;
        com.bytedance.ai.applet.base.log.b r13 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L15
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: failed to compress lossless WebP, snapshotId=" + r11, null);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r12, null);
        return null;
    L12:
        byte[] r14 = r12.toByteArray();     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r12, null);
        return r14;
    L5:
        r1 = Bitmap.CompressFormat.WEBP;
        goto L6
    }

    public static Bitmap e(View r10, String r11) {
        int r0 = r10.getWidth();
        int r1 = r10.getHeight();
        if (r0 <= 0) goto L36;
        if (r1 <= 0) goto L36;
        if (r0 > r1) goto L9;
        Pair r12 = TuplesKt.to(448, Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((((double) r1) * 448.0d) / ((double) r0)), 1)));
    L10:
        int r13 = ((Number) r12.component1()).intValue();
        int r14 = ((Number) r12.component2()).intValue();
        Bitmap r15 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);
        Canvas r16 = new Canvas(r15);
        r16.scale(r13 / r0, r14 / r1);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.getTag(2131363169), Boolean.TRUE) == true) goto L29;
        ArrayList r17 = new ArrayList();
        c(r10, r17);
        if (r17.isEmpty() == false) goto L16;
        r10.draw(r16);
        goto L29
    L16:
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L18:
        if (r19.hasNext() == false) goto L38;
        View r20 = (View) r19.next();
        r18.add(TuplesKt.to(r20, Float.valueOf(r20.getAlpha())));
        goto L18
    L38:
        Iterator r21 = r17.iterator();     // Catch: Throwable -> L30
    L22:
        if (r21.hasNext() == false) goto L24;
        ((View) r21.next()).setAlpha(0.0f);     // Catch: Throwable -> L30
        goto L22
    L24:
        r10.draw(r16);     // Catch: Throwable -> L30
        Iterator r22 = r18.iterator();
    L27:
        if (r22.hasNext() == false) goto L29;
        Pair r23 = (Pair) r22.next();
        ((View) r23.component1()).setAlpha(((Number) r23.component2()).floatValue());
    L30:
        th = move-exception;
        Iterator r24 = r18.iterator();
    L33:
        if (r24.hasNext() == false) goto L35;
        Pair r25 = (Pair) r24.next();
        ((View) r25.component1()).setAlpha(((Number) r25.component2()).floatValue());
        goto L33
    L35:
        throw th;
    L29:
        return r15;
    L9:
        r12 = TuplesKt.to(Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((((double) r0) * 448.0d) / ((double) r1)), 1)), 448);
    L36:
        com.bytedance.ai.applet.base.log.b r26 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: view is not laid out, snapshotId=" + r11 + ", size=" + r0 + 'x' + r1, null);
        return null;
    }

    public final Object i(String r10, Continuation<? super Result<e>> r11) {
        if ((r11 instanceof AppletSnapshotManagerService$upload$1) == false) goto L7;
        AppletSnapshotManagerService$upload$1 r0 = (AppletSnapshotManagerService$upload$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        AppletSnapshotManagerService$upload$2 r16 = new AppletSnapshotManagerService$upload$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new AppletSnapshotManagerService$upload$1(this, r11);
        goto L8
    }
}
