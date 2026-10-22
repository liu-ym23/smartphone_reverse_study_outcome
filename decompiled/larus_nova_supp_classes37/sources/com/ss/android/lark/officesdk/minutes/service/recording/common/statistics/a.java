package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.utils.e0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.a$a, reason: collision with other inner class name */
    public static final class C0048a {
    }

    static {
    }

    public a(MinutesUCCImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "userContext");
        this.a = r2;
    }

    public final b a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "hardwareUniqueId");
        Object r2 = null;
        String r0 = this.a.H().getString("minutes_hardware_audio_feature_status_v1_" + r6, null);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L24;
        return null;
    L24:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Gson r4 = e0.a;     // Catch: Throwable -> L13
        Object r5 = Result.constructor-impl((b) e0.a(r0, b.class));     // Catch: Throwable -> L13
    L15:
        Throwable r7 = Result.exceptionOrNull-impl(r5);
        if (r7 == null) goto L19;
        lvb.a.b("MmD1204RecordingEventLocalStorage", "[get] failed, keyHash=" + r6.hashCode() + ", error=" + r7);
    L19:
        if (Result.isFailure-impl(r5) == true) goto L23;
        r2 = r5;
    L23:
        return (b) r2;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void b(b r5) {
        Intrinsics.checkNotNullParameter(r5, "metadata");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        String r2 = e0.c(r5);     // Catch: Throwable -> L8
        if (r2 == null) goto L7;
        this.a.H().putString("minutes_hardware_audio_feature_status_v1_" + r5.a, r2);     // Catch: Throwable -> L8
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L15;
        lvb.a.b("MmD1204RecordingEventLocalStorage", "[put] failed, keyHash=" + r5.a.hashCode() + ", error=" + r3);
        return;
    L15:
        return;
    L7:
        throw new IllegalStateException("serialize metadata returned null".toString());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "hardwareUniqueId");
        this.a.H().remove("minutes_hardware_audio_feature_status_v1_" + r4);
    }
}
