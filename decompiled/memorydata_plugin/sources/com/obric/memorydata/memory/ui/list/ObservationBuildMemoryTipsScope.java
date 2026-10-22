package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ObservationBuildMemoryTipsScope;", "", "sources", "", "", "terminalStates", "refreshOldestObservationCutoff", "", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Z)V", "getSources", "()Ljava/util/List;", "getTerminalStates", "getRefreshOldestObservationCutoff", "()Z", "SCREEN_OBSERVATION", "CONTEXT_AWARENESS", "isAnySourceEnabled", "screenObservationEnabled", "glassesObservationEnabled", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ObservationBuildMemoryTipsScope extends Enum<ObservationBuildMemoryTipsScope> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObservationBuildMemoryTipsScope[] $VALUES = null;
    public static final ObservationBuildMemoryTipsScope CONTEXT_AWARENESS = null;
    public static final ObservationBuildMemoryTipsScope SCREEN_OBSERVATION = null;
    private final boolean refreshOldestObservationCutoff;
    private final List<String> sources;
    private final List<String> terminalStates;

    private static final /* synthetic */ ObservationBuildMemoryTipsScope[] $values() {
        return new ObservationBuildMemoryTipsScope[]{SCREEN_OBSERVATION, CONTEXT_AWARENESS};
    }

    static {
        SCREEN_OBSERVATION = new ObservationBuildMemoryTipsScope("SCREEN_OBSERVATION", 0, CollectionsKt.listOf("screenshot"), CollectionsKt.listOf("DONE"), false);
        CONTEXT_AWARENESS = new ObservationBuildMemoryTipsScope("CONTEXT_AWARENESS", 1, CollectionsKt.listOf(new String[]{"screenshot", "glasses", "auditory"}), CollectionsKt.listOf(new String[]{"DONE", RawObservationEntity.STATE_FAILED}), true);
        ObservationBuildMemoryTipsScope[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ObservationBuildMemoryTipsScope(String r3, int r4, List r5, List r6, boolean r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.sources = r8;
        this.terminalStates = r9;
        this.refreshOldestObservationCutoff = r7;
    }

    public static EnumEntries<ObservationBuildMemoryTipsScope> getEntries() {
        return $ENTRIES;
    }

    public static ObservationBuildMemoryTipsScope valueOf(String r2) {
        return (ObservationBuildMemoryTipsScope) ZeusTransformUtils.preCheckCast(Enum.valueOf(ObservationBuildMemoryTipsScope.class, r2), ObservationBuildMemoryTipsScope.class, "com.obric.memorydata.plugin");
    }

    public static ObservationBuildMemoryTipsScope[] values() {
        return (ObservationBuildMemoryTipsScope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ObservationBuildMemoryTipsScope[].class, "com.obric.memorydata.plugin");
    }

    public final boolean getRefreshOldestObservationCutoff() {
        return this.refreshOldestObservationCutoff;
    }

    public final List<String> getSources() {
        return this.sources;
    }

    public final List<String> getTerminalStates() {
        return this.terminalStates;
    }

    public final boolean isAnySourceEnabled(boolean r5, boolean r6) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.sources, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r4.iterator();
    L9:
        if (r7.hasNext() == false) goto L27;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r0, "screenshot") == false) goto L14;
        boolean r1 = r5;
    L17:
        if (r1 == false) goto L9;
        return true;
    L14:
        if (Intrinsics.areEqual(r0, "glasses") == false) goto L16;
        r1 = r6;
        goto L17
    L16:
        r1 = false;
        goto L17
    L27:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }
}
