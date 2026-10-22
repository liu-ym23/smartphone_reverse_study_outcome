package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Comparator {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r11, Object r12) {
            CotEvent r13 = (CotEvent) r11;
            CotEvent r14 = (CotEvent) r12;
            Long r0 = Long.valueOf(r13.getTimestamp());
            boolean r3 = false;
            if (r0.longValue() <= 0) goto L5;
            boolean r1 = true;
        L6:
            Long r2 = null;
            if (r1 == true) goto L10;
            r0 = null;
        L10:
            if (r0 == null) goto L12;
            long r4 = r0.longValue();
        L13:
            Long r15 = Long.valueOf(r14.getTimestamp());
            if (r15.longValue() <= 0) goto L16;
            r3 = true;
        L16:
            if (r3 == false) goto L18;
            r2 = r15;
        L18:
            if (r2 == null) goto L20;
            long r16 = r2.longValue();
        L22:
            return ComparisonsKt.compareValues(Long.valueOf(r4), Long.valueOf(r16));
        L20:
            r16 = r14.getCreatedAt();
            goto L22
        L12:
            r4 = r13.getCreatedAt();
            goto L13
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
    }

    public static CotViewModel a(CotContent r11) {
        Intrinsics.checkNotNullParameter(r11, "content");
        a5b.d r0 = new a5b.d(r11);
        f.a("reduce_start", "cotId=" + r11.getCotId() + ", status=" + r11.getStatus() + ", events=" + r11.getEvents().size() + ", incomplete=" + r11.getCotEventsIncomplete());
        Iterator r1 = CollectionsKt.sortedWith(r11.getEvents(), a.a).iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L20;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CotEvent r6 = (CotEvent) r4;
        if (StringsKt.isBlank(r6.getContent()) == false) goto L12;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L17
    L13:
        List<a5b.b> r8 = a5b.c.a;     // Catch: Exception -> L17
        CotEventType r9 = r6.getEventType();     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r9, "eventType");     // Catch: Exception -> L17
        a5b.b r10 = a5b.c.b.get(r9);     // Catch: Exception -> L17
        if (r10 == null) goto L19;
        r10.b(r0, r6, r7, r3);     // Catch: Exception -> L17
    L19:
        r3 = r5;
        goto L4
    L12:
        r7 = new JSONObject(r6.getContent());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        r0.e++;
        f.e("reduce_event", "skip event, cotId=" + r11.getCotId() + ", eventId=" + r6.getEventId() + ", eventType=" + r6.getEventType() + ", reason=" + e.getClass().getSimpleName());
        goto L19
    L20:
        f.a("reduce_done", "cotId=" + r11.getCotId() + ", blocks=" + r0.b.size() + ", overallStatus=" + r0.d + ", skippedEvents=" + r0.e);
        if (r0.e <= 0) goto L23;
        f.e("reduce_done", "cotId=" + r11.getCotId() + ", skippedEvents=" + r0.e);
    L23:
        String r12 = r11.getCotId();
        Collection<a5b.h> r2 = r0.b.values();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r14 = r2.iterator();
    L25:
        if (r14.hasNext() == false) goto L28;
        r13.add(((a5b.h) r14.next()).a());
        goto L25
    L28:
        return new CotViewModel(r12, new ArrayList(r13), r0.d, r11.getViolated(), r0.c);
    }
}
