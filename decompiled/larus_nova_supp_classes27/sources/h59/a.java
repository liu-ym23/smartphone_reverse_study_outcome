package h59;

import android.content.Context;
import com.bytedance.dora.annotation.ProductNameType;
import com.larus.dora.impl.dynamic.a2;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.util.u;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final Map<String, a2> a;

    /* JADX INFO: renamed from: h59.a$a, reason: collision with other inner class name */
    public static final class C0127a {
    }

    static {
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    public static String a(Context r4, String r5) {
        if (StringsKt.startsWith$default(r5, "PageData/DoraG/", false, 2, null) == false) goto L6;
        u.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "assetPath");
        return u.e(r4, DoraResourceDeviceType.G_SERIES, "assets/" + r5);
    L6:
        Reader r0 = new InputStreamReader(r4.getAssets().open(r5), Charsets.UTF_8);
        if ((r0 instanceof BufferedReader) == false) goto L9;
        BufferedReader r1 = (BufferedReader) r0;
    L18:
        String r6 = TextStreamsKt.readText(r1);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r1, null);
        return r6;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L9:
        r1 = new BufferedReader(r0, 8192);
        goto L18
    }

    public static String b(int r1, String r2) {
        if (r1 != ProductNameType.DORA_LITE.id) goto L6;
        String r3 = "PageData/DoraLite/";
    L13:
        return r3.concat(r2);
    L6:
        if (r1 != ProductNameType.DORA_E.id) goto L9;
        r3 = "PageData/DoraE/";
        goto L13
    L9:
        if (o59.a.o(Integer.valueOf(r1)) == false) goto L11;
        r3 = "PageData/DoraG/";
        goto L13
    L11:
        r3 = "PageData/";
        goto L13
    }
}
