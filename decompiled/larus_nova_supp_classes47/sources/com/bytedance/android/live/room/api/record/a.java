package com.bytedance.android.live.room.api.record;

import android.media.MediaMetadataRetriever;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.record.api.RecordPublishApi;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LiveRecordMonitorServiceWidget a;

    public a(LiveRecordMonitorServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        String r14 = (String) r13;
        LiveRecordMonitorServiceWidget r0 = this.a;
        LiveRecordMonitorContext r1 = r0.wq();
        boolean r2 = false;
        if (r1 == null) goto L5;
        r1.markRecordStared(false);
    L5:
        LiveRecordMonitorContext r3 = r0.wq();
        if (r3 == null) goto L8;
        r3.ignoreThisRecord(true);
    L8:
        int r4 = f.a;
        Intrinsics.checkNotNullParameter(r14, "videoPath");
        MediaMetadataRetriever r7 = null;
        String r8 = null;
        if (FileUtils.isFileEmpty(r14) == false) goto L80;
    L38:
        long r10 = 0;
    L40:
        if (r10 > 0) goto L42;
        r2 = true;
    L42:
        if (r2 == false) goto L44;
        ALogger.i(r0.a, "video duration is invalid, duration=" + r10);
        return;
    L44:
        JSONObject r5 = new JSONObject();
        IRoom r6 = gb2.a.e(((Widget) r0).dataCenter);
        int r9 = k.n(IMiddleWareHostContext.class).liveId();
        IMiddleWareHostContext r12 = k.f(IMiddleWareHostContext.class);
        if (r12 == null) goto L47;
        r8 = r12.getServerDeviceId();
    L47:
        r5.put("live_id", String.valueOf(r9));
        r5.put("room_id", r6.getIdStr());
        r5.put("user_id", r6.getOwnerUserIdString());
        r5.put("device_id", String.valueOf(r8));
        r5.put("scene", "user");
        RecordPublishApi.a.getClass();
        RecordPublishApi r15 = (RecordPublishApi) com.bytedance.android.live.network.c.b().e(RecordPublishApi.class);
        if (r15 == null) goto L83;
        Observable<Response<com.bytedance.android.live.room.api.record.api.a>> r16 = r15.pinHighlightReview("webcast_comment_highlight", r5.toString(), "");
        if (r16 == null) goto L84;
        Observable r17 = r16.flatMap(new b(r0, r14, r6));
        if (r17 == null) goto L85;
        Observable r18 = r17.subscribeOn(Schedulers.io());
        if (r18 == null) goto L86;
        Observable r19 = RxUtilKt.h(r18);
        if (r19 == null) goto L87;
        Disposable r110 = r19.subscribe(new c(r0, r14), new d(r0));
        if (r110 == null) goto L88;
        com.bytedance.revenue.platform.api.core.rx.f.a(r110, r0.f);
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L80:
        MediaMetadataRetriever r20 = new MediaMetadataRetriever();     // Catch: Throwable -> L27 Exception -> L29
        r20.setDataSource(r14);     // Catch: Throwable -> L23 Exception -> L25
        String r111 = f.a(r20);     // Catch: Throwable -> L23 Exception -> L25
        if (r111 == null) goto L18;
        Long r112 = StringsKt.toLongOrNull(r111);     // Catch: Throwable -> L23 Exception -> L25
        if (r112 == null) goto L18;
        r10 = r112.longValue();     // Catch: Throwable -> L23 Exception -> L25
    L70:
        r20.release();     // Catch: Exception -> L21
    L21:
        e = e;
        StringBuilder r22 = new StringBuilder("释放资源失败: ");
    L37:
        r22.append(e.getMessage());
        ALogger.w("SRMonitorUtils", r22.toString());
        goto L40
    L18:
        r10 = 0;
    L25:
        Exception e = e;
    L76:
        ALogger.e("SRMonitorUtils", "获取视频时长失败: " + e.getMessage());     // Catch: Throwable -> L61
        if (r20 == null) goto L38;
        r20.release();     // Catch: Exception -> L35
    L35:
        e = e;
        r22 = new StringBuilder("释放资源失败: ");
        r10 = 0;
    L61:
        th = th;
        r7 = r20;
    L63:
        r20 = r7;
    L64:
        if (r20 != null) goto L74;
    L69:
        throw th;
    L74:
        r20.release();     // Catch: Exception -> L67
    L67:
        e = move-exception;
        ALogger.w("SRMonitorUtils", "释放资源失败: " + e.getMessage());
    L23:
        th = th;
        goto L64
    L29:
        e = move-exception;
        e = e;
        r20 = null;
    L27:
        th = th;
        goto L63
    }
}
