package com.obric.assistant.session.model;

import android.content.Context;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.common.utils.p;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.spi.audio.CallType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0001H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0010H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010!\u001a\u00020\nH&JC\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010'\u001a\u00020\nH&¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\nH&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&J\u001c\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u00020\nH&J\u001a\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0010H&J\b\u00106\u001a\u00020\u0003H&J\b\u00107\u001a\u00020\nH&J\b\u00108\u001a\u00020\u0003H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0010H&J\u0012\u0010;\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010=H&J\u0012\u0010>\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010=H&J\b\u0010?\u001a\u00020\u0003H&¨\u0006@"}, d2 = {"Lcom/obric/assistant/session/model/ISessionMaintaining;", "", "init", "", "context", "Landroid/content/Context;", "interactionSession", "Landroid/service/voice/VoiceInteractionSession;", "getContext", "distinguishWakeupSource", "", "args", "Landroid/os/Bundle;", "showFlags", "", "getAssistantRequestFrom", "", "getWakeupSessionName", "isAutoMicRequest", "reset", "unregisterAsrListener", "registerAsrListener", "onStopIntercom", "store", "key", "value", "get", "onSessionPrepare", "onSessionProcess", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionComplete", "errorCode", "launchAssistantNow", "launchAssistantDirectly", "isMicInUse", "extra", "ignoreSpecialInput", "wakeUpClickTalk", "checkScreenLock", "(ZLandroid/os/Bundle;ZLjava/lang/Boolean;Z)V", "launchAssistant", "showOnLauncherOrKeyguard", "needUpdate", "markActivateToRecordStart", "closeSystemDialogs", "checkOpenSpecialInput", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "isVoiceInput", "launchRealtimeCall", "callType", "Lcom/obric/assistant/spi/audio/CallType;", "startupAttemptId", "closeClickTalk", "tryFinishChatActivity", "startAsrTimeout", "stopAsrTimeout", "from", "tryFinishApplet", "activity", "Landroidx/fragment/app/FragmentActivity;", "tryFinishDialogFragment", "interruptMovingBackground", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISessionMaintaining {

    public static final class a {
        public static /* synthetic */ void a(ISessionMaintaining r8, Bundle r9, Boolean r10, boolean r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            Set r0 = p.a;
            AppHost.Companion r1 = AppHost.a;
            boolean r3 = p.f(r1.getApplication(), p.b(r1.getApplication()));
        L7:
            if ((r12 & 2) == 0) goto L9;
            Bundle r4 = null;
        L11:
            if ((r12 & 8) == 0) goto L13;
            Boolean r6 = null;
        L15:
            if ((r12 & 16) == 0) goto L17;
            boolean r7 = false;
        L18:
            r8.b(r3, r4, false, r6, r7);
            return;
        L17:
            r7 = r11;
            goto L18
        L13:
            r6 = r10;
            goto L15
        L9:
            r4 = r9;
            goto L11
        L5:
            r3 = false;
            goto L7
        }
    }

    void b(boolean r1, Bundle r2, boolean r3, Boolean r4, boolean r5);

    void c();

    void closeSystemDialogs();

    Object d(Bundle r1, Continuation<? super ErrorCode> r2);

    boolean e(Bundle r1);

    boolean f(FragmentActivity r1);

    boolean g();

    Context getContext();

    void h(String r1, Object r2);

    void i();

    void interruptMovingBackground();

    boolean j();

    void k(b r1, boolean r2);

    void l();

    void m();

    boolean n(FragmentActivity r1);

    String o();

    void p(Context r1, Bundle r2);

    void r(ErrorCode r1, Bundle r2);

    boolean s(boolean r1, boolean r2);

    void t(Context r1, VoiceInteractionSession r2);

    void u(CallType r1, String r2);

    void v();

    String w();

    void x();

    void y();
}
