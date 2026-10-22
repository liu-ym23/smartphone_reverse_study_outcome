package k5;

import android.app.Application;
import android.net.Uri;
import android.os.Environment;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$2$1;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$3$1;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$4$1;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.service.base.p;
import com.google.gson.Gson;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostLocationPermissionServiceImpl;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostSystemActionServiceImpl;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostUserDependImpl;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.externalcard.travel.TravelWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IHostContextDepend f18600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AISdkInitializer$injectAIBridgeBaseRuntime$2$1 f18601b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AISdkInitializer$injectAIBridgeBaseRuntime$3$1 f18602c = null;
    public static AISdkInitializer$injectAIBridgeBaseRuntime$4$1 d = null;
    public static ObricLauncherHostLocationPermissionServiceImpl e = null;
    public static ObricLauncherHostUserDependImpl f = null;
    public static ObricLauncherHostSystemActionServiceImpl g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static TravelWidgetView f18603h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f18604i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f18605j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f18606k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f18607l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f18608m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f18609n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f18610o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f18611p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f18612q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f18613r = "";
    public static Application s;

    public static int a(int r5, int r10) {
        return androidx.room.jarjarred.org.antlr.runtime.a.c(r5, r10, 31);
    }

    public static g4.a b(b4.c r5, AnnieXLynxView r10, com.bytedance.sdk.xbridge.cn.platform.lynx.a r11) {
        Uri r12 = r5.f860b;
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "lynxBDXBridge");
        Intrinsics.checkNotNullParameter(r5, "lynxViewModel");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L6
        String r14 = r12.getQueryParameter("air_action_strategy");     // Catch: Throwable -> L6
        if (r14 == null) goto L8;
        int r15 = Integer.parseInt(r14);     // Catch: Throwable -> L6
    L10:
        if (r15 != 1) goto L13;
        return new g4.a(r10, r11);
    L13:
        return null;
    L8:
        r15 = 0;
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        if (Result.m127exceptionOrNullimpl(Result.m124constructorimpl(ResultKt.createFailure(th))) == null) goto L17;
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution", "air_action_strategy is illegal. schema:" + r12, null, 12);
    L17:
        return null;
    }

    public static File c(Application r5, String r10) {
        if (r5 == null) goto L18;
        String r11 = Environment.getExternalStorageState();
        if ("mounted".equals(r11) == false) goto L6;
    L20:
        boolean r12 = "mounted".equals(Environment.getExternalStorageState());     // Catch: Exception -> L9
    L10:
        if (r12 == false) goto L23;
        File r13 = r5.getExternalFilesDir(r10);
        if (r13 != null) goto L15;
    L17:
        return r13;
    L15:
        if (r13.exists() == true) goto L17;
        r13.mkdirs();
        goto L17
    L23:
        return null;
    L9:
        r12 = false;
        goto L10
    L6:
        if ("mounted_ro".equals(r11) == true) goto L20;
        return null;
    L18:
        return null;
    }

    public static String d(int r17, String r18) {
        int r5 = 16;
        char r10 = '#';
        com.bumptech.glide.load.engine.j r14 = null;
        if (r18 != null) goto L5;
        return null;
    L5:
        if (r17 == 0) goto L7;
    L9:
        int r15 = r18.length();
        StringBuilder r11 = new StringBuilder(r15);
        if (r17 == 0) goto L12;
        r14 = new com.bumptech.glide.load.engine.j();
    L12:
        int r12 = 0;
    L13:
        if (r12 >= r15) goto L308;
        char r13 = ';';
        if (r18.charAt(r12) != '&') goto L43;
        int r16 = r12 + 1;
        if (r16 >= r15) goto L43;
        if (r18.charAt(r16) != r10) goto L43;
        int r19 = r12 + 2;
        int r20 = r19;
    L21:
        if (r20 >= r15) goto L28;
        if (r20 >= (r12 + 13)) goto L28;
        if (r18.charAt(r20) == ';') goto L29;
        r20 = r20 + 1;
    L29:
        if (r20 != (-1)) goto L310;
        r11.append(r18.charAt(r12));
    L304:
        if (r17 == 0) goto L306;
        r14.a(r11, r17);
    L306:
        r12 = r12 + 1;
        r5 = 16;
        r10 = '#';
        goto L13
    L310:
        if (r18.charAt(r19) != 'x') goto L37;
        int r21 = Integer.parseInt(r18.subSequence(r12 + 3, r20).toString(), r5);     // Catch: Exception -> L34
    L312:
        r11.appendCodePoint(r21);     // Catch: Exception -> L309
        r12 = r20;
        goto L304
    L37:
        r21 = Integer.parseInt(r18.subSequence(r19, r20).toString(), 10);     // Catch: Exception -> L309
    L41:
        r11.append(r18.charAt(r12));
    L28:
        r20 = -1;
    L43:
        if (r18.charAt(r12) != '&') goto L303;
        int r22 = r12 + 1;
        if (r22 >= r15) goto L303;
        int r23 = r22;
    L48:
        if (r23 >= r15) goto L64;
        if (r23 >= (r12 + 8)) goto L64;
        char r24 = r18.charAt(r23);
        if (r24 == r13) goto L65;
        if (r24 < 'A') goto L59;
        if (r24 > 'Z') goto L59;
    L63:
        r23 = r23 + 1;
        r13 = ';';
    L59:
        if (r24 < 'a') goto L64;
        if (r24 <= 'z') goto L63;
    L65:
        if (r23 != (-1)) goto L67;
        r11.append(r18.charAt(r12));
        goto L304
    L67:
        String r25 = r18.subSequence(r22, r23).toString();
        r25.getClass();
        switch(r25.hashCode()) {
            case -1419323836: goto L251;
            case -1368034367: goto L247;
            case -1339299958: goto L243;
            case -1220935388: goto L239;
            case -1196259461: goto L235;
            case -1190290628: goto L231;
            case -1093812015: goto L227;
            case -1074341375: goto L223;
            case -991722477: goto L219;
            case -922037109: goto L215;
            case -874702154: goto L211;
            case 3294: goto L207;
            case 3309: goto L203;
            case 3449: goto L199;
            case 3464: goto L195;
            case 96708: goto L191;
            case 107431: goto L187;
            case 113011: goto L183;
            case 121037: goto L179;
            case 3035411: goto L175;
            case 3059573: goto L171;
            case 3075965: goto L167;
            case 3117317: goto L163;
            case 3118278: goto L159;
            case 3354221: goto L155;
            case 3374865: goto L151;
            case 3482377: goto L147;
            case 3752377: goto L143;
            case 77382239: goto L139;
            case 92925156: goto L135;
            case 93596489: goto L131;
            case 94431411: goto L127;
            case 96619240: goto L123;
            case 97692206: goto L119;
            case 100313324: goto L115;
            case 102831699: goto L111;
            case 103278564: goto L107;
            case 103739775: goto L103;
            case 104663296: goto L99;
            case 105832675: goto L95;
            case 106934911: goto L91;
            case 108372825: goto L87;
            case 108819690: goto L83;
            case 109236764: goto L79;
            case 110364486: goto L75;
            case 2039534506: goto L71;
            default: goto L69;
        };
    L69:
        byte r26 = -1;
    L254:
        switch(r26) {
            case 0: goto L300;
            case 1: goto L299;
            case 2: goto L298;
            case 3: goto L297;
            case 4: goto L296;
            case 5: goto L295;
            case 6: goto L294;
            case 7: goto L293;
            case 8: goto L292;
            case 9: goto L291;
            case 10: goto L290;
            case 11: goto L289;
            case 12: goto L288;
            case 13: goto L287;
            case 14: goto L286;
            case 15: goto L285;
            case 16: goto L284;
            case 17: goto L283;
            case 18: goto L282;
            case 19: goto L281;
            case 20: goto L280;
            case 21: goto L279;
            case 22: goto L278;
            case 23: goto L277;
            case 24: goto L297;
            case 25: goto L276;
            case 26: goto L275;
            case 27: goto L274;
            case 28: goto L273;
            case 29: goto L272;
            case 30: goto L271;
            case 31: goto L270;
            case 32: goto L269;
            case 33: goto L268;
            case 34: goto L267;
            case 35: goto L266;
            case 36: goto L265;
            case 37: goto L264;
            case 38: goto L263;
            case 39: goto L262;
            case 40: goto L261;
            case 41: goto L260;
            case 42: goto L259;
            case 43: goto L258;
            case 44: goto L257;
            case 45: goto L256;
            default: goto L255;
        };
    L255:
        int r27 = -1;
    L301:
        if (r27 <= 0) goto L304;
        r11.append((char) r27);
        r12 = r23;
        goto L304
    L256:
        r27 = 8225;
        goto L301
    L257:
        r27 = 215;
        goto L301
    L258:
        r27 = 8218;
        goto L301
    L259:
        r27 = 8217;
        goto L301
    L260:
        r27 = 8221;
        goto L301
    L261:
        r27 = 8242;
        goto L301
    L262:
        r27 = 8254;
        goto L301
    L263:
        r27 = 8211;
        goto L301
    L264:
        r27 = 8212;
        goto L301
    L265:
        r27 = 8216;
        goto L301
    L266:
        r27 = 8220;
        goto L301
    L267:
        r27 = 299;
        goto L301
    L268:
        r27 = 8260;
        goto L301
    L269:
        r27 = 275;
        goto L301
    L270:
        r27 = 711;
        goto L301
    L271:
        r27 = 8222;
        goto L301
    L272:
        r27 = 257;
        goto L301
    L273:
        r27 = 8243;
        goto L301
    L274:
        r27 = 8204;
        goto L301
    L275:
        r27 = 34;
        goto L301
    L276:
        r27 = 160;
        goto L301
    L277:
        r27 = 8194;
        goto L301
    L278:
        r27 = 8195;
        goto L301
    L279:
        r27 = 8595;
        goto L301
    L280:
        r27 = 169;
        goto L301
    L281:
        r27 = 8226;
        goto L301
    L282:
        r27 = 8205;
        goto L301
    L283:
        r27 = 8207;
        goto L301
    L284:
        r27 = 8206;
        goto L301
    L285:
        r27 = 38;
        goto L301
    L286:
        r27 = 60;
        goto L301
    L287:
        r27 = 8804;
        goto L301
    L288:
        r27 = 62;
        goto L301
    L289:
        r27 = 8805;
        goto L301
    L290:
        r27 = 8201;
        goto L301
    L291:
        r27 = 8250;
        goto L301
    L292:
        r27 = 8240;
        goto L301
    L293:
        r27 = 183;
        goto L301
    L294:
        r27 = 8249;
        goto L301
    L295:
        r27 = 236;
        goto L301
    L296:
        r27 = 237;
        goto L301
    L297:
        r27 = 8230;
        goto L301
    L298:
        r27 = 8224;
        goto L301
    L299:
        r27 = 263;
        goto L301
    L300:
        r27 = 224;
        goto L301
    L71:
        if (r25.equals("Dagger") == false) goto L327;
        r26 = 45;
        goto L254
    L327:
        r26 = -1;
        goto L254
    L75:
        if (r25.equals("times") == false) goto L328;
        r26 = 44;
        goto L254
    L328:
        r26 = -1;
        goto L254
    L79:
        if (r25.equals("sbquo") == false) goto L329;
        r26 = 43;
        goto L254
    L329:
        r26 = -1;
        goto L254
    L83:
        if (r25.equals("rsquo") == false) goto L330;
        r26 = 42;
        goto L254
    L330:
        r26 = -1;
        goto L254
    L87:
        if (r25.equals("rdquo") == false) goto L331;
        r26 = 41;
        goto L254
    L331:
        r26 = -1;
        goto L254
    L91:
        if (r25.equals("prime") == false) goto L332;
        r26 = 40;
        goto L254
    L332:
        r26 = -1;
        goto L254
    L95:
        if (r25.equals("oline") == false) goto L333;
        r26 = 39;
        goto L254
    L333:
        r26 = -1;
        goto L254
    L99:
        if (r25.equals("ndash") == false) goto L334;
        r26 = 38;
        goto L254
    L334:
        r26 = -1;
        goto L254
    L103:
        if (r25.equals("mdash") == false) goto L335;
        r26 = 37;
        goto L254
    L335:
        r26 = -1;
        goto L254
    L107:
        if (r25.equals("lsquo") == false) goto L336;
        r26 = 36;
        goto L254
    L336:
        r26 = -1;
        goto L254
    L111:
        if (r25.equals("ldquo") == false) goto L337;
        r26 = 35;
        goto L254
    L337:
        r26 = -1;
        goto L254
    L115:
        if (r25.equals("imacr") == false) goto L338;
        r26 = 34;
        goto L254
    L338:
        r26 = -1;
        goto L254
    L119:
        if (r25.equals("frasl") == false) goto L339;
        r26 = 33;
        goto L254
    L339:
        r26 = -1;
        goto L254
    L123:
        if (r25.equals("emacr") == false) goto L340;
        r26 = 32;
        goto L254
    L340:
        r26 = -1;
        goto L254
    L127:
        if (r25.equals("caron") == false) goto L341;
        r26 = 31;
        goto L254
    L341:
        r26 = -1;
        goto L254
    L131:
        if (r25.equals("bdquo") == false) goto L342;
        r26 = 30;
        goto L254
    L342:
        r26 = -1;
        goto L254
    L135:
        if (r25.equals("amacr") == false) goto L343;
        r26 = 29;
        goto L254
    L343:
        r26 = -1;
        goto L254
    L139:
        if (r25.equals("Prime") == false) goto L344;
        r26 = 28;
        goto L254
    L344:
        r26 = -1;
        goto L254
    L143:
        if (r25.equals("zwnj") == false) goto L345;
        r26 = 27;
        goto L254
    L345:
        r26 = -1;
        goto L254
    L147:
        if (r25.equals("quot") == false) goto L346;
        r26 = 26;
        goto L254
    L346:
        r26 = -1;
        goto L254
    L151:
        if (r25.equals("nbsp") == false) goto L347;
        r26 = 25;
        goto L254
    L347:
        r26 = -1;
        goto L254
    L155:
        if (r25.equals("mldr") == false) goto L348;
        r26 = 24;
        goto L254
    L348:
        r26 = -1;
        goto L254
    L159:
        if (r25.equals("ensp") == false) goto L349;
        r26 = 23;
        goto L254
    L349:
        r26 = -1;
        goto L254
    L163:
        if (r25.equals("emsp") == false) goto L350;
        r26 = 22;
        goto L254
    L350:
        r26 = -1;
        goto L254
    L167:
        if (r25.equals("darr") == false) goto L351;
        r26 = 21;
        goto L254
    L351:
        r26 = -1;
        goto L254
    L171:
        if (r25.equals("copy") == false) goto L352;
        r26 = 20;
        goto L254
    L352:
        r26 = -1;
        goto L254
    L175:
        if (r25.equals("bull") == false) goto L353;
        r26 = 19;
        goto L254
    L353:
        r26 = -1;
        goto L254
    L179:
        if (r25.equals("zwj") == false) goto L354;
        r26 = 18;
        goto L254
    L354:
        r26 = -1;
        goto L254
    L183:
        if (r25.equals("rlm") == false) goto L355;
        r26 = 17;
        goto L254
    L355:
        r26 = -1;
        goto L254
    L187:
        if (r25.equals("lrm") == false) goto L356;
        r26 = 16;
        goto L254
    L356:
        r26 = -1;
        goto L254
    L191:
        if (r25.equals("amp") == false) goto L357;
        r26 = 15;
        goto L254
    L357:
        r26 = -1;
        goto L254
    L195:
        if (r25.equals("lt") == false) goto L358;
        r26 = 14;
        goto L254
    L358:
        r26 = -1;
        goto L254
    L199:
        if (r25.equals("le") == false) goto L359;
        r26 = 13;
        goto L254
    L359:
        r26 = -1;
        goto L254
    L203:
        if (r25.equals("gt") == false) goto L360;
        r26 = 12;
        goto L254
    L360:
        r26 = -1;
        goto L254
    L207:
        if (r25.equals("ge") == false) goto L361;
        r26 = 11;
        goto L254
    L361:
        r26 = -1;
        goto L254
    L211:
        if (r25.equals("thinsp") == false) goto L362;
        r26 = 10;
        goto L254
    L362:
        r26 = -1;
        goto L254
    L215:
        if (r25.equals("rsaquo") == false) goto L363;
        r26 = 9;
        goto L254
    L363:
        r26 = -1;
        goto L254
    L219:
        if (r25.equals("permil") == false) goto L364;
        r26 = 8;
        goto L254
    L364:
        r26 = -1;
        goto L254
    L223:
        if (r25.equals("middot") == false) goto L365;
        r26 = 7;
        goto L254
    L365:
        r26 = -1;
        goto L254
    L227:
        if (r25.equals("lsaquo") == false) goto L366;
        r26 = 6;
        goto L254
    L366:
        r26 = -1;
        goto L254
    L231:
        if (r25.equals("igrave") == false) goto L367;
        r26 = 5;
        goto L254
    L367:
        r26 = -1;
        goto L254
    L235:
        if (r25.equals("iacute") == false) goto L368;
        r26 = 4;
        goto L254
    L368:
        r26 = -1;
        goto L254
    L239:
        if (r25.equals("hellip") == false) goto L369;
        r26 = 3;
        goto L254
    L369:
        r26 = -1;
        goto L254
    L243:
        if (r25.equals("dagger") == false) goto L370;
        r26 = 2;
        goto L254
    L370:
        r26 = -1;
        goto L254
    L247:
        if (r25.equals("cacute") == false) goto L371;
        r26 = 1;
        goto L254
    L371:
        r26 = -1;
        goto L254
    L251:
        if (r25.equals("agrave") == false) goto L372;
        r26 = 0;
        goto L254
    L372:
        r26 = -1;
    L64:
        r23 = -1;
    L303:
        r11.append(r18.charAt(r12));
        goto L304
    L308:
        return r11.toString();
    L7:
        if (r18.indexOf(38) >= 0) goto L9;
        return r18;
    }

    public static void e(AnnieXLynxView r5, g4.a r10) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        if (r10 == null) goto L30;
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        if (r10.e == true) goto L26;
        LynxBaseUI r11 = r5.findUIByIdSelector("annie-root");
        if (r11 == null) goto L20;
        JavaOnlyMap r12 = r11.getProps();
        if (r12 == null) goto L20;
        String r13 = r12.getString("meta-data");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L14
        Gson r15 = m4.b.f19980a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r13, "jsonStr");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(l4.e.class, "clazz");     // Catch: Throwable -> L14
        r10.d = (l4.e) m4.b.f19980a.fromJson(r13, l4.e.class);     // Catch: Throwable -> L14
        Object r16 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        if (Result.m127exceptionOrNullimpl(r16) == null) goto L19;
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution", "meta-data parse failed: metaDataStr: " + r13, null, 12);
    L19:
        Result.m123boximpl(r16);
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L20:
        l4.e r19 = r10.d;
        if (r19 == null) goto L26;
        ug.d r20 = r10.f17030b;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "metaContent");
        r20.f22357b = r19.c();
        r20.f22358c = r19.a();
        Map r21 = r19.b();
        if (r21 == null) goto L25;
        ((LinkedHashMap) ((i4.a) r20.d).f17502b).putAll(r21);
    L25:
        r10.e = true;
    L26:
        Unit r22 = Unit.INSTANCE;
        return;
    }

    public static synchronized void f(String r5, String r10) {
        monitor-enter(d.class);
        if (r5 == null) goto L51;
        if (r10 == null) goto L51;
        File r11 = new File(r5);     // Catch: Throwable -> L34
        FileWriter r12 = null;
    L19:
        th = th;
    L41:
        if (r12 != null) goto L61;
    L46:
        throw th;     // Catch: Throwable -> L34
    L61:
        r12.close();     // Catch: Throwable -> L34 IOException -> L44
    L44:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        goto L46
    L11:
        if (r11.exists() == true) goto L29;
        File r13 = r11.getParentFile();     // Catch: Throwable -> L19 IOException -> L55
        if (r13 != null) goto L15;
    L21:
        boolean r14 = true;
    L22:
        if (r14 == false) goto L29;
    L27:
        e = move-exception;
        mn.h.g("default_handle", e);     // Catch: Throwable -> L19 IOException -> L55
        goto L29
    L24:
        if (r11.exists() == true) goto L29;
        r11.createNewFile();     // Catch: Throwable -> L19 IOException -> L27
        goto L29
    L15:
        if (r13.exists() == true) goto L21;
        r14 = r13.mkdirs();     // Catch: Throwable -> L19 IOException -> L55
    L29:
        FileWriter r15 = new FileWriter(r11, true);     // Catch: Throwable -> L19 IOException -> L55
        goto L47
    L64:
        r15.write(r10);     // Catch: Throwable -> L38 IOException -> L40
        r15.flush();     // Catch: Throwable -> L38 IOException -> L40
        r15.close();     // Catch: Throwable -> L34 IOException -> L36
        monitor-exit(d.class);
        return;
    L40:
        r12 = r15;
    L38:
        th = move-exception;
        th = th;
        r12 = r15;
    L47:
        if (r12 == null) goto L51;
        r12.close();     // Catch: Throwable -> L34 IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L51:
        monitor-exit(d.class);
    }

    public static void g(String r5, String r10, Exception r11, int r12) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (r11 != null) goto L9;
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("Argus_".concat(r5), r10, null, 8);
        return;
    L9:
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d(com.lynx.tasm.utils.g.d("Argus_", r5, "_crash"), r10 + ",e=" + r11 + ',' + ExceptionsKt.stackTraceToString(r11), null, 8);
    }

    public static void h(s3.b r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        rd.b r10 = r5.getCurrentSchema();
        if (r10 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(new vd.a(r10, "error_page_style", null).f22372b, "host") == false) goto L7;
        com.bytedance.ies.bullet.base.utils.logger.a.c("CustomViewUtil", "use host theme to create error view");
        String r11 = "default_bid";
    L8:
        r5.getViewType();
        tc.c r12 = tc.c.f22119c;
        if (tc.c.f22119c.a(p.class, r11) != null) goto L12;
        return;
    L12:
        throw new ClassCastException();
    L7:
        com.bytedance.ies.bullet.base.utils.logger.a.c("CustomViewUtil", "use custom theme to create error view");
        r11 = r5.getBid();
        goto L8
    }

    public static void i(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("Argus_".concat(r5), r10, null, 8);
    }
}
