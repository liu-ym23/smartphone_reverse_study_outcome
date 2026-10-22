package com.larus.bmhome.view.actionbar.gaokao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.e1;
import ct8.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0010\u001a\u00020\u0007J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter$GaokaoPreferenceViewHolder;", "dataList", "", "", "maxSelectedNum", "", "selectCallback", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)V", "currentSelectedViewHolder", "selectedPosition", "Ljava/util/TreeSet;", "getMaxSelectedNum", "getSelectedList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setSelectedStatus", "isSelected", "", "getItemCount", "GaokaoPreferenceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoPreferenceAdapter extends RecyclerView.Adapter<GaokaoPreferenceViewHolder> {
    public final List<String> a;
    public final int b;
    public final Function1<List<String>, Unit> c;
    public GaokaoPreferenceViewHolder d;
    public final TreeSet<Integer> e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter$GaokaoPreferenceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "rootView", "getRootView", "()Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GaokaoPreferenceViewHolder extends RecyclerView.ViewHolder {
        public final Context a;
        public final View b;
        public final TextView c;

        public final Context getContext() {
            return this.a;
        }

        public GaokaoPreferenceViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.getContext();
            this.b = r2.findViewById(2131375835);
            this.c = (TextView) r2.findViewById(2131375863);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final List<String> y2() {
        ArrayList r0 = new ArrayList();
        Iterator<Integer> r1 = this.e.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        int r2 = r1.next().intValue();
        r0.add(ListProtector.get(this.a, r2));
        goto L4
    L6:
        return r0;
    }

    public static void z2(GaokaoPreferenceViewHolder r4, boolean r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 == false) goto L11;
        TextView r6 = r4.c;
        if (r6 == null) goto L8;
        r6.setTextColor(ContextCompat.getColor(r4.getContext(), c.b(2130972123, r4.getContext(), 2131103203)));
    L8:
        View r7 = r4.b;
        if (r7 == null) goto L18;
        r7.setBackgroundResource(c.b(2130970674, r7.getContext(), 2131239094));
        return;
    L18:
        return;
    L11:
        TextView r8 = r4.c;
        if (r8 == null) goto L14;
        r8.setTextColor(ContextCompat.getColor(r4.getContext(), c.b(2130972079, r4.getContext(), 2131103136)));
    L14:
        View r9 = r4.b;
        if (r9 == null) goto L20;
        r9.setBackgroundResource(c.b(2130970673, r9.getContext(), 2131239091));
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, final int r4) {
        final GaokaoPreferenceViewHolder r5 = (GaokaoPreferenceViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        String r0 = (String) ListProtector.get(this.a, r4);
        TextView r1 = r5.c;
        if (r1 == null) goto L5;
        r1.setText(r0);
    L5:
        z2(r5, this.e.contains(Integer.valueOf(r4)));
        View r2 = r5.b;
        if (r2 == null) goto L9;
        e1.d(r2, new a(r5, this, r4));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562573, r3, false);
        Intrinsics.checkNotNull(r5);
        return new GaokaoPreferenceViewHolder(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GaokaoPreferenceAdapter(List<String> r2, int r3, Function1<? super List<String>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "dataList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new TreeSet();
    }
}
