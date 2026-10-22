package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class ReplacingInputStream extends FilterInputStream {
    final int[] buf;
    private int matchedIndex;
    private final byte[] pattern;
    private int replacedIndex;
    private final byte[] replacement;
    private State state;
    private int unbufferIndex;

    /* JADX INFO: renamed from: org.apache.poi.util.ReplacingInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$util$ReplacingInputStream$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$org$apache$poi$util$ReplacingInputStream$State = r0;
            r0[State.NOT_MATCHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.MATCHING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.REPLACING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.UNBUFFER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State MATCHING = null;
        public static final State NOT_MATCHED = null;
        public static final State REPLACING = null;
        public static final State UNBUFFER = null;

        static {
            State r0 = new State("NOT_MATCHED", 0);
            NOT_MATCHED = r0;
            State r1 = new State("MATCHING", 1);
            MATCHING = r1;
            State r3 = new State("REPLACING", 2);
            REPLACING = r3;
            State r5 = new State("UNBUFFER", 3);
            UNBUFFER = r5;
            $VALUES = new State[]{r0, r1, r3, r5};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    public ReplacingInputStream(InputStream r2, String r3, String r4) {
        byte[] r5 = r3.getBytes(StandardCharsets.UTF_8);
        if (r4 != null) goto L5;
        byte[] r6 = null;
    L6:
        this(r2, r5, r6);
        return;
    L5:
        r6 = r4.getBytes(StandardCharsets.UTF_8);
        goto L6
    }

    public ReplacingInputStream(InputStream r1, byte[] r2, byte[] r3) {
        super(r1);
        this.state = State.NOT_MATCHED;
        if (r2 == null) goto L9;
        if (r2.length == 0) goto L9;
        this.pattern = r2;
        this.replacement = r3;
        this.buf = new int[r2.length];
        return;
    L9:
        throw new IllegalArgumentException("pattern length should be > 0");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$util$ReplacingInputStream$State[this.state.ordinal()];
        if (r0 != 2) goto L5;
        int r1 = super.read();
        byte[] r2 = this.pattern;
        int r3 = this.matchedIndex;
        if (r2[r3] != r1) goto L36;
        int[] r4 = this.buf;
        int r5 = r3 + 1;
        this.matchedIndex = r5;
        r4[r3] = r1;
        if (r5 != r2.length) goto L38;
        byte[] r6 = this.replacement;
        if (r6 != null) goto L32;
    L35:
        this.state = State.NOT_MATCHED;
        this.matchedIndex = 0;
        goto L38
    L32:
        if (r6.length == 0) goto L35;
        this.state = State.REPLACING;
        this.replacedIndex = 0;
    L38:
        return read();
    L36:
        int[] r7 = this.buf;
        this.matchedIndex = r3 + 1;
        r7[r3] = r1;
        this.state = State.UNBUFFER;
        this.unbufferIndex = 0;
        goto L38
    L5:
        if (r0 != 3) goto L7;
        byte[] r8 = this.replacement;
        int r9 = this.replacedIndex;
        int r10 = r9 + 1;
        this.replacedIndex = r10;
        byte r11 = r8[r9];
        if (r10 != r8.length) goto L24;
        this.state = State.NOT_MATCHED;
        this.replacedIndex = 0;
    L24:
        return r11;
    L7:
        if (r0 == 4) goto L17;
        int r12 = super.read();
        if (this.pattern[0] == r12) goto L11;
        return r12;
    L11:
        Arrays.fill(this.buf, 0);
        this.matchedIndex = 0;
        int[] r13 = this.buf;
        this.matchedIndex = 0 + 1;
        r13[0] = r12;
        if (this.pattern.length != 1) goto L14;
        this.state = State.REPLACING;
        this.replacedIndex = 0;
    L16:
        return read();
    L14:
        this.state = State.MATCHING;
        goto L16
    L17:
        int[] r14 = this.buf;
        int r15 = this.unbufferIndex;
        int r16 = r15 + 1;
        this.unbufferIndex = r16;
        int r17 = r14[r15];
        if (r16 != this.matchedIndex) goto L20;
        this.state = State.NOT_MATCHED;
        this.matchedIndex = 0;
    L20:
        return r17;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r5, int r6, int r7) {
        Objects.requireNonNull(r5);
        if (r6 < 0) goto L21;
        if (r7 < 0) goto L21;
        if (r7 > (r5.length - r6)) goto L21;
        if (r7 != 0) goto L10;
        return 0;
    L10:
        int r0 = read();
        if (r0 != (-1)) goto L13;
        return -1;
    L13:
        r5[r6] = (byte) r0;
        int r1 = 1;
    L14:
        if (r1 >= r7) goto L19;
        int r2 = read();
        if (r2 == (-1)) goto L19;
        r5[r6 + r1] = (byte) r2;
        r1 = r1 + 1;
    L19:
        return r1;
    L21:
        throw new IndexOutOfBoundsException();
    }

    public String toString() {
        return this.state.name() + " " + this.matchedIndex + " " + this.replacedIndex + " " + this.unbufferIndex;
    }
}
