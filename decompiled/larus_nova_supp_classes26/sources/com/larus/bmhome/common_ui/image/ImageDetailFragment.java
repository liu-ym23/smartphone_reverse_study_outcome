package com.larus.bmhome.common_ui.image;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.bigimg.n1;
import com.larus.image.databinding.LarusImageDetailLayoutBinding;
import com.larus.utils.logger.FLogger;
import j19.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l19.f;
import uo8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011J\b\u0010F\u001a\u00020\u000eH\u0002J\b\u0010G\u001a\u00020\u000eH\u0016J\b\u0010H\u001a\u00020\u000eH\u0002J\b\u0010I\u001a\u00020\u000eH\u0002J\u0010\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\rH\u0002J\u0018\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\r2\u0006\u0010M\u001a\u00020;H\u0002J\u0012\u0010N\u001a\u00020\u000e2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J&\u0010Q\u001a\u0004\u0018\u00010.2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u000f\u0010V\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020\u000eH\u0016J\u000e\u0010Y\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020\rJ\u0018\u0010[\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\r2\u0006\u0010M\u001a\u00020;H\u0002J\b\u0010\\\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010B\u001a\u00020;2\u0006\u0010A\u001a\u00020;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006^"}, d2 = {"Lcom/larus/bmhome/common_ui/image/ImageDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "adapter", "Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "initUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "thumbUrls", "", "", "selectCallback", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/larus/bmhome/common_ui/image/ImageAdapter;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "()V", "getAdapter", "()Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "setAdapter", "(Lcom/larus/bmhome/common_ui/image/ImageAdapter;)V", "pager", "Landroidx/recyclerview/widget/RecyclerView;", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "setPager", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "setRootContainer", "(Landroid/widget/FrameLayout;)V", "onPageSelectedListener", "getOnPageSelectedListener", "()Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;)V", "onDismissListener", "Lcom/larus/common_ui/photoviewer/OnDismissListener;", "getOnDismissListener", "()Lcom/larus/common_ui/photoviewer/OnDismissListener;", "setOnDismissListener", "(Lcom/larus/common_ui/photoviewer/OnDismissListener;)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "binding", "Lcom/larus/image/databinding/LarusImageDetailLayoutBinding;", "currentPos", "getCurrentPos", "()I", "_currentPos", "depInitPos", "isAnimatedShow", "", "backgroundAlphaFactor", "", "backgroundAlphaFactorWhenDragEnd", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "value", "isInfinityLoop", "()Z", "setInfinityLoop", "(Z)V", "initRecyclerView", "onResume", "updateLayoutManager", "initAdapter", "dispatchOnPageUnSelected", "pos", "dispatchOnPageSelected", "byScroll", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getExtraViewLayout", "()Ljava/lang/Integer;", "dismissFragment", "show", "position", "setCurrentPos", "onDestroyView", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ImageDetailFragment extends Fragment implements g {
    public static final /* synthetic */ int o = 0;
    public final ImageAdapter d;
    public final List<n1> e;
    public final List<String> f;
    public final Function1<Integer, Unit> g;
    public RecyclerView h;
    public FrameLayout i;
    public g j;
    public View k;
    public LarusImageDetailLayoutBinding l;
    public int m;
    public OrientationHelper n;

    public static final class a {
    }

    public static final class b implements f {
        public final /* synthetic */ ImageDetailFragment a;

        public final void onTransitionChanged(int r1, float r2) {
        }

        public b(ImageDetailFragment r1) {
            this.a = r1;
        }

        public final void onTransitionBegin(int r2) {
            View r3 = this.a.k;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        public final void onTransitionEnd(int r2) {
            View r3 = this.a.k;
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }
    }

    static {
    }

    public final void S80(int r1) {
    }

    public void T90() {
    }

    public Integer U90() {
        return null;
    }

    public final void onPageSelected(int r1) {
    }

    public final void onPageSelected(int r1, boolean r2) {
    }

    public ImageDetailFragment() {
        this(new ImageAdapter(), null, null, new i());
        T90();     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("ImageDetailFragment", "fallback by dismiss failed");
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public static final /* synthetic */ void S90(ImageDetailFragment r1, int r2) {
        r1.V90(r2, true);
    }

    private final void V90(int r3, boolean r4) {
        int r0 = this.m;
        if (r0 == r3) goto L15;
        g r1 = this.j;
        if (r1 == null) goto L7;
        r1.S80(r0);
    L7:
        this.m = r3;
        g r2 = this.j;
        if (r2 == null) goto L10;
        r2.onPageSelected(r3);
    L10:
        g r5 = this.j;
        if (r5 == null) goto L13;
        r5.onPageSelected(r3, r4);
    L13:
        this.g.invoke(Integer.valueOf(r3));
        return;
    }

    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        LarusImageDetailLayoutBinding r6 = LarusImageDetailLayoutBinding.a(r3, r4);
        this.l = r6;
        this.i = r6.c;
        this.h = r6.b;
        new PagerSnapHelper().attachToRecyclerView(this.h);
        RecyclerView r7 = this.h;
        if (r7 == null) goto L5;
        r7.addOnScrollListener(new ImageDetailFragment$initRecyclerView$1(this));
    L5:
        ImageAdapter r8 = this.d;
        r8.b = this.e;
        r8.c = this.f;
        RecyclerView r9 = this.h;
        if (r9 == null) goto L8;
        r9.setAdapter(r8);
    L8:
        this.d.registerAdapterDataObserver(new ImageDetailFragment$initAdapter$1());
        RecyclerView r10 = this.h;
        if (r10 == null) goto L11;
        NonScrollableLinearLayoutManager r11 = new NonScrollableLinearLayoutManager(getContext());
        r11.setOrientation(0);
        r10.setLayoutManager(r11);
    L11:
        RecyclerView r12 = this.h;
        if (r12 == null) goto L14;
        RecyclerView.LayoutManager r13 = r12.getLayoutManager();
    L15:
        this.n = OrientationHelper.createVerticalHelper(r13);
        RecyclerView r14 = this.h;
        if (r14 == null) goto L18;
        r14.scrollToPosition(0);
    L18:
        V90(0, false);
        FrameLayout r15 = this.i;
        if (r15 == null) goto L23;
        Drawable r16 = r15.getBackground();
        if (r16 == null) goto L23;
        r16.setAlpha(255);
    L23:
        Integer r17 = U90();
        if (r17 == null) goto L28;
        View r18 = getLayoutInflater().inflate(r17.intValue(), this.i, false);
        this.k = r18;
        FrameLayout r19 = this.i;
        if (r19 == null) goto L28;
        r19.addView(r18, new FrameLayout.LayoutParams(-1, -1));
    L28:
        this.d.g = new b(this);
        LarusImageDetailLayoutBinding r20 = this.l;
        if (r20 != null) goto L31;
        return null;
    L31:
        return r20.a;
    L14:
        r13 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageDetailFragment(ImageAdapter r2, List<n1> r3, List<String> r4, Function1<? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r5, "selectCallback");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.m = -1;
    }
}
