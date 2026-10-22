package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.poifs.filesystem.DirectoryEntry;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFObjectData extends HSSFPicture {
    private final DirectoryEntry _root;

    public HSSFObjectData(EscherContainerRecord r3, ObjRecord r4, DirectoryEntry r5) {
        DirectoryEntry r6 = (DirectoryEntry) ZeusTransformUtils.wrapperContextForParams(r5, DirectoryEntry.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this._root = r6;
    }
}
