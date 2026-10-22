package com.obric.assistant.obric_action.handler.omni_task;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.special_input.util.SpecialTrackEventUtilsKt;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.utils.l;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/omni_task/StopOmniTaskHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/omni_task/StopOmniTaskActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/omni_task/StopOmniTaskActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopOmniTaskHandler implements IObricActionHandler<b, Unit> {
    public final Class<b> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.g.a;
        return d.g.d;
    }

    public StopOmniTaskHandler() {
        this.b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r1, String r2) {
        return (b) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r8, b r9, Continuation<? super h<? extends Unit>> r10) {
        b r11 = r9;
        if (r11 == null) goto L61;
        String r12 = r11.d();
        String r0 = "";
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        boolean r2 = true;
        if (r12.length() != 0) goto L11;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        FLogger.a.w("StopOmniTaskHandler", "handle: task_id is empty");
        return h.a.a(h.d, "task_id is empty", 2);
    L15:
        ObricTaskStatusManager.a.getClass();
        DMTaskState r3 = ObricTaskStatusManager.e(r12);
        if (r3 != null) goto L18;
        FLogger.a.w("StopOmniTaskHandler", "handle: task not found. task_id=".concat(r12));
        return h.a.a(h.d, "task not found", 2);
    L18:
        String r5 = r11.a();
        if (r5 == null) goto L22;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L22;
    L32:
        if (r6 != null) goto L34;
        FLogger.a.w("StopOmniTaskHandler", "handle: message_id is invalid. task_id=" + r12 + ", message_id=" + r11.a());
        return h.a.a(h.d, "message_id is invalid", 2);
    L34:
        String r13 = r11.c();
        if (r13 != null) goto L37;
    L44:
        r13 = "bot_chat_menu";
    L45:
        String r14 = r11.b();
        if (r14 != null) goto L48;
    L55:
        r14 = "menu_interrupt_task";
    L56:
        FLogger.a.i("StopOmniTaskHandler", "handle: stop omni task. task_id=" + l.d(r3) + ", msgId=" + r6 + ", scene=" + r14);
        SpecialTrackEventUtilsKt.g(r3, r13);
        IObricNetworkService r15 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r15 == null) goto L60;
        r15.q(r6.longValue(), r14);
    L60:
        return h.a.c(h.d, null, null, 3);
    L48:
        if (r14.length() > 0) goto L51;
        r2 = false;
    L51:
        if (r2 == true) goto L54;
        r14 = null;
    L54:
        if (r14 != null) goto L56;
    L37:
        if (r13.length() <= 0) goto L39;
        boolean r16 = true;
    L40:
        if (r16 == true) goto L43;
        r13 = null;
    L43:
        if (r13 != null) goto L45;
    L39:
        r16 = false;
    L22:
        DMTaskInfo r7 = r3.getTaskInfo();
        if (r7 == null) goto L27;
        IMMessage r17 = r7.getMessage();
        if (r17 == null) goto L27;
        String r18 = r17.getMessageId();
    L28:
        if (r18 == null) goto L31;
        r0 = r18;
    L31:
        r6 = StringsKt.toLongOrNull(r0);
    L27:
        r18 = null;
        goto L28
    L11:
        r1 = false;
        goto L13
    L61:
        return h.a.a(h.d, "params is null", 2);
    }
}
