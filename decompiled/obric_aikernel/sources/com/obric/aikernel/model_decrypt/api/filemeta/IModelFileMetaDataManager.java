package com.obric.aikernel.model_decrypt.api.filemeta;

import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public interface IModelFileMetaDataManager extends IService {

    public static final class DefaultImpls {
        public static /* synthetic */ void update$default(IModelFileMetaDataManager r10, File r11, boolean r12, Function1 r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 2) == 0) goto L6;
            r12 = true;
        L6:
            r10.update(r11, r12, r13);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
    }

    void batchAction(Function0<Unit> r10);

    void checkWhetherRemoveKeyAlias(String r10);

    void delete(File r10);

    ModelFileMetaData get(File r10);

    boolean isFileExistedAndReady(File r10);

    void removeAllSubFileMeta(File r10);

    void update(File r10, boolean r11, Function1<? super ModelFileMetaData, ModelFileMetaData> r12);
}
