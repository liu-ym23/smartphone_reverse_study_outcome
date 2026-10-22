package com.larus.uaigc.createpage.component.inspiration.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.uaigc.createpage.component.inspiration.ImgInspirationListComponent;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import fq8.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kz9.a;
import kz9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016H\u0007J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationViewHolder;", "callback", "Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationViewHolderCallback;", "<init>", "(Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationViewHolderCallback;)V", "datas", "", "Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "submitList", "list", "", "getItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImgInspirationListAdapter extends RecyclerView.Adapter<ImgInspirationViewHolder> {
    public final b a;
    public final List<e> b;

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public ImgInspirationListAdapter(ImgInspirationListComponent.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
        this.b = new ArrayList();
    }

    public final void submitList(List<e> r3) {
        List<e> r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        FLogger.a.d("ImgInspirationListAdapter", "submitList list is empty");
        return;
    L12:
        ((ArrayList) this.b).clear();
        ((ArrayList) this.b).addAll(r4);
        notifyDataSetChanged();
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        final ImgInspirationViewHolder r5 = (ImgInspirationViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        final e r6 = (e) CollectionsKt.getOrNull(this.b, r4);
        if (r6 == null) goto L6;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        r5.b.setText(r6.d());
        e1.d(((RecyclerView.ViewHolder) r5).itemView, new a(r5, r6));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        RoundConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562833, r3, false);
        if (ViewBindings.findChildViewById(r5, 2131390788) == null) goto L7;
        return new ImgInspirationViewHolder(r5, this.a);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131390788)));
    }
}
