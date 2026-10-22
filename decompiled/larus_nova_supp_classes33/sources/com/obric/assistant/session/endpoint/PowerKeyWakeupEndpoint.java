package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAssistActivateOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.IPowerKeyWakeupOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/session/endpoint/PowerKeyWakeupEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IPowerKeyWakeupOperation;", "<init>", "()V", "processOrder", "", "getProcessOrder", "()I", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagName", "activateClickTalk", "", "stopListening", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PowerKeyWakeupEndpoint implements ISessionEndPoint, IPowerKeyWakeupOperation {
    public PowerKeyWakeupEndpoint() {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "PowerKeyWakeupEndpoint";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 80;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r1) {
        ISessionEndPoint.a.c(this, r1);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.assistant.session.endpoint.u0] */
    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r7, Continuation<? super Pair<? extends ErrorCode, String>> r8) {
        FLogger r9 = FLogger.a;
        r9.i(ISessionEndPoint.a.b(this), "onSessionProcess: requestFromStr = ".concat(bga.j.a()));
        String r0 = bga.j.a();
        boolean r3 = true;
        if (Intrinsics.areEqual(r0, "WAKEUP_SOURCE_POWER_KEY_LONG_PRESS") == false) goto L18;
        r9.i(ISessionEndPoint.a.b(this), "active by power key long press");
        ILaunchMethodOperation r10 = bga.g.a();
        if (r10 == null) goto L7;
        ILaunchMethodOperation.a.a(r10, null, "long_press_power_button", 1);
    L7:
        ILaunchMethodOperation r11 = bga.g.a();
        if (r11 == null) goto L10;
        r11.k("open_voice_input");
    L10:
        IAssistActivateOperation r12 = bga.d.a();
        if (r12 == null) goto L13;
        r12.e(r7, 100);
    L13:
        IAssistActivateOperation r13 = bga.d.a();
        if (r13 == null) goto L46;
        IAssistActivateOperation.a.a(r13, new bga.a.b(true), null, new u0(this), 6);
    L46:
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "PowerKey OP");
    L18:
        if (Intrinsics.areEqual(r0, "WAKEUP_SOURCE_POWER_KEY_LONG_PRESS_SHUTDOWN_MENU") == false) goto L45;
        r9.i(ISessionEndPoint.a.b(this), "active by power key long press shutdown menu");
        t1a.b r14 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.b);
        String r1 = ISessionEndPoint.a.b(this);
        StringBuilder r2 = new StringBuilder("stopListening: hasChatContext=");
        if (r14 == null) goto L22;
        boolean r5 = true;
    L23:
        r2.append(r5);
        r9.i(r1, r2.toString());
        if (r14 == null) goto L30;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r15 = r14.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r15 == null) goto L30;
        if (r15.m0() != true) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == false) goto L43;
        laa.d r17 = r14.getAbility(laa.d.class);
        if (r17 != null) goto L35;
    L37:
        r3 = false;
    L38:
        if (r3 == false) goto L43;
        maa.e r18 = r14.getAbility(maa.e.class);
        if (r18 == null) goto L43;
        maa.e.a.a(r18, null, null, false, 7);
        goto L43
    L35:
        if (r17.Da() != true) goto L37;
    L43:
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "PowerKey OP shot down menu");
    L30:
        r16 = false;
        goto L31
    L22:
        r5 = false;
        goto L23
    L45:
        return ISessionEndPoint.a.e(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r1, Bundle r2) {
        ISessionEndPoint.a.d(this, r1, r2);
    }
}
