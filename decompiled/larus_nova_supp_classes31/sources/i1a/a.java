package i1a;

import android.text.TextUtils;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.ugc.perf.impl.d;
import com.larus.ugc.perf.impl.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements d {
    public static final a a = null;
    public static boolean b;
    public static String c;

    /* JADX INFO: renamed from: i1a.a$a, reason: collision with other inner class name */
    public static final class C0060a implements b {
        public C0060a() {
        }

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public final void f(String r3, Message r4) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "msg");
            if (Intrinsics.areEqual(r4.getMessageId(), a.c) == false) goto L6;
            a r5 = a.a;
            a.f(r4, 30012L);
            return;
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
            if (r3 != MessageListState.DELETE) goto L15;
            List<Message> r5 = r4;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r7 = r5.iterator();
        L6:
            if (r7.hasNext() == false) goto L9;
            r6.add(((Message) r7.next()).getMessageId());
            goto L6
        L9:
            if (r6.contains(a.c) == false) goto L16;
            Message r8 = (Message) CollectionsKt.firstOrNull(r4);
            if (r8 == null) goto L17;
            a r9 = a.a;
            a.f(r8, 30012L);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public a() {
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void d(e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    static {
        a = new a();
        c = "";
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        String r3 = r2.b();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        c = r3;
        if (b == false) goto L8;
        return;
    L8:
        b = true;
        com.larus.im.d.e().registerOnGlobalMessageObserver(new C0060a());
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void c(e r13) {
        Intrinsics.checkNotNullParameter(r13, "source");
        String r0 = r13.b();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r7 = r0;
        long r1 = System.currentTimeMillis();
        Long r2 = r13.d();
        if (r2 == null) goto L8;
        long r3 = r2.longValue();
    L9:
        h1a.e.b(new h1a.a("music_create/chunk", "music_create", "1", 0L, Long.valueOf(r1 - r3), r7, null, null, 192), r13);
        return;
    L8:
        r3 = System.currentTimeMillis();
        goto L9
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void h(e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public static void f(Message r14, Long r15) {
        Intrinsics.checkNotNullParameter(r14, "message");
        e r0 = d.a.a(r14);
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = r0.b.get("lyrics_received");
        Boolean r3 = Boolean.TRUE;
        boolean r2 = Intrinsics.areEqual(r1, r3);
        long r4 = System.currentTimeMillis();
        Long r6 = r0.d();
        if (r6 == null) goto L8;
        long r7 = r6.longValue();
    L9:
        long r10 = r4 - r7;
        if (r2 == true) goto L17;
        if (r15 == null) goto L18;
        r0.b.put("lyrics_received", r3);
        String r16 = r14.getMessageId();
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        h1a.e.b(b(r16, "0", r10, r15.longValue()), r0);
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r7 = System.currentTimeMillis();
        goto L9
    }

    public final void i(Message r20, String r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r20, "message");
        Intrinsics.checkNotNullParameter(r21, "taskId");
        e r1 = d.a.a(r20);
        if (r1 != null) goto L5;
        return;
    L5:
        Object r3 = r1.b.get("play_start");
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r5) == false) goto L9;
        return;
    L9:
        if (r20.getContentType() == 72) goto L11;
        return;
    L11:
        r1.b.put("play_start", r5);
        Long r6 = null;
        if (r22 == false) goto L24;
        long r7 = System.currentTimeMillis();
        Object r0 = r1.b.get("stream_url_time".concat(r21));
        if ((r0 instanceof Long) == false) goto L16;
        r6 = (Long) r0;
    L16:
        if (r6 == null) goto L18;
        long r9 = r6.longValue();
    L19:
        long r8 = r7 - r9;
        String r2 = r20.getMessageId();
        if (r2 != null) goto L22;
        String r15 = "";
    L23:
        h1a.e.b(new h1a.a("music_create/chunk/stream/start", "music_create/chunk/stream", "1", 0L, Long.valueOf(r8), r15, null, null, 192), r1);
        return;
    L22:
        r15 = r2;
        goto L23
    L18:
        r9 = System.currentTimeMillis();
        goto L19
    L24:
        long r10 = System.currentTimeMillis();
        Object r4 = r1.b.get("vid_time".concat(r21));
        if ((r4 instanceof Long) == false) goto L27;
        r6 = (Long) r4;
    L27:
        if (r6 == null) goto L29;
        long r11 = r6.longValue();
    L30:
        long r12 = r10 - r11;
        String r13 = r20.getMessageId();
        if (r13 != null) goto L33;
        String r16 = "";
    L34:
        h1a.e.b(new h1a.a("music_create/chunk/vid/start", "music_create/chunk/vid", "1", 0L, Long.valueOf(r12), r16, null, null, 192), r1);
        return;
    L33:
        r16 = r13;
        goto L34
    L29:
        r11 = System.currentTimeMillis();
        goto L30
    }

    public static h1a.a b(String r11, String r12, long r13, long r15) {
        return new h1a.a("music_create/chunk/finish", "music_create/chunk", r12, Long.valueOf(r15), Long.valueOf(r13), r11, null, null, 192);
    }

    public final void g(Message r18, String r19, long r20, boolean r22) {
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r19, "taskId");
        e r1 = d.a.a(r18);
        if (r1 != null) goto L6;
        return;
    L6:
        if (r18.getContentType() == 72) goto L8;
        return;
    L8:
        r1.b.put("play_start", Boolean.TRUE);
        Long r4 = null;
        if (r22 == false) goto L21;
        long r5 = System.currentTimeMillis();
        Object r0 = r1.b.get("stream_url_time".concat(r19));
        if ((r0 instanceof Long) == false) goto L13;
        r4 = (Long) r0;
    L13:
        if (r4 == null) goto L15;
        long r7 = r4.longValue();
    L16:
        long r6 = r5 - r7;
        String r2 = r18.getMessageId();
        if (r2 != null) goto L19;
        String r13 = "";
    L20:
        h1a.e.b(new h1a.a("music_create/chunk/stream/start", "music_create/chunk/stream", "0", Long.valueOf(r20), Long.valueOf(r6), r13, null, null, 192), r1);
        return;
    L19:
        r13 = r2;
        goto L20
    L15:
        r7 = System.currentTimeMillis();
        goto L16
    L21:
        long r8 = System.currentTimeMillis();
        Object r3 = r1.b.get("vid_time".concat(r19));
        if ((r3 instanceof Long) == false) goto L24;
        r4 = (Long) r3;
    L24:
        if (r4 == null) goto L26;
        long r9 = r4.longValue();
    L27:
        long r10 = r8 - r9;
        String r11 = r18.getMessageId();
        if (r11 != null) goto L30;
        String r14 = "";
    L31:
        h1a.e.b(new h1a.a("music_create/chunk/vid/start", "music_create/chunk/vid", "0", Long.valueOf(r20), Long.valueOf(r10), r14, null, null, 192), r1);
        return;
    L30:
        r14 = r11;
        goto L31
    L26:
        r9 = System.currentTimeMillis();
        goto L27
    }

    public final boolean e(Message r25, String r26, String r27, String r28, boolean r29, boolean r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r25, "message");
        Intrinsics.checkNotNullParameter(r26, "taskId");
        Intrinsics.checkNotNullParameter(r27, "streamUrl");
        Intrinsics.checkNotNullParameter(r28, "vid");
        e r13 = d.a.a(r25);
        if (r13 == null) goto L132;
        Object r0 = r13.b.get("lyrics_received");
        Boolean r9 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r9) == true) goto L138;
        r13.c.add(r26);
        if (r25.getMessageStatusLocal() != 21) goto L9;
    L14:
        boolean r17 = true;
    L15:
        String r8 = "vid_received";
        if (TextUtils.isEmpty(r28) == true) goto L31;
        if (Intrinsics.areEqual(r13.b.get("vid_received" + r26), r9) == true) goto L31;
        r13.b.put("vid_received" + r26, r9);
        r13.b.put("vid_time" + r26, Long.valueOf(System.currentTimeMillis()));
        long r1 = System.currentTimeMillis();
        Long r2 = r13.d();
        if (r2 == null) goto L23;
        long r3 = r2.longValue();
    L24:
        long r4 = r1 - r3;
        String r5 = r13.b();
        if (r5 != null) goto L27;
        String r6 = "";
    L28:
        h1a.e.b(new h1a.a("music_create/chunk/vid", "music_create/chunk", "1", 0L, Long.valueOf(r4), r6, r26, null, 128), r13);
        goto L31
    L27:
        r6 = r5;
        goto L28
    L23:
        r3 = System.currentTimeMillis();
    L31:
        if (TextUtils.isEmpty(r27) == true) goto L45;
        if (Intrinsics.areEqual(r13.b.get("chunk_received" + r26), r9) == true) goto L45;
        r13.b.put("chunk_received" + r26, r9);
        r13.b.put("stream_url_time" + r26, Long.valueOf(System.currentTimeMillis()));
        long r7 = System.currentTimeMillis();
        Long r10 = r13.d();
        if (r10 == null) goto L38;
        long r11 = r10.longValue();
    L39:
        long r12 = r7 - r11;
        String r14 = r13.b();
        if (r14 != null) goto L42;
        String r15 = "";
    L43:
        h1a.e.b(new h1a.a("music_create/chunk/stream", "music_create/chunk", "1", 0L, Long.valueOf(r12), r15, r26, null, 128), r13);
        goto L45
    L42:
        r15 = r14;
        goto L43
    L38:
        r11 = System.currentTimeMillis();
    L45:
        String r16 = "cover_received";
        if (r29 == false) goto L60;
        if (Intrinsics.areEqual(r13.b.get("cover_received" + r26), r9) == true) goto L60;
        r13.b.put("cover_received" + r26, r9);
        long r18 = System.currentTimeMillis();
        Long r19 = r13.d();
        if (r19 == null) goto L53;
        long r20 = r19.longValue();
    L54:
        long r21 = r18 - r20;
        String r22 = r13.b();
        if (r22 != null) goto L57;
        String r23 = "";
    L58:
        h1a.e.b(new h1a.a("music_create/chunk/cover", "music_create/chunk", "1", 0L, Long.valueOf(r21), r23, r26, null, 128), r13);
        goto L60
    L57:
        r23 = r22;
        goto L58
    L53:
        r20 = System.currentTimeMillis();
    L60:
        if (r30 == true) goto L62;
    L73:
        if (r17 == false) goto L139;
        r13.b.put("lyrics_received", r9);
        e r24 = d.a.a(r25);
        if (r24 == null) goto L131;
        long r32 = System.currentTimeMillis();
        Long r33 = r24.d();
        if (r33 == null) goto L80;
        long r34 = r33.longValue();
    L81:
        long r35 = r32 - r34;
        if (r31 == false) goto L88;
        String r36 = r25.getMessageId();
        if (r36 != null) goto L86;
        String r37 = "";
    L87:
        h1a.e.b(b(r37, "0", r35, 30013), r13);
        goto L131
    L86:
        r37 = r36;
        goto L87
    L88:
        String r38 = r25.getMessageId();
        if (r38 != null) goto L91;
        String r39 = "";
    L92:
        h1a.e.b(b(r39, "1", r35, 0), r13);
        Iterator r40 = r13.c.iterator();
    L94:
        if (r40.hasNext() == false) goto L131;
        String r41 = (String) r40.next();
        if (TextUtils.isEmpty(r41) == true) goto L131;
        Object r42 = r13.b.get("chunk_received" + r41);
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r42, r110) == true) goto L106;
        String r43 = r13.b();
        if (r43 != null) goto L104;
        String r44 = "";
    L105:
        h1a.e.b(new h1a.a("music_create/chunk/stream", "music_create/chunk", "0", 30021L, 0L, r44, r41, null, 128), r13);
        goto L106
    L104:
        r44 = r43;
    L106:
        String r111 = r8;
        if (Intrinsics.areEqual(r13.b.get(r111 + r41), r110) == true) goto L114;
        String r45 = r13.b();
        if (r45 != null) goto L112;
        String r46 = "";
    L113:
        h1a.e.b(new h1a.a("music_create/chunk/vid", "music_create/chunk", "0", 30031L, 0L, r46, r41, null, 128), r13);
        goto L114
    L112:
        r46 = r45;
    L114:
        String r112 = r16;
        if (Intrinsics.areEqual(r13.b.get(r112 + r41), r110) == true) goto L123;
        String r47 = r13.b();
        if (r47 != null) goto L120;
        String r48 = "";
    L121:
        h1a.e.b(new h1a.a("music_create/chunk/cover", "music_create/chunk", "0", 30041L, 0L, r48, r41, null, 128), r13);
        goto L123
    L120:
        r48 = r47;
    L123:
        if (Intrinsics.areEqual(r13.b.get("lyrics_received" + r41), r110) == true) goto L130;
        String r49 = r13.b();
        if (r49 != null) goto L128;
        String r50 = "";
    L129:
        h1a.e.b(new h1a.a("music_create/chunk/lyrics", "music_create/chunk", "0", 30051L, 0L, r50, r41, null, 128), r13);
        goto L130
    L128:
        r50 = r49;
    L130:
        r40 = r40;
        r8 = r111;
        r16 = r112;
        goto L94
    L91:
        r39 = r38;
        goto L92
    L80:
        r34 = System.currentTimeMillis();
    L131:
        return true;
    L139:
        return false;
    L62:
        if (Intrinsics.areEqual(r13.b.get("lyrics_received" + r26), r9) == true) goto L73;
        r13.b.put("lyrics_received" + r26, r9);
        long r51 = System.currentTimeMillis();
        Long r52 = r13.d();
        if (r52 == null) goto L67;
        long r53 = r52.longValue();
    L68:
        long r54 = r51 - r53;
        String r55 = r13.b();
        if (r55 != null) goto L71;
        String r56 = "";
    L72:
        h1a.e.b(new h1a.a("music_create/chunk/lyrics", "music_create/chunk", "1", 0L, Long.valueOf(r54), r56, r26, null, 128), r13);
        goto L73
    L71:
        r56 = r55;
        goto L72
    L67:
        r53 = System.currentTimeMillis();
        goto L68
    L9:
        if (r25.getMessageStatusLocal() == 23) goto L14;
        if (r25.getMessageStatusLocal() == 22) goto L14;
        r17 = false;
        goto L15
    L138:
        return false;
    L132:
        return false;
    }
}
