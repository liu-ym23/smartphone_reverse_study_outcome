package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaTokenStatus;", "", "<init>", "(Ljava/lang/String;I)V", "VALID", "INVALID", "UNKNOWN", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum FlowMfaTokenStatus extends Enum<FlowMfaTokenStatus> {
    public static final FlowMfaTokenStatus INVALID = null;
    public static final FlowMfaTokenStatus UNKNOWN = null;
    public static final FlowMfaTokenStatus VALID = null;
    public static final /* synthetic */ FlowMfaTokenStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowMfaTokenStatus> getEntries() {
        return b;
    }

    static {
        FlowMfaTokenStatus r0 = new FlowMfaTokenStatus("VALID", 0);
        VALID = r0;
        FlowMfaTokenStatus r1 = new FlowMfaTokenStatus("INVALID", 1);
        INVALID = r1;
        FlowMfaTokenStatus r3 = new FlowMfaTokenStatus("UNKNOWN", 2);
        UNKNOWN = r3;
        FlowMfaTokenStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FlowMfaTokenStatus[] values() {
        return (FlowMfaTokenStatus[]) a.clone();
    }

    public static FlowMfaTokenStatus valueOf(String r1) {
        return (FlowMfaTokenStatus) r27.a.a(FlowMfaTokenStatus.class, r1);
    }

    public FlowMfaTokenStatus(String r1, int r2) {
        super(r1, r2);
    }
}
