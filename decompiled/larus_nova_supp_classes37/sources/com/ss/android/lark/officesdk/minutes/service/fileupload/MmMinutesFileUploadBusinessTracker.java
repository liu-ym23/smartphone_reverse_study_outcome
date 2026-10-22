package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmMinutesFileUploadBusinessTracker {
    public static final /* synthetic */ int c = 0;
    public final Set<String> a;
    public final Set<String> b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmMinutesFileUploadErrorCode.values().length];
            r0[MmMinutesFileUploadErrorCode.PRE_FILE_COUNT_EMPTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L84:
            r0[MmMinutesFileUploadErrorCode.PRE_FILE_COUNT_EXCEEDED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L98:
            r0[MmMinutesFileUploadErrorCode.FILE_TYPE_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L64:
            r0[MmMinutesFileUploadErrorCode.MEDIA_DURATION_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L68:
            r0[MmMinutesFileUploadErrorCode.FILE_SIZE_ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L76:
            r0[MmMinutesFileUploadErrorCode.FILE_READ_FAIL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L90:
            r0[MmMinutesFileUploadErrorCode.PRE_FILE_NOT_EXIST.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
        L72:
            r0[MmMinutesFileUploadErrorCode.NO_QUOTA.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
        L86:
            r0[MmMinutesFileUploadErrorCode.QUOTA_REQUEST_ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L39
        L88:
            r0[MmMinutesFileUploadErrorCode.PREPARE_REQUEST_ERROR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L40
        L56:
            r0[MmMinutesFileUploadErrorCode.DUPLICATE_IN_SERVER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L41
        L80:
            r0[MmMinutesFileUploadErrorCode.DRIVE_UPLOAD_REQUEST_ERROR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L42
        L96:
            r0[MmMinutesFileUploadErrorCode.DRIVE_PUSH_CALLBACK_ERROR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L43
        L54:
            r0[MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L70:
            r0[MmMinutesFileUploadErrorCode.ALREADY_UPLOAD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L45
        L92:
            r0[MmMinutesFileUploadErrorCode.NETWORK_ERROR.ordinal()] = 16;     // Catch: NoSuchFieldError -> L46
        L62:
            r0[MmMinutesFileUploadErrorCode.RETRY_TOO_MANY_TIMES.ordinal()] = 17;     // Catch: NoSuchFieldError -> L47
        L66:
            r0[MmMinutesFileUploadErrorCode.CANCEL_BY_USER.ordinal()] = 18;     // Catch: NoSuchFieldError -> L48
        L78:
            r0[MmMinutesFileUploadErrorCode.SOMETHING_WRONG.ordinal()] = 19;     // Catch: NoSuchFieldError -> L49
        L58:
            r0[MmMinutesFileUploadErrorCode.SUCCESS.ordinal()] = 20;     // Catch: NoSuchFieldError -> L50
        L25:
            a = r0;
            int[] r1 = new int[MmRecordingSource.values().length];
            r1[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 1;     // Catch: NoSuchFieldError -> L51
        L94:
            r1[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L52
        L60:
            r1[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L53
        L29:
            b = r1;
        }
    }

    static {
    }

    public MmMinutesFileUploadBusinessTracker() {
        this.a = Collections.newSetFromMap(new ConcurrentHashMap());
        this.b = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static boolean c(eub.f r2) {
        String r0 = r2.h.get("legacy_source");
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        MmRecordingSource r3 = r2.b;
        if (r3 != MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L8;
    L15:
        return true;
    L8:
        if (r3 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L15;
        if (r3 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L15;
        if (Intrinsics.areEqual(r0, "hardware_offline_upload") == true) goto L15;
        return false;
    }

    public static List r(String r7) {
        List r8 = StringsKt.split$default(r7, new String[]{fyb.a.COMMA}, false, 0, 6, null);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((String) r9.next()).toString());
        goto L4
    L6:
        ArrayList r10 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L15;
        Object r2 = r1.next();
        if (((String) r2).length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
        r10.add(r2);
        goto L8
    L12:
        r3 = false;
        goto L13
    L15:
        return r10;
    }

    public static String s(eub.f r2) {
        MmRecordingSource r0 = r2.b;
        int r1 = b.b[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "D1204";
    L5:
        if (r1 != 2) goto L7;
        return "D1204_CASE";
    L7:
        if (r1 != 3) goto L9;
    L12:
        return "D3200";
    L9:
        if (c(r2) == true) goto L12;
        return "software";
    }

    public final JSONObject a(eub.f r5) {
        JSONObject r0 = new JSONObject().put("file_id", r5.a).put("source", s(r5)).put("file_count", r5.c.size());
        String r1 = r5.h.get("retry_flag");
        if (r1 != null) goto L5;
        r1 = "none";
    L5:
        JSONObject r2 = r0.put("upload_retry", r1);
        if (c(r5) == false) goto L15;
        r2.put("hardware_unique_id", b(r5));
        String r3 = r5.h.get("hardware_file_ids");
        String r4 = "";
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r2.put("hardware_file_id", r3);
        String r6 = r5.h.get("sync_task_id");
        if (r6 == null) goto L14;
        r4 = r6;
    L14:
        r2.put("hardware_sync_task_id", r4);
    L15:
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public final String b(eub.f r13) {
        MmRecordingSource r0 = r13.b;
        String r2 = "";
        if (r0 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L5;
    L11:
        String r14 = r13.h.get("hardware_device_ids");
        if (r14 == null) goto L16;
        r2 = r14;
    L16:
        return CollectionsKt.joinToString$default(r(r2), fyb.a.COMMA, null, null, 0, null, new MmMinutesFileUploadBusinessTracker$hardwareDeviceIdsForTracking$1(this), 30, null);
    L5:
        if (r0 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L11;
        String r15 = r13.h.get("hardware_device_ids");
        if (r15 != null) goto L10;
        return "";
    L10:
        return r15;
    }

    public final void d(eub.f r9) {
        Intrinsics.checkNotNullParameter(r9, "param");
        p(this, r9, "prepare", "-1", null, null, 24);
    }

    public final void f(eub.f r9) {
        Intrinsics.checkNotNullParameter(r9, "param");
        p(this, r9, "quota", "-1", null, null, 24);
    }

    public final void g(eub.f r9) {
        Intrinsics.checkNotNullParameter(r9, "param");
        p(this, r9, "quota", "1", null, null, 24);
    }

    public static void k(JSONObject r2, eub.b r3) {
        MmMinutesFileUploadErrorCode r0 = r3.a;
        switch(b.a[r0.ordinal()]) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            case 19: goto L7;
            case 20: goto L6;
            default: goto L5;
        };
    L6:
        int r1 = -1;
    L25:
        r2.put("error_reason", r1);
        r2.put(UniContext.KEY_OF_ERROR_CODE, r1);
        r2.put("error_code_str", r3.a.name());
        r2.put("error_message", r3.b);
        return;
    L7:
        r1 = 200000;
        goto L25
    L8:
        r1 = 30003;
        goto L25
    L9:
        r1 = 30000;
        goto L25
    L10:
        r1 = 200015;
        goto L25
    L11:
        r1 = 200010;
        goto L25
    L12:
        r1 = 200009;
        goto L25
    L13:
        r1 = 200008;
        goto L25
    L14:
        r1 = 200014;
        goto L25
    L15:
        r1 = 200007;
        goto L25
    L16:
        r1 = 200005;
        goto L25
    L17:
        r1 = 200006;
        goto L25
    L18:
        r1 = 200012;
        goto L25
    L19:
        r1 = 200004;
        goto L25
    L20:
        r1 = 200003;
        goto L25
    L21:
        r1 = 200002;
        goto L25
    L22:
        r1 = 200001;
        goto L25
    L23:
        r1 = 30002;
        goto L25
    L24:
        r1 = 30001;
        goto L25
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void m(String r3, JSONObject r4) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        lvb.a.a("MmMinutesFileUploadBusinessTracker", "[sendEvent] eventName=" + r3 + ", params=" + r4);     // Catch: Throwable -> L5
        Statistics.sendEvent(r3, r4);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        lvb.a.b("MmMinutesFileUploadBusinessTracker", "[sendEvent] failed, eventName=" + r3 + ", error=" + r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void e(eub.f r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "param");
        Intrinsics.checkNotNullParameter(r10, "objectToken");
        p(this, r9, "prepare", "1", null, r10, 8);
    }

    public final void i(eub.f r9, eub.g r10) {
        Intrinsics.checkNotNullParameter(r9, "param");
        Intrinsics.checkNotNullParameter(r10, "status");
        p(this, r9, "upload", "-1", null, r10.d, 8);
    }

    public final void j(eub.f r9, eub.g r10) {
        Intrinsics.checkNotNullParameter(r9, "param");
        Intrinsics.checkNotNullParameter(r10, "status");
        p(this, r9, "upload", "1", null, r10.d, 8);
        p(this, r9, "uploading", "-1", null, r10.d, 8);
    }

    public final void q(eub.f r3, String r4) {
        if (this.b.add(r3.a) == true) goto L6;
        lvb.a.e("MmMinutesFileUploadBusinessTracker", "[sendTerminalFailedEventIfNeeded] skip duplicate failed, taskId=" + r3.a);
        return;
    L6:
        n(r3, -2, r4);
    }

    public final void h(eub.f r8, eub.g r9, eub.b r10) {
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r9, "status");
        Intrinsics.checkNotNullParameter(r10, "error");
        MmMinutesFileUploadErrorCode r3 = r10.a;
        switch(b.a[r3.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            case 15: goto L7;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            default: goto L5;
        };
    L6:
        q(r8, r10.b);
        return;
    L7:
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r9, "status");
        Intrinsics.checkNotNullParameter(r10, "error");
        o(r8, "finish", UserInfo.NONE_NAME_CARD_ID, r10, r9.d);
        q(r8, r10.b);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r9, "status");
        Intrinsics.checkNotNullParameter(r10, "error");
        o(r8, "uploading", UserInfo.NONE_NAME_CARD_ID, r10, r9.d);
        q(r8, r10.b);
        return;
    L9:
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r9, "status");
        Intrinsics.checkNotNullParameter(r10, "error");
        o(r8, "upload", UserInfo.NONE_NAME_CARD_ID, r10, r9.d);
        q(r8, r10.b);
        return;
    L10:
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r10, "error");
        p(this, r8, "prepare", UserInfo.NONE_NAME_CARD_ID, r10, null, 16);
        q(r8, r10.b);
        return;
    L11:
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r10, "error");
        p(this, r8, "quota", UserInfo.NONE_NAME_CARD_ID, r10, null, 16);
        q(r8, r10.b);
        return;
    L12:
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r10, "error");
        l(r8, UserInfo.NONE_NAME_CARD_ID, r10);
        q(r8, r10.b);
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void l(eub.f r2, String r3, eub.b r4) {
        JSONObject r5 = a(r2).put("upload_result", r3).put("current_step", "create");
        if (r4 == null) goto L5;
        Intrinsics.checkNotNull(r5);
        k(r5, r4);
    L5:
        Intrinsics.checkNotNull(r5);
        m("vc_minutes_file_upload_dev", r5);
    }

    public final void n(eub.f r9, int r10, String r11) {
        if (c(r9) == true) goto L5;
        return;
    L5:
        String r0 = r9.h.get("hardware_file_ids");
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        List r1 = r(r0);
        List r2 = r(b(r9));
        ArrayList r3 = (ArrayList) r1;
        ArrayList r5 = (ArrayList) r2;
        if (r3.size() == r5.size()) goto L11;
        lvb.a.b("MmMinutesFileUploadBusinessTracker", "[sendHardwareEndToEndEvent] skip unmatched hardware ids, taskId=" + r9.a + ", fileCount=" + r3.size() + ", deviceCount=" + r5.size());
    L11:
        Iterator r4 = CollectionsKt.zip(r1, r2).iterator();
    L13:
        if (r4.hasNext() == false) goto L30;
        Pair r6 = (Pair) r4.next();
        String r7 = (String) r6.component1();
        String r8 = (String) r6.component2();
        if (StringsKt.isBlank(r7) == true) goto L29;
        if (StringsKt.isBlank(r8) == true) goto L29;
        JSONObject r12 = new JSONObject().put("unique_id", r8).put("file_id", r7).put("device_model", s(r9));
        String r13 = r9.h.get("transfer_type");
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        if (StringsKt.isBlank(r13) == false) goto L25;
        r13 = "offline";
    L25:
        JSONObject r14 = r12.put("transfer_type", r13).put("status", r10).put("record_uuid", r9.d);
        if (r11 == null) goto L28;
        r14.put(UniContext.KEY_OF_ERROR_MSG, r11);
    L28:
        Intrinsics.checkNotNull(r14);
        m("vc_minutes_hardware_file_upload_dev", r14);
    L29:
        lvb.a.b("MmMinutesFileUploadBusinessTracker", "[sendHardwareEndToEndEvent] skip blank hardware id, taskId=" + r9.a);
        goto L13
    }

    public final void o(eub.f r8, String r9, String r10, eub.b r11, String r12) {
        JSONObject r13 = a(r8).put("object_token", y.b(r12));
        Iterator<T> r0 = r8.c.iterator();
        long r1 = 0;
        long r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r3 = r3 + ((eub.d) r0.next()).d;
        goto L4
    L6:
        JSONObject r14 = r13.put("file_size", r3);
        Iterator<T> r15 = r8.c.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r1 = r1 + ((eub.d) r15.next()).e;
        goto L8
    L10:
        JSONObject r16 = r14.put("file_duration", r1).put("upload_result", r10).put("current_step", r9);
        if (r11 == null) goto L13;
        Intrinsics.checkNotNull(r16);
        k(r16, r11);
    L13:
        Intrinsics.checkNotNull(r16);
        m("vc_minutes_file_upload_dev", r16);
    }

    public static /* synthetic */ void p(MmMinutesFileUploadBusinessTracker r6, eub.f r7, String r8, String r9, eub.b r10, String r11, int r12) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        eub.b r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = "";
    L8:
        r6.o(r7, r8, r9, r4, r11);
    }
}
