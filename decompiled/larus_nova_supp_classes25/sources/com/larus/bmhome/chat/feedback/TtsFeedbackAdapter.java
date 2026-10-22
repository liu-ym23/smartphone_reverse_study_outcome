package com.larus.bmhome.chat.feedback;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.bean.FeedbackItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusItemTtsFeedbackBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/feedback/TtsFeedbackAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/chat/feedback/TtsFeedbackHolder;", "list", "", "Lcom/larus/audio/bean/FeedbackItem;", "selectList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/List;Ljava/util/ArrayList;)V", "getList", "()Ljava/util/List;", "getSelectList", "()Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TtsFeedbackAdapter extends RecyclerView.Adapter<TtsFeedbackHolder> {
    public final List<FeedbackItem> a;
    public final ArrayList<Integer> b;

    public final int getItemCount() {
        return this.a.size();
    }

    public TtsFeedbackAdapter(List<FeedbackItem> r2, ArrayList<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "selectList");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        final TtsFeedbackHolder r8 = (TtsFeedbackHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        final FeedbackItem r9 = (FeedbackItem) ListProtector.get(this.a, r7);
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        boolean r1 = this.b.contains(Integer.valueOf(r9.a()));
        r0.element = r1;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "item");
        LarusItemTtsFeedbackBinding r2 = r8.a;
        TextView r3 = r2.b;
        String r4 = r9.b();
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        r3.setText(r4);
        boolean r5 = h.a;
        if (h.a(null) == false) goto L9;
        ImageLoaderKt.u(r2.c, r9.d(), "tts_feedback");
    L10:
        r8.T3(r1);
        e1.d(r8.a.a, new d(r0, this, r9, r8));
        return;
    L9:
        ImageLoaderKt.u(r2.c, r9.c(), "tts_feedback");
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        ConstraintLayout r7 = LayoutInflater.from(r5.getContext()).inflate(2131562698, r5, false);
        int r0 = 2131368819;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r7, 2131368819);
        if (r1 == null) goto L11;
        r0 = 2131374718;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r7, 2131374718);
        if (r2 == null) goto L11;
        r0 = 2131385765;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r7, 2131385765);
        if (r3 == null) goto L11;
        return new TtsFeedbackHolder(new LarusItemTtsFeedbackBinding(r7, r1, r2, r3));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
