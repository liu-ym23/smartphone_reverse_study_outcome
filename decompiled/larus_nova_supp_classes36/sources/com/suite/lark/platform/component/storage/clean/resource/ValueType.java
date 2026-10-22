package com.suite.lark.platform.component.storage.clean.resource;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/ValueType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "INT", "LONG", "BOOLEAN", "STRING_SET", "FLOAT", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ValueType extends Enum<ValueType> {
    public static final ValueType BOOLEAN = null;
    public static final ValueType FLOAT = null;
    public static final ValueType INT = null;
    public static final ValueType LONG = null;
    public static final ValueType STRING = null;
    public static final ValueType STRING_SET = null;
    public static final /* synthetic */ ValueType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ValueType> getEntries() {
        return b;
    }

    static {
        ValueType r0 = new ValueType("STRING", 0);
        STRING = r0;
        ValueType r1 = new ValueType("INT", 1);
        INT = r1;
        ValueType r3 = new ValueType("LONG", 2);
        LONG = r3;
        ValueType r5 = new ValueType("BOOLEAN", 3);
        BOOLEAN = r5;
        ValueType r7 = new ValueType("STRING_SET", 4);
        STRING_SET = r7;
        ValueType r9 = new ValueType("FLOAT", 5);
        FLOAT = r9;
        ValueType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ValueType[] values() {
        return (ValueType[]) a.clone();
    }

    public static ValueType valueOf(String r1) {
        return (ValueType) a.a(ValueType.class, r1);
    }

    public ValueType(String r1, int r2) {
        super(r1, r2);
    }
}
