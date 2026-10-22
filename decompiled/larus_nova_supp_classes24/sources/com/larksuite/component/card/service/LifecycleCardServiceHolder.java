package com.larksuite.component.card.service;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/service/LifecycleCardServiceHolder;", "Lcom/larksuite/component/card/service/BaseCardServiceHolder;", "Landroidx/lifecycle/LifecycleObserver;", "identifier", "", "<init>", "(I)V", "onDestroy", "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LifecycleCardServiceHolder extends com.larksuite.component.card.service.a implements LifecycleObserver {
    public static final a d = null;
    public static final Map<Integer, LifecycleCardServiceHolder> e = null;
    public final int c;

    public static final class a {
        public a() {
        }

        private final int getIdentifier(Lifecycle r1) {
            return r1.hashCode();
        }

        public final LifecycleCardServiceHolder a(Lifecycle r4) {
            Intrinsics.checkNotNullParameter(r4, "lifecycle");
            int r0 = getIdentifier(r4);
            Map<Integer, LifecycleCardServiceHolder> r1 = LifecycleCardServiceHolder.e;
            HashMap r2 = (HashMap) r1;
            LifecycleCardServiceHolder r3 = (LifecycleCardServiceHolder) r2.get(Integer.valueOf(r0));
            if (r3 != null) goto L6;
            LifecycleCardServiceHolder r5 = new LifecycleCardServiceHolder(r0);
            r2.put(Integer.valueOf(r0), r5);
            r4.addObserver(r5);
            return r5;
        L6:
            return r3;
        }
    }

    static {
        d = new a();
        e = new HashMap();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        a();
        Map<Integer, LifecycleCardServiceHolder> r0 = e;
        HashMap r1 = (HashMap) r0;
        r1.remove(Integer.valueOf(this.c));
    }

    public LifecycleCardServiceHolder(int r1) {
        this.c = r1;
    }
}
