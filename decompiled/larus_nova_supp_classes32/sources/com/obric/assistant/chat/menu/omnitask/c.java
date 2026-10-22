package com.obric.assistant.chat.menu.omnitask;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.special_input.util.SpecialTrackEventUtilsKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends a {
    public static final c b = null;

    static {
        b = new c();
    }

    public c() {
        super(2131381220);
    }

    @Override // com.obric.assistant.chat.menu.a
    public final void a(Fragment r5, ot8.a r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "item");
        FLogger r7 = FLogger.a;
        r7.i("OmniTaskStopMenuItemHandler", "handleMenuItemClick");
        String r2 = null;
        if ((r6 instanceof l0) == false) goto L5;
        l0 r8 = (l0) r6;
    L6:
        if (r8 == null) goto L8;
        Object r9 = r8.l;
    L10:
        if ((r9 instanceof Pair) == false) goto L12;
        Pair r10 = (Pair) r9;
    L13:
        if (r10 == null) goto L15;
        Object r0 = r10.getFirst();
    L17:
        if ((r0 instanceof Message) == false) goto L19;
        Message r1 = (Message) r0;
    L20:
        if (r1 != null) goto L23;
        r7.w("OmniTaskStopMenuItemHandler", "handleMenuItemClick: msg is null");
        return;
    L23:
        Object r11 = r10.getSecond();
        if ((r11 instanceof DMTaskState) == false) goto L26;
        DMTaskState r12 = (DMTaskState) r11;
    L27:
        if (r12 != null) goto L30;
        r7.i("OmniTaskStopMenuItemHandler", "no taskState");
        return;
    L30:
        DMTaskInfo r3 = r12.getTaskInfo();
        if (r3 == null) goto L35;
        IMMessage r4 = r3.getMessage();
        if (r4 == null) goto L35;
        r2 = r4.getMessageId();
    L35:
        if (r2 != null) goto L37;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L37:
        Long r13 = StringsKt.toLongOrNull(r2);
        if (r13 == null) goto L42;
        r7.i("OmniTaskStopMenuItemHandler", "notifyStopComplexTaskByHttp, msgId=" + r13);
        SpecialTrackEventUtilsKt.g(r12, "bot_chat_menu");
        IObricNetworkService r14 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r14 == null) goto L44;
        r14.q(r13.longValue(), "menu_interrupt_task");
        return;
    L44:
        return;
    L42:
        r7.w("OmniTaskStopMenuItemHandler", "handleMenuItemClick: msgId are invalid, " + r1.getMessageId());
        return;
    L26:
        r12 = null;
        goto L27
    L19:
        r1 = null;
        goto L20
    L15:
        r0 = null;
        goto L17
    L12:
        r10 = null;
        goto L13
    L8:
        r9 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
