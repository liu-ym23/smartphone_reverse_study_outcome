package com.bytedance.ies.bullet.lynx.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.salamander.anniex.n;
import com.google.common.reflect.w;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.j;
import com.lynx.tasm.n0;
import com.lynx.tasm.o0;
import com.lynx.tasm.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ym.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f5647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f5648b;

    public a(e r5) {
        this.f5648b = r5;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public final void loadImage(Context r13, String r14, String r15, float r16, float r17, Transformer r18, final j r19) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r19, "handler");
        ArrayList r5 = null;
        e r10 = this.f5648b;
        if (r15 == null) goto L23;
        if (h.d() == null) goto L23;
        com.bytedance.ies.bullet.core.e r11 = r10.f;
        if (r11 == null) goto L10;
        String r12 = r11.f;
        if (r12 == null) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r15, "url");
        if (StringsKt.P(r15, "file") == true) goto L39;
    L21:
        oc.b.d.b(r15);
        oc.d.d.b(r15);
        com.bytedance.ies.bullet.base.utils.b.m("错过内存缓存 image，".concat(r15));
        com.bytedance.ies.bullet.preloadv2.e.e(r12, r15, "image");
        goto L23
    L39:
    L17:
        e = move-exception;
        String r20 = androidx.room.jarjarred.org.antlr.runtime.a.o(e, new StringBuilder("getCacheImage，File Check Failed "));
        if (r20 == null) goto L23;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPreload", r20, null, 12);
        goto L23
    L14:
        if (new File(Uri.parse(r15).getPath()).exists() == true) goto L21;
        com.bytedance.ies.bullet.base.utils.b.m("getCacheImage，文件不存在, 清理缓存，".concat(r15));     // Catch: Exception -> L17
        oc.b.d.d(r15);     // Catch: Exception -> L17
        oc.d.d.d(r15);     // Catch: Exception -> L17
    L10:
        r12 = "default_bid";
    L23:
        if (r10.d() == null) goto L41;
        f r21 = r10.d();
        if (r21 == null) goto L31;
        ArrayList r22 = r21.f5665h;
        if (r22 == null) goto L31;
        if (r22.isEmpty() != true) goto L31;
        return;
    L31:
        com.bytedance.ies.bullet.lynx.h r23 = r10.f5656b;
        f r24 = r10.d();
        if (r24 == null) goto L34;
        r5 = r24.f5665h;
    L34:
        ArrayList r110 = r5;
        Intrinsics.checkNotNull(r110);
        com.bytedance.ies.bullet.lynx.a r25 = new com.bytedance.ies.bullet.lynx.a(r23, r110);
        com.bytedance.ies.bullet.lynx.b r111 = new com.bytedance.ies.bullet.lynx.b(r13, r14, r15, r16, r17, r18);
        Function1<Object, Unit> r26 = new DefaultLynxDelegate$createLynxClientDelegate$1$loadImage$2(r19);
        Function1<Throwable, Unit> r27 = new DefaultLynxDelegate$createLynxClientDelegate$1$loadImage$3(r19);
        Intrinsics.checkNotNullParameter(r111, "input");
        Intrinsics.checkNotNullParameter(r26, "resolve");
        Intrinsics.checkNotNullParameter(r27, "reject");
        Iterator r28 = r110.iterator();
        if (r28.hasNext() == true) goto L37;
        r27.invoke(new Throwable(td.d.b("None of ILynxClientDelegate processor for image ", r15)));
        return;
    L37:
        r25.a(r28, r111, r26, r27);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onDataUpdated() {
        e r5 = this.f5648b;
        f r10 = r5.d();     // Catch: YieldError -> L11
        if (r10 == null) goto L10;
        Iterator r11 = r10.f5665h.iterator();     // Catch: YieldError -> L11
    L7:
        if (r11.hasNext() == false) goto L17;
        ((vc.c) r11.next()).f(r5.f5656b);     // Catch: YieldError -> L11
    L17:
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstLoadPerfReady(y r5) {
        Intrinsics.checkNotNullParameter(null, LynxMonitorService.KEY_METRIC);
        throw null;
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstScreen() {
        e r5 = this.f5648b;
        f r10 = r5.d();     // Catch: YieldError -> L20
        if (r10 == null) goto L10;
        Iterator r11 = r10.f5665h.iterator();     // Catch: YieldError -> L20
    L7:
        if (r11.hasNext() == false) goto L10;
        ((vc.c) r11.next()).b(r5.f5656b);     // Catch: YieldError -> L20
    L10:
        com.bytedance.ies.bullet.lynx.d r12 = this.f5648b.f5655a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(o.class, "clazz");
        tc.c r13 = tc.c.f22119c;
        if (tc.c.f22119c.a(o.class, r12.f22117a) != null) goto L19;
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r15 = this.f5648b.f;
        if (r15 == null) goto L15;
        String r16 = r15.getSessionId();
    L16:
        com.bytedance.ies.bullet.service.base.b.b(8, r16, "first screen", "XLynxKit");
        return;
    L15:
        r16 = null;
        goto L16
    L19:
        throw new ClassCastException();
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadFailed(String r5) {
        e r10 = this.f5648b;
        f r11 = r10.d();     // Catch: YieldError -> L12
        if (r11 == null) goto L10;
        Iterator r12 = r11.f5665h.iterator();     // Catch: YieldError -> L12
    L7:
        if (r12.hasNext() == false) goto L10;
        ((vc.c) r12.next()).j(r10.f5656b, r5);     // Catch: YieldError -> L12
    L10:
        com.bytedance.ies.bullet.core.e r13 = r10.f;
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadSuccess() {
        e r5 = this.f5648b;
        f r10 = r5.d();     // Catch: YieldError -> L16
        if (r10 == null) goto L10;
        Iterator r11 = r10.f5665h.iterator();     // Catch: YieldError -> L16
    L7:
        if (r11.hasNext() == false) goto L10;
        ((vc.c) r11.next()).m(r5.f5656b);     // Catch: YieldError -> L16
    L10:
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r13 = r5.f;
        if (r13 == null) goto L13;
        String r14 = r13.getSessionId();
    L14:
        com.bytedance.ies.bullet.service.base.b.b(8, r14, "load success", "XLynxKit");
        return;
    L13:
        r14 = null;
        goto L14
    }

    @Override // com.lynx.tasm.o0
    public final void onLynxViewAndJSRuntimeDestroy() {
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        e r10 = this.f5648b;
        com.bytedance.ies.bullet.core.e r11 = r10.f;
        if (r11 == null) goto L5;
        String r12 = r11.getSessionId();
    L6:
        com.bytedance.ies.bullet.service.base.b.b(8, r12, "onLynxViewAndJSRuntimeDestroy", "XLynxKit");
        com.bytedance.ies.bullet.core.e r13 = r10.f;
        if (r13 == null) goto L12;
        com.bytedance.ies.bullet.core.kit.bridge.d r14 = r13.f5301o;
        if (r14 == null) goto L12;
        r14.release();
    L12:
        if (r10.d == false) goto L22;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r15 = r10.e;
        if (r15 == null) goto L16;
        r15.r();
    L16:
        com.bytedance.ies.bullet.core.e r16 = r10.f;
        if (r16 == null) goto L22;
        IBridge3Registry r17 = r16.f5302p;
        if (r17 == null) goto L22;
        r17.release();
    L22:
        if (xq.b.i() == false) goto L25;
        r10.e = null;
        return;
    L25:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.lynx.tasm.o0
    public final void onPageStart(String r5) {
        e r10 = this.f5648b;
        f r11 = r10.d();     // Catch: YieldError -> L26
        if (r11 == null) goto L10;
        Iterator r12 = r11.f5665h.iterator();     // Catch: YieldError -> L26
    L7:
        if (r12.hasNext() == false) goto L10;
        ((vc.c) r12.next()).g(r10.f5656b, r5);     // Catch: YieldError -> L26
    L10:
        Unit r13 = null;
        if (r5 == null) goto L13;
        Uri r14 = Uri.parse(r5);
    L14:
        this.f5647a = r14;
        LinkedHashMap r15 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r16 = this.f5648b.f;
        if (r16 == null) goto L17;
        String r17 = r16.getSessionId();
    L18:
        rb.b r18 = cd.a.a(r17);
        com.bytedance.ies.bullet.core.e r19 = this.f5648b.f;
        if (r19 == null) goto L23;
        rd.b r20 = r19.e;
        if (r20 == null) goto L23;
        String r21 = ((com.bytedance.ies.bullet.service.sdk.b) r20).f6135c.toString();
        com.bytedance.ies.bullet.service.base.c r22 = new com.bytedance.ies.bullet.service.base.c(r21);
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.c.class, "clazz");
        r18.b(com.bytedance.ies.bullet.service.base.c.class, new rb.a(r22, 0));
        boolean r23 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "onPageStart url: ".concat(r21), "XLynxKit");
        r13 = Unit.INSTANCE;
    L23:
        if (r13 != null) goto L31;
        r18.c(com.bytedance.ies.bullet.service.base.c.class);
        return;
    L31:
        return;
    L17:
        r17 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    }

    @Override // com.lynx.tasm.o0
    public final void onPageUpdate() {
        e r5 = this.f5648b;
        f r10 = r5.d();     // Catch: YieldError -> L11
        if (r10 == null) goto L10;
        Iterator r11 = r10.f5665h.iterator();     // Catch: YieldError -> L11
    L7:
        if (r11.hasNext() == false) goto L17;
        ((vc.c) r11.next()).l(r5.f5656b);     // Catch: YieldError -> L11
    L17:
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onReceivedError(LynxError r10) {
        if (r10 == null) goto L48;
        e r11 = this.f5648b;
        f r5 = r11.d();     // Catch: YieldError -> L40
        if (r5 == null) goto L11;
        Iterator r12 = r5.f5665h.iterator();     // Catch: YieldError -> L40
    L8:
        if (r12.hasNext() == false) goto L11;
        ((vc.c) r12.next()).e(r11.f5656b, new n(r10.e(), r10.a()));     // Catch: YieldError -> L40
    L11:
        com.bytedance.ies.bullet.lynx.d r13 = r11.f5655a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.settings.b.class, "clazz");
        tc.c r14 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r15 = (com.bytedance.ies.bullet.settings.b) tc.c.f22119c.a(com.bytedance.ies.bullet.settings.b.class, r13.f22117a);
        if (r15 == null) goto L18;
        com.bytedance.ies.bullet.service.base.d r16 = (com.bytedance.ies.bullet.service.base.d) r15.f6163b.getValue();
        if (r16 == null) goto L18;
        ArrayList r17 = r16.f5963a;
        if (r17 == null) goto L18;
    L19:
        boolean r18 = r17.isEmpty();
        Iterator r19 = r17.iterator();
    L20:
        String r20 = null;
        if (r19.hasNext() == false) goto L29;
        String r21 = (String) r19.next();
        a0 r22 = r11.g;
        if (r22 == null) goto L25;
        Uri r23 = r22.f5932a;
    L27:
        if (StringsKt.g(String.valueOf(r23), r21) == false) goto L20;
        r18 = true;
        goto L29
    L25:
        r23 = null;
    L29:
        boolean r24 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r25 = r11.f;
        if (r25 == null) goto L32;
        r20 = r25.getSessionId();
    L32:
        com.bytedance.ies.bullet.service.base.b.e(r20, "receive error. error_code: " + r10.a() + ", error_message: " + r10 + ", deleteWhen100Error: " + r18, "XLynxKit", LogLevel.d);
        if (r10.a() != 107) goto L49;
        com.bytedance.ies.bullet.core.e r26 = r11.f;
        if (r26 == null) goto L50;
        com.bytedance.ies.bullet.core.n r27 = r26.f5299m;
        if (r27 == null) goto L51;
        r27.r(Uri.parse(""), new Throwable(r10.e()));
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L18:
        r17 = new ArrayList();
        goto L19
    }

    @Override // com.lynx.tasm.o0
    public final void onRuntimeReady() {
        e r5 = this.f5648b;
        f r10 = r5.d();     // Catch: YieldError -> L16
        if (r10 == null) goto L10;
        Iterator r11 = r10.f5665h.iterator();     // Catch: YieldError -> L16
    L7:
        if (r11.hasNext() == false) goto L10;
        ((vc.c) r11.next()).d(r5.f5656b);     // Catch: YieldError -> L16
    L10:
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r13 = r5.f;
        if (r13 == null) goto L13;
        String r14 = r13.getSessionId();
    L14:
        com.bytedance.ies.bullet.service.base.b.b(8, r14, "js runtime ready", "XLynxKit");
        return;
    L13:
        r14 = null;
        goto L14
    }

    @Override // com.lynx.tasm.o0
    public final void onScrollStart(n0 r10) {
        Uri r5 = this.f5647a;
        if (r5 == null) goto L5;
        String r11 = r5.toString();
    L6:
        if (r10 != null) goto L21;
        return;
    L21:
        f r12 = this.f5648b.d();     // Catch: YieldError -> L20
        if (r12 == null) goto L26;
        Iterator r13 = r12.f5665h.iterator();     // Catch: YieldError -> L20
    L11:
        if (r13.hasNext() == false) goto L28;
        vc.c r14 = (vc.c) r13.next();     // Catch: YieldError -> L20
        if (r11 == null) goto L16;
        w r15 = new w(r10.f10921a, r10.f10922b, r10.f10923c, r11);     // Catch: YieldError -> L20
    L17:
        r14.k(r15);     // Catch: YieldError -> L20
        goto L11
    L16:
        r15 = null;
        goto L17
    L28:
        return;
    L26:
        return;
    L27:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.lynx.tasm.o0
    public final void onScrollStop(n0 r10) {
        Uri r5 = this.f5647a;
        if (r5 == null) goto L5;
        String r11 = r5.toString();
    L6:
        if (r10 != null) goto L21;
        return;
    L21:
        f r12 = this.f5648b.d();     // Catch: YieldError -> L20
        if (r12 == null) goto L26;
        Iterator r13 = r12.f5665h.iterator();     // Catch: YieldError -> L20
    L11:
        if (r13.hasNext() == false) goto L28;
        vc.c r14 = (vc.c) r13.next();     // Catch: YieldError -> L20
        if (r11 == null) goto L16;
        w r15 = new w(r10.f10921a, r10.f10922b, r10.f10923c, r11);     // Catch: YieldError -> L20
    L17:
        r14.c(r15);     // Catch: YieldError -> L20
        goto L11
    L16:
        r15 = null;
        goto L17
    L28:
        return;
    L26:
        return;
    L27:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingSetup(Map r5) {
        f r10 = this.f5648b.d();     // Catch: YieldError -> L11
        if (r10 == null) goto L10;
        Iterator r11 = r10.f5665h.iterator();     // Catch: YieldError -> L11
    L7:
        if (r11.hasNext() == false) goto L17;
        ((vc.c) r11.next()).a(r5);     // Catch: YieldError -> L11
    L17:
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingUpdate(Map r5, Map r10, String r11) {
        f r12 = this.f5648b.d();     // Catch: YieldError -> L11
        if (r12 == null) goto L10;
        Iterator r13 = r12.f5665h.iterator();     // Catch: YieldError -> L11
    L7:
        if (r13.hasNext() == false) goto L17;
        ((vc.c) r13.next()).i(r5, r10, r11);     // Catch: YieldError -> L11
    L17:
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onUpdatePerfReady(y r5) {
        Intrinsics.checkNotNullParameter(null, LynxMonitorService.KEY_METRIC);
        throw null;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public final String shouldRedirectImageUrl(String r5) {
        String r10 = null;
        f r11 = this.f5648b.d();     // Catch: YieldError -> L11
        if (r11 == null) goto L10;
        Iterator r12 = r11.f5665h.iterator();     // Catch: YieldError -> L11
    L7:
        if (r12.hasNext() == false) goto L10;
        r10 = ((vc.c) r12.next()).shouldRedirectImageUrl(r5);     // Catch: YieldError -> L11
    L10:
        return r10;
    }
}
