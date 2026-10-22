package com.lynx.tasm.behavior.ui.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.renderscript.Matrix4f;
import android.text.SpannableStringBuilder;
import android.webkit.WebView;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import c.q0;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.Gson;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.v0;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.y;
import com.obric.oui.calendar.CalendarDay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n implements z2.g, q0, com.bytedance.ies.bullet.kit.web.g, com.bytedance.ies.bullet.forest.p, y, pt.o, ng.a, tr.e, yq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10761a;

    public /* synthetic */ n(Object r5) {
        this.f10761a = r5;
    }

    public static float g(o r5, int r10, float r11) {
        if (r10 != 0) goto L10;
        k r12 = r5.f10764c;
        float r13 = k.b(r12.f10754c, r12.f10753b, r12.f10752a, r11);
        if (r5.d != 1) goto L9;
        int r14 = Math.round(r13);
    L8:
        return r14;
    L9:
        return r13;
    L10:
        if (r10 != 1) goto L16;
        k r15 = r5.f;
        float r16 = k.b(r15.f10754c, r15.f10753b, r15.f10752a, r11);
        if (r5.g != 1) goto L14;
        r14 = Math.round(r16);
        goto L8
    L14:
        return r16;
    L16:
        if (r10 != 2) goto L21;
        k r17 = r5.f10765h;
        float r18 = k.b(r17.f10754c, r17.f10753b, r17.f10752a, r11);
        if (r5.f10766i != 1) goto L20;
        r14 = Math.round(r18);
        goto L8
    L20:
        return r18;
    L21:
        return 0.0f;
    }

    public static n n(List r20, int r21, int r22) {
        int r5 = 0;
        n r10 = new n(0);
        if (r20 != null) goto L5;
    L33:
        return r10;
    L5:
        if (r20.isEmpty() == true) goto L33;
        Iterator r11 = r20.iterator();
    L9:
        if (r11.hasNext() == false) goto L33;
        o r12 = (o) r11.next();
        int r13 = r12.f10762a;
        LinkedHashMap r14 = (LinkedHashMap) r10.f10761a;
        if (r13 == 1) goto L32;
        if (r13 != 2) goto L13;
        r14.put("translateX", Float.valueOf(g(r12, r5, r21)));
        goto L9
    L13:
        float r15 = r12.e;
        float r16 = r12.f10763b;
        switch(r13) {
            case 4: goto L30;
            case 8: goto L29;
            case 16: goto L28;
            case 32: goto L27;
            case 64: goto L26;
            case 128: goto L25;
            case 256: goto L27;
            case 512: goto L24;
            case 1024: goto L23;
            case 2048: goto L22;
            case 4096: goto L21;
            case 8192: goto L20;
            case 16384: goto L19;
            case 32768: goto L17;
            case 65536: goto L17;
            default: goto L15;
        };
    L15:
        return null;
    L28:
        r5 = 0;
        goto L32
    L29:
        r5 = 0;
        r14.put("translateZ", Float.valueOf(g(r12, 0, 0.0f)));
        goto L9
    L30:
        r5 = 0;
        r14.put("translateY", Float.valueOf(g(r12, 0, r22)));
        goto L9
    L17:
        Matrix4f r17 = new Matrix4f(r12.f10767j);
        jk.a r18 = new jk.a(3);
        jk.a.h((double[]) r18.f18349a);
        jk.a.h((double[]) r18.f18350b);
        jk.a.h((double[]) r18.f18351c);
        jk.a.h((double[]) r18.d);
        jk.a.h((double[]) r18.e);
        com.lynx.tasm.utils.f.c(r(r17.getArray()), r18);
        r10.q(r18);
    L18:
        r5 = 0;
        goto L9
    L19:
        double[][] r19 = com.lynx.tasm.utils.f.f11168a;
        r14.put("skewY", Float.valueOf((float) Math.tan((float) ((((double) r16) * 3.141592653589793d) / 180.0d))));
        goto L18
    L20:
        double[][] r23 = com.lynx.tasm.utils.f.f11168a;
        r14.put("skewX", Float.valueOf((float) Math.tan((float) ((((double) r16) * 3.141592653589793d) / 180.0d))));
        goto L18
    L21:
        double[][] r24 = com.lynx.tasm.utils.f.f11168a;
        r14.put("skewX", Float.valueOf((float) Math.tan((float) ((((double) r16) * 3.141592653589793d) / 180.0d))));
        r14.put("skewY", Float.valueOf((float) Math.tan((float) ((((double) r15) * 3.141592653589793d) / 180.0d))));
        goto L18
    L22:
        r14.put("scaleY", Float.valueOf(r16));
        goto L18
    L23:
        r14.put("scaleX", Float.valueOf(r16));
        goto L18
    L24:
        r14.put("scaleX", Float.valueOf(r16));
        r14.put("scaleY", Float.valueOf(r15));
        goto L18
    L25:
        r14.put("rotateY", Float.valueOf(r16));
        goto L18
    L26:
        r14.put("rotateX", Float.valueOf(r16));
        goto L18
    L27:
        r14.put("rotate", Float.valueOf(r16));
    L32:
        r14.put("translateX", Float.valueOf(g(r12, r5, r21)));
        r14.put("translateY", Float.valueOf(g(r12, 1, r22)));
        r14.put("translateZ", Float.valueOf(g(r12, 2, 0.0f)));
        goto L9
    }

    public static double[] r(float[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        double[] r10 = new double[r5.length];
        int r11 = 0;
    L7:
        if (r11 >= r5.length) goto L9;
        r10[r11] = r5[r11];
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    @Override // com.bytedance.ies.bullet.kit.web.g
    public void a(int r5, int r10, int r11, int r12) {
        ((AnnieXLiteContainer) this.f10761a).onWebScrollChanged(r5, r10, r11, r12);
    }

    @Override // pt.o
    public Object apply(Object r5) {
        List r10 = (List) r5;
        Collections.sort(r10, (Comparator) this.f10761a);
        return r10;
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        JSONObject r10 = (JSONObject) this.f10761a;
        JSONObject r11 = r10.optJSONObject("category");
        if (r11 == null) goto L5;
        r5.f23387i = r11;
    L5:
        JSONObject r12 = r10.optJSONObject(LynxMonitorService.KEY_METRIC);
        if (r12 == null) goto L9;
        r5.f23388j = r12;
        return;
    }

    @Override // com.lynx.tasm.ui.image.y
    public void c() {
        ((FrescoImageView) this.f10761a).markDirty();
    }

    @Override // com.lynx.tasm.ui.image.y
    public void clear() {
        ((FrescoImageView) this.f10761a).setController(null);
    }

    @Override // com.lynx.tasm.ui.image.y
    public void d(LinkedList r5) {
        ((FrescoImageView) this.f10761a).onPostprocessorPreparing(r5);
    }

    @Override // com.lynx.tasm.ui.image.y
    public void e() {
        ((FrescoImageView) this.f10761a).maybeUpdateView();
    }

    public float f() {
        Float r5 = (Float) ((LinkedHashMap) this.f10761a).get("rotate");
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        return r5.floatValue();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.p
    public Pair h(String r5, boolean r10, com.bytedance.ies.bullet.core.e r11, rd.e r12) {
        return com.bytedance.ies.bullet.forest.o.b(this, r5, r10, r11, r12);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.lynx.tasm.ui.image.y
    public void i(CloseableReference r5) {
        Bitmap r10 = null;
        if (FrescoImageView.access$200((FrescoImageView) this.f10761a) == null) goto L5;
        FrescoImageView.access$200((FrescoImageView) this.f10761a).close();
        FrescoImageView.access$202((FrescoImageView) this.f10761a, null);
    L5:
        FrescoImageView.access$202((FrescoImageView) this.f10761a, r5.clone());
        if (FrescoImageView.access$500((FrescoImageView) this.f10761a) != null) goto L8;
    L27:
        ((FrescoImageView) this.f10761a).postInvalidate();
        return;
    L8:
        if (FrescoImageView.access$200((FrescoImageView) this.f10761a) == null) goto L27;
        CloseableReference r11 = FrescoImageView.access$200((FrescoImageView) this.f10761a);
        monitor-enter(r11);
        Object r12 = r11.f7671b.d();     // Catch: Throwable -> L24
        monitor-exit(r11);     // Catch: Throwable -> L24
        if ((r12 instanceof CloseableBitmap) == false) goto L17;
        r10 = ((CloseableStaticBitmap) ((CloseableBitmap) r12)).g;
    L19:
        if (r10 != null) goto L21;
    L23:
        LynxLog.b(4, "FrescoImageView", "onLocalCacheGet error bitmap is null or recycled");
        goto L27
    L21:
        if (r10.isRecycled() == true) goto L23;
        FrescoImageView.access$500((FrescoImageView) this.f10761a).d(r10.getWidth(), r10.getHeight());
        goto L27
    L17:
        if ((r12 instanceof Bitmap) == false) goto L19;
        r10 = (Bitmap) r12;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.ui.image.y
    public ImageRequestBuilder j(Uri r5) {
        return ((FrescoImageView) this.f10761a).createImageRequestBuilder(r5);
    }

    public GlobalConfigSettings k() {
        String r5 = com.bytedance.geckox.utils.d.f4794a.e((Context) this.f10761a, "gecko_settings", null);
        if (r5 != null) goto L8;
    L6:
        return null;
    L8:
        return (GlobalConfigSettings) oa.b.f20421b.f20423a.fromJson(r5, GlobalConfigSettings.class);
    }

    public SSWebView l(ContextWrapper r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.ies.bullet.service.webkit.d r11 = (com.bytedance.ies.bullet.service.webkit.d) this.f10761a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.preload.c.class, "cls");
        com.bytedance.ies.bullet.service.preload.c r12 = (com.bytedance.ies.bullet.service.preload.c) yc.a.a(com.bytedance.ies.bullet.service.preload.c.class, "default_bid");
        WebChromeClientDispatcher r13 = r11.d;
        bd.f r14 = r11.f6159c;
        if (r12 == null) goto L7;
        WebView r15 = r12.d(r10);
        if (r15 == null) goto L7;
        r11.f6158b = r15;
        r15.setWebViewClient(r14);
        r15.setWebChromeClient(r13);
    L9:
        if ((r15 instanceof SSWebView) == false) goto L11;
        SSWebView r16 = (SSWebView) r15;
    L20:
        Intrinsics.checkNotNullParameter(r16, "webView");
        r11.f6158b = r16;
        r16.setWebViewClient(r14);
        r16.setWebChromeClient(r13);
        r16.getSettings().getUserAgentString();
        return r16;
    L11:
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r17 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r17 == null) goto L16;
        xc.d r18 = (xc.d) r17.a(xc.d.class);
        if (r18 == null) goto L16;
        boolean r19 = Intrinsics.areEqual(r18.T(), Boolean.TRUE);
    L17:
        if (r19 == false) goto L19;
        r10 = new MutableContextWrapper(r10);
    L19:
        r16 = com.bytedance.android.anniex.base.service.e.b(r10);
    L16:
        r19 = false;
    L7:
        r15 = null;
        goto L9
    }

    public JavaOnlyMap m(Map r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "fields");
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();
        Object r14 = r13.getValue();
        Unit r15 = null;
        if ((r14 instanceof Map) == false) goto L8;
        Map r16 = (Map) r14;
    L9:
        if (r16 != null) goto L11;
    L15:
        if (r15 != null) goto L4;
        r5.put(r13.getKey(), r13.getValue());
        goto L4
    L11:
        if (r16.containsKey("$t") == false) goto L13;
        r5.put(r13.getKey(), p(new l9.l(r16), r16, r11));
    L14:
        r15 = Unit.INSTANCE;
        goto L15
    L13:
        r5.put(r13.getKey(), m(r16, r11));
        goto L14
    L8:
        r16 = null;
        goto L9
    L18:
        return v0.f(0, r5);
    }

    public Object o(String r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "optionStr");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Gson r12 = m4.b.f19980a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r10, "jsonStr");     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(l4.f.class, "clazz");     // Catch: Throwable -> L5
        Object r13 = Result.m124constructorimpl((l4.f) m4.b.f19980a.fromJson(r10, l4.f.class));     // Catch: Throwable -> L5
    L8:
        if (Result.m127exceptionOrNullimpl(r13) == null) goto L11;
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution_ParamExecutor", "optionStr parse failed: optionStr: " + r10, null, 12);
    L11:
        if (Result.m130isFailureimpl(r13) == false) goto L13;
        r13 = null;
    L13:
        l4.f r15 = (l4.f) r13;
        if (r15 != null) goto L18;
        return new Object();
    L18:
        if (r15.c() == null) goto L20;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.c().iterator();
    L23:
        if (r17.hasNext() == false) goto L33;
        Object r18 = r17.next();
        if ((r18 instanceof Map) == true) goto L27;
        r16.add(r18);
        goto L23
    L27:
        if ((r18 instanceof Map) == false) goto L29;
        Map r19 = (Map) r18;
    L30:
        if (r19 == null) goto L23;
        r16.add(p(new l9.l(r19), r19, r11));
        goto L23
    L29:
        r19 = null;
        goto L30
    L33:
        l4.f r20 = l4.f.b(r15, r16);
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L36
        Object r22 = kn.e.c(r20);     // Catch: Throwable -> L36
        int r23 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L36
        com.bytedance.ies.bullet.base.utils.logger.a.g("AirSolution_ParamExecutor", "CalcExecutor calc result: finalOption: " + r20 + ", result: " + r22, null, 12);     // Catch: Throwable -> L36
        Object r24 = Result.m124constructorimpl(r22);     // Catch: Throwable -> L36
    L39:
        if (Result.m127exceptionOrNullimpl(r24) == null) goto L42;
        int r25 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution_ParamExecutor", "CalcExecutor calc failure... option is " + r20, null, 12);
    L42:
        if (Result.m130isFailureimpl(r24) == false) goto L45;
        return null;
    L45:
        return r24;
    L36:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L39
    L20:
        return new Object();
    L5:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // c.q0
    public void onError(Throwable r5) {
        c.m.j("TaskUtils", "runInMainThread TaskUtils.run onError", r5);
    }

    public Object p(l9.l r10, Map r11, Map r12) {
        String r5 = (String) r10.f19575c;
        String r13 = (String) r10.d;
        if (r12 == null) goto L14;
        if (r13 != null) goto L6;
    L9:
        if (r5 == null) goto L14;
        if (r12.containsKey(r5) == false) goto L14;
        return r12.get(r5);
    L6:
        if (StringsKt.P(r13, "$.this") == false) goto L9;
        return ym.m.d(r12, r13.substring(7));
    L14:
        Object r14 = r10.e;
        if ((r14 instanceof Map) == false) goto L17;
        Map r15 = (Map) r14;
    L18:
        if (r15 == null) goto L23;
        Object r16 = m(MapsKt.mapOf(TuplesKt.to("d", r15)), r12).get("d");
        if (r16 == null) goto L23;
        r14 = r16;
    L23:
        String r17 = (String) r10.f19574b;
        if (r17 == null) goto L63;
        int r18 = r17.hashCode();
        ug.d r19 = (ug.d) this.f10761a;
        if (r18 == 109) goto L49;
        if (r18 == 112) goto L40;
        if (r18 != 3553) goto L63;
        if (r17.equals("op") == false) goto L63;
        Object r20 = o(new JSONObject(r11).toString(), r12);
        if (r20 == null) goto L61;
        return r20;
    L61:
        return r14;
    L40:
        if (r17.equals(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME) == false) goto L63;
        if (r5 != null) goto L44;
        return null;
    L44:
        Object r21 = ((ConcurrentHashMap) ((i4.a) r19.d).d).get(r5);
        if (r21 == null) goto L61;
        return r21;
    L49:
        if (r17.equals("m") == false) goto L63;
        if (r13 != null) goto L53;
        return null;
    L53:
        i4.a r22 = (i4.a) r19.d;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r13, STGroup.DICT_KEY);
        if (StringsKt.P(r13, "$.data") == false) goto L57;
        Object r23 = ym.m.d((LinkedHashMap) r22.f17502b, r13.substring(7));
    L60:
        if (r23 == null) goto L61;
        return r23;
    L57:
        if (StringsKt.P(r13, "$.globalProps") == false) goto L59;
        r23 = ym.m.d((LinkedHashMap) r22.f17503c, r13.substring(14));
        goto L60
    L59:
        r23 = ym.m.d((ConcurrentHashMap) r22.d, r13);
    L63:
        return null;
    L17:
        r15 = null;
        goto L18
    }

    public void q(jk.a r10) {
        double[] r5 = (double[]) r10.d;
        float r11 = com.lynx.tasm.utils.a.b((float) r5[0]);
        LinkedHashMap r12 = (LinkedHashMap) this.f10761a;
        r12.put("translateX", Float.valueOf(r11));
        r12.put("translateY", Float.valueOf(com.lynx.tasm.utils.a.b((float) r5[1])));
        r12.put("translateZ", Float.valueOf(com.lynx.tasm.utils.a.b((float) r5[2])));
        double[] r13 = (double[]) r10.e;
        r12.put("rotate", Float.valueOf(com.lynx.tasm.utils.a.b((float) r13[2])));
        r12.put("rotateX", Float.valueOf(com.lynx.tasm.utils.a.b((float) r13[0])));
        r12.put("rotateY", Float.valueOf(com.lynx.tasm.utils.a.b((float) r13[1])));
        double[] r14 = (double[]) r10.f18350b;
        r12.put("scaleX", Float.valueOf(com.lynx.tasm.utils.a.b((float) r14[0])));
        r12.put("scaleY", Float.valueOf(com.lynx.tasm.utils.a.b((float) r14[1])));
    }

    public float s() {
        Float r5 = (Float) ((LinkedHashMap) this.f10761a).get("rotateX");
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        return r5.floatValue();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    public float t() {
        Float r5 = (Float) ((LinkedHashMap) this.f10761a).get("rotateY");
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        return r5.floatValue();
    }

    public float u() {
        Float r5 = (Float) ((LinkedHashMap) this.f10761a).get("scaleX");
        if (r5 != null) goto L5;
        return 1.0f;
    L5:
        return r5.floatValue();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }

    public float v() {
        Float r5 = (Float) ((LinkedHashMap) this.f10761a).get("scaleY");
        if (r5 != null) goto L5;
        return 1.0f;
    L5:
        return r5.floatValue();
    }

    public float w() {
        Float r5 = (Float) ((LinkedHashMap) this.f10761a).get("translateZ");
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        return r5.floatValue();
    }

    public Matrix4f x() {
        Matrix4f r5 = new Matrix4f();
        LinkedHashMap r10 = (LinkedHashMap) this.f10761a;
        Float r11 = (Float) r10.get("translateX");
        float r12 = 0.0f;
        if (r11 == null) goto L5;
        float r13 = r11.floatValue();
    L6:
        Float r14 = (Float) r10.get("translateY");
        if (r14 == null) goto L9;
        float r15 = r14.floatValue();
    L10:
        r5.translate(r13, r15, w());
        r5.rotate(s(), 1.0f, 0.0f, 0.0f);
        r5.rotate(t(), 0.0f, 1.0f, 0.0f);
        r5.rotate(f(), 0.0f, 0.0f, 1.0f);
        r5.scale(u(), v(), 1.0f);
        Float r16 = (Float) r10.get("skewX");
        if (r16 == null) goto L13;
        float r17 = r16.floatValue();
    L14:
        Float r18 = (Float) r10.get("skewY");
        if (r18 == null) goto L17;
        r12 = r18.floatValue();
    L17:
        Matrix4f r19 = new Matrix4f();
        r19.set(0, 1, r17);
        Matrix4f r20 = new Matrix4f();
        r20.set(1, 0, r12);
        r5.multiply(r19);
        r5.multiply(r20);
        return r5;
    L13:
        r17 = 0.0f;
        goto L14
    L9:
        r15 = 0.0f;
        goto L10
    L5:
        r13 = 0.0f;
        goto L6
    }

    public n(int r5) {
        switch(r5) {
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        LinkedHashMap r10 = new LinkedHashMap();
        this.f10761a = r10;
        r10.clear();
        return;
    L5:
        this.f10761a = df.c.c();
    }

    @Override // c.q0
    public void a(Object r5) {
        ((Runnable) this.f10761a).run();
    }

    @Override // yq.b
    public CharSequence c(CalendarDay r5) {
        return new SpannableStringBuilder().append(((CharSequence[]) this.f10761a)[r5.f12167a.getMonthValue() - 1]).append(" ").append(String.valueOf(r5.f12167a.getYear()));
    }

    @Override // com.lynx.tasm.ui.image.y
    public boolean d() {
        return FrescoImageView.access$400((FrescoImageView) this.f10761a);
    }

    @Override // ng.a
    public void e(long r5) {
        ((mg.b) this.f10761a).d.put(AsyncTaskType.TIME_SENSITIVE, Long.valueOf(r5));
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public boolean hasGeckoModelInfo(rd.e r5) {
        return u8.a.j(r5);
    }

    @Override // c.q0
    public Object a() {
        return Boolean.TRUE;
    }

    @Override // com.lynx.tasm.ui.image.y
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo100a() {
        FrescoImageView r5 = (FrescoImageView) this.f10761a;
        FrescoImageView.access$600(r5, r5.getWidth(), r5.getHeight(), r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r5.getPaddingBottom());
    }

    @Override // com.lynx.tasm.ui.image.y
    public void b() {
        FrescoImageView r5 = (FrescoImageView) this.f10761a;
        FrescoImageView.access$100(r5);
        if (FrescoImageView.access$200(r5) == null) goto L6;
        FrescoImageView.access$200(r5).close();
        FrescoImageView.access$202(r5, null);
    L6:
        if (FrescoImageView.access$300(r5) == null) goto L12;
        GenericDraweeHierarchy r10 = r5.getHierarchy();
        if (r10 == null) goto L10;
        r10.a(1, null);
    L10:
        FrescoImageView.access$300(r5).close();
        FrescoImageView.access$302(r5, null);
        return;
    }

    public n(com.bytedance.ies.bullet.service.webkit.c r5) {
        Intrinsics.checkNotNullParameter(r5, "kitService");
        com.bytedance.ies.bullet.service.base.c r10 = new com.bytedance.ies.bullet.service.base.c(2);
        Intrinsics.checkNotNullParameter(r10, "config");
        this.f10761a = new com.bytedance.ies.bullet.service.webkit.d(r5, r10);
    }

    public n(ug.d r5) {
        Intrinsics.checkNotNullParameter(r5, "airSolutionContext");
        this.f10761a = r5;
    }

    public n(String r5, int r10) {
        this.f10761a = r5;
    }

    public n(CharSequence[] r5) {
        if (r5 == null) goto L11;
        if (r5.length < 12) goto L9;
        this.f10761a = r5;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }
}
