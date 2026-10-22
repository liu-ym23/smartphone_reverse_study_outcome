package com.obric.assistant.spi.complextask;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/complextask/ComplexTaskFoldStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CompleteFold", "HalfFold", "CompleteExpand", "None", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComplexTaskFoldStatus extends Enum<ComplexTaskFoldStatus> {
    public static final ComplexTaskFoldStatus CompleteExpand = null;
    public static final ComplexTaskFoldStatus CompleteFold = null;
    public static final ComplexTaskFoldStatus HalfFold = null;
    public static final ComplexTaskFoldStatus None = null;
    public static final /* synthetic */ ComplexTaskFoldStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ComplexTaskFoldStatus> getEntries() {
        return b;
    }

    static {
        ComplexTaskFoldStatus r0 = new ComplexTaskFoldStatus("CompleteFold", 0);
        CompleteFold = r0;
        ComplexTaskFoldStatus r1 = new ComplexTaskFoldStatus("HalfFold", 1);
        HalfFold = r1;
        ComplexTaskFoldStatus r3 = new ComplexTaskFoldStatus("CompleteExpand", 2);
        CompleteExpand = r3;
        ComplexTaskFoldStatus r5 = new ComplexTaskFoldStatus("None", 3);
        None = r5;
        ComplexTaskFoldStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ComplexTaskFoldStatus[] values() {
        return (ComplexTaskFoldStatus[]) a.clone();
    }

    public static ComplexTaskFoldStatus valueOf(String r1) {
        return (ComplexTaskFoldStatus) a.a(ComplexTaskFoldStatus.class, r1);
    }

    public ComplexTaskFoldStatus(String r1, int r2) {
        super(r1, r2);
    }
}
