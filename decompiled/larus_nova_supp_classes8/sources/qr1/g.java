package qr1;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements Observer<Boolean> {
    public final /* synthetic */ i a;

    public g(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        if (Boolean.TRUE.equals((Boolean) r10) == false) goto L20;
        i r11 = this.a;
        r11.f.a = true;
        APMEvent.Level r0 = APMEvent.Level.I;
        r11.c(com.bytedance.android.live.livepullstream.api.apm.a.c(r0, "init room; hashcode=" + this.a.hashCode(), "timeout config=" + this.a.e.enterRoomTimeout));
        i r12 = this.a;
        if (r12.e.enterRoomTimeout <= 0) goto L7;
        WeakHandler r13 = r12.p;
        r13.sendMessageDelayed(Message.obtain(r13, 2), this.a.e.enterRoomTimeout);
    L7:
        Bundle r14 = this.a.g;
        if (r14 == null) goto L21;
        String r1 = r14.getString("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_TYPE", "");
        this.a.d("type", r1);
        this.a.a("enter_type", r1);
        long r2 = r14.getLong("live.intent.extra.EXTRA_FEED_REQUEST_START_TIME");
        long r3 = r14.getLong("live.intent.extra.EXTRA_FEED_REQUEST_END_TIME");
        if (r3 > 0) goto L12;
    L14:
        long r4 = r14.getLong("live.intent.extra.EXTRA_BEGIN_START_ACTIVITY_TIME");
        long r5 = r14.getLong("live.intent.extra.EXTRA_ACTIVITY_ON_CREATE_TIME");
        if (r4 > 0) goto L17;
        return;
    L17:
        if (r5 <= 0) goto L23;
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r0, "activity_start_open", r4));
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r0, "activity_created", r5));
        this.a.e("start_activity", r5 - r4);
        return;
    L23:
        return;
    L12:
        if (r2 <= 0) goto L14;
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r0, "request_feed_start", r2));
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r0, "request_feed_finish", r3));
        this.a.e("load_feed", r3 - r2);
        goto L14
    L21:
        return;
    }
}
