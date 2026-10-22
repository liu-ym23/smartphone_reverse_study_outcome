package f4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import co.e;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.engine.bitmap_recycle.f;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.framwork.core.sdkmonitor.HttpResponseException;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil$CompressType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.sdk.xbridge.cn.auth.g;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.k;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.a0;
import nu.b0;
import nu.c0;
import nu.d;
import nu.f0;
import nu.t;
import nu.w;
import nu.x;
import rd.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile s8.a f16878a;

    public static e a(ReadableMap r12) {
        HashMap<String, Object> r5 = r12.asHashMap();
        String r10 = (String) r5.get("name");
        String r11 = (String) r5.get("entryType");
        if (r11.equals("pipeline") == false) goto L9;
        if (r10.equals("updateTriggeredByBts") == false) goto L9;
        return new co.a(r12.asHashMap());
    L9:
        if (r11.equals("pipeline") == false) goto L15;
        if (r10.equals("updateTriggeredByNative") == false) goto L15;
        return new co.a(r12.asHashMap());
    L15:
        if (r11.equals("pipeline") == false) goto L21;
        if (r10.equals("reactLynxHydrate") == false) goto L21;
        return new co.a(r12.asHashMap());
    L21:
        if (r11.equals("pipeline") == false) goto L27;
        if (r10.equals("setNativeProps") == false) goto L27;
        return new co.a(r12.asHashMap());
    L27:
        if (r11.equals("pipeline") == false) goto L33;
        if (r10.equals("updateGlobalProps") == false) goto L33;
        return new co.a(r12.asHashMap());
    L33:
        if (r11.equals("pipeline") == false) goto L68;
        if (r10.equals("loadBundle") == false) goto L68;
        HashMap<String, Object> r13 = r12.asHashMap();
        co.b r14 = new co.b(r13);
        if (r13.get("loadBundleStart") == null) goto L40;
        ((Double) r13.get("loadBundleStart")).getClass();
    L40:
        if (r13.get("loadBundleEnd") == null) goto L43;
        ((Double) r13.get("loadBundleEnd")).getClass();
    L43:
        if (r13.get("parseStart") == null) goto L46;
        ((Double) r13.get("parseStart")).getClass();
    L46:
        if (r13.get("parseEnd") == null) goto L49;
        ((Double) r13.get("parseEnd")).getClass();
    L49:
        if (r13.get("loadBackgroundStart") == null) goto L52;
        ((Double) r13.get("loadBackgroundStart")).getClass();
    L52:
        if (r13.get("loadBackgroundEnd") == null) goto L55;
        ((Double) r13.get("loadBackgroundEnd")).getClass();
    L55:
        if (r13.get("verifyTasmStart") == null) goto L58;
        ((Double) r13.get("verifyTasmStart")).getClass();
    L58:
        if (r13.get("verifyTasmEnd") == null) goto L61;
        ((Double) r13.get("verifyTasmEnd")).getClass();
    L61:
        if (r13.get("ffiStart") == null) goto L64;
        ((Double) r13.get("ffiStart")).getClass();
    L64:
        if (r13.get("ffiEnd") == null) goto L66;
        ((Double) r13.get("ffiEnd")).getClass();
    L66:
        return r14;
    L68:
        if (r11.equals("init") == false) goto L92;
        if (r10.equals("container") == false) goto L92;
        HashMap<String, Object> r15 = r12.asHashMap();
        co.a r16 = new co.a(r15);
        if (r15.get("openTime") == null) goto L75;
        ((Double) r15.get("openTime")).getClass();
    L75:
        if (r15.get("containerInitStart") == null) goto L78;
        ((Double) r15.get("containerInitStart")).getClass();
    L78:
        if (r15.get("containerInitEnd") == null) goto L81;
        ((Double) r15.get("containerInitEnd")).getClass();
    L81:
        if (r15.get("prepareTemplateStart") == null) goto L84;
        ((Double) r15.get("prepareTemplateStart")).getClass();
    L84:
        if (r15.get("prepareTemplateEnd") == null) goto L87;
        ((Double) r15.get("prepareTemplateEnd")).getClass();
    L87:
        if (r15.get("extraTiming") == null) goto L89;
        HashMap r17 = (HashMap) r15.get("extraTiming");
    L90:
        return r16;
    L89:
        new HashMap();
    L92:
        if (r11.equals("init") == false) goto L103;
        if (r10.equals("lynxview") == false) goto L103;
        HashMap<String, Object> r18 = r12.asHashMap();
        co.a r19 = new co.a(r18);
        if (r18.get("createLynxStart") == null) goto L99;
        ((Double) r18.get("createLynxStart")).getClass();
    L99:
        if (r18.get("createLynxEnd") == null) goto L101;
        ((Double) r18.get("createLynxEnd")).getClass();
    L101:
        return r19;
    L103:
        if (r11.equals("init") == false) goto L114;
        if (r10.equals("backgroundRuntime") == false) goto L114;
        HashMap<String, Object> r110 = r12.asHashMap();
        co.a r20 = new co.a(r110);
        if (r110.get("loadCoreStart") == null) goto L110;
        ((Double) r110.get("loadCoreStart")).getClass();
    L110:
        if (r110.get("loadCoreEnd") == null) goto L112;
        ((Double) r110.get("loadCoreEnd")).getClass();
    L112:
        return r20;
    L114:
        if (r11.equals(LynxMonitorService.KEY_METRIC) == false) goto L233;
        if (r10.equals("fcp") == false) goto L233;
        HashMap<String, Object> r111 = r12.asHashMap();
        co.a r21 = new co.a(r111);
        if (r111.get("fcp") == null) goto L137;
        HashMap r22 = (HashMap) r111.get("fcp");
        if (r22.get("name") == null) goto L123;
        String r23 = (String) r22.get("name");
    L123:
        if (r22.get("duration") == null) goto L126;
        ((Double) r22.get("duration")).getClass();
    L126:
        if (r22.get("startTimestampName") == null) goto L129;
        String r24 = (String) r22.get("startTimestampName");
    L129:
        if (r22.get("startTimestamp") == null) goto L132;
        ((Double) r22.get("startTimestamp")).getClass();
    L132:
        if (r22.get("endTimestampName") == null) goto L135;
        String r25 = (String) r22.get("endTimestampName");
    L135:
        if (r22.get("endTimestamp") == null) goto L156;
    L136:
        ((Double) r22.get("endTimestamp")).getClass();
    L156:
        if (r111.get("lynxFcp") == null) goto L175;
        HashMap r26 = (HashMap) r111.get("lynxFcp");
        if (r26.get("name") == null) goto L161;
        String r27 = (String) r26.get("name");
    L161:
        if (r26.get("duration") == null) goto L164;
        ((Double) r26.get("duration")).getClass();
    L164:
        if (r26.get("startTimestampName") == null) goto L167;
        String r28 = (String) r26.get("startTimestampName");
    L167:
        if (r26.get("startTimestamp") == null) goto L170;
        ((Double) r26.get("startTimestamp")).getClass();
    L170:
        if (r26.get("endTimestampName") == null) goto L173;
        String r29 = (String) r26.get("endTimestampName");
    L173:
        if (r26.get("endTimestamp") == null) goto L194;
    L174:
        ((Double) r26.get("endTimestamp")).getClass();
    L194:
        if (r111.get("totalFcp") == null) goto L213;
        HashMap r112 = (HashMap) r111.get("totalFcp");
        if (r112.get("name") == null) goto L199;
        String r30 = (String) r112.get("name");
    L199:
        if (r112.get("duration") == null) goto L202;
        ((Double) r112.get("duration")).getClass();
    L202:
        if (r112.get("startTimestampName") == null) goto L205;
        String r31 = (String) r112.get("startTimestampName");
    L205:
        if (r112.get("startTimestamp") == null) goto L208;
        ((Double) r112.get("startTimestamp")).getClass();
    L208:
        if (r112.get("endTimestampName") == null) goto L211;
        String r32 = (String) r112.get("endTimestampName");
    L211:
        if (r112.get("endTimestamp") == null) goto L231;
        ((Double) r112.get("endTimestamp")).getClass();
    L231:
        return r21;
    L213:
        HashMap r113 = new HashMap();
        if (r113.get("name") == null) goto L217;
        String r33 = (String) r113.get("name");
    L217:
        if (r113.get("duration") == null) goto L220;
        ((Double) r113.get("duration")).getClass();
    L220:
        if (r113.get("startTimestampName") == null) goto L223;
        String r34 = (String) r113.get("startTimestampName");
    L223:
        if (r113.get("startTimestamp") == null) goto L226;
        ((Double) r113.get("startTimestamp")).getClass();
    L226:
        if (r113.get("endTimestampName") == null) goto L229;
        String r35 = (String) r113.get("endTimestampName");
    L229:
        if (r113.get("endTimestamp") == null) goto L231;
        ((Double) r113.get("endTimestamp")).getClass();
        goto L231
    L175:
        r26 = new HashMap();
        if (r26.get("name") == null) goto L179;
        String r36 = (String) r26.get("name");
    L179:
        if (r26.get("duration") == null) goto L182;
        ((Double) r26.get("duration")).getClass();
    L182:
        if (r26.get("startTimestampName") == null) goto L185;
        String r37 = (String) r26.get("startTimestampName");
    L185:
        if (r26.get("startTimestamp") == null) goto L188;
        ((Double) r26.get("startTimestamp")).getClass();
    L188:
        if (r26.get("endTimestampName") == null) goto L191;
        String r38 = (String) r26.get("endTimestampName");
    L191:
        if (r26.get("endTimestamp") == null) goto L194;
    L137:
        r22 = new HashMap();
        if (r22.get("name") == null) goto L141;
        String r39 = (String) r22.get("name");
    L141:
        if (r22.get("duration") == null) goto L144;
        ((Double) r22.get("duration")).getClass();
    L144:
        if (r22.get("startTimestampName") == null) goto L147;
        String r40 = (String) r22.get("startTimestampName");
    L147:
        if (r22.get("startTimestamp") == null) goto L150;
        ((Double) r22.get("startTimestamp")).getClass();
    L150:
        if (r22.get("endTimestampName") == null) goto L153;
        String r41 = (String) r22.get("endTimestampName");
    L153:
        if (r22.get("endTimestamp") == null) goto L156;
    L233:
        if (r11.equals(LynxMonitorService.KEY_METRIC) == false) goto L352;
        if (r10.equals("fsp") == false) goto L352;
        HashMap<String, Object> r114 = r12.asHashMap();
        co.a r42 = new co.a(r114);
        if (r114.get("fsp") == null) goto L256;
        HashMap r43 = (HashMap) r114.get("fsp");
        if (r43.get("name") == null) goto L242;
        String r44 = (String) r43.get("name");
    L242:
        if (r43.get("duration") == null) goto L245;
        ((Double) r43.get("duration")).getClass();
    L245:
        if (r43.get("startTimestampName") == null) goto L248;
        String r45 = (String) r43.get("startTimestampName");
    L248:
        if (r43.get("startTimestamp") == null) goto L251;
        ((Double) r43.get("startTimestamp")).getClass();
    L251:
        if (r43.get("endTimestampName") == null) goto L254;
        String r46 = (String) r43.get("endTimestampName");
    L254:
        if (r43.get("endTimestamp") == null) goto L275;
    L255:
        ((Double) r43.get("endTimestamp")).getClass();
    L275:
        if (r114.get("lynxFsp") == null) goto L294;
        HashMap r47 = (HashMap) r114.get("lynxFsp");
        if (r47.get("name") == null) goto L280;
        String r48 = (String) r47.get("name");
    L280:
        if (r47.get("duration") == null) goto L283;
        ((Double) r47.get("duration")).getClass();
    L283:
        if (r47.get("startTimestampName") == null) goto L286;
        String r49 = (String) r47.get("startTimestampName");
    L286:
        if (r47.get("startTimestamp") == null) goto L289;
        ((Double) r47.get("startTimestamp")).getClass();
    L289:
        if (r47.get("endTimestampName") == null) goto L292;
        String r50 = (String) r47.get("endTimestampName");
    L292:
        if (r47.get("endTimestamp") == null) goto L313;
    L293:
        ((Double) r47.get("endTimestamp")).getClass();
    L313:
        if (r114.get("totalFsp") == null) goto L332;
        HashMap r115 = (HashMap) r114.get("totalFsp");
        if (r115.get("name") == null) goto L318;
        String r51 = (String) r115.get("name");
    L318:
        if (r115.get("duration") == null) goto L321;
        ((Double) r115.get("duration")).getClass();
    L321:
        if (r115.get("startTimestampName") == null) goto L324;
        String r52 = (String) r115.get("startTimestampName");
    L324:
        if (r115.get("startTimestamp") == null) goto L327;
        ((Double) r115.get("startTimestamp")).getClass();
    L327:
        if (r115.get("endTimestampName") == null) goto L330;
        String r53 = (String) r115.get("endTimestampName");
    L330:
        if (r115.get("endTimestamp") == null) goto L350;
        ((Double) r115.get("endTimestamp")).getClass();
    L350:
        return r42;
    L332:
        HashMap r116 = new HashMap();
        if (r116.get("name") == null) goto L336;
        String r54 = (String) r116.get("name");
    L336:
        if (r116.get("duration") == null) goto L339;
        ((Double) r116.get("duration")).getClass();
    L339:
        if (r116.get("startTimestampName") == null) goto L342;
        String r55 = (String) r116.get("startTimestampName");
    L342:
        if (r116.get("startTimestamp") == null) goto L345;
        ((Double) r116.get("startTimestamp")).getClass();
    L345:
        if (r116.get("endTimestampName") == null) goto L348;
        String r56 = (String) r116.get("endTimestampName");
    L348:
        if (r116.get("endTimestamp") == null) goto L350;
        ((Double) r116.get("endTimestamp")).getClass();
        goto L350
    L294:
        r47 = new HashMap();
        if (r47.get("name") == null) goto L298;
        String r57 = (String) r47.get("name");
    L298:
        if (r47.get("duration") == null) goto L301;
        ((Double) r47.get("duration")).getClass();
    L301:
        if (r47.get("startTimestampName") == null) goto L304;
        String r58 = (String) r47.get("startTimestampName");
    L304:
        if (r47.get("startTimestamp") == null) goto L307;
        ((Double) r47.get("startTimestamp")).getClass();
    L307:
        if (r47.get("endTimestampName") == null) goto L310;
        String r59 = (String) r47.get("endTimestampName");
    L310:
        if (r47.get("endTimestamp") == null) goto L313;
    L256:
        r43 = new HashMap();
        if (r43.get("name") == null) goto L260;
        String r60 = (String) r43.get("name");
    L260:
        if (r43.get("duration") == null) goto L263;
        ((Double) r43.get("duration")).getClass();
    L263:
        if (r43.get("startTimestampName") == null) goto L266;
        String r61 = (String) r43.get("startTimestampName");
    L266:
        if (r43.get("startTimestamp") == null) goto L269;
        ((Double) r43.get("startTimestamp")).getClass();
    L269:
        if (r43.get("endTimestampName") == null) goto L272;
        String r62 = (String) r43.get("endTimestampName");
    L272:
        if (r43.get("endTimestamp") == null) goto L275;
    L352:
        if (r11.equals(LynxMonitorService.KEY_METRIC) == false) goto L471;
        if (r10.equals("actualFmp") == false) goto L471;
        HashMap<String, Object> r117 = r12.asHashMap();
        co.a r63 = new co.a(r117);
        if (r117.get("actualFmp") == null) goto L375;
        HashMap r64 = (HashMap) r117.get("actualFmp");
        if (r64.get("name") == null) goto L361;
        String r65 = (String) r64.get("name");
    L361:
        if (r64.get("duration") == null) goto L364;
        ((Double) r64.get("duration")).getClass();
    L364:
        if (r64.get("startTimestampName") == null) goto L367;
        String r66 = (String) r64.get("startTimestampName");
    L367:
        if (r64.get("startTimestamp") == null) goto L370;
        ((Double) r64.get("startTimestamp")).getClass();
    L370:
        if (r64.get("endTimestampName") == null) goto L373;
        String r67 = (String) r64.get("endTimestampName");
    L373:
        if (r64.get("endTimestamp") == null) goto L394;
    L374:
        ((Double) r64.get("endTimestamp")).getClass();
    L394:
        if (r117.get("lynxActualFmp") == null) goto L413;
        HashMap r68 = (HashMap) r117.get("lynxActualFmp");
        if (r68.get("name") == null) goto L399;
        String r69 = (String) r68.get("name");
    L399:
        if (r68.get("duration") == null) goto L402;
        ((Double) r68.get("duration")).getClass();
    L402:
        if (r68.get("startTimestampName") == null) goto L405;
        String r70 = (String) r68.get("startTimestampName");
    L405:
        if (r68.get("startTimestamp") == null) goto L408;
        ((Double) r68.get("startTimestamp")).getClass();
    L408:
        if (r68.get("endTimestampName") == null) goto L411;
        String r71 = (String) r68.get("endTimestampName");
    L411:
        if (r68.get("endTimestamp") == null) goto L432;
    L412:
        ((Double) r68.get("endTimestamp")).getClass();
    L432:
        if (r117.get("totalActualFmp") == null) goto L451;
        HashMap r118 = (HashMap) r117.get("totalActualFmp");
        if (r118.get("name") == null) goto L437;
        String r72 = (String) r118.get("name");
    L437:
        if (r118.get("duration") == null) goto L440;
        ((Double) r118.get("duration")).getClass();
    L440:
        if (r118.get("startTimestampName") == null) goto L443;
        String r73 = (String) r118.get("startTimestampName");
    L443:
        if (r118.get("startTimestamp") == null) goto L446;
        ((Double) r118.get("startTimestamp")).getClass();
    L446:
        if (r118.get("endTimestampName") == null) goto L449;
        String r74 = (String) r118.get("endTimestampName");
    L449:
        if (r118.get("endTimestamp") == null) goto L469;
        ((Double) r118.get("endTimestamp")).getClass();
    L469:
        return r63;
    L451:
        HashMap r119 = new HashMap();
        if (r119.get("name") == null) goto L455;
        String r75 = (String) r119.get("name");
    L455:
        if (r119.get("duration") == null) goto L458;
        ((Double) r119.get("duration")).getClass();
    L458:
        if (r119.get("startTimestampName") == null) goto L461;
        String r76 = (String) r119.get("startTimestampName");
    L461:
        if (r119.get("startTimestamp") == null) goto L464;
        ((Double) r119.get("startTimestamp")).getClass();
    L464:
        if (r119.get("endTimestampName") == null) goto L467;
        String r77 = (String) r119.get("endTimestampName");
    L467:
        if (r119.get("endTimestamp") == null) goto L469;
        ((Double) r119.get("endTimestamp")).getClass();
        goto L469
    L413:
        r68 = new HashMap();
        if (r68.get("name") == null) goto L417;
        String r78 = (String) r68.get("name");
    L417:
        if (r68.get("duration") == null) goto L420;
        ((Double) r68.get("duration")).getClass();
    L420:
        if (r68.get("startTimestampName") == null) goto L423;
        String r79 = (String) r68.get("startTimestampName");
    L423:
        if (r68.get("startTimestamp") == null) goto L426;
        ((Double) r68.get("startTimestamp")).getClass();
    L426:
        if (r68.get("endTimestampName") == null) goto L429;
        String r80 = (String) r68.get("endTimestampName");
    L429:
        if (r68.get("endTimestamp") == null) goto L432;
    L375:
        r64 = new HashMap();
        if (r64.get("name") == null) goto L379;
        String r81 = (String) r64.get("name");
    L379:
        if (r64.get("duration") == null) goto L382;
        ((Double) r64.get("duration")).getClass();
    L382:
        if (r64.get("startTimestampName") == null) goto L385;
        String r82 = (String) r64.get("startTimestampName");
    L385:
        if (r64.get("startTimestamp") == null) goto L388;
        ((Double) r64.get("startTimestamp")).getClass();
    L388:
        if (r64.get("endTimestampName") == null) goto L391;
        String r83 = (String) r64.get("endTimestampName");
    L391:
        if (r64.get("endTimestamp") == null) goto L394;
    L471:
        if (r11.equals("pipeline") == false) goto L477;
        if (r10.equals("reloadBundleFromNative") == false) goto L477;
        return new co.b(r12.asHashMap());
    L477:
        if (r11.equals("pipeline") == false) goto L483;
        if (r10.equals("reloadBundleFromBts") == false) goto L483;
        return new co.b(r12.asHashMap());
    L483:
        if (r11.equals(LynxMonitorService.KEY_MEMORY) == false) goto L489;
        if (r10.equals(LynxMonitorService.KEY_MEMORY) == false) goto L489;
        return new co.c(r12.asHashMap());
    L489:
        if (r11.equals("resource") == false) goto L521;
        if (r10.equals("lazyBundle") == false) goto L521;
        HashMap<String, Object> r120 = r12.asHashMap();
        co.a r84 = new co.a(r120);
        if (r120.get("componentUrl") == null) goto L496;
        String r85 = (String) r120.get("componentUrl");
    L496:
        if (r120.get("mode") == null) goto L499;
        String r86 = (String) r120.get("mode");
    L499:
        if (r120.get("size") == null) goto L502;
        ((Double) r120.get("size")).getClass();
    L502:
        if (r120.get("sync") == null) goto L505;
        ((Boolean) r120.get("sync")).getClass();
    L505:
        if (r120.get("loadSuccess") == null) goto L508;
        ((Boolean) r120.get("loadSuccess")).getClass();
    L508:
        if (r120.get("requireStart") == null) goto L511;
        ((Double) r120.get("requireStart")).getClass();
    L511:
        if (r120.get("requireEnd") == null) goto L514;
        ((Double) r120.get("requireEnd")).getClass();
    L514:
        if (r120.get("decodeStart") == null) goto L517;
        ((Double) r120.get("decodeStart")).getClass();
    L517:
        if (r120.get("decodeEnd") == null) goto L519;
        ((Double) r120.get("decodeEnd")).getClass();
    L519:
        return r84;
    L521:
        if (r11.equals("jsBlocking") == false) goto L547;
        if (r10.equals("jsBlocking") == false) goto L547;
        HashMap<String, Object> r121 = r12.asHashMap();
        co.a r87 = new co.a(r121);
        if (r121.get("stage") == null) goto L528;
        String r88 = (String) r121.get("stage");
    L528:
        if (r121.get("total_blocking_time") == null) goto L531;
        ((Double) r121.get("total_blocking_time")).getClass();
    L531:
        if (r121.get("total_blocking_count") == null) goto L534;
        ((Double) r121.get("total_blocking_count")).getClass();
    L534:
        if (r121.get("total_duration") == null) goto L537;
        ((Double) r121.get("total_duration")).getClass();
    L537:
        if (r121.get("blocking_ratio") == null) goto L540;
        ((Double) r121.get("blocking_ratio")).getClass();
    L540:
        if (r121.get("avg_blocking_time") == null) goto L543;
        ((Double) r121.get("avg_blocking_time")).getClass();
    L543:
        if (r121.get("time_after_fcp") == null) goto L545;
        ((Double) r121.get("time_after_fcp")).getClass();
    L545:
        return r87;
    L547:
        return new e(r12.asHashMap());
    }

    public static String b(StringBuilder r5, String r10, String r11, String r12) {
        return androidx.constraintlayout.motion.widget.a.t(r5, r10, r11, r12);
    }

    public static s8.a c(Context r10) {
        HandlerThread r5 = new HandlerThread("wschannel");
        r5.start();
        i4.a r11 = new i4.a(19);
        jk.a r12 = new jk.a(r10, r11);
        com.bytedance.ies.bullet.service.base.c r13 = new com.bytedance.ies.bullet.service.base.c(16);
        s8.a r14 = new s8.a(r10, r5.getLooper(), new g(16), r11, r12, r13);
        r12.f18351c = r14;
        return r14;
    }

    public static final w d(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buffer");
        return new w(r5);
    }

    public static final x e(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buffer");
        return new x(r5);
    }

    public static int f(byte r5, byte r10) {
        return (r5 & UByte.MAX_VALUE) - (r10 & UByte.MAX_VALUE);
    }

    public static oj.b g(String r10, byte[] r11, MonitorNetUtil$CompressType r12, boolean r13) {
        String r5 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r11 != null) goto L8;
        r11 = new byte[0];
    L8:
        int r14 = r11.length;
        if (MonitorNetUtil$CompressType.GZIP != r12) goto L18;
        if (r14 <= 128) goto L18;
        ByteArrayOutputStream r15 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r16 = new GZIPOutputStream(r15);
        r16.write(r11);     // Catch: Throwable -> L15
        r16.close();
        r11 = r15.toByteArray();
        r5 = "gzip";
    L14:
        byte[] r17 = r11;
        String r18 = r5;
        if (r13 == false) goto L34;
        byte[] r19 = EncryptorUtil.a(r17.length, r17);
        if (r19 == null) goto L30;
        String r20 = r10.concat("&tt_data=a");
        byte[] r21 = r19;
        String r22 = "application/octet-stream;tt-data=a";
    L32:
        return h(r20, r21, r22, r18, "POST", true, true);
    L30:
        r21 = r17;
        r22 = "application/json; charset=utf-8";
        r20 = r10;
        goto L32
    L34:
        return h(r10, r17, "application/json; charset=utf-8", r18, "POST", true, false);
    L15:
        r16.close();
        return null;
    L18:
        if (MonitorNetUtil$CompressType.DEFLATER != r12) goto L14;
        if (r14 <= 128) goto L14;
        ByteArrayOutputStream r110 = new ByteArrayOutputStream(8192);
        Deflater r23 = new Deflater();
        r23.setInput(r11);
        r23.finish();
        byte[] r111 = new byte[8192];
    L22:
        if (r23.finished() == true) goto L24;
        r110.write(r111, 0, r23.deflate(r111));
        goto L22
    L24:
        r23.end();
        r11 = r110.toByteArray();
        r5 = "deflate";
        goto L14
    }

    public static oj.b h(String r5, byte[] r10, String r11, String r12, String r13, boolean r14, boolean r15) {
        InputStream r16 = null;
        LinkedList r17 = new LinkedList();     // Catch: Throwable -> L6
        if (r15 == false) goto L8;
        URL r18 = new URL(com.lynx.tasm.behavior.ui.utils.e.r(r5, r17));     // Catch: Throwable -> L6
    L9:
        HttpURLConnection r19 = (HttpURLConnection) r18.openConnection();     // Catch: Throwable -> L6
        if (r15 == false) goto L23;
    L20:
        th = th;
    L21:
        Throwable r20 = th;
        HttpURLConnection r21 = r19;
        th = r20;
    L99:
        throw th;     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        k.q(r16);
        if (r21 != null) goto L93;
    L88:
        throw th;
    L93:
        r21.disconnect();     // Catch: Exception -> L90
        goto L88
    L12:
        if (r17.isEmpty() == true) goto L23;
        Iterator r110 = r17.iterator();     // Catch: Throwable -> L20
    L15:
        if (r110.hasNext() == false) goto L23;
        Pair r22 = (Pair) r110.next();     // Catch: Throwable -> L20
        if (r22 == null) goto L15;
        r19.setRequestProperty((String) r22.first, (String) r22.second);     // Catch: Throwable -> L20
    L23:
        if (r14 == false) goto L25;
        r19.setDoOutput(true);     // Catch: Throwable -> L20
    L26:
        if (r11 == null) goto L28;
        r19.setRequestProperty("Content-Type", r11);     // Catch: Throwable -> L20
    L28:
        if (r12 == null) goto L30;
        r19.setRequestProperty("Content-Encoding", r12);     // Catch: Throwable -> L20
    L30:
        r19.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L20
        r19.setRequestProperty("Version-Code", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L20
        r19.setRequestMethod(r13);     // Catch: Throwable -> L20
        if (r10 != null) goto L33;
    L43:
        int r23 = r19.getResponseCode();     // Catch: Throwable -> L20
        if (r23 != 200) goto L82;
        InputStream r24 = r19.getInputStream();     // Catch: Throwable -> L20
        String r25 = r19.getContentEncoding();     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r25) == false) goto L49;
    L64:
        ByteArrayOutputStream r26 = new ByteArrayOutputStream();     // Catch: Throwable -> L57
        byte[] r27 = new byte[8192];     // Catch: Throwable -> L57
    L65:
        int r28 = r24.read(r27);     // Catch: Throwable -> L57
        if ((-1) == r28) goto L68;
        r26.write(r27, 0, r28);     // Catch: Throwable -> L57
        goto L65
    L68:
        r24.close();     // Catch: Throwable -> L57
        byte[] r29 = r26.toByteArray();     // Catch: Throwable -> L57
    L69:
        Map<String, List<String>> r30 = r19.getHeaderFields();     // Catch: Throwable -> L57
        HashMap r111 = new HashMap();     // Catch: Throwable -> L57
        Iterator<String> r31 = r30.keySet().iterator();     // Catch: Throwable -> L57
    L71:
        if (r31.hasNext() == false) goto L77;
        String r32 = r31.next();     // Catch: Throwable -> L57
        List<String> r33 = r30.get(r32);     // Catch: Throwable -> L57
        if (r33 == null) goto L71;
        if (dn.a.R(r33) == true) goto L71;
        r111.put(r32, r33.get(0));     // Catch: Throwable -> L57
        goto L71
    L77:
        oj.b r34 = new oj.b(r23, r111, r29);     // Catch: Throwable -> L57
        k.q(r24);
        r19.disconnect();     // Catch: Exception -> L89
    L80:
        return r34;
    L49:
        if (r25.equalsIgnoreCase("gzip") == false) goto L64;
        GZIPInputStream r35 = new GZIPInputStream(r24);     // Catch: Throwable -> L61
        ByteArrayOutputStream r36 = new ByteArrayOutputStream();     // Catch: Throwable -> L59
        byte[] r37 = new byte[8192];     // Catch: Throwable -> L59
    L52:
        int r38 = r35.read(r37);     // Catch: Throwable -> L59
        if ((-1) == r38) goto L55;
        r36.write(r37, 0, r38);     // Catch: Throwable -> L59
        goto L52
    L55:
        r35.close();     // Catch: Throwable -> L59
        r29 = r36.toByteArray();     // Catch: Throwable -> L59
        k.q(r35);     // Catch: Throwable -> L57
    L59:
        th = th;
        r16 = r35;
    L62:
        k.q(r16);     // Catch: Throwable -> L57
        throw th;     // Catch: Throwable -> L57
    L61:
        th = th;
    L57:
        th = th;
        r16 = r24;
        goto L21
    L82:
        throw new HttpResponseException(r23, r19.getResponseMessage());     // Catch: Throwable -> L20
    L33:
        if (r10.length <= 0) goto L43;
        DataOutputStream r39 = new DataOutputStream(r19.getOutputStream());     // Catch: Throwable -> L39
        r39.write(r10);     // Catch: Throwable -> L37
        r39.flush();     // Catch: Throwable -> L37
        k.q(r39);     // Catch: Throwable -> L20
    L37:
        th = th;
    L41:
        k.q(r39);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L39:
        th = th;
        r39 = null;
        goto L41
    L25:
        r19.setDoOutput(false);     // Catch: Throwable -> L20
        goto L26
    L8:
        r18 = new URL(r5);     // Catch: Throwable -> L6
    L6:
        th = th;
        r21 = null;
        goto L99
    }

    public static int i(f r5, InputStream r10, ArrayList r11) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        if (r10.markSupported() == true) goto L8;
        r10 = new s(r10, r5);
    L8:
        r10.mark(5242880);
        int r12 = r11.size();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L24;
        int r14 = ((z.b) r11.get(r13)).a(r10, r5);     // Catch: Throwable -> L16
        r10.reset();
        if (r14 != (-1)) goto L19;
        r13 = r13 + 1;
        goto L9
    L19:
        return r14;
    L16:
        th = move-exception;
        r10.reset();
        throw th;
    L24:
        return -1;
    }

    public static ImageHeaderParser$ImageType j(f r5, InputStream r10, ArrayList r11) {
        if (r10 != null) goto L6;
        return ImageHeaderParser$ImageType.UNKNOWN;
    L6:
        if (r10.markSupported() == true) goto L8;
        r10 = new s(r10, r5);
    L8:
        r10.mark(5242880);
        int r12 = r11.size();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L20;
        ImageHeaderParser$ImageType r14 = ((z.b) r11.get(r13)).c(r10);     // Catch: Throwable -> L16
        r10.reset();
        if (r14 != ImageHeaderParser$ImageType.UNKNOWN) goto L25;
        r13 = r13 + 1;
        goto L9
    L25:
        return r14;
    L16:
        th = move-exception;
        r10.reset();
        throw th;
    L20:
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static final boolean k(AssertionError r5) {
        Logger r10 = t.f20339a;
        Intrinsics.checkNotNullParameter(r5, "$this$isAndroidGetsocknameError");
        if (r5.getCause() == null) goto L11;
        String r11 = r5.getMessage();
        if (r11 == null) goto L7;
        boolean r12 = StringsKt.g(r11, "getsockname failed");
    L8:
        if (r12 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r12 = false;
        goto L8
    L11:
        return false;
    }

    public static boolean l(Context r5) {
        if (r5 != null) goto L15;
        return false;
    L15:
        NetworkInfo r10 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L10
        if (r10 == null) goto L12;
        if (r10.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        return false;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static String m(AbstractList r5, String r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator r12 = r5.iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L11;
        String r14 = (String) r12.next();
        if (r13 == false) goto L8;
        r13 = false;
    L9:
        r11.append(r14);
        goto L4
    L8:
        r11.append(r10);
        goto L9
    L11:
        return r11.toString();
    }

    public static final nu.c n(OutputStream r5) {
        Logger r10 = t.f20339a;
        Intrinsics.checkNotNullParameter(r5, "$this$sink");
        return new nu.c(r5, new f0());
    }

    public static final a0 o(Socket r5) {
        Logger r10 = t.f20339a;
        Intrinsics.checkNotNullParameter(r5, "$this$sink");
        b0 r11 = new b0(r5);
        return r11.sink(new nu.c(r5.getOutputStream(), r11));
    }

    public static final d p(InputStream r5) {
        Logger r10 = t.f20339a;
        Intrinsics.checkNotNullParameter(r5, "$this$source");
        return new d(r5, new f0());
    }

    public static final c0 q(Socket r5) {
        Logger r10 = t.f20339a;
        Intrinsics.checkNotNullParameter(r5, "$this$source");
        b0 r11 = new b0(r5);
        return r11.source(new d(r5.getInputStream(), r11));
    }
}
