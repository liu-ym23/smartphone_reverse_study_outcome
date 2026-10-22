package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableTypeWrapper;", "", "(Ljava/lang/String;I)V", "Null", "Boolean", "Int", "Number", "String", "Map", "Array", "Long", "ByteArray", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
public final enum ReadableTypeWrapper extends Enum<ReadableTypeWrapper> {
    private static final /* synthetic */ ReadableTypeWrapper[] $VALUES = null;
    public static final ReadableTypeWrapper Array = null;
    public static final ReadableTypeWrapper Boolean = null;
    public static final ReadableTypeWrapper ByteArray = null;
    public static final ReadableTypeWrapper Int = null;
    public static final ReadableTypeWrapper Long = null;
    public static final ReadableTypeWrapper Map = null;
    public static final ReadableTypeWrapper Null = null;
    public static final ReadableTypeWrapper Number = null;
    public static final ReadableTypeWrapper String = null;

    static {
        ReadableTypeWrapper r5 = new ReadableTypeWrapper("Null", 0);
        Null = r5;
        ReadableTypeWrapper r10 = new ReadableTypeWrapper("Boolean", 1);
        Boolean = r10;
        ReadableTypeWrapper r11 = new ReadableTypeWrapper("Int", 2);
        Int = r11;
        ReadableTypeWrapper r12 = new ReadableTypeWrapper("Number", 3);
        Number = r12;
        ReadableTypeWrapper r13 = new ReadableTypeWrapper("String", 4);
        String = r13;
        ReadableTypeWrapper r14 = new ReadableTypeWrapper("Map", 5);
        Map = r14;
        ReadableTypeWrapper r15 = new ReadableTypeWrapper("Array", 6);
        Array = r15;
        ReadableTypeWrapper r16 = new ReadableTypeWrapper("Long", 7);
        Long = r16;
        ReadableTypeWrapper r17 = new ReadableTypeWrapper("ByteArray", 8);
        ByteArray = r17;
        $VALUES = new ReadableTypeWrapper[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private ReadableTypeWrapper(String r5, int r10) {
        super(r5, r10);
    }

    public static ReadableTypeWrapper valueOf(String r5) {
        return (ReadableTypeWrapper) Enum.valueOf(ReadableTypeWrapper.class, r5);
    }

    public static ReadableTypeWrapper[] values() {
        return (ReadableTypeWrapper[]) $VALUES.clone();
    }
}
