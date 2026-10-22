package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ExceptionsKt {
    public static final /* synthetic */ String access$constructMessage(File r10, File r11, String r12) {
        return constructMessage(r10, r11, r12);
    }

    private static final String constructMessage(File r10, File r11, String r12) {
        StringBuilder r13 = new StringBuilder(r10.toString());
        if (r11 == null) goto L5;
        r13.append(" -> " + r11);
    L5:
        if (r12 == null) goto L7;
        r13.append(": " + r12);
    L7:
        String r14 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "sb.toString()");
        return r14;
    }
}
