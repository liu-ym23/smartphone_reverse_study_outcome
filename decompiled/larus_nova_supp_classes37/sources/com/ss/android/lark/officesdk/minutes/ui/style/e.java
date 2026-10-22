package com.ss.android.lark.officesdk.minutes.ui.style;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import com.ss.android.lark.officesdk.minutes.ui.style.provider.f;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final e a = null;
    public static final f b = null;
    public static final ConcurrentHashMap<MmRecordingUILaunchMode, h> c = null;
    public static final AtomicBoolean d = null;

    public e() {
    }

    static {
        a = new e();
        b = new f();
        c = new ConcurrentHashMap();
        d = new AtomicBoolean(false);
    }

    public static void a() {
        if (d.compareAndSet(false, true) == true) goto L21;
        return;
    L21:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Iterator r1 = ClaymoreServiceLoader.loadAll(h.class);     // Catch: Throwable -> L11
    L7:
        if (r1.hasNext() == false) goto L9;
        h r2 = (h) r1.next();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r2, "provider");     // Catch: Throwable -> L11
        c.compute(r2.getUiLaunchMode(), new d(r2));     // Catch: Throwable -> L11
        goto L7
    L9:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        int r5 = bwb.b.a;
        bwb.b.d(MmUiLogScene.STYLE, "ensureLoaded", "load providers failed, error=" + r4, null);
    L16:
        ConcurrentHashMap<MmRecordingUILaunchMode, h> r6 = c;
        h r7 = r6.get(MmRecordingUILaunchMode.WITH_DOUBAO_UI);
        if (r7 == null) goto L24;
        r6.putIfAbsent(MmRecordingUILaunchMode.WITH_DOUBAO_UI_HARDWARE, r7);
        return;
    L24:
        return;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static h b(MmRecordingUILaunchMode r4) {
        a();
        if (r4 != null) goto L5;
        r4 = MmRecordingUILaunchMode.UNKNOWN;
    L5:
        h r0 = c.get(r4);
        if (r0 != null) goto L9;
        f r1 = b;
        int r2 = bwb.b.a;
        bwb.b.d(MmUiLogScene.STYLE, "providerOrDefaultForResource", "use fallback, mode=" + r4, null);
        return r1;
    L9:
        return r0;
    }

    public static h c(MmRecordingUILaunchMode r4) {
        a();
        if (r4 != null) goto L5;
        r4 = MmRecordingUILaunchMode.UNKNOWN;
    L5:
        h r0 = c.get(r4);
        if (r0 != null) goto L8;
        int r1 = bwb.b.a;
        bwb.b.d(MmUiLogScene.STYLE, "providerOrNullForLaunch", "missing provider, mode=" + r4, null);
    L8:
        return r0;
    }
}
