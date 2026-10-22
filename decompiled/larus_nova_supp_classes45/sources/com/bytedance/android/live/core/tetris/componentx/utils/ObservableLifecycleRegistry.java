package com.bytedance.android.live.core.tetris.componentx.utils;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.tetris.componentx.component.a;
import g70.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/utils/ObservableLifecycleRegistry;", "Landroidx/lifecycle/LifecycleRegistry;", "Lg70/h;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ObservableLifecycleRegistry extends LifecycleRegistry implements h {
    public final Set<h.a> a;
    public final LifecycleOwner b;

    public ObservableLifecycleRegistry(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        super(r2);
        this.b = r2;
        this.a = new LinkedHashSet();
    }

    @Override // g70.h
    public final boolean a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return this.a.remove(r2);
    }

    public final void addObserver(LifecycleObserver r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((h.a) r0.next()).d(r3);
        goto L4
    L6:
        super.addObserver(r3);
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((h.a) r1.next()).c(r3);
        goto L8
    }

    @Override // g70.h
    public final boolean c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return this.a.add(r2);
    }

    public final void removeObserver(LifecycleObserver r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((h.a) r0.next()).a(r3);
        goto L4
    L6:
        super.removeObserver(r3);
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((h.a) r1.next()).b(r3);
        goto L8
    }
}
