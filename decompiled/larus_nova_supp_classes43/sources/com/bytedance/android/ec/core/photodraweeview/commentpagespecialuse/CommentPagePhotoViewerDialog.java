package com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
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
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.MainCommentLinearLayoutManager;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionUtils;
import com.bytedance.crash.d;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sh.a;
import sh.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/photodraweeview/commentpagespecialuse/CommentPagePhotoViewerDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CommentPagePhotoViewerDialog extends Dialog implements LifecycleObserver {
    public final RecyclerView a;
    public final FrameLayout b;
    public OnPageSelectedListener c;
    public OnDismissListener d;
    public final List<b> e;
    public int f;
    public int g;
    public final Rect h;
    public boolean i;
    public final ArrayList<IIndicatorView> j;
    public float k;
    public float l;
    public final TransitionPagerAdapter<?> m;

    public void c(int r1) {
    }

    public void onPageSelected(int r1) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.m.onDestroy();
        OnDismissListener r0 = this.d;
        if (r0 == null) goto L5;
        r0.onDismiss(this.g);
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r10 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r10 == null) goto L19;
        d.d(r10, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(this));
        return;
    L21:
        this.m.onDestroy();
    }

    private final void d(int r10) {
        int r0 = this.g;
        if (r0 == r10) goto L20;
        if (r10 <= r0) goto L6;
        Direction r1 = Direction.RIGHT;
    L7:
        this.f = r0;
        c(r0);
        this.g = r10;
        Iterator<IIndicatorView> r11 = this.j.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        r11.next().onPageSelected(this.g);
        goto L9
    L11:
        onPageSelected(this.g);
        OnPageSelectedListener r12 = this.c;
        if (r12 == null) goto L15;
        r12.onPageSelected(this.g);
    L15:
        if (this.f == (-1)) goto L23;
        Iterator<T> r13 = this.e.iterator();
    L18:
        if (r13.hasNext() == false) goto L24;
        ((b) r13.next()).a(r1);
        goto L18
    L24:
        return;
    L23:
        return;
    L6:
        r1 = Direction.LEFT;
        goto L7
    }

    public final void b(IIndicatorView r10) {
        Intrinsics.checkNotNullParameter(r10, "indicatorView");
        this.j.add(r10);
        this.b.addView((View) r10);
        r10.onAttach(this.g, this.m);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        Window r11 = getWindow();
        if (r11 == null) goto L5;
        r11.requestFeature(1);
    L5:
        setContentView(this.b);
        Window r12 = getWindow();
        if (r12 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r1 = r12.getAttributes();
        r12.setLayout(-1, -1);
        r12.setBackgroundDrawable(new ColorDrawable(0));
        r12.clearFlags(2);
        int r13 = Build.VERSION.SDK_INT;
        r12.addFlags(Integer.MIN_VALUE);
        View r14 = r12.getDecorView();
        if (c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r15 = ThreadMethodProxy.currentThread();
        if (r15 == c.a) goto L13;
        c.a(r15, "getDecorView");
    L13:
        r14.setSystemUiVisibility(768);
        if (r13 <= 28) goto L16;
        r1.layoutInDisplayCutoutMode = 1;
    L16:
        this.b.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.i == false) goto L20;
        this.b.getBackground().setAlpha(0);
        this.k = 0.0f;
        return;
    }

    public CommentPagePhotoViewerDialog(Context r10, TransitionPagerAdapter<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "transitionAdapter");
        super(r10);
        this.m = r11;
        FrameLayout r0 = new FrameLayout(r10);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r1 = Unit.INSTANCE;
        this.b = r0;
        this.e = new ArrayList();
        this.f = -1;
        this.g = -1;
        Rect r12 = new Rect();
        Window r13 = getWindow();
        if (r13 == null) goto L9;
        WindowManager r14 = r13.getWindowManager();
        if (r14 == null) goto L9;
        Display r15 = r14.getDefaultDisplay();
        if (r15 == null) goto L9;
        int r16 = r15.getWidth();
    L10:
        Window r17 = getWindow();
        if (r17 == null) goto L17;
        WindowManager r18 = r17.getWindowManager();
        if (r18 == null) goto L17;
        Display r19 = r18.getDefaultDisplay();
        if (r19 == null) goto L17;
        int r20 = r19.getHeight();
    L18:
        int r21 = r16 / 2;
        r12.left = r21;
        int r22 = r20 / 2;
        r12.top = r22;
        r12.right = r21;
        r12.bottom = r22;
        this.h = r12;
        this.j = new ArrayList();
        this.k = 1.0f;
        this.l = 1.0f;
        RecyclerView r23 = new RecyclerView(r10);
        r23.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.a = r23;
        final Ref.ObjectRef r24 = new Ref.ObjectRef();
        r24.element = new LinearLayoutManager(r10);
        Lazy r25 = ECAppInfoService.a;
        if (ECAppInfoService.j() == false) goto L21;
        r24.element = new MainCommentLinearLayoutManager(r10, r23);
    L21:
        LinearLayoutManager r26 = (LinearLayoutManager) r24.element;
        r26.setOrientation(0);
        r23.setLayoutManager(r26);
        new PagerSnapHelper().attachToRecyclerView(r23);
        r0.addView(r23, 0);
        r23.addOnScrollListener(new AnonymousClass3(this, r24));
        r23.setAdapter(r11);
        r11.setInternalTransitionListener(new a(this));
        r11.registerAdapterDataObserver(new CommentPagePhotoViewerDialog$initAdapter$2(this));
        if ((r10 instanceof FragmentActivity) == true) goto L24;
        r10 = null;
    L24:
        FragmentActivity r27 = (FragmentActivity) r10;
        if (r27 == null) goto L30;
        Lifecycle r28 = r27.getLifecycle();
        if (r28 == null) goto L31;
        r28.addObserver(this);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        r20 = 0;
    L9:
        r16 = 0;
        goto L10
    }

    public static final /* synthetic */ void a(CommentPagePhotoViewerDialog r0, int r1) {
        r0.d(r1);
    }

    public final void e(int r10, View r11) {
        Intrinsics.checkNotNullParameter(r11, "view");
        if ((r11 instanceof GenericDraweeView) == true) goto L5;
        View r0 = null;
    L6:
        GenericDraweeView r1 = (GenericDraweeView) r0;
        if (r1 == null) goto L11;
        GenericDraweeHierarchy r12 = r1.getHierarchy();
        if (r12 == null) goto L11;
        RectF r13 = new RectF();
        r12.getActualImageBounds(r13);
        int r14 = (int) r13.width();
        int r15 = (int) r13.height();
    L12:
        if (r15 == 0) goto L14;
        if (r14 == 0) goto L14;
    L15:
        Rect r16 = TransitionUtils.calculateStartRect(r11, new int[]{r14, r15});
    L36:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return;
    L17:
        if (isShowing() == false) goto L19;
        return;
    L19:
        if (r10 < this.m.getItemCount()) goto L26;
        d(0);     // Catch: Exception -> L36
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L36
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L25:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L36
        show();     // Catch: Exception -> L36
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L36
        return;
    L26:
        d(r10);     // Catch: Exception -> L36
        this.a.scrollToPosition(r10);     // Catch: Exception -> L36
        TransitionPagerAdapter<?> r17 = this.m;     // Catch: Exception -> L36
        if (r16 != null) goto L29;
        r16 = this.h;     // Catch: Exception -> L36
    L29:
        r17.setEnterAnimationParams(r10, r16);     // Catch: Exception -> L36
        this.i = true;     // Catch: Exception -> L36
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L36
        return;
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L34:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L36
        show();     // Catch: Exception -> L36
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L36
        return;
    L14:
        r14 = r11.getWidth();
        r15 = r11.getHeight();
    L11:
        r14 = 0;
        r15 = 0;
        goto L12
    L5:
        r0 = r11;
        goto L6
    }
}
