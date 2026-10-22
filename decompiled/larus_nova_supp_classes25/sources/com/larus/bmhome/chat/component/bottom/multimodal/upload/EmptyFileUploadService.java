package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import ic8.n0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Jp\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0084\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/EmptyFileUploadService;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadService;", "<init>", "()V", "fileUploader", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IFileUploader;", "createCacheWritingCallback", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IPreprocessUploadCallback;", "localMsgId", "", "entity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "conversationId", "botId", "isMultiFile", "", "fromScene", "clickFrom", "enterMethod", "messageId", "clarifyId", "cacheWriter", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadCacheWriter;", "displayType", "agentType", "EmptyUploader", "EmptyCallback", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class EmptyFileUploadService implements FileUploadService {
    public static final EmptyFileUploadService a = null;

    public static final class a implements m {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void a(long r1, String r3) {
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void b(mr9.l r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "uploadResult");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void c(boolean r1) {
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void d(n0 r2) {
            Intrinsics.checkNotNullParameter(r2, "processResult");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void e(String r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
        }
    }

    public static final class b implements l {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.l
        public final Object a(d r1, Continuation<? super Unit> r2) {
            return Unit.INSTANCE;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.l
        public final Object b(q r1, ns8.b r2, Continuation<? super Unit> r3) {
            return Unit.INSTANCE;
        }
    }

    static {
        a = new EmptyFileUploadService();
    }

    private EmptyFileUploadService() {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final l b() {
        return b.a;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m c(String r1, UplinkFileEntity r2, String r3, String r4, boolean r5, String r6, String r7, String r8, String r9, String r10, c r11) {
        Intrinsics.checkNotNullParameter(r1, "localMsgId");
        Intrinsics.checkNotNullParameter(r2, "entity");
        return a.a;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m a(String r1, UplinkFileEntity r2, String r3, String r4, boolean r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, c r13) {
        Intrinsics.checkNotNullParameter(r1, "localMsgId");
        Intrinsics.checkNotNullParameter(r2, "entity");
        return a.a;
    }
}
