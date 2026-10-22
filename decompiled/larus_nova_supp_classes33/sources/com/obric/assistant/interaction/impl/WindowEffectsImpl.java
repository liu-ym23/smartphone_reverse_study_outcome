package com.obric.assistant.interaction.impl;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IWindowEffects;
import com.obric.assistant.interaction.api.WeakUpState;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/interaction/impl/WindowEffectsImpl;", "Lcom/obric/assistant/interaction/api/IWindowEffects;", "<init>", "()V", "setWakeupStateTime", "Ljava/util/concurrent/atomic/AtomicLong;", "wakeupState", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/assistant/interaction/api/WeakUpState;", "setWakeupState", "", "weakUpState", "getValidWakeUpState", "startActivateEffect", "withRipple", "", "playRippleEffect", "stopActivateEffect", "showScreenShotEffect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowEffectsImpl implements IWindowEffects {
    public static final Companion Companion = null;
    private static final String TAG = "WindowEffectsImpl";
    private final AtomicLong setWakeupStateTime;
    private final AtomicReference<WeakUpState> wakeupState;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/WindowEffectsImpl$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.assistant.interaction.api.IWindowEffects
    public void playRippleEffect() {
        FLogger.a.i(TAG, "playRippleEffect");
        t9a.b.b().d();
        aaa.c.a.a(true, "obric-assistant-window");
    }

    @Override // com.obric.assistant.interaction.api.IWindowEffects
    public void showScreenShotEffect() {
        FLogger.a.i(TAG, "showScreenShotEffect");
        t9a.b.b().d();
        aaa.c.a.b(true, "obric-assistant-window");
    }

    @Override // com.obric.assistant.interaction.api.IWindowEffects
    public void stopActivateEffect() {
        FLogger.a.i(TAG, "stopActivateEffect");
        t9a.b.b().d();
        aaa.c.a.stopActivateEffect();
    }

    public WindowEffectsImpl() {
        this.setWakeupStateTime = new AtomicLong(0);
        this.wakeupState = new AtomicReference();
    }

    @Override // com.obric.assistant.interaction.api.IWindowEffects
    public WeakUpState getValidWakeUpState() {
        if ((SystemClock.elapsedRealtime() - this.setWakeupStateTime.get()) < 1000) goto L7;
        return null;
    L7:
        return this.wakeupState.get();
    }

    @Override // com.obric.assistant.interaction.api.IWindowEffects
    public void setWakeupState(WeakUpState r4) {
        Intrinsics.checkNotNullParameter(r4, "weakUpState");
        this.setWakeupStateTime.set(SystemClock.elapsedRealtime());
        this.wakeupState.set(r4);
    }

    @Override // com.obric.assistant.interaction.api.IWindowEffects
    public void startActivateEffect(boolean r4) {
        FLogger.a.i(TAG, "startActivateEffect: withRipple = " + r4);
        t9a.b.b().d();
        aaa.c.a.startActivateEffect(r4);
    }
}
