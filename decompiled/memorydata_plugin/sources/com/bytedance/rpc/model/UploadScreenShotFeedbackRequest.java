package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UploadScreenShotFeedbackRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("encrypted_image")
    public String encryptedImage;
    public Map<String, String> extra;
    public ScreenShotFeedback feedback;

    @SerializedName("image_count")
    public int imageCount;

    @SerializedName("is_finish")
    public boolean isFinish;
    public String mime;

    @SerializedName("react_view_tree")
    public String reactViewTree;
    public String source;

    @SerializedName("task_id")
    public String taskId;

    @SerializedName("tool_id")
    public String toolId;

    @SerializedName("view_tree")
    public String viewTree;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UploadScreenShotFeedbackRequest() {
    }
}
