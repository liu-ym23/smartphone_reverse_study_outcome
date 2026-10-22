package com.larus.video.impl.sdk.eventlog;

import com.larus.common.apphost.AppHost;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.platform.api.k4;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MediaEventLogReporter {
    public static final MediaEventLogReporter a = null;
    public static k4 b;
    public static PlayUploadStatus c;
    public static Job d;

    public MediaEventLogReporter() {
    }

    static {
        a = new MediaEventLogReporter();
        c = PlayUploadStatus.PAUSE;
    }

    public static void b(k4 r8, PlayUploadStatus r9) {
        Intrinsics.checkNotNullParameter(r9, "play");
        if (Intrinsics.areEqual(b, r8) == true) goto L5;
    L7:
        Job r0 = d;
        if (r0 == null) goto L10;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L10:
        b = r8;
        c = r9;
        d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MediaEventLogReporter$uploadEventLog$1(null), 3, null);
        return;
    L5:
        if (c != r9) goto L7;
    }

    public static final Object a(MediaEventLogReporter r15, k4 r16, PlayUploadStatus r17, Continuation r18) {
        r15.getClass();
        if ((r18 instanceof MediaEventLogReporter$doUpload$1) == false) goto L7;
        MediaEventLogReporter$doUpload$1 r2 = (MediaEventLogReporter$doUpload$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MediaEventLogReporter$doUpload$1 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L51:
        FLogger.a.d("MediaELR", "setEnvContext result: " + ((a) r1));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        JSONObject r6 = new JSONObject();
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
        if (r16 == null) goto L18;
        String r8 = r16.a;
        if (r8 == null) goto L18;
    L19:
        r6.put("scene", r8);
        if (r16 == null) goto L23;
        String r9 = r16.b;
        if (r9 == null) goto L23;
    L24:
        r6.put("title", r9);
        if (r16 == null) goto L28;
        String r10 = r16.c;
        if (r10 == null) goto L28;
    L29:
        r6.put("artist", r10);
        if (r16 == null) goto L33;
        String r11 = r16.d;
        if (r11 == null) goto L33;
    L34:
        r6.put("audio_id", r11);
        if (r16 == null) goto L40;
        String r12 = r16.f;
        if (r12 == null) goto L40;
        r7 = r12;
    L40:
        r6.put("message_id", r7);
        JSONObject r14 = new JSONObject();
        r14.put("timestamp", AppHost.a.getAppClock().currentTimeMillis());
        if (r16 == null) goto L47;
        String r0 = r16.e;
        if (r0 == null) goto L47;
        Long r19 = StringsKt.toLongOrNull(r0);
        if (r19 == null) goto L47;
        long r20 = r19.longValue();
    L48:
        r14.put("conversation_id", r20);
        r14.put("event_type", 3);
        r14.put("key", r17.getValue());
        r14.put("value", r6.toString());
        r13.label = 1;
        r1 = HttpExtKt.k("Basic", BizResponse.class, "/alice/message/event_log", r14, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L51;
        return r4;
    L47:
        r20 = 0;
    L33:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L28:
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L23:
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r2 = new MediaEventLogReporter$doUpload$1(r15, r18);
        goto L8
    }
}
