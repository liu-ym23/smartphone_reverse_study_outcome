package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import cfa.f;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ISpecialInputTask$a;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.special_input.c;
import com.obric.assistant.special_input.util.j;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenNewTaskPanelHandler implements IObricActionHandler<f, Unit> {
    public final Class<f> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.C0010d.a;
        return d.C0010d.d;
    }

    public OpenNewTaskPanelHandler() {
        this.b = f.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<f> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final f a(Context r1, String r2) {
        return (f) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r11, f r12, Continuation<? super h<? extends Unit>> r13) {
        f r14 = r12;
        if (r14 != null) goto L5;
        r14 = new f(0);
    L5:
        FLogger.a.i("OpenNewTaskPanelHandler", "handle: params = " + r14);
        String r15 = r14.c();
        if (r15 != null) goto L8;
    L15:
        r15 = "bot_chat_card";
    L16:
        ISpecialInputTask r2 = c.a();
        if (r2 == null) goto L41;
        int r4 = ObricComplexTaskPanelType.IDLE.getValue();
        boolean r5 = f.f(r14);
        String r3 = r14.a();
        if (r3 != null) goto L21;
    L26:
        String r6 = null;
    L27:
        StateInfo r7 = j.c(r4, r5, r6, null, MapsKt.mapOf(TuplesKt.to("source_from", r15)), 24);
        Boolean r16 = r14.b();
        if (r16 == null) goto L30;
        boolean r8 = r16.booleanValue();
    L31:
        Boolean r17 = r14.d();
        if (r17 == null) goto L34;
        boolean r9 = r17.booleanValue();
    L35:
        Boolean r18 = r14.e();
        if (r18 == null) goto L38;
        boolean r10 = r18.booleanValue();
    L39:
        ISpecialInputTask$a.a(r2, r7, r8, r9, r10, null, 16);
        goto L41
    L38:
        r10 = false;
        goto L39
    L34:
        r9 = true;
        goto L35
    L30:
        r8 = true;
        goto L31
    L21:
        if (r3.length() <= 0) goto L23;
        boolean r19 = true;
    L24:
        if (r19 == false) goto L26;
        r6 = r3;
        goto L27
    L23:
        r19 = false;
    L41:
        return h.a.c(h.d, null, null, 3);
    L8:
        if (r15.length() <= 0) goto L10;
        boolean r20 = true;
    L11:
        if (r20 == true) goto L14;
        r15 = null;
    L14:
        if (r15 != null) goto L16;
    L10:
        r20 = false;
        goto L11
    }
}
