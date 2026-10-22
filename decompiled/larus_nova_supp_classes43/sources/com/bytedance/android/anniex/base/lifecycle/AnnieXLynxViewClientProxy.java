package com.bytedance.android.anniex.base.lifecycle;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.anniex.container.popup.AnnieXLynxViewNestedScrollUtil;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;
import w26.e;
import w26.g;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLynxViewClientProxy extends q1 {
    public final AnnieXContainer a;
    public final q1 b;

    public static final class a {
    }

    static {
    }

    public final void onDataUpdated() {
        super.onDataUpdated();
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDataUpdated();
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    public final void onFirstScreen() {
        super.onFirstScreen();
        q1 r0 = this.b;
        if (r0 == null) goto L5;
        r0.onFirstScreen();
    L5:
        LynxView r1 = this.a.getKitView();
        i r10 = null;
        if ((r1 instanceof LynxView) == false) goto L8;
        LynxView r11 = r1;
    L9:
        if (r11 == null) goto L47;
        boolean r12 = false;
        if (Intrinsics.areEqual(this.a.getViewType(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L33;
        v36.a r13 = this.a.getAnnieXContainerModel$anniex_release();
        if (r13 == null) goto L20;
        i r14 = r13.E;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pullDownClose");
        r14 = null;
    L18:
        if (r14 == null) goto L20;
        boolean r15 = Intrinsics.areEqual(r14.b, Boolean.TRUE);
    L21:
        if (r15 == false) goto L33;
        Map r16 = x26.a.a;
        g r17 = (g) x26.a.a(g.class);
        if (r17 == null) goto L29;
        e r18 = (e) r17.n0(e.class);
        if (r18 == null) goto L29;
        Boolean r19 = r18.N();
        if (r19 == null) goto L29;
        boolean r20 = r19.booleanValue();
    L30:
        if (r20 == false) goto L33;
        AnnieXLynxViewNestedScrollUtil.b(r11);
    L29:
        r20 = true;
    L20:
        r15 = false;
    L33:
        if (Intrinsics.areEqual(this.a.getViewType(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L48;
        v36.a r21 = this.a.getAnnieXContainerModel$anniex_release();
        if (r21 == null) goto L42;
        i r22 = r21.F;
        if (r22 == null) goto L39;
        r10 = r22;
    L40:
        if (r10 == null) goto L42;
        r12 = Intrinsics.areEqual(r10.b, Boolean.TRUE);
        goto L42
    L39:
        Intrinsics.throwUninitializedPropertyAccessException("enableEngineViewScroll");
    L42:
        if (r12 == false) goto L49;
        int r23 = AnnieXLynxViewNestedScrollUtil.a;
        View r24 = AnnieXLynxViewNestedScrollUtil.a(r11, AnnieXLynxViewClientProxy$onFirstScreen$1$1.INSTANCE);
        if (r24 == null) goto L50;
        this.a.setLynxWithScrollView$anniex_release(r24);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLoadSuccess();
        return;
    }

    public final void onLynxViewAndJSRuntimeDestroy() {
        super.onLynxViewAndJSRuntimeDestroy();
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLynxViewAndJSRuntimeDestroy();
        return;
    }

    public final void onPageUpdate() {
        super.onPageUpdate();
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPageUpdate();
        return;
    }

    public final void onRuntimeReady() {
        super.onRuntimeReady();
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onRuntimeReady();
        return;
    }

    public final void onUpdateDataWithoutChange() {
        super.onUpdateDataWithoutChange();
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onUpdateDataWithoutChange();
        return;
    }

    public final void onCallJSBFinished(Map<String, Object> r10) {
        super.onCallJSBFinished(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onCallJSBFinished(r10);
        return;
    }

    public final void onDynamicComponentPerfReady(HashMap<String, Object> r10) {
        super.onDynamicComponentPerfReady(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDynamicComponentPerfReady(r10);
        return;
    }

    public final void onFirstLoadPerfReady(v0 r10) {
        super.onFirstLoadPerfReady(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFirstLoadPerfReady(r10);
        return;
    }

    public final void onFling(q1.b r10) {
        super.onFling(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFling(r10);
        return;
    }

    public final void onFlushFinish(q1.a r10) {
        super.onFlushFinish(null);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFlushFinish(null);
        return;
    }

    public final void onJSBInvoked(Map<String, Object> r10) {
        super.onJSBInvoked(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onJSBInvoked(r10);
        return;
    }

    public final void onLoadFailed(String r10) {
        super.onLoadFailed(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLoadFailed(r10);
        return;
    }

    public final void onLynxEvent(LynxEventDetail r10) {
        super.onLynxEvent(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLynxEvent(r10);
        return;
    }

    public final void onPageStart(String r10) {
        super.onPageStart(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPageStart(r10);
        return;
    }

    public final void onPiperInvoked(Map<String, Object> r10) {
        super.onPiperInvoked(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPiperInvoked(r10);
        return;
    }

    public final void onReceivedError(LynxError r10) {
        super.onReceivedError(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedError(r10);
        return;
    }

    public final void onReceivedJSError(LynxError r10) {
        super.onReceivedJSError(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedJSError(r10);
        return;
    }

    public final void onReceivedJavaError(LynxError r10) {
        super.onReceivedJavaError(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedJavaError(r10);
        return;
    }

    public final void onReceivedNativeError(LynxError r10) {
        super.onReceivedNativeError(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedNativeError(r10);
        return;
    }

    public final void onReportComponentInfo(Set<String> r10) {
        super.onReportComponentInfo(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReportComponentInfo(r10);
        return;
    }

    public final void onReportLynxConfigInfo(LynxConfigInfo r10) {
        super.onReportLynxConfigInfo(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReportLynxConfigInfo(r10);
        return;
    }

    public final void onScrollStart(q1.b r10) {
        super.onScrollStart(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onScrollStart(r10);
        return;
    }

    public final void onScrollStop(q1.b r10) {
        super.onScrollStop(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onScrollStop(r10);
        return;
    }

    public final void onTimingSetup(Map<String, Object> r10) {
        super.onTimingSetup(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onTimingSetup(r10);
        return;
    }

    public final void onUpdatePerfReady(v0 r10) {
        super.onUpdatePerfReady(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onUpdatePerfReady(r10);
        return;
    }

    public final String shouldRedirectImageUrl(String r10) {
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.shouldRedirectImageUrl(r10);
    L6:
        return super.shouldRedirectImageUrl(r10);
    }

    public final void onReceivedError(String r10) {
        super.onReceivedError(r10);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedError(r10);
        return;
    }

    public AnnieXLynxViewClientProxy(AnnieXContainer r10, q1 r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        this.a = r10;
        this.b = r11;
    }

    public final void onKeyEvent(KeyEvent r10, boolean r11) {
        super.onKeyEvent(r10, r11);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onKeyEvent(r10, r11);
        return;
    }

    public final void onModuleMethodInvoked(String r10, String r11, int r12) {
        super.onModuleMethodInvoked(r10, r11, r12);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onModuleMethodInvoked(r10, r11, r12);
        return;
    }

    public final void onTimingUpdate(Map<String, Object> r10, Map<String, Long> r11, String r12) {
        super.onTimingUpdate(r10, r11, r12);
        q1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.onTimingUpdate(r10, r11, r12);
        return;
    }

    public final void loadImage(Context r10, String r11, String r12, float r13, float r14, Transformer r15, m.a r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "handler");
        super.loadImage(r10, r11, r12, r13, r14, r15, r16);
        q1 r1 = this.b;
        if (r1 == null) goto L6;
        r1.loadImage(r10, r11, r12, r13, r14, r15, r16);
        return;
    }
}
