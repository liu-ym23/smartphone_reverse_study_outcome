package com.obric.sva.sdk.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.AsyncTask;
import androidx.core.content.ContextCompat;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\r\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupAudioServerMonitor;", "", "context", "Landroid/content/Context;", "callback", "Lcom/obric/sva/sdk/audio/WakeupAudioServerMonitor$Callback;", "<init>", "(Landroid/content/Context;Lcom/obric/sva/sdk/audio/WakeupAudioServerMonitor$Callback;)V", "appContext", "kotlin.jvm.PlatformType", "audioManager", "Landroid/media/AudioManager;", "audioServerStateCallback", "com/obric/sva/sdk/audio/WakeupAudioServerMonitor$audioServerStateCallback$1", "Lcom/obric/sva/sdk/audio/WakeupAudioServerMonitor$audioServerStateCallback$1;", "register", "", "clear", "Callback", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WakeupAudioServerMonitor {
    public static final Companion Companion = null;
    private static final String PERMISSION_MODIFY_AUDIO_ROUTING = "android.permission.MODIFY_AUDIO_ROUTING";
    private static final String PERMISSION_MODIFY_PHONE_STATE = "android.permission.MODIFY_PHONE_STATE";
    private static final String TAG = "WakeupAudioServerMonitor";
    private final Context appContext;
    private final AudioManager audioManager;
    private final WakeupAudioServerMonitor$audioServerStateCallback$1 audioServerStateCallback;
    private final Callback callback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupAudioServerMonitor$Callback;", "", "onAudioServerUp", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public interface Callback {
        void onAudioServerUp();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupAudioServerMonitor$Companion;", "", "<init>", "()V", "TAG", "", "PERMISSION_MODIFY_AUDIO_ROUTING", "PERMISSION_MODIFY_PHONE_STATE", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
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

    public final void clear() {
        AudioManager r0 = this.audioManager;
        if (r0 != null) goto L6;
        LogUtils.d(TAG, "clear ignored, audioManager is null", new Object[0]);
        return;
    L6:
        WakeupAudioServerCallbackRegistrar.clear(r0);
    }

    public final void register() {
        AudioManager r0 = this.audioManager;
        boolean r1 = false;
        if (r0 != null) goto L7;
        LogUtils.d(TAG, "register ignored, audioManager is null", new Object[0]);
        return;
    L7:
        if (ContextCompat.checkSelfPermission(this.appContext, PERMISSION_MODIFY_AUDIO_ROUTING) != 0) goto L9;
        boolean r2 = true;
    L11:
        if (ContextCompat.checkSelfPermission(this.appContext, PERMISSION_MODIFY_PHONE_STATE) != 0) goto L13;
        r1 = true;
    L13:
        if (r2 == true) goto L15;
        if (r1 == true) goto L15;
        return;
    L15:
        WakeupAudioServerCallbackRegistrar.register(r0, AsyncTask.THREAD_POOL_EXECUTOR, this.audioServerStateCallback);
        return;
    L9:
        r2 = false;
        goto L11
    }

    public static final /* synthetic */ AudioManager access$getAudioManager$p(WakeupAudioServerMonitor r0) {
        return r0.audioManager;
    }

    public static final /* synthetic */ Callback access$getCallback$p(WakeupAudioServerMonitor r0) {
        return r0.callback;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.obric.sva.sdk.audio.WakeupAudioServerMonitor$audioServerStateCallback$1] */
    public WakeupAudioServerMonitor(Context r2, Callback r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.callback = r3;
        Context r4 = r2.getApplicationContext();
        this.appContext = r4;
        Object r5 = r4.getSystemService("audio");
        if ((r5 instanceof AudioManager) == false) goto L5;
        AudioManager r6 = (AudioManager) r5;
    L6:
        this.audioManager = r6;
        this.audioServerStateCallback = new WakeupAudioServerMonitor$audioServerStateCallback$1(this);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
