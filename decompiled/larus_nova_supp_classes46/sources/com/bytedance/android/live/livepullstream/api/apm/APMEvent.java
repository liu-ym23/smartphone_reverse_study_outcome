package com.bytedance.android.live.livepullstream.api.apm;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class APMEvent {

    @SerializedName("key")
    private String mKey;

    @SerializedName("level")
    private Level mLevel;

    @SerializedName(MultiLinkOpenSource.MESSAGE)
    private String mMessage;

    @SerializedName("timestamp")
    private long mTimeStamp;

    public static final enum Level extends Enum<Level> {
        public static final Level E = null;
        public static final Level I = null;
        public static final /* synthetic */ Level[] a = null;

        static {
            Level r0 = new Level("I", 0);
            I = r0;
            Level r1 = new Level("E", 1);
            E = r1;
            a = new Level[]{r0, r1};
        }

        public static Level[] values() {
            return (Level[]) a.clone();
        }

        public static Level valueOf(String r1) {
            return (Level) r27.a.a(Level.class, r1);
        }

        public Level(String r1, int r2) {
            super(r1, r2);
        }
    }

    public APMEvent() {
    }

    public final JSONObject h() {
        JSONObject r0 = new JSONObject();
        r0.put("level", this.mLevel);     // Catch: JSONException -> L8
        r0.put("key", this.mKey);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(this.mMessage) == true) goto L6;
        r0.put(MultiLinkOpenSource.MESSAGE, this.mMessage);     // Catch: JSONException -> L8
    L6:
        r0.put("timestamp", this.mTimeStamp);     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final String toString() {
        return "key:" + this.mKey + " message:" + this.mMessage;
    }

    public final String a() {
        return this.mKey;
    }

    public final Level b() {
        return this.mLevel;
    }

    public final String c() {
        return this.mMessage;
    }

    public final void d(String r1) {
        this.mKey = r1;
    }

    public final void e(Level r1) {
        this.mLevel = r1;
    }

    public final void f(String r1) {
        this.mMessage = r1;
    }

    public final void g(long r1) {
        this.mTimeStamp = r1;
    }
}
