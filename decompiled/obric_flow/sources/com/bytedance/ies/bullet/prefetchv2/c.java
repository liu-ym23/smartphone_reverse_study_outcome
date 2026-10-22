package com.bytedance.ies.bullet.prefetchv2;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.ArgusPrefetchVerifyReason;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.bean.AspectContext$Companion$TraceStage;
import com.bytedance.ies.argus.bean.AspectContext$Companion$TraceType;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v14, types: [T] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v6, types: [T] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static f a(Uri r12, String r13) {
        final String r5 = io.reactivex.exceptions.a.b(r12, r13);
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = io.reactivex.exceptions.a.h(r12, "prefetch_channel");
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = io.reactivex.exceptions.a.h(r12, "prefetch_bundle");
        CharSequence r14 = (CharSequence) r10.element;
        String r15 = "";
        if (r14 != null) goto L5;
    L11:
        com.bytedance.ies.bullet.kit.resourceloader.h r16 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r13);
        r16.getClass();
        if (r5 != null) goto L15;
    L13:
        fc.a r17 = null;
    L22:
        if (r17 != null) goto L24;
    L28:
        ?? r18 = io.reactivex.exceptions.a.h(r12, LynxMonitorService.KEY_CHANNEL);
    L29:
        r10.element = r18;
        if (r17 != null) goto L32;
    L36:
        ?? r19 = io.reactivex.exceptions.a.h(r12, "bundle");
    L37:
        r11.element = r19;
    L38:
        final String r20 = io.reactivex.exceptions.a.h(r12, "prefetch_ak");
        i(new InternalConfigLoader$loadConfigFromRL$1(r5, r10, r11, r20));
        wc.g r21 = new wc.g("");
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r21.f22838c = r13;
        Intrinsics.checkNotNullParameter("prefetch", "<set-?>");
        r21.f22840i = "prefetch";
        r21.d = 0;
        if (Intrinsics.areEqual(io.reactivex.exceptions.a.h(r12, "prefetch_res_from"), "disable_cdn") == false) goto L42;
        wc.a r22 = new wc.a(false);
        r22.e = CollectionsKt.mutableListOf(new Class[]{cc.b.class});
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.f22837b = r22;
    L42:
        if (r5 != null) goto L121;
    L46:
        String r23 = (String) r10.element;     // Catch: Throwable -> L44
        if (r23 == null) goto L49;
        Intrinsics.checkNotNullParameter(r23, "<set-?>");     // Catch: Throwable -> L44
        r21.f = r23;     // Catch: Throwable -> L44
    L49:
        String r24 = (String) r11.element;     // Catch: Throwable -> L44
        if (r24 == null) goto L56;
        String r25 = "prefetch.json";
        Intrinsics.checkNotNullParameter(r24, "<this>");     // Catch: Throwable -> L44
        Intrinsics.checkNotNullParameter("prefetch.json", "suffix");     // Catch: Throwable -> L44
        if (StringsKt.g(r24, "/") == false) goto L55;
        r25 = e(r24);     // Catch: Throwable -> L44
    L55:
        Intrinsics.checkNotNullParameter(r25, "<set-?>");     // Catch: Throwable -> L44
        r21.g = r25;     // Catch: Throwable -> L44
    L56:
        if (r20 == null) goto L60;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");     // Catch: Throwable -> L44
        r21.f22836a = r20;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        l("Prefetch resourceloader 配置创建失败: " + th.getMessage());
    L60:
        a0 r26 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r13).c("", r21);
        if (r26 != null) goto L64;
        l("Prefetch配置加载失败, url可能不合法: " + r12);
        return null;
    L64:
        com.bytedance.ies.argus.api.b r27 = (com.bytedance.ies.argus.api.b) com.bytedance.ies.argus.api.b.f4956c.getValue();
        com.bytedance.ies.argus.strategy.provider.client.e r28 = new com.bytedance.ies.argus.strategy.provider.client.e(r26.f5952z, r26.s, r26.f5946t);
        r27.getClass();
        Intrinsics.checkNotNullParameter(r28, LynxResourceModule.PARAMS_KEY);
        Lazy r29 = com.bytedance.ies.argus.repository.a.d;
        com.bytedance.ies.argus.repository.a r30 = l9.o.c();
        ArgusGlobalAspect r31 = ArgusGlobalAspect.f5036b;
        r30.getClass();
        Intrinsics.checkNotNullParameter(r31, "aspect");
        Integer r32 = (Integer) r30.f5131a.get(r31);
        if (r32 != null) goto L68;
    L70:
        com.bytedance.ies.argus.aspect.eventCenter.a r33 = new com.bytedance.ies.argus.aspect.eventCenter.a(r27.f4958b, r31, r28);
        com.bytedance.ies.argus.bean.a r34 = r33.f4991a;
        r34.getClass();
        AspectContext$Companion$TraceType r35 = AspectContext$Companion$TraceType.f5111c;
        r34.a(r35, AspectContext$Companion$TraceStage.f5107a, null);
        r34.b();
        r27.f4957a.getClass();
        Intrinsics.checkNotNullParameter(r34, "aspectContext");
        com.bytedance.ies.argus.repository.c r36 = (com.bytedance.ies.argus.repository.c) r34.f5122c.getValue();
        com.bytedance.ies.argus.bean.b r37 = r34.b();
        ArgusCommonVerifyReason r38 = ArgusCommonVerifyReason.f5020h;
        r37.getClass();
        Intrinsics.checkNotNullParameter(r38, "reason");
        ((ArrayList) r37.g).add(r38.a());
        ((ArrayList) r37.f5127h).add(r38);
        r34.a(r35, AspectContext$Companion$TraceStage.f5108b, null);
        com.bytedance.ies.argus.aspect.eventCenter.a.a(r33);
        com.bytedance.ies.argus.bean.b r39 = r34.b();
    L72:
        if (((ArgusVerifyAction) r39.f5126c) != ArgusVerifyAction.f5092b) goto L116;
        InputStream r40 = r26.c();
        if (r40 == null) goto L79;
        r15 = new String(ByteStreamsKt.readBytes(r40), Charsets.UTF_8);     // Catch: Throwable -> L118
    L79:
        if (r15.length() != 0) goto L82;
        l("Prefetch配置加载失败: " + r26.f5938k + '-' + r26.f5942o);
        return null;
    L82:
        Intrinsics.checkNotNullParameter(r15, "<this>");
        f r41 = new f(new JSONObject(r15));     // Catch: Exception -> L85
    L87:
        if (r41 == null) goto L115;
        ArrayList r42 = r41.f5847c;
        if (r42 != null) goto L91;
    L114:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPrefetch", "apis为空", null, 12);
        goto L115
    L91:
        if (r42.isEmpty() == true) goto L114;
        Iterator r43 = r42.iterator();
    L95:
        if (r43.hasNext() == false) goto L112;
        i r44 = (i) r43.next();
        String r45 = r44.f5855a;
        if (r45 == null) goto L111;
        if (r45.length() == 0) goto L111;
        String r46 = r44.f5856b;
        if (r46 == null) goto L104;
        String r47 = r46.toLowerCase(Locale.ROOT);
    L106:
        if (Intrinsics.areEqual(r47, "get") == true) goto L95;
        if (Intrinsics.areEqual(r47, "post") == true) goto L95;
        l("不支持的请求类型: " + r46);
        goto L115
    L104:
        r47 = null;
    L111:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPrefetch", "url为空", null, 12);
        goto L115
    L112:
        String r48 = r26.a();
        Intrinsics.checkNotNullParameter(r48, "<set-?>");
        r41.f5846b = r48;
        ExecutorService r49 = o.f5870a;
        b r50 = new b(r12, r41, r13);
        Intrinsics.checkNotNullParameter(r50, "runnable");
        o.f5871b.execute(r50);
        return r41;
    L115:
        return null;
    L85:
        e = move-exception;
        l("Prefetch配置解析失败: " + e.getMessage() + "，json: " + r15);
        r41 = null;
        goto L87
    L116:
        l("disable prefetch for security reason by Argus. prefetch.json url: " + r26.f5952z);
        return null;
    L68:
        if (r32.intValue() != 0) goto L70;
        r39 = new com.bytedance.ies.argus.bean.b();
        com.bytedance.ies.argus.bean.b.g(r39, ArgusPrefetchVerifyReason.f5078h, null, 6);
        goto L72
    L121:
        String r51 = e(r5);     // Catch: Throwable -> L44
        Intrinsics.checkNotNullParameter(r51, "<set-?>");     // Catch: Throwable -> L44
        r21.f22839h = r51;     // Catch: Throwable -> L44
        goto L46
    L32:
        if (r17.f16890c == false) goto L34;
        r19 = r17.f16889b;
    L35:
        if (r19 != 0) goto L37;
    L34:
        r19 = 0;
        goto L35
    L24:
        if (r17.f16890c == false) goto L26;
        r18 = r17.f16888a;
    L27:
        if (r18 != 0) goto L29;
    L26:
        r18 = 0;
        goto L27
    L15:
        if (Uri.parse(r5).isHierarchical() == true) goto L17;
        dc.b.a("parseChannelBundle: is notHierarchical");
        goto L13
    L17:
        ConcurrentHashMap r52 = com.bytedance.ies.bullet.kit.resourceloader.a.f5444a;
        wc.e r53 = r16.d();
        String r54 = r16.e;
        if (r54 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("bid");
        r54 = null;
    L21:
        r17 = com.bytedance.ies.bullet.kit.resourceloader.a.a(r5, r53, r54, true, new wc.g(""));
        goto L22
    L5:
        if (r14.length() == 0) goto L11;
        CharSequence r55 = (CharSequence) r11.element;
        if (r55 == null) goto L11;
        if (r55.length() != 0) goto L38;
        goto L11
    }

    public static f b(Uri r5, String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r5, "pageUri");
        Intrinsics.checkNotNullParameter(r10, "targetBid");
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L5;
    L8:
        if (r11 == null) goto L11;
        a r12 = a.f5833a;
        Intrinsics.checkNotNullParameter(r11, "identifier");
        final f r13 = (f) a.f5835c.get(r11);
        h("Get config cache by identifier: " + r11 + ", config: " + r13);
        if (r13 == null) goto L11;
    L12:
        h("configCache: " + r13);
        if (r13 == null) goto L17;
        Intrinsics.checkNotNullParameter(LynxMonitorService.KEY_MEMORY, "<set-?>");
        r13.f5846b = LynxMonitorService.KEY_MEMORY;
        i(new InternalConfigLoader$loadConfig$1$1(r13, r11));
        ExecutorService r14 = o.f5870a;
        ab.b r15 = new ab.b(10, r5, r10);
        Intrinsics.checkNotNullParameter(r15, "runnable");
        o.f5871b.execute(r15);
        return r13;
    L17:
        return a(r5, r10);
    L11:
        r13 = a.f5833a.a(r5);
        goto L12
    L5:
        if (Intrinsics.areEqual(ym.m.f(r5, "__dev"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L8;
        return a(r5, r10);
    }

    public static h c(i r12, r r13, f r14) {
        Intrinsics.checkNotNullParameter(r12, "apiConfig");
        Intrinsics.checkNotNullParameter(r13, "schemaModel");
        Intrinsics.checkNotNullParameter(r14, "prefetchConfig");
        String r5 = r12.f5855a;
        if (r5 != null) goto L5;
    L34:
        return null;
    L5:
        if (r5.length() == 0) goto L34;
        Locale r10 = Locale.ROOT;
        String r11 = r12.f5856b;
        if (r11 == null) goto L33;
        String r15 = r11.toLowerCase(r10);
        if (r15 == null) goto L12;
        String r16 = r15.toLowerCase(r10);
    L14:
        if (Intrinsics.areEqual(r16, "get") == false) goto L16;
    L35:
    L25:
        e = move-exception;
        l(e.getMessage());
        return null;
    L21:
        if (r12.a(r13) == true) goto L28;
        String r17 = "不满足配置的条件，不发起prefetch请求，请检查condition配置：" + r12.f5855a;     // Catch: Exception -> L25
        if (r17 == null) goto L27;
        com.bytedance.ies.bullet.base.utils.logger.a.f("XPrefetch", r17);     // Catch: Exception -> L25
    L27:
        return null;
    L28:
        LinkedHashMap r18 = k(r12.f5857c, r13);     // Catch: Exception -> L25
        LinkedHashMap r19 = k(r12.d, r13);     // Catch: Exception -> L25
        JSONObject r20 = g(r12.e, r13);     // Catch: Exception -> L25
        k(r12.f5860j, r13);     // Catch: Exception -> L25
        k(r12.f5861k, r13);     // Catch: Exception -> L25
        h r110 = new h(r5, r15, r18, r19, r20, r12.f, r12.f5862l, r12.f5863m);     // Catch: Exception -> L25
        Intrinsics.checkNotNullParameter(r14.f5846b, "<set-?>");     // Catch: Exception -> L25
        Intrinsics.checkNotNullParameter(r14.d, "<set-?>");     // Catch: Exception -> L25
        return r110;
    L16:
        if (Intrinsics.areEqual(r16, "post") == true) goto L35;
        l("不支持的请求类型: " + r15);
        return null;
    L12:
        r16 = null;
        goto L14
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static Object d(g r10, r r11) {
        IHostUserDepend r5 = mn.h.f20142n;
        if (r5 == null) goto L5;
        String r12 = r5.getUserId();
    L6:
        if (r12 != null) goto L8;
    L29:
        IHostUserDepend r13 = mn.h.f20142n;
        if (r13 == null) goto L32;
        Boolean r14 = Boolean.valueOf(r13.hasLogin());
    L33:
        l("UID 为空，当前登录状态: " + r14);
        return null;
    L32:
        r14 = null;
        goto L33
    L8:
        if (r12.length() == 0) goto L29;
        boolean r15 = r10.f5850c;
        Object r16 = r10.f5849b;
        if (r15 == false) goto L24;
        String r17 = r11.a("app_id");
        if (r17 != null) goto L15;
    L22:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPrefetch", "appId为空", null, 12);
        return null;
    L15:
        if (r17.length() == 0) goto L22;
        Application r18 = com.bytedance.ies.bullet.core.h.g.f5316b;
        Intrinsics.checkNotNull(r18);
        Intrinsics.checkNotNullParameter(r18, "context");
        Triple r19 = ((com.bytedance.sdk.xbridge.cn.storage.utils.f) ((com.bytedance.sdk.xbridge.cn.storage.utils.b) com.bytedance.sdk.xbridge.cn.storage.utils.f.f7489b.a(r18.getApplicationContext()))).b(com.lynx.tasm.utils.k.j(r12, "appId_", r17), r16.toString(), "prefetch", "prefetch_session_id");
        boolean r20 = ((Boolean) r19.component1()).booleanValue();
        boolean r21 = ((Boolean) r19.component2()).booleanValue();
        Object r22 = r19.component3();
        if (r20 == false) goto L21;
        if (r21 == true) goto L21;
        return r22;
    L21:
        return null;
    L24:
        Application r23 = com.bytedance.ies.bullet.core.h.g.f5316b;
        Intrinsics.checkNotNull(r23);
        Intrinsics.checkNotNullParameter(r23, "context");
        Triple r24 = ((com.bytedance.sdk.xbridge.cn.storage.utils.f) ((com.bytedance.sdk.xbridge.cn.storage.utils.b) com.bytedance.sdk.xbridge.cn.storage.utils.f.f7489b.a(r23.getApplicationContext()))).b(r12, r16.toString(), "prefetch", "prefetch_session_id");
        boolean r25 = ((Boolean) r24.component1()).booleanValue();
        boolean r26 = ((Boolean) r24.component2()).booleanValue();
        Object r27 = r24.component3();
        if (r25 == false) goto L28;
        if (r26 == true) goto L28;
        return r27;
    L28:
        return null;
    L5:
        r12 = null;
        goto L6
    }

    public static final String e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter("prefetch.json", "suffix");
        if (r5.length() != 0) goto L5;
        return "prefetch.json";
    L5:
        int r10 = StringsKt.u(r5, "://");
        int r11 = StringsKt.t(r5, '/', 0, 6);
        if (r11 < 0) goto L15;
        if ((r10 + 2) != r11) goto L13;
        if (r10 < 0) goto L13;
        return r5.concat("/prefetch.json");
    L13:
        return r5.substring(0, r11) + "/prefetch.json";
    L15:
        return r5.concat("/prefetch.json");
    }

    public static final HashMap f(JSONObject r10) {
        if (r10 == null) goto L4;
        Iterator<String> r5 = r10.keys();
        HashMap r11 = new HashMap();
    L7:
        if (r5.hasNext() == false) goto L15;
        String r12 = r5.next();
        if (r10.optJSONObject(r12) == null) goto L14;
        HashMap r13 = f(r10.optJSONObject(r12));     // Catch: NullPointerException -> L12
        Intrinsics.checkNotNull(r13);     // Catch: NullPointerException -> L12
        r11.putAll(r13);     // Catch: NullPointerException -> L12
    L12:
        e = move-exception;
        StringBuilder r14 = com.lynx.tasm.utils.e.b("handle ", r12, " error: ");
        r14.append(e.getMessage());
        Log.e("JsonExt", r14.toString());
        goto L7
    L14:
        r11.put(r12, r10.optString(r12));
        goto L7
    L15:
        return r11;
    L4:
        return new LinkedHashMap();
    }

    public static JSONObject g(LinkedHashMap r10, r r11) {
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L28;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        g r15 = (g) r13.getValue();
        boolean r16 = Intrinsics.areEqual(r15.f5848a, "static");
        Object r17 = r15.f5849b;
        if (r16 == true) goto L7;
        String r18 = r15.f5848a;
        if (Intrinsics.areEqual(r18, "query") == true) goto L10;
        if (Intrinsics.areEqual(r18, "queryObject") == true) goto L15;
        if (Intrinsics.areEqual(r18, "userDomainStorage") == true) goto L20;
        if (Intrinsics.areEqual(r18, "env") == false) goto L4;
        String r19 = j(r17.toString());
        if (r19 == null) goto L4;
        r5.put(r14, r19);
        goto L4
    L20:
        Object r20 = d(r15, r11);
        if (r20 == null) goto L4;
        r5.put(r14, r20);
        goto L4
    L15:
        String r21 = r11.b(r17.toString());
        if (r21 == null) goto L4;
        r5.put(r14, r21);
        goto L4
    L10:
        String r22 = r11.a(r17.toString());
        if (r22 == null) goto L4;
        r5.put(r14, r22);
        goto L4
    L7:
        r5.put(r14, r17);
        goto L4
    L28:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        return new JSONObject(r5);
    }

    public static void h(String r5) {
        if (r5 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a.c("XPrefetch", r5);
        return;
    }

    public static final void i(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "getMessage");
        if (com.bytedance.ies.bullet.core.h.g.f5315a == false) goto L6;
        h((String) r5.invoke());
        return;
    }

    public static String j(String r5) {
        if (r5.equals("AID") == false) goto L7;
        return com.bytedance.ies.bullet.core.h.g.d;
    L7:
        if (r5.equals("OS") == false) goto L11;
        return "Android";
    L11:
        if (r5.equals("APP_VERSION") == false) goto L15;
        return com.bytedance.ies.bullet.core.h.g.e;
    L15:
        if (r5.equals("DID") == true) goto L17;
        return null;
    L17:
        return com.bytedance.ies.bullet.core.h.g.f;
    }

    public static LinkedHashMap k(LinkedHashMap r10, r r11) {
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L31;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        g r15 = (g) r13.getValue();
        boolean r16 = Intrinsics.areEqual(r15.f5848a, "static");
        Object r17 = r15.f5849b;
        if (r16 == true) goto L7;
        String r18 = r15.f5848a;
        if (Intrinsics.areEqual(r18, "query") == true) goto L10;
        if (Intrinsics.areEqual(r18, "queryObject") == true) goto L15;
        if (Intrinsics.areEqual(r18, "userDomainStorage") == true) goto L20;
        if (Intrinsics.areEqual(r18, "env") == true) goto L25;
        if (r15.e == false) goto L4;
        r5.put(r14, r15.d);
        goto L4
    L25:
        String r19 = j(r17.toString());
        if (r19 == null) goto L4;
        r5.put(r14, r19);
        goto L4
    L20:
        Object r20 = d(r15, r11);
        if (r20 == null) goto L4;
        r5.put(r14, r20.toString());
        goto L4
    L15:
        String r21 = r11.b(r17.toString());
        if (r21 == null) goto L4;
        r5.put(r14, r21);
        goto L4
    L10:
        String r22 = r11.a(r17.toString());
        if (r22 == null) goto L4;
        r5.put(r14, r22);
        goto L4
    L7:
        r5.put(r14, r17.toString());
        goto L4
    L31:
        return r5;
    }

    public static void l(String r5) {
        if (r5 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPrefetch", r5, null, 12);
        return;
    }
}
