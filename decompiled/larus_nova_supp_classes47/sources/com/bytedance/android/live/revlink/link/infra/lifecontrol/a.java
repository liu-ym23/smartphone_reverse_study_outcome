package com.bytedance.android.live.revlink.link.infra.lifecontrol;

import com.bytedance.android.livesdk.revenue.service.message.d;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import u51.b;
import yz0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o {
    public final PKLongBizHandler a;
    public final c b;
    public final f c;
    public final d d;
    public final b e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.infra.lifecontrol.a$a, reason: collision with other inner class name */
    public static final class C0203a {
    }

    static {
    }

    public final void onStart() {
        PKLongBizHandler r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void onStop() {
        PKLongBizHandler r0 = this.a;
        if (r0 == null) goto L6;
        r0.a.clear();
        return;
    }

    public a(c r2, f r3, d r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "revRoomService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r5, "infraScope");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        new CompositeDisposable();
        this.a = new PKLongBizHandler(true, r3, r4, r2);
    }
}
