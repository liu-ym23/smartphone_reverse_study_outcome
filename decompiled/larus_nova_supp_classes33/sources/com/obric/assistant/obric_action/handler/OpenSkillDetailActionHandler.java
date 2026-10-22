package com.obric.assistant.obric_action.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.obric_action.j;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/OpenSkillDetailActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/ObricSkillDetailActionUtils$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/ObricSkillDetailActionUtils$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenSkillDetailActionHandler implements IObricActionHandler<j.a, Unit> {
    public final Class<j.a> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.l.a;
        return d.l.a;
    }

    public OpenSkillDetailActionHandler() {
        this.b = j.a.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<j.a> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final j.a a(Context r1, String r2) {
        return (j.a) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r9, j.a r10, Continuation<? super h<? extends Unit>> r11) {
        j.a r12 = r10;
        FLogger r13 = FLogger.a;
        r13.i("OpenSkillDetailActionHandler", "execute: params = " + r12);
        String r2 = null;
        if (r12 == null) goto L9;
        String r3 = r12.b();
        if (r3 == null) goto L9;
        if ((!StringsKt.isBlank(r3)) == false) goto L9;
    L11:
        if (r3 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        r13.w("OpenSkillDetailActionHandler", "execute: skill_id is empty");
        return h.a.a(h.d, "skill_id is empty", 2);
    L19:
        h.a r14 = h.d;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L34
        Intent r4 = new Intent().setClassName(r9.getPackageName(), "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewStarterActivity").putExtra("slug", r3).putExtra("prefer_shop_detail", true);     // Catch: Throwable -> L34
        if (r12 == null) goto L30;
        String r15 = r12.a();     // Catch: Throwable -> L34
        if (r15 == null) goto L30;
        if ((!StringsKt.isBlank(r15)) == false) goto L27;
        r2 = r15;
    L27:
        if (r2 == null) goto L30;
        r4.putExtra("log_extras", r2);     // Catch: Throwable -> L34
    L30:
        if ((r9 instanceof Activity) == true) goto L32;
        r4.addFlags(268435456);     // Catch: Throwable -> L34
    L32:
        r9.startActivity(r4);     // Catch: Throwable -> L34
        Object r16 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L34
    L36:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L39;
        FLogger.a.w("OpenSkillDetailActionHandler", "startActivity failed. " + r17.getMessage(), r17);
    L39:
        Boolean r18 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r16) == false) goto L43;
        r16 = r18;
    L43:
        return r14.b(((Boolean) r16).booleanValue());
    L34:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L13:
        if (StringsKt.isBlank(r3) == true) goto L16;
        r5 = false;
    L9:
        r3 = null;
        goto L11
    }
}
