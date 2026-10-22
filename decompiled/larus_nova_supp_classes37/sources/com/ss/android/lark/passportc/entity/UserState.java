package com.ss.android.lark.passportc.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passportc/entity/UserState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "ABSENT", "OFFLINE", "ONLINE", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum UserState extends Enum<UserState> {
    public static final UserState ABSENT = null;
    public static final UserState OFFLINE = null;
    public static final UserState ONLINE = null;
    public static final /* synthetic */ UserState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int state;

    public static EnumEntries<UserState> getEntries() {
        return b;
    }

    static {
        UserState r0 = new UserState("ABSENT", 0, -1);
        ABSENT = r0;
        UserState r1 = new UserState("OFFLINE", 1, 0);
        OFFLINE = r1;
        UserState r2 = new UserState("ONLINE", 2, 1);
        ONLINE = r2;
        UserState[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UserState[] values() {
        return (UserState[]) a.clone();
    }

    public final int getState() {
        return this.state;
    }

    public static UserState valueOf(String r1) {
        return (UserState) a.a(UserState.class, r1);
    }

    public UserState(String r1, int r2, int r3) {
        super(r1, r2);
        this.state = r3;
    }
}
