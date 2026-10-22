package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$EventType;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SDK_PUSH", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ITransport$Ipc$EventType extends Enum<ITransport$Ipc$EventType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ITransport$Ipc$EventType[] $VALUES = null;
    public static final ITransport$Ipc$EventType SDK_PUSH = null;
    private final String value;

    private static final /* synthetic */ ITransport$Ipc$EventType[] $values() {
        return new ITransport$Ipc$EventType[]{SDK_PUSH};
    }

    public static EnumEntries<ITransport$Ipc$EventType> getEntries() {
        return $ENTRIES;
    }

    static {
        SDK_PUSH = new ITransport$Ipc$EventType("SDK_PUSH", 0, "SDK_PUSH");
        ITransport$Ipc$EventType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ITransport$Ipc$EventType[] values() {
        return (ITransport$Ipc$EventType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ITransport$Ipc$EventType valueOf(String r1) {
        return (ITransport$Ipc$EventType) r27.a.a(ITransport$Ipc$EventType.class, r1);
    }

    private ITransport$Ipc$EventType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
