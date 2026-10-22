package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.floating.enums.ShowPattern;
import com.ss.android.lark.floating.enums.SidePattern;
import com.ss.android.lark.floating.widget.activityfloat.FloatingView;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final e a;
    public final b b;

    public d() {
        this.a = new e();
        this.b = new b();
    }

    public final void a(final Context r27, final hwb.c r28) {
        Intrinsics.checkNotNullParameter(r27, "context");
        String r12 = "config";
        Intrinsics.checkNotNullParameter(r28, "config");
        int r1 = bwb.b.a;
        MmUiLogScene r2 = MmUiLogScene.FLOAT;
        bwb.b.g(r2, "showAppFloat", "recordingId=" + r28.a + ", context=" + r27.getClass().getName(), null, 8);
        final e r15 = this.a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "config");
        bwb.b.g(r2, "show", "recordingId=" + r28.a + ", context=" + r27.getClass().getName(), null, 8);
        tfb.a.b r0 = tfb.a.a;
        AppFloatManager r3 = com.ss.android.lark.floating.widget.appfloat.c.a(r28.a);
        if (r3 == null) goto L5;
        vfb.a r4 = r3.b;
    L6:
        if (r4 == null) goto L8;
        boolean r5 = r4.k;
    L9:
        if (r5 == true) goto L11;
    L16:
        r15.c();
        r15.i();
        r15.d();
        final Ref.ObjectRef r16 = new Ref.ObjectRef();
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        final Ref.ObjectRef r19 = new Ref.ObjectRef();
        final Ref.ObjectRef r20 = new Ref.ObjectRef();
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = r28.d.e;
        final hwb.a r7 = r28.c.b();
        Integer r6 = r28.d.c;
        if (r6 == null) goto L31;
        int r9 = r6.intValue();
        Integer r10 = r28.d.d;
        if (r10 == null) goto L31;
        int r11 = r10.intValue();
        int r13 = UIHelper.dp2px(r7.f);
        int r14 = UIHelper.dp2px(r7.g);
        int r110 = UIHelper.dp2px(r7.h) * 2;
        int r21 = r13 + r110;
        int r22 = r14 + r110;
        Resources r111 = r27.getResources();
        DisplayMetrics r23 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics());
        int r24 = r27.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r24 <= 0) goto L23;
        int r25 = r27.getResources().getDimensionPixelSize(r24);
    L24:
        int r112 = RangesKt.coerceAtLeast(r23.widthPixels - r21, 0);
        int r113 = RangesKt.coerceAtLeast((r23.heightPixels - r25) - r22, 0);
        int r114 = RangesKt.coerceIn(r9, 0, r112);
        int r115 = RangesKt.coerceIn(r11, 0, r113);
        if (r114 != r9) goto L29;
        if (r115 != r11) goto L29;
    L30:
        Pair r116 = TuplesKt.to(Integer.valueOf(r114), Integer.valueOf(r115));
    L32:
        StringBuilder r26 = new StringBuilder("recordingId=");
        r26.append(r28.a);
        r26.append(", x=");
        if (r116 == null) goto L35;
        Integer r29 = (Integer) r116.getFirst();
    L36:
        r26.append(r29);
        r26.append(", y=");
        if (r116 == null) goto L39;
        Integer r30 = (Integer) r116.getSecond();
    L40:
        r26.append(r30);
        bwb.b.g(r2, "restoreSystemFloatPosition", r26.toString(), null, 8);
        Intrinsics.checkNotNullParameter(r27, "activity");
        if ((r27 instanceof Activity) == false) goto L43;
        new WeakReference(r27);
    L43:
        tfb.a.a r117 = new tfb.a.a(r27);
        String r31 = r28.a;
        vfb.a r118 = r117.b;
        r118.d = r31;
        int r32 = r7.a;
        wfb.f r33 = new MmSystemRecordingFloatHost$show$1(r28, r15, r17, r16, r7, r18, r19, r20, r27, r8);
        r118.a = Integer.valueOf(r32);
        vfb.a r34 = r117.b;
        r34.A = r33;
        boolean r119 = true;
        r34.h = true;
        SidePattern r35 = SidePattern.RESULT_HORIZONTAL;
        Intrinsics.checkNotNullParameter(r35, "sidePattern");
        vfb.a r36 = r117.b;
        r36.getClass();
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        r36.m = r35;
        r117.b.f = UIHelper.dp2px(r7.i);
        r117.b.g = UIHelper.dp2px(r7.h);
        int r37 = UIHelper.dp2px(120.0f);
        vfb.a r38 = r117.b;
        r38.u = 53;
        r38.w = 0;
        r38.x = r37;
        ShowPattern r39 = ShowPattern.ALL_TIME;
        Intrinsics.checkNotNullParameter(r39, "showPattern");
        vfb.a r40 = r117.b;
        r40.getClass();
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        r40.n = r39;
        r117.b.q = true;
        if (r116 == null) goto L46;
        int r41 = ((Number) r116.component1()).intValue();
        int r42 = ((Number) r116.component2()).intValue();
        vfb.a r43 = r117.b;
        Pair r44 = new Pair(Integer.valueOf(r41), Integer.valueOf(r42));
        r43.getClass();
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r43.y = r44;
    L46:
        Function1<wfb.a.a, Unit> r120 = new MmSystemRecordingFloatHost$show$3(r28, r8, r15, r17, r16, r18, r19, r20);
        Intrinsics.checkNotNullParameter(r120, "builder");
        vfb.a r45 = r117.b;
        wfb.a r46 = new wfb.a();
        Intrinsics.checkNotNullParameter(r120, "builder");
        wfb.a.a r47 = new wfb.a.a();
        r120.invoke(r47);
        Intrinsics.checkNotNullParameter(r47, "<set-?>");
        r46.a = r47;
        r45.B = r46;
        vfb.a r48 = r117.b;
        if (r48.a != null) goto L49;
        r117.b("No layout exception. You need to set up the layout file.");
        return;
    L49:
        int r49 = tfb.a.a.a.a[r48.n.ordinal()];
        if (r49 != 1) goto L52;
    L67:
        r119 = false;
    L68:
        if (r119 == false) goto L71;
        r117.b("Uninitialized exception. You need to initialize in the application.");
        return;
    L71:
        if (r117.b.n != ShowPattern.CURRENT_ACTIVITY) goto L101;
        Context r50 = r117.a;
        if ((r50 instanceof Activity) == false) goto L99;
        Activity r51 = (Activity) r50;
        Intrinsics.checkNotNullParameter(r51, "activity");
        View r52 = r51.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L79;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r53 = ThreadMethodProxy.currentThread();
        if (r53 == com.larus.home.impl.utils.c.a) goto L79;
        com.larus.home.impl.utils.c.a(r53, "getDecorView");
    L79:
        FrameLayout r54 = (FrameLayout) r52.findViewById(R.id.content);
        vfb.a r55 = r117.b;
        Intrinsics.checkNotNullParameter(r55, r12);
        FloatingView r56 = new FloatingView(r51, null);
        String r57 = r55.d;
        if (r57 != null) goto L82;
        r57 = r51.getComponentName().getClassName();
    L82:
        r56.setTag(r57);
        int r58 = -2;
        if (r55.s == false) goto L85;
        int r59 = -1;
    L87:
        if (r55.t == false) goto L89;
        r58 = -1;
    L89:
        FrameLayout.LayoutParams r60 = new FrameLayout.LayoutParams(r59, r58);
        if (Intrinsics.areEqual(r55.y, new Pair(0, 0)) == false) goto L92;
        r60.gravity = r55.u;
    L92:
        r56.setLayoutParams(r60);
        r56.setFloatConfig(r55);
        r54.addView(r56);
        r55.b = r56;
        r55.c = r56;
        wfb.a r61 = r55.B;
        if (r61 == null) goto L114;
        wfb.a.a r62 = r61.a();
        if (r62 == null) goto L115;
        Function3 r63 = r62.a;
        if (r63 == null) goto L116;
        r63.invoke(Boolean.TRUE, null, r56);
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L85:
        r59 = -2;
        goto L87
    L99:
        r117.b("Context exception. Activity float need to pass in a activity context.");
        return;
    L101:
        if (com.ss.android.lark.floating.b.a(r117.a) == false) goto L104;
        r117.c();
        return;
    L104:
        if (r117.b.q == true) goto L109;
        FragmentActivity r64 = r117.a;
        if ((r64 instanceof FragmentActivity) == false) goto L108;
        com.ss.android.lark.floating.b.b(r64, r117);
        return;
    L108:
        r117.b("Context exception. Request Permission need to pass in a activity context.");
        return;
    L109:
        Log.i("LKUIFloat", "ban request float permission and permission is Denied");
        return;
    L52:
        if (r49 == 2) goto L65;
        if (r49 == 3) goto L65;
        if (r49 != 4) goto L63;
        if ((!r117.b.F.isEmpty()) == false) goto L67;
        if (tfb.a.b.get() == true) goto L67;
    L63:
        throw new NoWhenBranchMatchedException();
    L65:
        if (tfb.a.b.get() == true) goto L67;
    L39:
        r30 = null;
        goto L40
    L35:
        r29 = null;
    L29:
        bwb.b.g(r2, "resolveInitialPosition", "clamp system position, recordingId=" + r28.a + ", raw=(" + r9 + ',' + r11 + "), safe=(" + r114 + ',' + r115 + "), screen=" + r23.widthPixels + 'x' + r23.heightPixels + ", topOffset=" + r25 + ", float=" + r21 + 'x' + r22, null, 8);
        goto L30
    L23:
        r25 = 0;
    L31:
        r12 = "config";
        r116 = null;
        goto L32
    L11:
        if (r15.e == null) goto L16;
        bwb.b.g(r2, "show", "reuse existing float, recordingId=" + r28.a, null, 8);
        if (r15.k != null) goto L15;
        r15.f(r27, r28);
    L15:
        r15.e(r28, null);
        r28.e.f(r28.a);
        return;
    L8:
        r5 = false;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
