package com.bytedance.ai.bridge.context;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/context/RefType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "WEAK", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RefType extends Enum<RefType> {
    public static final RefType NORMAL = null;
    public static final RefType WEAK = null;
    public static final /* synthetic */ RefType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RefType> getEntries() {
        return b;
    }

    static {
        RefType r0 = new RefType("NORMAL", 0);
        NORMAL = r0;
        RefType r1 = new RefType("WEAK", 1);
        WEAK = r1;
        RefType[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static RefType[] values() {
        return (RefType[]) a.clone();
    }

    public static RefType valueOf(String r1) {
        return (RefType) a.a(RefType.class, r1);
    }

    public RefType(String r1, int r10) {
        super(r1, r10);
    }
}
