package com.obric.assistant.session.model;

import android.os.Bundle;
import com.obric.assistant.session.endpoint.u0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\ba\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ\u001e\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J:\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u000eH&J\b\u0010\u001a\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u000eH&¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/session/model/IAssistActivateOperation;", "", "prepareActivation", "", "args", "Landroid/os/Bundle;", "backtrackDurationMs", "", "showListeningUI", "extra", "isAudioWeakUp", "tryInterruptConversation", "onHapticAndSoundFeedback", "Lkotlin/Function0;", "", "activate", "activation", "Lcom/obric/assistant/session/model/Activation;", "handleIntercomConditionFail", "onTouchSpeakStop", "onTouchSpeakFailed", "checkIntercomConditionPass", "updateIntercomConditionStatus", "status", "", "handleConditionUnPass", "getIntercomConditionStatus", "isShowOnLauncherOrKeyguard", "isShowOnLauncher", "resetOnLauncherOrKeyguard", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAssistActivateOperation {

    public static final class a {
        public static /* synthetic */ boolean a(IAssistActivateOperation r2, bga.a r3, Bundle r4, u0 r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L8;
            boolean r0 = true;
        L10:
            if ((r6 & 8) == 0) goto L13;
            r5 = null;
        L13:
            return r2.g(r3, r4, r0, r5);
        L8:
            r0 = false;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean b(IAssistActivateOperation r3, Bundle r4, boolean r5, Function0 r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r4 = null;
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = false;
        L9:
            if ((r7 & 8) == 0) goto L12;
            r6 = null;
        L12:
            return r3.c(r4, false, r5, r6);
        }
    }

    void a();

    void b(int r1);

    boolean c(Bundle r1, boolean r2, boolean r3, Function0<Unit> r4);

    boolean e(Bundle r1, long r2);

    boolean g(bga.a r1, Bundle r2, boolean r3, Function0<Unit> r4);

    void i();

    boolean j();

    boolean k();

    boolean l();

    int m();

    boolean o();

    void q();
}
