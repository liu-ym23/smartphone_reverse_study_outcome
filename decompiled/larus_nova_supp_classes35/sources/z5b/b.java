package z5b;

import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;
import yya.e;
import yya.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements e, h {
    public b() {
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.COT;
    }

    public final boolean d(yya.a r5) {
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        com.ss.android.lark.chat.cot.a r0 = w.a(r5).o0();
        v5b.c r1 = r5.m();
        CotContent r3 = null;
        if ((r1 instanceof y6b.a) == false) goto L5;
        y6b.a r2 = (y6b.a) r1;
    L6:
        Message r6 = r5.g();
        if (r0.a.isEnable("lark.im.agent.cot_message") == false) goto L16;
        if (r2 == null) goto L10;
        CotContent r4 = r2.a;
    L11:
        if (r4 != null) goto L15;
        if (r6 == null) goto L14;
        r3 = r6.getCotContent();
    L14:
        if (r3 == null) goto L16;
    L15:
        return true;
    L10:
        r4 = null;
    L16:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean a(MessageActionType r3, yya.a r4) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "actionContext");
        return false;
    }

    public final boolean b(MessageActionType r1, yya.a r2) {
        e.a.c(r1, r2);
        return false;
    }

    public final boolean c(MessageActionType r1, yya.a r2, boolean r3) {
        e.a.b(r1, r2);
        return false;
    }
}
