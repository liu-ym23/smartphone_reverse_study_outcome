package com.larus.ugc.feed.impl.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.larus.ugc.feed.impl.widget.MoreItemView;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fJ \u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "moreItemView", "Lcom/larus/ugc/feed/impl/widget/MoreItemView;", "kotlin.jvm.PlatformType", "setOnErrorClickListener", "", "onErrorClickListener", "Lkotlin/Function0;", "updateStatus", "state", "Lcom/larus/ugc/feed/api/state/LoadMoreState;", "disableEndView", "", "bottomPadding", "", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationMoreViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int b = 0;
    public final MoreItemView a;

    public CreationMoreViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (MoreItemView) r2.findViewById(2131380310);
    }

    public final void T3(final n0a.b r2, boolean r3, int r4) {
        this.a.setDisableEndView(r3);
        UIUtils.updateLayoutMargin(this.a, 0, 0, 0, r4);
        w0a.a.a("CreationDiscoverMoreViewHolder", new s(r2));
        MoreItemView r5 = this.a;
        if (r2 == null) goto L20;
        r5.getClass();
        if (Intrinsics.areEqual(r2, n0a.b.c.a) == true) goto L20;
        if (Intrinsics.areEqual(r2, n0a.b.d.a) == true) goto L20;
        if (Intrinsics.areEqual(r2, n0a.b.C0067b.a) == false) goto L13;
        e1.o(r5.a.d);
        e1.x(r5.a.c);
        e1.o(r5.a.b);
    L22:
        if (r5.c == false) goto L25;
        e1.o(r5.a.b);
        return;
    L25:
        return;
    L13:
        if (Intrinsics.areEqual(r2, n0a.b.e.a) == false) goto L15;
    L19:
        e1.o(r5.a.d);
        e1.o(r5.a.c);
        e1.x(r5.a.b);
        goto L22
    L15:
        if (Intrinsics.areEqual(r2, n0a.b.a.a) == true) goto L19;
        throw new NoWhenBranchMatchedException();
    L20:
        e1.x(r5.a.d);
        e1.o(r5.a.c);
        e1.o(r5.a.b);
        goto L22
    }
}
