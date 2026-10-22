package kotlin.io.encoding;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a5\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b¨\u0006\u000e"}, d2 = {"platformCharsToBytes", "", "Lkotlin/io/encoding/Base64;", AILabCheckPermissionTask.KEY_SOURCE, "", "startIndex", "", "endIndex", "platformEncodeIntoByteArray", "destination", "destinationOffset", "platformEncodeToByteArray", "platformEncodeToString", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Base64JVMKt {
    private static final byte[] platformCharsToBytes(Base64 r2, CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, AILabCheckPermissionTask.KEY_SOURCE);
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L6;
        r2.checkSourceBounds$kotlin_stdlib(r6.length(), r4, r5);
        String r7 = ((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")).substring(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        Charset r8 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.String");
        byte[] r9 = r7.getBytes(r8);
        Intrinsics.checkNotNullExpressionValue(r9, "getBytes(...)");
        return r9;
    L6:
        return r2.charsToBytesImpl$kotlin_stdlib(r6, r4, r5);
    }

    private static final int platformEncodeIntoByteArray(Base64 r1, byte[] r2, byte[] r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "destination");
        return r1.encodeIntoByteArrayImpl$kotlin_stdlib(r2, r3, r4, r5, r6);
    }

    private static final byte[] platformEncodeToByteArray(Base64 r1, byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        return r1.encodeToByteArrayImpl$kotlin_stdlib(r2, r3, r4);
    }

    private static final String platformEncodeToString(Base64 r1, byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        return new String(r1.encodeToByteArrayImpl$kotlin_stdlib(r2, r3, r4), Charsets.ISO_8859_1);
    }
}
