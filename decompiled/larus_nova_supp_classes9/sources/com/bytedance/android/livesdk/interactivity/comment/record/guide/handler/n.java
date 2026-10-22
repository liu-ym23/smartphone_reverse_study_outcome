package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.n b;

    public n(long r1, com.bytedance.android.livesdk.interactivity.comment.record.guide.n r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object apply(Object r10) {
        String r0 = (String) r10;
        Intrinsics.checkNotNullParameter(r0, "it");
        LiveScreenRecordGuideConfig.c.getClass();
        if (LiveScreenRecordGuideConfig.a.b().b() == false) goto L6;
        long r2 = this.a;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.n r11 = this.b;
        return z22.c.c(r0, null, r2, r11.d, r11.e, "active_publish");
    L6:
        return Observable.just(new ILiveRecordService.RecordMetaData(r0, null, null));
    }
}
