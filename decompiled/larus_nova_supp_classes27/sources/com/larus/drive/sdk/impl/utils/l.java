package com.larus.drive.sdk.impl.utils;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l {
    public static final DrivePreviewOpenItem a(OfficeSpaceItem r16) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        return new DrivePreviewOpenItem("2", DrivePreviewResType.SPACE_FILE, r16.getToken(), r16.getObjType(), r16.getTitle(), r16.getUrl(), (String) r16.getExtra().get("file_ext"), (String) r16.getExtra().get("mount_node_token"), (String) r16.getExtra().get("mount_point"), null, null, new HashMap(r16.getExtra()), 1536, null);
    }
}
