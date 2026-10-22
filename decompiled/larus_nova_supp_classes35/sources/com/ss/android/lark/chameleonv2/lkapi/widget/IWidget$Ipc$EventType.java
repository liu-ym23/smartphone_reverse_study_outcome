package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Ipc$EventType;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONFIRM_DIALOG_CLOSED", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IWidget$Ipc$EventType extends Enum<IWidget$Ipc$EventType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IWidget$Ipc$EventType[] $VALUES = null;
    public static final IWidget$Ipc$EventType CONFIRM_DIALOG_CLOSED = null;
    private final String value;

    private static final /* synthetic */ IWidget$Ipc$EventType[] $values() {
        return new IWidget$Ipc$EventType[]{CONFIRM_DIALOG_CLOSED};
    }

    public static EnumEntries<IWidget$Ipc$EventType> getEntries() {
        return $ENTRIES;
    }

    static {
        CONFIRM_DIALOG_CLOSED = new IWidget$Ipc$EventType("CONFIRM_DIALOG_CLOSED", 0, "CONFIRM_DIALOG_CLOSED");
        IWidget$Ipc$EventType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static IWidget$Ipc$EventType[] values() {
        return (IWidget$Ipc$EventType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IWidget$Ipc$EventType valueOf(String r1) {
        return (IWidget$Ipc$EventType) a.a(IWidget$Ipc$EventType.class, r1);
    }

    private IWidget$Ipc$EventType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
