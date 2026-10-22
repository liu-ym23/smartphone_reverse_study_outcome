package jca;

import com.larus.im.bean.message.block.OSearchEntityImage;
import com.larus.im.bean.message.block.OSearchEntityVideo;
import com.larus.im.bean.message.block.OSearchReferenceInCollection;
import kotlin.text.StringsKt;
import zda.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final OSearchReferenceInCollection a(c r10) {
        String r0 = r10.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        if (r10.f == false) goto L15;
        OSearchReferenceInCollection r2 = new OSearchReferenceInCollection(null, new OSearchEntityVideo(r10.a, r10.b, r10.c, r10.d, r10.e), 1, null);
    L17:
        return r2;
    L15:
        r2 = new OSearchReferenceInCollection(new OSearchEntityImage(r10.a, r10.b, r10.c, r10.d, r10.e), null, 2, null);
        goto L17
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
