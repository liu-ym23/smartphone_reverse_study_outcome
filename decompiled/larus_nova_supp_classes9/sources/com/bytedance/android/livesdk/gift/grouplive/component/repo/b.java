package com.bytedance.android.livesdk.gift.grouplive.component.repo;

import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentDataStore;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ GroupComponentRepo a;

    public b(GroupComponentRepo r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        GroupComponentDataStore r0 = this.a.e;
        r0.S((List) r2);
    }
}
