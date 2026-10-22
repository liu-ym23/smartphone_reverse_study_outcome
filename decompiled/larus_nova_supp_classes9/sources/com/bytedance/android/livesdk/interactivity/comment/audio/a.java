package com.bytedance.android.livesdk.interactivity.comment.audio;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a {

    @SerializedName("results")
    public List<C0111a> result;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.audio.a$a, reason: collision with other inner class name */
    public static class C0111a {

        @SerializedName("end_time")
        public float endTime;

        @SerializedName("index")
        public int index;

        @SerializedName("is_interim")
        public boolean isInterim;

        @SerializedName("start_time")
        public float startTime;

        @SerializedName("text")
        public String text;

        public C0111a() {
        }
    }

    public a() {
    }
}
