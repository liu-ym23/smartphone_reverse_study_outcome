package com.ss.android.lark.mergeforward;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import kotlin.Unit;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.mergeforward.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0178a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Chat.Type.values().length];
            r0[Chat.Type.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Chat.Type.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static String a(MergeForwardContent r3) {
        StringBuilder r0 = new StringBuilder();
        Chat.Type r1 = r3.getType();
        if (r1 != null) goto L6;
        r1 = Chat.Type.UNKNOWN;
    L6:
        if (TextUtils.isEmpty(r3.getQuasiTitle()) == true) goto L11;
        String r4 = r3.getQuasiTitle();
        if (r4 != null) goto L23;
        return "";
    L23:
        return r4;
    L11:
        int r2 = C0178a.a[r1.ordinal()];
        if (r2 != 1) goto L14;
        String r5 = r3.getP2pCreatorName();
        String r6 = r3.getP2pPartnerName();
        r0.append(r5);
        if (TextUtils.isEmpty(r6) == true) goto L20;
        r0.append(d.h(2131891910));
        r0.append(r6);
    L20:
        r0.append(d.h(2131891911));
    L22:
        return r0.toString();
    L14:
        if (r2 == 2) goto L16;
        Unit r7 = Unit.INSTANCE;
        goto L22
    L16:
        r0.append(d.h(2131891792));
        goto L22
    }
}
