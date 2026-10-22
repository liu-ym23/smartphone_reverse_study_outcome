package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.n a;

    public g(com.bytedance.android.livesdk.interactivity.comment.record.guide.n r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        String r0 = (String) r10;
        Intrinsics.checkNotNullParameter(r0, "it");
        LiveScreenRecordGuideConfig.c.getClass();
        if (LiveScreenRecordGuideConfig.a.b().b() == false) goto L12;
        DataCenter r11 = this.a.b;
        if (r11 == null) goto L9;
        Room r13 = z.o(r11);
        if (r13 == null) goto L9;
        long r2 = r13.id;
    L10:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.n r14 = this.a;
        return z22.c.c(r0, null, r2, r14.d, r14.e, "active_publish");
    L9:
        r2 = 0;
        goto L10
    L12:
        return Observable.just(new ILiveRecordService.RecordMetaData(r0, null, null));
    }
}
