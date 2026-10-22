package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public abstract class CodePointCharStream implements CharStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final String name;
    protected int position;
    protected final int size;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.runtime.CodePointCharStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type = null;

        static {
            int[] r5 = new int[CodePointBuffer.Type.values().length];
            $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type = r5;
            r5[CodePointBuffer.Type.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[CodePointBuffer.Type.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[CodePointBuffer.Type.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class CodePoint16BitCharStream extends CodePointCharStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final char[] charArray;

        public /* synthetic */ CodePoint16BitCharStream(int r5, int r10, String r11, char[] r12, int r13, AnonymousClass1 r14) {
            this(r5, r10, r11, r12, r13);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
        public int LA(int r5) {
            int r10 = Integer.signum(r5);
            if (r10 == (-1)) goto L17;
            if (r10 != 0) goto L6;
            return 0;
        L6:
            if (r10 != 1) goto L14;
            int r11 = (this.position + r5) - 1;
            if (r11 < this.size) goto L10;
            return -1;
        L10:
            char r12 = this.charArray[r11];
        L12:
            return r12 & 65535;
        L14:
            throw new UnsupportedOperationException("Not reached");
        L17:
            int r13 = this.position + r5;
            if (r13 >= 0) goto L20;
            return -1;
        L20:
            r12 = this.charArray[r13];
            goto L12
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CodePointCharStream
        public Object getInternalStorage() {
            return this.charArray;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CharStream
        public String getText(Interval r5) {
            return new String(this.charArray, Math.min(r5.f665a, this.size - 1), Math.min((r5.f666b - r5.f665a) + 1, this.size));
        }

        private CodePoint16BitCharStream(int r5, int r10, String r11, char[] r12, int r13) {
            super(r5, r10, r11, null);
            this.charArray = r12;
        }
    }

    public static final class CodePoint32BitCharStream extends CodePointCharStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int[] intArray;

        public /* synthetic */ CodePoint32BitCharStream(int r5, int r10, String r11, int[] r12, int r13, AnonymousClass1 r14) {
            this(r5, r10, r11, r12, r13);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
        public int LA(int r5) {
            int r10 = Integer.signum(r5);
            if (r10 == (-1)) goto L16;
            if (r10 != 0) goto L6;
            return 0;
        L6:
            if (r10 != 1) goto L13;
            int r11 = (this.position + r5) - 1;
            if (r11 < this.size) goto L11;
            return -1;
        L11:
            return this.intArray[r11];
        L13:
            throw new UnsupportedOperationException("Not reached");
        L16:
            int r12 = this.position + r5;
            if (r12 >= 0) goto L20;
            return -1;
        L20:
            return this.intArray[r12];
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CodePointCharStream
        public Object getInternalStorage() {
            return this.intArray;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CharStream
        public String getText(Interval r5) {
            return new String(this.intArray, Math.min(r5.f665a, this.size - 1), Math.min((r5.f666b - r5.f665a) + 1, this.size));
        }

        private CodePoint32BitCharStream(int r5, int r10, String r11, int[] r12, int r13) {
            super(r5, r10, r11, null);
            this.intArray = r12;
        }
    }

    public static final class CodePoint8BitCharStream extends CodePointCharStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] byteArray;

        public /* synthetic */ CodePoint8BitCharStream(int r5, int r10, String r11, byte[] r12, int r13, AnonymousClass1 r14) {
            this(r5, r10, r11, r12, r13);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
        public int LA(int r5) {
            int r10 = Integer.signum(r5);
            if (r10 == (-1)) goto L17;
            if (r10 != 0) goto L6;
            return 0;
        L6:
            if (r10 != 1) goto L14;
            int r11 = (this.position + r5) - 1;
            if (r11 < this.size) goto L10;
            return -1;
        L10:
            byte r12 = this.byteArray[r11];
        L12:
            return r12 & UByte.MAX_VALUE;
        L14:
            throw new UnsupportedOperationException("Not reached");
        L17:
            int r13 = this.position + r5;
            if (r13 >= 0) goto L20;
            return -1;
        L20:
            r12 = this.byteArray[r13];
            goto L12
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CodePointCharStream
        public Object getInternalStorage() {
            return this.byteArray;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CharStream
        public String getText(Interval r5) {
            int r10 = Math.min(r5.f665a, this.size);
            int r11 = Math.min((r5.f666b - r5.f665a) + 1, this.size - r10);
            return new String(this.byteArray, r10, r11, StandardCharsets.ISO_8859_1);
        }

        private CodePoint8BitCharStream(int r5, int r10, String r11, byte[] r12, int r13) {
            super(r5, r10, r11, null);
            this.byteArray = r12;
        }
    }

    public /* synthetic */ CodePointCharStream(int r5, int r10, String r11, AnonymousClass1 r12) {
        this(r5, r10, r11);
    }

    public static CodePointCharStream fromBuffer(CodePointBuffer r5) {
        return fromBuffer(r5, IntStream.UNKNOWN_SOURCE_NAME);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public final void consume() {
        int r5 = this.size;
        int r10 = this.position;
        if ((r5 - r10) == 0) goto L7;
        this.position = r10 + 1;
        return;
    L7:
        throw new IllegalStateException("cannot consume EOF");
    }

    public abstract Object getInternalStorage();

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public final String getSourceName() {
        String r5 = this.name;
        if (r5 != null) goto L5;
        return IntStream.UNKNOWN_SOURCE_NAME;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return IntStream.UNKNOWN_SOURCE_NAME;
    L8:
        return this.name;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public final int index() {
        return this.position;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public final int mark() {
        return -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public final void release(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public final void seek(int r5) {
        this.position = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public final int size() {
        return this.size;
    }

    public final String toString() {
        return getText(Interval.of(0, this.size - 1));
    }

    private CodePointCharStream(int r5, int r10, String r11) {
        this.size = r10;
        this.name = r11;
        this.position = 0;
    }

    public static CodePointCharStream fromBuffer(CodePointBuffer r16, String r17) {
        int r5 = AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$CodePointBuffer$Type[r16.getType().ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 != 3) goto L11;
        return new CodePoint32BitCharStream(r16.position(), r16.remaining(), r17, r16.intArray(), r16.arrayOffset(), null);
    L11:
        throw new UnsupportedOperationException("Not reached");
    L13:
        return new CodePoint16BitCharStream(r16.position(), r16.remaining(), r17, r16.charArray(), r16.arrayOffset(), null);
    L15:
        return new CodePoint8BitCharStream(r16.position(), r16.remaining(), r17, r16.byteArray(), r16.arrayOffset(), null);
    }
}
