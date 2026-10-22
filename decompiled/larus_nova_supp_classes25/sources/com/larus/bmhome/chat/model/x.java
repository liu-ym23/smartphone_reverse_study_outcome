package com.larus.bmhome.chat.model;

import android.os.Looper;
import androidx.lifecycle.Transformations;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.nestedfile.FieldType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public static final x a = null;
    public static final Keva b = null;
    public static String c;
    public static volatile String d;
    public static volatile String e;
    public static volatile boolean f;
    public static volatile long g;
    public static final Map<String, Long> h = null;
    public static final Lazy i = null;
    public static final p j = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FieldType.values().length];
            r0[FieldType.PARSE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FieldType.REVIEW_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements com.larus.platform.api.b {
        public b() {
        }

        public final void a(com.larus.platform.api.c r28) {
            Intrinsics.checkNotNullParameter(r28, "event");
            FLogger.a.d("ChatDraftRepo", "accountStateCallback.onLogIn");
            x r1 = x.a;
            monitor-enter(r1);
            long r2 = Math.max(System.currentTimeMillis(), x.g + 1);     // Catch: Throwable -> L50
            x.g = r2;     // Catch: Throwable -> L50
            String r14 = x.d;     // Catch: Throwable -> L50
            String r12 = x.e;     // Catch: Throwable -> L50
            boolean r17 = true;
            if (Intrinsics.areEqual(r28.e, "input_click") == false) goto L7;
        L10:
            boolean r19 = true;
        L11:
            final Ref.LongRef r13 = new Ref.LongRef();     // Catch: Throwable -> L50
            final Ref.LongRef r11 = new Ref.LongRef();     // Catch: Throwable -> L50
            if (r14 == null) goto L15;
            if (r12 == null) goto L15;
            List<ChatDraftItem> r4 = r1.d(r14, r12, new y(r13, r11));     // Catch: Throwable -> L50
        L16:
            List<ChatDraftItem> r6 = r4;
            x.c = r28.b;     // Catch: Throwable -> L50
            z2 r5 = z2.a;     // Catch: Throwable -> L50
            if (z2.c4() == false) goto L26;
            if (r19 == false) goto L26;
            if (r14 == null) goto L26;
            if (r12 == null) goto L26;
            if (Intrinsics.areEqual(r12, r28.b) == true) goto L26;
            if ((!r6.isEmpty()) == false) goto L26;
            boolean r20 = true;
        L27:
            if (r20 == false) goto L29;
            boolean r7 = x.i(r1, r14, r6, r2, true, r28.b, null, r11.element, 32);     // Catch: Throwable -> L50
        L30:
            if (r20 == false) goto L33;
            if (r7 == false) goto L33;
        L34:
            x.f = r17;     // Catch: Throwable -> L50
            if (r19 == false) goto L43;
            if (r14 == 0) goto L43;
            if (r12 == 0) goto L43;
            if (Intrinsics.areEqual(r12, r28.b) == true) goto L43;
            if (r20 == false) goto L42;
            if (r7 == false) goto L43;
        L42:
            x.b(r1, r14, Math.max(r2, r13.element + 1), true, r12, Long.valueOf(r11.element), null, 32);     // Catch: Throwable -> L50
        L43:
            if (r19 == true) goto L45;
            x.d = null;     // Catch: Throwable -> L50
            x.e = null;     // Catch: Throwable -> L50
            x.f = false;     // Catch: Throwable -> L50
        L45:
            monitor-exit(r1);
            if (z2.c4() == true) goto L55;
            x.b(r1, "__mobile_new_session_mode_draft_chat__", r2, true, r28.b, null, null, 48);
            x.b(r1, "__mobile_new_session_mode_draft_office__", r2, true, r28.b, null, null, 48);
            return;
        L55:
            return;
        L33:
            r17 = false;
            goto L34
        L29:
            r7 = false;
        L26:
            r20 = false;
        L15:
            r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L50
            goto L16
        L7:
            if (Intrinsics.areEqual(r28.e, "message_quota_limit") == true) goto L10;
            r19 = false;
        L50:
            th = move-exception;
            throw th;
        }

        public final void b(com.larus.platform.api.c r18) {
            Intrinsics.checkNotNullParameter(r18, "event");
            String r0 = x.c;
            x r10 = x.a;
            x.d = null;
            x.e = null;
            x.f = false;
            z2 r1 = z2.a;
            if (z2.c4() == true) goto L5;
            long r11 = System.currentTimeMillis();
            x.b(r10, "__mobile_new_session_mode_draft_chat__", r11, true, r0, null, null, 48);
            x.b(r10, "__mobile_new_session_mode_draft_office__", r11, true, r0, null, null, 48);
        L5:
            x.c = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/model/ChatDraftRepo$convertToDraftItemList$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/model/ChatDraftItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c extends TypeToken<List<? extends ChatDraftItem>> {
        public c() {
        }
    }

    public x() {
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [androidx.lifecycle.Observer, com.larus.bmhome.chat.model.p] */
    static {
        x r10 = new x();
        a = r10;
        b = Keva.getRepo("im_chat_draft", 0);
        c = "";
        g = System.currentTimeMillis();
        h = new LinkedHashMap();
        i = LazyKt.lazy(new o());
        b r0 = new b();
        ?? r11 = new p();
        j = r11;
        AccountService r1 = AccountService.a;
        c = r1.getUserId();
        r1.E(r0);
        z2 r2 = z2.a;
        if (z2.c4() == true) goto L12;
        monitor-enter(r10);
        long r12 = Math.max(System.currentTimeMillis(), g + 1);     // Catch: Throwable -> L8
        g = r12;     // Catch: Throwable -> L8
        monitor-exit(r10);
        b(r10, "__mobile_new_session_mode_draft_chat__", r12, true, c, null, null, 48);
        b(r10, "__mobile_new_session_mode_draft_office__", r12, true, c, null, null, 48);
    L8:
        th = move-exception;
        throw th;
    L12:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L14;
        RepoDispatcher.a.getClass();
        Transformations.distinctUntilChanged(RepoDispatcher.d.a).observeForever(r11);
        return;
    L14:
        FLogger.a.w("ChatDraftRepo", "ChatDraftRepo first init not in main thread, current thread is " + ThreadMethodProxy.currentThread().getName());
        com.larus.utils.y.c(new q());
    }

    public static List a(final String r3) {
        if (((Boolean) i.getValue()).booleanValue() == true) goto L5;
    L17:
        final Type r0 = new c().getType();
        int r1 = com.larus.utils.l0.a;
        return (List) com.larus.utils.l0.a(CollectionsKt.emptyList(), new r(r3, r0));
    L5:
        if (StringsKt.isBlank(r3) == true) goto L16;
        if (r3.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        if (Intrinsics.areEqual(StringsKt.trim(r3).toString(), "[]") == true) goto L16;
        if (Intrinsics.areEqual(StringsKt.trim(r3).toString(), "{}") == false) goto L17;
    L9:
        r2 = false;
    L16:
        return CollectionsKt.emptyList();
    }

    public static String c(String r1, String r2) {
        return r2 + '_' + r1;
    }

    public final boolean f(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        List r7 = e(this, r5, r6, null, 4);
        if (r7.isEmpty() == false) goto L14;
        return false;
    L14:
        List r8 = r7;
        if ((r8 instanceof Collection) == true) goto L17;
    L19:
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L25;
        if (z.a((ChatDraftItem) r9.next()) == false) goto L21;
        return true;
    L25:
        return false;
    L17:
        if (r8.isEmpty() == false) goto L19;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static /* synthetic */ boolean h(String r6, String r7, String r8) {
        return a.g(r6, r7, r8, false, false);
    }

    public final synchronized List<ChatDraftItem> d(String r9, String r10, Function2<? super Long, ? super Long, Unit> r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "userId");     // Catch: Throwable -> L54
        if (r9 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L14;
        List<ChatDraftItem> r12 = CollectionsKt.emptyList();     // Catch: Throwable -> L54
        monitor-exit(this);
        return r12;
    L14:
        String r13 = c(r9, r10);     // Catch: Throwable -> L54
        z2 r1 = z2.a;     // Catch: Throwable -> L54
        if (z2.c4() == true) goto L19;
        List<ChatDraftItem> r14 = a(b.getString(r13, "[]"));     // Catch: Throwable -> L54
        monitor-exit(this);
        return r14;
    L19:
        List<ChatDraftItem> r2 = a(b.getString(r13, "[]"));     // Catch: Throwable -> L54
        Iterator<T> r3 = r2.iterator();     // Catch: Throwable -> L54
        if (r3.hasNext() == true) goto L22;
        Long r4 = null;
    L30:
        if (r4 == null) goto L32;
        long r5 = r4.longValue();     // Catch: Throwable -> L54
    L34:
        if (Intrinsics.areEqual(r9, "__mobile_new_session_mode_draft_chat__") == false) goto L36;
    L37:
        long r6 = b.getLong("mobile_new_session_mode_draft_invalidated_at", 0);     // Catch: Throwable -> L54
        if (r5 > r6) goto L47;
        if (r11 == null) goto L44;
        LinkedHashMap r15 = (LinkedHashMap) h;     // Catch: Throwable -> L54
        Object r7 = r15.get(r13);     // Catch: Throwable -> L54
        if (r7 != null) goto L43;
        r7 = Long.valueOf(Math.max(r5, r6));     // Catch: Throwable -> L54
        r15.put(r13, r7);     // Catch: Throwable -> L54
    L43:
        r11.invoke(r7, 0L);     // Catch: Throwable -> L54
    L44:
        List<ChatDraftItem> r16 = CollectionsKt.emptyList();     // Catch: Throwable -> L54
        monitor-exit(this);
        return r16;
    L47:
        if (r11 == null) goto L52;
        LinkedHashMap r17 = (LinkedHashMap) h;     // Catch: Throwable -> L54
        Object r8 = r17.get(r13);     // Catch: Throwable -> L54
        if (r8 != null) goto L51;
        r8 = Long.valueOf(r5);     // Catch: Throwable -> L54
        r17.put(r13, r8);     // Catch: Throwable -> L54
    L51:
        r11.invoke(r8, Long.valueOf(r5));     // Catch: Throwable -> L54
    L52:
        monitor-exit(this);
        return r2;
    L36:
        if (Intrinsics.areEqual(r9, "__mobile_new_session_mode_draft_office__") == false) goto L47;
    L32:
        r5 = b.getLong(r13 + "_update_time", 0);     // Catch: Throwable -> L54
        goto L34
    L22:
        Long r18 = Long.valueOf(((ChatDraftItem) r3.next()).getUpdateTime());     // Catch: Throwable -> L54
    L24:
        if (r3.hasNext() == false) goto L28;
        Long r19 = Long.valueOf(((ChatDraftItem) r3.next()).getUpdateTime());     // Catch: Throwable -> L54
        if (r18.compareTo(r19) >= 0) goto L24;
        r18 = r19;
        goto L24
    L28:
        r4 = r18;
        goto L30
    L6:
        if (r9.length() == 0) goto L9;
        r0 = false;
    L54:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List e(x r1, String r2, String r3, Function2 r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = c;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.d(r2, r3, r4);
    }

    public final synchronized boolean g(String r22, String r23, String r24, boolean r25, boolean r26) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r24, "userId");     // Catch: Throwable -> L56
        FLogger.a.d("ChatDraftRepo", "migrateDraftToNewConversation oldCvsId:" + r22 + " newCvsId:" + r23);     // Catch: Throwable -> L56
        if (r22 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L53;
        if (r23 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L53;
        if (Intrinsics.areEqual(r22, r23) == false) goto L24;
        monitor-exit(this);
        return true;
    L24:
        final Ref.LongRef r11 = new Ref.LongRef();     // Catch: Throwable -> L56
        final Ref.LongRef r9 = new Ref.LongRef();     // Catch: Throwable -> L56
        List<ChatDraftItem> r3 = d(r22, r24, new v(r11, r9));     // Catch: Throwable -> L56
        if (r26 == true) goto L27;
    L30:
        final Ref.LongRef r4 = new Ref.LongRef();     // Catch: Throwable -> L56
        d(r23, r24, new w(r4));     // Catch: Throwable -> L56
        monitor-enter(this);     // Catch: Throwable -> L56
        long r14 = Math.max(System.currentTimeMillis(), Math.max(g + 1, r11.element + 1));     // Catch: Throwable -> L50
        g = r14;     // Catch: Throwable -> L50
        monitor-exit(this);     // Catch: Throwable -> L56
        if (r25 == true) goto L36;
    L39:
        Ref.LongRef r20 = r9;
        Ref.LongRef r0 = r11;
        if (i(this, r23, r3, r14, false, r24, null, r9.element, 40) == false) goto L42;
    L41:
        boolean r5 = true;
    L43:
        if (r5 == true) goto L45;
    L47:
        boolean r15 = false;
    L48:
        monitor-exit(this);
        return r15;
    L45:
        if (b(this, r22, r14, false, r24, Long.valueOf(r20.element), Long.valueOf(r0.element), 4) == false) goto L47;
        r15 = true;
        goto L48
    L42:
        r5 = false;
        goto L43
    L36:
        if (r4.element < r9.element) goto L39;
        r20 = r9;
        r0 = r11;
        goto L41
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L27:
        if (r3.isEmpty() == false) goto L30;
        monitor-exit(this);
        return true;
    L14:
        if (r23.length() == 0) goto L17;
        r2 = false;
    L53:
        monitor-exit(this);
        return false;
    L7:
        if (r22.length() == 0) goto L10;
        r1 = false;
    L56:
        th = move-exception;
        throw th;
    }

    public static boolean b(x r17, String r18, long r19, boolean r21, String r22, Long r23, Long r24, int r25) {
        if ((r25 & 2) == 0) goto L5;
        long r1 = System.currentTimeMillis();
    L7:
        if ((r25 & 4) == 0) goto L9;
        z2 r3 = z2.a;
        boolean r4 = z2.c4();
    L11:
        if ((r25 & 8) == 0) goto L13;
        String r5 = c;
    L14:
        Long r6 = null;
        if ((r25 & 16) == 0) goto L17;
        Long r7 = null;
    L19:
        if ((r25 & 32) == 0) goto L21;
        Long r8 = null;
    L23:
        monitor-enter(r17);
        Intrinsics.checkNotNullParameter(r5, "userId");     // Catch: Throwable -> L97
        FLogger.a.d("ChatDraftRepo", "deleteDraftList conversationId:" + r18);     // Catch: Throwable -> L97
        if (r18 != null) goto L27;
    L30:
        boolean r10 = true;
    L31:
        if (r10 == false) goto L34;
        monitor-exit(r17);
    L89:
        return false;
    L34:
        String r9 = c(r18, r5);     // Catch: Throwable -> L97
        z2 r11 = z2.a;     // Catch: Throwable -> L97
        if (z2.c4() == true) goto L40;
        if (r4 == true) goto L40;
        b.storeString(r9, "[]");     // Catch: Throwable -> L97
        monitor-exit(r17);
    L95:
        return true;
    L40:
        Iterator r12 = a(b.getString(r9, "[]")).iterator();     // Catch: Throwable -> L97
        if (r12.hasNext() == false) goto L50;
        r6 = Long.valueOf(((ChatDraftItem) r12.next()).getUpdateTime());     // Catch: Throwable -> L97
    L45:
        if (r12.hasNext() == false) goto L50;
        Long r13 = Long.valueOf(((ChatDraftItem) r12.next()).getUpdateTime());     // Catch: Throwable -> L97
        if (r6.compareTo(r13) >= 0) goto L45;
        r6 = r13;
    L50:
        if (r6 == null) goto L52;
        long r14 = r6.longValue();     // Catch: Throwable -> L97
    L53:
        LinkedHashMap r15 = (LinkedHashMap) h;     // Catch: Throwable -> L97
        Object r16 = r15.get(r9);     // Catch: Throwable -> L97
        if (r16 != null) goto L56;
        r16 = Long.valueOf(r14);     // Catch: Throwable -> L97
        r15.put(r9, r16);     // Catch: Throwable -> L97
    L56:
        long r110 = ((Number) r16).longValue();     // Catch: Throwable -> L97
        z2 r111 = z2.a;     // Catch: Throwable -> L97
        if (z2.c4() == true) goto L64;
        if (Intrinsics.areEqual(r18, "__mobile_new_session_mode_draft_chat__") == false) goto L61;
    L62:
        Keva r20 = b;     // Catch: Throwable -> L97
        r20.storeLong("mobile_new_session_mode_draft_invalidated_at", Math.max(r1, Math.max(r110, r20.getLong("mobile_new_session_mode_draft_invalidated_at", 0))));     // Catch: Throwable -> L97
        goto L64
    L61:
        if (Intrinsics.areEqual(r18, "__mobile_new_session_mode_draft_office__") == true) goto L62;
    L64:
        if (r4 == false) goto L91;
        if (r7 != null) goto L67;
    L73:
        boolean r26 = false;
    L74:
        if (r26 == true) goto L87;
        if (r8 == null) goto L83;
        if (r8.longValue() == r110) goto L79;
        boolean r27 = true;
        boolean r28 = true;
    L80:
        if (r28 != r27) goto L83;
        boolean r29 = true;
    L84:
        if (r29 == true) goto L87;
        if (r1 >= r110) goto L91;
    L79:
        r27 = true;
        r28 = false;
    L83:
        r29 = false;
    L87:
        FLogger.a.i("ChatDraftRepo", "ignore stale draft deletion conversationId:" + r18 + " writeRevision:" + r1 + " storedWriteRevision:" + r110 + " expectedWriteRevision:" + r8 + " expectedLastUserEditedAt:" + r7 + " storedLastUserEditedAt:" + r14);     // Catch: Throwable -> L97
        monitor-exit(r17);
        goto L89
    L67:
        if (r7.longValue() == r14) goto L69;
        boolean r30 = true;
    L71:
        if (r30 != true) goto L73;
        r26 = true;
        goto L74
    L69:
        r30 = false;
    L91:
        Keva r0 = b;     // Catch: Throwable -> L97
        r0.storeString(r9, "[]");     // Catch: Throwable -> L97
        if (r4 == false) goto L94;
        r0.storeLong(r9 + "_update_time", r14);     // Catch: Throwable -> L97
        r15.put(r9, Long.valueOf(r1));     // Catch: Throwable -> L97
    L94:
        monitor-exit(r17);
        goto L95
    L52:
        r14 = b.getLong(r9 + "_update_time", 0);     // Catch: Throwable -> L97
        goto L53
    L27:
        if (r18.length() == 0) goto L30;
        r10 = false;
    L97:
        th = move-exception;
        throw th;
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r22;
        goto L14
    L9:
        r4 = r21;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }

    public static boolean i(x r27, String r28, List r29, long r30, boolean r32, String r33, Long r34, long r35, int r37) {
        if ((r37 & 4) == 0) goto L5;
        long r1 = System.currentTimeMillis();
    L7:
        if ((r37 & 8) == 0) goto L9;
        z2 r3 = z2.a;
        boolean r4 = z2.c4();
    L11:
        if ((r37 & 16) == 0) goto L13;
        String r5 = c;
    L15:
        if ((r37 & 32) == 0) goto L17;
        Long r6 = null;
    L19:
        if ((r37 & 64) == 0) goto L33;
        if (r29 == null) goto L32;
        Iterator r7 = r29.iterator();
        if (r7.hasNext() == true) goto L24;
        Long r10 = null;
    L30:
        if (r10 == null) goto L32;
        long r11 = r10.longValue();
    L34:
        monitor-enter(r27);
        Intrinsics.checkNotNullParameter(r5, "userId");     // Catch: Throwable -> L118
        FLogger r8 = FLogger.a;     // Catch: Throwable -> L118
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L118
        r13.append("updateDraftList conversationId:");     // Catch: Throwable -> L118
        r13.append(r28);     // Catch: Throwable -> L118
        r13.append(", newDraftList:");     // Catch: Throwable -> L118
        if (r29 == null) goto L41;
        List r15 = r29;     // Catch: Throwable -> L118
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));     // Catch: Throwable -> L118
        Iterator r12 = r15.iterator();     // Catch: Throwable -> L118
    L39:
        if (r12.hasNext() == false) goto L42;
        ChatDraftItem r16 = (ChatDraftItem) r12.next();     // Catch: Throwable -> L118
        r9.add(ChatDraftItem.copy$default(r16, null, g2a.d.b(r16.getContent()), null, 0, null, null, null, null, 253, null));     // Catch: Throwable -> L118
    L42:
        r13.append(r9);     // Catch: Throwable -> L118
        r8.d("ChatDraftRepo", r13.toString());     // Catch: Throwable -> L118
        if (r28 != null) goto L45;
    L48:
        boolean r14 = true;
    L49:
        if (r14 == true) goto L116;
        if (r29 == null) goto L116;
        String r17 = c(r28, r5);     // Catch: Throwable -> L118
        z2 r18 = z2.a;     // Catch: Throwable -> L118
        if (z2.c4() == true) goto L64;
        if (r4 == true) goto L64;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L118
        Iterator r0 = r29.iterator();     // Catch: Throwable -> L118
    L57:
        if (r0.hasNext() == false) goto L61;
        Object r19 = r0.next();     // Catch: Throwable -> L118
        if (z.a((ChatDraftItem) r19) == false) goto L57;
        r2.add(r19);     // Catch: Throwable -> L118
        goto L57
    L61:
        b.storeString(r17, GsonProtectorUtils.toJson(new Gson(), r2));     // Catch: Throwable -> L118
        monitor-exit(r27);
    L115:
        return true;
    L64:
        Iterator r20 = a(b.getString(r17, "[]")).iterator();     // Catch: Throwable -> L118
        if (r20.hasNext() == true) goto L67;
        Long r21 = null;
    L73:
        if (r21 == null) goto L75;
        long r22 = r21.longValue();     // Catch: Throwable -> L118
    L76:
        LinkedHashMap r110 = (LinkedHashMap) h;     // Catch: Throwable -> L118
        Object r111 = r110.get(r17);     // Catch: Throwable -> L118
        if (r111 != null) goto L79;
        r111 = Long.valueOf(r22);     // Catch: Throwable -> L118
        r110.put(r17, r111);     // Catch: Throwable -> L118
    L79:
        long r112 = ((Number) r111).longValue();     // Catch: Throwable -> L118
        if (r6 != null) goto L82;
    L84:
        boolean r113 = false;
    L86:
        if (r1 >= r112) goto L88;
        boolean r114 = true;
    L89:
        if (r4 == false) goto L95;
        if (r113 == true) goto L92;
        if (r114 == false) goto L95;
    L92:
        FLogger.a.i("ChatDraftRepo", "ignore stale draft update conversationId:" + r28 + " lastUserEditedAt:" + r11 + " storedLastUserEditedAt:" + r22 + " writeRevision:" + r1 + " storedWriteRevision:" + r112 + " expectedWriteRevision:" + r6);     // Catch: Throwable -> L118
        monitor-exit(r27);
        return false;
    L95:
        ArrayList r23 = new ArrayList();     // Catch: Throwable -> L118
        Iterator r24 = r29.iterator();     // Catch: Throwable -> L118
    L97:
        if (r24.hasNext() == false) goto L101;
        Object r25 = r24.next();     // Catch: Throwable -> L118
        if (z.a((ChatDraftItem) r25) == false) goto L97;
        r23.add(r25);     // Catch: Throwable -> L118
        goto L97
    L101:
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));     // Catch: Throwable -> L118
        Iterator r31 = r23.iterator();     // Catch: Throwable -> L118
    L103:
        if (r31.hasNext() == false) goto L108;
        ChatDraftItem r115 = (ChatDraftItem) r31.next();     // Catch: Throwable -> L118
        if (r4 == false) goto L107;
        r115 = ChatDraftItem.copy$default(r115, null, null, null, r11, null, null, null, null, 247, null);     // Catch: Throwable -> L118
    L107:
        r26.add(r115);     // Catch: Throwable -> L118
        goto L103
    L108:
        String r36 = GsonProtectorUtils.toJson(new Gson(), r26);     // Catch: Throwable -> L118
        Keva r38 = b;     // Catch: Throwable -> L118
        r38.storeString(r17, r36);     // Catch: Throwable -> L118
        if (r4 == true) goto L111;
    L114:
        monitor-exit(r27);
        goto L115
    L111:
        if (r26.isEmpty() == false) goto L113;
        r38.storeLong(r17 + "_update_time", r11);     // Catch: Throwable -> L118
    L113:
        h.put(r17, Long.valueOf(r1));     // Catch: Throwable -> L118
        goto L114
    L88:
        r114 = false;
        goto L89
    L82:
        if (r6.longValue() == r112) goto L84;
        r113 = true;
        goto L86
    L75:
        r22 = b.getLong(r17 + "_update_time", 0);     // Catch: Throwable -> L118
        goto L76
    L67:
        r21 = Long.valueOf(((ChatDraftItem) r20.next()).getUpdateTime());     // Catch: Throwable -> L118
    L69:
        if (r20.hasNext() == false) goto L73;
        Long r116 = Long.valueOf(((ChatDraftItem) r20.next()).getUpdateTime());     // Catch: Throwable -> L118
        if (r21.compareTo(r116) >= 0) goto L69;
        r21 = r116;
    L116:
        monitor-exit(r27);
        return false;
    L45:
        if (r28.length() == 0) goto L48;
        r14 = false;
        goto L49
    L41:
        r9 = null;
    L118:
        th = move-exception;
        throw th;
    L24:
        r10 = Long.valueOf(((ChatDraftItem) r7.next()).getUpdateTime());
    L26:
        if (r7.hasNext() == false) goto L30;
        Long r117 = Long.valueOf(((ChatDraftItem) r7.next()).getUpdateTime());
        if (r10.compareTo(r117) >= 0) goto L26;
        r10 = r117;
    L32:
        r11 = 0;
        goto L34
    L33:
        r11 = r35;
        goto L34
    L17:
        r6 = r34;
        goto L19
    L13:
        r5 = r33;
        goto L15
    L9:
        r4 = r32;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }
}
