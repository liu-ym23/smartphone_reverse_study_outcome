package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int g = 0;
    public final Function0<MmRecordingViewModel> a;
    public final Function0<MmRecordingUILaunchMode> b;
    public final Function0<FragmentActivity> c;
    public final Function0<Context> d;
    public final Function1<CloseReason, Unit> e;
    public final Function0<String> f;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        e r0 = e.a;
        MmRecordingUILaunchMode r1 = (MmRecordingUILaunchMode) this.b.invoke();
        r0.getClass();
        e.b(r1).getCapability().d();
        return false;
    }

    public final boolean a(boolean r7, Function0<Unit> r8) {
        MmRecordingViewModel r1 = (MmRecordingViewModel) this.a.invoke();
        MmRecordingSession r2 = r1.getSession();
        b();
        boolean r3 = r1.isRecordingActiveForFloat();
        int r4 = bwb.b.a;
        MmUiLogScene r5 = MmUiLogScene.FLOAT;
        StringBuilder r6 = new StringBuilder("skip show, support=false, active=");
        r6.append(r3);
        r6.append(", session=");
        if (r2 == null) goto L5;
        boolean r9 = true;
    L6:
        r6.append(r9);
        bwb.b.f(r5, "handleUserLeaveRecordingPage", r6.toString(), (String) this.f.invoke());
        if (r7 == false) goto L10;
        this.e.invoke(CloseReason.USER_CLOSE);
        return true;
    L10:
        return false;
    L5:
        r9 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<MmRecordingViewModel> r2, Function0<? extends MmRecordingUILaunchMode> r3, Function0<? extends FragmentActivity> r4, Function0<? extends Context> r5, Function1<? super CloseReason, Unit> r6, Function0<String> r7) {
        Intrinsics.checkNotNullParameter(r2, "viewModelProvider");
        Intrinsics.checkNotNullParameter(r3, "uiLaunchModeProvider");
        Intrinsics.checkNotNullParameter(r4, "activityProvider");
        Intrinsics.checkNotNullParameter(r5, "contextProvider");
        Intrinsics.checkNotNullParameter(r6, "closePage");
        Intrinsics.checkNotNullParameter(r7, "logDetailProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
