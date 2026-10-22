package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HistorySecretChatListAdapter;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i1<T> implements Consumer {
    public final /* synthetic */ k1.a a;

    public i1(k1.a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        List<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.n> r5 = ((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.i) ((BaseResponse) ((Response) r4)).data).a();
        if (r5 == null) goto L10;
        List<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.n> r0 = r5;
        if ((!r0.isEmpty()) == false) goto L11;
        HistorySecretChatListAdapter r1 = this.a.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        ((ArrayList) r1.a).clear();
        ((ArrayList) r1.a).addAll(r0);
        r1.notifyDataSetChanged();
        RecyclerView r6 = this.a.e;
        if (r6 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r6);
        return;
    L12:
        return;
    L11:
        return;
    }
}
