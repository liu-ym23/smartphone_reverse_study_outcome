package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.f3;
import com.bytedance.android.livesdk.config.td;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.AbstractMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnnieParamUtil {
    public static final String[] a = null;
    public static final Boolean b = null;
    public static final ConcurrentHashMap<String, Pair<Object, Boolean>> c = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/browser/AnnieParamUtil$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Object>> {
        public a() {
        }
    }

    static {
        a = new String[]{"568863", "615883", "1349"};
        b = (Boolean) f3.a.getValue();
        c = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final Map<String, String> i() {
        HashMap r0 = new HashMap();
        j0 r1 = j0.l();
        com.bytedance.android.livesdk.log.filter.o r2 = r1.c(com.bytedance.android.livesdk.log.filter.t.class);
        if (r2 == null) goto L5;
        r2.a(r0);
    L5:
        com.bytedance.android.livesdk.log.filter.o r3 = r1.c(IRoom.class);
        if (r3 == null) goto L8;
        r3.a(r0);
    L8:
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r5 = r0.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r6 = (Map.Entry) r5.next();
        if (StringsKt.contains$default((String) r6.getKey(), "vs", false, 2, null) == false) goto L10;
        r4.put(r6.getKey(), r6.getValue());
        goto L10
    L15:
        return MapsKt.toMutableMap(r4);
    }

    @JvmStatic
    public static final void a(final com.bytedance.android.annie.param.k r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        int r0 = com.bytedance.android.annie.param.b.a;
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$1(r2));
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$2(r2));
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$3(r2));
        Boolean r1 = (Boolean) td.a.getValue();
        if (r1 == null) goto L5;
        boolean r3 = r1.booleanValue();
    L6:
        r2.s1(r3);
        Object r4 = String.valueOf(jc1.k.n(IMiddleWareHostContext.class).hostAppId());
        if (r4 != null) goto L10;
        r4 = 0;
    L10:
        if (ArraysKt.contains(a, r4) == false) goto L12;
        r2.E1();
    L12:
        IMiddlewareNetworkService r5 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r5 == null) goto L24;
        final Map r6 = r5.getCommonParams();
        if (r6 == null) goto L25;
        String r7 = (String) r6.get("ac");
        if (r7 == null) goto L19;
        r2.R0(r7);
    L19:
        String r8 = (String) r6.get("current_network_quality_info");
        if (r8 == null) goto L22;
        r2.k1(r8);
    L22:
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$$inlined$let$lambda$1(r6, r2));
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r3 = false;
        goto L6
    }

    @JvmStatic
    public static final void b(com.bytedance.android.annie.param.k r3) {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L15;
        r3.q2(String.valueOf(r0.getUpdateVersionCode()));
        r3.o2(r0.isNeedProtectUnderage() ? 1 : 0);
        ALogger.i("HybridParamUtil", "AnnieParamUtil is_teen_mode = " + r3.P0());
        if (fm3.d.b() == true) goto L12;
        Boolean r1 = r0.isDarkMode();
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L11;
    L13:
        String r2 = "dark";
    L14:
        r3.b1(r2);
        goto L15
    L11:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L13;
    L12:
        r2 = "light";
    L15:
        com.bytedance.android.livesdk.user.e r4 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r4 == null) goto L19;
        r3.H1(r4.isLogin() ? 1 : 0);
        return;
    }

    public static JsonElement e(Object r2) {
        Gson r0 = GsonHelper.get();
        if ((r2 instanceof JSONObject) == false) goto L6;
        return GsonProtectorUtils.toJsonTree(r0, GsonProtectorUtils.fromJson(r0, r2.toString(), Object.class));
    L6:
        if ((r2 instanceof JSONArray) == false) goto L9;
        return GsonProtectorUtils.toJsonTree(r0, GsonProtectorUtils.fromJson(r0, r2.toString(), new a().getType()));
    L9:
        return GsonProtectorUtils.toJsonTree(r0, r2);
    }

    @JvmStatic
    public static final Map<String, Object> g(String r3) {
        if (r3 == null) goto L4;
        WebResourceResponse r4 = com.bytedance.android.livesdk.gecko.n.b.c(r3);
        if (r4 == null) goto L8;
        BufferedReader r0 = new BufferedReader(new InputStreamReader(r4.getData()));
        StringBuilder r5 = new StringBuilder();
    L10:
        String r1 = r0.readLine();
        if (r1 == null) goto L13;
        r5.append(Intrinsics.stringPlus(r1, "\n"));
        goto L10
    L13:
        ALogger.i("HybridParamUtil", "inject_json = " + r5);
        return UtilsKt.g(new JSONObject(r5.toString()));
    L16:
        ALogger.e("HybridParamUtil", "inject_json parse error");
        return new HashMap();
    L8:
        return new HashMap();
    L4:
        return new HashMap();
    }

    @JvmStatic
    public static final Object h(String r3) {
        Boolean r0 = b;
        if (r0.booleanValue() == false) goto L8;
        Pair<Object, Boolean> r1 = c.get(r3);
        if (r1 == null) goto L8;
        return r1.getFirst();
    L8:
        Object r2 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r3);
        if (r0.booleanValue() == false) goto L16;
        if (r3 == null) goto L16;
        ConcurrentHashMap<String, Pair<Object, Boolean>> r4 = c;
        if (r2 != null) goto L14;
        boolean r5 = true;
    L15:
        r4.put(r3, TuplesKt.to(r2, Boolean.valueOf(r5)));
        goto L16
    L14:
        r5 = false;
    L16:
        return r2;
    }

    public static boolean j(String r2) {
        if (r2 != null) goto L14;
        return false;
    L14:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(Boolean.valueOf(UriProtector.parse(r2).getBooleanQueryParameter("inject_cache_async", false)));     // Catch: Throwable -> L7
    L9:
        Boolean r0 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = r0;
    L13:
        return ((Boolean) r3).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void d(com.bytedance.android.annie.param.k r8, Context r9) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == true) goto L5;
    L7:
        Iterator r0 = ((List) AnnieConfigSettingKeys.TRY_FIX_NATIVIGATION_BAR_HEIGHT_DEVICE.a()).iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((String) r0.next(), Build.MODEL) == false) goto L9;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L35;
        if (r9 == null) goto L34;
        Resources r2 = r9.getResources();
        int r3 = r2.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r3 <= 0) goto L20;
        int r4 = r2.getDimensionPixelSize(r3);
    L21:
        Rect r5 = new Rect();
        if ((r9 instanceof Activity) == false) goto L33;
        View r6 = ((Activity) r9).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L28;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r7 = ThreadMethodProxy.currentThread();
        if (r7 == com.larus.home.impl.utils.c.a) goto L28;
        com.larus.home.impl.utils.c.a(r7, "getDecorView");
    L28:
        r6.getWindowVisibleDisplayFrame(r5);
        int r11 = r5.height();
        if (r11 != (x1.e(r9) - r4)) goto L31;
        r11 = r11 - s1.A();
    L31:
        r4 = Math.min(Math.max((x1.e(r9) - s1.A()) - r11, 0), r4);
    L36:
        int r12 = s1.q(r9).heightPixels - r4;
        r8.d2(s1.G(r12));
        r8.e2(r12);
        Resources r13 = s1.getResources();
        if (r13 == null) goto L46;
        Configuration r14 = r13.getConfiguration();
        if (r14 == null) goto L46;
        int r15 = r14.orientation;
        if (r15 != 1) goto L44;
        r8.P1(0);
        goto L46
    L44:
        if (r15 != 2) goto L46;
        r8.P1(1);
    L46:
        r8.g2(s1.G(s1.y()));
        r8.Y1(s1.G(s1.q(r9).heightPixels));
        r8.h2(s1.y());
        return;
    L33:
        if (x1.c(r9) == true) goto L36;
    L20:
        r4 = 0;
    L34:
        r4 = 0;
        goto L36
    L35:
        r4 = x1.j(r9);
        goto L36
    L13:
        r1 = false;
        goto L14
    L5:
        if (((Boolean) AnnieConfigSettingKeys.AVOID_WORKER_THREAD_INVOKE_DECORVIEW.a()).booleanValue() == false) goto L7;
        goto L7
    }

    public static void c(com.bytedance.android.annie.param.k r12, String r13, String r14) {
        com.bytedance.live.datacontext.m r0 = o3.f().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        IMiddlewareUserService r2 = jc1.k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L17;
        String r4 = r3.n();
        if (r4 == null) goto L13;
        r12.r2(r4);
        ALogger.i("HybridParamUtil", "userID = ".concat(r4));
    L13:
        String r5 = com.bytedance.android.live.base.model.user.o.a(r3.b());
        if (r5 == null) goto L17;
        r12.j2(r5);
    L17:
        if (r1 == null) goto L29;
        String r6 = r1.getIdStr();
        if (r6 == null) goto L21;
        r12.a2(r6);
    L21:
        String r7 = r1.getOwnerUserIdString();
        if (r7 == null) goto L24;
        r12.W0(r7);
    L24:
        IBaseUser r8 = r1.getOwner();
        if (r8 == null) goto L29;
        Intrinsics.checkNotNullParameter(r8, "$this$secUidExt");
        String r9 = r8.getCastSecUid();
        if (r9 == null) goto L29;
        r12.i2(r9);
    L29:
        boolean r11 = pm1.h.a;
        if (pm1.h.a == false) goto L43;
        lm1.b r15 = pm1.f.d(null);
        if (r15 == null) goto L36;
        com.bytedance.live.datacontext.n r16 = r15.getEpisode();
        if (r16 == null) goto L36;
        Episode r17 = (Episode) r16.getValue();
    L37:
        if (r17 == null) goto L43;
        r12.a2(String.valueOf(r17.getIdExt()));
        r12.W0(EpisodeExtKt.getOwnerIdString(r17));
        IBaseUser r18 = r17.getOwner();
        if (r18 == null) goto L43;
        Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
        String r19 = r18.getCastSecUid();
        if (r19 == null) goto L43;
        r12.i2(r19);
    L36:
        r17 = null;
    L43:
        JsonObject r21 = new JsonObject();
        int r22 = 0;
        boolean r23 = true;
        if (TextUtils.isEmpty(r13) == true) goto L67;
        Uri r24 = UriProtector.parse(r13);
        if (r24 == null) goto L49;
        String r25 = UriProtector.getQueryParameter(r24, "settings_keys");
    L50:
        if (r25 == null) goto L52;
        List r26 = StringsKt.split$default(r25, new String[]{","}, false, 0, 6, null);
    L53:
        List r27 = r26;
        if (r27 != null) goto L56;
    L59:
        boolean r28 = true;
    L60:
        if (r28 == true) goto L67;
        Iterator r29 = r26.iterator();
    L63:
        if (r29.hasNext() == false) goto L67;
        String r31 = (String) r29.next();
        Object r32 = h(r31);
        if (r32 == null) goto L63;
        r21.add(r31, GsonProtectorUtils.toJsonTree(new Gson(), r32));
        goto L63
    L56:
        if (r27.isEmpty() == true) goto L59;
        r28 = false;
        goto L60
    L52:
        r26 = null;
        goto L53
    L49:
        r25 = null;
    L67:
        r12.k2(r21);
        JsonObject r33 = new JsonObject();
    L94:
        e = move-exception;
        ALogger.e("HybridParamUtil", e);
    L96:
        r12.T0(r33);
        JsonObject r34 = new JsonObject();
    L120:
        e = move-exception;
        ALogger.e("HybridParamUtil", e);
    L122:
        r12.u1(r34);
        AbstractMap r35 = new HashMap();
        if (TextUtils.isEmpty(r13) == true) goto L146;
        Uri r36 = UriProtector.parse(r13);
        if (r36 == null) goto L128;
        String r37 = UriProtector.getQueryParameter(r36, "ab_params");
    L129:
        if (r37 != null) goto L131;
    L134:
        if (r23 == true) goto L146;
        ArrayList r38 = new ArrayList();
        JSONArray r39 = new JSONArray(r37);
        int r41 = r39.length();
    L137:
        if (r22 >= r41) goto L139;
        r38.add(r39.get(r22).toString());
        r22 = r22 + 1;
        goto L137
    L139:
        Map r42 = jc1.k.n(IMiddleWareHostContext.class).getSettings(r38);
        if (r42 != null) goto L142;
    L145:
        r35 = null;
        goto L146
    L142:
        if (r42.isEmpty() == true) goto L145;
        r35 = UtilsKt.g(new JSONObject(r42.toString()));
        goto L146
    L131:
        if (r37.length() == 0) goto L134;
        r23 = false;
        goto L134
    L128:
        r37 = null;
    L146:
        if (r35 == null) goto L148;
        r12.Q0(r35);
    L148:
        if (r13 == null) goto L150;
        Uri r110 = UriProtector.parse(r13);
    L151:
        ArrayList r43 = new ArrayList();
        r43.add(new ja1.a.c(r14));
        r43.add(new ja1.a.b(r110));
        r43.add(new ja1.a.a(null));
        Object r111 = "";
        if (r43.isEmpty() == true) goto L160;
        Iterator r112 = r43.iterator();
    L156:
        if (r112.hasNext() == false) goto L160;
        ja1.b r44 = (ja1.b) r112.next();
        if (r44.a("inject_json_url") == false) goto L156;
        r111 = r44.b("inject_json_url", "");
    L160:
        r12.D1(g((String) r111));
        return;
    L150:
        r110 = null;
        goto L151
    L98:
        if (TextUtils.isEmpty(r13) == true) goto L122;
        Uri r45 = UriProtector.parse(r13);     // Catch: Exception -> L120
        if (r45 == null) goto L103;
        String r46 = UriProtector.getQueryParameter(r45, "dynamic_settings");     // Catch: Exception -> L120
    L104:
        if (r46 == null) goto L122;
        JSONArray r47 = new JSONArray(r46);     // Catch: Exception -> L120
        int r48 = r47.length();     // Catch: Exception -> L120
        int r49 = 0;
    L106:
        if (r49 >= r48) goto L122;
        Object r51 = r47.get(r49);     // Catch: Exception -> L120
        if (r51 == null) goto L119;
        if (r51.toString().length() <= 0) goto L112;
        boolean r52 = true;
    L113:
        if (r52 == false) goto L119;
        Object r53 = jc1.k.n(IMiddleWareHostContext.class).getUgSettingsByKey(1, "data." + r51);     // Catch: Exception -> L120
        if (r53 == null) goto L119;
        JsonElement r54 = e(r53);     // Catch: Exception -> L120
        if (r54 == null) goto L119;
        r34.add(r47.get(r49).toString(), r54);     // Catch: Exception -> L120
        goto L119
    L112:
        r52 = false;
    L119:
        r49 = r49 + 1;
        goto L106
    L103:
        r46 = null;
        goto L104
    L69:
        if (TextUtils.isEmpty(r13) == true) goto L96;
        Uri r55 = UriProtector.parse(r13);     // Catch: Exception -> L94
        if (r55 == null) goto L74;
        String r56 = UriProtector.getQueryParameter(r55, "activity_settings");     // Catch: Exception -> L94
    L75:
        if (r56 == null) goto L96;
        JSONArray r57 = new JSONArray(r56);     // Catch: Exception -> L94
        int r58 = r57.length();     // Catch: Exception -> L94
        int r59 = 0;
    L77:
        if (r59 >= r58) goto L96;
        Object r61 = r57.get(r59);     // Catch: Exception -> L94
        if (r61 == null) goto L93;
        if (r61.toString().length() <= 0) goto L83;
        boolean r113 = true;
    L84:
        if (r113 == true) goto L87;
        r61 = null;
    L87:
        if (r61 == null) goto L93;
        Object r62 = jc1.k.n(IMiddleWareHostContext.class).getUgSettingsByKey(0, "data.common_info.extra." + r61.toString());     // Catch: Exception -> L94
        if (r62 == null) goto L93;
        JsonElement r63 = e(r62);     // Catch: Exception -> L94
        if (r63 == null) goto L93;
        r33.add(r57.get(r59).toString(), r63);     // Catch: Exception -> L94
        goto L93
    L83:
        r113 = false;
    L93:
        r59 = r59 + 1;
        goto L77
    L74:
        r56 = null;
        goto L75
    L5:
        r1 = null;
        goto L6
    }

    public static void f(final com.bytedance.android.annie.param.k r16, Context r17, String r18, String r19, final w r21) {
        Intrinsics.checkNotNullParameter(r16, "param");
        Intrinsics.checkNotNullParameter(r19, LiveSlardarConstants.EXTRA_KEY_URL);
        int r3 = o.a;
        AnnieParamUtil$getCacheParam$1 r4 = AnnieParamUtil$getCacheParam$1.INSTANCE;
        final Function1<Map<String, ? extends Object>, Unit> r5 = new AnnieParamUtil$getCacheParam$2(r16);
        AnnieParamUtil$getCacheParam$3 r6 = AnnieParamUtil$getCacheParam$3.INSTANCE;
        final Function1<Map<String, ? extends Object>, Unit> r7 = new AnnieParamUtil$getCacheParam$4(r16);
        Function2<String, JSONObject, Unit> r8 = new AnnieParamUtil$getCacheParam$5(r21);
        Intrinsics.checkNotNullParameter(r4, "prefetchProvider");
        Intrinsics.checkNotNullParameter(r6, "storageProvider");
        Intrinsics.checkNotNullParameter(r5, "prefetchResolve");
        Intrinsics.checkNotNullParameter(r7, "storageResolve");
        Intrinsics.checkNotNullParameter(r8, "monitorResolve");
        if (r18 == null) goto L123;
        if (r19 != null) goto L111;
        return;
    L111:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L56
        String r1 = UriProtector.getQueryParameter(UriProtector.parse(r18), "inject_config_channel");     // Catch: Throwable -> L56
        if (r1 == null) goto L51;
        JSONObject r2 = e0.c(r19, r1, "inject_data.json");     // Catch: Throwable -> L56
        if (r2 != null) goto L13;
        String r11 = "inject_json_miss";
    L14:
        Uri r12 = UriProtector.parse(r19);     // Catch: Throwable -> L56
        String r13 = r12.getPath();     // Catch: Throwable -> L56
        if (r13 == null) goto L52;
        if (r2 == null) goto L52;
        r11 = "parse_detail_failed";
        String r14 = UriProtector.getQueryParameter(r12, "inject_scene");     // Catch: Throwable -> L56
        if (r14 != null) goto L20;
        r14 = "default";
    L20:
        JSONObject r9 = r2.optJSONObject(r13);     // Catch: Throwable -> L56
        if (r9 == null) goto L52;
        JSONObject r15 = r9.optJSONObject(r14);     // Catch: Throwable -> L56
        if (r15 == null) goto L52;
        if (r15.optInt("disable_prefetch_inject") != 1) goto L27;
        boolean r110 = true;
    L29:
        if (r15.optInt("disable_storage_inject") != 1) goto L31;
        boolean r111 = true;
    L32:
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L56
        JSONArray r113 = r15.optJSONArray("api_storage_key");     // Catch: Throwable -> L56
        if (r113 == null) goto L37;
        int r114 = r113.length();     // Catch: Throwable -> L56
        int r22 = 0;
    L35:
        if (r22 >= r114) goto L37;
        r112.add(JSONArrayProtectorUtils.getString(r113, r22));     // Catch: Throwable -> L56
        r22 = r22 + 1;     // Catch: Throwable -> L56
    L37:
        ArrayList r23 = new ArrayList();     // Catch: Throwable -> L56
        JSONArray r24 = r15.optJSONArray("local_storage_key");     // Catch: Throwable -> L56
        if (r24 == null) goto L42;
        int r115 = r24.length();     // Catch: Throwable -> L56
        int r116 = 0;
    L40:
        if (r116 >= r115) goto L42;
        r23.add(JSONArrayProtectorUtils.getString(r24, r116));     // Catch: Throwable -> L56
        r116 = r116 + 1;     // Catch: Throwable -> L56
    L42:
        JSONArray r25 = r15.optJSONArray("dynamic_storage_keys");     // Catch: Throwable -> L56
        if (r25 == null) goto L50;
        int r26 = r25.length();     // Catch: Throwable -> L56
        int r117 = 0;
    L45:
        if (r117 >= r26) goto L50;
        String r118 = o.a(JSONArrayProtectorUtils.getString(r25, r117), UriProtector.parse(r18));     // Catch: Throwable -> L56
        if (r118 == null) goto L49;
        r23.add(r118);     // Catch: Throwable -> L56
    L49:
        r117 = r117 + 1;     // Catch: Throwable -> L56
    L50:
        m r27 = new m(r110, r111, r112, r23);     // Catch: Throwable -> L56
    L59:
        if (r27 == null) goto L125;
        final Ref.BooleanRef r28 = new Ref.BooleanRef();
        r28.element = false;
        Function1<Map<String, ? extends Object>, Unit> r29 = new CacheParamUtil$injectCacheParam$1(r28, r5);
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L80
        if (r27.a == true) goto L78;
        JsonObject r32 = (JsonElement) r4.invoke(UriProtector.parse(r19).buildUpon().clearQuery().build().toString());     // Catch: Throwable -> L80
        if (r32 == null) goto L78;
        if ((r32 instanceof JsonObject) == true) goto L70;
    L72:
        boolean r33 = false;
    L73:
        if (r33 == true) goto L76;
        r32 = null;
    L76:
        if (r32 == null) goto L78;
        r29.invoke(GsonHelper.getDefault().fromJson(r32, new n().getType()));     // Catch: Throwable -> L80
        goto L78
    L70:
        if (r32.size() <= 0) goto L72;
        r33 = true;
    L78:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L82:
        final Ref.BooleanRef r34 = new Ref.BooleanRef();
        r34.element = false;
        boolean r35 = r28.element;
        Function2<Map<String, ? extends Object>, Boolean, Unit> r119 = new CacheParamUtil$injectCacheParam$2(r34, r7);
        if (r17 != null) goto L114;
    L105:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L107
    L109:
        o.c(r28.element, r34.element, r19, null, r8);
        return;
    L107:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L109
    L114:
        if (r27.b == true) goto L105;
        LinkedHashMap r37 = new LinkedHashMap();     // Catch: Throwable -> L107
        if (r35 == true) goto L94;
        Iterator<T> r38 = r27.c.iterator();     // Catch: Throwable -> L107
    L91:
        if (r38.hasNext() == false) goto L93;
        o.b((String) r38.next(), r37, r17, r6);     // Catch: Throwable -> L107
        goto L91
    L93:
        boolean r39 = !r37.isEmpty();     // Catch: Throwable -> L107
    L95:
        Iterator<T> r41 = r27.d.iterator();     // Catch: Throwable -> L107
    L97:
        if (r41.hasNext() == false) goto L100;
        o.b((String) r41.next(), r37, r17, r6);     // Catch: Throwable -> L107
        goto L97
    L100:
        if ((!r37.isEmpty()) == true) goto L103;
        r37 = null;
    L103:
        if (r37 == null) goto L105;
        r119.invoke(r37, Boolean.valueOf(r39));     // Catch: Throwable -> L107
        goto L105
    L94:
        r39 = false;
    L80:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L82
    L125:
        return;
    L31:
        r111 = false;
        goto L32
    L27:
        r110 = false;
    L52:
        if (r11 == null) goto L54;
        o.c(false, false, r19, r11, r8);     // Catch: Throwable -> L56
    L54:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L58:
        r27 = null;
        goto L59
    L13:
        r11 = null;
        goto L14
    L51:
        r11 = null;
    L56:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    }
}
