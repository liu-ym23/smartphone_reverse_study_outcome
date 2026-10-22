package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.content.Context;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements Runnable {
    public final /* synthetic */ i.d a;

    public l(i.d r1) {
        this.a = r1;
    }

    public final void a() {
        WelfareAnchorServiceWidget r0 = this.a.a.a;
        Context r6 = ((Widget) r0).context;
        if (r6 == null) goto L12;
        int r1 = yt2.b.a;
        List<Integer> r2 = qy0.a.getValue().g();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        int r4 = ((Number) r3.next()).intValue();
        r5.add(new gm3.a(r4, r6.getString(2131922402, new Object[]{String.valueOf(r4)}), true));
        goto L7
    L9:
        Intrinsics.checkNotNullParameter(r6, "context");
        String r7 = r6.getString(2131922401);
        Intrinsics.checkNotNullParameter(r7, "description");
        String r8 = r6.getString(2131915442);
        Intrinsics.checkNotNullParameter(r8, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r5, "items");
        r r9 = new r(r0);
        Intrinsics.checkNotNullParameter(r9, "listener");
        s r10 = new s(r0);
        Intrinsics.checkNotNullParameter(r10, "listener");
        new gm3.b(r10, r9, r8, r5, r6, r7).b();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
