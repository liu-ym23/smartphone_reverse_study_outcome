package com.larus.e_commerce.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/e_commerce/api/ECNotifyBinderDialogType;", "", "<init>", "(Ljava/lang/String;I)V", "CheckNeedBinder", "NotifyBinder", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECNotifyBinderDialogType extends Enum<ECNotifyBinderDialogType> {
    public static final ECNotifyBinderDialogType CheckNeedBinder = null;
    public static final ECNotifyBinderDialogType NotifyBinder = null;
    public static final /* synthetic */ ECNotifyBinderDialogType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ECNotifyBinderDialogType> getEntries() {
        return b;
    }

    static {
        ECNotifyBinderDialogType r0 = new ECNotifyBinderDialogType("CheckNeedBinder", 0);
        CheckNeedBinder = r0;
        ECNotifyBinderDialogType r1 = new ECNotifyBinderDialogType("NotifyBinder", 1);
        NotifyBinder = r1;
        ECNotifyBinderDialogType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ECNotifyBinderDialogType[] values() {
        return (ECNotifyBinderDialogType[]) a.clone();
    }

    public static ECNotifyBinderDialogType valueOf(String r1) {
        return (ECNotifyBinderDialogType) r27.a.a(ECNotifyBinderDialogType.class, r1);
    }

    public ECNotifyBinderDialogType(String r1, int r2) {
        super(r1, r2);
    }
}
