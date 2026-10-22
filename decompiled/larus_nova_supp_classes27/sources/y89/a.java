package y89;

import android.content.Context;
import android.net.Uri;
import bf.c;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECAiSearchExtra;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.impl.ECSaasSearchCommand;
import com.ss.android.ugc.aweme.search.common.route.RouteSearchParamsBuilder;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAddressService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.mob.base.BaseSearchSchemaMonitorEvent;
import com.ss.android.ugc.aweme.search.mob.base.SearchSchemaEvent;
import com.ss.android.ugc.aweme.search.model.SearchConfig;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.GsonUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements c {
    public a() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_search";
    }

    public final boolean c(Context r13, Uri r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "uri");
        ECSaasSearchCommand.a.getClass();
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "routeUri");
        Logger.a("SearchCommand", "ec_router= " + r14);
        BaseSearchSchemaMonitorEvent r0 = new BaseSearchSchemaMonitorEvent("ec_search_schema_parse");
        SearchSchemaEvent r1 = new SearchSchemaEvent();
        r0.c = r1;
        r1.a = System.currentTimeMillis();
        ECSearchParam.Builder r2 = new ECSearchParam.Builder();
        Intrinsics.checkNotNullParameter(r14, "routeUri");
        Intrinsics.checkNotNullParameter(r2, "searchParamBuilder");
        new RouteSearchParamsBuilder();
        Intrinsics.checkNotNullParameter(r14, "routeUri");
        Intrinsics.checkNotNullParameter(r2, "searchParamBuilder");
        Set r16 = UriProtector.getQueryParameterNames(r14);
        Set r3 = r16;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Unit r5 = null;
        if (r4 == true) goto L492;
        Iterator r17 = r16.iterator();
    L13:
        if (r17.hasNext() == false) goto L492;
        String r6 = (String) r17.next();
        if (r6 == null) goto L13;
        switch(r6.hashCode()) {
            case -2135058808: goto L488;
            case -2130235764: goto L483;
            case -2051025175: goto L474;
            case -2013051485: goto L469;
            case -1947702144: goto L464;
            case -1936786367: goto L459;
            case -1901827785: goto L454;
            case -1773577784: goto L442;
            case -1696874790: goto L437;
            case -1572211365: goto L432;
            case -1570056317: goto L427;
            case -1512022125: goto L422;
            case -1501985745: goto L417;
            case -1390435021: goto L412;
            case -1330710590: goto L407;
            case -1298782681: goto L398;
            case -1272274258: goto L393;
            case -1244335699: goto L388;
            case -1160605116: goto L383;
            case -1147692044: goto L378;
            case -1101383022: goto L373;
            case -1076964254: goto L368;
            case -1046993439: goto L363;
            case -992137736: goto L358;
            case -934964668: goto L353;
            case -818786127: goto L348;
            case -814408215: goto L343;
            case -794507445: goto L338;
            case -763807553: goto L333;
            case -685906904: goto L328;
            case -657183940: goto L323;
            case -539642911: goto L318;
            case -329995663: goto L313;
            case -311974433: goto L308;
            case -297525420: goto L299;
            case -266558761: goto L294;
            case -196353205: goto L289;
            case -190092677: goto L284;
            case -46719451: goto L279;
            case 3575610: goto L274;
            case 64698861: goto L269;
            case 86846870: goto L264;
            case 96965648: goto L259;
            case 139937063: goto L254;
            case 166131389: goto L249;
            case 191213151: goto L244;
            case 248581099: goto L239;
            case 271909869: goto L236;
            case 338406772: goto L231;
            case 385931614: goto L226;
            case 463013978: goto L221;
            case 495151089: goto L216;
            case 499389714: goto L211;
            case 506361563: goto L206;
            case 532906889: goto L197;
            case 700130234: goto L185;
            case 726831056: goto L180;
            case 858923796: goto L175;
            case 883692091: goto L170;
            case 883893994: goto L165;
            case 894001516: goto L160;
            case 955996655: goto L155;
            case 1005514169: goto L143;
            case 1018731210: goto L138;
            case 1216475079: goto L133;
            case 1299729785: goto L130;
            case 1301273968: goto L121;
            case 1379892991: goto L116;
            case 1416723757: goto L111;
            case 1463800466: goto L106;
            case 1475600463: goto L101;
            case 1477847209: goto L96;
            case 1610110710: goto L90;
            case 1614915556: goto L85;
            case 1631163343: goto L80;
            case 1642811807: goto L75;
            case 1736160442: goto L70;
            case 1781166887: goto L65;
            case 1781191808: goto L60;
            case 1786457275: goto L55;
            case 1819724607: goto L50;
            case 1899359028: goto L45;
            case 1970919567: goto L40;
            case 2020047791: goto L31;
            case 2041397228: goto L26;
            case 2097110929: goto L21;
            default: goto L13;
        };
    L21:
        if (r6.equals("ecom_scene_id") == false) goto L13;
        String r7 = UriProtector.getQueryParameter(r14, r6);
        if (r7 == null) goto L13;
        r2.G = r7;
        Unit r8 = Unit.INSTANCE;
        goto L13
    L26:
        if (r6.equals("hide_keyword") == false) goto L13;
        String r9 = UriProtector.getQueryParameter(r14, r6);
        if (r9 == null) goto L13;
        r2.u = CastIntegerProtector.parseInt(r9);
        Unit r10 = Unit.INSTANCE;
        goto L13
    L31:
        if (r6.equals("float_screen") == false) goto L13;
        String r11 = UriProtector.getQueryParameter(r14, r6);
        if (r11 == null) goto L13;
        r2.a0 = CastFloatProtector.parseFloat(r11);     // Catch: Exception -> L36
    L38:
        Unit r12 = Unit.INSTANCE;
    L36:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "saas_search_parse_schema");
        goto L38
    L40:
        if (r6.equals("delivery_session_id") == false) goto L13;
        String r18 = UriProtector.getQueryParameter(r14, r6);
        if (r18 == null) goto L13;
        r2.z0 = r18;
        Unit r20 = Unit.INSTANCE;
        goto L13
    L45:
        if (r6.equals("ecom_saas_extra") == false) goto L13;
        String r21 = UriProtector.getQueryParameter(r14, r6);
        if (r21 == null) goto L13;
        r2.x0 = r21;
        Unit r22 = Unit.INSTANCE;
        goto L13
    L50:
        if (r6.equals("transition_animation_type") == false) goto L13;
        String r23 = UriProtector.getQueryParameter(r14, r6);
        if (r23 == null) goto L13;
        r2.u0 = CastIntegerProtector.parseInt(r23);
        Unit r24 = Unit.INSTANCE;
        goto L13
    L55:
        if (r6.equals("needBack2Origin") == false) goto L13;
        String r25 = UriProtector.getQueryParameter(r14, r6);
        if (r25 == null) goto L13;
        r2.X = Intrinsics.areEqual("1", r25);
        Unit r26 = Unit.INSTANCE;
        goto L13
    L60:
        if (r6.equals("video_ph_word_info") == false) goto L13;
        String r27 = UriProtector.getQueryParameter(r14, r6);
        if (r27 == null) goto L13;
        r2.M = r27;
        Unit r28 = Unit.INSTANCE;
        goto L13
    L65:
        if (r6.equals("recommend_reason") == false) goto L13;
        String r30 = UriProtector.getQueryParameter(r14, r6);
        if (r30 == null) goto L13;
        r2.s = r30;
        Unit r31 = Unit.INSTANCE;
        goto L13
    L70:
        if (r6.equals("show_content_gid") == false) goto L13;
        String r32 = UriProtector.getQueryParameter(r14, r6);
        if (r32 == null) goto L13;
        r2.k = r32;
        Unit r33 = Unit.INSTANCE;
        goto L13
    L75:
        if (r6.equals("is_hit_ab_page_animation_crowd") == false) goto L13;
        String r34 = UriProtector.getQueryParameter(r14, r6);
        if (r34 == null) goto L13;
        r2.i = Intrinsics.areEqual(r34, "true");
        Unit r35 = Unit.INSTANCE;
        goto L13
    L80:
        if (r6.equals("pass_through_marketing_info") == false) goto L13;
        String r36 = UriProtector.getQueryParameter(r14, r6);
        if (r36 == null) goto L13;
        r2.z = r36;
        Unit r37 = Unit.INSTANCE;
        goto L13
    L85:
        if (r6.equals("display_hint") == false) goto L13;
        String r38 = UriProtector.getQueryParameter(r14, r6);
        if (r38 == null) goto L13;
        r2.l = r38;
        Unit r40 = Unit.INSTANCE;
        goto L13
    L90:
        if (r6.equals("mob_params_extra") == false) goto L13;
        String r41 = UriProtector.getQueryParameter(r14, r6);
        if (r41 == null) goto L94;
        r2.e0 = r41;
        Unit r42 = Unit.INSTANCE;
    L94:
        Logger.a("MobParamDebug", "mobParamsExtra = " + r2.e0);
        goto L13
    L96:
        if (r6.equals("common_search_params") == false) goto L13;
        String r43 = UriProtector.getQueryParameter(r14, r6);
        if (r43 == null) goto L13;
        r2.A = r43;
        Unit r44 = Unit.INSTANCE;
        goto L13
    L101:
        if (r6.equals("author_id") == false) goto L13;
        String r45 = UriProtector.getQueryParameter(r14, r6);
        if (r45 == null) goto L13;
        r2.C = r45;
        Unit r46 = Unit.INSTANCE;
        goto L13
    L106:
        if (r6.equals("search_source") == false) goto L13;
        String r47 = UriProtector.getQueryParameter(r14, r6);
        if (r47 == null) goto L13;
        r2.E = r47;
        Unit r48 = Unit.INSTANCE;
        goto L13
    L111:
        if (r6.equals("video_ph_word") == false) goto L13;
        String r50 = UriProtector.getQueryParameter(r14, r6);
        if (r50 == null) goto L13;
        r2.L = r50;
        Unit r51 = Unit.INSTANCE;
        goto L13
    L116:
        if (r6.equals("room_id") == false) goto L13;
        String r52 = UriProtector.getQueryParameter(r14, r6);
        if (r52 == null) goto L13;
        r2.B = r52;
        Unit r53 = Unit.INSTANCE;
        goto L13
    L121:
        if (r6.equals("ai_search_extra") == false) goto L13;
        String r54 = UriProtector.getQueryParameter(r14, r6);
        if (r54 == null) goto L13;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L126
        r2.w0 = (ECAiSearchExtra) GsonUtil.a().fromJson(r54, new RouteSearchParamsBuilder.buildSearchParams.83.1.tokenType.1().getType());     // Catch: Throwable -> L126
        Object r56 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L126
    L128:
        Result.box-impl(r56);
    L126:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r56 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L128
    L130:
        if (r6.equals("enable_pull_to_full_page") == false) goto L13;
        r2.c = r14.getBooleanQueryParameter(r6, false);
        Unit r58 = Unit.INSTANCE;
        goto L13
    L133:
        if (r6.equals("client_engine_extra") == false) goto L13;
        String r60 = UriProtector.getQueryParameter(r14, r6);
        if (r60 == null) goto L13;
        r2.y = r60;
        Unit r61 = Unit.INSTANCE;
        goto L13
    L138:
        if (r6.equals("search_hint_word_log_id") == false) goto L13;
        String r62 = UriProtector.getQueryParameter(r14, r6);
        if (r62 == null) goto L13;
        r2.o = r62;
        Unit r63 = Unit.INSTANCE;
        goto L13
    L143:
        if (r6.equals("search_config") == false) goto L13;
        String r64 = UriProtector.getQueryParameter(r14, r6);
        if (r64 == null) goto L13;
        Object r65 = GsonUtil.a().fromJson(r64, SearchConfig.class);     // Catch: Throwable -> L149
    L516:
        SearchConfig r66 = (SearchConfig) r65;     // Catch: Exception -> L152
        Logger.a("ECSearchGson", "searchConfigStr = " + r64 + ", searchConfig = " + r66);     // Catch: Exception -> L152
        r2.p0 = r66;     // Catch: Exception -> L152
        Unit r67 = Unit.INSTANCE;     // Catch: Exception -> L152
    L152:
        e = move-exception;
        e.toString();
    L149:
        r65 = null;
        goto L516
    L155:
        if (r6.equals("search_hint_word_id") == false) goto L13;
        String r68 = UriProtector.getQueryParameter(r14, r6);
        if (r68 == null) goto L13;
        r2.n = r68;
        Unit r70 = Unit.INSTANCE;
        goto L13
    L160:
        if (r6.equals("search_channel") == false) goto L13;
        String r71 = UriProtector.getQueryParameter(r14, r6);
        if (r71 == null) goto L13;
        r2.w = r71;
        Unit r72 = Unit.INSTANCE;
        goto L13
    L165:
        if (r6.equals("page_type") == false) goto L13;
        String r73 = UriProtector.getQueryParameter(r14, r6);
        if (r73 == null) goto L13;
        r2.a = CastIntegerProtector.parseInt(r73);
        Unit r74 = Unit.INSTANCE;
        goto L13
    L170:
        if (r6.equals("page_name") == false) goto L13;
        if (UriProtector.getQueryParameter(r14, r6) == null) goto L13;
        Unit r75 = Unit.INSTANCE;
        goto L13
    L175:
        if (r6.equals("trans_event_extra") == false) goto L13;
        String r76 = UriProtector.getQueryParameter(r14, r6);
        if (r76 == null) goto L13;
        r2.c0 = r76;
        Unit r77 = Unit.INSTANCE;
        goto L13
    L180:
        if (r6.equals("from_group_id") == false) goto L13;
        String r78 = UriProtector.getQueryParameter(r14, r6);
        if (r78 == null) goto L13;
        r2.r0 = r78;
        Unit r80 = Unit.INSTANCE;
        goto L13
    L185:
        if (r6.equals("extraLogParams") == false) goto L13;
        String r81 = UriProtector.getQueryParameter(r14, r6);
        if (r81 == null) goto L13;
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L193
        String r83 = new JSONObject(r81).optString("word_reason");     // Catch: Throwable -> L193
        if (r83 != null) goto L191;
        r83 = "";
    L191:
        r2.d0 = r83;     // Catch: Throwable -> L193
        Object r84 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L193
    L195:
        Result.box-impl(r84);
    L193:
        th = move-exception;
        Result.Companion r85 = Result.Companion;
        r84 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L195
    L197:
        if (r6.equals("pendant_params") == false) goto L13;
        String r86 = UriProtector.getQueryParameter(r14, r6);
        if (r86 == null) goto L13;
        Map r87 = (Map) GsonUtil.a().fromJson(r86, Map.class);     // Catch: Throwable -> L203
        Objects.toString(r87);     // Catch: Throwable -> L203
        r2.j0 = r87;     // Catch: Throwable -> L203
        Unit r88 = Unit.INSTANCE;     // Catch: Throwable -> L203
    L203:
        th = move-exception;
        th.toString();
        goto L13
    L206:
        if (r6.equals("group_id") == false) goto L13;
        String r90 = UriProtector.getQueryParameter(r14, r6);
        if (r90 == null) goto L13;
        Logger.a("ParamsDebug", "saas group_id = ".concat(r90));
        r2.h = r90;
        Unit r91 = Unit.INSTANCE;
        goto L13
    L211:
        if (r6.equals("gd_label") == false) goto L13;
        String r92 = UriProtector.getQueryParameter(r14, r6);
        if (r92 == null) goto L13;
        r2.n0 = r92;
        Unit r93 = Unit.INSTANCE;
        goto L13
    L216:
        if (r6.equals("source_btm_token") == false) goto L13;
        String r94 = UriProtector.getQueryParameter(r14, r6);
        if (r94 == null) goto L13;
        r2.o0 = r94;
        Unit r95 = Unit.INSTANCE;
        goto L13
    L221:
        if (r6.equals("search_style") == false) goto L13;
        String r96 = UriProtector.getQueryParameter(r14, r6);
        if (r96 == null) goto L13;
        Intrinsics.checkNotNullParameter(r96, "<set-?>");
        r2.J = r96;
        Unit r97 = Unit.INSTANCE;
        goto L13
    L226:
        if (r6.equals("feed_play_duration") == false) goto L13;
        String r98 = UriProtector.getQueryParameter(r14, r6);
        if (r98 == null) goto L13;
        r2.t0 = CastLongProtector.parseLong(r98);
        Unit r100 = Unit.INSTANCE;
        goto L13
    L231:
        if (r6.equals("promotion_extra") == false) goto L13;
        String r101 = UriProtector.getQueryParameter(r14, r6);
        if (r101 == null) goto L13;
        r2.v0 = r101;
        Unit r102 = Unit.INSTANCE;
        goto L13
    L236:
        if (r6.equals("should_hide_toolbar_function") == false) goto L13;
    L359:
        String r103 = UriProtector.getQueryParameter(r14, r6);
        if (r103 == null) goto L13;
        r2.R = CastIntegerProtector.parseInt(r103);
        Unit r104 = Unit.INSTANCE;
        goto L13
    L239:
        if (r6.equals("search_hint_word") == false) goto L13;
        String r105 = UriProtector.getQueryParameter(r14, r6);
        if (r105 == null) goto L13;
        r2.m = r105;
        Unit r106 = Unit.INSTANCE;
        goto L13
    L244:
        if (r6.equals("search_entrance_style") == false) goto L13;
        String r107 = UriProtector.getQueryParameter(r14, r6);
        if (r107 == null) goto L13;
        r2.H = r107;
        Unit r108 = Unit.INSTANCE;
        goto L13
    L249:
        if (r6.equals("group_result_id") == false) goto L13;
        if (UriProtector.getQueryParameter(r14, r6) == null) goto L13;
        Unit r109 = Unit.INSTANCE;
        goto L13
    L254:
        if (r6.equals("tag_icon_trans") == false) goto L13;
        String r110 = UriProtector.getQueryParameter(r14, r6);
        if (r110 == null) goto L13;
        r2.p = r110;
        Unit r111 = Unit.INSTANCE;
        goto L13
    L259:
        if (r6.equals("extra") == false) goto L13;
        String r112 = UriProtector.getQueryParameter(r14, r6);
        if (r112 == null) goto L13;
        Logger.a("ParamsDebug", "extra = ".concat(r112));
        r2.v = r112;
        Unit r113 = Unit.INSTANCE;
        goto L13
    L264:
        if (r6.equals("sug_extra") == false) goto L13;
        String r114 = UriProtector.getQueryParameter(r14, r6);
        if (r114 == null) goto L13;
        r2.W = r114;
        Unit r115 = Unit.INSTANCE;
        goto L13
    L269:
        if (r6.equals("middleInfoExtra") == false) goto L13;
        String r116 = UriProtector.getQueryParameter(r14, r6);
        if (r116 == null) goto L13;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r2.K = r116;
        Unit r117 = Unit.INSTANCE;
        goto L13
    L274:
        if (r6.equals("type") == false) goto L13;
        String r118 = UriProtector.getQueryParameter(r14, r6);
        if (r118 == null) goto L13;
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r2.P = r118;
        Unit r119 = Unit.INSTANCE;
        goto L13
    L279:
        if (r6.equals("mall_extra") == false) goto L13;
        String r120 = UriProtector.getQueryParameter(r14, r6);
        if (r120 == null) goto L13;
        r2.m0 = r120;
        Unit r121 = Unit.INSTANCE;
        goto L13
    L284:
        if (r6.equals("base_keyword") == false) goto L13;
        String r122 = UriProtector.getQueryParameter(r14, r6);
        if (r122 == null) goto L13;
        r2.T = r122;
        Unit r123 = Unit.INSTANCE;
        goto L13
    L289:
        if (r6.equals("show_sug_page") == false) goto L13;
        String r124 = UriProtector.getQueryParameter(r14, r6);
        if (r124 == null) goto L13;
        r2.q0 = Intrinsics.areEqual("1", r124);
        Unit r125 = Unit.INSTANCE;
        goto L13
    L294:
        if (r6.equals(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE) == false) goto L13;
        String r126 = UriProtector.getQueryParameter(r14, r6);
        if (r126 == null) goto L13;
        r2.O = r126;
        Unit r127 = Unit.INSTANCE;
        goto L13
    L299:
        if (r6.equals("is_search_button") == false) goto L13;
        String r128 = UriProtector.getQueryParameter(r14, r6);
        if (r128 == null) goto L13;
        r2.I = CastIntegerProtector.parseInt(r128);     // Catch: Exception -> L304
    L306:
        Unit r129 = Unit.INSTANCE;
    L304:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "saas_search_parse_schema");
        goto L306
    L308:
        if (r6.equals("pre_general_search_id") == false) goto L13;
        String r130 = UriProtector.getQueryParameter(r14, r6);
        if (r130 == null) goto L13;
        r2.y0 = r130;
        Unit r131 = Unit.INSTANCE;
        goto L13
    L313:
        if (r6.equals("words_source") == false) goto L13;
        if (UriProtector.getQueryParameter(r14, r6) == null) goto L13;
        Unit r132 = Unit.INSTANCE;
        goto L13
    L318:
        if (r6.equals("search_from") == false) goto L13;
        String r133 = UriProtector.getQueryParameter(r14, r6);
        if (r133 == null) goto L13;
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        r2.g = r133;
        Unit r134 = Unit.INSTANCE;
        goto L13
    L323:
        if (r6.equals("should_keep_one_commodity_tab") == false) goto L13;
        String r135 = UriProtector.getQueryParameter(r14, r6);
        if (r135 == null) goto L13;
        r2.Q = Integer.valueOf(CastIntegerProtector.parseInt(r135));
        Unit r136 = Unit.INSTANCE;
        goto L13
    L328:
        if (r6.equals(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD) == false) goto L13;
        String r137 = UriProtector.getQueryParameter(r14, r6);
        if (r137 == null) goto L13;
        r2.x = r137;
        Unit r138 = Unit.INSTANCE;
        goto L13
    L333:
        if (r6.equals("tag_type") == false) goto L13;
        String r139 = UriProtector.getQueryParameter(r14, r6);
        if (r139 == null) goto L13;
        r2.r = r139;
        Unit r140 = Unit.INSTANCE;
        goto L13
    L338:
        if (r6.equals("ec_perf_click_ts") == false) goto L13;
        String r141 = UriProtector.getQueryParameter(r14, r6);
        if (r141 == null) goto L13;
        r2.A0 = StringsKt.toLongOrNull(r141);
        Unit r142 = Unit.INSTANCE;
        goto L13
    L343:
        if (r6.equals("keyword") == false) goto L13;
        String r143 = UriProtector.getQueryParameter(r14, r6);
        if (r143 == null) goto L13;
        r2.b = r143;
        Unit r144 = Unit.INSTANCE;
        goto L13
    L348:
        if (r6.equals(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM) == false) goto L13;
        String r145 = UriProtector.getQueryParameter(r14, r6);
        if (r145 == null) goto L13;
        Intrinsics.checkNotNullParameter(r145, "<set-?>");
        r2.d = r145;
        Unit r146 = Unit.INSTANCE;
        goto L13
    L353:
        if (r6.equals("reason") == false) goto L13;
        if (UriProtector.getQueryParameter(r14, r6) == null) goto L13;
        Unit r147 = Unit.INSTANCE;
        goto L13
    L358:
        if (r6.equals("should_shield_commodity_toolbar_function") == false) goto L13;
    L363:
        if (r6.equals("sec_author_id") == false) goto L13;
        String r148 = UriProtector.getQueryParameter(r14, r6);
        if (r148 == null) goto L13;
        r2.F = r148;
        Unit r149 = Unit.INSTANCE;
        goto L13
    L368:
        if (r6.equals("enter_group_id") == false) goto L13;
        String r150 = UriProtector.getQueryParameter(r14, r6);
        if (r150 == null) goto L13;
        r2.k0 = r150;
        Unit r151 = Unit.INSTANCE;
        goto L13
    L373:
        if (r6.equals("need_send_close_message") == false) goto L13;
        String r152 = UriProtector.getQueryParameter(r14, r6);
        if (r152 == null) goto L13;
        r2.b0 = Intrinsics.areEqual("1", r152);
        Unit r153 = Unit.INSTANCE;
        goto L13
    L378:
        if (r6.equals("address") == false) goto L13;
        String r154 = UriProtector.getQueryParameter(r14, r6);
        if (r154 == null) goto L13;
        r2.h0 = r154;
        Unit r155 = Unit.INSTANCE;
        goto L13
    L383:
        if (r6.equals("hide_keyboard") == false) goto L13;
        String r156 = UriProtector.getQueryParameter(r14, r6);
        if (r156 == null) goto L13;
        r2.Y = CastIntegerProtector.parseInt(r156) ^ 1;
        Unit r157 = Unit.INSTANCE;
        goto L13
    L388:
        if (r6.equals("from_gid") == false) goto L13;
        if (UriProtector.getQueryParameter(r14, r6) == null) goto L13;
        Unit r158 = Unit.INSTANCE;
        goto L13
    L393:
        if (r6.equals("picture_url") == false) goto L13;
        if (UriProtector.getQueryParameter(r14, r6) == null) goto L13;
        Unit r159 = Unit.INSTANCE;
        goto L13
    L398:
        if (r6.equals("keywordList") == false) goto L13;
        String r160 = UriProtector.getQueryParameter(r14, r6);
        if (r160 == null) goto L13;
        Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L403
        r2.b((List) GsonUtil.a().fromJson(r160, new RouteSearchParamsBuilder.buildSearchParams.74.1.tokenType.1().getType()));     // Catch: Throwable -> L403
        Object r162 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L403
    L405:
        Result.box-impl(r162);
    L403:
        th = move-exception;
        Result.Companion r163 = Result.Companion;
        r162 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L405
    L407:
        if (r6.equals("enter_from_second") == false) goto L13;
        String r164 = UriProtector.getQueryParameter(r14, r6);
        if (r164 == null) goto L13;
        r2.e = r164;
        Unit r165 = Unit.INSTANCE;
        goto L13
    L412:
        if (r6.equals("icon_text") == false) goto L13;
        String r166 = UriProtector.getQueryParameter(r14, r6);
        if (r166 == null) goto L13;
        r2.q = r166;
        Unit r167 = Unit.INSTANCE;
        goto L13
    L417:
        if (r6.equals("enter_from_method") == false) goto L13;
        String r168 = UriProtector.getQueryParameter(r14, r6);
        if (r168 == null) goto L13;
        r2.f = r168;
        Unit r169 = Unit.INSTANCE;
        goto L13
    L422:
        if (r6.equals("aweme_id") == false) goto L13;
        String r170 = UriProtector.getQueryParameter(r14, r6);
        if (r170 == null) goto L13;
        r2.s0 = r170;
        Unit r171 = Unit.INSTANCE;
        goto L13
    L427:
        if (r6.equals("video_info_extra") == false) goto L13;
        String r172 = UriProtector.getQueryParameter(r14, r6);
        if (r172 == null) goto L13;
        r2.N = r172;
        Unit r173 = Unit.INSTANCE;
        goto L13
    L432:
        if (r6.equals("need_send_close_extra") == false) goto L13;
        String r174 = UriProtector.getQueryParameter(r14, r6);
        if (r174 == null) goto L13;
        r2.l0 = r174;
        Unit r175 = Unit.INSTANCE;
        goto L13
    L437:
        if (r6.equals("trending_words_from") == false) goto L13;
        String r176 = UriProtector.getQueryParameter(r14, r6);
        if (r176 == null) goto L13;
        r2.t = r176;
        Unit r177 = Unit.INSTANCE;
        goto L13
    L442:
        if (r6.equals("hide_sug") == false) goto L13;
        String r178 = UriProtector.getQueryParameter(r14, r6);
        if (r178 == null) goto L13;
        if (StringsKt.equals(r178, "true", true) == false) goto L449;
        r2.U = 1;
    L452:
        Unit r179 = Unit.INSTANCE;
        goto L13
    L449:
        if (StringsKt.equals(r178, "false", true) == false) goto L451;
        r2.U = 0;
        goto L452
    L451:
        r2.U = CastIntegerProtector.parseInt(r178);
        goto L452
    L454:
        if (r6.equals("show_content") == false) goto L13;
        String r180 = UriProtector.getQueryParameter(r14, r6);
        if (r180 == null) goto L13;
        r2.j = r180;
        Unit r181 = Unit.INSTANCE;
        goto L13
    L459:
        if (r6.equals("sug_hint") == false) goto L13;
        String r182 = UriProtector.getQueryParameter(r14, r6);
        if (r182 == null) goto L13;
        r2.V = r182;
        Unit r183 = Unit.INSTANCE;
        goto L13
    L464:
        if (r6.equals("non_full_config") == false) goto L13;
        String r184 = UriProtector.getQueryParameter(r14, r6);
        if (r184 == null) goto L13;
        r2.Z = r184;
        Unit r185 = Unit.INSTANCE;
        goto L13
    L469:
        if (r6.equals("last_scene") == false) goto L13;
        String r186 = UriProtector.getQueryParameter(r14, r6);
        if (r186 == null) goto L13;
        r2.f0 = r186;
        Unit r187 = Unit.INSTANCE;
        goto L13
    L474:
        if (r6.equals("show_keyboard") == false) goto L13;
        String r188 = UriProtector.getQueryParameter(r14, r6);
        if (r188 == null) goto L13;
        r2.Y = CastIntegerProtector.parseInt(r188);     // Catch: Exception -> L479
    L481:
        Unit r189 = Unit.INSTANCE;
    L479:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "saas_search_parse_schema");
        goto L481
    L483:
        if (r6.equals("entrance_tab") == false) goto L13;
        String r190 = UriProtector.getQueryParameter(r14, r6);
        if (r190 == null) goto L13;
        r2.i0 = r190;
        Unit r191 = Unit.INSTANCE;
        goto L13
    L488:
        if (r6.equals("search_passthrough_params") == false) goto L13;
        String r192 = UriProtector.getQueryParameter(r14, r6);
        if (r192 == null) goto L13;
        r2.g0 = r192;
        Unit r193 = Unit.INSTANCE;
    L492:
        ECSearchParam r194 = r2.a();
        ECSaasSearchCommand.b(r0, r194);
        r0.c("is_success", "1");
        r0.e();
        Result.Companion r195 = Result.Companion;     // Catch: Throwable -> L502
        String r196 = UriProtector.getQueryParameter(r14, "instant_address");     // Catch: Throwable -> L502
        if (r196 == null) goto L500;
        JSONObject r197 = new JSONObject(r196);     // Catch: Throwable -> L502
        ITradeSearchHostService r198 = TradeSearch.c(TradeSearch.a);     // Catch: Throwable -> L502
        if (r198 == null) goto L500;
        ITradeSearchAddressService r199 = r198.getITradeSearchAddressService();     // Catch: Throwable -> L502
        if (r199 == null) goto L500;
        r199.setAddress(r197, 1, false, true);     // Catch: Throwable -> L502
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L502
    L500:
        Result.constructor-impl(r5);     // Catch: Throwable -> L502
    L504:
        r194.setOriginSchema(r14.toString());
        ECSaasSearchCommand.a(r13, r194, true, true);
        return true;
    L502:
        th = move-exception;
        Result.Companion r200 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L504
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }
}
