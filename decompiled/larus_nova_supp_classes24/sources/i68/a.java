package i68;

import com.larus.audio.audiov3.task.sami.v2.x;
import h68.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements f {
    public a() {
    }

    @Override // h68.f
    public final x a(String r2, y58.a r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "asrConfig");
        x r0 = new x(r2);
        r0.k(r3);
        return r0;
    }
}
