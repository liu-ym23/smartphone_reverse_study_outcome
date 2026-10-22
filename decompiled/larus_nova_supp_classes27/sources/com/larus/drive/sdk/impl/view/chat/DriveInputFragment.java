package com.larus.drive.sdk.impl.view.chat;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.collection.LruCache;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.drive.sdk.impl.view.common.TouchInterceptFrameLayout;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\u000e\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u000bJ\u000e\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u000bJ\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\u001a\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\u0019H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020\u000bH\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010!¨\u0006E"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/DriveInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "driveInputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "rootView", "Landroid/view/View;", "interceptorView", "contentView", "inputDisabled", "", "windowManager", "Landroid/view/WindowManager;", "globalListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "preHeight", "", "originBottomMargin", "getOriginBottomMargin", "()I", "originBottomMargin$delegate", "Lkotlin/Lazy;", "updateInterceptRunnable", "Lkotlin/Function0;", "", "driveInputAbility", "Lcom/larus/drive/sdk/api/ability/IDriveGalleryInputAbility;", "getDriveInputAbility", "()Lcom/larus/drive/sdk/api/ability/IDriveGalleryInputAbility;", "driveInputAbility$delegate", "shouldSubtractHostConsumedBottomInset", "getShouldSubtractHostConsumedBottomInset", "()Z", "shouldSubtractHostConsumedBottomInset$delegate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "changeInputVisible", "visible", "setInputEnabled", "enabled", "attachComponents", "watchOnImeStatus", "watchOnInsetsAnimation", "watchOnGlobalLayout", "updateInterceptorView", "isImeShow", "needSetExternalImeFunc", "getInterceptorTopOffset", "removeImeInterceptView", "getLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "h", "isImeVisible", "resolveCurrentImePaddingBottom", "resolveImePaddingBottom", "rawImeBottomInset", "resolveHostConsumedBottomInset", "getDecorViewInvisibleHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveInputFragment extends Fragment {
    public static final /* synthetic */ int o = 0;
    public TouchInterceptFrameLayout d;
    public View e;
    public View f;
    public boolean g;
    public WindowManager h;
    public p i;
    public int j;
    public final Lazy k;
    public final a0 l;
    public final Lazy m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    public final void V90() {
        View r0 = this.e;
        Unit r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if (r2 != null) goto L21;
        FLogger.a.i("DriveGalleryInputFragment", "DriveInput interceptorView no parent");
        return;
    L21:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        WindowManager r4 = this.h;     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        r4.removeViewImmediate(this.e);     // Catch: Throwable -> L15
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r5 = Result.constructor-impl(r1);     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L23;
        FLogger.a.e("DriveGalleryInputFragment", "RemoveWindowView failed throwable=" + r6 + ", message=" + r6.getMessage());
        return;
    L23:
        return;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.drive.sdk.impl.view.chat.a0] */
    public DriveInputFragment() {
        this.k = LazyKt.lazy(new z(this));
        this.l = new a0(this);
        this.m = LazyKt.lazy(new b0(this));
        this.n = LazyKt.lazy(new c0(this));
    }

    public final int T90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L13;
        View r2 = S90(r1);
        if (r2 == null) goto L14;
        Rect r3 = new Rect();
        r2.getWindowVisibleDisplayFrame(r3);
        return RangesKt.coerceAtLeast(Math.abs(r2.getBottom() - r3.bottom), ((Number) this.k.getValue()).intValue());
    L14:
        return 0;
    L13:
        return 0;
    L11:
        return 0;
    }

    public final boolean U90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L12;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L12;
        View r2 = S90(r1);
        if (r2 == null) goto L12;
        Rect r3 = new Rect();
        r2.getWindowVisibleDisplayFrame(r3);
        int r4 = r2.getHeight();
        if ((r4 - r3.height()) <= (((double) r4) * 0.15d)) goto L12;
        return true;
    L12:
        return false;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        V90();
        View r0 = this.f;
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.removeOnGlobalLayoutListener(this.i);
    L7:
        TouchInterceptFrameLayout r2 = this.d;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r2, null);
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

    public final int W90(int r7) {
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L29;
        TouchInterceptFrameLayout r0 = this.d;
        if (r0 == null) goto L26;
        Integer r2 = Integer.valueOf(r0.getHeight());
        if (r2.intValue() <= 0) goto L10;
        boolean r3 = true;
    L11:
        Integer r5 = null;
        if (r3 == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L17;
        int r4 = r2.intValue();
    L25:
        int[] r6 = new int[2];
        r0.getLocationOnScreen(r6);
        int r1 = r6[1] + r4;
        int r8 = m0.a;
        int r9 = RangesKt.coerceAtLeast(m0.a(getContext()) - r1, 0);
    L27:
        r7 = RangesKt.coerceAtLeast(r7 - r9, 0);
        goto L29
    L17:
        Integer r10 = Integer.valueOf(r0.getMeasuredHeight());
        if (r10.intValue() <= 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L23;
        r5 = r10;
    L23:
        if (r5 == null) goto L26;
        r4 = r5.intValue();
        goto L25
    L20:
        r11 = false;
        goto L21
    L10:
        r3 = false;
    L26:
        r9 = 0;
    L29:
        return RangesKt.coerceAtLeast(r7, ((Number) this.k.getValue()).intValue());
    }

    public final void X90(boolean r3) {
        boolean r4 = !r3;
        if (this.g != r4) goto L5;
        return;
    L5:
        TouchInterceptFrameLayout r0 = this.d;
        if (r0 != null) goto L8;
        return;
    L8:
        this.g = r4;
        if (r4 == false) goto L11;
        float r1 = 0.5f;
    L12:
        r0.setAlpha(r1);
        if (r4 == false) goto L17;
        r79.c r2 = (r79.c) this.m.getValue();
        if (r2 == null) goto L17;
        r2.g();
    L17:
        r0.setInterceptAllTouch(r4);
        return;
    L11:
        r1 = 1.0f;
        goto L12
    }

    public final void onCreate(Bundle r26) {
        super.onCreate(r26);
        Bundle r1 = getArguments();
        if (r1 != null) goto L5;
        r1 = com.larus.utils.f.c(new Pair[0]);
    L5:
        Bundle r3 = new Bundle(r1);
        r3.remove("arg_subtract_host_consumed_bottom_inset");
        t1a.b r2 = s1a.a.g(this);
        LruCache r5 = ko8.a.a;
        r2.n(new de8.c(r3, r3, false, null, null, false, null, null, null, null, false, false, null, ko8.a.g(), 24572), de8.c.class);
        ChatParam r4 = new ChatParam(null, null, null, null, null, 255);
        r4.d = "ai_space_detail";
        r4.a = "";
        r4.b = com.larus.drive.sdk.impl.utils.n.f();
        s1a.a.g(this).n(r4, ChatParam.class);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new v(this));
    }

    public final void Y90(boolean r4, boolean r5) {
        if (r4 == false) goto L71;
        Unit r1 = null;
        if (this.e != null) goto L19;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L9;
        Object r7 = r6.getSystemService("window");
    L11:
        if ((r7 instanceof WindowManager) == false) goto L13;
        WindowManager r8 = (WindowManager) r7;
    L14:
        this.h = r8;
        View r9 = new View(getContext());
        e1.d(r9, new d0(this));
        this.e = r9;
        if (r5 == false) goto L19;
        r79.c r10 = (r79.c) this.m.getValue();
        if (r10 == null) goto L19;
        r10.i1(new q(this));
        goto L19
    L13:
        r8 = null;
        goto L14
    L9:
        r7 = null;
    L19:
        View r11 = this.e;
        boolean r12 = true;
        if (r11 == null) goto L22;
        r11.setClickable(true);
    L22:
        View r13 = this.e;
        if (r13 == null) goto L25;
        ViewParent r14 = r13.getParent();
    L26:
        if (r14 == null) goto L76;
        V90();
    L76:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L65
        TouchInterceptFrameLayout r16 = this.d;     // Catch: Throwable -> L65
        if (r16 == null) goto L38;
        Integer r17 = Integer.valueOf(r16.getHeight());     // Catch: Throwable -> L65
        if (r17.intValue() <= 0) goto L33;
        boolean r2 = true;
    L34:
        if (r2 == true) goto L37;
        r17 = null;
    L37:
        if (r17 == null) goto L38;
    L42:
        if (r17 != null) goto L44;
    L52:
        TouchInterceptFrameLayout r18 = this.d;     // Catch: Throwable -> L65
        if (r18 == null) goto L55;
        int r20 = r18.getPaddingBottom();     // Catch: Throwable -> L65
    L56:
        int r21 = m0.a;     // Catch: Throwable -> L65
        int r22 = m0.a(getContext()) - r20;     // Catch: Throwable -> L65
        if (Build.VERSION.SDK_INT >= 30) goto L59;
        int r23 = 0;
    L60:
        int r24 = r22 - r23;     // Catch: Throwable -> L65
        WindowManager r25 = this.h;     // Catch: Throwable -> L65
        if (r25 == null) goto L63;
        View r3 = this.e;     // Catch: Throwable -> L65
        int r26 = RangesKt.coerceAtLeast(r24, 0);     // Catch: Throwable -> L65
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();     // Catch: Throwable -> L65
        r0.type = 2;     // Catch: Throwable -> L65
        r0.flags = 552;     // Catch: Throwable -> L65
        r0.format = -2;     // Catch: Throwable -> L65
        r0.gravity = 8388659;     // Catch: Throwable -> L65
        r0.width = -1;     // Catch: Throwable -> L65
        r0.height = r26;     // Catch: Throwable -> L65
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r3, r0);     // Catch: Throwable -> L65
        r25.addView(r3, r0);     // Catch: Throwable -> L65
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L65
    L63:
        Object r27 = Result.constructor-impl(r1);     // Catch: Throwable -> L65
    L67:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L70;
        FLogger.a.e("DriveGalleryInputFragment", "AddWindowView failed throwable=" + r28 + ", message=" + r28.getMessage());
    L70:
        Result.box-impl(r27);
        return;
    L59:
        i0.a.getClass();     // Catch: Throwable -> L65
        r23 = i0.g();     // Catch: Throwable -> L65
        goto L60
    L55:
        r20 = 0;
        goto L56
    L44:
        if (r17.intValue() > 0) goto L47;
        r12 = false;
    L47:
        if (r12 == true) goto L50;
        r17 = null;
    L50:
        if (r17 == null) goto L52;
        r20 = r17.intValue();     // Catch: Throwable -> L65
        goto L56
    L33:
        r2 = false;
    L38:
        TouchInterceptFrameLayout r30 = this.d;     // Catch: Throwable -> L65
        if (r30 == null) goto L41;
        r17 = Integer.valueOf(r30.getMeasuredHeight());     // Catch: Throwable -> L65
        goto L42
    L41:
        r17 = null;
    L65:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    L25:
        r14 = null;
        goto L26
    L71:
        View r32 = this.e;
        if (r32 == null) goto L74;
        r32.setClickable(false);
    L74:
        V90();
    }

    /* JADX WARN: Type inference failed for: r8v7, types: [com.larus.drive.sdk.impl.view.chat.p] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        TouchInterceptFrameLayout r10 = this.d;
        if (r10 == null) goto L6;
        r10.setPadding(0, 0, 0, ((Number) this.k.getValue()).intValue());
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L10;
        FLogger.a.i("DriveGalleryInputFragment", "[Ime Status] watchOnInsetsAnimation");
        TouchInterceptFrameLayout r1 = this.d;
        if (r1 == null) goto L30;
        ViewExtKt.l(r1, new w(), null, new x(this), new y(this), 2);
        return;
    L30:
        return;
    L10:
        FLogger.a.i("DriveGalleryInputFragment", "[Ime Status] watchOnGlobalLayout");
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L36;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L32;
        WindowManager.LayoutParams r13 = r12.getAttributes();
        if (r13 != null) goto L18;
        return;
    L18:
        if ((r13.flags & 512) != 0) goto L24;
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L24;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L24;
        r15.clearFlags(512);
    L24:
        this.f = r11.findViewById(R.id.content);
        this.j = T90();
        this.i = new p(this);
        View r16 = this.f;
        if (r16 == null) goto L34;
        ViewTreeObserver r17 = r16.getViewTreeObserver();
        if (r17 == null) goto L35;
        r17.addOnGlobalLayoutListener(this.i);
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r7 = r4.inflate(2131562826, r5, false);
        ViewStub r1 = (ViewStub) r7.findViewById(2131375364);
        InputViewCreatorDelegate r2 = InputViewCreatorDelegate.b;
        Intrinsics.checkNotNull(r1);
        r2.a(r1, 2131375364);
        TouchInterceptFrameLayout r8 = new TouchInterceptFrameLayout(r4.getContext(), null, 6, 0);
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if (r9 == null) goto L5;
        r8.setLayoutParams(r9);
    L5:
        r8.addView(r7, new ViewGroup.LayoutParams(-1, -2));
        this.d = r8;
        return r8;
    }
}
