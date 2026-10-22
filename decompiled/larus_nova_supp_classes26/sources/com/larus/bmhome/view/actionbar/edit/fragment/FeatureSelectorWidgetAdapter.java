package com.larus.bmhome.view.actionbar.edit.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import at8.b;
import com.larus.bmhome.actionbar.model.t;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.chat.view.FlowLayout;
import com.larus.bmhome.view.actionbar.edit.component.m1;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u001d\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/fragment/FeatureSelectorWidgetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionFeatureOptionPanel;", "Lcom/larus/bmhome/view/actionbar/edit/fragment/FeatureSelectorHolder;", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;", "initInputText", "", "<init>", "(Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;Ljava/lang/String;)V", "getCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/FeatureItemSelectorCallback;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorWidgetAdapter extends ListAdapter<t, FeatureSelectorHolder> {
    public static final FeatureSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1 c = null;
    public final m1 a;
    public final String b;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.edit.fragment.FeatureSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        c = new FeatureSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1();
    }

    public FeatureSelectorWidgetAdapter(m1 r2, String r3) {
        super(c);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r15) {
        FeatureSelectorHolder r16 = (FeatureSelectorHolder) r14;
        Intrinsics.checkNotNullParameter(r16, "holder");
        t r17 = (t) getItem(r15);
        Intrinsics.checkNotNull(r17);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "data");
        r16.d.setLineSpacing(i5.r0());
        r16.d.setItemSpacing(i5.r0());
        r16.c.setText(r17.b);
        List r1 = r17.c;
        if (r1 == null) goto L38;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L5:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L14;
        Object r5 = r3.next();
        String r6 = ((w) r5).b;
        if (r6 != null) goto L10;
    L12:
        if (r4 == false) goto L5;
        r2.add(r5);
        goto L5
    L10:
        if ((!StringsKt.isBlank(r6)) != true) goto L12;
        r4 = true;
        goto L12
    L14:
        Iterator r7 = r2.iterator();
    L16:
        if (r7.hasNext() == false) goto L47;
        final w r8 = (w) r7.next();
        FlowLayout r9 = r16.d;
        final b r10 = new b(((RecyclerView.ViewHolder) r16).itemView.getContext());
        final Integer r11 = r17.a;
        final m1 r12 = r16.a;
        String r13 = r16.b;
        Intrinsics.checkNotNullParameter(r8, "data");
        if (o0.d(r8.b) == false) goto L34;
        if (r13 == null) goto L26;
        String r18 = r8.b;
        if (r18 != null) goto L24;
        r18 = "";
    L24:
        if (StringsKt.contains$default(r13, r18, false, 2, null) != true) goto L26;
        boolean r19 = true;
    L27:
        if (r19 == false) goto L31;
        r10.setSelected(true);
        TextView r20 = r10.a;
        if (r20 == null) goto L34;
        r20.setTextColor(r10.b);
        goto L34
    L31:
        r10.setSelected(false);
        TextView r21 = r10.a;
        if (r21 == null) goto L34;
        r21.setTextColor(r10.c);
    L26:
        r19 = false;
    L34:
        TextView r22 = r10.a;
        if (r22 == null) goto L37;
        r22.setText(r8.b);
    L37:
        e1.d(r10, new at8.a(r10, r12, r11, r8));
        r9.addView(r10);
        goto L16
    L47:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562464, r3, false);
        int r6 = 2131388092;
        if (((FlowLayout) ViewBindings.findChildViewById(r5, 2131388092)) == null) goto L9;
        r6 = 2131390607;
        if (ViewBindings.findChildViewById(r5, 2131390607) == null) goto L9;
        return new FeatureSelectorHolder(r5, this.a, this.b);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
