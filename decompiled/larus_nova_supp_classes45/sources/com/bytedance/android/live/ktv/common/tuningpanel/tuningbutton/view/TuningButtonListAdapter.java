package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListViewHolder;", "Lbc0/c;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningButtonListAdapter extends RecyclerView.Adapter<TuningButtonListViewHolder> implements bc0.c {
    public final List<ac0.a> a;
    public final bc0.a b;
    public final boolean c;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((ac0.a) r1).getType().getValue() - ((ac0.a) r2).getType().getValue();
        }
    }

    public static final class b<T> implements Comparator {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((ac0.a) r1).getType().getValue() - ((ac0.a) r2).getType().getValue();
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    @Override // bc0.c
    public final void j0(ac0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "tuningButtonData");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((ac0.a) r1).getType() != r5.getType()) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        if (((ac0.a) r1) != null) goto L21;
        ((ArrayList) this.a).add(r5);
        CollectionsKt.sortWith(this.a, a.a);
        notifyDataSetChanged();
        return;
    L21:
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final void y2(List<ac0.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "buttonList");
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r2);
        CollectionsKt.sortWith(this.a, b.a);
        notifyDataSetChanged();
    }

    public TuningButtonListAdapter(bc0.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "tuningButtonCallback");
        this.b = r2;
        this.c = r3;
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        TuningButtonListViewHolder r7 = (TuningButtonListViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        ac0.a r0 = (ac0.a) ListProtector.get(this.a, r6);
        r7.a = r0;
        TextView r1 = (TextView) r7.b.getValue();
        if (r1 == null) goto L8;
        if (r0 == null) goto L6;
        String r2 = r0.b;
    L7:
        r1.setText(r2);
        goto L8
    L6:
        r2 = null;
    L8:
        Switch r3 = (Switch) r7.d.getValue();
        if (r3 == null) goto L14;
        if (r0 == null) goto L12;
        boolean r4 = r0.c;
    L13:
        r3.setChecked(r4);
        goto L14
    L12:
        r4 = false;
    L14:
        Switch r8 = (Switch) r7.d.getValue();
        if (r8 == null) goto L21;
        if (r0 == null) goto L18;
        float r9 = r0.e;
    L19:
        r8.setAlpha(r9);
        goto L21
    L18:
        r9 = 1.0f;
    L21:
        if (r7.f.a() == true) goto L23;
        return;
    L23:
        if ((r6 % 2) == 0) goto L29;
        View r11 = (View) r7.e.getValue();
        if (r11 == null) goto L30;
        r11.setVisibility(0);
        return;
    L30:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566473, r3, false);
        if (this.c == false) goto L7;
        TextView r6 = (TextView) r5.findViewById(2131364755);
        if (r6 == null) goto L7;
        r6.setTextSize(13.0f);
    L7:
        Unit r7 = Unit.INSTANCE;
        return new TuningButtonListViewHolder(r5, this.b);
    }

    @Override // bc0.c
    public final void m2(Function1<? super ac0.a, Unit> r11, TuningButtonType r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "preHandleButtonData");
        Intrinsics.checkNotNullParameter(r12, "tuningButtonType");
        Iterator r0 = ((ArrayList) this.a).iterator();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r12 == ((ac0.a) r3).getType()) goto L13;
        r2 = r4;
    L13:
        int r14 = ((ArrayList) this.a).size();
        if (r2 < 0) goto L37;
        if (r14 <= r2) goto L35;
        ac0.a r15 = new ac0.a(((ac0.a) ListProtector.get(this.a, r2)).getType(), ((ac0.a) ListProtector.get(this.a, r2)).b, ((ac0.a) ListProtector.get(this.a, r2)).c, ((ac0.a) ListProtector.get(this.a, r2)).d, ((ac0.a) ListProtector.get(this.a, r2)).e, 32);
        r11.invoke(ListProtector.get(this.a, r2));
        if (r13 == true) goto L31;
        ac0.a r16 = (ac0.a) ListProtector.get(this.a, r2);
        if (r15.c == r16.c) goto L22;
    L29:
        r1 = true;
    L30:
        if (r1 == true) goto L31;
        return;
    L22:
        if (r15.e != r16.e) goto L29;
        if ((!Intrinsics.areEqual(r15.b, r16.b)) == true) goto L29;
        if (r15.getType() != r16.getType()) goto L29;
        if (r15.d == r16.d) goto L30;
    L31:
        notifyItemChanged(r2);
        return;
    L35:
        return;
    L37:
        return;
    L12:
        r2 = -1;
        goto L13
    }
}
