package com.lightning.edu.ei.edgealgorithm;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status STATUS_BITMAP_GET_INFO = null;
    public static final Status STATUS_BITMAP_IS_RECYCLED = null;
    public static final Status STATUS_BITMAP_LOCK_PIXELS = null;
    public static final Status STATUS_BITMAP_NOT_RGBA8888 = null;
    public static final Status STATUS_CHECK_BLUR_FAILED = null;
    public static final Status STATUS_CHECK_DARK_FAILED = null;
    public static final Status STATUS_CHECK_SCENE_FAILED = null;
    public static final Status STATUS_DETECTION_INFERENCE_FAILED = null;
    public static final Status STATUS_DETECTION_INFERENCE_IS_NULL = null;
    public static final Status STATUS_IMAGE_SMALL = null;
    public static final Status STATUS_INFERENCE_IS_NULL = null;
    public static final Status STATUS_INFERENCE_IS_NULL_C = null;
    public static final Status STATUS_NEED_REFUSE = null;
    public static final Status STATUS_NEED_RETAKE = null;
    public static final Status STATUS_SUCCESS = null;
    private int statusCode;
    private String statusMsg;

    static {
        Status r0 = new Status("STATUS_SUCCESS", 0, 0, "Success");
        STATUS_SUCCESS = r0;
        Status r1 = new Status("STATUS_INFERENCE_IS_NULL", 1, 1, "Inference is null (InferenceNative)");
        STATUS_INFERENCE_IS_NULL = r1;
        Status r2 = new Status("STATUS_IMAGE_SMALL", 2, 2, "Image too small");
        STATUS_IMAGE_SMALL = r2;
        Status r4 = new Status("STATUS_INFERENCE_IS_NULL_C", 3, 3, "Inference is nullptr (JNI)");
        STATUS_INFERENCE_IS_NULL_C = r4;
        Status r6 = new Status("STATUS_BITMAP_IS_RECYCLED", 4, 4, "Bitmap is recycled");
        STATUS_BITMAP_IS_RECYCLED = r6;
        Status r8 = new Status("STATUS_BITMAP_GET_INFO", 5, 5, "Bitmap get info error");
        STATUS_BITMAP_GET_INFO = r8;
        Status r10 = new Status("STATUS_BITMAP_NOT_RGBA8888", 6, 6, "Bitmap is not RGBA8888 format");
        STATUS_BITMAP_NOT_RGBA8888 = r10;
        Status r12 = new Status("STATUS_BITMAP_LOCK_PIXELS", 7, 7, "Bitmap lock pixels error");
        STATUS_BITMAP_LOCK_PIXELS = r12;
        Status r14 = new Status("STATUS_CHECK_BLUR_FAILED", 8, 8, "Check Blur Failed");
        STATUS_CHECK_BLUR_FAILED = r14;
        Status r13 = new Status("STATUS_CHECK_SCENE_FAILED", 9, 9, "Check Scene Failed");
        STATUS_CHECK_SCENE_FAILED = r13;
        Status r11 = new Status("STATUS_CHECK_DARK_FAILED", 10, 10, "Check Dark Failed, Too Dark");
        STATUS_CHECK_DARK_FAILED = r11;
        Status r9 = new Status("STATUS_NEED_RETAKE", 11, 11, "Need retake photo!");
        STATUS_NEED_RETAKE = r9;
        Status r7 = new Status("STATUS_NEED_REFUSE", 12, 12, "Need refuse photo!");
        STATUS_NEED_REFUSE = r7;
        Status r5 = new Status("STATUS_DETECTION_INFERENCE_FAILED", 13, 13, "Detection Inference run error");
        STATUS_DETECTION_INFERENCE_FAILED = r5;
        Status r3 = new Status("STATUS_DETECTION_INFERENCE_IS_NULL", 14, 14, "Detection Inference is null (InferenceNative)");
        STATUS_DETECTION_INFERENCE_IS_NULL = r3;
        $VALUES = new Status[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3};
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public static Status valueOf(String r1) {
        return (Status) a.a(Status.class, r1);
    }

    private Status(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.statusCode = r3;
        this.statusMsg = r4;
    }
}
