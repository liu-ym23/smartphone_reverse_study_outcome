package com.bytedance.android.live.revlink.impl.pk.scope.service;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.scope.o;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o {
    public e a;
    public c b;
    public com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b c;
    public final C0173a d;
    public final b e;
    public final com.bytedance.android.live.profit.privilege.c f;
    public final com.bytedance.android.live.revlink.impl.global.c g;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.scope.service.a$a, reason: collision with other inner class name */
    public static final class C0173a<T> implements Observer {
        public final /* synthetic */ a a;

        public C0173a(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            if (((List) r7) == null) goto L22;
            a r8 = this.a;
            r8.getClass();
            LinkedHashMap r0 = new LinkedHashMap();
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r1 = r8.c;
            if (r1 == null) goto L17;
            LiveData<List<af2.b>> r2 = r1.getScoreState();
            if (r2 == null) goto L17;
            List r3 = (List) r2.getValue();
            if (r3 == null) goto L17;
            Iterator<T> r4 = r3.iterator();
        L12:
            if (r4.hasNext() == false) goto L17;
            af2.b r5 = (af2.b) r4.next();
            String r6 = af2.c.a(r5);
            if (r6 != null) goto L16;
            r6 = DataType.FALSE;
        L16:
            r0.put(r6, Long.valueOf(af2.c.b(r5)));
        L17:
            Map<String, ? extends Object> r9 = MapsKt.mapOf(TuplesKt.to("uid_2_score", r0));
            r8.f.B1(ProfitCheckType.PK, r9, null);
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            if (((List) r13) == null) goto L60;
            a r14 = this.a;
            cf2.a r0 = r14.g.getPKBaseUtils().a();
            String r1 = DataType.FALSE;
            if (r0 == null) goto L8;
            String r2 = r0.c;
            if (r2 == null) goto L8;
        L9:
            cf2.a r3 = r14.g.el().a();
            if (r3 == null) goto L15;
            String r4 = r3.c;
            if (r4 == null) goto L15;
            r1 = r4;
        L15:
            Pair[] r5 = new Pair[2];
            cf2.a r6 = r14.g.getPKBaseUtils().a();
            long r7 = 0;
            if (r6 == null) goto L18;
            long r8 = r6.a;
        L19:
            r5[0] = TuplesKt.to(r2, Long.valueOf(r8));
            cf2.a r9 = r14.g.el().a();
            if (r9 == null) goto L22;
            r7 = r9.a;
        L22:
            r5[1] = TuplesKt.to(r1, Long.valueOf(r7));
            Map r10 = MapsKt.mapOf(r5);
            Pair[] r12 = new Pair[2];
            c r15 = r14.b;
            int r16 = 3;
            if (r15 == null) goto L38;
            LiveData<List<h7.b>> r17 = r15.getLeftMvpRankList();
            if (r17 == null) goto L38;
            List r18 = (List) r17.getValue();
            if (r18 == null) goto L38;
            List r19 = r18;
            ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator<T> r20 = r19.iterator();
        L30:
            if (r20.hasNext() == false) goto L33;
            r110.add(((h7.b) r20.next()).getUserId());
            goto L30
        L33:
            if (3 > r110.size()) goto L35;
            int r22 = 3;
        L36:
            List r23 = r110.subList(0, r22);
            if (r23 == null) goto L38;
        L39:
            r12[0] = TuplesKt.to(r2, r23);
            c r24 = r14.b;
            if (r24 == null) goto L55;
            LiveData<List<h7.b>> r25 = r24.getRightMvpRankList();
            if (r25 == null) goto L55;
            List r26 = (List) r25.getValue();
            if (r26 == null) goto L55;
            List r27 = r26;
            ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
            Iterator<T> r29 = r27.iterator();
        L47:
            if (r29.hasNext() == false) goto L50;
            r28.add(((h7.b) r29.next()).getUserId());
            goto L47
        L50:
            if (3 <= r28.size()) goto L53;
            r16 = r28.size();
        L53:
            List r30 = r28.subList(0, r16);
            if (r30 == null) goto L55;
        L56:
            r12[1] = TuplesKt.to(r1, r30);
            r14.f.B1(ProfitCheckType.PK, MapsKt.mapOf(new Pair[]{TuplesKt.to("uid_2_score", r10), TuplesKt.to("uid_2_contributor_top", MapsKt.mapOf(r12))}), null);
            return;
        L55:
            r30 = CollectionsKt.emptyList();
            goto L56
        L35:
            r22 = r110.size();
        L38:
            r23 = CollectionsKt.emptyList();
            goto L39
        L18:
            r8 = 0;
        L8:
            r2 = DataType.FALSE;
            goto L9
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        e r0 = this.a;
        if (r0 == null) goto L7;
        LiveData<List<cf2.a>> r1 = r0.getBaseScoreState();
        if (r1 == null) goto L7;
        r1.removeObserver(this.e);
    L7:
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r2 = this.c;
        if (r2 == null) goto L13;
        LiveData<List<af2.b>> r3 = r2.getScoreState();
        if (r3 == null) goto L14;
        r3.removeObserver(this.d);
        return;
    L14:
        return;
    }

    public a(com.bytedance.android.live.profit.privilege.c r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "profitCheckService");
        Intrinsics.checkNotNullParameter(r3, "linkFakeGlobalService");
        this.f = r2;
        this.g = r3;
        this.d = new C0173a(this);
        this.e = new b(this);
    }
}
