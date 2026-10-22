package com.bytedance.android.bytehook;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final enum ByteHook$RecordItem extends Enum<ByteHook$RecordItem> {
    public static final ByteHook$RecordItem CALLER_LIB_NAME = null;
    public static final ByteHook$RecordItem ERRNO = null;
    public static final ByteHook$RecordItem LIB_NAME = null;
    public static final ByteHook$RecordItem NEW_ADDR = null;
    public static final ByteHook$RecordItem OP = null;
    public static final ByteHook$RecordItem STUB = null;
    public static final ByteHook$RecordItem SYM_NAME = null;
    public static final ByteHook$RecordItem TIMESTAMP = null;
    public static final /* synthetic */ ByteHook$RecordItem[] a = null;

    static {
        ByteHook$RecordItem r0 = new ByteHook$RecordItem("TIMESTAMP", 0);
        TIMESTAMP = r0;
        ByteHook$RecordItem r1 = new ByteHook$RecordItem("CALLER_LIB_NAME", 1);
        CALLER_LIB_NAME = r1;
        ByteHook$RecordItem r10 = new ByteHook$RecordItem("OP", 2);
        OP = r10;
        ByteHook$RecordItem r11 = new ByteHook$RecordItem("LIB_NAME", 3);
        LIB_NAME = r11;
        ByteHook$RecordItem r12 = new ByteHook$RecordItem("SYM_NAME", 4);
        SYM_NAME = r12;
        ByteHook$RecordItem r13 = new ByteHook$RecordItem("NEW_ADDR", 5);
        NEW_ADDR = r13;
        ByteHook$RecordItem r14 = new ByteHook$RecordItem("ERRNO", 6);
        ERRNO = r14;
        ByteHook$RecordItem r15 = new ByteHook$RecordItem("STUB", 7);
        STUB = r15;
        a = new ByteHook$RecordItem[]{r0, r1, r10, r11, r12, r13, r14, r15};
    }

    public static ByteHook$RecordItem[] values() {
        return (ByteHook$RecordItem[]) a.clone();
    }

    public static ByteHook$RecordItem valueOf(String r1) {
        return (ByteHook$RecordItem) a.a(ByteHook$RecordItem.class, r1);
    }

    public ByteHook$RecordItem(String r1, int r10) {
        super(r1, r10);
    }
}
