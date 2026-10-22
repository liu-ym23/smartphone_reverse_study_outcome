package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.SdkParamsOptimizeConfig;
import com.bytedance.android.livesdkapi.depend.model.live.StreamDataOptimizeConfig;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ,\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\rR#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \u0005*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/core/utils/rxutils/StreamDataUtil;", "", "()V", "parseCdnName", "", "kotlin.jvm.PlatformType", "getParseCdnName", "()Ljava/lang/Integer;", "parseCdnName$delegate", "Lkotlin/Lazy;", "sdkParamsCache", "Lcom/bytedance/android/live/core/utils/rxutils/FIFOConcurrentMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lorg/json/JSONObject;", "sdkParamsOptimizeConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/SdkParamsOptimizeConfig;", "getSdkParamsOptimizeConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/SdkParamsOptimizeConfig;", "sdkParamsOptimizeConfig$delegate", "streamDataCache", "streamDataOptimizeConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamDataOptimizeConfig;", "getStreamDataOptimizeConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamDataOptimizeConfig;", "streamDataOptimizeConfig$delegate", "getCdnName", "dataObj", "getResolutionSdkParamsObj", "streamDataString", "sdkKey", "getSdkParamsObject", "currentResolution", "level", "getStreamDataObject", "multiStreamData", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamDataUtil {
    public static final StreamDataUtil INSTANCE = null;
    private static final Lazy parseCdnName$delegate = null;
    private static FIFOConcurrentMap<Integer, ConcurrentHashMap<String, JSONObject>> sdkParamsCache;
    private static final Lazy sdkParamsOptimizeConfig$delegate = null;
    private static FIFOConcurrentMap<Integer, JSONObject> streamDataCache;
    private static final Lazy streamDataOptimizeConfig$delegate = null;

    private StreamDataUtil() {
    }

    private final Integer getParseCdnName() {
        return (Integer) parseCdnName$delegate.getValue();
    }

    private final SdkParamsOptimizeConfig getSdkParamsOptimizeConfig() {
        return (SdkParamsOptimizeConfig) sdkParamsOptimizeConfig$delegate.getValue();
    }

    private final StreamDataOptimizeConfig getStreamDataOptimizeConfig() {
        return (StreamDataOptimizeConfig) streamDataOptimizeConfig$delegate.getValue();
    }

    static {
        StreamDataUtil r0 = new StreamDataUtil();
        INSTANCE = r0;
        streamDataOptimizeConfig$delegate = LazyKt.lazy(StreamDataUtil$streamDataOptimizeConfig$2.INSTANCE);
        sdkParamsOptimizeConfig$delegate = LazyKt.lazy(StreamDataUtil$sdkParamsOptimizeConfig$2.INSTANCE);
        parseCdnName$delegate = LazyKt.lazy(StreamDataUtil$parseCdnName$2.INSTANCE);
        if (r0.getStreamDataOptimizeConfig().getEnableOptimize() == false) goto L6;
        streamDataCache = new FIFOConcurrentMap(r0.getStreamDataOptimizeConfig().getCacheSize(), r0.getStreamDataOptimizeConfig().getEnableRemoveAll());
    L6:
        if (r0.getSdkParamsOptimizeConfig().getEnableOptimize() == false) goto L9;
        sdkParamsCache = new FIFOConcurrentMap(r0.getSdkParamsOptimizeConfig().getCacheSize(), r0.getSdkParamsOptimizeConfig().getEnableRemoveAll());
        return;
    }

    public final String getCdnName(JSONObject r5) {
        Integer r0 = getParseCdnName();
        if (r0 != null) goto L6;
    L7:
        return null;
    L6:
        if (r0.intValue() != 1) goto L7;
        if (r5 == null) goto L14;
        JSONObject r6 = r5.optJSONObject("origin");
        if (r6 == null) goto L14;
        JSONObject r7 = r6.optJSONObject("main");
        if (r7 == null) goto L14;
        String r8 = r7.optString("flv");
    L15:
        if (r8 != null) goto L48;
        return null;
    L48:
        String r9 = new URL(r8).getHost();     // Catch: Exception -> L47
        if (StringsKt.contains$default(r9, "96", false, 2, null) == false) goto L22;
        String r11 = "mobile_cdn";
    L46:
        return r11;
    L22:
        if (StringsKt.contains$default(r9, "95", false, 2, null) == false) goto L25;
        r11 = "telecom_cdn";
        goto L46
    L25:
        if (StringsKt.contains$default(r9, "26", false, 2, null) == false) goto L28;
        r11 = "hw";
        goto L46
    L28:
        if (StringsKt.contains$default(r9, "13", false, 2, null) == false) goto L31;
        r11 = "baidu";
        goto L46
    L31:
        if (StringsKt.contains$default(r9, "11", false, 2, null) == false) goto L34;
        r11 = "tencent";
        goto L46
    L34:
        if (StringsKt.contains$default(r9, "6", false, 2, null) == false) goto L37;
        r11 = "ksyun";
        goto L46
    L37:
        if (StringsKt.contains$default(r9, "5", false, 2, null) == false) goto L40;
        r11 = "fcdn";
        goto L46
    L40:
        if (StringsKt.contains$default(r9, "3", false, 2, null) == false) goto L42;
        r11 = "aliyun";
        goto L46
    L42:
        if (StringsKt.contains$default(r9, GamePromoteDataContext.GAME_TYPE_MOBILE, false, 2, null) == false) goto L50;
        r11 = "wangsu";
        goto L46
    L50:
        return null;
    L51:
        return null;
    L14:
        r8 = null;
        goto L15
    }

    public final JSONObject getStreamDataObject(String r3) {
        Intrinsics.checkNotNullParameter(r3, "multiStreamData");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        if (getStreamDataOptimizeConfig().getEnableOptimize() == false) goto L27;
        FIFOConcurrentMap<Integer, JSONObject> r1 = streamDataCache;     // Catch: Exception -> L21
        if (r1 == null) goto L14;
        JSONObject r2 = r1.get(Integer.valueOf(r3.hashCode()));     // Catch: Exception -> L21
    L15:
        if (r2 != null) goto L24;
        JSONObject r4 = new JSONObject(r3);     // Catch: Exception -> L21
        FIFOConcurrentMap<Integer, JSONObject> r5 = streamDataCache;     // Catch: Exception -> L21
        if (r5 == null) goto L25;
        r5.put(Integer.valueOf(r3.hashCode()), r4);     // Catch: Exception -> L21
        return r4;
    L25:
        return r4;
    L24:
        return r2;
    L14:
        r2 = null;
        goto L15
    L27:
        return new JSONObject(r3);
    L22:
        return new JSONObject();
    L8:
        return new JSONObject();
    L5:
        r0 = false;
        goto L6
    }

    public final JSONObject getResolutionSdkParamsObj(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "streamDataString");
        Intrinsics.checkNotNullParameter(r3, "sdkKey");
        FIFOConcurrentMap<Integer, ConcurrentHashMap<String, JSONObject>> r0 = sdkParamsCache;
        if (r0 == null) goto L7;
        ConcurrentHashMap<String, JSONObject> r4 = r0.get(Integer.valueOf(r2.hashCode()));
        if (r4 == null) goto L7;
        return r4.get(r3);
    L7:
        return null;
    }

    public final JSONObject getSdkParamsObject(String r4, JSONObject r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "streamDataString");
        Intrinsics.checkNotNullParameter(r6, "currentResolution");
        Intrinsics.checkNotNullParameter(r7, "level");
        boolean r1 = true;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L42;
        if (r5 == null) goto L42;
        JSONObject r8 = r5.optJSONObject(r6);
        if (r8 == null) goto L15;
        JSONObject r9 = r8.optJSONObject(r7);
        if (r9 == null) goto L15;
        String r11 = r9.optString("sdk_params");
        if (r11 == null) goto L15;
    L17:
        if (r11.length() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L22;
        if (getSdkParamsOptimizeConfig().getEnableOptimize() == false) goto L46;
        FIFOConcurrentMap<Integer, ConcurrentHashMap<String, JSONObject>> r12 = sdkParamsCache;     // Catch: Exception -> L39
        if (r12 == null) goto L45;
        ConcurrentHashMap<String, JSONObject> r2 = r12.get(Integer.valueOf(r4.hashCode()));     // Catch: Exception -> L39
        if (r2 == null) goto L30;
        JSONObject r3 = r2.get(r6);     // Catch: Exception -> L39
    L31:
        if (r2 != null) goto L33;
        r2 = new ConcurrentHashMap();     // Catch: Exception -> L39
        r3 = new JSONObject(r11);     // Catch: Exception -> L39
        r2.put(r6, r3);     // Catch: Exception -> L39
    L35:
        r12.put(Integer.valueOf(r4.hashCode()), r2);     // Catch: Exception -> L39
        return r3;
    L33:
        if (r3 != null) goto L35;
        r3 = new JSONObject(r11);     // Catch: Exception -> L39
        r2.put(r6, r3);     // Catch: Exception -> L39
        goto L35
    L30:
        r3 = null;
        goto L31
    L45:
        return new JSONObject(r11);
    L46:
        return new JSONObject(r11);
    L40:
        return new JSONObject();
    L22:
        return new JSONObject();
    L15:
        r11 = "";
    L42:
        return new JSONObject();
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ JSONObject getSdkParamsObject$default(StreamDataUtil r0, String r1, JSONObject r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "origin";
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = "main";
    L9:
        return r0.getSdkParamsObject(r1, r2, r3, r4);
    }
}
