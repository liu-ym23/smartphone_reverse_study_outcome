package a6;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import cj.f;
import com.airbnb.lottie.a0;
import com.airbnb.lottie.c0;
import com.airbnb.lottie.y;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.anniex.container.g;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.n;
import com.bytedance.crash.p;
import com.bytedance.crash.upload.q;
import com.bytedance.crash.upload.r;
import com.bytedance.crash.upload.s;
import com.bytedance.forest.model.o;
import com.bytedance.framwork.core.sdkmonitor.e;
import com.bytedance.geckox.AppSettingsManager$IGeckoAppSettings;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.ies.bullet.core.u;
import com.bytedance.ies.bullet.lynx.init.m;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.common.util.concurrent.e0;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.w0;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import l9.l;
import oo.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f111b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f110a = r10;
        this.f111b = r5;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = false;
        byte[] r10 = null;
        f r11 = null;
        r11 = null;
        switch(this.f110a) {
            case 0: goto L292;
            case 1: goto L247;
            case 2: goto L233;
            case 3: goto L195;
            case 4: goto L192;
            case 5: goto L188;
            case 6: goto L186;
            case 7: goto L184;
            case 8: goto L167;
            case 9: goto L163;
            case 10: goto L160;
            case 11: goto L129;
            case 12: goto L281;
            case 13: goto L115;
            case 14: goto L110;
            case 15: goto L276;
            case 16: goto L81;
            case 17: goto L75;
            case 18: goto L73;
            case 19: goto L59;
            case 20: goto L54;
            case 21: goto L29;
            case 22: goto L25;
            case 23: goto L23;
            case 24: goto L21;
            case 25: goto L19;
            case 26: goto L283;
            case 27: goto L10;
            case 28: goto L6;
            default: goto L4;
        };
    L4:
        ((w0) this.f111b).a();
        return;
    L6:
        UIBody r12 = ((PaintingContext) this.f111b).f10169a.f10288b;
        if (r12 == null) goto L329;
        r12.requestLayout();
        return;
    L329:
        return;
    L10:
        LynxModuleFactory r13 = (LynxModuleFactory) this.f111b;
        if (r13.d == null) goto L330;
        LynxLog.b(2, "LynxModuleFactory", "lynx invoke onLynxViewAndJSRuntimeDestroy");
        r13.d.onLynxViewAndJSRuntimeDestroy();
        return;
    L330:
        return;
    L19:
        zi.a r14 = (zi.a) this.f111b;
        r14.g = r14.g();
        return;
    L21:
        ((oi.d) this.f111b).c();
        return;
    L23:
        com.bytedance.iesgurd.loader.a r15 = (com.bytedance.iesgurd.loader.a) this.f111b;
        r15.g = com.bytedance.android.anniex.base.service.f.d(r15.e, r15.f6634a, 0, r15.f6635b);
        return;
    L25:
        BulletCardView r16 = (BulletCardView) this.f111b;
        g r17 = new g(r16);
        Intrinsics.checkNotNullParameter(r17, "event");
        h r18 = r16.g;
        if (r18 == null) goto L332;
        r18.a((String) r17.f3144b, null);
        return;
    L332:
        return;
    L29:
        long r19 = System.currentTimeMillis();
        com.bytedance.ies.bullet.service.preload.b r20 = (com.bytedance.ies.bullet.service.preload.b) this.f111b;
        Object r21 = r20.d;
        monitor-enter(r21);
        ConcurrentHashMap r22 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;     // Catch: Throwable -> L34
        LinkedHashMap r23 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r20.f6111a).h();     // Catch: Throwable -> L34
        if (r23.isEmpty() == false) goto L36;
        com.bytedance.ies.bullet.service.base.b.d("no configs from gecko", LogLevel.d, "PreLoadService");     // Catch: Throwable -> L34
    L47:
        ConcurrentHashMap r24 = u.f5365a;     // Catch: Throwable -> L34
        u.a(r20.f6111a);     // Catch: Throwable -> L34
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r21);
        Log.d("OptPreloadConfigs", "preload config cost: " + (System.currentTimeMillis() - r19));
        return;
    L36:
        Iterator r26 = r23.entrySet().iterator();     // Catch: Throwable -> L34
    L38:
        if (r26.hasNext() == false) goto L46;
        Map.Entry r27 = (Map.Entry) r26.next();     // Catch: Throwable -> L34
        File r28 = new File((String) r27.getValue());     // Catch: Throwable -> L34
        if (r28.exists() == false) goto L38;
        if (r28.canRead() == false) goto L38;
        if (r28.length() <= 0) goto L38;
        r20.f6113c.put(r27.getKey(), ym.a.a(new JSONObject(FilesKt.a(r28))));     // Catch: Throwable -> L34
        goto L38
    L46:
        com.bytedance.ies.bullet.service.base.b.d("read preload config success: size: " + r23.size(), LogLevel.f5954b, "PreLoadService");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L59:
        Set r29 = (Set) this.f111b;
        if (r29 == null) goto L335;
        e r30 = m.f5687a;
        if (r30 != null) goto L64;
        return;
    L64:
        if (r29.isEmpty() == false) goto L66;
        String r31 = "";
    L71:
        r30.p("lynx_component_info", com.lynx.tasm.utils.d.k("components", r31), null, null);
        return;
    L66:
        StringBuilder r32 = new StringBuilder();
        Iterator r33 = r29.iterator();
        r32.append((String) r33.next());
    L68:
        if (r33.hasNext() == false) goto L70;
        r32.append(",");
        r32.append((String) r33.next());
        goto L68
    L70:
        r31 = r32.toString();
        goto L71
    L335:
        return;
    L73:
        GkFSFileInputStream.access$report((GkFSFileInputStream) this.f111b);
        return;
    L75:
        com.bytedance.gkfs.io.b r34 = (com.bytedance.gkfs.io.b) this.f111b;
        r34.getClass();
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L78
        ((InputStream) r34.f4854a.getValue()).close();     // Catch: Throwable -> L78
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L78
        return;
    L78:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L81:
        f8.b.c((com.bytedance.gkfs.io.m) this.f111b);
        return;
    L115:
        ((o) this.f111b).h();
        return;
    L129:
        s r37 = (s) this.f111b;
        io.reactivex.exceptions.a.i("disaster:checkNetworkRestore");
        HashMap r38 = r37.f4156a;     // Catch: Throwable -> L269
        monitor-enter(r38);     // Catch: Throwable -> L269
    L136:
        th = move-exception;
        throw th;     // Catch: Throwable -> L269
    L133:
        if (r37.f4156a.size() > 0) goto L138;
        monitor-exit(r38);     // Catch: Throwable -> L136
        return;
    L138:
        HashMap r39 = new HashMap();     // Catch: Throwable -> L136
        Iterator r40 = r37.f4156a.entrySet().iterator();     // Catch: Throwable -> L136
    L140:
        if (r40.hasNext() == false) goto L150;
        Map.Entry r41 = (Map.Entry) r40.next();     // Catch: Throwable -> L136
        if (r41 == null) goto L140;
        q r42 = (q) r41.getValue();     // Catch: Throwable -> L136
        if (r42 == null) goto L140;
        if (r37.b(r42) > 0) goto L140;
        r39.put(r42.f4149b, r42.f4150c);     // Catch: Throwable -> L136
        goto L140
    L150:
        Iterator r43 = r39.entrySet().iterator();     // Catch: Throwable -> L136
    L152:
        if (r43.hasNext() == false) goto L154;
        Map.Entry r44 = (Map.Entry) r43.next();     // Catch: Throwable -> L136
        r37.n((String) r44.getKey(), (String) r44.getValue());     // Catch: Throwable -> L136
        goto L152
    L154:
        monitor-exit(r38);     // Catch: Throwable -> L136
        l.i("DST_CHECK_RESTORE", "");     // Catch: Throwable -> L269
        return;
    L348:
        return;
    L160:
        s r45 = (s) ((r) this.f111b).f4155b;
        r45.r();
        r45.t();
        return;
    L167:
        Application r46 = ((com.bytedance.android.monitorV2.h) this.f111b).f3581a;
        if (r46 == null) goto L350;
        File r47 = k5.d.c(r46, "monitor_data_switch");     // Catch: Throwable -> L174
        File r48 = new File(r47, "is_debug");     // Catch: Throwable -> L174
        if (r48.isFile() == true) goto L172;
    L176:
        File r49 = new File(r47, "is_output_file");     // Catch: Throwable -> L174
        if (r49.isFile() == true) goto L179;
        return;
    L179:
        if (r49.exists() == false) goto L352;
        com.bytedance.apm.util.a.f3906c = true;     // Catch: Throwable -> L174
        Application r50 = com.bytedance.android.monitorV2.h.e().f3581a;     // Catch: Throwable -> L174
        return;
    L352:
        return;
    L172:
        if (r48.exists() == false) goto L176;
        Application r51 = com.bytedance.android.monitorV2.h.e().f3581a;     // Catch: Throwable -> L174
        d5.b.f16593a = true;     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L350:
        return;
    L184:
        AnnieXLynxView.e((AnnieXLynxView) this.f111b);
        return;
    L186:
        AnnieXContainer r52 = (AnnieXContainer) this.f111b;
        r52.getBulletContext().release();
        AnnieXContainer.access$getContextProviderFactory$p(r52).f21717a.clear();
        return;
    L188:
        ja.d r53 = (ja.d) this.f111b;
        r53.getClass();
    L294:
        r53.g((com.bumptech.glide.load.engine.b) ((ReferenceQueue) r53.f18303c).remove());     // Catch: InterruptedException -> L191
    L191:
        Thread.currentThread().interrupt();
        goto L294
    L192:
        com.bumptech.glide.g r54 = (com.bumptech.glide.g) this.f111b;
        r54.f1409c.c(r54);
        return;
    L233:
        ConcurrentHashMap r55 = cj.l.f1209a;
        ConcurrentHashMap r56 = cj.l.f1209a;
        Class r57 = (Class) this.f111b;
        if (r56.contains(r57) == false) goto L236;
        ki.a.a(r57.getName().concat(" already cached"));
        return;
    L236:
        Class r58 = cj.l.b(r57, dj.d.class);
        if (r58 != null) goto L239;
        ConcurrentHashMap r59 = ki.b.f18649a;
        Intrinsics.checkNotNullParameter(r57, "clazz");
        ki.b.a(r57, dj.d.class);
    L243:
        if (r11 == null) goto L358;
        r56.put(r57, r11);
        cj.l.f1210b.put(r11.f1195b, r57);
        return;
    L358:
        return;
    L239:
        Class r60 = cj.l.b(r57, dj.e.class);
        if (r60 != null) goto L242;
        ConcurrentHashMap r61 = ki.b.f18649a;
        Intrinsics.checkNotNullParameter(r57, "clazz");
        ki.b.a(r57, dj.e.class);
        goto L243
    L242:
        HashMap r110 = new HashMap();
        r11 = new f(r58, r60, cj.l.a(r58, r110), cj.l.a(r60, r110), r110);
        goto L243
    L276:
        e r62 = (e) this.f111b;     // Catch: Throwable -> L103
        if (r62.f4718n == null) goto L338;
        Iterator r63 = r62.f4719o.iterator();     // Catch: Throwable -> L103
    L87:
        if (r63.hasNext() == false) goto L341;
        StringBuilder r64 = ((e) this.f111b).j((String) r63.next());     // Catch: Throwable -> L103
        r64.append("&encrypt=close");     // Catch: Throwable -> L103
        String r65 = r64.toString();     // Catch: Throwable -> L103
    L92:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L103
        goto L87
    L90:
        if (((e) this.f111b).l() == null) goto L94;
        byte[] r66 = ((e) this.f111b).l().doGet(r65, null).f20586b;     // Catch: Throwable -> L92
    L98:
        if (r66 == null) goto L339;
        e.i((e) this.f111b, new JSONObject(new String(r66)));     // Catch: Throwable -> L92
    L340:
        return;
    L339:
        return;
    L94:
        boolean r111 = ((e) this.f111b).f4722r;     // Catch: Throwable -> L92
        if (TextUtils.isDigitsOnly(r65) == false) goto L97;
        r66 = null;
        goto L98
    L97:
        r66 = f4.b.h(r65, null, null, null, "GET", false, r111).f20586b;     // Catch: Throwable -> L92
        goto L98
    L341:
        return;
    L338:
        return;
    L103:
        th = move-exception;
        if (((e) this.f111b).f4723t == true) goto L107;
        ((e) this.f111b).f4723t = true;
        e r67 = (e) this.f111b;
        r67.f4725v.a(r67);
    L107:
        th.printStackTrace();
        return;
    L281:
        r10 = (byte[]) com.bytedance.crash.upload.b.c(com.bytedance.crash.upload.b.h(n.f4062j.getApmConfigUrl(), i4.a.j(n.d().v(), new String[]{WsConstants.KEY_APP_ID, "4444", "crash", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, "os", "Android", "update_version_code", "000000", LynxMonitorService.KEY_CHANNEL, "unknown", "app_version", "0.0.0"})), null, "application/json; charset=utf-8", "gzip", "GET", false).e;     // Catch: Throwable -> L119
    L121:
        if (r10 != null) goto L123;
        return;
    L123:
        if (r10.length <= 0) goto L345;
        JSONObject r68 = new JSONObject(new String(r10)).optJSONObject("ret");     // Catch: Throwable -> L268
        String r69 = n.d().i();     // Catch: Throwable -> L268
        JSONArray r70 = new JSONArray();     // Catch: Throwable -> L268
        JSONObject r71 = new JSONObject();     // Catch: Throwable -> L268
        r71.put(r69, r68);     // Catch: JSONException -> L267 Throwable -> L268
        r70.put(r71);     // Catch: JSONException -> L267 Throwable -> L268
    L127:
        l9.c.a(r70, true);     // Catch: Throwable -> L268
        io.reactivex.exceptions.a.i("success updateWhenCrash");     // Catch: Throwable -> L268
        ((CountDownLatch) this.f111b).countDown();     // Catch: Throwable -> L268
        return;
    L346:
        return;
    L345:
        return;
    L119:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        goto L121
    L283:
        ((AutoCloseable) this.f111b).close();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e0.f9411a.log(Level.WARNING, "thrown by close()", e);
        return;
    L292:
        ((c) this.f111b).h();     // Catch: Throwable -> L264
        return;
    L264:
        th = move-exception;
        j.h(th, "handleReportAndHandleCache");
        return;
    L54:
        if (((com.lynx.tasm.l) this.f111b) == null) goto L333;
        e r72 = m.f5687a;
        if (r72 == null) goto L334;
        JSONObject r73 = new JSONObject();
        r73.put("pageVersion", "error");
        r73.put("pageType", "error");
        r73.put("cliVersion", "error");
        r73.put("customData", "error");
        r73.put("templateUrl", "error");
        r73.put("targetSdkVersion", "error");
        r73.put("lepusVersion", "error");
        r73.put("threadStrategyForRendering", null);
        r73.put("isEnableLepusNG", false);
        r73.put("radonMode", "error");
        r72.p("lynx_config_info", r73, null, null);
        return;
    L334:
        return;
    L333:
        return;
    L110:
        if (com.bytedance.frameworks.baselib.network.b.f4660b == false) goto L342;
        com.bytedance.frameworks.baselib.network.b.f4660b = false;
        ((ca.f) this.f111b).f1161c.set(true);
        if (Logger.debug() == false) goto L343;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    L343:
        return;
    L342:
        return;
    L163:
        if (p.f4084h == true) goto L349;
        com.bytedance.crash.upload.n.g();
        com.bytedance.crash.upload.n r74 = (com.bytedance.crash.upload.n) this.f111b;
        com.bytedance.crash.upload.n.b(r74);
        r74.f4145a.c(r74.f4147c, 30000);
        return;
    L349:
        return;
    L195:
        if (((c0) this.f111b).d == null) goto L354;
        a0 r75 = ((c0) this.f111b).d;
        Object r76 = r75.f1247a;
        if (r76 == null) goto L212;
        c0 r77 = (c0) this.f111b;
        monitor-enter(r77);
        Iterator r78 = new ArrayList(r77.f1251a).iterator();     // Catch: Throwable -> L206
    L203:
        if (r78.hasNext() == false) goto L208;
        ((y) r78.next()).onResult(r76);     // Catch: Throwable -> L206
        goto L203
    L208:
        monitor-exit(r77);
        return;
    L206:
        th = move-exception;
        throw th;
    L212:
        c0 r79 = (c0) this.f111b;
        Throwable r80 = r75.f1248b;
        monitor-enter(r79);
        ArrayList r81 = new ArrayList(r79.f1252b);     // Catch: Throwable -> L222
        if (r81.isEmpty() == false) goto L224;
        u.b.f22181a.getClass();     // Catch: Throwable -> L222
        HashSet r82 = u.a.f22180a;     // Catch: Throwable -> L222
        if (r82.contains("Lottie encountered an error but no failure listener was added:") == true) goto L220;
        Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added:", r80);     // Catch: Throwable -> L222
        r82.add("Lottie encountered an error but no failure listener was added:");     // Catch: Throwable -> L222
    L220:
        monitor-exit(r79);
        return;
    L224:
        Iterator r83 = r81.iterator();     // Catch: Throwable -> L222
    L226:
        if (r83.hasNext() == false) goto L229;
        ((y) r83.next()).onResult(r80);     // Catch: Throwable -> L222
        goto L226
    L229:
        monitor-exit(r79);
        return;
    L222:
        th = move-exception;
        throw th;
    L354:
        return;
    L247:
        if (com.bytedance.geckox.p.d() == false) goto L253;
        com.bytedance.geckox.c r84 = com.bytedance.geckox.b.f4736a;
        AppSettingsManager$IGeckoAppSettings r85 = r84.a();
        if (r85 == null) goto L252;
        r84.f4741b = r85.isGkFSTidyUpEnable();
    L252:
        GeckoLogger.a("enableGkFSTidyUp: " + r84.f4741b);
        r5 = r84.f4741b;
    L253:
        if (r5 == false) goto L360;
        com.bytedance.gkfs.storage.g r86 = com.bytedance.gkfs.a.b();     // Catch: Throwable -> L259
        if (r86 == null) goto L359;
        f8.b.f(null, r86, ((Ref.LongRef) this.f111b).element);     // Catch: Throwable -> L259
        return;
    L359:
        return;
    L259:
        th = move-exception;
        f8.b.f(th, null, 0);
        return;
    }
}
