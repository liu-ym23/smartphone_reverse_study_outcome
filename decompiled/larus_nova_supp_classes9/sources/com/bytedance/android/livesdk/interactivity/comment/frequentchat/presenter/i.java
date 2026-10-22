package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ FrequentChatPresenter a;
    public final /* synthetic */ String b;

    public i(FrequentChatPresenter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        if (((BaseResponse) r4).statusCode != 0) goto L12;
        FrequentChatPresenter.a r5 = (FrequentChatPresenter.a) ((q46.b) this.a).a;
        if (r5 == null) goto L7;
        r5.Ih();
    L7:
        int r6 = !Intrinsics.areEqual(this.a.i, this.b) ? 1 : 0;
        int r0 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.a.h;
        if (r1 == null) goto L10;
        Boolean r2 = Boolean.valueOf(r1.k0());
    L11:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_rank_complete", r2, MapsKt.mapOf(TuplesKt.to("is_rerank", String.valueOf(r6))));
    L13:
        this.a.k = false;
        return;
    L10:
        r2 = null;
        goto L11
    L12:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.b("sort", r4);
        goto L13
    }
}
