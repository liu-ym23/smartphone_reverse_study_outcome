package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.f;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qub.e;
import qub.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements b {
    public final Function0<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> a;
    public final Function0<MmRecordingUILaunchMode> b;
    public final Function0<FragmentManager> c;
    public final Function0<MmRecordingSession> d;
    public final Function0<String> e;

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.b
    public final boolean w() {
        Intrinsics.checkNotNullParameter("MmStandaloneAIInterpretationLanguagePanel", "id");
        boolean r0 = a(e.class);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        int r2 = f.a;     // Catch: Throwable -> L5
        f.a((com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.a.invoke(), (MmRecordingUILaunchMode) this.b.invoke()).T((FragmentManager) this.c.invoke());     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L10;
        int r5 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "slotDismissPanel", "resolved provider failed e=" + r4, (String) this.e.invoke());
    L10:
        boolean r6 = Result.isSuccess-impl(r3);
        if (r0 == true) goto L13;
        int r7 = bwb.b.a;
        bwb.b.h(MmUiLogScene.RECORDING, "slotDismissPanel", "host provider missing", (String) this.e.invoke());
    L13:
        if (r6 == false) goto L16;
        if (r0 == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final <T extends IOfficeSDKProtocol> boolean a(Class<T> r2) {
        if (((com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.a.invoke()).u(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.b
    public final boolean v(rub.d r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        boolean r0 = a(e.class);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        int r2 = f.a;     // Catch: Throwable -> L5
        f.a((com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.a.invoke(), (MmRecordingUILaunchMode) this.b.invoke()).w((FragmentManager) this.c.invoke(), r7);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r8);
        if (r3 == null) goto L10;
        int r4 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "slotShowPanel", "resolved provider failed e=" + r3, (String) this.e.invoke());
    L10:
        boolean r9 = Result.isSuccess-impl(r8);
        if (r0 == true) goto L13;
        int r5 = bwb.b.a;
        bwb.b.h(MmUiLogScene.RECORDING, "slotShowPanel", "host provider missing", (String) this.e.invoke());
    L13:
        if (r9 == false) goto L16;
        if (r0 == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.b
    public final boolean u(Context r6, rub.e r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "config");
        boolean r0 = a(h.class);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        int r2 = f.a;     // Catch: Throwable -> L5
        f.c((com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.a.invoke(), (MmRecordingUILaunchMode) this.b.invoke()).u(r6, r7);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L10;
        int r3 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "slotShowToast", "resolved provider failed e=" + r9, (String) this.e.invoke());
    L10:
        boolean r10 = Result.isSuccess-impl(r8);
        if (r0 == true) goto L13;
        int r11 = bwb.b.a;
        bwb.b.h(MmUiLogScene.RECORDING, "slotShowToast", "host provider missing", (String) this.e.invoke());
    L13:
        if (r10 == false) goto L16;
        if (r0 == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<? extends com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> r2, Function0<? extends MmRecordingUILaunchMode> r3, Function0<? extends FragmentManager> r4, Function0<MmRecordingSession> r5, Function0<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApiProvider");
        Intrinsics.checkNotNullParameter(r3, "uiLaunchModeProvider");
        Intrinsics.checkNotNullParameter(r4, "fragmentManagerProvider");
        Intrinsics.checkNotNullParameter(r5, "recordingSessionProvider");
        Intrinsics.checkNotNullParameter(r6, "logDetailProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
