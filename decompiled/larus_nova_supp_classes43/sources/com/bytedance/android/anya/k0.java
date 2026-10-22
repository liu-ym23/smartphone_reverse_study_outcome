package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.k0;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class k0<STATE extends MVIState<?>, CONTEXT extends k0<STATE, CONTEXT>> extends h<STATE, CONTEXT> {

    public static final class a<STATE extends MVIState<?>> extends k0<STATE, a<STATE>> {
        public a() {
        }
    }

    public k0() {
    }

    public static List c(t0 r0) {
        return ((com.bytedance.android.anya.internal.u) r0).c();
    }

    public final <T extends MVIState<?>> r e(T r1) {
        return r1.toBusinessState(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MVIState d(t0 r0, int r1) {
        return (MVIState) ((com.bytedance.android.anya.internal.u) r0).c().get(r1);
    }
}
