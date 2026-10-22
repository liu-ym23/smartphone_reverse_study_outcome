package com.larus.canvas.feature.component.instruction.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.canvas.service.bean.Icon;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.o0;
import j19.c;
import jy8.e;
import jy8.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\n2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/ui/DropdownBoxSelectAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/canvas/feature/component/instruction/ui/DropDownBoxSelectItem;", "Lcom/larus/canvas/feature/component/instruction/ui/DropDownBoxSelectHolder;", "<init>", "()V", "maxWidth", "", "listener", "Lkotlin/Function2;", "", "setOnItemClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getMaxWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownBoxSelectAdapter extends ListAdapter<e, DropDownBoxSelectHolder> {
    public static final DropdownBoxSelectAdapter$Companion$DIFF_CALLBACK$1 c = null;
    public int a;
    public Function2<? super Integer, ? super e, Unit> b;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.canvas.feature.component.instruction.ui.DropdownBoxSelectAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        c = new DropdownBoxSelectAdapter$Companion$DIFF_CALLBACK$1();
    }

    public DropdownBoxSelectAdapter() {
        super(c);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r19, final int r20) {
        DropDownBoxSelectHolder r2 = (DropDownBoxSelectHolder) r19;
        Intrinsics.checkNotNullParameter(r2, "holder");
        r2.setIsRecyclable(false);
        final e r4 = (e) getItem(r20);
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.d == false) goto L5;
        e1.x(r2.a);
    L6:
        r2.c.setText(r4.b);
        Icon r5 = r4.e;
        if (r5 == null) goto L39;
        Long r6 = r5.getWidth();
        float r7 = 0.0f;
        if (r6 == null) goto L35;
        boolean r11 = true;
        if (r6.longValue() <= 0) goto L13;
        boolean r9 = true;
    L14:
        Long r10 = null;
        if (r9 == true) goto L18;
        r6 = null;
    L18:
        if (r6 == null) goto L35;
        long r14 = r6.longValue();
        Long r8 = r5.getHeight();
        if (r8 != null) goto L22;
    L33:
        e1.o(r2.d);
        SimpleDraweeView r12 = Unit.INSTANCE;
    L34:
        if (r12 == null) goto L35;
    L41:
        if (o0.d(r4.c) == false) goto L43;
        e1.x(r2.e);
        r2.e.setText(r4.c);
    L45:
        if (r4.f == false) goto L47;
        e1.x(r2.b);
    L48:
        e1.d(((RecyclerView.ViewHolder) r2).itemView, new f(this, r20, r4));
        ((RecyclerView.ViewHolder) r2).itemView.measure(0, 0);
        int r1 = ((RecyclerView.ViewHolder) r2).itemView.getMeasuredWidth();
        if (r1 <= this.a) goto L52;
        this.a = r1;
        return;
    L52:
        return;
    L47:
        e1.o(r2.b);
        goto L48
    L43:
        e1.o(r2.e);
        goto L45
    L22:
        if (r8.longValue() > 0) goto L25;
        r11 = false;
    L25:
        if (r11 == false) goto L27;
        r10 = r8;
    L27:
        if (r10 == null) goto L33;
        long r13 = r10.longValue();
        ViewGroup.LayoutParams r15 = r2.d.getLayoutParams();
        r15.width = c.c(Long.valueOf(r14));
        r15.height = c.c(Long.valueOf(r13));
        r12 = r2.d;
        r12.requestLayout();
        ImageLoaderKt.u(r12, r5.getUrl(), "template_item_photo");
        Long r16 = r5.getRadius();
        GenericDraweeHierarchy r17 = r12.getHierarchy();
        if (r16 == null) goto L31;
        float r18 = c7.c(r16);
    L32:
        r17.setRoundingParams(RoundingParams.fromCornersRadius(r18));
        e1.x(r12);
        goto L34
    L31:
        r18 = 0.0f;
        goto L32
    L13:
        r9 = false;
    L35:
        SimpleDraweeView r21 = r2.d;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        r22.width = c.c(20);
        r22.height = c.c(20);
        Long r23 = r5.getRadius();
        GenericDraweeHierarchy r110 = r21.getHierarchy();
        if (r23 == null) goto L38;
        r7 = c7.c(r23);
    L38:
        r110.setRoundingParams(RoundingParams.fromCornersRadius(r7));
        ImageLoaderKt.u(r21, r5.getUrl(), "template_item_photo");
        e1.x(r21);
        goto L41
    L39:
        e1.o(r2.d);
        Unit r24 = Unit.INSTANCE;
        goto L41
    L5:
        e1.o(r2.a);
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562477, r3, false);
        int r6 = 2131374690;
        if (ViewBindings.findChildViewById(r5, 2131374690) == null) goto L19;
        r6 = 2131374691;
        if (ViewBindings.findChildViewById(r5, 2131374691) == null) goto L19;
        r6 = 2131374697;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131374697)) == null) goto L19;
        r6 = 2131375736;
        if (ViewBindings.findChildViewById(r5, 2131375736) == null) goto L19;
        r6 = 2131378904;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131378904)) == null) goto L19;
        r6 = 2131390825;
        if (ViewBindings.findChildViewById(r5, 2131390825) == null) goto L19;
        r6 = 2131390830;
        if (ViewBindings.findChildViewById(r5, 2131390830) == null) goto L19;
        return new DropDownBoxSelectHolder(r5);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
