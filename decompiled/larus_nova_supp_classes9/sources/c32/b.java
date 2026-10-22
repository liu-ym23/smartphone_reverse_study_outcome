package c32;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b {

    @SerializedName("content_encode")
    public String contentEncode;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("spelling_content_encode")
    public String spellingContentEncode;

    public b() {
        this.spellingContentEncode = BuildConfig.FLAVOR;
    }
}
