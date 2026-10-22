package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.message.model.l4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/FansClubTrigger;", "Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/FeedbackMsgTrigger;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubTrigger extends FeedbackMsgTrigger {
    public final TriggerId f;
    public final List<Integer> g;

    @Override // fx1.e
    public final TriggerId getId() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final List<Integer> h() {
        return this.g;
    }

    public FansClubTrigger(DataCenter r1) {
        super(r1);
        this.f = TriggerId.FANS_CLUB;
        this.g = CollectionsKt.listOf(Integer.valueOf(MessageType.FANS_CLUB.getIntType()));
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final void i(tlc.d r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if ((r5 instanceof l4) == false) goto L23;
        l4 r6 = (l4) r5;
        if (r6 == null) goto L25;
        User r0 = r6.getUser();
        if (r0 == null) goto L10;
        String r1 = r0.getIdString();
    L12:
        if (Intrinsics.areEqual(r1, k.n(IUserService.class).user().n()) == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == true) goto L20;
        r6 = null;
    L20:
        if (r6 == null) goto L24;
        d("on action：加入粉丝团", new Pair[0]);
        ALogger.d(this.a, "on action：加入粉丝团");
        e(fx1.c.f(5));
        return;
    L24:
        return;
    L14:
        if (r6.getAction() != 2) goto L16;
        r2 = true;
        goto L17
    L10:
        r1 = null;
        goto L12
    L25:
        return;
    }
}
