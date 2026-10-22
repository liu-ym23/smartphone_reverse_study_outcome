package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ BehaviorSubject a;

    public u(BehaviorSubject r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L5;
        String r0 = r4.getKey();
    L7:
        if (Intrinsics.areEqual(r0, "data_online_changed_list") == false) goto L15;
        BehaviorSubject r1 = this.a;
        if (r4 == null) goto L12;
        List r5 = (List) r4.getData();
        if (r5 == null) goto L12;
    L13:
        r1.onNext(r5);
        return;
    L12:
        r5 = CollectionsKt.emptyList();
        goto L13
    L15:
        return;
    L5:
        r0 = null;
        goto L7
    }
}
