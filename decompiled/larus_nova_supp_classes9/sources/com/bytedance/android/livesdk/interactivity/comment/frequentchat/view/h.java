package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ FrequentChatSecondaryFragment a;
    public final /* synthetic */ String b;

    public h(FrequentChatSecondaryFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Response r6 = (Response) r5;
        if (((BaseResponse) r6).statusCode != 0) goto L5;
        this.a.z.g(((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.a) ((BaseResponse) r6).data).a(), this.b);
        FrequentChatSecondaryFragment.U90(this.a);
        f2.c(s1.B(2131897052), 0);
        int r7 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_saved", Boolean.valueOf(this.a.y.k0()), MapsKt.mapOf(TuplesKt.to("edit_status", "first")));
    L6:
        this.a.z.p(false);
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.b("add", r6);
        goto L6
    }
}
