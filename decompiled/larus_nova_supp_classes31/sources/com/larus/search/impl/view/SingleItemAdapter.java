package com.larus.search.impl.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/search/impl/view/SingleItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/search/impl/view/SingleItemAdapter$InnerHolder;", "contentView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "currentWrapper", "Landroid/view/ViewGroup;", "onCreateViewHolder", "parent", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "Companion", "InnerHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SingleItemAdapter extends RecyclerView.Adapter<InnerHolder> {
    public static final /* synthetic */ int c = 0;
    public final View a;
    public ViewGroup b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/search/impl/view/SingleItemAdapter$InnerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "wrapper", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "getWrapper", "()Landroid/view/ViewGroup;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class InnerHolder extends RecyclerView.ViewHolder {
        public final ViewGroup a;

        public InnerHolder(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "wrapper");
            super(r2);
            this.a = r2;
            setIsRecyclable(false);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return 1;
    }

    public SingleItemAdapter(View r2) {
        Intrinsics.checkNotNullParameter(r2, "contentView");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter((InnerHolder) r1, "holder");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        FrameLayout r5 = new FrameLayout(this.a.getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ViewGroup r6 = this.b;
        if (r6 == null) goto L6;
        r6.removeViewInLayout(this.a);
        r6.endViewTransition(this.a);
    L6:
        if (this.a.getParent() != null) goto L8;
        r5.addView(this.a);
    L8:
        this.b = r5;
        return new InnerHolder(r5);
    }
}
