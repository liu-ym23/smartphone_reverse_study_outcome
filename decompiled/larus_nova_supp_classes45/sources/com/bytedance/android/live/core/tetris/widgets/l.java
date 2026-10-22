package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.bytedance.ies.sdk.widgets.priority.ContinueLoadTask;
import com.bytedance.ies.sdk.widgets.priority.GroupSchedule;
import com.bytedance.ies.sdk.widgets.priority.ILoadTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements ILoadTask<Object> {
    public final /* synthetic */ LiveRecyclableWidget a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ WidgetManager.LoadCallback d;
    public final /* synthetic */ RecyclableWidgetManager e;

    public final Object run() {
        RecyclableWidgetManager r0 = this.e;
        Widget r1 = this.a;
        boolean r2 = this.b;
        boolean r3 = this.c;
        RecyclableWidgetManager.a r4 = RecyclableWidgetManager.j;
        e80.b r5 = r0.e;
        if (r5 == null) goto L5;
        r5.d(r1);
    L5:
        if (r2 == false) goto L10;
        WidgetPerfManager.getInstance().onPerfStart(r1, "inflate");
        r0.onLoadByAsync(r1);
        if (r3 == false) goto L9;
        r0.mayInsertHighPriorityHandlerQueue(new ContinueLoadTask(r1, new m(r0, r1)));
    L11:
        WidgetPerfManager.getInstance().onPerfEnd(r1, "onLoad");
        WidgetManager.LoadCallback r6 = this.d;
        if (r6 == null) goto L15;
        r6.onLoaded(this.a);
    L15:
        return this.a;
    L9:
        r0.mayInsertHandlerQueue(new ContinueLoadTask(r1, new n(r0, r1)));
        goto L11
    L10:
        GroupSchedule.getInstance().enqueueContinueLoad(r1, new o(r0, r1));
        goto L11
    }

    public l(RecyclableWidgetManager r1, LiveRecyclableWidget r2, boolean r3, boolean r4) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
    }
}
