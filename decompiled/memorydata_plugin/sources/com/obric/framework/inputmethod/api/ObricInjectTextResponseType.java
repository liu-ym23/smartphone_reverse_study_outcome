package com.obric.framework.inputmethod.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "ABNORMAL", "SECURE", "UNKNOWN", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ObricInjectTextResponseType extends Enum<ObricInjectTextResponseType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricInjectTextResponseType[] $VALUES = null;
    public static final ObricInjectTextResponseType ABNORMAL = null;
    public static final ObricInjectTextResponseType NORMAL = null;
    public static final ObricInjectTextResponseType SECURE = null;
    public static final ObricInjectTextResponseType UNKNOWN = null;

    private static final /* synthetic */ ObricInjectTextResponseType[] $values() {
        return new ObricInjectTextResponseType[]{NORMAL, ABNORMAL, SECURE, UNKNOWN};
    }

    static {
        NORMAL = new ObricInjectTextResponseType("NORMAL", 0);
        ABNORMAL = new ObricInjectTextResponseType("ABNORMAL", 1);
        SECURE = new ObricInjectTextResponseType("SECURE", 2);
        UNKNOWN = new ObricInjectTextResponseType("UNKNOWN", 3);
        ObricInjectTextResponseType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ObricInjectTextResponseType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ObricInjectTextResponseType> getEntries() {
        return $ENTRIES;
    }

    public static ObricInjectTextResponseType valueOf(String r2) {
        return (ObricInjectTextResponseType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ObricInjectTextResponseType.class, r2), ObricInjectTextResponseType.class, "com.obric.memorydata.plugin");
    }

    public static ObricInjectTextResponseType[] values() {
        return (ObricInjectTextResponseType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ObricInjectTextResponseType[].class, "com.obric.memorydata.plugin");
    }
}
