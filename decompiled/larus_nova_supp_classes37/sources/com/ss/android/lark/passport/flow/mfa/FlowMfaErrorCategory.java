package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_ARGUMENT", "BUSY", "USER_CANCEL", "UNSUPPORTED_THIRD_PARTY_MFA", "UNSUPPORTED_STEP", "NO_SUPPORTED_VERIFY_FACTOR", "UNSUPPORTED_IDP_CHANNEL", "PASSWORD_ENCRYPT_FAILED", "PROCESS_RECREATED", "USER_CHANGED", "AUTH_EXPIRED", "SERVER", "NETWORK", "INTERNAL", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum FlowMfaErrorCategory extends Enum<FlowMfaErrorCategory> {
    public static final FlowMfaErrorCategory AUTH_EXPIRED = null;
    public static final FlowMfaErrorCategory BUSY = null;
    public static final FlowMfaErrorCategory INTERNAL = null;
    public static final FlowMfaErrorCategory INVALID_ARGUMENT = null;
    public static final FlowMfaErrorCategory NETWORK = null;
    public static final FlowMfaErrorCategory NO_SUPPORTED_VERIFY_FACTOR = null;
    public static final FlowMfaErrorCategory PASSWORD_ENCRYPT_FAILED = null;
    public static final FlowMfaErrorCategory PROCESS_RECREATED = null;
    public static final FlowMfaErrorCategory SERVER = null;
    public static final FlowMfaErrorCategory UNSUPPORTED_IDP_CHANNEL = null;
    public static final FlowMfaErrorCategory UNSUPPORTED_STEP = null;
    public static final FlowMfaErrorCategory UNSUPPORTED_THIRD_PARTY_MFA = null;
    public static final FlowMfaErrorCategory USER_CANCEL = null;
    public static final FlowMfaErrorCategory USER_CHANGED = null;
    public static final /* synthetic */ FlowMfaErrorCategory[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowMfaErrorCategory> getEntries() {
        return b;
    }

    static {
        FlowMfaErrorCategory r0 = new FlowMfaErrorCategory("INVALID_ARGUMENT", 0);
        INVALID_ARGUMENT = r0;
        FlowMfaErrorCategory r1 = new FlowMfaErrorCategory("BUSY", 1);
        BUSY = r1;
        FlowMfaErrorCategory r3 = new FlowMfaErrorCategory("USER_CANCEL", 2);
        USER_CANCEL = r3;
        FlowMfaErrorCategory r5 = new FlowMfaErrorCategory("UNSUPPORTED_THIRD_PARTY_MFA", 3);
        UNSUPPORTED_THIRD_PARTY_MFA = r5;
        FlowMfaErrorCategory r7 = new FlowMfaErrorCategory("UNSUPPORTED_STEP", 4);
        UNSUPPORTED_STEP = r7;
        FlowMfaErrorCategory r9 = new FlowMfaErrorCategory("NO_SUPPORTED_VERIFY_FACTOR", 5);
        NO_SUPPORTED_VERIFY_FACTOR = r9;
        FlowMfaErrorCategory r11 = new FlowMfaErrorCategory("UNSUPPORTED_IDP_CHANNEL", 6);
        UNSUPPORTED_IDP_CHANNEL = r11;
        FlowMfaErrorCategory r13 = new FlowMfaErrorCategory("PASSWORD_ENCRYPT_FAILED", 7);
        PASSWORD_ENCRYPT_FAILED = r13;
        FlowMfaErrorCategory r15 = new FlowMfaErrorCategory("PROCESS_RECREATED", 8);
        PROCESS_RECREATED = r15;
        FlowMfaErrorCategory r14 = new FlowMfaErrorCategory("USER_CHANGED", 9);
        USER_CHANGED = r14;
        FlowMfaErrorCategory r12 = new FlowMfaErrorCategory("AUTH_EXPIRED", 10);
        AUTH_EXPIRED = r12;
        FlowMfaErrorCategory r10 = new FlowMfaErrorCategory("SERVER", 11);
        SERVER = r10;
        FlowMfaErrorCategory r8 = new FlowMfaErrorCategory("NETWORK", 12);
        NETWORK = r8;
        FlowMfaErrorCategory r6 = new FlowMfaErrorCategory("INTERNAL", 13);
        INTERNAL = r6;
        FlowMfaErrorCategory[] r4 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static FlowMfaErrorCategory[] values() {
        return (FlowMfaErrorCategory[]) a.clone();
    }

    public static FlowMfaErrorCategory valueOf(String r1) {
        return (FlowMfaErrorCategory) r27.a.a(FlowMfaErrorCategory.class, r1);
    }

    public FlowMfaErrorCategory(String r1, int r2) {
        super(r1, r2);
    }
}
