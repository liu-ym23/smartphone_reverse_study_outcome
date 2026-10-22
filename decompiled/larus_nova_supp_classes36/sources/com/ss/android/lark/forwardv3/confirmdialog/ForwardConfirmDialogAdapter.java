package com.ss.android.lark.forwardv3.confirmdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.forwardv3.utils.n;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onItemClickListener", "Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/ss/android/lark/forwardv3/confirmdialog/ForwardConfirmDialogAdapter$OnItemClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "OnItemClickListener", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardConfirmDialogAdapter extends LarkRecyclerViewBaseAdapter<ForwardConfirmDialogViewHolder, SearchBaseInfo> {
    public final Context a;
    public a b;

    public interface a {
        void a(SearchBaseInfo r1);
    }

    public ForwardConfirmDialogAdapter(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ForwardConfirmDialogViewHolder r6 = (ForwardConfirmDialogViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        SearchBaseInfo r7 = (SearchBaseInfo) getItem(r5);
        LKUIRoundedImageView r0 = r6.a;
        LKUIRoundedImageView r1 = r6.b;
        if (r0 == null) goto L12;
        if (r1 == null) goto L15;
        int r2 = n.a;
        Context r3 = this.a;
        Intrinsics.checkNotNull(r7);
        n.c(r3, r7, r0, r1);
        a r8 = this.b;
        if (r8 == null) goto L13;
        Intrinsics.checkNotNullParameter(r8, "onItemClickListener");
        Intrinsics.checkNotNullParameter(r7, "data");
        FrameLayout r9 = r6.c;
        if (r9 == null) goto L14;
        r9.setOnClickListener(new com.ss.android.lark.forwardv3.confirmdialog.a(r8, r7));
        return;
    L14:
        return;
    L13:
        return;
    L15:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561605, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ForwardConfirmDialogViewHolder(r5);
    }
}
