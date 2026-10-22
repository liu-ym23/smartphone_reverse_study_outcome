package com.ss.android.lark.coremd.span.list;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/coremd/span/list/ListHeadType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ListHead", "VirtualHead", "None", "core-md_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ListHeadType extends Enum<ListHeadType> {
    public static final ListHeadType ListHead = null;
    public static final ListHeadType None = null;
    public static final ListHeadType VirtualHead = null;
    public static final /* synthetic */ ListHeadType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ListHeadType> getEntries() {
        return b;
    }

    static {
        ListHeadType r0 = new ListHeadType("ListHead", 0);
        ListHead = r0;
        ListHeadType r1 = new ListHeadType("VirtualHead", 1);
        VirtualHead = r1;
        ListHeadType r3 = new ListHeadType("None", 2);
        None = r3;
        ListHeadType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ListHeadType[] values() {
        return (ListHeadType[]) a.clone();
    }

    public static ListHeadType valueOf(String r1) {
        return (ListHeadType) a.a(ListHeadType.class, r1);
    }

    public ListHeadType(String r1, int r2) {
        super(r1, r2);
    }
}
