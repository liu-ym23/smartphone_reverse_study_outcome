package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.im.bean.message.FileType;
import com.larus.nova.NovaApplication;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.trace.audioattachment.AudioAttachmentUploadEvent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.m0;
import ic8.n0;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FileProcessor extends e {
    public static final /* synthetic */ int d = 0;

    public FileProcessor() {
    }

    public static ParcelFileDescriptor j(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public final n0 k(FileType r20, Uri r21, boolean r22, ns8.b r23, ux9.a.c r24) {
        Intrinsics.checkNotNullParameter(r20, "fileType");
        Intrinsics.checkNotNullParameter(r21, "uri");
        if (Intrinsics.areEqual(r21, Uri.EMPTY) == false) goto L6;
        if (r24 == null) goto L6;
        ux9.a.c.e(r24, AudioAttachmentUploadEvent.Result.EMPTY_URL, null, null, 6);
    L6:
        FLogger r4 = FLogger.a;
        r4.d("SendResourcePreprocessManager", "FileProcessor for uri: " + r21);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        ImFileUtil.a.getClass();     // Catch: Throwable -> L13
        m0 r8 = ImFileUtil.f(r21);     // Catch: Throwable -> L13
        r8.g = r22;     // Catch: Throwable -> L11
        r4.i("SendResourcePreprocessManager", "ProcessFileInfo: " + r8);     // Catch: Throwable -> L11
        Object r0 = Result.constructor-impl(r8);     // Catch: Throwable -> L11
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r0);
        if (r5 == null) goto L22;
        if (r24 == null) goto L20;
        ux9.a.c.e(r24, AudioAttachmentUploadEvent.Result.EMPTY_DATA, null, r5.getClass().getSimpleName(), 2);
    L20:
        FLogger.a.e("SendResourcePreprocessManager", "FileProcessor getFileInfoFromUri failed: " + r5);
    L22:
        if (Result.isFailure-impl(r0) == false) goto L24;
        r0 = null;
    L24:
        m0 r6 = (m0) r0;
        if (r6 == null) goto L27;
        String r15 = r6.b;
        long r9 = r6.c;
        String r11 = r6.d;
        FileType r1 = FileType.FileTypeAudio;
        if (r20 != r1) goto L35;
        ImFileUtil r12 = ImFileUtil.a;
        gd9.i r13 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r13);
        NovaApplication r14 = r13.getApplication();
        r12.getClass();
        Long r16 = ImFileUtil.d(r14, r21);
        if (r16 == null) goto L33;
        Float r17 = Float.valueOf(r16.longValue() / 1000.0f);
    L34:
        r6.n = r17;
        goto L35
    L33:
        r17 = null;
    L35:
        String r18 = "";
        if (r24 == null) goto L45;
        if (r15 == null) goto L39;
        String r10 = StringsKt.substringAfterLast(r15, '.', "");
    L40:
        Long r19 = Long.valueOf(r9);
        Float r25 = r6.n;
        if (r25 == null) goto L43;
        Long r26 = Long.valueOf((long) (r25.floatValue() * 1000));
    L44:
        r24.a.f(r10, r19, r26);
        goto L45
    L43:
        r26 = null;
        goto L44
    L39:
        r10 = null;
    L45:
        if (r15 == null) goto L47;
        String r110 = StringsKt.substringAfterLast(r15, ".", "");
    L48:
        boolean r27 = true;
        if (r1 != r20) goto L51;
        ImFileUtil.a.getClass();
        boolean r2 = ImFileUtil.u(r15, r11);
    L60:
        if (r2 == false) goto L146;
        if (r24 == null) goto L63;
        ux9.a.c.e(r24, AudioAttachmentUploadEvent.Result.UNSUPPORTED_TYPE, null, null, 6);
    L63:
        FLogger r3 = FLogger.a;
        StringBuilder r28 = new StringBuilder("uri: ");
        r28.append(r21);
        r28.append(", getFileType success ");
        if (r11 != null) goto L66;
    L71:
        r27 = false;
    L72:
        r28.append(r27);
        r28.append(' ');
        r3.e("SendResourcePreprocessManager", r28.toString());
        return new n0(r6, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH);
    L66:
        if (r11.length() != 0) goto L68;
        boolean r29 = true;
    L69:
        if (r29 != true) goto L71;
    L68:
        r29 = false;
        goto L69
    L146:
        Object r30 = Result.constructor-impl(j((ContentResolver) this.b.getValue(), r21));     // Catch: Throwable -> L77
    L79:
        Throwable r31 = Result.exceptionOrNull-impl(r30);
        if (r31 == null) goto L85;
        if (r24 == null) goto L83;
        ux9.a.c.e(r24, AudioAttachmentUploadEvent.Result.EMPTY_DATA, null, r31.getClass().getSimpleName(), 2);
    L83:
        FLogger.a.e("SendResourcePreprocessManager", "FileProcessor openFileDescriptor failed: " + r31);
    L85:
        if (Result.isFailure-impl(r30) == false) goto L87;
        r30 = null;
    L87:
        ParcelFileDescriptor r32 = (ParcelFileDescriptor) r30;
        if (r32 != null) goto L92;
        return new n0(r6, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    L92:
        if (FileType.FileTypeAudio != r20) goto L94;
        Function3 r33 = new FileProcessor$execIncludeClone$isFileOverSizeMethod$1(ImFileUtil.a);
    L96:
        if (((Boolean) r33.invoke(Boolean.valueOf(r22), Long.valueOf(r9), Boolean.FALSE)).booleanValue() == false) goto L105;
        if (r24 != null) goto L99;
    L103:
        FLogger.a.e("SendResourcePreprocessManager", "FileProcessor file oversize " + r9);
        return new n0(r6, ProcessFileResultCode.PREPARE_OVER_SIZE);
    L99:
        if (r9 > 0) goto L101;
        AudioAttachmentUploadEvent.Result r34 = AudioAttachmentUploadEvent.Result.EMPTY_DATA;
    L102:
        ux9.a.c.e(r24, r34, null, null, 6);
        goto L103
    L101:
        r34 = AudioAttachmentUploadEvent.Result.OVERSIZE;
        goto L102
    L105:
        if (r24 == null) goto L115;
        Float r35 = r6.n;
        if (r35 == null) goto L109;
        float r36 = r35.floatValue();
    L111:
        if (r36 <= 0.0f) goto L113;
        AudioAttachmentUploadEvent.Result r37 = AudioAttachmentUploadEvent.Result.VALIDATED;
    L114:
        ux9.a.c.e(r24, r37, null, null, 6);
        goto L115
    L113:
        r37 = AudioAttachmentUploadEvent.Result.WITHOUT_DURATION;
        goto L114
    L109:
        r36 = 0.0f;
    L115:
        if (r24 == null) goto L123;
        monitor-enter(r24);
        r24.e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L120
        monitor-exit(r24);
    L120:
        th = move-exception;
        throw th;
    L123:
        Pair r38 = e.h(this, r11, r32.getFileDescriptor(), true, r110, r22, r23, r15, null, 128);
        String r39 = (String) r38.getFirst();
        String r40 = (String) r38.getSecond();
        if (r24 != null) goto L126;
    L130:
        FLogger.a.i("SendResourcePreprocessManager", "FileProcessor tryCloneAndCalcMD5 result: " + r38);
        Intrinsics.checkNotNullParameter(r32, "<this>");
        r32.close();     // Catch: Throwable -> L133
    L135:
        if (o0.d(r39) == false) goto L137;
        ProcessFileResultCode r41 = ProcessFileResultCode.SUCCESS;
    L138:
        r6.f = r40;
        r6.e = r39;
        return new n0(r6, r41);
    L137:
        r41 = ProcessFileResultCode.PREPARE_CLONE_FAILED;
        goto L138
    L126:
        if (o0.d(r39) == false) goto L128;
        AudioAttachmentUploadEvent.Result r42 = AudioAttachmentUploadEvent.Result.CACHED;
    L129:
        ux9.a.c.e(r24, r42, null, null, 6);
        goto L130
    L128:
        r42 = AudioAttachmentUploadEvent.Result.COPY_FAILED;
        goto L129
    L94:
        r33 = new FileProcessor$execIncludeClone$isFileOverSizeMethod$2(ImFileUtil.a);
    L77:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L51:
        if (r15 == null) goto L55;
        String r44 = StringsKt.substringAfterLast(r15, '.', "");
        if (r44 == null) goto L55;
        String r45 = r44.toLowerCase(Locale.ROOT);
    L56:
        if (r45 == null) goto L59;
        r18 = r45;
    L59:
        r2 = !UploadFilePolicy.g(r18);
    L55:
        r45 = null;
        goto L56
    L47:
        r110 = null;
        goto L48
    L27:
        return new n0(null, ProcessFileResultCode.PREPARE_RES_NOT_FOUND);
    L11:
        th = th;
    L15:
        Result.Companion r46 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        th = th;
        goto L15
    }
}
