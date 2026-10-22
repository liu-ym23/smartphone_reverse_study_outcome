package com.larus.bmhome.chat.service;

import com.larus.bmhome.chat.api.ConversationFeedActionScene;
import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.api.IConversationFeedActionService;
import com.larus.bmhome.chat.api.u;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.i1;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/service/ConversationFeedActionServiceImpl;", "Lcom/larus/bmhome/chat/api/IConversationFeedActionService;", "<init>", "()V", "getSupportedActions", "", "Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "scene", "Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "canShowAction", "", "actionType", "createExecutor", "Lcom/larus/bmhome/chat/api/IConversationFeedActionExecutor;", "context", "Lcom/larus/bmhome/chat/api/ConversationFeedActionContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationFeedActionServiceImpl implements IConversationFeedActionService {

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

    public ConversationFeedActionServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final u b(com.larus.bmhome.chat.api.i r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new d(r2);
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final List<ConversationFeedActionType> c(wh8.a r7, ConversationFeedActionScene r8) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        ConversationFeedActionType[] r0 = ConversationFeedActionType.values();
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        ConversationFeedActionType r4 = r0[r3];
        if (a(r4, r7, r8) == false) goto L7;
        r1.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("getSupportedActions: scene=");
        r6.append(r8);
        r6.append(", conversationId=");
        if (r7 == null) goto L13;
        wc9.e r9 = r7.a;
        if (r9 == null) goto L13;
        String r10 = r9.a;
    L14:
        r6.append(r10);
        r6.append(", actions=");
        r6.append(r1);
        r5.d("ConversationFeedActionService", r6.toString());
        return r1;
    L13:
        r10 = null;
        goto L14
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final boolean a(ConversationFeedActionType r7, wh8.a r8, ConversationFeedActionScene r9) {
        Intrinsics.checkNotNullParameter(r7, "actionType");
        Intrinsics.checkNotNullParameter(r9, "scene");
        BotModel r10 = null;
        if (r8 == null) goto L5;
        wc9.e r0 = r8.a;
    L7:
        if (r8 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r0 != null) goto L14;
    L28:
        boolean r4 = false;
    L30:
        switch(b.a[r7.ordinal()]) {
            case 1: goto L110;
            case 2: goto L91;
            case 3: goto L72;
            case 4: goto L118;
            case 5: goto L45;
            case 6: goto L41;
            case 7: goto L114;
            case 8: goto L38;
            case 9: goto L33;
            default: goto L32;
        };
    L33:
        ShareServiceDelegate r11 = ShareServiceDelegate.b;
        if (r8 == null) goto L116;
        r10 = r8.b;
    L116:
        return r11.h(r0, r10);
    L41:
        if (r4 == false) goto L114;
        if (AppHost.a.isOversea() == true) goto L114;
        return true;
    L45:
        if (r3 == true) goto L114;
        if (r0 != null) goto L48;
    L50:
        boolean r12 = false;
    L51:
        if (r12 == true) goto L117;
        if (r0 != null) goto L54;
    L56:
        boolean r13 = false;
    L57:
        if (r13 == false) goto L114;
        if (ArraysKt.contains(new Integer[]{4, 3}, r0.t) == true) goto L114;
        if (ic8.n.k(r0) != true) goto L63;
        boolean r14 = true;
    L64:
        if (r14 == true) goto L66;
    L68:
        boolean r15 = false;
    L69:
        if (r15 == true) goto L114;
        return true;
    L66:
        if (Intrinsics.areEqual(r0.A, Boolean.TRUE) == false) goto L68;
        r15 = true;
        goto L69
    L63:
        r14 = false;
        goto L64
    L54:
        if (ic8.n.k(r0) != true) goto L56;
        r13 = true;
        goto L57
    L117:
        return true;
    L48:
        if (ic8.n.D(r0) != true) goto L50;
        r12 = true;
        goto L51
    L72:
        if (r8 != null) goto L74;
    L76:
        boolean r16 = false;
    L77:
        if (r16 == true) goto L114;
        if (r0 != null) goto L80;
    L82:
        boolean r17 = false;
    L83:
        if (r17 == false) goto L114;
        if (ic8.n.m(r0) == true) goto L114;
        if (ic8.n.l(r0) == true) goto L114;
        if (ic8.n.y(r0) == true) goto L114;
        return true;
    L80:
        if (ic8.n.z(r0) != true) goto L82;
        r17 = true;
        goto L83
    L74:
        if (i1.b(r8) != true) goto L76;
        r16 = true;
        goto L77
    L91:
        if (r8 != null) goto L93;
    L95:
        boolean r18 = false;
    L96:
        if (r18 == true) goto L114;
        if (r0 != null) goto L99;
    L101:
        boolean r19 = false;
    L102:
        if (r19 == true) goto L114;
        if (ic8.n.m(r0) == true) goto L114;
        if (ic8.n.l(r0) == true) goto L114;
        if (ic8.n.y(r0) == true) goto L114;
        return true;
    L99:
        if (ic8.n.z(r0) != true) goto L101;
        r19 = true;
        goto L102
    L93:
        if (i1.b(r8) != true) goto L95;
        r18 = true;
        goto L96
    L110:
        if (r8 == null) goto L114;
        if (i1.b(r8) != true) goto L114;
        return true;
    L114:
        return false;
    L32:
        throw new NoWhenBranchMatchedException();
    L38:
        if (ic8.n.w(r0) == true) goto L114;
        if (r3 == true) goto L114;
        return true;
    L118:
        return r3;
    L14:
        if (ic8.n.u(r0) != true) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
    L25:
        boolean r6 = true;
    L26:
        if (r6 != true) goto L28;
        r4 = true;
        goto L30
    L19:
        if (ic8.n.D(r0) != true) goto L21;
        boolean r20 = true;
    L22:
        if (r20 == true) goto L25;
        r6 = false;
        goto L26
    L21:
        r20 = false;
        goto L22
    L16:
        r5 = false;
        goto L17
    L9:
        if (r8.c() != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r0 = null;
        goto L7
    }
}
