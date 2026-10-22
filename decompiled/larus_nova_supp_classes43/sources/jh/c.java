package jh;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements a {
    public final q a;

    public final void b() {
        int r0 = ECSdk.a;
        cj.a r1 = (cj.a) ECSdk.a(cj.a.class);
        if (r1 == null) goto L6;
        String r10 = this.a.a;
        r1.start();
        return;
    }

    @Override // jh.a
    public final void stop() {
        int r0 = ECSdk.a;
        cj.a r1 = (cj.a) ECSdk.a(cj.a.class);
        if (r1 == null) goto L6;
        String r10 = this.a.a;
        r1.stop();
        return;
    }

    public c(q r10) {
        Intrinsics.checkNotNullParameter(r10, "monitorSceneWrapper");
        this.a = r10;
    }

    public final void c(RecyclerView r10) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        int r11 = ECSdk.a;
        cj.a r12 = (cj.a) ECSdk.a(cj.a.class);
        if (r12 == null) goto L6;
        String r0 = this.a.a;
        r12.b();
        return;
    }

    public final void a(String r1, Object r10) {
        Intrinsics.checkNotNullParameter(r1, "key");
        int r11 = ECSdk.a;
        cj.a r12 = (cj.a) ECSdk.a(cj.a.class);
        if (r12 == null) goto L6;
        String r13 = this.a.a;
        r12.c();
        return;
    }
}
