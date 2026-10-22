package com.bytedance.android.annie.bridge.method.calendar;

import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ g a;

    public i(g r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        CreateCalendarEventResultModel.Code r11 = (CreateCalendarEventResultModel.Code) r10;
        CreateCalendarEventResultModel.Code r0 = CreateCalendarEventResultModel.Code.Success;
        if (r11 != r0) goto L5;
        g r12 = this.a;
        CreateCalendarEventResultModel r1 = new CreateCalendarEventResultModel();
        r1.a(r0);
        r1.b("create calendar success!");
        r12.finishWithResult(r1);
        return;
    L5:
        g r13 = this.a;
        CreateCalendarEventResultModel r14 = new CreateCalendarEventResultModel();
        r14.a(CreateCalendarEventResultModel.Code.Failed);
        r14.b("create calendar failed!");
        r13.finishWithResult(r14);
    }
}
