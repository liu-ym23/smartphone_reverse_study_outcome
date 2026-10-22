package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T, R> implements Function {
    public final /* synthetic */ Context a;

    public o(Context r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        ILiveRecordService.RecordMetaData r5 = (ILiveRecordService.RecordMetaData) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        Context r0 = this.a;
        String r1 = r5.getNewFile();
        if (r1 != null) goto L6;
        r1 = r5.getOriginFile();
    L6:
        if (r5.getNewFile() == null) goto L8;
        boolean r6 = true;
    L9:
        int r2 = z22.c.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "videoPath");
        Observable r7 = Observable.create(new z22.b(r1, r0, r6));
        int r3 = com.bytedance.revenue.platform.api.core.rx.p.a;
        return r7.subscribeOn(Schedulers.io());
    L8:
        r6 = false;
        goto L9
    }
}
