package com.obric.aikernel.middleware.impl.obric;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.obric.aiagent.assistant.utils.ObricAppStatus;
import com.obric.aiagent.assistant.utils.ObricAppStatusHelper;
import com.obric.aiagent.assistant.utils.ReflectHiddenRoleMonitor;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.obric.IAssistantStateService;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AssistantStateService implements IAssistantStateService {
    public static final AssistantStateService INSTANCE = null;
    private static final String TAG = "AssistantStateService";

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4563a = null;

        static {
            int[] r10 = new int[ObricAppStatus.values().length];
            r10[ObricAppStatus.NotRoleAssistant.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[ObricAppStatus.AppDisabledError.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[ObricAppStatus.NoInstalledError.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f4563a = r10;
        }
    }

    public static final class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 == null) goto L25;
            Integer r12 = Integer.valueOf(r11.getIntExtra("android.intent.extra.UID", -1));
            int r13 = 0;
            if (r12.intValue() <= 0) goto L6;
            boolean r14 = true;
        L7:
            String r15 = null;
            if (r14 == true) goto L11;
            r12 = null;
        L11:
            if (r12 == null) goto L26;
            String[] r16 = AppContext.INSTANCE.getContext().getPackageManager().getPackagesForUid(r12.intValue());
            if (r16 == null) goto L20;
            int r17 = r16.length;
        L15:
            if (r13 >= r17) goto L20;
            String r18 = r16[r13];
            if (Intrinsics.areEqual(r18, IAIKernelManager.PACKAGE_NAME_ASSIST) == true) goto L18;
            r13 = r13 + 1;
            goto L15
        L18:
            r15 = r18;
        L20:
            if (r15 == null) goto L27;
            AIKLog.INSTANCE.i(AssistantStateService.TAG, "registerAssistantPackageState changed by " + r11);
            AssistantStateService.access$checkAssistantState(AssistantStateService.INSTANCE);
            return;
        L27:
            return;
        L26:
            return;
        L6:
            r14 = false;
            goto L7
        }
    }

    public static final class c implements com.obric.aiagent.assistant.utils.b {
        c() {
        }

        @Override // com.obric.aiagent.assistant.utils.b
        public void a(String r10, String r11) {
            AIKLog.INSTANCE.i(AssistantStateService.TAG, "onAssistantSwitched " + r10 + " to " + r11);
            if (Intrinsics.areEqual(r11, IAIKernelManager.PACKAGE_NAME_ASSIST) == true) goto L6;
            AssistantStateService.access$onAssistantNotAvailable(AssistantStateService.INSTANCE);
            return;
        }
    }

    static {
        INSTANCE = new AssistantStateService();
    }

    private AssistantStateService() {
    }

    public static final /* synthetic */ void access$checkAssistantState(AssistantStateService r10) {
        r10.checkAssistantState();
    }

    public static final /* synthetic */ void access$onAssistantNotAvailable(AssistantStateService r10) {
        r10.onAssistantNotAvailable();
    }

    private final void checkAssistantState() {
        ObricAppStatus r10 = ObricAppStatusHelper.f4360a.a(AppContext.INSTANCE.getContext());
        int r11 = a.f4563a[r10.ordinal()];
        if (r11 != 1) goto L5;
    L9:
        onAssistantNotAvailable();
        return;
    L5:
        if (r11 == 2) goto L9;
        if (r11 == 3) goto L9;
        AIKLog.INSTANCE.d(TAG, "checkAssistantState ok: " + r10);
    }

    @JvmStatic
    public static final AssistantStateService getInst() {
        return INSTANCE;
    }

    private final boolean isEnableAssociateAssistantState() {
        return com.obric.aikernel.api.b.f4431a.a().i();
    }

    private final void onAssistantNotAvailable() {
        AIKLog.INSTANCE.i(TAG, "onAssistantNotAvailable start destroy!");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        ProcessService.INSTANCE.destroy();     // Catch: Throwable -> L5
        AppContext r11 = AppContext.INSTANCE;     // Catch: Throwable -> L5
        Object r12 = r11.getContext().getSystemService("activity");     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L5
        ActivityManager r13 = (ActivityManager) r12;     // Catch: Throwable -> L5
        Object r14 = Result.m32constructorimpl(r13.getClass().getMethod("forceStopPackage", new Class[]{String.class}).invoke(r13, new Object[]{r11.getPackageName()}));     // Catch: Throwable -> L5
    L7:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L13;
        AIKLog.INSTANCE.e(TAG, "onAssistantNotAvailable stop pkg failed: " + r15);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void registerAssistantPackageState() {
        AppContext r10 = AppContext.INSTANCE;
        Context r11 = r10.getContext();
        b r12 = new b();
        IntentFilter r13 = new IntentFilter();
        r13.addAction("android.intent.action.PACKAGE_CHANGED");
        r13.addAction("android.intent.action.PACKAGE_REMOVED");
        r13.addDataScheme("package");
        Unit r14 = Unit.INSTANCE;
        r11.registerReceiver(r12, r13, 2);
        ReflectHiddenRoleMonitor.f4362j.a(r10.getContext()).q(new c());
    }

    @Override // com.obric.aikernel.middleware.api.obric.IAssistantStateService
    public void init() {
        if (isEnableAssociateAssistantState() == false) goto L5;
        AIKLog.INSTANCE.i(TAG, "start init");
        registerAssistantPackageState();
        return;
    L5:
        AIKLog.INSTANCE.i(TAG, "do not need init");
    }
}
