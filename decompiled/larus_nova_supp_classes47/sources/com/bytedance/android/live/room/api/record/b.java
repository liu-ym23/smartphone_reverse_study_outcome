package com.bytedance.android.live.room.api.record;

import android.content.Context;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ LiveRecordMonitorServiceWidget a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IRoom c;

    public b(LiveRecordMonitorServiceWidget r1, String r2, IRoom r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r12) {
        Response r13 = (Response) r12;
        Intrinsics.checkNotNullParameter(r13, "res");
        com.bytedance.android.live.room.api.record.api.a r14 = (com.bytedance.android.live.room.api.record.api.a) ((BaseResponse) r13).data;
        if (r14 == null) goto L30;
        if (r14.a() != true) goto L30;
        LiveScreenRecordGuideConfig.c.getClass();
        String r0 = null;
        if (LiveScreenRecordGuideConfig.a.b().b() == false) goto L34;
        String r1 = this.b;
        LiveRecordMonitorServiceWidget r15 = this.a;
        r15.getClass();
        int r2 = z22.c.a;
        Context r16 = ((Widget) r15).context;
        if (r16 != null) goto L31;
    L16:
        String r17 = null;
    L17:
        if (r17 == null) goto L24;
        String r18 = r17 + File.separator + "highlight";     // Catch: Exception -> L22
        if (z22.c.a(r18) == false) goto L24;
    L25:
        if (r18 == null) goto L27;
        r0 = r18 + File.separator + System.currentTimeMillis() + "_highlight_guide_record.mp4";
    L27:
        long r3 = this.c.getRoomId();
        LiveRecordMonitorServiceWidget r19 = this.a;
        return z22.c.c(r1, r0, r3, r19.g, r19.h, "guide_publish");
    L22:
        e = move-exception;
        Logger.e("VideoRecordUtils", "get backtrack cache file path error: " + e.toString());
    L24:
        r18 = null;
        goto L25
    L31:
        File r4 = r16.getExternalCacheDir();     // Catch: Exception -> L22
        if (r4 != null) goto L14;
        r4 = r16.getCacheDir();     // Catch: Exception -> L22
    L14:
        if (r4 == null) goto L16;
        r17 = r4.getAbsolutePath();     // Catch: Exception -> L22
        goto L17
    L34:
        return Observable.just(new ILiveRecordService.RecordMetaData(this.b, null, null));
    L30:
        return Observable.error(new IllegalStateException("请求校验接口未成功"));
    }
}
