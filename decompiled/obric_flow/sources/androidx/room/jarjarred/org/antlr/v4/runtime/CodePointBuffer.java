package androidx.room.jarjarred.org.antlr.v4.runtime;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class CodePointBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBuffer byteBuffer;
    private final CharBuffer charBuffer;
    private final IntBuffer intBuffer;
    private final Type type;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.runtime.CodePointBuffer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type = null;

        static {
            int[] r5 = new int[Type.values().length];
            $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type = r5;
            r5[Type.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[Type.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[Type.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ByteBuffer byteBuffer;
        private CharBuffer charBuffer;
        private IntBuffer intBuffer;
        private int prevHighSurrogate;
        private Type type;

        public /* synthetic */ Builder(int r5, AnonymousClass1 r10) {
            this(r5);
        }

        private void appendArray(CharBuffer r5) {
            int r10 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
            if (r10 != 1) goto L5;
            appendArrayByte(r5);
            return;
        L5:
            if (r10 != 2) goto L7;
            appendArrayChar(r5);
            return;
        L7:
            if (r10 != 3) goto L15;
            appendArrayInt(r5);
            return;
        }

        private void appendArrayByte(CharBuffer r10) {
            char[] r5 = r10.array();
            int r11 = r10.arrayOffset();
            int r12 = r10.position() + r11;
            int r13 = r10.arrayOffset();
            int r14 = r10.limit() + r13;
            byte[] r15 = this.byteBuffer.array();
            int r16 = this.byteBuffer.arrayOffset();
            int r17 = this.byteBuffer.position() + r16;
        L3:
            if (r12 >= r14) goto L13;
            char r18 = r5[r12];
            if (r18 > 255) goto L7;
            r15[r17] = (byte) (r18 & 255);
            r12 = r12 + 1;
            r17 = r17 + 1;
            goto L3
        L7:
            r10.position(r12 - r10.arrayOffset());
            ByteBuffer r19 = this.byteBuffer;
            r19.position(r17 - r19.arrayOffset());
            if (Character.isHighSurrogate(r18) == true) goto L11;
            byteToCharBuffer(r10.remaining());
            appendArrayChar(r10);
            return;
        L11:
            byteToIntBuffer(r10.remaining());
            appendArrayInt(r10);
            return;
        L13:
            r10.position(r12 - r10.arrayOffset());
            ByteBuffer r20 = this.byteBuffer;
            r20.position(r17 - r20.arrayOffset());
        }

        private void appendArrayChar(CharBuffer r10) {
            char[] r5 = r10.array();
            int r11 = r10.arrayOffset();
            int r12 = r10.position() + r11;
            int r13 = r10.arrayOffset();
            int r14 = r10.limit() + r13;
            char[] r15 = this.charBuffer.array();
            int r16 = this.charBuffer.arrayOffset();
            int r17 = this.charBuffer.position() + r16;
        L3:
            if (r12 >= r14) goto L9;
            char r18 = r5[r12];
            if (Character.isHighSurrogate(r18) == true) goto L7;
            r15[r17] = r18;
            r12 = r12 + 1;
            r17 = r17 + 1;
            goto L3
        L7:
            r10.position(r12 - r10.arrayOffset());
            CharBuffer r19 = this.charBuffer;
            r19.position(r17 - r19.arrayOffset());
            charToIntBuffer(r10.remaining());
            appendArrayInt(r10);
            return;
        L9:
            r10.position(r12 - r10.arrayOffset());
            CharBuffer r20 = this.charBuffer;
            r20.position(r17 - r20.arrayOffset());
        }

        private void appendArrayInt(CharBuffer r11) {
            char[] r5 = r11.array();
            int r10 = r11.arrayOffset();
            int r12 = r11.position() + r10;
            int r13 = r11.arrayOffset();
            int r14 = r11.limit() + r13;
            int[] r15 = this.intBuffer.array();
            int r16 = this.intBuffer.arrayOffset();
            int r17 = this.intBuffer.position() + r16;
        L4:
            if (r12 >= r14) goto L18;
            char r18 = r5[r12];
            r12 = r12 + 1;
            if (this.prevHighSurrogate != (-1)) goto L8;
            if (Character.isHighSurrogate(r18) == true) goto L16;
            r15[r17] = r18 & 65535;
            r17 = r17 + 1;
            goto L4
        L16:
            this.prevHighSurrogate = r18 & 65535;
            goto L4
        L8:
            if (Character.isLowSurrogate(r18) == true) goto L9;
            r15[r17] = this.prevHighSurrogate;
            int r19 = r17 + 1;
            if (Character.isHighSurrogate(r18) == true) goto L12;
            r15[r19] = 65535 & r18;
            r17 = r17 + 2;
            this.prevHighSurrogate = -1;
            goto L4
        L12:
            this.prevHighSurrogate = r18 & 65535;
            r17 = r19;
            goto L4
        L9:
            r15[r17] = Character.toCodePoint((char) this.prevHighSurrogate, r18);
            r17 = r17 + 1;
            this.prevHighSurrogate = -1;
            goto L4
        L18:
            int r20 = this.prevHighSurrogate;
            if (r20 == (-1)) goto L21;
            r15[r17] = r20 & 65535;
            r17 = r17 + 1;
        L21:
            r11.position(r12 - r11.arrayOffset());
            IntBuffer r110 = this.intBuffer;
            r110.position(r17 - r110.arrayOffset());
        }

        private void byteToCharBuffer(int r5) {
            this.byteBuffer.flip();
            CharBuffer r10 = CharBuffer.allocate(Math.max(this.byteBuffer.remaining() + r5, this.byteBuffer.capacity() / 2));
        L4:
            if (this.byteBuffer.hasRemaining() == false) goto L6;
            r10.put((char) (this.byteBuffer.get() & UByte.MAX_VALUE));
            goto L4
        L6:
            this.type = Type.CHAR;
            this.byteBuffer = null;
            this.charBuffer = r10;
        }

        private void byteToIntBuffer(int r5) {
            this.byteBuffer.flip();
            IntBuffer r10 = IntBuffer.allocate(Math.max(this.byteBuffer.remaining() + r5, this.byteBuffer.capacity() / 4));
        L4:
            if (this.byteBuffer.hasRemaining() == false) goto L6;
            r10.put(this.byteBuffer.get() & UByte.MAX_VALUE);
            goto L4
        L6:
            this.type = Type.INT;
            this.byteBuffer = null;
            this.intBuffer = r10;
        }

        private void charToIntBuffer(int r5) {
            this.charBuffer.flip();
            IntBuffer r10 = IntBuffer.allocate(Math.max(this.charBuffer.remaining() + r5, this.charBuffer.capacity() / 2));
        L4:
            if (this.charBuffer.hasRemaining() == false) goto L6;
            r10.put(this.charBuffer.get() & 65535);
            goto L4
        L6:
            this.type = Type.INT;
            this.charBuffer = null;
            this.intBuffer = r10;
        }

        private static int roundUpToNextPowerOfTwo(int r5) {
            return (int) Math.pow(2.0d, 32 - Integer.numberOfLeadingZeros(r5 - 1));
        }

        public void append(CharBuffer r5) {
            ensureRemaining(r5.remaining());
            if (r5.hasArray() == false) goto L7;
            appendArray(r5);
            return;
        L7:
            throw new UnsupportedOperationException("TODO");
        }

        public CodePointBuffer build() {
            int r5 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
            if (r5 != 1) goto L5;
            this.byteBuffer.flip();
        L13:
            return new CodePointBuffer(this.type, this.byteBuffer, this.charBuffer, this.intBuffer, null);
        L5:
            if (r5 != 2) goto L7;
            this.charBuffer.flip();
            goto L13
        L7:
            if (r5 != 3) goto L13;
            this.intBuffer.flip();
            goto L13
        }

        public void ensureRemaining(int r5) {
            int r10 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L13;
            if (r10 == 3) goto L10;
            return;
        L10:
            if (this.intBuffer.remaining() >= r5) goto L19;
            IntBuffer r11 = IntBuffer.allocate(roundUpToNextPowerOfTwo(this.intBuffer.capacity() + r5));
            this.intBuffer.flip();
            r11.put(this.intBuffer);
            this.intBuffer = r11;
            return;
        L19:
            return;
        L13:
            if (this.charBuffer.remaining() >= r5) goto L21;
            CharBuffer r12 = CharBuffer.allocate(roundUpToNextPowerOfTwo(this.charBuffer.capacity() + r5));
            this.charBuffer.flip();
            r12.put(this.charBuffer);
            this.charBuffer = r12;
            return;
        L21:
            return;
        L16:
            if (this.byteBuffer.remaining() >= r5) goto L23;
            ByteBuffer r13 = ByteBuffer.allocate(roundUpToNextPowerOfTwo(this.byteBuffer.capacity() + r5));
            this.byteBuffer.flip();
            r13.put(this.byteBuffer);
            this.byteBuffer = r13;
            return;
        }

        public ByteBuffer getByteBuffer() {
            return this.byteBuffer;
        }

        public CharBuffer getCharBuffer() {
            return this.charBuffer;
        }

        public IntBuffer getIntBuffer() {
            return this.intBuffer;
        }

        public Type getType() {
            return this.type;
        }

        private Builder(int r5) {
            this.type = Type.BYTE;
            this.byteBuffer = ByteBuffer.allocate(r5);
            this.charBuffer = null;
            this.intBuffer = null;
            this.prevHighSurrogate = -1;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BYTE = null;
        public static final Type CHAR = null;
        public static final Type INT = null;

        static {
            Type r5 = new Type("BYTE", 0);
            BYTE = r5;
            Type r10 = new Type("CHAR", 1);
            CHAR = r10;
            Type r11 = new Type("INT", 2);
            INT = r11;
            $VALUES = new Type[]{r5, r10, r11};
        }

        private Type(String r5, int r10) {
            super(r5, r10);
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public /* synthetic */ CodePointBuffer(Type r5, ByteBuffer r10, CharBuffer r11, IntBuffer r12, AnonymousClass1 r13) {
        this(r5, r10, r11, r12);
    }

    public static Builder builder(int r5) {
        return new Builder(r5, null);
    }

    public static CodePointBuffer withBytes(ByteBuffer r5) {
        return new CodePointBuffer(Type.BYTE, r5, null, null);
    }

    public static CodePointBuffer withChars(CharBuffer r5) {
        return new CodePointBuffer(Type.CHAR, null, r5, null);
    }

    public static CodePointBuffer withInts(IntBuffer r5) {
        return new CodePointBuffer(Type.INT, null, null, r5);
    }

    public int arrayOffset() {
        int r5 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 != 3) goto L11;
        return this.intBuffer.arrayOffset();
    L11:
        throw new UnsupportedOperationException("Not reached");
    L13:
        return this.charBuffer.arrayOffset();
    L15:
        return this.byteBuffer.arrayOffset();
    }

    public byte[] byteArray() {
        return this.byteBuffer.array();
    }

    public char[] charArray() {
        return this.charBuffer.array();
    }

    public int get(int r5) {
        int r10 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 != 3) goto L11;
        return this.intBuffer.get(r5);
    L11:
        throw new UnsupportedOperationException("Not reached");
    L13:
        return this.charBuffer.get(r5);
    L15:
        return this.byteBuffer.get(r5);
    }

    public Type getType() {
        return this.type;
    }

    public int[] intArray() {
        return this.intBuffer.array();
    }

    public int position() {
        int r5 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 != 3) goto L11;
        return this.intBuffer.position();
    L11:
        throw new UnsupportedOperationException("Not reached");
    L13:
        return this.charBuffer.position();
    L15:
        return this.byteBuffer.position();
    }

    public int remaining() {
        int r5 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 != 3) goto L11;
        return this.intBuffer.remaining();
    L11:
        throw new UnsupportedOperationException("Not reached");
    L13:
        return this.charBuffer.remaining();
    L15:
        return this.byteBuffer.remaining();
    }

    private CodePointBuffer(Type r5, ByteBuffer r10, CharBuffer r11, IntBuffer r12) {
        this.type = r5;
        this.byteBuffer = r10;
        this.charBuffer = r11;
        this.intBuffer = r12;
    }

    public void position(int r5) {
        int r10 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[this.type.ordinal()];
        if (r10 != 1) goto L5;
        this.byteBuffer.position(r5);
        return;
    L5:
        if (r10 != 2) goto L7;
        this.charBuffer.position(r5);
        return;
    L7:
        if (r10 != 3) goto L15;
        this.intBuffer.position(r5);
        return;
    }
}
