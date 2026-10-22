package com.obric.capabilitykit.entity.memory;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryServiceStatus;", "", "", "code", "I", "getCode", "()I", "AVAILABLE", "UNAVAILABLE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum MemoryServiceStatus extends Enum<MemoryServiceStatus> {
    public static final MemoryServiceStatus AVAILABLE = null;
    public static final MemoryServiceStatus UNAVAILABLE = null;
    public static final /* synthetic */ MemoryServiceStatus[] a = null;
    private final int code;

    static {
        MemoryServiceStatus r0 = new MemoryServiceStatus("AVAILABLE", 0, 0);
        AVAILABLE = r0;
        MemoryServiceStatus r1 = new MemoryServiceStatus("UNAVAILABLE", 1, 1);
        UNAVAILABLE = r1;
        a = new MemoryServiceStatus[]{r0, r1};
    }

    public MemoryServiceStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static MemoryServiceStatus valueOf(String r1) {
        return (MemoryServiceStatus) a.a(MemoryServiceStatus.class, r1);
    }

    public static MemoryServiceStatus[] values() {
        return (MemoryServiceStatus[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
