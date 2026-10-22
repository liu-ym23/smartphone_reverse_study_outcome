package com.larus.common_ui.fragment;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.crash.d;
import com.larus.bmhome.video.fragment.VideoDetailPagerFragment;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusFragmentCommonSlideBinding;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.view.CommonSlideRootContainer;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f19.e;
import f19.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001%\b&\u0018\u0000 T*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002STB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0019\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\r\u0010$\u001a\u00020%H\u0002¢\u0006\u0002\u0010&J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0012\u0010*\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J!\u0010+\u001a\u00020\u001c2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010-\u001a\u00020\u0013¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u0013H\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\u0006\u00102\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\u001cJ\u0006\u00104\u001a\u00020\u001cJ\u0006\u00105\u001a\u00020\u001cJ\u0006\u00106\u001a\u00020\u001cJ\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u0013J\u0006\u00109\u001a\u00020\u001cJ\u0006\u0010:\u001a\u00020\u001cJ\u0006\u0010;\u001a\u00020\u001cJ\u0006\u0010<\u001a\u00020\u001cJ\u0006\u0010=\u001a\u00020\u001cJ\u0006\u0010>\u001a\u00020\u001cJ\u0006\u0010?\u001a\u00020\u001cJ\u0006\u0010@\u001a\u00020\u001cJ\u0006\u0010A\u001a\u00020\u001cJ\u0006\u0010B\u001a\u00020\u001cJ\b\u0010C\u001a\u0004\u0018\u00010DJ&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010K\u001a\u00020\u001cH\u0002J\b\u0010L\u001a\u00020\u001cH\u0002J\u001a\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020F2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010O\u001a\u00020\u001cH\u0002J\b\u0010P\u001a\u00020\u001cH\u0002J\b\u0010Q\u001a\u00020\u001cH\u0016J\b\u0010R\u001a\u00020\u001cH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/larus/common_ui/fragment/CommonSlideDialogFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "rootBinding", "Lcom/larus/common_res/common_ui/databinding/LarusFragmentCommonSlideBinding;", "getRootBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusFragmentCommonSlideBinding;", "setRootBinding", "(Lcom/larus/common_res/common_ui/databinding/LarusFragmentCommonSlideBinding;)V", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "needDispatcherScrollEvent", "", "getNeedDispatcherScrollEvent", "()Z", "setNeedDispatcherScrollEvent", "(Z)V", "previousPos", "initViewBinding", "()Landroidx/viewbinding/ViewBinding;", "initView", "", "savedInstanceState", "Landroid/os/Bundle;", "initViewModel", "getInitItemPosition", "dispatchContainerEvent", "event", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment$ContainerEvent;", "onPageChangeCallback", "com/larus/common_ui/fragment/CommonSlideDialogFragment$onPageChangeCallback$1", "()Lcom/larus/common_ui/fragment/CommonSlideDialogFragment$onPageChangeCallback$1;", "getPagerAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "getFeedDirection", "onCreate", "dismissFragment", "orientation", "isAnim", "(Ljava/lang/Integer;Z)V", "initViewAnimator", "needCommonSlide", "clickBackCallback", "isMoreVisible", "showMoreWithAnimator", "showMore", "dismissMore", "dismissShare", "enableShare", "enable", "showOrDismissBackWithPinch", "showOrDismissMoreWithPinch", "showOrDismissShareWithPinch", "dismissBackWithPinch", "dismissMoreWithPinch", "dismissShareWithPinch", "showBackWithPinch", "showShareWithPinch", "showMoreWithPinch", "dismissMoreWithAnimator", "getViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupDialogWindow", "makeNavigateBarTransparent", "onViewCreated", "view", "setInitItem", "handleBackPressed", "onDestroy", "onDestroyView", "ContainerEvent", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CommonSlideDialogFragment<VB extends ViewBinding> extends AppCompatDialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusFragmentCommonSlideBinding d;
    public int e;
    public boolean f;
    public int g;

    public static final class a {
    }

    public interface b {

        public static final class a implements b {
            public final int a;

            public a(int r1) {
                this.a = r1;
            }
        }

        /* JADX INFO: renamed from: com.larus.common_ui.fragment.CommonSlideDialogFragment$b$b, reason: collision with other inner class name */
        public static final class C0011b implements b {
            public static final C0011b a = null;

            static {
                a = new C0011b();
            }

            public C0011b() {
            }
        }

        public static final class c implements b {
            public c() {
            }
        }

        public static final class d implements b {
            public final int a;
            public final int b;

            public d(int r1, int r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class e implements b {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }
    }

    public static final class c implements Animation.AnimationListener {
        public final /* synthetic */ CommonSlideDialogFragment<VB> a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public c(CommonSlideDialogFragment<VB> r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
        L10:
            FLogger.a.e("CommonSlideDialogFragment", "fallback by dismiss failed");
            return;
        L15:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L12:
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: IllegalStateException -> L10
            Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L10
            if (r4 == null) goto L12;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L10
            goto L12
        }
    }

    static {
    }

    public void T90() {
    }

    public void Y90(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public int aa0() {
        return 1;
    }

    public int ba0() {
        return 0;
    }

    public FragmentStateAdapter ca0() {
        return null;
    }

    public abstract VB ea0();

    public void fa0() {
    }

    public boolean ga0() {
        return this instanceof VideoDetailPagerFragment;
    }

    public final void W90() {
        LarusFragmentCommonSlideBinding r0 = this.d;
        if (r0 == null) goto L8;
        ImageView r1 = r0.f;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    L9:
        return;
    }

    public final void X90() {
        LarusFragmentCommonSlideBinding r0 = this.d;
        if (r0 == null) goto L8;
        ImageView r1 = r0.g;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    L9:
        return;
    }

    public final void ha0() {
        LarusFragmentCommonSlideBinding r0 = this.d;
        boolean r1 = false;
        if (r0 == null) goto L9;
        ImageView r2 = r0.b;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 8) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        LarusFragmentCommonSlideBinding r3 = this.d;
        if (r3 == null) goto L17;
        ImageView r4 = r3.b;
        if (r4 == null) goto L18;
        ViewExtKt.d(r4);
        return;
    L18:
        return;
    }

    public final void ia0() {
        LarusFragmentCommonSlideBinding r0 = this.d;
        boolean r1 = false;
        if (r0 == null) goto L9;
        ImageView r2 = r0.f;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 8) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        LarusFragmentCommonSlideBinding r3 = this.d;
        if (r3 == null) goto L17;
        ImageView r4 = r3.f;
        if (r4 == null) goto L18;
        ViewExtKt.d(r4);
        return;
    L18:
        return;
    }

    public final void ja0() {
        LarusFragmentCommonSlideBinding r0 = this.d;
        boolean r1 = true;
        if (r0 == null) goto L9;
        ImageView r2 = r0.b;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 8) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return;
    L12:
        LarusFragmentCommonSlideBinding r4 = this.d;
        if (r4 == null) goto L19;
        ImageView r5 = r4.b;
        if (r5 == null) goto L19;
        if (r5.getVisibility() != 0) goto L19;
    L20:
        if (r1 == false) goto L26;
        LarusFragmentCommonSlideBinding r6 = this.d;
        if (r6 == null) goto L32;
        ImageView r7 = r6.b;
        if (r7 == null) goto L33;
        r7.setVisibility(4);
        return;
    L33:
        return;
    L32:
        return;
    L26:
        LarusFragmentCommonSlideBinding r8 = this.d;
        if (r8 == null) goto L35;
        ImageView r9 = r8.b;
        if (r9 == null) goto L36;
        r9.setVisibility(0);
        return;
    L36:
        return;
    L35:
        return;
    L19:
        r1 = false;
    L9:
        r3 = false;
        goto L10
    }

    public final void ka0() {
        LarusFragmentCommonSlideBinding r0 = this.d;
        boolean r1 = true;
        if (r0 == null) goto L9;
        ImageView r2 = r0.g;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 8) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return;
    L12:
        LarusFragmentCommonSlideBinding r4 = this.d;
        if (r4 == null) goto L19;
        ImageView r5 = r4.g;
        if (r5 == null) goto L19;
        if (r5.getVisibility() != 0) goto L19;
    L20:
        if (r1 == false) goto L26;
        LarusFragmentCommonSlideBinding r6 = this.d;
        if (r6 == null) goto L32;
        ImageView r7 = r6.g;
        if (r7 == null) goto L33;
        r7.setVisibility(4);
        return;
    L33:
        return;
    L32:
        return;
    L26:
        LarusFragmentCommonSlideBinding r8 = this.d;
        if (r8 == null) goto L35;
        ImageView r9 = r8.g;
        if (r9 == null) goto L36;
        r9.setVisibility(0);
        return;
    L36:
        return;
    L35:
        return;
    L19:
        r1 = false;
    L9:
        r3 = false;
        goto L10
    }

    public final void la0() {
        LarusFragmentCommonSlideBinding r0 = this.d;
        boolean r1 = false;
        if (r0 == null) goto L9;
        ImageView r2 = r0.g;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 8) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        LarusFragmentCommonSlideBinding r3 = this.d;
        if (r3 == null) goto L17;
        ImageView r4 = r3.g;
        if (r4 == null) goto L18;
        ViewExtKt.d(r4);
        return;
    L18:
        return;
    }

    public CommonSlideDialogFragment() {
        this.e = -1;
        this.f = true;
        this.g = -1;
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.d = null;
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        LarusFragmentCommonSlideBinding r0 = this.d;
        if (r0 == null) goto L8;
        ViewPager2 r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setAdapter(null);
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

    public final void Z90(boolean r2) {
        LarusFragmentCommonSlideBinding r0 = this.d;
        if (r0 == null) goto L8;
        ImageView r1 = r0.g;
        if (r1 == null) goto L9;
        r1.setEnabled(r2);
        return;
    L9:
        return;
    }

    public void da0(Bundle r4) {
        if (ga0() == false) goto L27;
        LarusFragmentCommonSlideBinding r5 = this.d;
        if (r5 == null) goto L9;
        ViewPager2 r6 = r5.c;
        if (r6 == null) goto L9;
        r6.setVisibility(0);
    L9:
        LarusFragmentCommonSlideBinding r7 = this.d;
        if (r7 == null) goto L27;
        ViewPager2 r8 = r7.c;
        if (r8 == null) goto L27;
        r8.setAdapter(ca0());
        Dialog r1 = getDialog();
        if (r1 == null) goto L18;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L18;
        r2.setBackgroundDrawable(new ColorDrawable(0));
    L18:
        Dialog r0 = getDialog();
        if (r0 == null) goto L23;
        Window r3 = r0.getWindow();
        if (r3 == null) goto L23;
        WindowManager.LayoutParams r9 = r3.getAttributes();
    L24:
        if (r9 == null) goto L26;
        r9.gravity = 7;
    L26:
        r8.setOffscreenPageLimit(1);
        r8.setOrientation(aa0());
        r8.registerOnPageChangeCallback(new CommonSlideDialogFragment$onPageChangeCallback$1(this));
    L23:
        r9 = null;
    L27:
        LarusFragmentCommonSlideBinding r10 = this.d;
        if (r10 == null) goto L33;
        CommonSlideRootContainer r11 = r10.e;
        if (r11 == null) goto L33;
        r11.setDismissCallback(new f(this));
    L33:
        if (AppHost.a.isPlugin() == false) goto L36;
        X90();
        return;
    }

    public void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        setStyle(2, 2131952391);
    }

    public final void U90(Integer r4, boolean r5) {
        T90();
        if (getContext() != null) goto L5;
        return;
    L5:
        int r0 = 2130772402;
        if (r4 == null) goto L12;
        Context r6 = getContext();
        if (r4.intValue() == 1) goto L11;
        r0 = 2130772412;
    L11:
        Animation r7 = AnimationUtils.loadAnimation(r6, r0);
    L18:
        r7.setAnimationListener(new c(this));
        LarusFragmentCommonSlideBinding r8 = this.d;
        if (r8 == null) goto L24;
        FrameLayout r9 = r8.a;
        if (r9 == null) goto L25;
        r9.startAnimation(r7);
        return;
    L25:
        return;
    L24:
        return;
    L12:
        if (r5 == true) goto L14;
        AlphaAnimation r10 = new AlphaAnimation(1.0f, 0.0f);
        r10.setDuration(200);
        r7 = r10;
        goto L18
    L14:
        Context r11 = getContext();
        if (aa0() != 1) goto L17;
        r0 = 2130772412;
    L17:
        r7 = AnimationUtils.loadAnimation(r11, r0);
        goto L18
    }

    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        LarusFragmentCommonSlideBinding r6 = this.d;
        if (r6 == null) goto L11;
        ImageView r7 = r6.b;
        if (r7 == null) goto L11;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if (r0 == null) goto L10;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        i0.a.getClass();
        r1.topMargin = i0.g();
        r7.setLayoutParams(r1);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        LarusFragmentCommonSlideBinding r8 = this.d;
        if (r8 == null) goto L20;
        ImageView r9 = r8.f;
        if (r9 == null) goto L20;
        ViewGroup.LayoutParams r2 = r9.getLayoutParams();
        if (r2 == null) goto L19;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        i0.a.getClass();
        r3.topMargin = i0.g();
        r9.setLayoutParams(r3);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        LarusFragmentCommonSlideBinding r10 = this.d;
        if (r10 == null) goto L29;
        ImageView r11 = r10.g;
        if (r11 == null) goto L29;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L28;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        i0.a.getClass();
        r13.topMargin = i0.g();
        r11.setLayoutParams(r13);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L29:
        Dialog r14 = getDialog();
        if (r14 == null) goto L51;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L51;
        WindowManager.LayoutParams r16 = r15.getAttributes();
        r15.setLayout(-1, -1);
        int r17 = 0;
        r15.setBackgroundDrawable(new ColorDrawable(0));
        r15.clearFlags(2);
        S90(r15).setPadding(0, 0, 0, 0);
        int r18 = Build.VERSION.SDK_INT;
        if (r18 < 29) goto L37;
        r15.setNavigationBarContrastEnforced(false);
    L37:
        r15.addFlags(Integer.MIN_VALUE);
        S90(r15).setSystemUiVisibility(1280);
        if (r18 <= 28) goto L40;
        r16.layoutInDisplayCutoutMode = 1;
    L40:
        Dialog r20 = getDialog();
        if (r20 == null) goto L51;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L51;
        Context r22 = getContext();
        if (r22 == null) goto L50;
        Resources r23 = r22.getResources();
        if (r23 == null) goto L50;
        r17 = r23.getColor(R.color.transparent);
    L50:
        r21.setNavigationBarColor(r17);
        r21.addFlags(134217728);
    L51:
        Dialog r24 = getDialog();
        if (r24 == null) goto L55;
        r24.setOnKeyListener(new f19.a(this));
    L55:
        if (ga0() == false) goto L61;
        LarusFragmentCommonSlideBinding r25 = this.d;
        if (r25 == null) goto L67;
        final ViewPager2 r26 = r25.c;
        if (r26 == null) goto L68;
        r26.setVisibility(8);
        r26.post(new f19.b(r26, this));
        return;
    L68:
        return;
    L67:
        return;
    L61:
        LarusFragmentCommonSlideBinding r27 = this.d;
        if (r27 == null) goto L70;
        ViewPager2 r28 = r27.c;
        if (r28 == null) goto L71;
        r28.setVisibility(8);
        return;
    L71:
        return;
    }

    public static /* synthetic */ void V90(CommonSlideDialogFragment r1, Integer r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        boolean r4 = true;
    L9:
        r1.U90(r2, r4);
        return;
    L8:
        r4 = false;
        goto L9
    }

    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        if (r6 != null) goto L43;
        LarusFragmentCommonSlideBinding r7 = LarusFragmentCommonSlideBinding.a(getLayoutInflater(), r5);
        this.d = r7;
        FrameLayout r0 = r7.d;
        ImageView r8 = r7.b;
        if (r8 == null) goto L19;
        e1.d(r8, new f19.c(this));
    L19:
        LarusFragmentCommonSlideBinding r9 = this.d;
        if (r9 == null) goto L24;
        ImageView r10 = r9.f;
        if (r10 == null) goto L24;
        e1.d(r10, new f19.d(this));
    L24:
        LarusFragmentCommonSlideBinding r11 = this.d;
        if (r11 == null) goto L29;
        ImageView r12 = r11.g;
        if (r12 == null) goto L29;
        e1.d(r12, new e(this));
    L29:
        ViewBinding r13 = ea0();
        if (r13 == null) goto L34;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        r1.gravity = 17;
        if (r0 == null) goto L34;
        r0.addView(r13.getRoot(), r1);
    L34:
        da0(r6);
        fa0();
        AlphaAnimation r14 = new AlphaAnimation(0.0f, 1.0f);
        r14.setDuration(300);
        LarusFragmentCommonSlideBinding r15 = this.d;
        if (r15 == null) goto L39;
        FrameLayout r16 = r15.a;
        if (r16 == null) goto L39;
        r16.startAnimation(r14);
    L39:
        LarusFragmentCommonSlideBinding r17 = this.d;
        if (r17 != null) goto L42;
        return null;
    L42:
        return r17.a;
    L43:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
    L12:
        LarusFragmentCommonSlideBinding r18 = this.d;
        if (r18 != null) goto L15;
        return null;
    L15:
        return r18.a;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: IllegalStateException -> L11
        Throwable r20 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L11
        if (r20 == null) goto L12;
        d.d(r20, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L11
    L11:
        FLogger.a.e("CommonSlideDialogFragment", "fallback by dismiss failed");
        goto L12
    }
}
