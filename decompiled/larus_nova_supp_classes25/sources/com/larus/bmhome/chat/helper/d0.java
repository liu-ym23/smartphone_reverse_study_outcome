package com.larus.bmhome.chat.helper;

import android.content.Context;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.im.bean.conversation.ArchiveStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tx9.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 {
    public static final d0 a = null;
    public static final Set<String> b = null;

    public static final class a implements IIMCallback<ArchiveStatus> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;
        public final /* synthetic */ Integer e;
        public final /* synthetic */ Context f;
        public final /* synthetic */ Function0<Unit> g;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("ConversationArchiveHelper", "update failed source=" + this.a + " archived=" + this.b + " conversationId=" + this.c + " code=" + r4.getCode() + " msg=" + r4.getTips());
            Integer r5 = this.e;
            if (r5 == null) goto L5;
            t19.s r0 = t19.s.a;
            Context r1 = this.f;
            int r6 = r5.intValue();
            r0.getClass();
            t19.s.s(r1, r6);
        L5:
            this.g.invoke();
        }

        public final void onSuccess(Object r5) {
            ArchiveStatus r6 = (ArchiveStatus) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            if (r6 != ArchiveStatus.SUCCESS) goto L5;
            boolean r0 = true;
        L6:
            FLogger.a.i("ConversationArchiveHelper", "update finished source=" + this.a + " archived=" + this.b + " status=" + r6 + " conversationSucceeded=" + r0 + " conversationId=" + this.c);
            if (r0 == false) goto L9;
            this.d.invoke();
        L12:
            this.g.invoke();
            return;
        L9:
            Integer r7 = this.e;
            if (r7 == null) goto L12;
            t19.s r1 = t19.s.a;
            Context r2 = this.f;
            int r8 = r7.intValue();
            r1.getClass();
            t19.s.s(r2, r8);
            goto L12
        L5:
            r0 = false;
            goto L6
        }

        public a(String r1, boolean r2, String r3, Function0<Unit> r4, Integer r5, Context r6, Function0<Unit> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public d0() {
    }

    static {
        a = new d0();
        b = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static /* synthetic */ void c(wc9.e r6) {
        a.b(r6, "chat", "auto_after_send", "send", new w());
    }

    public final void b(wc9.e r10, String r11, String r12, String r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "conversation");
        Intrinsics.checkNotNullParameter(r11, "currentPage");
        Intrinsics.checkNotNullParameter(r12, "clickFrom");
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r14, "onUnarchived");
        if (ic8.n.r(r10) == true) goto L25;
        Integer r0 = r10.t;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.intValue() != 8) goto L27;
        final String r1 = r10.a;
        if (r1.length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L17;
        r1 = null;
    L17:
        if (r1 != null) goto L20;
        return;
    L20:
        if (b.add(r1) == true) goto L23;
        FLogger.a.i("ConversationArchiveHelper", "update skipped source=" + r13 + " reason=in_flight conversationId=" + r1);
        return;
    L23:
        p3.j(r11, r1, BotInfoCache.INSTANCE.getBotId(r1), r10.I, r12, null);
        update(null, r1, false, r13, null, new x(r1), new y(r14));
        return;
    L13:
        r2 = false;
        goto L14
    L27:
        return;
    }

    public static /* synthetic */ void d(d0 r8, Context r9, String r10, boolean r11, String r12, Integer r13, Function0 r14) {
        r8.update(r9, r10, r11, r12, r13, new b0(), r14);
    }

    private final void update(Context r20, String r21, boolean r22, String r23, Integer r24, Function0<Unit> r25, Function0<Unit> r26) {
        FLogger.a.i("ConversationArchiveHelper", "update requested source=" + r23 + " archived=" + r22 + " conversationId=" + r21);
        com.larus.im.service.r.a.e(com.larus.im.d.d(), null, CollectionsKt.listOf(r21), r22, null, 0, 0, new a(r23, r22, r21, r26, r24, r20, r25), 57);
    }

    public final void a(final Context r20, final wc9.e r21, final String r22, String r23, final String r24, String r25, final by7.e r26, final Function0<Unit> r27) {
        Intrinsics.checkNotNullParameter(r21, "conversation");
        Intrinsics.checkNotNullParameter(r23, "clickFrom");
        Intrinsics.checkNotNullParameter(r27, "onArchived");
        if (ic8.n.r(r21) == false) goto L5;
        return;
    L5:
        Integer r0 = r21.t;
        boolean r1 = false;
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.intValue() != 8) goto L33;
        boolean r17 = false;
    L16:
        String r2 = r21.a;
        if (r2.length() <= 0) goto L19;
        r1 = true;
    L19:
        if (r1 == true) goto L22;
        r2 = null;
    L22:
        final String r18 = r2;
        if (r18 != null) goto L25;
        return;
    L25:
        if (r17 == false) goto L27;
        p3.b(r22, "chat", r18, r24, r21.I, r25, r23, r26);
    L28:
        if (r17 == false) goto L30;
        int r3 = 2131906567;
    L31:
        Integer r10 = Integer.valueOf(r3);
        final boolean r4 = r17;
        Function0 r11 = new z(r4, r27, r22, r18, r26, r20, r24, r21);
        d(this, r20, r18, r17, "manual", r10, r11);
        return;
    L30:
        r3 = 2131906254;
        goto L31
    L27:
        p3.j(r22, r18, r24, r21.I, r23, r26);
        goto L28
    L33:
        return;
    L9:
        if (r0.intValue() != 1) goto L11;
        r17 = true;
        goto L16
    }
}
