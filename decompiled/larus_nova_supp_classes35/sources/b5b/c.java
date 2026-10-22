package b5b;

import a5b.k;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.ss.android.lark.chat.utils.a0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements a5b.b {
    public static final c a = null;
    public static final Set<CotEventType> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotEventType.values().length];
            r0[CotEventType.RUN_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CotEventType.RUN_FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CotEventType.RUN_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = SetsKt.setOf(new CotEventType[]{CotEventType.RUN_STARTED, CotEventType.RUN_FINISHED, CotEventType.RUN_ERROR});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return b;
    }

    @Override // a5b.b
    public final void b(a5b.d r12, CotEvent r13, JSONObject r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "event");
        Intrinsics.checkNotNullParameter(r14, "json");
        HashMap<String, String> r0 = r12.c;
        List<String> r1 = a5b.f.a;
        Intrinsics.checkNotNullParameter(r0, "target");
        Intrinsics.checkNotNullParameter(r14, "json");
        JSONObject r16 = r14.optJSONObject("input");
        boolean r2 = true;
        if (r16 == null) goto L31;
        JSONObject r3 = r16.optJSONObject("statusText");
        if (r3 != null) goto L10;
        r3 = r16.optJSONObject("status_text");
        if (r3 == null) goto L31;
    L10:
        Iterator<String> r17 = a5b.f.a.iterator();
    L12:
        if (r17.hasNext() == false) goto L31;
        String r4 = r17.next();
        JSONObject r5 = r3.optJSONObject(r4);
        if (r5 == null) goto L12;
        HashMap r6 = new HashMap();
        Iterator<String> r7 = r5.keys();
    L18:
        if (r7.hasNext() == false) goto L25;
        String r8 = r7.next();
        String r9 = r5.optString(r8);
        Intrinsics.checkNotNull(r9);
        if (r9.length() <= 0) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L18;
        r6.put(r8, r9);
        goto L18
    L22:
        r10 = false;
        goto L23
    L25:
        String r11 = StringsKt.trim(a0.b(r6)).toString();
        if (r11.length() <= 0) goto L28;
        boolean r18 = true;
    L29:
        if (r18 == false) goto L12;
        r0.put(r4, r11);
        goto L12
    L28:
        r18 = false;
    L31:
        CotEventType r19 = r13.getEventType();
        int r110 = a.a[r19.ordinal()];
        if (r110 != 1) goto L34;
        k r111 = r12.c(r14);
        r111.b(CotBlockStatus.RUNNING);
        r111.f = true;
        CotStatus r112 = CotStatus.RUNNING;
    L82:
        CotStatus r113 = r12.a;
        Intrinsics.checkNotNullParameter(r113, "contentStatus");
        Intrinsics.checkNotNullParameter(r112, "runStatus");
        CotStatus r114 = CotStatus.TIMEOUT;
        if (r113 != r114) goto L85;
    L84:
        r112 = r114;
    L93:
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r12.d = r112;
        return;
    L85:
        r114 = CotStatus.ERROR;
        if (r113 == r114) goto L84;
        r114 = CotStatus.DONE;
        if (r113 != r114) goto L93;
        if (r112 != CotStatus.RUNNING) goto L93;
    L34:
        if (r110 != 2) goto L36;
        String r115 = StringsKt.trim(a5b.e.c(r14, new String[]{"status"})).toString().toLowerCase(Locale.ROOT);
        int r116 = r115.hashCode();
        if (r116 == (-1947652542)) goto L77;
        if (r116 == (-1313911455)) goto L73;
        if (r116 == (-995321554)) goto L69;
        if (r116 == 0) goto L65;
        if (r116 == 3089282) goto L62;
        if (r116 == 96784904) goto L58;
    L78:
        Pair r117 = TuplesKt.to(CotStatus.DONE, CotBlockStatus.DONE);
    L80:
        CotStatus r118 = (CotStatus) r117.component1();
        CotBlockStatus r119 = (CotBlockStatus) r117.component2();
        k r120 = r12.c(r14);
        r120.b(r119);
        r120.f = false;
        r12.a();
        r112 = r118;
        goto L82
    L58:
        if (r115.equals(Keys.API_RETURN_KEY_ERROR) == false) goto L78;
        r117 = TuplesKt.to(CotStatus.ERROR, CotBlockStatus.ERROR);
        goto L80
    L62:
        if (r115.equals("done") == false) goto L78;
    L67:
        r117 = TuplesKt.to(CotStatus.DONE, CotBlockStatus.DONE);
        goto L80
    L65:
        if (r115.equals(BuildConfig.FLAVOR) == true) goto L67;
    L69:
        if (r115.equals("paused") == false) goto L78;
        r117 = TuplesKt.to(CotStatus.PAUSED, CotBlockStatus.DONE);
        goto L80
    L73:
        if (r115.equals(ChameleonOpenTracker.OpenResult.TIMEOUT) == false) goto L78;
        r117 = TuplesKt.to(CotStatus.TIMEOUT, CotBlockStatus.DONE);
        goto L80
    L77:
        if (r115.equals("interrupted") == false) goto L78;
        r117 = TuplesKt.to(CotStatus.INTERRUPTED, CotBlockStatus.DONE);
        goto L80
    L36:
        if (r110 == 3) goto L38;
        return;
    L38:
        k r121 = r12.c(r14);
        String r122 = a5b.e.c(r14, new String[]{"message", Keys.API_RETURN_KEY_ERROR});
        if (r122.length() == 0) goto L42;
        r2 = false;
    L42:
        if (r2 == false) goto L44;
        r122 = r13.getContent();
    L44:
        r121.g = r122;
        r121.b(CotBlockStatus.ERROR);
        r121.f = false;
        r112 = CotStatus.ERROR;
        goto L82
    }
}
