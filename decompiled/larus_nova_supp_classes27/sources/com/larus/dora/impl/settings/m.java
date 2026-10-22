package com.larus.dora.impl.settings;

import android.os.Build;
import com.bytedance.news.common.settings.SettingsManager;
import com.larus.dora.impl.core.a0;
import com.larus.dora.impl.core.b0;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Function0 {
    public /* synthetic */ m() {
    }

    public final Object invoke() {
        com.larus.dora.impl.core.d r0 = ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraBTOptimizationConfig();
        a0 r1 = null;
        if (r0 == null) goto L93;
        DoraSetting.a.getClass();
        if (Build.VERSION.SDK_INT < 31) goto L91;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Build.SOC_MODEL);     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        String r4 = (String) r3;
        if (r4 == null) goto L16;
        String r5 = StringsKt.trim(r4).toString();
    L28:
        b0 r6 = r0.b();
        if (r6 == null) goto L31;
        Boolean r7 = r6.b();
    L32:
        b0 r8 = r0.b();
        if (r8 == null) goto L35;
        List<String> r9 = r8.d();
    L36:
        boolean r10 = DoraSetting.o(r7, r5, r9);
        com.larus.dora.impl.core.m0 r11 = r0.c();
        if (r11 == null) goto L39;
        Boolean r12 = r11.b();
    L40:
        com.larus.dora.impl.core.m0 r13 = r0.c();
        if (r13 == null) goto L43;
        List<String> r14 = r13.c();
    L44:
        boolean r15 = DoraSetting.o(r12, r5, r14);
        a0 r16 = r0.a();
        if (r16 == null) goto L47;
        Boolean r17 = r16.b();
    L48:
        a0 r18 = r0.a();
        if (r18 == null) goto L51;
        List<String> r20 = r18.c();
    L52:
        boolean r21 = DoraSetting.o(r17, r5, r20);
        StringBuilder r22 = new StringBuilder("doraBTOptimizationConfig: socModel=<");
        r22.append(r5);
        r22.append(">, heartbeat enable=");
        b0 r23 = r0.b();
        if (r23 == null) goto L55;
        Boolean r24 = r23.b();
    L56:
        r22.append(r24);
        r22.append(" inWhitelist=");
        b0 r25 = r0.b();
        if (r25 == null) goto L59;
        List<String> r26 = r25.d();
    L60:
        r22.append(DoraSetting.n(r5, r26));
        r22.append(" shouldEnable=");
        r22.append(r10);
        r22.append(", mutePlayback enable=");
        com.larus.dora.impl.core.m0 r110 = r0.c();
        if (r110 == null) goto L63;
        Boolean r111 = r110.b();
    L64:
        r22.append(r111);
        r22.append(" inWhitelist=");
        com.larus.dora.impl.core.m0 r112 = r0.c();
        if (r112 == null) goto L67;
        List<String> r113 = r112.c();
    L68:
        r22.append(DoraSetting.n(r5, r113));
        r22.append(" shouldEnable=");
        r22.append(r15);
        r22.append(", force3m enable=");
        a0 r114 = r0.a();
        if (r114 == null) goto L71;
        Boolean r115 = r114.b();
    L72:
        r22.append(r115);
        r22.append(" inWhitelist=");
        a0 r27 = r0.a();
        if (r27 == null) goto L75;
        List<String> r28 = r27.c();
    L76:
        r22.append(DoraSetting.n(r5, r28));
        r22.append(" shouldEnable=");
        r22.append(r21);
        g49.d.d("DoraSetting", r22.toString());
        b0 r30 = r0.b();
        if (r30 == null) goto L79;
        b0 r31 = b0.a(r30, Boolean.valueOf(r10));
    L80:
        com.larus.dora.impl.core.m0 r32 = r0.c();
        if (r32 == null) goto L83;
        com.larus.dora.impl.core.m0 r33 = com.larus.dora.impl.core.m0.a(r32, Boolean.valueOf(r15));
    L84:
        a0 r34 = r0.a();
        if (r34 == null) goto L88;
        r1 = a0.a(r34, Boolean.valueOf(r21));
    L88:
        return new com.larus.dora.impl.core.d(r31, r33, r1);
    L83:
        r33 = null;
        goto L84
    L79:
        r31 = null;
        goto L80
    L75:
        r28 = null;
        goto L76
    L71:
        r115 = null;
        goto L72
    L67:
        r113 = null;
        goto L68
    L63:
        r111 = null;
        goto L64
    L59:
        r26 = null;
        goto L60
    L55:
        r24 = null;
        goto L56
    L51:
        r20 = null;
        goto L52
    L47:
        r17 = null;
        goto L48
    L43:
        r14 = null;
        goto L44
    L39:
        r12 = null;
        goto L40
    L35:
        r9 = null;
        goto L36
    L31:
        r7 = null;
        goto L32
    L16:
        r5 = null;
    L8:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L91:
        Object r36 = DoraSetting.a().getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.soc.model"});     // Catch: Exception -> L25
        if ((r36 instanceof String) == false) goto L20;
        String r37 = (String) r36;     // Catch: Exception -> L25
    L21:
        if (r37 == null) goto L27;
        r5 = StringsKt.trim(r37).toString();     // Catch: Exception -> L25
        if (r5 != null) goto L28;
    L27:
        r5 = "";
        goto L28
    L20:
        r37 = null;
    L25:
        e = move-exception;
        g49.d.c("DoraSetting", "Failed to get ro.soc.model", e);
        goto L27
    L93:
        return null;
    }
}
