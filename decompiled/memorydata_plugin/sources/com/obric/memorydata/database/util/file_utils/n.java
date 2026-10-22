package com.obric.memorydata.database.util.file_utils;

import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/IDocumentImageProcessor;", "", "processImage", "", "imageBytes", "", "imageInfo", "Lcom/obric/memorydata/database/util/file_utils/DocumentImageInfo;", "tree", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "parentId", "", "docFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "useAutoIncrement", "([BLcom/obric/memorydata/database/util/file_utils/DocumentImageInfo;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface n {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(n r10, byte[] r11, i r12, j r13, int r14, FileEntity r15, boolean r16, Continuation r17, int r18, Object r19) {
            n r2 = (n) ZeusTransformUtils.wrapperContextForParams(r10, n.class, "com.obric.memorydata.plugin");
            Continuation<? super Boolean> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
            if (r19 != null) goto L11;
            if ((r18 & 32) == 0) goto L7;
            boolean r8 = false;
        L9:
            return r2.a(r11, r12, r13, r14, r15, r8, r9);
        L7:
            r8 = r16;
            goto L9
        L11:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processImage");
        }
    }

    Object a(byte[] r1, i r2, j r3, int r4, FileEntity r5, boolean r6, Continuation<? super Boolean> r7);
}
