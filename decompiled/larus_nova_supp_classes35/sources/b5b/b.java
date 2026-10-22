package b5b;

import a5b.h;
import a5b.j;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements a5b.b {
    public static final b a = null;
    public static final Set<CotEventType> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotEventType.values().length];
            r0[CotEventType.REASONING_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[CotEventType.REASONING_MESSAGE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[CotEventType.REASONING_MESSAGE_CONTENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[CotEventType.REASONING_MESSAGE_CHUNK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[CotEventType.REASONING_MESSAGE_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[CotEventType.REASONING_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[CotEventType.REASONING_ENCRYPTED_VALUE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = SetsKt.setOf(new CotEventType[]{CotEventType.REASONING_START, CotEventType.REASONING_MESSAGE_START, CotEventType.REASONING_MESSAGE_CONTENT, CotEventType.REASONING_MESSAGE_CHUNK, CotEventType.REASONING_MESSAGE_END, CotEventType.REASONING_END, CotEventType.REASONING_ENCRYPTED_VALUE});
    }

    @Override // a5b.b
    public final Set<CotEventType> a() {
        return b;
    }

    @Override // a5b.b
    public final void b(a5b.d r8, CotEvent r9, JSONObject r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "event");
        Intrinsics.checkNotNullParameter(r10, "json");
        boolean r2 = false;
        boolean r3 = true;
        switch(a.a[r9.getEventType().ordinal()]) {
            case 1: goto L52;
            case 2: goto L52;
            case 3: goto L46;
            case 4: goto L46;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L5;
            default: goto L67;
        };
    L5:
        String r12 = a5b.e.c(r10, new String[]{"entityId", "entity_id"});
        if (r12.length() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L16;
        r12 = a5b.e.c(r10, new String[]{"messageId", "message_id"});
        if (r12.length() != 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L16;
        r12 = r9.getEventId();
        goto L16
    L13:
        r0 = false;
    L16:
        Collection<h> r1 = r8.b.values();
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r1.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if ((r7 instanceof j) == false) goto L18;
        r5.add(r7);
        goto L18
    L22:
        Iterator r13 = r5.iterator();
    L24:
        if (r13.hasNext() == false) goto L28;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((j) r14).a, "reasoning:" + r12) == false) goto L24;
    L29:
        j r15 = (j) r14;
        if (r15 != null) goto L32;
        r15 = r8.b(r9, r10);
    L32:
        String r16 = a5b.e.c(r10, new String[]{"encryptedValue", "encrypted_value"});
        if (r16.length() <= 0) goto L35;
        r2 = true;
    L35:
        if (r2 == false) goto L62;
        ((ArrayList) r15.g).add(r16);
        return;
    L62:
        return;
    L28:
        r14 = null;
        goto L29
    L8:
        r4 = false;
        goto L9
    L46:
        j r17 = r8.b(r9, r10);
        String r18 = a5b.e.a(r10, r9.getContent());
        if (r18.length() <= 0) goto L49;
        r2 = true;
    L49:
        if (r2 == false) goto L51;
        r17.d.append(r18);
    L51:
        r17.b(CotBlockStatus.RUNNING);
        r17.f = true;
        return;
    L52:
        j r19 = r8.b(r9, r10);
        r19.b(CotBlockStatus.RUNNING);
        r19.f = true;
        return;
    L67:
        return;
    L38:
        if (a5b.e.c(r10, new String[]{"messageId", "message_id"}).length() == 0) goto L41;
        r3 = false;
    L41:
        if (r3 == true) goto L43;
    L45:
        j r20 = r8.b(r9, r10);
        r20.b(CotBlockStatus.DONE);
        r20.f = false;
        return;
    L43:
        if (r9.getEventType() != CotEventType.REASONING_END) goto L45;
        r8.a();
    }
}
