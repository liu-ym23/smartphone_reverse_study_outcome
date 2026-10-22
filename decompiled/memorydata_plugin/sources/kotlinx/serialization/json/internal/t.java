package kotlinx.serialization.json.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u0012*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0000\u001a\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\bH\u0000¢\u0006\u0002\u0010\u0018\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"&\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"ESCAPE_MARKERS", "", "getESCAPE_MARKERS$annotations", "()V", "getESCAPE_MARKERS", "()[B", "ESCAPE_STRINGS", "", "", "getESCAPE_STRINGS$annotations", "getESCAPE_STRINGS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "toHexChar", "", "i", "", "printQuoted", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", EventBody.KEY_VALUE, "toBooleanStrictOrNull", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f17852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f17853b = null;

    static {
        String[] r1 = new String[93];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 32) goto L6;
        r1[r3] = "\\u" + a(r3 >> 12) + a(r3 >> 8) + a(r3 >> 4) + a(r3);
        r3 = r3 + 1;
        goto L4
    L6:
        r1[34] = "\\\"";
        r1[92] = "\\\\";
        r1[9] = "\\t";
        r1[8] = "\\b";
        r1[10] = "\\n";
        r1[13] = "\\r";
        r1[12] = "\\f";
        f17852a = r1;
        byte[] r0 = new byte[93];
    L7:
        if (r2 >= 32) goto L9;
        r0[r2] = 1;
        r2 = r2 + 1;
        goto L7
    L9:
        r0[34] = 34;
        r0[92] = 92;
        r0[9] = 116;
        r0[8] = 98;
        r0[10] = 110;
        r0[13] = 114;
        r0[12] = 102;
        f17853b = r0;
    }

    private static final char a(int r1) {
        int r2 = r1 & 15;
        if (r2 >= 10) goto L5;
        int r3 = r2 + 48;
    L7:
        return (char) r3;
    L5:
        r3 = (r2 - 10) + 97;
        goto L7
    }

    public static final Boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (StringsKt.equals(r2, "true", true) == false) goto L6;
        return true;
    L6:
        if (StringsKt.equals(r2, "false", true) == true) goto L11;
        return null;
    L11:
        return false;
    }

    public static final void a(StringBuilder r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, EventBody.KEY_VALUE);
        r8.append(Typography.quote);
        int r1 = r9.length();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r1) goto L11;
        char r5 = r9.charAt(r2);
        String[] r6 = f17852a;
        if (r5 >= r6.length) goto L10;
        if (r6[r5] == null) goto L10;
        r8.append((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), r3, r2);
        r8.append(r6[r5]);
        r3 = r2 + 1;
    L10:
        r2 = r2 + 1;
        goto L4
    L11:
        if (r3 == 0) goto L13;
        r8.append((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), r3, r9.length());
    L14:
        r8.append(Typography.quote);
        return;
    L13:
        r8.append(r9);
        goto L14
    }
}
