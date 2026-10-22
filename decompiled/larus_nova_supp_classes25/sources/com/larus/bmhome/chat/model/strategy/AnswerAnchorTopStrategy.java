package com.larus.bmhome.chat.model.strategy;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AnswerAnchorTopStrategy {
    public static final Set<String> a = null;
    public static final Set<String> b = null;
    public static boolean c;
    public static final Object d = null;

    public static final class a implements nf9.c {
        public a() {
        }

        public final void B(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void C(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void A(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            if (com.larus.bmhome.chat.bean.d.j0(r2) == false) goto L6;
            Set<String> r0 = AnswerAnchorTopStrategy.a;
            AnswerAnchorTopStrategy.a(r2.getReplyId());
            return;
        }
    }

    static {
        a = new LinkedHashSet();
        b = new LinkedHashSet();
        d = new Object();
        FLogger.a.d("AnswerAnchorTopStrategy", "add global message stream observer");
        int r0 = com.larus.im.d.a;
        com.larus.im.internal.stream.b.a.a(new a());
    }

    public static void a(String r9) {
        if (r9 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        c = false;
        FLogger.a.d("AnswerAnchorTopStrategy", "endReply, reply_for: " + r9);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnswerAnchorTopStrategy$endAnswerReceiving$1(r9, null), 2, null);
        return;
    L5:
        if (r9.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
