package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"MAX_UTF8_INFO_LENGTH", "", "UTF8_MODE_MARKER", "", "bytesToStrings", "", "", "bytes", "", "([B)[Ljava/lang/String;", "stringsToBytes", "strings", "([Ljava/lang/String;)[B", "metadata.jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UtfEncodingKt {
    public static final int MAX_UTF8_INFO_LENGTH = 65535;
    public static final char UTF8_MODE_MARKER = 0;

    public static final String[] bytesToStrings(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        ArrayList r5 = new ArrayList(1);
        StringBuilder r11 = new StringBuilder();
        r11.append(0);
        int r12 = r10.length;
        int r13 = 2;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L15;
        byte r15 = r10[r14];
        r11.append((char) (r15 & UByte.MAX_VALUE));
        if (1 <= r15) goto L7;
    L9:
        r13 = r13 + 2;
    L11:
        if (r13 < 65534) goto L13;
        r5.add(r11.toString());
        r11.setLength(0);
        r13 = 0;
    L13:
        r14 = r14 + 1;
        goto L3
    L7:
        if (r15 >= 128) goto L9;
        r13 = r13 + 1;
        goto L11
    L15:
        if (r11.length() == 0) goto L18;
        r5.add(r11.toString());
    L18:
        Object[] r16 = r5.toArray(new String[0]);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) r16;
    }

    public static final byte[] stringsToBytes(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "strings");
        int r5 = r10.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r12 = r12 + r10[r11].length();
        r11 = r11 + 1;
        goto L3
    L5:
        byte[] r13 = new byte[r12];
        int r14 = r10.length;
        int r15 = 0;
        int r16 = 0;
    L6:
        if (r15 >= r14) goto L11;
        String r17 = r10[r15];
        int r18 = r17.length();
        int r19 = 0;
    L8:
        if (r19 >= r18) goto L10;
        r13[r16] = (byte) r17.charAt(r19);
        r19 = r19 + 1;
        r16 = r16 + 1;
        goto L8
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r13;
    }
}
