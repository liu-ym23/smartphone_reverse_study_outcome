package com.bytedance.lego.init;

import com.bytedance.lego.init.model.FeedShowTaskInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6723b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f6722a = r10;
        this.f6723b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.f6723b;
        switch(this.f6722a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((Function0) r5).invoke();
        return;
    L6:
        ArrayList r10 = e.f6731a;
        e.a((FeedShowTaskInfo) r5, true);
        return;
    L8:
        LinkedHashMap r11 = c.f6725a;
        c.b(((DelayTaskDispatcher$dispatchTask$1) r5).$task, true);
    }
}
