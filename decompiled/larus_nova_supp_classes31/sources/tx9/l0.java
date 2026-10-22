package tx9;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l0 {
    public static final ConcurrentHashMap<String, Long> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        a.put(r3, Long.valueOf(System.currentTimeMillis()));
    }

    public static final void c(String r8, String r9, boolean r10, Long r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r9, "taskId");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        Long r13 = a.remove(r9);     // Catch: Throwable -> L17
        if (r13 == null) goto L15;
        long r2 = r13.longValue();     // Catch: Throwable -> L17
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L17
        if (r3 <= r2) goto L15;
        com.larus.platform.service.g r14 = com.larus.platform.service.g.a;     // Catch: Throwable -> L17
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L17
        if (r10 == false) goto L10;
        int r15 = 1;
    L11:
        r6.put("is_success", r15);     // Catch: Throwable -> L17
        if (r12 == null) goto L14;
        r6.put("error_code", r12.intValue());     // Catch: Throwable -> L17
    L14:
        r6.put("scene", r8);     // Catch: Throwable -> L17
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L17
        r17.put("file_size", r11);     // Catch: Throwable -> L17
        r17.put("duration", r3 - r2);     // Catch: Throwable -> L17
        r14.monitorEventForSlardar("avatar_video_upload_result", r6, r17, new JSONObject());     // Catch: Throwable -> L17
        goto L15
    L10:
        r15 = 0;
    L15:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final void a(String r7, String r8, boolean r9, Integer r10, Long r11, String r12) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r8, "taskId");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        Long r13 = a.remove(r8);     // Catch: Throwable -> L17
        if (r13 == null) goto L15;
        long r2 = r13.longValue();     // Catch: Throwable -> L17
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L17
        if (r3 <= r2) goto L15;
        com.larus.platform.service.o r14 = com.larus.platform.service.o.a;     // Catch: Throwable -> L17
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L17
        r6.put("scene", r7);     // Catch: Throwable -> L17
        if (r9 == false) goto L10;
        int r15 = 1;
    L11:
        r6.put("is_success", r15);     // Catch: Throwable -> L17
        if (r10 == null) goto L14;
        r6.put("error_code", r10.intValue());     // Catch: Throwable -> L17
    L14:
        r6.put("duration", r3 - r2);     // Catch: Throwable -> L17
        r6.putOpt("file_size", r11);     // Catch: Throwable -> L17
        r6.putOpt("file_type", r12);     // Catch: Throwable -> L17
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r14.reportEvent("creation_image_upload_result", r6);     // Catch: Throwable -> L17
        goto L15
    L10:
        r15 = 0;
    L15:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void b(String r8, String r9, boolean r10, Integer r11, Long r12, String r13, int r14) {
        if ((r14 & 8) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r14 & 16) == 0) goto L9;
        Long r6 = null;
    L11:
        if ((r14 & 32) == 0) goto L13;
        String r7 = null;
    L14:
        a(r8, r9, r10, r5, r6, r7);
        return;
    L13:
        r7 = r13;
        goto L14
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }
}
