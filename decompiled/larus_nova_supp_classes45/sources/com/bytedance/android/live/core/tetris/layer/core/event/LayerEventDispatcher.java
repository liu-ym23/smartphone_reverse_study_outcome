package com.bytedance.android.live.core.tetris.layer.core.event;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o70.b;
import o70.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/event/LayerEventDispatcher;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "<init>", "()V", "a", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LayerEventDispatcher implements LifecycleObserver {
    public final HashMap<Class<? extends b>, HashSet<o70.a>> a;

    public static final class a {
        public final List<Class<? extends b>> a;
        public final o70.a b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<Class<? extends b>> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            o70.a r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "EventPair(list=" + this.a + ", resolver=" + this.b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends Class<? extends b>> r2, o70.a r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            Intrinsics.checkNotNullParameter(r3, "resolver");
            this.a = r2;
            this.b = r3;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        HashMap<Integer, LayerEventDispatcher> r0 = c.a;
        Intrinsics.checkNotNullParameter(this, "layerEventDispatcher");
        HashMap<LayerEventDispatcher, Integer> r1 = c.b;
        if (r1.containsKey(this) == false) goto L5;
        Integer r2 = r1.get(this);
        r1.remove(this);
        HashMap<Integer, LayerEventDispatcher> r3 = c.a;
        Intrinsics.checkNotNull(r2);
        r3.remove(r2);
    L5:
        this.a.clear();
    }

    public LayerEventDispatcher() {
        this.a = new HashMap();
    }

    public final void a(o70.a r6) {
        ArrayList r0 = new ArrayList();
        if (r6 == null) goto L5;
        r0.add(new a(r6.Mg(), r6));
    L5:
        Iterator r7 = r0.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        a r1 = (a) r7.next();
        Iterator<T> r2 = r1.a.iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        Class<? extends b> r3 = (Class) r2.next();
        if (this.a.containsKey(r3) == false) goto L14;
        HashSet<o70.a> r4 = this.a.get(r3);
        Intrinsics.checkNotNull(r4);
        HashSet<o70.a> r5 = r4;
    L15:
        r5.add(r1.b);
        goto L10
    L14:
        HashSet<o70.a> r8 = new HashSet();
        this.a.put(r3, r8);
        r5 = r8;
        goto L15
    }

    public final void b(b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        HashSet<o70.a> r0 = this.a.get(r3.getClass());
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((o70.a) r1.next()).onEvent(r3);
        goto L6
    L10:
        return;
    }
}
