package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RoomParamsLotteryPlugin implements n {
    public final k a;

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    public RoomParamsLotteryPlugin(k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.live.profit.lottery.plugin.RoomParamsLotteryPlugin$appendUrlParams$1] */
    @Override // com.bytedance.android.live.profit.lottery.n
    public final void b(final Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "extra");
        ?? r0 = new RoomParamsLotteryPlugin$appendUrlParams$1(r6);
        IRoom r1 = this.a.getRoom();
        r0.invoke(r1.getId(), "room_id");
        String r2 = r1.getAnchorId();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r6.put("anchor_id", r2);
        String r3 = (String) this.a.getDataCenter().get("preview_extend_guide_text_function", "");
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        r6.put("lottery_from_source", "preview_guide");
        r6.put("guide_text", r3);
    L14:
        this.a.getDataCenter().put("preview_extend_guide_text_function", "");
        return;
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final boolean c(g r2) {
        Intrinsics.checkNotNullParameter(r2, "lottery");
        Intrinsics.checkNotNullParameter(r2, "lottery");
        return false;
    }
}
