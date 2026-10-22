package com.obric.assistant.component.task;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.task.TaskStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u0013\u001a\u00020\fJ\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\f2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/component/task/TaskAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/assistant/component/task/TaskAdapter$TaskViewHolder;", "<init>", "()V", "tasks", "", "Lcom/obric/assistant/task/TaskEntry;", "openViewHolders", "", "onItemClickListener", "Lkotlin/Function0;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "submitList", "newTasks", "resetAllItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "TaskViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    public List<com.obric.assistant.task.b> a;
    public final List<TaskViewHolder> b;
    public Function0<Unit> c;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/component/task/TaskAdapter$TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/obric/assistant/component/task/TaskAdapter;Landroid/view/View;)V", "clContent", "tvSwipeAction", "Landroid/widget/TextView;", "vDivider", "tvTitle", "tvDesc", "ivIcon", "Landroid/widget/ImageView;", "pbLoading", "Landroid/widget/ProgressBar;", "ivDone", "tvStatusText", "currentTranslationX", "", "bind", "", "task", "Lcom/obric/assistant/task/TaskEntry;", "isLastItem", "", "resetSwipe", "animate", "setupBouncyGesture", "setupSwipeGesture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TaskViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int l = 0;
        public final View a;
        public final TextView b;
        public final View c;
        public final TextView d;
        public final TextView e;
        public final ImageView f;
        public final ProgressBar g;
        public final ImageView h;
        public final TextView i;
        public float j;
        public final /* synthetic */ TaskAdapter k;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TaskStatus.values().length];
                r0[TaskStatus.PROGRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TaskStatus.COMPLETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TaskStatus.QUEUEING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void T3() {
            this.a.animate().translationX(0.0f).setDuration(250).start();
            this.b.animate().translationX(0.0f).setDuration(250).start();
            this.c.animate().translationX(0.0f).setDuration(250).start();
            this.j = 0.0f;
            ((ArrayList) this.k.b).remove(this);
        }

        public TaskViewHolder(TaskAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.k = r2;
            super(r3);
            this.a = r3.findViewById(2131366841);
            this.b = (TextView) r3.findViewById(2131391537);
            this.c = r3.findViewById(2131392112);
            this.d = (TextView) r3.findViewById(2131391606);
            this.e = (TextView) r3.findViewById(2131390479);
            this.f = (ImageView) r3.findViewById(2131376297);
            this.g = (ProgressBar) r3.findViewById(2131382055);
            this.h = (ImageView) r3.findViewById(2131376183);
            this.i = (TextView) r3.findViewById(2131391509);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public TaskAdapter() {
        this.a = CollectionsKt.emptyList();
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r16, int r17) {
        final TaskViewHolder r5 = (TaskViewHolder) r16;
        Intrinsics.checkNotNullParameter(r5, "holder");
        final com.obric.assistant.task.b r10 = (com.obric.assistant.task.b) ListProtector.get(this.a, r17);
        if (r17 != (this.a.size() - 1)) goto L5;
        boolean r1 = true;
    L6:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "task");
        r5.d.setText(r10.c);
        r5.e.setText(r10.d);
        Drawable r2 = r10.f;
        if (r2 != null) goto L10;
        r2 = r10.e;
    L10:
        if (r2 == null) goto L12;
        r5.f.setImageDrawable(r2);
        r5.f.setVisibility(0);
    L13:
        r5.g.setVisibility(8);
        r5.h.setVisibility(8);
        r5.i.setVisibility(8);
        int r3 = TaskViewHolder.a.a[r10.g.ordinal()];
        if (r3 != 1) goto L16;
        r5.g.setVisibility(0);
        if (r10.h < 0) goto L30;
        r5.g.setIndeterminate(false);
        r5.g.setProgressDrawable(ContextCompat.getDrawable(((RecyclerView.ViewHolder) r5).itemView.getContext(), 2131244353));
        r5.g.setMax(100);
        r5.g.setProgress(r10.h);
    L31:
        View r4 = r5.c;
        if (r1 == false) goto L34;
        int r6 = 8;
    L35:
        r4.setVisibility(r6);
        r5.a.setTranslationX(0.0f);
        r5.b.setTranslationX(0.0f);
        r5.c.setTranslationX(0.0f);
        r5.j = 0.0f;
        ((ArrayList) r5.k.b).remove(r5);
        r5.a.setOnClickListener(null);
        if (r10.o == null) goto L38;
        r5.b.setText(r10.n);
        r5.b.setVisibility(0);
        r5.b.setOnClickListener(new f(r10, r5));
        r5.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r7 = r5.b.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        final float r9 = -((r5.b.getMeasuredWidth() + r8.getMarginStart()) + r8.getMarginEnd());
        final Ref.FloatRef r11 = new Ref.FloatRef();
        final Ref.FloatRef r12 = new Ref.FloatRef();
        final Ref.BooleanRef r13 = new Ref.BooleanRef();
        Resources r14 = ((RecyclerView.ViewHolder) r5).itemView.getContext().getResources();
        float r15 = WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).density;
        final float r18 = 48 * r15;
        final float r19 = 10 * r15;
        final int r20 = ViewConfiguration.get(((RecyclerView.ViewHolder) r5).itemView.getContext()).getScaledTouchSlop();
        View r110 = r5.a;
        final TaskAdapter r21 = r5.k;
        r110.setOnTouchListener(new h(r11, r12, r13, r5, r20, r9, r19, r21, r10, r18, r19));
        return;
    L38:
        r5.b.setVisibility(8);
        r5.a.setOnClickListener(null);
        final Ref.FloatRef r22 = new Ref.FloatRef();
        final Ref.FloatRef r23 = new Ref.FloatRef();
        final Ref.BooleanRef r24 = new Ref.BooleanRef();
        Resources r25 = ((RecyclerView.ViewHolder) r5).itemView.getContext().getResources();
        final float r26 = 10 * WindowDisplayMetricsOverride.apply(r25, r25.getDisplayMetrics()).density;
        final int r27 = ViewConfiguration.get(((RecyclerView.ViewHolder) r5).itemView.getContext()).getScaledTouchSlop();
        View r111 = r5.a;
        final TaskAdapter r28 = r5.k;
        r111.setOnTouchListener(new g(r22, r23, r24, r5, r27, r26, r10, r28));
        return;
    L34:
        r6 = 0;
        goto L35
    L30:
        r5.g.setIndeterminate(true);
        r5.g.setIndeterminateTintList(ColorStateList.valueOf(ColorProtector.parseColor("#3D7EFF")));
        goto L31
    L16:
        if (r3 == 2) goto L23;
        if (r3 != 3) goto L21;
        r5.i.setVisibility(0);
        r5.i.setText(r10.j);
        goto L31
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        if (r10.p == false) goto L25;
        int r29 = 2131244513;
    L26:
        r5.h.setImageDrawable(ContextCompat.getDrawable(((RecyclerView.ViewHolder) r5).itemView.getContext(), r29));
        r5.h.setVisibility(0);
        goto L31
    L25:
        r29 = 2131244512;
        goto L26
    L12:
        r5.f.setVisibility(8);
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131564027, r3, false);
        Intrinsics.checkNotNull(r5);
        return new TaskViewHolder(this, r5);
    }
}
