package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p62.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/ChannelTrayDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelTrayDiffCallback extends DiffUtil.Callback {
    public final List<a> a;
    public final List<a> b;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public ChannelTrayDiffCallback(List<a> r2, List<a> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldDatas");
        Intrinsics.checkNotNullParameter(r3, "newDatas");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r5, int r6) {
        a r7 = (a) ListProtector.get(this.a, r5);
        a r8 = (a) ListProtector.get(this.b, r6);
        if (r7.l != r8.l) goto L5;
        boolean r0 = true;
    L7:
        if (r7.k != r8.k) goto L9;
        boolean r9 = true;
    L10:
        if (r0 == false) goto L13;
        if (r9 == false) goto L13;
        return true;
    L13:
        return false;
    L9:
        r9 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public final boolean areItemsTheSame(int r4, int r5) {
        a r6 = (a) ListProtector.get(this.a, r4);
        a r7 = (a) ListProtector.get(this.b, r5);
        if (r6.c != r7.c) goto L5;
        return true;
    L5:
        return false;
    }
}
