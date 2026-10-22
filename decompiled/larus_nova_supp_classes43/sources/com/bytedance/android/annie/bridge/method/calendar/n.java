package com.bytedance.android.annie.bridge.method.calendar;

import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import e7.f0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ f0 b;

    public n(g r1, f0 r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void accept(Object r10) {
        g r0 = this.a;
        CreateCalendarEventResultModel r1 = new CreateCalendarEventResultModel();
        f0 r11 = this.b;
        r1.a(CreateCalendarEventResultModel.Code.Failed);
        r1.b("delete calendar event failed. error msg = " + ((Throwable) r10).getMessage() + ", request id = " + r11.getIdentifier());
        r0.finishWithResult(r1);
    }
}
