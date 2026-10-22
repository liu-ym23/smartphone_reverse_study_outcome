package sc8;

import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static final i a = null;
    public static final Handler b = null;
    public static final Lazy c = null;

    public i() {
    }

    static {
        a = new i();
        b = new Handler(Looper.getMainLooper());
        c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c());
    }

    public static void a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Iterator r0 = b(r5.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        BubbleBannerSourceListener r1 = (BubbleBannerSourceListener) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.i(r5);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        FLogger.a.w("BubbleBannerEventDispatcher", "dispatch click failed, bannerSource=" + r5.a + ", promptId=" + r5.b, r4);
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static List b(String r3) {
        Lazy r0 = c;
        List r1 = (List) ((Map) r0.getValue()).get("*");
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        if (r3 == null) goto L7;
        a.getClass();
        List r4 = (List) ((Map) r0.getValue()).get(r3);
    L8:
        if (r4 != null) goto L11;
        r4 = CollectionsKt.emptyList();
    L11:
        if (r1.isEmpty() == false) goto L14;
        return r4;
    L14:
        return CollectionsKt.plus(r1, r4);
    L7:
        r4 = null;
        goto L8
    }

    public static void c(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        b.post(new h(r2));
    }
}
