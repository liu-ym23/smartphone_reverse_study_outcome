package com.obric.assistant.chat.impl;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.api.b0;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.chat.ObricWindowMessageBubbleConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.IClearContextInKeyguardService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.IQueryAuthenticationService;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import iga.c;
import iga.d;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import va8.l;
import va8.m;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J4\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u000bH\u0016J$\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070-H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020+H\u0002J\u0014\u00101\u001a\u00020\u0007*\u00020+2\u0006\u0010*\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/assistant/chat/impl/ObricChatSPIServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricChatSPIService;", "<init>", "()V", "queryAuthenticationService", "Lcom/obric/assistant/chat/IQueryAuthenticationService;", "tryBreakLatestAnswer", NameKeys.UnloadStrategy_No_Strategy, "curCvsId", NameKeys.UnloadStrategy_No_Strategy, "onCheckAsrContentRelative", NameKeys.UnloadStrategy_No_Strategy, "taskid", "asrContent", "ensureContextSafe", "cvsId", "canRetry", "extra", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReGenerate", "questionMsg", "Lcom/larus/im/bean/message/Message;", "shouldSkipAsLatestRegenerateMessage", "message", "markChatListBottomReached", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "isEnabledAssistantOpenPageMethod", "isBluetoothHeadSetConnected", "enableLiveTutorAsrOpt", "enableCameraCommandOpt", "enableCameraSuggestedToDeferred", "enableCameraOpenResultPage", "openChatWindowForCameraResult", "Landroid/os/Bundle;", "getCachedMainChatSnapshot", "Lcom/obric/assistant/spi/chat/ObricMainChatSnapshot;", "getWindowInboxBackgroundStyle", "Lcom/obric/assistant/spi/chat/ObricWindowInboxBackgroundStyle;", "isDarkMode", "tryLaunchFilePicker", "defaultIntent", "Landroid/content/Intent;", "launch", "Lkotlin/Function1;", "buildFilePickerIntent", "canResolveFilePicker", "intent", "copyAllowedMimeTypes", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatSPIServiceImpl implements IObricChatSPIService {
    public final IQueryAuthenticationService a;

    public static final class a {
    }

    static {
    }

    public final boolean d() {
        return true;
    }

    public final boolean i() {
        return true;
    }

    public final boolean j() {
        return true;
    }

    public final boolean l() {
        return true;
    }

    public final c c() {
        IObricChatService.a.getClass();
        IObricChatService r0 = IObricChatService.a.a();
        if (r0 != null) goto L6;
        FLogger.a.i("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: chat service unavailable");
        return null;
    L6:
        e r3 = r0.h();
        BotModel r1 = r0.j0();
        if (r3 == null) goto L42;
        if (r1 == null) goto L10;
        String r4 = r1.getBotId();
    L11:
        boolean r5 = true;
        if (r4 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == true) goto L42;
        IAuthModelService r7 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r7 == null) goto L27;
        LiveData r8 = r7.y();
        if (r8 == null) goto L27;
        e r9 = (e) r8.getValue();
        if (r9 == null) goto L27;
        String r10 = r9.a;
    L28:
        if (r10 != null) goto L30;
    L33:
        if (r5 == false) goto L37;
        FLogger.a.i("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: current main conversation unavailable");
        return null;
    L37:
        if (Intrinsics.areEqual(r3.a, r10) == true) goto L41;
        FLogger.a.w("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: cached conversation is stale");
        return null;
    L41:
        return new c(r1, r3);
    L30:
        if (StringsKt.isBlank(r10) == true) goto L33;
        r5 = false;
    L27:
        r10 = null;
        goto L28
    L14:
        if (StringsKt.isBlank(r4) == true) goto L17;
        r6 = false;
        goto L18
    L10:
        r4 = null;
    L42:
        FLogger.a.i("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: chat cache not ready");
        return null;
    }

    public ObricChatSPIServiceImpl() {
        this.a = (IQueryAuthenticationService) ServiceManager.get().getService(IQueryAuthenticationService.class);
    }

    public final boolean a() {
        IBluetoothHeadSetAPI r0 = tha.c.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public static Intent o(Intent r10) {
        Intent r0 = new Intent("com.bytedance.action.PICK_FILE_FROM_FILE_MANAGER");
        r0.setPackage("com.obric.filemanager");
        String r1 = r10.getType();
        if (r1 != null) goto L5;
        r1 = "*/*";
    L5:
        r0.setType(r1);
        String[] r2 = r10.getStringArrayExtra("android.intent.extra.MIME_TYPES");
        boolean r3 = true;
        if (r2 == null) goto L14;
        ArrayList r5 = new ArrayList();
        int r6 = r2.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L13;
        String r8 = r2[r7];
        Intrinsics.checkNotNull(r8);
        if ((!StringsKt.isBlank(r8)) == false) goto L12;
        r5.add(r8);
    L12:
        r7 = r7 + 1;
        goto L8
    L13:
        String[] r4 = (String[]) r5.toArray(new String[0]);
    L15:
        if (r4 != null) goto L17;
    L23:
        if (r3 == true) goto L25;
        r0.putExtra("android.intent.extra.MIME_TYPES", r4);
    L25:
        r0.putExtra("android.intent.extra.ALLOW_MULTIPLE", r10.getBooleanExtra("android.intent.extra.ALLOW_MULTIPLE", false));
        return r0;
    L17:
        if (r4.length != 0) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L23;
        r3 = false;
        goto L23
    L19:
        r9 = false;
        goto L20
    L14:
        r4 = null;
        goto L15
    }

    public static boolean p(Intent r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (FlowRuntime.a().getApplication().getPackageManager().queryIntentActivities(r5, 65536).isEmpty() == true) goto L5;
        boolean r1 = true;
    L6:
        Object r2 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L13;
        FLogger.a.w("ObricChatSPIServiceImpl", "canResolveFilePicker failed, package=" + r5.getPackage() + ", action=" + r5.getAction() + ", message=" + r3.getMessage());
    L13:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L17;
        r2 = r6;
    L17:
        return ((Boolean) r2).booleanValue();
    L5:
        r1 = false;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "questionMsg");
        IQueryAuthenticationService r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final d e(boolean r3) {
        ObricWindowMessageBubbleConfig r0 = z2.a.getObricWindowMessageBubbleConfig();
        if (r0.getEnable() == true) goto L7;
        return null;
    L7:
        return new d(r0.getColorToken(r3));
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "curCvsId");
        IObricChatService.a.getClass();
        IObricChatService r0 = IObricChatService.a.a();
        if (r0 == null) goto L6;
        r0.g();
        MessageApiImpl.a.h(r2);
        return;
    }

    public final boolean h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (com.larus.bmhome.chat.bean.d.W0(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.larus.bmhome.chat.bean.d.V0(r2) == false) goto L7;
        return true;
    }

    public final void k(t1a.b r3) {
        Intrinsics.checkNotNullParameter(r3, "vContext");
        m r4 = r3.getAbility(m.class);
        b0 r0 = null;
        if (r4 == null) goto L7;
        l r5 = r4.iX();
        if (r5 == null) goto L7;
        RecyclerView r6 = r5.getMessageList();
    L9:
        if ((r6 instanceof b0) == false) goto L11;
        r0 = (b0) r6;
    L11:
        if (r0 != null) goto L14;
        FLogger.a.w("ObricChatSPIServiceImpl", "markChatListBottomReached: messageList is null");
        return;
    L14:
        r0.setBottomReached(true);
        return;
    L7:
        r6 = null;
        goto L9
    }

    public final boolean m(Bundle r15) {
        Intrinsics.checkNotNullParameter(r15, "extra");
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r1 != null) goto L6;
        return false;
    L6:
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r1, NameKeys.UnloadStrategy_No_Strategy, false, Boolean.FALSE, r15, false, false, null, null, false, false, 768, null);
        return true;
    }

    public final boolean f(Intent r5, li8.c r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultIntent");
        Intrinsics.checkNotNullParameter(r6, "launch");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Intent r7 = o(r5);     // Catch: Throwable -> L9
        if (p(r7) == true) goto L6;
        FLogger.a.w("ObricChatSPIServiceImpl", "tryLaunchFilePicker: custom file picker unavailable");     // Catch: Throwable -> L9
        boolean r8 = false;
    L7:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r8));     // Catch: Throwable -> L9
    L11:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L14;
        FLogger.a.e("ObricChatSPIServiceImpl", "tryLaunchFilePicker failed, message=" + r10.getMessage(), r10);
    L14:
        Boolean r11 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L18;
        r9 = r11;
    L18:
        return ((Boolean) r9).booleanValue();
    L6:
        FLogger.a.i("ObricChatSPIServiceImpl", "tryLaunchFilePicker: launch custom file picker");     // Catch: Throwable -> L9
        r6.invoke(r7);     // Catch: Throwable -> L9
        r8 = true;
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final Object n(String r17, boolean r18, Map<String, String> r19, Continuation<? super Boolean> r20) {
        String r0 = r17;
        if ((r20 instanceof ObricChatSPIServiceImpl$ensureContextSafe$1) == false) goto L7;
        ObricChatSPIServiceImpl$ensureContextSafe$1 r3 = (ObricChatSPIServiceImpl$ensureContextSafe$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = false;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        ResultKt.throwOnFailure(r2);
    L80:
        if (((Boolean) r2).booleanValue() == true) goto L82;
        r7 = true;
    L82:
        boolean r8 = !r7;
    L83:
        if (r8 == true) goto L86;
        FLogger.a.w("ObricChatSPIServiceImpl", "ensureContextSafe: clear context in keyguard failed");
    L86:
        return Boxing.boxBoolean(r8);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        IClearContextInKeyguardService r1 = (IClearContextInKeyguardService) r3.L$1;
        String r9 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L75:
        if (r1 == null) goto L82;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.label = 4;
        r2 = r1.a(r9, r3);
        if (r2 != r5) goto L80;
        return r5;
    L18:
        boolean r10 = r3.Z$0;
        IClearContextInKeyguardService r11 = (IClearContextInKeyguardService) r3.L$1;
        String r12 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L64:
        if (((Boolean) r2).booleanValue() == true) goto L66;
        boolean r13 = true;
    L68:
        r8 = !r13;
        if (r8 == true) goto L83;
        if (r10 == false) goto L83;
        FLogger.a.i("ObricChatSPIServiceImpl", "ensureContextSafe: clear context in keyguard failed, will retry");
        r3.L$0 = r12;
        r3.L$1 = r11;
        r3.label = 3;
        if (DelayKt.delay(700, r3) != r5) goto L74;
        return r5;
    L74:
        r1 = r11;
        r9 = r12;
        goto L75
    L66:
        boolean r14 = r10;
    L67:
        r10 = r14;
        r13 = false;
        goto L68
    L19:
        boolean r15 = r3.Z$0;
        String r16 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r14 = r15;
        r0 = r16;
        Object r21 = r2;
    L33:
        e r22 = (e) r21;
        if (r22 == null) goto L37;
        String r23 = r22.a;
    L38:
        if (r0 != null) goto L40;
    L43:
        boolean r24 = true;
    L44:
        if (r24 == false) goto L48;
        if (r23 != null) goto L47;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
        goto L48
    L47:
        r12 = r23;
    L50:
        if (Intrinsics.areEqual(r12, r23) == false) goto L87;
        r11 = (IClearContextInKeyguardService) ServiceManager.get().getService(IClearContextInKeyguardService.class);
        if (r11 != null) goto L54;
    L56:
        boolean r25 = false;
    L57:
        if (r25 == false) goto L89;
        if (r11 == null) goto L67;
        r3.L$0 = r12;
        r3.L$1 = r11;
        r3.Z$0 = r14;
        r3.label = 2;
        Object r26 = r11.a(r12, r3);
        if (r26 != r5) goto L62;
        return r5;
    L62:
        boolean r110 = r14;
        r2 = r26;
        r10 = r110;
    L89:
        return Boxing.boxBoolean(true);
    L54:
        if (r11.b() != true) goto L56;
        r25 = true;
        goto L57
    L87:
        FLogger.a.i("ObricChatSPIServiceImpl", "ensureContextSafe: is not main conversation, mainConversationId = " + r23);
    L48:
        r12 = r0;
        goto L50
    L40:
        if (r0.length() == 0) goto L43;
        r24 = false;
    L37:
        r23 = null;
        goto L38
    L20:
        ResultKt.throwOnFailure(r2);
        FLogger r27 = FLogger.a;
        r27.i("ObricChatSPIServiceImpl", "ensureContextSafe: cvsId = " + r0);
        if (r19 == null) goto L23;
        String r28 = r19.get("o_not_clear_context");
    L25:
        if (Intrinsics.areEqual(r28, "1") == false) goto L28;
        r27.i("ObricChatSPIServiceImpl", "has extra, not clear context");
        return Boxing.boxBoolean(true);
    L28:
        IObricChatService r29 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r29 == null) goto L36;
        r3.L$0 = r0;
        r14 = r18;
        r3.Z$0 = r14;
        r3.label = 1;
        r21 = r29.d(r3);
        if (r21 != r5) goto L33;
        return r5;
    L36:
        r14 = r18;
        goto L37
    L23:
        r28 = null;
    L7:
        r3 = new ObricChatSPIServiceImpl$ensureContextSafe$1(this, r20);
        goto L8
    }
}
