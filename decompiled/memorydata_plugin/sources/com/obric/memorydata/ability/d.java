package com.obric.memorydata.ability;

import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/ability/AbilityManager;", "Lcom/obric/memorydata/ability/IAbilityManager;", "<init>", "()V", ChatMessage.TYPE_QUERY, "", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "dataReceiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", AwarenessManagerImpl.ACTION_SUBSCRIBE, "unsubscribe", "getReceiverDataId", "", "()Ljava/lang/Integer;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class d implements l {
    public d() {
    }

    @Override // com.obric.memorydata.ability.l
    public boolean a(f r3, k r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        Intrinsics.checkNotNullParameter(r5, "dataReceiver");
        return e.f8354a.a(r3, r5, b());
    }

    public Integer b() {
        return null;
    }

    @Override // com.obric.memorydata.ability.l
    public boolean b(f r3, k r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        Intrinsics.checkNotNullParameter(r5, "dataReceiver");
        return e.f8354a.b(r3, r5, b());
    }

    @Override // com.obric.memorydata.ability.l
    public boolean query(f r3, k r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        Intrinsics.checkNotNullParameter(r5, "dataReceiver");
        return e.f8354a.query(r3, r5, b());
    }
}
