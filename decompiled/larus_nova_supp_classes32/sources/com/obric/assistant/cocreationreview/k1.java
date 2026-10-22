package com.obric.assistant.cocreationreview;

import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class k1 implements Function0 {
    public final /* synthetic */ CocreationReviewActivity a;
    public final /* synthetic */ a b;
    public final /* synthetic */ Vote c;

    public /* synthetic */ k1(CocreationReviewActivity r1, a r2, Vote r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        final CocreationReviewActivity r1 = this.a;
        a r8 = this.b;
        final Vote r9 = this.c;
        Set<String> r2 = CocreationReviewActivity.P1;
        r1.getClass();
        if (r1.i2(r8.a()) == false) goto L5;
        int r3 = s3.a;
        s3.b("feedback.detail", "showAfterVote blocked recordId=" + r8.a() + ", module=" + r8.b().getRaw() + ", vote=" + r9.getRaw() + ", reason=feedback_completed");
    L65:
        return Unit.INSTANCE;
    L5:
        l0 r4 = (l0) ((Map) r1.b.getValue()).get(r8.b());
        if (r4 != null) goto L8;
        r1.D2(r8, r9);
        goto L65
    L8:
        FrameLayout r14 = null;
        r1.D = null;
        a5 r5 = r1.i.get(r8.a());
        if (r5 != null) goto L13;
        r5 = (a5) ((LinkedHashMap) r1.L1()).get(r8.a());
        if (r5 != null) goto L13;
        r5 = new a5(r8.a(), null, null, null, false, 0, null, 254);
    L13:
        a5 r6 = r5;
        j5 r7 = new j5(r1);
        boolean r15 = true;
        if (r1.B != ReviewMode.HISTORY) goto L16;
        boolean r10 = true;
    L18:
        if (r6.e == false) goto L20;
        b r11 = b.c.a;
    L21:
        z4 r12 = r4.c(r7, r8, r6, r10, r11).j;
        if ((r12 instanceof z4.a) == false) goto L24;
        z4.a r13 = (z4.a) r12;
    L26:
        if (r13 != null) goto L28;
        int r16 = s3.a;
        s3.c("feedback.detail", "fallback recordId=" + r8.a() + ", module=" + r8.b().getRaw() + ", reason=detail_missing");
        r1.D2(r8, r9);
        goto L65
    L28:
        String r17 = r8.a();
        Iterator r18 = CocreationReviewActivity.N1(r13).iterator();
        int r19 = 0;
    L30:
        if (r18.hasNext() == false) goto L35;
        if (Intrinsics.areEqual(CocreationReviewActivity.O1((x4) r18.next(), r13), r17) == true) goto L36;
        r19 = r19 + 1;
    L36:
        Integer r20 = Integer.valueOf(r19);
        if (r20.intValue() >= 0) goto L40;
        r15 = false;
    L40:
        if (r15 == true) goto L43;
        r20 = null;
    L43:
        if (r20 == null) goto L45;
        int r21 = r20.intValue();
    L46:
        String r22 = CocreationReviewActivity.z1(r13, r21);
        Iterator r23 = ((ArrayList) r1.c2()).iterator();
    L48:
        if (r23.hasNext() == false) goto L52;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((a) r24).a(), r22) == false) goto L48;
    L53:
        final a r25 = (a) r24;
        if (r25 != null) goto L57;
        int r26 = s3.a;
        s3.c("feedback.detail", "fallback recordId=" + r8.a() + ", module=" + r8.b().getRaw() + ", targetRecordId=" + r22 + ", reason=target_missing");
        r1.D2(r8, r9);
        goto L65
    L57:
        if (r1.i2(r25.a()) == false) goto L59;
        int r27 = s3.a;
        s3.b("feedback.detail", "showAfterVote blocked recordId=" + r25.a() + ", module=" + r25.b().getRaw() + ", vote=" + r9.getRaw() + ", reason=target_completed");
        goto L65
    L59:
        a5 r28 = r1.A1(r25, r9);
        int r29 = s3.a;
        s3.b("feedback.detail", "showAfterVote recordId=" + r8.a() + ", targetRecordId=" + r25.a() + ", module=" + r25.b().getRaw() + ", vote=" + r9.getRaw() + ", pageIndex=" + r21 + ", pages=" + r13.f.size() + ", reasonCount=" + r28.c.size());
        r1.D = r25.a();
        r25.b();
        r1.E2(r13, r21);
        FrameLayout r30 = r1.O;
        if (r30 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L63:
        r14.post(new q1(r1, r25, r9));
        goto L65
    L62:
        r14 = r30;
        goto L63
    L52:
        r24 = null;
        goto L53
    L45:
        r21 = 0;
        goto L46
    L35:
        r19 = -1;
        goto L36
    L24:
        r13 = null;
        goto L26
    L20:
        r11 = b.C0079b.a;
        goto L21
    L16:
        r10 = false;
        goto L18
    }
}
