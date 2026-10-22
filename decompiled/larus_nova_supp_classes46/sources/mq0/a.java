package mq0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.config.ce0;
import com.bytedance.android.livesdk.config.rc1;
import com.bytedance.android.livesdk.config.sc1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final long a;
    public final long b;
    public final long c;
    public final Map<Long, Long> d;
    public final b e;
    public final oq0.a f;
    public final com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a g;

    /* JADX INFO: renamed from: mq0.a$a, reason: collision with other inner class name */
    public static final class C0240a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (r2.what != 1) goto L7;
            this.a.g.a("auto_show_explain_card");
            return;
        }

        public b(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    public a(oq0.a r5, com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a r6) {
        Intrinsics.checkNotNullParameter(r5, "prefHelper");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.f = r5;
        this.g = r6;
        sc1 r7 = ((rc1) ce0.a.getValue()).b();
        if (r7 == null) goto L5;
        long r0 = r7.c();
    L6:
        this.a = r0;
        if (r7 == null) goto L9;
        long r1 = r7.e();
    L10:
        long r2 = 1000;
        this.b = r1 * r2;
        if (r7 == null) goto L13;
        long r8 = r7.a();
    L14:
        this.c = r8 * r2;
        this.d = new LinkedHashMap();
        this.e = new b(this, Looper.getMainLooper());
        return;
    L13:
        r8 = 10;
        goto L14
    L9:
        r1 = 600;
        goto L10
    L5:
        r0 = 1;
        goto L6
    }
}
