package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.im.internal.jni.bean.FileContent;
import com.larus.im.internal.jni.bean.FileMeta;
import com.larus.im.internal.jni.bean.GetRemoteFilesContentRequestPayload;
import com.larus.im.internal.jni.bean.GetRemoteFilesContentResponsePayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PcRemoteFileDispatcher {
    public static final PcRemoteFileDispatcher a = null;

    static {
        a = new PcRemoteFileDispatcher();
    }

    public PcRemoteFileDispatcher() {
    }

    public final Object b(g r33, Continuation<? super String> r34) {
        if ((r34 instanceof PcRemoteFileDispatcher$requestUrl$1) == false) goto L7;
        PcRemoteFileDispatcher$requestUrl$1 r2 = (PcRemoteFileDispatcher$requestUrl$1) r34;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L22;
        if (r5 != 1) goto L21;
        String r6 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L14 PcRemoteFileException -> L16 CancellationException -> L18 TimeoutCancellationException -> L41
    L49:
        return r1;
    L14:
        e = e;
    L37:
        FLogger.a.e("PcRemoteFilePreview", "stage=url_request_failed command_id=" + r6 + " exception=" + e.getClass().getSimpleName());
        throw new PcRemoteFileException(PcRemoteFileError.NETWORK_ERROR, null, 2, null);
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r1);
        r33.b();
        String r14 = o.a.getDeviceId();
        if (StringsKt.isBlank(r14) == false) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == true) goto L44;
        String r8 = UUID.randomUUID().toString();
        DispatchCommand r10 = DispatchCommand.GET_REMOTE_FILES_CONTENT_REQUEST;
        String r11 = r33.c;
        String r13 = r33.e;
        if (r13 != null) goto L47;
        r13 = "";
    L47:
        PcRemoteFileDispatcher$requestUrl$2 r9 = new PcRemoteFileDispatcher$requestUrl$2(r33, new DispatchCommandPayload(r10, r8, new DispatchCommandBody(null, null, null, null, null, null, null, null, null, null, new GetRemoteFilesContentRequestPayload(CollectionsKt.listOf(new FileMeta(r11, r13)), 0, 2, null), null, null, null, 15359, null), null, r14, null, 0, null, null, 488, null), r8, null);     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        r2.L$0 = r8;     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        r2.label = 1;     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        r1 = TimeoutKt.b(900000, r9, r2);     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        if (r1 != r4) goto L49;
        return r4;
    L35:
        e = e;
        r6 = r8;
        goto L37
    L44:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_REQUEST, null, 2, null);
    L25:
        r7 = false;
    L16:
        e = move-exception;
        throw e;
    L18:
        e = move-exception;
        throw e;
    L42:
        throw new PcRemoteFileException(PcRemoteFileError.REQUEST_TIMEOUT, null, 2, null);
    L7:
        r2 = new PcRemoteFileDispatcher$requestUrl$1(this, r34);
        goto L8
    }

    public static String a(OmniDispatchCommandResponse r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "response");
        Intrinsics.checkNotNullParameter(r7, "commandId");
        Intrinsics.checkNotNullParameter(r8, "filePath");
        DispatchCommandPayload r9 = r6.payload;
        if (r9 == null) goto L86;
        if (Intrinsics.areEqual(r9.commandId, r7) == false) goto L84;
        if (r9.command != DispatchCommand.GET_REMOTE_FILES_CONTENT_RESPONSE) goto L82;
        if (r9.errorCode != DispatchErrorCode.DISPATCH_ERROR_CODE_SUCCESS) goto L80;
        DispatchCommandBody r10 = r9.body;
        if (r10 == null) goto L78;
        GetRemoteFilesContentResponsePayload r11 = r10.getRemoteFilesContentResponse;
        if (r11 == null) goto L78;
        List r12 = r11.fileContents;
        if (r12 == null) goto L76;
        Iterator r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L26;
        Object r14 = r13.next();
        FileMeta r2 = ((FileContent) r14).meta;
        if (r2 == null) goto L22;
        String r3 = r2.filePath;
    L24:
        if (Intrinsics.areEqual(r3, r8) == false) goto L18;
    L27:
        FileContent r15 = (FileContent) r14;
        if (r15 == null) goto L76;
        String r16 = r15.url;
        if (r16 != null) goto L87;
        r16 = "";
    L87:
        URI r17 = new URI(r16);     // Catch: Exception -> L34
    L35:
        boolean r18 = false;
        int r4 = 0;
    L37:
        if (r4 >= r16.length()) goto L48;
        char r5 = r16.charAt(r4);
        if (CharsKt.isWhitespace(r5) == false) goto L41;
    L44:
        boolean r19 = true;
    L45:
        if (r19 == true) goto L46;
        r4 = r4 + 1;
        goto L37
    L46:
        boolean r20 = true;
    L49:
        if (r20 == true) goto L74;
        if (r17 == null) goto L52;
        String r21 = r17.getHost();
    L53:
        if (r21 != null) goto L55;
    L56:
        r18 = true;
    L57:
        if (r18 == true) goto L74;
        if (r17 == null) goto L60;
        String r22 = r17.getScheme();
    L62:
        if (StringsKt.equals(r22, "https", true) == true) goto L68;
        if (r17 == null) goto L65;
        String r23 = r17.getScheme();
    L67:
        if (StringsKt.equals(r23, "http", true) == false) goto L74;
    L65:
        r23 = null;
    L68:
        if (r17 == null) goto L70;
        String r24 = r17.getRawUserInfo();
    L71:
        if (r24 != null) goto L74;
        return r16;
    L70:
        r24 = null;
        goto L71
    L60:
        r22 = null;
        goto L62
    L55:
        if (StringsKt.isBlank(r21) == false) goto L57;
    L52:
        r21 = null;
    L74:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_URL, null, 2, null);
    L41:
        if (Character.isISOControl(r5) == true) goto L44;
        r19 = false;
        goto L45
    L48:
        r20 = false;
    L34:
        r17 = null;
        goto L35
    L22:
        r3 = null;
        goto L24
    L26:
        r14 = null;
    L76:
        throw new PcRemoteFileException(PcRemoteFileError.FILE_NOT_FOUND, null, 2, null);
    L78:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_RESPONSE, null, 2, null);
    L80:
        throw new PcRemoteFileException(PcRemoteFileError.SERVER_ERROR, Integer.valueOf(r9.errorCode.value));
    L82:
        throw new PcRemoteFileException(PcRemoteFileError.UNEXPECTED_COMMAND, null, 2, null);
    L84:
        throw new PcRemoteFileException(PcRemoteFileError.MISMATCHED_COMMAND, null, 2, null);
    L86:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_RESPONSE, null, 2, null);
    }
}
