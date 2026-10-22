package com.larus.canvas.feature.component.instruction.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.layout.holder.progressloading.RadiusCardView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import jy8.b;
import jy8.c;
import jy8.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/ui/CanvasOptionListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/canvas/feature/component/instruction/ui/CanvasOptionListItem;", "Lcom/larus/canvas/feature/component/instruction/ui/CanvasOptionListHolder;", "<init>", "()V", "listener", "Lkotlin/Function1;", "", "setOnItemClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasOptionListAdapter extends ListAdapter<d, CanvasOptionListHolder> {
    public static final CanvasOptionListAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public Function1<? super d, Unit> a;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.canvas.feature.component.instruction.ui.CanvasOptionListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new CanvasOptionListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public CanvasOptionListAdapter() {
        super(b);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        CanvasOptionListHolder r9 = (CanvasOptionListHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final d r10 = (d) getItem(r8);
        Intrinsics.checkNotNull(r10);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "data");
        r9.b.setText(r10.b);
        if (r10.d != null) goto L5;
        e1.o(r9.f);
    L17:
        if (r10.c != null) goto L22;
        e1.o(r9.a);
        boolean r0 = h.a;
        if (h.a(null) == false) goto L21;
        r9.b.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r9).itemView.getContext(), 2131103298));
    L26:
        e1.d(((RecyclerView.ViewHolder) r9).itemView, new jy8.a(this, r10));
        return;
    L21:
        r9.b.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r9).itemView.getContext(), 2131103292));
        goto L26
    L22:
        r9.b.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r9).itemView.getContext(), 2131103298));
        e1.x(r9.c);
        r9.c.setBackground(ContextCompat.getDrawable(((RecyclerView.ViewHolder) r9).itemView.getContext(), 2131239373));
        ImageLoaderKt.y(r9.a, r10.c.getUrl(), "canvas_instruction_option_cover", new c(), 4);
        if (r10.e == false) goto L25;
        e1.x(r9.d);
        e1.x(r9.e);
        goto L26
    L25:
        e1.o(r9.d);
        e1.o(r9.e);
        goto L26
    L5:
        e1.x(r9.f);
        ImageLoaderKt.y(r9.h, r10.d.getUrl(), "canvas_instruction_option_icon", new b(), 4);
        if (r10.f == false) goto L15;
        e1.o(r9.h);
        e1.x(r9.g);
        boolean r1 = h.a;
        if (h.a(null) == false) goto L13;
        if (Intrinsics.areEqual(r9.g.getIndeterminateDrawable(), r9.i) == true) goto L17;
        r9.g.setIndeterminateDrawable(r9.i);
        goto L17
    L13:
        if (Intrinsics.areEqual(r9.g.getIndeterminateDrawable(), r9.j) == true) goto L17;
        r9.g.setIndeterminateDrawable(r9.j);
        goto L17
    L15:
        e1.x(r9.h);
        e1.o(r9.g);
        goto L17
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        RadiusCardView r5 = LayoutInflater.from(r3.getContext()).inflate(2131562461, r3, false);
        int r6 = 2131374975;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131374975)) == null) goto L21;
        r6 = 2131375035;
        if (ViewBindings.findChildViewById(r5, 2131375035) == null) goto L21;
        r6 = 2131375036;
        if (ViewBindings.findChildViewById(r5, 2131375036) == null) goto L21;
        r6 = 2131381593;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131381593)) == null) goto L21;
        r6 = 2131381595;
        if (((ProgressBar) ViewBindings.findChildViewById(r5, 2131381595)) == null) goto L21;
        r6 = 2131381598;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131381598)) == null) goto L21;
        r6 = 2131381599;
        if (((ProgressBar) ViewBindings.findChildViewById(r5, 2131381599)) == null) goto L21;
        r6 = 2131391040;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131391040)) == null) goto L21;
        return new CanvasOptionListHolder(r5);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
