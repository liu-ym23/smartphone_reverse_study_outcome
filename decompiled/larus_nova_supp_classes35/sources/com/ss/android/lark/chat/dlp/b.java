package com.ss.android.lark.chat.dlp;

import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements e {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.DLP;
    }

    public final boolean a(MessageActionType r3, yya.a r4) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "actionContext");
        Message r5 = r4.g();
        if (r5 != null) goto L7;
        Log.w("DLPActionInterceptor", "message == null");
        return false;
    L7:
        if (r3 != MessageActionType.DELETE) goto L9;
        return false;
    L9:
        if (r3 != MessageActionType.COPY_MESSAGE_ID) goto L12;
        return false;
    L12:
        if (r5.getDlpState() != MessageDLPState.BLOCK) goto L16;
        return true;
    L16:
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
