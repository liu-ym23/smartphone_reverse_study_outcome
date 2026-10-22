package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final JSONObject a;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        this.a.remove("recording_id");
        return this.a;
    }

    public d() {
        this.a = new JSONObject();
    }

    public final void f(JSONObject r5) {
        if (r5 != null) goto L16;
        return;
    L16:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Iterator<String> r1 = r5.keys();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();     // Catch: Throwable -> L10
        this.a.put(r2, r5.opt(r2));     // Catch: Throwable -> L10
        goto L6
    L8:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L19;
        lvb.a.b("MmRecordingTrackerParams", "[putAll] error:" + r7);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        this.a.put(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }

    public final void c(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        this.a.put(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }

    public final void d(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        this.a.put(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        this.a.put(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }
}
