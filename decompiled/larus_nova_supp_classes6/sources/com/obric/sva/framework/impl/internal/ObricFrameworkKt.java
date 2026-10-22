package com.obric.sva.framework.impl.internal;

import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.content.Context;
import android.hardware.soundtrigger.SoundTrigger;
import android.hardware.soundtrigger.SoundTriggerModule;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.permission.Identity;
import android.os.Build;
import android.os.Handler;
import android.os.ServiceManager;
import com.android.internal.app.IVoiceInteractionManagerService;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.framework.log.AiagentLog;
import com.obric.sva.framework.wrapper.ActivityTaskManagerWrapper;
import com.obric.sva.framework.wrapper.AudioManagerWrapper$AudioServerStateCallbackWrapper;
import com.obric.sva.framework.wrapper.IVoiceInteractionManagerServiceWrapper;
import com.obric.sva.framework.wrapper.IdentityWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerModuleWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper$ModulePropertiesWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper$StatusListenerWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007J*\u0010\u0019\u001a\u00020\n2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J0\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\"\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0007J\u0012\u0010.\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/sva/framework/impl/internal/ObricFrameworkKt;", "", "<init>", "()V", "TAG", "", "setInternalCapturePresetExt", "Landroid/media/AudioAttributes$Builder;", "builder", "preset", "", "getInitialApplication", "Landroid/content/Context;", "shareAudioHistoryExt", "", "record", "Landroid/media/AudioRecord;", "pkg", "offsetTime", "", "getActivityTaskManager", "Lcom/obric/sva/framework/wrapper/ActivityTaskManagerWrapper;", "context", "IVoiceInteractionManagerService_AsInterface", "Lcom/obric/sva/framework/wrapper/IVoiceInteractionManagerServiceWrapper;", "listModulesAsOriginator", "modules", "Ljava/util/ArrayList;", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$ModulePropertiesWrapper;", "Lkotlin/collections/ArrayList;", "originatorIdentity", "Lcom/obric/sva/framework/wrapper/IdentityWrapper;", "attachModuleAsOriginator", "Lcom/obric/sva/framework/wrapper/SoundTriggerModuleWrapper;", "moduleId", "listener", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$StatusListenerWrapper;", "handler", "Landroid/os/Handler;", "setAudioServerStateCallback", "audioManager", "Landroid/media/AudioManager;", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Lcom/obric/sva/framework/wrapper/AudioManagerWrapper$AudioServerStateCallbackWrapper;", "clearAudioServerStateCallback", "impl_release"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ObricFrameworkKt {
    public static final ObricFrameworkKt INSTANCE = null;
    public static final String TAG = "ObricFrameworkKt";

    static {
        INSTANCE = new ObricFrameworkKt();
    }

    private ObricFrameworkKt() {
    }

    @JvmStatic
    public static final Context getInitialApplication() {
        AiagentLog.d(TAG, "getInitialApplication");
        return AppGlobals.getInitialApplication();
    }

    @JvmStatic
    public static final IVoiceInteractionManagerServiceWrapper IVoiceInteractionManagerService_AsInterface() {
        return new IVoiceInteractionManagerServiceWrapper(IVoiceInteractionManagerService.Stub.asInterface(ServiceManager.getService("voiceinteraction")));
    }

    @JvmStatic
    public static final void clearAudioServerStateCallback(AudioManager r0) {
        if (r0 == null) goto L5;
        r0.clearAudioServerStateCallback();
        return;
    }

    @JvmStatic
    public static final ActivityTaskManagerWrapper getActivityTaskManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Object r3 = r2.getSystemService("activity_task");
        if ((r3 instanceof ActivityTaskManager) == true) goto L7;
        return null;
    L7:
        return new ActivityTaskManagerWrapper((ActivityTaskManager) r3);
    L8:
        return null;
    }

    @JvmStatic
    public static final int listModulesAsOriginator(ArrayList<SoundTriggerWrapper$ModulePropertiesWrapper> r3, IdentityWrapper r4) {
        Intrinsics.checkNotNullParameter(r3, "modules");
        ArrayList r0 = new ArrayList(r3.size());
        if (r4 == null) goto L5;
        Identity r5 = r4.identity;
    L6:
        Intrinsics.checkNotNull(r5);
        int r6 = SoundTrigger.listModulesAsOriginator(r0, r5);
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r3.add(new SoundTriggerWrapper$ModulePropertiesWrapper((SoundTrigger.ModuleProperties) r1.next()));
        goto L8
    L10:
        return r6;
    L5:
        r5 = null;
        goto L6
    }

    @JvmStatic
    public static final AudioAttributes.Builder setInternalCapturePresetExt(AudioAttributes.Builder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        AiagentLog.d(TAG, "setInternalCapturePresetExt " + r3);
        r2.setInternalCapturePreset(r3);
        return r2;
    }

    @JvmStatic
    public static final void setAudioServerStateCallback(AudioManager r1, Executor r2, AudioManagerWrapper$AudioServerStateCallbackWrapper r3) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        Intrinsics.checkNotNullParameter(r3, "stateCallback");
        if (r1 == null) goto L6;
        r1.setAudioServerStateCallback(r2, r3.mAudioServerStateCallback);
        return;
    }

    @JvmStatic
    public static final void shareAudioHistoryExt(AudioRecord r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "record");
        Intrinsics.checkNotNullParameter(r3, "pkg");
        AiagentLog.d(TAG, "shareAudioHistoryExt " + r3 + " -> " + r4);
        r2.shareAudioHistory(r3, r4);
    }

    @JvmStatic
    public static final SoundTriggerModuleWrapper attachModuleAsOriginator(int r2, SoundTriggerWrapper$StatusListenerWrapper r3, Handler r4, IdentityWrapper r5) {
        if (r3 == null) goto L5;
        SoundTrigger.StatusListener r1 = r3.statusListener;
    L6:
        if (r1 == null) goto L23;
        if (r5 == null) goto L9;
        Identity r6 = r5.identity;
    L10:
        if (r6 == null) goto L25;
        if (r3 == null) goto L14;
        SoundTrigger.StatusListener r7 = r3.statusListener;
    L15:
        Intrinsics.checkNotNull(r7);
        if (r5 == null) goto L18;
        Identity r8 = r5.identity;
    L19:
        Intrinsics.checkNotNull(r8);
        SoundTriggerModule r9 = SoundTrigger.attachModuleAsOriginator(r2, r7, r4, r8);
        if (r9 != null) goto L22;
        return null;
    L22:
        return new SoundTriggerModuleWrapper(r9);
    L18:
        r8 = null;
        goto L19
    L14:
        r7 = null;
        goto L15
    L25:
        return null;
    L9:
        r6 = null;
        goto L10
    L23:
        return null;
    L5:
        r1 = null;
        goto L6
    }
}
