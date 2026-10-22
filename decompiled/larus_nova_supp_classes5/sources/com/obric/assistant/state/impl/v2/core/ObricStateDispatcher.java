package com.obric.assistant.state.impl.v2.core;

import cha.a;
import cha.c;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.api.v2.core.bean.ObricTtsInfo;
import com.obric.assistant.state.impl.v2.utils.j;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricStateDispatcher implements c, cha.b, a {
    public static final ObricStateDispatcher a = null;
    public static final ConcurrentHashMap<String, Set<c>> b = null;
    public static final CopyOnWriteArraySet<c> c = null;
    public static final CopyOnWriteArraySet<cha.b> d = null;
    public static final CopyOnWriteArraySet<a> e = null;

    public ObricStateDispatcher() {
    }

    static {
        a = new ObricStateDispatcher();
        b = new ConcurrentHashMap();
        c = new CopyOnWriteArraySet();
        d = new CopyOnWriteArraySet();
        e = new CopyOnWriteArraySet();
    }

    public final void a(ObricAssistantAliveLockState r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        onAssistantAliveStateChanged.1 r4 = new onAssistantAliveStateChanged.1(r8, null);
        Lazy r9 = j.a;
        Intrinsics.checkNotNullParameter(r4, "block");
        BuildersKt.launch$default((CoroutineScope) j.a.getValue(), null, null, r4, 3, null);
    }

    public final void c(ObricState r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        onObricStateChanged.1 r4 = new onObricStateChanged.1(r8, null);
        Lazy r9 = j.a;
        Intrinsics.checkNotNullParameter(r4, "block");
        BuildersKt.launch$default((CoroutineScope) j.d.getValue(), null, null, r4, 3, null);
    }

    public final void d(ObricNetworkKeepAliveLockState r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        onNetworkKeepAliveLockStateChanged.1 r4 = new onNetworkKeepAliveLockStateChanged.1(r8, null);
        Lazy r9 = j.a;
        Intrinsics.checkNotNullParameter(r4, "block");
        BuildersKt.launch$default((CoroutineScope) j.d.getValue(), null, null, r4, 3, null);
    }

    public final void b(ObricTtsInfo r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "ttsInfo");
        onObricTTSStateChanged.1 r4 = new onObricTTSStateChanged.1(r8, r9, null);
        Lazy r10 = j.a;
        Intrinsics.checkNotNullParameter(r4, "block");
        BuildersKt.launch$default((CoroutineScope) j.a.getValue(), null, null, r4, 3, null);
    }
}
