package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends com.bytedance.android.anya.b implements com.bytedance.android.scope.o {
    public final ConcurrentHashMap<String, Boolean> a;
    public final List<BaseMVIViewModel<?, ?>> b;
    public final List<BaseMVIView<?, ?>> c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public e() {
        this.a = new ConcurrentHashMap();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final Collection<BaseMVIViewModel<?, ?>> d() {
        return this.b;
    }

    public final <STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        com.bytedance.android.scope.m r5 = com.bytedance.android.scope.m.e;
        r5.getClass();
        h r0 = r5.a(com.bytedance.android.scope.m.d, h.class);
        m r1 = null;
        if (r0 == null) goto L5;
        Object r6 = r5.d(r0, CrossRoomTrayDataStore.class);
    L6:
        CrossRoomTrayDataStore r7 = (CrossRoomTrayDataStore) r6;
        if (r7 == null) goto L9;
        m r2 = new m(r7);
    L11:
        if ((r2 instanceof BaseMVIViewModel) == false) goto L14;
        r1 = r2;
    L14:
        if (r1 == null) goto L16;
        ((ArrayList) this.b).add(r1);
    L16:
        return r1;
    L9:
        r2 = null;
        goto L11
    L5:
        r6 = null;
        goto L6
    }
}
