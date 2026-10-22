package com.bytedance.android.live.core.resources;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class g {

    @SerializedName("audio_graph")
    public a audioGraph;

    @SerializedName("gift_duration")
    public long duration;

    @SerializedName("befViewFitMode")
    public int fitMode;

    @SerializedName("befViewRenderFPS")
    public int fps;

    @SerializedName("gift_type")
    public String giftType;

    @SerializedName("model_names")
    public String modelNames;

    @Expose(deserialize = false, serialize = false)
    private HashMap<String, List<String>> modelNamesEntity;

    @SerializedName("need_screen_shot")
    public boolean needScreenShot;

    @SerializedName("requirements")
    public List<String> requirements;

    @SerializedName("should_multi_frame")
    public boolean shouldMultiFrame;

    @SerializedName("befViewRenderSize")
    public b size;

    @SerializedName("view_overlay")
    public String viewOverlay;

    public static class a {

        @SerializedName("dB_value")
        public float dbValue;

        @SerializedName("gain")
        public float gain;

        @SerializedName("sources")
        public List<String> sources;

        @SerializedName("use_output")
        public boolean useOutput;

        public a() {
        }
    }

    public static class b {

        @SerializedName("h")
        public int h;

        @SerializedName("w")
        public int w;

        public b() {
        }
    }

    public g() {
        this.modelNamesEntity = null;
    }
}
