package f7;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class d {

    @SerializedName("results")
    public List<a> result;

    public static class a {

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

        public a() {
        }
    }

    public d() {
    }
}
