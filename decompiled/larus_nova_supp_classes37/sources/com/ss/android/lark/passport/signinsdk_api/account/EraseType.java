package com.ss.android.lark.passport.signinsdk_api.account;

import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutSceneKey;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/account/EraseType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LOGOUT_ALL", "DEEP_CLEAN", "ADMIN_KICKOUT_WIPE", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum EraseType extends Enum<EraseType> {
    public static final EraseType ADMIN_KICKOUT_WIPE = null;
    public static final EraseType DEEP_CLEAN = null;
    public static final EraseType LOGOUT_ALL = null;
    public static final /* synthetic */ EraseType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<EraseType> getEntries() {
        return b;
    }

    static {
        EraseType r0 = new EraseType("LOGOUT_ALL", 0, "logout_all");
        LOGOUT_ALL = r0;
        EraseType r1 = new EraseType("DEEP_CLEAN", 1, "deep_clean");
        DEEP_CLEAN = r1;
        EraseType r2 = new EraseType("ADMIN_KICKOUT_WIPE", 2, LogoutSceneKey.ADMIN_KICKOUT_WIPE);
        ADMIN_KICKOUT_WIPE = r2;
        EraseType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static EraseType[] values() {
        return (EraseType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static EraseType valueOf(String r1) {
        return (EraseType) a.a(EraseType.class, r1);
    }

    public EraseType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
