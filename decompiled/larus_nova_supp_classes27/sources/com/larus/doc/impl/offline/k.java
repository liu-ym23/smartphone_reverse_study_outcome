package com.larus.doc.impl.offline;

import com.ixigua.lib.track.TrackParams;
import com.larus.doc.impl.DocFragment;
import com.larus.office.OfflineDocReportGate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.a1;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r22, final String r23, final String r24, final String r25, final Integer r26, JSONObject r27, DocFragment r28) {
        Intrinsics.checkNotNullParameter(r27, "params");
        if (r22 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        u0.d("upper_right", r23, r24, r25, r26, "ai_doc_detail", null, null, null, null, null, null, r27, r28, 4032);
        return;
    L12:
        final JSONObject r1 = new JSONObject(r27.toString());
        final j r3 = new j(by7.h.a(r28));
        OfflineDocReportGate r4 = OfflineDocReportGate.a;
        Function1 r5 = new h(r1, r23, r24, r25, r26, r3);
        r4.getClass();
        OfflineDocReportGate.d(r22, r5);
        return;
    L5:
        if (StringsKt.isBlank(r22) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static void a(String r64, final String r65, final String r66, final String r67, final Integer r68, final Integer r610, final String r70, JSONObject r71, by7.e r72) {
        Intrinsics.checkNotNullParameter(r71, "params");
        if (r64 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        a1.c(null, null, null, null, null, "ai_doc_detail", null, null, r65, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r70, null, r66, r67, r68, null, null, null, null, null, null, null, r610, r71, r72, null, null, null, null, null, null, null, -1153, -29374977, 7);
        return;
    L12:
        final JSONObject r2 = new JSONObject(r71.toString());
        i r3 = null;
        if (r72 == null) goto L15;
        TrackParams r4 = by7.h.a(r72);
    L16:
        if (r4 == null) goto L18;
        r3 = new i(r4);
    L18:
        final i r63 = r3;
        OfflineDocReportGate r5 = OfflineDocReportGate.a;
        Function1 r6 = new g(r70, r2, r65, r66, r67, r68, r610, r63);
        r5.getClass();
        OfflineDocReportGate.d(r64, r6);
        return;
    L15:
        r4 = null;
        goto L16
    L5:
        if (StringsKt.isBlank(r64) == true) goto L8;
        r1 = false;
        goto L9
    }
}
