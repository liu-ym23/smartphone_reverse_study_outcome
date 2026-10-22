package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.clarification.j2;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.thread.ThreadMessageListRequest;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final j2 a;
    public final g b;
    public final AtomicInteger c;

    /* JADX INFO: renamed from: com.larus.bmhome.interactionpanel.a$a, reason: collision with other inner class name */
    public static final class C0020a {
    }

    static {
    }

    public a(j2 r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "manager");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicInteger();
    }

    public final boolean update(m r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "entry");
        Intrinsics.checkNotNullParameter(r20, "hostId");
        t r0 = r19.c;
        boolean r2 = false;
        if (r0 != null) goto L8;
        r0 = r19.d;
        if (r0 != null) goto L8;
        FLogger.a.w("ClarificationPanelAdapter", "skip clarification update, payload empty, key=" + r19.a);
        return false;
    L8:
        int r5 = this.c.incrementAndGet();
        if ((r0 instanceof t.b) == false) goto L12;
        return b(r19, r20, ((t.b) r0).a, r5);
    L12:
        if ((r0 instanceof t.a) == false) goto L20;
        t.a r1 = (t.a) r0;
        String r7 = r1.d;
        if (StringsKt.isBlank(r7) == false) goto L16;
        FLogger.a.w("ClarificationPanelAdapter", "skip clarification update, messageId empty, key=" + r19.a);
        this.b.e(r19.a, "clarification_message_id_empty");
    L18:
        return r2;
    L16:
        com.larus.im.d.e().q(new ThreadMessageListRequest(r1.b, null, 0, 50, true, 6, null), new d(r19, r7, this, r20, r5));
        r2 = true;
        goto L18
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a(m r2, String r3, Message r4, int r5) {
        if (r5 == this.c.get()) goto L6;
        FLogger.a.i("ClarificationPanelAdapter", "skip stale clarification show, key=" + r2.a);
        return false;
    L6:
        this.a.fY(r2, r4, new b(this, r3));
        return true;
    }

    public final boolean b(m r5, String r6, Message r7, int r8) {
        if (r8 == this.c.get()) goto L5;
        FLogger.a.i("ClarificationPanelAdapter", "skip stale clarification update, key=" + r5.a);
        boolean r0 = false;
    L6:
        if (r0 == false) goto L9;
        return true;
    L9:
        FLogger.a.i("ClarificationPanelAdapter", "fallback to clarification show on update miss, key=" + r5.a);
        return a(r5, r6, r7, r8);
    L5:
        r0 = this.a.update(r5, r7);
        goto L6
    }
}
