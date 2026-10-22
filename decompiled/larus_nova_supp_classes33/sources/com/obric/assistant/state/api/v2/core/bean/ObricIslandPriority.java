package com.obric.assistant.state.api.v2.core.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", "HIGH", "MEDIUM", "LOW", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricIslandPriority extends Enum<ObricIslandPriority> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricIslandPriority[] $VALUES = null;
    public static final ObricIslandPriority HIGH = null;
    public static final ObricIslandPriority LOW = null;
    public static final ObricIslandPriority MEDIUM = null;
    private final int order;

    private static final /* synthetic */ ObricIslandPriority[] $values() {
        return new ObricIslandPriority[]{HIGH, MEDIUM, LOW};
    }

    public static EnumEntries<ObricIslandPriority> getEntries() {
        return $ENTRIES;
    }

    static {
        HIGH = new ObricIslandPriority("HIGH", 0, 1);
        MEDIUM = new ObricIslandPriority("MEDIUM", 1, 2);
        LOW = new ObricIslandPriority("LOW", 2, 3);
        ObricIslandPriority[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ObricIslandPriority[] values() {
        return (ObricIslandPriority[]) $VALUES.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static ObricIslandPriority valueOf(String r1) {
        return (ObricIslandPriority) a.a(ObricIslandPriority.class, r1);
    }

    private ObricIslandPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.order = r3;
    }
}
