package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/LiveEndTrigger;", "Lfx1/c;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEndTrigger extends fx1.c<Object> implements Observer<KVData> {
    public final TriggerId d;
    public final DataCenter e;

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        DataCenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.observe("cmd_on_live_end_fragment_show", this);
        return;
    }

    @Override // fx1.c, fx1.e
    public final void reset() {
        super.reset();
        DataCenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }

    public LiveEndTrigger(DataCenter r1) {
        this.e = r1;
        this.d = TriggerId.LIVE_END;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r6 = r5.getKey();
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.hashCode() == (-170252752)) goto L12;
        return;
    L12:
        if (r6.equals("cmd_on_live_end_fragment_show") == false) goto L21;
        Pair<String, ? extends Object>[] r7 = new Pair[1];
        DataCenter r1 = this.e;
        if (r1 == null) goto L18;
        Room r2 = z.o(r1);
        if (r2 == null) goto L18;
        String r3 = r2.getIdStr();
    L19:
        r7[0] = TuplesKt.to("roomId", r3);
        d("on action：关播", r7);
        ALogger.d(this.a, "on action：关播");
        e(null);
        return;
    L18:
        r3 = null;
        goto L19
    L21:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
