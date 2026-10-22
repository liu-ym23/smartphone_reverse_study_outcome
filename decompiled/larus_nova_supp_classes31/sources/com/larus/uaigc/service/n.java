package com.larus.uaigc.service;

import com.larus.common_ui.video.VideoPlayView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n implements kh8.a {
    public n() {
    }

    public final Integer a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        return null;
    }

    public final String b() {
        return null;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
    }

    public final void d(String r1, VideoPlayView r2) {
        Intrinsics.checkNotNullParameter(r1, "vid");
    }

    public final void e(String r1, Integer r2) {
    }

    public final void g() {
    }

    public final MutableSharedFlow h() {
        return SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final MutableSharedFlow i() {
        return SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final void j(String r1, boolean r2) {
    }

    public final Object f(Continuation<? super Unit> r1) {
        return Unit.INSTANCE;
    }
}
