package com.obric.assistant.state.impl.multitask.producer;

import aha.u;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public m() {
    }

    public static /* synthetic */ u c(Message r1, boolean r2) {
        return a(r1, ObricInteractionType.DefaultMode, r2);
    }

    public static u a(Message r3, ObricInteractionType r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "fallbackType");
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getConversationId();
    L6:
        if (r3 == null) goto L14;
        if (com.larus.bmhome.chat.bean.d.G0(r3) == false) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L14;
        r0 = r3.getSenderId();
    L14:
        return b(r1, r0, r4, r5);
    L5:
        r1 = null;
        goto L6
    }

    public static u b(String r6, String r7, ObricInteractionType r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "fallbackType");
        String r1 = null;
        if (r6 != null) goto L5;
    L14:
        String r2 = null;
    L15:
        if (r7 != null) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == true) goto L26;
        if (r2 == null) goto L26;
        if (Intrinsics.areEqual(r7, r2) == true) goto L26;
        FLogger.a.w("TaskContextResolver", "botId conflict, conversationId=" + r6 + ", explicit=" + r7 + ", cached=" + r2);
    L26:
        if (r7 != null) goto L28;
    L34:
        if (r9 == false) goto L39;
        if (r2 == null) goto L39;
        IObricInteractionModeService r10 = (IObricInteractionModeService) ServiceManager.get().getService(IObricInteractionModeService.class);
        if (r10 == null) goto L39;
        a r11 = r10.c(r2);
    L41:
        if (r11 == null) goto L46;
        ObricInteractionType r0 = r11.d;
        if (r0 == null) goto L46;
        r8 = r0;
    L46:
        if (r11 == null) goto L49;
        r1 = r11.c;
    L49:
        return new u(r2, r6, r8, r1);
    L39:
        r11 = null;
        goto L41
    L28:
        if ((true ^ StringsKt.isBlank(r7)) == true) goto L31;
        r7 = null;
    L31:
        if (r7 == null) goto L34;
        r2 = r7;
        goto L34
    L17:
        if (StringsKt.isBlank(r7) == true) goto L20;
        r3 = false;
        goto L21
    L5:
        if ((!StringsKt.isBlank(r6)) == false) goto L7;
        String r4 = r6;
    L8:
        if (r4 == null) goto L14;
        r2 = BotInfoCache.INSTANCE.getBotId(r4);
        if (r2 == null) goto L14;
        if ((!StringsKt.isBlank(r2)) == false) goto L14;
    L7:
        r4 = null;
        goto L8
    }

    public static /* synthetic */ u d(String r1, String r2, ObricInteractionType r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = ObricInteractionType.DefaultMode;
    L9:
        if ((r4 & 8) == 0) goto L11;
        boolean r5 = true;
    L13:
        return b(r1, r2, r3, r5);
    L11:
        r5 = false;
        goto L13
    }
}
