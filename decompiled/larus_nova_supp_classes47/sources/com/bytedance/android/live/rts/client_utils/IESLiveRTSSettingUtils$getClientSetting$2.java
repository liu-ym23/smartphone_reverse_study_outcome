package com.bytedance.android.live.rts.client_utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"parseTarget", "", "", "", "key", "value", "invoke"}, k = 3, mv = {1, 4, 3})
public final class IESLiveRTSSettingUtils$getClientSetting$2 extends Lambda implements Function2<String, Object, Map<String, ? extends Object>> {
    public static final IESLiveRTSSettingUtils$getClientSetting$2 INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/rts/client_utils/IESLiveRTSSettingUtils$getClientSetting$2$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Object>> {
        public a() {
        }
    }

    static {
        INSTANCE = new IESLiveRTSSettingUtils$getClientSetting$2();
    }

    public IESLiveRTSSettingUtils$getClientSetting$2() {
        super(2);
    }

    public final Map<String, Object> invoke(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Gson r0 = GsonHelper.get();
        if ((r5 instanceof JSONObject) == false) goto L6;
        JsonElement r6 = GsonProtectorUtils.toJsonTree(r0, GsonProtectorUtils.fromJson(r0, r5.toString(), Object.class));
    L16:
        return MapsKt.mapOf(TuplesKt.to(Constants.Keys.DATA, MapsKt.mapOf(TuplesKt.to(r4, c.a(r6, true)))));
    L6:
        if ((r5 instanceof JSONArray) == false) goto L9;
        Type r1 = new a().getType();
        r6 = GsonProtectorUtils.toJsonTree(r0, GsonProtectorUtils.fromJson(r0, r5.toString(), r1));
        goto L16
    L9:
        if ((r5 instanceof Boolean) == true) goto L11;
        r6 = GsonProtectorUtils.toJsonTree(r0, r5);
        goto L16
    L11:
        if (((Boolean) r5).booleanValue() == false) goto L13;
        r6 = GsonProtectorUtils.toJsonTree(r0, 1);
        goto L16
    L13:
        r6 = GsonProtectorUtils.toJsonTree(r0, 0);
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, r2);
    }
}
