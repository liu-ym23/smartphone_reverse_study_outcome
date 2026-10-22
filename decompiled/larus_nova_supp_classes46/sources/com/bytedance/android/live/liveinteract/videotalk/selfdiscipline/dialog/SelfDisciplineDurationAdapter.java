package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineDurationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineDurationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean a;
    public final List<Integer> b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size() + 2;
    }

    public final int getItemViewType(int r3) {
        if (r3 != 0) goto L4;
        return 0;
    L4:
        int r0 = this.b.size();
        if (1 > r3) goto L9;
        if (r0 < r3) goto L9;
        return 1;
    L9:
        return 2;
    }

    public SelfDisciplineDurationAdapter(List<Integer> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "durationList");
        this.b = r2;
        this.c = r3;
        this.a = true;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof DurationViewHolder) == false) goto L13;
        DurationViewHolder r6 = (DurationViewHolder) r4;
        int r7 = r5 - 1;
        int r0 = ((Number) ListProtector.get(this.b, r7)).intValue();
        r6.b = r0;
        r6.a.setText(com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.a.a(r0));
        r6.a.setTextColor(ColorProtector.parseColor("#80161823"));
        if (this.a == true) goto L7;
        return;
    L7:
        if (((Number) ListProtector.get(this.b, r7)).intValue() != this.c) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == false) goto L15;
        r6.T3(true);
        this.a = false;
        return;
    L15:
        return;
    L9:
        r8 = false;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 0) goto L5;
        View r5 = new View(r3.getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(48.0f)));
        return new EmptyViewHolder(r5);
    L5:
        if (r4 == 1) goto L11;
        View r6 = new View(r3.getContext());
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(81.0f)));
        return new EmptyViewHolder(r6);
    L11:
        return new DurationViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131566268, r3, false));
    }
}
