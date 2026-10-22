package com.obric.assistant.live.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/live/util/ObricIslandType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMPLEX_TASK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricIslandType extends Enum<ObricIslandType> {
    public static final ObricIslandType COMPLEX_TASK = null;
    public static final /* synthetic */ ObricIslandType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ObricIslandType> getEntries() {
        return b;
    }

    static {
        ObricIslandType r0 = new ObricIslandType();
        COMPLEX_TASK = r0;
        ObricIslandType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public ObricIslandType() {
        super("COMPLEX_TASK", 0);
        this.value = "complex_task";
    }

    public static ObricIslandType[] values() {
        return (ObricIslandType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ObricIslandType valueOf(String r1) {
        return (ObricIslandType) a.a(ObricIslandType.class, r1);
    }
}
