package com.bytedance.android.anniex.scene.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.t;
import com.bytedance.forest.model.w;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.bytedance.forest.utils.l;
import com.bytedance.forest.utils.o;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.n;
import com.bytedance.geckox.p;
import com.bytedance.gkfs.io.ChunkFrom;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.ies.bullet.service.monitor.standard.ContainerStandardMonitor;
import com.bytedance.iesgurd.IESGurdResFrom;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.api.bridge.PiaMethod$InvalidParamsError;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.utils.m;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.gson.JsonObject;
import com.lynx.component.svg.SvgImageView;
import com.lynx.component.svg.UISvg;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.ui.image.a0;
import com.lynx.tasm.ui.image.r;
import com.lynx.tasm.ui.image.u;
import com.obric.common.oea.style.scene.alpha.AlphaView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.oui.orecyclerview.widget.f0;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3399c;
    public final Object d;

    public /* synthetic */ i(int r5, String r10, Object r11, String r12) {
        this.f3397a = r5;
        this.f3398b = r10;
        this.f3399c = r12;
        this.d = r11;
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = true;
        long r10 = 0;
        String r11 = "";
        com.bytedance.forest.model.i r12 = null;
        switch(this.f3397a) {
            case 0: goto L190;
            case 1: goto L188;
            case 2: goto L186;
            case 3: goto L181;
            case 4: goto L179;
            case 5: goto L170;
            case 6: goto L142;
            case 7: goto L137;
            case 8: goto L130;
            case 9: goto L198;
            case 10: goto L196;
            case 11: goto L116;
            case 12: goto L114;
            case 13: goto L112;
            case 14: goto L99;
            case 15: goto L90;
            case 16: goto L88;
            case 17: goto L75;
            case 18: goto L57;
            case 19: goto L53;
            case 20: goto L36;
            case 21: goto L34;
            case 22: goto L32;
            case 23: goto L28;
            case 24: goto L6;
            default: goto L4;
        };
    L4:
        Fresco.a().e().a((ImageRequest) this.d, null, ImageRequest.RequestLevel.f8431b, null).a((zf.b) this.f3398b, ((zf.h) this.f3399c).e);
        return;
    L6:
        StringBuilder r13 = new StringBuilder("[SnapShot] pia.removeSnapshot called (Query: ");
        yh.b r14 = (yh.b) this.d;
        r13.append(r14.a());
        r13.append(", URL: ");
        r13.append(r14.c());
        r13.append(", SDK: ");
        r13.append(r14.b());
        r13.append(')');
        com.bytedance.pia.core.utils.j.q(r13.toString(), null);
        Number r15 = r14.b();
        if (r15 == null) goto L9;
        r15.intValue();
    L9:
        String r16 = r14.c();
        JsonObject r17 = r14.a();
        if (r17 == null) goto L13;
        String r18 = r17.toString();
        if (r18 == null) goto L13;
    L14:
        n0 r19 = (n0) this.f3398b;
        if (r16 != null) goto L17;
        r19.accept(new PiaMethod$InvalidParamsError());
        return;
    L17:
        JSONObject r20 = (JSONObject) com.bytedance.pia.core.utils.i.b(r18);
        if (r20 != null) goto L20;
        td.b.c("", r19);
        return;
    L20:
        AtomicBoolean r21 = xh.b.f23150a;
        Intrinsics.checkNotNullParameter(r20, "query");
        Intrinsics.checkNotNullParameter(r16, "url");
        com.bytedance.pia.core.utils.j.y("[SnapShot] Remove a snapshot (URL: " + r16 + ", Query: " + r20 + ')', null);
        ((Handler) m.f7156b.getValue()).post(xh.a.f23148c);
        Keva r22 = zh.b.f23447a;
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r20, "query");
        String r23 = com.bytedance.pia.core.utils.j.u(Uri.parse(r16));
        ArrayList r24 = new ArrayList();
        if (r20.length() <= 0) goto L26;
        Iterator<String> r25 = r20.keys();
    L24:
        if (r25.hasNext() == false) goto L26;
        r24.add(r25.next());
    L26:
        CollectionsKt.sort(r24);
        ((gh.b) this.f3399c).accept(new yh.c(zh.b.d(r23, r24, r20)));
        return;
    L13:
        r18 = "";
        goto L14
    L28:
        zm.c r26 = ((PlayerController) this.d).f;
        if (r26 == null) goto L218;
        f0 r27 = (f0) this.f3398b;
        int r28 = r27.f13809a;
        int r29 = r27.f13810b;
        Intrinsics.checkNotNullParameter((ScaleType) this.f3399c, "scaleType");
        ((AlphaView) r26.f23470b).getListener();
        return;
    L218:
        return;
    L32:
        i6.a.i().b(new j6.f((String) this.f3398b, (String) this.f3399c, (JSONObject) this.d, null));
        return;
    L34:
        UISvg r30 = (UISvg) this.f3399c;
        ((SvgImageView) UISvg.n(r30)).setImageDrawable((lm.b) this.d);
        r30.invalidate();
        UISvg.k(r30, (com.lynx.component.svg.parser.n0) this.f3398b);
        return;
    L36:
        hf.g r31 = (hf.g) this.d;
        String r32 = (String) this.f3398b;
        PrepareMeta r33 = (PrepareMeta) this.f3399c;
        RuntimeException r34 = new RuntimeException(r32);     // Catch: Throwable -> L40
        pa.a r35 = r31.d;     // Catch: Throwable -> L40
        if (r35 == null) goto L42;
        r33.getPack();     // Catch: Throwable -> L40
        r35.f(r33.getPack(), r34);     // Catch: Throwable -> L40
        r33.getChannel();     // Catch: Throwable -> L40
    L42:
        Iterator r36 = pa.b.f21323a.iterator();     // Catch: Throwable -> L40
    L43:
        if (r36.hasNext() == false) goto L48;
        ((pa.a) r36.next()).f(r33.getPack(), r34);     // Catch: Throwable -> L40
        r33.getChannel();     // Catch: Throwable -> L40
    L48:
        n r37 = r31.f;
        String r38 = r33.getChannel();
        if (r32 == null) goto L51;
        r11 = r32;
    L51:
        r37.b(r38, r11);
        return;
    L40:
        th = move-exception;
        GeckoLogger.b("onEventUpdateFailed exception: " + th.getMessage());
        goto L48
    L53:
        ArrayList r39 = p.f4771a;
        if (p.c((String) this.f3398b, (String) this.f3399c) == false) goto L219;
        String[] r40 = com.bytedance.gkfs.a.f4810a;
        com.bytedance.gkfs.a.e(((PrepareMeta) ((mn.i) this.d).f20153a).getDestDir());
        return;
    L219:
        return;
    L57:
        k6.a r41 = (k6.a) this.d;
        h.f r42 = (h.f) r41.f18623a;
        h.f r43 = (h.f) ((dd.b) this.f3398b).a((h.f) this.f3399c);     // Catch: Exception -> L65 CancellationException -> L70
        if (r43 == null) goto L61;
        r43.a(new dd.b(this, 2));     // Catch: Exception -> L65 CancellationException -> L70
        return;
    L61:
        if (r42.d(null) == false) goto L64;
        return;
    L64:
        throw new IllegalStateException("Cannot set the result of a completed task.");     // Catch: Exception -> L65 CancellationException -> L70
    L65:
        e = move-exception;
        r41.h(e);
        return;
    L71:
        if (r42.g() == false) goto L74;
        return;
    L74:
        throw new IllegalStateException("Cannot cancel a completed task.");
    L75:
        k6.a r44 = (k6.a) this.d;
    L81:
        e = move-exception;
        r44.h(e);
        return;
    L77:
        if (((h.f) r44.f18623a).d(((h.d) this.f3398b).a((h.f) this.f3399c)) == false) goto L80;
        return;
    L80:
        throw new IllegalStateException("Cannot set the result of a completed task.");     // Catch: Exception -> L81 CancellationException -> L83
    L84:
        if (((h.f) r44.f18623a).g() == false) goto L87;
        return;
    L87:
        throw new IllegalStateException("Cannot cancel a completed task.");
    L88:
        WsChannelMultiProcessSharedProvider r45 = (WsChannelMultiProcessSharedProvider) this.d;
        r45.getContext().getContentResolver().notifyChange(WsChannelMultiProcessSharedProvider.b(r45.getContext(), (String) this.f3398b, (String) this.f3399c), null);
        return;
    L90:
        View r46 = (View) this.f3398b;
        if (r46 == null) goto L225;
        HeaderBehavior r47 = (HeaderBehavior) this.f3399c;
        if (r47.d == null) goto L226;
        Log.i("djd ", "FlingRunnable: " + r46.getClass().getName() + "  scroller.getCurrY：" + r47.d.getCurrY());
        boolean r48 = r47.d.computeScrollOffset();
        CoordinatorLayout r49 = (CoordinatorLayout) this.d;
        if (r48 == false) goto L97;
        r47.setHeaderTopBottomOffset(r49, r46, r47.d.getCurrY());
        ViewCompat.postOnAnimation(r46, this);
        return;
    L97:
        r47.onFlingFinished(r49, r46);
        return;
    L226:
        return;
    L225:
        return;
    L99:
        u r50 = (u) this.d;
        if (r50.f11107c == false) goto L106;
        if (TextUtils.equals(r50.f11105a, r50.f.f11017u) == false) goto L104;
        r50.f.r((String) this.f3398b);
        goto L106
    L104:
        StringBuilder r51 = new StringBuilder("image redirect check failed curUrl = ");
        r51.append(r50.f.f11017u);
        r51.append(" preUrl = ");
        com.lynx.tasm.behavior.ui.utils.e.i(r51, r50.f11105a, 3, "Lynx-Image");
    L106:
        if (r50.e == false) goto L108;
        Bitmap.Config r52 = a0.l0;
        r50.f.l((String) this.f3399c);
    L108:
        r r53 = r50.f.f11021y;
        if (r53 == null) goto L228;
        r53.a();
        return;
    L228:
        return;
    L112:
        LynxBaseUI.access$100((LynxBaseUI) this.f3399c, (ReadableMap) this.d, (Callback) this.f3398b);
        return;
    L114:
        ((com.bytedance.sdk.xbridge.cn.platform.web.e) this.d).i((String) this.f3398b, (com.bytedance.pia.core.utils.n) this.f3399c);
        return;
    L116:
        com.bytedance.iesgurd.d r54 = (com.bytedance.iesgurd.d) this.f3399c;
        if (r54.f6617b != IESGurdResFrom.f6588b) goto L119;
        r10 = r54.f6618c;
    L119:
        com.bytedance.iesgurd.loader.a r55 = (com.bytedance.iesgurd.loader.a) this.d;
        String r56 = r55.f6634a;
        String r110 = r55.f6635b;
        Pair r57 = com.bytedance.android.anniex.base.service.f.d(r54.f6618c, r56, r10, r110);
        JSONObject r58 = com.bytedance.android.anniex.base.service.f.f(r55.f6634a, r55.f6635b, Long.valueOf(r54.f6618c), (String) this.f3398b, r57);
        if (r58 == null) goto L229;
        com.bytedance.iesgurd.loader.a.e(r55, r58, r54.f6616a);
        r58.put("res_from", r54.f6617b.name());
        if (r54.f6617b != IESGurdResFrom.f6589c) goto L124;
        r58.put("offline_from_cdn_url", r54.d);
    L124:
        com.lynx.tasm.utils.j.g("geckosdk_resource_access_stats", r58);
        return;
    L229:
        return;
    L130:
        com.bytedance.ies.bullet.pool.d r59 = (com.bytedance.ies.bullet.pool.d) this.d;
        Uri r60 = (Uri) this.f3399c;
        String r61 = (String) this.f3398b;
        Intrinsics.checkNotNullParameter(r60, "originSchema");
        Intrinsics.checkNotNullParameter(r61, "cacheKey");
        Intrinsics.checkNotNullParameter("timeout", "reason");
        com.bytedance.ies.bullet.pool.impl.a r62 = r59.f5806b;
        r62.getClass();
        Intrinsics.checkNotNullParameter(r61, "uniqueSchema");
        if (r62.f5817a.f(r61) == false) goto L133;
        com.bytedance.ies.bullet.service.base.f r63 = new com.bytedance.ies.bullet.service.base.f(r60, r60, CacheType.f5917b);
        int r64 = ((com.bytedance.forest.utils.m) r59.f5806b.f5817a.f22361b).size();
        int r65 = ((com.bytedance.android.monitorV2.k) ((w8.f) r59.f5807c.f22857a).f22816a).size();
        JSONObject r66 = new JSONObject();
        r66.put("prerender_pool_size", String.valueOf(r64));
        r66.put("prerender_pool_max_size", String.valueOf(3));
        r66.put("reuse_pool_size", String.valueOf(r65));
        r66.put("reuse_pool_max_size", String.valueOf(3));
        r66.put("reason", "timeout");
        Unit r67 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r63, "event");
        Intrinsics.checkNotNullParameter(r66, "extraInfo");
    L133:
        Uri r68 = (Uri) this.f3399c;
        int r69 = ((com.bytedance.forest.utils.m) ((com.bytedance.ies.bullet.pool.d) this.d).f5806b.f5817a.f22361b).size();
        String r70 = ((com.bytedance.ies.bullet.pool.d) this.d).f5805a;
        Intrinsics.checkNotNullParameter(r68, "schema");
        Intrinsics.checkNotNullParameter("timer", "reason");
        Intrinsics.checkNotNullParameter(r70, "bid");
        x r71 = new x("bdx_monitor_xpool_clear_view");
        r71.f6027j = new ad.a(r68);
        JSONObject r72 = new JSONObject();
        r72.put("reason", "timer");
        r72.put("max_count", 3);
        r72.put("remaining_count", 3 - r69);
        r71.e = r72;
        tc.c r73 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.base.i r74 = (com.bytedance.ies.bullet.service.base.i) tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.i.class, r70);
        if (r74 == null) goto L232;
        ((com.bytedance.ies.bullet.service.monitor.i) r74).d(r71);
        return;
    L232:
        return;
    L137:
        com.bytedance.gkfs.io.i r75 = (com.bytedance.gkfs.io.i) this.d;
        Pair r76 = (Pair) r75.e.d.get((com.bytedance.gkfs.io.c) this.f3398b);
        if (r76 == null) goto L140;
        r10 = ((Number) r76.getSecond()).longValue() - ((Number) r76.getFirst()).longValue();
    L140:
        long r111 = r10;
        com.bytedance.gkfs.io.n r77 = com.bytedance.gkfs.io.n.d;
        ChunkFrom r78 = r75.f4876c;
        com.bytedance.gkfs.io.b r79 = (com.bytedance.gkfs.io.b) this.f3399c;
        com.bytedance.gkfs.io.f r112 = r79.f4856c;
        com.bytedance.gkfs.storage.e r80 = r79.e;
        f8.b.d(r77, r75.f4877h, r78, new com.bytedance.gkfs.io.d(r112, new com.bytedance.gkfs.storage.e(r80.f4925b, r80.f4926c, r80.d, r80.e, r80.f, r111, r111, r80.f4928i)));
        return;
    L142:
        ConcurrentHashMap r81 = o.f4654a;
        com.bytedance.forest.model.i r82 = (com.bytedance.forest.model.i) ((com.bytedance.forest.model.j) this.d).f4377a.f4376a.get();
        if (r82 == null) goto L146;
        r12 = r82;
    L146:
        com.bytedance.forest.model.o r83 = (com.bytedance.forest.model.o) r12;
        ArrayList r84 = new ArrayList();
    L147:
        if (r83 == null) goto L154;
        if (r83.d() == false) goto L153;
        if (StringsKt.isBlank(r83.e()) == true) goto L153;
        r84.add(r83);
    L153:
        r83 = r83.f();
        goto L147
    L154:
        StringBuilder r85 = new StringBuilder();
        CollectionsKt.sortedWith(r84, new ca.d(6));
        Iterator r86 = r84.iterator();
    L156:
        if (r86.hasNext() == false) goto L161;
        com.bytedance.forest.model.o r87 = (com.bytedance.forest.model.o) r86.next();
        if (r5 == true) goto L160;
        r85.append(',');
    L160:
        r85.append(r87.e());
        r5 = false;
        goto L156
    L161:
        String r88 = r85.toString();
        com.bytedance.forest.utils.d.b((com.bytedance.forest.utils.d) this.f3399c, 4, "ResponseCacheManager", td.d.b("write back ", r88), false, null, null, 56);
        boolean r89 = StringsKt.isBlank(r88);
        String r90 = (String) this.f3398b;
        if (r89 == false) goto L166;
        Keva r91 = l.f4649a;
        if (r91 == null) goto L233;
        r91.erase(r90);
        return;
    L233:
        return;
    L166:
        Keva r92 = l.f4649a;
        if (r92 == null) goto L235;
        r92.storeStringJustDisk(r90, r88);
        return;
    L235:
        return;
    L170:
        com.bytedance.forest.postprocessor.f r93 = (com.bytedance.forest.postprocessor.f) this.f3398b;
        ForestPostProcessor r94 = (ForestPostProcessor) this.d;
        ProcessedData r95 = r94.onProcess(r93);     // Catch: Throwable -> L174
        r95.setContext$forest_release(r94.getContext());     // Catch: Throwable -> L174
        r94.onPostProcess$forest_release(r93);
        ((Function1) this.f3399c).invoke(r95);
        return;
    L174:
        th = move-exception;
        throw th;     // Catch: Throwable -> L176
    L176:
        th = move-exception;
        r94.onPostProcess$forest_release(r93);
        throw th;
    L179:
        com.bytedance.forest.utils.e r96 = (com.bytedance.forest.utils.e) this.d;
        r96.b(new String[]{"res_callback_switch_thread_finish", "res_load_finish", "callback_execute_start"});
        ((Function1) this.f3398b).invoke((w) this.f3399c);
        r96.b(new String[]{"callback_execute_finish"});
        return;
    L181:
        com.bytedance.forest.preload.d r97 = Forest.access$getPreLoader$p((Forest) this.d);
        String r98 = (String) this.f3398b;
        if (r98 == null) goto L184;
        r11 = r98;
    L184:
        r97.d(r11, (t) this.f3399c);
        return;
    L186:
        h7.a.b(new j7.a((String) this.f3398b, 0, ApmAgent.access$000((JSONObject) this.d, true), null, null, ApmAgent.access$000((JSONObject) this.f3399c, false)));
        return;
    L188:
        LynxError r99 = new LynxError(10203, "Error occurred while fetching app bundle resource", "", "error");
        r99.f10000o = (String) this.f3398b;
        r99.g = null;
        r99.f9999n = (String) this.f3399c;
        ((AnnieXLynxView) this.d).getClass();
        return;
    L190:
        ((LruCache) ((j) this.d).f3406j.getValue()).put((String) this.f3398b, (String) this.f3399c);
        return;
    L196:
        ContainerStandardMonitor.INSTANCE.collect((String) this.f3398b, (String) this.f3399c, this.d);     // Catch: Throwable -> L192
        return;
    L230:
        return;
    L198:
        ContainerStandardMonitor.INSTANCE.attach((String) this.f3398b, (View) this.d, (String) this.f3399c);     // Catch: Throwable -> L193
        return;
    }

    public /* synthetic */ i(Object r5, int r10, Object r11, Object r12) {
        this.f3397a = r10;
        this.d = r5;
        this.f3398b = r11;
        this.f3399c = r12;
    }

    public /* synthetic */ i(Object r5, Object r10, Object r11, int r12, boolean r13) {
        this.f3397a = r12;
        this.f3399c = r5;
        this.d = r10;
        this.f3398b = r11;
    }

    public /* synthetic */ i(Object r5, Object r10, String r11, int r12) {
        this.f3397a = r12;
        this.d = r5;
        this.f3399c = r10;
        this.f3398b = r11;
    }

    public /* synthetic */ i(String r5, Object r10, Object r11, int r12) {
        this.f3397a = r12;
        this.f3398b = r5;
        this.d = r10;
        this.f3399c = r11;
    }
}
