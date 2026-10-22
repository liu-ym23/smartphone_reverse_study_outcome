package com.bytedance.byted_bach_sdk.buffer;

import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BachFaceAlgorithmOutput extends BachAlgorithmOutput {
    public Vector<SingleFaceResult> faceResults;

    public BachFaceAlgorithmOutput(HashMap<String, BachObject>[] r15) {
        this.faceResults = new Vector();
        int r0 = r15.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L62;
        HashMap<String, BachObject> r3 = r15[r2];
        SingleFaceResult r4 = new SingleFaceResult();
        r4.m_width = (int) r3.get("m_width").valueResult.int64Val;
        r4.m_height = (int) r3.get("m_height").valueResult.int64Val;
        r4.bbox_x = (float) r3.get("bbox_x").valueResult.doubleVal;
        r4.bbox_y = (float) r3.get("bbox_y").valueResult.doubleVal;
        r4.bbox_width = (float) r3.get("bbox_width").valueResult.doubleVal;
        r4.bbox_height = (float) r3.get("bbox_height").valueResult.doubleVal;
        r4.score = (float) r3.get("score").valueResult.doubleVal;
        r4.points_array = new Vector();
        BachObject[] r5 = r3.get("points_array").vectorResult;
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L8;
        BachObject r9 = r5[r7];
        Vector<Float> r10 = new Vector();
        r10.add(Float.valueOf((float) r9.valueResult.vecFVal[0]));
        r10.add(Float.valueOf((float) r9.valueResult.vecFVal[1]));
        r4.points_array.add(r10);
        r7 = r7 + 1;
        goto L6
    L8:
        Vector<Float> r8 = new Vector();
        double[] r11 = r3.get("visibility_array").valueResult.vecFVal;
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        r8.add(Float.valueOf((float) r11[r13]));
        r13 = r13 + 1;
        goto L9
    L11:
        r4.visibility_array = r8;
        r4.roll = (float) r3.get("roll").valueResult.doubleVal;
        r4.yaw = (float) r3.get("yaw").valueResult.doubleVal;
        r4.pitch = (float) r3.get("pitch").valueResult.doubleVal;
        r4.eye_dist = (float) r3.get("eye_dist").valueResult.doubleVal;
        r4.ID = (int) r3.get("ID").valueResult.int64Val;
        r4.action = r3.get("action").valueResult.int64Val;
        r4.tracking_cnt = r3.get("tracking_cnt").valueResult.int64Val;
        r4.occlusion_prob = (float) r3.get("occlusion_prob").valueResult.doubleVal;
        if (r3.containsKey("mouth_id") == false) goto L21;
        r4.mouth_id = (int) r3.get("mouth_id").valueResult.int64Val;
        r4.mouth_mask_size = (int) r3.get("mouth_mask_size").valueResult.int64Val;
        Vector<Short> r14 = new Vector();
        byte[] r16 = r3.get("mouth_mask").valueResult.byteArrayVal;
        int r17 = r16.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L16;
        r14.add(Short.valueOf((short) (r16[r18] & 255)));
        r18 = r18 + 1;
        goto L14
    L16:
        r4.mouth_mask = r14;
        Vector<Float> r19 = new Vector();
        double[] r20 = r3.get("mouth_warp_mat").valueResult.vecFVal;
        int r21 = r20.length;
        int r22 = 0;
    L17:
        if (r22 >= r21) goto L19;
        r19.add(Float.valueOf((float) r20[r22]));
        r22 = r22 + 1;
        goto L17
    L19:
        r4.mouth_warp_mat = r19;
    L21:
        if (r3.containsKey("teeth_id") == false) goto L30;
        r4.teeth_id = (int) r3.get("teeth_id").valueResult.int64Val;
        r4.teeth_mask_size = (int) r3.get("teeth_mask_size").valueResult.int64Val;
        Vector<Short> r23 = new Vector();
        byte[] r24 = r3.get("teeth_mask").valueResult.byteArrayVal;
        int r25 = r24.length;
        int r26 = 0;
    L23:
        if (r26 >= r25) goto L25;
        r23.add(Short.valueOf((short) (r24[r26] & 255)));
        r26 = r26 + 1;
        goto L23
    L25:
        r4.teeth_mask = r23;
        Vector<Float> r27 = new Vector();
        double[] r28 = r3.get("teeth_warp_mat").valueResult.vecFVal;
        int r29 = r28.length;
        int r30 = 0;
    L26:
        if (r30 >= r29) goto L28;
        r27.add(Float.valueOf((float) r28[r30]));
        r30 = r30 + 1;
        goto L26
    L28:
        r4.teeth_warp_mat = r27;
    L30:
        if (r3.containsKey("face_id") == false) goto L39;
        r4.face_id = (int) r3.get("face_id").valueResult.int64Val;
        r4.face_mask_size = (int) r3.get("face_mask_size").valueResult.int64Val;
        Vector<Short> r31 = new Vector();
        byte[] r32 = r3.get("face_mask").valueResult.byteArrayVal;
        int r33 = r32.length;
        int r34 = 0;
    L32:
        if (r34 >= r33) goto L34;
        r31.add(Short.valueOf((short) (r32[r34] & 255)));
        r34 = r34 + 1;
        goto L32
    L34:
        r4.face_mask = r31;
        Vector<Float> r35 = new Vector();
        double[] r36 = r3.get("face_warp_mat").valueResult.vecFVal;
        int r37 = r36.length;
        int r38 = 0;
    L35:
        if (r38 >= r37) goto L37;
        r35.add(Float.valueOf((float) r36[r38]));
        r38 = r38 + 1;
        goto L35
    L37:
        r4.face_warp_mat = r35;
    L39:
        if (r3.containsKey("eye_count") == false) goto L61;
        r4.eye_count = (int) r3.get("eye_count").valueResult.int64Val;
        r4.eyebrow_count = (int) r3.get("eyebrow_count").valueResult.int64Val;
        r4.lips_count = (int) r3.get("lips_count").valueResult.int64Val;
        r4.iris_count = (int) r3.get("iris_count").valueResult.int64Val;
        r4.eye_left = new Vector();
        BachObject[] r39 = r3.get("eye_left").vectorResult;
        int r40 = r39.length;
        int r41 = 0;
    L41:
        if (r41 >= r40) goto L43;
        BachObject r42 = r39[r41];
        Vector<Float> r110 = new Vector();
        r110.add(Float.valueOf((float) r42.valueResult.vecFVal[0]));
        r110.add(Float.valueOf((float) r42.valueResult.vecFVal[1]));
        r4.eye_left.add(r110);
        r41 = r41 + 1;
        goto L41
    L43:
        r4.eye_right = new Vector();
        BachObject[] r43 = r3.get("eye_right").vectorResult;
        int r44 = r43.length;
        int r45 = 0;
    L44:
        if (r45 >= r44) goto L46;
        BachObject r46 = r43[r45];
        Vector<Float> r111 = new Vector();
        r111.add(Float.valueOf((float) r46.valueResult.vecFVal[0]));
        r111.add(Float.valueOf((float) r46.valueResult.vecFVal[1]));
        r4.eye_right.add(r111);
        r45 = r45 + 1;
        goto L44
    L46:
        r4.eyebrow_left = new Vector();
        BachObject[] r47 = r3.get("eyebrow_left").vectorResult;
        int r48 = r47.length;
        int r49 = 0;
    L47:
        if (r49 >= r48) goto L49;
        BachObject r50 = r47[r49];
        Vector<Float> r112 = new Vector();
        r112.add(Float.valueOf((float) r50.valueResult.vecFVal[0]));
        r112.add(Float.valueOf((float) r50.valueResult.vecFVal[1]));
        r4.eyebrow_left.add(r112);
        r49 = r49 + 1;
        goto L47
    L49:
        r4.eyebrow_right = new Vector();
        BachObject[] r51 = r3.get("eyebrow_right").vectorResult;
        int r52 = r51.length;
        int r53 = 0;
    L50:
        if (r53 >= r52) goto L52;
        BachObject r54 = r51[r53];
        Vector<Float> r113 = new Vector();
        r113.add(Float.valueOf((float) r54.valueResult.vecFVal[0]));
        r113.add(Float.valueOf((float) r54.valueResult.vecFVal[1]));
        r4.eyebrow_right.add(r113);
        r53 = r53 + 1;
        goto L50
    L52:
        r4.lips = new Vector();
        BachObject[] r55 = r3.get("lips").vectorResult;
        int r56 = r55.length;
        int r57 = 0;
    L53:
        if (r57 >= r56) goto L55;
        BachObject r58 = r55[r57];
        Vector<Float> r114 = new Vector();
        r114.add(Float.valueOf((float) r58.valueResult.vecFVal[0]));
        r114.add(Float.valueOf((float) r58.valueResult.vecFVal[1]));
        r4.lips.add(r114);
        r57 = r57 + 1;
        goto L53
    L55:
        r4.left_iris = new Vector();
        BachObject[] r59 = r3.get("left_iris").vectorResult;
        int r60 = r59.length;
        int r61 = 0;
    L56:
        if (r61 >= r60) goto L58;
        BachObject r62 = r59[r61];
        Vector<Float> r115 = new Vector();
        r115.add(Float.valueOf((float) r62.valueResult.vecFVal[0]));
        r115.add(Float.valueOf((float) r62.valueResult.vecFVal[1]));
        r4.left_iris.add(r115);
        r61 = r61 + 1;
        goto L56
    L58:
        r4.right_iris = new Vector();
        BachObject[] r63 = r3.get("right_iris").vectorResult;
        int r64 = r63.length;
        int r65 = 0;
    L59:
        if (r65 >= r64) goto L61;
        BachObject r66 = r63[r65];
        Vector<Float> r67 = new Vector();
        r67.add(Float.valueOf((float) r66.valueResult.vecFVal[0]));
        r67.add(Float.valueOf((float) r66.valueResult.vecFVal[1]));
        r4.right_iris.add(r67);
        r65 = r65 + 1;
    L61:
        this.faceResults.add(r4);
        r2 = r2 + 1;
        goto L3
    }
}
