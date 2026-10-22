package a2;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.DispatchQueue;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$callback$1;
import androidx.room.TransactionExecutor;
import com.bytedance.ai.applet.components.page.AppletPageActivity;
import com.bytedance.ai.applet.components.page.RenderUrlData;
import com.bytedance.ai.applet.render.core.relax.h;
import com.bytedance.ai.bridge.method.info.GetAppInfoMethod;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.model.q;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.pia.core.bridge.methods.d0;
import com.bytedance.pia.core.bridge.methods.l0;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.bytedance.salamander.anniex.b0;
import com.google.common.reflect.w;
import com.google.gson.JsonObject;
import com.lynx.tasm.behavior.t0;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.w0;
import com.obric.launcher.widget.R$color;
import com.obric.oui.constraintlayout.motion.widget.i0;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.texteffects.ODimPointGenerateEffectView;
import j1.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import js.s;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import l9.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f50a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f51b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f52c;

    public /* synthetic */ b(int r5, Object r10, Object r11) {
        this.f50a = r5;
        this.f51b = r10;
        this.f52c = r11;
    }

    /* JADX WARN: Type inference failed for: r13v27, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.Lambda] */
    @Override // java.lang.Runnable
    public final void run() {
        int r5 = -1;
        int r10 = 2;
        int r11 = 0;
        Object r12 = null;
        boolean r13 = true;
        char r14 = 1;
        switch(this.f50a) {
            case 0: goto L150;
            case 1: goto L148;
            case 2: goto L146;
            case 3: goto L144;
            case 4: goto L142;
            case 5: goto L140;
            case 6: goto L138;
            case 7: goto L136;
            case 8: goto L122;
            case 9: goto L120;
            case 10: goto L115;
            case 11: goto L106;
            case 12: goto L104;
            case 13: goto L102;
            case 14: goto L87;
            case 15: goto L76;
            case 16: goto L74;
            case 17: goto L72;
            case 18: goto L70;
            case 19: goto L68;
            case 20: goto L64;
            case 21: goto L62;
            case 22: goto L41;
            case 23: goto L39;
            case 24: goto L28;
            case 25: goto L20;
            case 26: goto L15;
            case 27: goto L10;
            case 28: goto L6;
            default: goto L4;
        };
    L4:
        ((kh.c) this.f51b).getClass();
        new WeakReference((WebView) this.f52c);
        return;
    L6:
        WebView r15 = (WebView) ((g) this.f51b).f18229c.get();
        if (r15 == null) goto L161;
        String r16 = "onWebViewMessage(" + JSONObject.quote((String) this.f52c) + ')';
        Intrinsics.checkNotNullParameter(r16, "script");
        r15.evaluateJavascript(r16, new q(1));
        return;
    L161:
        return;
    L10:
        ProtocolMessage r17 = (ProtocolMessage) ((j2.a) this.f51b).f22372b;
        Intrinsics.checkNotNullParameter(r17, "value");
        String r18 = z0.a.a().toJson(r17);
        g r19 = (g) this.f52c;
        WebMessagePort r20 = r19.e;
        if (r20 == null) goto L13;
        r20.postMessage(new WebMessage(r18));
        return;
    L13:
        c1.b.b(new b(28, r19, r18));
        return;
    L15:
        WebView r21 = (WebView) ((WeakReference) ((l) this.f51b).e).get();
        if (r21 == null) goto L163;
        StringBuilder r22 = new StringBuilder("(function(n){var i=window.pia_bridge,o=i&&i.onmessage;o&&\"function\"==typeof o&&o(n)})");
        j.r(r22, (String) this.f52c);
        String r110 = r22.toString();
        Intrinsics.checkNotNullParameter(r110, "script");
        j.o(r21, r110, null);
        return;
    L163:
        return;
    L20:
        l r23 = (l) this.f51b;
        WebView r24 = (WebView) ((WeakReference) r23.e).get();
        if (r24 != null) goto L24;
        return;
    L24:
        if (j.a(r24) < 66) goto L165;
        WebMessagePort[] r25 = r24.createWebMessageChannel();
        r25[0].setWebMessageCallback(new hh.b(r23, r25, r11), (Handler) m.f7156b.getValue());
        Intrinsics.checkNotNullParameter("(function(e){var i=function(a){if(\"__channel_init__\"===a.data&&a.ports&&a.ports[0]){var s=a.ports[0];s.postMessage(\"__channel_ack__\"),s.onmessage=function(i){i&&i.data&&\"string\"==typeof i.data&&e(i.data)};var n=function(e){s.postMessage(e)};window.pia_bridge&&window.pia_bridge.onmessage?window.pia_bridge.postMessage=n:window.pia_bridge={postMessage:n},window.removeEventListener(\"message\",i)}};window.addEventListener(\"message\",i)})(function(n){var i=window.pia_bridge,o=i&&i.onmessage;o&&\"function\"==typeof o&&o(n)})", "script");
        j.o(r24, "(function(e){var i=function(a){if(\"__channel_init__\"===a.data&&a.ports&&a.ports[0]){var s=a.ports[0];s.postMessage(\"__channel_ack__\"),s.onmessage=function(i){i&&i.data&&\"string\"==typeof i.data&&e(i.data)};var n=function(e){s.postMessage(e)};window.pia_bridge&&window.pia_bridge.onmessage?window.pia_bridge.postMessage=n:window.pia_bridge={postMessage:n},window.removeEventListener(\"message\",i)}};window.addEventListener(\"message\",i)})(function(n){var i=window.pia_bridge,o=i&&i.onmessage;o&&\"function\"==typeof o&&o(n)})", null);
        r24.postWebMessage(new WebMessage("__channel_init__", new WebMessagePort[]{r25[1]}), (Uri) this.f52c);
        return;
    L165:
        return;
    L28:
        int r26 = AppletPopup.L;
        String r27 = (String) this.f51b;
        FragmentTransaction r111 = (FragmentTransaction) this.f52c;
        if (r27 != null) goto L154;
    L33:
        r111.commitAllowingStateLoss();     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L166;
        r28.e("AppletPopup", "commitNowAllowingStateLossSafely", th);
        return;
    L166:
        return;
    L154:
        r111.addToBackStack(r27);     // Catch: Throwable -> L31
        goto L33
    L39:
        ((gu.f) this.f51b).f((View) this.f52c);
        return;
    L41:
        JsonObject r29 = (JsonObject) this.f52c;
        gh.c r30 = (gh.c) this.f51b;
        r30.getClass();
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L44
        Object r113 = Result.m124constructorimpl((com.bytedance.pia.core.bridge.protocol.ProtocolMessage) i.a().fromJson(r29, com.bytedance.pia.core.bridge.protocol.ProtocolMessage.class));     // Catch: Throwable -> L44
    L47:
        if (Result.m130isFailureimpl(r113) == true) goto L50;
        r12 = r113;
    L50:
        com.bytedance.pia.core.bridge.protocol.ProtocolMessage r31 = (com.bytedance.pia.core.bridge.protocol.ProtocolMessage) r12;
        if (r31 == null) goto L171;
        b0 r114 = r31.d();
        if (r114 == null) goto L56;
        AtomicBoolean r32 = new AtomicBoolean(false);
        com.bytedance.pia.core.utils.d r115 = new com.bytedance.pia.core.utils.d(r30, r114, r32);
        m.b(new com.bytedance.ai.model.widgets.m(r30, (String) r114.f7247c, new d0(r30, r114, r32), (JsonObject) r114.d, r115, 3));
        return;
    L56:
        l9.g r116 = r31.c();
        if (r116 == null) goto L169;
        SparseArray r33 = r30.g;
        int r34 = r116.f19561b;
        fh.a r35 = (fh.a) r33.get(r34);
        if (r35 == null) goto L170;
        r33.remove(r34);
        r35.accept(r116);
        return;
    L170:
        return;
    L169:
        return;
    L171:
        return;
    L44:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r113 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L47
    L62:
        hh.a r37 = (hh.a) this.f52c;
        gh.c r117 = (gh.c) this.f51b;
        r117.f = r37;
        r117.e.b(new l0(r37, r14 == true ? 1 : 0));
        r37.d(new l0(r117, r10));
        return;
    L64:
        gh.a r38 = (gh.a) this.f51b;
        r38.getClass();
        ah.b r118 = (ah.b) this.f52c;
        if (TextUtils.isEmpty(r118.f169a) == true) goto L172;
        r38.f17094a.put(r118.f169a, r118);
        return;
    L172:
        return;
    L68:
        FragmentStrictMode.a((String) this.f51b, (Violation) this.f52c);
        return;
    L70:
        FragmentStrictMode.b((FragmentStrictMode.Policy) this.f51b, (Violation) this.f52c);
        return;
    L72:
        int r39 = ODimPointGenerateEffectView.f14707j;
        ODimPointGenerateEffectView r40 = (ODimPointGenerateEffectView) this.f51b;
        Intrinsics.checkNotNullParameter(r40, "this$0");
        s r119 = (s) this.f52c;
        Intrinsics.checkNotNullParameter(r119, "$spec");
        r40.f = null;
        r40.f(r119);
        return;
    L74:
        int r41 = ODimPointGenerateEffectView.f14707j;
        ODimPointGenerateEffectView r42 = (ODimPointGenerateEffectView) this.f51b;
        Intrinsics.checkNotNullParameter(r42, "this$0");
        CharSequence r120 = (CharSequence) this.f52c;
        Intrinsics.checkNotNullParameter(r120, "$newText");
        r42.g = null;
        r42.h(r120);
        return;
    L76:
        i0 r43 = (i0) this.f51b;
        int r44 = r43.f12817p;
        View[] r121 = (View[]) this.f52c;
        if (r44 == (-1)) goto L82;
        int r45 = r121.length;
        int r46 = 0;
    L79:
        if (r46 >= r45) goto L82;
        r121[r46].setTag(r43.f12817p, Long.valueOf(System.nanoTime()));
        r46 = r46 + 1;
    L82:
        if (r43.f12818q == (-1)) goto L86;
        int r47 = r121.length;
    L84:
        if (r11 >= r47) goto L173;
        r121[r11].setTag(r43.f12818q, null);
        r11 = r11 + 1;
        goto L84
    L173:
        return;
    L86:
        return;
    L87:
        RecyclerView r48 = (RecyclerView) this.f51b;
        Intrinsics.checkNotNullParameter(r48, "$this_apply");
        com.obric.oui.orecyclerview.widget.s r122 = (com.obric.oui.orecyclerview.widget.s) this.f52c;
        Intrinsics.checkNotNullParameter(r122, "$lm");
        if (r48.computeVerticalScrollRange() <= ((r48.getHeight() - r48.getPaddingTop()) - r48.getPaddingBottom())) goto L92;
        r13 = false;
    L92:
        if (r122.f13902r == r13) goto L97;
        r122.b(null);
        if (r122.f13902r == r13) goto L97;
        r122.f13902r = r13;
        r122.Q();
    L97:
        if (r13 == true) goto L100;
        r10 = 0;
    L100:
        r48.setOverScrollMode(r10);
        return;
    L102:
        View r49 = (View) this.f51b;
        Intrinsics.checkNotNullParameter(r49, "$widget");
        com.obric.flow.cardlistpage.ui.component.feedlist.s r123 = (com.obric.flow.cardlistpage.ui.component.feedlist.s) this.f52c;
        Intrinsics.checkNotNullParameter(r123, "this$0");
        r123.getClass();
        r49.setAlpha(0.0f);
        float r124 = r123.f11614w;
        r49.setScaleX(r124);
        r49.setScaleY(r124);
        return;
    L104:
        ((t0) this.f51b).a((Object[]) this.f52c);
        return;
    L106:
        w r50 = (w) this.f51b;
        Iterator r51 = ((ArrayList) r50.f9377c).iterator();
    L107:
        boolean r52 = r51.hasNext();
        yg.d r53 = (yg.d) this.f52c;
        HashSet r54 = r53.f23266b;
        if (r52 == false) goto L112;
        r53.accept((com.bytedance.pia.core.tracing.d) r51.next());
        if (r54.isEmpty() == false) goto L107;
    L112:
        if (r54.isEmpty() == true) goto L174;
        ((HashSet) r50.f9376b).add(r53);
        return;
    L174:
        return;
    L115:
        com.bytedance.lynx.service.reporter.performance.c r55 = (com.bytedance.lynx.service.reporter.performance.c) this.f51b;
        Ref.LongRef r125 = (Ref.LongRef) this.f52c;
        Intrinsics.checkNotNullParameter(r55, "this$0");
        Intrinsics.checkNotNullParameter(r125, "$interval");
        if (r55.d == false) goto L175;
        r55.f6847c += r125.element;
        r55.f6846b++;
        r55.f6845a.invoke(Long.valueOf(((Number) com.bytedance.lynx.service.reporter.performance.c.e.getValue()).longValue()), Integer.valueOf(r55.f6846b), Long.valueOf(r55.f6847c));
        r55.a();
        return;
    L175:
        return;
    L120:
        h.e((h) this.f51b, (j2.a) this.f52c);
        return;
    L122:
        int r56 = AppletPageActivity.f1709t;
        int r57 = R$color.base_1;
        View r58 = (View) this.f51b;
        r58.setBackgroundResource(r57);
        AppletPageActivity r126 = (AppletPageActivity) this.f52c;
        RenderUrlData r59 = r126.s;
        if (r59 != null) goto L125;
    L127:
        int r60 = r126.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r60 <= 0) goto L130;
        int r61 = r126.getApplicationContext().getResources().getDimensionPixelSize(r60);
    L131:
        int r62 = r58.getPaddingStart();
        int r63 = r58.getPaddingEnd();
        int r64 = r126.getApplicationContext().getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r64 <= 0) goto L134;
        r5 = r126.getApplicationContext().getResources().getDimensionPixelSize(r64);
    L134:
        r58.setPaddingRelative(r62, r61, r63, r5);
        return;
    L130:
        r61 = -1;
        goto L131
    L125:
        if (r59.f1717b != true) goto L127;
    L136:
        ((PerformanceController) this.f51b).c((w0) this.f52c);
        return;
    L138:
        ((PerformanceController) this.f51b).g((HashMap) this.f52c);
        return;
    L140:
        TransactionExecutor.a((Runnable) this.f51b, (TransactionExecutor) this.f52c);
        return;
    L142:
        MultiInstanceInvalidationClient$callback$1.d((MultiInstanceInvalidationClient) this.f51b, (String[]) this.f52c);
        return;
    L144:
        ProfileInstallerInitializer.a((ProfileInstallerInitializer) this.f51b, (Context) this.f52c);
        return;
    L146:
        DispatchQueue.a((DispatchQueue) this.f51b, (Runnable) this.f52c);
        return;
    L148:
        ResourcesCompat.FontCallback.a((ResourcesCompat.FontCallback) this.f51b, (Typeface) this.f52c);
        return;
    L150:
        GetAppInfoMethod.d((AtomicBoolean) this.f51b, (a) this.f52c);
    }
}
