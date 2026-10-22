package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.n a;
    public final /* synthetic */ Context b;

    public l(com.bytedance.android.livesdk.interactivity.comment.record.guide.n r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r2) {
        ILiveRecordService.RecordMetaData r3 = (ILiveRecordService.RecordMetaData) r2;
        Intrinsics.checkNotNullParameter(r3, "recordData");
        String r0 = r3.getNewFile();
        if (r0 != null) goto L6;
        r0 = r3.getOriginFile();
    L6:
        return Observable.create(new k(this, r0));
    }
}
