package okhttp3.internal.platform.android;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"MAX_LOG_LENGTH", "", "androidLog", "", "level", "message", "", "t", "", "okhttp"}, k = 2, mv = {1, 1, 15})
public final class UtilKt {
    private static final int MAX_LOG_LENGTH = 4000;

    public static final void androidLog(int r7, String r8, Throwable r9) {
        Intrinsics.checkParameterIsNotNull(r8, "message");
        int r0 = 5;
        if (r7 == 5) goto L6;
        r0 = 3;
    L6:
        if (r9 == null) goto L8;
        r8 = r8 + "\n" + Log.getStackTraceString(r9);
    L8:
        int r10 = 0;
        int r11 = r8.length();
    L9:
        if (r10 >= r11) goto L22;
        int r1 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), '\n', r10, false, 4, null);
        if (r1 != (-1)) goto L14;
        r1 = r11;
    L14:
        int r2 = Math.min(r1, r10 + MAX_LOG_LENGTH);
        if (r8 == null) goto L21;
        String r12 = r8.substring(r10, r2);
        Intrinsics.checkExpressionValueIsNotNull(r12, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.println(r0, "OkHttp", r12);
        if (r2 >= r1) goto L18;
        r10 = r2;
        goto L14
    L18:
        r10 = r2 + 1;
        goto L9
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
