package fj;

import android.content.Context;
import android.graphics.PointF;
import android.os.HandlerThread;
import android.support.v4.media.c;
import android.text.Layout;
import android.text.Spanned;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.t;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import s8.g;
import t0.d;
import w0.f;
import ym.l;
import ym.o;
import zm.d0;
import zm.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements XBaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile s8.a f16915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f16916b;

    public static rc.c a(tc.c r5, Class r10, Class r11) {
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return r5.a(r11, "default_bid");
    }

    public static s8.a b(Context r10) {
        HandlerThread r5 = new HandlerThread("wschannel");
        r5.start();
        i4.a r11 = new i4.a(19);
        g r12 = new g(r10, r11);
        t r13 = new t(r10, new WeakHandler(r5.getLooper(), new g8.a()));
        s8.a r14 = new s8.a(r10, r5.getLooper(), new o(r10, 11), r11, r12, r13);
        r12.d = r14;
        return r14;
    }

    public static wm.a c(LynxBaseUI r10, float r11, float r12, LynxBaseUI r13, Layout r14, Spanned r15, PointF r16, boolean r17) {
        if (r14 != null) goto L4;
    L51:
        return r13;
    L4:
        if (r11 > r14.getWidth()) goto L51;
        if (r12 > r14.getHeight()) goto L51;
        int r5 = r14.getLineForVertical((int) r12);
        int r18 = r14.getParagraphDirection(r5);
        float r19 = r11 - r16.x;
        float r110 = r12 - r16.y;
        if (r110 > r14.getLineBottom(r5)) goto L51;
        if (r110 < r14.getLineTop(r5)) goto L51;
        if (r19 < r14.getLineLeft(r5)) goto L51;
        if (r19 > r14.getLineRight(r5)) goto L51;
        int r111 = r14.getOffsetForHorizontal(r5, r19);
        float r112 = r14.getPrimaryHorizontal(r111);
        if (r18 != 1) goto L23;
        if (r19 < r112) goto L24;
    L25:
        if (r15 == null) goto L27;
        h[] r113 = (h[]) r15.getSpans(r111, r111, h.class);
    L28:
        if (r113 == null) goto L51;
        if (r113.length == 0) goto L51;
        int r20 = r15.length();
        int r21 = r113.length;
        int r22 = 0;
        wm.a r23 = r13;
        int r24 = 0;
    L33:
        if (r22 >= r21) goto L42;
        h r25 = r113[r22];
        r25.getClass();
        r25.f23490c = new WeakReference(r13);
        int r26 = r15.getSpanStart(r25);
        int r27 = r15.getSpanEnd(r25);
        if (r111 < r26) goto L40;
        if (r111 > r27) goto L40;
        if (r26 < r24) goto L40;
        if (r27 > r20) goto L40;
        r25.f23490c = new WeakReference(r13);
        r23 = r25;
    L40:
        r22 = r22 + 1;
        r24 = r26;
        r20 = r27;
        goto L33
    L42:
        if ((r23 instanceof l) == false) goto L50;
        Iterator<LynxBaseUI> r28 = r10.getChildren().iterator();
    L45:
        if (r28.hasNext() == false) goto L50;
        LynxBaseUI r114 = r28.next();
        if (r114.getSign() != ((h) r23).f23488a) goto L45;
        return r114.hitTest(r11 - r114.getOriginLeft(), r12 - r114.getOriginTop(), r17);
    L50:
        return r23;
    L27:
        r113 = null;
    L24:
        r111 = r111 - 1;
        goto L25
    L23:
        if (r19 < r112) goto L25;
        goto L24
    }

    public static final void d(o1.a r5, n1.c r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        n1.a r11 = (n1.a) r10;
        j r12 = (j) r11.b(j.class);
        f r13 = null;
        if (r12 == null) goto L5;
        ContainerType r14 = r12.d();
    L6:
        if (r14 != null) goto L8;
        int r15 = -1;
    L10:
        if (r15 != 1) goto L12;
        r13 = (f) r11.b(f.class);
    L12:
        String r16 = r5.getName() + " getAIContainerView " + r13;
        Intrinsics.checkNotNullParameter("FloatingSpeaker", "tag");
        d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L16;
        r17.d("FloatingSpeaker", r16);
        return;
    L16:
        return;
    L8:
        r15 = com.bytedance.ai.bridge.method.floatinginput.a.f1823a[r14.ordinal()];
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    public static /* synthetic */ void e(o1.f r5, ResultModel r10) {
        r5.b(r10, "");
    }

    public static void f(d0 r5, LynxBaseUI r10) {
        HashSet r11 = r5.d;
        Iterator<LynxBaseUI> r12 = r10.getChildren().iterator();
    L4:
        if (r12.hasNext() == false) goto L22;
        LynxBaseUI r13 = r12.next();
        if ((r13 instanceof LynxUI) == false) goto L4;
        LynxUI r14 = (LynxUI) r13;
        if (r11 != null) goto L11;
    L13:
        boolean r15 = false;
    L14:
        if (r15 == false) goto L18;
        if (r14.getVisibility() == false) goto L18;
        r14.setVisibilityForView(4);
    L18:
        if (r15 == true) goto L4;
        if (r14.getVisibility() == true) goto L4;
        r14.setVisibilityForView(0);
        goto L4
    L11:
        if (r11.contains(Integer.valueOf(r14.getSign())) == false) goto L13;
        r15 = true;
        goto L14
    }

    public static s8.a g(Context r5) {
        if (f16915a != null) goto L16;
        monitor-enter(s8.a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f16915a != null) goto L11;
        f16915a = b(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(s8.a.class);     // Catch: Throwable -> L9
    L16:
        return f16915a;
    }
}
