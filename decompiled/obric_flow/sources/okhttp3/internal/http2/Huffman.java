package okhttp3.internal.http2;

import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import nu.k;
import nu.l;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lokhttp3/internal/http2/Huffman;", "", "<init>", "()V", "", "symbol", "code", "codeBitCount", "", "addCode", "(III)V", "Lokio/ByteString;", "source", "Lnu/k;", "sink", "encode", "(Lokio/ByteString;Lnu/k;)V", "bytes", "encodedLength", "(Lokio/ByteString;)I", "Lnu/l;", "", "byteCount", "decode", "(Lnu/l;JLnu/k;)V", "", "CODES", "[I", "", "CODE_BIT_COUNTS", "[B", "Lokhttp3/internal/http2/Huffman$Node;", "root", "Lokhttp3/internal/http2/Huffman$Node;", "Node", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Huffman {
    private static final int[] CODES = null;
    private static final byte[] CODE_BIT_COUNTS = null;
    public static final Huffman INSTANCE = null;
    private static final Node root = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Node {
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node(int r5, int r10) {
            this.children = null;
            this.symbol = r5;
            int r11 = r10 & 7;
            if (r11 != 0) goto L5;
            r11 = 8;
        L5:
            this.terminalBitCount = r11;
        }
    }

    static {
        Huffman r5 = new Huffman();
        INSTANCE = r5;
        int r10 = 0;
        CODES = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] r11 = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        CODE_BIT_COUNTS = r11;
        root = new Node();
        int r12 = r11.length;
    L3:
        if (r10 >= r12) goto L5;
        r5.addCode(r10, CODES[r10], CODE_BIT_COUNTS[r10]);
        r10 = r10 + 1;
        goto L3
    }

    private Huffman() {
    }

    private final void addCode(int r5, int r10, int r11) {
        Node r12 = new Node(r5, r11);
        Node r13 = root;
    L4:
        if (r11 <= 8) goto L9;
        r11 = r11 - 8;
        int r14 = (r10 >>> r11) & 255;
        Node[] r15 = r13.getChildren();
        Intrinsics.checkNotNull(r15);
        Node r16 = r15[r14];
        if (r16 != null) goto L8;
        r16 = new Node();
        r15[r14] = r16;
    L8:
        r13 = r16;
        goto L4
    L9:
        int r17 = 8 - r11;
        int r18 = (r10 << r17) & 255;
        Node[] r19 = r13.getChildren();
        Intrinsics.checkNotNull(r19);
        ArraysKt.fill(r19, r12, r18, (1 << r17) + r18);
    }

    public final void decode(l r10, long r11, k r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r12, "sink");
        Node r13 = root;
        int r5 = 0;
        long r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r11) goto L13;
        r5 = (r5 << 8) | Util.and(r10.readByte(), 255);
        r15 = r15 + 8;
    L7:
        if (r15 < 8) goto L12;
        int r16 = r15 - 8;
        Node[] r17 = r13.getChildren();
        Intrinsics.checkNotNull(r17);
        r13 = r17[(r5 >>> r16) & 255];
        Intrinsics.checkNotNull(r13);
        if (r13.getChildren() == null) goto L10;
        r15 = r16;
        goto L7
    L10:
        r12.writeByte(r13.getSymbol());
        r15 = r15 - r13.getTerminalBitCount();
        r13 = root;
        goto L7
    L12:
        r14 = r14 + 1;
    L13:
        if (r15 <= 0) goto L31;
        Node[] r18 = r13.getChildren();
        Intrinsics.checkNotNull(r18);
        Node r19 = r18[(r5 << (8 - r15)) & 255];
        Intrinsics.checkNotNull(r19);
        if (r19.getChildren() != null) goto L32;
        if (r19.getTerminalBitCount() > r15) goto L20;
        r12.writeByte(r19.getSymbol());
        r15 = r15 - r19.getTerminalBitCount();
        r13 = root;
        goto L13
    L20:
        return;
    L32:
        return;
    }

    public final void encode(ByteString r10, k r11) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "sink");
        int r12 = r10.size();
        long r5 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L9;
        int r15 = Util.and(r10.getByte(r13), 255);
        int r16 = CODES[r15];
        byte r17 = CODE_BIT_COUNTS[r15];
        r5 = (r5 << r17) | ((long) r16);
        r14 = r14 + r17;
    L6:
        if (r14 < 8) goto L8;
        r14 = r14 - 8;
        r11.writeByte((int) (r5 >> r14));
        goto L6
    L8:
        r13 = r13 + 1;
        goto L3
    L9:
        if (r14 <= 0) goto L14;
        r11.writeByte((int) ((r5 << (8 - r14)) | (255 >>> r14)));
        return;
    }

    public final int encodedLength(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        int r5 = r10.size();
        long r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L6;
        int r13 = Util.and(r10.getByte(r12), 255);
        r11 = r11 + ((long) CODE_BIT_COUNTS[r13]);
        r12 = r12 + 1;
        goto L3
    L6:
        return (int) ((r11 + ((long) 7)) >> 3);
    }
}
