package k5;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends b {
    public static final j d = null;
    public static final ArrayList e = null;

    static {
        d = new j("regex_param_bid");
        e = CollectionsKt.arrayListOf(new String[]{"bd_hybrid_monitor_bid", "bdhm_bid"});
    }

    @Override // k5.b
    public final a a(String r10, String r11) {
        if (r10.length() <= 0) goto L5;
        String r5 = r10;
    L6:
        j r12 = d;
        com.bytedance.android.monitorV2.k r13 = b.f18597c;
        if (r5 == null) goto L13;
        String r14 = (String) r13.get(r5);
        if (r14 == null) goto L13;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "bid");
        return new a(r14, r12.f18598a);
    L13:
        if (r11.length() <= 0) goto L15;
        String r15 = r11;
    L16:
        if (r15 == null) goto L21;
        String r16 = (String) r13.get(r15);
        if (r16 == null) goto L21;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r16, "bid");
        return new a(r16, r12.f18598a);
    L21:
        ArrayList r17 = CollectionsKt.arrayListOf(new String[]{r10, r11});
        String r18 = "";
        if (r17 == null) goto L43;
        if (r17.isEmpty() == true) goto L43;
        Iterator r19 = r17.iterator();
    L28:
        if (r19.hasNext() == false) goto L43;
        String r20 = (String) r19.next();
        Iterator r21 = e.iterator();
    L31:
        if (r21.hasNext() == false) goto L28;
        String r22 = (String) r21.next();
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L36
        String r24 = Uri.parse(r20).getQueryParameter(r22);     // Catch: Throwable -> L36
        if (r24 == null) goto L38;
        r13.put(r20, r24);     // Catch: Throwable -> L36
        r18 = r24;
        goto L43
    L38:
        Object r25 = Result.m124constructorimpl(null);     // Catch: Throwable -> L36
    L41:
        Result.m127exceptionOrNullimpl(r25);
    L36:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r25 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L43:
        if (r18.length() == 0) goto L57;
        if (Intrinsics.areEqual(r18, "__hybrid_default") == true) goto L57;
        Intrinsics.checkNotNullParameter(r18, "bid");
        return new a(r18, this.f18598a);
    L57:
        return this.f18599b;
    L15:
        r15 = null;
        goto L16
    L5:
        r5 = null;
        goto L6
    }
}
