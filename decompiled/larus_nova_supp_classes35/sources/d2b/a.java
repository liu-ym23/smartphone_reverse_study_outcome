package d2b;

import android.text.TextUtils;
import com.larksuite.framework.thread.n;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final HashMap<String, a> c = null;
    public final String a;
    public final ScheduledExecutorService b;

    /* JADX INFO: renamed from: d2b.a$a, reason: collision with other inner class name */
    public static final class C0208a {
        @JvmStatic
        public static a a(String r2) {
            if (r2 == null) goto L4;
            HashMap<String, a> r0 = a.c;
            monitor-enter(r0);
            a r1 = r0.get(r2);     // Catch: Throwable -> L12
            if (r1 != null) goto L10;
            r1 = new a(r2);     // Catch: Throwable -> L12
            r0.put(r2, r1);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);
            return r1;
        L12:
            th = move-exception;
            throw th;
        L4:
            return new a(BuildConfig.FLAVOR);
        }
    }

    public interface b {
    }

    public interface c {
    }

    static {
        c = new HashMap();
    }

    public final void b() {
        HashMap<String, a> r0 = c;
        monitor-enter(r0);
        r0.clear();     // Catch: Throwable -> L7
        this.b.shutdown();     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public a(String r4) {
        this.a = r4;
        this.b = PThreadExecutorsUtils.newScheduledThreadPool(1, new n("MsgSampleIssueTracker_" + r4));
    }

    public final void a(Chat r2, c r3, b r4) {
        Intrinsics.checkNotNullParameter(r3, "fetcher");
        Intrinsics.checkNotNullParameter(r4, "syncFetcher");
        if (TextUtils.isEmpty(this.a) == true) goto L7;
        if (r2 == null) goto L8;
        Intrinsics.areEqual(this.a, r2.getId());
        return;
    L8:
        return;
    }
}
