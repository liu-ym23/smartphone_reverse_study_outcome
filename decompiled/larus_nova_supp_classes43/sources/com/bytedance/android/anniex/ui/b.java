package com.bytedance.android.anniex.ui;

import android.content.Context;
import android.net.Uri;
import bolts.Task;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.q1;
import com.lynx.tasm.r1;
import com.lynx.tasm.v0;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m26.f;
import org.json.JSONObject;
import v26.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b extends r1 {
    public String b;
    public String c;
    public WeakReference<AnnieXLynxView> d;
    public Uri e;
    public WeakReference<e> f;
    public WeakReference<Forest> g;

    public void onDestroy() {
        WeakReference<e> r0 = this.f;
        e.a r1 = null;
        if (r0 == null) goto L5;
        e r10 = r0.get();
    L7:
        if ((r10 instanceof e.a) == false) goto L9;
        r1 = (e.a) r10;
    L9:
        if (r1 == null) goto L12;
        r1.onDestroy();
        return;
    L12:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public void onDataUpdated() {
        super.onDataUpdated();
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L12;
        e r1 = r0.get();
        if (r1 == null) goto L13;
        WeakReference<AnnieXLynxView> r10 = this.d;
        if (r10 == null) goto L9;
        AnnieXLynxView r11 = r10.get();
    L10:
        r1.f(r11);
        return;
    L9:
        r11 = null;
        goto L10
    L13:
        return;
    }

    public void onFirstScreen() {
        super.onFirstScreen();
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L11;
        e r1 = r0.get();
        if (r1 == null) goto L11;
        WeakReference<AnnieXLynxView> r10 = this.d;
        if (r10 == null) goto L9;
        AnnieXLynxView r11 = r10.get();
    L10:
        r1.e(r11);
        goto L11
    L9:
        r11 = null;
    L11:
        Map<String, i36.d> r12 = MonitorManager.a;
        MonitorManager.j(this.b);
    }

    public void onLoadSuccess() {
        super.onLoadSuccess();
        WeakReference<AnnieXLynxView> r0 = this.d;
        if (r0 == null) goto L7;
        AnnieXLynxView r1 = r0.get();
        if (r1 == null) goto L7;
        r1.p(this.c);
    L7:
        WeakReference<e> r10 = this.f;
        if (r10 == null) goto L16;
        e r11 = r10.get();
        if (r11 == null) goto L16;
        Uri r12 = this.e;
        WeakReference<AnnieXLynxView> r13 = this.d;
        if (r13 == null) goto L14;
        AnnieXLynxView r14 = r13.get();
    L15:
        r11.d(r12, r14);
        goto L16
    L14:
        r14 = null;
    L16:
        Map<String, i36.d> r15 = MonitorManager.a;
        MonitorManager.r(this.b);
    }

    public void onPageUpdate() {
        super.onPageUpdate();
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L12;
        e r1 = r0.get();
        if (r1 == null) goto L13;
        WeakReference<AnnieXLynxView> r10 = this.d;
        if (r10 == null) goto L9;
        AnnieXLynxView r11 = r10.get();
    L10:
        r1.c(r11);
        return;
    L9:
        r11 = null;
        goto L10
    L13:
        return;
    }

    public void onRuntimeReady() {
        super.onRuntimeReady();
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L12;
        e r1 = r0.get();
        if (r1 == null) goto L13;
        WeakReference<AnnieXLynxView> r10 = this.d;
        if (r10 == null) goto L9;
        AnnieXLynxView r11 = r10.get();
    L10:
        r1.p(r11);
        return;
    L9:
        r11 = null;
        goto L10
    L13:
        return;
    }

    public void onFirstLoadPerfReady(v0 r10) {
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L14;
        e r1 = r0.get();
        if (r1 == null) goto L15;
        WeakReference<AnnieXLynxView> r11 = this.d;
        JSONObject r12 = null;
        if (r11 == null) goto L9;
        AnnieXLynxView r13 = r11.get();
    L10:
        if (r10 == null) goto L12;
        r12 = new JSONObject();
    L12:
        r1.m(r13, r12);
        return;
    L9:
        r13 = null;
        goto L10
    L15:
        return;
    }

    public void onLoadFailed(String r10) {
        super.onLoadFailed(r10);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L12;
        e r1 = r0.get();
        if (r1 == null) goto L13;
        WeakReference<AnnieXLynxView> r11 = this.d;
        if (r11 == null) goto L9;
        AnnieXLynxView r12 = r11.get();
    L10:
        r1.b(r12, r10);
        return;
    L9:
        r12 = null;
        goto L10
    L13:
        return;
    }

    public void onLynxEvent(LynxEventDetail r1) {
        super.onLynxEvent(r1);
    }

    public void onPageStart(String r10) {
        super.onPageStart(r10);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L11;
        e r1 = r0.get();
        if (r1 == null) goto L11;
        WeakReference<AnnieXLynxView> r11 = this.d;
        if (r11 == null) goto L9;
        AnnieXLynxView r12 = r11.get();
    L10:
        r1.k(r12, r10);
        goto L11
    L9:
        r12 = null;
    L11:
        if (r10 == null) goto L13;
        this.e = UriProtector.parse(r10);
    L13:
        Map<String, i36.d> r13 = MonitorManager.a;
        MonitorManager.A(this.b);
    }

    public void onReceivedError(LynxError r10) {
        super.onReceivedError(r10);
        WeakReference<e> r0 = this.f;
        AnnieXLynxView r1 = null;
        if (r0 == null) goto L12;
        e r11 = r0.get();
        if (r11 == null) goto L12;
        WeakReference<AnnieXLynxView> r12 = this.d;
        if (r12 == null) goto L9;
        AnnieXLynxView r13 = r12.get();
    L10:
        r11.g(r13, r10);
        goto L12
    L9:
        r13 = null;
    L12:
        if (h.X() == false) goto L24;
        if (r10 == null) goto L24;
        WeakReference<AnnieXLynxView> r14 = this.d;
        if (r14 == null) goto L19;
        AnnieXLynxView r15 = r14.get();
        if (r15 == null) goto L19;
        d1 r16 = r15.getResourceInfo$anniex_release();
    L21:
        if (r10.getErrorCode() != 102) goto L24;
        if (r16 == null) goto L24;
        Task.call(new a(r16, this), Task.BACKGROUND_EXECUTOR);
    L19:
        r16 = null;
    L24:
        if (r10 == null) goto L28;
        boolean r17 = true;
        if (r10.isFatal() != true) goto L28;
    L29:
        if (r17 == true) goto L31;
        return;
    L31:
        if (this.e == null) goto L59;
        WeakReference<e> r18 = this.f;
        if (r18 == null) goto L37;
        e r19 = r18.get();
        if (r19 == null) goto L37;
        Uri r20 = this.e;
        Intrinsics.checkNotNull(r20);
        r19.onLoadFail(r20, new Throwable(r10.toString()));
    L37:
        WeakReference<e> r21 = this.f;
        if (r21 == null) goto L40;
        e r22 = r21.get();
    L42:
        if ((r22 instanceof e.a) == false) goto L44;
        e.a r23 = (e.a) r22;
    L45:
        if (r23 == null) goto L50;
        WeakReference<AnnieXLynxView> r24 = this.d;
        if (r24 == null) goto L49;
        AnnieXLynxView r25 = r24.get();
    L49:
        r10.getErrorCode();
        r23.s(r10.getMsg());
    L50:
        Map<String, i36.d> r26 = MonitorManager.a;
        String r27 = this.c;
        String r28 = this.b;
        AbsBulletMonitorCallback.ErrStage r29 = AbsBulletMonitorCallback.ErrStage.Engine;
        String r30 = r10.getMsg();
        if (r30 != null) goto L53;
        r30 = "";
    L53:
        WeakReference<AnnieXLynxView> r31 = this.d;
        if (r31 == null) goto L56;
        r1 = r31.get();
    L56:
        MonitorManager.p(r27, r28, r29, r30, r1);
        return;
    L44:
        r23 = null;
        goto L45
    L40:
        r22 = null;
        goto L42
    L59:
        return;
    L28:
        r17 = false;
        goto L29
    }

    public void onScrollStart(q1.b r10) {
        super.onScrollStart(r10);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L8;
        e r1 = r0.get();
        if (r1 == null) goto L9;
        r1.o(r10);
        return;
    L9:
        return;
    }

    public void onScrollStop(q1.b r10) {
        super.onScrollStop(r10);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L8;
        e r1 = r0.get();
        if (r1 == null) goto L9;
        r1.o(r10);
        return;
    L9:
        return;
    }

    public void onTemplateBundleReady(TemplateBundle r10) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L8;
        e r1 = r0.get();
        if (r1 == null) goto L9;
        r1.a(r10);
        return;
    L9:
        return;
    }

    public void onTimingSetup(Map<String, Object> r10) {
        super.onTimingSetup(r10);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L7;
        e r1 = r0.get();
        if (r1 == null) goto L7;
        r1.onTimingSetup(r10);
    L7:
        Map<String, i36.d> r11 = MonitorManager.a;
        String r12 = this.b;
        WeakReference<AnnieXLynxView> r13 = this.d;
        if (r13 == null) goto L12;
        AnnieXLynxView r14 = r13.get();
        if (r14 == null) goto L12;
        LynxDevtool r15 = r14.D();
    L13:
        MonitorManager.L(r12, r10, r15);
        return;
    L12:
        r15 = null;
        goto L13
    }

    public void onUpdatePerfReady(v0 r10) {
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L14;
        e r1 = r0.get();
        if (r1 == null) goto L15;
        WeakReference<AnnieXLynxView> r11 = this.d;
        JSONObject r12 = null;
        if (r11 == null) goto L9;
        AnnieXLynxView r13 = r11.get();
    L10:
        if (r10 == null) goto L12;
        r12 = new JSONObject();
    L12:
        r1.j(r13, r12);
        return;
    L9:
        r13 = null;
        goto L10
    L15:
        return;
    }

    public final String shouldRedirectImageUrl(String r17) {
        WeakReference<e> r1 = this.f;
        if (r1 == null) goto L9;
        e r10 = r1.get();
        if (r10 == null) goto L9;
        String r11 = r10.shouldRedirectImageUrl(r17);
        if (r11 == null) goto L9;
        return r11;
    L9:
        Uri r12 = UriProtector.parse(r17);
        long r13 = System.currentTimeMillis();
        int r14 = f.a;
        StringBuilder r15 = new StringBuilder("redirectWithPipeline URL:");
        r15.append(r17);
        r15.append(",defaultCache:");
        boolean r16 = RedirectManager.a;
        r15.append(RedirectManager.b);
        f.c(r15.toString());
        boolean r18 = false;
        if (r17 != null) goto L12;
    L15:
        boolean r19 = true;
    L17:
        if (r19 == false) goto L19;
    L87:
        String r20 = r17;
    L88:
        if (r20 != null) goto L90;
    L95:
        if (r17 != null) goto L97;
    L98:
        r18 = true;
    L99:
        if (r18 == true) goto L114;
        List r21 = CollectionsKt.listOf(new String[]{"http", "https", "file", "content", "res", "data"});
        String r22 = r12.getScheme();
        if (r22 != null) goto L104;
        r22 = "";
    L104:
        if (r21.contains(r22) == true) goto L115;
        if (Intrinsics.areEqual(r12.getScheme(), "bundle") == true) goto L113;
        if (Intrinsics.areEqual(r12.getScheme(), "relative") == false) goto L115;
    L113:
        return r12.getPath();
    L115:
        return r17;
    L114:
        return null;
    L97:
        if (r17.length() != 0) goto L99;
    L90:
        if ((!equals(r17)) == true) goto L93;
        r20 = null;
    L93:
        if (r20 == null) goto L95;
        return r20;
    L19:
        if (StringsKt.startsWith$default(r17, "file://", false, 2, null) == true) goto L87;
        if (StringsKt.startsWith$default(r17, "data:", false, 2, null) == true) goto L87;
        r20 = RedirectManager.a(r17);
        if (r20 == null) goto L27;
        RedirectManager.c(this.c, r17, r20, true, System.currentTimeMillis() - r13);
        goto L88
    L27:
        if (StringsKt.startsWith$default(r17, "base64:", false, 2, null) == true) goto L70;
        WeakReference<Forest> r23 = this.g;
        if (r23 == null) goto L33;
        Forest r24 = r23.get();
        if (r24 == null) goto L33;
        String r25 = r24.getTag();
    L35:
        if (Intrinsics.areEqual(r25, "miniapp") == false) goto L45;
        String r26 = UriProtector.parse(r17).getScheme();
        if (r26 != null) goto L39;
    L42:
        boolean r27 = true;
    L43:
        if (r27 == false) goto L87;
        r20 = "anniexForMiniApp:///".concat(r17);
        goto L88
    L39:
        if (r26.length() == 0) goto L42;
        r27 = false;
        goto L43
    L45:
        com.bytedance.ies.bullet.forest.f r28 = ForestLoader.a;
        WeakReference<Forest> r29 = this.g;
        if (r29 == null) goto L49;
        Forest r30 = r29.get();
        if (r30 == null) goto L49;
    L50:
        Scene r31 = Scene.LYNX_IMAGE;
        String r32 = this.b;
        l r33 = new l();
        r33.b(this.c);
        Unit r34 = Unit.INSTANCE;
        Response r35 = ForestLoader.h(r30, r17, null, r31, r32, r33, AnnieXDefaultLynxViewClient$redirectWithPipeline$3.INSTANCE, 4);
        if (r35 == null) goto L70;
        String r36 = r35.t;
        if (r36 != null) goto L55;
    L69:
        String r37 = null;
    L71:
        if (r37 != null) goto L73;
    L76:
        boolean r38 = true;
    L77:
        if (r38 == false) goto L79;
    L80:
        GeckoXAdapter.Companion r39 = GeckoXAdapter.Companion;
        if (r39.isCDNMultiVersionResource(r17) == false) goto L83;
        r37 = r39.addCommonParamsForCDNMultiVersionURL(r17);
    L83:
        r20 = r37;
        if (RedirectManager.b == false) goto L86;
        f.c("redirectWithPipeline putRedirectPath URL:" + r17 + ",redirectUrl:" + r20);
        RedirectManager.b(r17, r20);
    L86:
        RedirectManager.c(this.c, r17, r20, false, System.currentTimeMillis() - r13);
        goto L88
    L79:
        if (Intrinsics.areEqual(r37, r17) == false) goto L83;
    L73:
        if (r37.length() == 0) goto L76;
        r38 = false;
        goto L77
    L55:
        if ((!StringsKt.isBlank(r36)) == true) goto L58;
        r36 = null;
    L58:
        if (r36 == null) goto L69;
        ResourceFrom2 r40 = r35.v;
        if (r40 == ResourceFrom2.MEMORY) goto L62;
        boolean r41 = true;
    L63:
        if (r41 == true) goto L66;
        r40 = null;
    L66:
        if (r40 != null) goto L68;
        r40 = r35.x;
    L68:
        r37 = RedirectManager.f(r36, r40);
        goto L71
    L62:
        r41 = false;
    L49:
        r30 = ForestLoader.d();
    L33:
        r25 = null;
    L70:
        r37 = r17;
        goto L71
    L12:
        if (r17.length() == 0) goto L15;
        r19 = false;
        goto L17
    }

    public void onReceivedError(String r10) {
        super.onReceivedError(r10);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L12;
        e r1 = r0.get();
        if (r1 == null) goto L13;
        WeakReference<AnnieXLynxView> r11 = this.d;
        if (r11 == null) goto L9;
        AnnieXLynxView r12 = r11.get();
    L10:
        r1.q(r12, r10);
        return;
    L9:
        r12 = null;
        goto L10
    L13:
        return;
    }

    public b(AnnieXLynxView r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "bid");
        this.b = r11;
        this.c = r12;
        if (r10 == null) goto L5;
        WeakReference<AnnieXLynxView> r13 = new WeakReference(r10);
    L6:
        this.d = r13;
        return;
    L5:
        r13 = null;
        goto L6
    }

    public void onModuleMethodInvoked(String r10, String r11, int r12) {
        super.onModuleMethodInvoked(r10, r11, r12);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L8;
        e r1 = r0.get();
        if (r1 == null) goto L9;
        r1.onModuleMethodInvoked(r10, r11, r12);
        return;
    L9:
        return;
    }

    public void onTimingUpdate(Map<String, Object> r10, Map<String, Long> r11, String r12) {
        super.onTimingUpdate(r10, r11, r12);
        WeakReference<e> r0 = this.f;
        if (r0 == null) goto L7;
        e r1 = r0.get();
        if (r1 == null) goto L7;
        r1.onTimingUpdate(r10, r11, r12);
    L7:
        Map<String, i36.d> r13 = MonitorManager.a;
        MonitorManager.M(this.b, r10, r11, r12);
    }

    public void loadImage(Context r10, String r11, String r12, float r13, float r14, Transformer r15, m.a r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "handler");
        super.loadImage(r10, r11, r12, r13, r14, r15, r16);
        WeakReference<e> r1 = this.f;
        if (r1 == null) goto L8;
        e r17 = r1.get();
        if (r17 == null) goto L9;
        r17.loadImage(r10, r11, r12, r13, r14, r15, r16);
        return;
    L9:
        return;
    }
}
