package ld0;

import com.bytedance.android.livesdk.chatroom.model.v1;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a implements v1 {

    @SerializedName("camera_open")
    public int cameraOpen;

    @SerializedName("link_id")
    public String linkId;

    @SerializedName("mode")
    private int mode;

    @SerializedName("sing_mode")
    private int singMode;

    @SerializedName("song_type")
    public int songType;

    @SerializedName("timestamp")
    public long timestamp;

    public a() {
    }

    public final boolean b() {
        if (this.singMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String toString() {
        return "VideoStateSei{linkId='" + this.linkId + "', singMode=" + this.singMode + ", mode=" + this.mode + ", cameraOpen=" + this.cameraOpen + ", timestamp=" + this.timestamp + '}';
    }

    public static a a(String r2, String r3, JSONObject r4) throws JSONException {
        a r5 = new a();
        new JSONObject();
        JSONObject r6 = r4.optJSONObject(r3);
        r5.linkId = r6.optString("link_id");
        r5.timestamp = r6.optLong("timestamp");
        r5.singMode = r6.optInt("sing_mode");
        r5.mode = r6.optInt("mode");
        r5.songType = r6.optInt("song_type");
        if ((r6.get("camera_open") instanceof Boolean) == false) goto L5;
        r5.cameraOpen = r6.optBoolean("camera_open") ? 1 : 0;
    L6:
        return r5;
    L5:
        r5.cameraOpen = r6.optInt("camera_open");
        goto L6
    }
}
