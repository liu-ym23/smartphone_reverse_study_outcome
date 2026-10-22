package com.larus.ui.arch.vm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/larus/ui/arch/vm/EmptyLifecycle;", "Landroidx/lifecycle/Lifecycle;", "<init>", "()V", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "component_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class EmptyLifecycle extends Lifecycle {
    public static final EmptyLifecycle a = null;
    public static final Lifecycle.State b = null;

    public final void addObserver(LifecycleObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
    }

    public final void removeObserver(LifecycleObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
    }

    static {
        a = new EmptyLifecycle();
        b = Lifecycle.State.DESTROYED;
    }

    private EmptyLifecycle() {
    }

    public final Lifecycle.State getCurrentState() {
        return b;
    }
}
