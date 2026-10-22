package ssc;

import io.noties.markwon.ext.tasklist.TaskListItem;
import lsc.m;
import lsc.m$c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements m$c<TaskListItem> {
    public b() {
    }

    @Override // lsc.m$c
    public final void a(m r5, uvc.b r6) {
        TaskListItem r7 = (TaskListItem) r6;
        int r0 = r5.length();
        r5.c(r7);
        e.a.c(r5.r(), Boolean.valueOf(r7.h));
        r5.y(r7, r0);
        if (r5.s(r7) == false) goto L6;
        r5.a();
        return;
    }
}
