package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.pin.business.comment.api.ChatHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.comment.api.PinCommentApi;
import com.bytedance.android.livesdk.interactivity.pin.ui.PinAndQARemoveDialog;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightContainerSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g42.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements PinAndQARemoveDialog.a {
    public final /* synthetic */ PinContainerHighlightProcessor a;
    public final /* synthetic */ Function0 b;

    @Override // com.bytedance.android.livesdk.interactivity.pin.ui.PinAndQARemoveDialog.a
    public final void a() {
        PinContainerHighlightProcessor r6 = this.a;
        r6.getClass();
        o32.a.a("removeAllPinItems");
        ChatHighlightRequest r0 = new ChatHighlightRequest();
        r0.actionType = 4;
        DataCenter r1 = r6.getDataCenter();
        if (r1 == null) goto L7;
        Room r2 = z.o(r1);
        if (r2 == null) goto L7;
        long r4 = r2.getRoomId();
    L8:
        r0.roomId = r4;
        r0.scene = "comment_highlight";
        dc2.c<HighlightContainerSyncData> r3 = r6.v();
        if (r3 == null) goto L15;
        HighlightContainerSyncData r5 = r3.c();
        if (r5 == null) goto L15;
        List r7 = r5.getHighlightItems();
        if (r7 == null) goto L15;
        ArrayList r8 = new ArrayList(r7);
    L16:
        l r9 = new l(PinType.All, new Object(), 0);
        long r10 = System.currentTimeMillis();
        PinCommentApi.a.getClass();
        RxUtilKt.c(((PinCommentApi) com.bytedance.android.live.network.c.b().e(PinCommentApi.class)).pin(r0.toRequestFieldMap()).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r6, r9, r10, r8), new f(r6, r9, r10)), r6.e);
        return;
    L15:
        r8 = null;
    L7:
        r4 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.pin.ui.PinAndQARemoveDialog.a
    public final void b() {
        this.b.invoke();
    }

    public g(PinContainerHighlightProcessor r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
