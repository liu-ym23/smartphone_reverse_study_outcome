package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes7.dex */
public final class CharUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ThreadLocal<SoftReference<CharUtil>> tl_charUtil = null;
    public int _cchSrc;
    private final int _charBufSize;
    private final CharIterator _charIter;
    private char[] _currentBuffer;
    private int _currentOffset;
    public int _offSrc;

    public static final class CharIterator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _cchRoot;
        private int _maxPos;
        private int _minPos;
        private int _offLeaf;
        private int _offRoot;
        private int _pos;
        private char[] _srcLeafChars;
        private String _srcLeafString;
        private Object _srcRoot;

        static {
        }

        public CharIterator() {
        }

        private char currentChar() {
            int r0 = (this._offLeaf + this._pos) - this._minPos;
            char[] r1 = this._srcLeafChars;
            if (r1 != null) goto L6;
            return this._srcLeafString.charAt(r0);
        L6:
            return r1[r0];
        }

        public boolean hasNext() {
            if (this._pos >= this._cchRoot) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasPrev() {
            if (this._pos <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void init(Object r2, int r3, int r4) {
            init(r2, r3, r4, 0);
        }

        public void init(Object r1, int r2, int r3, int r4) {
            release();
            this._srcRoot = r1;
            this._offRoot = r2;
            this._cchRoot = r3;
            this._maxPos = -1;
            this._minPos = -1;
            movePos(r4);
        }

        public void movePos(int r8) {
            if (r8 >= this._minPos) goto L5;
        L6:
            Object r1 = this._srcRoot;
            int r2 = this._offRoot;
            int r3 = r2 + r8;
            int r4 = this._cchRoot;
            this._offLeaf = r2;
        L8:
            if (ZeusTransformUtils.instanceOf(r1, CharJoin.class) == false) goto L14;
            CharJoin r5 = (CharJoin) ZeusTransformUtils.preCheckCast(r1, CharJoin.class, "com.obric.memorydata.plugin");
            if (r3 >= r5._cchLeft) goto L12;
            Object r6 = r5._srcLeft;
            this._offLeaf = r5._offLeft;
            r3 = r3 + r5._offLeft;
            r4 = r5._cchLeft;
        L13:
            r1 = r6;
            goto L8
        L12:
            r6 = r5._srcRight;
            this._offLeaf = r5._offRight;
            r3 = r3 - (r5._cchLeft - r5._offRight);
            r4 = r4 - r5._cchLeft;
            goto L13
        L14:
            int r7 = r8 - (r3 - this._offLeaf);
            this._minPos = r7;
            int r9 = r7 + r4;
            this._maxPos = r9;
            if (r8 >= this._cchRoot) goto L17;
            this._maxPos = r9 - 1;
        L17:
            this._srcLeafChars = null;
            this._srcLeafString = null;
            if ((r1 instanceof char[]) == false) goto L20;
            this._srcLeafChars = (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r1, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin");
        L21:
            this._pos = r8;
            return;
        L20:
            this._srcLeafString = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
            goto L21
        L5:
            if (r8 <= this._maxPos) goto L21;
            goto L6
        }

        public char next() {
            char r0 = currentChar();
            movePos(this._pos + 1);
            return r0;
        }

        public char prev() {
            movePos(this._pos - 1);
            return currentChar();
        }

        public void release() {
            this._srcRoot = null;
            this._srcLeafString = null;
            this._srcLeafChars = null;
        }
    }

    public static final class CharJoin {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public final int _cchLeft;
        public final int _depth;
        public final int _offLeft;
        public final int _offRight;
        public final Object _srcLeft;
        public final Object _srcRight;

        static {
        }

        public CharJoin(Object r2, int r3, int r4, Object r5, int r6) {
            this._srcLeft = r2;
            this._offLeft = r3;
            this._cchLeft = r4;
            this._srcRight = r5;
            this._offRight = r6;
            if (ZeusTransformUtils.instanceOf(r2, CharJoin.class) == false) goto L5;
            int r7 = ((CharJoin) ZeusTransformUtils.preCheckCast(r2, CharJoin.class, "com.obric.memorydata.plugin"))._depth;
        L7:
            if (ZeusTransformUtils.instanceOf(r5, CharJoin.class) == false) goto L11;
            int r8 = ((CharJoin) ZeusTransformUtils.preCheckCast(r5, CharJoin.class, "com.obric.memorydata.plugin"))._depth;
            if (r8 <= r7) goto L11;
            r7 = r8;
        L11:
            this._depth = r7 + 1;
            return;
        L5:
            r7 = 0;
            goto L7
        }

        static /* synthetic */ void access$000(CharJoin r0, StringBuffer r1, int r2, int r3) {
            r0.getString(r1, r2, r3);
        }

        static /* synthetic */ void access$100(CharJoin r0, char[] r1, int r2, int r3, int r4) {
            r0.getChars(r1, r2, r3, r4);
        }

        private int cchRight(int r1, int r2) {
            return Math.max(0, (r2 - this._cchLeft) - r1);
        }

        private void getChars(char[] r4, int r5, int r6, int r7) {
            int r0 = this._cchLeft;
            if (r6 >= r0) goto L7;
            int r1 = Math.min(r0 - r6, r7);
            CharUtil.getChars(r4, r5, this._srcLeft, this._offLeft + r6, r1);
            if (r7 <= r1) goto L9;
            CharUtil.getChars(r4, r5 + r1, this._srcRight, this._offRight, r7 - r1);
            return;
        L9:
            return;
        L7:
            CharUtil.getChars(r4, r5, this._srcRight, (this._offRight + r6) - r0, r7);
        }

        private void getString(StringBuffer r4, int r5, int r6) {
            int r0 = this._cchLeft;
            if (r5 >= r0) goto L7;
            int r1 = Math.min(r0 - r5, r6);
            CharUtil.getString(r4, this._srcLeft, this._offLeft + r5, r1);
            if (r6 <= r1) goto L9;
            CharUtil.getString(r4, this._srcRight, this._offRight, r6 - r1);
            return;
        L9:
            return;
        L7:
            CharUtil.getString(r4, this._srcRight, (this._offRight + r5) - r0, r6);
        }

        public int depth() {
            if (ZeusTransformUtils.instanceOf(this._srcLeft, CharJoin.class) == false) goto L5;
            int r1 = ((CharJoin) ZeusTransformUtils.preCheckCast(this._srcLeft, CharJoin.class, "com.obric.memorydata.plugin")).depth();
        L7:
            if (ZeusTransformUtils.instanceOf(this._srcRight, CharJoin.class) == false) goto L10;
            r1 = Math.max(((CharJoin) ZeusTransformUtils.preCheckCast(this._srcRight, CharJoin.class, "com.obric.memorydata.plugin")).depth(), r1);
        L10:
            return r1 + 1;
        L5:
            r1 = 0;
            goto L7
        }

        public boolean isValid(int r5, int r6) {
            if (this._depth <= 2) goto L7;
            return true;
        L7:
            if (r5 < 0) goto L15;
            if (r6 < 0) goto L15;
            if (CharUtil.isValid(this._srcLeft, this._offLeft, this._cchLeft) == true) goto L14;
            return false;
        L14:
            return CharUtil.isValid(this._srcRight, this._offRight, cchRight(r5, r6));
        L15:
            return false;
        }
    }

    static {
        tl_charUtil = ThreadLocal.withInitial($$Lambda$CharUtil$RuH8WFlHCGyp0oH0NEyRfF19acU.INSTANCE);
    }

    public CharUtil(int r2) {
        this._charIter = new CharIterator();
        this._charBufSize = r2;
    }

    private char[] allocate(int r4) {
        if (this._currentBuffer != null) goto L5;
        this._currentBuffer = new char[Math.max(r4, this._charBufSize)];
        this._currentOffset = 0;
    L5:
        int r0 = this._currentOffset;
        this._offSrc = r0;
        int r5 = Math.min(this._currentBuffer.length - r0, r4);
        this._cchSrc = r5;
        char[] r1 = this._currentBuffer;
        int r2 = this._currentOffset + r5;
        this._currentOffset = r2;
        if (r2 != r1.length) goto L8;
        this._currentBuffer = null;
        this._currentOffset = 0;
    L8:
        return r1;
    }

    private boolean canAllocate(int r2) {
        char[] r0 = this._currentBuffer;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if ((r0.length - this._currentOffset) >= r2) goto L8;
        return false;
    }

    public static void getChars(char[] r3, int r4, Object r5, int r6, int r7) {
        if (r7 != 0) goto L6;
        return;
    L6:
        if ((r5 instanceof char[]) == false) goto L9;
        System.arraycopy((char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r5, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin"), r6, r3, r4, r7);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L11;
        ((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")).getChars(r6, r7 + r6, r3, r4);
        return;
    L11:
        CharJoin.access$100((CharJoin) ZeusTransformUtils.preCheckCast(r5, CharJoin.class, "com.obric.memorydata.plugin"), r3, r4, r6, r7);
    }

    public static String getString(Object r3, int r4, int r5) {
        if (r5 != 0) goto L7;
        return "";
    L7:
        if ((r3 instanceof char[]) == false) goto L11;
        return new String((char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin"), r4, r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L19;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r4 != 0) goto L18;
        if (r5 != r6.length()) goto L18;
        return r6;
    L18:
        return r6.substring(r4, r5 + r4);
    L19:
        StringBuffer r0 = new StringBuffer();
        CharJoin.access$000((CharJoin) ZeusTransformUtils.preCheckCast(r3, CharJoin.class, "com.obric.memorydata.plugin"), r0, r4, r5);
        return r0.toString();
    }

    public static void getString(StringBuffer r3, Object r4, int r5, int r6) {
        if (r6 != 0) goto L6;
        return;
    L6:
        if ((r4 instanceof char[]) == false) goto L9;
        r3.append((char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r4, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin"), r5, r6);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L16;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        if (r5 == 0) goto L13;
    L15:
        r3.append(r7, r5, r6 + r5);
        return;
    L13:
        if (r6 != r7.length()) goto L15;
        r3.append(r7);
        return;
    L16:
        CharJoin.access$000((CharJoin) ZeusTransformUtils.preCheckCast(r4, CharJoin.class, "com.obric.memorydata.plugin"), r3, r5, r6);
    }

    public static CharUtil getThreadLocalCharUtil() {
        ThreadLocal<SoftReference<CharUtil>> r0 = tl_charUtil;
        CharUtil r1 = (CharUtil) ZeusTransformUtils.preCheckCast(((SoftReference) ZeusTransformUtils.preCheckCast(r0.get(), SoftReference.class, "com.obric.memorydata.plugin")).get(), CharUtil.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        CharUtil r2 = new CharUtil(32768);
        r0.set(new SoftReference(r2));
        return r2;
    L6:
        return r1;
    }

    public static boolean isValid(Object r5, int r6, int r7) {
        if (r7 < 0) goto L32;
        if (r6 < 0) goto L32;
        if (r5 != null) goto L13;
        if (r6 != 0) goto L33;
        if (r7 == 0) goto L11;
        return false;
    L11:
        return true;
    L33:
        return false;
    L13:
        if ((r5 instanceof char[]) == false) goto L21;
        char[] r8 = (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r5, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin");
        if (r6 <= r8.length) goto L17;
        return false;
    L17:
        if ((r6 + r7) <= r8.length) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L29;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (r6 <= r9.length()) goto L25;
        return false;
    L25:
        if ((r6 + r7) <= r9.length()) goto L27;
        return false;
    L27:
        return true;
    L29:
        if (ZeusTransformUtils.instanceOf(r5, CharJoin.class) == false) goto L32;
        return ((CharJoin) ZeusTransformUtils.preCheckCast(r5, CharJoin.class, "com.obric.memorydata.plugin")).isValid(r6, r7);
    L32:
        return false;
    }

    public static boolean isWhiteSpace(char r1) {
        if (r1 != '\t') goto L5;
        return true;
    L5:
        if (r1 != '\n') goto L7;
        return true;
    L7:
        if (r1 != '\r') goto L9;
        return true;
    L9:
        if (r1 == ' ') goto L16;
        return false;
    L16:
        return true;
    }

    static /* synthetic */ SoftReference lambda$static$0() {
        return new SoftReference(new CharUtil(32768));
    }

    public Object insertChars(int r9, Object r10, int r11, int r12, Object r13, int r14, int r15) {
        if (r15 != 0) goto L5;
        this._cchSrc = r12;
        this._offSrc = r11;
        return r10;
    L5:
        if (r12 != 0) goto L8;
        this._cchSrc = r15;
        this._offSrc = r14;
        return r13;
    L8:
        int r0 = r12 + r15;
        this._cchSrc = r0;
        if (r0 <= 64) goto L11;
    L13:
        this._offSrc = 0;
        if (r9 != 0) goto L17;
        CharJoin r16 = new CharJoin(r13, r14, r15, r10, r11);
    L16:
        CharJoin r1 = r16;
    L21:
        if (r1._depth > 64) goto L23;
        return r1;
    L23:
        return saveChars(r1, this._offSrc, this._cchSrc);
    L17:
        if (r9 != r12) goto L19;
        r16 = new CharJoin(r10, r11, r12, r13, r14);
        goto L16
    L19:
        r1 = new CharJoin(new CharJoin(r10, r11, r9, r13, r14), 0, r9 + r15, r10, r11 + r9);
        goto L21
    L11:
        if (canAllocate(r0) == false) goto L13;
        char[] r2 = allocate(this._cchSrc);
        getChars(r2, this._offSrc, r10, r11, r9);
        getChars(r2, this._offSrc + r9, r13, r14, r15);
        getChars(r2, (this._offSrc + r9) + r15, r10, r11 + r9, r12 - r9);
        return r2;
    }

    public final boolean isWhiteSpace(Object r6, int r7, int r8) {
        boolean r1 = true;
        if (r8 > 0) goto L6;
        return true;
    L6:
        if ((r6 instanceof char[]) == false) goto L15;
        char[] r5 = (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r6, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin");
    L8:
        if (r8 <= 0) goto L13;
        int r9 = r7 + 1;
        if (isWhiteSpace(r5[r7]) == false) goto L11;
        r8 = r8 - 1;
        r7 = r9;
        goto L8
    L11:
        return false;
    L13:
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L23;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L17:
        if (r8 <= 0) goto L22;
        int r11 = r7 + 1;
        if (isWhiteSpace(r10.charAt(r7)) == false) goto L20;
        r8 = r8 - 1;
        r7 = r11;
        goto L17
    L20:
        return false;
    L22:
        return true;
    L23:
        this._charIter.init(r6, r7, r8);
    L25:
        if (this._charIter.hasNext() == false) goto L29;
        if (isWhiteSpace(this._charIter.next()) == true) goto L25;
        r1 = false;
    L29:
        this._charIter.release();
        return r1;
    }

    public Object removeChars(int r10, int r11, Object r12, int r13, int r14) {
        int r0 = r14 - r11;
        this._cchSrc = r0;
        if (r0 != 0) goto L5;
        this._offSrc = 0;
        return null;
    L5:
        if (r10 != 0) goto L9;
        r13 = r13 + r11;
    L7:
        this._offSrc = r13;
        return r12;
    L9:
        if ((r10 + r11) == r14) goto L7;
        if (r0 <= 64) goto L14;
    L16:
        CharJoin r15 = new CharJoin(r12, r13, r10, r12, (r13 + r10) + r11);
        if (r15._depth > 64) goto L24;
        this._offSrc = 0;
        return r15;
    L24:
        return saveChars(r15, 0, this._cchSrc);
    L14:
        if (canAllocate(r0) == false) goto L16;
        char[] r1 = allocate(r0);
        getChars(r1, this._offSrc, r12, r13, r10);
        getChars(r1, this._offSrc + r10, r12, (r13 + r10) + r11, (r14 - r10) - r11);
        return r1;
    }

    public Object saveChars(Object r8, int r9, int r10) {
        return saveChars(r8, r9, r10, null, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object saveChars(Object r16, int r17, int r18, Object r19, int r20, int r21) {
        char[] r8 = allocate(r18);
        int r9 = this._offSrc;
        int r10 = this._cchSrc;
        getChars(r8, r9, r16, r17, r10);
        int r11 = r10 + r21;
        int r13 = 0;
        if (r21 != 0) goto L5;
        Object r14 = r8;
    L20:
        int r4 = r18 - r10;
        if (r4 <= 0) goto L26;
        char[] r5 = allocate(r4);
        int r6 = this._offSrc;
        getChars(r5, r6, r16, r17 + (r18 - r4), r4);
        CharJoin r1 = new CharJoin(r14, r9, r11, r5, r6);
        r11 = r11 + r4;
        int r2 = r1._depth;
        Object r3 = r1;
        if (r2 <= 64) goto L25;
        r3 = saveChars(r1, 0, r11);
    L25:
        Object r15 = r3;
    L27:
        this._offSrc = r13;
        this._cchSrc = r11;
        return r15;
    L26:
        r13 = r9;
        r15 = r14;
        goto L27
    L5:
        if (r19 != r8) goto L10;
        if ((r20 + r21) != r9) goto L10;
    L15:
        r9 = r20;
        r14 = r19;
    L10:
        if (ZeusTransformUtils.instanceOf(r19, CharJoin.class) == false) goto L16;
        CharJoin r7 = (CharJoin) ZeusTransformUtils.preCheckCast(r19, CharJoin.class, "com.obric.memorydata.plugin");
        if (r7._srcRight != r8) goto L16;
        if ((((r20 + r21) - r7._cchLeft) + r7._offRight) == r9) goto L15;
    L16:
        CharJoin r110 = new CharJoin(r19, r20, r21, r8, r9);
        int r12 = r110._depth;
        Object r111 = r110;
        if (r12 <= 64) goto L19;
        r111 = saveChars(r110, 0, r11);
    L19:
        r9 = 0;
        r14 = r111;
        goto L20
    }

    public Object stripLeft(Object r5, int r6, int r7) {
        if (r7 > 0) goto L5;
    L26:
        if (r7 != 0) goto L29;
        this._offSrc = 0;
        this._cchSrc = 0;
        return null;
    L29:
        this._offSrc = r6;
        this._cchSrc = r7;
        return r5;
    L5:
        if ((r5 instanceof char[]) == false) goto L12;
        char[] r0 = (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r5, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin");
    L7:
        if (r7 <= 0) goto L26;
        if (isWhiteSpace(r0[r6]) == false) goto L26;
        r7 = r7 - 1;
        r6 = r6 + 1;
        goto L7
    L12:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L14:
        if (r7 <= 0) goto L26;
        if (isWhiteSpace(r1.charAt(r6)) == false) goto L26;
        r7 = r7 - 1;
        r6 = r6 + 1;
        goto L14
    L18:
        this._charIter.init(r5, r6, r7);
        int r2 = 0;
    L20:
        if (this._charIter.hasNext() == false) goto L25;
        if (isWhiteSpace(this._charIter.next()) == false) goto L25;
        r2 = r2 + 1;
    L25:
        this._charIter.release();
        r6 = r6 + r2;
        goto L26
    }

    public Object stripRight(Object r2, int r3, int r4) {
        if (r4 <= 0) goto L11;
        this._charIter.init(r2, r3, r4, r4);
    L5:
        if (this._charIter.hasPrev() == false) goto L10;
        if (isWhiteSpace(this._charIter.prev()) == false) goto L10;
        r4 = r4 - 1;
    L10:
        this._charIter.release();
    L11:
        if (r4 != 0) goto L14;
        this._offSrc = 0;
        this._cchSrc = 0;
        return null;
    L14:
        this._offSrc = r3;
        this._cchSrc = r4;
        return r2;
    }
}
