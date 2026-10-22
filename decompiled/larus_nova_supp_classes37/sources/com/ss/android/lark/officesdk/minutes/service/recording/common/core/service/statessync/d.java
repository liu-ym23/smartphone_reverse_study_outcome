package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.google.gson.Gson;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.e0;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r6, e r7) {
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r7, "localStorage");
        String r1 = r7.t(r6);
        String r2 = r7.u(r6);
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        r7.a.H().remove("minutes_recording_v2_local_state_".concat(r6));
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Map<String, String> r4 = r7.c;     // Catch: Throwable -> L11
        if (r4 != null) goto L6;
    L8:
        Unit r5 = null;
    L9:
        Result.constructor-impl(r5);     // Catch: Throwable -> L11
    L13:
        r7.a(r6);
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        lvb.a.e(r7.b, "[sourceSessionKey] clear, meetingId:".concat(r6));
        r7.a.H().remove("minutes_recording_v2_source_session_key_prefix".concat(r6));
        r7.d(r6);
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        r7.a.H().remove("minutes_recording_v2_recording_id_prefix".concat(r6));
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        r7.a.H().remove("minutes_recording_v2_route_prefix".concat(r6));
        r7.c(r6);
        r7.e(r6);
        r7.b(r6);
        r7.f(r6);
        if ((!StringsKt.isBlank(r2)) == false) goto L17;
        r7.c(r2);
        r7.e(r2);
        r7.d(r2);
        r7.g(r2);
    L17:
        if ((!StringsKt.isBlank(r1)) == true) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r1, r6) == true) goto L25;
        r7.e(r1);
        return;
    L25:
        return;
    L6:
        if (r4.remove(r6) == null) goto L8;
        KVRepo r8 = r7.a.H();     // Catch: Throwable -> L11
        Gson r9 = e0.a;     // Catch: Throwable -> L11
        r8.putString("minutes_recording_v2_meeting_map_prefix", e0.c(r7.c));     // Catch: Throwable -> L11
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
