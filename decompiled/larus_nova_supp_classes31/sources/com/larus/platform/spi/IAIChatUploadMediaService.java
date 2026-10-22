package com.larus.platform.spi;

import android.net.Uri;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import ic8.n0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ns8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 !2\u00020\u0001:\u0001!J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&JN\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0015J6\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H¦@¢\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0010H&J\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010 ¨\u0006\""}, d2 = {"Lcom/larus/platform/spi/IAIChatUploadMediaService;", "", "onTakePictureSuccess", "", "path", "", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "compressConfig", "Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;", "onPickImageSuccess", "uri", "Landroid/net/Uri;", "preprocessAlbumImg", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "isMultiFile", "", "processConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "keepCompressConfig", "scene", "(Landroid/net/Uri;Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;ZLcom/larus/bmhome/uploadmedia/bean/ProcessConfig;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTakePhotoImg", "tmpSrcPath", "(Ljava/lang/String;ZLcom/larus/bmhome/uploadmedia/bean/CompressConfig;Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildFinalSendImgPath", "isAlbum", "suffix", "isFile", "tryUploadFile", "param", "Lcom/larus/bmhome/chat/FileUploadParam;", "(Lcom/larus/bmhome/chat/FileUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IAIChatUploadMediaService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0001J#\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J#\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001JD\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096A¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0096A¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/larus/platform/spi/IAIChatUploadMediaService$Companion;", "Lcom/larus/platform/spi/IAIChatUploadMediaService;", "<init>", "()V", "buildFinalSendImgPath", "", "isAlbum", "", "suffix", "isFile", "onPickImageSuccess", "", "uri", "Landroid/net/Uri;", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "compressConfig", "Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;", "onTakePictureSuccess", "path", "preprocessAlbumImg", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "isMultiFile", "processConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "keepCompressConfig", "scene", "(Landroid/net/Uri;Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;ZLcom/larus/bmhome/uploadmedia/bean/ProcessConfig;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTakePhotoImg", "tmpSrcPath", "(Ljava/lang/String;ZLcom/larus/bmhome/uploadmedia/bean/CompressConfig;Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryUploadFile", "param", "Lcom/larus/bmhome/chat/FileUploadParam;", "(Lcom/larus/bmhome/chat/FileUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IAIChatUploadMediaService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IAIChatUploadMediaService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatUploadMediaService
        public final String a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "suffix");
            return this.b.a(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatUploadMediaService
        public final Object b(String r2, ns8.a r3, b r4, Continuation r5) {
            return this.b.b(r2, r3, r4, r5);
        }

        @Override // com.larus.platform.spi.IAIChatUploadMediaService
        public final Object c(Uri r9, ns8.a r10, boolean r11, b r12, boolean r13, String r14, Continuation<? super n0> r15) {
            return this.b.c(r9, r10, r11, r12, r13, r14, r15);
        }

        private Companion() {
            IAIChatUploadMediaService r0 = (IAIChatUploadMediaService) ServiceManager.get().getService(IAIChatUploadMediaService.class);
            if (r0 != null) goto L5;
            r0 = new AIChatUploadMediaServiceNoop();
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ Object a(Companion r10, Uri r11, ns8.a r12, boolean r13, boolean r14, String r15, Continuation r16, int r17) {
            if ((r17 & 2) == 0) goto L5;
            ns8.a r4 = null;
        L7:
            if ((r17 & 4) == 0) goto L9;
            boolean r5 = false;
        L11:
            if ((r17 & 16) == 0) goto L13;
            boolean r7 = false;
        L15:
            if ((r17 & 32) == 0) goto L17;
            String r8 = null;
        L19:
            return r10.c(r11, r4, r5, null, r7, r8, r16);
        L17:
            r8 = r15;
            goto L19
        L13:
            r7 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r4 = r12;
            goto L7
        }
    }

    static {
        a = Companion.c;
    }

    String a(String r1, boolean r2);

    Object b(String r1, ns8.a r2, b r3, Continuation r4);

    Object c(Uri r1, ns8.a r2, boolean r3, b r4, boolean r5, String r6, Continuation<? super n0> r7);
}
