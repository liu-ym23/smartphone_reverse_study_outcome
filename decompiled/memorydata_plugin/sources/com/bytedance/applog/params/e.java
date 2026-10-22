package com.bytedance.applog.params;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0005"}, d2 = {"mainThreadRun", "", f.f1488a, "Lkotlin/Function0;", "noMainThreadRun", "params_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class e {
    public static final void a(Function0<Unit> r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, f.f1488a);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        new Handler(Looper.getMainLooper()).post(new $$Lambda$e$FvjwqcU8KsUmPldrCKOd7yD9Pd0(r3));
        return;
    L5:
        r3.invoke();
    }

    private static final void b(Function0 r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$f");
        r3.invoke();
    }

    public static /* synthetic */ void lambda$FvjwqcU8KsUmPldrCKOd7yD9Pd0(Function0 r0) {
        b(r0);
    }
}
