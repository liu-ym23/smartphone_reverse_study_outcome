package com.bytedance.byted_bach_sdk.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class BachFaceAlgorithmOutput extends BachAlgorithmOutput {
    public Vector<SingleFaceResult> faceResults;

    public BachFaceAlgorithmOutput(HashMap<String, BachObject>[] r14) {
        this.faceResults = new Vector();
        int r0 = r14.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L62;
        HashMap<String, BachObject> r3 = r14[r2];
        SingleFaceResult r4 = new SingleFaceResult();
        r4.m_width = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("m_width"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.m_height = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("m_height"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.bbox_x = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("bbox_x"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.bbox_y = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("bbox_y"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.bbox_width = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("bbox_width"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.bbox_height = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("bbox_height"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.score = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("score"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.points_array = new Vector();
        BachObject[] r5 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("points_array"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r6 = r5.length;
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L8;
        BachObject r10 = r5[r8];
        Vector<Float> r11 = new Vector();
        r11.add(Float.valueOf(GetPointValue(r10, 0)));
        r11.add(Float.valueOf(GetPointValue(r10, 1)));
        r4.points_array.add(r11);
        r8 = r8 + 1;
        goto L6
    L8:
        Vector<Float> r7 = new Vector();
        float[] r9 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("visibility_array"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.vecFVal;
        int r12 = r9.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        r7.add(Float.valueOf(r9[r13]));
        r13 = r13 + 1;
        goto L9
    L11:
        r4.visibility_array = r7;
        r4.roll = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("roll"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.yaw = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("yaw"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.pitch = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("pitch"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.eye_dist = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("eye_dist"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        r4.ID = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("ID"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.action = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("action"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.tracking_cnt = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("tracking_cnt"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.occlusion_prob = (float) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("occlusion_prob"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.doubleVal;
        if (r3.containsKey("mouth_id") == false) goto L21;
        r4.mouth_id = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("mouth_id"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.mouth_mask_size = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("mouth_mask_size"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        Vector<Short> r15 = new Vector();
        byte[] r16 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("mouth_mask"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.byteArrayVal;
        int r17 = r16.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L16;
        r15.add(Short.valueOf((short) Byte.toUnsignedInt(r16[r18])));
        r18 = r18 + 1;
        goto L14
    L16:
        r4.mouth_mask = r15;
        Vector<Float> r19 = new Vector();
        float[] r20 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("mouth_warp_mat"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.vecFVal;
        int r21 = r20.length;
        int r110 = 0;
    L17:
        if (r110 >= r21) goto L19;
        r19.add(Float.valueOf(r20[r110]));
        r110 = r110 + 1;
        goto L17
    L19:
        r4.mouth_warp_mat = r19;
    L21:
        if (r3.containsKey("teeth_id") == false) goto L30;
        r4.teeth_id = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("teeth_id"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.teeth_mask_size = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("teeth_mask_size"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        Vector<Short> r22 = new Vector();
        byte[] r23 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("teeth_mask"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.byteArrayVal;
        int r24 = r23.length;
        int r111 = 0;
    L23:
        if (r111 >= r24) goto L25;
        r22.add(Short.valueOf((short) Byte.toUnsignedInt(r23[r111])));
        r111 = r111 + 1;
        goto L23
    L25:
        r4.teeth_mask = r22;
        Vector<Float> r25 = new Vector();
        float[] r26 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("teeth_warp_mat"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.vecFVal;
        int r27 = r26.length;
        int r112 = 0;
    L26:
        if (r112 >= r27) goto L28;
        r25.add(Float.valueOf(r26[r112]));
        r112 = r112 + 1;
        goto L26
    L28:
        r4.teeth_warp_mat = r25;
    L30:
        if (r3.containsKey("face_id") == false) goto L39;
        r4.face_id = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("face_id"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.face_mask_size = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("face_mask_size"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        Vector<Short> r28 = new Vector();
        byte[] r29 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("face_mask"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.byteArrayVal;
        int r30 = r29.length;
        int r113 = 0;
    L32:
        if (r113 >= r30) goto L34;
        r28.add(Short.valueOf((short) Byte.toUnsignedInt(r29[r113])));
        r113 = r113 + 1;
        goto L32
    L34:
        r4.face_mask = r28;
        Vector<Float> r31 = new Vector();
        float[] r32 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("face_warp_mat"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.vecFVal;
        int r33 = r32.length;
        int r114 = 0;
    L35:
        if (r114 >= r33) goto L37;
        r31.add(Float.valueOf(r32[r114]));
        r114 = r114 + 1;
        goto L35
    L37:
        r4.face_warp_mat = r31;
    L39:
        if (r3.containsKey("eye_count") == false) goto L61;
        r4.eye_count = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("eye_count"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.eyebrow_count = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("eyebrow_count"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.lips_count = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("lips_count"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.iris_count = (int) ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("iris_count"), BachObject.class, "com.obric.memorydata.plugin")).valueResult.int64Val;
        r4.eye_left = new Vector();
        BachObject[] r34 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("eye_left"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r35 = r34.length;
        int r36 = 0;
    L41:
        if (r36 >= r35) goto L43;
        BachObject r115 = r34[r36];
        Vector<Float> r116 = new Vector();
        r116.add(Float.valueOf(GetPointValue(r115, 0)));
        r116.add(Float.valueOf(GetPointValue(r115, 1)));
        r4.eye_left.add(r116);
        r36 = r36 + 1;
        goto L41
    L43:
        r4.eye_right = new Vector();
        BachObject[] r37 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("eye_right"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r38 = r37.length;
        int r39 = 0;
    L44:
        if (r39 >= r38) goto L46;
        BachObject r117 = r37[r39];
        Vector<Float> r118 = new Vector();
        r118.add(Float.valueOf(GetPointValue(r117, 0)));
        r118.add(Float.valueOf(GetPointValue(r117, 1)));
        r4.eye_right.add(r118);
        r39 = r39 + 1;
        goto L44
    L46:
        r4.eyebrow_left = new Vector();
        BachObject[] r40 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("eyebrow_left"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r41 = r40.length;
        int r42 = 0;
    L47:
        if (r42 >= r41) goto L49;
        BachObject r119 = r40[r42];
        Vector<Float> r120 = new Vector();
        r120.add(Float.valueOf(GetPointValue(r119, 0)));
        r120.add(Float.valueOf(GetPointValue(r119, 1)));
        r4.eyebrow_left.add(r120);
        r42 = r42 + 1;
        goto L47
    L49:
        r4.eyebrow_right = new Vector();
        BachObject[] r43 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("eyebrow_right"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r44 = r43.length;
        int r45 = 0;
    L50:
        if (r45 >= r44) goto L52;
        BachObject r121 = r43[r45];
        Vector<Float> r122 = new Vector();
        r122.add(Float.valueOf(GetPointValue(r121, 0)));
        r122.add(Float.valueOf(GetPointValue(r121, 1)));
        r4.eyebrow_right.add(r122);
        r45 = r45 + 1;
        goto L50
    L52:
        r4.lips = new Vector();
        BachObject[] r46 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("lips"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r47 = r46.length;
        int r48 = 0;
    L53:
        if (r48 >= r47) goto L55;
        BachObject r123 = r46[r48];
        Vector<Float> r124 = new Vector();
        r124.add(Float.valueOf(GetPointValue(r123, 0)));
        r124.add(Float.valueOf(GetPointValue(r123, 1)));
        r4.lips.add(r124);
        r48 = r48 + 1;
        goto L53
    L55:
        r4.left_iris = new Vector();
        BachObject[] r49 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("left_iris"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r50 = r49.length;
        int r51 = 0;
    L56:
        if (r51 >= r50) goto L58;
        BachObject r125 = r49[r51];
        Vector<Float> r126 = new Vector();
        r126.add(Float.valueOf(GetPointValue(r125, 0)));
        r126.add(Float.valueOf(GetPointValue(r125, 1)));
        r4.left_iris.add(r126);
        r51 = r51 + 1;
        goto L56
    L58:
        r4.right_iris = new Vector();
        BachObject[] r52 = ((BachObject) ZeusTransformUtils.preCheckCast(r3.get("right_iris"), BachObject.class, "com.obric.memorydata.plugin")).vectorResult;
        int r53 = r52.length;
        int r54 = 0;
    L59:
        if (r54 >= r53) goto L61;
        BachObject r55 = r52[r54];
        Vector<Float> r56 = new Vector();
        r56.add(Float.valueOf(GetPointValue(r55, 0)));
        r56.add(Float.valueOf(GetPointValue(r55, 1)));
        r4.right_iris.add(r56);
        r54 = r54 + 1;
    L61:
        this.faceResults.add(r4);
        r2 = r2 + 1;
        goto L3
    }

    private static float GetPointValue(BachObject r2, int r3) {
        if (r2.infoType != BachObject.BachObjectType.INFO_TYPE_VECXD) goto L9;
        if (r2.valueResult.vecDVal == null) goto L9;
        return (float) r2.valueResult.vecDVal[r3];
    L9:
        if (r2.infoType != BachObject.BachObjectType.INFO_TYPE_VECXF) goto L15;
        if (r2.valueResult.vecFVal == null) goto L15;
        return r2.valueResult.vecFVal[r3];
    L15:
        if (r2.infoType == BachObject.BachObjectType.INFO_TYPE_VECXI) goto L17;
        return 0.0f;
    L17:
        if (r2.valueResult.vecIVal != null) goto L19;
        return 0.0f;
    L19:
        return r2.valueResult.vecIVal[r3];
    }
}
