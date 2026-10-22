package com.bytedance.sdk.xbridge.cn.auth;

import ai.j0;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthConfigSource;
import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckAction;
import com.lynx.tasm.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import li.m;
import li.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mi.b f7347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7349c;
    public final Lazy d;
    public mi.c e;

    public i() {
        this.f7347a = new f9.a(7);
        this.f7348b = new ConcurrentHashMap();
        this.f7349c = true;
        this.d = LazyKt.lazy(WebAuthVerifier$onlyUseHostNamespace$2.f7296a);
        this.e = new ib.d(7);
    }

    public final li.c a(String r29, li.e r30, String r31) {
        Intrinsics.checkNotNullParameter(r29, Constant.APPID);
        Intrinsics.checkNotNullParameter(r30, "bridgeInfo");
        Intrinsics.checkNotNullParameter(r31, "namespace");
        li.a r5 = e.c(r29, r31);
        AuthErrorCode r10 = AuthErrorCode.d;
        String r11 = r30.d;
        AuthConfigType r12 = null;
        if (r11 != null) goto L6;
        r10 = AuthErrorCode.f7312l;
    L5:
        AuthErrorCode r13 = r10;
    L11:
        String r14 = "";
        AuthBridgeAccess r15 = r30.f19653b;
        String r16 = r30.f19652a;
        if (r13 != null) goto L49;
        String r17 = r30.d;
        if (r17 != null) goto L16;
        r17 = "";
    L16:
        Uri r18 = Uri.parse(r17);
        String r19 = r18.getHost() + r18.getPath();
        ConcurrentHashMap r110 = this.f7348b;
        a r111 = (a) r110.get(r19);
        if (r111 != null) goto L20;
        r111 = new a(new d(127));
        mi.b r112 = this.f7347a;
        Intrinsics.checkNotNullParameter(r112, "logDepend");
        r111.f7299c = r112;
        r110.put(r19, r111);
    L20:
        Intrinsics.checkNotNullParameter(r30, "bridgeInfo");
        StringBuilder r20 = new StringBuilder("AuthV2VerifyHelper config type :");
        if (r5 == null) goto L23;
        r12 = r5.f19633a;
    L23:
        r20.append(r12);
        r111.f7299c.a("AuthV2VerifyHelper", r20.toString());
        if (r5 != null) goto L26;
        r111.f7299c.a("AuthV2VerifyHelper", "auth config is null,pass");
        li.c r21 = new li.c(true, null, null, null, 62);
    L47:
        r111.b(r21, r30);
        String r22 = r16;
    L56:
        if (this.f7349c == false) goto L62;
        mi.a r23 = new mi.a();
        JSONObject r24 = new JSONObject();
        String r25 = r30.d;
        if (r25 == null) goto L61;
        r14 = r25;
    L61:
        r24.put("url", r14);
        r24.put("fe_id", r29);
        r24.put("method_name", r22);
        r24.put("auth_type", r15);
        r24.put("result", r21.f19640a ? 1 : 0);
        r24.put(NotificationCompat.CATEGORY_STATUS, r21.a());
        r23.f20109a = r24;
        r23.f20110b = true;
        this.e.a(r23);
    L62:
        r21.f = e.a(r31);
        return r21;
    L26:
        AuthErrorCode r113 = r111.a(r5.g, r30);
        if (r113 == null) goto L30;
        r21 = new li.c(false, null, r113, null, 54);
        goto L47
    L30:
        if (r5.f.contains(r16) == false) goto L33;
        r111.f7299c.a("AuthV2VerifyHelper", j0.j(r16, " is in exclude methods,fail"));
        r21 = new li.c(false, "method in exclude methods", AuthErrorCode.e, null, 50);
        goto L47
    L33:
        if (r5.e.contains(r16) == false) goto L36;
        r111.f7299c.a("AuthV2VerifyHelper", j0.j(r16, " is in included methods,pass"));
        r21 = new li.c(true, null, null, null, 62);
        goto L47
    L36:
        if (r15 != AuthBridgeAccess.e) goto L38;
        r111.f7299c.a("AuthV2VerifyHelper", j0.j(r16, " is secure,and not in include method,fail"));
        r21 = new li.c(false, "method is secure,and not in include method,fail", AuthErrorCode.f, null, 50);
        goto L47
    L38:
        AuthBridgeAccess r26 = r5.d;
        if (r26.compareTo(r15) < 0) goto L41;
        boolean r27 = true;
    L42:
        if (r27 == true) goto L44;
        r111.f7299c.a("AuthV2VerifyHelper", "no permission,bridge " + r16 + " auth level is " + r15 + ",but group auth level is " + r26);
    L44:
        if (r27 == false) goto L46;
        r21 = new li.c(true, null, null, null, 62);
        goto L47
    L46:
        r21 = new li.c(false, "method < rule", AuthErrorCode.g, null, 50);
        goto L47
    L41:
        r27 = false;
        goto L42
    L49:
        if (r13 != AuthErrorCode.f7312l) goto L51;
        r22 = r16;
        r21 = new li.c(false, "auth url is empty", r13, null, 50);
        b("WebAuthVerifier auth url is empty");
        goto L56
    L51:
        r22 = r16;
        if (r13 != AuthErrorCode.f7307c) goto L54;
        r21 = new li.c(false, "app id is not legal, appid:".concat(r29), r13, null, 50);
        b("WebAuthVerifier app id is not legal");
        goto L56
    L54:
        r21 = new li.c(false, "not in safe url, url:" + r30.d, r13, null, 50);
        b("WebAuthVerifier not in safe url");
        goto L56
    L6:
        if (r5 != null) goto L9;
        r10 = AuthErrorCode.f7307c;
        goto L5
    L9:
        if (com.lynx.tasm.utils.d.m(r11, r5.f19634b) == false) goto L5;
        r13 = null;
        goto L11
    }

    public final void b(String r5) {
        ab.b r10 = new ab.b(15, this, r5);
        Intrinsics.checkNotNullParameter(r10, "runnable");
        if (com.lynx.tasm.utils.b.f11162a != null) goto L5;
        com.lynx.tasm.utils.b.f11162a = Executors.newSingleThreadExecutor();
    L5:
        ExecutorService r11 = com.lynx.tasm.utils.b.f11162a;
        Intrinsics.checkNotNull(r11);
        r11.submit(r10);
    }

    public final li.c c(String r37, li.e r38, String r39) {
        i r5 = this;
        li.e r10 = r38;
        String r11 = r39;
        Intrinsics.checkNotNullParameter(r37, Constant.APPID);
        String r12 = "bridgeInfo";
        Intrinsics.checkNotNullParameter(r10, "bridgeInfo");
        Intrinsics.checkNotNullParameter(r11, "callNamespace");
        String r13 = r10.d;
        StringBuilder r14 = com.lynx.tasm.utils.e.b("Start H5 auth v3: ", r13, ", method name: ");
        String r15 = r10.f19652a;
        r14.append(r15);
        r14.append(", namespace: ");
        r14.append(r11);
        r5.b(r14.toString());
        if (r13 != null) goto L6;
        li.c r16 = new li.c(false, "empty url", AuthErrorCode.f7312l, null, 50);
    L354:
        StringBuilder r17 = new StringBuilder("End H5 auth v3: verify result: ");
        r17.append(r16.f19640a);
        r17.append(", auth code: ");
        AuthErrorCode r18 = r16.d;
        if (r18 == null) goto L357;
        int r19 = r18.f7315a;
    L361:
        r17.append(r19);
        r17.append(", status: ");
        r17.append(r16.a());
        r5.b(r17.toString());
        return r16;
    L357:
        AuthSuccessCode r20 = r16.e;
        if (r20 == null) goto L360;
        r19 = r20.f7325a;
        goto L361
    L360:
        r19 = 0;
        goto L361
    L6:
        if (e.f7342a.isEmpty() == false) goto L8;
        r16 = new li.c(true, "all permission config not found", null, AuthSuccessCode.f7321h, 42);
        goto L354
    L8:
        Uri r110 = Uri.parse(r13);
        StringBuilder r111 = sk.a.a(r110.getHost());
        r111.append(r110.getPath());
        String r112 = r111.toString();
        ConcurrentHashMap r113 = r5.f7348b;
        a r114 = (a) r113.get(r112);
        String r115 = ".";
        Lazy r116 = r5.d;
        String r21 = "";
        if (r114 == null) goto L25;
        d r22 = r114.f7297a;
        Integer r117 = StringsKt.toIntOrNull(r22.f);
        if (r117 == null) goto L13;
        int r118 = r117.intValue();
    L14:
        if (r118 <= 0) goto L16;
        boolean r119 = true;
    L17:
        if (r119 == false) goto L22;
        li.a r120 = e.c(r22.f, "");
        if (r120 == null) goto L24;
        r22.a(r22.f, r120, FeAuthConfigSource.e);
    L24:
        String r121 = "host";
        Lazy r23 = r116;
    L115:
        Intrinsics.checkNotNullParameter(r10, r12);
        li.g r24 = (li.g) pi.a.f21356c.get(r121);
        if (r24 != null) goto L118;
        r24 = new li.g();
    L118:
        AuthConfigType r25 = r10.e;
        AuthConfigType r26 = AuthConfigType.f7306c;
        if (r25 != r26) goto L121;
        boolean r122 = r24.f19660c;
    L122:
        if (r25 != r26) goto L124;
        String[] r27 = r24.d;
    L125:
        Map r28 = r24.e;
        String r29 = r15;
        boolean r123 = r28.containsKey(r29);
        d r124 = r114.f7297a;
        if (r123 == false) goto L135;
        Integer r30 = (Integer) r28.get(r29);
        if (r30 == null) goto L130;
        int r31 = r30.intValue();
    L132:
        if (r124.d < r31) goto L135;
        Pair r32 = new Pair(AuthBridgeAccess.e, Boolean.valueOf(r122));
    L140:
        AuthBridgeAccess r33 = (AuthBridgeAccess) r32.component1();
        boolean r34 = ((Boolean) r32.component2()).booleanValue();
        Intrinsics.checkNotNullParameter(r10, r12);
        Intrinsics.checkNotNullParameter(r33, "methodAccess");
        AuthErrorCode r210 = r114.a(r124.e, r10);
        if (r210 == null) goto L144;
        li.c r35 = new li.c(false, null, r210, null, 54);
        String r211 = "";
        r29 = r29;
        d r212 = r124;
    L330:
        r35.f19646k = r13;
        if (r34 == false) goto L333;
        AuthMode r36 = AuthMode.e;
    L334:
        r35.f19647l = r36;
        r35.g = r33;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        d r40 = r212;
        r35.f19645j = r40.f;
        FeAuthConfigSource r41 = r40.g;
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r35.f19643h = r41;
        r35.f19644i = r40.f7339a;
        Integer r42 = StringsKt.toIntOrNull(r40.f);
        if (r42 == null) goto L337;
        int r43 = r42.intValue();
    L338:
        if (r43 <= 0) goto L340;
        boolean r44 = true;
    L341:
        if (r44 == false) goto L344;
        r11 = r211;
    L344:
        if (((Boolean) r23.getValue()).booleanValue() == false) goto L346;
        int r45 = e.a(r211);
    L347:
        r35.f = r45;
        r5 = this;
        if (r5.f7349c == false) goto L353;
        mi.a r46 = new mi.a();
        JSONObject r47 = com.lynx.tasm.utils.d.k("auth_url", r13);
        r47.put("fe_id", r35.f19645j);
        r47.put("fe_id_mapper", null);
        r47.put("method_name", r29);
        r47.put("method_auth_type", r33.f7303a);
        r47.put("result", r35.f19640a ? 1 : 0);
        r47.put(NotificationCompat.CATEGORY_STATUS, r35.a());
        r47.put("package_version", r35.f);
        Object r48 = r35.f19648m;
        if (r48 != null) goto L352;
        r48 = r211;
    L352:
        r47.put("request_trackings", r48);
        r46.f20109a = r47;
        r46.f20110b = true;
        r5.e.a(r46);
    L353:
        r16 = r35;
        goto L354
    L346:
        r45 = e.a(r11);
        goto L347
    L340:
        r44 = false;
        goto L341
    L337:
        r43 = 0;
        goto L338
    L333:
        r36 = AuthMode.d;
        goto L334
    L144:
        if (r124.f7341c.contains(r29) == false) goto L147;
        r114.f7299c.a("AuthV2VerifyHelper", io.reactivex.internal.observers.h.b(r29, " is in exclude methods,fail"));
        li.c r49 = new li.c(false, "method in exclude methods", AuthErrorCode.e, null, 50);
    L162:
        if (r49.f19640a == false) goto L328;
        mn.i r50 = pi.b.f21357a;
        r50.getClass();
        Intrinsics.checkNotNullParameter(r29, "method");
        JSONObject r125 = r10.f19654c;
        Intrinsics.checkNotNullParameter(r125, "parameters");
        RequestCheckAction r126 = RequestCheckAction.f7334b;
        Intrinsics.checkNotNullParameter(r126, "action");
        Map r127 = pi.a.d;
        if (r127 == null) goto L170;
        if (r127.isEmpty() != true) goto L170;
        r126 = RequestCheckAction.e;
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
    L168:
        r211 = "";
        r212 = r124;
        LinkedHashMap r51 = null;
        LinkedHashMap r52 = null;
        Object r128 = null;
        boolean r129 = true;
    L284:
        r49 = new li.c(true, null, null, null, 62);
        int r53 = r126.ordinal();
        if (r53 != 0) goto L287;
    L306:
        r49.e = AuthSuccessCode.g;
    L308:
        if (r49.d != AuthErrorCode.f7313m) goto L310;
        String r54 = "failed_request_parameters_check_deny";
    L317:
        r49.f19642c = r54;
        JSONObject r55 = new JSONObject();
        r55.put("action", r126.f7336a);
        LinkedHashMap r130 = new LinkedHashMap();
        if (r51 == null) goto L320;
        r130.putAll(r51);
    L320:
        if (r52 == null) goto L323;
        r130.putAll(r52);
    L323:
        if (r130.isEmpty() == true) goto L325;
        r55.put("trackings", r130);
    L325:
        if (r128 == null) goto L327;
        r55.put("reason", r128);
    L327:
        r49.f19648m = r55;
    L329:
        r114.b(r49, r10);
        r35 = r49;
        goto L330
    L310:
        AuthSuccessCode r56 = r49.e;
        if (r56 != AuthSuccessCode.f7323j) goto L314;
        r54 = "success_request_parameters_warn";
        goto L317
    L314:
        if (r56 != AuthSuccessCode.g) goto L316;
        r54 = "success_request_parameters_check_passed";
        goto L317
    L316:
        r54 = null;
        goto L317
    L287:
        if (r53 != 1) goto L289;
        if (r52 != null) goto L304;
        if (r128 != null) goto L304;
        AuthSuccessCode r57 = AuthSuccessCode.g;
    L305:
        r49.e = r57;
    L304:
        r57 = AuthSuccessCode.f7323j;
        goto L305
    L289:
        if (r53 != 2) goto L291;
        if (r129 == false) goto L299;
        if (r52 != null) goto L297;
        if (r128 != null) goto L297;
        AuthSuccessCode r58 = AuthSuccessCode.g;
    L298:
        r49.e = r58;
    L300:
        r49.f19640a = r129;
    L297:
        r58 = AuthSuccessCode.f7323j;
        goto L298
    L299:
        r49.d = AuthErrorCode.f7313m;
        goto L300
    L291:
        if (r53 == 3) goto L306;
        r49.e = AuthSuccessCode.f7323j;
    L170:
        if (r29.length() == 0) goto L168;
        HashMap r59 = (HashMap) r50.f20153a;
        m r60 = (m) r59.get(r29);
        if (r60 != null) goto L187;
        Map r61 = pi.a.d;
        if (r61 == null) goto L178;
        Map r62 = (Map) r61.get(r29);
    L179:
        if (r62 == null) goto L186;
        Intrinsics.checkNotNullParameter(r62, "dictionary");
        if (pi.a.e == null) goto L183;
        r60 = new m(r62);
    L184:
        if (r60 == null) goto L186;
        r59.put(r29, r60);
        goto L187
    L183:
        r60 = null;
    L186:
        r60 = null;
        goto L187
    L178:
        r62 = null;
    L187:
        if (r60 == null) goto L168;
        RequestCheckAction r63 = r60.f19672a;
        Intrinsics.checkNotNullParameter(r63, "<set-?>");
        if (r63 != r126) goto L193;
    L191:
        r126 = r63;
        goto L168
    L193:
        if (r63 != RequestCheckAction.d) goto L195;
    L197:
        LinkedHashSet r131 = new LinkedHashSet();
        HashMap r132 = r60.f19673b;
        r131.addAll(r132.keySet());
        HashMap r64 = r60.f19674c;
        r131.addAll(r64.keySet());
        LinkedHashMap r65 = new LinkedHashMap();
        LinkedHashMap r66 = new LinkedHashMap();
        Iterator r133 = r131.iterator();
    L199:
        if (r133.hasNext() == false) goto L216;
        Iterator r310 = r133;
        String r134 = (String) r133.next();
        String r213 = r21;
        String r214 = r115;
        d r215 = r124;
        Iterator r67 = StringsKt.K(r134, new String[]{r115}, 0, 6).iterator();
        Object r135 = r125;
    L202:
        if (r67.hasNext() == false) goto L209;
        String r136 = (String) r67.next();
        if (r135 == null) goto L209;
        Iterator r137 = r67;
        if ((r135 instanceof JSONObject) == false) goto L209;
        r135 = ((JSONObject) r135).opt(r136);
        r67 = r137;
    L209:
        if (r135 != null) goto L211;
        r66.put(r134, "null");
    L213:
        r133 = r310;
        r21 = r213;
        r115 = r214;
        r124 = r215;
        goto L199
    L211:
        if ((r135 instanceof String) == false) goto L214;
        r65.put(r134, r135);
        goto L213
    L214:
        r66.put(r134, r135.getClass().getSimpleName());
        goto L213
    L216:
        r211 = r21;
        r212 = r124;
        if (r65.isEmpty() == true) goto L219;
        LinkedHashMap r68 = r65;
    L221:
        if (r66.isEmpty() == false) goto L224;
        r66 = null;
    L224:
        Iterator r69 = r65.entrySet().iterator();
        boolean r138 = true;
        r128 = null;
        Exception r139 = null;
    L226:
        if (r69.hasNext() == false) goto L277;
        Map.Entry r140 = (Map.Entry) r69.next();
        r68 = r68;
        String r70 = (String) r140.getKey();
        r69 = r69;
        String r71 = (String) r140.getValue();
        if (r138 == false) goto L278;
        ArrayList r141 = (ArrayList) r64.get(r70);
        if (r141 == null) goto L244;
        Iterator r142 = r141.iterator();
        boolean r216 = true;
    L234:
        if (r142.hasNext() == false) goto L243;
        HashMap r217 = r64;
        String r72 = (String) r142.next();
        if (r216 == false) goto L237;
        Pair r218 = mn.i.a(r72, r71);
        boolean r219 = ((Boolean) r218.component1()).booleanValue();
        Exception r220 = (Exception) r218.component2();
        if (r219 == false) goto L241;
        r128 = k.j(r70, " [exclude_reg]: ", r72);
        r216 = false;
    L241:
        if (r220 == null) goto L237;
        r139 = r220;
    L237:
        r64 = r217;
        goto L234
    L243:
        r64 = r64;
    L245:
        if (r138 == false) goto L248;
        if (r216 == false) goto L248;
        boolean r73 = true;
    L249:
        if (r73 == false) goto L279;
        ArrayList r143 = (ArrayList) r132.get(r70);
        if (r143 == null) goto L256;
        r66 = r66;
        if (r143.isEmpty() != true) goto L257;
        boolean r74 = true;
    L258:
        ArrayList r144 = (ArrayList) r132.get(r70);
        if (r144 == null) goto L271;
        Iterator r145 = r144.iterator();
    L262:
        if (r145.hasNext() == false) goto L271;
        Iterator r221 = r145;
        String r146 = (String) r145.next();
        if (r74 == true) goto L265;
        Pair r147 = mn.i.a(r146, r71);
        boolean r222 = ((Boolean) r147.component1()).booleanValue();
        Exception r148 = (Exception) r147.component2();
        if (r222 == false) goto L269;
        r74 = true;
    L269:
        if (r148 == null) goto L265;
        r139 = r148;
    L265:
        r145 = r221;
    L271:
        if (r74 == true) goto L273;
        r128 = io.reactivex.internal.observers.h.b(r70, " [match_reg] hit nothing");
    L273:
        if (r73 == false) goto L276;
        if (r74 == false) goto L276;
        r138 = true;
    L276:
        r138 = false;
    L257:
        r74 = false;
        goto L258
    L256:
        r66 = r66;
    L279:
        if (r128 != null) goto L283;
        if (r139 == null) goto L282;
        r128 = r139.getMessage();
        goto L283
    L282:
        r128 = null;
    L283:
        r51 = r68;
        r129 = r73;
        r52 = r66;
        r126 = r63;
    L248:
        r73 = false;
        goto L249
    L244:
        r64 = r64;
        r216 = true;
    L278:
        r73 = r138;
        goto L279
    L277:
        r68 = r68;
        goto L278
    L219:
        r68 = null;
        goto L221
    L195:
        if (r63 == RequestCheckAction.f7335c) goto L197;
    L328:
        r211 = "";
        r29 = r29;
        r212 = r124;
        goto L329
    L147:
        if (r124.f7340b.contains(r29) == false) goto L150;
        r114.f7299c.a("AuthV2VerifyHelper", io.reactivex.internal.observers.h.b(r29, " is in included methods,pass"));
        r49 = new li.c(true, "", null, null, 58);
        goto L162
    L150:
        if (r33 != AuthBridgeAccess.e) goto L153;
        r114.f7299c.a("AuthV2VerifyHelper", io.reactivex.internal.observers.h.b(r29, " is secure,and not in include method,fail"));
        r49 = new li.c(false, "method is secure,and not in include method,fail", AuthErrorCode.f, null, 50);
        goto L162
    L153:
        if (r124.f7339a.compareTo(r33) < 0) goto L155;
        boolean r75 = true;
    L156:
        if (r75 == true) goto L158;
        r114.f7299c.a("AuthV2VerifyHelper", "no permission,bridge " + r29 + " auth level is " + r33 + ",but fe group auth level is " + r124.f7339a);
    L158:
        if (r75 == false) goto L160;
        r49 = new li.c(true, null, null, null, 62);
        goto L162
    L160:
        r49 = new li.c(false, "method < rule", AuthErrorCode.g, null, 50);
        goto L162
    L155:
        r75 = false;
        goto L156
    L130:
        r31 = 0;
    L135:
        if (ArraysKt.contains(r27, r29) == false) goto L137;
        r32 = new Pair(AuthBridgeAccess.f7302c, Boolean.valueOf(r122));
        goto L140
    L137:
        if (r122 == false) goto L139;
        r32 = new Pair(AuthBridgeAccess.d, Boolean.valueOf(r122));
        goto L140
    L139:
        r32 = new Pair(r10.f19653b, Boolean.valueOf(r122));
        goto L140
    L124:
        r27 = r24.f19659b;
        goto L125
    L121:
        r122 = r24.f19658a;
        goto L122
    L22:
        if (r22.g != FeAuthConfigSource.f7329h) goto L24;
        FeAuthConfigSource r76 = FeAuthConfigSource.f7331j;
        Intrinsics.checkNotNullParameter(r76, "<set-?>");
        r22.g = r76;
        goto L24
    L16:
        r119 = false;
        goto L17
    L13:
        r118 = 0;
        goto L14
    L25:
        Uri r77 = Uri.parse(r13);
        String r149 = r77.getHost();
        r121 = "host";
        d r78 = new d(62);
        Integer r150 = StringsKt.toIntOrNull(r37);
        if (r150 == null) goto L28;
        int r151 = r150.intValue();
    L29:
        if (r151 <= 0) goto L36;
        li.a r152 = e.c(r37, "");
        if (r152 == null) goto L36;
        if (com.lynx.tasm.utils.d.m(r13, r152.f19634b) == false) goto L36;
        r78.a(r37, r152, FeAuthConfigSource.f);
        String r223 = "bridgeInfo";
    L35:
        r112 = r112;
        r23 = r116;
    L111:
        r114 = new a(r78);
        mi.b r79 = r5.f7347a;
        Intrinsics.checkNotNullParameter(r79, "logDepend");
        r114.f7299c = r79;
        if (r78.g.f7333a <= 0) goto L114;
        r113.put(r112, r114);
    L114:
        r10 = r38;
        r12 = r223;
    L36:
        n r80 = pi.a.f21355b;
        if (r80 != null) goto L40;
        r80 = pi.a.f21354a;
    L40:
        if (r80.f19677c == false) goto L50;
        Iterator r81 = e.f().entrySet().iterator();
    L43:
        if (r81.hasNext() == false) goto L50;
        Map.Entry r82 = (Map.Entry) r81.next();
        String r153 = (String) r82.getKey();
        li.a r83 = (li.a) r82.getValue();
        Iterator r311 = r81;
        r223 = r12;
        if (r83.f19633a != AuthConfigType.f7305b) goto L49;
        if (com.lynx.tasm.utils.d.m(r13, r83.f19634b) == false) goto L49;
        r78.a(r153, r83, FeAuthConfigSource.g);
    L49:
        r81 = r311;
        r12 = r223;
    L50:
        r223 = r12;
        Intrinsics.checkNotNullParameter("-1", "<set-?>");
        r78.f = "-1";
        if (r149 == null) goto L57;
        Object[] r84 = new Regex("[.]").split(r149, 0).toArray(new String[0]);
        if (r84 == null) goto L364;
        String[] r85 = (String[]) r84;
        int r86 = r85.length;
        if (r86 < 2) goto L57;
        if (r86 != 2) goto L60;
        String r87 = r149;
    L61:
        if (r149 != null) goto L63;
    L67:
        r23 = r116;
        FeAuthConfigSource r88 = FeAuthConfigSource.f7327b;
        Intrinsics.checkNotNullParameter(r88, "<set-?>");
        r78.g = r88;
    L91:
        if (r149 == null) goto L111;
        n r89 = pi.a.f21355b;
        if (r89 != null) goto L95;
        r89 = pi.a.f21354a;
    L95:
        Map r90 = r89.f19676b;
        Intrinsics.checkNotNullParameter(r11, "namespace");
        if (Intrinsics.areEqual(r11, "") == false) goto L98;
        String r91 = r121;
    L99:
        String[] r92 = (String[]) r90.get(r91);
        if (r92 != null) goto L102;
        r92 = new String[0];
    L102:
        int r93 = r92.length;
        int r94 = 0;
    L103:
        if (r94 >= r93) goto L111;
        String r95 = r92[r94];
        if (Intrinsics.areEqual(r149, r95) == true) goto L110;
        if (StringsKt.k(r149, td.d.b(".", r95)) == true) goto L110;
        r94 = r94 + 1;
    L110:
        r78.f7339a = AuthBridgeAccess.d;
        r78.g = FeAuthConfigSource.f7330i;
        goto L111
    L98:
        r91 = r11;
        goto L99
    L63:
        if (TextUtils.isEmpty(r77.getScheme()) == true) goto L67;
        if (TextUtils.isEmpty(r149) == true) goto L67;
        if (r87 == null) goto L67;
        LinkedHashSet r96 = new LinkedHashSet();
        LinkedHashSet r97 = new LinkedHashSet();
        AuthBridgeAccess r154 = AuthBridgeAccess.f7302c;
        if (((Boolean) r116.getValue()).booleanValue() == false) goto L71;
        List r98 = e.e(r87, "");
    L72:
        Iterator r155 = r98.iterator();
        boolean r224 = false;
    L74:
        if (r155.hasNext() == false) goto L87;
        r155 = r155;
        li.b r156 = (li.b) r155.next();
        String r99 = r156.f19637a;
        r116 = r116;
        Intrinsics.checkNotNullParameter(r13, "content");
        Intrinsics.checkNotNullParameter(r99, "pattern");
        Result.Companion r157 = Result.Companion;     // Catch: Throwable -> L78
        boolean r100 = Pattern.compile(r99).matcher(r13).find();     // Catch: Throwable -> L78
    L80:
        if (r100 == true) goto L81;
        r155 = r155;
        goto L74
    L81:
        r96.addAll(r156.f19639c);
        r97.addAll(r156.d);
        AuthBridgeAccess r101 = r156.f19638b;
        if (r101.compareTo(r154) < 0) goto L84;
        r154 = r101;
    L84:
        r224 = true;
    L78:
        th = move-exception;
        Result.Companion r158 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r100 = false;
        goto L80
    L87:
        r23 = r116;
        if (r224 == false) goto L91;
        FeAuthConfigSource r102 = FeAuthConfigSource.f7329h;
        Intrinsics.checkNotNullParameter(r154, "newAccess");
        Intrinsics.checkNotNullParameter(r96, "newIncludeMethods");
        Intrinsics.checkNotNullParameter(r97, "newExcludedMethods");
        Intrinsics.checkNotNullParameter(r102, "updateSource");
        r78.f = "-1";
        r78.f7339a = r154;
        r78.f7340b = r96;
        r78.f7341c = r97;
        r78.g = r102;
        goto L111
    L71:
        r98 = e.e(r87, r11);
        goto L72
    L60:
        r87 = r85[r86 - 2] + '.' + r85[r86 - 1];
        goto L61
    L364:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L57:
        r87 = null;
        goto L61
    L28:
        r151 = 0;
        goto L29
    }
}
