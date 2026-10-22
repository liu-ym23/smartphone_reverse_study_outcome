package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.utils.x0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0004\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "TargetViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineTargetAdapterV2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Context a;
    public final List<String> b;
    public String c;
    public final a d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetAdapterV2$TargetViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class TargetViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ViewGroup b;

        public TargetViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390538);
            this.b = (ViewGroup) r2.findViewById(2131375718);
        }
    }

    public interface a {
        void k0(String r1);
    }

    public final int getItemCount() {
        List<String> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final Context getContext() {
        return this.a;
    }

    public final void onBindViewHolder(final RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        if ((r4 instanceof TargetViewHolder) == false) goto L16;
        TargetViewHolder r0 = (TargetViewHolder) r4;
        TextView r1 = r0.a;
        List<String> r2 = this.b;
        if (r2 == null) goto L7;
        String r6 = (String) CollectionsKt.getOrNull(r2, r5);
    L8:
        r1.setText(r6);
        if (r0.a.getText() != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        r0.a.setSelected(r7);
        r0.b.setSelected(r7);
        r0.b.setOnClickListener(x0.a(new AnonymousClass1(this, r4)));
        return;
    L11:
        if (Intrinsics.areEqual(r0.a.getText().toString(), this.c) == false) goto L13;
        r7 = true;
        goto L14
    L7:
        r6 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new TargetViewHolder(LayoutInflater.from(this.a).inflate(2131566399, r4, false));
    }

    public SelfDisciplineTargetAdapterV2(Context r2, List<String> r3, String r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
