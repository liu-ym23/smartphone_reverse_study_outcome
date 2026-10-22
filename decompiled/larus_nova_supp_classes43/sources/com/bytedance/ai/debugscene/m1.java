package com.bytedance.ai.debugscene;

import android.net.Uri;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.debug.AIDebugCommand;
import com.bytedance.ai.infra.thread_pool.AISdkCoroutineUtil;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m1 {
    public final AppletDebugTool a;

    public static final class a {
    }

    static {
    }

    public m1(AppletDebugTool r10) {
        Intrinsics.checkNotNullParameter(r10, "debugTool");
        this.a = r10;
    }

    public final com.bytedance.ai.debug.b a(final AIDebugCommand r33, final o1 r34) {
        Intrinsics.checkNotNullParameter(r33, "command");
        if (com.bytedance.ai.debug.a.a.contains(r33.b) == true) goto L5;
        String r17 = "appVersion";
        String r0 = "unsupported action:" + r33.b;
    L76:
        String r18 = "appletHost";
    L129:
        Object r12 = "com.bytedance.applet.UNINSTALL_AIPACKAGE";
        String r10 = r17;
    L184:
        Object r19 = r12;
        if (r0 == null) goto L188;
        com.bytedance.ai.utils.g.a.w("AppletDebugCommandDispatcher", "reject debug command: invalid params, action:" + r33.b + ", reason:" + r0);
        int r11 = com.bytedance.ai.debug.b.d;
        Intrinsics.checkNotNullParameter(r0, com.bytedance.android.ec.core.event.a.KEY_MSG);
        return new com.bytedance.ai.debug.b(true, false, r0);
    L188:
        String r1 = r33.b;
        switch(r1.hashCode()) {
            case -1893447523: goto L300;
            case -1864874172: goto L296;
            case -1703457137: goto L280;
            case -1643018152: goto L253;
            case -1004947045: goto L229;
            case -158032536: goto L213;
            case 122726254: goto L208;
            case 519666357: goto L195;
            case 742115725: goto L192;
            default: goto L309;
        };
    L195:
        final m1 r13 = this;
        if (r1.equals("com.bytedance.applet.CALL_TOOL") == false) goto L309;
        String r14 = n1.a(r33, "appletName");
        if (r14 != null) goto L201;
        r14 = "";
    L201:
        String r15 = n1.a(r33, "toolName");
        if (r15 != null) goto L204;
        r15 = "";
    L204:
        String r16 = n1.a(r33, "toolData");
        if (r16 != null) goto L207;
        r16 = "";
    L207:
        com.bytedance.ai.utils.g.a.d("AppletDebugCommandDispatcher", "ACTION_CALL_APPLET_TOOL. appId:" + r14 + ", toolName:" + r15);
        r13.a.getClass();
        Intrinsics.checkNotNullParameter(r14, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r15, "toolName");
        Intrinsics.checkNotNullParameter(r16, "toolData");
        int r20 = AISdkCoroutineUtil.a;
        AISdkCoroutineUtil.a(new AppletDebugTool$callAppletTool$1(r14, r15, r16, null));
        int r21 = com.bytedance.ai.debug.b.d;
        com.bytedance.ai.debug.b r22 = com.bytedance.ai.debug.b.a.a("applet tool called");
    L320:
        return r22;
    L208:
        r13 = this;
        if (r1.equals("com.bytedance.applet.UPDATE_ALL_AIPACKAGE") == false) goto L309;
        AIManager r23 = AIManager.a;
        AIManager.M();
        int r24 = com.bytedance.ai.debug.b.d;
        r22 = com.bytedance.ai.debug.b.a.a("all ai packages update started");
        goto L320
    L213:
        r13 = this;
        if (r1.equals("com.bytedance.applet.START_APPLET_WIDGET") == false) goto L309;
        String r25 = n1.a(r33, "appletName");
        if (r25 != null) goto L219;
        r25 = "";
    L219:
        String r26 = n1.a(r33, "widgetName");
        if (r26 != null) goto L222;
        r26 = "";
    L222:
        String r27 = n1.a(r33, "widgetData");
        if (r27 != null) goto L225;
        r27 = "";
    L225:
        String r28 = n1.a(r33, "botId");
        if (r28 != null) goto L228;
        r28 = "";
    L228:
        com.bytedance.ai.utils.g.a.d("AppletDebugCommandDispatcher", "ACTION_START_APPLET_WIDGET. appletName:" + r25 + ", widgetName:" + r26);
        r13.a.getClass();
        AppletDebugTool.j(r25, r26, r27, r28);
        int r29 = com.bytedance.ai.debug.b.d;
        r22 = com.bytedance.ai.debug.b.a.a("applet widget started");
        goto L320
    L229:
        r13 = this;
        if (r1.equals("com.bytedance.applet.START_APPLET") == false) goto L309;
        String r30 = n1.a(r33, "appletName");
        String r31 = n1.a(r33, "appletPageName");
        if (r31 != null) goto L235;
        String r210 = "";
    L236:
        String r32 = n1.a(r33, "appletPageUrl");
        if (r32 != null) goto L239;
        String r211 = r210;
    L240:
        String r35 = n1.a(r33, "appletPageData");
        if (r35 != null) goto L243;
        String r212 = "";
    L244:
        String r36 = n1.a(r33, "appletPageSettings");
        if (r36 == null) goto L248;
        r13.a.getClass();
        JavaOnlyMap r37 = AppletDebugTool.f(r36);
        if (r37 == null) goto L248;
    L249:
        JavaOnlyMap r213 = r37;
        String r38 = n1.a(r33, "mode");
        if (r38 != null) goto L252;
        r38 = "full";
    L252:
        String r214 = r38;
        com.bytedance.ai.utils.g.a.d("AppletDebugCommandDispatcher", "ACTION_START_APPLET. appletName:" + r30);
        AppletDebugTool r39 = r13.a;
        boolean r40 = AppletDebugTool.f;
        r39.i(r30, r210, r211, r212, r213, r214, false);
        int r41 = com.bytedance.ai.debug.b.d;
        r22 = com.bytedance.ai.debug.b.a.a("applet started");
    L248:
        r37 = new JavaOnlyMap();
        goto L249
    L243:
        r212 = r35;
        goto L244
    L239:
        r211 = r32;
        goto L240
    L235:
        r210 = r31;
        goto L236
    L253:
        r13 = this;
        if (r1.equals("com.bytedance.applet.SET_APPLET_DEBUG_HOST") == false) goto L309;
        final String r42 = n1.a(r33, "appletName");
        String r43 = r18;
        if (r42 != null) goto L259;
        r42 = "";
    L259:
        String r44 = n1.a(r33, r43);
        String r45 = n1.a(r33, "appletType");
        if (r45 != null) goto L262;
        r45 = "0";
    L262:
        String r215 = r45;
        com.bytedance.ai.utils.g.a.d("AppletDebugCommandDispatcher", "ACTION_SET_APPLET_DEBUG_HOST. appletName:" + r42 + ", appletHost:" + r44);
        if (r44 != null) goto L265;
    L268:
        boolean r46 = true;
    L269:
        if (r46 == false) goto L274;
        r13.a.getClass();
        AppletDebugTool.c();
        r13.a.getClass();
        AppletDebugTool.k(r42);
        int r47 = com.bytedance.ai.debug.b.d;
        com.bytedance.ai.debug.b r48 = com.bytedance.ai.debug.b.a.a("applet debug host removed");
        String r49 = r48.c;
        if (r49 != null) goto L273;
        r49 = "";
    L273:
        b(r34, r33, r42, true, r49);
    L277:
        r22 = r48;
        goto L320
    L274:
        r13.a.getClass();
        AIDebugManager.a.getClass();
        if ((!AIDebugManager.e.isEmpty()) == false) goto L278;
        int r50 = com.bytedance.ai.debug.b.d;
        Intrinsics.checkNotNullParameter("Please exit preview mode before enabling end-to-end debug mode.", com.bytedance.android.ec.core.event.a.KEY_MSG);
        r48 = new com.bytedance.ai.debug.b(true, false, "Please exit preview mode before enabling end-to-end debug mode.");
        goto L277
    L278:
        String r216 = r42;
        r13.a.h(r216, r44, n1.b(r33, "isSigned", false), r215, n1.a(r33, "signPublicKeyVersion"), n1.b(r33, "isEncrypted", false), n1.a(r33, "versionTag"), n1.b(r33, "defaultDebugTagState", true), new k1(r34, r33, r42), new l1(r13, r42, r34, r33));
        int r51 = com.bytedance.ai.debug.b.d;
        r22 = com.bytedance.ai.debug.b.a.a("applet debug host set");
        goto L320
    L265:
        if (StringsKt.isBlank(r44) == true) goto L268;
        r46 = false;
    L309:
        int r52 = com.bytedance.ai.debug.b.d;
        String r53 = r33.b;
        Intrinsics.checkNotNullParameter(r53, "action");
        com.bytedance.ai.debug.b r54 = new com.bytedance.ai.debug.b(false, false, "unsupported debug command: " + r53);
    L311:
        return r54;
    L192:
        if (r1.equals("com.bytedance.applet.SET_DEBUG_TAG") == false) goto L309;
        boolean r55 = n1.b(r33, "enable", false);
        com.bytedance.ai.utils.g.a.d("AppletDebugCommandDispatcher", "ACTION_SET_DEBUG_TAG. enable:" + r55);
        r13 = this;
        r13.a.g(r55);
        int r56 = com.bytedance.ai.debug.b.d;
        r22 = com.bytedance.ai.debug.b.a.a("debug tag updated");
        goto L320
    L280:
        if (r1.equals("com.bytedance.applet.INSTALL_AIPACKAGE_VERSION") == false) goto L309;
        String r57 = n1.a(r33, BdpAwemeConstant.KEY_APP_ID);
        if (r57 != null) goto L285;
        r57 = "";
    L285:
        String r58 = n1.a(r33, "packageName");
        if (r58 != null) goto L288;
        r58 = "";
    L288:
        String r59 = n1.a(r33, r10);
        if (r59 == null) goto L291;
        Long r60 = StringsKt.toLongOrNull(r59);
    L292:
        if (r60 != null) goto L294;
        int r61 = com.bytedance.ai.debug.b.d;
        Intrinsics.checkNotNullParameter("invalid versionCode", com.bytedance.android.ec.core.event.a.KEY_MSG);
        r54 = new com.bytedance.ai.debug.b(true, false, "invalid versionCode");
        goto L311
    L294:
        int r62 = AISdkCoroutineUtil.a;
        AISdkCoroutineUtil.a(new AppletDebugCommandDispatcher$installAIPackageVersion$1(r57, r58, r60, null));
        int r63 = com.bytedance.ai.debug.b.d;
        return com.bytedance.ai.debug.b.a.a("ai package install started");
    L291:
        r60 = null;
        goto L292
    L296:
        if (r1.equals("com.bytedance.applet.CLEAN_AIPACKAGE") == false) goto L309;
        int r64 = AISdkCoroutineUtil.a;
        AISdkCoroutineUtil.a(new AppletDebugCommandDispatcher$clearAIPackage$1(null));
        int r65 = com.bytedance.ai.debug.b.d;
        return com.bytedance.ai.debug.b.a.a("all ai packages cleared");
    L300:
        if (r1.equals(r19) == false) goto L309;
        String r66 = n1.a(r33, BdpAwemeConstant.KEY_APP_ID);
        if (r66 != null) goto L305;
        r66 = "";
    L305:
        String r67 = n1.a(r33, "packageName");
        if (r67 != null) goto L308;
        r67 = "";
    L308:
        this.a.getClass();
        AppletDebugTool.c();
        int r68 = AISdkCoroutineUtil.a;
        AISdkCoroutineUtil.a(new AppletDebugCommandDispatcher$uninstallAIPackage$1(r67, r66, null));
        int r69 = com.bytedance.ai.debug.b.d;
        return com.bytedance.ai.debug.b.a.a("ai package uninstall started");
    L5:
        r17 = "appVersion";
        String r70 = r33.b;
        switch(r70.hashCode()) {
            case -1893447523: goto L162;
            case -1703457137: goto L131;
            case -1643018152: goto L65;
            case -1004947045: goto L52;
            case -158032536: goto L31;
            case 519666357: goto L10;
            default: goto L7;
        };
    L7:
        r18 = "appletHost";
    L8:
        r12 = "com.bytedance.applet.UNINSTALL_AIPACKAGE";
        r10 = r17;
    L183:
        r0 = null;
        goto L184
    L131:
        r18 = "appletHost";
        if (r70.equals("com.bytedance.applet.INSTALL_AIPACKAGE_VERSION") == false) goto L8;
        String r71 = n1.a(r33, BdpAwemeConstant.KEY_APP_ID);
        if (r71 != null) goto L137;
    L140:
        boolean r72 = true;
    L141:
        if (r72 == false) goto L143;
        r12 = "com.bytedance.applet.UNINSTALL_AIPACKAGE";
        r10 = r17;
    L173:
        r0 = "appId is required";
        goto L184
    L143:
        String r73 = n1.a(r33, "packageName");
        if (r73 != null) goto L146;
    L149:
        boolean r74 = true;
    L150:
        if (r74 == false) goto L152;
        r12 = "com.bytedance.applet.UNINSTALL_AIPACKAGE";
        r10 = r17;
    L182:
        r0 = "packageName is required";
        goto L184
    L152:
        r10 = r17;
        String r75 = n1.a(r33, r10);
        if (r75 == null) goto L155;
        Long r76 = StringsKt.toLongOrNull(r75);
    L156:
        if (r76 != null) goto L158;
    L161:
        r0 = "appVersion must be positive long";
        r12 = "com.bytedance.applet.UNINSTALL_AIPACKAGE";
        goto L184
    L158:
        if (r76.longValue() <= 0) goto L161;
        r12 = "com.bytedance.applet.UNINSTALL_AIPACKAGE";
        goto L183
    L155:
        r76 = null;
        goto L156
    L146:
        if (StringsKt.isBlank(r73) == true) goto L149;
        r74 = false;
        goto L150
    L137:
        if (StringsKt.isBlank(r71) == true) goto L140;
        r72 = false;
        goto L141
    L162:
        r18 = "appletHost";
        r12 = "com.bytedance.applet.UNINSTALL_AIPACKAGE";
        r10 = r17;
        if (r70.equals(r12) == false) goto L183;
        String r77 = n1.a(r33, BdpAwemeConstant.KEY_APP_ID);
        if (r77 != null) goto L168;
    L171:
        boolean r78 = true;
    L172:
        if (r78 == true) goto L173;
        String r79 = n1.a(r33, "packageName");
        if (r79 != null) goto L177;
    L180:
        boolean r80 = true;
    L181:
        if (r80 == false) goto L183;
    L177:
        if (StringsKt.isBlank(r79) == true) goto L180;
        r80 = false;
        goto L181
    L168:
        if (StringsKt.isBlank(r77) == true) goto L171;
        r78 = false;
        goto L172
    L10:
        if (r70.equals("com.bytedance.applet.CALL_TOOL") == false) goto L316;
        String r81 = n1.a(r33, "appletName");
        if (r81 != null) goto L15;
    L18:
        boolean r82 = true;
    L19:
        if (r82 == true) goto L75;
        String r83 = n1.a(r33, "toolName");
        if (r83 != null) goto L24;
    L27:
        boolean r84 = true;
    L28:
        if (r84 == false) goto L63;
        r0 = "toolName is required";
    L63:
        r18 = "appletHost";
    L128:
        r0 = null;
        goto L129
    L24:
        if (StringsKt.isBlank(r83) == true) goto L27;
        r84 = false;
    L75:
        r0 = "appletName is required";
        goto L76
    L15:
        if (StringsKt.isBlank(r81) == true) goto L18;
        r82 = false;
        goto L19
    L316:
        r18 = "appletHost";
        goto L8
    L31:
        if (r70.equals("com.bytedance.applet.START_APPLET_WIDGET") == false) goto L317;
        String r85 = n1.a(r33, "appletName");
        if (r85 != null) goto L36;
    L39:
        boolean r86 = true;
    L40:
        if (r86 == true) goto L75;
        String r87 = n1.a(r33, "widgetName");
        if (r87 != null) goto L45;
    L48:
        boolean r88 = true;
    L49:
        if (r88 == false) goto L63;
        r0 = "widgetName is required";
        goto L76
    L45:
        if (StringsKt.isBlank(r87) == true) goto L48;
        r88 = false;
        goto L49
    L36:
        if (StringsKt.isBlank(r85) == true) goto L39;
        r86 = false;
        goto L40
    L317:
        r18 = "appletHost";
        goto L8
    L52:
        if (r70.equals("com.bytedance.applet.START_APPLET") == false) goto L318;
        String r89 = n1.a(r33, "appletName");
        if (r89 != null) goto L57;
    L60:
        boolean r90 = true;
    L61:
        if (r90 == false) goto L63;
    L57:
        if (StringsKt.isBlank(r89) == true) goto L60;
        r90 = false;
        goto L61
    L318:
        r18 = "appletHost";
        goto L8
    L65:
        if (r70.equals("com.bytedance.applet.SET_APPLET_DEBUG_HOST") == false) goto L319;
        String r91 = n1.a(r33, "appletName");
        if (r91 != null) goto L70;
    L73:
        boolean r92 = true;
    L74:
        if (r92 == true) goto L75;
        String r93 = n1.a(r33, "appletHost");
        if (r93 != null) goto L80;
    L83:
        boolean r94 = true;
    L84:
        if (r94 == false) goto L314;
        r18 = "appletHost";
    L118:
        boolean r95 = n1.b(r33, "isSigned", false);
        String r96 = n1.a(r33, "signPublicKeyVersion");
        if (r95 == false) goto L128;
        if (r96 != null) goto L122;
    L125:
        boolean r97 = true;
    L126:
        if (r97 == false) goto L128;
        r0 = "signVersion is required when verifySignature=true";
        goto L129
    L122:
        if (StringsKt.isBlank(r96) == true) goto L125;
        r97 = false;
        goto L126
    L314:
        Result.Companion r98 = Result.Companion;     // Catch: Throwable -> L108
        Uri r99 = UriProtector.parse(r93);     // Catch: Throwable -> L108
        String r100 = r99.getScheme();     // Catch: Throwable -> L108
        r18 = "appletHost";
        if (r100 != null) goto L312;
        String r101 = null;
    L90:
        String r102 = r99.getHost();     // Catch: Throwable -> L106
        if (r102 != null) goto L93;
    L96:
        boolean r103 = true;
    L97:
        if (r103 == false) goto L99;
    L103:
        boolean r104 = false;
    L104:
        Object r105 = Result.constructor-impl(Boolean.valueOf(r104));     // Catch: Throwable -> L106
    L111:
        Boolean r106 = Boolean.FALSE;
        if (Result.isFailure-impl(r105) == false) goto L115;
        r105 = r106;
    L115:
        if (((Boolean) r105).booleanValue() == true) goto L118;
        r0 = "appletHost only supports http or https";
    L106:
        th = th;
    L110:
        Result.Companion r107 = Result.Companion;
        r105 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L111
    L99:
        if (Intrinsics.areEqual(r101, "http") == false) goto L101;
    L102:
        r104 = true;
        goto L104
    L101:
        if (Intrinsics.areEqual(r101, "https") == false) goto L103;
    L93:
        if (StringsKt.isBlank(r102) == true) goto L96;
        r103 = false;
        goto L97
    L312:
        r101 = r100.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L106
    L108:
        th = th;
        r18 = "appletHost";
        goto L110
    L80:
        if (StringsKt.isBlank(r93) == true) goto L83;
        r94 = false;
        goto L84
    L70:
        if (StringsKt.isBlank(r91) == true) goto L73;
        r92 = false;
        goto L74
    L319:
        r18 = "appletHost";
        goto L8
    }

    public static final void b(Function1<? super com.bytedance.ai.debugscene.a, Unit> r10, AIDebugCommand r11, String r12, boolean r13, String r14) {
        if (r10 == null) goto L5;
        r10.invoke(new com.bytedance.ai.debugscene.a(r11.b, r13, r14, MapsKt.mapOf(TuplesKt.to("packageName", r12))));
        return;
    }
}
