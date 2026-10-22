package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.r;
import com.bytedance.forest.model.u;
import com.bytedance.gkfs.io.ChunkFrom;
import com.bytedance.keva.Keva;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.salamander.anniex.n;
import com.bytedance.services.apm.api.IHttpService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.ui.image.f0;
import com.lynx.tasm.ui.image.k0;
import com.lynx.tasm.ui.image.l0;
import com.lynx.tasm.ui.image.n0;
import com.lynx.tasm.ui.image.o0;
import com.lynx.tasm.ui.image.p0;
import com.lynx.tasm.ui.image.q0;
import com.lynx.tasm.ui.image.v;
import com.lynx.tasm.ui.image.v0;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3871c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e(int r5, Object r10, Object r11, Object r12, Object r13) {
        this.f3869a = r5;
        this.f3870b = r10;
        this.f3871c = r11;
        this.d = r12;
        this.e = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int r5 = 23;
        boolean r10 = false;
        Object[] r11 = 0;
        switch(this.f3869a) {
            case 0: goto L297;
            case 1: goto L225;
            case 2: goto L198;
            case 3: goto L196;
            case 4: goto L187;
            case 5: goto L180;
            case 6: goto L300;
            case 7: goto L165;
            case 8: goto L163;
            case 9: goto L81;
            case 10: goto L73;
            case 11: goto L71;
            case 12: goto L30;
            case 13: goto L24;
            case 14: goto L6;
            default: goto L4;
        };
    L4:
        i6.a.i().b(new j6.e((String) this.f3870b, "", (JSONObject) this.d, (JSONObject) this.e, (JSONObject) this.f3871c));
        return;
    L6:
        oo.b r12 = (oo.b) this.f3870b;
        String r13 = r12.f;     // Catch: Throwable -> L15
        Context r14 = (Context) this.f3871c;
        oo.e r15 = (oo.e) this.e;
        if (r13 != null) goto L11;
    L17:
        oo.d r16 = oo.e.e(r15, r12);     // Catch: Throwable -> L15
        if (r16 == null) goto L20;
        r15.f20801c.post(new v(r5, r15, r16));     // Catch: Throwable -> L15
    L307:
        return;
    L20:
        oo.e.k(r15, r14, (oo.b) this.d);     // Catch: Throwable -> L15
        goto L307
    L11:
        if (r13.startsWith("asset") == false) goto L17;
        oo.d r17 = oo.e.d(r15, r14, r12);     // Catch: Throwable -> L15
        if (r17 == null) goto L307;
        r15.f20801c.post(new v(r5, r15, r17));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        LynxLog.b(4, "BigImageDrawingHelper", "loadOriginBitmap failed: " + th.toString());
        return;
    L24:
        LynxModuleWrapper r18 = (LynxModuleWrapper) ((WeakReference) this.f3871c).get();
        LynxEngineProxy r19 = (LynxEngineProxy) ((WeakReference) this.d).get();
        if (r18 == null) goto L28;
        if (r19 == null) goto L28;
        sk.a.b(r18, r19, (ReadableMap) this.e, (String) this.f3870b);
        return;
    L28:
        LynxLog.b(2, "LynxLepusModule", "triggerLepusBridgeAsync failed, LynxModule or LynxEngine has been released.");
        return;
    L30:
        Uri r20 = (Uri) this.f3871c;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L45
        String r22 = (String) this.f3870b;
        if (r22 != null) goto L35;
        return;
    L35:
        if (r22.length() == 0) goto L326;
        String r23 = com.bytedance.pia.core.utils.j.k(r20, null);     // Catch: Throwable -> L45
        if (r23 == null) goto L330;
        JsonObject r24 = (JsonObject) this.d;
        if (r24 != null) goto L47;
        r24 = com.bytedance.pia.core.utils.j.t(r22);     // Catch: Throwable -> L45
        if (r24 != null) goto L47;
        return;
    L47:
        String r110 = r24.get("version").getAsString();     // Catch: Throwable -> L45
        if (r110 == null) goto L328;
        Keva r111 = jh.c.a(r23);     // Catch: Throwable -> L45
        if (r111 == null) goto L63;
        i4.a r112 = jh.c.o(r111, r23);     // Catch: Throwable -> L45
        i4.a r25 = (i4.a) this.e;
        if (r112 != null) goto L56;
        r112 = r25;
    L56:
        if (r112 == null) goto L63;
        String r113 = ((jh.a) r112.d).g();     // Catch: Throwable -> L45
        if (r113 == null) goto L63;
        if (Intrinsics.areEqual(r113, r110) == false) goto L62;
        jh.c.e(r20, r25, false);     // Catch: Throwable -> L45
        com.bytedance.pia.core.utils.j.y("[PIACacheManager] No Need to validate Cache Finish. (URL: " + r20 + ')', null);     // Catch: Throwable -> L45
    L64:
        Object r26 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L67:
        Throwable r27 = Result.m127exceptionOrNullimpl(r26);
        if (r27 == null) goto L329;
        com.bytedance.pia.core.utils.j.w(6, "[PIACacheManager] Validate Cache Exception. (URL: " + r20 + " , Error: " + r27 + ')', null);
        return;
    L329:
        return;
    L62:
        jh.c.n(r23);     // Catch: Throwable -> L45
    L63:
        com.bytedance.pia.core.utils.j.y("[PIACacheManager] Validate Cache Finish. (URL: " + r20 + " , isUpdate: " + jh.c.i(r20, r22, r24, null) + ')', null);     // Catch: Throwable -> L45
        goto L64
    L328:
        return;
    L330:
        return;
    L326:
        return;
    L45:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L67
    L71:
        ((jg.k) ((com.lynx.animax.player.b) this.e).f9657b).e((wn.b) this.f3870b, (xn.e) this.f3871c, (xn.c) this.d);
        return;
    L73:
        Long r29 = (Long) dd.c.e().get("mem_java_used");
        String r30 = (String) this.f3871c;
        String r31 = (String) this.f3870b;
        z4.a r32 = (z4.a) this.e;
        Ref.IntRef r33 = (Ref.IntRef) this.d;
        if (r29 == null) goto L76;
        r32.c(r29.longValue(), r31, r30 + '_' + r33.element);
    L76:
        Double r34 = (Double) dd.c.a().get("cpu_rate");
        if (r34 == null) goto L79;
        r32.e(r31, r30 + '_' + r33.element, r34.doubleValue());
    L79:
        r33.element++;
        return;
    L81:
        v0 r35 = (v0) this.e;
        o0 r36 = r35.O;
        r36.d = r35.H;
        r36.f11080c = r35.d;
        no.d r37 = (no.d) this.f3871c;
        if (r37 == null) goto L84;
        boolean r38 = true;
    L85:
        r36.e = r38;
        no.d r39 = (no.d) this.d;
        r36.f11078a = r39;
        n0 r40 = r35.K.d;
        r36.f11079b = r37;
        r36.f11088k = r35.f11120f0;
        if (r39 != null) goto L89;
        if (r37 == null) goto L89;
        r36.f11078a = r37;
        r36.f11079b = null;
    L89:
        String r41 = String.valueOf(l0.f11077h.getAndIncrement());
        if (r40 == null) goto L93;
    L102:
        no.d r42 = r36.f11078a;
        if (r42 == null) goto L105;
        Supplier r43 = new k0(r36, r40, r42);
    L106:
        if (r43 != null) goto L108;
    L110:
        if (r43 != null) goto L112;
        r43 = DataSources.a(l0.g);
    L112:
        r40.f11085r = r36.f11088k;
        if (r40.f11059j == true) goto L117;
        com.lynx.tasm.ui.image.b r44 = r40.f11054a;
        if (r44 == null) goto L117;
        r44.f11025a.remove(r40);
    L117:
        r40.f11056c = false;
        r40.a();
        r40.f = false;
        r40.f11060k = null;
        if (r40.f11061l == null) goto L120;
        r40.f11061l = null;
    L120:
        r40.f11064o = r41;
        r40.f11059j = false;
        r40.f11084q = r43;
        r40.f = r36.e;
        BaseControllerListener r45 = r36.f11080c;
        if (r45 == null) goto L124;
        r40.b(r45);
    L124:
        if (r36.d == false) goto L126;
        r40.b(l0.f);
    L126:
        v0 r46 = (v0) this.e;
        r40.f11062m = r46.i0;
        r40.f11063n = (String) this.f3870b;
        q0 r47 = r46.K;
        boolean r48 = r47.f11096a;
        if (r48 == false) goto L129;
        r47.a();
    L129:
        n0 r49 = r47.d;
        if (r49 != null) goto L132;
    L139:
        r47.d = r40;
        DraweeHierarchy r50 = r47.f11098c;
        if (r40.d == false) goto L143;
        r40.f11054a.f11025a.remove(r40);
        r40.a();
    L143:
        if (r40.f11061l == null) goto L145;
        r40.f11061l = null;
    L145:
        if (r50 != null) goto L147;
    L151:
        if (r48 == true) goto L153;
    L159:
        o0 r51 = ((v0) this.e).O;
        r51.f11088k = null;
        r51.f11078a = null;
        r51.f11079b = null;
        r51.f11080c = null;
        r51.d = false;
        return;
    L153:
        if (r47.f11096a == true) goto L159;
        r47.f11096a = true;
        p0 r52 = new p0(r47, r11 == true ? 1 : 0);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) goto L158;
        r52.run();
        goto L159
    L158:
        mn.h.j().execute(r52);
        goto L159
    L147:
        if ((r50 instanceof SettableDraweeHierarchy) == false) goto L150;
        r40.f11061l = (SettableDraweeHierarchy) r50;
        goto L151
    L150:
        throw new IllegalArgumentException();
    L132:
        if (r49.f11061l != r47.f11098c) goto L139;
        if (r49.d == false) goto L137;
        r49.f11054a.f11025a.remove(r49);
        r49.a();
    L137:
        if (r49.f11061l == null) goto L139;
        r49.f11061l = null;
        goto L139
    L108:
        if (r36.f11079b == null) goto L110;
        ArrayList r53 = new ArrayList(2);
        r53.add(r43);
        r53.add(new k0(r36, r40, r36.f11079b));
        r43 = new IncreasingQualityDataSourceSupplier(r53);
        goto L110
    L105:
        r43 = null;
        goto L106
    L93:
        monitor-enter(com.lynx.tasm.ui.image.b.class);
    L97:
        th = move-exception;
        throw th;
    L95:
        if (com.lynx.tasm.ui.image.b.f11024c != null) goto L99;
        com.lynx.tasm.ui.image.b.f11024c = new com.lynx.tasm.ui.image.b();     // Catch: Throwable -> L97
    L99:
        com.lynx.tasm.ui.image.b r54 = com.lynx.tasm.ui.image.b.f11024c;     // Catch: Throwable -> L97
        monitor-exit(com.lynx.tasm.ui.image.b.class);     // Catch: Throwable -> L97
        DrawableFactory r55 = r36.f11087j;
        UiThreadImmediateExecutorService r114 = UiThreadImmediateExecutorService.b();
        InstrumentedMemoryCache r115 = r36.f11086i.e;
        r40 = new n0(r54, r55, r114);
        goto L102
    L84:
        r38 = false;
        goto L85
    L163:
        String r56 = (String) this.f3870b;
        ((LynxTemplateRender) this.e).J((byte[]) this.f3871c, (TemplateData) this.d, r56);
        return;
    L165:
        ((LynxTemplateRender) this.e).r((TemplateBundle) this.f3871c, (TemplateData) this.d, (String) this.f3870b);
        return;
    L180:
        com.bytedance.iesgurd.loader.a r57 = (com.bytedance.iesgurd.loader.a) this.f3871c;
        String r58 = r57.f6634a;
        com.bytedance.iesgurd.d r59 = (com.bytedance.iesgurd.d) this.d;
        Long r60 = Long.valueOf(r59.f6618c);
        Pair r61 = r57.g;
        if (r61 != null) goto L183;
        Intrinsics.throwNpe();
    L183:
        JSONObject r62 = com.bytedance.android.anniex.base.service.f.f(r58, r57.f6635b, r60, "getData", r61);
        if (r62 == null) goto L333;
        com.bytedance.iesgurd.loader.a.e(r57, r62, r59.f6616a);
        r62.put("res_from", r59.f6617b.name());
        r62.put("offline_from_cdn_url", (String) this.f3870b);
        r62.put("offline_from_cdn_http_status", ((n) this.e).f7268b);
        r62.put("offline_from_cdn_duration", System.currentTimeMillis() - r57.f6637h);
        r62.put("offline_from_cdn_failed_times", r57.f6639j);
        com.lynx.tasm.utils.j.g("geckosdk_resource_access_stats", r62);
        return;
    L333:
        return;
    L187:
        Long r63 = (Long) this.d;
        if (r63 == null) goto L191;
        long r64 = r63.longValue();
    L190:
        long r65 = r64;
        Pair r66 = com.bytedance.android.anniex.base.service.f.d(r65, (String) this.f3870b, r65, (String) this.f3871c);
        JSONObject r67 = com.bytedance.android.anniex.base.service.f.f((String) this.f3870b, (String) this.f3871c, r63, (String) this.e, r66);
        if (r67 == null) goto L334;
        com.lynx.tasm.utils.j.g("geckosdk_resource_access_stats", r67);
        return;
    L334:
        return;
    L191:
        r64 = 0;
        goto L190
    L196:
        File r68 = ((com.bytedance.gkfs.io.i) this.f3870b).f4877h;
        ChunkFrom r69 = ChunkFrom.f4835c;
        com.bytedance.gkfs.io.f r70 = (com.bytedance.gkfs.io.f) this.d;
        com.bytedance.gkfs.io.c r71 = r70.f4865a;
        com.bytedance.gkfs.storage.b r72 = new com.bytedance.gkfs.storage.b(r71, com.bytedance.gkfs.io.a.f4852b, new String[0], 0);
        int r73 = (int) ((File) this.e).length();
        f8.b.d((com.bytedance.gkfs.io.n) this.f3871c, r68, r69, new com.bytedance.gkfs.io.d(r70, new com.bytedance.gkfs.storage.e(r71, (File) this.e, com.bytedance.gkfs.storage.f.f4930b, r72, 0, 0, 0, r73)));
        return;
    L198:
        com.bytedance.framwork.core.sdkmonitor.e r74 = (com.bytedance.framwork.core.sdkmonitor.e) this.e;
        Context r75 = (Context) this.f3870b;
        JSONObject r76 = (JSONObject) this.d;
        com.bytedance.framwork.core.sdkmonitor.d r77 = (com.bytedance.framwork.core.sdkmonitor.d) this.f3871c;
        if (r75 == null) goto L222;
        r74.s = true;
        r74.f4709a = r75.getApplicationContext();
        r74.f4710b = r76;
        r76.put(WsConstants.KEY_APP_ID, r74.f4726w);     // Catch: Exception -> L299
        r74.f4710b.put("os", "Android");     // Catch: Exception -> L299
        r74.f4710b.put("device_platform", "android");     // Catch: Exception -> L299
        r74.f4710b.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L299
        r74.f4710b.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L299
        r74.f4710b.put("device_model", Build.MODEL);     // Catch: Exception -> L299
        r74.f4710b.put("device_brand", Build.BRAND);     // Catch: Exception -> L299
        r74.f4710b.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L299
        r74.f4710b.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L299
        r74.f4710b.put("monitor_from", "sdk");     // Catch: Exception -> L299
        if (TextUtils.isEmpty(r74.f4710b.optString(Constant.PACKAGE_NAME)) == false) goto L205;
        r74.f4710b.put(Constant.PACKAGE_NAME, r75.getPackageName());     // Catch: Exception -> L299
    L205:
        if (TextUtils.isEmpty(r74.f4710b.optString("version_name")) == false) goto L207;
        PackageInfo r78 = r74.f4709a.getPackageManager().getPackageInfo(r74.f4709a.getPackageName(), 0);     // Catch: Exception -> L299
        r74.f4710b.put("version_name", r78.versionName);     // Catch: Exception -> L299
        PackageInfo r116 = r78;
    L209:
        if (TextUtils.isEmpty(r74.f4710b.optString("version_code")) == false) goto L213;
        if (r116 != null) goto L212;
        r116 = r74.f4709a.getPackageManager().getPackageInfo(r74.f4709a.getPackageName(), 0);     // Catch: Exception -> L299
    L212:
        r74.f4710b.put("version_code", r116.versionCode);     // Catch: Exception -> L299
    L213:
        r74.f4717m = r77;     // Catch: Exception -> L299
        Map r79 = r77.getCommonParams();     // Catch: Exception -> L299
        r74.f4718n = r79;     // Catch: Exception -> L299
        if (r79 != null) goto L216;
        r74.f4718n = new HashMap();     // Catch: Exception -> L299
    L216:
        r74.f4727x = TextUtils.equals((CharSequence) r74.f4718n.get("oversea"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Exception -> L299
        r74.f4718n.put(WsConstants.KEY_APP_ID, r74.f4726w);     // Catch: Exception -> L299
        r74.f4718n.put(WsConstants.KEY_DEVICE_ID, r74.f4710b.optString(WsConstants.KEY_DEVICE_ID));     // Catch: Exception -> L299
        r74.f4718n.put("device_platform", "android");     // Catch: Exception -> L299
        r74.f4718n.put(Constant.PACKAGE_NAME, r74.f4710b.optString(Constant.PACKAGE_NAME));     // Catch: Exception -> L299
        r74.f4718n.put(LynxMonitorService.KEY_CHANNEL, r74.f4710b.optString(LynxMonitorService.KEY_CHANNEL));     // Catch: Exception -> L299
        r74.f4718n.put("app_version", r74.f4710b.optString("app_version"));     // Catch: Exception -> L299
        r74.f4718n.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L299
        r74.f4718n.put("minor_version", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Exception -> L299
        fa.c.f16887a.put(r74.f4726w, r74);     // Catch: Exception -> L299
        ha.c.f17296a.put(r74.f4726w, r74);     // Catch: Exception -> L299
        com.bytedance.sdk.xbridge.cn.auth.g r80 = new com.bytedance.sdk.xbridge.cn.auth.g(5);     // Catch: Exception -> L299
        if (ja.c.f18300b == true) goto L220;
        ja.c.f18299a = r80;     // Catch: Exception -> L299
        ja.c.f18300b = true;     // Catch: Exception -> L299
    L220:
        ea.d r81 = new ea.d(r74.f4709a, r74.f4726w);     // Catch: Exception -> L299
        r74.f4711c = r81;     // Catch: Exception -> L299
        ia.a.f17554a.t(r81);     // Catch: Exception -> L299
        r74.f4716l = (IHttpService) og.a.a(IHttpService.class);     // Catch: Exception -> L299
        r74.o();     // Catch: Exception -> L299
        goto L222
    L207:
        r116 = null;
    L222:
        if (((com.bytedance.framwork.core.sdkmonitor.e) this.e).f4723t == false) goto L335;
        com.bytedance.framwork.core.sdkmonitor.e r82 = (com.bytedance.framwork.core.sdkmonitor.e) this.e;
        r82.f4725v.a(r82);
        return;
    L335:
        return;
    L225:
        com.bytedance.forest.preload.d r83 = Forest.access$getPreLoader$p((Forest) this.d);
        r83.getClass();
        r r84 = (r) this.e;
        u r85 = r84.f4401c;
        if (r85 == null) goto L228;
        String r117 = r85.f4428c;
    L229:
        String r118 = (String) this.f3870b;
        String r86 = (String) this.f3871c;
        PreloadType r119 = r84.d;
        if (r117 != null) goto L232;
        int r120 = 0;
        f0.h("PreLoader", 60, "preload with mainUrl is null", false);
    L241:
        PreloadType r87 = PreloadType.f4334b;
        Map r121 = r84.e;
        if (r119 != r87) goto L270;
        String[] r122 = {"css", "script"};
    L244:
        if (r120 >= 2) goto L254;
        String r88 = r122[r120];
        if (r121 == null) goto L253;
        List r89 = (List) r121.get(r88);
        if (r89 == null) goto L253;
        Iterator r123 = r89.iterator();
    L251:
        if (r123.hasNext() == false) goto L253;
        r83.b((u) r123.next(), Scene.f4352l, r118, r86, r84.f4399a, r84.f4400b);
    L253:
        r120 = r120 + 1;
        goto L244
    L254:
        if (r121 == null) goto L296;
        Set r90 = r121.entrySet();
        if (r90 == null) goto L336;
        ArrayList r91 = new ArrayList();
        Iterator r92 = r90.iterator();
    L259:
        if (r92.hasNext() == false) goto L263;
        Object r93 = r92.next();
        if (ArraysKt.contains(r122, ((Map.Entry) r93).getKey()) == true) goto L259;
        r91.add(r93);
        goto L259
    L263:
        Iterator r94 = r91.iterator();
    L265:
        if (r94.hasNext() == false) goto L338;
        Iterator r124 = ((Iterable) ((Map.Entry) r94.next()).getValue()).iterator();
    L268:
        if (r124.hasNext() == false) goto L265;
        r83.b((u) r124.next(), Scene.f4352l, r118, r86, r84.f4399a, r84.f4400b);
        goto L268
    L338:
        return;
    L336:
        return;
    L296:
        return;
    L270:
        if (r121 == null) goto L337;
        Iterator r95 = r121.entrySet().iterator();
    L273:
        if (r95.hasNext() == false) goto L339;
        Map.Entry r96 = (Map.Entry) r95.next();
        String r97 = (String) r96.getKey();
        int r98 = r97.hashCode();
        if (r98 == 3148879) goto L289;
        if (r98 == 100313435) goto L286;
        if (r98 == 112202875) goto L282;
    L291:
        Scene r99 = Scene.f4350j;
    L284:
        Scene r125 = r99;
        Iterator r126 = ((Iterable) r96.getValue()).iterator();
    L294:
        if (r126.hasNext() == false) goto L273;
        r83.b((u) r126.next(), r125, r118, r86, r84.f4399a, r84.f4400b);
        goto L294
    L282:
        if (r97.equals("video") == false) goto L291;
        r99 = Scene.f4348h;
        goto L284
    L286:
        if (r97.equals("image") == false) goto L291;
        r99 = Scene.f;
        goto L284
    L289:
        if (r97.equals("font") == false) goto L291;
        r99 = Scene.d;
        goto L284
    L339:
        return;
    L337:
        return;
    L232:
        r120 = 0;
        if (r85 != null) goto L236;
        Intrinsics.throwNpe();
    L236:
        if (r119 != PreloadType.f4334b) goto L239;
        Scene r100 = Scene.f4351k;
    L240:
        r83.b(r85, r100, r118, r86, r84.f4399a, r84.f4400b);
        goto L241
    L239:
        r100 = Scene.f4345a;
        goto L240
    L228:
        r117 = null;
        goto L229
    L297:
        i6.a.i().b(new j6.f((String) this.f3870b, (String) this.f3871c, (JSONObject) this.d, (JSONObject) this.e));
        return;
    L300:
        boolean r101 = jh.c.e.get();     // Catch: Exception -> L171
        gh.b r102 = (gh.b) this.d;
        if (r101 == true) goto L173;
        r102.accept(new com.bytedance.pia.core.bridge.methods.n(false));     // Catch: Exception -> L171
        return;
    L173:
        Keva r103 = jh.c.a((String) this.f3870b);     // Catch: Exception -> L171
        if (r103 == null) goto L176;
        r10 = jh.c.j(r103, (String) this.f3871c);     // Catch: Exception -> L171
    L176:
        r102.accept(new com.bytedance.pia.core.bridge.methods.n(r10));     // Catch: Exception -> L171
        return;
    L171:
        e = move-exception;
        ((com.bytedance.pia.core.bridge.methods.n0) this.e).accept(new PiaMethod$Error("[Cache] PIA Cache Remove Failed, reason: (" + e.getMessage() + ')'));
    }

    public e(com.bytedance.iesgurd.loader.a r5, com.bytedance.iesgurd.d r10, String r11, n r12) {
        this.f3869a = 5;
        this.f3871c = r5;
        this.d = r10;
        this.f3870b = r11;
        this.e = r12;
    }

    public e(gh.b r5, String r10, com.bytedance.pia.core.bridge.methods.n0 r11, String r12) {
        this.f3869a = 6;
        this.d = r5;
        this.f3870b = r10;
        this.e = r11;
        this.f3871c = r12;
    }

    public /* synthetic */ e(Object r5, Object r10, Object r11, Object r12, int r13, boolean r14) {
        this.f3869a = r13;
        this.e = r5;
        this.f3870b = r10;
        this.f3871c = r11;
        this.d = r12;
    }

    public /* synthetic */ e(Object r5, Object r10, Object r11, String r12, int r13) {
        this.f3869a = r13;
        this.e = r5;
        this.f3871c = r10;
        this.d = r11;
        this.f3870b = r12;
    }

    public /* synthetic */ e(Object r5, Object r10, String r11, String r12, int r13) {
        this.f3869a = r13;
        this.d = r5;
        this.e = r10;
        this.f3870b = r11;
        this.f3871c = r12;
    }

    public e(String r5, String r10, Long r11, String r12) {
        this.f3869a = 4;
        this.d = r11;
        this.f3870b = r5;
        this.f3871c = r10;
        this.e = r12;
    }

    public e(LynxTemplateRender r5, byte[] r10, String r11, TemplateData r12) {
        this.f3869a = 8;
        this.e = r5;
        this.f3871c = r10;
        this.f3870b = r11;
        this.d = r12;
    }

    public e(WeakReference r5, WeakReference r10, ReadableMap r11, String r12) {
        this.f3869a = 13;
        this.f3871c = r5;
        this.d = r10;
        this.e = r11;
        this.f3870b = r12;
    }

    public e(String r5, JSONObject r10, JSONObject r11, JSONObject r12) {
        this.f3869a = 15;
        this.f3870b = r5;
        this.d = r10;
        this.e = r11;
        this.f3871c = r12;
    }

    public e(com.bytedance.framwork.core.sdkmonitor.e r5, Context r10, JSONObject r11, com.bytedance.framwork.core.sdkmonitor.d r12) {
        this.f3869a = 2;
        this.e = r5;
        this.f3870b = r10;
        this.d = r11;
        this.f3871c = r12;
    }
}
