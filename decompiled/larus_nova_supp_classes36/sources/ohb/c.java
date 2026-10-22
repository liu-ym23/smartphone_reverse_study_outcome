package ohb;

import com.ss.android.lark.notification.export.entity.CurrentProcess;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements ctb.a {
    public c() {
    }

    @Override // ctb.a
    public final void a(Notice r3) {
        Intrinsics.checkNotNullParameter(r3, "notice");
        StringBuilder r0 = new StringBuilder("onPushNotice id=");
        r0.append(r3.key);
        r0.append(", messageId=");
        r0.append(r3.messageId);
        r0.append("  type=");
        r0.append(r3.type);
        r0.append(" from=");
        r0.append(r3.extra.c);
        r0.append(", uid=");
        Notice.Extra r1 = r3.extra;
        if (r1 == null) goto L5;
        String r2 = r1.p;
    L6:
        r0.append(r2);
        thb.a.b("InitFlowNotificationTask", r0.toString());
        int r4 = a.a;
        ((zsb.c) k.a(LarkContext.getApplication(), zsb.c.class)).R2(r3, CurrentProcess.MAIN);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
