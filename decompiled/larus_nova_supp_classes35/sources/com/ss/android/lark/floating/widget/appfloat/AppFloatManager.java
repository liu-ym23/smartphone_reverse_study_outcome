package com.ss.android.lark.floating.widget.appfloat;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.floating.enums.SideHideDirection;
import com.ss.android.lark.floating.enums.SidePattern;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AppFloatManager {
    public final Context a;
    public final vfb.a b;
    public WindowManager c;
    public h d;
    public com.ss.android.lark.floating.widget.appfloat.d e;
    public TouchUtils f;
    public int g;
    public Integer h;
    public Integer i;
    public final int[] j;
    public final Rect k;
    public final e l;
    public Animator m;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SidePattern.values().length];
            r0[SidePattern.AUTO_HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[SidePattern.RESULT_HORIZONTAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[SidePattern.RESULT_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[SidePattern.RESULT_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[SidePattern.LEFT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[SidePattern.RIGHT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[SidePattern.AUTO_VERTICAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[SidePattern.RESULT_VERTICAL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[SidePattern.RESULT_TOP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[SidePattern.RESULT_BOTTOM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[SidePattern.TOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[SidePattern.BOTTOM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    public static final class d implements wfb.e {
        public final /* synthetic */ AppFloatManager a;
        public final /* synthetic */ com.ss.android.lark.floating.widget.appfloat.d b;

        public static final class a implements b {
            public final /* synthetic */ AppFloatManager a;

            @Override // com.ss.android.lark.floating.widget.appfloat.AppFloatManager.b
            public final void a() {
                AppFloatManager r0 = this.a;
                r0.b(r0.b.z);
            }

            public a(AppFloatManager r1) {
                this.a = r1;
            }
        }

        @Override // wfb.e
        public final void onTouch(MotionEvent r18) {
            Intrinsics.checkNotNullParameter(r18, "event");
            TouchUtils r3 = this.a.f;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
            r3 = null;
        L5:
            com.ss.android.lark.floating.widget.appfloat.d r7 = this.b;
            WindowManager r8 = this.a.f();
            h r6 = this.a.e();
            AppFloatManager r4 = this.a;
            int r9 = r4.b.w;
            a r10 = new a(r4);
            r3.getClass();
            Intrinsics.checkNotNullParameter(r7, "view");
            Intrinsics.checkNotNullParameter(r18, "event");
            Intrinsics.checkNotNullParameter(r8, "windowManager");
            Intrinsics.checkNotNullParameter(r6, "params");
            Intrinsics.checkNotNullParameter(r10, Keys.API_PARAM_KEY_ACTION);
            r3.b.getClass();
            wfb.a r2 = r3.b.B;
            if (r2 == null) goto L9;
            r2.a();
        L9:
            if (r3.e != 0) goto L12;
            r3.e = xfb.d.b(r3.a);
        L12:
            if (r3.d != 0) goto L14;
            r3.d = r3.b.E.a(r3.a);
        L14:
            r7.getLocationOnScreen(r3.n);
            boolean r5 = true;
            int r11 = 0;
            if (r3.n[1] <= ((WindowManager.LayoutParams) r6.a).y) goto L17;
            boolean r12 = true;
        L18:
            r3.p = r12;
            r3.o = r3.d - r7.getHeight();
            vfb.a r13 = r3.b;
            if (r13.h == true) goto L21;
        L158:
            r13.i = false;
            r3.f = r18.getRawX();
            r3.g = r18.getRawY();
            Log.i("TouchUtils", "config.dragEnable: " + r3.b.h + ", config.isAnim: " + r3.b.j + ", return");
            return;
        L21:
            if (r13.j == true) goto L158;
            int r14 = r18.getAction() & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
            if (r14 == 0) goto L157;
            if (r14 != 1) goto L27;
            vfb.a r1 = r3.b;
            if (r1.i == true) goto L140;
            return;
        L140:
            switch(TouchUtils.b.a[r1.m.ordinal()]) {
                case 8: goto L148;
                case 9: goto L148;
                case 10: goto L148;
                case 11: goto L148;
                case 12: goto L148;
                case 13: goto L148;
                case 14: goto L143;
                default: goto L141;
            };
        L141:
            r3.t = SideHideDirection.NONE;
            r3.b.getClass();
            wfb.a r15 = r3.b.B;
            if (r15 == null) goto L156;
            wfb.a.C0318a r16 = r15.a();
            if (r16 == null) goto L156;
            Function1<? super View, Unit> r17 = r16.e;
            if (r17 == null) goto L156;
            r17.invoke(r7);
        L156:
            r3.b.i = false;
            return;
        L148:
            r3.g(r7, r6, r9, r8, r10);
            goto L156
        L143:
            if (Intrinsics.areEqual(r3.b.e, Boolean.TRUE) == true) goto L145;
        L147:
            r3.g(r7, r6, r9, r8, r10);
            goto L156
        L145:
            if (r3.r == false) goto L147;
            r3.h(new TouchUtils$sideHideAnim$1(r3, r6, r7, r8, r10, true));
            goto L156
        L27:
            if (r14 != 2) goto L29;
            float r19 = r18.getRawX() - r3.f;
            float r20 = r18.getRawY() - r3.g;
            vfb.a r110 = r3.b;
            if (r110.i == false) goto L38;
        L40:
            r110.i = true;
            WindowManagerLayoutParamsInternal r111 = r6.a;
            int r112 = ((WindowManager.LayoutParams) r111).x + ((int) r19);
            int r21 = ((WindowManager.LayoutParams) r111).y + ((int) r20);
            Boolean r22 = r110.e;
            Boolean r113 = Boolean.TRUE;
            if (Intrinsics.areEqual(r22, r113) == true) goto L43;
            if (r112 >= 0) goto L51;
            r112 = 0;
        L53:
            if (r21 >= 0) goto L56;
            r21 = 0;
        L63:
            boolean r23 = r3.r;
            if (Intrinsics.areEqual(r3.b.e, r113) == true) goto L66;
        L71:
            boolean r114 = false;
        L72:
            r3.r = r114;
            if (r23 == r114) goto L85;
            r3.f(r6, r7);
            r3.l();
            wfb.a r24 = r3.b.B;
            if (r24 == null) goto L85;
            wfb.a.C0318a r25 = r24.a();
            if (r25 == null) goto L85;
            Function2<? super Boolean, ? super Boolean, Unit> r26 = r25.c;
            if (r26 == null) goto L85;
            Boolean r115 = Boolean.valueOf(r3.r);
            if (r3.t != SideHideDirection.RIGHT) goto L83;
            boolean r116 = true;
        L84:
            r26.invoke(r115, Boolean.valueOf(r116));
            goto L85
        L83:
            r116 = false;
        L85:
            boolean r27 = r3.s;
            if (Intrinsics.areEqual(r3.b.e, r113) == true) goto L88;
        L93:
            boolean r117 = false;
        L94:
            r3.s = r117;
            if (r27 == r117) goto L108;
            r3.f(r6, r7);
            r3.l();
            wfb.a r28 = r3.b.B;
            if (r28 == null) goto L108;
            wfb.a.C0318a r29 = r28.a();
            if (r29 == null) goto L108;
            Function2<? super Boolean, ? super Boolean, Unit> r30 = r29.d;
            if (r30 == null) goto L108;
            Boolean r118 = Boolean.valueOf(r3.s);
            if (r3.t == SideHideDirection.RIGHT) goto L106;
            r5 = false;
        L106:
            r30.invoke(r118, Boolean.valueOf(r5));
        L108:
            switch(TouchUtils.b.a[r3.b.m.ordinal()]) {
                case 1: goto L132;
                case 2: goto L129;
                case 3: goto L128;
                case 4: goto L126;
                case 5: goto L123;
                case 6: goto L120;
                case 7: goto L110;
                default: goto L109;
            };
        L109:
            r11 = r21;
        L131:
            r21 = r11;
            r11 = r112;
            goto L132
        L110:
            r3.h = (int) r18.getRawX();
            r3.i = r3.e - ((int) r18.getRawX());
            int r31 = (int) r18.getRawY();
            int r32 = r3.c.top;
            r3.j = r31 - r32;
            r3.k = (r3.d + r32) - ((int) r18.getRawY());
            r3.l = Math.min(r3.h, r3.i);
            int r33 = Math.min(r3.j, r3.k);
            r3.m = r33;
            int r34 = r3.l;
            if (r34 >= r33) goto L117;
            if (r3.h == r34) goto L132;
            int r35 = r3.e;
            int r36 = r7.getWidth();
        L130:
            r11 = r35 - r36;
            goto L132
        L117:
            if (r3.j == r33) goto L131;
            int r37 = r3.d;
            int r38 = r7.getHeight();
        L127:
            r11 = r37 - r38;
            goto L131
        L120:
            float r39 = (r18.getRawY() - r3.c.top) * 2;
            int r40 = r3.d;
            if (r39 <= r40) goto L131;
            r11 = r40 - r7.getHeight();
            goto L131
        L123:
            float r41 = r18.getRawX() * 2;
            int r42 = r3.e;
            if (r41 <= r42) goto L132;
            r36 = r7.getWidth();
            r35 = r42;
            goto L130
        L126:
            r37 = r3.d;
            r38 = r7.getHeight();
            goto L127
        L128:
            r11 = r112;
            r21 = 0;
            goto L132
        L129:
            r35 = r3.e;
            r36 = r7.getWidth();
        L132:
            WindowManagerLayoutParamsInternal r43 = r6.a;
            ((WindowManager.LayoutParams) r43).x = r11;
            ((WindowManager.LayoutParams) r43).y = r21;
            r8.updateViewLayout(r7, r43);
            r3.b.getClass();
            wfb.a r44 = r3.b.B;
            if (r44 == null) goto L135;
            r44.a();
        L135:
            r3.f = r18.getRawX();
            r3.g = r18.getRawY();
            return;
        L88:
            if (r112 > r3.d(r7)) goto L91;
        L92:
            r117 = true;
            goto L94
        L91:
            if (r112 < r3.e()) goto L93;
        L66:
            if (r112 > ((0 - r3.b.g) - r3.u)) goto L69;
        L70:
            r114 = true;
            goto L72
        L69:
            if (r112 < (((r3.e - r7.getWidth()) + r3.b.g) + r3.u)) goto L71;
        L56:
            if (r21 <= (r3.o - TouchUtils.k(r7))) goto L63;
            if (r3.p == false) goto L60;
            r21 = r3.o - TouchUtils.k(r7);
            goto L63
        L60:
            int r45 = r3.o;
            if (r21 <= r45) goto L63;
            r21 = r45;
            goto L63
        L51:
            if (r112 <= (r3.e - r7.getWidth())) goto L53;
            r112 = r3.e - r7.getWidth();
            goto L53
        L43:
            if (r112 >= r3.d(r7)) goto L46;
            r112 = r3.d(r7);
            goto L53
        L46:
            if (r112 <= r3.e()) goto L53;
            r112 = r3.e();
            goto L53
        L38:
            if (((r19 * r19) + (r20 * r20)) >= 81.0f) goto L40;
            return;
        L29:
            if (r14 != 3) goto L164;
            vfb.a r46 = r3.b;
            if (r46.i == false) goto L165;
            r46.i = false;
            return;
        L165:
            return;
        L164:
            return;
        L157:
            r3.b.i = false;
            r3.f = r18.getRawX();
            r3.g = r18.getRawY();
            return;
        L17:
            r12 = false;
            goto L18
        }

        public d(AppFloatManager r1, com.ss.android.lark.floating.widget.appfloat.d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements b {
        public boolean a;
        public final /* synthetic */ AppFloatManager b;

        @Override // com.ss.android.lark.floating.widget.appfloat.AppFloatManager.b
        public final void a() {
            if (this.a == false) goto L12;
            return;
        L12:
            this.a = true;     // Catch: Throwable -> L9
            AppFloatManager r0 = this.b;     // Catch: Throwable -> L9
            r0.b(r0.b.z);     // Catch: Throwable -> L9
            this.a = false;
            return;
        L9:
            th = move-exception;
            this.a = false;
            throw th;
        }

        public e(AppFloatManager r1) {
            this.b = r1;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ AppFloatManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        public f(AppFloatManager r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        final com.ss.android.lark.floating.widget.appfloat.d r0 = new com.ss.android.lark.floating.widget.appfloat.d(this.a, this.b);
        r0.setTag(this.b.d);
        LayoutInflater r1 = LayoutInflater.from(this.a);
        Integer r2 = this.b.a;
        Intrinsics.checkNotNull(r2);
        final View r3 = r1.inflate(r2.intValue(), r0, true);
        r3.setVisibility(4);
        WindowManager r4 = f();
        WindowManagerLayoutParamsInternal r5 = e().a;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r0, r5);
        r4.addView(r0, r5);
        Log.i("AppFloatManager", "addParentFrameLayout@" + r0.hashCode());
        vfb.a r6 = this.b;
        r6.b = r3;
        r6.c = r0;
        wfb.f r7 = r6.A;
        if (r7 == null) goto L5;
        r7.a(r3);
    L5:
        r0.setTouchListener(new d(this, r0));
        r0.setLayoutListener(new AppFloatManager$addView$1$3(this, r0, r3));
        this.e = r0;
    }

    public final void d() {
        StringBuilder r2 = new StringBuilder("floatOver, removeParentFrameLayout@");     // Catch: Exception -> L9
        com.ss.android.lark.floating.widget.appfloat.d r1 = this.e;     // Catch: Exception -> L9
        if (r1 == null) goto L6;
        Integer r3 = Integer.valueOf(r1.hashCode());     // Catch: Exception -> L9
    L7:
        r2.append(r3);     // Catch: Exception -> L9
        Log.i("AppFloatManager", r2.toString());     // Catch: Exception -> L9
        this.b.j = false;     // Catch: Exception -> L9
        f().removeView(this.e);     // Catch: Exception -> L9
        return;
    L6:
        r3 = null;
    L9:
        e = move-exception;
        Log.e("AppFloatManager", "float dismiss occurs error：" + e);
    }

    public final h e() {
        h r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final WindowManager f() {
        WindowManager r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        return null;
    }

    public final void g() {
        Object r1 = this.a.getSystemService("window");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        i r0 = new i((WindowManager) r1);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.c = r0;
        h r2 = new h();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r3 = 2038;
    L6:
        WindowManagerLayoutParamsInternal r4 = r2.a;
        ((WindowManager.LayoutParams) r4).type = r3;
        boolean r5 = true;
        ((WindowManager.LayoutParams) r4).format = 1;
        ((WindowManager.LayoutParams) r4).gravity = 8388659;
        ((WindowManager.LayoutParams) r4).flags = 552;
        vfb.a r6 = this.b;
        if (r6.o == false) goto L10;
        this.g |= 128;
    L10:
        if (r6.p == false) goto L12;
        this.g |= 16777216;
    L12:
        float r7 = r6.r;
        if (r7 == (-1.0f)) goto L16;
        r5 = false;
    L16:
        if (r5 == true) goto L18;
        this.g |= 2;
        ((WindowManager.LayoutParams) r4).dimAmount = r7;
    L18:
        ((WindowManager.LayoutParams) r4).flags = this.g | 552;
        int r8 = -1;
        if (r6.s == false) goto L21;
        int r9 = -1;
    L22:
        ((WindowManager.LayoutParams) r4).width = r9;
        if (r6.t == true) goto L26;
        r8 = -2;
    L26:
        ((WindowManager.LayoutParams) r4).height = r8;
        if (Intrinsics.areEqual(r6.y, new Pair(0, 0)) == true) goto L29;
        ((WindowManager.LayoutParams) r2.a).x = ((Number) this.b.y.getFirst()).intValue();
        ((WindowManager.LayoutParams) r2.a).y = ((Number) this.b.y.getSecond()).intValue();
    L30:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
        return;
    L29:
        ((WindowManager.LayoutParams) r2.a).y = this.b.x;
        goto L30
    L21:
        r9 = -2;
        goto L22
    L5:
        r3 = 2002;
        goto L6
    }

    public final Context getContext() {
        return this.a;
    }

    public final void b(List<Rect> r13) {
        Intrinsics.checkNotNullParameter(r13, "rects");
        if (this.b.j == false) goto L5;
        return;
    L5:
        com.ss.android.lark.floating.widget.appfloat.d r6 = this.e;
        if (r6 == null) goto L92;
        int[] r0 = this.j;
        r6.getLocationOnScreen(r0);
        Rect r1 = this.k;
        boolean r2 = false;
        int r3 = r0[0];
        r1.set(r3, r0[1], r6.getWidth() + r3, r0[1] + r6.getHeight());
        List<Rect> r14 = r13;
        Iterator<T> r4 = r14.iterator();
        boolean r5 = false;
    L9:
        if (r4.hasNext() == false) goto L11;
        r5 = r5 | r1.intersect((Rect) r4.next());
        goto L9
    L11:
        if (r5 == true) goto L13;
        return;
    L13:
        Rect r7 = new Rect();
        Iterator<T> r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L17;
        r7.union((Rect) r15.next());
        goto L15
    L17:
        int r16 = xfb.d.a;
        Rect r17 = xfb.d.c(this.a);
        if (r1.top <= ((WindowManager.LayoutParams) e().a).y) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L25;
        Context r9 = this.a;
        Intrinsics.checkNotNullParameter(r9, "context");
        Resources r10 = r9.getResources();
        int r11 = r10.getIdentifier("status_bar_height", "dimen", "android");
        if (r11 <= 0) goto L25;
        int r12 = r10.getDimensionPixelSize(r11);
    L27:
        switch(c.a[this.b.m.ordinal()]) {
            case 1: goto L59;
            case 2: goto L59;
            case 3: goto L59;
            case 4: goto L59;
            case 5: goto L59;
            case 6: goto L59;
            case 7: goto L29;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L29;
            default: goto L28;
        };
    L28:
        return;
    L29:
        int r18 = r7.left - UIHelper.dp2px(20.0f);
        int r19 = (r17.right - r7.right) - UIHelper.dp2px(20.0f);
        int r20 = r19 + 1;
        int r110 = r6.getWidth();
        if (r20 > r110) goto L33;
        if (r110 > r18) goto L33;
        boolean r21 = true;
    L34:
        if (r21 == false) goto L36;
        int r111 = r7.left - UIHelper.dp2px(20.0f);
        int r22 = r6.getWidth();
    L48:
        int r112 = r111 - r22;
    L51:
        int r23 = r112;
    L53:
        if (r23 == (-1)) goto L93;
        TouchUtils r113 = this.f;
        if (r113 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        TouchUtils r24 = null;
    L58:
        h r25 = e();
        WindowManager r26 = f();
        int r114 = TouchUtils.v;
        r24.b(true, r25, r23, r26, r6, null, false);
        return;
    L57:
        r24 = r113;
        goto L58
    L93:
        return;
    L36:
        int r27 = r18 + 1;
        int r115 = r6.getWidth();
        if (r27 > r115) goto L40;
        if (r115 > r19) goto L40;
        r2 = true;
    L40:
        if (r2 == false) goto L43;
        int r116 = r7.right;
        int r28 = UIHelper.dp2px(20.0f);
    L50:
        r112 = r116 + r28;
        goto L51
    L43:
        if (r18 >= r6.getWidth()) goto L45;
    L52:
        r23 = -1;
        goto L53
    L45:
        if (r19 < r6.getWidth()) goto L52;
        if (r18 <= r19) goto L49;
        r111 = r7.left - UIHelper.dp2px(20.0f);
        r22 = r6.getWidth();
        goto L48
    L49:
        r116 = r7.right;
        r28 = UIHelper.dp2px(20.0f);
    L33:
        r21 = false;
        goto L34
    L59:
        int r29 = r7.top - UIHelper.dp2px(20.0f);
        int r117 = (r17.bottom - r7.bottom) - UIHelper.dp2px(20.0f);
        int r118 = r117 + 1;
        int r119 = r6.getHeight();
        if (r118 > r119) goto L63;
        if (r119 > r29) goto L63;
        boolean r120 = true;
    L64:
        if (r120 == false) goto L66;
        int r121 = r7.top - UIHelper.dp2px(20.0f);
        int r30 = r6.getHeight();
    L78:
        int r122 = r121 - r30;
    L81:
        int r31 = r122 - r12;
    L83:
        if (r31 == (-1)) goto L95;
        TouchUtils r123 = this.f;
        if (r123 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        TouchUtils r32 = null;
    L88:
        h r33 = e();
        WindowManager r34 = f();
        int r124 = TouchUtils.v;
        r32.b(false, r33, r31, r34, r6, null, false);
        return;
    L87:
        r32 = r123;
        goto L88
    L95:
        return;
    L66:
        int r125 = r29 + 1;
        int r126 = r6.getHeight();
        if (r125 > r126) goto L70;
        if (r126 > r117) goto L70;
        r2 = true;
    L70:
        if (r2 == false) goto L73;
        int r127 = r7.bottom;
        int r35 = UIHelper.dp2px(20.0f);
    L80:
        r122 = r127 + r35;
        goto L81
    L73:
        if (r29 >= r6.getHeight()) goto L75;
    L82:
        r31 = -1;
        goto L83
    L75:
        if (r117 < r6.getHeight()) goto L82;
        if (r29 <= r117) goto L79;
        r121 = r7.top - UIHelper.dp2px(20.0f);
        r30 = r6.getHeight();
        goto L78
    L79:
        r127 = r7.bottom;
        r35 = UIHelper.dp2px(20.0f);
    L63:
        r120 = false;
    L25:
        r12 = 0;
        goto L27
    L20:
        r8 = false;
        goto L21
    }

    public final void c(final boolean r4) {
        vfb.a r0 = this.b;
        if (r0.i == false) goto L5;
        return;
    L5:
        if (r0.j == true) goto L21;
        TouchUtils r2 = null;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L14;
        TouchUtils r1 = this.f;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
    L13:
        r2.h(new AppFloatManager$expandAppFloatView$1(this, r4));
        return;
    L12:
        r2 = r1;
        goto L13
    L14:
        TouchUtils r3 = this.f;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        r3 = null;
    L17:
        r3.h(null);
        i(this, Boolean.valueOf(r4), null, 2);
        return;
    }

    public AppFloatManager(Context r2, vfb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r2;
        this.b = r3;
        this.j = new int[2];
        this.k = new Rect();
        this.l = new e(this);
    }

    public final void h(int r4, boolean r5) {
        com.ss.android.lark.floating.widget.appfloat.d r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getChildCount() >= 1) goto L8;
        return;
    L8:
        if (r0.isLaidOut() == true) goto L12;
        if (r4 != 0) goto L12;
        r0.post(new f(this, r4, r5));
        return;
    L12:
        this.b.H = r5;
        r0.setVisibility(r4);
        r0.getChildAt(0);
        if (r4 != 0) goto L17;
        vfb.a r6 = this.b;
        r6.k = true;
        r6.getClass();
        wfb.a r7 = this.b.B;
        if (r7 == null) goto L22;
        r7.a();
        return;
    L22:
        return;
    L17:
        vfb.a r8 = this.b;
        r8.k = false;
        r8.getClass();
        wfb.a r9 = this.b.B;
        if (r9 == null) goto L24;
        r9.a();
        return;
    }

    public static void i(AppFloatManager r11, Boolean r12, Boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r13 = null;
    L8:
        com.ss.android.lark.floating.widget.appfloat.d r7 = r11.e;
        if (r7 == null) goto L47;
        Animator r15 = r11.m;
        if (r15 == null) goto L13;
        r15.cancel();
    L13:
        r11.m = null;
        if (r7.isLaidOut() == false) goto L53;
        TouchUtils r16 = r11.f;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        r16 = null;
    L19:
        h r0 = r11.e();
        WindowManager r6 = r11.f();
        e r8 = r11.l;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r6, "windowManager");
        Intrinsics.checkNotNullParameter(r7, "view");
        r16.f(r0, r7);
        vfb.a r17 = r16.b;
        int r1 = r17.w;
        int r2 = r16.h;
        int r3 = r16.i;
        if (r2 >= r3) goto L22;
        int r4 = 0 - r1;
    L23:
        int r5 = r17.x;
        if (Intrinsics.areEqual(r17.e, Boolean.TRUE) == false) goto L45;
        if (r12 != null) goto L27;
        if (r13 == null) goto L42;
        if (r13.booleanValue() == false) goto L42;
        r16.i(r0, r4, r5, r6, r7, r8, true, r16.r);
        return;
    L42:
        if (r16.r == false) goto L44;
        r16.h(new TouchUtils$sideHideAnim$1(r16, r0, r7, r6, r8, false));
        Unit r18 = Unit.INSTANCE;
        return;
    L44:
        TouchUtils.j(r16, r0, r4, r6, r7, r8, false);
        return;
    L27:
        if (r16.r == false) goto L32;
        if (r12.booleanValue() == false) goto L32;
        TouchUtils.j(r16, r0, r4, r6, r7, r8, true);
        return;
    L32:
        if (r16.r == false) goto L34;
    L36:
        Unit r19 = Unit.INSTANCE;
        return;
    L34:
        if (r12.booleanValue() == true) goto L36;
        r16.h(new TouchUtils$sideHideAnim$1(r16, r0, r7, r6, r8, true));
        goto L36
    L45:
        r16.i(r0, r4, r5, r6, r7, r8, false, false);
        return;
    L22:
        r4 = (((WindowManager.LayoutParams) r0.a).x + r3) + r1;
        goto L23
    L53:
        return;
    }
}
