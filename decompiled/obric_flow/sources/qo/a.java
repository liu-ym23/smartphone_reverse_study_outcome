package qo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleEventObserver;
import com.bytedance.android.anniex.container.m;
import com.bytedance.android.anniex.container.ui.AnnieXDialog;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt$setWindowSoftInput$callback$1;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt$setWindowSoftInputCompatible$1;
import com.bytedance.ies.bullet.service.base.d;
import com.bytedance.ies.bullet.settings.b;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.o0;
import com.obric.launcher.widget.R$id;
import com.obric.oui.constraintlayout.core.widgets.analyzer.f;
import gr.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mn.h;
import org.json.JSONArray;
import org.json.JSONObject;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static String a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return "webx";
    L7:
        if (r5.startsWith("webx_") == false) goto L9;
        return r5;
    L9:
        return "webx_".concat(r5);
    }

    public static ArrayList b(JSONArray r5) {
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L11
        if (r5 != null) goto L5;
    L13:
        return r10;
    L5:
        if (r5.length() <= 0) goto L13;
        int r11 = 0;
    L8:
        if (r11 >= r5.length()) goto L13;
        r10.add(r5.optString(r11));     // Catch: Throwable -> L11
        r11 = r11 + 1;
    L11:
        th = move-exception;
        h.g("default_handle", th);
        return new ArrayList();
    }

    public static JSONObject c(String r5) {
    L6:
        e = move-exception;
        h.g("default_handle", e);
        return new JSONObject();
    L3:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return new JSONObject();
    L9:
        return new JSONObject(r5);
    }

    public static JSONObject d(JSONObject r5, String r10) {
        if (r5 != null) goto L6;
        return new JSONObject();
    L6:
        return r5.optJSONObject(r10);
    }

    public static void e(int r5, String r10, JSONObject r11) {
        r11.put(r10, r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        h.g("default_handle", e);
    }

    public static final void f(final Window r10, final View r11, final Function1 r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        View r5 = r10.getDecorView();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        WindowInsetsControllerCompat r13 = ViewCompat.getWindowInsetsController(r5);
        if (r13 != null) goto L5;
    L8:
        r10.setSoftInputMode(16);
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        final Ref.BooleanRef r15 = new Ref.BooleanRef();
        c r16 = c.f22119c;
        b r17 = (b) fj.a.a(c.f22119c, b.class, b.class);
        if (r17 == null) goto L13;
        d r18 = (d) r17.f6163b.getValue();
        if (r18 == null) goto L13;
        int r19 = r18.f;
    L14:
        ViewTreeObserver.OnGlobalLayoutListener r20 = null;
        if (r19 != 2) goto L24;
        Object r21 = r10.getDecorView().getTag(R$id.bullet_container);
        if ((r21 instanceof com.bytedance.ies.bullet.base.utils.keyboard.c) == false) goto L19;
        com.bytedance.ies.bullet.base.utils.keyboard.c r22 = (com.bytedance.ies.bullet.base.utils.keyboard.c) r21;
    L20:
        if (r22 != null) goto L22;
        r22 = new com.bytedance.ies.bullet.base.utils.keyboard.c();
        r22.f5244a = null;
        r10.getDecorView().setTag(R$id.bullet_container, r22);
    L22:
        r22.f5244a = new WeakReference(new SoftInputKt$setWindowSoftInputCompatible$1(r10, r15, r14, r12));
        r10.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(r22);
        return;
    L19:
        r22 = null;
        goto L20
    L24:
        ViewTreeObserver r23 = r10.getDecorView().getViewTreeObserver();
        com.bytedance.ies.bullet.base.utils.keyboard.b r24 = new com.bytedance.ies.bullet.base.utils.keyboard.b(r10, r15, r14, r12);
        if (r19 != 1) goto L32;
        Object r25 = r10.getDecorView().getTag(R$id.bullet_container);
        if ((r25 instanceof ViewTreeObserver.OnGlobalLayoutListener) == false) goto L29;
        r20 = (ViewTreeObserver.OnGlobalLayoutListener) r25;
    L29:
        if (r20 == null) goto L31;
        r10.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(r20);
    L31:
        r10.getDecorView().setTag(R$id.bullet_container, r24);
    L32:
        r23.addOnGlobalLayoutListener(r24);
        return;
    L13:
        r19 = 1;
        goto L14
    L5:
        if (r13.getSystemBarsBehavior() == 0) goto L8;
        LifecycleEventObserver r26 = com.bytedance.ies.bullet.base.utils.keyboard.a.f5240a;
        r10.setSoftInputMode(48);
        new Ref.BooleanRef();
        final Ref.BooleanRef r27 = new Ref.BooleanRef();
        new Ref.IntRef();
        final Ref.ObjectRef r28 = new Ref.ObjectRef();
        new Ref.FloatRef();
        ViewCompat.setWindowInsetsAnimationCallback(r10.getDecorView(), new SoftInputKt$setWindowSoftInput$callback$1(r27, r10, r11, r28, r12));
    }

    public static final void g(LynxView r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();
        Intrinsics.checkNotNullParameter(r5, "view");
        d5.b.f("LynxViewMonitor", "unregisterLynxViewMonitor");
        String r10 = null;
        com.bytedance.android.monitorV2.lynx.impl.d r11 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k.a(r5, null);
        WeakReference r12 = r11.d;
        if (r12 == null) goto L5;
        r5.removeLynxViewClient((o0) r12.get());
        r11.d = null;
    L5:
        Intrinsics.checkNotNullParameter(r5, "view");
        com.bytedance.android.monitorV2.lynx.impl.d r13 = (com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3686n.remove(r5);
        WeakHashMap r14 = com.bytedance.android.monitorV2.lynx.impl.d.f3687o;
        if (r13 == null) goto L8;
        r10 = r13.f3690i;
    L8:
        r14.remove(r10);
    }

    public static final void h(LynxView r5, f r10) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "lynxMonitorConfig");
        if (r10.f12567a == false) goto L9;
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "config");
        d5.b.f("LynxViewMonitor", "registerLynxViewMonitor");
        com.bytedance.android.monitorV2.lynx.impl.d r11 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k.a(r5, (String) r10.f12570h);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r11.f3688c = r10;
        o0 r12 = new com.bytedance.android.monitorV2.lynx_helper.a(new WeakReference(r5));
        r5.addLynxViewClient(r12);
        String r13 = (String) r10.f12570h;
        if (r13 == null) goto L7;
        HashMap r14 = new HashMap();
        r14.put("bdx_monitor_session_id", r13);
        r5.putParamsForReportingEvents(r14);
    L7:
        r11.d = new WeakReference(r12);
        return;
    }

    public static /* synthetic */ void i(Object r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        throw new ClassCastException();
    }

    public static void j(Object r5, String r10, JSONObject r11) {
        r11.put(r10, r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        h.g("default_handle", e);
    }

    public static void k(String r5, long r10, JSONObject r11) {
        r11.put(r5, r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        h.g("default_handle", e);
    }

    public static void l(JSONObject r5, String r10, String r11) {
    L6:
        e = move-exception;
        h.g("default_handle", e);
        return;
    L3:
        if (TextUtils.isEmpty(r11) == true) goto L11;
        r5.put(r10, r11);     // Catch: Exception -> L6
        return;
    }

    public static void m(JSONObject r5, JSONObject r10) {
        if (r5 == null) goto L17;
        if (r10 == null) goto L18;
        Iterator<String> r11 = r10.keys();     // Catch: Exception -> L10
    L7:
        if (r11.hasNext() == false) goto L19;
        String r12 = r11.next();     // Catch: Exception -> L10
        j(r10.opt(r12), r12, r5);     // Catch: Exception -> L10
        goto L7
    L19:
        return;
    L10:
        e = move-exception;
        h.g("default_handle", e);
        return;
    L18:
        return;
    }

    public static void n(w3.a r10) {
        r3.c r5 = (r3.c) r10.f22712b;
        Bundle r11 = r5.f21654c;
        Intrinsics.checkNotNullParameter(r11, "bundle");
        String r12 = r11.getString("__x_session_id");
        if (r12 == null) goto L8;
        long r13 = r11.getLong("open_time", 0);
        if (r13 <= 0) goto L7;
        LinkedHashMap r14 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.j(r12, Long.valueOf(r13));
        goto L8
    L7:
        LinkedHashMap r15 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.j(r12, Long.valueOf(System.currentTimeMillis()));
    L8:
        m r16 = (m) r10.d;
        Context r17 = r16.getSystemContext();
        if (r17 == null) goto L11;
        com.bytedance.ies.bullet.base.b.a(r17);
    L11:
        AnnieXDialog r18 = (AnnieXDialog) r10.f22713c;
        if (r18 != null) goto L18;
        r18 = new AnnieXDialog();
        r18.setArguments(r5.f21654c);
        Intrinsics.checkNotNullParameter(r16, "popupContainer");
        r18.f3180a = r16;
        s6.b r19 = (s6.b) r10.e;
        if (r19 == null) goto L17;
        Intrinsics.checkNotNullParameter(r19, "listener");
    L17:
        r10.f22713c = r18;
    L18:
        FragmentActivity r20 = r5.f21650i;
        if (r20 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentActivity");
        r20 = null;
    L22:
        r18.show(r20.getSupportFragmentManager(), "annie_x_dialog");
    }

    public static boolean o(JSONObject r10, JSONObject r11, String... r12) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L7;
        return true;
    L7:
        if (r10 == null) goto L16;
        if (r11 == null) goto L16;
        int r5 = r12.length;
        int r13 = 0;
    L10:
        if (r13 >= r5) goto L15;
        String r14 = r12[r13];
        if (r10.optString(r14, "").equals(r11.optString(r14, "")) == false) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public static String p(String r5, JSONObject r10) {
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.optString(r5, "");
    }

    public static JSONObject q(JSONObject r5, JSONObject r10) {
        if (r5 == null) goto L4;
        if (r10 != null) goto L9;
        return r5;
    L9:
        Iterator<String> r11 = r10.keys();     // Catch: Throwable -> L5
    L11:
        if (r11.hasNext() == false) goto L18;
        String r12 = r11.next();     // Catch: Throwable -> L5
        Object r13 = r10.opt(r12);     // Catch: Throwable -> L5
        if ((r13 instanceof JSONObject) == true) goto L14;
        j(r13, r12, r5);     // Catch: Throwable -> L5
        goto L11
    L14:
        j(q(r5.optJSONObject(r12), r10.optJSONObject(r12)), r12, r5);     // Catch: Throwable -> L5
    L18:
        return r5;
    L4:
        return q(new JSONObject(), r10);
    L5:
        th = move-exception;
        h.g("default_handle", th);
        goto L18
    }

    public static void r(String r5, String r10, JSONObject r11) {
        if (r10 == null) goto L10;
        r11.put(r5, r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        h.g("default_handle", e);
        return;
    }

    public static String s(String r5, String r10, JSONObject r11) {
        if (r11 != null) goto L9;
    L8:
        return r10;
    L9:
        return r11.optString(r5, r10);
    L6:
        th = move-exception;
        h.g("default_handle", th);
        goto L8
    }

    public static void t(String r5, String r10, JSONObject r11) {
        r11.put(r5, r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        h.g("default_handle", e);
    }

    public static a u(int r10, double[] r11, double[][] r12) {
        if (r11.length != 1) goto L5;
        r10 = 2;
    L5:
        if (r10 == 0) goto L21;
        if (r10 == 2) goto L18;
        g r13 = new g();
        int r5 = r12[0].length;
        r13.f17151c = new double[r5];
        r13.f17149a = r11;
        r13.f17150b = r12;
        if (r5 <= 2) goto L17;
        double r14 = 0.0d;
        int r15 = 0;
    L11:
        double r16 = r14;
        if (r15 >= r11.length) goto L17;
        double r17 = r12[r15][0];
        if (r15 <= 0) goto L16;
        Math.hypot(r17 - r14, r17 - r16);
    L16:
        r15 = r15 + 1;
        r14 = r17;
    L17:
        return r13;
    L18:
        double r18 = r11[0];
        double[] r19 = r12[0];
        gr.c r20 = new gr.c();
        r20.f17140a = r18;
        r20.f17141b = r19;
        return r20;
    L21:
        return new gr.h(r11, r12);
    }

    public abstract double[] A();

    public abstract double v(double r5);

    public abstract void w(double r5, double[] r10);

    public abstract void x(double r5, float[] r10);

    public abstract double y(double r5);

    public abstract void z(double r5, double[] r10);
}
