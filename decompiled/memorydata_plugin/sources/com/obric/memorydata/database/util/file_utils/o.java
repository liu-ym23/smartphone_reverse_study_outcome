package com.obric.memorydata.database.util.file_utils;

import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/IFileProcessor;", "", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface o {
    Object a(FileEntity r1, Continuation<? super j> r2);

    FileExtension j();
}
