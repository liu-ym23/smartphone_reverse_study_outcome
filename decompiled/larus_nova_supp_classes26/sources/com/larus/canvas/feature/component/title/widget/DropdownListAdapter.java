package com.larus.canvas.feature.component.title.widget;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.canvas.feature.component.title.b;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ly8.g;
import ly8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/larus/canvas/feature/component/title/widget/DropdownListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/canvas/feature/component/title/widget/DropdownItemData;", "Lcom/larus/canvas/feature/component/title/widget/DropdownItemHolder;", "onItemSelected", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "maxWidth", "", "getMaxWidth", "()I", "setMaxWidth", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownListAdapter extends ListAdapter<g, DropdownItemHolder> {
    public static final DropdownListAdapter$Companion$DIFF_CALLBACK$1 c = null;
    public final Function1<String, Unit> a;
    public int b;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.canvas.feature.component.title.widget.DropdownListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        c = new DropdownListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public DropdownListAdapter(b r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemSelected");
        super(c);
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        DropdownItemHolder r6 = (DropdownItemHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        final g r7 = (g) getItem(r5);
        Intrinsics.checkNotNull(r7);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "data");
        r7.b.loadImage(r6.b);
        ImageViewCompat.setImageTintList(r6.b, ColorStateList.valueOf(r7.d));
        r6.c.setTextColor(r7.d);
        r6.c.setText(r7.c.toString(((RecyclerView.ViewHolder) r6).itemView.getContext()));
        RecyclerView r0 = ((RecyclerView.ViewHolder) r6).itemView.getParent();
        RecyclerView.Adapter r2 = null;
        if ((r0 instanceof RecyclerView) == false) goto L5;
        RecyclerView r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getAdapter();
    L8:
        int r3 = r6.getAdapterPosition();
        if (r2 == null) goto L11;
        Object r8 = Integer.valueOf(r2.getItemCount() - 1);
    L13:
        if ((r8 instanceof Integer) == true) goto L16;
    L18:
        e1.x(r6.a);
    L19:
        e1.d(((RecyclerView.ViewHolder) r6).itemView, new h(this, r7));
        ((RecyclerView.ViewHolder) r6).itemView.measure(0, 0);
        int r9 = ((RecyclerView.ViewHolder) r6).itemView.getMeasuredWidth();
        if (r9 <= this.b) goto L23;
        this.b = r9;
        return;
    L23:
        return;
    L16:
        if (r3 != ((Number) r8).intValue()) goto L18;
        e1.o(r6.a);
        goto L19
    L11:
        r8 = Boolean.FALSE;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131561858, r3, false);
        int r6 = 2131368819;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131368819)) == null) goto L11;
        r6 = 2131374718;
        if (((ImageView) ViewBindings.findChildViewById(r5, 2131374718)) == null) goto L11;
        r6 = 2131375736;
        if (ViewBindings.findChildViewById(r5, 2131375736) == null) goto L11;
        return new DropdownItemHolder(r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
