package com.ss.android.lark.passportc.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passportc/api/ExecuteStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "RETRY", "ROLLBACK", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ExecuteStrategy extends Enum<ExecuteStrategy> {
    public static final ExecuteStrategy NORMAL = null;
    public static final ExecuteStrategy RETRY = null;
    public static final ExecuteStrategy ROLLBACK = null;
    public static final /* synthetic */ ExecuteStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExecuteStrategy> getEntries() {
        return b;
    }

    static {
        ExecuteStrategy r0 = new ExecuteStrategy("NORMAL", 0);
        NORMAL = r0;
        ExecuteStrategy r1 = new ExecuteStrategy("RETRY", 1);
        RETRY = r1;
        ExecuteStrategy r3 = new ExecuteStrategy("ROLLBACK", 2);
        ROLLBACK = r3;
        ExecuteStrategy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ExecuteStrategy[] values() {
        return (ExecuteStrategy[]) a.clone();
    }

    public static ExecuteStrategy valueOf(String r1) {
        return (ExecuteStrategy) r27.a.a(ExecuteStrategy.class, r1);
    }

    public ExecuteStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
