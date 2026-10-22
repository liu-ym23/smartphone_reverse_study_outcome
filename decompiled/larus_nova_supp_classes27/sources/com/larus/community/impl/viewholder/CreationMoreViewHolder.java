package com.larus.community.impl.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.larus.community.impl.widget.MoreItemView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fJ\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "moreItemView", "Lcom/larus/community/impl/widget/MoreItemView;", "kotlin.jvm.PlatformType", "setOnErrorClickListener", "", "onErrorClickListener", "Lkotlin/Function0;", "updateStatus", "moreState", "Lcom/larus/profile/api/model/MoreState;", "disableEndView", "", "bottomPadding", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMoreViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int b = 0;
    public final MoreItemView a;

    public CreationMoreViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (MoreItemView) r2.findViewById(2131380310);
    }

    public final void T3(final gs9.i r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "moreState");
        this.a.setDisableEndView(r4);
        UIUtils.updateLayoutMargin(this.a, 0, 0, 0, r5);
        m29.a.a("CreationDiscoverMoreViewHolder", new w(r3));
        MoreItemView r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "moreState");
        if (Intrinsics.areEqual(r3, gs9.i.c.a) == false) goto L6;
        e1.x(r6.a.d);
        e1.o(r6.a.c);
        e1.o(r6.a.b);
    L12:
        if (r6.c == false) goto L17;
        e1.o(r6.a.b);
        return;
    L17:
        return;
    L6:
        if (Intrinsics.areEqual(r3, gs9.i.b.a) == false) goto L9;
        e1.o(r6.a.d);
        e1.x(r6.a.c);
        e1.o(r6.a.b);
        goto L12
    L9:
        if (Intrinsics.areEqual(r3, gs9.i.a.a) == false) goto L16;
        e1.o(r6.a.d);
        e1.o(r6.a.c);
        e1.x(r6.a.b);
        goto L12
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
