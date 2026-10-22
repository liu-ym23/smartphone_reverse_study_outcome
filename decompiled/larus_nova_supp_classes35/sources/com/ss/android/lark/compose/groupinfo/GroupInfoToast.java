package com.ss.android.lark.compose.groupinfo;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/compose/groupinfo/GroupInfoToast;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SAVE_SUCCESS", "EDIT_NOT_ALLOWED", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GroupInfoToast extends Enum<GroupInfoToast> {
    public static final GroupInfoToast EDIT_NOT_ALLOWED = null;
    public static final GroupInfoToast SAVE_SUCCESS = null;
    public static final /* synthetic */ GroupInfoToast[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<GroupInfoToast> getEntries() {
        return b;
    }

    static {
        GroupInfoToast r0 = new GroupInfoToast("SAVE_SUCCESS", 0);
        SAVE_SUCCESS = r0;
        GroupInfoToast r1 = new GroupInfoToast("EDIT_NOT_ALLOWED", 1);
        EDIT_NOT_ALLOWED = r1;
        GroupInfoToast[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static GroupInfoToast[] values() {
        return (GroupInfoToast[]) a.clone();
    }

    public static GroupInfoToast valueOf(String r1) {
        return (GroupInfoToast) r27.a.a(GroupInfoToast.class, r1);
    }

    public GroupInfoToast(String r1, int r2) {
        super(r1, r2);
    }
}
