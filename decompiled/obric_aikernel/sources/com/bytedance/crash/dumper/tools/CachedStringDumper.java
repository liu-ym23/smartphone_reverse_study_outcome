package com.bytedance.crash.dumper.tools;

import com.google.protobuf.DescriptorProtos;

/* JADX INFO: loaded from: classes.dex */
class CachedStringDumper extends BaseStringDumper {
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private static final int MIN_CACHE_SIZE = 128;
    private static final char[] MIN_INT = null;
    private static final char[] MIN_LONG = null;
    private static final AppendableByteArray sAppendableByteArray = null;
    private static final AppendableCharArray sAppendableCharArray = null;
    private static final AppendableStringArray sAppendableStringArray = null;
    private static final int[] sTable = null;
    private final char[] mCacheArray;
    private int mPosition;

    static abstract class AppendableArray<A> {
        AppendableArray() {
        }

        void append(CachedStringDumper r13, A r14) {
            int r10 = length(r14);
            char[] r11 = r13.getCharArray();
            int r12 = r10;
            int r15 = r13.getPosition();
            int r16 = 0;
        L3:
            int r17 = r12 + r15;
            if (r17 < r11.length) goto L9;
            int r18 = r11.length - r15;
            arrayCopy(r14, r16, r11, r15, r18);
            r13.dumpCacheArray();
            if (r15 == 0) goto L8;
            r13.setPosition(0);
            r15 = 0;
        L8:
            r16 = r16 + r18;
            r12 = r12 - r18;
            goto L3
        L9:
            if (r12 <= 0) goto L15;
            arrayCopy(r14, r16, r11, r15, r12);
            r13.setPosition(r17);
            return;
        }

        abstract void arrayCopy(A r10, int r11, char[] r12, int r13, int r14);

        abstract int length(A r10);
    }

    static class AppendableByteArray extends AppendableArray<byte[]> {
        AppendableByteArray() {
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* bridge */ /* synthetic */ void arrayCopy(byte[] r10, int r11, char[] r12, int r13, int r14) {
            arrayCopy2(r10, r11, r12, r13, r14);
        }

        /* JADX INFO: renamed from: arrayCopy, reason: avoid collision after fix types in other method */
        void arrayCopy2(byte[] r10, int r11, char[] r12, int r13, int r14) {
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L5;
            r12[r13 + r15] = (char) r10[r11 + r15];
            r15 = r15 + 1;
            goto L3
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* bridge */ /* synthetic */ int length(byte[] r10) {
            return length2(r10);
        }

        /* JADX INFO: renamed from: length, reason: avoid collision after fix types in other method */
        int length2(byte[] r10) {
            return r10.length;
        }
    }

    static class AppendableCharArray extends AppendableArray<char[]> {
        AppendableCharArray() {
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* bridge */ /* synthetic */ void arrayCopy(char[] r10, int r11, char[] r12, int r13, int r14) {
            arrayCopy2(r10, r11, r12, r13, r14);
        }

        /* JADX INFO: renamed from: arrayCopy, reason: avoid collision after fix types in other method */
        void arrayCopy2(char[] r10, int r11, char[] r12, int r13, int r14) {
            System.arraycopy(r10, r11, r12, r13, r14);
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* bridge */ /* synthetic */ int length(char[] r10) {
            return length2(r10);
        }

        /* JADX INFO: renamed from: length, reason: avoid collision after fix types in other method */
        int length2(char[] r10) {
            return r10.length;
        }
    }

    static class AppendableStringArray extends AppendableArray<String> {
        AppendableStringArray() {
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* bridge */ /* synthetic */ void arrayCopy(String r10, int r11, char[] r12, int r13, int r14) {
            arrayCopy2(r10, r11, r12, r13, r14);
        }

        /* JADX INFO: renamed from: arrayCopy, reason: avoid collision after fix types in other method */
        void arrayCopy2(String r10, int r11, char[] r12, int r13, int r14) {
            r10.getChars(r11, r14 + r11, r12, r13);
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* bridge */ /* synthetic */ int length(String r10) {
            return length2(r10);
        }

        /* JADX INFO: renamed from: length, reason: avoid collision after fix types in other method */
        int length2(String r10) {
            return r10.length();
        }
    }

    static {
        MIN_INT = new char[]{'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
        MIN_LONG = new char[]{'-', '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '8'};
        sTable = new int[]{9, 99, 999, 9999, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        sAppendableCharArray = new AppendableCharArray();
        sAppendableByteArray = new AppendableByteArray();
        sAppendableStringArray = new AppendableStringArray();
    }

    CachedStringDumper(String r10) {
        int r11 = 1024;
        char[] r12 = new char[1024];     // Catch: Throwable -> L5
    L6:
        this.mCacheArray = r12;
        this.mPosition = 0;
        this.mDumpImpl = createImpl(r10, r11);
        return;
    L5:
        r11 = 128;
        r12 = new char[128];
        goto L6
    }

    private void appendChar(char r10) {
        char[] r11 = this.mCacheArray;
        int r12 = this.mPosition;
        r11[r12] = r10;
        int r13 = r12 + 1;
        this.mPosition = r13;
        if (r13 != r11.length) goto L6;
        this.mDumpImpl.dumpCharArray(r11, r11.length);
        this.mPosition = 0;
        return;
    }

    private static void appendInt(int r10, char[] r11, int r12) {
    L3:
        if (r10 < 65536) goto L5;
        int r13 = r10 / 100;
        int r14 = r10 - (((r13 << 6) + (r13 << 5)) + (r13 << 2));
        int r15 = r14 / 10;
        int r16 = r12 - 1;
        r11[r16] = (char) ((r14 - (r15 * 10)) + 48);
        r12 = r16 - 1;
        r11[r12] = (char) (r15 + 48);
        r10 = r13;
    L5:
        if (r10 == 0) goto L7;
        int r17 = (52429 * r10) >>> 19;
        r12 = r12 - 1;
        r11[r12] = (char) ((r10 - ((r17 << 3) + (r17 << 1))) + 48);
        r10 = r17;
        goto L5
    }

    private static void appendLong(long r10, char[] r11, int r12) {
    L3:
        if (r10 <= 2147483647L) goto L5;
        long r13 = r10 / 100;
        int r14 = (int) (r10 - (((r13 << 6) + (r13 << 5)) + (r13 << 2)));
        int r15 = r14 / 10;
        int r16 = r12 - 1;
        r11[r16] = (char) ((r14 - (r15 * 10)) + 48);
        r12 = r16 - 1;
        r11[r12] = (char) (r15 + 48);
        r10 = r13;
        goto L3
    L5:
        appendInt((int) r10, r11, r12);
    }

    private static int stringSize(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= 10) goto L8;
        int r12 = sTable[r11];
        r11 = r11 + 1;
        if (r10 > r12) goto L4;
        return r11;
    L8:
        return 11;
    }

    private static int stringSize(long r10) {
        int r11 = 1;
        long r12 = 10;
    L4:
        if (r11 >= 19) goto L9;
        if (r10 < r12) goto L7;
        r12 = r12 * 10;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return 19;
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char r10) {
        appendChar(r10);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(int r10) {
        if (r10 != Integer.MIN_VALUE) goto L5;
        append(MIN_INT);
        return;
    L5:
        if (r10 >= 0) goto L8;
        r10 = -r10;
        appendChar('-');
    L8:
        if (r10 < 100) goto L10;
        int r11 = stringSize(r10);
        int r12 = this.mPosition;
        int r13 = r12 + r11;
        char[] r14 = this.mCacheArray;
        if (r13 < r14.length) goto L17;
        this.mDumpImpl.dumpCharArray(r14, r12);
        this.mPosition = 0;
    L17:
        int r15 = this.mPosition + r11;
        this.mPosition = r15;
        appendInt(r10, this.mCacheArray, r15);
        return;
    L10:
        if (r10 < 10) goto L13;
        int r16 = r10 / 10;
        r10 = r10 - (r16 * 10);
        appendChar((char) (r16 + 48));
    L13:
        appendChar((char) (r10 + 48));
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        append(MIN_LONG);
        return;
    L6:
        if (r10 >= 0) goto L9;
        r10 = -r10;
        appendChar('-');
    L9:
        if (r10 < 100) goto L11;
        int r11 = stringSize(r10);
        int r12 = this.mPosition;
        int r13 = r12 + r11;
        char[] r14 = this.mCacheArray;
        if (r13 < r14.length) goto L18;
        this.mDumpImpl.dumpCharArray(r14, r12);
        this.mPosition = 0;
    L18:
        int r15 = this.mPosition + r11;
        this.mPosition = r15;
        appendLong(r10, this.mCacheArray, r15);
        return;
    L11:
        if (r10 < 10) goto L14;
        long r16 = r10 / 10;
        r10 = r10 - (10 * r16);
        appendChar((char) (r16 + 48));
    L14:
        appendChar((char) (r10 + 48));
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(String r10) {
        sAppendableStringArray.append(this, r10);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(byte[] r10) {
        sAppendableByteArray.append(this, r10);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char[] r10) {
        sAppendableCharArray.append(this, r10);
    }

    void dumpCacheArray() {
        IStringDumperImpl r10 = this.mDumpImpl;
        char[] r11 = this.mCacheArray;
        r10.dumpCharArray(r11, r11.length);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void flush() {
        int r10 = this.mPosition;
        if (r10 <= 0) goto L5;
        this.mDumpImpl.dumpCharArray(this.mCacheArray, r10);
        this.mPosition = 0;
    L5:
        this.mDumpImpl.flush();
    }

    char[] getCharArray() {
        return this.mCacheArray;
    }

    int getPosition() {
        return this.mPosition;
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void release() {
        flush();
        this.mDumpImpl.release();
    }

    void setPosition(int r10) {
        this.mPosition = r10;
    }
}
