package com.bytedance.ai.applet.login;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.widget.Toast;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$4$1;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.model.p;
import com.google.gson.JsonSyntaxException;
import com.lynx.tasm.ui.image.f0;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import w2.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f1750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference f1751b;

    static {
        f1750a = new LinkedHashMap();
        f1751b = new WeakReference(null);
        h0.a(Dispatchers.getMain().plus(j0.b()));
    }

    public static a a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        a r10 = (a) f1750a.get(r5);
        if (r10 != null) goto L7;
        String r11 = com.lynx.tasm.behavior.utils.d.c("getLoginContext failed for applet: ", r5, "McpLoginManager");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L7;
        r12.w("McpLoginManager", r11);
    L7:
        return r10;
    }

    public static void b(String r10, DialogAction r11, OperationType r12) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter(r12, "operationType");
        LinkedHashMap r5 = f1750a;
        a r13 = (a) r5.get(r10);
        if (r13 != null) goto L9;
        String r14 = com.lynx.tasm.behavior.utils.d.c("onDrawerDialogAction: Can not find loginContext of ", r10, "McpLoginManager");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L50;
        r15.e("McpLoginManager", r14);
        return;
    L50:
        return;
    L9:
        if (Intrinsics.areEqual(r10, null) == true) goto L14;
        String r16 = com.lynx.tasm.behavior.utils.d.c("onDrawerDialogAction: Received from non-active applet: ", r10, "McpLoginManager");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L51;
        r17.e("McpLoginManager", r16);
        return;
    L51:
        return;
    L14:
        f8.b r18 = r13.f1735c;
        String r19 = "onDrawerDialogAction: appletId=" + r10 + ", action=" + r11 + ", operationType=" + r12 + ", currentState=" + r18;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L17;
        r20.i("McpLoginManager", r19);
    L17:
        int r21 = r11.ordinal();
        if (r21 != 0) goto L20;
        a r22 = (a) r5.get(r10);
        if (r22 != null) goto L39;
        String r23 = com.lynx.tasm.behavior.utils.d.c("handleDialogAgree: Can not find loginContext of ", r10, "McpLoginManager");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L52;
        r24.e("McpLoginManager", r23);
        return;
    L52:
        return;
    L39:
        StringBuilder r25 = com.lynx.tasm.utils.e.b("handleDialogAgree: applet: ", r10, ", currentState: ");
        r25.append(r22.f1735c);
        r25.append(", opType: ");
        r25.append(r12);
        String r26 = r25.toString();
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L43;
        r27.i("McpLoginManager", r26);
    L43:
        if ((r22.f1735c instanceof f) == true) goto L48;
        String r28 = "handleDialogAgree called in unexpected state: " + r22.f1735c;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L53;
        r29.w("McpLoginManager", r28);
        return;
    L53:
        return;
    L48:
        c(r10, i.f1749a);
        return;
    L20:
        if (r21 == 1) goto L28;
        if (r21 != 2) goto L26;
        c(r10, g.f1747a);
        return;
    L26:
        throw new NoWhenBranchMatchedException();
    L28:
        if ((r18 instanceof f) == false) goto L30;
        FinishReason r30 = FinishReason.f1725c;
    L31:
        c(r10, new e(r30));
        return;
    L30:
        r30 = FinishReason.f;
        goto L31
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(String r18, f8.b r19) {
        LinkedHashMap r5 = f1750a;
        a r10 = (a) r5.get(r18);
        if (r10 != null) goto L8;
        String r11 = com.lynx.tasm.behavior.utils.d.c("transitionTo: Can not find loginContext: ", r18, "McpLoginManager");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L110;
        r12.e("McpLoginManager", r11);
        return;
    L110:
        return;
    L8:
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r10.f1735c = r19;
        String r13 = "Applet [" + r18 + "] transitioned to " + r19;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L11;
        r14.i("McpLoginManager", r13);
    L11:
        LifecycleOwner r15 = null;
        if ((r19 instanceof f) == false) goto L35;
        Activity r16 = s0.c.b();
        if (r16 != 0) goto L18;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L104;
        r17.e("McpLoginManager", "Top activity is null");
        return;
    L104:
        return;
    L18:
        a r20 = (a) r5.get(r18);
        if (r20 == null) goto L30;
        r r21 = r20.f1734b;
        if (r21 == null) goto L30;
        if ((r16 instanceof LifecycleOwner) == false) goto L26;
        r15 = (LifecycleOwner) r16;
    L26:
        if (r15 == null) goto L106;
        LifecycleCoroutineScope r22 = LifecycleOwnerKt.getLifecycleScope(r15);
        if (r22 == null) goto L107;
        BuildersKt.launch$default(r22, Dispatchers.getMain(), null, new McpLoginManager$loadAddShowWidget$1(r21, r18, "mcp-login-card", r16, null), 2, null);
        return;
    L107:
        return;
    L106:
        return;
    L30:
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L109;
        r23.e("McpLoginManager", "loadAddShowWidget: renderContext is null");
        return;
    L109:
        return;
    L35:
        if ((r19 instanceof g) == false) goto L37;
        return;
    L37:
        if ((r19 instanceof i) == false) goto L39;
        return;
    L39:
        if ((r19 instanceof e) == false) goto L113;
        FinishReason r24 = ((e) r19).f1746a;
        String r25 = "finishLoginProcessing reason: ".concat(r24.f1726a);
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L43;
        r26.i("McpLoginManager", r25);
    L43:
        a r27 = (a) r5.get(r18);
        if (r27 == null) goto L48;
        r r28 = r27.f1734b;
        if (r28 == null) goto L48;
        String r29 = r28.f22705a;
    L49:
        if (r29 != null) goto L51;
    L100:
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r30 = com.bytedance.ai.utils.c.f2846a;
        if (r30 == null) goto L115;
        r30.e("McpLoginManager", "finishLoginProcessing: messageId is null");
        return;
    L115:
        return;
    L51:
        if (r29.length() == 0) goto L100;
        c r31 = (c) f1751b.get();
        switch(r24.ordinal()) {
            case 0: goto L96;
            case 1: goto L93;
            case 2: goto L90;
            case 3: goto L87;
            case 4: goto L72;
            case 5: goto L60;
            case 6: goto L57;
            default: goto L56;
        };
    L57:
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r32 = com.bytedance.ai.utils.c.f2846a;
        if (r32 == null) goto L99;
        r32.d("McpLoginManager", "finishLoginProcessing: timeout");
    L99:
        Intrinsics.areEqual(null, r18);
        return;
    L60:
        Activity r110 = s0.c.b();
        if (r110 == null) goto L69;
        ToastBuilder r33 = new ToastBuilder(r110, "Login failed with unknown error", "error", null, null, null, 56, null);
        AISdkInitializer$injectAIBridgeBaseRuntime$4$1 r34 = k5.d.d;
        if (r34 == null) goto L65;
        Boolean r35 = r34.showToast(r33);
    L67:
        if (Intrinsics.areEqual(r35, Boolean.TRUE) == true) goto L69;
        Intrinsics.checkNotNullParameter(r33, "toastBuilder");
        Toast.makeText(r33.getContext(), r33.getMessage(), 0).show();
        goto L69
    L65:
        r35 = null;
    L69:
        t0.b r36 = p.f2294c;
        if (r36 == null) goto L99;
        r36.resendUserQueryAfterLogin(r29, false, "Business login failed");
        goto L99
    L72:
        if (r31 == null) goto L74;
        ComponentCallbacks2 r37 = r31.d;
    L76:
        if ((r37 instanceof LifecycleOwner) == false) goto L78;
        LifecycleOwner r38 = (LifecycleOwner) r37;
    L79:
        if (r38 == null) goto L83;
        LifecycleCoroutineScope r39 = LifecycleOwnerKt.getLifecycleScope(r38);
        if (r39 == null) goto L83;
        BuildersKt.launch$default(r39, Dispatchers.getMain(), null, new McpLoginManager$finishLoginProcessing$1(null), 2, null);
    L83:
        t0.b r40 = p.f2294c;
        if (r40 == null) goto L86;
        r40.resendUserQueryAfterLogin(r29, true, null);
    L86:
        r5.remove(r18);
        goto L99
    L78:
        r38 = null;
        goto L79
    L74:
        r37 = null;
        goto L76
    L87:
        t0.b r41 = p.f2294c;
        if (r41 == null) goto L99;
        r41.resendUserQueryAfterLogin(r29, false, "User rejected on combined");
        goto L99
    L90:
        t0.b r42 = p.f2294c;
        if (r42 == null) goto L99;
        r42.resendUserQueryAfterLogin(r29, false, "User rejected login");
        goto L99
    L93:
        t0.b r43 = p.f2294c;
        if (r43 == null) goto L99;
        r43.resendUserQueryAfterLogin(r29, false, "User rejected privacy");
        goto L99
    L96:
        t0.b r44 = p.f2294c;
        if (r44 == null) goto L99;
        r44.resendUserQueryAfterLogin(r29, false, "User rejected on card");
        goto L99
    L56:
        throw new NoWhenBranchMatchedException();
    L48:
        r29 = null;
        goto L49
    }

    public static void d(r r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        t0.b r5 = p.f2294c;
        if (r5 == null) goto L5;
        Map r11 = r5.getAccountInfo();
    L6:
        if (r11 == null) goto L8;
        Object r12 = r11.get("isLogin");
    L10:
        if ((r12 instanceof Boolean) == false) goto L12;
        Boolean r13 = (Boolean) r12;
    L14:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == true) goto L19;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L96;
        r14.w("McpLoginManager", "Interceptor: User has not login");
        return;
    L96:
        return;
    L19:
        WidgetInfo r15 = r10.e;
        if (r15 == null) goto L22;
        String r16 = r15.getAppletId();
    L23:
        if (r16 != null) goto L25;
    L90:
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L101;
        r17.e("McpLoginManager", "Interceptor: appletId is null");
        return;
    L101:
        return;
    L25:
        if (r16.length() == 0) goto L90;
        WidgetInfo r18 = r10.e;
        if (r18 == null) goto L30;
        String r19 = r18.getWidgetId();
    L32:
        if (Intrinsics.areEqual(r19, "system.login.authRequest") == true) goto L37;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L97;
        r20.d("McpLoginManager", "Interceptor: flagWidgetId not login");
        return;
    L97:
        return;
    L37:
        String r21 = androidx.room.jarjarred.org.antlr.runtime.a.r("Interceptor: ", r16, " will show login card", "McpLoginManager", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L40;
        r22.i("McpLoginManager", r21);
    L40:
        WidgetInfo r23 = r10.e;
        if (r23 == null) goto L43;
        String r24 = r23.getWidgetData();
    L44:
        if (r24 != null) goto L46;
    L60:
        d r25 = null;
    L61:
        if (r25 != null) goto L63;
        return;
    L63:
        String r26 = r25.a();
        if (r26.length() != 0) goto L69;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L98;
        r27.e("McpLoginManager", "Interceptor: targetAppletId is empty");
        return;
    L98:
        return;
    L69:
        LinkedHashMap r28 = f1750a;
        if (((a) r28.get(r26)) == null) goto L74;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L74;
        r29.w("McpLoginManager", "Interceptor: oldLoginContext is not null");
    L74:
        r28.put(r26, new a(r25, r10));
        t0.b r30 = p.f2294c;
        if (r30 == null) goto L77;
        r30.getNativeLoginCard();
    L77:
        r10.g.onPageFinish();
        c r31 = (c) f1751b.get();
        if (r31 == null) goto L80;
        ComponentCallbacks2 r32 = r31.d;
    L82:
        if ((r32 instanceof LifecycleOwner) == false) goto L84;
        LifecycleOwner r33 = (LifecycleOwner) r32;
    L85:
        if (r33 == null) goto L99;
        LifecycleCoroutineScope r34 = LifecycleOwnerKt.getLifecycleScope(r33);
        if (r34 == null) goto L100;
        BuildersKt.launch$default(r34, Dispatchers.getMain(), null, new McpLoginManager$mcpLoginInterceptor$1(null), 2, null);
        return;
    L100:
        return;
    L99:
        return;
    L84:
        r33 = null;
        goto L85
    L80:
        r32 = null;
        goto L82
    L46:
        if (StringsKt.isBlank(r24) == true) goto L60;
        r25 = (d) com.bytedance.pia.core.utils.i.a().fromJson(r24, d.class);     // Catch: Exception -> L50 JsonSyntaxException -> L52
    L52:
        e = move-exception;
        String r35 = "parseLoginData JsonSyntaxException: " + e.getMessage();
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r36 = com.bytedance.ai.utils.c.f2846a;
        if (r36 == null) goto L60;
        r36.e("McpLoginManager", r35);
    L50:
        e = move-exception;
        String r37 = f0.d(e, new StringBuilder("parseLoginData Exception: "), "McpLoginManager");
        t0.d r38 = com.bytedance.ai.utils.c.f2846a;
        if (r38 == null) goto L60;
        r38.e("McpLoginManager", r37);
        goto L60
    L43:
        r24 = null;
        goto L44
    L30:
        r19 = null;
        goto L32
    L22:
        r16 = null;
        goto L23
    L12:
        r13 = null;
        goto L14
    L8:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        String r5 = "postLoginFailed: appletId=" + r10;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.i("McpLoginManager", r5);
    L5:
        LinkedHashMap r12 = f1750a;
        a r13 = (a) r12.get(r10);
        f8.b r14 = null;
        if (r13 == null) goto L8;
        f8.b r15 = r13.f1735c;
    L10:
        if ((r15 instanceof i) == true) goto L17;
        StringBuilder r16 = new StringBuilder("current state=");
        a r17 = (a) r12.get(r10);
        if (r17 == null) goto L14;
        r14 = r17.f1735c;
    L14:
        r16.append(r14);
        String r18 = r16.toString();
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L17;
        r19.w("McpLoginManager", r18);
    L17:
        c(r10, new e(FinishReason.f));
        return;
    L8:
        r15 = null;
        goto L10
    }

    public static void f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        String r5 = "postLoginSuccess: appletId=".concat(r10);
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.i("McpLoginManager", r5);
    L5:
        LinkedHashMap r12 = f1750a;
        a r13 = (a) r12.get(r10);
        f8.b r14 = null;
        if (r13 == null) goto L8;
        f8.b r15 = r13.f1735c;
    L10:
        if ((r15 instanceof i) == true) goto L17;
        StringBuilder r16 = new StringBuilder("current state=");
        a r17 = (a) r12.get(r10);
        if (r17 == null) goto L14;
        r14 = r17.f1735c;
    L14:
        r16.append(r14);
        String r18 = r16.toString();
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L17;
        r19.w("McpLoginManager", r18);
    L17:
        c(r10, new e(FinishReason.e));
        return;
    L8:
        r15 = null;
        goto L10
    }
}
