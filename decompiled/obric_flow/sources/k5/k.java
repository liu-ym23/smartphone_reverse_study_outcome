package k5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f18621a = null;

    static {
        f18621a = Pattern.compile("/(data|user|local_file)/.+?/([^\\/]+?)/\\d{5}\\d+/res/([^?]+)");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "fullUrl");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        if (StringsKt.P(r5, "http") == false) goto L8;
        r5 = CollectionsKt.first(StringsKt.K(r5, new String[]{"?"}, 0, 6));     // Catch: Throwable -> L6
    L20:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        ?? r11 = r5;
    L24:
        return (String) r11;
    L8:
        boolean r12 = StringsKt.P(r5, "/data");     // Catch: Throwable -> L6
        r5 = r5;
        if (r12 == false) goto L20;
        Matcher r13 = f18621a.matcher(r5);     // Catch: Throwable -> L6
        if (r13.find() == false) goto L14;
        String r14 = r13.group(2);     // Catch: Throwable -> L6
        String r15 = r13.group(3);     // Catch: Throwable -> L6
    L15:
        r5 = r5;
        if (StringsKt.isBlank(r14) == true) goto L20;
        r5 = r5;
        if (StringsKt.isBlank(r15) == true) goto L20;
        r5 = "lynxview://" + r14 + '/' + r15;     // Catch: Throwable -> L6
        goto L20
    L14:
        r14 = "";
        r15 = "";
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r11 = r5;
        goto L24
    }
}
