package dtb;

import com.larksuite.framework.utils.a0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final int a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        Log.w(r4, "sid is invalid");
        int r0 = a0.a(0);
    L12:
        Log.i(r4, "sid is -> " + r3 + "  notificationId is -> " + r0);
        return r0;
    L11:
        r0 = r3.hashCode();
        goto L12
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Integer] */
    public static final int b(Notice r3, String r4) {
        if (r4 != 0) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r4 = Integer.valueOf(a0.a(0));
    L11:
        if (r3 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L22;
        ?? r6 = new Object[2];
        String r7 = r3.extra.p;
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r6[0] = r7;
        r6[1] = r4;
        return Objects.hash(r6);
    L22:
        return Objects.hash(new Object[]{r4});
    L13:
        if (r3.isFromBackgroundUser != true) goto L15;
        r5 = true;
        goto L16
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r2 = false;
        goto L9
    }
}
