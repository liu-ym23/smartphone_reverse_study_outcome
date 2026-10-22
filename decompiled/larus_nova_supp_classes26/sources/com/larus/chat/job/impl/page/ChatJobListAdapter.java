package com.larus.chat.job.impl.page;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.component.ChatJobLynxItemComponent;
import com.larus.im.bean.job.AIJob;
import com.larus.platform.api.e4;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$Bu\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/chat/job/impl/page/ChatJobListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/chat/job/impl/page/ChatJobListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onTaskClick", "Lkotlin/Function2;", "Lcom/larus/im/bean/job/AIJob;", "", "", "onTaskTapObserved", "onTaskLongClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "onItemShow", "Lcom/larus/chat/job/impl/page/ChatJobListItem$Job;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "lynxItemReuseController", "Lcom/larus/chat/job/impl/page/ChatJobLynxItemReuseController;", "configureRecycling", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewAttachedToWindow", "onViewRecycled", "onFailedToRecycleView", "onDetachedFromRecyclerView", "jobFlatIndex", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobListAdapter extends ListAdapter<i, RecyclerView.ViewHolder> {
    public static final ChatJobListAdapter$Companion$DIFF_CALLBACK$1 f = null;
    public final Function2<AIJob, Integer, Unit> a;
    public final Function2<AIJob, Integer, Unit> b;
    public final Function3<View, AIJob, Integer, Boolean> c;
    public final Function2<i.a, Integer, Unit> d;
    public final e0 e;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.chat.job.impl.page.ChatJobListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f = new ChatJobListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final int getItemViewType(int r2) {
        i r3 = (i) getItem(r2);
        if ((r3 instanceof i.b) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof i.a) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void onDetachedFromRecyclerView(RecyclerView r7) {
        Intrinsics.checkNotNullParameter(r7, "recyclerView");
        e0 r0 = this.e;
        Iterator<T> r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        JobViewHolder r2 = (JobViewHolder) r1.next();
        r2.unbind();
        ChatJobLynxItemComponent r3 = r2.b;
        if (r3 == null) goto L11;
        e4 r5 = r3.m;
        if (r5 == null) goto L10;
        r5.destroy();
    L10:
        r3.m = null;
        r3.n = null;
        r3.o = null;
        r3.q = null;
        r3.l.removeAllViews();
    L11:
        r2.b = null;
        goto L4
    L12:
        r0.a.clear();
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r7);
    }

    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        this.e.getClass();
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof JobViewHolder) == false) goto L5;
        JobViewHolder r0 = (JobViewHolder) r4;
    L7:
        if (r0 != null) goto L9;
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
    L13:
        return true;
    L12:
        if (super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onFailedToRecycleView(r4) == true) goto L13;
        return false;
    L9:
        r0.unbind();
        r1 = true;
        goto L10
    L5:
        r0 = null;
        goto L7
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r6) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r6);
        int r7 = r6.getAdapterPosition();
        if (r7 != (-1)) goto L5;
        return;
    L5:
        Object r0 = getItem(r7);
        if ((r0 instanceof i.a) == false) goto L8;
        i.a r1 = (i.a) r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        Function2<i.a, Integer, Unit> r2 = this.d;
        int r3 = 0;
        int r4 = 0;
    L12:
        if (r3 >= r7) goto L17;
        if ((getItem(r3) instanceof i.a) == false) goto L16;
        r4 = r4 + 1;
    L16:
        r3 = r3 + 1;
        goto L12
    L17:
        r2.invoke(r1, Integer.valueOf(r4));
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        this.e.getClass();
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof JobViewHolder) == false) goto L5;
        JobViewHolder r0 = (JobViewHolder) r3;
    L6:
        if (r0 == null) goto L8;
        r0.unbind();
    L8:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r3);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        i r1 = (i) getItem(r13);
        int r3 = 0;
        RecyclerView.LayoutParams r4 = null;
        if ((r1 instanceof i.b) == false) goto L22;
        if ((r12 instanceof k0) == false) goto L7;
        k0 r14 = (k0) r12;
    L8:
        if (r14 == null) goto L52;
        String r0 = ((i.b) r1).b;
        if (r13 != 0) goto L12;
        boolean r15 = true;
    L13:
        Intrinsics.checkNotNullParameter(r0, "title");
        r14.a.setText(r0);
        RecyclerView.LayoutParams r2 = r14.a.getLayoutParams();
        if ((r2 instanceof RecyclerView.LayoutParams) == false) goto L16;
        r4 = r2;
    L16:
        if (r4 == null) goto L53;
        if (r15 == true) goto L20;
        r3 = i5.A();
    L20:
        ((ViewGroup.MarginLayoutParams) r4).topMargin = r3;
        r14.a.setLayoutParams(r4);
        return;
    L53:
        return;
    L12:
        r15 = false;
        goto L13
    L52:
        return;
    L7:
        r14 = null;
        goto L8
    L22:
        if ((r1 instanceof i.a) == false) goto L48;
        final int r5 = 0;
    L24:
        if (r3 >= r13) goto L29;
        if ((getItem(r3) instanceof i.a) == false) goto L28;
        r5 = r5 + 1;
    L28:
        r3 = r3 + 1;
        goto L24
    L29:
        e0 r16 = this.e;
        final i.a r6 = (i.a) r1;
        final Function2<AIJob, Integer, Unit> r7 = this.a;
        final Function2<AIJob, Integer, Unit> r8 = this.b;
        final Function3<View, AIJob, Integer, Boolean> r9 = this.c;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r12, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r7, "onTaskClick");
        Intrinsics.checkNotNullParameter(r8, "onTaskTapObserved");
        Intrinsics.checkNotNullParameter(r9, "onTaskLongClick");
        if ((r12 instanceof JobViewHolder) == false) goto L32;
        final JobViewHolder r17 = (JobViewHolder) r12;
    L33:
        if (r17 == null) goto L55;
        r16.a.add(r17);
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r7, "onTaskClick");
        Intrinsics.checkNotNullParameter(r8, "onTaskTapObserved");
        Intrinsics.checkNotNullParameter(r9, "onTaskLongClick");
        fz8.k r18 = r17.a;
        if (r6.b == false) goto L38;
        float r10 = 87;
        Resources r11 = r18.getResources();
        float r19 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density;
    L39:
        r18.setMinimumHeight((int) ((r10 * r19) + 0.5f));
        ChatJobLynxItemComponent r110 = r17.b;
        if (r110 != null) goto L42;
        r110 = new ChatJobLynxItemComponent(r17.a);
        r17.b = r110;
    L42:
        r110.L2(r6);
        if (r6.b == false) goto L45;
        r17.a.setOnDetectedTap(null);
        r17.a.setOnClickListener(null);
        r17.a.setOnDetectedLongPress(null);
        return;
    L45:
        r17.a.setOnDetectedTap(new h0(r8, r6, r5));
        r17.a.setOnClickListener(new i0(r7, r6, r5));
        r17.a.setOnDetectedLongPress(new j0(r9, r17, r6, r5));
        return;
    L38:
        r10 = 157;
        Resources r20 = r18.getResources();
        r19 = WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).density;
        goto L39
    L55:
        return;
    L32:
        r17 = null;
        goto L33
    L48:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 == 1) goto L7;
        e0 r4 = this.e;
        Context r5 = r2.getContext();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        JobViewHolder r0 = new JobViewHolder(r5);
        r4.a.add(r0);
        return r0;
    L7:
        return new k0(new TextView(r2.getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatJobListAdapter(Function2<? super AIJob, ? super Integer, Unit> r2, Function2<? super AIJob, ? super Integer, Unit> r3, Function3<? super View, ? super AIJob, ? super Integer, Boolean> r4, Function2<? super i.a, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "onTaskClick");
        Intrinsics.checkNotNullParameter(r3, "onTaskTapObserved");
        Intrinsics.checkNotNullParameter(r4, "onTaskLongClick");
        Intrinsics.checkNotNullParameter(r5, "onItemShow");
        super(f);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new e0();
    }
}
