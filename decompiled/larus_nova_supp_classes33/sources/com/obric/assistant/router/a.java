package com.obric.assistant.router;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(Ref.ObjectRef r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref.ObjectRef r0 = this.a;
        int r1 = this.b;
        List r2 = AppHost.a.a().g();
        if (r2.contains(r0.element) == true) goto L5;
        FLogger.a.i("ObricChatPageRouterInterceptor", "already finished?");
        return;
    L5:
        Iterator r3 = CollectionsKt.reversed(r2).iterator();
    L7:
        if (r3.hasNext() == false) goto L23;
        Activity r4 = (Activity) r3.next();
        if (r4.getTaskId() != r1) goto L7;
        if (r4.isFinishing() == true) goto L7;
        FLogger.a.i("ObricChatPageRouterInterceptor", "finishing ".concat(r4.getClass().getSimpleName()));
        r4.finish();
        if (Intrinsics.areEqual(r4, r0.element) == false) goto L7;
        return;
    }
}
