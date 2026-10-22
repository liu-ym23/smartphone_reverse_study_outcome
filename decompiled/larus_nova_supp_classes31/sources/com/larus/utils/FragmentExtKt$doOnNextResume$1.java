package com.larus.utils;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/utils/FragmentExtKt$doOnNextResume$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FragmentExtKt$doOnNextResume$1 implements LifecycleEventObserver {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ Fragment b;

    public FragmentExtKt$doOnNextResume$1(Function0<Unit> r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 != Lifecycle.Event.ON_RESUME) goto L6;
        this.a.invoke();
        this.b.getLifecycle().removeObserver(this);
        return;
    }
}
