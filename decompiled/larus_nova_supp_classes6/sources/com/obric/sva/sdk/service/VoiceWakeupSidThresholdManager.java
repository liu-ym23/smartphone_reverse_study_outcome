package com.obric.sva.sdk.service;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.config.ConfigManager;
import com.obric.sva.sdk.sami.SamiWakeupParamProvider;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/sva/sdk/service/VoiceWakeupSidThresholdManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "matchedThresholds", "", "syncAndApply", "", "parseThresholds", "thresholdConfig", "", "targetVersion", "thresholdKey", "findThresholdsFromArray", "jsonArray", "Lorg/json/JSONArray;", "findThresholdsFromObject", "jsonObject", "Lorg/json/JSONObject;", "parseThresholdEntry", "entry", "parseThresholdValueList", "thresholdValue", "isSameThresholds", "", "first", "second", "resolveThresholdKey", "getCurrentLocale", "Ljava/util/Locale;", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class VoiceWakeupSidThresholdManager {
    private static final String CANTONESE_LANGUAGE = "yue";
    private static final String CHINESE_LANGUAGE = "zh";
    public static final Companion Companion = null;
    private static final String DEFAULT_THRESHOLD_KEY = "default";
    private static final String HK_THRESHOLD_KEY = "HK";
    private static final String HONG_KONG_LANGUAGE_TAG = "-hk";
    private static final String HONG_KONG_REGION = "hk";
    private static final String TAG = "VoiceWakeupSidThresholdManager";
    private final Context appContext;
    private float[] matchedThresholds;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/service/VoiceWakeupSidThresholdManager$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_THRESHOLD_KEY", "HK_THRESHOLD_KEY", "CHINESE_LANGUAGE", "CANTONESE_LANGUAGE", "HONG_KONG_REGION", "HONG_KONG_LANGUAGE_TAG", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void syncAndApply() {
        String r0 = rna.b.a;
        sna.h r1 = sna.h.a;
        String r2 = "";
        String r3 = sna.h.a().getString("voice_wakeup_sid_threshold_config", "");
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        if (r3.length() != 0) goto L8;
        boolean r4 = true;
    L9:
        long r5 = 0;
        String r7 = null;
        if (r4 == false) goto L12;
        sna.h.b("getSidThreshold cache miss");
        sna.h.a r6 = null;
    L13:
        if (r6 == null) goto L15;
        rna.b.b r8 = new rna.b.b(r6.a, r6.b);
    L16:
        if (r8 == null) goto L18;
        String r9 = r8.a;
    L19:
        if (r9 == null) goto L22;
        r2 = r9;
    L22:
        StringBuilder r10 = new StringBuilder("syncAndApply cacheHit=");
        if (r8 == null) goto L25;
        boolean r11 = true;
    L26:
        r10.append(r11);
        r10.append(" cachedAt=");
        if (r8 == null) goto L29;
        r5 = r8.b;
    L29:
        r10.append(r5);
        r10.append(" configLength=");
        r10.append(r2.length());
        LogUtils.i(TAG, r10.toString(), new Object[0]);
        float[] r12 = this.matchedThresholds;
        String r13 = ConfigManager.INSTANCE.getStage2Config().getVoiceprint_modelVersion();
        String r14 = resolveThresholdKey(this.appContext);
        if (r2.length() != 0) goto L32;
        boolean r15 = true;
    L34:
        if (r15 == true) goto L58;
        if (r13 != null) goto L37;
    L40:
        boolean r16 = true;
    L41:
        if (r16 == true) goto L58;
        float[] r17 = parseThresholds(r2, r13, r14);
        this.matchedThresholds = r17;
        boolean r18 = !isSameThresholds(r12, r17);
        if (this.matchedThresholds != null) goto L46;
        LogUtils.w(TAG, "syncAndApply no matched thresholds, version = " + r13 + ", thresholdKey = " + r14, new Object[0]);
    L46:
        StringBuilder r19 = new StringBuilder("syncAndApply version = ");
        r19.append(r13);
        r19.append(", thresholdKey = ");
        r19.append(r14);
        r19.append(", matchedThresholds = ");
        float[] r20 = this.matchedThresholds;
        if (r20 == null) goto L49;
        String r21 = Arrays.toString(r20);
    L50:
        r19.append(r21);
        r19.append(", previousThresholds = ");
        if (r12 == null) goto L53;
        r7 = Arrays.toString(r12);
    L53:
        r19.append(r7);
        r19.append(", thresholdChanged = ");
        r19.append(r18);
        LogUtils.d(TAG, r19.toString(), new Object[0]);
        if (r18 == false) goto L56;
        SamiWakeupParamProvider.INSTANCE.updateSidThresholds(this.matchedThresholds);
        return;
    L56:
        LogUtils.d(TAG, "syncAndApply skip update, threshold is unchanged", new Object[0]);
        return;
    L49:
        r21 = null;
        goto L50
    L37:
        if (r13.length() == 0) goto L40;
        r16 = false;
    L58:
        this.matchedThresholds = null;
        SamiWakeupParamProvider.INSTANCE.updateSidThresholds(null);
        LogUtils.w(TAG, "syncAndApply clear, config or version is empty, version = " + r13 + ", thresholdKey = " + r14, new Object[0]);
        return;
    L32:
        r15 = false;
        goto L34
    L25:
        r11 = false;
        goto L26
    L18:
        r9 = null;
        goto L19
    L15:
        r8 = null;
        goto L16
    L12:
        r6 = new sna.h.a(r3, sna.h.a().getLong("voice_wakeup_sid_threshold_cached_at", 0));
        sna.h.b("getSidThreshold success, configLength=" + r6.a.length() + ", cachedAt=" + r6.b);
        goto L13
    L8:
        r4 = false;
        goto L9
    }

    public VoiceWakeupSidThresholdManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
    }

    private final Locale getCurrentLocale(Context r3) {
        Configuration r4 = r3.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 24) goto L8;
        Locale r5 = r4.getLocales().get(0);
        if (r5 != null) goto L7;
        r5 = Locale.getDefault();
    L7:
        Intrinsics.checkNotNull(r5);
    L12:
        return r5;
    L8:
        r5 = r4.locale;
        if (r5 != null) goto L11;
        r5 = Locale.getDefault();
    L11:
        Intrinsics.checkNotNull(r5);
        goto L12
    }

    private final float[] parseThresholdValueList(Object r10) {
        boolean r1 = true;
        if ((r10 instanceof JSONArray) == false) goto L21;
        JSONArray r11 = (JSONArray) r10;
        if (r11.length() > 0) goto L7;
        LogUtils.w(TAG, "parseThresholdValueList empty threshold array", new Object[0]);
        return null;
    L7:
        int r0 = r11.length();
        float[] r5 = new float[r0];
        int r6 = 0;
    L8:
        if (r6 >= r0) goto L10;
        r5[r6] = (float) r11.optDouble(r6, Double.NaN);
        r6 = r6 + 1;
        goto L8
    L10:
        int r12 = 0;
    L11:
        if (r12 >= r0) goto L16;
        if (Float.isNaN(r5[r12]) == true) goto L14;
        r12 = r12 + 1;
        goto L11
    L14:
        r1 = false;
    L16:
        if (r1 == true) goto L18;
        LogUtils.w(TAG, "parseThresholdValueList contains invalid float value", new Object[0]);
    L18:
        if (r1 == true) goto L52;
        return null;
    L52:
        return r5;
    L21:
        if ((r10 instanceof Number) == false) goto L24;
        return new float[]{((Number) r10).floatValue()};
    L24:
        if ((r10 instanceof String) == false) goto L29;
        Float r13 = StringsKt.toFloatOrNull((String) r10);
        if (r13 != null) goto L55;
        return null;
    L55:
        return new float[]{r13.floatValue()};
    L29:
        if ((r10 instanceof JSONObject) == false) goto L56;
        JSONObject r14 = (JSONObject) r10;
        if (r14.has("thresholds") == false) goto L34;
        return parseThresholdValueList(r14.opt("thresholds"));
    L34:
        if (r14.has("threshold") == false) goto L37;
        return parseThresholdValueList(r14.opt("threshold"));
    L37:
        if (r14.has("list") == false) goto L42;
        JSONArray r15 = r14.optJSONArray("list");
        if (r15 != null) goto L60;
        return null;
    L60:
        return parseThresholdValueList(r15);
    L42:
        if (r14.has("data") == false) goto L61;
        JSONArray r16 = r14.optJSONArray("data");
        if (r16 != null) goto L46;
        return null;
    L46:
        return parseThresholdValueList(r16);
    L61:
        return null;
    L56:
        return null;
    }

    private final String resolveThresholdKey(Context r11) {
        Locale r12 = getCurrentLocale(r11);
        String r0 = r12.getLanguage();
        Locale r1 = Locale.ROOT;
        String r2 = r0.toLowerCase(r1);
        String r3 = r12.getCountry().toLowerCase(r1);
        String r13 = r12.toLanguageTag();
        Intrinsics.checkNotNull(r13);
        String r4 = r13.toLowerCase(r1);
        String r5 = StringsKt.substringBefore$default(r4, '-', null, 2, null);
        boolean r8 = true;
        if (Intrinsics.areEqual(r2, CANTONESE_LANGUAGE) == false) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (Intrinsics.areEqual(r5, CHINESE_LANGUAGE) == true) goto L12;
    L16:
        r8 = false;
    L17:
        if (r6 == true) goto L21;
        if (r8 == true) goto L21;
        String r7 = DEFAULT_THRESHOLD_KEY;
    L22:
        LogUtils.d(TAG, "resolveThresholdKey language = " + r2 + ", country = " + r3 + ", languageTag = " + r13 + ", thresholdKey = " + r7, new Object[0]);
        return r7;
    L21:
        r7 = HK_THRESHOLD_KEY;
        goto L22
    L12:
        if (Intrinsics.areEqual(r3, HONG_KONG_REGION) == true) goto L17;
        if (StringsKt.contains$default(r4, HONG_KONG_LANGUAGE_TAG, false, 2, null) == false) goto L16;
    L5:
        if (Intrinsics.areEqual(r5, CANTONESE_LANGUAGE) == true) goto L8;
        r6 = false;
        goto L10
    }

    private final float[] findThresholdsFromArray(JSONArray r6, String r7) {
        int r0 = r6.length();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L10;
        float[] r4 = parseThresholdEntry(r6.opt(r2), r7);
        if (r4 != null) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        LogUtils.d(TAG, "findThresholdsFromArray matched version at index = " + r2 + ", targetVersion = " + r7, new Object[0]);
        return r4;
    L10:
        LogUtils.w(TAG, "findThresholdsFromArray no matched version, targetVersion = " + r7, new Object[0]);
        return null;
    }

    private final boolean isSameThresholds(float[] r1, float[] r2) {
        if (r1 != null) goto L5;
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        return Arrays.equals(r1, r2);
    L9:
        return false;
    }

    private final float[] parseThresholdEntry(Object r5, String r6) {
        if ((r5 instanceof JSONObject) == false) goto L16;
        JSONObject r7 = (JSONObject) r5;
        String r0 = r7.optString("version", r7.optString("model_version", r7.optString("voiceprint-model-version", "")));
        if (TextUtils.isEmpty(r0) == true) goto L22;
        if (TextUtils.equals(r0, r6) == true) goto L9;
        LogUtils.d(TAG, "parseThresholdEntry version mismatch, expect = " + r6 + ", actual = " + r0, new Object[0]);
        return null;
    L9:
        LogUtils.d(TAG, "parseThresholdEntry version matched, version = " + r0, new Object[0]);
        if (r7.has("thresholds") == false) goto L12;
        Object r8 = r7.opt("thresholds");
    L21:
        return parseThresholdValueList(r8);
    L12:
        r8 = r7.opt("threshold");
        goto L21
    L22:
        return findThresholdsFromObject(r7, r6, DEFAULT_THRESHOLD_KEY);
    L16:
        if ((r5 instanceof JSONArray) == false) goto L19;
        return findThresholdsFromArray((JSONArray) r5, r6);
    L19:
        return parseThresholdValueList(r5);
    }

    private final float[] findThresholdsFromObject(JSONObject r8, String r9, String r10) {
        if (r8.has("version") == true) goto L49;
        if (r8.has("threshold") == true) goto L49;
        if (r8.has("thresholds") == true) goto L49;
        if (r8.has(DEFAULT_THRESHOLD_KEY) == false) goto L12;
    L31:
        boolean r0 = r8.has(r10);
        Object r2 = r8.opt(r10);
        if (r2 != null) goto L34;
        r2 = r8.opt(DEFAULT_THRESHOLD_KEY);
    L34:
        StringBuilder r5 = new StringBuilder("findThresholdsFromObject use scoped config, thresholdKey = ");
        r5.append(r10);
        r5.append(", useExactKey = ");
        r5.append(r0);
        r5.append(", fallbackToDefault = ");
        if (r0 == false) goto L37;
    L39:
        boolean r11 = false;
    L40:
        r5.append(r11);
        LogUtils.d(TAG, r5.toString(), new Object[0]);
        if ((r2 instanceof JSONObject) == false) goto L44;
        return findThresholdsFromObject((JSONObject) r2, r9, DEFAULT_THRESHOLD_KEY);
    L44:
        if ((r2 instanceof JSONArray) == false) goto L47;
        return findThresholdsFromArray((JSONArray) r2, r9);
    L47:
        return parseThresholdValueList(r2);
    L37:
        if (r8.has(DEFAULT_THRESHOLD_KEY) == false) goto L39;
        r11 = true;
        goto L40
    L12:
        if (r8.has(r10) == true) goto L31;
        float[] r1 = parseThresholdValueList(r8.opt(r9));
        if (r1 == null) goto L17;
        return r1;
    L17:
        JSONArray r3 = r8.optJSONArray("list");
        if (r3 != null) goto L20;
        JSONArray r4 = r8.optJSONArray("data");
        if (r4 != null) goto L24;
        JSONArray r12 = r8.optJSONArray("thresholds");
        if (r12 != null) goto L28;
        LogUtils.w(TAG, "findThresholdsFromObject no valid scoped config, targetVersion = " + r9 + ", thresholdKey = " + r10, new Object[0]);
        return null;
    L28:
        return parseThresholdValueList(r12);
    L24:
        return findThresholdsFromArray(r4, r9);
    L20:
        return findThresholdsFromArray(r3, r9);
    L49:
        return parseThresholdEntry(r8, r9);
    }

    private final float[] parseThresholds(String r8, String r9, String r10) {
        String r4 = StringsKt.trim(r8).toString();     // Catch: Exception -> L12
        if (StringsKt.startsWith$default(r4, "[", false, 2, null) == false) goto L8;
        float[] r11 = findThresholdsFromArray(new JSONArray(r4), r9);     // Catch: Exception -> L12
    L16:
        return r11;
    L8:
        if (StringsKt.startsWith$default(r4, "{", false, 2, null) == false) goto L10;
        r11 = findThresholdsFromObject(new JSONObject(r4), r9, r10);     // Catch: Exception -> L12
        goto L16
    L10:
        LogUtils.w(TAG, "parseThresholds unknown config format: " + r8, new Object[0]);     // Catch: Exception -> L12
        return null;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "parseThresholds error: " + e.getMessage(), new Object[0]);
        return null;
    }
}
