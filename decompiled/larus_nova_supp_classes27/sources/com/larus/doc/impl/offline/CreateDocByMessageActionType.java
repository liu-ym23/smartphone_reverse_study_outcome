package com.larus.doc.impl.offline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/impl/offline/CreateDocByMessageActionType;", "", "<init>", "(Ljava/lang/String;I)V", "FORMAL", "COMPENSATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateDocByMessageActionType extends Enum<CreateDocByMessageActionType> {
    public static final CreateDocByMessageActionType COMPENSATE = null;
    public static final CreateDocByMessageActionType FORMAL = null;
    public static final /* synthetic */ CreateDocByMessageActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreateDocByMessageActionType> getEntries() {
        return b;
    }

    static {
        CreateDocByMessageActionType r0 = new CreateDocByMessageActionType("FORMAL", 0);
        FORMAL = r0;
        CreateDocByMessageActionType r1 = new CreateDocByMessageActionType("COMPENSATE", 1);
        COMPENSATE = r1;
        CreateDocByMessageActionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CreateDocByMessageActionType[] values() {
        return (CreateDocByMessageActionType[]) a.clone();
    }

    public static CreateDocByMessageActionType valueOf(String r1) {
        return (CreateDocByMessageActionType) r27.a.a(CreateDocByMessageActionType.class, r1);
    }

    public CreateDocByMessageActionType(String r1, int r2) {
        super(r1, r2);
    }
}
