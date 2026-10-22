package com.bytedance.crash.dumper.tools;

import com.google.protobuf.DescriptorProtos;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes2.dex */
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
            int r0 = length(r14);
            char[] r7 = r13.getCharArray();
            int r10 = r0;
            int r9 = r13.getPosition();
            int r1 = 0;
        L3:
            int r11 = r10 + r9;
            if (r11 < r7.length) goto L9;
            int r12 = r7.length - r9;
            arrayCopy(r14, r1, r7, r9, r12);
            r13.dumpCacheArray();
            if (r9 == 0) goto L8;
            r13.setPosition(0);
            r9 = 0;
        L8:
            r1 = r1 + r12;
            r10 = r10 - r12;
            goto L3
        L9:
            if (r10 <= 0) goto L15;
            arrayCopy(r14, r1, r7, r9, r10);
            r13.setPosition(r11);
            return;
        }

        abstract void arrayCopy(A r1, int r2, char[] r3, int r4, int r5);

        abstract int length(A r1);
    }

    static class AppendableByteArray extends AppendableArray<byte[]> {
        AppendableByteArray() {
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* synthetic */ void arrayCopy(byte[] r7, int r8, char[] r9, int r10, int r11) {
            arrayCopy2((byte[]) ZeusTransformUtils.preCheckCast(r7, byte[].class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: arrayCopy, reason: avoid collision after fix types in other method */
        void arrayCopy2(byte[] r3, int r4, char[] r5, int r6, int r7) {
            int r2 = 0;
        L3:
            if (r2 >= r7) goto L5;
            r5[r6 + r2] = (char) r3[r4 + r2];
            r2 = r2 + 1;
            goto L3
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* synthetic */ int length(byte[] r3) {
            return length2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: length, reason: avoid collision after fix types in other method */
        int length2(byte[] r1) {
            return r1.length;
        }
    }

    static class AppendableCharArray extends AppendableArray<char[]> {
        AppendableCharArray() {
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* synthetic */ void arrayCopy(char[] r7, int r8, char[] r9, int r10, int r11) {
            arrayCopy2((char[]) ZeusTransformUtils.preCheckCast(r7, char[].class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: arrayCopy, reason: avoid collision after fix types in other method */
        void arrayCopy2(char[] r1, int r2, char[] r3, int r4, int r5) {
            System.arraycopy(r1, r2, r3, r4, r5);
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* synthetic */ int length(char[] r3) {
            return length2((char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: length, reason: avoid collision after fix types in other method */
        int length2(char[] r1) {
            return r1.length;
        }
    }

    static class AppendableStringArray extends AppendableArray<String> {
        AppendableStringArray() {
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* synthetic */ void arrayCopy(String r7, int r8, char[] r9, int r10, int r11) {
            arrayCopy2((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: arrayCopy, reason: avoid collision after fix types in other method */
        void arrayCopy2(String r1, int r2, char[] r3, int r4, int r5) {
            r1.getChars(r2, r5 + r2, r3, r4);
        }

        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        /* synthetic */ int length(String r3) {
            return length2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: length, reason: avoid collision after fix types in other method */
        int length2(String r1) {
            return r1.length();
        }
    }

    static {
        MIN_INT = new char[]{'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
        MIN_LONG = new char[]{'-', '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '8'};
        sTable = new int[]{9, 99, 999, HijrahDate.MAX_VALUE_OF_ERA, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE, 999999, 9999999, 99999999, Year.MAX_VALUE, Integer.MAX_VALUE};
        sAppendableCharArray = new AppendableCharArray();
        sAppendableByteArray = new AppendableByteArray();
        sAppendableStringArray = new AppendableStringArray();
    }

    CachedStringDumper(String r3) {
        int r0 = 1024;
        char[] r1 = new char[1024];     // Catch: Throwable -> L5
    L6:
        this.mCacheArray = r1;
        this.mPosition = 0;
        this.mDumpImpl = createImpl(r3, r0);
        return;
    L5:
        r0 = 128;
        r1 = new char[128];
        goto L6
    }

    private void appendChar(char r3) {
        char[] r0 = this.mCacheArray;
        int r1 = this.mPosition;
        r0[r1] = r3;
        int r2 = r1 + 1;
        this.mPosition = r2;
        if (r2 != r0.length) goto L6;
        IStringDumperImpl r4 = this.mDumpImpl;
        char[] r5 = this.mCacheArray;
        r4.dumpCharArray(r5, r5.length);
        this.mPosition = 0;
        return;
    }

    private static void appendInt(int r3, char[] r4, int r5) {
    L3:
        if (r3 < 65536) goto L5;
        int r0 = r3 / 100;
        int r6 = r3 - (((r0 << 6) + (r0 << 5)) + (r0 << 2));
        int r1 = r6 / 10;
        int r7 = r5 - 1;
        r4[r7] = (char) ((r6 - (r1 * 10)) + 48);
        r5 = r7 - 1;
        r4[r5] = (char) (r1 + 48);
        r3 = r0;
    L5:
        if (r3 == 0) goto L7;
        int r2 = (52429 * r3) >>> 19;
        r5 = r5 - 1;
        r4[r5] = (char) ((r3 - ((r2 << 3) + (r2 << 1))) + 48);
        r3 = r2;
        goto L5
    }

    private static void appendLong(long r6, char[] r8, int r9) {
    L3:
        if (r6 <= 2147483647L) goto L5;
        long r0 = r6 / 100;
        int r7 = (int) (r6 - (((r0 << 6) + (r0 << 5)) + (r0 << 2)));
        int r10 = r7 / 10;
        int r11 = r9 - 1;
        r8[r11] = (char) ((r7 - (r10 * 10)) + 48);
        r9 = r11 - 1;
        r8[r9] = (char) (r10 + 48);
        r6 = r0;
        goto L3
    L5:
        appendInt((int) r6, r8, r9);
    }

    private static int stringSize(int r2) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L8;
        int r1 = sTable[r0];
        r0 = r0 + 1;
        if (r2 > r1) goto L4;
        return r0;
    L8:
        return 11;
    }

    private static int stringSize(long r6) {
        int r0 = 1;
        long r3 = 10;
    L4:
        if (r0 >= 19) goto L9;
        if (r6 < r3) goto L7;
        r3 = r3 * 10;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return 19;
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char r1) {
        appendChar(r1);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(int r5) {
        if (r5 != Integer.MIN_VALUE) goto L5;
        append(MIN_INT);
        return;
    L5:
        if (r5 >= 0) goto L8;
        r5 = -r5;
        appendChar('-');
    L8:
        if (r5 < 100) goto L10;
        int r0 = stringSize(r5);
        if ((this.mPosition + r0) < this.mCacheArray.length) goto L17;
        this.mDumpImpl.dumpCharArray(this.mCacheArray, this.mPosition);
        this.mPosition = 0;
    L17:
        int r1 = this.mPosition + r0;
        this.mPosition = r1;
        appendInt(r5, this.mCacheArray, r1);
        return;
    L10:
        if (r5 < 10) goto L13;
        int r2 = r5 / 10;
        r5 = r5 - (r2 * 10);
        appendChar((char) (r2 + 48));
    L13:
        appendChar((char) (r5 + 48));
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(long r8) {
        if (r8 != Long.MIN_VALUE) goto L6;
        append(MIN_LONG);
        return;
    L6:
        if (r8 >= 0) goto L9;
        r8 = -r8;
        appendChar('-');
    L9:
        if (r8 < 100) goto L11;
        int r0 = stringSize(r8);
        if ((this.mPosition + r0) < this.mCacheArray.length) goto L18;
        this.mDumpImpl.dumpCharArray(this.mCacheArray, this.mPosition);
        this.mPosition = 0;
    L18:
        int r1 = this.mPosition + r0;
        this.mPosition = r1;
        appendLong(r8, this.mCacheArray, r1);
        return;
    L11:
        if (r8 < 10) goto L14;
        long r5 = r8 / 10;
        r8 = r8 - (10 * r5);
        appendChar((char) (r5 + 48));
    L14:
        appendChar((char) (r8 + 48));
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(String r2) {
        sAppendableStringArray.append(this, r2);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(byte[] r2) {
        sAppendableByteArray.append(this, r2);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char[] r2) {
        sAppendableCharArray.append(this, r2);
    }

    void dumpCacheArray() {
        IStringDumperImpl r0 = this.mDumpImpl;
        char[] r2 = this.mCacheArray;
        r0.dumpCharArray(r2, r2.length);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void flush() {
        if (this.mPosition <= 0) goto L5;
        this.mDumpImpl.dumpCharArray(this.mCacheArray, this.mPosition);
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

    void setPosition(int r1) {
        this.mPosition = r1;
    }
}
