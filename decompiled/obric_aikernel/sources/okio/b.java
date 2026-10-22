package okio;

import com.bytedance.apm6.util.constant.NetConst;
import kotlin.UShort;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "-SegmentedByteString")
@SourceDebugExtension({"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,187:1\n68#1:188\n74#1:189\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n106#1:188\n107#1:189\n*E\n"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.a f12170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f12171b = 0;

    static {
        f12170a = new d.a();
        f12171b = -1234567890;
    }

    public static final boolean a(byte[] r10, int r11, byte[] r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r12, "b");
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        if (r10[r15 + r11] != r12[r15 + r13]) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final void b(long r10, long r11, long r12) {
        if ((r11 | r12) < 0) goto L10;
        if (r11 > r10) goto L10;
        if ((r10 - r11) < r12) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("size=" + r10 + " offset=" + r11 + " byteCount=" + r12);
    }

    public static final int c() {
        return f12171b;
    }

    public static final int d(ByteString r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == f12171b) goto L5;
        return r11;
    L5:
        return r10.size();
    }

    public static final int e(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == f12171b) goto L5;
        return r11;
    L5:
        return r10.length;
    }

    public static final int f(int r10) {
        int r11 = ((((-16777216) & r10) >>> 24) | ((16711680 & r10) >>> 8)) | ((65280 & r10) << 8);
        return ((r10 & 255) << 24) | r11;
    }

    public static final long g(long r10) {
        long r11 = ((((((((-72057594037927936L) & r10) >>> 56) | ((71776119061217280L & r10) >>> 40)) | ((280375465082880L & r10) >>> 24)) | ((1095216660480L & r10) >>> 8)) | ((4278190080L & r10) << 8)) | ((16711680 & r10) << 24)) | ((65280 & r10) << 40);
        return ((r10 & 255) << 56) | r11;
    }

    public static final short h(short r10) {
        int r11 = r10 & UShort.MAX_VALUE;
        int r12 = (65280 & r11) >>> 8;
        return (short) (((r11 & 255) << 8) | r12);
    }

    public static final String i(byte r10) {
        return StringsKt.concatToString(new char[]{okio.internal.b.f()[(r10 >> 4) & 15], okio.internal.b.f()[r10 & 15]});
    }

    public static final String j(int r10) {
        if (r10 != 0) goto L5;
        return NetConst.NOT_ENCRYPT_VERISON_CODE;
    L5:
        int r11 = 0;
        char[] r12 = {okio.internal.b.f()[(r10 >> 28) & 15], okio.internal.b.f()[(r10 >> 24) & 15], okio.internal.b.f()[(r10 >> 20) & 15], okio.internal.b.f()[(r10 >> 16) & 15], okio.internal.b.f()[(r10 >> 12) & 15], okio.internal.b.f()[(r10 >> 8) & 15], okio.internal.b.f()[(r10 >> 4) & 15], okio.internal.b.f()[r10 & 15]};
    L6:
        if (r11 >= 8) goto L11;
        if (r12[r11] != '0') goto L11;
        r11 = r11 + 1;
    L11:
        return StringsKt.concatToString(r12, r11, 8);
    }
}
