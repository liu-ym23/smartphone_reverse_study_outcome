package com.ss.android.lark.passport.flow.core.network;

import android.content.Context;
import android.os.Build;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowPassportAccountsHttpClient {
    public static final Set<String> d = null;
    public final l a;
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> b;
    public final String c;

    public static final class a {
    }

    static {
        Locale r1 = Locale.US;
        d = SetsKt.setOf(new String[]{"X-App-Id".toLowerCase(r1), "X-Device-Info".toLowerCase(r1), "Authorization".toLowerCase(r1), "DPoP".toLowerCase(r1), "cookie".toLowerCase(r1), "X-Request-ID".toLowerCase(r1), "x-tt-env".toLowerCase(r1), "X-Front-Uuid".toLowerCase(r1), "X-Terminal-Type".toLowerCase(r1), "X-Locale".toLowerCase(r1), "X-Flow-Key".toLowerCase(r1), "X-Verify-Token".toLowerCase(r1), "X-Proxy-Unit".toLowerCase(r1), "Suite-Session-Key".toLowerCase(r1), "X-Passport-Session-Keys".toLowerCase(r1), "X-Passport-Unit".toLowerCase(r1), "X-Passport-Uni-Did".toLowerCase(r1), "X-Passport-Device-IDs".toLowerCase(r1), "x-passport-single-product".toLowerCase(r1), "x-passport-from-source".toLowerCase(r1), "X-Api-Version".toLowerCase(r1)});
    }

    public FlowPassportAccountsHttpClient(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
        this.b = new ConcurrentHashMap();
        this.c = UUID.randomUUID().toString();
    }

    public final void a(String r2, Map<String, String> r3, String r4) {
        ConcurrentHashMap<String, String> r5 = this.b.get(r2);
        if (r5 == null) goto L13;
        String r6 = r5.get(r4);
        if (r6 != null) goto L7;
        return;
    L7:
        if ((!StringsKt.isBlank(r6)) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L15;
        r3.put(r4, r6);
        return;
    L15:
        return;
    }

    public final void d(f r3, String r4, String r5) {
        String r6 = r3.b(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r6)) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L18;
        ConcurrentHashMap<String, ConcurrentHashMap<String, String>> r0 = this.b;
        ConcurrentHashMap<String, String> r1 = r0.get(r4);
        if (r1 != null) goto L15;
        r1 = new ConcurrentHashMap();
        ConcurrentHashMap<String, String> r7 = r0.putIfAbsent(r4, r1);
        if (r7 == null) goto L15;
        r1 = r7;
    L15:
        r1.put(r5, r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object c(FlowPassportAccountsHttpClient r14, String r15, String r16, PassportHttpMethod r17, Map r18, Map r19, byte[] r20, ContinuationImpl r21, int r22) {
        if ((r22 & 8) == 0) goto L5;
        Map r6 = MapsKt.emptyMap();
    L7:
        if ((r22 & 16) == 0) goto L9;
        Map r7 = MapsKt.emptyMap();
    L11:
        if ((r22 & 32) == 0) goto L13;
        byte[] r8 = null;
    L15:
        if ((r22 & 64) == 0) goto L17;
        String r9 = UUID.randomUUID().toString();
    L19:
        if ((r22 & 128) == 0) goto L21;
        int r10 = 30;
    L23:
        if ((r22 & 256) == 0) goto L25;
        boolean r11 = true;
    L27:
        if ((r22 & 512) == 0) goto L29;
        boolean r12 = false;
    L31:
        return r14.b(r15, r16, r17, r6, r7, r8, r9, r10, r11, r12, r21);
    L29:
        r12 = true;
        goto L31
    L25:
        r11 = false;
        goto L27
    L21:
        r10 = 0;
        goto L23
    L17:
        r9 = null;
        goto L19
    L13:
        r8 = r20;
        goto L15
    L9:
        r7 = r19;
        goto L11
    L5:
        r6 = r18;
        goto L7
    }

    public final Object b(String r33, String r34, PassportHttpMethod r35, Map<String, String> r36, Map<String, String> r37, byte[] r38, String r39, int r40, boolean r41, boolean r42, Continuation<? super f> r43) {
        if ((r43 instanceof FlowPassportAccountsHttpClient$executeAccounts$1) == false) goto L7;
        FlowPassportAccountsHttpClient$executeAccounts$1 r2 = (FlowPassportAccountsHttpClient$executeAccounts$1) r43;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        String r6 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        Object r7 = null;
    L358:
        f r8 = (f) r0;
        d(r8, r6, "X-Flow-Key");
        d(r8, r6, "X-Verify-Token");
        d(r8, r6, "X-Proxy-Unit");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L361
        Object r9 = Result.constructor-impl(JSON.parseObject(f.a(r8)));     // Catch: Throwable -> L361
    L364:
        if (Result.isFailure-impl(r9) == false) goto L366;
        Object r10 = r7;
    L367:
        JSONObject r11 = (JSONObject) r10;
        if (r11 == null) goto L421;
        Integer r12 = r11.getInteger("code");
        if (r12 == null) goto L373;
        int r13 = r12.intValue();
    L374:
        String r14 = r11.getString("message");
        Integer r15 = r11.getInteger(UniContext.KEY_OF_BIZ_CODE);
        JSONObject r16 = r11.getJSONObject("data");
        if (r16 == null) goto L380;
        String r17 = r16.getString("next_step");
        if (r17 == null) goto L380;
        String r18 = r17;
    L382:
        if (r13 != 4233) goto L420;
        tyb.a r19 = tyb.a.a;
        if (r16 == null) goto L413;
        boolean r110 = r16.containsKey("type");
        int r20 = r16.getIntValue("type");
        String r111 = r16.getString("decision");
        if (r111 != null) goto L388;
    L391:
        boolean r112 = true;
    L392:
        if (r112 == true) goto L410;
        StringBuilder r21 = new StringBuilder("show turing dialog by decision, is risk info empty? ");
        if (r111 != null) goto L396;
    L399:
        boolean r22 = true;
    L400:
        r21.append(r22);
        PassportLog.d("n_action_bdturing", r21.toString());
        if (r111 != null) goto L403;
    L406:
        boolean r113 = true;
    L407:
        if (r113 == false) goto L409;
        PassportLog.b("n_action_bdturing", "show turing dialog get empty risk info");
    L414:
        String r23 = r8.b("x-tt-logid");
        if (r14 != null) goto L418;
        r14 = "BDTuring verification is required";
    L418:
        throw new PassportHttpBusinessException(r13, r15, r18, r23, r14);
    L409:
        tyb.a r24 = tyb.a.a;
        tyb.a.b.C0196b r25 = new tyb.a.b.C0196b(r111);
        r24.getClass();
        UICallbackExecutor.execute(new tyb.c(r25));
        goto L414
    L403:
        if (StringsKt.isBlank(r111) == true) goto L406;
        r113 = false;
        goto L407
    L396:
        if (r111.length() == 0) goto L399;
        r22 = false;
        goto L400
    L410:
        if (r110 == false) goto L412;
        PassportLog.d("n_action_bdturing", "show turing dialog by challenge id, challengeId: " + r20);
        tyb.a r26 = tyb.a.a;
        tyb.a.b.C0195a r27 = new tyb.a.b.C0195a(r20);
        r26.getClass();
        UICallbackExecutor.execute(new tyb.c(r27));
        goto L414
    L412:
        PassportLog.b("n_action_bdturing", "decision is empty and no challenge code, data keys: " + r16.keySet());
        goto L414
    L388:
        if (StringsKt.isBlank(r111) == true) goto L391;
        r112 = false;
        goto L392
    L413:
        PassportLog.b("n_action_bdturing", "bdturing resp data is null");
        goto L414
    L420:
        if (Intrinsics.areEqual(r18, "change_geo") == false) goto L421;
        throw new PassportHttpBusinessException(50001, r15, r18, r8.b("x-tt-logid"), "next step is change_geo");
    L380:
        r18 = r11.getString("next_step");
        goto L382
    L373:
        r13 = 0;
    L421:
        return r8;
    L366:
        r10 = r9;
    L361:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L364
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r29 = r2.Z$1;
        boolean r114 = r2.Z$0;
        int r115 = r2.I$0;
        gpb.a r116 = (gpb.a) r2.L$7;
        String r30 = (String) r2.L$6;
        byte[] r31 = (byte[]) r2.L$5;
        Map<String, String> r32 = (Map) r2.L$4;
        Map<String, String> r44 = (Map) r2.L$3;
        PassportHttpMethod r45 = (PassportHttpMethod) r2.L$2;
        String r46 = (String) r2.L$1;
        String r47 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r117 = r29;
        Object r118 = r0;
        gpb.a r210 = r116;
        String r48 = r46;
        boolean r119 = r114;
        int r120 = r115;
        String r121 = r30;
        PassportHttpMethod r49 = r45;
    L84:
        String r50 = (String) r118;
        FlowPassportAccountsHttpClient$executeAccounts$1 r122 = r2;
        PassportHttpMethod r310 = r49;
        int r311 = r120;
        boolean r410 = r119;
        if (StringsKt.startsWith$default(r48, "/", false, 2, null) == false) goto L437;
        StringBuilder r51 = new StringBuilder();
        r51.append(com.ss.android.lark.passport.flow.core.network.a.a(r210));
        r51.append(r48);
        if (r44.isEmpty() == false) goto L89;
        String r52 = "";
    L90:
        r51.append(r52);
        String r53 = r51.toString();
        if (r31 == null) goto L93;
        boolean r54 = true;
    L95:
        if ((!StringsKt.isBlank(r47)) == false) goto L435;
        Set<String> r55 = r32.keySet();
        if ((r55 instanceof Collection) == true) goto L99;
    L101:
        Iterator r56 = r55.iterator();
    L103:
        if (r56.hasNext() == false) goto L108;
        Iterator r312 = r56;
        if (d.contains(((String) r56.next()).toLowerCase(Locale.US)) == true) goto L106;
        r56 = r312;
        goto L103
    L106:
        boolean r57 = false;
    L109:
        if (r57 == false) goto L433;
        Pair[] r123 = new Pair[7];
        r123[0] = TuplesKt.to("Accept", "application/json; charset=utf-8");
        r123[1] = TuplesKt.to("X-Request-ID", r121);
        r123[2] = TuplesKt.to("X-App-Id", "12");
        String r211 = r121;
        r123[3] = TuplesKt.to("X-Api-Version", "1.0.30");
        r123[4] = TuplesKt.to("X-Front-Uuid", this.c);
        r123[5] = TuplesKt.to("X-Terminal-Type", "3");
        Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L113
        Object r59 = Result.constructor-impl(LarkContext.getApplication().getApplicationContext());     // Catch: Throwable -> L113
    L116:
        if (Result.isFailure-impl(r59) == false) goto L118;
        r59 = null;
    L118:
        Context r60 = (Context) r59;
        LinkedHashMap r124 = new LinkedHashMap();
        byte[] r313 = r31;
        r124.put("device_id", r50);
        String r61 = Build.MODEL;
        if (r61 == null) goto L127;
        if ((!StringsKt.isBlank(r61)) == true) goto L124;
        r61 = null;
    L124:
        if (r61 == null) goto L127;
        r124.put("device_name", r61);
        r124.put("device_model", r61);
    L127:
        String r62 = Build.VERSION.RELEASE;
        if (r62 != null) goto L130;
        r62 = "";
    L130:
        String r63 = StringsKt.trim("Android ".concat(r62)).toString();
        if ((!StringsKt.isBlank(r63)) == false) goto L133;
        r124.put("device_os", r63);
    L133:
        if (r60 == null) goto L143;
        String r64 = r60.getPackageName();
        if (r64 == null) goto L143;
        if ((!StringsKt.isBlank(r64)) == true) goto L140;
        r64 = null;
    L140:
        if (r64 == null) goto L143;
        r124.put("package_name", r64);
    L143:
        if (r210.isFeishuBrand() == false) goto L145;
        String r65 = "feishu";
    L146:
        r124.put("package_brand", r65);
        if (r60 != null) goto L450;
    L160:
        String r66 = null;
    L161:
        if (r66 == null) goto L163;
        r124.put("lark_version", r66);
    L163:
        r124.put("tt_app_id", "12");
        r123[6] = TuplesKt.to("X-Device-Info", CollectionsKt.joinToString$default(r124.entrySet(), ";", null, ";", 0, null, FlowPassportAccountsHttpClient$buildDeviceInfo$6.INSTANCE, 26, null));
        LinkedHashMap r67 = MapsKt.linkedMapOf(r123);
        Locale r68 = Locale.getDefault();
        String r69 = r68.getLanguage();
        Intrinsics.checkNotNull(r69);
        if ((!StringsKt.isBlank(r69)) == true) goto L167;
        r69 = null;
    L167:
        if (r69 == null) goto L174;
        String r70 = r68.getCountry();
        Intrinsics.checkNotNull(r70);
        if ((!StringsKt.isBlank(r70)) == true) goto L173;
        r70 = null;
    L173:
        if (r70 == null) goto L174;
        String r71 = r69 + '_' + r70;
        if (Intrinsics.areEqual(r71, "in_ID") == false) goto L178;
        r71 = "id_ID";
    L178:
        if (r71 == null) goto L180;
        r67.put("X-Locale", r71);
    L180:
        String r72 = r210.getUserUnit();
        if ((!StringsKt.isBlank(r72)) == true) goto L184;
        r72 = null;
    L184:
        if (r72 == null) goto L186;
        r67.put("X-Passport-Unit", r72);
        r67.put("X-Passport-Device-IDs", r72 + ':' + r50);
    L186:
        r67.put("X-Passport-Uni-Did", r50);
        if (com.ss.android.lark.passport.a.b() == false) goto L190;
        r67.put("x-passport-single-product", "7");
        r67.put("x-passport-from-source", "11");
    L190:
        if (com.ss.android.lark.passport.a.a() == true) goto L460;
    L207:
        a(r47, r67, "X-Flow-Key");
        a(r47, r67, "X-Verify-Token");
        a(r47, r67, "X-Proxy-Unit");
        if (r117 == true) goto L440;
    L254:
        r67.putAll(r32);
        if (r54 == false) goto L270;
        Set r73 = r67.keySet();
        if ((r73 instanceof Collection) == true) goto L259;
    L261:
        Iterator r74 = r73.iterator();
    L263:
        if (r74.hasNext() == false) goto L267;
        if (StringsKt.equals((String) r74.next(), "Content-Type", true) == false) goto L263;
        boolean r75 = false;
    L268:
        if (r75 == false) goto L270;
        r67.put("Content-Type", "application/json");
    L267:
        r75 = true;
        goto L268
    L259:
        if (r73.isEmpty() == false) goto L261;
    L270:
        final g r76 = new g(this.a);
        final e r77 = new e(r53, r310, r67, r313, r211, r311, r410);
        r122.L$0 = r47;
        r122.L$1 = null;
        r122.L$2 = null;
        r122.L$3 = null;
        r122.L$4 = null;
        r122.L$5 = null;
        r122.L$6 = null;
        r122.L$7 = null;
        r122.label = 2;
        if ((!StringsKt.isBlank(r77.c)) == false) goto L431;
        if (r77.d <= 0) goto L275;
        boolean r78 = true;
    L276:
        if (r78 == false) goto L429;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L279
        Object r80 = Result.constructor-impl(new URI(r77.a));     // Catch: Throwable -> L279
    L282:
        if (Result.isFailure-impl(r80) == false) goto L284;
        r80 = null;
    L284:
        URI r81 = (URI) r80;
        if (r81 != null) goto L287;
    L297:
        boolean r82 = false;
    L298:
        if (r82 == false) goto L427;
        if (StringsKt.equals(r81.getScheme(), "https", true) == false) goto L302;
    L305:
        boolean r83 = true;
    L306:
        if (r83 == false) goto L425;
        Iterator r84 = ((LinkedHashMap) r77.g).entrySet().iterator();
    L309:
        if (r84.hasNext() == false) goto L324;
        Map.Entry r85 = (Map.Entry) r84.next();
        String r86 = (String) r85.getKey();
        String r87 = (String) r85.getValue();
        if (g.b.matches(r86) == false) goto L323;
        if (StringsKt.contains$default(r87, '\r', false, 2, null) == false) goto L315;
    L317:
        boolean r88 = false;
    L318:
        if (r88 == true) goto L309;
        throw new IllegalArgumentException("Invalid HTTP header value".toString());
    L315:
        if (StringsKt.contains$default(r87, '\n', false, 2, null) == true) goto L317;
        r88 = true;
        goto L318
    L323:
        throw new IllegalArgumentException("Invalid HTTP header name".toString());
    L324:
        kotlinx.coroutines.j r89 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r122), 1);
        r89.C();
        final AtomicBoolean r90 = new AtomicBoolean(false);
        final AtomicReference r91 = new AtomicReference();
        UserSendHttpRequest.Builder r92 = new UserSendHttpRequest.Builder().url(r77.a);
        switch(g.b.a[r77.b.ordinal()]) {
            case 1: goto L334;
            case 2: goto L333;
            case 3: goto L332;
            case 4: goto L331;
            case 5: goto L330;
            case 6: goto L329;
            case 7: goto L328;
            default: goto L327;
        };
    L328:
        HttpMethod r125 = HttpMethod.OPTIONS;
    L335:
        UserSendHttpRequest.Builder r93 = r92.method(r125);
        Map<String, String> r126 = r77.g;
        ArrayList r127 = new ArrayList(r126.size());
        Iterator r128 = ((LinkedHashMap) r126).entrySet().iterator();
    L337:
        if (r128.hasNext() == false) goto L339;
        Map.Entry r129 = (Map.Entry) r128.next();
        r127.add(new HttpHeader((String) r129.getKey(), (String) r129.getValue()));
        r47 = r47;
        goto L337
    L339:
        String r314 = r47;
        UserSendHttpRequest.Builder r94 = r93.headers(new HttpHeaderMap(r127)).request_id(r77.c).timeout_s(Boxing.boxInt(r77.d)).no_follow_redirection(Boxing.boxBoolean(!r77.e)).disable_cookie(Boxing.boxBoolean(false));
        byte[] r130 = r77.h;
        if (r130 == null) goto L342;
        r94.body(ByteString.a.e(ByteString.Companion, r130));
    L342:
        l r131 = r76.a;
        Intrinsics.checkNotNull(r94);
        Disposable r95 = r131.h(new com.bytedance.lark.rustclient.api.d(r94, UserSendHttpResponse.ADAPTER, Command.USER_SEND_HTTP, r77.c, null, null, Boxing.boxBoolean(r77.f), 112)).a().subscribe(new j(r90, r91, r89, r76, r77), new k(r90, r91, r89, r77));
        if (r90.get() == false) goto L345;
        r95.dispose();
    L350:
        r7 = null;
    L351:
        r89.i(new PassportRustHttpClient$execute$2$2(r90, r91, r76, r77));
        r0 = r89.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L355;
        DebugProbesKt.probeCoroutineSuspended(r122);
    L355:
        if (r0 != r4) goto L357;
        return r4;
    L357:
        r6 = r314;
        goto L358
    L345:
        r91.set(r95);
        if (r90.get() == false) goto L350;
        r7 = null;
        Disposable r96 = (Disposable) r91.getAndSet(null);
        if (r96 == null) goto L351;
        r96.dispose();
        goto L351
    L329:
        r125 = HttpMethod.HEAD;
        goto L335
    L330:
        r125 = HttpMethod.PATCH;
        goto L335
    L331:
        r125 = HttpMethod.PUT;
        goto L335
    L332:
        r125 = HttpMethod.DELETE;
        goto L335
    L333:
        r125 = HttpMethod.POST;
        goto L335
    L334:
        r125 = HttpMethod.GET;
        goto L335
    L327:
        throw new NoWhenBranchMatchedException();
    L425:
        throw new IllegalArgumentException("Passport HTTP URL must use HTTP or HTTPS".toString());
    L302:
        if (StringsKt.equals(r81.getScheme(), "http", true) == true) goto L305;
        r83 = false;
        goto L306
    L427:
        throw new IllegalArgumentException("Passport HTTP URL must be absolute".toString());
    L287:
        if (r81.isAbsolute() == false) goto L297;
        String r97 = r81.getHost();
        if (r97 != null) goto L291;
    L294:
        boolean r98 = true;
    L295:
        if (r98 == true) goto L297;
        r82 = true;
        goto L298
    L291:
        if (StringsKt.isBlank(r97) == true) goto L294;
        r98 = false;
    L279:
        th = move-exception;
        Result.Companion r99 = Result.Companion;
        r80 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L282
    L429:
        throw new IllegalArgumentException("timeoutSeconds must be greater than zero".toString());
    L275:
        r78 = false;
        goto L276
    L431:
        throw new IllegalArgumentException("requestId must not be blank".toString());
    L440:
        Object r100 = Result.constructor-impl((IUserListService) e0c.k.a(LarkContext.getApplication(), IUserListService.class));     // Catch: Throwable -> L211
    L214:
        if (Result.isFailure-impl(r100) == false) goto L216;
        r100 = null;
    L216:
        IUserListService r101 = (IUserListService) r100;
        if (r101 == null) goto L254;
        Object r102 = Result.constructor-impl(r101.r());     // Catch: Throwable -> L221
    L224:
        if (Result.isFailure-impl(r102) == false) goto L226;
        r102 = null;
    L226:
        List r103 = (List) r102;
        if (r103 != null) goto L229;
        r103 = CollectionsKt.emptyList();
    L229:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L231:
        if (r105.hasNext() == false) goto L238;
        String r106 = (String) r105.next();
        Intrinsics.checkNotNull(r106);
        if ((!StringsKt.isBlank(r106)) == true) goto L236;
        r106 = null;
    L236:
        if (r106 == null) goto L231;
        r104.add(r106);
        goto L231
    L238:
        List r107 = CollectionsKt.distinct(r104);
        if ((!r107.isEmpty()) == false) goto L254;
        Set r108 = r67.keySet();
        if ((r108 instanceof Collection) == true) goto L243;
    L245:
        Iterator r109 = r108.iterator();
    L247:
        if (r109.hasNext() == false) goto L251;
        if (StringsKt.equals((String) r109.next(), "cookie", true) == false) goto L247;
        boolean r132 = false;
    L252:
        if (r132 == false) goto L254;
        r67.put("cookie", "session_list=" + CollectionsKt.joinToString$default(r107, "_", null, null, 0, null, null, 62, null) + ';');
    L251:
        r132 = true;
        goto L252
    L243:
        if (r108.isEmpty() == false) goto L245;
    L221:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r102 = Result.constructor-impl(ResultKt.createFailure(th));
    L211:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r100 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L214
    L460:
        Object r135 = Result.constructor-impl(LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getString("tt_env", ""));     // Catch: Throwable -> L194
    L197:
        if (Result.isFailure-impl(r135) == false) goto L199;
        r135 = null;
    L199:
        String r136 = (String) r135;
        if (r136 == null) goto L207;
        if ((!StringsKt.isBlank(r136)) == true) goto L205;
        r136 = null;
    L205:
        if (r136 == null) goto L207;
        r67.put("x-tt-env", r136);
    L194:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r135 = Result.constructor-impl(ResultKt.createFailure(th));
    L174:
        r71 = null;
        goto L178
    L450:
        Object r138 = Result.constructor-impl(r60.getPackageManager().getPackageInfo(r60.getPackageName(), 0).versionName);     // Catch: Throwable -> L150
    L153:
        if (Result.isFailure-impl(r138) == false) goto L155;
        r138 = null;
    L155:
        r66 = (String) r138;
        if (r66 == null) goto L160;
        if ((!StringsKt.isBlank(r66)) == false) goto L160;
    L150:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r138 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L153
    L145:
        r65 = "lark";
    L113:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r59 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L116
    L433:
        throw new IllegalArgumentException("Rust-managed auth and Passport common headers cannot be overridden".toString());
    L108:
        r57 = true;
        goto L109
    L99:
        if (r55.isEmpty() == false) goto L101;
    L435:
        throw new IllegalArgumentException("Passport request userId must not be blank".toString());
    L93:
        r54 = false;
        goto L95
    L89:
        r52 = CollectionsKt.joinToString$default(r44.entrySet(), "&", "?", null, 0, null, new FlowPassportAccountsHttpClient$toQueryString$1(this), 28, null);
        goto L90
    L437:
        throw new IllegalArgumentException("Passport accounts path must start with '/'".toString());
    L16:
        ResultKt.throwOnFailure(r0);
        gpb.a r141 = (gpb.a) ApiUtils.getApi(gpb.a.class);
        if (com.ss.android.lark.passport.a.a() == true) goto L442;
        Integer r142 = null;
    L34:
        if (r142 == null) goto L36;
        int r143 = r142.intValue();
        Intrinsics.checkNotNull(r141);
        gpb.a r144 = new c(r141, r143);
    L37:
        r2.L$0 = r33;
        r2.L$1 = r34;
        r2.L$2 = r35;
        r2.L$3 = r36;
        r2.L$4 = r37;
        r2.L$5 = r38;
        r121 = r39;
        r2.L$6 = r121;
        r2.L$7 = r144;
        r2.I$0 = r40;
        r2.Z$0 = r41;
        r2.Z$1 = r42;
        r2.label = 1;
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L40
        Object r146 = Result.constructor-impl((epb.a) ApiUtils.getApi(epb.a.class));     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r146) == false) goto L45;
        r146 = null;
    L45:
        epb.a r147 = (epb.a) r146;
        if (r147 == null) goto L439;
        Object r148 = Result.constructor-impl(r147.getDeviceIdFromLocal());     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r148) == false) goto L54;
        r148 = null;
    L54:
        String r149 = (String) r148;
        if (r149 == null) goto L59;
        boolean r150 = !StringsKt.isBlank(r149);
        Object r151 = r149;
        if (r150 == false) goto L59;
    L60:
        if (r151 == null) goto L448;
    L81:
        if (r151 != r4) goto L83;
        return r4;
    L83:
        r47 = r33;
        r49 = r35;
        r44 = r36;
        r32 = r37;
        r117 = r42;
        r118 = r151;
        r31 = r38;
        r210 = r144;
        r48 = r34;
        r120 = r40;
        r119 = r41;
        goto L84
    L448:
        Object r152 = Result.constructor-impl(r147.getDeviceId());     // Catch: Throwable -> L64
    L67:
        if (Result.isFailure-impl(r152) == false) goto L69;
        r152 = null;
    L69:
        String r153 = (String) r152;
        if (r153 == null) goto L74;
        int r154 = 1;
        boolean r155 = !StringsKt.isBlank(r153);
        r151 = r153;
        if (r155 == true) goto L76;
    L75:
        r151 = null;
    L76:
        if (r151 != null) goto L81;
        final kotlinx.coroutines.j r156 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), r154);
        r156.C();
        r147.getDeviceIdWithTimeout(LarkContext.getApplication(), new FlowPassportAccountsHttpClient$resolvePassportDeviceId$2$1(r156), 5000);
        r151 = r156.B();
        if (r151 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L81;
        DebugProbesKt.probeCoroutineSuspended(r2);
        goto L81
    L74:
        r154 = 1;
    L64:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        r152 = Result.constructor-impl(ResultKt.createFailure(th));
    L59:
        r151 = null;
    L49:
        th = move-exception;
        Result.Companion r158 = Result.Companion;
        r148 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L439:
        throw new PassportHttpDeviceIdException("Passport device id service is unavailable");
    L40:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        r146 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L36:
        Intrinsics.checkNotNull(r141);
        r144 = r141;
        goto L37
    L442:
        Result.Companion r160 = Result.Companion;     // Catch: Throwable -> L28
        Integer r161 = Integer.valueOf(LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getInt("custom_env_value", -1));     // Catch: Throwable -> L28
        if (r161.intValue() == (-1)) goto L22;
        boolean r162 = true;
    L23:
        if (r162 == true) goto L26;
        r161 = null;
    L26:
        Object r163 = Result.constructor-impl(r161);     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r163) == false) goto L33;
        r163 = null;
    L33:
        r142 = (Integer) r163;
        goto L34
    L22:
        r162 = false;
    L28:
        th = move-exception;
        Result.Companion r164 = Result.Companion;
        r163 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new FlowPassportAccountsHttpClient$executeAccounts$1(this, r43);
        goto L8
    }
}
