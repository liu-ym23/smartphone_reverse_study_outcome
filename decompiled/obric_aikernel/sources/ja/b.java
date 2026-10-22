package ja;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9792a = null;

    static {
        f9792a = new b();
    }

    private b() {
    }

    private final String a(Context r17) {
        StringBuilder r10 = new StringBuilder("{\n");
        String[] r11 = r17.getAssets().list("pap/packages");
        if (r11 == null) goto L26;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L26;
        String r14 = r11[r13];
        Intrinsics.checkNotNullExpressionValue(r14, "it");
        if (StringsKt.endsWith$default(r14, ".somap", false, 2, null) == false) goto L19;
        InputStream r15 = r17.getAssets().open("pap/packages/" + r14);
        Intrinsics.checkNotNullExpressionValue(r15, "context.assets.open(\"$packagePrefix/$it\")");
        Reader r16 = new InputStreamReader(r15, Charsets.UTF_8);
        if ((r16 instanceof BufferedReader) == false) goto L12;
        BufferedReader r18 = (BufferedReader) r16;
    L30:
        Iterator<String> r19 = TextStreamsKt.lineSequence(r18).iterator();     // Catch: Throwable -> L20
    L15:
        if (r19.hasNext() == false) goto L17;
        List r20 = StringsKt.split$default(r19.next(), new String[]{"="}, false, 0, 6, null);     // Catch: Throwable -> L20
        String r110 = (String) r20.get(0);     // Catch: Throwable -> L20
        r10.append(Typography.quote + ((String) r20.get(1)) + "\":\"" + r110 + "\",");     // Catch: Throwable -> L20
        goto L15
    L17:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r18, null);
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L12:
        r18 = new BufferedReader(r16, 8192);
    L19:
        r13 = r13 + 1;
    L26:
        r10.append("}");
        String r22 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r22, "builder.toString()");
        return r22;
    }

    public final String b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return "from importlib._bootstrap_external import _builtin_mods\n_builtin_mods.update(" + a(r10) + ")\n";
    }
}
