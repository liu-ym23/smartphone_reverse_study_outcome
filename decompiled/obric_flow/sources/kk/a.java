package kk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Path;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.ies.web.jsbridge2.l;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.LynxContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import x4.c;
import ym.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f18651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CopyOnWriteArrayList f18652c;

    public static int a(AppletPopupSchemaParam r11, View r12, Integer[] r13) {
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "margin");
        String r14 = r11.a(r12.getContext());
        switch(r14.hashCode()) {
            case -1383228885: goto L26;
            case -1364013995: goto L22;
            case 100571: goto L18;
            case 3317767: goto L14;
            case 108511772: goto L10;
            case 109757538: goto L6;
            default: goto L96;
        };
    L6:
        if (r14.equals("start") == false) goto L96;
        return GravityCompat.START;
    L10:
        if (r14.equals("right") == false) goto L96;
        return 5;
    L14:
        if (r14.equals(OpenPageMethod.ALIGN_LEFT) == false) goto L96;
        return 3;
    L18:
        if (r14.equals("end") == false) goto L96;
        return GravityCompat.END;
    L22:
        if (r14.equals("center") == false) goto L96;
        return 17;
    L26:
        if (r14.equals("bottom") == false) goto L96;
        return 81;
    L96:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L30
        Integer r10 = r13[0];     // Catch: Throwable -> L30
        r10.getClass();     // Catch: Throwable -> L30
        Object r15 = Result.m124constructorimpl(r10);     // Catch: Throwable -> L30
    L33:
        if (Result.m130isFailureimpl(r15) == false) goto L35;
        r15 = 0;
    L35:
        int r16 = ((Number) r15).intValue();
        Integer r17 = r13[1];     // Catch: Throwable -> L38
        r17.getClass();     // Catch: Throwable -> L38
        Object r18 = Result.m124constructorimpl(r17);     // Catch: Throwable -> L38
    L41:
        if (Result.m130isFailureimpl(r18) == false) goto L43;
        r18 = 0;
    L43:
        int r19 = ((Number) r18).intValue();
        Integer r20 = r13[2];     // Catch: Throwable -> L46
        r20.getClass();     // Catch: Throwable -> L46
        Object r21 = Result.m124constructorimpl(r20);     // Catch: Throwable -> L46
    L49:
        if (Result.m130isFailureimpl(r21) == false) goto L51;
        r21 = 0;
    L51:
        int r22 = ((Number) r21).intValue();
        Integer r23 = r13[3];     // Catch: Throwable -> L54
        r23.getClass();     // Catch: Throwable -> L54
        Object r24 = Result.m124constructorimpl(r23);     // Catch: Throwable -> L54
    L57:
        if (Result.m130isFailureimpl(r24) == false) goto L59;
        r24 = 0;
    L59:
        ((Number) r24).intValue();
        Integer r25 = r13[4];     // Catch: Throwable -> L62
        r25.getClass();     // Catch: Throwable -> L62
        Object r26 = Result.m124constructorimpl(r25);     // Catch: Throwable -> L62
    L65:
        if (Result.m130isFailureimpl(r26) == false) goto L67;
        r26 = 0;
    L67:
        int r27 = ((Number) r26).intValue();
        Integer r110 = r13[5];     // Catch: Throwable -> L70
        r110.getClass();     // Catch: Throwable -> L70
        Object r111 = Result.m124constructorimpl(r110);     // Catch: Throwable -> L70
    L73:
        if (Result.m130isFailureimpl(r111) == false) goto L75;
        r111 = 0;
    L75:
        int r112 = ((Number) r111).intValue();
        if (r19 <= 0) goto L78;
        int r113 = 48;
    L79:
        k.c(r12.getContext());
        if (r27 > 0) goto L104;
        if (r112 > 0) goto L105;
        if (r16 > 0) goto L106;
        if (r22 <= 0) goto L89;
        return r113 | 5;
    L89:
        return r113 | 17;
    L106:
        return r113 | 3;
    L105:
        return r113 | GravityCompat.END;
    L104:
        return r113 | GravityCompat.START;
    L78:
        r113 = 80;
    L70:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r111 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L62:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r26 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L54:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L46:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r21 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L38:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L30:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L33
    }

    public static int b(String r5, int r10, int r11) {
        return androidx.constraintlayout.motion.widget.a.c(r10, r11, r5);
    }

    public static Activity c(Context r5) {
    L3:
        if ((r5 instanceof ContextWrapper) == false) goto L9;
        if ((r5 instanceof Activity) == true) goto L7;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L3
    L7:
        return (Activity) r5;
    L9:
        return null;
    }

    public static Path d(float[] r5, boolean r10) {
        Path r11 = new Path();
        if (r5 == null) goto L13;
        int r12 = 2;
        if (r5.length < 2) goto L13;
        r11.moveTo(r5[0], r5[1]);
    L9:
        if (r12 >= r5.length) goto L11;
        r11.lineTo(r5[r12], r5[r12 + 1]);
        r12 = r12 + 2;
        goto L9
    L11:
        if (r10 == false) goto L13;
        r11.close();
    L13:
        return r11;
    }

    public static synchronized String e() {
        monitor-enter(a.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (f18651b == true) goto L27;
        f18651b = true;     // Catch: Throwable -> L23
        byte[] r5 = new byte[64];     // Catch: Throwable -> L23 IOException -> L32
        FileInputStream r10 = new FileInputStream("/proc/self/cmdline");     // Catch: Throwable -> L23 IOException -> L32
        int r11 = r10.read(r5);     // Catch: Throwable -> L15
        int r12 = 0;
    L10:
        if (r12 >= 64) goto L17;
        if (r5[r12] == 0) goto L19;
        r12 = r12 + 1;     // Catch: Throwable -> L15
    L19:
        if (r12 <= 0) goto L21;
        r11 = r12;
    L21:
        String r13 = new String(r5, 0, r11);     // Catch: Throwable -> L15
        r10.close();     // Catch: Throwable -> L23 IOException -> L32
        f18650a = r13;     // Catch: Throwable -> L23 IOException -> L32
        goto L27
    L17:
        r12 = -1;
    L15:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L23 IOException -> L32
        throw th;     // Catch: Throwable -> L23 IOException -> L32
    L27:
        String r14 = f18650a;     // Catch: Throwable -> L23
        monitor-exit(a.class);
        return r14;
    }

    public static c f(eb.a r5) {
        l r10 = new l(r5.f16812a, 1);
        r10.f6290b = null;
        r10.f6292h = r5.f16813b;
        r10.f6293i = r5.f16814c;
        r10.b(r5.d);
        r10.f6291c = "bullet_custom_bid";
        String r11 = r5.e;
        if (r11 == null) goto L6;
        r10.f6291c = r11;
    L6:
        return r10.a();
    }

    public static void g(LinearLayout r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        ViewGroup.LayoutParams r11 = null;
        if (r5 == null) goto L5;
        LinearLayout r12 = r5;
    L6:
        if (r12 == null) goto L9;
        r11 = r12.getLayoutParams();
    L9:
        if ((r11 instanceof FrameLayout.LayoutParams) == false) goto L12;
        ((FrameLayout.LayoutParams) r11).gravity = r10;
    L17:
        r5.requestLayout();
        return;
    L12:
        if ((r11 instanceof CoordinatorLayout.LayoutParams) == false) goto L15;
        ((CoordinatorLayout.LayoutParams) r11).gravity = r10;
        goto L17
    L15:
        if ((r11 instanceof LinearLayout.LayoutParams) == false) goto L17;
        ((LinearLayout.LayoutParams) r11).gravity = r10;
        goto L17
    L5:
        r12 = null;
        goto L6
    }

    public static final boolean h(Context r5) {
        if ((r5 instanceof Activity) == false) goto L13;
        Activity r10 = (Activity) r5;
        WindowManager r11 = r10.getWindowManager();
        if (r11 == null) goto L7;
        Display r12 = r11.getDefaultDisplay();
    L8:
        if (r12 == null) goto L13;
        Display r13 = r10.getWindowManager().getDefaultDisplay();
        if (r13.getWidth() < r13.getHeight()) goto L12;
        return true;
    L12:
        return false;
    L7:
        r12 = null;
    L13:
        if (r5 == null) goto L18;
        Resources r14 = r5.getResources();
        if (r14 == null) goto L18;
        DisplayMetrics r15 = r14.getDisplayMetrics();
        if (r15 == null) goto L18;
    L20:
        if (r15.widthPixels < r15.heightPixels) goto L22;
        return true;
    L22:
        return false;
    L18:
        r15 = Resources.getSystem().getDisplayMetrics();
        goto L20
    }

    public static LynxContext i(Context r5) {
    L3:
        if ((r5 instanceof ContextWrapper) == false) goto L9;
        if ((r5 instanceof LynxContext) == true) goto L7;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L3
    L7:
        return (LynxContext) r5;
    L9:
        return null;
    }

    public static final void j(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getParent() != null) goto L5;
        return;
    L5:
        if ((r5.getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r10 = r5.getParent();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r10).removeView(r5);
        return;
    }
}
