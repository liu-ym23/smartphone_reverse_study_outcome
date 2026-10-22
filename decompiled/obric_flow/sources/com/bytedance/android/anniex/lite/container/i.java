package com.bytedance.android.anniex.lite.container;

import android.app.Application;
import android.net.Uri;
import android.util.LruCache;
import android.view.View;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.monitorV2.webview.k;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements x3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f3252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnieXLiteContainer f3253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n4.a f3254c;

    public i(AnnieXLiteContainer r5, a4.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieXContext");
        Intrinsics.checkNotNullParameter(r5, "iContainer");
        this.f3252a = r10;
        this.f3253b = r5;
    }

    @Override // x3.a
    public final boolean a() {
        return false;
    }

    @Override // x3.a
    public final View b() {
        n4.a r5 = this.f3254c;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f20202b;
    }

    @Override // x3.a
    public final void c(com.bytedance.ies.bullet.core.kit.bridge.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        n4.a r10 = this.f3254c;
        if (r10 == null) goto L6;
        r10.b(r5.getName(), r5.getParams());
        return;
    }

    @Override // x3.a
    public final void enterBackground() {
        n4.a r5 = this.f3254c;
        if (r5 == null) goto L9;
        SSWebView r10 = r5.f20202b;
        if (r10 == null) goto L7;
        r10.onPause();
    L7:
        r5.b("viewDisappeared", null);
        com.bytedance.ies.bullet.service.base.b.b(8, null, "kitView status:on hide", "XWebKit");
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // x3.a
    public final void enterForeground() {
        n4.a r5 = this.f3254c;
        if (r5 == null) goto L9;
        SSWebView r10 = r5.f20202b;
        if (r10 == null) goto L7;
        r10.onResume();
    L7:
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        r12.put("isViewFirstAppeared", r5.d);
        Unit r13 = Unit.INSTANCE;
        r11.put("data", r12);
        r5.b("viewAppeared", r11);
        r5.d = false;
        return;
    }

    @Override // x3.a
    public final void release() {
        n4.a r5 = this.f3254c;
        if (r5 == null) goto L20;
        SSWebView r10 = r5.f20202b;
        if (r10 == null) goto L8;
        r10.setWebChromeClient(null);
        r10.setWebViewClient(new WebViewClient());
        r10.destroy();     // Catch: Throwable -> L21
    L8:
        String r11 = r5.f20201a;
        com.bytedance.android.anniex.assemble.a.b(p3.c.class, r11);
        if (((Boolean) com.bytedance.android.anniex.lite.utils.a.f3257a.getValue()).booleanValue() == true) goto L15;
        tc.c r12 = tc.c.f22119c;
        if (tc.c.f22119c.a(p3.c.class, r11) == null) goto L15;
        throw new ClassCastException();
    L15:
        r5.f20203c.getClass();
        k r13 = k.d;
        String[] r14 = {SSWebView.class.getName()};
        m r15 = r13.f3799b;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "webViewClassesNames");
        String r16 = r14[0];
        HashMap r17 = r15.f3803a;
        if (r17 == null) goto L19;
        TypeIntrinsics.asMutableMap(r17).remove(r16);
        r5.f.f21717a.clear();
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    @Override // x3.a
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
    }

    @Override // x3.a
    public final void a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, android.net.Uri, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15, types: [T] */
    /* JADX WARN: Type inference failed for: r8v18, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r8v20 */
    @Override // x3.a
    public final void b(String r10, Map r11, rb.b r12, v3.a r13) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        String r14 = this.f3252a.f90b;
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        y3.a.f23235a.a(r14);
        a4.a r15 = this.f3252a;
        FragmentActivity r5 = r15.g;
        if (r5 == null) goto L13;
        String r16 = r15.f91c;
        LruCache r17 = com.bytedance.android.anniex.lite.b.f3223a;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r16, "bid");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r16, "bid");
        com.bytedance.ies.bullet.base.b.a(r5);
        if (xq.b.k() == false) goto L12;
        tc.c r18 = tc.c.f22119c;
        rc.c r19 = tc.c.f22119c.a(com.bytedance.ies.bullet.service.webkit.c.class, r16);
        if ((r19 instanceof com.bytedance.ies.bullet.service.webkit.c) == false) goto L9;
        com.bytedance.ies.bullet.service.webkit.c r20 = (com.bytedance.ies.bullet.service.webkit.c) r19;
    L10:
        if (r20 == null) goto L12;
        n4.a r21 = new n4.a(r16, r20);
        r21.a(r5);
    L14:
        this.f3254c = r21;
        if (r21 == null) goto L17;
        Intrinsics.checkNotNullParameter(this.f3252a.f89a, "scene");
    L17:
        if (r13 == null) goto L19;
        r13.f("", this.f3253b);
    L19:
        ?? r22 = Uri.parse(this.f3252a.e);
        a4.a r23 = this.f3252a;
        String r110 = r23.f91c;
        String r24 = r23.f90b;
        LruCache r25 = com.bytedance.android.anniex.lite.b.f3223a;
        Intrinsics.checkNotNullParameter(r110, "bid");
        Intrinsics.checkNotNullParameter(r22, "schema");
        Intrinsics.checkNotNullParameter(r24, "sessionId");
        if (com.bytedance.android.anniex.lite.b.f3223a.get(r24) != null) goto L30;
        com.bytedance.android.anniex.monitor.c.x(r110, r24);
        Application r26 = com.bytedance.ies.bullet.core.h.g.f5316b;
        LinkedHashMap r27 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r110, "bid");
        Intrinsics.checkNotNullParameter(r27, "globalProps");
        rd.e r28 = com.bytedance.android.anniex.lite.b.a(r22, r110, r24);
        Intrinsics.checkNotNullParameter(r24, "sessionId");
        Intrinsics.checkNotNullParameter(r22, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter("AnnieXCard", "enterFrom");
        Ref.ObjectRef r29 = new Ref.ObjectRef();
        r29.element = r22;
        rd.b r30 = r28.f21723a;
        String r31 = (String) ((com.bytedance.ies.bullet.service.sdk.b) r30).f6143o.get("url");
        if (r31 == null) goto L24;
        ?? r32 = Uri.parse(r31);
    L25:
        if (r32 != 0) goto L27;
        r32 = (Uri) r29.element;
    L27:
        r29.element = r32;
        Lazy r33 = com.bytedance.ies.bullet.service.sdk.d.e;
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r30, td.a.class);
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r30, td.a.class);
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r30, td.e.class);
        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel");
        throw null;
    L24:
        r32 = 0;
        goto L25
    L30:
        throw new ClassCastException();
    L9:
        r20 = null;
    L12:
        r21 = new n4.a(r16, new com.bytedance.ies.bullet.service.webkit.c(null, 3));
        r21.a(r5);
        goto L14
    L13:
        r21 = null;
        goto L14
    }
}
