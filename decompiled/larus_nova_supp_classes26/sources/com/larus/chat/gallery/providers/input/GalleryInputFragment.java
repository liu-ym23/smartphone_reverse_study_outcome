package com.larus.chat.gallery.providers.input;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 |2\u00020\u0001:\u0001|B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010:\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J&\u0010=\u001a\u0004\u0018\u00010\u00072\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010B\u001a\u000207H\u0002J\u001a\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0018\u0010E\u001a\u0002072\u0006\u0010>\u001a\u00020?2\u0006\u0010F\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u000207H\u0002J\u0015\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020\u000bH\u0000¢\u0006\u0002\bJJ\u001d\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u001fH\u0000¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u0002072\u0006\u0010P\u001a\u00020\u000bH\u0000¢\u0006\u0002\bQJ\u0010\u0010R\u001a\u0002072\u0006\u0010P\u001a\u00020\u000bH\u0002J\b\u0010S\u001a\u000207H\u0016J\b\u0010T\u001a\u000207H\u0002J\b\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u00020\u000bH\u0002J\b\u0010W\u001a\u00020\u0011H\u0002J\b\u0010X\u001a\u000207H\u0002J\b\u0010Y\u001a\u000207H\u0002J\u0010\u0010Z\u001a\u0002072\u0006\u0010[\u001a\u00020#H\u0002J\u0018\u0010\\\u001a\u0002072\u0006\u0010[\u001a\u00020#2\u0006\u0010]\u001a\u00020\u0011H\u0002J%\u0010^\u001a\u0002072\n\b\u0002\u0010[\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010`J\u0012\u0010a\u001a\u00020\u00112\b\b\u0002\u0010b\u001a\u00020\u0011H\u0002J\b\u0010c\u001a\u00020\u0011H\u0002J\f\u0010b\u001a\u00020\u0011*\u00020#H\u0002J\u001a\u0010d\u001a\u0002072\u0006\u0010e\u001a\u00020\u000b2\b\b\u0002\u0010f\u001a\u00020\u000bH\u0002J\u000f\u0010g\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010hJ\b\u0010i\u001a\u000207H\u0002J\b\u0010j\u001a\u00020\u0011H\u0002J\u0010\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u0011H\u0002J\b\u0010n\u001a\u000207H\u0016J\b\u0010o\u001a\u000207H\u0016J\r\u0010p\u001a\u000207H\u0000¢\u0006\u0002\bqJ\b\u0010r\u001a\u000207H\u0002J\b\u0010s\u001a\u000207H\u0002J*\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020\u000b2\b\b\u0002\u0010v\u001a\u00020\u000b2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106J\u000e\u0010x\u001a\u0002072\u0006\u0010y\u001a\u00020\u000bJ\u0010\u0010z\u001a\u0002072\b\u0010{\u001a\u0004\u0018\u000109R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u001b\u00100\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/larus/chat/gallery/providers/input/GalleryInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "cameraContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "rootView", "Landroid/view/View;", "pageUploadedImageProvider", "Lcom/larus/chat/gallery/impl/providers/input/GalleryPageUploadedImageProvider;", "imeShowingOnStart", "", "imeShowingStatusConsumed", "windowManager", "Landroid/view/WindowManager;", "interceptorView", "preHeight", "", "globalListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "contentView", "isImeShowing", "ignoreImeInsetsForNavigation", "localMediaBottomController", "Lcom/larus/chat/gallery/providers/input/LocalMediaBottomViewController;", "previewSuggestedActionArea", "previewInputContainer", "restingInputHeight", "previewAudioInputActive", "previewSuggestedActionsAvailable", "restingInputHeightSettlingUntil", "", "previewImeAnimation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "previewTargetInsets", "Landroidx/core/view/WindowInsetsCompat;", "inputLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "updatePreviewLayoutRunnable", "Ljava/lang/Runnable;", "updatePreviewInterceptorRunnable", "respectImeVisibility", "getRespectImeVisibility", "()Z", "prepareForNavigationEnabled", "getPrepareForNavigationEnabled", "useBurstResultSugLayout", "getUseBurstResultSugLayout", "originBottomMargin", "getOriginBottomMargin", "()I", "originBottomMargin$delegate", "Lkotlin/Lazy;", "updateInterceptRunnable", "Lkotlin/Function0;", "", "logTag", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attachComponents", "onViewCreated", "view", "createPreviewSuggestedActionLayer", "root", "updatePreviewSuggestedActionLayout", "setPreviewSuggestedActionsAvailable", "available", "setPreviewSuggestedActionsAvailable$impl_mainlandRelease", "onInputHeightWillChange", "deltaPx", "durationMs", "onInputHeightWillChange$impl_mainlandRelease", "setPreviewAudioInputActive", "active", "setPreviewAudioInputActive$impl_mainlandRelease", "setPreviewImeActive", "onStart", "watchOnImeStatus", "watchOnGlobalLayout", "isImeVisible", "getDecorViewInvisibleHeight", "watchOnInsetsAnimation", "watchOnPreviewInsetsAnimation", "applyPreviewSettledInsets", "insets", "applyPreviewBottomPadding", "imeBottom", "updateBottomPadding", "imeBottomInset", "(Landroidx/core/view/WindowInsetsCompat;Ljava/lang/Integer;)V", "minimumBottomPadding", "navigationInset", "currentNavigationInset", "updateInterceptorView", "isImeShow", "needSetExternalImeFunc", "previewInterceptorHeight", "()Ljava/lang/Integer;", "updatePreviewInterceptorBounds", "getInterceptorTopOffset", "getLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "h", "onDestroyView", "onStop", "prepareInsetsForNavigation", "prepareInsetsForNavigation$impl_mainlandRelease", "restoreRestingInsets", "removeImeInterceptView", "showLocalMediaBottom", "show", "enableSave", "onSaveClick", "setLocalMediaSaveLoading", "loading", "updatePageImageUrl", ShareType.URL, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryInputFragment extends Fragment {
    public static final /* synthetic */ int D = 0;
    public final Lazy A;
    public final v B;
    public final String C;
    public View d;
    public final zy8.r e;
    public boolean f;
    public boolean g;
    public WindowManager h;
    public View i;
    public int j;
    public l k;
    public View l;
    public boolean m;
    public boolean n;
    public h0 o;
    public View p;
    public View q;
    public int r;
    public boolean s;
    public boolean t;
    public long u;
    public WindowInsetsAnimationCompat v;
    public WindowInsetsCompat w;
    public final r x;
    public final s y;
    public final t z;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ GalleryInputFragment a;
        public final /* synthetic */ View b;

        public b(GalleryInputFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            GalleryInputFragment.ia0(this.a, ViewCompat.getRootWindowInsets(this.b), null, 2);
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ GalleryInputFragment a;

        public c(GalleryInputFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            GalleryInputFragment r10 = this.a;
            int r11 = GalleryInputFragment.D;
            r10.la0();
        }
    }

    static {
    }

    public final void ea0() {
        ja0(false, false);
        fa0(false);
        ia0(this, null, 0, 1);
    }

    public final int V90() {
        View r0 = this.d;
        if (r0 == null) goto L7;
        WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(r0);
        if (r1 == null) goto L7;
        return r1.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L7:
        return 0;
    }

    public final int X90() {
        return ((Number) this.A.getValue()).intValue();
    }

    public final Integer ca0() {
        View r0 = this.q;
        if (r0 != null) goto L5;
    L21:
        return null;
    L5:
        if (r0.isAttachedToWindow() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L21;
        int[] r1 = new int[2];
        r0.getLocationOnScreen(r1);
        int r3 = r1[1];
        if (Build.VERSION.SDK_INT >= 30) goto L18;
        int r4 = 0;
    L20:
        return Integer.valueOf(RangesKt.coerceAtLeast(r3 - r4, 0));
    L18:
        i0.a.getClass();
        r4 = i0.g();
        goto L20
    L7:
        if (r0.getHeight() <= 0) goto L9;
        r2 = true;
        goto L10
    }

    public final void da0() {
        View r0 = this.i;
        Unit r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L6:
        if (r2 != null) goto L19;
        return;
    L19:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        WindowManager r4 = this.h;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.removeViewImmediate(this.i);     // Catch: Throwable -> L13
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r5 = Result.constructor-impl(r1);     // Catch: Throwable -> L13
    L15:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        FLogger.a.e(this.C, "removeWindowView failed throwable=" + r6 + ", message=" + r6.getMessage());
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    public final void ka0() {
        View r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getParent() == null) goto L7;
        boolean r1 = true;
    L8:
        Unit r2 = null;
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L42;
        Integer r3 = ca0();
        if (r3 == null) goto L40;
        int r4 = r3.intValue();
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        if ((r5 instanceof WindowManager.LayoutParams) == false) goto L19;
        WindowManager.LayoutParams r6 = (WindowManager.LayoutParams) r5;
    L20:
        if (r6 != null) goto L23;
        return;
    L23:
        if (r6.height != r4) goto L25;
        return;
    L25:
        r6.height = r4;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L31
        WindowManager r8 = this.h;     // Catch: Throwable -> L31
        if (r8 == null) goto L29;
        r8.updateViewLayout(r0, r6);     // Catch: Throwable -> L31
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Object r9 = Result.constructor-impl(r2);     // Catch: Throwable -> L31
    L33:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L41;
        FLogger.a.e(this.C, "updateWindowView failed throwable=" + r10);
        return;
    L41:
        return;
    L31:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L19:
        r6 = null;
        goto L20
    L40:
        return;
    L42:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void la0() {
        View r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.q;
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.m == false) goto L11;
    L19:
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L22;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
    L23:
        int r4 = 0;
        if (r3 == null) goto L29;
        int r5 = RangesKt.coerceAtLeast(this.r - i5.h(), 0);
        if (r3.bottomMargin == r5) goto L29;
        r3.bottomMargin = r5;
        r0.setLayoutParams(r3);
    L29:
        if (Z90() == false) goto L31;
        int r6 = V90() + i5.h();
    L32:
        View r7 = this.d;
        if (r7 == null) goto L35;
        int r8 = r7.getPaddingBottom();
    L36:
        r0.setTranslationY(RangesKt.coerceAtLeast(r8 - r6, 0));
        if (this.t == true) goto L40;
        r4 = 8;
    L44:
        r0.setVisibility(r4);
        return;
    L40:
        if (this.s == false) goto L42;
    L43:
        r4 = 4;
        goto L44
    L42:
        if (this.r != 0) goto L44;
    L35:
        r8 = 0;
        goto L36
    L31:
        r6 = X90();
        goto L32
    L22:
        r3 = null;
        goto L23
    L11:
        if (this.v != null) goto L19;
        if (this.s == true) goto L19;
        if (r1.getHeight() <= 0) goto L19;
        if (SystemClock.uptimeMillis() < this.u) goto L19;
        this.r = r1.getHeight();
        goto L19
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.chat.gallery.providers.input.r] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.chat.gallery.providers.input.s] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.chat.gallery.providers.input.t] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.chat.gallery.providers.input.v] */
    public GalleryInputFragment() {
        this.e = new zy8.r();
        this.x = new r(this);
        this.y = new s(this);
        this.z = new t(this);
        this.A = LazyKt.lazy(new u(this));
        this.B = new v(this);
        this.C = "GalleryInputFragment";
    }

    public final int W90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L17;
        View r2 = S90(r1);
        if (r2 == null) goto L18;
        Rect r3 = new Rect();
        r2.getWindowVisibleDisplayFrame(r3);
        int r4 = Math.abs(r2.getBottom() - r3.bottom);
        if (Z90() == false) goto L12;
        int r5 = V90() + i5.h();
    L14:
        return RangesKt.coerceAtLeast(r4, r5);
    L12:
        r5 = X90();
        goto L14
    L18:
        return 0;
    L17:
        return 0;
    L15:
        return 0;
    }

    public final boolean Y90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("prepare_for_navigation", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean Z90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("respect_ime_visibility", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean aa0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("use_burst_result_sug_layout", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean ba0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        View r2 = S90(r1);
        if (r2 == null) goto L16;
        Rect r3 = new Rect();
        r2.getWindowVisibleDisplayFrame(r3);
        int r4 = r2.getHeight();
        if ((r4 - r3.height()) <= (((double) r4) * 0.15d)) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    L14:
        return false;
    L13:
        return false;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        da0();
        View r0 = this.l;
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.removeOnGlobalLayoutListener(this.k);
    L7:
        View r2 = this.d;
        if (r2 == null) goto L15;
        r2.removeCallbacks(this.y);
        r2.removeCallbacks(this.z);
        r2.removeOnLayoutChangeListener(this.x);
        if (Z90() == false) goto L12;
    L13:
        ViewCompat.setOnApplyWindowInsetsListener(r2, null);
    L14:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r2, null);
        goto L15
    L12:
        if (aa0() == false) goto L14;
    L15:
        this.o = null;
        Handler r3 = t0.a;
        final v r4 = this.B;
        r3.removeCallbacks(new com.larus.chat.gallery.providers.input.c(r4));
        View r5 = this.q;
        if (r5 == null) goto L18;
        r5.removeCallbacks(this.y);
    L18:
        View r6 = this.q;
        if (r6 == null) goto L21;
        r6.removeOnLayoutChangeListener(this.x);
    L21:
        this.q = null;
        this.p = null;
        this.r = 0;
        this.u = 0;
        this.t = false;
        this.s = false;
        this.v = null;
        this.w = null;
        this.m = false;
        this.d = null;
        this.l = null;
        this.k = null;
        this.i = null;
        this.h = null;
    }

    public final void onStart() {
        super.onStart();
        if (Y90() == true) goto L5;
        return;
    L5:
        View r0 = this.d;
        if (r0 == null) goto L9;
        r0.post(new d(this));
        return;
    }

    public final void onStop() {
        super.onStop();
        if (Y90() == false) goto L8;
        com.larus.chat.gallery.providers.input.a r0 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(this).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r0 == null) goto L9;
        r0.at();
        return;
    L9:
        return;
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void U90(WindowInsetsCompat r3) {
        int r1 = 0;
        if (r3.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.m = r0;
        fa0(r0);
        if (this.m == false) goto L11;
        r1 = r3.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L11:
        T90(r3, r1);
        View r4 = this.d;
        if (r4 == null) goto L14;
        r4.removeCallbacks(this.z);
    L14:
        View r5 = this.d;
        if (r5 == null) goto L17;
        r5.post(this.z);
    L17:
        View r6 = this.d;
        if (r6 == null) goto L21;
        r6.post(this.y);
        return;
    L21:
        return;
    L5:
        if (this.n == true) goto L7;
        r0 = true;
        goto L8
    }

    public final void fa0(boolean r2) {
        View r0 = this.p;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        float r3 = 0.5f;
    L7:
        r0.setAlpha(r3);
        return;
    L6:
        r3 = 1.0f;
        goto L7
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        t1a.b r4 = s1a.a.g(this);
        de8.c r0 = de8.c.s;
        r4.n(de8.c.a.a(getArguments()), de8.c.class);
        s1a.a.g(this).k(this.e, Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.n.class));
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new n(this));
    }

    public final void T90(WindowInsetsCompat r3, int r4) {
        if (Z90() == false) goto L6;
        ha0(r3, Integer.valueOf(r4));
        return;
    L6:
        if (this.n == false) goto L8;
        r4 = 0;
    L8:
        View r5 = this.d;
        if (r5 == null) goto L11;
        r5.setPaddingRelative(0, 0, 0, RangesKt.coerceAtLeast(r4, X90()));
    L11:
        la0();
    }

    public final void ha0(WindowInsetsCompat r5, Integer r6) {
        Integer r0 = null;
        if (r5 != null) goto L8;
        View r7 = this.d;
        if (r7 == null) goto L7;
        r5 = ViewCompat.getRootWindowInsets(r7);
        goto L8
    L7:
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        int r1 = r5.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L12:
        if (this.n == true) goto L26;
        if (r6 == null) goto L16;
        int r8 = r6.intValue();
    L27:
        int r9 = Math.max(r1 + i5.h(), r8);
        View r10 = this.d;
        if (r10 == null) goto L30;
        r10.setPaddingRelative(0, 0, 0, r9);
    L30:
        la0();
        return;
    L16:
        if (r5 != null) goto L18;
    L24:
        if (r0 == null) goto L26;
        r8 = r0.intValue();
        goto L27
    L18:
        if (Z90() == true) goto L20;
    L22:
        int r11 = r5.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L23:
        r0 = Integer.valueOf(r11);
        goto L24
    L20:
        if (r5.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L22;
        r11 = 0;
    L26:
        r8 = 0;
        goto L27
    L10:
        r1 = V90();
        goto L12
    }

    public final void ja0(boolean r5, boolean r6) {
        boolean r0 = true;
        if (r5 == true) goto L5;
    L7:
        boolean r7 = false;
    L8:
        this.m = r7;
        if (r7 == false) goto L93;
        Unit r2 = null;
        if (this.i != null) goto L25;
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L15;
        Object r9 = r8.getSystemService("window");
    L17:
        if ((r9 instanceof WindowManager) == false) goto L19;
        WindowManager r10 = (WindowManager) r9;
    L20:
        this.h = r10;
        View r11 = new View(getContext());
        e1.d(r11, new g(this));
        this.i = r11;
        if (r6 == false) goto L25;
        com.larus.chat.gallery.providers.input.a r12 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(this).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r12 == null) goto L25;
        r12.i1(new h(this));
        goto L25
    L19:
        r10 = null;
        goto L20
    L15:
        r9 = null;
    L25:
        View r13 = this.i;
        if (r13 == null) goto L29;
        r13.setClickable(true);
    L29:
        if (aa0() == false) goto L37;
        View r14 = this.i;
        if (r14 == null) goto L33;
        ViewParent r15 = r14.getParent();
    L34:
        if (r15 == null) goto L37;
        ka0();
        return;
    L33:
        r15 = null;
    L37:
        View r16 = this.i;
        if (r16 == null) goto L40;
        ViewParent r17 = r16.getParent();
    L41:
        if (r17 == null) goto L98;
        da0();
    L98:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L87
        if (aa0() == false) goto L49;
        Integer r19 = ca0();     // Catch: Throwable -> L87
        if (r19 == null) goto L48;
        int r20 = r19.intValue();     // Catch: Throwable -> L87
    L82:
        WindowManager r21 = this.h;     // Catch: Throwable -> L87
        if (r21 == null) goto L85;
        View r1 = this.i;     // Catch: Throwable -> L87
        int r22 = RangesKt.coerceAtLeast(r20, 0);     // Catch: Throwable -> L87
        WindowManager.LayoutParams r3 = new WindowManager.LayoutParams();     // Catch: Throwable -> L87
        r3.type = 2;     // Catch: Throwable -> L87
        r3.flags = 552;     // Catch: Throwable -> L87
        r3.format = -2;     // Catch: Throwable -> L87
        r3.gravity = 8388659;     // Catch: Throwable -> L87
        r3.width = -1;     // Catch: Throwable -> L87
        r3.height = r22;     // Catch: Throwable -> L87
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r1, r3);     // Catch: Throwable -> L87
        r21.addView(r1, r3);     // Catch: Throwable -> L87
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L87
    L85:
        Object r23 = Result.constructor-impl(r2);     // Catch: Throwable -> L87
    L89:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L92;
        FLogger.a.e(this.C, "addWindowView failed throwable=" + r24 + ", message=" + r24.getMessage());
    L92:
        Result.box-impl(r23);
        return;
    L48:
        return;
    L49:
        View r25 = this.d;     // Catch: Throwable -> L87
        if (r25 == null) goto L59;
        Integer r26 = Integer.valueOf(r25.getHeight());     // Catch: Throwable -> L87
        if (r26.intValue() <= 0) goto L54;
        boolean r27 = true;
    L55:
        if (r27 == true) goto L58;
        r26 = null;
    L58:
        if (r26 == null) goto L59;
    L63:
        if (r26 != null) goto L65;
    L73:
        View r28 = this.d;     // Catch: Throwable -> L87
        if (r28 == null) goto L76;
        int r29 = r28.getPaddingBottom();     // Catch: Throwable -> L87
    L77:
        int r30 = m0.a;     // Catch: Throwable -> L87
        int r31 = m0.a(getContext()) - r29;     // Catch: Throwable -> L87
        if (Build.VERSION.SDK_INT >= 30) goto L80;
        int r32 = 0;
    L81:
        r20 = r31 - r32;     // Catch: Throwable -> L87
        goto L82
    L80:
        i0.a.getClass();     // Catch: Throwable -> L87
        r32 = i0.g();     // Catch: Throwable -> L87
        goto L81
    L76:
        r29 = 0;
        goto L77
    L65:
        if (r26.intValue() > 0) goto L68;
        r0 = false;
    L68:
        if (r0 == true) goto L71;
        r26 = null;
    L71:
        if (r26 == null) goto L73;
        r29 = r26.intValue();     // Catch: Throwable -> L87
        goto L77
    L54:
        r27 = false;
    L59:
        View r33 = this.d;     // Catch: Throwable -> L87
        if (r33 == null) goto L62;
        r26 = Integer.valueOf(r33.getMeasuredHeight());     // Catch: Throwable -> L87
        goto L63
    L62:
        r26 = null;
    L87:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L89
    L40:
        r17 = null;
        goto L41
    L93:
        View r35 = this.i;
        if (r35 == null) goto L96;
        r35.setClickable(false);
    L96:
        da0();
        return;
    L5:
        if (this.n == true) goto L7;
        r7 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [com.larus.chat.gallery.providers.input.l] */
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        if (aa0() == false) goto L8;
        if (Build.VERSION.SDK_INT < 30) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r7, new e(this));
        ViewCompat.requestApplyInsets(r7);
    L19:
        if (r7.isLaidOut() == true) goto L21;
    L23:
        r7.addOnLayoutChangeListener(new c(this));
    L25:
        if (Build.VERSION.SDK_INT >= 30) goto L27;
        FLogger.a.i(this.C, "watchOnGlobalLayout");
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L63;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L58;
        WindowManager.LayoutParams r11 = r10.getAttributes();
        if (r11 != null) goto L43;
        return;
    L43:
        if ((r11.flags & 512) != 0) goto L49;
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L49;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L49;
        r13.clearFlags(512);
    L49:
        this.l = r9.findViewById(R.id.content);
        this.j = W90();
        this.k = new l(this);
        View r14 = this.l;
        if (r14 == null) goto L60;
        ViewTreeObserver r15 = r14.getViewTreeObserver();
        if (r15 == null) goto L61;
        r15.addOnGlobalLayoutListener(this.k);
        return;
    L61:
        return;
    L60:
        return;
    L58:
        return;
    L63:
        return;
    L27:
        if (aa0() == false) goto L32;
        final View r16 = this.d;
        if (r16 == null) goto L62;
        ViewCompat.setWindowInsetsAnimationCallback(r16, new GalleryInputFragment$watchOnPreviewInsetsAnimation$1(this, r16));
        return;
    L62:
        return;
    L32:
        View r0 = this.d;
        if (r0 == null) goto L56;
        ViewExtKt.l(r0, new i(this), null, new j(this), new k(this), 2);
        return;
    L56:
        return;
    L21:
        if (r7.isLayoutRequested() == true) goto L23;
        la0();
    L8:
        if (Z90() == false) goto L15;
        ViewCompat.setOnApplyWindowInsetsListener(r7, new f(this));
        ViewCompat.requestApplyInsets(r7);
        if (r7.isLaidOut() == true) goto L12;
    L14:
        r7.addOnLayoutChangeListener(new b(this, r7));
        goto L19
    L12:
        if (r7.isLayoutRequested() == true) goto L14;
        ia0(this, ViewCompat.getRootWindowInsets(r7), null, 2);
        goto L19
    L15:
        View r17 = this.d;
        if (r17 == null) goto L19;
        r17.setPadding(0, 0, 0, X90());
        goto L19
    }

    public final void ga0(boolean r3, boolean r4, Function0<Unit> r5) {
        if (r3 == false) goto L7;
        h0 r6 = this.o;
        if (r6 == null) goto L11;
        r6.f = r4;
        r6.h = r5;
        r6.d.invoke();
        r6.e.invoke();
        r6.a.setVisibility(8);
        r6.b.setVisibility(0);
        r6.a();
        return;
    L11:
        return;
    L7:
        h0 r7 = this.o;
        if (r7 == null) goto L13;
        r7.g = false;
        r7.h = null;
        r7.a.setVisibility(0);
        r7.b.setVisibility(8);
        r7.a();
        return;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.chat.gallery.providers.input.x] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.chat.gallery.providers.input.y] */
    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131562826, r11, false);
        ViewStub r1 = (ViewStub) r13.findViewById(2131375364);
        InputViewCreatorDelegate r2 = InputViewCreatorDelegate.b;
        Intrinsics.checkNotNull(r1);
        r2.a(r1, 2131375364);
        if (aa0() == false) goto L14;
        Intrinsics.checkNotNull(r13);
        if ((r13 instanceof FrameLayout) == false) goto L7;
        FrameLayout r14 = (FrameLayout) r13;
    L8:
        if (r14 == null) goto L14;
        r14.setClipToPadding(false);
        View r3 = r13.findViewById(2131375324);
        if (r3 == null) goto L14;
        View r15 = r10.inflate(2131562827, r14, false);
        r14.addView(r15, 0, new FrameLayout.LayoutParams(-1, -2, 80));
        this.p = r15;
        this.q = r3;
        r3.addOnLayoutChangeListener(this.x);
        r15.setVisibility(8);
        r14.addOnLayoutChangeListener(this.x);
        r3.post(this.y);
        goto L14
    L7:
        r14 = null;
    L14:
        this.o = new h0(r13.findViewById(2131375324), r13.findViewById(2131379114), r13.findViewById(2131379115), new x(this), new y(this));
        this.d = r13;
        return r13;
    }

    public static /* synthetic */ void ia0(GalleryInputFragment r2, WindowInsetsCompat r3, Integer r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        r2.ha0(r3, r4);
    }
}
