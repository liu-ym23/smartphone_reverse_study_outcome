package com.larus.bmhome.chat.standarduikit.generictool.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusGenericToolViewBinding;
import com.larus.utils.o0;
import jl8.c;
import jl8.f;
import jl8.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 &2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001&B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0017\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u001a\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\u0019H\u0002J\u0006\u0010%\u001a\u00020\u0013R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolViewInput;", "Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "output", "binding", "Lcom/larus/mainbot/impl/databinding/LarusGenericToolViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusGenericToolViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "currentTitle", "", "setupBackground", "res", "", "(Ljava/lang/Integer;)V", "updatePadding", "setupIcon", "setupTitle", "setupShimmerAnimation", "setupExposure", "setupClick", "setupArrow", "getCardId", "messageId", "cardPosition", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenericToolView extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GenericToolViewStage.values().length];
            r0[GenericToolViewStage.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GenericToolViewStage.FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    private final LarusGenericToolViewBinding getBinding() {
        return (LarusGenericToolViewBinding) this.a.getValue();
    }

    public final void b() {
        getBinding().e.x();
    }

    public GenericToolView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setupArrow(f r3) {
        View r0 = getBinding().b;
        if (r3.i == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        if (r3.i == false) goto L14;
        View r2 = getBinding().b;
        if (r3.j == false) goto L11;
        int r4 = 2131242201;
    L12:
        r2.setBackgroundResource(r4);
        return;
    L11:
        r4 = 2131242202;
        goto L12
    L14:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private final void setupBackground(Integer r2) {
        if (r2 == null) goto L5;
        r2.intValue();
        getBinding().c.setBackgroundResource(r2.intValue());
        return;
    }

    private final void setupClick(final g r5) {
        View r0 = getBinding().a;
        if (r5.b == null) goto L5;
        View.OnClickListener r1 = new jl8.a(r5);
    L6:
        r0.setOnClickListener(r1);
        View r2 = getBinding().a;
        boolean r3 = true;
        if (r5.b == null) goto L9;
        boolean r4 = true;
    L10:
        r2.setClickable(r4);
        View r6 = getBinding().a;
        if (r5.b != null) goto L14;
        r3 = false;
    L14:
        r6.setFocusable(r3);
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final void setupIcon(f r8) {
        boolean r0 = h.a;
        RoundingParams r1 = null;
        if (h.a(null) == false) goto L5;
        String r2 = r8.b;
    L6:
        LinearLayout r3 = getBinding().c;
        r3.setPaddingRelative(r8.m, r3.getPaddingTop(), r3.getPaddingEnd(), r3.getPaddingBottom());
        SimpleDraweeView r4 = getBinding().d;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L16;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        int r7 = r8.l;
        r6.width = r7;
        r6.height = r7;
        r6.setMarginEnd(r8.n);
        r4.setLayoutParams(r6);
        GenericDraweeHierarchy r9 = getBinding().d.getHierarchy();
        if (r8.k == false) goto L11;
        r1 = RoundingParams.asCircle();
    L11:
        r9.setRoundingParams(r1);
        if (o0.d(r2) == false) goto L17;
        ImageLoaderKt.u(getBinding().d, r2, "GenericToolView");
        return;
    L17:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L5:
        r2 = r8.a;
        goto L6
    }

    private final void setupShimmerAnimation(f r2) {
        GenericToolViewStage r3 = r2.d;
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        ShimmerTextView r5 = getBinding().e;
        int r0 = ShimmerTextView.h;
        r5.z(false);
        return;
    L5:
        if (r4 != 2) goto L8;
        getBinding().e.x();
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final void setupTitle(f r8) {
        ShimmerTextView r0 = getBinding().e;
        r0.setText(r8.c);
        Intrinsics.checkNotNull(r0);
        we8.a.b(r0, i5.t(), false, null, null, 12);
        r0.setTypeface(Typeface.DEFAULT, 0);
    }

    public GenericToolView(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(new jl8.b(r2, this));
    }

    public final void a(final f r5, final g r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        setupIcon(r5);
        setupTitle(r5);
        setupShimmerAnimation(r5);
        Pair<Integer, Integer> r0 = r5.e;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = ((Number) r0.getFirst()).intValue();
    L6:
        Pair<Integer, Integer> r3 = r5.e;
        if (r3 == null) goto L9;
        r1 = ((Number) r3.getSecond()).intValue();
    L9:
        setPaddingRelative(getPaddingStart(), r2, getPaddingEnd(), r1);
        ExposeXTrackerExtKt.b(this, new c(this, r5, r6));
        setupBackground(r5.h);
        setupClick(r6);
        setupArrow(r5);
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
