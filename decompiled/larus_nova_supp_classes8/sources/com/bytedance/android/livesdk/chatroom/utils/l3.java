package com.bytedance.android.livesdk.chatroom.utils;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.feed.LiveFeedType;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.search.api.ILiveSearchService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.config.du;
import com.bytedance.android.livesdk.config.feed.LiveFeedDynamic;
import com.bytedance.android.livesdk.config.kx;
import com.bytedance.android.livesdk.config.pp;
import com.bytedance.android.livesdk.config.r5;
import com.bytedance.android.livesdk.config.sv;
import com.bytedance.android.livesdk.config.wo;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.live.model.LiveInnerUrl;
import com.bytedance.android.livesdk.live.model.LiveNotFeedInnerUrl;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.feed.LiveDrawerUrlHelper;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.live.model.LiveConvergeInnerUrl;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l3 {

    public class a extends TypeToken<HashMap<String, String>> {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v70 */
    public static f0 a(Bundle r31, Bundle r32, String r33, String r34) {
        k3 r4 = new k3.a().a;
        r4.a = r33;
        r4.b = r34;
        Intrinsics.checkNotNullParameter(r31, "intent");
        Intrinsics.checkNotNullParameter(r32, "enterExtra");
        ILiveSearchService r6 = jc1.k.f(ILiveSearchService.class);
        if (Intrinsics.areEqual("general_search", r4.a) == true) goto L5;
    L7:
        boolean r7 = false;
    L9:
        if (Intrinsics.areEqual("im_watch_assistant", r4.a) == false) goto L13;
        if (Intrinsics.areEqual("im_rec_live_card", r4.b) == false) goto L13;
    L16:
        boolean r10 = true;
    L18:
        boolean r11 = r32.getBoolean("disable_inner_drawer", false);
        if (r31.getInt("from_drawer", 0) != 1) goto L21;
        boolean r12 = true;
    L22:
        String r15 = r31.getString("live.intent.extra.MULTI_ROOM_PROVIDER", "");
        if (r15 == null) goto L25;
        boolean r16 = r15.equals("true");
    L26:
        boolean r8 = Intrinsics.areEqual(r31.getString("isInnerFromDrawer", ""), "true");
        boolean r2 = Intrinsics.areEqual(r32.getString("is_mini_window", ""), "1");
        String r5 = LiveDrawerUrlHelper.getSourceKey(r4.a, r4.b, sv.a.getValue(), r31);
        if (TextUtils.isEmpty(r5) == false) goto L29;
        String r9 = r31.getString("source_key_from_schema", null);
        r31.remove("source_key_from_schema");
        r5 = r9;
    L29:
        String r13 = r31.getString("extra_multi_tab_sub_not_same_stream_source_key", null);
        if (Intrinsics.areEqual("homepage_tablive", r4.a) == true) goto L32;
    L36:
        boolean r3 = false;
    L37:
        boolean r21 = !TextUtils.isEmpty(r31.getString("double_stream_feed_url"));
        String r22 = r5;
        boolean r1 = r31.getBoolean("live.intent.extra.EXTRA_ENTER_HOTSOON_VIDEO_DETAIL", false);
        String r14 = r31.getString("pre_enter_from", "");
        List<String> r17 = kx.a.getValue().a();
        if (r17 == null) goto L44;
        boolean r23 = r3;
        if (r17.contains(r14) == true) goto L42;
    L45:
        boolean r18 = false;
    L47:
        if (r31.getBoolean("live.intent.extra.FIRST_ROOM_FROM_INNER_PREVIEW", false) == false) goto L50;
        r4.c = false;
        r4.d = -1;
    L134:
        String r19 = r22;
    L145:
        Bundle r20 = r32;
        String r110 = null;
    L216:
        String r24 = r19;
    L217:
        boolean r25 = r4.c;
        int r111 = r4.d;
        String r26 = r4.e;
        if (r26 != null) goto L220;
        String r112 = "";
    L221:
        String r113 = r4.f;
        if (r24 != null) goto L224;
        String r114 = "";
    L225:
        f0 r27 = new f0(r25, r111, r112, r113, r114);
        int r28 = m3.a;
        Intrinsics.checkNotNullParameter(r27, "innerDrawData");
        Intrinsics.checkNotNullParameter(r31, "intent");
        String r0 = r31.getString("live.intent.extra.MULTI_ROOM_PROVIDER", "");
        if (r0 == null) goto L228;
        boolean r115 = r0.equals("true");
    L229:
        LiveFeedDynamic r29 = com.bytedance.android.live.core.feed.c.a(r33, r34, LiveFeedType.INNER_FLOW);
        String r30 = r29.getLiveFeedUrl();
        boolean r35 = r29.getCanDraw();
        if (r35 == false) goto L232;
        int r36 = r27.b;
    L233:
        if (r115 == false) goto L235;
        boolean r37 = false;
        int r38 = -1;
    L236:
        String r116 = r27.d;
        String r117 = r27.e;
        Intrinsics.checkNotNullParameter(r30, "url");
        Intrinsics.checkNotNullParameter(r117, "sourceKey");
        Intrinsics.checkNotNullParameter(r30, "urlInput");
        if (((Boolean) LiveSettingKeys.LIVE_FOLLOW_APPEND_RECO.getValue()).booleanValue() == true) goto L239;
    L244:
        boolean r118 = false;
        String r39 = r30;
    L245:
        SettingKey<com.bytedance.android.livesdk.config.u2> r40 = LiveConfigSettingKeys.LIVE_DESKTOP_WIDGET_CONFIG;
        com.bytedance.android.livesdk.config.u2 r119 = (com.bytedance.android.livesdk.config.u2) r40.getValue();
        String r41 = r33 + '+' + r34;
        int r42 = jt1.a.a;
        if (((com.bytedance.android.livesdk.config.u2) r40.getValue()).b() == false) goto L254;
        IHostBusiness r43 = jc1.k.f(IHostBusiness.class);
        if (r43 == null) goto L254;
        if (r43.isSupportRequestPin() != true) goto L254;
        boolean r44 = true;
    L255:
        if (r44 == true) goto L257;
    L259:
        boolean r45 = false;
    L260:
        if (r45 == false) goto L263;
        r39 = t4.a(r30, "content_type", String.valueOf(2));
    L263:
        if (r20.containsKey("dynamic_FEED_ID_PARAMS") == false) goto L302;
        ?? r46 = (Map) new Gson().fromJson(r20.getString("dynamic_FEED_ID_PARAMS"), new a().getType());     // Catch: Exception -> L267
    L268:
        int r47 = q0.a;
        if (r46 != 0) goto L271;
    L272:
        r118 = true;
    L273:
        if (r118 == false) goto L275;
    L297:
        String r120 = r110;
    L299:
        if (StringUtils.isEmpty(r120) == true) goto L302;
        r39 = r39 + r120;
        goto L302
    L275:
        if (StringUtils.isEmpty(r39) == true) goto L297;
        StringBuilder r48 = new StringBuilder();
        Uri r49 = UriProtector.parse(r39);
        Iterator r50 = r46.keySet().iterator();     // Catch: JSONException -> L321
        if (StringUtils.isEmpty(r49.getQuery()) == false) goto L288;
        if (r50.hasNext() == false) goto L288;
        String r51 = (String) r50.next();     // Catch: JSONException -> L321
        String r52 = (String) r46.get(r51);     // Catch: JSONException -> L321
        if (StringUtils.isEmpty(r51) == true) goto L288;
        if (StringUtils.isEmpty(r52) == true) goto L288;
        r48.append("?");     // Catch: JSONException -> L321
        r48.append(r51);     // Catch: JSONException -> L321
        r48.append("=");     // Catch: JSONException -> L321
        r48.append(r52);     // Catch: JSONException -> L321
    L288:
        if (r50.hasNext() == false) goto L296;
        String r53 = (String) r50.next();     // Catch: JSONException -> L321
        String r54 = (String) r46.get(r53);     // Catch: JSONException -> L321
        if (StringUtils.isEmpty(r53) == true) goto L288;
        if (StringUtils.isEmpty(r54) == true) goto L288;
        r48.append("&");     // Catch: JSONException -> L321
        r48.append(r53);     // Catch: JSONException -> L321
        r48.append("=");     // Catch: JSONException -> L321
        r48.append(r54);     // Catch: JSONException -> L321
    L296:
        r120 = r48.toString();
        goto L299
    L271:
        if (r46.isEmpty() == false) goto L273;
    L267:
        r46 = r110;
    L302:
        if (r20.containsKey("live.intent.extra.FEED_URL_REQ_PARAMS") == false) goto L310;
        String r55 = r20.getString("live.intent.extra.FEED_URL_REQ_PARAMS");
        HashMap r56 = new HashMap();
        if (TextUtils.isEmpty(r55) == true) goto L306;
        r56.put("req_param", r55);
    L306:
        String r57 = h2.a(r56, r39);
        if (StringUtils.isEmpty(r57) == true) goto L310;
        r39 = r39 + r57;
    L310:
        if (TTLiveSDK.hostService() == null) goto L320;
        if (TTLiveSDK.hostService().appContext() == null) goto L320;
        LocationResult r58 = TTLiveSDK.hostService().appContext().getNearByLocation();
        if (r58 == null) goto L320;
        if (r39 == null) goto L320;
        if (r39.isEmpty() == true) goto L320;
        String r59 = r58.city;
        String r60 = r58.cityCode;
        ita.l r61 = new ita.l(r39);
        r61.c("city_name", r59);
        r61.c("city_code", r60);
        r39 = r61.d();
    L320:
        return new f0(r37, r38, r39, r116, r117);
    L257:
        if (r119.a().contains(r41) == false) goto L259;
        r45 = true;
    L254:
        r44 = false;
        goto L255
    L239:
        if (((List) LiveConfigSettingKeys.LIVE_FOLLOW_STORY_ENTER_PATTERNS.getValue()).contains(r33 + '+' + r34) == false) goto L244;
        r5 r62 = (r5) LiveSettingKeys.LIVE_FOLLOW_APPEND_RECO_NEW_CONFIG.getValue();
        if (r62.b() == false) goto L243;
        r118 = false;
        r39 = t4.a(t4.a(r30, "content_type", String.valueOf(0)), "channel_id", r62.a());
        goto L245
    L243:
        r118 = false;
        r39 = t4.a(r30, "content_type", String.valueOf(5));
        goto L245
    L235:
        r37 = r35;
        r38 = r36;
        goto L236
    L232:
        r36 = -1;
        goto L233
    L228:
        r115 = false;
        goto L229
    L224:
        r114 = r24;
        goto L225
    L220:
        r112 = r26;
        goto L221
    L50:
        if (r18 == false) goto L52;
        r4.c = false;
        r4.d = -1;
        goto L134
    L52:
        if (r10 == false) goto L54;
        r4.c = false;
        r4.d = -1;
        goto L134
    L54:
        if (r11 == false) goto L56;
        r4.c = false;
        r4.d = -1;
        goto L134
    L56:
        if (r16 == false) goto L58;
        r4.c = false;
        r4.d = -1;
        goto L134
    L58:
        if (r1 == false) goto L60;
        r4.c = false;
        r4.d = -1;
        goto L134
    L60:
        if (r8 == false) goto L68;
        r4.c = true;
        r4.d = 0;
        ILiveService r63 = TTLiveService.getLiveService();
        if (r63 == null) goto L66;
        ILiveOntologyInfoManager r64 = r63.getLiveOntologyRecord();
        if (r64 == null) goto L66;
        String r65 = r64.getInnerUrl();
    L67:
        r4.e = r65;
    L66:
        r65 = null;
        goto L67
    L68:
        if (r7 == false) goto L76;
        if (r6 == null) goto L76;
        if (r6.supportSearch() != true) goto L76;
        if (r6.getSearchSlideType() == 2) goto L76;
        r4.c = false;
        r4.d = -1;
    L76:
        if (r12 == false) goto L95;
        r4.c = true;
        r4.d = 0;
        int r66 = r31.getInt("tab_id", 0);
        String r67 = r31.getString("origin_enter_from", "");
        String r68 = r31.getString("origin_enter_method", "");
        String r121 = r4.a + "_" + r4.b;
        ita.l r122 = new ita.l("/webcast/feed/");
        r122.a("inner_from_drawer", 1);
        r122.a("need_map", 1);
        if (r67 != null) goto L80;
    L83:
        boolean r69 = true;
    L84:
        if (r69 == true) goto L93;
        if (r68 != null) goto L87;
    L90:
        boolean r70 = true;
    L91:
        if (r70 == true) goto L93;
        String r71 = r67 + "_" + r68;
    L94:
        r122.c("source_key", r71);
        r4.e = r122.d();
    L139:
        r24 = r71;
    L141:
        r20 = r32;
        r110 = null;
        goto L217
    L87:
        if (r68.length() == 0) goto L90;
        r70 = false;
    L93:
        r122.a("tab_id", r66);
        r71 = r121;
        goto L94
    L80:
        if (r67.length() == 0) goto L83;
        r69 = false;
        goto L84
    L95:
        Bundle r72 = com.bytedance.android.livesdk.chatroom.m0.a(r31);
        if ("1".equals(r31.getString("enable_feed_drawer", "0")) == true) goto L102;
        if (r72 != null) goto L99;
    L101:
        boolean r73 = false;
    L103:
        if (r73 == false) goto L115;
        r31.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r31.putString("live.intent.extra.WINDOW_MODE", "full_screen");
        if (TTMiddlewareLiveSDK.hostMiddlewareService() != null) goto L107;
    L113:
        String r75 = "";
    L114:
        r31.putString("live.intent.extra.FEED_URL", r75);
        boolean r76 = true;
    L116:
        if (r76 == false) goto L119;
        r4.c = false;
        r4.d = -1;
        r31.putBoolean("live.intent.extra.IS_MULTI", false);
        goto L134
    L119:
        if (TextUtils.isEmpty(h2.b(r31)) == true) goto L125;
        r4.c = true;
        r4.d = 0;
        r4.e = h2.b(r31);
        LiveConvergeInnerUrl r77 = LiveConvergeInnerUrl.Companion.getInnerUrlSetting(r4.a, r4.b);
        if (r77 == null) goto L134;
        if (r77.isValid() == false) goto L134;
        r4.f = r77.getReqFrom();
        goto L134
    L125:
        if (r21 == false) goto L135;
        r4.d = 0;
        Integer r78 = wo.a.getValue();
        if (r78 != null) goto L130;
    L131:
        boolean r79 = true;
    L133:
        r4.c = r79;
        r4.e = r31.getString("double_stream_feed_url");
        goto L134
    L130:
        if (r78.intValue() != 0) goto L131;
        r79 = false;
        goto L133
    L135:
        if (r23 == false) goto L143;
        if (TextUtils.isEmpty(r13) == true) goto L140;
        r4.c = true;
        r4.d = 2;
        ita.l r80 = new ita.l("/webcast/feed/");
        r80.c("source_key", r13);
        r80.a("need_map", 1);
        r4.e = r80.d();
        r71 = r13;
        goto L139
    L140:
        r24 = "";
        goto L141
    L143:
        if (TextUtils.isEmpty(r22) == true) goto L146;
        r4.c = true;
        r4.d = 2;
        ita.l r81 = new ita.l("/webcast/feed/");
        r19 = r22;
        r81.c("source_key", r19);
        r81.a("need_map", 1);
        r4.e = r81.d();
        goto L145
    L146:
        r19 = r22;
        LiveInnerUrl.a r82 = LiveInnerUrl.Companion;
        String r83 = r4.a;
        String r84 = r4.b;
        r82.getClass();
        List<? extends LiveInnerUrl> r85 = pp.a.getValue();
        if (ListUtils.isEmpty(r85) == false) goto L149;
    L192:
        r110 = null;
        LiveInnerUrl r86 = null;
    L193:
        if (r86 != null) goto L195;
    L197:
        LiveNotFeedInnerUrl.a r87 = LiveNotFeedInnerUrl.Companion;
        String r88 = r4.a;
        String r89 = r4.b;
        r87.getClass();
        LiveNotFeedInnerUrl r90 = LiveNotFeedInnerUrl.a.a(r88, r89);
        if (r90 != null) goto L200;
    L203:
        r20 = r32;
        if (r20.getBoolean("live.intent.extra.CURRENT_ROOM_IS_DRAW", false) == false) goto L209;
        if (TextUtils.isEmpty(r20.getString("live.intent.extra.CURRENT_ROOM_INNER_URL", "")) == true) goto L209;
        r4.c = true;
        r4.e = r20.getString("live.intent.extra.CURRENT_ROOM_INNER_URL");
        r4.d = r20.getInt("live.intent.extra.CURRENT_ROOM_DRAW_TYPE", -1);
    L209:
        if (r2 == false) goto L216;
        if (TextUtils.isEmpty(r31.getString("live.intent.extra.XTRA_DRAW_URL")) == true) goto L214;
        r4.c = true;
        r4.e = r31.getString("live.intent.extra.XTRA_DRAW_URL");
        r4.d = 2;
        goto L216
    L214:
        if (r31.getBoolean("live.intent.extra.IS_FROM_XTAB") == false) goto L216;
        r4.c = true;
        r4.d = 2;
        ita.l r91 = new ita.l("/webcast/feed/");
        r91.c("source_key", r4.a + "_" + r4.b);
        r91.a("need_map", 1);
        r4.e = r91.d();
        goto L216
    L200:
        if (r90.isValid() != true) goto L203;
        r4.c = true;
        r4.d = 2;
        r4.e = r90.getPath();
        r4.f = r90.getKey();
    L202:
        r20 = r32;
        goto L216
    L195:
        if (TextUtils.isEmpty(r86.getInnerUrl()) == true) goto L197;
        r4.c = true;
        r4.d = 2;
        r4.e = r86.getInnerUrl();
        r4.f = r86.getReqFrom();
        goto L202
    L149:
        if (TextUtils.isEmpty(r83) == true) goto L192;
        if (TextUtils.isEmpty(r84) == true) goto L192;
        String r92 = r83 + "_" + r84;
        Iterator<? extends LiveInnerUrl> r93 = r85.iterator();
        r86 = null;
    L155:
        if (r93.hasNext() == false) goto L191;
        LiveInnerUrl r123 = r93.next();
        if (r123 == null) goto L159;
        String r124 = r123.getKey();
    L161:
        if (TextUtils.isEmpty(r124) == false) goto L164;
        Iterator<? extends LiveInnerUrl> r210 = r93;
    L190:
        r93 = r210;
        goto L155
    L164:
        if (r123 == null) goto L166;
        String r125 = r123.getKey();
    L168:
        if (TextUtils.equals(r125, r92) == true) goto L169;
        if (r123 == null) goto L172;
        String r126 = r123.getKey();
    L174:
        if (r126 == null) goto L180;
        r210 = r93;
        if (StringsKt.startsWith$default(r123.getKey(), "*", false, 2, null) == true) goto L178;
    L181:
        if (r123 == null) goto L183;
        String r94 = r123.getKey();
    L184:
        if (r94 == null) goto L190;
        if (StringsKt.endsWith$default(r123.getKey(), "*", false, 2, null) == false) goto L190;
        if (StringsKt.startsWith$default(r92, StringsKt.replace$default(r123.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L190;
    L189:
        r86 = r123;
        goto L190
    L183:
        r94 = null;
        goto L184
    L178:
        if (StringsKt.endsWith$default(r92, StringsKt.replace$default(r123.getKey(), "*", "", false, 4, null), false, 2, null) == false) goto L181;
    L180:
        r210 = r93;
        goto L181
    L172:
        r126 = null;
        goto L174
    L169:
        r86 = r123;
        goto L191
    L166:
        r125 = null;
        goto L168
    L159:
        r124 = null;
    L191:
        r110 = null;
        goto L193
    L107:
        if (TTMiddlewareLiveSDK.hostMiddlewareService().hostFeed() == null) goto L113;
        Map r95 = TTMiddlewareLiveSDK.hostMiddlewareService().hostFeed().getFeedTab(-1);
        if (r95 == null) goto L113;
        if ((r95.get("feed_url") instanceof String) == false) goto L113;
        r75 = (String) r95.get("feed_url");
        goto L114
    L115:
        r76 = false;
        goto L116
    L99:
        if ("1".equals(r72.getString("enable_feed_drawer", "0")) == false) goto L101;
    L102:
        r73 = true;
        goto L103
    L42:
        if (du.a.getValue().contains(r14) == false) goto L45;
        r18 = true;
        goto L47
    L44:
        r23 = r3;
        goto L45
    L32:
        if (Intrinsics.areEqual("live_cell", r4.b) == false) goto L36;
        if (r31.getBoolean("multi_tab_sub_not_same_stream_enable", false) == false) goto L36;
        r3 = true;
        goto L37
    L25:
        r16 = false;
        goto L26
    L21:
        r12 = false;
    L13:
        if (Intrinsics.areEqual("im_watch_assistant_card_more", r4.a) == true) goto L15;
    L17:
        r10 = false;
        goto L18
    L15:
        if (Intrinsics.areEqual(LiveEndPageData.TAG_RECOMMEND, r4.b) == false) goto L17;
    L5:
        if (Intrinsics.areEqual("drawer_cover", r4.b) == false) goto L7;
        r7 = true;
        goto L9
    }
}
