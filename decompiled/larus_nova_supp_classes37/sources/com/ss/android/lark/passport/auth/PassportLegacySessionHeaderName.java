package com.ss.android.lark.passport.auth;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passport/auth/PassportLegacySessionHeaderName;", "", "<init>", "(Ljava/lang/String;I)V", "SUITE_SESSION_KEY", "SESSION_ID", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum PassportLegacySessionHeaderName extends Enum<PassportLegacySessionHeaderName> {
    public static final PassportLegacySessionHeaderName SESSION_ID = null;
    public static final PassportLegacySessionHeaderName SUITE_SESSION_KEY = null;
    public static final /* synthetic */ PassportLegacySessionHeaderName[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PassportLegacySessionHeaderName> getEntries() {
        return b;
    }

    static {
        PassportLegacySessionHeaderName r0 = new PassportLegacySessionHeaderName("SUITE_SESSION_KEY", 0);
        SUITE_SESSION_KEY = r0;
        PassportLegacySessionHeaderName r1 = new PassportLegacySessionHeaderName("SESSION_ID", 1);
        SESSION_ID = r1;
        PassportLegacySessionHeaderName[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PassportLegacySessionHeaderName[] values() {
        return (PassportLegacySessionHeaderName[]) a.clone();
    }

    public static PassportLegacySessionHeaderName valueOf(String r1) {
        return (PassportLegacySessionHeaderName) r27.a.a(PassportLegacySessionHeaderName.class, r1);
    }

    public PassportLegacySessionHeaderName(String r1, int r2) {
        super(r1, r2);
    }
}
