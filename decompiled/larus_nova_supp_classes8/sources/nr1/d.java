package nr1;

import com.bytedance.android.livesdk.chatroom.monitor.e;
import kotlin.jvm.internal.Intrinsics;
import vr1.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements b0 {
    public final e a;

    @Override // vr1.b0
    public final void b() {
        e r0 = this.a;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    @Override // vr1.b0
    public final void stop() {
        e r0 = this.a;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public d() {
        this.a = com.bytedance.android.livesdk.chatroom.monitor.a.a();
    }

    @Override // vr1.b0
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        e r0 = this.a;
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }
}
