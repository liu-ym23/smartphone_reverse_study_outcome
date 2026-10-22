package com.bytedance.ai.applet.domain;

import android.net.Uri;
import android.util.Base64;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.FetchDomainPolicyResponse;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.AppletSettings;
import com.bytedance.ai.utils.g;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletDomainPolicyManager {
    public static final AppletDomainPolicyManager a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;
    public static final CoroutineScope d = null;
    public static final ConcurrentHashMap<String, a> e = null;
    public static final ConcurrentHashMap<String, a> f = null;
    public static final ConcurrentHashMap<String, Deferred<Result<a>>> g = null;
    public static final Lazy h = null;

    public AppletDomainPolicyManager() {
    }

    static {
        a = new AppletDomainPolicyManager();
        b = SetsKt.setOf("https");
        c = SetsKt.setOf("wss");
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        h = LazyKt.lazy(new b());
    }

    public static f i(String r10) {
        if (r10 != null) goto L5;
    L21:
        return null;
    L5:
        if ((!StringsKt.isBlank(r10)) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L21;
        if (j(r10) == true) goto L13;
        a r1 = e.get(r10);
        if (r1 != null) goto L20;
        r1 = f.get(r10);
        if (r1 != null) goto L20;
        return null;
    L20:
        return new f(r1.c, r1.h);
    L13:
        return new f(false, SetsKt.emptySet());
    }

    public static boolean j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r0 = AppletAppManagerService.b(r10);
        if (r0 == null) goto L5;
        Applet r1 = r0.j();
    L7:
        if (r1 != null) goto L10;
        g.a.w("AppletDomainPolicyManager", "isDomainVerifyDisabled manifest miss, appKey:" + r10 + ", fallback verify enabled");
        return false;
    L10:
        AppletSettings r11 = r1.k0;
        if (r11 == null) goto L15;
        Boolean r12 = r11.getUrlCheck();
        if (r12 == null) goto L15;
        boolean r13 = r12.booleanValue();
    L16:
        boolean r14 = !r13;
        g.a.i("AppletDomainPolicyManager", "isDomainVerifyDisabled appKey:" + r10 + ", urlCheck:" + r13 + ", disabled:" + r14);
        return r14;
    L15:
        r13 = true;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public static a k(String r11) {
        Object r10 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L26
        String r13 = ((Keva) h.getValue()).getString("domain_policy_" + r11, null);     // Catch: Throwable -> L26
        if (r13 != null) goto L7;
        g.a.d("AppletDomainPolicyManager", "cache empty, appKey:" + r11);     // Catch: Throwable -> L26
        return null;
    L7:
        Lazy r14 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L26
        d r15 = (d) com.bytedance.ai.applet.base.gson.e.a(r13, d.class);     // Catch: Throwable -> L26
        long r16 = r15.e;     // Catch: Throwable -> L26
        if (r16 > 0) goto L10;
    L13:
        boolean r17 = true;
    L14:
        if (r17 == true) goto L25;
        a r18 = p(r11, r15.a, r15.b);     // Catch: Throwable -> L26
        if (r15.c != r18.b) goto L23;
        if (r15.d != r18.c) goto L21;
        g.a.d("AppletDomainPolicyManager", "cache load, appKey:" + r11 + ", v:" + r18.b + ", switch:" + r18.c + ", age:" + (System.currentTimeMillis() - r15.e));     // Catch: Throwable -> L26
        Object r1 = Result.constructor-impl(r18);     // Catch: Throwable -> L26
    L28:
        Throwable r19 = Result.exceptionOrNull-impl(r1);
        if (r19 == null) goto L40;
        a.getClass();
        ((Keva) h.getValue()).erase("domain_policy_" + r11);     // Catch: Throwable -> L33
        g.a.d("AppletDomainPolicyManager", "cache remove, appKey:" + r11);     // Catch: Throwable -> L33
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L38;
        g.a.e("AppletDomainPolicyManager", "remove cached policy failed: " + r111.getMessage());
    L38:
        g.a.e("AppletDomainPolicyManager", "load cached policy failed: " + r19.getMessage());
    L33:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        if (Result.isFailure-impl(r1) == true) goto L44;
        r10 = r1;
    L44:
        return (a) r10;
    L21:
        throw new IllegalStateException("cached domain_verify_switch mismatch");     // Catch: Throwable -> L26
    L23:
        throw new IllegalStateException("cached snapshot_version mismatch");     // Catch: Throwable -> L26
    L25:
        throw new IllegalStateException("cached policy expired");     // Catch: Throwable -> L26
    L10:
        if ((System.currentTimeMillis() - r16) > 604800000) goto L13;
        r17 = false;
    L26:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    public final void n(String r13) {
        Intrinsics.checkNotNullParameter("app_onAttached", "source");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        if (r13 != null) goto L6;
    L16:
        g.a.e("AppletDomainPolicyManager", "prefetch skip: appKey empty, source:app_onAttached");     // Catch: Throwable -> L19
    L17:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r11 = Result.exceptionOrNull-impl(r1);
        if (r11 == null) goto L27;
        g.a.e("AppletDomainPolicyManager", "prefetch trigger failed, appKey:" + r13 + ", source:app_onAttached, error:" + r11.getMessage());
        return;
    L27:
        return;
    L6:
        if ((!StringsKt.isBlank(r13)) == false) goto L8;
        String r12 = r13;
    L9:
        if (r12 == null) goto L16;
        if (e.containsKey(r12) == false) goto L15;
        g.a.d("AppletDomainPolicyManager", "prefetch skip: already success, appKey:" + r12 + ", source:app_onAttached");     // Catch: Throwable -> L19
        goto L17
    L15:
        g.a.d("AppletDomainPolicyManager", "prefetch start, appKey:" + r12 + ", source:app_onAttached");     // Catch: Throwable -> L19
        BuildersKt.launch$default(d, null, null, new AppletDomainPolicyManager$prefetch$1$1(this, r12, "app_onAttached", null), 3, null);     // Catch: Throwable -> L19
        goto L17
    L8:
        r12 = null;
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public static String l(String r10, Set r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r12 = Result.constructor-impl(UriProtector.parse(r10));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r12) == false) goto L9;
        r12 = null;
    L9:
        Uri r13 = (Uri) r12;
        if (r13 != null) goto L12;
        return null;
    L12:
        String r1 = r13.getScheme();
        if (r1 == null) goto L31;
        Locale r14 = Locale.ROOT;
        String r15 = r1.toLowerCase(r14);
        if (r15 == null) goto L31;
        if (r11.contains(r15) == true) goto L20;
        return null;
    L20:
        String r16 = r13.getHost();
        if (r16 == null) goto L31;
        String r17 = r16.toLowerCase(r14);
        if (r17 == null) goto L31;
        int r18 = r13.getPort();
        if (r18 <= 0) goto L28;
        String r19 = ":" + r18;
    L30:
        return r15 + "://" + r17 + r19;
    L28:
        r19 = "";
    L31:
        return null;
    L4:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static Set m(String r10, Set r11) {
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
        List r13 = StringsKt.split$default(r10, new char[]{','}, false, 0, 6, null);
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        r14.add(StringsKt.trim((String) r15.next()).toString());
        goto L14
    L16:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r14.iterator();
    L18:
        if (r17.hasNext() == false) goto L25;
        Object r18 = r17.next();
        if (((String) r18).length() <= 0) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == false) goto L18;
        r16.add(r18);
        goto L18
    L22:
        r19 = false;
        goto L23
    L25:
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r20 = r16.iterator();
    L27:
        if (r20.hasNext() == false) goto L34;
        String r1 = (String) r20.next();
        a.getClass();
        String r21 = l(r1, r11);
        if (r21 == null) goto L32;
        r0.add(r21);
        goto L27
    L32:
        throw new IllegalStateException("invalid allowlist domain");
    L34:
        return CollectionsKt.toSet(r0);
    L11:
        return SetsKt.emptySet();
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L9
    }

    public static a p(String r13, String r14, String r15) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        PublicKey r10 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2rcHwDRl8JBb1XqLfddO1GdNMi+QebVdVH2D/FrlIOQPwamL2Sf6hchOTdXFZoWjE+aIfhCHbY//APXG0xXC7f7MH07HdWRtZ5aiKFyQotjZ6lDfZbIeHOxuxaMkbBxTdp2jF34a0LZLqdA3HHsw5eW+B/KgQk+ozqDVK5FLXrUzt7eOdrbhncnkrCDcaLBFxkWrXCS+fuLPk3IitCCNQQGqwueBb2zRl/dXg2tb6wJT9EobUEbaLvSZ3sasa1FpFK30IrfMARUlGrnS3MUQmUcWeqj445KQYlofh4GyVTltlnsDxaiNiANImUfBIf4fldvxNCOJnKCo1Z7wNYEvQQIDAQAB", 0)));     // Catch: Throwable -> L5
        Signature r11 = Signature.getInstance("SHA256withRSA");     // Catch: Throwable -> L5
        r11.initVerify(r10);     // Catch: Throwable -> L5
        r11.update(r14.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L5
        Object r16 = Result.constructor-impl(Boolean.valueOf(r11.verify(Base64.decode(r15, 0))));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.exceptionOrNull-impl(r16);
        if (r12 == null) goto L12;
        g.a.e("AppletDomainPolicyManager", "verify signature failed: " + r12.getMessage());
        r16 = Boolean.FALSE;
    L12:
        if (((Boolean) r16).booleanValue() == false) goto L55;
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = StringsKt.lineSequence(r14).iterator();
    L14:
        boolean r19 = true;
        if (r18.hasNext() == false) goto L27;
        String r20 = (String) r18.next();
        if (r20.length() == 0) goto L20;
        r19 = false;
    L20:
        if (r19 == true) goto L14;
        int r21 = StringsKt.indexOf$default(r20, '=', 0, false, 6, null);
        if (r21 < 0) goto L25;
        r17.put(r20.substring(0, r21), r20.substring(r21 + 1));
        goto L14
    L25:
        throw new IllegalStateException("invalid payload line");
    L27:
        if (Intrinsics.areEqual(r17.get("v"), "1") == false) goto L53;
        if (Intrinsics.areEqual((String) r17.get("mini_program_id"), r13) == false) goto L51;
        String r110 = (String) r17.get("snapshot_version");
        if (r110 == null) goto L49;
        Long r111 = StringsKt.toLongOrNull(r110);
        if (r111 == null) goto L49;
        long r22 = r111.longValue();
        String r112 = (String) r17.get("domain_verify_switch");
        if (r112 == null) goto L37;
        String r113 = r112.toLowerCase(Locale.ROOT);
    L39:
        if (Intrinsics.areEqual(r113, "true") == false) goto L42;
        boolean r23 = true;
    L44:
        String r0 = (String) r17.get("request");
        Set<String> r24 = b;
        return new a(r13, r22, r23, m(r0, r24), m((String) r17.get("download"), r24), m((String) r17.get("upload"), r24), m((String) r17.get("socket"), c), m((String) r17.get("webview"), r24));
    L42:
        if (Intrinsics.areEqual(r113, "false") == false) goto L47;
        r23 = false;
        goto L44
    L47:
        throw new IllegalStateException("invalid domain_verify_switch");
    L37:
        r113 = null;
    L49:
        throw new IllegalStateException("invalid snapshot_version");
    L51:
        throw new IllegalStateException("mini_program_id mismatch");
    L53:
        throw new IllegalStateException("unsupported payload version");
    L55:
        throw new IllegalStateException("signature verify failed");
    L5:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object c(String r12, String r13, Continuation<? super e> r14) {
        if ((r14 instanceof AppletDomainPolicyManager$ensureDownloadAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureDownloadAllowed$1 r0 = (AppletDomainPolicyManager$ensureDownloadAllowed$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        String r16 = (String) r0.L$2;
        String r17 = (String) r0.L$1;
        String r18 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Object r19 = ((Result) r15).unbox-impl();
        String r20 = r16;
        String r21 = r18;
    L34:
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 != null) goto L38;
        a r22 = (a) r19;
        return b(r22, r22.e, r20, r21, "download_blocked", "download domain is not in whitelist");
    L38:
        g.a.e("AppletDomainPolicyManager", "download blocked: policy unavailable, appKey:" + r17 + ", origin:" + r20 + ", error:" + r110.getMessage());
        int r111 = e.c;
        return e.a.b("domain policy unavailable: " + r110.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r12 != null) goto L17;
    L40:
        g.a.e("AppletDomainPolicyManager", "download blocked: appKey empty, url:" + r13);
        int r112 = e.c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r12)) == true) goto L20;
        r12 = null;
    L20:
        if (r12 == null) goto L40;
        if (j(r12) == false) goto L26;
        g.a.d("AppletDomainPolicyManager", "download allowed: dev bypass, appKey:" + r12 + ", url:" + r13);
        int r113 = e.c;
        return e.a.a();
    L26:
        String r114 = l(r13, b);
        if (r114 != null) goto L30;
        g.a.e("AppletDomainPolicyManager", "download blocked: invalid url, appKey:" + r12 + ", url:" + r13);
        int r115 = e.c;
        return e.a.b("invalid download url");
    L30:
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.L$2 = r114;
        r0.label = 1;
        Object r23 = h(r12, "download", r0);
        if (r23 != r10) goto L33;
        return r10;
    L33:
        r21 = r13;
        r20 = r114;
        r19 = r23;
        r17 = r12;
    L7:
        r0 = new AppletDomainPolicyManager$ensureDownloadAllowed$1(this, r14);
        goto L8
    }

    public final Object d(String r12, String r13, Continuation<? super e> r14) {
        if ((r14 instanceof AppletDomainPolicyManager$ensureRequestAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureRequestAllowed$1 r0 = (AppletDomainPolicyManager$ensureRequestAllowed$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        String r16 = (String) r0.L$2;
        String r17 = (String) r0.L$1;
        String r18 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Object r19 = ((Result) r15).unbox-impl();
        String r20 = r16;
        String r21 = r18;
    L34:
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 != null) goto L41;
        a r22 = (a) r19;
        if (r22.c == true) goto L40;
        g.a.d("AppletDomainPolicyManager", "request allowed: switch off, appKey:" + r22.a + ", origin:" + r20 + ", v:" + r22.b);
        int r111 = e.c;
        return e.a.a();
    L40:
        return b(r22, r22.d, r20, r21, "request_blocked", "request domain is not in whitelist");
    L41:
        g.a.e("AppletDomainPolicyManager", "request blocked: policy unavailable, appKey:" + r17 + ", origin:" + r20 + ", error:" + r110.getMessage());
        int r112 = e.c;
        return e.a.b("domain policy unavailable: " + r110.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r12 != null) goto L17;
    L43:
        g.a.e("AppletDomainPolicyManager", "request blocked: appKey empty, url:" + r13);
        int r113 = e.c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r12)) == true) goto L20;
        r12 = null;
    L20:
        if (r12 == null) goto L43;
        if (j(r12) == false) goto L26;
        g.a.d("AppletDomainPolicyManager", "request allowed: dev bypass, appKey:" + r12 + ", url:" + r13);
        int r114 = e.c;
        return e.a.a();
    L26:
        String r115 = l(r13, b);
        if (r115 != null) goto L30;
        g.a.e("AppletDomainPolicyManager", "request blocked: invalid url, appKey:" + r12 + ", url:" + r13);
        int r116 = e.c;
        return e.a.b("invalid request url");
    L30:
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.L$2 = r115;
        r0.label = 1;
        Object r23 = h(r12, "request", r0);
        if (r23 != r10) goto L33;
        return r10;
    L33:
        r21 = r13;
        r20 = r115;
        r19 = r23;
        r17 = r12;
    L7:
        r0 = new AppletDomainPolicyManager$ensureRequestAllowed$1(this, r14);
        goto L8
    }

    public final Object e(String r12, String r13, Continuation<? super e> r14) {
        if ((r14 instanceof AppletDomainPolicyManager$ensureSocketAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureSocketAllowed$1 r0 = (AppletDomainPolicyManager$ensureSocketAllowed$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        String r16 = (String) r0.L$2;
        String r17 = (String) r0.L$1;
        String r18 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Object r19 = ((Result) r15).unbox-impl();
        String r20 = r16;
        String r21 = r18;
    L34:
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 != null) goto L38;
        a r22 = (a) r19;
        return b(r22, r22.g, r20, r21, "socket_blocked", "socket domain is not in whitelist");
    L38:
        g.a.e("AppletDomainPolicyManager", "socket blocked: policy unavailable, appKey:" + r17 + ", origin:" + r20 + ", error:" + r110.getMessage());
        int r111 = e.c;
        return e.a.b("domain policy unavailable: " + r110.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r12 != null) goto L17;
    L40:
        g.a.e("AppletDomainPolicyManager", "socket blocked: appKey empty, url:" + r13);
        int r112 = e.c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r12)) == true) goto L20;
        r12 = null;
    L20:
        if (r12 == null) goto L40;
        if (j(r12) == false) goto L26;
        g.a.d("AppletDomainPolicyManager", "socket allowed: dev bypass, appKey:" + r12 + ", url:" + r13);
        int r113 = e.c;
        return e.a.a();
    L26:
        String r114 = l(r13, c);
        if (r114 != null) goto L30;
        g.a.e("AppletDomainPolicyManager", "socket blocked: invalid url, appKey:" + r12 + ", url:" + r13);
        int r115 = e.c;
        return e.a.b("invalid socket url");
    L30:
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.L$2 = r114;
        r0.label = 1;
        Object r23 = h(r12, "socket", r0);
        if (r23 != r10) goto L33;
        return r10;
    L33:
        r21 = r13;
        r20 = r114;
        r19 = r23;
        r17 = r12;
    L7:
        r0 = new AppletDomainPolicyManager$ensureSocketAllowed$1(this, r14);
        goto L8
    }

    public final Object f(String r12, String r13, Continuation<? super e> r14) {
        if ((r14 instanceof AppletDomainPolicyManager$ensureUploadAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureUploadAllowed$1 r0 = (AppletDomainPolicyManager$ensureUploadAllowed$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        String r16 = (String) r0.L$2;
        String r17 = (String) r0.L$1;
        String r18 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Object r19 = ((Result) r15).unbox-impl();
        String r20 = r16;
        String r21 = r18;
    L34:
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 != null) goto L38;
        a r22 = (a) r19;
        return b(r22, r22.f, r20, r21, "upload_blocked", "upload domain is not in whitelist");
    L38:
        g.a.e("AppletDomainPolicyManager", "upload blocked: policy unavailable, appKey:" + r17 + ", origin:" + r20 + ", error:" + r110.getMessage());
        int r111 = e.c;
        return e.a.b("domain policy unavailable: " + r110.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r12 != null) goto L17;
    L40:
        g.a.e("AppletDomainPolicyManager", "upload blocked: appKey empty, url:" + r13);
        int r112 = e.c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r12)) == true) goto L20;
        r12 = null;
    L20:
        if (r12 == null) goto L40;
        if (j(r12) == false) goto L26;
        g.a.d("AppletDomainPolicyManager", "upload allowed: dev bypass, appKey:" + r12 + ", url:" + r13);
        int r113 = e.c;
        return e.a.a();
    L26:
        String r114 = l(r13, b);
        if (r114 != null) goto L30;
        g.a.e("AppletDomainPolicyManager", "upload blocked: invalid url, appKey:" + r12 + ", url:" + r13);
        int r115 = e.c;
        return e.a.b("invalid upload url");
    L30:
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.L$2 = r114;
        r0.label = 1;
        Object r23 = h(r12, "upload", r0);
        if (r23 != r10) goto L33;
        return r10;
    L33:
        r21 = r13;
        r20 = r114;
        r19 = r23;
        r17 = r12;
    L7:
        r0 = new AppletDomainPolicyManager$ensureUploadAllowed$1(this, r14);
        goto L8
    }

    public final Object g(String r13, String r14, Continuation<? super Result<a>> r15) {
        if ((r15 instanceof AppletDomainPolicyManager$fetchPolicyOnce$1) == false) goto L7;
        AppletDomainPolicyManager$fetchPolicyOnce$1 r0 = (AppletDomainPolicyManager$fetchPolicyOnce$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L18;
        if (r11 != 1) goto L17;
        Deferred<Result<a>> r17 = (Deferred) r0.L$2;
        Deferred<Result<a>> r18 = (Deferred) r0.L$1;
        String r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
        Deferred<Result<a>> r19 = r17;
        r13 = r12;
        Object r20 = r16;
    L41:
        Object r21 = ((Result) r20).unbox-impl();     // Catch: Throwable -> L34
        if (r18 != null) goto L33;
        g.remove(r13, r19);
    L33:
        return r21;
    L34:
        Throwable th2 = th;
    L38:
        if (r18 != null) goto L40;
        g.remove(r13, r19);
    L40:
        throw th2;
    L14:
        th = move-exception;
        r19 = r17;
        r13 = r12;
        th2 = th;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r16);
        a r110 = e.get(r13);
        if (r110 == null) goto L22;
        g.a.d("AppletDomainPolicyManager", "fetch skip: memory policy exists, appKey:" + r13 + ", source:" + r14 + ", v:" + r110.b);
        return Result.constructor-impl(r110);
    L22:
        r19 = BuildersKt.async$default(d, null, CoroutineStart.LAZY, new AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1(r13, r14, null), 1, null);
        Deferred<Result<a>> r22 = g.putIfAbsent(r13, r19);
        if (r22 == null) goto L25;
        g.a.d("AppletDomainPolicyManager", "fetch reuse in-flight, appKey:" + r13 + ", source:" + r14);
        r19 = r22;
    L43:
        r0.L$0 = r13;     // Catch: Throwable -> L36
        r0.L$1 = r22;     // Catch: Throwable -> L36
        r0.L$2 = r19;     // Catch: Throwable -> L36
        r0.label = 1;     // Catch: Throwable -> L36
        Object r111 = r19.await(r0);     // Catch: Throwable -> L36
        if (r111 != r10) goto L29;
        return r10;
    L29:
        r20 = r111;
        r18 = r22;
    L36:
        th = move-exception;
        th2 = th;
        r18 = r22;
        goto L38
    L25:
        g.a.d("AppletDomainPolicyManager", "fetch start new, appKey:" + r13 + ", source:" + r14);
        r19.start();
    L7:
        r0 = new AppletDomainPolicyManager$fetchPolicyOnce$1(this, r15);
        goto L8
    }

    public final Object h(String r10, String r11, Continuation<? super Result<a>> r12) {
        if ((r12 instanceof AppletDomainPolicyManager$getPolicyForUse$1) == false) goto L7;
        AppletDomainPolicyManager$getPolicyForUse$1 r0 = (AppletDomainPolicyManager$getPolicyForUse$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r11 = (String) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Object r16 = ((Result) r13).unbox-impl();
    L22:
        if (Result.isSuccess-impl(r16) == true) goto L24;
        g r17 = g.a;
        r17.e("AppletDomainPolicyManager", "policy fetch failed, try cache, appKey:" + r10 + ", source:" + r11);
        a r18 = k(r10);
        if (r18 != null) goto L29;
        r17.e("AppletDomainPolicyManager", "policy unavailable: cache empty or invalid, appKey:" + r10 + ", source:" + r11);
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("fetch failed and cache is empty")));
    L29:
        f.put(r10, r18);
        r17.d("AppletDomainPolicyManager", "policy use cache, appKey:" + r10 + ", source:" + r11 + ", v:" + r18.b + ", switch:" + r18.c);
        return Result.constructor-impl(r18);
    L24:
        return Result.constructor-impl((a) r16);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        a r19 = e.get(r10);
        if (r19 == null) goto L18;
        g.a.d("AppletDomainPolicyManager", "policy hit memory, appKey:" + r10 + ", source:" + r11 + ", v:" + r19.b);
        return Result.constructor-impl(r19);
    L18:
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        r16 = g(r10, r11, r0);
        if (r16 != r14) goto L22;
        return r14;
    L7:
        r0 = new AppletDomainPolicyManager$getPolicyForUse$1(this, r12);
        goto L8
    }

    public static final Object a(AppletDomainPolicyManager r22, String r23, String r24, Continuation r25) {
        r22.getClass();
        if ((r25 instanceof AppletDomainPolicyManager$fetchPolicyFromServer$1) == false) goto L7;
        AppletDomainPolicyManager$fetchPolicyFromServer$1 r10 = (AppletDomainPolicyManager$fetchPolicyFromServer$1) r25;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        String r0 = (String) r10.L$1;
        String r1 = (String) r10.L$0;
        ResultKt.throwOnFailure(r12);
        Object r15 = ((Result) r12).unbox-impl();
        String r16 = r0;
        Object r17 = r15;
    L18:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 != null) goto L65;
        FetchDomainPolicyResponse.Data r19 = (FetchDomainPolicyResponse.Data) r17;
        String r20 = r19.getSignedPayload();     // Catch: Throwable -> L54
        if (r20 == null) goto L59;
        if (r20.length() <= 0) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == true) goto L30;
        r20 = null;
    L30:
        if (r20 == null) goto L59;
        String r21 = r19.getSignature();     // Catch: Throwable -> L54
        if (r21 == null) goto L57;
        if (r21.length() <= 0) goto L36;
        boolean r111 = true;
    L37:
        if (r111 == true) goto L40;
        r21 = null;
    L40:
        if (r21 == null) goto L57;
        a r112 = p(r1, r20, r21);     // Catch: Throwable -> L54
        g r113 = g.a;     // Catch: Throwable -> L54
        r113.d("AppletDomainPolicyManager", "fetch remote verified, appKey:" + r1 + ", v:" + r112.b + ", switch:" + r112.c + ", request:" + r112.d.size() + ", socket:" + r112.g.size());     // Catch: Throwable -> L54
        a r26 = k(r1);     // Catch: Throwable -> L54
        if (r26 != null) goto L44;
    L52:
        e.put(r1, r112);     // Catch: Throwable -> L54
        f.put(r1, r112);     // Catch: Throwable -> L54
        o(r1, r20, r21, r112.b, r112.c);     // Catch: Throwable -> L54
        r113.d("AppletDomainPolicyManager", "fetch use remote, appKey:" + r1 + ", source:" + r16 + ", v:" + r112.b + ", switch:" + r112.c);     // Catch: Throwable -> L54
    L53:
        Object r27 = Result.constructor-impl(r112);     // Catch: Throwable -> L54
    L61:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L68;
        g.a.e("AppletDomainPolicyManager", "fetch policy invalid, appKey:" + r1 + ", source:" + r16 + ", error:" + r28.getMessage());
    L68:
        return r27;
    L44:
        if (r26.b <= r112.b) goto L46;
        boolean r29 = true;
    L47:
        if (r29 == false) goto L49;
        a r114 = r26;
    L50:
        if (r114 == null) goto L52;
        e.put(r1, r114);     // Catch: Throwable -> L54
        f.put(r1, r114);     // Catch: Throwable -> L54
        r113.d("AppletDomainPolicyManager", "fetch use newer cache, appKey:" + r1 + ", cacheV:" + r114.b + ", remoteV:" + r112.b);     // Catch: Throwable -> L54
        r112 = r114;
        goto L53
    L49:
        r114 = null;
        goto L50
    L46:
        r29 = false;
        goto L47
    L36:
        r111 = false;
    L57:
        throw new IllegalStateException("signature is empty");     // Catch: Throwable -> L54
    L26:
        r110 = false;
    L59:
        throw new IllegalStateException("signed_payload is empty");     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L65:
        g.a.e("AppletDomainPolicyManager", "fetch remote failed, appKey:" + r1 + ", source:" + r16 + ", error:" + r18.getMessage());
        return Result.constructor-impl(ResultKt.createFailure(r18));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        g.a.d("AppletDomainPolicyManager", "fetch remote start, appKey:" + r23 + ", source:" + r24);
        UserAuthService r31 = UserAuthService.a;
        r10.L$0 = r23;
        r10.L$1 = r24;
        r10.label = 1;
        Object r32 = r31.g(r23, r10);
        if (r32 == r13) goto L69;
        r1 = r23;
        r17 = r32;
        r16 = r24;
        goto L18
    L69:
        return r13;
    L7:
        r10 = new AppletDomainPolicyManager$fetchPolicyFromServer$1(r22, r25);
        goto L8
    }

    public static void o(String r14, String r15, String r16, long r17, boolean r19) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Keva r11 = (Keva) h.getValue();     // Catch: Throwable -> L5
        String r1 = "domain_policy_".concat(r14);     // Catch: Throwable -> L5
        Lazy r12 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L5
        r11.storeString(r1, com.bytedance.ai.applet.base.gson.e.c(new d(r15, r16, r17, r19, System.currentTimeMillis())));     // Catch: Throwable -> L5
        g.a.d("AppletDomainPolicyManager", "cache save, appKey:" + r14 + ", v:" + r17 + ", switch:" + r19);     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.exceptionOrNull-impl(r0);
        if (r13 == null) goto L13;
        g.a.e("AppletDomainPolicyManager", "save policy failed: " + r13.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static e b(a r10, Set r11, String r12, String r13, String r14, String r15) {
        String r16 = StringsKt.removeSuffix(r14, "_blocked");
        if (r10.c == true) goto L7;
        g.a.d("AppletDomainPolicyManager", r16 + " allowed: switch off, appKey:" + r10.a + ", origin:" + r12 + ", v:" + r10.b);
        int r17 = e.c;
        return e.a.a();
    L7:
        if (r11.contains(r12) == false) goto L10;
        g.a.d("AppletDomainPolicyManager", r16 + " allowed: whitelist hit, appKey:" + r10.a + ", origin:" + r12 + ", v:" + r10.b);
        int r18 = e.c;
        return e.a.a();
    L10:
        g.a.e("AppletDomainPolicyManager", r16 + " blocked: not in whitelist, appKey:" + r10.a + ", origin:" + r12 + ", v:" + r10.b + ", url:" + r13);
        int r19 = e.c;
        return e.a.b(r15);
    }
}
