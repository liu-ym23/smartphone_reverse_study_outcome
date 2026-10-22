package com.bytedance.byted_bach_sdk.buffer;

import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
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
        r4.ID = (int) r3.get("id").valueResult.int64Val;
        r4.age = (float) r3.get("age").valueResult.doubleVal;
        r4.boy_prob = (float) r3.get("boy_prob").valueResult.doubleVal;
        if (r3.get("gender").valueResult.int64Val >= 0) goto L8;
        r4.gender = SingleExpressionDetectResult.FaceGender.UNKNOWN;
    L12:
        r4.attractive = (float) r3.get("attractive").valueResult.doubleVal;
        r4.happy_score = (float) r3.get("happy_score").valueResult.doubleVal;
        if (r3.get("exp_type").valueResult.int64Val >= 0) goto L15;
        r4.exp_type = SingleExpressionDetectResult.FaceExpression.UNKNOWN;
    L16:
        Vector<Float> r5 = new Vector();
        double[] r6 = r3.get("exp_probs").valueResult.vecFVal;
        int r7 = r6.length;
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L19;
        r5.add(Float.valueOf((float) r6[r8]));
        r8 = r8 + 1;
        goto L17
    L19:
        r4.exp_probs = r5;
        r4.real_face_prob = (float) r3.get("real_face_prob").valueResult.doubleVal;
        r4.quality = (float) r3.get("quality").valueResult.doubleVal;
        this.expressionDetectResults.add(r4);
        r2 = r2 + 1;
        goto L3
    L15:
        r4.exp_type = SingleExpressionDetectResult.FaceExpression.values()[(int) r3.get("exp_type").valueResult.int64Val];
        goto L16
    L8:
        if (r3.get("gender").valueResult.int64Val != 1) goto L10;
        SingleExpressionDetectResult.FaceGender r9 = SingleExpressionDetectResult.FaceGender.MALE;
    L11:
        r4.gender = r9;
        goto L12
    L10:
        r9 = SingleExpressionDetectResult.FaceGender.FEMALE;
        goto L11
    }
}
