package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/lark/kmp/basic/ReturnType;", "", "<init>", "(Ljava/lang/String;I)V", "QUICK_ONLINE_RETURN", "Foreground", "All", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReturnType extends Enum<ReturnType> {
    public static final ReturnType All = null;
    public static final ReturnType Foreground = null;
    public static final ReturnType QUICK_ONLINE_RETURN = null;
    public static final /* synthetic */ ReturnType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReturnType> getEntries() {
        return b;
    }

    static {
        ReturnType r0 = new ReturnType("QUICK_ONLINE_RETURN", 0);
        QUICK_ONLINE_RETURN = r0;
        ReturnType r1 = new ReturnType("Foreground", 1);
        Foreground = r1;
        ReturnType r10 = new ReturnType("All", 2);
        All = r10;
        ReturnType[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ReturnType[] values() {
        return (ReturnType[]) a.clone();
    }

    public static ReturnType valueOf(String r1) {
        return (ReturnType) a.a(ReturnType.class, r1);
    }

    public ReturnType(String r1, int r10) {
        super(r1, r10);
    }
}
