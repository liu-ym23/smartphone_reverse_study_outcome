package com.bytedance.bdinstall.oaid;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class OaidModel {
    public static final String KEY_HW_ID_VERSION_CODE = "hw_id_version_code";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_TRACK_LIMITED = "is_track_limited";
    public static final String KEY_QUERY_TIMES = "query_times";
    public static final String KEY_REQ_ID = "req_id";
    public static final String KEY_TAKE_MS = "take_ms";
    public static final String KEY_TIME = "time";
    public final Boolean isTrackLimited;
    public final Long mHwIdVersionCode;
    public final String oaid;
    public final Integer queryTimes;
    public final String reqId;
    public final Long takeMs;
    public final Long time;

    OaidModel(String r10, String r11, Boolean r12, Long r13, Long r14, Integer r15, Long r16) {
        this.oaid = r10;
        this.reqId = r11;
        this.isTrackLimited = r12;
        this.takeMs = r13;
        this.time = r14;
        this.queryTimes = r15;
        this.mHwIdVersionCode = r16;
    }

    @Nullable
    @AnyThread
    public static OaidModel create(@Nullable String r15) {
        if (TextUtils.isEmpty(r15) == false) goto L30;
        return null;
    L30:
        JSONObject r10 = new JSONObject(r15);     // Catch: JSONException -> L27
        String r11 = r10.optString(KEY_ID, null);     // Catch: JSONException -> L27
        String r12 = r10.optString("req_id", null);     // Catch: JSONException -> L27
        if (r10.has(KEY_IS_TRACK_LIMITED) == false) goto L8;
        Boolean r13 = Boolean.valueOf(r10.optBoolean(KEY_IS_TRACK_LIMITED));     // Catch: JSONException -> L27
    L10:
        if (r10.has(KEY_TAKE_MS) == false) goto L12;
        Long r16 = Long.valueOf(r10.optLong(KEY_TAKE_MS, -1));     // Catch: JSONException -> L27
    L14:
        if (r10.has(KEY_TIME) == false) goto L16;
        Long r14 = Long.valueOf(r10.optLong(KEY_TIME, -1));     // Catch: JSONException -> L27
    L18:
        if (r10.has(KEY_QUERY_TIMES) == false) goto L20;
        Integer r17 = Integer.valueOf(r10.optInt(KEY_QUERY_TIMES, -1));     // Catch: JSONException -> L27
    L22:
        if (r10.has(KEY_HW_ID_VERSION_CODE) == false) goto L24;
        Long r18 = Long.valueOf(r10.optLong(KEY_HW_ID_VERSION_CODE, -1));     // Catch: JSONException -> L27
    L25:
        return new OaidModel(r11, r12, r13, r16, r14, r17, r18);
    L24:
        r18 = null;
        goto L25
    L20:
        r17 = null;
        goto L22
    L16:
        r14 = null;
        goto L18
    L12:
        r16 = null;
        goto L14
    L8:
        r13 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @NonNull
    Map<String, String> toApiMap() {
        HashMap r10 = new HashMap();
        Oaid.safePutNonNullValue(r10, KEY_ID, this.oaid);
        Oaid.safePutNonNullValue(r10, "req_id", this.reqId);
        Oaid.safePutNonNullValue(r10, KEY_IS_TRACK_LIMITED, String.valueOf(this.isTrackLimited));
        Oaid.safePutNonNullValue(r10, KEY_TAKE_MS, String.valueOf(this.takeMs));
        Oaid.safePutNonNullValue(r10, KEY_TIME, String.valueOf(this.time));
        Oaid.safePutNonNullValue(r10, KEY_QUERY_TIMES, String.valueOf(this.queryTimes));
        Oaid.safePutNonNullValue(r10, KEY_HW_ID_VERSION_CODE, String.valueOf(this.mHwIdVersionCode));
        return r10;
    }

    @NonNull
    JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        Oaid.safePutNonEmptyValue(r10, KEY_ID, this.oaid);
        Oaid.safePutNonEmptyValue(r10, "req_id", this.reqId);
        Oaid.safePutNonEmptyValue(r10, KEY_IS_TRACK_LIMITED, this.isTrackLimited);
        Oaid.safePutNonEmptyValue(r10, KEY_TAKE_MS, this.takeMs);
        Oaid.safePutNonEmptyValue(r10, KEY_TIME, this.time);
        Oaid.safePutNonEmptyValue(r10, KEY_QUERY_TIMES, this.queryTimes);
        Oaid.safePutNonEmptyValue(r10, KEY_HW_ID_VERSION_CODE, this.mHwIdVersionCode);
        return r10;
    }

    public String toString() {
        return toJson().toString();
    }
}
