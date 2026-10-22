package com.obric.assistant.session.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/session/bean/ActivateEventType;", "", "<init>", "(Ljava/lang/String;I)V", "SinglePress", "DoublePress", "LongPress", "Other", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActivateEventType extends Enum<ActivateEventType> {
    public static final ActivateEventType DoublePress = null;
    public static final ActivateEventType LongPress = null;
    public static final ActivateEventType Other = null;
    public static final ActivateEventType SinglePress = null;
    public static final /* synthetic */ ActivateEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActivateEventType> getEntries() {
        return b;
    }

    static {
        ActivateEventType r0 = new ActivateEventType("SinglePress", 0);
        SinglePress = r0;
        ActivateEventType r1 = new ActivateEventType("DoublePress", 1);
        DoublePress = r1;
        ActivateEventType r3 = new ActivateEventType("LongPress", 2);
        LongPress = r3;
        ActivateEventType r5 = new ActivateEventType("Other", 3);
        Other = r5;
        ActivateEventType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ActivateEventType[] values() {
        return (ActivateEventType[]) a.clone();
    }

    public static ActivateEventType valueOf(String r1) {
        return (ActivateEventType) a.a(ActivateEventType.class, r1);
    }

    public ActivateEventType(String r1, int r2) {
        super(r1, r2);
    }
}
