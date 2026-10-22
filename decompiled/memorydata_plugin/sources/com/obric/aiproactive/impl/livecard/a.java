package com.obric.aiproactive.impl.livecard;

import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/AbilityManagerTimeDriver;", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardTimeAbilityDriver;", "<init>", "()V", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", AwarenessManagerImpl.ACTION_SUBSCRIBE, "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "receiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "unsubscribe", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.ability.d f6456a;

    public a() {
        this.f6456a = new com.obric.memorydata.ability.d();
    }

    @Override // com.obric.aiproactive.impl.livecard.p
    public boolean a(com.obric.memorydata.ability.f r3, com.obric.memorydata.ability.k r4) {
        com.obric.memorydata.ability.k r5 = (com.obric.memorydata.ability.k) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r5, "receiver");
        return this.f6456a.a(r3, r5);
    }

    @Override // com.obric.aiproactive.impl.livecard.p
    public boolean b(com.obric.memorydata.ability.f r3, com.obric.memorydata.ability.k r4) {
        com.obric.memorydata.ability.k r5 = (com.obric.memorydata.ability.k) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r5, "receiver");
        return this.f6456a.b(r3, r5);
    }
}
