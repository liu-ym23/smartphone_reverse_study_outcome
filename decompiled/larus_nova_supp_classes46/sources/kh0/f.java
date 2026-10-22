package kh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.q;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements q {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ EffectManager c;
    public final /* synthetic */ c.a d;

    public final void b() {
        c(new Exception("贴纸sync失败。[panel=" + this.b + ", name=" + this.a + ']'));
    }

    public final void a(EffectChannelResponse r5) {
        Effect r0 = null;
        Object r1 = null;
        r0 = null;
        if (r5 == null) goto L13;
        List r6 = r5.getAllCategoryEffects();
        if (r6 == null) goto L13;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        Object r2 = r7.next();
        if (Intrinsics.areEqual(((Effect) r2).getName(), this.a) == false) goto L8;
        r1 = r2;
    L12:
        r0 = (Effect) r1;
    L13:
        if (r0 != null) goto L16;
        c(new Exception("在{" + this.b + "}中没有找到相应贴纸" + this.a));
        return;
    L16:
        if (DownloadableModelSupport.isInitialized() == false) goto L23;
        if (DownloadableModelSupport.getInstance().isEffectReady(this.c, r0) == false) goto L23;
        ALogger.i("CommonStickerManager", "#RevenueStickerDebug# DownloadableModelSupport isEffectReady=true. name: " + this.a);
        Sticker r8 = com.bytedance.android.live.effect.utils.b.a().convertStickerBean(r0);
        c.a r3 = this.d;
        if (r3 == null) goto L35;
        r3.a(r8);
        return;
    L35:
        return;
    L23:
        if (DownloadableModelSupport.isInitialized() == false) goto L25;
    L29:
        this.c.fetchEffect(r0, new e(this));
        return;
    L25:
        if (this.c.isEffectDownloaded(r0) == false) goto L29;
        Sticker r9 = com.bytedance.android.live.effect.utils.b.a().convertStickerBean(r0);
        c.a r4 = this.d;
        if (r4 == null) goto L37;
        r4.a(r9);
        return;
    }

    public final void c(Exception r8) {
        ii0.b r0 = ii0.b.a;
        String r1 = this.b;
        String r2 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "e");
        Intrinsics.checkNotNullParameter(r1, "panel");
        Intrinsics.checkNotNullParameter(r2, "name");
        ALogger.e("[GuestBattle]GuestBattleWidget", "loki effect download failed panel: " + r1 + " , name: " + r2);
        JSONObject r5 = new JSONObject();
        r5.put("panel", r1);
        r5.put("name", r2);
        ii0.b.m(r8, r5);
        r0.o("battle_loki_effect_download_failed", r5);
        x.t0("battle_loki_effect_download_failed", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra", r5.toString())}));
        c.a r3 = this.d;
        if (r3 == null) goto L5;
        r3.onError(r8);
    L5:
        ALogger.w("CommonStickerManager", "#RevenueStickerDebug# [notifyOnError] name: " + this.a + ", error: " + r8);
    }

    public f(String r1, String r2, EffectManager r3, d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
