package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageStatus;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BadUserId", "DbFail", "Fail", "NotFound", "Ok", "ValueTooLarge", "ValueTotalTooLarge", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IStorage$Internal$StorageStatus extends Enum<IStorage$Internal$StorageStatus> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IStorage$Internal$StorageStatus[] $VALUES = null;
    public static final IStorage$Internal$StorageStatus BadUserId = null;
    public static final IStorage$Internal$StorageStatus DbFail = null;
    public static final IStorage$Internal$StorageStatus Fail = null;
    public static final IStorage$Internal$StorageStatus NotFound = null;
    public static final IStorage$Internal$StorageStatus Ok = null;
    public static final IStorage$Internal$StorageStatus ValueTooLarge = null;
    public static final IStorage$Internal$StorageStatus ValueTotalTooLarge = null;
    private final String value;

    private static final /* synthetic */ IStorage$Internal$StorageStatus[] $values() {
        return new IStorage$Internal$StorageStatus[]{BadUserId, DbFail, Fail, NotFound, Ok, ValueTooLarge, ValueTotalTooLarge};
    }

    public static EnumEntries<IStorage$Internal$StorageStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        BadUserId = new IStorage$Internal$StorageStatus("BadUserId", 0, "bad-user-id");
        DbFail = new IStorage$Internal$StorageStatus("DbFail", 1, "db-fail");
        Fail = new IStorage$Internal$StorageStatus("Fail", 2, "fail");
        NotFound = new IStorage$Internal$StorageStatus("NotFound", 3, "not-found");
        Ok = new IStorage$Internal$StorageStatus("Ok", 4, "ok");
        ValueTooLarge = new IStorage$Internal$StorageStatus("ValueTooLarge", 5, "value-too-large");
        ValueTotalTooLarge = new IStorage$Internal$StorageStatus("ValueTotalTooLarge", 6, "value-total-too-large");
        IStorage$Internal$StorageStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static IStorage$Internal$StorageStatus[] values() {
        return (IStorage$Internal$StorageStatus[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IStorage$Internal$StorageStatus valueOf(String r1) {
        return (IStorage$Internal$StorageStatus) a.a(IStorage$Internal$StorageStatus.class, r1);
    }

    private IStorage$Internal$StorageStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
