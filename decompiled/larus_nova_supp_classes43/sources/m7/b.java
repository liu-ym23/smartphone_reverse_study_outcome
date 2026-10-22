package m7;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends q1 {
    public final AnnieXLiveContext a;
    public final q1 b;
    public final b7.b c;
    public ia.c d;

    public static final class a {
    }

    static {
    }

    public final void onDataUpdated() {
        super.onDataUpdated();
        this.b.onDataUpdated();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.b.onDestroy();
    }

    public final void onFirstScreen() {
        super.onFirstScreen();
        this.b.onFirstScreen();
        b7.b r0 = this.c;
        if (r0 == null) goto L6;
        r0.onLynxFirstScreen();
        return;
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        this.b.onLoadSuccess();
    }

    public final void onLynxViewAndJSRuntimeDestroy() {
        super.onLynxViewAndJSRuntimeDestroy();
        this.b.onLynxViewAndJSRuntimeDestroy();
    }

    public final void onPageUpdate() {
        super.onPageUpdate();
        this.b.onPageUpdate();
    }

    public final void onRuntimeReady() {
        super.onRuntimeReady();
        this.b.onRuntimeReady();
        b7.b r0 = this.c;
        if (r0 == null) goto L10;
        ia.c r1 = this.d;
        if (r1 == null) goto L7;
        View r10 = r1.getKitView();
    L8:
        r0.onLoadSuccess(r10);
        return;
    L7:
        r10 = null;
        goto L8
    }

    public final void onUpdateDataWithoutChange() {
        super.onUpdateDataWithoutChange();
        this.b.onUpdateDataWithoutChange();
    }

    public final void onCallJSBFinished(Map<String, Object> r10) {
        super.onCallJSBFinished(r10);
        this.b.onCallJSBFinished(r10);
    }

    public final void onDynamicComponentPerfReady(HashMap<String, Object> r10) {
        super.onDynamicComponentPerfReady(r10);
        this.b.onDynamicComponentPerfReady(r10);
    }

    public final void onFirstLoadPerfReady(v0 r10) {
        super.onFirstLoadPerfReady(r10);
        this.b.onFirstLoadPerfReady(r10);
    }

    public final void onFling(q1.b r10) {
        super.onFling(r10);
        this.b.onFling(r10);
    }

    public final void onFlushFinish(q1.a r10) {
        super.onFlushFinish(null);
        this.b.onFlushFinish(null);
    }

    public final void onJSBInvoked(Map<String, Object> r10) {
        super.onJSBInvoked(r10);
        this.b.onJSBInvoked(r10);
    }

    public final void onLoadFailed(String r10) {
        super.onLoadFailed(r10);
        this.b.onLoadFailed(r10);
        b7.b r0 = this.c;
        if (r0 == null) goto L13;
        ia.c r1 = this.d;
        String r11 = null;
        if (r1 == null) goto L7;
        View r12 = r1.getKitView();
    L8:
        AnnieXLiveContext r13 = this.a;
        if (r13 == null) goto L11;
        r11 = r13.getUrl();
    L11:
        r0.onLoadFail(r12, String.valueOf(r11), r10);
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final void onLynxEvent(LynxEventDetail r10) {
        super.onLynxEvent(r10);
        this.b.onLynxEvent(r10);
    }

    public final void onPageStart(String r10) {
        super.onPageStart(r10);
        this.b.onPageStart(r10);
        b7.b r11 = this.c;
        if (r11 == null) goto L6;
        r11.onLoadStart(null, false);
        return;
    }

    public final void onPiperInvoked(Map<String, Object> r10) {
        super.onPiperInvoked(r10);
        this.b.onPiperInvoked(r10);
    }

    public final void onReceivedError(LynxError r10) {
        super.onReceivedError(r10);
        this.b.onReceivedError(r10);
    }

    public final void onReceivedJSError(LynxError r10) {
        super.onReceivedJSError(r10);
        this.b.onReceivedJSError(r10);
    }

    public final void onReceivedJavaError(LynxError r10) {
        super.onReceivedJavaError(r10);
        this.b.onReceivedJavaError(r10);
    }

    public final void onReceivedNativeError(LynxError r10) {
        super.onReceivedNativeError(r10);
        this.b.onReceivedNativeError(r10);
    }

    public final void onReportComponentInfo(Set<String> r10) {
        super.onReportComponentInfo(r10);
        this.b.onReportComponentInfo(r10);
    }

    public final void onReportLynxConfigInfo(LynxConfigInfo r10) {
        super.onReportLynxConfigInfo(r10);
        this.b.onReportLynxConfigInfo(r10);
    }

    public final void onScrollStart(q1.b r10) {
        super.onScrollStart(r10);
        this.b.onScrollStart(r10);
    }

    public final void onScrollStop(q1.b r10) {
        super.onScrollStop(r10);
        this.b.onScrollStop(r10);
    }

    public final void onTimingSetup(Map<String, Object> r10) {
        super.onTimingSetup(r10);
        this.b.onTimingSetup(r10);
    }

    public final void onUpdatePerfReady(v0 r10) {
        super.onUpdatePerfReady(r10);
        this.b.onUpdatePerfReady(r10);
    }

    public final String shouldRedirectImageUrl(String r10) {
        this.b.shouldRedirectImageUrl(r10);
        return super.shouldRedirectImageUrl(r10);
    }

    public final void onReceivedError(String r10) {
        super.onReceivedError(r10);
        this.b.onReceivedError(r10);
    }

    public b(AnnieXLiveContext r10, q1 r11) {
        Intrinsics.checkNotNullParameter(r11, "lynxViewClient");
        this.a = r10;
        this.b = r11;
        if (r10 == null) goto L5;
        b7.b r12 = r10.getCommonLifecycle();
    L6:
        this.c = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void onKeyEvent(KeyEvent r10, boolean r11) {
        super.onKeyEvent(r10, r11);
        this.b.onKeyEvent(r10, r11);
    }

    public final void onModuleMethodInvoked(String r10, String r11, int r12) {
        super.onModuleMethodInvoked(r10, r11, r12);
        this.b.onModuleMethodInvoked(r10, r11, r12);
    }

    public final void onTimingUpdate(Map<String, Object> r10, Map<String, Long> r11, String r12) {
        super.onTimingUpdate(r10, r11, r12);
        this.b.onTimingUpdate(r10, r11, r12);
    }

    public final void loadImage(Context r10, String r11, String r12, float r13, float r14, Transformer r15, m.a r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "handler");
        super.loadImage(r10, r11, r12, r13, r14, r15, r16);
        this.b.loadImage(r10, r11, r12, r13, r14, r15, r16);
    }
}
