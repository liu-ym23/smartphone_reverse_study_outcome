package b5b;

import a5b.h;
import a5b.n;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements a5b.b {
    public static final g a = null;
    public static final Set<CotEventType> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotEventType.values().length];
            r0[CotEventType.TOOL_CALL_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CotEventType.TOOL_CALL_ARGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CotEventType.TOOL_CALL_CHUNK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CotEventType.TOOL_CALL_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CotEventType.TOOL_CALL_RESULT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public g() {
    }

    static {
        a = new g();
        b = SetsKt.setOf(new CotEventType[]{CotEventType.TOOL_CALL_START, CotEventType.TOOL_CALL_ARGS, CotEventType.TOOL_CALL_CHUNK, CotEventType.TOOL_CALL_END, CotEventType.TOOL_CALL_RESULT});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return b;
    }

    public static void c(n r4, JSONObject r5) {
        String r0 = a5b.e.c(r5, new String[]{"toolCallName", "tool_call_name", IPortraitService.NAME});
        boolean r2 = false;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = r4.h;
    L8:
        r4.h = r0;
        String r3 = a5b.e.c(r5, new String[]{"title"});
        if (r3.length() != 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r3 = r4.c;
    L14:
        r4.c = r3;
        String r7 = r5.optString("icon");
        if (r7.length() != 0) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L20;
        r7 = r4.i;
    L20:
        r4.i = r7;
        String r9 = a5b.e.c(r5, new String[]{"parentMessageId", "parent_message_id"});
        if (r9.length() != 0) goto L23;
        r2 = true;
    L23:
        if (r2 == false) goto L25;
        r9 = r4.n;
    L25:
        r4.n = r9;
        return;
    L17:
        r8 = false;
        goto L18
    L11:
        r6 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    @Override // a5b.b
    public final void b(a5b.d r6, CotEvent r7, JSONObject r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r8, "json");
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r8, "json");
        String r10 = a5b.e.c(r8, new String[]{"toolCallId", "tool_call_id"});
        boolean r1 = false;
        boolean r2 = true;
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r10 = r7.getEventId();
    L8:
        String r11 = "tool:" + r10;
        LinkedHashMap<String, h> r12 = r6.b;
        h r3 = r12.get(r11);
        if (r3 != null) goto L11;
        r3 = new n(r11);
        r12.put(r11, r3);
    L11:
        n r4 = (n) r3;
        int r13 = a.a[r7.getEventType().ordinal()];
        if (r13 != 1) goto L14;
        c(r4, r8);
        r4.b(CotBlockStatus.RUNNING);
        r4.f = true;
        return;
    L14:
        if (r13 != 2) goto L16;
    L79:
        c(r4, r8);
        String r14 = a5b.e.a(r8, r7.getContent());
        if (r14.length() <= 0) goto L82;
        r1 = true;
    L82:
        if (r1 == false) goto L84;
        r4.j.append(r14);
    L84:
        r4.b(CotBlockStatus.RUNNING);
        r4.f = true;
        return;
    L16:
        if (r13 == 3) goto L79;
        String r5 = null;
        if (r13 != 4) goto L20;
        StringBuilder r15 = r4.j;
        if (r15.length() <= 0) goto L63;
        boolean r16 = true;
    L64:
        if (r16 == true) goto L67;
        r15 = null;
    L67:
        if (r15 == null) goto L69;
        String r17 = r15.toString();
    L70:
        if (r17 != null) goto L72;
    L75:
        if (r2 == false) goto L88;
    L78:
        r4.k = r5;
        r4.b(CotBlockStatus.RUNNING);
        r4.f = false;
        return;
    L88:
        r5 = new JSONObject(r17).toString();     // Catch: Exception -> L87
        goto L78
    L72:
        if (StringsKt.isBlank(r17) == true) goto L75;
        r2 = false;
        goto L75
    L69:
        r17 = null;
        goto L70
    L63:
        r16 = false;
        goto L64
    L20:
        if (r13 != 5) goto L93;
        Object r18 = a5b.e.b(r8, new String[]{"content", ChameleonOpenTracker.ParamKey.RESULT, "output"});
        if (r18 != null) goto L25;
    L37:
        r4.m = r5;
        if (r18 == null) goto L41;
        String r19 = a5b.e.d(r18);
        if (r19 == null) goto L41;
    L42:
        r4.setResult(r19);
        String r20 = r4.l;
        if (r20 != null) goto L45;
    L50:
        boolean r21 = false;
    L51:
        if (r21 == true) goto L53;
    L59:
        r4.b(CotBlockStatus.DONE);
        r4.f = false;
        return;
    L53:
        if (r4.d.length() > 0) goto L56;
        r2 = false;
    L56:
        if (r2 == false) goto L58;
        r4.d.append('\n');
    L58:
        r4.d.append(r4.l);
        goto L59
    L45:
        if (r20.length() <= 0) goto L47;
        boolean r22 = true;
    L48:
        if (r22 != true) goto L50;
        r21 = true;
        goto L51
    L47:
        r22 = false;
    L41:
        r19 = r7.getContent();
        goto L42
    L25:
        if (Intrinsics.areEqual(r18, JSONObject.NULL) == true) goto L37;
        if ((r18 instanceof String) == false) goto L31;
        r5 = (String) r18;
        goto L37
    L31:
        if ((r18 instanceof JSONObject) == false) goto L34;
        r5 = ((JSONObject) r18).toString();
        goto L37
    L34:
        if ((r18 instanceof JSONArray) == false) goto L36;
        r5 = ((JSONArray) r18).toString();
        goto L37
    L36:
        r5 = r18.toString();
        goto L37
    L93:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
