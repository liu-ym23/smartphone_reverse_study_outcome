package com.obric.aikernel.qnn;

import android.os.SystemClock;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.utils.f;
import com.obric.aikernel.utils.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f4834b = null;

    static {
        f4833a = new a();
        f4834b = MapsKt.mapOf(new Pair[]{TuplesKt.to("SM8750", "V79"), TuplesKt.to("SM8850", "V81"), TuplesKt.to("SM8845", "V81")});
    }

    private a() {
    }

    private final void a(File r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append("hexagon/");
        Map<String, String> r12 = f4834b;
        k r13 = k.f5601a;
        String r14 = r12.get(r13.a());
        if (r14 == null) goto L31;
        r11.append(r14);
        String r15 = r11.toString();
        AIKLog.INSTANCE.d("HexagonLibUtil", "extractHexagonLib from " + r15);
        String[] r16 = AppContext.INSTANCE.getContext().getAssets().list(r15);
        if (r16 == null) goto L29;
        int r17 = r16.length;
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L42;
        String r19 = r16[r18];
        File r20 = new File(r10, r19);
        InputStream r21 = AppContext.INSTANCE.getContext().getAssets().open(r15 + '/' + r19);
        FileOutputStream r22 = new FileOutputStream(r20);     // Catch: Throwable -> L24
        byte[] r23 = new byte[4096];     // Catch: Throwable -> L19
    L12:
        int r24 = r21.read(r23);     // Catch: Throwable -> L19
        if (r24 == (-1)) goto L15;
        r22.write(r23, 0, r24);     // Catch: Throwable -> L19
        goto L12
    L15:
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r22, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r21, null);
        r18 = r18 + 1;
        goto L7
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r22, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r21, th);
        throw th;
    L42:
        return;
    L29:
        return;
    L31:
        throw new IllegalArgumentException("Not Configured Soc " + r13.a());
    }

    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "dirPath");
        AIKLog r11 = AIKLog.INSTANCE;
        r11.d("HexagonLibUtil", "extractHexagonLib start");
        long r12 = SystemClock.elapsedRealtime();
        File r13 = new File(r10);
        f r14 = f.f5592a;
        r14.f(r13);
        r14.a(r13);
        a(r13);
        r11.d("HexagonLibUtil", "extractHexagonLib finish. used time " + (SystemClock.elapsedRealtime() - r12) + " ms");
    }
}
