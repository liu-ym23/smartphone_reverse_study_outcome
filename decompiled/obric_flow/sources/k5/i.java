package k5;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends b {
    public static final i d = null;

    static {
        d = new i("regex_list_bid");
    }

    @Override // k5.b
    public final a a(String r13, String r14) {
        ArrayList r15 = com.bytedance.android.monitorV2.h.e().a().b();
        if (r15 == null) goto L34;
        if (r15.isEmpty() == true) goto L34;
        long r5 = System.currentTimeMillis();
        com.bytedance.android.monitorV2.k r10 = b.f18597c;
        String r11 = (String) r10.get(r13);
        String r12 = this.f18598a;
        if (r11 == null) goto L35;
        Map r16 = com.bytedance.android.monitorV2.i.f3604a;
        com.bytedance.android.monitorV2.i.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r13), TuplesKt.to("hit_cache", String.valueOf(true))}), MapsKt.mapOf(TuplesKt.to("regex_match_time", Long.valueOf(System.currentTimeMillis() - r5))), "regex_perf");
        Intrinsics.checkNotNullParameter(r11, "bid");
        return new a(r11, r12);
    L35:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L15
        Uri.parse(r13).getQueryParameter("url");     // Catch: Throwable -> L15
        if (StringsKt.P(r13, "http") == false) goto L17;
        String r18 = (String) CollectionsKt.first(StringsKt.K(r13, new String[]{"?"}, 0, 6));     // Catch: Throwable -> L15
    L18:
        Object r19 = Result.m124constructorimpl(r18);     // Catch: Throwable -> L15
    L22:
        if (Result.m130isFailureimpl(r19) == false) goto L24;
        r19 = r13;
    L24:
        String r20 = (String) r19;
        Iterator r110 = r15.iterator();
    L26:
        if (r110.hasNext() == false) goto L30;
        a5.a r111 = (a5.a) r110.next();
        if (r111.a().containsMatchIn(r20) == false) goto L26;
        String r112 = r111.f94a;
    L31:
        r10.put(r13, r112);
        Map r21 = com.bytedance.android.monitorV2.i.f3604a;
        com.bytedance.android.monitorV2.i.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r13), TuplesKt.to("hit_cache", String.valueOf(false))}), MapsKt.mapOf(TuplesKt.to("regex_match_time", Long.valueOf(System.currentTimeMillis() - r5))), "regex_perf");
        Intrinsics.checkNotNullParameter(r112, "bid");
        return new a(r112, r12);
    L30:
        r112 = "";
        goto L31
    L17:
        r18 = r13;
    L15:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L34:
        return this.f18599b;
    }
}
