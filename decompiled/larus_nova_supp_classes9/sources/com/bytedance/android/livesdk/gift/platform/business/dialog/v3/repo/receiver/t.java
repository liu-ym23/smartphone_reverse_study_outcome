package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ BehaviorSubject a;
    public final /* synthetic */ com.bytedance.android.scope.j b;
    public final /* synthetic */ DataCenter c;

    public t(BehaviorSubject r1, i12.e r2, DataCenter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L5;
        String r5 = r4.getKey();
    L7:
        if (Intrinsics.areEqual(r5, "data_link_state") == false) goto L10;
        this.a.onNext(Integer.valueOf(v.a(this.b, this.c)));
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
