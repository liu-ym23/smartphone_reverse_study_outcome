package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"lowestBitOf", "", "bits", "", "binarySearch", "", "value", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnapshotIdSetKt {
    public static final /* synthetic */ int access$lowestBitOf(long r5) {
        return lowestBitOf(r5);
    }

    public static final int binarySearch(int[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r11 = r5.length - 1;
        int r12 = 0;
    L3:
        if (r12 > r11) goto L11;
        int r13 = (r12 + r11) >>> 1;
        int r14 = r5[r13];
        if (r10 > r14) goto L6;
        if (r10 >= r14) goto L9;
        r11 = r13 - 1;
        goto L3
    L9:
        return r13;
    L6:
        r12 = r13 + 1;
        goto L3
    L11:
        return -(r12 + 1);
    }

    private static final int lowestBitOf(long r10) {
        if ((4294967295L & r10) != 0) goto L5;
        int r5 = 32;
        r10 = r10 >> 32;
    L7:
        if ((WebSocketProtocol.PAYLOAD_SHORT_MAX & r10) != 0) goto L10;
        r5 = r5 + 16;
        r10 = r10 >> 16;
    L10:
        if ((255 & r10) != 0) goto L13;
        r5 = r5 + 8;
        r10 = r10 >> 8;
    L13:
        if ((15 & r10) != 0) goto L16;
        r5 = r5 + 4;
        r10 = r10 >> 4;
    L16:
        if ((1 & r10) == 0) goto L19;
        return r5;
    L19:
        if ((2 & r10) == 0) goto L23;
        return r5 + 1;
    L23:
        if ((4 & r10) == 0) goto L27;
        return r5 + 2;
    L27:
        if ((r10 & 8) != 0) goto L29;
        return -1;
    L29:
        return r5 + 3;
    L5:
        r5 = 0;
        goto L7
    }
}
