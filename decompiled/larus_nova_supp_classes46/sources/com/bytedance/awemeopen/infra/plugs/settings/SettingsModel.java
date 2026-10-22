package com.bytedance.awemeopen.infra.plugs.settings;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/SettingsModel;", "", "Lorg/json/JSONObject;", "toJson", "", "isSettingsValid", "", "toString", "", "component1", "component2", "lastUpdateTime", "settings", "copy", "", "hashCode", PbRequest.SwitchType.OTHER, "equals", "J", "getLastUpdateTime", "()J", "Lorg/json/JSONObject;", "getSettings", "()Lorg/json/JSONObject;", "<init>", "(JLorg/json/JSONObject;)V", "Companion", "a", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1})
public final class SettingsModel {
    public static final a Companion = null;
    private static final String KEY_LAST_UPDATE_TIME = "update_time";
    private static final String KEY_SETTINGS_JSON = "settings_json";
    private static final String TAG = "SettingsModel";
    private static final long VALID_DURATION = 3600000;
    private final long lastUpdateTime;
    private final JSONObject settings;

    public static final class a {
        public a() {
        }

        public static SettingsModel a(String r7) {
            if (r7 != null) goto L5;
        L8:
            boolean r2 = true;
        L10:
            if (r2 == false) goto L20;
            return null;
        L20:
            JSONObject r3 = new JSONObject(r7);     // Catch: Exception -> L17
            long r4 = r3.optLong(SettingsModel.KEY_LAST_UPDATE_TIME);     // Catch: Exception -> L17
            JSONObject r8 = r3.optJSONObject(SettingsModel.KEY_SETTINGS_JSON);     // Catch: Exception -> L17
            if (r8 != null) goto L15;
            r8 = new JSONObject();     // Catch: Exception -> L17
        L15:
            return new SettingsModel(r4, r8);
        L17:
            e = move-exception;
            AoNpthService r5 = AoExceptionReporter.a;
            AoExceptionReporter.a(ErrorPriority.p2, "settingsModel", "toSettingsModel", "json_parse_error", e);
            AoLogger.c(SettingsModel.TAG, new Object[]{"toSettingsModel", e});
            return null;
        L5:
            if (r7.length() == 0) goto L8;
            r2 = false;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ SettingsModel copy$default(SettingsModel r0, long r1, JSONObject r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.lastUpdateTime;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.settings;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.lastUpdateTime;
    }

    public final JSONObject component2() {
        return this.settings;
    }

    public final SettingsModel copy(long r2, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "settings");
        return new SettingsModel(r2, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SettingsModel) == true) goto L8;
        return false;
    L8:
        SettingsModel r9 = (SettingsModel) r8;
        if (this.lastUpdateTime == r9.lastUpdateTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.settings, r9.settings) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = this.lastUpdateTime;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.settings.hashCode();
    }

    public final JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put(KEY_LAST_UPDATE_TIME, this.lastUpdateTime);     // Catch: JSONException -> L5
        r0.put(KEY_SETTINGS_JSON, this.settings);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"toJson", e});
        goto L7
    }

    public final boolean isSettingsValid() {
        if ((System.currentTimeMillis() - this.lastUpdateTime) >= VALID_DURATION) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return toJson().toString();
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final JSONObject getSettings() {
        return this.settings;
    }

    public SettingsModel(long r2, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "settings");
        this.lastUpdateTime = r2;
        this.settings = r4;
    }
}
