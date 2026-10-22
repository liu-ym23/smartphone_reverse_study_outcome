package b5b;

import a5b.h;
import a5b.m;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements a5b.b {
    public static final f a = null;
    public static final Set<CotEventType> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotEventType.values().length];
            r0[CotEventType.TEXT_MESSAGE_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CotEventType.TEXT_MESSAGE_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CotEventType.TEXT_MESSAGE_CHUNK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CotEventType.TEXT_MESSAGE_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public f() {
    }

    static {
        a = new f();
        b = SetsKt.setOf(new CotEventType[]{CotEventType.TEXT_MESSAGE_START, CotEventType.TEXT_MESSAGE_CONTENT, CotEventType.TEXT_MESSAGE_CHUNK, CotEventType.TEXT_MESSAGE_END});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return b;
    }

    @Override // a5b.b
    public final void b(a5b.d r5, CotEvent r6, JSONObject r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "json");
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "json");
        String r9 = a5b.e.c(r7, new String[]{"messageId", "message_id"});
        boolean r1 = false;
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r9 = r6.getEventId();
    L8:
        String r10 = "text:" + r9;
        LinkedHashMap<String, h> r11 = r5.b;
        h r2 = r11.get(r10);
        if (r2 != null) goto L11;
        r2 = new m(r10);
        r2.c = a5b.e.c(r7, new String[]{"title"});
        r11.put(r10, r2);
    L11:
        m r3 = (m) r2;
        int r12 = a.a[r6.getEventType().ordinal()];
        if (r12 != 1) goto L14;
        r3.b(CotBlockStatus.RUNNING);
        r3.f = true;
        return;
    L14:
        if (r12 != 2) goto L16;
    L21:
        String r13 = a5b.e.a(r7, r6.getContent());
        if (r13.length() <= 0) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L26;
        r3.d.append(r13);
    L26:
        r3.b(CotBlockStatus.RUNNING);
        r3.f = true;
        return;
    L16:
        if (r12 == 3) goto L21;
        if (r12 != 4) goto L31;
        r3.b(CotBlockStatus.DONE);
        r3.f = false;
        return;
    L31:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
