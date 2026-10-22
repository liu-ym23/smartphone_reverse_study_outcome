package com.larus.common_ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.common_res.common_ui.databinding.LarusFragmentCommonSlideBinding;
import com.larus.common_ui.view.CommonSlideRootContainer;
import com.larus.profile.impl.creation.CreationGroupFragment;
import com.larus.utils.e1;
import com.larus.utils.i0;
import f19.g;
import f19.h;
import f19.i;
import f19.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001d\b&\u0018\u0000 >*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002=>B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0011\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\r\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\tH\u0016J\u0017\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010$J\u0017\u0010%\u001a\u00020\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010$J\b\u0010&\u001a\u00020\u0010H\u0016J\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010+\u001a\u00020\u0014J\u0006\u0010,\u001a\u00020\u0014J\u0006\u0010-\u001a\u00020\u0014J\b\u0010.\u001a\u0004\u0018\u00010/J\b\u00100\u001a\u00020\u0014H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u0002022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u00109\u001a\u00020\u0014H\u0002J\u0006\u0010:\u001a\u00020\u0014J\b\u0010;\u001a\u00020\u0014H\u0016J\b\u0010<\u001a\u00020\u0014H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/common_ui/fragment/CommonSlideFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "rootBinding", "Lcom/larus/common_res/common_ui/databinding/LarusFragmentCommonSlideBinding;", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "previousPos", "needDispatcherScrollEvent", "", "initViewBinding", "()Landroidx/viewbinding/ViewBinding;", "initView", "", "savedInstanceState", "Landroid/os/Bundle;", "initViewModel", "getInitItemPosition", "dispatchContainerEvent", "event", "Lcom/larus/common_ui/fragment/CommonSlideFragment$ContainerEvent;", "onPageChangeCallback", "com/larus/common_ui/fragment/CommonSlideFragment$onPageChangeCallback$1", "()Lcom/larus/common_ui/fragment/CommonSlideFragment$onPageChangeCallback$1;", "getPagerAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "getDirection", "dismissFragment", "orientation", "(Ljava/lang/Integer;)V", "dismissFragmentWithNoAni", "needCommonSlide", "isMoreVisible", "showMoreWithAnimator", "showMore", "dismissMore", "dismissBack", "dismissShare", "dismissMoreWithAnimator", "getViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "onResume", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setInitItem", "resetPosition", "onDestroy", "onDestroyView", "ContainerEvent", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CommonSlideFragment<VB extends ViewBinding> extends Fragment {
    public static final /* synthetic */ int h = 0;
    public LarusFragmentCommonSlideBinding d;
    public int e;
    public int f;
    public boolean g;

    public static final class a {
    }

    public interface b {

        public static final class a implements b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.common_ui.fragment.CommonSlideFragment$b$b, reason: collision with other inner class name */
        public static final class C0012b implements b {
            public C0012b() {
            }
        }

        public static final class c implements b {
            public final int a;
            public final int b;

            public c(int r1, int r2) {
                this.a = r1;
                this.b = r2;
            }
        }
    }

    static {
    }

    public void T90(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public int U90() {
        return 1;
    }

    public int V90() {
        return 0;
    }

    public FragmentStateAdapter W90() {
        return null;
    }

    public abstract VB Y90();

    public CommonSlideFragment() {
        this.e = -1;
        this.f = -1;
        this.g = true;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        LarusFragmentCommonSlideBinding r0 = this.d;
        if (r0 == null) goto L8;
        ViewPager2 r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setAdapter(null);
        return;
    L9:
        return;
    }

    public final void onResume() {
        super.onResume();
    }

    public static void S90(CommonSlideFragment r2) {
        CommonSlideDialogFragment r3 = r2.getParentFragment();
        if ((r3 instanceof CommonSlideDialogFragment) == false) goto L5;
        CommonSlideDialogFragment r4 = r3;
    L6:
        if (r4 == null) goto L9;
        CommonSlideDialogFragment.V90(r4, null, 2);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void X90(Bundle r2) {
        if ((this instanceof CreationGroupFragment) == false) goto L20;
        LarusFragmentCommonSlideBinding r3 = this.d;
        if (r3 == null) goto L9;
        ViewPager2 r4 = r3.c;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
    L9:
        LarusFragmentCommonSlideBinding r5 = this.d;
        if (r5 == null) goto L14;
        ViewPager2 r6 = r5.c;
        if (r6 == null) goto L14;
        r6.setAdapter(W90());
        r6.setOffscreenPageLimit(1);
        r6.setOrientation(U90());
        r6.registerOnPageChangeCallback(new CommonSlideFragment$onPageChangeCallback$1(this));
    L14:
        LarusFragmentCommonSlideBinding r7 = this.d;
        if (r7 == null) goto L21;
        CommonSlideRootContainer r8 = r7.e;
        if (r8 == null) goto L22;
        r8.setDismissCallback(new j(this));
        return;
    L22:
        return;
    L21:
        return;
    }

    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        LarusFragmentCommonSlideBinding r5 = this.d;
        if (r5 == null) goto L11;
        ImageView r6 = r5.b;
        if (r6 == null) goto L11;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L10;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        i0.a.getClass();
        r1.topMargin = i0.g();
        r6.setLayoutParams(r1);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        LarusFragmentCommonSlideBinding r7 = this.d;
        if (r7 == null) goto L21;
        ImageView r8 = r7.f;
        if (r8 == null) goto L21;
        ViewGroup.LayoutParams r2 = r8.getLayoutParams();
        if (r2 == null) goto L19;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r2;
        i0.a.getClass();
        r9.topMargin = i0.g();
        r8.setLayoutParams(r9);
        goto L21
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L21:
        if ((this instanceof CreationGroupFragment) == false) goto L27;
        LarusFragmentCommonSlideBinding r10 = this.d;
        if (r10 == null) goto L33;
        final ViewPager2 r11 = r10.c;
        if (r11 == null) goto L34;
        r11.setVisibility(8);
        r11.post(new g(r11, this));
        return;
    L34:
        return;
    L33:
        return;
    L27:
        LarusFragmentCommonSlideBinding r12 = this.d;
        if (r12 == null) goto L36;
        ViewPager2 r13 = r12.c;
        if (r13 == null) goto L37;
        r13.setVisibility(8);
        return;
    L37:
        return;
    }

    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        if (r6 == null) goto L8;
        S90(this);
        LarusFragmentCommonSlideBinding r7 = this.d;
        if (r7 != null) goto L7;
        return null;
    L7:
        return r7.a;
    L8:
        LarusFragmentCommonSlideBinding r8 = LarusFragmentCommonSlideBinding.a(getLayoutInflater(), r5);
        this.d = r8;
        FrameLayout r0 = r8.d;
        ImageView r9 = r8.b;
        if (r9 == null) goto L11;
        e1.d(r9, new h(this));
    L11:
        LarusFragmentCommonSlideBinding r10 = this.d;
        if (r10 == null) goto L16;
        ImageView r11 = r10.f;
        if (r11 == null) goto L16;
        e1.d(r11, new i(this));
    L16:
        ViewBinding r12 = Y90();
        if (r12 == null) goto L21;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        r1.gravity = 17;
        if (r0 == null) goto L21;
        r0.addView(r12.getRoot(), r1);
    L21:
        X90(r6);
        LarusFragmentCommonSlideBinding r13 = this.d;
        if (r13 != null) goto L24;
        return null;
    L24:
        return r13.a;
    }
}
