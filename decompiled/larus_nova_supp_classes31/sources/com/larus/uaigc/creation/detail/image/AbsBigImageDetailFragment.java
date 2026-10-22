package com.larus.uaigc.creation.detail.image;

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
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.bmhome.common_ui.image.NonScrollableLinearLayoutManager;
import com.larus.image.databinding.LarusImageDetailLayoutBinding;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0007¢\u0006\u0004\b\u0003\u0010\u0004JJ\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0016J\b\u0010=\u001a\u00020\u0013H\u0002J\b\u0010>\u001a\u00020\u0013H\u0016J\b\u0010?\u001a\u00020\u0013H\u0002J\b\u0010@\u001a\u00020\u0013H\u0002J\u0010\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u0012H\u0002J\u0018\u0010C\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u00122\u0006\u0010D\u001a\u000204H\u0002J\u0012\u0010E\u001a\u00020\u00132\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J&\u0010H\u001a\u0004\u0018\u00010'2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u000f\u0010M\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\u0013H\u0016J\u000e\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0012J\u0018\u0010R\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u00122\u0006\u0010D\u001a\u000204H\u0002J\b\u0010S\u001a\u00020\u0013H\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00109\u001a\u0002042\u0006\u0010\u0005\u001a\u000204@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006U"}, d2 = {"Lcom/larus/uaigc/creation/detail/image/AbsBigImageDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "<init>", "()V", "value", "Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "adapter", "getAdapter", "()Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "initUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "thumbUrls", "", "", "selectCallback", "Lkotlin/Function1;", "", "", "initialize", "pager", "Landroidx/recyclerview/widget/RecyclerView;", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "setPager", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "setRootContainer", "(Landroid/widget/FrameLayout;)V", "onPageSelectedListener", "getOnPageSelectedListener", "()Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "binding", "Lcom/larus/image/databinding/LarusImageDetailLayoutBinding;", "currentPos", "getCurrentPos", "()I", "_currentPos", "depInitPos", "isAnimatedShow", "", "backgroundAlphaFactor", "", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "isInfinityLoop", "()Z", "setInfinityLoop", "(Z)V", "initRecyclerView", "onResume", "updateLayoutManager", "initAdapter", "dispatchOnPageUnSelected", "pos", "dispatchOnPageSelected", "byScroll", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getExtraViewLayout", "()Ljava/lang/Integer;", "dismissFragment", "show", "position", "setCurrentPos", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class AbsBigImageDetailFragment extends Fragment implements j19.g {
    public static final /* synthetic */ int n = 0;
    public ImageAdapter d;
    public List<n1> e;
    public List<String> f;
    public Function1<? super Integer, Unit> g;
    public RecyclerView h;
    public FrameLayout i;
    public View j;
    public LarusImageDetailLayoutBinding k;
    public int l;
    public OrientationHelper m;

    public static final class a {
    }

    static {
    }

    public final void S80(int r1) {
    }

    public Integer T90() {
        return null;
    }

    public final void onPageSelected(int r1) {
    }

    public final void onPageSelected(int r1, boolean r2) {
    }

    public AbsBigImageDetailFragment() {
        this.l = -1;
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

    public static final void S90(AbsBigImageDetailFragment r1, int r2) {
        if (r1.l == r2) goto L8;
        r1.l = r2;
        Function1<? super Integer, Unit> r3 = r1.g;
        if (r3 == null) goto L9;
        r3.invoke(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        LarusImageDetailLayoutBinding r6 = LarusImageDetailLayoutBinding.a(r3, r4);
        this.k = r6;
        this.i = r6.c;
        this.h = r6.b;
        new PagerSnapHelper().attachToRecyclerView(this.h);
        RecyclerView r7 = this.h;
        if (r7 == null) goto L5;
        r7.addOnScrollListener(new AbsBigImageDetailFragment$initRecyclerView$1(this));
    L5:
        ImageAdapter r8 = this.d;
        if (r8 == null) goto L8;
        r8.b = this.e;
    L8:
        if (r8 == null) goto L10;
        r8.c = this.f;
    L10:
        RecyclerView r9 = this.h;
        if (r9 == null) goto L13;
        r9.setAdapter(r8);
    L13:
        ImageAdapter r10 = this.d;
        if (r10 == null) goto L16;
        r10.registerAdapterDataObserver(new AbsBigImageDetailFragment$initAdapter$1());
    L16:
        ImageAdapter r11 = this.d;
        if (r11 == null) goto L19;
        r11.g = new b(this);
    L19:
        RecyclerView r12 = this.h;
        if (r12 == null) goto L22;
        NonScrollableLinearLayoutManager r13 = new NonScrollableLinearLayoutManager(getContext());
        r13.setOrientation(0);
        r12.setLayoutManager(r13);
    L22:
        RecyclerView r14 = this.h;
        if (r14 == null) goto L25;
        RecyclerView.LayoutManager r15 = r14.getLayoutManager();
    L26:
        this.m = OrientationHelper.createVerticalHelper(r15);
        RecyclerView r16 = this.h;
        if (r16 == null) goto L30;
        r16.scrollToPosition(0);
    L30:
        if (this.l == 0) goto L34;
        this.l = 0;
        Function1<? super Integer, Unit> r17 = this.g;
        if (r17 == null) goto L34;
        r17.invoke(0);
    L34:
        FrameLayout r18 = this.i;
        if (r18 == null) goto L39;
        Drawable r19 = r18.getBackground();
        if (r19 == null) goto L39;
        r19.setAlpha(255);
    L39:
        Integer r20 = T90();
        if (r20 == null) goto L44;
        View r21 = getLayoutInflater().inflate(r20.intValue(), this.i, false);
        this.j = r21;
        FrameLayout r22 = this.i;
        if (r22 == null) goto L44;
        r22.addView(r21, new FrameLayout.LayoutParams(-1, -1));
    L44:
        LarusImageDetailLayoutBinding r23 = this.k;
        if (r23 != null) goto L47;
        return null;
    L47:
        return r23.a;
    L25:
        r15 = null;
        goto L26
    }
}
