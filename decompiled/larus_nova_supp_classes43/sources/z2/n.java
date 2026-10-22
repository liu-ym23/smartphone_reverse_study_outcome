package z2;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends WebChromeClient {
    public final /* synthetic */ l a;

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[EmbedWebViewService] onHideCustomView");
        this.a.c();
    }

    public n(l r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r12) {
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r1 = new StringBuilder("[EmbedWebViewService] onPermissionRequest: ");
        if (r12 == null) goto L7;
        String[] r10 = r12.getResources();
        if (r10 == null) goto L7;
        String r11 = ArraysKt.joinToString$default(r10, null, null, null, 0, null, null, 63, null);
    L8:
        r1.append(r11);
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", r1.toString());
        l r13 = this.a;
        r13.getClass();
        if (r12 == null) goto L26;
        String[] r14 = r12.getResources();
        if (r14 == null) goto L15;
        List r15 = ArraysKt.toList(r14);
        if (r15 == null) goto L15;
    L17:
        if (r15.isEmpty() == false) goto L19;
        l.b(r12);
        return;
    L19:
        d r16 = r13.c;
        if (r16 != null) goto L22;
        l.b(r12);
        return;
    L22:
        r16.h(r15, new e(r12), new f(r12));
        return;
    L15:
        r15 = CollectionsKt.emptyList();
        goto L17
    L26:
        return;
    L7:
        r11 = null;
        goto L8
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r10, WebChromeClient.CustomViewCallback r11) {
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[EmbedWebViewService] onShowCustomView");
        l r1 = this.a;
        if (r10 != null) goto L8;
        r1.getClass();
        if (r11 == null) goto L36;
        r11.onCustomViewHidden();
        return;
    L36:
        return;
    L8:
        if (r1.h == null) goto L11;
        if (r11 == null) goto L38;
        r11.onCustomViewHidden();
        return;
    L38:
        return;
    L11:
        Activity r12 = r1.f();
        if (r12 == null) goto L16;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L16;
        View r14 = l.a(r13);
    L18:
        if ((r14 instanceof ViewGroup) == false) goto L20;
        ViewGroup r15 = (ViewGroup) r14;
    L21:
        if (r12 == null) goto L32;
        if (r15 == null) goto L32;
        r1.h = r10;
        r1.i = r11;
        WebView r16 = r1.e;
        int r0 = 0;
        if (r16 == null) goto L27;
        int r17 = r16.getScrollX();
    L28:
        r1.j = r17;
        WebView r18 = r1.e;
        if (r18 == null) goto L31;
        r0 = r18.getScrollY();
    L31:
        r1.k = r0;
        r1.l = Integer.valueOf(r12.getRequestedOrientation());
        r12.setRequestedOrientation(-1);
        r15.addView(r10, new ViewGroup.LayoutParams(-1, -1));
        return;
    L27:
        r17 = 0;
    L32:
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] cannot find decorView for custom view", null);
        if (r11 == null) goto L41;
        r11.onCustomViewHidden();
        return;
    L41:
        return;
    L20:
        r15 = null;
    L16:
        r14 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [z2.i] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList] */
    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r12, final ValueCallback<Uri[]> r13, WebChromeClient.FileChooserParams r14) {
        com.bytedance.ai.applet.base.log.b r15 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r16 = new StringBuilder("[EmbedWebViewService] onShowFileChooser: mode=");
        if (r14 == null) goto L5;
        Integer r1 = Integer.valueOf(r14.getMode());
    L6:
        r16.append(r1);
        r16.append(", acceptTypes=");
        if (r14 == null) goto L11;
        String[] r10 = r14.getAcceptTypes();
        if (r10 == null) goto L11;
        String r11 = ArraysKt.joinToString$default(r10, null, null, null, 0, null, null, 63, null);
    L12:
        r16.append(r11);
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", r16.toString());
        boolean r17 = false;
        if (r13 != null) goto L15;
        return false;
    L15:
        d r18 = this.a.c;
        if (r18 != null) goto L18;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] no capability, cancel file chooser", null);
        r13.onReceiveValue(null);
    L46:
        return true;
    L18:
        final AtomicBoolean r19 = new AtomicBoolean(false);
        ?? r20 = new i(r19, r13);
        if (r14 != null) goto L21;
    L23:
        boolean r110 = false;
    L24:
        if (r14 == null) goto L33;
        String[] r21 = r14.getAcceptTypes();
        if (r21 == null) goto L33;
        ?? r22 = new ArrayList();
        int r23 = r21.length;
        int r24 = 0;
    L28:
        if (r24 >= r23) goto L34;
        String r25 = r21[r24];
        Intrinsics.checkNotNull(r25);
        if ((!StringsKt.isBlank(r25)) == false) goto L32;
        r22.add(r25);
    L32:
        r24 = r24 + 1;
    L34:
        if (r14 != null) goto L36;
    L38:
        s r111 = new s(r22, r17, r110);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L41
        r18.i(r111, new j(r20));     // Catch: Throwable -> L41
        Object r113 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r114 = Result.exceptionOrNull-impl(r113);
        if (r114 == null) goto L46;
        com.bytedance.ai.applet.base.log.b r115 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] onChooseFile threw: " + r114, null);
        r20.invoke(CollectionsKt.emptyList());
    L41:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L36:
        if (r14.isCaptureEnabled() != true) goto L38;
        r17 = true;
    L33:
        r22 = CollectionsKt.emptyList();
        goto L34
    L21:
        if (r14.getMode() != 1) goto L23;
        r110 = true;
    L11:
        r11 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
