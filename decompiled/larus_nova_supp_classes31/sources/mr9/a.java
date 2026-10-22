package mr9;

import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final FlowResourceType a(UplinkFileEntity r3) {
        if (l1.j(r3) == true) goto L24;
        boolean r0 = false;
        if (r3 == null) goto L14;
        Integer r1 = r3.getEntityType();
        int r2 = UplinkEntityType.EntityTypeImage.getValue();
        if (r1 == null) goto L14;
        if (r1.intValue() != r2) goto L14;
        r0 = true;
    L14:
        if (r0 == false) goto L17;
        return FlowResourceType.Image;
    L17:
        if (l1.i(r3) == false) goto L20;
        return FlowResourceType.Audio;
    L20:
        if (l1.n(r3) == false) goto L23;
        return FlowResourceType.Video;
    L23:
        return FlowResourceType.Unknown;
    L24:
        return FlowResourceType.File;
    }
}
