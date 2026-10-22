package com.obric.assistant.interaction.base.model;

import com.obric.assistant.interaction.base.interact.IStatable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;", "Lcom/obric/assistant/interaction/base/interact/IStatable;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "VISIBLE", "INVISIBLE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AssistantActivityVisibleState extends Enum<AssistantActivityVisibleState> implements IStatable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AssistantActivityVisibleState[] $VALUES = null;
    public static final AssistantActivityVisibleState INVISIBLE = null;
    public static final AssistantActivityVisibleState NA = null;
    public static final AssistantActivityVisibleState VISIBLE = null;

    private static final /* synthetic */ AssistantActivityVisibleState[] $values() {
        return new AssistantActivityVisibleState[]{NA, VISIBLE, INVISIBLE};
    }

    public static EnumEntries<AssistantActivityVisibleState> getEntries() {
        return $ENTRIES;
    }

    static {
        NA = new AssistantActivityVisibleState("NA", 0);
        VISIBLE = new AssistantActivityVisibleState("VISIBLE", 1);
        INVISIBLE = new AssistantActivityVisibleState("INVISIBLE", 2);
        AssistantActivityVisibleState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static AssistantActivityVisibleState[] values() {
        return (AssistantActivityVisibleState[]) $VALUES.clone();
    }

    public static AssistantActivityVisibleState valueOf(String r1) {
        return (AssistantActivityVisibleState) a.a(AssistantActivityVisibleState.class, r1);
    }

    private AssistantActivityVisibleState(String r1, int r2) {
        super(r1, r2);
    }
}
