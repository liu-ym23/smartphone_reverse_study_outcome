package com.obric.assistant.activation.presentation.runtime.surface;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceEvent;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "INITIAL", "CREATED", "REPLACED", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricRootSurfaceEvent extends Enum<ObricRootSurfaceEvent> {
    public static final ObricRootSurfaceEvent CREATED = null;
    public static final ObricRootSurfaceEvent INITIAL = null;
    public static final ObricRootSurfaceEvent REPLACED = null;
    public static final /* synthetic */ ObricRootSurfaceEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricRootSurfaceEvent> getEntries() {
        return b;
    }

    static {
        ObricRootSurfaceEvent r0 = new ObricRootSurfaceEvent("INITIAL", 0);
        INITIAL = r0;
        ObricRootSurfaceEvent r1 = new ObricRootSurfaceEvent("CREATED", 1);
        CREATED = r1;
        ObricRootSurfaceEvent r3 = new ObricRootSurfaceEvent("REPLACED", 2);
        REPLACED = r3;
        ObricRootSurfaceEvent[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ObricRootSurfaceEvent[] values() {
        return (ObricRootSurfaceEvent[]) a.clone();
    }

    public static ObricRootSurfaceEvent valueOf(String r1) {
        return (ObricRootSurfaceEvent) a.a(ObricRootSurfaceEvent.class, r1);
    }

    public ObricRootSurfaceEvent(String r1, int r2) {
        super(r1, r2);
    }
}
