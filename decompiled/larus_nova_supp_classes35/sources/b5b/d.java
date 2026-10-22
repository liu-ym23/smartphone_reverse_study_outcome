package b5b;

import a5b.h;
import a5b.m;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements a5b.b {
    public static final d a = null;
    public static final Set<CotEventType> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotEventType.values().length];
            r0[CotEventType.MESSAGES_SNAPSHOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CotEventType.ACTIVITY_SNAPSHOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public d() {
    }

    static {
        a = new d();
        b = SetsKt.setOf(new CotEventType[]{CotEventType.MESSAGES_SNAPSHOT, CotEventType.ACTIVITY_SNAPSHOT});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return b;
    }

    @Override // a5b.b
    public final void b(a5b.d r11, CotEvent r12, JSONObject r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "json");
        int r2 = a.a[r12.getEventType().ordinal()];
        boolean r7 = false;
        if (r2 != 1) goto L5;
        JSONArray r15 = r13.optJSONArray("messages");
        if (r15 == null) goto L86;
        Collection<h> r16 = r11.b.values();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L37:
        if (r18.hasNext() == false) goto L44;
        Object r0 = r18.next();
        if (((h) r0).getType() != CotViewBlockType.TEXT) goto L41;
        boolean r1 = true;
    L42:
        if (r1 == false) goto L37;
        r17.add(r0);
        goto L37
    L41:
        r1 = false;
        goto L42
    L44:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r110 = r17.iterator();
    L46:
        if (r110.hasNext() == false) goto L48;
        r19.add(((h) r110.next()).a);
        goto L46
    L48:
        Iterator r111 = CollectionsKt.toSet(r19).iterator();
    L50:
        if (r111.hasNext() == false) goto L52;
        r11.b.remove((String) r111.next());
        goto L50
    L52:
        int r112 = r15.length();
        int r113 = 0;
    L53:
        if (r113 >= r112) goto L87;
        JSONObject r3 = r15.optJSONObject(r113);
        if (r3 == null) goto L73;
        String r4 = a5b.e.c(r3, new String[]{"id", "messageId", "message_id"});
        if (r4.length() != 0) goto L60;
        boolean r5 = true;
    L61:
        if (r5 == false) goto L63;
        r4 = "snapshot-" + r113;
    L63:
        String r6 = a5b.e.c(r3, new String[]{"content", "text"});
        String r8 = "text:" + r4;
        LinkedHashMap<String, h> r9 = r11.b;
        h r10 = r9.get(r8);
        if (r10 != null) goto L66;
        r10 = new m(r8);
        r9.put(r8, r10);
    L66:
        m r20 = (m) r10;
        StringsKt.clear(r20.d);
        if (r6.length() <= 0) goto L69;
        boolean r21 = true;
    L70:
        if (r21 == false) goto L72;
        r20.d.append(r6);
    L72:
        r20.b(CotBlockStatus.DONE);
        r20.f = false;
        goto L73
    L69:
        r21 = false;
        goto L70
    L60:
        r5 = false;
    L73:
        r113 = r113 + 1;
        goto L53
    L87:
        return;
    L86:
        return;
    L5:
        if (r2 != 2) goto L85;
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "json");
        String r22 = a5b.e.c(r13, new String[]{"messageId", "message_id", "activityId", "activity_id", "id"});
        if (r22.length() != 0) goto L10;
        boolean r23 = true;
    L11:
        if (r23 == false) goto L13;
        r22 = r12.getEventId();
    L13:
        String r114 = r12.getEventId();
        if (r114.length() != 0) goto L16;
        boolean r24 = true;
    L17:
        if (r24 == false) goto L19;
        r114 = String.valueOf(r14);
    L19:
        String r115 = "activity:" + r114 + ':' + r22 + ':' + r14;
        LinkedHashMap<String, h> r116 = r11.b;
        h r117 = r116.get(r115);
        if (r117 != null) goto L22;
        r117 = new a5b.a(r115);
        r117.c = a5b.e.c(r13, new String[]{"activityType", "activity_type", "title"});
        r116.put(r115, r117);
    L22:
        a5b.a r118 = (a5b.a) r117;
        String r119 = a5b.e.c(r13, new String[]{"activityType", "activity_type", "title"});
        if (r119.length() != 0) goto L25;
        r7 = true;
    L25:
        if (r7 == false) goto L27;
        r119 = r118.c;
    L27:
        r118.c = r119;
        Object r120 = a5b.e.b(r13, new String[]{"content"});
        Object r121 = r13;
        if (r120 == null) goto L31;
        r121 = r120;
    L31:
        r118.g = a5b.e.d(r121);
        r118.b(CotBlockStatus.RUNNING);
        r118.f = true;
        return;
    L16:
        r24 = false;
        goto L17
    L10:
        r23 = false;
        goto L11
    }
}
