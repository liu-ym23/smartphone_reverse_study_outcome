package com.bytedance.android.live.effect.avadjust;

import android.os.Looper;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {
    public final List<Sticker> a;
    public final List<Sticker> b;
    public final List<b> c;
    public final com.bytedance.android.live.effect.sticker.e d;
    public final LiveEffectContextFactoryDelegate$Type e;

    public static final class a {
    }

    public interface b {
        void onError();

        void onSuccess();
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r1);
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.e;
    }

    public l(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.e = r2;
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new com.bytedance.android.live.effect.sticker.e("live_adjustment");
    }

    @Deprecated(message = "")
    public final void d(Sticker r22) {
        Intrinsics.checkNotNullParameter(r22, "sticker");
        boolean r1 = y50.c.a;
        long r3 = y50.c.g("av_adjust_updateLocalTagValue");
        List<String> r5 = LiveEffectContext.h;
        ILiveEffectComposerManager r6 = LiveEffectContext.a.a(this.e).a();
        List<Sticker> r7 = this.b;
        ArrayList r8 = new ArrayList();
        Iterator r9 = ((CopyOnWriteArrayList) r7).iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r11 = r9.next();
        if (StringUtils.equal(((Sticker) r11).getResourceId(), r22.getResourceId()) == false) goto L4;
        r8.add(r11);
        goto L4
    L8:
        Iterator r2 = r8.iterator();
    L10:
        if (r2.hasNext() == false) goto L20;
        Sticker r13 = (Sticker) r2.next();
        Sticker.ComposerConfig r14 = r13.getSmallItemConfig();
        if (r14 == null) goto L10;
        if (r6.G(r13.getEffectId(), r14.getTag()) != null) goto L10;
        ILiveEffectComposerManager.f.a(r6, "live_adjustment", r13, "LiveSmallItemBeautyHelper_updateLocalTagValue", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), null, 48);
        Float r12 = r6.G(r13.getEffectId(), r14.getTag());
        if (r12 == null) goto L18;
        float r15 = r12.floatValue();
    L19:
        String r16 = r14.getTag();
        ILiveEffectComposerManager.f.d(r6, "live_adjustment", r13, r16, r15, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 16);
        goto L10
    L18:
        r15 = com.bytedance.android.live.effect.q.d(r13, r14.getDefaultValue());
        goto L19
    L20:
        boolean r4 = y50.c.a;
        y50.c.h("av_adjust_updateLocalTagValue", r3);
    }

    public static void b(l r9, LiveColorAdjustFragment.b r11) {
        r9.getClass();
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadAvAdjustData");
        LiveColorAdjustHelper$loadAvAdjustData$listener$1 r4 = new LiveColorAdjustHelper$loadAvAdjustData$listener$1(r9, r11);
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(r9.e).b().d().a("live_adjustment", r4, true, true, false, true);
    }

    public static void c(l r4, Sticker r5, boolean r6) {
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "sticker");
        LiveColorAdjustHelper$tryDownloadSticker$1 r1 = new LiveColorAdjustHelper$tryDownloadSticker$1(Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())));
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(r4.e).b().r().q(r5) == false) goto L10;
        if (r6 == false) goto L6;
        AndroidSchedulers.mainThread().scheduleDirect(new p(r4, r5));
    L6:
        AndroidSchedulers.mainThread().scheduleDirect(new q(null, r5));
        Iterator r7 = ((CopyOnWriteArrayList) r4.c).iterator();
    L8:
        if (r7.hasNext() == false) goto L13;
        b r8 = (b) r7.next();
        AndroidSchedulers.mainThread().scheduleDirect(new o(r8, r5));
        goto L8
    L13:
        return;
    L10:
        LiveEffectContext.a.a(r4.e).b().r().g("live_adjustment", r5, new r(r4, r1, null, r6));
    }

    public static Sticker a(l r3, List r4, Effect r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "stickerList");
        Intrinsics.checkNotNullParameter(r5, NewBroadcastMonitor.STAGE.EFFECT);
        Sticker r0 = com.bytedance.android.live.effect.sticker.d.b(r5);
        r0.setParentResId(r7);
        JsonObject r8 = new JsonParser().parse(r5.getExtra()).getAsJsonObject();     // Catch: Throwable -> L14
        JsonElement r9 = r8.get("video_tag");     // Catch: Throwable -> L14
        if (r9 == null) goto L7;
        String r11 = r9.getAsString();     // Catch: Throwable -> L14
        if (r11 == null) goto L7;
    L8:
        String r12 = r8.get("adjustment").getAsString();     // Catch: Throwable -> L14
        JsonArray r13 = new JsonParser().parse(r12).getAsJsonObject().getAsJsonArray("items");     // Catch: Throwable -> L14
        Type r1 = new m().getType();     // Catch: Throwable -> L14
        List r14 = (List) GsonHelper.get().fromJson(r13, r1);     // Catch: Throwable -> L14
        r0.setComposerConfigList(r14);     // Catch: Throwable -> L14
        r0.setVideoTag(r11);     // Catch: Throwable -> L14
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L14
    L10:
        if (r15.hasNext() == false) goto L12;
        Sticker.ComposerConfig r16 = (Sticker.ComposerConfig) r15.next();     // Catch: Throwable -> L14
        r0.getUpdateKeys().add(r16.getTag());     // Catch: Throwable -> L14
        goto L10
    L12:
        ((CopyOnWriteArrayList) r4).add(r0);     // Catch: Throwable -> L14
        c(r3, r0, r6);     // Catch: Throwable -> L14
    L16:
        return r0;
    L7:
        r11 = "";
    L14:
        th = move-exception;
        ALogger.e("ttlive_anchor_effect_LiveColorAdjustHelper", th);
        goto L16
    }
}
