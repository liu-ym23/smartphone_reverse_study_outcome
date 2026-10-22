package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Jp\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0084\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadServiceImpl;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadService;", "<init>", "()V", "fileUploader", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IFileUploader;", "createCacheWritingCallback", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IPreprocessUploadCallback;", "localMsgId", "", "entity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "conversationId", "botId", "isMultiFile", "", "fromScene", "clickFrom", "enterMethod", "messageId", "clarifyId", "cacheWriter", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadCacheWriter;", "displayType", "agentType", "DefaultFileUploader", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FileUploadServiceImpl implements FileUploadService {

    public static final class a implements l {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.l
        public final Object a(d r2, Continuation<? super Unit> r3) {
            FileUploader r0 = FileUploader.a;
            Object r4 = FileUploader.k(r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.l
        public final Object b(q r2, ns8.b r3, Continuation<? super Unit> r4) {
            Object r5 = FileUploader.g(r2, r3, r4, 4);
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r5;
        L6:
            return Unit.INSTANCE;
        }
    }

    public FileUploadServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final l b() {
        return a.a;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m c(String r16, UplinkFileEntity r17, String r18, String r19, boolean r20, String r21, String r22, String r23, String r24, String r25, c r26) {
        Intrinsics.checkNotNullParameter(r16, "localMsgId");
        Intrinsics.checkNotNullParameter(r17, "entity");
        return a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, null, null, r26);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m a(String r25, UplinkFileEntity r26, String r27, String r28, boolean r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, c r37) {
        Intrinsics.checkNotNullParameter(r25, "localMsgId");
        Intrinsics.checkNotNullParameter(r26, "entity");
        return new com.larus.bmhome.chat.component.bottom.multimodal.upload.a(r25, r26, r27, r28, r29, r30, r31, r32, null, null, null, null, null, null, null, null, r33, r34, r35, r36, r37, 64512);
    }
}
