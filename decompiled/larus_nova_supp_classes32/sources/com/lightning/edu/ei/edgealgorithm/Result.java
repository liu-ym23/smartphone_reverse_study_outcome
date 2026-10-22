package com.lightning.edu.ei.edgealgorithm;

import android.os.Build;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class Result {
    public float[] blurConf;
    public long blurCost;
    public float blurScore;
    public float blurThreshold;
    public float[][] boundingBoxes;
    public boolean checkOrbFeat;
    public long darkCheckCost;
    public int darkLabel;
    public float[] darkLabelConf;
    public long detectionCost;
    public String detectionMsg;
    public int detectionStatus;
    public String deviceInfo;
    public long featureCheckCost;
    public int inHeight;
    public int inOrientation;
    public int inWidth;
    public long initCost;
    public float[] midboundingBox;
    public String msg;
    public int orientation;
    public float[] orientationConf;
    public long orientationCost;
    public String os;
    public boolean pass;
    public long preProcessCost;
    public long predictCost;
    public long sceneCost;
    public int sceneLabel;
    public float[] sceneLabelConf;
    public long sceneOrientationCost;
    public String stateMachineInfo;
    public int stateMachinePrePC;
    public int status;
    public String threeClassMsg;
    public int threeClassStatus;
    public String version;

    public static String readableDark(int r1) {
        if (r1 != 0) goto L6;
        return "过暗";
    L6:
        if (r1 != 1) goto L9;
        return "正常";
    L9:
        return "未知亮度";
    }

    public static String readableOrientation(int r1) {
        if (r1 != 0) goto L6;
        return "0度";
    L6:
        if (r1 != 1) goto L10;
        return "左转90度";
    L10:
        if (r1 != 2) goto L14;
        return "旋转180度";
    L14:
        if (r1 != 3) goto L17;
        return "右转90度";
    L17:
        return "未知角度";
    }

    public static String readableScene(int r1) {
        if (r1 != 0) goto L6;
        return "题目场景";
    L6:
        if (r1 != 1) goto L9;
        return "非题目场景";
    L9:
        return "未知场景";
    }

    public void getOsDeviceInfo() {
        this.os = "Android " + Build.VERSION.RELEASE;
        this.deviceInfo = Build.BRAND + "_" + Build.HARDWARE + "_" + Build.CPU_ABI;
    }

    public Status getStatus() {
        switch(this.status) {
            case 0: goto L35;
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L29;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L13;
            case 12: goto L11;
            case 13: goto L9;
            case 14: goto L7;
            default: goto L5;
        };
    L5:
        return Status.STATUS_SUCCESS;
    L7:
        return Status.STATUS_DETECTION_INFERENCE_IS_NULL;
    L9:
        return Status.STATUS_DETECTION_INFERENCE_FAILED;
    L11:
        return Status.STATUS_NEED_REFUSE;
    L13:
        return Status.STATUS_NEED_RETAKE;
    L15:
        return Status.STATUS_CHECK_DARK_FAILED;
    L17:
        return Status.STATUS_CHECK_SCENE_FAILED;
    L19:
        return Status.STATUS_CHECK_BLUR_FAILED;
    L21:
        return Status.STATUS_BITMAP_LOCK_PIXELS;
    L23:
        return Status.STATUS_BITMAP_NOT_RGBA8888;
    L25:
        return Status.STATUS_BITMAP_GET_INFO;
    L27:
        return Status.STATUS_BITMAP_IS_RECYCLED;
    L29:
        return Status.STATUS_INFERENCE_IS_NULL_C;
    L31:
        return Status.STATUS_IMAGE_SMALL;
    L33:
        return Status.STATUS_INFERENCE_IS_NULL;
    L35:
        return Status.STATUS_SUCCESS;
    }

    public String toJSON() {
        getOsDeviceInfo();
        JSONObject r1 = new JSONObject();
        r1.put("pass", this.pass);     // Catch: JSONException -> L27
        r1.put("blurScore", this.blurScore);     // Catch: JSONException -> L27
        r1.put("blurThreshold", this.blurThreshold);     // Catch: JSONException -> L27
        JSONArray r2 = new JSONArray();     // Catch: JSONException -> L27
        float[] r3 = this.blurConf;     // Catch: JSONException -> L27
        int r4 = r3.length;     // Catch: JSONException -> L27
        int r6 = 0;
    L4:
        if (r6 >= r4) goto L6;
        r2.put(r3[r6]);     // Catch: JSONException -> L27
        r6 = r6 + 1;     // Catch: JSONException -> L27
        goto L4
    L6:
        r1.put("blurConf", r2);     // Catch: JSONException -> L27
        r1.put("sceneLabel", this.sceneLabel);     // Catch: JSONException -> L27
        JSONArray r5 = new JSONArray();     // Catch: JSONException -> L27
        float[] r7 = this.sceneLabelConf;     // Catch: JSONException -> L27
        int r8 = r7.length;     // Catch: JSONException -> L27
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L9;
        r5.put(r7[r9]);     // Catch: JSONException -> L27
        r9 = r9 + 1;     // Catch: JSONException -> L27
        goto L7
    L9:
        r1.put("sceneLabelConf", r5);     // Catch: JSONException -> L27
        r1.put("darkLabel", this.darkLabel);     // Catch: JSONException -> L27
        JSONArray r10 = new JSONArray();     // Catch: JSONException -> L27
        float[] r11 = this.darkLabelConf;     // Catch: JSONException -> L27
        int r12 = r11.length;     // Catch: JSONException -> L27
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L12;
        r10.put(r11[r13]);     // Catch: JSONException -> L27
        r13 = r13 + 1;     // Catch: JSONException -> L27
        goto L10
    L12:
        r1.put("darkLabelConf", r10);     // Catch: JSONException -> L27
        r1.put("inOrientation", this.inOrientation);     // Catch: JSONException -> L27
        r1.put("inWidth", this.inWidth);     // Catch: JSONException -> L27
        r1.put("inHeight", this.inHeight);     // Catch: JSONException -> L27
        r1.put("orientation", this.orientation);     // Catch: JSONException -> L27
        JSONArray r14 = new JSONArray();     // Catch: JSONException -> L27
        float[] r15 = this.orientationConf;     // Catch: JSONException -> L27
        int r16 = r15.length;     // Catch: JSONException -> L27
        int r17 = 0;
    L13:
        if (r17 >= r16) goto L15;
        r14.put(r15[r17]);     // Catch: JSONException -> L27
        r17 = r17 + 1;     // Catch: JSONException -> L27
        goto L13
    L15:
        r1.put("orientationConf", r14);     // Catch: JSONException -> L27
        r1.put("initCost", this.initCost + "ms");     // Catch: JSONException -> L27
        r1.put("preProcessCost", this.preProcessCost + "ms");     // Catch: JSONException -> L27
        r1.put("darkCheckCost", this.darkCheckCost + "ms");     // Catch: JSONException -> L27
        r1.put("blurCost", this.blurCost + "ms");     // Catch: JSONException -> L27
        r1.put("featureCheckCost", this.featureCheckCost + "ms");     // Catch: JSONException -> L27
        r1.put("sceneCost", this.sceneCost + "ms");     // Catch: JSONException -> L27
        r1.put("orientationCost", this.orientationCost + "ms");     // Catch: JSONException -> L27
        r1.put("predictCost", this.predictCost + "ms");     // Catch: JSONException -> L27
        r1.put("version", this.version);     // Catch: JSONException -> L27
        r1.put("status", this.status);     // Catch: JSONException -> L27
        r1.put("threeClassStatus", this.threeClassStatus);     // Catch: JSONException -> L27
        r1.put("stateMachineInfo", this.stateMachineInfo);     // Catch: JSONException -> L27
        r1.put("stateMachinePrePC", this.stateMachinePrePC);     // Catch: JSONException -> L27
        r1.put("msg", this.msg);     // Catch: JSONException -> L27
        r1.put("threeClassMsg", this.threeClassMsg);     // Catch: JSONException -> L27
        r1.put("os", this.os);     // Catch: JSONException -> L27
        r1.put("deviceInfo", this.deviceInfo);     // Catch: JSONException -> L27
        JSONArray r18 = new JSONArray();     // Catch: JSONException -> L27
        float[] r19 = this.midboundingBox;     // Catch: JSONException -> L27
        int r20 = r19.length;     // Catch: JSONException -> L27
        int r21 = 0;
    L16:
        if (r21 >= r20) goto L18;
        r18.put(r19[r21]);     // Catch: JSONException -> L27
        r21 = r21 + 1;     // Catch: JSONException -> L27
        goto L16
    L18:
        JSONArray r22 = new JSONArray();     // Catch: JSONException -> L27
        r1.put("midboundingBox", r18);     // Catch: JSONException -> L27
        int r23 = 0;
    L20:
        if (r23 >= this.boundingBoxes.length) goto L25;
        JSONArray r24 = new JSONArray();     // Catch: JSONException -> L27
        float[] r25 = this.boundingBoxes[r23];     // Catch: JSONException -> L27
        int r26 = r25.length;     // Catch: JSONException -> L27
        int r27 = 0;
    L22:
        if (r27 >= r26) goto L24;
        r24.put(r25[r27]);     // Catch: JSONException -> L27
        r27 = r27 + 1;     // Catch: JSONException -> L27
        goto L22
    L24:
        r22.put(r24);     // Catch: JSONException -> L27
        r23 = r23 + 1;     // Catch: JSONException -> L27
        goto L20
    L25:
        r1.put("boundingBoxes", r22);     // Catch: JSONException -> L27
        r1.put("detectionCost", this.detectionCost + "ms");     // Catch: JSONException -> L27
        r1.put("detectionStatus", this.detectionStatus);     // Catch: JSONException -> L27
        r1.put("detectionMsg", this.detectionMsg);     // Catch: JSONException -> L27
        return r1.toString();
    L27:
        e = move-exception;
        e.printStackTrace();
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public Result() {
        this.pass = true;
        this.status = 0;
        this.threeClassStatus = 0;
        this.blurScore = -1.0f;
        this.orientation = -1;
        this.sceneLabel = -1;
        this.darkLabel = -1;
        this.blurConf = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.orientationConf = new float[]{-1.0f, -1.0f, -1.0f, -1.0f};
        this.sceneLabelConf = new float[]{-1.0f, -1.0f};
        this.darkLabelConf = new float[]{-1.0f, -1.0f};
        this.msg = "Success";
        this.threeClassMsg = "Success";
        this.stateMachineInfo = NameKeys.UnloadStrategy_No_Strategy;
        this.stateMachinePrePC = -1;
        this.version = NameKeys.UnloadStrategy_No_Strategy;
        this.initCost = 0;
        this.preProcessCost = 0;
        this.blurCost = 0;
        this.sceneCost = 0;
        this.orientationCost = 0;
        this.sceneOrientationCost = 0;
        this.predictCost = 0;
        this.darkCheckCost = 0;
        this.featureCheckCost = 0;
        this.blurThreshold = 0.0f;
        this.inOrientation = 0;
        this.inWidth = 0;
        this.inHeight = 0;
        this.checkOrbFeat = true;
        this.detectionStatus = 0;
        this.detectionMsg = "Success";
        this.boundingBoxes = new float[][]{new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f}};
        this.midboundingBox = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.detectionCost = 0;
    }

    public String toString() {
        getOsDeviceInfo();
        return " 是否通过=" + this.pass + ",\n 模糊打分=" + this.blurScore + " [模糊阈值: " + this.blurThreshold + "],\n 模糊置信度=" + Arrays.toString(this.blurConf) + ",\n 输入Exif方向=" + this.inOrientation + ", 输入尺寸=w:" + this.inWidth + ", h:" + this.inHeight + ",\n 旋转角度=" + readableOrientation(this.orientation) + " 置信度: " + Arrays.toString(this.orientationConf) + ",\n 场景分类=" + readableScene(this.sceneLabel) + " 置信度: " + Arrays.toString(this.sceneLabelConf) + ",\n 过暗判断=" + readableDark(this.darkLabel) + " 置信度: " + Arrays.toString(this.darkLabelConf) + ",\n 模型初始化耗时=" + this.initCost + "ms,\n 预处理耗时=" + this.preProcessCost + "ms,\n 过暗判断耗时=" + this.darkCheckCost + "ms,\n 模糊检测耗时=" + this.blurCost + "ms,\n ORB特征耗时=" + this.featureCheckCost + "ms,\n 场景判断耗时=" + this.sceneCost + "ms,\n 方向检测耗时=" + this.orientationCost + "ms,\n 算法总耗时=" + this.predictCost + "ms,\n ORB判断=" + this.checkOrbFeat + ",\n 状态=" + readableStatus(this.status) + ",\n 调试信息='" + this.msg + "',\n Refuse状态=" + readableStatus(this.threeClassStatus) + ",\n Refuse信息='" + this.threeClassMsg + "',\n 预测前状态机计数='" + this.stateMachinePrePC + "',\n 状态机='" + this.stateMachineInfo + "',\n 切题输入图像宽度=" + this.inWidth + ", 高度=" + this.inHeight + ",\n 切题最近中心检测结果=" + Arrays.toString(this.midboundingBox) + ",\n 切题算法总耗时=" + this.detectionCost + "ms,\n 切题状态=" + readableDetectionStatus(this.detectionStatus) + ",\n 切题调试信息='" + this.detectionMsg + "',\n 版本=" + this.version + ",\n 系统&设备=" + this.os + "_" + this.deviceInfo;
    }

    public static String readableDetectionStatus(int r2) {
        if (r2 != (-1)) goto L6;
        return "被拒识";
    L6:
        if (r2 != 0) goto L10;
        return "成功";
    L10:
        return "失败(" + r2 + ")";
    }

    public static String readableStatus(int r2) {
        if (r2 != 0) goto L6;
        return "成功";
    L6:
        return "失败(" + r2 + ")";
    }
}
