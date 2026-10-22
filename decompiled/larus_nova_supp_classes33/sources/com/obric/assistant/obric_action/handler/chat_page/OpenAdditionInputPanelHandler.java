package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import cfa.d;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ISpecialInputTask$a;
import com.obric.assistant.special_input.c;
import com.obric.assistant.special_input.util.j;
import com.obric.assistant.task.ObricTaskStatusManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenAdditionInputPanelHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/OpenAdditionInputPanelActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/OpenAdditionInputPanelActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenAdditionInputPanelHandler implements IObricActionHandler<d, Unit> {
    public final Class<d> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final com.obric.assistant.obric_action.d c() {
        com.obric.assistant.obric_action.d r0 = com.obric.assistant.obric_action.d.C0010d.a;
        return com.obric.assistant.obric_action.d.C0010d.f;
    }

    public OpenAdditionInputPanelHandler() {
        this.b = d.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<d> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d a(Context r1, String r2) {
        return (d) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r17, d r18, Continuation<? super h<? extends Unit>> r19) {
        d r0 = r18;
        if (r0 != null) goto L5;
        r0 = new d(0);
    L5:
        FLogger r2 = FLogger.a;
        r2.i("OpenAdditionInputPanelHandler", "handle: params = " + r0);
        String r3 = r0.e();
        String r5 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r3.length() != 0) goto L11;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r2.w("OpenAdditionInputPanelHandler", "handle: task_id is empty, abort");
        return h.a.a(h.d, "task_id is empty", 2);
    L15:
        ObricTaskStatusManager.a.getClass();
        DMTaskState r7 = ObricTaskStatusManager.e(r3);
        if (r7 != null) goto L18;
        r2.w("OpenAdditionInputPanelHandler", "handle: no such task for task_id=".concat(r3));
    L18:
        String r4 = r0.d();
        if (r4 != null) goto L21;
    L28:
        r4 = "bot_chat_card";
    L29:
        ISpecialInputTask r9 = c.a();
        if (r9 == null) goto L49;
        boolean r8 = d.h(r0);
        Pair[] r10 = new Pair[2];
        String r11 = r0.b();
        if (r11 == null) goto L35;
        r5 = r11;
    L35:
        r10[0] = TuplesKt.to("o_reference_msg_content", r5);
        r10[1] = TuplesKt.to("source_from", r4);
        StateInfo r12 = j.b(2, r8, MapsKt.mapOf(r10), r0.c(), r7);
        Boolean r13 = r0.a();
        if (r13 == null) goto L38;
        boolean r14 = r13.booleanValue();
    L39:
        Boolean r15 = r0.f();
        if (r15 == null) goto L42;
        boolean r16 = r15.booleanValue();
    L43:
        Boolean r1 = r0.g();
        if (r1 == null) goto L46;
        boolean r110 = r1.booleanValue();
    L47:
        ISpecialInputTask$a.a(r9, r12, r14, r16, r110, null, 16);
        goto L49
    L46:
        r110 = false;
        goto L47
    L42:
        r16 = true;
        goto L43
    L38:
        r14 = true;
    L49:
        return h.a.c(h.d, null, null, 3);
    L21:
        if (r4.length() <= 0) goto L23;
        boolean r20 = true;
    L24:
        if (r20 == true) goto L27;
        r4 = null;
    L27:
        if (r4 != null) goto L29;
    L23:
        r20 = false;
        goto L24
    L11:
        r6 = false;
        goto L13
    }
}
