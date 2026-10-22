package ps8;

import com.larus.bmhome.video.h;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import com.larus.video.impl.sdk.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements a {
    public static final d a = null;
    public static final Lazy b = null;

    public d() {
    }

    static {
        a = new d();
        b = LazyKt.lazy(new b());
    }

    public static ConcurrentHashMap d() {
        return (ConcurrentHashMap) b.getValue();
    }

    @Override // ps8.a
    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        IVideoController r0 = (IVideoController) d().get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap r1 = d();
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (r0.isReleased() == true) goto L10;
        r0.release();     // Catch: Throwable -> L13
    L10:
        IVideoController r5 = (IVideoController) d().remove(r4);     // Catch: Throwable -> L13
        monitor-exit(r1);
    }

    @Override // ps8.a
    public final IVideoController a(final String r6, final String r7, final String r8) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "tag");
        Intrinsics.checkNotNullParameter(r8, "subTag");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        Object r1 = d().get(r6);
        r0.element = r1;
        if (r1 != null) goto L5;
    L6:
        ConcurrentHashMap r2 = d();
        monitor-enter(r2);
        Object r3 = d().get(r6);     // Catch: Throwable -> L23
        r0.element = r3;     // Catch: Throwable -> L23
        if (r3 != null) goto L16;
        o r4 = null;
        o r5 = q3.b(r7, null, 6);     // Catch: Throwable -> L23
        if (r5 == null) goto L13;
        r5.I(true);     // Catch: Throwable -> L23
        r4 = r5;
    L13:
        r0.element = r4;     // Catch: Throwable -> L23
        if (r4 == null) goto L16;
        d().put(r6, r4);     // Catch: Throwable -> L23
    L16:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r2);
    L18:
        IVideoController r10 = (IVideoController) r0.element;
        if (r10 == null) goto L21;
        r10.setSubTag(r8);
    L21:
        h.a("VideoPlayerEngineManager", new c(r6, r7, r8, r0));
        return (IVideoController) r0.element;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (((IVideoController) r1).isReleased() == false) goto L18;
        goto L6
    }

    @Override // ps8.a
    public final IVideoController c(String r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r4, "subTag");
        o r5 = q3.b(r2, r3, 2);
        if (r5 == null) goto L5;
        o r6 = r5;
        r6.setSubTag(r4);
        r6.I(true);
        return r5;
    L5:
        return null;
    }
}
