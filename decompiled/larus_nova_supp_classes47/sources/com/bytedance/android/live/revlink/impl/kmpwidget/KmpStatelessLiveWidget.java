package com.bytedance.android.live.revlink.impl.kmpwidget;

import android.content.res.Configuration;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.scopeui.KmpStatelessWidget;
import com.bytedance.android.livesdk.revenue.room.a;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.m;
import dy0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/kmpwidget/KmpStatelessLiveWidget;", "Lcom/bytedance/android/live/revlink/scopeui/KmpStatelessWidget;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KmpStatelessLiveWidget extends KmpStatelessWidget {
    public KmpStatelessLiveWidget() {
    }

    public static o xq(Class r3) {
        Intrinsics.checkNotNullParameter(r3, "typeId");
        j.a r0 = j.C0;
        c r1 = (b) e.c(r0.a(), c.class);
        if (r1 == null) goto L12;
        a r2 = r1.getRoomContext();
        if (r2 == null) goto L12;
        m r4 = r2.getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L12;
        r5.getRoomId();
    L12:
        if (d51.c.A0.a() == false) goto L19;
        o41.a r6 = (o41.a) f.d(r0.a(), o41.a.class);
        if (r6 == null) goto L21;
        o11.b r7 = r6.a;
        if (r7 == null) goto L21;
        return (o) com.bytedance.android.scope.m.e.d(r7, r3);
    L21:
        return null;
    L19:
        com.bytedance.android.live.revenue.core.b r8 = r0.a();
        Intrinsics.checkNotNull(r8);
        o11.b r9 = ((o41.a) f.b(r8, o41.a.class)).a;
        if (r9 == null) goto L21;
        return (o) com.bytedance.android.scope.m.e.d(r9, r3);
    }

    public static b yq(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "typeId");
        return (b) z11.a.a(r1);
    }

    public static f80.b zq(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "typeId");
        if (d51.c.A0.a() == false) goto L8;
        com.bytedance.android.live.revenue.core.b r0 = j.C0.a();
        if (r0 != null) goto L11;
        return null;
    L11:
        return f.b(r0, r1);
    L8:
        com.bytedance.android.live.revenue.core.b r2 = j.C0.a();
        Intrinsics.checkNotNull(r2);
        return f.b(r2, r1);
    }

    @Override // com.bytedance.android.live.revlink.scopeui.KmpWidget
    public final b03.b wq(Object r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((r3 instanceof Configuration) == true) goto L7;
        return null;
    L7:
        return zr0.b.a((Configuration) r3);
    }
}
