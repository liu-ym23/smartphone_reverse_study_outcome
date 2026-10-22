package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "b", "TargetListAdapter", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineTargetDialog extends CommonBottomDialog {
    public String a;
    public final List<String> b;
    public final b c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetDialog$TargetListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "TargetViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class TargetListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final /* synthetic */ SelfDisciplineTargetDialog a;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetDialog$TargetListAdapter$TargetViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        public final class TargetViewHolder extends RecyclerView.ViewHolder {
            public final TextView a;

            public TargetViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "view");
                super(r2);
                this.a = (TextView) r2.findViewById(2131391555);
            }
        }

        public final int getItemCount() {
            List<String> r0 = this.a.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public TargetListAdapter(SelfDisciplineTargetDialog r1) {
            this.a = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, final int r4) {
            Intrinsics.checkNotNullParameter(r3, "viewHolder");
            if ((r3 instanceof TargetViewHolder) == false) goto L16;
            final TextView r5 = ((TargetViewHolder) r3).a;
            List<String> r0 = this.a.b;
            if (r0 == null) goto L7;
            String r1 = (String) CollectionsKt.getOrNull(r0, r4);
        L8:
            r5.setText(r1);
            if (r5.getText() != null) goto L11;
        L13:
            boolean r2 = false;
        L14:
            r5.setSelected(r2);
            r5.setOnClickListener(x0.a(new SelfDisciplineTargetDialog$TargetListAdapter$onBindViewHolder$$inlined$with$lambda$1(r5, this, r4)));
            return;
        L11:
            if (Intrinsics.areEqual(r5.getText().toString(), this.a.a) == false) goto L13;
            r2 = true;
            goto L14
        L7:
            r1 = null;
            goto L8
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new TargetViewHolder(LayoutInflater.from(this.a.getContext()).inflate(2131566398, r4, false));
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r1);
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565555;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        TextView r6 = (TextView) findViewById(2131390273);
        if (r6 == null) goto L5;
        r6.setOnClickListener(x0.a(new SelfDisciplineTargetDialog$init$1(this)));
    L5:
        TextView r7 = (TextView) findViewById(2131390381);
        if (r7 == null) goto L8;
        r7.setOnClickListener(x0.a(new SelfDisciplineTargetDialog$init$2(this)));
    L8:
        TextView r8 = (TextView) findViewById(2131391606);
        SelfDisciplineContext.Companion.getClass();
        if (Intrinsics.areEqual(SelfDisciplineContext.a.c(), s1.B(2131922430)) == false) goto L11;
        String r0 = getContext().getResources().getString(2131922428);
    L12:
        r8.setText(r0);
        RecyclerView r1 = findViewById(2131385018);
        if (r1 == null) goto L15;
        r1.setAdapter(new TargetListAdapter(this));
    L15:
        RecyclerView r2 = findViewById(2131385018);
        if (r2 == null) goto L18;
        r2.setLayoutManager(new SSGridLayoutManager(getContext(), 3));
    L18:
        RecyclerView r3 = findViewById(2131385018);
        if (r3 == null) goto L21;
        r3.setItemAnimator(null);
    L21:
        RecyclerView r9 = findViewById(2131385018);
        if (r9 == null) goto L25;
        r9.addItemDecoration(new SelfDisciplineTargetDialog$init$3());
        return;
    L25:
        return;
    L11:
        r0 = getContext().getResources().getString(2131922429);
        goto L12
    }

    public SelfDisciplineTargetDialog(Context r2, String r3, List r4, SelfDisciplineManageDialog$mSelectTargetCallback$2.a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = r4;
        this.c = r5;
        this.a = r3;
    }
}
