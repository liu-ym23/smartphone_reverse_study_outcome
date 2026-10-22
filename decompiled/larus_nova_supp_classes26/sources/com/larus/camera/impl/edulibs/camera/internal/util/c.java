package com.larus.camera.impl.edulibs.camera.internal.util;

import android.graphics.Bitmap;
import android.util.Base64;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.camera.api.vlm.VLMFileDataType;
import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.camera.api.vlm.VLMSceneType;
import com.larus.camera.impl.edulibs.camera.internal.idl.BusinessType;
import com.larus.camera.impl.edulibs.camera.internal.idl.DetectionType;
import com.larus.camera.impl.edulibs.camera.internal.idl.ProcessType;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import com.larus.platform.service.z2;
import ix8.d;
import ix8.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import ox8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final c a = null;
    public static String b;
    public static final Lazy c = null;
    public static NetworkClient d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SceneType.values().length];
            r0[SceneType.Doubao_Education_Camera_Qa.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SceneType.Doubao_Live_Tutor.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SceneType.Doubao_Education_Camera_Homework_Correction.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = "";
        c = LazyKt.lazy(new b());
    }

    public static e a(Bitmap r33, boolean r34, DetectionType r35, Integer r36, Long r37, int r38, SceneType r39, boolean r40) {
        Integer r10 = r36;
        Intrinsics.checkNotNullParameter(r33, "bitmap");
        boolean r13 = true;
        if (z2.a.enableEduVlmMigration() == false) goto L87;
        List r18 = CollectionsKt.listOf(new ix8.b(r33, VLMFileDataType.IMAGE));
        VLMSceneType r19 = VLMSceneType.TAKE_PICTURE;
        ix8.a r20 = new ix8.a(Long.valueOf(com.larus.camera.impl.edulibs.camera.a.b.a()), 720.0f, r38, false, r40, r34);
        if (r39 == null) goto L7;
        Map r0 = MapsKt.mapOf(TuplesKt.to("eduSceneType", Long.valueOf(r39.getValue())));
    L8:
        if (r0 != null) goto L10;
        r0 = MapsKt.emptyMap();
    L10:
        Map r21 = r0;
        if (r39 != null) goto L13;
        int r1 = -1;
    L14:
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L19;
        VLMIntentTrackSource r22 = null;
    L22:
        ix8.c r2 = new ix8.c(r18, r19, r20, r21, r22);
        com.larus.camera.impl.edulibs.camera.a.b r3 = com.larus.camera.impl.edulibs.camera.a.c;
        StringBuilder r4 = new StringBuilder("requestCloudDetection: ");
        r4.append(r33.getWidth());
        r4.append(", ");
        r4.append(r33.getHeight());
        r4.append(", enableCrop=");
        r4.append(r34);
        r4.append(", detectionType=");
        if (r35 == null) goto L25;
        Integer r5 = Integer.valueOf(r35.getValue());
    L26:
        r4.append(r5);
        r4.append(", imageOrientation=");
        r4.append(r10);
        r4.append(", detectTime=");
        r4.append(r37);
        r4.append(", sceneType=");
        if (r39 == null) goto L29;
        Integer r6 = Integer.valueOf(r39.getValue());
    L30:
        r4.append(r6);
        r3.i("EduNetUtils", r4.toString());
        d r7 = (d) BuildersKt.runBlocking$default(null, new EduNetUtils$requestCloudDetectionByVlm$detectResult$1(r2, null), 1, null);
        if ((r7 instanceof d.b) == false) goto L33;
        d.b r8 = (d.b) r7;
    L34:
        if (r8 != null) goto L56;
        com.larus.camera.impl.edulibs.camera.a.b r9 = com.larus.camera.impl.edulibs.camera.a.c;
        StringBuilder r11 = new StringBuilder("requestCloudDetection failed: status=");
        if (r7 == null) goto L38;
        ix8.e r12 = r7.b();
    L40:
        if ((r12 instanceof ix8.e.d) == false) goto L43;
        String r14 = "success";
    L53:
        r11.append(r14);
        r9.e("EduNetUtils", r11.toString(), null);
        return new e(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    L43:
        if ((r12 instanceof ix8.e.c) == false) goto L46;
        r14 = "not_detected";
        goto L53
    L46:
        if ((r12 instanceof ix8.e.a) == false) goto L49;
        r14 = "timeout";
        goto L53
    L49:
        if ((r12 instanceof ix8.e.b) == false) goto L51;
        r14 = "failure:" + ((ix8.e.b) r12).a;
        goto L53
    L51:
        if (r12 != null) goto L55;
        r14 = "service_unavailable";
        goto L53
    L55:
        throw new NoWhenBranchMatchedException();
    L38:
        r12 = null;
        goto L40
    L56:
        String r15 = r8.g;
        if (r15 != null) goto L59;
    L62:
        if (r13 == false) goto L145;
        com.larus.camera.impl.edulibs.camera.a.c.i("EduNetUtils", "requestCloudDetection empty edu_data, requestId=" + r8.i);
        String r16 = r8.i;
        String r17 = r8.j;
        f r23 = r8.h;
        if (r23 == null) goto L66;
        Boolean r30 = r23.a();
    L156:
        return new e(null, null, null, null, null, null, null, null, null, null, null, r16, r17, r30, 2047);
    L66:
        r30 = null;
        goto L156
    L145:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L70
        Object r25 = Result.constructor-impl((ox8.a) ((Gson) c.getValue()).fromJson(r15, ox8.a.class));     // Catch: Throwable -> L70
    L73:
        if (Result.isFailure-impl(r25) == false) goto L75;
        r25 = null;
    L75:
        ox8.a r26 = (ox8.a) r25;
        if (r26 == null) goto L82;
        e r27 = ox8.b.a(r26);
        String r28 = r8.i;
        String r29 = r8.j;
        f r31 = r8.h;
        if (r31 == null) goto L80;
        Boolean r110 = r31.a();
    L157:
        return e.a(r27, null, r28, r29, r110, 2047);
    L80:
        r110 = null;
        goto L157
    L82:
        String r111 = r8.i;
        String r32 = r8.j;
        f r41 = r8.h;
        if (r41 == null) goto L85;
        Boolean r112 = r41.a();
    L158:
        return new e(null, null, null, null, null, null, null, null, null, null, null, r111, r32, r112, 2047);
    L85:
        r112 = null;
    L70:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L59:
        if (r15.length() == 0) goto L62;
        r13 = false;
        goto L62
    L33:
        r8 = null;
        goto L34
    L29:
        r6 = null;
        goto L30
    L25:
        r5 = null;
        goto L26
    L19:
        VLMIntentTrackSource r43 = VLMIntentTrackSource.EDU_CAMERA_HOMEWORK;
    L21:
        r22 = r43;
    L20:
        r43 = VLMIntentTrackSource.EDU_CAMERA_QA;
        goto L21
    L13:
        r1 = a.a[r39.ordinal()];
        goto L14
    L7:
        r0 = null;
        goto L8
    L87:
        int r44 = com.larus.camera.impl.edulibs.camera.internal.util.a.a;
        ByteArrayOutputStream r45 = new ByteArrayOutputStream();     // Catch: Throwable -> L95 IOException -> L97
    L153:
        r33.compress(Bitmap.CompressFormat.JPEG, r38, r45);     // Catch: Throwable -> L91 IOException -> L93
        r45.flush();     // Catch: Throwable -> L91 IOException -> L93
        r45.close();     // Catch: Throwable -> L91 IOException -> L93
        String r46 = Base64.encodeToString(r45.toByteArray(), 2);     // Catch: Throwable -> L91 IOException -> L93
    L90:
        ByteArrayOutputStream r310 = r45;
        String r47 = r46;
        r310.flush();     // Catch: IOException -> L105
        r310.close();     // Catch: IOException -> L105
    L107:
        r46 = r47;
    L108:
        if (r34 == false) goto L110;
        ArrayList r48 = CollectionsKt.arrayListOf(new ProcessType[]{ProcessType.Orientation, ProcessType.Detection});
    L111:
        ArrayList r49 = r48;
        ArrayList r50 = CollectionsKt.arrayListOf(new lx8.b[]{new lx8.b(r46, 11)});
        if (r39 == SceneType.Doubao_Education_Camera_Homework_Correction) goto L114;
        boolean r51 = true;
    L115:
        if (r35 == null) goto L117;
        Integer r52 = Integer.valueOf(r35.getValue());
    L118:
        if (r10 != null) goto L120;
    L128:
        Long r113 = null;
    L129:
        lx8.c r114 = new lx8.c("", r50, Boolean.valueOf(r51), r52, r49, BusinessType.Doubao, r39, new lx8.a(r113, r37, 60), 8);
        com.larus.camera.impl.edulibs.camera.a.c.i("EduNetUtils", "requestCloudDetectionByHippo: " + r33.getWidth() + ", " + r33.getHeight() + ", data size=" + r46.length());
        StringBuilder r53 = new StringBuilder();
        r53.append(b);
        r53.append("/hippo/turing/qs/v1/algorithm_detection");
        String r54 = r53.toString();
        NetworkClient r55 = d;
        if (r55 != null) goto L132;
        r55 = NetworkClient.getDefault();
    L132:
        Lazy r56 = c;
        String r57 = r55.post(r54, GsonProtectorUtils.toJson((Gson) r56.getValue(), r114).getBytes(Charsets.UTF_8), false, "application/json; charset=utf-8", true);
        com.larus.camera.impl.edulibs.camera.a.c.i("EduNetUtils", "do post: " + r54 + ", resp=" + r57);
        return (e) GsonProtectorUtils.fromJson((Gson) r56.getValue(), r57, e.class);
    L120:
        if (r36.intValue() >= 0) goto L123;
        r13 = false;
    L123:
        if (r13 == true) goto L126;
        r10 = null;
    L126:
        if (r10 == null) goto L128;
        r113 = Long.valueOf(r10.intValue());
        goto L129
    L117:
        r52 = null;
        goto L118
    L114:
        r51 = false;
        goto L115
    L110:
        r48 = CollectionsKt.arrayListOf(new ProcessType[]{ProcessType.Orientation});
    L105:
        e = move-exception;
        e.printStackTrace();
        goto L107
    L93:
        e = e;
    L149:
        e.printStackTrace();     // Catch: Throwable -> L134
        r46 = "";
        if (r45 == null) goto L108;
    L134:
        th = th;
        ByteArrayOutputStream r115 = r45;
    L136:
        Throwable r58 = th;
        r45 = r115;
    L137:
        if (r45 == null) goto L159;
        r45.flush();     // Catch: IOException -> L140
        r45.close();     // Catch: IOException -> L140
        throw r58;
    L140:
        e = move-exception;
        e.printStackTrace();
        throw r58;
    L159:
        throw r58;
    L91:
        th = move-exception;
        r58 = th;
    L97:
        e = e;
        r45 = null;
    L95:
        th = th;
        r115 = null;
        goto L136
    }
}
