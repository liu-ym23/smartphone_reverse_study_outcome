package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/effect/utils/n$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Sticker.ComposerConfig>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/effect/utils/n$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends Sticker.ComposerConfig>> {
        public b() {
        }
    }

    static {
    }

    public static List a(JsonObject r3) {
        List r0 = null;
        JsonElement r4 = r3.get("adjustment");     // Catch: Throwable -> L16
        if (r4 == null) goto L6;
        String r5 = r4.getAsString();     // Catch: Throwable -> L16
    L7:
        JsonElement r6 = new JsonParser().parse(r5);     // Catch: Throwable -> L16
        if (r6 == null) goto L10;
        JsonObject r7 = r6.getAsJsonObject();     // Catch: Throwable -> L16
    L11:
        if (r7 == null) goto L13;
        JsonArray r8 = r7.getAsJsonArray("items");     // Catch: Throwable -> L16
    L14:
        r0 = (List) GsonHelper.get().fromJson(r8, new a().getType());     // Catch: Throwable -> L16
    L18:
        if (r0 == null) goto L20;
        return r0;
    L20:
        return new ArrayList();
    L13:
        r8 = null;
        goto L14
    L10:
        r7 = null;
        goto L11
    L6:
        r5 = null;
    L16:
        th = move-exception;
        ALogger.e("LiveEffectExtraHelper", th);
        goto L18
    }

    public static List b(String r4) {
        List r0 = null;
        if (r4 != null) goto L41;
    L38:
        if (r0 == null) goto L40;
        return r0;
    L40:
        return new ArrayList();
    L41:
        boolean r2 = false;
        if (r4.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        JsonElement r5 = new JsonParser().parse(r4);     // Catch: Throwable -> L36
        if (r5 == null) goto L14;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: Throwable -> L36
    L15:
        if (r6 == null) goto L19;
        JsonElement r7 = r6.get("beautyConfig");     // Catch: Throwable -> L36
        if (r7 == null) goto L19;
        String r8 = r7.getAsString();     // Catch: Throwable -> L36
    L20:
        if (r8 != null) goto L22;
    L23:
        r2 = true;
    L24:
        if (r2 == true) goto L26;
        JsonElement r9 = new JsonParser().parse(r8);     // Catch: Throwable -> L36
        if (r9 == null) goto L30;
        JsonObject r11 = r9.getAsJsonObject();     // Catch: Throwable -> L36
    L31:
        if (r11 == null) goto L33;
        JsonArray r12 = r11.getAsJsonArray("items");     // Catch: Throwable -> L36
    L35:
        r0 = (List) GsonHelper.get().fromJson(r12, new b().getType());     // Catch: Throwable -> L36
        goto L38
    L33:
        r12 = null;
        goto L35
    L30:
        r11 = null;
        goto L31
    L26:
        return new ArrayList();
    L22:
        if (r8.length() != 0) goto L24;
    L19:
        r8 = null;
        goto L20
    L14:
        r6 = null;
        goto L15
    L10:
        return new ArrayList();
    L7:
        r1 = false;
    L36:
        th = move-exception;
        ALogger.e("LiveEffectExtraHelper", th);
        goto L38
    }

    public static void c(Effect r5, Sticker r6) {
        Intrinsics.checkNotNullParameter(r5, NewBroadcastMonitor.STAGE.EFFECT);
        Intrinsics.checkNotNullParameter(r6, "stickerBean");
        String r4 = r5.getExtra();     // Catch: Throwable -> L37
        if (r4 != null) goto L6;
    L9:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
        return;
    L12:
        JsonObject r8 = new JsonParser().parse(r5.getExtra()).getAsJsonObject();     // Catch: Throwable -> L37
        if (r8.has("MakeupType") == false) goto L17;
        r6.setStickerFeature(r8.get("MakeupType").getAsInt());     // Catch: Throwable -> L37
    L17:
        if (r8.has("beautyConfig") == false) goto L23;
        String r9 = r8.get("beautyConfig").getAsString();     // Catch: Throwable -> L37
        JsonArray r11 = new JsonParser().parse(r9).getAsJsonObject().getAsJsonArray("items");     // Catch: Throwable -> L37
        Type r0 = new o().getType();     // Catch: Throwable -> L37
        List r12 = (List) GsonHelper.get().fromJson(r11, r0);     // Catch: Throwable -> L37
        r6.setComposerConfigList(r12);     // Catch: Throwable -> L37
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L37
    L20:
        if (r13.hasNext() == false) goto L47;
        Sticker.ComposerConfig r1 = (Sticker.ComposerConfig) r13.next();     // Catch: Throwable -> L37
        r6.getUpdateKeys().add(r1.getTag());     // Catch: Throwable -> L37
        goto L20
    L47:
        return;
    L23:
        if (r8.has("filterconfig") == false) goto L26;
        Sticker.FilterConfig r14 = (Sticker.FilterConfig) GsonHelper.get().fromJson(r8.get("filterconfig"), Sticker.FilterConfig.class);     // Catch: Throwable -> L37
        r6.setComposerConfigList(CollectionsKt.listOf(new Sticker.ComposerConfig("Filter_intensity", r14.getDefaultLevel(), r14.getMinLevel(), r14.getMaxLevel())));     // Catch: Throwable -> L37
        return;
    L26:
        if (r8.has("adjustment") == false) goto L29;
        r6.setComposerConfigList(a(r8));     // Catch: Throwable -> L37
        return;
    L29:
        if (r8.has("cameraConfig") == true) goto L31;
        return;
    L31:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_INDEPENDENT_CAMERA_MOVEMENT_PANEL.getValue().booleanValue() == false) goto L46;
        String r15 = r8.get("cameraConfig").getAsString();     // Catch: Throwable -> L37
        JsonArray r16 = new JsonParser().parse(r15).getAsJsonObject().getAsJsonArray("items");     // Catch: Throwable -> L37
        Type r2 = new p().getType();     // Catch: Throwable -> L37
        List r17 = (List) GsonHelper.get().fromJson(r16, r2);     // Catch: Throwable -> L37
        r6.setComposerConfigList(r17);     // Catch: Throwable -> L37
        Iterator r18 = r17.iterator();     // Catch: Throwable -> L37
    L34:
        if (r18.hasNext() == false) goto L48;
        Sticker.ComposerConfig r3 = (Sticker.ComposerConfig) r18.next();     // Catch: Throwable -> L37
        r6.getUpdateKeys().add(r3.getTag());     // Catch: Throwable -> L37
        goto L34
    L48:
        return;
    L46:
        return;
    L6:
        if (r4.length() == 0) goto L9;
        r7 = false;
    L37:
        th = move-exception;
        ALogger.e("LiveEffectExtraHelper", th);
    }
}
