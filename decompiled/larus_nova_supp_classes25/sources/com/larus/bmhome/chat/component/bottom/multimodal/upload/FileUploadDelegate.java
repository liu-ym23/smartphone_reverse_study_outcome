package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jq\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u0085\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadDelegate;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadService;", "<init>", "()V", "createCacheWritingCallback", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IPreprocessUploadCallback;", "localMsgId", "", "entity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "conversationId", "botId", "isMultiFile", "", "fromScene", "clickFrom", "enterMethod", "messageId", "clarifyId", "cacheWriter", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadCacheWriter;", "displayType", "agentType", "fileUploader", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IFileUploader;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FileUploadDelegate implements FileUploadService {
    public static final FileUploadDelegate b = null;
    public final /* synthetic */ FileUploadService a;

    static {
        b = new FileUploadDelegate();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m a(String r16, UplinkFileEntity r17, String r18, String r19, boolean r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, c r28) {
        Intrinsics.checkNotNullParameter(r16, "localMsgId");
        Intrinsics.checkNotNullParameter(r17, "entity");
        return this.a.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final l b() {
        return this.a.b();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m c(String r14, UplinkFileEntity r15, String r16, String r17, boolean r18, String r19, String r20, String r21, String r22, String r23, c r24) {
        Intrinsics.checkNotNullParameter(r14, "localMsgId");
        Intrinsics.checkNotNullParameter(r15, "entity");
        return this.a.c(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    private FileUploadDelegate() {
        FileUploadService r0 = (FileUploadService) ServiceManager.get().getService(FileUploadService.class);
        if (r0 != null) goto L5;
        r0 = EmptyFileUploadService.a;
    L5:
        this.a = r0;
    }
}
