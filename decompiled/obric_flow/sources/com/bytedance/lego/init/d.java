package com.bytedance.lego.init;

import com.bytedance.lego.init.model.FeedShowTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f6728b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f6729c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6730a;

    static {
        f6728b = new d(0);
        f6729c = new d(1);
    }

    public /* synthetic */ d(int r5) {
        this.f6730a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6730a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        InitScheduler.startDispatchIdleTask();
        return;
    L6:
        ArrayList r5 = e.f6731a;
        if (o.f != null) goto L13;
        o.f = new ArrayList();
        ArrayList r10 = o.f6769c;
        r10.isEmpty();
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == false) goto L13;
        throw androidx.constraintlayout.motion.widget.a.g(r11);
    L13:
        r5.addAll(o.f);
        CollectionsKt.sort(r5);
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L22;
        if (r5 == null) goto L22;
        StringBuilder r12 = new StringBuilder("\n-------------------------   AllFeedShowTasks   ------------------------\n");
        Iterator r13 = r5.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        FeedShowTaskInfo r14 = (FeedShowTaskInfo) r13.next();
        StringBuilder r15 = new StringBuilder();
        r15.append(r14);
        r15.append('\n');
        r12.append(r15.toString());
        goto L19
    L21:
        com.bytedance.lego.init.util.b.a("FeedShowTaskDispatcher", r12.toString());
    L22:
        Iterator r16 = e.f6731a.iterator();
    L24:
        if (r16.hasNext() == false) goto L29;
        FeedShowTaskInfo r17 = (FeedShowTaskInfo) r16.next();
        if (r17.mustRunInMainThread == true) goto L27;
        e.a(r17, false);
        goto L24
    L27:
        c.e.post(new a(r17, 1));
        goto L24
    }
}
