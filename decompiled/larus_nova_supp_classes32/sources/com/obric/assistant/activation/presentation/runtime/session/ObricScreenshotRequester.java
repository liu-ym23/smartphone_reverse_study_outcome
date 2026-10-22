package com.obric.assistant.activation.presentation.runtime.session;

import android.os.Build;
import android.os.Bundle;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.common.utils.i;
import com.obric.assistant.state.ISharedStateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import sna.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricScreenshotRequester {
    public static final ObricScreenshotRequester a = null;
    public static final CoroutineScope b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricAiKeyGestureAction.values().length];
            r0[ObricAiKeyGestureAction.PRESS_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ObricAiKeyGestureAction.SINGLE_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public ObricScreenshotRequester() {
    }

    static {
        a = new ObricScreenshotRequester();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void a(Bundle r7) {
        Intrinsics.checkNotNullParameter(r7, "args");
        i.a r1 = i.a("ObricScreenshotRequester_onShow");
        int r2 = r7.getInt("invocation_type", Integer.MIN_VALUE);     // Catch: Throwable -> L24
        if (r2 != 6) goto L7;
    L19:
        a.getClass();     // Catch: Throwable -> L24
        b("on_show", r2);     // Catch: Throwable -> L24
    L20:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L24
        if (r1 == null) goto L30;
        r1.a();
        return;
    L30:
        return;
    L7:
        if (r2 != 23) goto L9;
        a.getClass();     // Catch: Throwable -> L24
        b("dora_key_down", r2);     // Catch: Throwable -> L24
        goto L20
    L9:
        if (r2 == 26) goto L19;
        String r3 = r7.getString("REQUEST_FROM");     // Catch: Throwable -> L24
        String r9 = r7.getString("sessionName");     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(r3, "VOICE_ASSIST") == true) goto L13;
    L17:
        FLogger.a.i("ObricScreenshotRequester", "request_skipped: reason=unknown_invocation invocationType=" + r2 + " requestFrom=" + r3 + " sessionName=" + r9);     // Catch: Throwable -> L24
        goto L20
    L13:
        if (Intrinsics.areEqual(r9, "VOICE") == false) goto L15;
    L16:
        a.getClass();     // Catch: Throwable -> L24
        b("on_show", r2);     // Catch: Throwable -> L24
        goto L20
    L15:
        if (Intrinsics.areEqual(r9, "BREATH") == false) goto L17;
    L24:
        th = move-exception;
        if (r1 == null) goto L27;
        r1.a();
    L27:
        throw th;
    }

    public static void b(String r11, int r12) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        FLogger.a.w("ObricScreenshotRequester", "request_skipped: reason=unsupported_sdk trigger=".concat(r11));
        return;
    L6:
        ISharedStateService.a.getClass();
        ISharedStateService r0 = ISharedStateService.a.a();
        ISecPrivacyService r1 = (ISecPrivacyService) ServiceManager.get().getService(ISecPrivacyService.class);
        boolean r3 = true;
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r0 == null) goto L14;
        boolean r4 = Intrinsics.areEqual(r0.e(StateKey.KEY_DOUBAO_LOGIN_STATE), Boolean.TRUE);
    L15:
        h r5 = h.a;
        boolean r6 = h.a().getBoolean("auto_image_upload_enabled", false);
        if (r2 == false) goto L20;
        if (r4 == false) goto L20;
        if (r6 == false) goto L20;
    L21:
        FLogger.a.i("ObricScreenshotRequester", "request_state_received: trigger=" + r11 + " invocationType=" + r12 + " privacyAgreed=" + r2 + " loggedIn=" + r4 + " autoImageUploadEnabled=" + r6);
        BuildersKt.launch$default(b, null, null, new ObricScreenshotRequester$request$1(r11, r12, r3, null), 3, null);
        return;
    L20:
        r3 = false;
        goto L21
    L14:
        r4 = false;
        goto L15
    L9:
        if (r1.h() != true) goto L11;
        r2 = true;
        goto L12
    }
}
