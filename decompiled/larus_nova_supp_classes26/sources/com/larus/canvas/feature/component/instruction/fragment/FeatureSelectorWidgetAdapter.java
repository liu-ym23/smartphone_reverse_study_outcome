package com.larus.canvas.feature.component.instruction.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.view.FlowLayout;
import com.larus.utils.e1;
import com.larus.utils.o0;
import iy8.b;
import iy8.c;
import iy8.i;
import iy8.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorWidgetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorOptionPanelItem;", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorHolder;", "initInputText", "", "callback", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureItemSelectorCallback;", "<init>", "(Ljava/lang/String;Lcom/larus/canvas/feature/component/instruction/fragment/FeatureItemSelectorCallback;)V", "getInitInputText", "()Ljava/lang/String;", "getCallback", "()Lcom/larus/canvas/feature/component/instruction/fragment/FeatureItemSelectorCallback;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorWidgetAdapter extends ListAdapter<j, FeatureSelectorHolder> {
    public static final FeatureSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1 c = null;
    public final String a;
    public final iy8.a b;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.canvas.feature.component.instruction.fragment.FeatureSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        c = new FeatureSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1();
    }

    public FeatureSelectorWidgetAdapter(String r2, iy8.a r3) {
        super(c);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r15) {
        FeatureSelectorHolder r16 = (FeatureSelectorHolder) r14;
        Intrinsics.checkNotNullParameter(r16, "holder");
        j r17 = (j) getItem(r15);
        Intrinsics.checkNotNull(r17);
        String r0 = this.a;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "data");
        r16.d.setLineSpacing(i5.r0());
        r16.d.setItemSpacing(i5.r0());
        r16.c.setText(r17.b);
        List<i> r2 = r17.c;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((true ^ StringsKt.isBlank(((i) r5).b)) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L30;
        final i r7 = (i) r6.next();
        FlowLayout r8 = r16.d;
        final c r9 = new c(r16.a.getContext());
        final Long r10 = r17.a;
        final iy8.a r11 = r16.b;
        Intrinsics.checkNotNullParameter(r7, "data");
        if (o0.d(r7.b) == true) goto L14;
    L26:
        TextView r12 = r9.a;
        if (r12 == null) goto L29;
        r12.setText(r7.b);
    L29:
        e1.d(r9, new b(r9, r11, r10, r7));
        r8.addView(r9);
        goto L10
    L14:
        if (r0 != null) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r13 == false) goto L23;
        r9.setSelected(true);
        TextView r18 = r9.a;
        if (r18 == null) goto L26;
        r18.setTextColor(r9.b);
        goto L26
    L23:
        r9.setSelected(false);
        TextView r19 = r9.a;
        if (r19 == null) goto L26;
        r19.setTextColor(r9.c);
        goto L26
    L16:
        if (StringsKt.contains$default(r0, r7.b, false, 2, null) != true) goto L18;
        r13 = true;
        goto L19
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562479, r3, false);
        int r6 = 2131388092;
        if (((FlowLayout) ViewBindings.findChildViewById(r5, 2131388092)) == null) goto L9;
        r6 = 2131390607;
        if (ViewBindings.findChildViewById(r5, 2131390607) == null) goto L9;
        return new FeatureSelectorHolder(r5, this.b);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
