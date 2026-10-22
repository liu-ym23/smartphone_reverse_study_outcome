package kc8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final Message a;
    public final Boolean b;
    public boolean c;
    public boolean d;
    public final h e;
    public String f;
    public e g;
    public ra8.b h;

    public f(Message r17, Boolean r18, boolean r19, boolean r20, h r21, String r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        Message r1 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        Boolean r3 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r23 & 8) == 0) goto L17;
        boolean r5 = true;
    L19:
        if ((r23 & 16) == 0) goto L21;
        h r6 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r14 = "default";
    L26:
        Intrinsics.checkNotNullParameter(r14, "containerScene");
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r14;
        this.g = null;
        this.h = new ra8.b(null, null, null, false, null, r14, 95);
        return;
    L25:
        r14 = r22;
        goto L26
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
