package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Image a(Map r28) {
        Intrinsics.checkNotNullParameter(r28, "attributes");
        String r1 = (String) r28.get("video_cover_key");
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = (String) r28.get("video_cover_local_path");
        if (r3 == null) goto L10;
        r2 = r3;
    L10:
        if (StringsKt.isBlank(r1) == false) goto L15;
        if (StringsKt.isBlank(r2) == false) goto L15;
        return null;
    L15:
        if ((!StringsKt.isBlank(r1)) == false) goto L17;
        String r6 = r1;
    L19:
        if ((!StringsKt.isBlank(r2)) == false) goto L21;
        String r11 = r2;
    L22:
        String r4 = (String) r28.get("video_cover_width");
        if (r4 == null) goto L27;
        Integer r5 = StringsKt.toIntOrNull(r4);
        if (r5 == null) goto L27;
        int r22 = r5.intValue();
    L28:
        String r0 = (String) r28.get("video_cover_height");
        if (r0 == null) goto L33;
        Integer r7 = StringsKt.toIntOrNull(r0);
        if (r7 == null) goto L33;
        int r23 = r7.intValue();
    L35:
        return new Image(r6, null, null, new ImageObj(null, r22, r23, null, null, 25, null), null, r11, null, null, null, null, null, null, null, null, 16342, null);
    L33:
        r23 = 0;
    L27:
        r22 = 0;
        goto L28
    L21:
        r11 = null;
        goto L22
    L17:
        r6 = null;
        goto L19
    }
}
