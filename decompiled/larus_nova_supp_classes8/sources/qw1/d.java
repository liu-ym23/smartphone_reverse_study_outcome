package qw1;

import android.os.Message;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.feed.preview.roomdetector.RoomRetrofitApi;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdkapi.ping.PingResult;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements WeakHandler.IHandler {
    public final WeakHandler a;
    public final long b;
    public final a c;
    public boolean d;
    public final Gson e;
    public long f;

    public interface a {
    }

    public final void a() {
        if (this.d == false) goto L19;
        qw1.a r0 = ((e) this.c).b;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L19;
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendPlayingPing(this.b, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        long r2 = this.f;
        if (r2 > 0) goto L15;
        return;
    L15:
        if (r2 < ((Integer) LiveFeedSettings.AUDIENCE_PING_INTERVAL.getValue()).intValue()) goto L24;
        this.a.sendMessageDelayed(this.a.obtainMessage(8), this.f * 1000);
        return;
    L24:
        return;
    L7:
        if (r0.onPingCheck() == false) goto L9;
        r1 = true;
    L19:
        if (this.d == false) goto L25;
        this.d = false;
        this.a.removeCallbacksAndMessages(null);
        return;
    }

    public final void handleMsg(Message r7) {
        boolean r0 = this.d;
        if (r0 == true) goto L5;
        return;
    L5:
        int r1 = r7.what;
        if (r1 != 7) goto L8;
        Object r8 = r7.obj;
        if (r0 == true) goto L15;
        return;
    L15:
        if ((r8 instanceof ApiServerException) == false) goto L32;
        int r9 = ((ApiServerException) r8).getErrorCode();
        Logger.d("LivePingController", "ping replay api exception, error code: " + r9);
        if (30001 != r9) goto L19;
    L28:
        qw1.a r10 = ((e) this.c).b;
        if (r10 == null) goto L50;
        r10.b();
        return;
    L50:
        return;
    L19:
        if (30003 == r9) goto L28;
        if (30004 == r9) goto L28;
        if (50002 != r9) goto L47;
        qw1.a r11 = ((e) this.c).b;
        if (r11 == null) goto L48;
        r11.onUserNotInRoom();
        return;
    L48:
        return;
    L47:
        return;
    L32:
        if ((r8 instanceof PingResult) == false) goto L52;
        long r2 = System.currentTimeMillis();
        ALogger.json(4, "pingresult", GsonProtectorUtils.toJson(this.e, r8));
        ALogger.i("pingresultCostTime", String.valueOf(System.currentTimeMillis() - r2));
        PingResult r12 = (PingResult) r8;
        this.f = r12.getNextPingInterval();
        if (4 != r12.getRoomStatus()) goto L41;
        if (r12.getRoomId() != this.b) goto L41;
        qw1.a r13 = ((e) this.c).b;
        if (r13 == null) goto L53;
        r13.onRoomFinished();
        return;
    L53:
        return;
    L41:
        if (r12.getMosaicStatus() == 0) goto L55;
        a r3 = this.c;
        r12.getRoomId();
        long r4 = r12.getMosaicStatus();
        qw1.a r14 = ((e) r3).b;
        if (r14 == null) goto L56;
        r14.a(r4);
        return;
    L56:
        return;
    L55:
        return;
    L52:
        return;
    L8:
        if (r1 != 8) goto L57;
        a();
        return;
    }

    public d(long r3, a r5) {
        this.a = new WeakHandler(this);
        this.d = false;
        this.f = ((Integer) LiveFeedSettings.AUDIENCE_PING_INTERVAL.getValue()).intValue();
        this.b = r3;
        this.c = r5;
        this.e = LiveGsonHelper.get();
    }
}
