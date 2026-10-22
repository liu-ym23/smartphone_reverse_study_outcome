package g7;

import java.io.PrintWriter;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9003a = null;

    static {
        f9003a = new a();
    }

    private a() {
    }

    public final void a(List<String> r10, PrintWriter r11, Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "printer");
        Intrinsics.checkNotNullParameter(r12, "cmd");
        String r13 = (String) CollectionsKt.getOrNull(r10, 1);
        if (r13 == null) goto L5;
        r12.invoke(r13);
        Unit r14 = Unit.INSTANCE;
    L6:
        if (r14 != null) goto L9;
        r11.println("target package name required");
        return;
    L9:
        return;
    L5:
        r14 = null;
        goto L6
    }
}
