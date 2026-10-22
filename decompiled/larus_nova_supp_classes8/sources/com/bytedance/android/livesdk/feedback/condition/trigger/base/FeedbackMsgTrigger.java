package com.bytedance.android.livesdk.feedback.condition.trigger.base;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fx1.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/FeedbackMsgTrigger;", "Lfx1/d;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class FeedbackMsgTrigger extends d implements l, Observer<KVData> {
    public vlc.d d;
    public final DataCenter e;

    public List<String> g() {
        return null;
    }

    public abstract List<Integer> h();

    public abstract void i(tlc.d r1);

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        DataCenter r0 = this.e;
        vlc.d r2 = null;
        if (r0 == null) goto L5;
        r2 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.d = r2;
        if (r2 == null) goto L8;
        j(r2);
        return;
    L8:
        DataCenter r1 = this.e;
        if (r1 == null) goto L13;
        r1.observe("data_message_manager", this);
        return;
    }

    @Override // fx1.c, fx1.e
    public final void reset() {
        super.reset();
        vlc.d r0 = this.d;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public FeedbackMsgTrigger(DataCenter r1) {
        this.e = r1;
    }

    public final void j(vlc.d r3) {
        Iterator<T> r0 = h().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.addMessageListener(((Number) r0.next()).intValue(), this);
        goto L4
    L6:
        List<String> r1 = g();
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        r3.addMessageListener((String) r2.next(), this);
        goto L10
    L15:
        return;
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
        if (r0.equals("data_message_manager") == false) goto L18;
        vlc.d r6 = (vlc.d) r5.getData();
        if (r6 == null) goto L21;
        this.d = r6;
        j(r6);
        return;
    L21:
        return;
    L18:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(tlc.d r1) {
        if (r1 == null) goto L5;
        i(r1);
        return;
    }
}
