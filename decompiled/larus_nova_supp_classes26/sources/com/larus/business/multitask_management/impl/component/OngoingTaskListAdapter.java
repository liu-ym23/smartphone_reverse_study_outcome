package com.larus.business.multitask_management.impl.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.business.multitask_management.impl.view.MultitaskLottieIcon;
import com.larus.business.multitask_management.impl.view.OngoingTaskItemHolderView;
import com.larus.business.multitask_management.impl.view.v;
import com.larus.business.multitask_management.impl.view.w;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.o0;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kl9.p;
import kl9.u;
import kl9.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003GHIB\u009e\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012_\b\u0002\u0010\f\u001aY\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012#\u0012!\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\nH\u0016J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\nH\u0016J\u0014\u0010-\u001a\u00020\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010/\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\nJ\u000e\u00100\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nJ\u0006\u00101\u001a\u00020\u0015JD\u00102\u001a\u00020\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u000e\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0019J\u000e\u0010;\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010<\u001a\u00020\nH\u0002J$\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J \u0010>\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\u0015H\u0002J\u001e\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020D2\u0006\u0010$\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0019J\u0018\u0010E\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u0019H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Re\u0010\f\u001aY\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012#\u0012!\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006J"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/OngoingTaskListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "tasks", "", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "showPlaceholderHeader", "", "enableFold", "foldThreshold", "", "enableCardShadow", "onItemClick", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "", "clickFrom", "", "extra", "", "<init>", "(Ljava/util/List;ZZIZLkotlin/jvm/functions/Function3;)V", "expandProgress", "", "expanded", "translationStepPx", "delayFactorCache", "", "isFolded", "hasUserExpanded", "headerCount", "getHeaderCount$impl_mainlandRelease", "()I", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewAttachedToWindow", "getItemCount", "updateTasks", "newTasks", "getTaskAt", "getTaskPosition", "expandAllTasks", "updateDataInternal", "oldDisplayTasks", "newDisplayTasks", "oldFullTaskCount", "newFullTaskCount", "oldIsFolded", "newIsFolded", "setExpandProgress", "progress", "setExpanded", "visibleTaskCount", "displayTasks", "isFoldTriggerCardAt", "fullTaskCount", "folded", "updateFoldStateAfterTasksChanged", "applyAnimation", "itemView", "Landroid/view/View;", "delayFactorForPosition", "maxDelay", "Companion", "HeaderViewHolder", "TaskViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int m = 0;
    public List<u> a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final Function3<Integer, String, Map<String, String>, Unit> f;
    public float g;
    public boolean h;
    public final int i;
    public float[] j;
    public boolean k;
    public boolean l;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/OngoingTaskListAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u008f\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2_\b\u0002\u0010\u0010\u001aY\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012#\u0012!\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/OngoingTaskListAdapter$TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "taskItemView", "Lcom/larus/business/multitask_management/impl/view/OngoingTaskItemHolderView;", "<init>", "(Lcom/larus/business/multitask_management/impl/view/OngoingTaskItemHolderView;)V", "bind", "", "bindingAdapterPosition", "", "item", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "isFoldTriggerCard", "", "onCardClick", "Lkotlin/Function0;", "onItemClick", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "clickFrom", "", "extra", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TaskViewHolder extends RecyclerView.ViewHolder {
        public final OngoingTaskItemHolderView a;

        public TaskViewHolder(OngoingTaskItemHolderView r2) {
            Intrinsics.checkNotNullParameter(r2, "taskItemView");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int D2() {
        if (this.c == false) goto L8;
        if (this.k == false) goto L8;
        return RangesKt.coerceIn(this.d, 0, this.a.size());
    L8:
        return this.a.size();
    }

    public final int getItemCount() {
        return D2() + (this.b ? 1 : 0);
    }

    public final u A2(int r3) {
        return (u) CollectionsKt.getOrNull(this.a, r3 - (this.b ? 1 : 0));
    }

    public final void C2(List<u> r10) {
        Intrinsics.checkNotNullParameter(r10, "newTasks");
        boolean r6 = this.k;
        int r5 = this.a.size();
        List<u> r2 = z2(this.a, r6);
        this.a = r10;
        if (this.c == true) goto L6;
        this.k = false;
        this.l = false;
    L11:
        boolean r8 = this.k;
        int r7 = this.a.size();
        DiffUtil.calculateDiff(new OngoingTaskListAdapter$updateDataInternal$diffResult$1(r2, z2(this.a, r8), this, r5, r6, r7, r8)).dispatchUpdatesTo(new e(this, this.b ? 1 : 0));
        return;
    L6:
        if (r10.size() > this.d) goto L9;
        this.k = false;
        goto L11
    L9:
        if (this.l == true) goto L11;
        this.k = true;
        goto L11
    }

    public final int getItemViewType(int r4) {
        boolean r0 = this.b;
        int r1 = 0;
        if (r0 == false) goto L6;
        if (r4 != 0) goto L6;
        return 0;
    L6:
        u r5 = (u) CollectionsKt.getOrNull(this.a, r4 - (r0 ? 1 : 0));
        if (r5 == null) goto L12;
        x r6 = r5.i;
        if (r6 == null) goto L12;
        r1 = r6.h;
    L12:
        return r1 + GuidePriority.COMMERCE_CREDIT_PRIORITY;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewAttachedToWindow(r4);
        if ((r4 instanceof TaskViewHolder) == false) goto L12;
        int r0 = ConcatAdapter.z2(r4) - (this.b ? 1 : 0);
        boolean r1 = false;
        if (r0 >= 0) goto L7;
    L9:
        if (r1 == false) goto L13;
        y2(r4.itemView, r0, this.g);
        return;
    L13:
        return;
    L7:
        if (r0 >= D2()) goto L9;
        r1 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v13, types: [com.larus.business.multitask_management.impl.view.u] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r23, final int r24) {
        Intrinsics.checkNotNullParameter(r23, "holder");
        if ((r23 instanceof TaskViewHolder) == false) goto L128;
        int r9 = r24 - (this.b ? 1 : 0);
        if (r9 >= 0) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L129;
        boolean r5 = B2(r9, this.a.size(), this.k);
        String r6 = null;
        if (r5 == false) goto L14;
        Function0<Unit> r10 = new f(this, r24);
    L15:
        TaskViewHolder r7 = (TaskViewHolder) r23;
        final u r11 = (u) ListProtector.get(this.a, r9);
        final Function3<Integer, String, Map<String, String>, Unit> r12 = this.f;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r11, "item");
        final OngoingTaskItemHolderView r13 = r7.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r11, "item");
        View r8 = r13.b.d;
        if (r5 == false) goto L18;
        int r14 = 0;
    L19:
        r8.setVisibility(r14);
        r13.e = r10;
        boolean r15 = v19.h.a;
        if (v19.h.b(r13.getContext()) == false) goto L38;
        x r16 = r11.i;
        if (r16 == null) goto L24;
        String r17 = r16.g;
    L25:
        if (r17 != null) goto L27;
    L30:
        boolean r18 = true;
    L31:
        if (r18 == false) goto L35;
        x r19 = r11.i;
        if (r19 == null) goto L41;
        String r20 = r19.f;
    L42:
        x r21 = r11.i;
        if (r21 == null) goto L47;
        Double r22 = r21.e;
        if (r22 == null) goto L47;
        int r25 = c7.b(Double.valueOf(RangesKt.coerceAtLeast(r22.doubleValue(), 0.0d)));
    L48:
        if (r20 != null) goto L50;
    L53:
        boolean r26 = true;
    L54:
        if (r26 == true) goto L56;
        r13.b.f.setBackgroundColor(com.larus.business.multitask_management.impl.view.f.d(r20, false, -1));
    L57:
        if (r25 <= 0) goto L59;
        r13.b.f.setPadding(r25, r25, r25, r25);
    L60:
        Context r27 = r13.getContext();
        LottieAdapterView r28 = r13.b.g;
        x r29 = r11.i;
        if (r29 == null) goto L63;
        String r30 = r29.c;
    L64:
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "lottieView");
        Iterator r110 = MultitaskLottieIcon.getEntries().iterator();
    L66:
        if (r110.hasNext() == false) goto L70;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((MultitaskLottieIcon) r111).getIdentifier(), r30) == false) goto L66;
    L71:
        MultitaskLottieIcon r112 = (MultitaskLottieIcon) r111;
        if (r112 != null) goto L74;
        boolean r2 = false;
    L79:
        if (r2 == false) goto L81;
        r13.b.g.setVisibility(0);
        r13.b.e.setVisibility(8);
        r13.b.g.cancelAnimation();
        r13.b.g.playAnimation();
    L89:
        View r3 = r13.d;
        if (r3 == null) goto L95;
        jl9.a r31 = r13.c;
        if (r31 == null) goto L95;
        r31.b(r3, new jl9.b(r13.getContext(), new com.larus.business.multitask_management.impl.view.u(r12, r24)), r11);
    L95:
        p r32 = r11.l;
        if (r32 == null) goto L98;
        String r33 = r32.d;
    L100:
        if (o0.d(r33) == false) goto L102;
        p r34 = r11.l;
    L106:
        final p r35 = r34;
        Context r36 = r13.getContext();
        SimpleDraweeView r37 = r13.b.b;
        if (r35 == null) goto L109;
        String r38 = r35.b;
    L110:
        if (r35 == null) goto L112;
        String r39 = r35.c;
    L113:
        com.larus.business.multitask_management.impl.view.f.c(r36, r37, r38, r39, 2131243072);
        SimpleDraweeView r40 = r13.b.b;
        if (r35 == null) goto L122;
        String r41 = r35.a;
        if (r41 == null) goto L122;
        if (o0.d(r41) == false) goto L120;
        r6 = r41;
    L120:
        if (r6 == null) goto L122;
    L123:
        r40.setContentDescription(r6);
        e1.d(r13.b.b, new v(r12, r24, r35, r13, r11));
        final f r42 = r10;
        e1.d(r13, new w(r42, r13, r12, r24, r11));
        y2(r23.itemView, r9, this.g);
        return;
    L122:
        int r43 = j0.a;
        r6 = j0.d(2131898867);
        goto L123
    L112:
        r39 = null;
        goto L113
    L109:
        r38 = null;
        goto L110
    L102:
        p r44 = r11.l;
        if (r44 == null) goto L105;
        r34 = p.a(r44, "sslocal://task_management/remove_task?task_instance_id=" + r11.a, null, 247);
        goto L106
    L105:
        r34 = new p(null, null, "sslocal://task_management/remove_task?task_instance_id=" + r11.a, null, null, null, 247);
        goto L106
    L98:
        r33 = null;
        goto L100
    L81:
        r13.b.g.cancelAnimation();
        r13.b.g.setVisibility(8);
        r13.b.e.setVisibility(0);
        Context r45 = r13.getContext();
        SimpleDraweeView r46 = r13.b.e;
        x r47 = r11.i;
        if (r47 == null) goto L84;
        String r48 = r47.c;
    L85:
        if (r47 == null) goto L87;
        String r49 = r47.d;
    L88:
        com.larus.business.multitask_management.impl.view.f.c(r45, r46, r48, r49, 2131243087);
        goto L89
    L87:
        r49 = null;
        goto L88
    L84:
        r48 = null;
        goto L85
    L74:
        boolean r50 = v19.h.a;
        if (v19.h.b(r27) == false) goto L77;
        r28.setAnimation(r112.getDarkAssetPath());
    L78:
        r2 = true;
        goto L79
    L77:
        r28.setAnimation(r112.getLightAssetPath());
        goto L78
    L70:
        r111 = null;
        goto L71
    L63:
        r30 = null;
        goto L64
    L59:
        r13.b.f.setPadding(0, 0, 0, 0);
        goto L60
    L56:
        r13.b.f.setBackground(null);
        goto L57
    L50:
        if (r20.length() == 0) goto L53;
        r26 = false;
    L47:
        r25 = 0;
    L41:
        r20 = null;
        goto L42
    L35:
        x r51 = r11.i;
        if (r51 == null) goto L41;
        r20 = r51.g;
        goto L42
    L27:
        if (r17.length() == 0) goto L30;
        r18 = false;
        goto L31
    L24:
        r17 = null;
        goto L25
    L38:
        x r52 = r11.i;
        if (r52 == null) goto L41;
        r20 = r52.f;
        goto L42
    L18:
        r14 = 8;
        goto L19
    L14:
        r10 = null;
        goto L15
    L129:
        return;
    L7:
        if (r9 >= D2()) goto L9;
        r4 = true;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        if (r8 != 0) goto L5;
        View r9 = new View(r7.getContext());
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        return new HeaderViewHolder(r9);
    L5:
        OngoingTaskItemHolderView r10 = new OngoingTaskItemHolderView(r7.getContext(), null, 0, r8 - 1000, 6);
        if (this.e == false) goto L9;
        com.larus.business.multitask_management.impl.view.f.a(r10);
    L9:
        return new TaskViewHolder(r10);
    }

    public final List<u> z2(List<u> r3, boolean r4) {
        if (this.c == false) goto L7;
        if (r4 == true) goto L6;
        return r3;
    L6:
        return CollectionsKt.take(r3, RangesKt.coerceIn(this.d, 0, r3.size()));
    L7:
        return r3;
    }

    public final boolean B2(int r2, int r3, boolean r4) {
        if (this.c == false) goto L10;
        if (r4 == false) goto L10;
        int r5 = this.d;
        if (r3 <= r5) goto L10;
        if (r2 != (r5 - 1)) goto L10;
        return true;
    L10:
        return false;
    }

    public final void y2(View r17, int r18, float r19) {
        Intrinsics.checkNotNullParameter(r17, "itemView");
        if (r19 != 1.0f) goto L5;
        boolean r6 = true;
    L6:
        float r7 = 0.0f;
        if (r6 == false) goto L10;
        r17.setTranslationX(0.0f);
        r17.setAlpha(1.0f);
        return;
    L10:
        int r8 = this.i * r18;
        if (this.h == false) goto L13;
        float r9 = 0.0f;
    L14:
        r17.setTranslationX(r9);
        if (r18 >= 0) goto L17;
        float r3 = 0.0f;
    L28:
        if (r19 > r3) goto L30;
        float r10 = 0.0f;
    L31:
        float r4 = RangesKt.coerceIn(r10, 0.0f, 1.0f);
        if (r18 == 0) goto L34;
        r7 = r4;
    L41:
        r17.setAlpha(r7);
        return;
    L34:
        if (r19 != 0.0f) goto L36;
        boolean r5 = true;
    L37:
        if (r5 == true) goto L41;
        r7 = (r19 * 0.5f) + 0.5f;
        goto L41
    L36:
        r5 = false;
        goto L37
    L30:
        r10 = (r19 - r3) / (1.0f - r3);
        goto L31
    L17:
        float[] r11 = this.j;
        if (r18 < r11.length) goto L23;
        int r12 = RangesKt.coerceAtLeast(Math.max(r18 + 1, r11.length * 2), 8);
        float[] r15 = new float[r12];
        int r13 = 0;
    L20:
        if (r13 >= r12) goto L22;
        r15[r13] = Float.NaN;
        r13 = r13 + 1;
        goto L20
    L22:
        float[] r14 = this.j;
        ArraysKt.copyInto$default(r14, r15, 0, 0, r14.length, 6, null);
        this.j = r15;
    L23:
        float r16 = this.j[r18];
        if (Float.isNaN(r16) == true) goto L26;
        r3 = Math.min(r16, 0.5f);
        goto L28
    L26:
        float r20 = ((float) Math.log(r18 + 1.0f)) * 0.2f;
        this.j[r18] = r20;
        r3 = Math.min(r20, 0.5f);
        goto L28
    L13:
        r9 = r8 * (1.0f - r19);
        goto L14
    L5:
        r6 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OngoingTaskListAdapter(List<u> r2, boolean r3, boolean r4, int r5, boolean r6, Function3<? super Integer, ? super String, ? super Map<String, String>, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "tasks");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.i = c7.b(28);
        float[] r8 = new float[10];
        int r9 = 0;
    L3:
        if (r9 >= 10) goto L5;
        r8[r9] = Float.NaN;
        r9 = r9 + 1;
        goto L3
    L5:
        this.j = r8;
    }
}
