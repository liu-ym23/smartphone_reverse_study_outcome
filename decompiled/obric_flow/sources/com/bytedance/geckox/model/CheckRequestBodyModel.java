package com.bytedance.geckox.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Deprecated
public class CheckRequestBodyModel {

    @Keep
    public static class TargetChannel {

        @SerializedName("c")
        public String channelName;

        @SerializedName("from")
        public List<String> from;

        @SerializedName("t_v")
        public Long targetVersion;

        public TargetChannel() {
        }

        public TargetChannel(String r5) {
            this.channelName = r5;
        }

        public TargetChannel(String r5, Long r10) {
            this.channelName = r5;
            this.targetVersion = r10;
        }
    }

    public CheckRequestBodyModel() {
    }
}
