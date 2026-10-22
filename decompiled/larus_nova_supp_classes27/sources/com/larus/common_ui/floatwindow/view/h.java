package com.larus.common_ui.floatwindow.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.HandlerCompat;
import androidx.core.view.ViewGroupKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hq9.f1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements ViewManager {
    public static final /* synthetic */ int i = 0;
    public final Set<Pair<View, ImageView>> a;
    public final Map<View, View> b;
    public WeakReference<FrameLayout> c;
    public final int d;
    public int e;
    public final int f;
    public final Lazy g;
    public final Lazy h;

    public static final class a implements f09.a.a {
        public final /* synthetic */ h a;

        /* JADX INFO: renamed from: com.larus.common_ui.floatwindow.view.h$a$a, reason: collision with other inner class name */
        public static final class RunnableC0010a implements Runnable {
            public final /* synthetic */ h a;
            public final /* synthetic */ Activity b;

            public RunnableC0010a(h r1, Activity r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h r0 = this.a;     // Catch: Throwable -> L4
                Activity r1 = this.b;     // Catch: Throwable -> L4
                int r2 = h.i;     // Catch: Throwable -> L4
                r0.e(r1);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(h r1) {
            this.a = r1;
        }

        public final void onPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            ((Handler) this.a.g.getValue()).removeCallbacksAndMessages(r2);
        }

        public final void onPreDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onResumed(Activity r6) {
            Intrinsics.checkNotNullParameter(r6, "activity");
            HandlerCompat.postDelayed((Handler) this.a.g.getValue(), new RunnableC0010a(this.a, r6), r6, 100);
        }

        public final void onStart(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onCreate(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }
    }

    public static final class b {
    }

    static {
    }

    public final FrameLayout d() {
        WeakReference<FrameLayout> r0 = this.c;
        if (r0 == null) goto L5;
        FrameLayout r1 = r0.get();
    L6:
        if (r1 != null) goto L8;
        e(AppHost.a.a().getCurrentActivity());
    L8:
        WeakReference<FrameLayout> r2 = this.c;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.get();
    L5:
        r1 = null;
        goto L6
    }

    public h() {
        this.a = new LinkedHashSet();
        this.b = new LinkedHashMap();
        this.d = 40;
        this.e = c7.b(8);
        this.f = -16777216;
        this.g = LazyKt.lazy(new f());
        this.h = LazyKt.lazy(new g());
        AppHost.Companion r0 = AppHost.a;
        e(r0.a().getCurrentActivity());
        r0.a().e(new a(this));
    }

    public final FrameLayout a(Activity r8) {
        FLogger r0 = FLogger.a;
        r0.d("FloatWindowManager", "addWindowIfNeeded. currentActivity:" + r8);
        if (r8 == null) goto L11;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L11;
        View r10 = r9.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        r0.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L13:
        if ((r10 instanceof ViewGroup) == false) goto L15;
        ViewGroup r11 = (ViewGroup) r10;
    L16:
        if (r11 != null) goto L18;
        return null;
    L18:
        Iterator r2 = ViewGroupKt.getChildren(r11).iterator();
    L20:
        if (r2.hasNext() == false) goto L27;
        Object r3 = r2.next();
        if (((View) r3).getTag() != "global.floating_container") goto L24;
        boolean r5 = true;
    L25:
        if (r5 == false) goto L20;
    L29:
        if ((r3 instanceof FrameLayout) == false) goto L31;
        FrameLayout r4 = (FrameLayout) r3;
    L32:
        if (r4 != null) goto L34;
        FLogger.a.d("FloatWindowManager", "findOrCreateWindow. create a new container");
        r4 = new FrameLayout(r11.getContext());
        r4.setTag("global.floating_container");
        r11.addView(r4, -1, -1);
    L34:
        FLogger.a.d("FloatWindowManager", "addWindowIfNeeded. window:" + r4);
        Iterator<T> r12 = this.a.iterator();
    L36:
        if (r12.hasNext() == false) goto L59;
        Pair r6 = (Pair) r12.next();
        View r7 = (View) ((LinkedHashMap) this.b).get(r6.getFirst());
        ViewParent r13 = ((View) r6.getFirst()).getParent();
        if ((r13 instanceof ViewGroup) == false) goto L40;
        ViewGroup r14 = (ViewGroup) r13;
    L41:
        if (r14 == null) goto L43;
        r14.removeView((View) r6.getFirst());
    L43:
        if (r7 == null) goto L45;
        ViewParent r15 = r7.getParent();
    L47:
        if ((r15 instanceof ViewGroup) == false) goto L49;
        ViewGroup r16 = (ViewGroup) r15;
    L50:
        if (r16 == null) goto L52;
        r16.removeView(r7);
    L52:
        ViewParent r17 = ((ImageView) r6.getSecond()).getParent();
        if ((r17 instanceof ViewGroup) == false) goto L55;
        ViewGroup r18 = (ViewGroup) r17;
    L56:
        if (r18 == null) goto L58;
        r18.removeView((View) r6.getSecond());
    L58:
        r4.addView((View) r6.getSecond());
        r4.addView(r7);
        r4.addView((View) r6.getFirst());
        FLogger.a.d("FloatWindowManager", "addWindowIfNeeded. move view first:" + r6.getSecond() + " second:" + r6.getFirst());
        goto L36
    L55:
        r18 = null;
        goto L56
    L49:
        r16 = null;
        goto L50
    L45:
        r15 = null;
        goto L47
    L40:
        r14 = null;
        goto L41
    L59:
        this.c = new WeakReference(r4);
        return r4;
    L31:
        r4 = null;
        goto L32
    L24:
        r5 = false;
        goto L25
    L27:
        r3 = null;
        goto L29
    L15:
        r11 = null;
    L11:
        r10 = null;
        goto L13
    }

    public final boolean b(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        FrameLayout r0 = d();
        if (r0 != null) goto L5;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L19;
        Set<Pair<View, ImageView>> r2 = this.a;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L14:
        if (r4.hasNext() == false) goto L17;
        r3.add((View) ((Pair) r4.next()).getFirst());
        goto L14
    L17:
        if (r3.contains(r6) == false) goto L19;
        return true;
    L19:
        return false;
    L5:
        if (r0.indexOfChild(r6) == (-1)) goto L7;
        boolean r5 = true;
    L8:
        if (r5 != true) goto L10;
        r1 = true;
        goto L11
    L7:
        r5 = false;
        goto L8
    }

    public final void e(Activity r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(a(e.a(r4)));     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.e("FloatWindowManager", "onResumed throw exception:" + r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // android.view.ViewManager
    public final void removeView(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        FLogger.a.d("FloatWindowManager", "removeView. start to removeView");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        Iterator<T> r1 = this.a.iterator();     // Catch: Throwable -> L21
    L5:
        if (r1.hasNext() == false) goto L9;
        Object r2 = r1.next();     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(((Pair) r2).getFirst(), r6) == false) goto L5;
    L10:
        Pair r3 = (Pair) r2;     // Catch: Throwable -> L21
        if (r3 != null) goto L13;
        return;
    L13:
        this.a.remove(r3);     // Catch: Throwable -> L21
        this.b.remove(r6);     // Catch: Throwable -> L21
        FrameLayout r4 = d();     // Catch: Throwable -> L21
        if (r4 == null) goto L16;
        r4.removeView((View) r3.getSecond());     // Catch: Throwable -> L21
    L16:
        FrameLayout r5 = d();     // Catch: Throwable -> L21
        if (r5 == null) goto L19;
        r5.removeView(r6);     // Catch: Throwable -> L21
    L19:
        FLogger.a.d("FloatWindowManager", "removeView end, view:" + r6 + " backgroundView:" + r3.getSecond());     // Catch: Throwable -> L21
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L32;
        FLogger.a.e("FloatWindowManager", "removeView throw exception:" + r8);
        return;
    L32:
        return;
    L9:
        r2 = null;
    L21:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    @Override // android.view.ViewManager
    public final void addView(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "params");
        FLogger r1 = FLogger.a;
        r1.d("FloatWindowManager", "addView. start to addView");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L25
        if ((r11 instanceof WindowManager.LayoutParams) == true) goto L7;
        r1.e("FloatWindowManager", "Params must be WindowManager.LayoutParams");     // Catch: Throwable -> L25
    L23:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L33;
        FLogger.a.e("FloatWindowManager", "addView throw exception:" + r13);
        return;
    L33:
        return;
    L7:
        if (b(r10) == false) goto L9;
        return;
    L9:
        ImageView r4 = new ImageView(r10.getContext());     // Catch: Throwable -> L25
        r4.setAlpha(r10.getAlpha());     // Catch: Throwable -> L25
        r4.setLayoutParams(g(this, (WindowManager.LayoutParams) r11, this.d, 2));     // Catch: Throwable -> L25
        r4.setImageBitmap(c(r11.width, r11.height, this.e, this.d, this.f));     // Catch: Throwable -> L25
        FrameLayout r5 = d();     // Catch: Throwable -> L25
        if (r5 == null) goto L12;
        r5.addView(r4);     // Catch: Throwable -> L25
    L12:
        WindowManager.LayoutParams r6 = (WindowManager.LayoutParams) r11;     // Catch: Throwable -> L25
        TextView r7 = new TextView(r10.getContext());     // Catch: Throwable -> L25
        int r8 = 8;
        r7.setVisibility(8);     // Catch: Throwable -> L25
        r7.setAlpha(0.0f);     // Catch: Throwable -> L25
        if (((f1) this.h.getValue()).e() == true) goto L16;
        r8 = 12;
    L16:
        r7.setLayoutParams(f(r6, c7.b(Integer.valueOf(r8)), true));     // Catch: Throwable -> L25
        FrameLayout r9 = d();     // Catch: Throwable -> L25
        if (r9 == null) goto L19;
        r9.addView(r7);     // Catch: Throwable -> L25
    L19:
        r10.setLayoutParams(g(this, (WindowManager.LayoutParams) r11, 0, 3));     // Catch: Throwable -> L25
        FrameLayout r14 = d();     // Catch: Throwable -> L25
        if (r14 == null) goto L22;
        r14.addView(r10);     // Catch: Throwable -> L25
    L22:
        this.a.add(TuplesKt.to(r10, r4));     // Catch: Throwable -> L25
        this.b.put(r10, r7);     // Catch: Throwable -> L25
        r1.d("FloatWindowManager", "addView end, view:" + r10 + " params:" + r11 + " backgroundView:" + r4 + " alpha:" + r10.getAlpha());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    @Override // android.view.ViewManager
    public final void updateViewLayout(View r8, ViewGroup.LayoutParams r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "params");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L29
        if ((r9 instanceof WindowManager.LayoutParams) == true) goto L6;
        FLogger.a.e("FloatWindowManager", "Params must be WindowManager.LayoutParams");     // Catch: Throwable -> L29
    L26:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L41;
        FLogger.a.e("FloatWindowManager", "updateViewLayout throw exception:" + r11);
        return;
    L41:
        return;
    L6:
        r8.setLayoutParams(g(this, (WindowManager.LayoutParams) r9, 0, 3));     // Catch: Throwable -> L29
        Iterator<T> r2 = this.a.iterator();     // Catch: Throwable -> L29
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(((Pair) r3).getFirst(), r8) == false) goto L8;
    L13:
        Pair r4 = (Pair) r3;     // Catch: Throwable -> L29
        if (r4 == null) goto L28;
        ImageView r5 = (ImageView) r4.getSecond();     // Catch: Throwable -> L29
        if (r5 == null) goto L40;
        r5.setLayoutParams(g(this, (WindowManager.LayoutParams) r9, this.d, 2));     // Catch: Throwable -> L29
        if (r5.getLayoutParams().width == r9.width) goto L21;
    L22:
        r5.setImageBitmap(c(r9.width, r9.height, this.e, this.d, this.f));     // Catch: Throwable -> L29
    L23:
        View r12 = (View) ((LinkedHashMap) this.b).get(r8);     // Catch: Throwable -> L29
        if (r12 == null) goto L26;
        r12.setLayoutParams(f((WindowManager.LayoutParams) r9, c7.b(12), true));     // Catch: Throwable -> L29
        goto L26
    L21:
        if (r5.getLayoutParams().height == r9.height) goto L23;
    L40:
        return;
    L28:
        return;
    L12:
        r3 = null;
    L29:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }

    public static FrameLayout.LayoutParams f(WindowManager.LayoutParams r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r7 = 0;
    L5:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r4.width + (r5 * 2), r4.height + (r7 * 2));
        int r1 = r4.gravity;
        r0.gravity = r1;
        if ((r1 & 7) != 5) goto L8;
        r0.rightMargin = r4.x - r5;
    L9:
        r0.topMargin = r4.y - r7;
        return r0;
    L8:
        r0.leftMargin = r4.x - r5;
        goto L9
    L4:
        r7 = r5;
        goto L5
    }

    public static /* synthetic */ FrameLayout.LayoutParams g(h r1, WindowManager.LayoutParams r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        r3 = 0;
    L5:
        r1.getClass();
        return f(r2, r3, false);
    }

    public static Bitmap c(int r3, int r4, float r5, float r6, int r7) {
        int r8 = Color.argb(60, Color.red(r7), Color.green(r7), Color.blue(r7));
        int r0 = (int) (2 * r6);
        Bitmap r1 = Bitmap.createBitmap(r3 + r0, r0 + r4, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        RectF r9 = new RectF(r6, r6, r3 + r6, r4 + r6);
        Paint r10 = new Paint();
        r10.setAntiAlias(true);
        r10.setColor(r8);
        r10.setShadowLayer(r6, 0.0f, 0.0f, r8);
        r2.drawRoundRect(r9, r5, r5, r10);
        return r1;
    }
}
