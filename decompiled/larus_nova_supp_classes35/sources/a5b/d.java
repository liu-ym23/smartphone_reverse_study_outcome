package a5b;

import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final CotStatus a;
    public final LinkedHashMap<String, h> b;
    public final HashMap<String, String> c;
    public CotStatus d;
    public int e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotViewBlockType.values().length];
            r0[CotViewBlockType.RAW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CotViewBlockType.CUSTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void a() {
        Collection<h> r0 = this.b.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof j) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        j r5 = (j) r4.next();
        r5.b(CotBlockStatus.DONE);
        r5.f = false;
        goto L10
    }

    public d(CotContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        r2.getCotId();
        this.a = r2.getStatus();
        this.b = new LinkedHashMap();
        this.c = new HashMap();
        this.d = r2.getStatus();
    }

    public final k c(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        String r4 = e.c(r3, new String[]{"runId", "run_id"});
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r4 = "default";
    L8:
        String r5 = "run:".concat(r4);
        LinkedHashMap<String, h> r1 = this.b;
        h r2 = r1.get(r5);
        if (r2 != null) goto L12;
        r2 = new k(r5);
        r1.put(r5, r2);
    L12:
        return (k) r2;
    L5:
        r0 = false;
        goto L6
    }

    public final j b(CotEvent r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "json");
        String r5 = e.c(r4, new String[]{"messageId", "message_id"});
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r5 = r3.getEventId();
    L8:
        String r6 = "reasoning:" + r5;
        LinkedHashMap<String, h> r7 = this.b;
        h r1 = r7.get(r6);
        if (r1 != null) goto L12;
        r1 = new j(r6);
        r7.put(r6, r1);
    L12:
        return (j) r1;
    L5:
        r0 = false;
        goto L6
    }
}
