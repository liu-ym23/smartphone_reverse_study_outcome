package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PayGradeChange;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o0<T> implements Consumer {
    public final /* synthetic */ p0 a;

    public o0(p0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.d.a(new PayGradeChange((PayGrade) r3));
    }
}
