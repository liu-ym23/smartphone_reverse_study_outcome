package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MorePanelButtonDiffUpdater<Model extends com.bytedance.android.livesdk.chatroom.e> {
    public final ArrayList<Pair<ViewGroup, Integer>> a;
    public final RecyclerView b;
    public final s<Model> c;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/MorePanelButtonDiffUpdater$DynamicItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class DynamicItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public List<? extends Model> a;
        public final /* synthetic */ MorePanelButtonDiffUpdater b;

        public final int getItemCount() {
            List<? extends Model> r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L6:
            return r0.size();
        }

        public DynamicItemAdapter(MorePanelButtonDiffUpdater r1) {
            this.b = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "vh");
            s<Model> r0 = this.b.c;
            List<? extends Model> r1 = this.a;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L5:
            Object r2 = ListProtector.get(r1, r5);
            Model r3 = (Model) r2;
            r0.o(null, r3, r4.itemView, r5);
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "rv");
            final View r5 = this.b.c.x(r3, 4.5f, null);
            return new MorePanelButtonDiffUpdater$DynamicItemAdapter$onCreateViewHolder$1(r5, r5);
        }
    }

    public MorePanelButtonDiffUpdater(ArrayList<Pair<ViewGroup, Integer>> r2, RecyclerView r3, s<Model> r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutList");
        Intrinsics.checkNotNullParameter(r4, "dataViewBinder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
