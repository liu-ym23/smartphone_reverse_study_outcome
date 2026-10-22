package com.obric.sva.framework.impl;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Handler;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.framework.api.ISvaFramework;
import com.obric.sva.framework.impl.internal.ObricFrameworkKt;
import com.obric.sva.framework.impl.internal.PowerUpWrapper;
import com.obric.sva.framework.log.AiagentLog;
import com.obric.sva.framework.wrapper.ActivityTaskManagerWrapper;
import com.obric.sva.framework.wrapper.AudioManagerWrapper$AudioServerStateCallbackWrapper;
import com.obric.sva.framework.wrapper.IVoiceInteractionManagerServiceWrapper;
import com.obric.sva.framework.wrapper.IdentityWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerModuleWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper$ModulePropertiesWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper$StatusListenerWrapper;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J*\u0010\u0019\u001a\u00020\n2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J0\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000203H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u000203H\u0016J\b\u0010:\u001a\u000203H\u0016J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016¨\u0006="}, d2 = {"Lcom/obric/sva/framework/impl/SvaFrameworkImpl;", "Lcom/obric/sva/framework/api/ISvaFramework;", "<init>", "()V", "start", "", "setInternalCapturePresetExt", "Landroid/media/AudioAttributes$Builder;", "builder", "preset", "", "getInitialApplication", "Landroid/content/Context;", "shareAudioHistoryExt", "recorder", "Landroid/media/AudioRecord;", "pkg", "", "offsetTime", "", "getActivityTaskManager", "Lcom/obric/sva/framework/wrapper/ActivityTaskManagerWrapper;", "context", "IVoiceInteractionManagerService_AsInterface", "Lcom/obric/sva/framework/wrapper/IVoiceInteractionManagerServiceWrapper;", "listModulesAsOriginator", "modules", "Ljava/util/ArrayList;", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$ModulePropertiesWrapper;", "Lkotlin/collections/ArrayList;", "originatorIdentity", "Lcom/obric/sva/framework/wrapper/IdentityWrapper;", "attachModuleAsOriginator", "Lcom/obric/sva/framework/wrapper/SoundTriggerModuleWrapper;", "moduleId", "listener", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$StatusListenerWrapper;", "handler", "Landroid/os/Handler;", "setAudioServerStateCallback", "audioManager", "Landroid/media/AudioManager;", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Lcom/obric/sva/framework/wrapper/AudioManagerWrapper$AudioServerStateCallbackWrapper;", "clearAudioServerStateCallback", "powerUpScreen", "packageName", "resetPowerUpMode", "powerDown", "", "startPowerUpTimer", "stopPowerUpTimer", "resetPowerUpAsync", "powerOff", "setPowerUpState", "state", "getPowerUpState", "setPowerUpHandler", "Companion", "impl_release"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SvaFrameworkImpl implements ISvaFramework {
    public static final Companion Companion = null;
    public static final String TAG = "SVA-SvaFrameworkImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/framework/impl/SvaFrameworkImpl$Companion;", "", "<init>", "()V", "TAG", "", "impl_release"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
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

    @Override // com.obric.sva.framework.api.ISvaFramework
    public Context getInitialApplication() {
        AiagentLog.i(TAG, "getInitialApplication");
        return ObricFrameworkKt.getInitialApplication();
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public boolean getPowerUpState() {
        return PowerUpWrapper.INSTANCE.getState();
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void start() {
        AiagentLog.i(TAG, "start");
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void startPowerUpTimer() {
        PowerUpWrapper.INSTANCE.startPowerUpTimer();
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void stopPowerUpTimer() {
        PowerUpWrapper.INSTANCE.stopPowerUpTimer();
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public IVoiceInteractionManagerServiceWrapper IVoiceInteractionManagerService_AsInterface() {
        return ObricFrameworkKt.IVoiceInteractionManagerService_AsInterface();
    }

    public SvaFrameworkImpl() {
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void clearAudioServerStateCallback(AudioManager r1) {
        ObricFrameworkKt.clearAudioServerStateCallback(r1);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public ActivityTaskManagerWrapper getActivityTaskManager(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AiagentLog.i(TAG, "getActivityTaskManager");
        return ObricFrameworkKt.getActivityTaskManager(r3);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void resetPowerUpAsync(boolean r2) {
        PowerUpWrapper.INSTANCE.resetPowerAsync(r2);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void resetPowerUpMode(boolean r1) {
        PowerUpWrapper.resetPowerUpMode(r1);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void setPowerUpHandler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        PowerUpWrapper.INSTANCE.setHandler(r2);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void setPowerUpState(boolean r2) {
        PowerUpWrapper.INSTANCE.setState(r2);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public int listModulesAsOriginator(ArrayList<SoundTriggerWrapper$ModulePropertiesWrapper> r3, IdentityWrapper r4) {
        Intrinsics.checkNotNullParameter(r3, "modules");
        AiagentLog.i(TAG, "listModulesAsOriginator");
        return ObricFrameworkKt.listModulesAsOriginator(r3, r4);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void powerUpScreen(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        PowerUpWrapper.powerUpScreen(r2, r3);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public AudioAttributes.Builder setInternalCapturePresetExt(AudioAttributes.Builder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        AiagentLog.i(TAG, "setInternalCapturePresetExt " + r4);
        return ObricFrameworkKt.setInternalCapturePresetExt(r3, r4);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void setAudioServerStateCallback(AudioManager r2, Executor r3, AudioManagerWrapper$AudioServerStateCallbackWrapper r4) {
        Intrinsics.checkNotNullParameter(r3, "executor");
        Intrinsics.checkNotNullParameter(r4, "stateCallback");
        ObricFrameworkKt.setAudioServerStateCallback(r2, r3, r4);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public void shareAudioHistoryExt(AudioRecord r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "recorder");
        Intrinsics.checkNotNullParameter(r3, "pkg");
        ObricFrameworkKt.shareAudioHistoryExt(r2, r3, r4);
    }

    @Override // com.obric.sva.framework.api.ISvaFramework
    public SoundTriggerModuleWrapper attachModuleAsOriginator(int r3, SoundTriggerWrapper$StatusListenerWrapper r4, Handler r5, IdentityWrapper r6) {
        AiagentLog.i(TAG, "attachModuleAsOriginator " + r3 + " -> " + r4 + " -> " + r6);
        return ObricFrameworkKt.attachModuleAsOriginator(r3, r4, r5, r6);
    }
}
