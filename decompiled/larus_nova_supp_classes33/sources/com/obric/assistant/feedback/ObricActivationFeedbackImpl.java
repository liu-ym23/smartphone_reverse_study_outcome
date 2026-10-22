package com.obric.assistant.feedback;

import android.media.AudioManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.feedback.ObricActivationFeedback;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/feedback/ObricActivationFeedbackImpl;", "Lcom/obric/assistant/activation/presentation/contract/feedback/ObricActivationFeedback;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onChildListeningUiShown", "", "feedbackType", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActivationFeedbackImpl implements ObricActivationFeedback {
    public final CoroutineScope a;

    public static final class a {
    }

    static {
    }

    public ObricActivationFeedbackImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final boolean a(int r11) {
        FLogger r0 = FLogger.a;
        r0.i("ObricActivationFeedback", "onChildListeningUiShown " + r11);
        if (r11 == 1) goto L11;
        if (r11 != 2) goto L6;
        BuildersKt.launch$default(this.a, null, null, new ObricActivationFeedbackImpl$onChildListeningUiShown$1(null), 3, null);
    L14:
        return true;
    L6:
        if (r11 == 3) goto L9;
        r0.w("ObricActivationFeedback", "unsupported child listening feedback type=" + r11);
        return false;
    L9:
        t9a.b.b().d();
        aaa.c.a.a(true, "ObricListeningChildWindow");
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_WAKE_UP);
        goto L14
    L11:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_LONG_PRESS);
        Object r12 = AppHost.a.getApplication().getSystemService("audio");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) r12).getRingerMode() != 2) goto L14;
        SoundEffectHelper.INSTANCE.playListening();
        goto L14
    }
}
