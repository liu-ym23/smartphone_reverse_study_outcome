package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedWakeupItemBinding;
import com.larus.dora.impl.settings.SimplifiedTopic;
import com.larus.dora.impl.view.DoraTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter$ViewHolder;", "<init>", "()V", "items", "", "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "updateTopics", "", "newItems", "", "getTopic", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "getItemId", "", "getItemCount", "ViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedWakeupAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<SimplifiedTopic> a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupItemBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupItemBinding;)V", "bind", "", "item", "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "bindText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final LarusDoraHSimplifiedWakeupItemBinding a;

        public ViewHolder(LarusDoraHSimplifiedWakeupItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public final long getItemId(int r3) {
        return r3;
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public DoraHStreamlinedWakeupAdapter() {
        this.a = new ArrayList();
        setHasStableIds(true);
    }

    public final void y2(List<SimplifiedTopic> r7) {
        Intrinsics.checkNotNullParameter(r7, "newItems");
        if (((ArrayList) this.a).size() == r7.size()) goto L6;
        ((ArrayList) this.a).clear();
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r7);
        notifyDataSetChanged();
        return;
    L6:
        Iterator<T> r1 = r7.iterator();
        boolean r2 = false;
        int r3 = 0;
    L8:
        if (r1.hasNext() == false) goto L16;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        SimplifiedTopic r6 = (SimplifiedTopic) r4;
        if (Intrinsics.areEqual((SimplifiedTopic) CollectionsKt.getOrNull(this.a, r3), r6) == true) goto L15;
        ListProtector.set(this.a, r3, r6);
        notifyItemChanged(r3, "payload_topic_text");
        r2 = true;
    L15:
        r3 = r5;
        goto L8
    L16:
        if (r2 == false) goto L18;
        return;
    L18:
        if (((ArrayList) this.a).isEmpty() == true) goto L20;
        return;
    L20:
        if (r7.isEmpty() == false) goto L28;
        notifyDataSetChanged();
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ViewHolder r5 = (ViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        SimplifiedTopic r6 = (SimplifiedTopic) ListProtector.get(this.a, r4);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r6, "item");
        AppCompatTextView r0 = r5.a.c;
        int r1 = com.larus.utils.j0.a;
        String r7 = r6.getTitleKey();
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        r0.setText(com.larus.utils.j0.e(r7));
        r5.a.c.setAlpha(1.0f);
        r5.a.b.setAlpha(1.0f);
        RecyclerView.LayoutParams r8 = r5.a.b.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r9 = r8;
        ((ViewGroup.MarginLayoutParams) r9).topMargin = c7.b(12);
        ((ViewGroup.MarginLayoutParams) r9).bottomMargin = 0;
        r5.a.b.setLayoutParams(r9);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562209, r3, false);
        FrameLayout r6 = (FrameLayout) r5;
        DoraTextView r1 = (DoraTextView) ViewBindings.findChildViewById(r5, 2131369897);
        if (r1 == null) goto L7;
        return new ViewHolder(new LarusDoraHSimplifiedWakeupItemBinding(r6, r6, r1));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131369897)));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        ViewHolder r5 = (ViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.contains("payload_topic_text") == false) goto L8;
        SimplifiedTopic r6 = (SimplifiedTopic) ListProtector.get(this.a, r3);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        AppCompatTextView r7 = r5.a.c;
        int r8 = com.larus.utils.j0.a;
        String r9 = r6.getTitleKey();
        if (r9 != null) goto L7;
        r9 = "";
    L7:
        r7.setText(com.larus.utils.j0.e(r9));
        return;
    L8:
        super.onBindViewHolder(r5, r3, r4);
    }
}
