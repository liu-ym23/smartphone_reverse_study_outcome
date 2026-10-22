package com.larus.bmhome.instruction.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import up8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/instruction/base/ViewLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "parentLifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "parentLifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onAttached", "", "onDetached", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewLifecycleOwner implements LifecycleOwner {
    public final Lifecycle a;
    public final LifecycleRegistry b;

    public ViewLifecycleOwner() {
        this(null);
    }

    public final Lifecycle getLifecycle() {
        return this.b;
    }

    public ViewLifecycleOwner(Lifecycle r2) {
        this.a = r2;
        this.b = new LifecycleRegistry(this);
        LifecycleEventObserver r0 = new e(this);
        if (r2 == null) goto L6;
        r2.addObserver(r0);
        return;
    }
}
