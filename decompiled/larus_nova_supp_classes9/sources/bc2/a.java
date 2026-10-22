package bc2;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.log.b0;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements vlc.c {
    public final String a;

    public final boolean a() {
        return ((Boolean) b.a.getValue()).booleanValue();
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "actualLogTag");
        this.a = r2;
    }

    public final void log(String r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LocalTestManager.a(new Class[]{wy.a.class});
        b0 r5 = b0.o();
        String r0 = "LiveMessageTracer_" + this.a;
        r5.getClass();
        g.i(r0, r4);
    }
}
