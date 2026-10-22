package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.poifs.filesystem.DirectoryEntry;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectPoolImpl {
    private DirectoryEntry _objectPool;

    public ObjectPoolImpl(DirectoryEntry r3) {
        this._objectPool = (DirectoryEntry) ZeusTransformUtils.wrapperContextForParams(r3, DirectoryEntry.class, "com.obric.memorydata.plugin");
    }
}
