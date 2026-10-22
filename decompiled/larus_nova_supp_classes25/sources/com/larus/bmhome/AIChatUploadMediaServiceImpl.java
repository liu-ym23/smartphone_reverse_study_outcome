package com.larus.bmhome;

import android.net.Uri;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ns8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JD\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\u0017J2\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J.\u0010#\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0007H\u0002J(\u00101\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¨\u00066"}, d2 = {"Lcom/larus/bmhome/AIChatUploadMediaServiceImpl;", "Lcom/larus/platform/spi/IAIChatUploadMediaService;", "<init>", "()V", "onTakePictureSuccess", "", "path", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "compressConfig", "Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;", "onPickImageSuccess", "uri", "Landroid/net/Uri;", "preprocessAlbumImg", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "isMultiFile", "", "processConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "keepCompressConfig", "scene", "(Landroid/net/Uri;Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;ZLcom/larus/bmhome/uploadmedia/bean/ProcessConfig;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTakePhotoImg", "tmpSrcPath", "(Ljava/lang/String;ZLcom/larus/bmhome/uploadmedia/bean/CompressConfig;Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildFinalSendImgPath", "isAlbum", "suffix", "isFile", "tryUploadFile", "param", "Lcom/larus/bmhome/chat/FileUploadParam;", "(Lcom/larus/bmhome/chat/FileUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryUploadFileOrImg", "uploadResult", "isImgMsg", "fromScene", "(Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/bmhome/chat/bean/ProcessFileResult;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUriPath", "resolveUploadResourceScene", "Lcom/larus/bmhome/rc/FlowResourceScene;", "isImage", "uploadImageMsgFailedNew", "msg", "Lcom/larus/im/bean/message/Message;", "breakAnswer", "conversationId", "sendMediaMessage", "strategy", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "msgId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AIChatUploadMediaServiceImpl implements IAIChatUploadMediaService {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public AIChatUploadMediaServiceImpl() {
    }

    public final String a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "suffix");
        String r5 = ChatInputService.b.f().b(true, r3, r4);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        File r6 = new PolarisFileWrapper(r5).getParentFile();
        if (r6 != null) goto L5;
    L7:
        return r5;
    L5:
        if (r6.exists() == true) goto L7;
        r6.mkdirs();
        goto L7
    }

    public final Object b(String r9, ns8.a r10, b r11, Continuation r12) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AIChatUploadMediaServiceImpl$processTakePhotoImg$2(r9, true, r10, r11, null), r12);
    }

    public static final Object d(final AIChatUploadMediaServiceImpl r24, final wc9.e r25, final ic8.n0 r26, final String r27, Continuation r28) {
        r24.getClass();
        FLogger r3 = FLogger.a;
        r3.i("AIChatUploadMediaServiceImpl", "tryUploadFile, ProcessResult: " + r26);
        ProcessFileResultCode r4 = r26.b;
        if (r4 != ProcessFileResultCode.PREPARE_OVER_SIZE) goto L9;
        r3.w("AIChatUploadMediaServiceImpl", "tryUploadFileOrImg ProcessResult for OverSize");
        Object r0 = BuildersKt.withContext(Dispatchers.getMain(), new AIChatUploadMediaServiceImpl$tryUploadFileOrImg$2(true, null), r28);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        return r0;
    L33:
        return Unit.INSTANCE;
    L9:
        if (r4 != ProcessFileResultCode.PREPARE_TYPE_NO_MATCH) goto L15;
        r3.w("AIChatUploadMediaServiceImpl", "tryUploadFileOrImg ProcessResult for not support type");
        Object r1 = BuildersKt.withContext(Dispatchers.getMain(), new AIChatUploadMediaServiceImpl$tryUploadFileOrImg$3(null), r28);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        return r1;
    L34:
        return Unit.INSTANCE;
    L15:
        if (r4 != null) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == true) goto L23;
        r3.w("AIChatUploadMediaServiceImpl", "tryUploadFileOrImg ProcessResult for not Success, error msg: " + r26.b);
        return Unit.INSTANCE;
    L23:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L25;
        int r6 = 0;
    L26:
        ic8.m0 r7 = r26.a;
        if (r7 == null) goto L30;
        String r8 = r7.e;
        if (r8 == null) goto L30;
    L31:
        ai8.e r9 = new ai8.e(r8, null, null, null, null, null, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("loading", "1"), TuplesKt.to("progress", "0")}), false, null, null, null, 27646);
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.e.d(r25.a, r6, r9, new e(r25, r27, r26, r24));
        return Unit.INSTANCE;
    L30:
        r8 = "";
        goto L31
    L25:
        r6 = 12;
        goto L26
    L17:
        if (r4.isSuccess() != true) goto L19;
        r5 = true;
        goto L20
    }

    public final Object c(Uri r11, ns8.a r12, boolean r13, b r14, boolean r15, String r16, Continuation<? super ic8.n0> r17) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AIChatUploadMediaServiceImpl$preprocessAlbumImg$2(r11, r13, r12, r16, r14, r15, null), r17);
    }
}
