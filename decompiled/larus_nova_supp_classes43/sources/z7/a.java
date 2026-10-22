package z7;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends b7.a {
    public c7.a a;

    @Override // b7.a, b7.b
    public final void onRelease() {
        super.onRelease();
        c7.a r0 = this.a;
        if (r0 == null) goto L8;
        String r1 = r0.getMonitorID();
        if (r1 == null) goto L9;
        ConcurrentHashMap<String, com.bytedance.android.monitorV2.event.c> r10 = e.a;
        Intrinsics.checkNotNullParameter(r1, "monitorID");
        e.a.remove(r1);
        return;
    L9:
        return;
    }

    public a() {
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        super.onInit(r10);
        this.a = r10;
    }
}
