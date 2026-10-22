package com.obric.memorydata.memory.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H¦@¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H¦@¢\u0006\u0002\u0010\bJ\u001a\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H¦@¢\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H¦@¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/utils/ReentrantMutex;", "", "isLocked", "", "()Z", "lock", "", "owner", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock", "holdsLock", "holdCount", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface o {
    Object a(Object r1, Continuation<? super Unit> r2);

    Object b(Object r1, Continuation<? super Unit> r2);
}
