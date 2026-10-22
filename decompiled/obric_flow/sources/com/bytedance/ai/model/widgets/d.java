package com.bytedance.ai.model.widgets;

import android.net.Uri;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.b0;
import com.bytedance.ai.resource.core.db.AIPackageDao_Impl;
import com.bytedance.ai.uiu.UIUInternalDebugBroadcastReceiver;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.e0;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2337c;

    public /* synthetic */ d(int r5, Object r10, Object r11) {
        this.f2335a = r5;
        this.f2336b = r10;
        this.f2337c = r11;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r14) {
        com.ivy.ivykit.api.plugin.a r10 = null;
        Object r11 = this.f2337c;
        Object r12 = this.f2336b;
        switch(this.f2335a) {
            case 0: goto L71;
            case 1: goto L70;
            case 2: goto L64;
            case 3: goto L56;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L48;
            case 7: goto L42;
            case 8: goto L37;
            case 9: goto L22;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L12;
            case 13: goto L10;
            case 14: goto L8;
            case 15: goto L6;
            default: goto L4;
        };
    L4:
        Throwable r15 = (Throwable) r14;
        ((wt.d) r12).f22904a.removeCallbacks((s8.h) r11);
        return Unit.INSTANCE;
    L6:
        Intrinsics.checkNotNullParameter((Throwable) r14, ST.IMPLICIT_ARG_NAME);
        ((com.bytedance.ai.model.g) r12).invoke(null, (String) r11, "");
        return Unit.INSTANCE;
    L8:
        Intrinsics.checkNotNullParameter((XmlSerializer) r14, "$this$insertTag");
        ((XmlSerializer) r12).text(((e0) r11).b());
        return Unit.INSTANCE;
    L10:
        XmlSerializer r16 = (XmlSerializer) r14;
        Intrinsics.checkNotNullParameter(r16, "$this$insertTag");
        XmlPullParserFactory r13 = x1.b.f22944a;
        x1.b.b(r16, w1.o.f22699b, new b2.c((String) r12, 7));
        x1.b.b(r16, u1.e.f22227i, new com.bytedance.ai.model.m(21));
        x1.b.b(r16, u1.e.f, new u1.a((Property$NodeInfo[]) r11, 1));
        return Unit.INSTANCE;
    L12:
        XmlSerializer r17 = (XmlSerializer) r14;
        Intrinsics.checkNotNullParameter(r17, "$this$insertTag");
        XmlPullParserFactory r18 = x1.b.f22944a;
        x1.b.b(r17, u1.e.f, new com.bytedance.ai.model.m(23));
        Iterator r19 = ((List) r12).iterator();
    L14:
        if (r19.hasNext() == false) goto L17;
        e0 r5 = (e0) r19.next();
        XmlPullParserFactory r20 = x1.b.f22944a;
        x1.b.b(r17, u1.e.g, new d(14, (XmlSerializer) r11, r5));
        goto L14
    L17:
        return Unit.INSTANCE;
    L20:
        Throwable r110 = (Throwable) r14;
        ((kotlinx.coroutines.sync.b) r11).getClass();
        ((kotlinx.coroutines.sync.d) r12).d(null);
        return Unit.INSTANCE;
    L22:
        com.ivy.ivykit.api.plugin.b r111 = (com.ivy.ivykit.api.plugin.b) r14;
        Intrinsics.checkNotNullParameter(r111, "response");
        com.ivy.ivykit.api.plugin.a r112 = r111.e;
        if (r112 == null) goto L31;
        byte[] r113 = r112.f9478a;
        if (r113.length == 0) goto L31;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r114 = com.bytedance.ai.utils.c.f2846a;
        if (r114 == null) goto L30;
        r114.i("AppletResourceLoader", "loadResourceAsync success");
    L30:
        ((Function1) r12).invoke(r113);
    L36:
        return Unit.INSTANCE;
    L31:
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L34;
        r115.e("AppletResourceLoader", "loadResourceAsync failed. data is empty");
    L34:
        ((Function1) r11).invoke(new Exception("data is empty"));
        goto L36
    L37:
        String r116 = ((UIUInternalDebugBroadcastReceiver) r12).f2821a;
        String r117 = "Conversation scene=" + ((ConversionScene) r11) + ", page context=" + ((String) r14);
        Intrinsics.checkNotNullParameter(r116, "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L41;
        r21.d(r116, r117);
    L41:
        return Unit.INSTANCE;
    L42:
        String r118 = ((UIUInternalDebugBroadcastReceiver) r12).f2821a;
        String r119 = androidx.constraintlayout.motion.widget.a.t(new StringBuilder("Page "), (String) r11, " context=", (String) r14);
        Intrinsics.checkNotNullParameter(r118, "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L46;
        r22.d(r118, r119);
    L46:
        return Unit.INSTANCE;
    L51:
        com.ivy.ivykit.api.plugin.b r120 = (com.ivy.ivykit.api.plugin.b) r14;
        Intrinsics.checkNotNullParameter(r120, "resourceInfo");
        String r121 = "currentThread:" + Thread.currentThread().getName() + ", res_from:" + r120.f9481c + ", url:" + ((Uri) r12);
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L54;
        r23.d("AppletResourceLoader", r121);
    L54:
        ((b0) r11).invoke(r120);
        return Unit.INSTANCE;
    L56:
        d3.a r122 = (d3.a) r14;
        Intrinsics.checkNotNullParameter(r122, "resourceInfo");
        StringBuilder r123 = new StringBuilder("currentThread:");
        r123.append(Thread.currentThread().getName());
        r123.append(", res_from:");
        String r124 = f4.b.b(r123, r122.f16586b, ", url:", (String) r12);
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L59;
        r24.d("AppletResourceLoader", r124);
    L59:
        d3.b r125 = r122.d;
        if (r125 == null) goto L62;
        r10 = new com.ivy.ivykit.api.plugin.a(r125.f16588a);
    L62:
        String r25 = r122.f16586b;
        String r26 = r122.f16587c;
        b0 r126 = (b0) r11;
        r126.invoke(new com.ivy.ivykit.api.plugin.b(r122.f16585a, 0, r25, r26, r10));
        return Unit.INSTANCE;
    L64:
        String r127 = (String) r14;
        String r128 = androidx.constraintlayout.motion.widget.a.q(r127, "msg", "createPage failed: ", r127, ", destroy webview");
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L67;
        r27.e("LynxViewFloatingPage", r128);
    L67:
        ((WebViewFloatingPageV2) r12).k();
        ((com.bytedance.ai.model.k) r11).invoke(r127);
        return Unit.INSTANCE;
    L71:
        String r129 = (String) r14;
        String r130 = androidx.constraintlayout.motion.widget.a.q(r129, "msg", "createPage failed: ", r129, ", destroy lynxView");
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L74;
        r28.e("LynxViewFloatingPage", r130);
    L74:
        ((LynxViewFloatingPage) r12).l();
        ((com.bytedance.ai.model.k) r11).invoke(r129);
        return Unit.INSTANCE;
    L19:
        return ConvertUtils.a((ReadableMap) r12, (JsonObject) r11, (String) r14);
    L48:
        return AIPackageDao_Impl.b((AIPackageDao_Impl) r12, (Widget) r11, (Continuation) r14);
    L50:
        return AIPackageDao_Impl.d((AIPackageDao_Impl) r12, (Applet) r11, (Continuation) r14);
    L70:
        return RelaxViewFloatingPageV2.i((RelaxViewFloatingPageV2) r12, (PageInfo) r11, (com.ivy.ivykit.api.plugin.b) r14);
    }
}
