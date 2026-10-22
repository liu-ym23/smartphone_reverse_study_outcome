package com.ss.android.lark.chameleonv2.lkapi.ui;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$Ipc$EventType;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "THEME_EVENT", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IUI$Ipc$EventType extends Enum<IUI$Ipc$EventType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IUI$Ipc$EventType[] $VALUES = null;
    public static final IUI$Ipc$EventType THEME_EVENT = null;
    private final String value;

    private static final /* synthetic */ IUI$Ipc$EventType[] $values() {
        return new IUI$Ipc$EventType[]{THEME_EVENT};
    }

    public static EnumEntries<IUI$Ipc$EventType> getEntries() {
        return $ENTRIES;
    }

    static {
        THEME_EVENT = new IUI$Ipc$EventType("THEME_EVENT", 0, "THEME_EVENT");
        IUI$Ipc$EventType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static IUI$Ipc$EventType[] values() {
        return (IUI$Ipc$EventType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IUI$Ipc$EventType valueOf(String r1) {
        return (IUI$Ipc$EventType) a.a(IUI$Ipc$EventType.class, r1);
    }

    private IUI$Ipc$EventType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
