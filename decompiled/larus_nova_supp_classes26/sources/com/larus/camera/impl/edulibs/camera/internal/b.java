package com.larus.camera.impl.edulibs.camera.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.SystemClock;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.camera.impl.edulibs.camera.internal.idl.Orientation;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.camera.impl.edulibs.cameraapi.idl.RotatedBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nx8.h;
import nx8.n;
import org.json.JSONObject;
import ox8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static IdentifyDetectionResult a(Context r13, Bitmap r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "bitmap");
        Context r16 = r13.getApplicationContext();
        long r0 = SystemClock.elapsedRealtimeNanos();
        long r2 = GuidePriority.COMMERCE_CREDIT_PRIORITY;
        long r1 = r0 / r2;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        float r5 = Math.min(r14.getWidth(), r14.getHeight());     // Catch: Throwable -> L9
        if (r5 <= 720.0f) goto L6;
        float r6 = 720.0f / r5;     // Catch: Throwable -> L9
        Matrix r11 = new Matrix();     // Catch: Throwable -> L9
        r11.postScale(r6, r6);     // Catch: Throwable -> L9
        Bitmap r7 = Bitmap.createBitmap(r14, 0, 0, r14.getWidth(), r14.getHeight(), r11, true);     // Catch: Throwable -> L9
    L7:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L9
    L11:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L14;
        a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.e("EduImageHelper", "detectIdentifiable resizeBitmap error", r9);
    L14:
        Object r10 = null;
        if (Result.isFailure-impl(r8) == false) goto L17;
        r8 = null;
    L17:
        Bitmap r12 = (Bitmap) r8;
        if (r12 == null) goto L62;
        r14 = r12;
    L62:
        c.a r17 = c.c;     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L23
        Object r18 = Result.constructor-impl(r17.a(r16).a(r16, r14));     // Catch: Throwable -> L23
    L25:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L29;
        a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.e("EduImageHelper", "detectIdentifiable error", r19);
    L29:
        if (Result.isFailure-impl(r18) == true) goto L32;
        r10 = r18;
    L32:
        com.lightning.edu.ei.edgealgorithm.Result r20 = (com.lightning.edu.ei.edgealgorithm.Result) r10;
        long r110 = (SystemClock.elapsedRealtimeNanos() / r2) - r1;
        int r3 = 3;
        if (r20 == null) goto L51;
        boolean r21 = false;
        if (r20.pass == false) goto L38;
    L46:
        r3 = 0;
    L48:
        if (r3 != 0) goto L50;
        r21 = true;
    L50:
        IdentifyDetectionResult r22 = new IdentifyDetectionResult(r21, r3, r110);
    L52:
        nx8.a r23 = com.larus.camera.impl.edulibs.camera.a.d;
        if (r23 == null) goto L60;
        JSONObject r24 = new JSONObject();
        r24.put("cost_time_micro_sec", r110);
        JSONObject r111 = new JSONObject();
        if (r15 == false) goto L58;
        String r112 = "album";
    L59:
        r111.put("scene", r112);
        r23.a("edu_reject_model_cost", r111, r24);
        goto L60
    L58:
        r112 = "take";
    L60:
        com.larus.camera.impl.edulibs.camera.a.c.i("EduImageHelper", "detectIdentifiable: result=" + r22 + ", " + r20);
        return r22;
    L38:
        if (r20.darkLabel != 0) goto L41;
        r3 = 1;
        goto L48
    L41:
        if (r20.blurScore <= r20.blurThreshold) goto L44;
        r3 = 2;
        goto L48
    L44:
        if (r20.sceneLabel == 0) goto L46;
    L51:
        r22 = new IdentifyDetectionResult(r110, 3);
    L23:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L6:
        r7 = r14;
    L9:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static void b(kx8.c r20, ox8.e r21, float r22, int r23, int r24) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Intrinsics.checkNotNullParameter(r21, "response");
        String r5 = "EduImageHelper";
        com.larus.camera.impl.edulibs.camera.a.c.d("EduImageHelper", "updateWithResponse: scaleFactor=" + r22);
        r20.e = r21.i();
        r20.a = r21.c();
        r20.f = r21.d();
        r20.g = r21.a;
        r20.d = r21.f();
        List<List<g>> r3 = r21.g();
        if (r3 == null) goto L9;
        List r4 = CollectionsKt.filterNotNull(r3);
        if (r4 == null) goto L9;
        List r6 = (List) CollectionsKt.firstOrNull(r4);
        if (r6 == null) goto L9;
        List r7 = CollectionsKt.filterNotNull(r6);
    L10:
        List<List<String>> r8 = r21.h();
        if (r8 == null) goto L17;
        List r9 = CollectionsKt.filterNotNull(r8);
        if (r9 == null) goto L17;
        List r10 = (List) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L17;
        List r11 = CollectionsKt.filterNotNull(r10);
    L18:
        List r12 = r7;
        if (r12 != null) goto L21;
    L24:
        boolean r13 = true;
    L25:
        if (r13 == true) goto L125;
        ArrayList r14 = new ArrayList();
        Integer r15 = r21.f();
        int r16 = Orientation.Angle_90.getValue();
        if (r15 != null) goto L30;
    L32:
        int r17 = Orientation.Angle_180.getValue();
        if (r15 != null) goto L36;
    L38:
        int r18 = Orientation.Angle_270.getValue();
        if (r15 != null) goto L42;
    L44:
        float r19 = 0.0f;
    L46:
        if (r19 != 0.0f) goto L48;
        boolean r110 = true;
    L49:
        if (r110 == true) goto L69;
        com.larus.camera.impl.edulibs.camera.a.c.d("EduImageHelper", "rotate rect: degree=" + r19);
        float r111 = (float) r23;
        float r112 = (float) r24;
        RectF r25 = new RectF(0.0f, 0.0f, r111, r112);
        Matrix r26 = new Matrix();
        r26.postRotate(-r19);
        if (r19 != 90.0f) goto L53;
        boolean r113 = true;
    L54:
        if (r113 == false) goto L57;
        r26.postTranslate(0.0f, r112);
    L68:
        r26.mapRect(r25);
        com.larus.camera.impl.edulibs.camera.a.c.d("EduImageHelper", "rotate rect: rotated tmp=" + r25);
    L70:
        Iterator r27 = r7.iterator();
        int r28 = 0;
    L72:
        if (r27.hasNext() == false) goto L124;
        Object r29 = r27.next();
        int r114 = r28 + 1;
        if (r28 >= 0) goto L76;
        CollectionsKt.throwIndexOverflow();
    L76:
        g r30 = (g) r29;
        ox8.c r115 = r30.a();
        if (r115 != null) goto L79;
        Iterator r210 = r27;
        String r116 = r5;
        List r117 = r11;
        ArrayList r1 = r14;
    L123:
        r27 = r210;
        r14 = r1;
        r28 = r114;
        r5 = r116;
        r11 = r117;
        goto L72
    L79:
        ox8.d r118 = r115.b();
        if (r118 == null) goto L82;
        float r119 = (float) r118.a();
    L83:
        ox8.d r120 = r115.b();
        if (r120 == null) goto L86;
        float r0 = (float) r120.b();
    L87:
        ox8.d r2 = r115.a();
        ArrayList r121 = r14;
        if (r2 == null) goto L90;
        float r31 = (float) r2.a();
    L91:
        ox8.d r32 = r115.a();
        if (r32 == null) goto L94;
        float r33 = (float) r32.b();
    L95:
        RectF r122 = new RectF(r119, r0, r31, r33);
        if (r22 <= 0.0f) goto L99;
        float r34 = 1 / r22;
        RectF r35 = new RectF(r122);
        r35.top *= r34;
        r35.left *= r34;
        r35.right *= r34;
        r35.bottom *= r34;
        r122 = r35;
    L99:
        String r36 = "origin=" + r122;
        if (r26 == null) goto L102;
        r26.mapRect(r122);
        a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.d(r5, "rotate rect: rotated " + r36 + ", rect=" + r122);
    L103:
        if (r11 == null) goto L105;
        String r37 = (String) CollectionsKt.getOrNull(r11, r28);
    L106:
        RotatedBox r38 = r30.c();
        if (r38 == null) goto L111;
        Double r39 = r38.getTheta();
        if (r39 == null) goto L111;
        double r40 = r39.doubleValue();
    L112:
        List<ox8.d> r41 = r30.b();
        if (r41 == null) goto L121;
        List r42 = CollectionsKt.filterNotNull(r41);
        if (r42 == null) goto L121;
        List r43 = r42;
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
        Iterator r44 = r43.iterator();
    L118:
        if (r44.hasNext() == false) goto L120;
        ox8.d r124 = (ox8.d) r44.next();
        Iterator r211 = r27;
        double r45 = r22;
        r123.add(new h(r124.a() / r45, r124.b() / r45));
        r27 = r211;
        r44 = r44;
        r5 = r5;
        r11 = r11;
        goto L118
    L120:
        r210 = r27;
        r116 = r5;
        r117 = r11;
    L122:
        kx8.b r46 = new kx8.b(r122, r37, new n(r123, Double.valueOf(r40)));
        r1 = r121;
        r1.add(r46);
    L121:
        r210 = r27;
        r116 = r5;
        r117 = r11;
        r123 = null;
    L111:
        r40 = 0.0d;
        goto L112
    L105:
        r37 = null;
        goto L106
    L102:
        a.getClass();
        com.larus.camera.impl.edulibs.camera.a.c.d(r5, "map rect: " + r36);
        goto L103
    L94:
        r33 = 0.0f;
        goto L95
    L90:
        r31 = 0.0f;
        goto L91
    L86:
        r0 = 0.0f;
        goto L87
    L82:
        r119 = 0.0f;
        goto L83
    L124:
        ArrayList r47 = r14;
    L126:
        r20.b = r47;
        List<Integer> r48 = r21.b();
        if (r48 == null) goto L130;
        int r49 = (Integer) CollectionsKt.firstOrNull(r48);
        if (r49 == null) goto L130;
    L131:
        r20.c = r49;
        return;
    L130:
        r49 = 0;
        goto L131
    L57:
        if (r19 != 180.0f) goto L59;
        boolean r125 = true;
    L60:
        if (r125 == false) goto L63;
        r26.postTranslate(r111, r112);
        goto L68
    L63:
        if (r19 != 270.0f) goto L65;
        boolean r50 = true;
    L66:
        if (r50 == false) goto L68;
        r26.postTranslate(r111, 0.0f);
        goto L68
    L65:
        r50 = false;
        goto L66
    L59:
        r125 = false;
        goto L60
    L53:
        r113 = false;
        goto L54
    L69:
        r26 = null;
        goto L70
    L48:
        r110 = false;
        goto L49
    L42:
        if (r15.intValue() != r18) goto L44;
        r19 = 270.0f;
        goto L46
    L36:
        if (r15.intValue() != r17) goto L38;
        r19 = 180.0f;
        goto L46
    L30:
        if (r15.intValue() != r16) goto L32;
        r19 = 90.0f;
        goto L46
    L125:
        r47 = null;
        goto L126
    L21:
        if (r12.isEmpty() == true) goto L24;
        r13 = false;
    L17:
        r11 = null;
    L9:
        r7 = null;
        goto L10
    }
}
