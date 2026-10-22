package com.bytedance.ies.xbridge.model.idl;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/xbridge/model/idl/XDynamicType;", "", "(Ljava/lang/String;I)V", "Null", "Boolean", "Int", "Number", "String", "Map", "Array", "Long", "ByteArray", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum XDynamicType extends Enum<XDynamicType> {
    private static final /* synthetic */ XDynamicType[] $VALUES = null;
    public static final XDynamicType Array = null;
    public static final XDynamicType Boolean = null;
    public static final XDynamicType ByteArray = null;
    public static final XDynamicType Int = null;
    public static final XDynamicType Long = null;
    public static final XDynamicType Map = null;
    public static final XDynamicType Null = null;
    public static final XDynamicType Number = null;
    public static final XDynamicType String = null;

    private static final /* synthetic */ XDynamicType[] $values() {
        return new XDynamicType[]{Null, Boolean, Int, Number, String, Map, Array, Long, ByteArray};
    }

    static {
        Null = new XDynamicType("Null", 0);
        Boolean = new XDynamicType("Boolean", 1);
        Int = new XDynamicType("Int", 2);
        Number = new XDynamicType("Number", 3);
        String = new XDynamicType("String", 4);
        Map = new XDynamicType("Map", 5);
        Array = new XDynamicType("Array", 6);
        Long = new XDynamicType("Long", 7);
        ByteArray = new XDynamicType("ByteArray", 8);
        $VALUES = $values();
    }

    private XDynamicType(String r5, int r10) {
        super(r5, r10);
    }

    public static XDynamicType valueOf(String r5) {
        return (XDynamicType) Enum.valueOf(XDynamicType.class, r5);
    }

    public static XDynamicType[] values() {
        return (XDynamicType[]) $VALUES.clone();
    }
}
