package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingEntity;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final Fragment a;
    public final Function0<MmRecordingViewModel> b;
    public final Function0<Boolean> c;
    public final Function1<Boolean, Unit> d;
    public final Function0<MmRecordingEntity> e;
    public final Function0<UserSession> f;
    public final Function0<dwb.b> g;
    public final Function0<String> h;

    public b(MmRecordingFragment r2, Function0 r3, Function0 r4, Function1 r5, Function0 r6, Function0 r7, Function0 r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        Intrinsics.checkNotNullParameter(r3, "viewModelProvider");
        Intrinsics.checkNotNullParameter(r4, "shouldCheckDarkModeProvider");
        Intrinsics.checkNotNullParameter(r5, "handleDarkModeChange");
        Intrinsics.checkNotNullParameter(r6, "entityProvider");
        Intrinsics.checkNotNullParameter(r7, "userSessionProvider");
        Intrinsics.checkNotNullParameter(r8, "slotsConfigProvider");
        Intrinsics.checkNotNullParameter(r9, "logDetailProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
