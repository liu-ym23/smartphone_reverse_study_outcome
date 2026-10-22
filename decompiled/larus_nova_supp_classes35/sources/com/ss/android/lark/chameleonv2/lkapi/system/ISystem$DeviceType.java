package com.ss.android.lark.chameleonv2.lkapi.system;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceType;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Phone", "Pad", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ISystem$DeviceType extends Enum<ISystem$DeviceType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ISystem$DeviceType[] $VALUES = null;
    public static final ISystem$DeviceType Pad = null;
    public static final ISystem$DeviceType Phone = null;
    private final String value;

    private static final /* synthetic */ ISystem$DeviceType[] $values() {
        return new ISystem$DeviceType[]{Phone, Pad};
    }

    public static EnumEntries<ISystem$DeviceType> getEntries() {
        return $ENTRIES;
    }

    static {
        Phone = new ISystem$DeviceType("Phone", 0, CommonCmd.AIDL_PLATFORM_TYPE_PHONE);
        Pad = new ISystem$DeviceType("Pad", 1, CommonCmd.AIDL_PLATFORM_TYPE_PAD);
        ISystem$DeviceType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ISystem$DeviceType[] values() {
        return (ISystem$DeviceType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ISystem$DeviceType valueOf(String r1) {
        return (ISystem$DeviceType) a.a(ISystem$DeviceType.class, r1);
    }

    private ISystem$DeviceType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
