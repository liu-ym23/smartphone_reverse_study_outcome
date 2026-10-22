package com.bytedance.android.annie.business.lynx;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxEnv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import y9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLiveLynxGlobalConfigService extends v16.a {
    public AnnieXLiveLynxGlobalConfigService() {
    }

    public final u26.b G(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        return new c(r10);
    }

    public final Map<String, Object> j0(m16.b r14) {
        Intrinsics.checkNotNullParameter(r14, "providerFactory");
        m16.c r0 = r14.a(AnnieXLiveContext.class);
        String r1 = null;
        if (r0 == null) goto L5;
        AnnieXLiveContext r10 = (AnnieXLiveContext) r0.provideInstance();
    L6:
        i<Boolean> r11 = AnnieConfigSettingKeys.ENABLE_ANNIEX_WEBCAST_GLOBALPROPS_REUSE;
        if (r11.a().booleanValue() == false) goto L14;
        if (r10 == null) goto L10;
        Map<String, Object> r12 = r10.getGlobalProps();
    L11:
        if (r12 == null) goto L14;
        return r10.getGlobalProps();
    L10:
        r12 = null;
    L14:
        m16.c r13 = r14.a(Context.class);
        if (r13 == null) goto L17;
        Context r15 = (Context) r13.provideInstance();
    L18:
        m16.c r16 = r14.a(BulletContext.class);
        if (r16 == null) goto L21;
        BulletContext r17 = (BulletContext) r16.provideInstance();
    L23:
        if (r10 == null) goto L26;
        final Uri r18 = r10.getUri();
        if (r18 == null) goto L26;
    L36:
        if (r10 == null) goto L39;
        String r19 = r10.getBizKey();
        if (r19 == null) goto L39;
    L40:
        String r110 = r19;
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("lynxVersion", LynxEnv.inst().getLynxVersion());
        r111.put("lynx_version", LynxEnv.inst().getLynxVersion());
        h r20 = h.h;
        Function0<Boolean> r21 = new AnnieXLiveLynxGlobalConfigService$getConstants$1(r18);
        r20.getClass();
        Intrinsics.checkNotNullParameter("AnnieXLiveLynxGlobalConfigService uri is null", "errorMessage");
        Intrinsics.checkNotNullParameter(r21, "block");
        if (r20.a == true) goto L43;
    L47:
        b8.a r22 = b8.a.a;
        b8.a.a(new b8.b("AnnieXLiveLynxGlobalConfigService", LogLevel.ERROR, null, "url: " + r18 + '.'), true);
        i7.a r23 = i7.a.a;
        if (r17 == null) goto L50;
        String r24 = r17.f;
    L51:
        if (r18 == null) goto L53;
        String r25 = r18.toString();
    L55:
        if (r18 == null) goto L60;
        String r112 = UriProtector.getQueryParameter(r18, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r112 == null) goto L60;
        String r113 = r112;
    L63:
        i7.a.b(r23, r111, r24, r15, r25, false, r113, r110);
        if (r11.a().booleanValue() == false) goto L68;
        if (r10 == null) goto L68;
        r10.setGlobalProps(r111);
    L68:
        return r111;
    L60:
        if (r18 == null) goto L62;
        r1 = r18.toString();
    L62:
        r113 = r1;
        goto L63
    L53:
        r25 = null;
        goto L55
    L50:
        r24 = null;
        goto L51
    L43:
        if (((Boolean) r21.invoke()).booleanValue() == false) goto L47;
        throw new RuntimeException("AnnieXLiveLynxGlobalConfigService uri is null");
    L39:
        r19 = "host";
    L26:
        if (r17 != null) goto L28;
    L30:
        boolean r26 = false;
    L31:
        if (r26 == false) goto L35;
        t36.d r27 = r17.e;
        if (r27 == null) goto L35;
        r18 = r27.getOriginUrl();
    L35:
        r18 = null;
        goto L36
    L28:
        if (r17.G != true) goto L30;
        r26 = true;
        goto L31
    L21:
        r17 = null;
        goto L23
    L17:
        r15 = null;
        goto L18
    L5:
        r10 = null;
        goto L6
    }

    public final List<com.lynx.tasm.behavior.a> m(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        f8.a r12 = com.bytedance.android.annie.lynx.e.a().a;     // Catch: Throwable -> L10
        if (r12 == null) goto L7;
        List<com.lynx.tasm.behavior.a> r13 = r12.provide();     // Catch: Throwable -> L10
        if (r13 == null) goto L7;
    L8:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L10
    L13:
        if (Result.exceptionOrNull-impl(r14) == null) goto L17;
        r14 = CollectionsKt.emptyList();
    L17:
        return (List) r14;
    L7:
        r13 = CollectionsKt.emptyList();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
