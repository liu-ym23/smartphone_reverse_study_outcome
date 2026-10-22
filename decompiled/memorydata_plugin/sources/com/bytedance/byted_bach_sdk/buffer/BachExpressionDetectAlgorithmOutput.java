package com.bytedance.byted_bach_sdk.buffer;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class BachExpressionDetectAlgorithmOutput extends BachAlgorithmOutput {
    public Vector<SingleExpressionDetectResult> expressionDetectResults;

    public BachExpressionDetectAlgorithmOutput(HashMap<String, BachObject>[] r13) {
        this.expressionDetectResults = new Vector();
        int r0 = r13.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L20;
        HashMap<String, BachObject> r3 = r13[r2];
        SingleExpressionDetectResult r4 = new SingleExpressionDetectResult();
        r4.ID = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get(OaidModel.KEY_ID), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.age = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("age"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.boy_prob = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("boy_prob"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        if (((BachObject) ZeusTransformUtils.preCheckCast(r3.get("gender"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val >= 0) goto L9;
        SingleExpressionDetectResult.FaceGender r5 = SingleExpressionDetectResult.FaceGender.UNKNOWN;
    L7:
        r4.gender = r5;
        r4.attractive = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("attractive"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.happy_score = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("happy_score"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        if (((BachObject) ZeusTransformUtils.preCheckCast(r3.get("exp_type"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val >= 0) goto L15;
        SingleExpressionDetectResult.FaceExpression r6 = SingleExpressionDetectResult.FaceExpression.UNKNOWN;
    L16:
        r4.exp_type = r6;
        Vector<Float> r7 = new Vector();
        float[] r8 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("exp_probs"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.vecFVal;
        int r9 = r8.length;
        int r10 = 0;
    L17:
        if (r10 >= r9) goto L19;
        r7.add(Float.valueOf(r8[r10]));
        r10 = r10 + 1;
        goto L17
    L19:
        r4.exp_probs = r7;
        r4.real_face_prob = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("real_face_prob"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.quality = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("quality"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        this.expressionDetectResults.add(r4);
        r2 = r2 + 1;
        goto L3
    L15:
        r6 = SingleExpressionDetectResult.FaceExpression.values()[(int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("exp_type"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val];
        goto L16
    L9:
        if (((BachObject) ZeusTransformUtils.preCheckCast(r3.get("gender"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val != 1) goto L11;
        r5 = SingleExpressionDetectResult.FaceGender.MALE;
        goto L7
    L11:
        r5 = SingleExpressionDetectResult.FaceGender.FEMALE;
        goto L7
    }
}
