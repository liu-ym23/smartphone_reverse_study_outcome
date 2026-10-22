package com.bytedance.android.live.effect.sticker;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.MVBindStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {

    public class a extends TypeToken<Sticker.AigcEffectInfo> {
        public a() {
        }
    }

    public class b extends TypeToken<Sticker.EffectTipsInfo> {
        public b() {
        }
    }

    public class c extends TypeToken<List<MVBindStickerInfo>> {
        public c() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.d$d, reason: collision with other inner class name */
    public class C0191d extends TypeToken<List<Sticker.ComposerConfig>> {
        public C0191d() {
        }
    }

    public class e extends TypeToken<List<Sticker.ComposerConfig>> {
        public e() {
        }
    }

    public static Effect a(Sticker r4) {
        if (r4.getEffect() != null) goto L5;
        Effect r0 = new Effect();
        r0.setId(r4.getRealId());
        r0.setEffectId(r4.getEffectId());
        UrlModel r1 = r4.getIcon();
        if (r1 != null) goto L9;
        com.ss.android.ugc.effectmanager.common.model.UrlModel r2 = new com.ss.android.ugc.effectmanager.common.model.UrlModel();
    L10:
        r0.setIconUrl(r2);
        r0.setUnzipPath(r4.getUnzipPath());
        r0.setHint(r4.getHint());
        r0.setTags(r4.getTags());
        r0.setDownloaded(r4.isDownloaded());
        r0.setEffectId(r4.getEffectId());
        String r3 = r4.getTagsUpdatedAt();
        if (r3 == null) goto L13;
        r0.setTagsUpdatedAt(r3);
    L13:
        r0.setExtra(r4.getExtra());
        r0.setTypes(r4.getTypes());
        String r5 = r4.getSdkExtra();
        if (r5 == null) goto L16;
        r0.setSdkExtra(r5);
    L16:
        return r0;
    L9:
        com.ss.android.ugc.effectmanager.common.model.UrlModel r6 = new com.ss.android.ugc.effectmanager.common.model.UrlModel();
        r6.setUri(r1.getUri());
        r6.setUrlList(r1.getUrlList());
        r2 = r6;
        goto L10
    L5:
        return r4.getEffect();
    }

    public static Sticker b(Effect r4) {
        SystemClock.uptimeMillis();
        Sticker r0 = new Sticker();
        com.ss.android.ugc.effectmanager.common.model.UrlModel r1 = r4.getIconUrl();
        if (r1 != null) goto L5;
        UrlModel r2 = new UrlModel();
    L6:
        r0.setIcon(r2);
        r0.setId(CastLongProtector.valueOf(r4.getEffectId()).longValue());
        r0.setRealId(r4.getId());
        r0.setResourceId(r4.getResourceId());
        r0.setEffectId(r4.getEffectId());
        r0.setUnzipPath(r4.getUnzipPath());
        r0.setHint(r4.getHint());
        r0.setDownloaded(r4.isDownloaded());
        r0.setTags(r4.getTags());
        String r3 = r4.getTagsUpdatedAt();
        if (r3 == null) goto L9;
        r0.setTagsUpdatedAt(r3);
    L9:
        r0.setTypes(r4.getTypes());
        r0.setName(r4.getName());
        r0.setEffect(r4);
        r0.setExtra(r4.getExtra());
        int r5 = com.bytedance.android.live.effect.utils.n.a;
        r0.setComposerConfigList(com.bytedance.android.live.effect.utils.n.b(r4.getExtra()));
        if (r0.getEffect() == null) goto L12;
        r0.setStickerPanel(r0.getEffect().getPanel());
    L12:
        String r6 = r4.getSdkExtra();
        if (r6 == null) goto L15;
        r0.setSdkExtra(r6);
    L15:
        h(r0);
        i(r0);
        com.bytedance.android.live.effect.utils.n.c(r0.getEffect(), r0);
        return r0;
    L5:
        UrlModel r7 = new UrlModel();
        r7.setUri(r1.getUri());
        r7.setUrlList(r1.getUrlList());
        r2 = r7;
        goto L6
    }

    public static Single<Sticker> c(final Effect r1) {
        return Single.create(new com.bytedance.android.live.effect.sticker.c(r1)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Single<List<Sticker>> e(final List<Effect> r1) {
        return Single.create(new com.bytedance.android.live.effect.sticker.b(r1)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }

    public static void h(Sticker r21) {
        if (StringUtils.isEmpty(r21.getExtra()) == false) goto L93;
        if (d0.c.equals(r21.getStickerPanel()) == false) goto L7;
    L10:
        r21.getCoexistGroup().addAll(Arrays.asList(new Integer[]{1, 2}));
        return;
    L7:
        if (d0.e.equals(r21.getStickerPanel()) == true) goto L10;
        if ("live_camera_move".equals(r21.getStickerPanel()) == true) goto L10;
        return;
    L93:
        JsonObject r2 = new JsonParser().parse(r21.getExtra()).getAsJsonObject();     // Catch: Throwable -> L88
        if (r2.has("RepelPanel") == false) goto L17;
        r21.setStickerFeature(r2.get("RepelPanel").getAsInt());     // Catch: Throwable -> L88
    L17:
        if (r2.has("disableEffectPreview") == false) goto L20;
        r21.setDisableEffectPreview(r2.get("disableEffectPreview").getAsInt());     // Catch: Throwable -> L88
    L20:
        if (r2.has("is_blessing_sticker") == false) goto L23;
        r21.setBlessing(r2.get("is_blessing_sticker").getAsBoolean());     // Catch: Throwable -> L88
    L23:
        if (r2.has("game") == false) goto L26;
        r21.setGame(r2.get("game").getAsBoolean());     // Catch: Throwable -> L88
    L26:
        if (r2.has("video_tag") == false) goto L30;
        r21.setVideoTag(r2.get("video_tag").getAsString());     // Catch: Throwable -> L88
    L30:
        if (r2.has("beautyConfig") == false) goto L91;
        List r3 = (List) GsonHelper.get().fromJson(new JsonParser().parse(r2.get("beautyConfig").getAsString()).getAsJsonObject().getAsJsonArray("items"), new C0191d().getType());     // Catch: Throwable -> L88
        r21.setComposerConfigList(r3);     // Catch: Throwable -> L88
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L88
    L33:
        if (r4.hasNext() == false) goto L91;
        r21.getUpdateKeys().add(((Sticker.ComposerConfig) r4.next()).getTag());     // Catch: Throwable -> L88
    L91:
    L48:
        th = move-exception;
        ALogger.e("stickerSdkExtraToModel", th);     // Catch: Throwable -> L88
    L51:
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == false) goto L56;
        if (r2.has("styleType") == false) goto L56;
        r21.setStyleType(r2.get("styleType").getAsInt());     // Catch: Throwable -> L88
    L56:
        if (d0.c.equals(r21.getStickerPanel()) == false) goto L58;
    L61:
        f(r2, r21);     // Catch: Throwable -> L88
    L63:
        if (r2.has("Review_original_frame") == false) goto L66;
        r21.setReviewOriginalFrame(r2.get("Review_original_frame").getAsBoolean());     // Catch: Throwable -> L88
    L66:
        if (LiveEffectSettings.LIVE_ANCHOR_PREVIEW_ENABLE_CAMPAIGN_EFFECT_INSERT.getValue().booleanValue() == false) goto L71;
        if (r2.has("forbidden_linkage_share") == false) goto L71;
        r21.setDisableEffectLink(r2.get("forbidden_linkage_share").getAsBoolean());     // Catch: Throwable -> L88
    L71:
        if (r2.has("enable_customize_duration") == false) goto L74;
        r21.setHasCustomizeDurationConfigFromLoki(true);     // Catch: Throwable -> L88
        r21.setEnableCustomizeDurationFromLoki(r2.get("enable_customize_duration").getAsBoolean());     // Catch: Throwable -> L88
    L74:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_EXTRA_TIPS.getValue().booleanValue() == false) goto L82;
        if (r2.has("tip_text") == false) goto L82;
        Sticker.EffectTipsInfo r0 = new Sticker.EffectTipsInfo();     // Catch: Throwable -> L88
        r0.setTipText(r2.get("tip_text").getAsString());     // Catch: Throwable -> L88
        if (r2.has("jump_url") == false) goto L80;
        r0.setJumpUrl(r2.get("jump_url").getAsString());     // Catch: Throwable -> L88
    L80:
        r21.setEffectExtraTipsInfo(r0);     // Catch: Throwable -> L88
    L82:
        if (r2.has("transfer_type") == false) goto L85;
        r21.setTransferType(r2.get("transfer_type").getAsInt());     // Catch: Throwable -> L88
    L85:
        if (r2.has("layer_map") == false) goto L97;
        r21.setLayerMap(r2.get("layer_map").getAsString());     // Catch: Throwable -> L88
        return;
    L97:
        return;
    L58:
        if (d0.e.equals(r21.getStickerPanel()) == true) goto L61;
        if ("live_camera_move".equals(r21.getStickerPanel()) == false) goto L63;
    L37:
        if (r2.has("beautify") == false) goto L43;
        List r5 = (List) GsonHelper.get().fromJson(new JsonParser().parse(r2.get("beautify").getAsString()).getAsJsonObject().getAsJsonArray("items"), new e().getType());     // Catch: Throwable -> L48
        r21.setComposerConfigList(r5);     // Catch: Throwable -> L48
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L48
    L40:
        if (r6.hasNext() == false) goto L43;
        r21.getUpdateKeys().add(((Sticker.ComposerConfig) r6.next()).getTag());     // Catch: Throwable -> L48
    L43:
        if (r2.has("is_style") == false) goto L51;
        if (r2.get("is_style").getAsBoolean() == false) goto L51;
        r21.setStyleType(1);     // Catch: Throwable -> L48
    L88:
        th = move-exception;
        th.printStackTrace();
    }

    public static void i(Sticker r11) {
        if (StringUtils.isEmpty(r11.getSdkExtra()) == true) goto L38;
        r11.setSdkExtraModel((Sticker.StickerSDKExtra) GsonProtectorUtils.fromJson(GsonHelper.get(), r11.getSdkExtra(), Sticker.StickerSDKExtra.class));
    L31:
        th = move-exception;
        ALogger.e("stickerSdkExtraToModel", th);
        return;
    L7:
        if (r11.getSdkExtra() == null) goto L36;
        JsonObject r7 = new JsonParser().parse(r11.getSdkExtra()).getAsJsonObject();     // Catch: Throwable -> L31
        if (r7.has("live_custom_data") == false) goto L20;
        JsonObject r6 = r7.getAsJsonObject("live_custom_data");     // Catch: Throwable -> L31
        if (r6.has("aigc_info") == false) goto L14;
        JsonObject r4 = r6.getAsJsonObject("aigc_info");     // Catch: Throwable -> L31
        Type r8 = new a().getType();     // Catch: Throwable -> L31
        r11.setAigcEffectInfo((Sticker.AigcEffectInfo) GsonHelper.get().fromJson(r4, r8));     // Catch: Throwable -> L31
    L14:
        if (r6.has("interact_info") == false) goto L17;
        r11.setInteractRules(r6.getAsJsonObject("interact_info").toString());     // Catch: Throwable -> L31
    L17:
        if (r6.has("effect_tips") == false) goto L20;
        JsonObject r0 = r6.getAsJsonObject("effect_tips");     // Catch: Throwable -> L31
        Type r2 = new b().getType();     // Catch: Throwable -> L31
        r11.setEffectTipsInfo((Sticker.EffectTipsInfo) GsonHelper.get().fromJson(r0, r2));     // Catch: Throwable -> L31
    L20:
        if (r7.has("attachment_effect") == false) goto L25;
        String r1 = r7.getAsJsonArray("attachment_effect").toString();     // Catch: Throwable -> L31
        Type r3 = new c().getType();     // Catch: Throwable -> L31
        List r5 = (List) GsonHelper.get().fromJson(r1, r3);     // Catch: Throwable -> L31
        if (r5.isEmpty() == true) goto L25;
        r11.setMvBindStickerInfo((MVBindStickerInfo) ListProtector.get(r5, 0));     // Catch: Throwable -> L31
    L25:
        if (r7.has("enable_customize_duration") == false) goto L28;
        r11.setEnableCustomizeDurationFromExtra(r7.get("enable_customize_duration").getAsBoolean());     // Catch: Throwable -> L31
    L28:
        if (r7.has("effect_duration") == false) goto L37;
        r11.setDefaultDuration(r7.get("effect_duration").getAsLong());     // Catch: Throwable -> L31
        return;
    L37:
        return;
    L36:
        return;
    }

    public static Sticker d(Effect r4, String r5) {
        SystemClock.uptimeMillis();
        Sticker r0 = new Sticker();
        com.ss.android.ugc.effectmanager.common.model.UrlModel r1 = r4.getIconUrl();
        if (r1 != null) goto L5;
        UrlModel r2 = new UrlModel();
    L6:
        r0.setIcon(r2);
        r0.setId(CastLongProtector.valueOf(r4.getEffectId()).longValue());
        r0.setRealId(r4.getId());
        r0.setResourceId(r4.getResourceId());
        r0.setEffectId(r4.getEffectId());
        r0.setUnzipPath(r4.getUnzipPath());
        r0.setHint(r4.getHint());
        r0.setDownloaded(r4.isDownloaded());
        r0.setTags(r4.getTags());
        String r3 = r4.getTagsUpdatedAt();
        if (r3 == null) goto L9;
        r0.setTagsUpdatedAt(r3);
    L9:
        r0.setTypes(r4.getTypes());
        r0.setName(r4.getName());
        r0.setEffect(r4);
        r0.setExtra(r4.getExtra());
        int r6 = com.bytedance.android.live.effect.utils.n.a;
        r0.setComposerConfigList(com.bytedance.android.live.effect.utils.n.b(r4.getExtra()));
        if (r5 == null) goto L15;
        if (r5.isEmpty() == true) goto L15;
        r0.setStickerPanel(r5);
    L17:
        String r7 = r4.getSdkExtra();
        if (r7 == null) goto L20;
        r0.setSdkExtra(r7);
    L20:
        h(r0);
        i(r0);
        com.bytedance.android.live.effect.utils.n.c(r0.getEffect(), r0);
        return r0;
    L15:
        if (r0.getEffect() == null) goto L17;
        r0.setStickerPanel(r0.getEffect().getPanel());
        goto L17
    L5:
        UrlModel r8 = new UrlModel();
        r8.setUri(r1.getUri());
        r8.setUrlList(r1.getUrlList());
        r2 = r8;
        goto L6
    }

    public static void f(JsonObject r6, Sticker r7) {
        if (r6.has("gift_sticker") == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r6.has("gift_sticker_repel_high") == true) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r0 == true) goto L17;
        if (r8 == true) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == true) goto L20;
        if (r8 == true) goto L20;
        return;
    L20:
        r7.getCoexistGroup().clear();
        r7.getCoexistGroup().addAll(Arrays.asList(new Integer[]{1, 2}));
        if (r8 == false) goto L25;
        r7.setHighCost(true);
        return;
    L25:
        return;
    L17:
        r1 = false;
        goto L18
    L11:
        if (r6.get("gift_sticker_repel_high").getAsBoolean() == false) goto L13;
        r8 = true;
        goto L14
    L5:
        if (r6.get("gift_sticker").getAsBoolean() == false) goto L7;
        r0 = true;
        goto L9
    }

    public static boolean g(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L19;
        JsonObject r3 = new JsonParser().parse(r1).getAsJsonObject();     // Catch: Throwable -> L11
        if (r3.has(r2) == false) goto L18;
        return r3.get(r2).getAsBoolean();
    L18:
        return false;
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    L19:
        return false;
    }
}
