package com.bytedance.android.annie.bridge.method.calendar;

import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ g a;

    public j(g r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        g r0 = this.a;
        CreateCalendarEventResultModel r1 = new CreateCalendarEventResultModel();
        r1.a(CreateCalendarEventResultModel.Code.Failed);
        r1.b("create calendar failed with unknown error, error msg = " + ((Throwable) r10).getMessage());
        r0.finishWithResult(r1);
    }
}
