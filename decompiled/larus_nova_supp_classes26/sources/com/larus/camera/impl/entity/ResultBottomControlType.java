package com.larus.camera.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/camera/impl/entity/ResultBottomControlType;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIRM", "INPUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultBottomControlType extends Enum<ResultBottomControlType> {
    public static final ResultBottomControlType CONFIRM = null;
    public static final ResultBottomControlType INPUT = null;
    public static final /* synthetic */ ResultBottomControlType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResultBottomControlType> getEntries() {
        return b;
    }

    static {
        ResultBottomControlType r0 = new ResultBottomControlType("CONFIRM", 0);
        CONFIRM = r0;
        ResultBottomControlType r1 = new ResultBottomControlType("INPUT", 1);
        INPUT = r1;
        ResultBottomControlType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ResultBottomControlType[] values() {
        return (ResultBottomControlType[]) a.clone();
    }

    public static ResultBottomControlType valueOf(String r1) {
        return (ResultBottomControlType) a.a(ResultBottomControlType.class, r1);
    }

    public ResultBottomControlType(String r1, int r2) {
        super(r1, r2);
    }
}
