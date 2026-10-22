package com.larus.bmhome.chat.service;

import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.api.u;
import com.larus.bmhome.chat.service.action.j0;
import com.larus.bmhome.chat.service.action.l0;
import com.larus.bmhome.chat.service.action.m0;
import com.larus.bmhome.chat.service.action.n0;
import com.larus.bmhome.chat.service.action.z;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements u {
    public final com.larus.bmhome.chat.api.i a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ConversationFeedActionType.values().length];
            r0[ConversationFeedActionType.REFRESH_RECOMMEND_BOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[ConversationFeedActionType.PIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[ConversationFeedActionType.UNPIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[ConversationFeedActionType.HIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ConversationFeedActionType.EDIT_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[ConversationFeedActionType.MOVE_TO_PROJECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[ConversationFeedActionType.REMOVE_FROM_PROJECT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[ConversationFeedActionType.DELETE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[ConversationFeedActionType.SHARE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    static {
    }

    public final com.larus.bmhome.chat.service.action.a b() {
        return (com.larus.bmhome.chat.service.action.a) this.d.getValue();
    }

    public d(com.larus.bmhome.chat.api.i r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new com.larus.bmhome.chat.service.a(this));
        this.c = LazyKt.lazy(new com.larus.bmhome.chat.service.b(this));
        this.d = LazyKt.lazy(new c(this));
    }

    @Override // com.larus.bmhome.chat.api.u
    public final void a(ConversationFeedActionType r4, wh8.a r5) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "data");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("execute: actionType=");
        r1.append(r4);
        r1.append(", conversationId=");
        wc9.e r2 = r5.a;
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L6:
        r1.append(r3);
        r0.d("ConversationFeedActionExecutor", r1.toString());
        switch(b.a[r4.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            default: goto L9;
        };
    L10:
        com.larus.bmhome.chat.service.action.b r6 = new m0(b());
    L18:
        r6.a(r5);
        return;
    L11:
        r6 = new com.larus.bmhome.chat.service.action.h(b());
        goto L18
    L12:
        r6 = new z(b(), r4);
        goto L18
    L13:
        r6 = new com.larus.bmhome.chat.service.action.k(b());
        goto L18
    L14:
        r6 = new com.larus.bmhome.chat.service.action.l(b());
        goto L18
    L15:
        r6 = new n0(b());
        goto L18
    L16:
        r6 = new j0(b());
        goto L18
    L17:
        r6 = new l0(b());
        goto L18
    L9:
        throw new NoWhenBranchMatchedException();
    L5:
        r3 = null;
        goto L6
    }
}
