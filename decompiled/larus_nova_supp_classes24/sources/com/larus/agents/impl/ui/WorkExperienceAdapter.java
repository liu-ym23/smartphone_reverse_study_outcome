package com.larus.agents.impl.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusItemWorkExperienceBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u0000 \u00192\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J$\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/agents/impl/ui/WorkExperienceAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/agents/impl/experience/WorkExperienceSummary;", "Lcom/larus/agents/impl/ui/WorkExperienceAdapter$Holder;", "onOpen", "Lkotlin/Function1;", "", "onManage", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onCurrentListChanged", "previousList", "", "currentList", "Holder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkExperienceAdapter extends ListAdapter<com.larus.agents.impl.experience.t, Holder> {
    public static final WorkExperienceAdapter$Companion$DIFF$1 c = null;
    public final Function1<com.larus.agents.impl.experience.t, Unit> a;
    public final Function2<com.larus.agents.impl.experience.t, View, Unit> b;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/agents/impl/ui/WorkExperienceAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/agents/impl/databinding/LarusItemWorkExperienceBinding;", "<init>", "(Lcom/larus/agents/impl/ui/WorkExperienceAdapter;Lcom/larus/agents/impl/databinding/LarusItemWorkExperienceBinding;)V", "bind", "", "item", "Lcom/larus/agents/impl/experience/WorkExperienceSummary;", "position", "", "count", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public final class Holder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusItemWorkExperienceBinding a;
        public final /* synthetic */ WorkExperienceAdapter b;

        public Holder(WorkExperienceAdapter r2, LarusItemWorkExperienceBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.agents.impl.ui.WorkExperienceAdapter$Companion$DIFF$1] */
    static {
        c = new WorkExperienceAdapter$Companion$DIFF$1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkExperienceAdapter(Function1<? super com.larus.agents.impl.experience.t, Unit> r2, Function2<? super com.larus.agents.impl.experience.t, ? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onOpen");
        Intrinsics.checkNotNullParameter(r3, "onManage");
        super(c);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Holder r9 = (Holder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final com.larus.agents.impl.experience.t r0 = (com.larus.agents.impl.experience.t) getItem(r8);
        int r1 = getItemCount();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        final LarusItemWorkExperienceBinding r2 = r9.a;
        final WorkExperienceAdapter r10 = r9.b;
        ConstraintLayout r3 = r2.a;
        if (r1 != 1) goto L5;
        int r5 = 2131239964;
    L11:
        r3.setBackgroundResource(r5);
        View r4 = r2.b;
        if (r8 != (r1 - 1)) goto L14;
        int r11 = 8;
    L15:
        r4.setVisibility(r11);
        TextView r12 = r2.c;
        String r6 = r0.b;
        if (StringsKt.isBlank(r6) == false) goto L18;
        r6 = r0.c;
    L18:
        r12.setText(r6);
        ConstraintLayout r13 = r2.a;
        String r14 = r0.b;
        if (StringsKt.isBlank(r14) == false) goto L21;
        r14 = r0.c;
    L21:
        r13.setContentDescription(r14);
        r2.a.setOnClickListener(new i(r10, r0));
        r2.a.setOnLongClickListener(new j(r10, r0, r2));
        return;
    L14:
        r11 = 0;
        goto L15
    L5:
        if (r8 != 0) goto L8;
        r5 = 2131239960;
        goto L11
    L8:
        if (r8 != (r1 - 1)) goto L10;
        r5 = 2131239962;
        goto L11
    L10:
        r5 = 2131239963;
        goto L11
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new Holder(this, LarusItemWorkExperienceBinding.a(LayoutInflater.from(r2.getContext()), r2));
    }

    public final void onCurrentListChanged(List<com.larus.agents.impl.experience.t> r8, List<com.larus.agents.impl.experience.t> r9) {
        Intrinsics.checkNotNullParameter(r8, "previousList");
        Intrinsics.checkNotNullParameter(r9, "currentList");
        super.onCurrentListChanged(r8, r9);
        String[] r0 = new String[4];
        com.larus.agents.impl.experience.t r1 = (com.larus.agents.impl.experience.t) CollectionsKt.firstOrNull(r8);
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a;
    L6:
        r0[0] = r3;
        com.larus.agents.impl.experience.t r10 = (com.larus.agents.impl.experience.t) CollectionsKt.lastOrNull(r8);
        if (r10 == null) goto L9;
        String r11 = r10.a;
    L10:
        r0[1] = r11;
        com.larus.agents.impl.experience.t r12 = (com.larus.agents.impl.experience.t) CollectionsKt.firstOrNull(r9);
        if (r12 == null) goto L13;
        String r13 = r12.a;
    L14:
        r0[2] = r13;
        com.larus.agents.impl.experience.t r14 = (com.larus.agents.impl.experience.t) CollectionsKt.lastOrNull(r9);
        if (r14 == null) goto L17;
        r2 = r14.a;
    L17:
        r0[3] = r2;
        Set r15 = SetsKt.setOfNotNull(r0);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L19:
        if (r16.hasNext() == false) goto L29;
        String r5 = (String) r16.next();
        Iterator<com.larus.agents.impl.experience.t> r6 = r9.iterator();
        int r7 = 0;
    L22:
        if (r6.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(r6.next().a, r5) == true) goto L28;
        r7 = r7 + 1;
    L28:
        r4.add(Integer.valueOf(r7));
        goto L19
    L27:
        r7 = -1;
        goto L28
    L29:
        ArrayList r17 = new ArrayList();
        Iterator r19 = r4.iterator();
    L31:
        if (r19.hasNext() == false) goto L38;
        Object r20 = r19.next();
        if (((Number) r20).intValue() < 0) goto L35;
        boolean r21 = true;
    L36:
        if (r21 == false) goto L31;
        r17.add(r20);
        goto L31
    L35:
        r21 = false;
        goto L36
    L38:
        Iterator r22 = CollectionsKt.distinct(r17).iterator();
    L40:
        if (r22.hasNext() == false) goto L42;
        notifyItemChanged(((Number) r22.next()).intValue());
        goto L40
    L42:
        return;
    L13:
        r13 = null;
        goto L14
    L9:
        r11 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
