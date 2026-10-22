package ej0;

import com.bytedance.android.live.liveinteract.plantform.model.y0;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.i1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ PaidProfileCardControlPresenter a;

    public a(PaidProfileCardControlPresenter r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r3) {
        e r4 = (e) r3;
        if (r4 == null) goto L13;
        y0 r5 = (y0) r4.data;
        if (r5 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r5.needShow, Boolean.TRUE) == false) goto L14;
        i1 r6 = r5.explainCardInfo;
        if (r6 == null) goto L15;
        PaidProfileCardControlPresenter r0 = this.a;
        int r1 = PaidProfileCardControlPresenter.h;
        r0.i0(r6);
        return;
    L15:
        return;
    L14:
        return;
    }
}
