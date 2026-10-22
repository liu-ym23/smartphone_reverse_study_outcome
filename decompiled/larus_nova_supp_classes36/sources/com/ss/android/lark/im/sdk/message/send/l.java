package com.ss.android.lark.im.sdk.message.send;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.o;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l extends jkb.a<k> {

    public static final class a {
    }

    static {
    }

    public l() {
    }

    @Override // jkb.a
    public final void b(jkb.d r7, jkb.b r8, jkb.e r9) {
        k r10 = (k) r8;
        Intrinsics.checkNotNullParameter(r7, "pipelineStep");
        Intrinsics.checkNotNullParameter(r10, "pipelineContext");
        Intrinsics.checkNotNullParameter(r9, "reason");
        Log.e("ImSdkSendPipeline", "Send message pipeline terminated terminated in " + r7.getName() + ", reason is " + r9);
        o r11 = r10.b;
        MessageInfo r0 = r10.c;
        if (r0 == null) goto L5;
        Message r1 = r0.getMessage();
    L6:
        r11.k(r9, r1);
        Long r12 = r10.d;
        Long r13 = r10.e;
        if (r12 == null) goto L35;
        if (r13 == null) goto L38;
        Object r14 = m.a;
        long r2 = r12.longValue();
        long r15 = r13.longValue();
        Object r16 = m.a;
        monitor-enter(r16);
        m.a r3 = (m.a) ((LinkedHashMap) m.b).get(Long.valueOf(r2));     // Catch: Throwable -> L32
        if (r3 != null) goto L15;
        monitor-exit(r16);
        return;
    L15:
        long r4 = r3.b;     // Catch: Throwable -> L32
        if (r15 >= r4) goto L20;
        monitor-exit(r16);
        return;
    L20:
        if (r15 != r4) goto L26;
        r3.d.remove(Long.valueOf(r15));     // Catch: Throwable -> L32
        long r17 = r3.b + 1;     // Catch: Throwable -> L32
        r3.b = r17;     // Catch: Throwable -> L32
        if (r3.c == false) goto L24;
    L27:
        boolean r18 = false;
    L28:
        m.a(r2, r3);     // Catch: Throwable -> L32
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r16);
        if (r18 == false) goto L39;
        m.b(r2);
        return;
    L39:
        return;
    L24:
        if (r3.d.containsKey(Long.valueOf(r17)) == false) goto L27;
        r18 = true;
        r3.c = true;     // Catch: Throwable -> L32
        goto L28
    L26:
        r3.d.remove(Long.valueOf(r15));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L38:
        return;
    L35:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
