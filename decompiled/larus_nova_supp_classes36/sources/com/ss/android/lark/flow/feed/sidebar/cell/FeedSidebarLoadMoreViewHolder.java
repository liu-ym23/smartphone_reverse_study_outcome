package com.ss.android.lark.flow.feed.sidebar.cell;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import iza.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/flow/feed/sidebar/cell/FeedSidebarLoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sidebarItemConfig", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;Lkotlin/jvm/functions/Function0;)V", "textView", "Landroid/widget/TextView;", "bind", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FeedSidebarLoadMoreViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class b {
    }

    static {
    }

    public FeedSidebarLoadMoreViewHolder(View r7, e r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        Intrinsics.checkNotNullParameter(r8, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r9, "onClick");
        super(r7);
        TextView r0 = (TextView) r7.findViewById(2131386414);
        this.a = r0;
        if (r8.a == false) goto L5;
        int r1 = UIHelper.dp2px(40.0f);
    L6:
        r0.setPaddingRelative(r8.c + r1, r0.getPaddingTop(), r0.getPaddingEnd(), r0.getPaddingBottom());
        r7.setOnClickListener(new a(r9));
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarLoadMoreViewHolder", "init, hasAvatar=" + r8.a + ", avatarOffset=" + r1 + ", titleLeftMargin=" + r8.c + ", paddingStart=" + r0.getPaddingStart());
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
