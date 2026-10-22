package com.larus.voicecall.impl;

import com.larus.voicecall.api.IRealtimeCallStateService;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/impl/RealtimeCallStateServiceImpl;", "Lcom/larus/voicecall/api/IRealtimeCallStateService;", "<init>", "()V", "addStateChangeListener", NameKeys.UnloadStrategy_No_Strategy, "listener", "Lcom/larus/voicecall/api/IRealtimeCallStateListener;", "removeStateChangeListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallStateServiceImpl implements IRealtimeCallStateService {
    public RealtimeCallStateServiceImpl() {
    }

    @Override // com.larus.voicecall.api.IRealtimeCallStateService
    public final void a() {
        com.bytedance.applet.event.u r0 = com.bytedance.applet.event.u.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        b0.a(r0);
    }
}
