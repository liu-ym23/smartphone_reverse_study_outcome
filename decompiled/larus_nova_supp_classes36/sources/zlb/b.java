package zlb;

import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final Map<String, a> a = null;

    public static final class a {
        public final String a;
        public final ScenarioType b;
        public final String c;
        public final String d;
        public final long e;
        public long f;
        public long g;
        public InlineAITaskStatus h;
        public int i;

        public a(String r4, ScenarioType r5, String r6, String r7) {
            long r0 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r4, "taskId");
            Intrinsics.checkNotNullParameter(r5, "scenario");
            Intrinsics.checkNotNullParameter(r6, "promptId");
            Intrinsics.checkNotNullParameter(r7, "promptType");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r0;
        }
    }

    static {
        a = new LinkedHashMap();
    }

    public static void a(InlineAITaskStatus r21) {
        Intrinsics.checkNotNullParameter(r21, "data");
        Map<String, a> r2 = a;
        a r3 = (a) ((LinkedHashMap) r2).get(r21.unique_task_id);
        if (r3 == null) goto L27;
        Intrinsics.checkNotNullParameter(r21, "data");
        r3.h = r21;
        boolean r4 = true;
        r3.i++;
        long r5 = System.currentTimeMillis();
        if (r21.content.length() > 0) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L15;
        if (r3.f != 0) goto L13;
        r3.f = r5;
    L13:
        r3.g = r5;
    L15:
        if (Intrinsics.areEqual(r21.task_status, "processing") == true) goto L28;
        int r1 = zlb.a.d;
        ScenarioType r10 = r3.b;
        String r11 = r3.c;
        String r12 = r3.d;
        int r13 = (int) r21.status_code.longValue();
        String r14 = r21.task_status;
        long r6 = r3.f;
        if (r6 <= 0) goto L20;
        int r8 = (int) (r6 - r3.e);
        long r16 = 0;
    L22:
        if (r6 <= r16) goto L24;
        int r17 = (int) (r5 - r6);
    L25:
        zlb.a.C0355a.b(r10, r11, r12, r13, r14, r8, r17, (int) (r5 - r3.e), r21.content.length(), r3.i, 0);
        String r0 = r3.a;
        Intrinsics.checkNotNullParameter(r0, "taskId");
        r2.remove(r0);
        return;
    L24:
        r17 = 0;
        goto L25
    L20:
        r16 = 0;
        r8 = 0;
        goto L22
    L28:
        return;
    }
}
