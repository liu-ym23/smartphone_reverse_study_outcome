package lda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import com.obric.assistant.cocreationreview.s3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q {
    public final i a;
    public final com.obric.assistant.cocreationreview.j b;
    public final LinkedHashSet<Function1<u, Unit>> c;
    public final List<Function0<Unit>> d;
    public boolean e;
    public g5 f;

    public final synchronized void d() {
        monitor-enter(this);
        Iterator r0 = ((ArrayList) this.d).iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        ((Function0) r0.next()).invoke();     // Catch: Throwable -> L10
        goto L5
    L7:
        ((ArrayList) this.d).clear();     // Catch: Throwable -> L10
        this.e = false;     // Catch: Throwable -> L10
        s3.b("omni.repository.observe", "stopStoreObservers");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.a == null) goto L12;
        Function1 r1 = new o(this);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r1, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.d).add(i.b.b(r1));     // Catch: Throwable -> L17
    L12:
        if (this.b == null) goto L14;
        Function1 r2 = new p(this);     // Catch: Throwable -> L17
        com.obric.assistant.cocreationreview.g r3 = com.obric.assistant.cocreationreview.j.b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.d).add(com.obric.assistant.cocreationreview.j.b.b(r2));     // Catch: Throwable -> L17
    L14:
        this.e = true;     // Catch: Throwable -> L17
        int r4 = s3.a;     // Catch: Throwable -> L17
        s3.b("omni.repository.observe", "startStoreObservers subscriptions=" + ((ArrayList) this.d).size());     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public q(Context r4) {
        com.obric.assistant.cocreationreview.j r0 = null;
        if (r4 == null) goto L7;
        Context r1 = r4.getApplicationContext();
        if (r1 == null) goto L7;
        i r2 = new i(r1);
    L8:
        this.a = r2;
        if (r4 == null) goto L13;
        Context r5 = r4.getApplicationContext();
        if (r5 == null) goto L13;
        r0 = new com.obric.assistant.cocreationreview.j(r5);
    L13:
        this.b = r0;
        this.c = new LinkedHashSet();
        this.d = new ArrayList();
        int r6 = g5.c;
        this.f = g5.a.a("repository_init");
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void b(String r8) {
        LinkedHashSet<Function1<u, Unit>> r0 = this.c;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(this.c);     // Catch: Throwable -> L26
        monitor-exit(r0);
        List<b0> r2 = c(this.f);
        u r3 = new u(r8, r2);
        int r4 = s3.a;
        StringBuilder r5 = new StringBuilder("changed reason=");
        r5.append(r8);
        r5.append(", listeners=");
        r5.append(r1.size());
        r5.append(", records=");
        ArrayList r6 = (ArrayList) r2;
        r5.append(r6.size());
        r5.append(", feedback=");
        int r7 = 0;
        if (r6.isEmpty() == true) goto L21;
        Iterator r9 = r6.iterator();
        int r10 = 0;
    L11:
        if (r9.hasNext() == false) goto L20;
        if (((b0) r9.next()).l == null) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == false) goto L11;
        r10 = r10 + 1;
        if (r10 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L15:
        r11 = false;
        goto L16
    L20:
        r7 = r10;
    L21:
        r5.append(r7);
        s3.b("omni.repository.observe", r5.toString());
        Iterator r12 = r1.iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        ((Function1) r12.next()).invoke(r3);
        goto L23
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final List<b0> c(g5 r38) {
        Intrinsics.checkNotNullParameter(r38, "request");
        i r3 = this.a;
        Map<String, a5> r4 = null;
        String r6 = ", reason=";
        String r7 = ", latest=";
        String r8 = ", earliest=";
        if (r3 == null) goto L24;
        Intrinsics.checkNotNullParameter(r38, "request");
        SQLiteDatabase r10 = r3.a.getWritableDatabase();
        Intrinsics.checkNotNull(r10);
        ArrayList r5 = new ArrayList();
        h5 r15 = g5.a(r38);
        Cursor r11 = r10.query("omni_data", null, "created_at >= ? AND created_at <= ?", new String[]{String.valueOf(r15.a), String.valueOf(r15.b)}, null, null, "created_at DESC, record_id ASC");
        Cursor r12 = r11;     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L11
        r5.add(com.obric.assistant.cocreationreview.modules.omni.a.b(r12));     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r2 = Result.exceptionOrNull-impl(r1);     // Catch: Throwable -> L18
        if (r2 == null) goto L8;
        int r13 = s3.a;     // Catch: Throwable -> L18
        s3.c("omni.database", "skip invalid row error=" + r2.getMessage());     // Catch: Throwable -> L18
        goto L8
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L18
        r1 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
        goto L13
    L16:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r11, null);
        String r16 = CollectionsKt.joinToString$default(r5, null, "[", "]", 0, null, new h(), 25, null);
        int r17 = s3.a;
        s3.b("omni.database", "query count=" + r5.size() + ", earliest=" + r15.a + ", latest=" + r15.b + ", reason=" + r38.b + ", records=" + r16);
        ?? r18 = r5;
    L25:
        if (r18 != 0) goto L27;
        r18 = CollectionsKt.emptyList();
    L27:
        String r19 = "omni.repository";
        if (r18.isEmpty() == false) goto L30;
    L29:
        String r110 = r19;
        String r34 = r6;
        String r35 = r7;
        String r36 = r8;
        ArrayList r20 = new ArrayList();
        Iterator r21 = ((Iterable) r18).iterator();
    L46:
        if (r21.hasNext() == false) goto L55;
        Object r22 = r21.next();
        long r23 = ((b0) r22).d;
        int r24 = g5.c;
        long r25 = System.currentTimeMillis();
        r38.getClass();
        long r26 = r38.a;
        if (r23 <= RangesKt.coerceAtLeast(r25, r26)) goto L50;
    L52:
        boolean r27 = false;
    L53:
        if (r27 == false) goto L46;
        r20.add(r22);
        goto L46
    L50:
        if (r26 > r23) goto L52;
        r27 = true;
        goto L53
    L55:
        String r28 = CollectionsKt.joinToString$default(r20, null, "[", "]", 0, null, new m(), 25, null);
        if (this.a == null) goto L74;
        h5 r29 = g5.a(r38);
        int r30 = s3.a;
        StringBuilder r31 = new StringBuilder("loadRecords source=runtime_database, count=");
        r31.append(r20.size());
        r31.append(", feedback=");
        if (r20.isEmpty() == false) goto L60;
        int r32 = 0;
    L72:
        r31.append(r32);
        r31.append(r36);
        r31.append(r29.a);
        r31.append(r35);
        r31.append(r29.b);
        r31.append(r34);
        r31.append(r38.b);
        r31.append(", items=");
        r31.append(r28);
        s3.b(r110, r31.toString());
        return r20;
    L60:
        Iterator r33 = r20.iterator();
        int r37 = 0;
    L62:
        if (r33.hasNext() == false) goto L71;
        if (((b0) r33.next()).l == null) goto L66;
        boolean r39 = true;
    L67:
        if (r39 == false) goto L62;
        r37 = r37 + 1;
        if (r37 >= 0) goto L62;
        CollectionsKt.throwCountOverflow();
        goto L62
    L66:
        r39 = false;
        goto L67
    L71:
        r32 = r37;
        goto L72
    L74:
        int r40 = s3.a;
        StringBuilder r41 = new StringBuilder("loadRecords source=empty, reason=context_unavailable, count=");
        r41.append(r20.size());
        r41.append(", feedback=");
        if (r20.isEmpty() == false) goto L77;
        int r42 = 0;
    L89:
        r41.append(r42);
        r41.append(", observeReason=");
        r41.append(r38.b);
        r41.append(", items=");
        r41.append(r28);
        s3.c(r110, r41.toString());
        return r20;
    L77:
        Iterator r43 = r20.iterator();
        int r44 = 0;
    L79:
        if (r43.hasNext() == false) goto L88;
        if (((b0) r43.next()).l == null) goto L83;
        boolean r45 = true;
    L84:
        if (r45 == false) goto L79;
        r44 = r44 + 1;
        if (r44 >= 0) goto L79;
        CollectionsKt.throwCountOverflow();
        goto L79
    L83:
        r45 = false;
        goto L84
    L88:
        r42 = r44;
        goto L89
    L30:
        Iterable r46 = (Iterable) r18;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r46, 10));
        Iterator r112 = r46.iterator();
    L32:
        if (r112.hasNext() == false) goto L34;
        r111.add(((b0) r112.next()).a);
        goto L32
    L34:
        Set<String> r113 = CollectionsKt.toSet(r111);
        com.obric.assistant.cocreationreview.j r114 = this.b;
        if (r114 == null) goto L37;
        r4 = r114.a(r113, CollectionsKt.emptyList());
    L37:
        if (r4 == null) goto L39;
        int r115 = s3.a;
        s3.b("omni.repository", "loadFeedback source=database, requested=" + r113.size() + ", count=" + r4.size());
    L40:
        s3.b("omni.repository", "attachFeedback records=" + r18.size() + ", feedbackIds=" + CollectionsKt.joinToString$default(r4.keySet(), null, "[", "]", 0, null, null, 57, null));
        r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r46, 10));
        Iterator r47 = r46.iterator();
    L42:
        if (r47.hasNext() == false) goto L29;
        b0 r116 = (b0) r47.next();
        a5 r310 = r4.get(r116.a);
        String r117 = r116.a;
        ModuleKey r118 = r116.b;
        String r119 = r116.c;
        long r120 = r116.d;
        String r48 = r116.e;
        Iterator r121 = r47;
        String r49 = r116.f;
        Map<String, a5> r122 = r4;
        OmniTaskStatus r50 = r116.g;
        String r123 = r19;
        OmniTaskTriggerType r51 = r116.h;
        String r311 = r6;
        List<c> r52 = r116.i;
        String r312 = r7;
        String r53 = r116.j;
        String r124 = r116.k;
        Intrinsics.checkNotNullParameter(r117, "id");
        Intrinsics.checkNotNullParameter(r118, "module");
        Intrinsics.checkNotNullParameter(r119, "taskId");
        Intrinsics.checkNotNullParameter(r48, "userQuery");
        Intrinsics.checkNotNullParameter(r49, "doubaoAnswer");
        Intrinsics.checkNotNullParameter(r50, "status");
        Intrinsics.checkNotNullParameter(r51, "taskTriggerType");
        Intrinsics.checkNotNullParameter(r52, "steps");
        Intrinsics.checkNotNullParameter(r53, "timeCost");
        Intrinsics.checkNotNullParameter(r124, "payload");
        r18.add(new b0(r117, r118, r119, r120, r48, r49, r50, r51, r52, r53, r124, r310));
        r47 = r121;
        r4 = r122;
        r19 = r123;
        r6 = r311;
        r7 = r312;
        r8 = r8;
        goto L42
    L39:
        int r54 = s3.a;
        s3.c("omni.repository", "loadFeedback source=empty, reason=context_unavailable, requested=" + r113.size() + ", count=0");
        r4 = MapsKt.emptyMap();
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L24:
        r18 = 0;
        goto L25
    }
}
