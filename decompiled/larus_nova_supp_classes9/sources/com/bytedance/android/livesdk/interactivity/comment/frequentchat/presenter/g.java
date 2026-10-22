package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ FrequentChatPresenter a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c b;

    public g(FrequentChatPresenter r1, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Response r5 = (Response) r4;
        if (((BaseResponse) r5).statusCode != 0) goto L17;
        List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> r6 = this.a.c;
        ArrayList r7 = (ArrayList) r6;
        int r8 = r7.indexOf(this.b);
        if (r8 < 0) goto L9;
        List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> r0 = this.a.c;
        ArrayList r1 = (ArrayList) r0;
        r1.remove(this.b);
        this.a.d.notifyItemRemoved(r8);
        if (r8 == ((ArrayList) this.a.c).size()) goto L9;
        FrequentChatPresenter r2 = this.a;
        r2.d.notifyItemRangeChanged(r8, ((ArrayList) r2.c).size() - r8);
    L9:
        f2.b(2131897047, 0);
        if (this.a.c0() <= 0) goto L14;
        FrequentChatPresenter.a r9 = (FrequentChatPresenter.a) ((q46.b) this.a).a;
        if (r9 == null) goto L18;
        r9.Cg();
    L18:
        this.a.k = false;
        return;
    L14:
        FrequentChatPresenter.a r10 = (FrequentChatPresenter.a) ((q46.b) this.a).a;
        if (r10 == null) goto L18;
        r10.Ih();
        goto L18
    L17:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.b("remove", r5);
        goto L18
    }
}
