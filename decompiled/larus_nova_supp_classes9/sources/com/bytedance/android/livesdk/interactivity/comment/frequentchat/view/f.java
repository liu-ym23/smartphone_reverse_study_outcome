package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ FrequentChatSecondaryFragment a;
    public final /* synthetic */ RecyclerView b;

    public f(FrequentChatSecondaryFragment r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        if (((BaseResponse) r4).statusCode == 0) goto L5;
        return;
    L5:
        if (((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.e) ((BaseResponse) r4).data).a() == null) goto L12;
        List<String> r0 = this.a.r;
        ArrayList r1 = (ArrayList) r0;
        r1.addAll(((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.e) ((BaseResponse) r4).data).a());
        if (((ArrayList) this.a.r).size() <= 0) goto L20;
        View r5 = this.a.p;
        if (r5 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r5);
    L11:
        UtilityKotlinExtentionsKt.w(this.b);
        int r6 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_recommend_show", Boolean.valueOf(this.a.y.k0()), MapsKt.mapOf(TuplesKt.to("recommend_comment_num", String.valueOf(((ArrayList) this.a.r).size()))));
        return;
    L20:
        return;
    L12:
        int r2 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.a;
        Intrinsics.checkNotNullParameter("recommend", "scene");
        Intrinsics.checkNotNullParameter(r4, "response");
        StringBuilder r7 = new StringBuilder("recommend status code error, ");
        RequestError r8 = ((BaseResponse) r4).error;
        if (r8 == null) goto L16;
        String r9 = r8.prompts;
        if (r9 == null) goto L16;
    L17:
        r7.append(r9);
        r7.append(", log id: ");
        r7.append(((BaseResponse) r4).logId);
        ALogger.e("FrequentChatApi", r7.toString());
        return;
    L16:
        r9 = BuildConfig.FLAVOR;
        goto L17
    }
}
