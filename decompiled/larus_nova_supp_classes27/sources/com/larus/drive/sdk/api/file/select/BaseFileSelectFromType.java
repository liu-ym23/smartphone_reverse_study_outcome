package com.larus.drive.sdk.api.file.select;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/sdk/api/file/select/BaseFileSelectFromType;", "", "<init>", "(Ljava/lang/String;I)V", "DRIVE", "RECENT", "LOCAL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BaseFileSelectFromType extends Enum<BaseFileSelectFromType> {
    public static final BaseFileSelectFromType DRIVE = null;
    public static final BaseFileSelectFromType LOCAL = null;
    public static final BaseFileSelectFromType RECENT = null;
    public static final /* synthetic */ BaseFileSelectFromType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BaseFileSelectFromType> getEntries() {
        return b;
    }

    static {
        BaseFileSelectFromType r0 = new BaseFileSelectFromType("DRIVE", 0);
        DRIVE = r0;
        BaseFileSelectFromType r1 = new BaseFileSelectFromType("RECENT", 1);
        RECENT = r1;
        BaseFileSelectFromType r3 = new BaseFileSelectFromType("LOCAL", 2);
        LOCAL = r3;
        BaseFileSelectFromType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BaseFileSelectFromType[] values() {
        return (BaseFileSelectFromType[]) a.clone();
    }

    public static BaseFileSelectFromType valueOf(String r1) {
        return (BaseFileSelectFromType) a.a(BaseFileSelectFromType.class, r1);
    }

    public BaseFileSelectFromType(String r1, int r2) {
        super(r1, r2);
    }
}
