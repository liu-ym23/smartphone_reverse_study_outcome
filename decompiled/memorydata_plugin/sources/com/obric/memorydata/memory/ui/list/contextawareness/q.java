package com.obric.memorydata.memory.ui.list.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.cu;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J@\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePageRepository;", "", "queryPage", "", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "dayRange", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "cursor", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineCursor;", "limit", "", "queryPageBefore", "recordedDates", "", "Ljava/time/LocalDate;", "resolveTargetDate", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "zoneId", "Ljava/time/ZoneId;", "querySelectionMetaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "screenIds", "", "audioIds", "withSpecifiedRange", "", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;Ljava/util/List;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTotalCount", "Lkotlinx/coroutines/flow/Flow;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface q {
    Object a(d r1, List<String> r2, List<String> r3, boolean r4, Continuation<? super List<cu>> r5);

    LocalDate a(v r1, ZoneId r2);

    List<t> a(d r1, p r2, int r3);

    Set<LocalDate> a();

    kotlinx.coroutines.flow.i<Integer> a(d r1);

    List<t> b(d r1, p r2, int r3);
}
