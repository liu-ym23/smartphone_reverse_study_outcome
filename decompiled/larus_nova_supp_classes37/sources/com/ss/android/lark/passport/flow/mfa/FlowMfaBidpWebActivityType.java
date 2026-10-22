package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaBidpWebActivityType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL_AUTH", "EXTERNAL_BROWSER_LOADING", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum FlowMfaBidpWebActivityType extends Enum<FlowMfaBidpWebActivityType> {
    public static final FlowMfaBidpWebActivityType EXTERNAL_BROWSER_LOADING = null;
    public static final FlowMfaBidpWebActivityType INTERNAL_AUTH = null;
    public static final /* synthetic */ FlowMfaBidpWebActivityType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowMfaBidpWebActivityType> getEntries() {
        return b;
    }

    static {
        FlowMfaBidpWebActivityType r0 = new FlowMfaBidpWebActivityType("INTERNAL_AUTH", 0);
        INTERNAL_AUTH = r0;
        FlowMfaBidpWebActivityType r1 = new FlowMfaBidpWebActivityType("EXTERNAL_BROWSER_LOADING", 1);
        EXTERNAL_BROWSER_LOADING = r1;
        FlowMfaBidpWebActivityType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static FlowMfaBidpWebActivityType[] values() {
        return (FlowMfaBidpWebActivityType[]) a.clone();
    }

    public static FlowMfaBidpWebActivityType valueOf(String r1) {
        return (FlowMfaBidpWebActivityType) r27.a.a(FlowMfaBidpWebActivityType.class, r1);
    }

    public FlowMfaBidpWebActivityType(String r1, int r2) {
        super(r1, r2);
    }
}
