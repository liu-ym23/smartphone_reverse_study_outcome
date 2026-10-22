package com.larus.common_ui.photoviewer;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j19.d;
import j19.e;
import j19.f;
import j19.g;
import j19.i;
import j19.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020EH\u0002J\u0010\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020!H\u0002J\u0018\u0010I\u001a\u00020E2\u0006\u0010H\u001a\u00020!2\u0006\u0010J\u001a\u00020,H\u0002J\u000e\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020/J\u000e\u0010M\u001a\u00020E2\u0006\u0010L\u001a\u00020/J\u0012\u0010N\u001a\u00020E2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u00020EH\u0002J\u001a\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020!2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010&J\u0016\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020!2\u0006\u0010U\u001a\u00020VJ\u001e\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020!2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020,J\u000e\u0010X\u001a\u00020E2\u0006\u0010S\u001a\u00020!J\b\u0010Y\u001a\u00020EH\u0007J\b\u0010Z\u001a\u00020EH\u0016J\u0018\u0010[\u001a\u00020E2\u0006\u0010H\u001a\u00020!2\u0006\u0010J\u001a\u00020,H\u0002J\u000e\u0010\\\u001a\u00020E2\u0006\u0010]\u001a\u00020\rR\u0015\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00107\u001a\u0004\u0018\u0001062\b\u0010\f\u001a\u0004\u0018\u000106@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u00020,2\u0006\u0010\f\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010@\u001a\u00020!2\u0006\u0010\f\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010#\"\u0004\bB\u0010C¨\u0006^"}, d2 = {"Lcom/larus/common_ui/photoviewer/PhotoViewerDialog;", "Landroid/app/Dialog;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "transitionAdapter", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "<init>", "(Landroid/content/Context;Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;)V", "getTransitionAdapter", "()Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "value", "Landroidx/recyclerview/widget/RecyclerView;", "pager", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "onPageSelectedListener", "getOnPageSelectedListener", "()Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;)V", "onDismissListener", "Lcom/larus/common_ui/photoviewer/OnDismissListener;", "getOnDismissListener", "()Lcom/larus/common_ui/photoviewer/OnDismissListener;", "setOnDismissListener", "(Lcom/larus/common_ui/photoviewer/OnDismissListener;)V", "currentPos", "", "getCurrentPos", "()I", "_currentPos", "defaultStartRect", "Landroid/graphics/Rect;", "getDefaultStartRect", "()Landroid/graphics/Rect;", "setDefaultStartRect", "(Landroid/graphics/Rect;)V", "isAnimatedShow", "", "indicatorViews", "Ljava/util/ArrayList;", "Lcom/larus/common_ui/photoviewer/IIndicatorView;", "Lkotlin/collections/ArrayList;", "backgroundAlphaFactor", "", "backgroundAlphaFactorWhenDragEnd", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "restoreTransitionProvider", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "isInfinityLoop", "()Z", "setInfinityLoop", "(Z)V", "dismissAnimationType", "getDismissAnimationType", "setDismissAnimationType", "(I)V", "updateLayoutManager", "", "initAdapter", "dispatchOnPageUnSelected", "pos", "dispatchOnPageSelected", "byScroll", "addIndicatorView", "indicatorView", "removeIndicatorView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "makeNavigateBarTransparent", "showAnimated", "position", "startRect", "view", "Landroid/view/View;", "enableRestoreTransition", "show", "onDestroy", "dismiss", "setCurrentPos", "bindRestoreRecyclerView", "recyclerView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PhotoViewerDialog extends Dialog implements g, LifecycleObserver {
    public final TransitionPagerAdapter<?> a;
    public final RecyclerView b;
    public final FrameLayout c;
    public g d;
    public f e;
    public int f;
    public Rect g;
    public boolean h;
    public final ArrayList<d> i;
    public float j;
    public float k;
    public OrientationHelper l;
    public e m;

    @Override // j19.g
    public final void S80(int r1) {
    }

    @Override // j19.g
    public final void onPageSelected(int r1) {
    }

    @Override // j19.g
    public final void onPageSelected(int r1, boolean r2) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.a.getClass();
        f r0 = this.e;
        if (r0 == null) goto L5;
        r0.onDismiss();
    L5:
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (isShowing() == false) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(this));
        return;
    L21:
        this.a.getClass();
    }

    public static View b(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void c(PhotoViewerDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Window r7 = getWindow();
        if (r7 == null) goto L5;
        r7.requestFeature(1);
    L5:
        setContentView(this.c);
        Window r8 = getWindow();
        if (r8 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r1 = r8.getAttributes();
        r8.setLayout(-1, -1);
        r8.setBackgroundDrawable(new ColorDrawable(0));
        r8.clearFlags(2);
        b(r8).setPadding(0, 0, 0, 0);
        int r2 = Build.VERSION.SDK_INT;
        r8.addFlags(Integer.MIN_VALUE);
        b(r8).setSystemUiVisibility(1280);
        if (r2 <= 28) goto L11;
        r1.layoutInDisplayCutoutMode = 1;
    L11:
        Window r9 = getWindow();
        if (r9 == null) goto L15;
        r9.setNavigationBarColor(0);
        r9.addFlags(134217728);
    L15:
        this.c.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.h == false) goto L19;
        this.c.getBackground().setAlpha(0);
        this.j = 0.0f;
        return;
    }

    public PhotoViewerDialog(Context r7, TransitionPagerAdapter<?> r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "transitionAdapter");
        super(r7);
        this.a = r8;
        FrameLayout r0 = new FrameLayout(r7);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.c = r0;
        this.f = -1;
        Rect r1 = new Rect();
        Window r3 = getWindow();
        if (r3 == null) goto L9;
        WindowManager r4 = r3.getWindowManager();
        if (r4 == null) goto L9;
        Display r5 = r4.getDefaultDisplay();
        if (r5 == null) goto L9;
        int r6 = r5.getWidth();
    L10:
        Window r9 = getWindow();
        if (r9 == null) goto L17;
        WindowManager r10 = r9.getWindowManager();
        if (r10 == null) goto L17;
        Display r11 = r10.getDefaultDisplay();
        if (r11 == null) goto L17;
        int r12 = r11.getHeight();
    L18:
        int r13 = r6 / 2;
        r1.left = r13;
        int r14 = r12 / 2;
        r1.top = r14;
        r1.right = r13;
        r1.bottom = r14;
        this.g = r1;
        this.i = new ArrayList();
        this.j = 1.0f;
        this.k = 1.0f;
        RecyclerView r2 = new RecyclerView(r7);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.b = r2;
        new PagerSnapHelper().attachToRecyclerView(r2);
        r0.addView(r2, 0);
        r2.addOnScrollListener(new AnonymousClass2(this));
        r2.setAdapter(r8);
        i r15 = new i(this);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r8.b = r15;
        r8.registerAdapterDataObserver(new PhotoViewerDialog$initAdapter$2(this));
        if ((r7 instanceof FragmentActivity) == false) goto L21;
        FragmentActivity r16 = (FragmentActivity) r7;
    L22:
        if (r16 == null) goto L26;
        Lifecycle r17 = r16.getLifecycle();
        if (r17 == null) goto L26;
        r17.addObserver(this);
    L26:
        LinearLayoutManager r18 = new LinearLayoutManager(getContext());
        r18.setOrientation(0);
        r2.setLayoutManager(r18);
        this.l = OrientationHelper.createHorizontalHelper(r2.getLayoutManager());
        return;
    L21:
        r16 = null;
    L17:
        r12 = 0;
    L9:
        r6 = 0;
        goto L10
    }

    public final void d(int r4, boolean r5) {
        int r0 = this.f;
        if (r0 == r4) goto L30;
        Iterator<d> r1 = this.i.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().S80(r0);
        goto L6
    L8:
        g r2 = this.d;
        if (r2 == null) goto L11;
        r2.S80(r0);
    L11:
        this.a.S80(r0);
        this.f = r4;
        Iterator<d> r3 = this.i.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r3.next().onPageSelected(r4);
        goto L13
    L15:
        g r6 = this.d;
        if (r6 == null) goto L18;
        r6.onPageSelected(r4);
    L18:
        this.a.onPageSelected(r4);
        Iterator<d> r7 = this.i.iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        r7.next().onPageSelected(r4, r5);
        goto L20
    L22:
        g r8 = this.d;
        if (r8 == null) goto L25;
        r8.onPageSelected(r4, r5);
    L25:
        this.a.getClass();
        return;
    }

    public final void e(int r4, Rect r5) {
        if (isShowing() == false) goto L5;
        return;
    L5:
        if (r4 < this.a.getItemCount()) goto L7;
        d(0, false);
        this.b.scrollToPosition(0);
        c(this);
        return;
    L7:
        d(r4, false);
        this.b.scrollToPosition(r4);
        TransitionPagerAdapter<?> r0 = this.a;
        if (r5 != null) goto L10;
        r5 = this.g;
    L10:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "startRect");
        if (r4 >= r0.getItemCount()) goto L14;
        r0.a = true;
        r0.g.set(r5);
    L14:
        this.h = true;
        c(this);
    }

    public final void f(int r4, View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (this.m != null) goto L5;
        j r1 = new j(r4, r5);
        this.m = r1;
        this.a.d = r1;
    L5:
        Intrinsics.checkNotNullParameter(r5, "view");
        View r0 = j19.c.b(r5);
        if (r0 == null) goto L8;
        r5 = r0;
    L8:
        e(r4, h.a(r5));
    }
}
