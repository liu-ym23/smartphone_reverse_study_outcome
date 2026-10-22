package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/TabFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TabFragment extends BaseFragment {
    public PkItemExposeRecyclerView d;
    public MultiTypeAdapter e;
    public q21.d.b f;
    public final me.drakeet.multitype.e g;

    public TabFragment(me.drakeet.multitype.e r2) {
        Intrinsics.checkNotNullParameter(r2, "typePool");
        this.g = r2;
    }

    public final void S90(q21.d.b r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        this.f = r2;
        MultiTypeAdapter r0 = this.e;
        if (r0 == null) goto L9;
        if (r2 == null) goto L7;
        List<Object> r3 = r2.b;
        if (r3 == null) goto L7;
    L8:
        r0.A2(r3);
    L7:
        r3 = CollectionsKt.emptyList();
    L9:
        MultiTypeAdapter r4 = this.e;
        if (r4 == null) goto L13;
        r4.notifyDataSetChanged();
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        PkItemExposeRecyclerView r4 = (PkItemExposeRecyclerView) r2.findViewById(2131384076);
        this.d = r4;
        if (r4 == null) goto L5;
        r4.setInviteIconPanelType("anchor");
    L5:
        PkItemExposeRecyclerView r5 = this.d;
        if (r5 == null) goto L8;
        r5.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        PkItemExposeRecyclerView r6 = this.d;
        if (r6 == null) goto L11;
        r6.setDisableScrollTouch(true);
    L11:
        MultiTypeAdapter r7 = new MultiTypeAdapter();
        this.e = r7;
        r7.b = this.g;
        q21.d.b r8 = this.f;
        if (r8 == null) goto L15;
        List<Object> r9 = r8.b;
        if (r9 == null) goto L15;
    L16:
        r7.A2(r9);
        PkItemExposeRecyclerView r10 = this.d;
        if (r10 == null) goto L19;
        r10.setAdapter(this.e);
    L19:
        MultiTypeAdapter r12 = this.e;
        if (r12 == null) goto L23;
        r12.notifyDataSetChanged();
        return;
    L23:
        return;
    L15:
        r9 = CollectionsKt.emptyList();
        goto L16
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566032, r3, false);
    }
}
