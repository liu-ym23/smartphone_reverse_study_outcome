package com.larus.chat.job.impl.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.component.ChatJobLynxItemComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005Jj\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u00112\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u00112\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u0015J\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/chat/job/impl/page/JobViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "container", "Lcom/larus/chat/job/impl/ui/ChatJobLongPressLayout;", "lynxComponent", "Lcom/larus/chat/job/impl/component/ChatJobLynxItemComponent;", "bind", "", "item", "Lcom/larus/chat/job/impl/page/ChatJobListItem$Job;", "itemIndex", "", "onTaskClick", "Lkotlin/Function2;", "Lcom/larus/im/bean/job/AIJob;", "onTaskTapObserved", "onTaskLongClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "unbind", "destroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JobViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final fz8.k a;
    public ChatJobLynxItemComponent b;

    public final void unbind() {
        this.a.setOnDetectedTap(null);
        this.a.setOnClickListener(null);
        this.a.setOnDetectedLongPress(null);
    }

    public JobViewHolder(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(new fz8.k(r4));
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.chat.job.impl.ui.ChatJobLongPressLayout");
        fz8.k r6 = (fz8.k) r5;
        this.a = r6;
        RecyclerView.LayoutParams r0 = new RecyclerView.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) r0).leftMargin = i5.q();
        ((ViewGroup.MarginLayoutParams) r0).rightMargin = i5.q();
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = i5.h();
        r6.setLayoutParams(r0);
    }
}
