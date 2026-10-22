package com.bytedance.android.livesdk.dislike.preload.loader;

import com.bytedance.android.livesdk.dislike.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a {
    public final DataCenter a;
    public IRoom b;
    public final com.bytedance.android.livesdk.dislike.preload.context.a c;

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public void c() {
    }

    public abstract List<n> d();

    public a(com.bytedance.android.livesdk.dislike.preload.context.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.c = r2;
        DataCenter r3 = r2.getDataCenter();
        this.a = r3;
        if (r3 == null) goto L5;
        gb2.a.b(r3);
    L5:
        if (r3 == null) goto L7;
        gb2.a.d(r3);
    L7:
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.get("data_room");
    L10:
        this.b = r4;
        return;
    L9:
        r4 = null;
        goto L10
    }
}
