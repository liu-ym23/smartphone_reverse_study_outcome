package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.imagex.common.AsyncWorker;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageTrackHandler {
    public static final WeakHashMap<r, u> a = null;
    public static final ECImageTrackHandler b = null;

    public ECImageTrackHandler() {
    }

    static {
        b = new ECImageTrackHandler();
        a = new WeakHashMap();
    }

    public final u b(Object r10) {
        if ((r10 instanceof r) == false) goto L17;
        WeakHashMap<r, u> r0 = a;
        u r1 = r0.get(r10);
        if (r1 != null) goto L16;
        monitor-enter(this);
        r1 = r0.get(r10);     // Catch: Throwable -> L13
        if (r1 != null) goto L10;
        r1 = new u((r) r10);     // Catch: Throwable -> L13
        r0.put(r10, r1);     // Catch: Throwable -> L13
    L10:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
    L13:
        th = move-exception;
        throw th;
    L16:
        return r1;
    L17:
        return null;
    }

    public static boolean a(u r10, ImageRequest r11) {
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L6:
        f r13 = (f) r10.y.get(String.valueOf(r12));
        if (r13 != null) goto L10;
        return false;
    L10:
        if (r13.d == null) goto L24;
        Long r14 = r13.b;
        long r1 = -1;
        if (r14 == null) goto L14;
        long r15 = r14.longValue();
    L16:
        if (r15 <= 0) goto L25;
        Long r16 = r13.a;
        if (r16 == null) goto L21;
        r1 = r16.longValue();
    L21:
        if (r1 <= 0) goto L26;
        return true;
    L26:
        return false;
    L25:
        return false;
    L14:
        r15 = -1;
        goto L16
    L24:
        return false;
    L5:
        r12 = 0;
        goto L6
    }

    public static void d(final ImageRequest r12, final u r13) {
        if (r12 == null) goto L5;
        int r1 = r12.hashCode();
    L6:
        String r10 = String.valueOf(r1);
        if (r12 == null) goto L9;
        int r11 = r12.hashCode();
    L10:
        String r14 = String.valueOf(r11);
        f r15 = (f) r13.y.get(r14);
        if (r15 == null) goto L13;
        r13.y.remove(r10);
    L14:
        if (r15 != null) goto L16;
        return;
    L16:
        Long r16 = r15.a;
        if (r16 == null) goto L34;
        final long r17 = r16.longValue();
        Long r18 = r15.b;
        if (r18 == null) goto L35;
        final long r19 = r18.longValue();
        Integer r20 = r15.c;
        if (r20 == null) goto L23;
        final int r21 = r20.intValue();
    L24:
        final g r22 = r15.d;
        if (r22 != null) goto L28;
        return;
    L28:
        if (r19 > 0) goto L30;
        return;
    L30:
        if (r17 <= 0) goto L37;
        Function0<Unit> r23 = new ECImageTrackHandler$onReport$1(r22, r21, r17, r19, r12, r13);
        AsyncWorker.d.b(true, false, r23);
        return;
    L37:
        return;
    L23:
        r21 = -1;
        goto L24
    L35:
        return;
    L34:
        return;
    L13:
        r15 = null;
        goto L14
    L9:
        r11 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public final void c(ImageRequest r10, r r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.d.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if ((r11 instanceof u) == false) goto L8;
        u r16 = (u) r11;
    L10:
        if ((r16 instanceof u) == false) goto L15;
        ECImageTrackHandlerKt.b(r16, r10, r12);
        final g r17 = new g(r13, r14, r15);
        ECImageTrackHandlerKt.a(r16, r10, new ECImageTrackHandlerKt$recordReportData$1(r17));
        if (a(r16, r10) == false) goto L16;
        d(r10, r16);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r16 = b(r11);
        goto L10
    }
}
