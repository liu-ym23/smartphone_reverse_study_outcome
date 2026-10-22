package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityTextViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.RequestViewHolder;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.SchemaViewHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ga2.d;
import ia2.a;
import ia2.b;
import ia2.e;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/QuickAbilityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityBaseViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QuickAbilityAdapter extends RecyclerView.Adapter<QuickAbilityBaseViewHolder> {
    public final a a;
    public final List<b> b;

    public final int getItemCount() {
        return this.b.size();
    }

    public final int getItemViewType(int r3) {
        b r0 = (b) CollectionsKt.getOrNull(this.b, r3);
        if (r0 == null) goto L8;
        Ability r1 = r0.a;
        if (r1 == null) goto L8;
        return (int) r1.getType();
    L8:
        return super.getItemViewType(r3);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        QuickAbilityBaseViewHolder r3 = (QuickAbilityBaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        a r0 = r3.a;
        if (r0 == null) goto L7;
        WeakReference<DataCenter> r1 = r0.getDataCenter();
        if (r1 == null) goto L7;
        DataCenter r4 = r1.get();
    L8:
        r3.T3(r4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public QuickAbilityAdapter(e r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "quickAbilityManager");
        Intrinsics.checkNotNullParameter(r3, "items");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        QuickAbilityBaseViewHolder r4 = (QuickAbilityBaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        b r0 = (b) CollectionsKt.getOrNull(this.b, r3);
        if (r0 != null) goto L5;
        int r5 = d.a;
        String r6 = "QuickAbilityAdapter.onBindViewHolder get item null,  index = " + r3 + ", itemSize = " + this.b.size();
        Intrinsics.checkNotNullParameter(r6, "msg");
        ALogger.e("PSSelectedAiAgent", r6);
        return;
    L5:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "data");
        r4.b = r0;
        r4.U3(r0);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 1) goto L5;
        int r5 = QuickAbilityTextViewHolder.f;
        QuickAbilityBaseViewHolder r6 = new SchemaViewHolder(QuickAbilityTextViewHolder.a.a(r3));
    L13:
        a r7 = this.a;
        Intrinsics.checkNotNullParameter(r7, "quickAbilityManager");
        r6.a = r7;
        return r6;
    L5:
        if (r4 != 2) goto L7;
        int r8 = QuickAbilityTextViewHolder.f;
        r6 = new RequestViewHolder(QuickAbilityTextViewHolder.a.a(r3));
        goto L13
    L7:
        if (v.b() == true) goto L10;
        int r0 = d.a;
        String r9 = "Unknown view type: " + r4;
        Intrinsics.checkNotNullParameter(r9, "msg");
        ALogger.e("PSSelectedAiAgent", r9);
        int r10 = QuickAbilityTextViewHolder.f;
        r6 = new QuickAbilityTextViewHolder(QuickAbilityTextViewHolder.a.a(r3));
        goto L13
    L10:
        throw new IllegalArgumentException("Unknown view type: " + r4);
    }
}
