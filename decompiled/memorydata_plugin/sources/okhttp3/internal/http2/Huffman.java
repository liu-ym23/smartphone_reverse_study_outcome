package okhttp3.internal.http2;

import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/http2/Huffman;", "", "()V", "CODES", "", "CODE_BIT_COUNTS", "", "root", "Lokhttp3/internal/http2/Huffman$Node;", "addCode", "", "symbol", "", "code", "codeBitCount", "decode", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "byteCount", "", "sink", "Lokio/BufferedSink;", "encode", "Lokio/ByteString;", "encodedLength", "bytes", "Node", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Huffman {
    private static final int[] CODES = null;
    private static final byte[] CODE_BIT_COUNTS = null;
    public static final Huffman INSTANCE = null;
    private static final Node root = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, k = 1, mv = {1, 1, 15})
    private static final class Node {
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public Node(int r4, int r5) {
            this.children = (Node[]) ZeusTransformUtils.preCheckCast(null, Node[].class, "com.obric.memorydata.plugin");
            this.symbol = r4;
            int r6 = r5 & 7;
            if (r6 != 0) goto L5;
            r6 = 8;
        L5:
            this.terminalBitCount = r6;
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
    }

    static {
        Huffman r0 = new Huffman();
        INSTANCE = r0;
        CODES = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, IdlErrors.E_RejectInferDeviceOverheat, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] r1 = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        CODE_BIT_COUNTS = r1;
        root = new Node();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0.addCode(r3, CODES[r3], CODE_BIT_COUNTS[r3]);
        r3 = r3 + 1;
        goto L3
    }

    private Huffman() {
    }

    private final void addCode(int r3, int r4, int r5) {
        Node r2 = new Node(r3, r5);
        Node r6 = root;
    L4:
        if (r5 <= 8) goto L12;
        r5 = r5 - 8;
        int r0 = (r4 >>> r5) & 255;
        Node[] r7 = r6.getChildren();
        if (r7 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        Node r1 = r7[r0];
        if (r1 != null) goto L11;
        r1 = new Node();
        r7[r0] = r1;
    L11:
        r6 = r1;
        goto L4
    L12:
        int r8 = 8 - r5;
        int r9 = (r4 << r8) & 255;
        int r10 = 1 << r8;
        Node[] r11 = r6.getChildren();
        if (r11 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        ArraysKt.fill(r11, r2, r9, r10 + r9);
    }

    public final void decode(BufferedSource r8, long r9, BufferedSink r11) {
        BufferedSource r7 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r8, BufferedSource.class, "com.obric.memorydata.plugin");
        BufferedSink r10 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r11, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r10, "sink");
        Node r12 = root;
        int r0 = 0;
        long r2 = 0;
        int r1 = 0;
    L4:
        if (r2 >= r9) goto L19;
        r0 = (r0 << 8) | Util.and(r7.readByte(), 255);
        r1 = r1 + 8;
    L7:
        if (r1 < 8) goto L18;
        int r4 = r1 - 8;
        int r6 = (r0 >>> r4) & 255;
        Node[] r13 = r12.getChildren();
        if (r13 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r12 = r13[r6];
        if (r12 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        if (r12.getChildren() == null) goto L16;
        r1 = r4;
        goto L7
    L16:
        r10.writeByte(r12.getSymbol());
        r1 = r1 - r12.getTerminalBitCount();
        r12 = root;
        goto L7
    L18:
        r2 = r2 + 1;
    L19:
        if (r1 <= 0) goto L32;
        int r14 = (r0 << (8 - r1)) & 255;
        Node[] r15 = r12.getChildren();
        if (r15 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        Node r16 = r15[r14];
        if (r16 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        if (r16.getChildren() != null) goto L43;
        if (r16.getTerminalBitCount() > r1) goto L44;
        r10.writeByte(r16.getSymbol());
        r1 = r1 - r16.getTerminalBitCount();
        r12 = root;
        goto L19
    L44:
        return;
    L43:
        return;
    }

    public final void encode(ByteString r8, BufferedSink r9) {
        BufferedSink r7 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r9, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r7, "sink");
        int r10 = r8.size();
        int r0 = 0;
        long r2 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r10) goto L9;
        int r4 = Util.and(r8.getByte(r0), 255);
        int r5 = CODES[r4];
        byte r6 = CODE_BIT_COUNTS[r4];
        r2 = (r2 << r6) | ((long) r5);
        r1 = r1 + r6;
    L6:
        if (r1 < 8) goto L8;
        r1 = r1 - 8;
        r7.writeByte((int) (r2 >> r1));
        goto L6
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        if (r1 <= 0) goto L14;
        r7.writeByte((int) ((r2 << (8 - r1)) | (255 >>> r1)));
        return;
    }

    public final int encodedLength(ByteString r6) {
        Intrinsics.checkParameterIsNotNull(r6, "bytes");
        int r5 = r6.size();
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        int r3 = Util.and(r6.getByte(r2), 255);
        r0 = r0 + ((long) CODE_BIT_COUNTS[r3]);
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) ((r0 + ((long) 7)) >> 3);
    }
}
