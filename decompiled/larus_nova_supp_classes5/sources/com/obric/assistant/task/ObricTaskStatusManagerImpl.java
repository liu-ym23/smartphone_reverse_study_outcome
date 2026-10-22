package com.obric.assistant.task;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.settings.LockedUseAuthSettingItem;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"Lcom/obric/assistant/task/ObricTaskStatusManagerImpl;", "Lcom/obric/assistant/task/IObricTaskStatusManager;", "<init>", "()V", "init", "", "isComplexSessionAuthPass", "", "isDeviceLocked", "isBiometricPass", "isVoicePrintPass", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskStatusManagerImpl implements IObricTaskStatusManager {
    static {
    }

    public ObricTaskStatusManagerImpl() {
    }

    public static boolean b() {
        ISessionAuthenticationService r0 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r0 == null) goto L9;
        i1 r1 = r0.o();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean a() {
        IKeyguardState r0 = (IKeyguardState) ServiceManager.get().getService(IKeyguardState.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        FLogger.a.i("ObricTaskStatusManagerImpl", "isTaskQuerySessionAuthPass: is not locked");
        return true;
    L12:
        int r2 = LockedUseAuthSettingItem.AUTO_GUI.getAuthType();
        if (r2 == 0) goto L34;
        if (r2 != 1) goto L16;
        FLogger.a.i("ObricTaskStatusManagerImpl", "isTaskQuerySessionAuthPass: VOICE_PRINT");
        ISessionAuthenticationService r3 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r3 == null) goto L29;
        i1 r4 = r3.k();
        if (r4 == null) goto L29;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L32;
    L33:
        return true;
    L32:
        if (b() == true) goto L33;
        return false;
    L29:
        r5 = false;
        goto L30
    L16:
        if (r2 != 2) goto L18;
        FLogger.a.i("ObricTaskStatusManagerImpl", "isTaskQuerySessionAuthPass: ALWAYS");
        goto L33
    L18:
        if (r2 == 3) goto L20;
        FLogger.a.w("ObricTaskStatusManagerImpl", "isTaskQuerySessionAuthPass: unknown auth type: " + r2);
        return false;
    L20:
        FLogger.a.i("ObricTaskStatusManagerImpl", "isTaskQuerySessionAuthPass: NOT_ALLOWED");
        return false;
    L34:
        FLogger.a.i("ObricTaskStatusManagerImpl", "isTaskQuerySessionAuthPass: SYSTEM_AUTHENTICATION");
        return b();
    L5:
        if (r0.isDeviceLocked() != true) goto L7;
        r1 = true;
        goto L9
    }

    public final void init() {
        ObricTaskStatusManager.a.getClass();
        if (ObricTaskStatusManager.g.compareAndSet(false, true) == false) goto L6;
        FLogger.a.i("ObricTaskStatusManager", "init");
        BuildersKt.launch$default(ObricTaskStatusManager.h, null, null, new ObricTaskStatusManager$init$1(null), 3, null);
        return;
    }
}
