package b5b;

import a5b.h;
import a5b.l;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements a5b.b {
    public static final e a = null;
    public static final Set<CotEventType> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotEventType.values().length];
            r0[CotEventType.STEP_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CotEventType.STEP_FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public e() {
    }

    static {
        a = new e();
        b = SetsKt.setOf(new CotEventType[]{CotEventType.STEP_STARTED, CotEventType.STEP_FINISHED});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return b;
    }

    @Override // a5b.b
    public final void b(a5b.d r6, CotEvent r7, JSONObject r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r8, "json");
        Intrinsics.checkNotNullParameter(r8, "json");
        String r10 = a5b.e.c(r8, new String[]{"runId", "run_id"});
        String r0 = a5b.e.c(r8, new String[]{"stepName", "step_name", IPortraitService.NAME});
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = "step";
    L8:
        String r11 = a5b.e.c(r8, new String[]{"stepId", "step_id"});
        if (r11.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r11 = r0;
    L14:
        String r12 = "step:" + r10 + ':' + r11;
        LinkedHashMap<String, h> r13 = r6.b;
        h r14 = r13.get(r12);
        if (r14 != null) goto L17;
        r14 = new l(r12);
        r14.c = r0;
        r13.put(r12, r14);
    L17:
        l r15 = (l) r14;
        int r16 = a.a[r7.getEventType().ordinal()];
        if (r16 != 1) goto L20;
        r15.b(CotBlockStatus.RUNNING);
        r15.f = true;
        return;
    L20:
        if (r16 != 2) goto L26;
        r15.b(CotBlockStatus.DONE);
        r15.f = false;
        return;
    L26:
        return;
    L11:
        r2 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }
}
