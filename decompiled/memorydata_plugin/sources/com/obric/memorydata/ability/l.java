package com.obric.memorydata.ability;

import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.database.entity.ChatMessage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/ability/IAbilityManager;", "", ChatMessage.TYPE_QUERY, "", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "dataReceiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", AwarenessManagerImpl.ACTION_SUBSCRIBE, "unsubscribe", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface l {
    boolean a(f r1, k r2);

    boolean b(f r1, k r2);

    boolean query(f r1, k r2);
}
