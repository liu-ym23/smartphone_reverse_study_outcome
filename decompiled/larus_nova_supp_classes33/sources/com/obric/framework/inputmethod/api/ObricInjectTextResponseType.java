package com.obric.framework.inputmethod.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "ABNORMAL", "SECURE", "UNKNOWN", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricInjectTextResponseType extends Enum<ObricInjectTextResponseType> {
    public static final ObricInjectTextResponseType ABNORMAL = null;
    public static final ObricInjectTextResponseType NORMAL = null;
    public static final ObricInjectTextResponseType SECURE = null;
    public static final ObricInjectTextResponseType UNKNOWN = null;
    public static final /* synthetic */ ObricInjectTextResponseType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricInjectTextResponseType> getEntries() {
        return b;
    }

    static {
        ObricInjectTextResponseType r0 = new ObricInjectTextResponseType("NORMAL", 0);
        NORMAL = r0;
        ObricInjectTextResponseType r1 = new ObricInjectTextResponseType("ABNORMAL", 1);
        ABNORMAL = r1;
        ObricInjectTextResponseType r3 = new ObricInjectTextResponseType("SECURE", 2);
        SECURE = r3;
        ObricInjectTextResponseType r5 = new ObricInjectTextResponseType("UNKNOWN", 3);
        UNKNOWN = r5;
        ObricInjectTextResponseType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ObricInjectTextResponseType[] values() {
        return (ObricInjectTextResponseType[]) a.clone();
    }

    public static ObricInjectTextResponseType valueOf(String r1) {
        return (ObricInjectTextResponseType) a.a(ObricInjectTextResponseType.class, r1);
    }

    public ObricInjectTextResponseType(String r1, int r2) {
        super(r1, r2);
    }
}
