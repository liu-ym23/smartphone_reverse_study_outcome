package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public static final i a = null;
    public static final Set<String> b = null;

    public static final class a {
        public final MmMinutesFileUploadErrorCode a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PreCheckResult(code=" + this.a + ", message=" + this.b + ')';
        }

        public final MmMinutesFileUploadErrorCode a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public a(MmMinutesFileUploadErrorCode r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            Intrinsics.checkNotNullParameter(r3, "message");
            this.a = r2;
            this.b = r3;
        }
    }

    public i() {
    }

    static {
        a = new i();
        b = SetsKt.setOf(new String[]{"wav", "mp3", "m4a", "aac", "ogg", "og9", "wma", "avi", "wmv", "mov", "mp4", "m4v", "mpeg", "flv"});
    }

    public static a a(eub.f r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "param");
        MmRecordingSource r0 = r17.b;
        if (r0 != MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L5;
    L10:
        boolean r3 = true;
    L12:
        if (r17.c.isEmpty() == true) goto L14;
        if (r3 == false) goto L17;
    L20:
        Iterator<T> r6 = r17.c.iterator();
        long r7 = 0;
        long r9 = 0;
        long r11 = 0;
    L22:
        if (r6.hasNext() == false) goto L66;
        eub.d r14 = (eub.d) r6.next();
        a.getClass();
        if (r14.a.length() != 0) goto L26;
        boolean r1 = true;
    L27:
        if (r1 == false) goto L85;
        boolean r2 = false;
    L37:
        if (r2 == true) goto L48;
        MmMinutesFileUploadErrorCode r13 = MmMinutesFileUploadErrorCode.PRE_FILE_NOT_EXIST;
        StringBuilder r15 = new StringBuilder("file not exist, fileName=");
        r15.append(r14.c);
        r15.append(", localPathEmpty=");
        if (r14.a.length() != 0) goto L41;
        boolean r4 = true;
    L42:
        r15.append(r4);
        r15.append(", uriEmpty=");
        if (r14.b.length() != 0) goto L45;
        boolean r5 = true;
    L46:
        r15.append(r5);
        a r8 = new a(r13, r15.toString());
    L63:
        if (r8 != null) goto L64;
        r9 = r9 + r14.d;
        r11 = r11 + r14.e;
        r7 = 0;
        goto L22
    L64:
        return r8;
    L45:
        r5 = false;
        goto L46
    L41:
        r4 = false;
        goto L42
    L48:
        if (r14.c.length() != 0) goto L50;
        boolean r10 = true;
    L51:
        if (r10 == false) goto L53;
        r8 = new a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "file name empty");
        goto L63
    L53:
        String r12 = StringsKt.substringAfterLast(r14.c, '.', "").toLowerCase(Locale.ROOT);
        if (b.contains(r12) == true) goto L56;
        r8 = new a(MmMinutesFileUploadErrorCode.FILE_TYPE_ERROR, "file type invalid, fileName=" + r14.c + ", extension=" + r12);
        goto L63
    L56:
        if (r3 == true) goto L58;
    L62:
        r8 = null;
        goto L63
    L58:
        if (r14.d > r7) goto L60;
    L61:
        r8 = new a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "hardware file size or duration invalid, fileName=" + r14.c + ", fileSize=" + r14.d + ", fileDuration=" + r14.e);
        goto L63
    L60:
        if (r14.e > r7) goto L62;
    L50:
        r10 = false;
        goto L51
    L85:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L31
        com.ss.android.lark.vfs.h r19 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Throwable -> L31
        Object r20 = Result.constructor-impl(Boolean.valueOf(com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r14.a).exists()));     // Catch: Throwable -> L31
    L33:
        Boolean r110 = Boolean.FALSE;
        if (Result.isFailure-impl(r20) == false) goto L36;
        r20 = r110;
    L36:
        r2 = ((Boolean) r20).booleanValue();
    L31:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L26:
        r1 = false;
        goto L27
    L66:
        if (r3 == true) goto L77;
        if (r18 == true) goto L77;
        if (r9 < 6442450944L) goto L73;
        return new a(MmMinutesFileUploadErrorCode.FILE_SIZE_ERROR, "file size exceeded, totalFileSize=" + r9);
    L73:
        if (r11 < 21600000) goto L77;
        return new a(MmMinutesFileUploadErrorCode.MEDIA_DURATION_ERROR, "file duration exceeded, totalFileDuration=" + r11);
    L77:
        if (r9 <= 0) goto L84;
        if (r11 <= 0) goto L84;
        lvb.a.e("MmMinutesFileUploadPreCheckHelper", "preCheck success: taskId=" + r17.a + ", isHardware=" + r3 + ", fileCount=" + r17.c.size() + ", totalFileSize=" + r9 + ", totalFileDuration=" + r11 + ", skipSizeDurationCheck=" + r18);
        return new a(MmMinutesFileUploadErrorCode.SUCCESS, "");
    L84:
        return new a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "file size or duration invalid, totalFileSize=" + r9 + ", totalFileDuration=" + r11);
    L17:
        if (r17.c.size() <= 9) goto L20;
        return new a(MmMinutesFileUploadErrorCode.PRE_FILE_COUNT_EXCEEDED, "file count exceeded, count=" + r17.c.size());
    L14:
        return new a(MmMinutesFileUploadErrorCode.PRE_FILE_COUNT_EMPTY, "files empty");
    L5:
        if (r0 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L10;
        if (r0 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L10;
        r3 = false;
        goto L12
    }
}
