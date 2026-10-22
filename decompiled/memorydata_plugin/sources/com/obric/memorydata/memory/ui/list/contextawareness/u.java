package com.obric.memorydata.memory.ui.list.contextawareness;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.fj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\u001a\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\b\u0012\u0004\u0012\u00020\r0\fH\u0002¨\u0006\u000e"}, d2 = {"mapScreenRecord", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "mapAudioRecord", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "toSqlFlag", "", "", "toLocalDateSet", "", "Ljava/time/LocalDate;", "", "", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class u {
    public static final /* synthetic */ int a(boolean r0) {
        return b(r0);
    }

    public static final /* synthetic */ t a(EpisodicMemoryEntity r0) {
        return b(r0);
    }

    public static final /* synthetic */ t a(fj r0) {
        return b(r0);
    }

    public static final /* synthetic */ Set a(List r2) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private static final int b(boolean r0) {
        return r0 ? 1 : 0;
    }

    private static final t b(EpisodicMemoryEntity r7) {
        return new t(ContextAwarenessTimelineSource.SCREEN_CONTENT, r7.getEntityId(), r7.getStartTimestamp(), (r) ZeusTransformUtils.preCheckCast(new r.b(r7), r.class, "com.obric.memorydata.plugin"));
    }

    private static final t b(fj r7) {
        return new t(ContextAwarenessTimelineSource.AMBIENT_AUDIO, r7.getEntityId(), r7.getCreateTime(), (r) ZeusTransformUtils.preCheckCast(new r.a(r7), r.class, "com.obric.memorydata.plugin"));
    }

    private static final Set<LocalDate> b(List<String> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        LocalDate r2 = LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"), DateTimeFormatter.ISO_LOCAL_DATE);     // Catch: DateTimeParseException -> L8
    L9:
        if (r2 == null) goto L4;
        r0.add(r2);
    L8:
        r2 = null;
        goto L9
    L12:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }
}
