package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ RoomCreateInfo.p.a a;
    public final /* synthetic */ Room b;

    public l(RoomCreateInfo.p.a r1, Room r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        Response r12 = (Response) r11;
        Map<String, Pair<Integer, Integer>> r0 = AnchorVideoResolutionManager.a;
        RoomCreateInfo.p.a r1 = AnchorVideoResolutionManager.f(((AnchorResolutionInfo) ((BaseResponse) r12).data).getKey());
        String r2 = ((AnchorResolutionInfo) ((BaseResponse) r12).data).getKey();
        if (r1 != null) goto L6;
        AnchorVideoResolutionManager.h("changeResolutionBySelectedResolutionButton failed : local no resolution for " + r2);
        return;
    L6:
        if (Intrinsics.areEqual(((AnchorResolutionInfo) ((BaseResponse) r12).data).getKey(), AnchorVideoResolutionManager.c) == false) goto L9;
        AnchorVideoResolutionManager.h("changeResolutionBySelectedResolutionButton failed : cannot change to same resolution -> " + r2);
        return;
    L9:
        if ((!Intrinsics.areEqual((String) ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt().getValue(), this.a.text)) == false) goto L11;
        f2.c("已切换到" + ((String) CollectionsKt.firstOrNull(StringsKt.split$default(this.a.text, new String[]{" "}, false, 0, 6, null))), 0);
    L11:
        Intrinsics.checkNotNullParameter(((AnchorResolutionInfo) ((BaseResponse) r12).data).getSdkParams(), "<set-?>");
        AnchorVideoResolutionManager.k(r2);
        AnchorVideoResolutionManager.a(AnchorVideoResolutionManager.c);
        String r3 = AnchorVideoResolutionManager.c;
        String r4 = ((BaseResponse) r12).logId;
        Boolean r5 = Boolean.valueOf(((AnchorResolutionInfo) ((BaseResponse) r12).data).isDownGrade());
        String r6 = ((AnchorResolutionInfo) ((BaseResponse) r12).data).getKey();
        String r13 = ((AnchorResolutionInfo) ((BaseResponse) r12).data).getSdkParams();
        String r7 = this.b.getIdStr();
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        int r8 = l00.a.a;
        Intrinsics.checkNotNullParameter("change_resolution", "method");
        NewBroadcastMonitor.a r9 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_CLARITY_CHANGE, null, null, 14);
        r9.l(0);
        r9.c("change_resolution");
        r9.d(r3);
        r9.i(r3, "清晰度切换途径");
        r9.i(r3, "选择的清晰度");
        r9.i("log_id", r4);
        r9.i("wnableDowngrade", r5);
        r9.i("key", r6);
        r9.i("sdkParams", r13);
        r9.i("room_id", r7);
        r9.a().report();
        AnchorVideoResolutionManager.i(this.b);
        xs2.b.a().post(new AnchorVideoResolutionManager.a());
    }
}
