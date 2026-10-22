package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.chatroom.ui.UserFeatureLabelListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements wr1.f {
    public final UserFeatureLabelListAdapter a;

    public r() {
        this.a = new UserFeatureLabelListAdapter();
    }

    @Override // wr1.f
    public final UserFeatureLabelListAdapter getAdapter() {
        return this.a;
    }

    @Override // wr1.f
    public final void a(bm1.e r2) {
        this.a.b = r2;
    }

    @Override // wr1.f
    public final void setData(List<? extends py.k> r5) {
        Intrinsics.checkNotNullParameter(r5, "imageModels");
        UserFeatureLabelListAdapter r0 = this.a;
        List<? extends py.k> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r1.add((ImageModel) com.bytedance.android.live.base.model.m.b((py.k) r7.next(), ImageModel.class));
        goto L4
    L6:
        r0.setData(r1);
    }
}
