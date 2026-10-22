package com.alibaba.excel.enums;

import com.alibaba.excel.i.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.Map;
import org.apache.commons.io.ByteOrderMark;

/* JADX INFO: loaded from: classes.dex */
public final enum ByteOrderMarkEnum extends Enum<ByteOrderMarkEnum> {
    private static final /* synthetic */ ByteOrderMarkEnum[] $VALUES = null;
    private static final Map<String, ByteOrderMarkEnum> CHARSET_BYTE_ORDER_MARK_MAP = null;
    public static final ByteOrderMarkEnum UTF_16BE = null;
    public static final ByteOrderMarkEnum UTF_16LE = null;
    public static final ByteOrderMarkEnum UTF_32BE = null;
    public static final ByteOrderMarkEnum UTF_32LE = null;
    public static final ByteOrderMarkEnum UTF_8 = null;
    final ByteOrderMark byteOrderMark;
    final String stringPrefix;

    static {
        int r3 = 0;
        ByteOrderMarkEnum r0 = new ByteOrderMarkEnum("UTF_8", 0, ByteOrderMark.UTF_8);
        UTF_8 = r0;
        ByteOrderMarkEnum r1 = new ByteOrderMarkEnum("UTF_16BE", 1, ByteOrderMark.UTF_16BE);
        UTF_16BE = r1;
        ByteOrderMarkEnum r2 = new ByteOrderMarkEnum("UTF_16LE", 2, ByteOrderMark.UTF_16LE);
        UTF_16LE = r2;
        ByteOrderMarkEnum r4 = new ByteOrderMarkEnum("UTF_32BE", 3, ByteOrderMark.UTF_32BE);
        UTF_32BE = r4;
        ByteOrderMarkEnum r6 = new ByteOrderMarkEnum("UTF_32LE", 4, ByteOrderMark.UTF_32LE);
        UTF_32LE = r6;
        $VALUES = new ByteOrderMarkEnum[]{r0, r1, r2, r4, r6};
        CHARSET_BYTE_ORDER_MARK_MAP = j.a();
        ByteOrderMarkEnum[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        ByteOrderMarkEnum r8 = r5[r3];
        CHARSET_BYTE_ORDER_MARK_MAP.put(r8.getByteOrderMark().getCharsetName(), r8);
        r3 = r3 + 1;
        goto L3
    }

    private ByteOrderMarkEnum(String r1, int r2, ByteOrderMark r3) {
        super(r1, r2);
        this.byteOrderMark = r3;
        Charset r4 = Charset.forName(r3.getCharsetName());
        this.stringPrefix = new String(r3.getBytes(), r4);
    }

    public static ByteOrderMarkEnum valueOf(String r2) {
        return (ByteOrderMarkEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(ByteOrderMarkEnum.class, r2), ByteOrderMarkEnum.class, "com.obric.memorydata.plugin");
    }

    public static ByteOrderMarkEnum valueOfByCharsetName(String r2) {
        return (ByteOrderMarkEnum) ZeusTransformUtils.preCheckCast(CHARSET_BYTE_ORDER_MARK_MAP.get(r2), ByteOrderMarkEnum.class, "com.obric.memorydata.plugin");
    }

    public static ByteOrderMarkEnum[] values() {
        return (ByteOrderMarkEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ByteOrderMarkEnum[].class, "com.obric.memorydata.plugin");
    }

    public ByteOrderMark getByteOrderMark() {
        return this.byteOrderMark;
    }

    public String getStringPrefix() {
        return this.stringPrefix;
    }
}
