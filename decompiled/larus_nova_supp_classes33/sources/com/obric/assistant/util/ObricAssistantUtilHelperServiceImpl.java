package com.obric.assistant.util;

import android.content.Intent;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.utils.IObricAssistantUtilHelperService;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000728\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0016JG\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/util/ObricAssistantUtilHelperServiceImpl;", "Lcom/obric/assistant/utils/IObricAssistantUtilHelperService;", "<init>", "()V", "startActivityForResult", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onSucceeded", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", WindowEvent.Params.RESULT, "onFailed", "Lkotlin/Function0;", "mobClickTalkEnter", "botId", "", "conversationId", "callId", "enterMethod", "duration", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/json/JSONObject;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantUtilHelperServiceImpl implements IObricAssistantUtilHelperService {
    public ObricAssistantUtilHelperServiceImpl() {
    }

    @Override // com.obric.assistant.utils.IObricAssistantUtilHelperService
    public void startActivityForResult(Intent r2, Function2<? super Integer, ? super Intent, Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r3, "onSucceeded");
        StartActivityForResultHelper.a.startActivityForResult(r2, r3, r4);
    }

    @Override // com.obric.assistant.utils.IObricAssistantUtilHelperService
    public final void a(String r3, String r4, String r5, String r6, Integer r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r8.put("bot_id", r3);
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r8.put("conversation_id", r4);
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r8.put("call_id", r5);
        r8.put("enter_method", r6);
        r8.put("duration", r7);
        TrackParams r9 = new TrackParams().merge(r8);
        by7.a r10 = new by7.a("obric_click_speak_enter_call");
        r10.a.merge(r9);
        r10.b();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
        if (com.obric.assistant.t1.a.o0() == false) goto L15;
        com.larus.platform.service.g.a.monitorEventForSlardar("obric_click_speak_enter_call", r8, null, null);     // Catch: Throwable -> L17
    L15:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        FLogger.a.i("mobClickTalkEnterCall", "params:" + r8);
        return;
    L17:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
