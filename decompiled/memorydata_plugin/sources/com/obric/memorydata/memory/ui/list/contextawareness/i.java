package com.obric.memorydata.memory.ui.list.contextawareness;

import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.cu;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000fJ2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessScreenPageSource;", "", ChatMessage.TYPE_QUERY, "", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "cursor", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessSourceCursor;", "limit", "", "queryBefore", "recordedDateStrings", "", "findEventTime", "", "entityId", "(Ljava/lang/String;)Ljava/lang/Long;", "querySelectionMetaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "dayRange", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "ids", "withSpecifiedRange", "", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeCount", "Lkotlinx/coroutines/flow/Flow;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface i {
    Long a(String r1);

    Object a(d r1, List<String> r2, boolean r3, Continuation<? super List<cu>> r4);

    List<String> a();

    List<t> a(k r1, int r2);

    kotlinx.coroutines.flow.i<Integer> a(d r1);

    List<t> query(k r1, int r2);
}
