package com.ss.android.lark.officesdk.di.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/DependencyContextUniqueId;", "", "<init>", "(Ljava/lang/String;I)V", "Global", "OfficeWebView", "Chameleon", "Doc", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum DependencyContextUniqueId extends Enum<DependencyContextUniqueId> {
    public static final DependencyContextUniqueId Chameleon = null;
    public static final DependencyContextUniqueId Doc = null;
    public static final DependencyContextUniqueId Global = null;
    public static final DependencyContextUniqueId OfficeWebView = null;
    public static final /* synthetic */ DependencyContextUniqueId[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DependencyContextUniqueId> getEntries() {
        return b;
    }

    static {
        DependencyContextUniqueId r0 = new DependencyContextUniqueId("Global", 0);
        Global = r0;
        DependencyContextUniqueId r1 = new DependencyContextUniqueId("OfficeWebView", 1);
        OfficeWebView = r1;
        DependencyContextUniqueId r3 = new DependencyContextUniqueId("Chameleon", 2);
        Chameleon = r3;
        DependencyContextUniqueId r5 = new DependencyContextUniqueId("Doc", 3);
        Doc = r5;
        DependencyContextUniqueId[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DependencyContextUniqueId[] values() {
        return (DependencyContextUniqueId[]) a.clone();
    }

    public static DependencyContextUniqueId valueOf(String r1) {
        return (DependencyContextUniqueId) r27.a.a(DependencyContextUniqueId.class, r1);
    }

    public DependencyContextUniqueId(String r1, int r2) {
        super(r1, r2);
    }
}
