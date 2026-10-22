package lda;

import com.larus.common.apphost.AppHost;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.s3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z {
    public static final LinkedHashMap<String, c0> a = null;
    public static final LinkedHashSet<String> b = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashSet();
    }

    public static void a(w r17) {
        Intrinsics.checkNotNullParameter(r17, "step");
        int r3 = s3.a;
        s3.b("omni.runtime", "receive step recordId=" + r17.a + ", stepIndex=" + r17.d + ", createdAt=" + r17.b + ", finishAt=" + r17.i + ", last=" + r17.g + ", success=" + r17.h + ", taskTriggerType=" + r17.j.getRaw() + ", query=" + j.c(r17.c) + ", desc=" + j.c(r17.e) + ", reply=" + j.c(r17.f));
        LinkedHashMap<String, c0> r4 = a;
        monitor-enter(r4);
    L49:
        th = move-exception;
        throw th;
    L5:
        if (b.contains(r17.a) == false) goto L9;
        s3.b("omni.runtime", "skip step for user stopped recordId=" + r17.a + ", stepIndex=" + r17.d + ", last=" + r17.g);     // Catch: Throwable -> L49
        monitor-exit(r4);
        return;
    L9:
        String r2 = r17.a;     // Catch: Throwable -> L49
        c0 r5 = r4.get(r2);     // Catch: Throwable -> L49
        if (r5 != null) goto L12;
        s3.b("omni.runtime", "create pending recordId=" + r17.a + ", createdAt=" + r17.b + ", taskTriggerType=" + r17.j.getRaw() + ", query=" + j.c(r17.c));     // Catch: Throwable -> L49
        r5 = new c0(r17.b, r17.c, r17.j);     // Catch: Throwable -> L49
        r4.put(r2, r5);     // Catch: Throwable -> L49
    L12:
        c0 r6 = r5;     // Catch: Throwable -> L49
        r6.a(r17);     // Catch: Throwable -> L49
        monitor-exit(r4);
        if (r17.g == true) goto L18;
        s3.a("omni.runtime", "append step recordId=" + r17.a + ", stepIndex=" + r17.d + ", steps=" + r6.e.size() + ", latestReply=" + j.c(r6.d));
        return;
    L18:
        Intrinsics.checkNotNullParameter(r17, "finalStep");
        List r1 = CollectionsKt.toList(r6.e.values());
        if (r1.isEmpty() == false) goto L30;
        String r7 = r17.f;
        if (StringsKt.isBlank(r7) == false) goto L23;
        r7 = r17.e;
    L23:
        List r8 = CollectionsKt.listOf(new c(v.a(r7)));
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L25:
        if (r10.hasNext() == false) goto L29;
        Object r11 = r10.next();
        if ((!StringsKt.isBlank(((c) r11).a)) == false) goto L25;
        r9.add(r11);
        goto L25
    L29:
        r1 = r9;
    L30:
        List r15 = r1;
        String r12 = v.b(r17.a);
        ModuleKey r13 = e.a.a;
        String r14 = r17.a;
        long r16 = r6.a;
        String r18 = r6.b;
        String r19 = r17.f;
        if (StringsKt.isBlank(r19) == false) goto L34;
        r19 = r6.d;
    L34:
        if (StringsKt.isBlank(r19) == false) goto L36;
        r19 = r17.e;
    L36:
        String r110 = r19;
        if (r17.h == false) goto L39;
        OmniTaskStatus r20 = OmniTaskStatus.SUCCESS;
    L40:
        b0 r21 = new b0(r12, r13, r14, r16, r18, r110, r20, r6.c, r15, j.a(r6.a, r17.i));
        String r22 = CollectionsKt.joinToString$default(r21.i, null, "[", "]", 0, null, new y(), 25, null);
        int r23 = s3.a;
        s3.b("omni.runtime", "transform to usage recordId=" + r21.a + ", taskId=" + r21.c + ", createdAt=" + r21.d + ", status=" + r21.g.getRaw() + ", taskTriggerType=" + r21.h.getRaw() + ", stepCount=" + r21.i.size() + ", time=" + r21.j + ", title=" + j.c(r21.e) + ", answer=" + j.c(r21.f) + ", steps=" + r22);
        new i(AppHost.a.getApplication().getApplicationContext()).a(CollectionsKt.listOf(r21));
        LinkedHashMap<String, c0> r24 = a;
        monitor-enter(r24);
        c0 r0 = r24.remove(r17.a);     // Catch: Throwable -> L46
        monitor-exit(r24);
        s3.b("omni.runtime", "saved runtime recordId=" + r21.a + ", taskId=" + r21.c + ", steps=" + r21.i.size() + ", status=" + r21.g.getRaw() + ", taskTriggerType=" + r21.h.getRaw() + ", time=" + r21.j);
        return;
    L46:
        th = move-exception;
        throw th;
    L39:
        r20 = OmniTaskStatus.FAILED;
        goto L40
    }

    public static void b(a0 r10) {
        Intrinsics.checkNotNullParameter(r10, "stop");
        int r0 = s3.a;
        s3.b("omni.runtime", "receive user stop recordId=" + r10.a + ", createdAt=" + r10.b + ", finishAt=" + r10.d + ", reason=" + r10.e + ", taskTriggerType=" + r10.f.getRaw() + ", query=" + j.c(r10.c));
        LinkedHashMap<String, c0> r1 = a;
        monitor-enter(r1);
        b.add(r10.a);     // Catch: Throwable -> L18
    L5:
        LinkedHashSet<String> r2 = b;     // Catch: Throwable -> L18
        if (r2.size() <= 64) goto L11;
        String r3 = (String) CollectionsKt.firstOrNull(r2);     // Catch: Throwable -> L18
        if (r3 == null) goto L11;
        r2.remove(r3);     // Catch: Throwable -> L18
    L11:
        c0 r4 = a.remove(r10.a);     // Catch: Throwable -> L18
        if (r4 != null) goto L14;
        r4 = new c0(r10.b, r10.c, r10.f);     // Catch: Throwable -> L18
    L14:
        b0 r11 = r4.b(r10);     // Catch: Throwable -> L18
        monitor-exit(r1);
        String r5 = CollectionsKt.joinToString$default(r11.i, null, "[", "]", 0, null, new x(), 25, null);
        int r6 = s3.a;
        s3.b("omni.runtime", "transform user stop to usage recordId=" + r11.a + ", taskId=" + r11.c + ", createdAt=" + r11.d + ", status=" + r11.g.getRaw() + ", taskTriggerType=" + r11.h.getRaw() + ", stepCount=" + r11.i.size() + ", time=" + r11.j + ", title=" + j.c(r11.e) + ", answer=" + j.c(r11.f) + ", steps=" + r5);
        new i(AppHost.a.getApplication().getApplicationContext()).a(CollectionsKt.listOf(r11));
        StringBuilder r7 = new StringBuilder("saved user stopped recordId=");
        r7.append(r11.a);
        r7.append(", taskId=");
        r7.append(r11.c);
        r7.append(", steps=");
        r7.append(r11.i.size());
        r7.append(", status=");
        r7.append(r11.g.getRaw());
        r7.append(", taskTriggerType=");
        r7.append(r11.h.getRaw());
        r7.append(", time=");
        r7.append(r11.j);
        s3.b("omni.runtime", r7.toString());
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
