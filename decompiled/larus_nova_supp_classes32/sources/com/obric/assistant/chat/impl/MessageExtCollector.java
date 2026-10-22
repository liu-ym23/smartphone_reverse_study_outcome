package com.obric.assistant.chat.impl;

import bda.b$a;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.actionbar.service.IObricActionBarSendServiceExt;
import com.obric.assistant.special_input.j;
import com.obric.assistant.task.skill.f;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b1;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\r\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/chat/impl/MessageExtCollector;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", NameKeys.UnloadStrategy_No_Strategy, "map", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "handleReeditMessageExt", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageExtCollector implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public MessageExtCollector() {
    }

    public final String service() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void b(Map r2, IMessageExtService.a r3) {
        Intrinsics.checkNotNullParameter(r2, "map");
        String r4 = r3.b;
        if (r4 == null) goto L5;
        String r5 = (String) r2.put("reedit_id", r4);
    L5:
        r2.remove("o_user_selection_button_result");
        r2.remove("o_user_selection_type");
    }

    public final void a(Map<String, String> r3, e r4, IMessageExtService.a r5) {
        Intrinsics.checkNotNullParameter(r3, "map");
        if (r5 == null) goto L5;
        b$a r0 = new b$a(r5.a, r5.b);
    L6:
        MessageApiImpl r6 = MessageApiImpl.a;
        r3.putAll(MessageApiImpl.e(r3, r4, r0));
        if (f.d() == false) goto L19;
        String r7 = r3.get("o_task_type");
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L19;
        FLogger.a.i("MessageExtCollector", "setSendMessageExt: append phone operation ext");
        IObricActionBarSendServiceExt r9 = (IObricActionBarSendServiceExt) ServiceManager.get().getService(IObricActionBarSendServiceExt.class);
        if (r9 == null) goto L19;
        r9.i(r3, r4);
        goto L19
    L11:
        if (r7.length() == 0) goto L14;
        r8 = false;
    L19:
        b1 r10 = j.a;
        if (j.a(500) == false) goto L22;
        String r11 = "1";
    L23:
        r3.put("o_omni_enable_skill", r11);
        return;
    L22:
        r11 = "0";
        goto L23
    L5:
        r0 = null;
        goto L6
    }
}
