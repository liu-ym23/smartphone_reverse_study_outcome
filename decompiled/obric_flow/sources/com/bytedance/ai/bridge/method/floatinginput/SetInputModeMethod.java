package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.objects.PageType;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetInputModeMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL$SetInputModeParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL$SetInputModeResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetInputModeMethodIDL$SetInputModeParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSetInputModeMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SetInputModeMethod.kt\ncom/bytedance/ai/bridge/method/floatinginput/SetInputModeMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
public final class SetInputModeMethod extends AbsSetInputModeMethodIDL {
    public SetInputModeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSetInputModeMethodIDL.SetInputModeParamModal) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(n1.c r5, AbsSetInputModeMethodIDL.SetInputModeParamModal r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        n1.a r12 = (n1.a) r5;
        j r13 = (j) r12.b(j.class);
        Object r14 = null;
        if (r13 == null) goto L5;
        ContainerType r15 = r13.d();
    L7:
        if (r15 != ContainerType.f1801c) goto L39;
        w0.f r16 = (w0.f) r12.b(w0.f.class);
        if (r16 != null) goto L12;
        r11.a("aicontainer is null");
        return;
    L12:
        com.bytedance.ai.model.widgets.a r17 = (com.bytedance.ai.model.widgets.a) r16;
        if (r17.f2330b.getPageType() != PageType.FULL_PAGE) goto L15;
    L44:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L25
        e r19 = InputMode.f1817a;     // Catch: Throwable -> L25
        String r20 = r10.getMode();     // Catch: Throwable -> L25
        r19.getClass();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r20, "value");     // Catch: Throwable -> L25
        InputMode r21 = InputMode.f1818b;     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r20, MessageIndication.CONTENT_TYPE_TEXT) == true) goto L24;
        r21 = InputMode.f1819c;     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r20, "asr") == true) goto L24;
        throw new IllegalArgumentException(td.d.b("No enum constant ", r20));     // Catch: Throwable -> L25
    L24:
        Object r22 = Result.m124constructorimpl(r21);     // Catch: Throwable -> L25
    L31:
        if (Result.m130isFailureimpl(r22) == true) goto L35;
        r14 = r22;
    L35:
        if (((InputMode) r14) == null) goto L37;
        r11.a("floating speaker controller is null");
        return;
    L37:
        r11.a("unsupported input mode " + r10.getMode());
        return;
    L25:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L31
    L15:
        if (r17.f2330b.getPageType() == PageType.POPUP_PAGE) goto L44;
        r11.a("unsupported page type " + r17.f2330b.getPageType());
        return;
    L39:
        StringBuilder r24 = new StringBuilder("unsupported container type ");
        j r25 = (j) r12.b(j.class);
        if (r25 == null) goto L42;
        r14 = r25.d();
    L42:
        r24.append(r14);
        r11.a(r24.toString());
        return;
    L5:
        r15 = null;
        goto L7
    }
}
