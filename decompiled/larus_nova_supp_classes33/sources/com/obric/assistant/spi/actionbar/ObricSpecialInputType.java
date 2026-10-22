package com.obric.assistant.spi.actionbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/actionbar/ObricSpecialInputType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SPECIAL_INPUT", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSpecialInputType extends Enum<ObricSpecialInputType> {
    public static final ObricSpecialInputType SPECIAL_INPUT = null;
    public static final /* synthetic */ ObricSpecialInputType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<ObricSpecialInputType> getEntries() {
        return b;
    }

    static {
        ObricSpecialInputType r0 = new ObricSpecialInputType();
        SPECIAL_INPUT = r0;
        ObricSpecialInputType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public ObricSpecialInputType() {
        super("SPECIAL_INPUT", 0);
        this.type = -100;
    }

    public static ObricSpecialInputType[] values() {
        return (ObricSpecialInputType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static ObricSpecialInputType valueOf(String r1) {
        return (ObricSpecialInputType) a.a(ObricSpecialInputType.class, r1);
    }
}
