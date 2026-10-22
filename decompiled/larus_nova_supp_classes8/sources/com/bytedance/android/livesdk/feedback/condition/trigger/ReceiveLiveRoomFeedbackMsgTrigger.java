package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.message.model.o4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/ReceiveLiveRoomFeedbackMsgTrigger;", "Lfx1/c;", "Lcom/bytedance/android/livesdk/message/model/o4;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReceiveLiveRoomFeedbackMsgTrigger extends fx1.c<o4> implements l, Observer<KVData> {
    public final List<Integer> d;
    public final TriggerId e;
    public vlc.d f;
    public final DataCenter g;

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        DataCenter r0 = this.g;
        vlc.d r2 = null;
        if (r0 == null) goto L5;
        r2 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.f = r2;
        if (r2 == null) goto L13;
        Iterator<T> r1 = this.d.iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        int r3 = ((Number) r1.next()).intValue();
        vlc.d r4 = this.f;
        if (r4 == null) goto L9;
        r4.addMessageListener(r3, this);
        goto L9
    L23:
        return;
    L13:
        DataCenter r5 = this.g;
        if (r5 == null) goto L22;
        r5.observe("data_message_manager", this);
        return;
    }

    @Override // fx1.c, fx1.e
    public final void reset() {
        super.reset();
        vlc.d r0 = this.f;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.e;
    }

    public ReceiveLiveRoomFeedbackMsgTrigger(DataCenter r1) {
        this.g = r1;
        this.d = CollectionsKt.listOf(Integer.valueOf(MessageType.FEEDBACK_CARD_MESSAGE.getIntType()));
        this.e = TriggerId.RECEIVE_LIVE_ROOM_FEEDBACK_MSG;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1434292000)) goto L12;
        return;
    L12:
        if (r0.equals("data_message_manager") == false) goto L22;
        vlc.d r6 = (vlc.d) r5.getData();
        if (r6 == null) goto L30;
        this.f = r6;
        Iterator<T> r7 = this.d.iterator();
    L18:
        if (r7.hasNext() == false) goto L31;
        int r1 = ((Number) r7.next()).intValue();
        vlc.d r2 = this.f;
        if (r2 == null) goto L18;
        r2.addMessageListener(r1, this);
        goto L18
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(tlc.d r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((r2 instanceof o4) == false) goto L8;
        e(r2);
        return;
    }
}
