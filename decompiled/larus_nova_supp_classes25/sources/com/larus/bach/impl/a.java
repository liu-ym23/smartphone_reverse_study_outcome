package com.larus.bach.impl;

import android.graphics.Bitmap;
import android.os.Build;
import com.bytedance.byted_bach_sdk.BachAlgorithmSystem;
import com.bytedance.byted_bach_sdk.buffer.AlgorithmResultUnion;
import com.bytedance.byted_bach_sdk.buffer.BachAlgorithmOutput;
import com.bytedance.byted_bach_sdk.buffer.BachFaceAlgorithmOutput;
import com.bytedance.byted_bach_sdk.buffer.BachObject;
import com.bytedance.byted_bach_sdk.buffer.SingleFaceResult;
import com.bytedance.byted_bach_sdk.finder.EPResourceFinder;
import com.bytedance.byted_bach_sdk.input.BachBitmapInput;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.vesdk.api.IVeSDK;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements i {
    public final BachAlgorithmSystem a;

    public final float b() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        BachAlgorithmSystem r3 = this.a;     // Catch: Throwable -> L21
        if (r3 == null) goto L6;
        BachAlgorithmOutput r4 = r3.getResult("after_effect_0", 0);     // Catch: Throwable -> L21
    L7:
        if (r4 == null) goto L17;
        HashMap[] r5 = r4.m_dataMap;     // Catch: Throwable -> L21
        if (r5 == null) goto L17;
        HashMap r6 = (HashMap) ArraysKt.getOrNull(r5, 0);     // Catch: Throwable -> L21
        if (r6 == null) goto L17;
        BachObject r7 = (BachObject) r6.get("sharepness_score");     // Catch: Throwable -> L21
        if (r7 == null) goto L17;
        AlgorithmResultUnion r8 = r7.valueResult;     // Catch: Throwable -> L21
        if (r8 == null) goto L17;
        double r9 = r8.doubleVal;     // Catch: Throwable -> L21
    L18:
        FLogger.a.i("BachAvatarDetectAbility", "getClarityScore sharepness:" + r9);     // Catch: Throwable -> L21
        return (float) r9;
    L17:
        r9 = 0.0d;
        goto L18
    L6:
        r4 = null;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Throwable r1 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r1 == null) goto L27;
        FLogger.a.e("BachAvatarDetectAbility", "error info ", r1);
        return 0.0f;
    L27:
        throw new KotlinNothingValueException();
    }

    public final void release() {
        BachAlgorithmSystem r0 = this.a;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public a() {
        AlgorithmResourceManager.Companion r0 = AlgorithmResourceManager.Companion;
        if (r0.isInitialized() == true) goto L7;
        IVeSDK r1 = (IVeSDK) ServiceManager.get().getService(IVeSDK.class);
        if (r1 == null) goto L7;
        r1.e();
    L7:
        EPResourceFinder r2 = new EPResourceFinder(r0.getInstance().getResourceFinder().getNativeResourceFinder());
        BachAlgorithmSystem.BachInitConfig r3 = new BachAlgorithmSystem.BachInitConfig();
        r3.finder = r2;
        AppHost.Companion r4 = AppHost.a;
        r3.applicationName = r4.getApplication().getPackageName();
        r3.deviceName = Build.DEVICE;
        this.a = new BachAlgorithmSystem(r3);
        String[] r5 = i.a;
        Intrinsics.checkNotNullParameter("bach_config.json", "configName");
        InputStream r6 = r4.getApplication().getAssets().open("config/bach_config.json");     // Catch: Exception -> L25
        BufferedReader r7 = new BufferedReader(new InputStreamReader(r6));     // Catch: Throwable -> L20
        String r8 = TextStreamsKt.readText(r7);     // Catch: Throwable -> L15
    L12:
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r6, null);     // Catch: Exception -> L25
    L27:
        BachAlgorithmSystem r9 = this.a;
        if (r9 == null) goto L39;
        r9.initGraph(r8);
        return;
    L39:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Exception -> L25
        throw th;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        r8 = "";
        goto L27
    }

    public static float[] c(double[] r27) {
        double r3 = r27[0];
        double r6 = r27[1];
        double r9 = r27[2];
        double[] r1 = {r3, r6, r9};
        double r4 = Math.sqrt(((r3 * r3) + (r6 * r6)) + (r9 * r9));
        if (r4 >= 1.0E-6d) goto L5;
        double[][] r2 = {new double[]{1.0d, 0.0d, 0.0d}, new double[]{0.0d, 1.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d}};
    L6:
        double r5 = r2[0][0];
        double r10 = r2[1][0];
        double r7 = Math.sqrt((r5 * r5) + (r10 * r10));
        if (r7 >= 1.0E-6d) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        double[] r8 = r2[2];
        double r11 = Math.atan2(r8[1], r8[2]);
        double r12 = Math.atan2(-r2[2][0], r7);
        double r13 = Math.atan2(r2[1][0], r2[0][0]);
    L13:
        double r14 = r13 - 3.141592653589793d;
        if (r14 >= 0.0d) goto L17;
        r14 = r14 + 6.283185307179586d;
    L17:
        return new float[]{(((float) r11) * 180.0f) / 3.1415927f, (((float) r12) * 180.0f) / 3.1415927f, (((float) r14) * 180.0f) / 3.1415927f};
    L12:
        double[] r15 = r2[1];
        r11 = Math.atan2(-r15[2], r15[1]);
        r12 = Math.atan2(-r2[2][0], r7);
        r13 = 0.0d;
        goto L13
    L9:
        r0 = false;
        goto L10
    L5:
        double r16 = r1[0] / r4;
        double r17 = r1[1] / r4;
        double r18 = r1[2] / r4;
        double r19 = Math.cos(r4);
        double r20 = Math.sin(r4);
        double r21 = ((double) 1) - r19;
        double r110 = (r16 * r17) * r21;
        double r111 = r18 * r20;
        double r22 = (r16 * r18) * r21;
        double r23 = r17 * r20;
        double r112 = (r17 * r18) * r21;
        double r24 = r20 * r16;
        r2 = new double[][]{new double[]{r19 + ((r16 * r16) * r21), r110 - r111, r22 + r23}, new double[]{r110 + r111, ((r17 * r17) * r21) + r19, r112 - r24}, new double[]{r22 - r23, r112 + r24, r19 + ((r18 * r18) * r21)}};
        goto L6
    }

    public final zp9.b a(Bitmap r25) {
        Intrinsics.checkNotNullParameter(r25, "bitmap");
        BachBitmapInput r4 = new BachBitmapInput(r25);
        BachAlgorithmSystem r0 = this.a;
        if (r0 == null) goto L5;
        BachAlgorithmSystem.BachErrorCode r1 = r0.execute(r4);
    L6:
        IApplog.Companion r5 = IApplog.a;
        JSONObject r6 = new JSONObject();
        if (r1 != null) goto L9;
    L11:
        int r9 = 0;
    L12:
        r6.put("success", r9);
        if (r1 == null) goto L15;
        int r10 = r1.ordinal();
    L16:
        r6.put("errorCode", r10);
        Unit r11 = Unit.INSTANCE;
        r5.reportEvent("bach_avatar_exec_result", r6);
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("execute res:");
        if (r1 == null) goto L19;
        Integer r2 = Integer.valueOf(r1.ordinal());
    L20:
        r8.append(r2);
        r7.i("BachAvatarDetectAbility", r8.toString());
        BachAlgorithmSystem r3 = this.a;
        if (r3 == null) goto L23;
        BachAlgorithmOutput r12 = r3.getResult("face_0", 0);
    L25:
        if ((r12 instanceof BachFaceAlgorithmOutput) == false) goto L27;
        BachFaceAlgorithmOutput r13 = (BachFaceAlgorithmOutput) r12;
    L28:
        if (r13 == null) goto L32;
        Vector r14 = r13.faceResults;
        if (r14 == null) goto L32;
        int r15 = r14.size();
    L33:
        BachAlgorithmSystem r16 = this.a;
        if (r16 == null) goto L36;
        BachAlgorithmOutput r17 = r16.getResult("facefitting_3d_0", 0);
    L38:
        if (r15 != 1) goto L55;
        if (r17 == null) goto L49;
        HashMap[] r18 = r17.m_dataMap;
        if (r18 == null) goto L49;
        HashMap r19 = (HashMap) ArraysKt.getOrNull(r18, 0);
        if (r19 == null) goto L49;
        BachObject r20 = (BachObject) r19.get("rvec");
        if (r20 == null) goto L49;
        AlgorithmResultUnion r21 = r20.valueResult;
        if (r21 == null) goto L49;
        double[] r22 = r21.vecFVal;
    L50:
        if (r22 != null) goto L52;
    L54:
        float[] r23 = {0.0f, 0.0f, 0.0f};
    L56:
        float r110 = r23[1];
        float r111 = r23[0];
        float r112 = b();
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L117
        if (r15 <= 0) goto L116;
        if (r15 > 1) goto L116;
        float r26 = b();     // Catch: Throwable -> L117
        BachAlgorithmSystem r113 = this.a;     // Catch: Throwable -> L117
        if (r113 == null) goto L64;
        BachAlgorithmOutput r114 = r113.getResult("face_0", 0);     // Catch: Throwable -> L117
    L66:
        if ((r114 instanceof BachFaceAlgorithmOutput) == false) goto L68;
        BachFaceAlgorithmOutput r115 = (BachFaceAlgorithmOutput) r114;     // Catch: Throwable -> L117
    L69:
        if (r115 == null) goto L75;
        Vector r27 = r115.faceResults;     // Catch: Throwable -> L117
        if (r27 == null) goto L75;
        SingleFaceResult r28 = (SingleFaceResult) r27.get(0);     // Catch: Throwable -> L117
        if (r28 == null) goto L75;
        float r29 = r28.occlusion_prob;     // Catch: Throwable -> L117
    L76:
        BachAlgorithmSystem r116 = this.a;     // Catch: Throwable -> L117
        if (r116 == null) goto L79;
        BachAlgorithmOutput r117 = r116.getResult("face_quality_0", 0);     // Catch: Throwable -> L117
    L80:
        if (r117 == null) goto L90;
        HashMap[] r118 = r117.m_dataMap;     // Catch: Throwable -> L117
        if (r118 == null) goto L90;
        HashMap r119 = (HashMap) ArraysKt.getOrNull(r118, 0);     // Catch: Throwable -> L117
        if (r119 == null) goto L90;
        BachObject r120 = (BachObject) r119.get("quality_score");     // Catch: Throwable -> L117
        if (r120 == null) goto L90;
        AlgorithmResultUnion r121 = r120.valueResult;     // Catch: Throwable -> L117
        if (r121 == null) goto L90;
        double r122 = r121.doubleVal;     // Catch: Throwable -> L117
    L91:
        BachAlgorithmSystem r123 = this.a;     // Catch: Throwable -> L117
        if (r123 == null) goto L94;
        BachAlgorithmOutput r124 = r123.getResult("facefitting_3d_0", 0);     // Catch: Throwable -> L117
    L95:
        if (r124 == null) goto L105;
        HashMap[] r125 = r124.m_dataMap;     // Catch: Throwable -> L117
        if (r125 == null) goto L105;
        HashMap r126 = (HashMap) ArraysKt.getOrNull(r125, 0);     // Catch: Throwable -> L117
        if (r126 == null) goto L105;
        BachObject r127 = (BachObject) r126.get("rvec");     // Catch: Throwable -> L117
        if (r127 == null) goto L105;
        AlgorithmResultUnion r128 = r127.valueResult;     // Catch: Throwable -> L117
        if (r128 == null) goto L105;
        double[] r129 = r128.vecFVal;     // Catch: Throwable -> L117
    L106:
        if (r129 == null) goto L116;
        if (r129.length < 3) goto L116;
        float[] r30 = c(r129);     // Catch: Throwable -> L117
        String r210 = "face_0";
        float r31 = (float) ((((r122 + ((double) r26)) + ((double) r29)) - ((double) Math.abs(r30[1] / 90.0f))) - ((double) Math.abs(r30[0] / 90.0f)));     // Catch: Throwable -> L114
        r7.i("BachAvatarDetectAbility", "getIPAScore ipaScore:" + r31);     // Catch: Throwable -> L114
        float r130 = r31;
        int r32 = 1;
    L123:
        if (r15 > r32) goto L140;
        if (r15 <= 0) goto L140;
        BachAlgorithmSystem r33 = this.a;
        if (r33 == null) goto L129;
        int r34 = 0;
        BachAlgorithmOutput r35 = r33.getResult("face_verify_0", 0);
    L130:
        if (r35 == null) goto L140;
        HashMap[] r36 = r35.m_dataMap;
        if (r36 == null) goto L140;
        HashMap r37 = (HashMap) ArraysKt.getOrNull(r36, r34);
        if (r37 == null) goto L140;
        BachObject r38 = (BachObject) r37.get("feature");
        if (r38 == null) goto L140;
        AlgorithmResultUnion r39 = r38.valueResult;
        if (r39 == null) goto L140;
        double[] r40 = r39.vecFVal;
    L142:
        if (r15 > 1) goto L161;
        if (r15 <= 0) goto L161;
        BachAlgorithmSystem r41 = this.a;
        if (r41 == null) goto L148;
        BachAlgorithmOutput r42 = r41.getResult("face_quality_0", 0);
    L149:
        if (r42 == null) goto L159;
        HashMap[] r43 = r42.m_dataMap;
        if (r43 == null) goto L159;
        HashMap r44 = (HashMap) ArraysKt.getOrNull(r43, 0);
        if (r44 == null) goto L159;
        BachObject r45 = (BachObject) r44.get("quality_score");
        if (r45 == null) goto L159;
        AlgorithmResultUnion r46 = r45.valueResult;
        if (r46 == null) goto L159;
        double r47 = r46.doubleVal;
    L160:
        FLogger.a.i("BachAvatarDetectAbility", "getFaceQualityScore faceQualityScore:" + r47);
        float r131 = (float) r47;
    L162:
        if (r15 > 0) goto L164;
    L182:
        float r132 = 0.0f;
    L184:
        return new zp9.b(r15, r112, r130, r40, r131, r132, r110, r111);
    L164:
        if (r15 > 1) goto L182;
        BachAlgorithmSystem r48 = this.a;
        if (r48 == null) goto L169;
        int r49 = 0;
        BachAlgorithmOutput r50 = r48.getResult(r210, 0);
    L171:
        if ((r50 instanceof BachFaceAlgorithmOutput) == false) goto L173;
        BachFaceAlgorithmOutput r51 = (BachFaceAlgorithmOutput) r50;
    L174:
        if (r51 == null) goto L180;
        Vector r52 = r51.faceResults;
        if (r52 == null) goto L180;
        SingleFaceResult r53 = (SingleFaceResult) CollectionsKt.getOrNull(r52, r49);
        if (r53 == null) goto L180;
        float r54 = r53.occlusion_prob;
    L181:
        FLogger.a.i("BachAvatarDetectAbility", "getOcclusionScore faceOcclusion:" + r54);
        r132 = r54;
    L180:
        r54 = 0.0f;
        goto L181
    L173:
        r51 = null;
        goto L174
    L169:
        r49 = 0;
        r50 = null;
    L159:
        r47 = 0.0d;
        goto L160
    L148:
        r42 = null;
    L161:
        r131 = 0.0f;
        goto L162
    L129:
        r34 = 0;
        r35 = null;
    L140:
        r40 = null;
    L114:
        th = th;
    L119:
        Result.Companion r55 = Result.Companion;
        Throwable r56 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r56 == null) goto L186;
        FLogger.a.e("BachAvatarDetectAbility", "error info ", r56);
    L122:
        r32 = 1;
        r130 = 0.0f;
        goto L123
    L186:
        throw new KotlinNothingValueException();
    L105:
        r129 = null;
        goto L106
    L94:
        r124 = null;
    L90:
        r122 = 0.0d;
        goto L91
    L79:
        r117 = null;
    L75:
        r29 = 0.0f;
        goto L76
    L68:
        r115 = null;
        goto L69
    L64:
        r114 = null;
    L116:
        r210 = "face_0";
    L117:
        th = th;
        r210 = "face_0";
        goto L119
    L52:
        if (r22.length < 3) goto L54;
        r23 = c(r22);
    L49:
        r22 = null;
        goto L50
    L55:
        r23 = new float[]{0.0f, 0.0f, 0.0f};
        goto L56
    L36:
        r17 = null;
    L32:
        r15 = 0;
        goto L33
    L27:
        r13 = null;
        goto L28
    L23:
        r12 = null;
        goto L25
    L19:
        r2 = null;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L9:
        if (r1.ordinal() != 0) goto L11;
        r9 = 1;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
