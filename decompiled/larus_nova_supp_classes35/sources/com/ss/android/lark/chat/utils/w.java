package com.ss.android.lark.chat.utils;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w {
    static {
    }

    @JvmStatic
    public static final void a(ImageSet r6, ValidateIMFileResult r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        IMFileResult r0 = null;
        if (r7 == null) goto L43;
        ValidateIMFileResult.a r1 = ValidateIMFileResult.Companion;
        boolean r3 = false;
        if ((r6 instanceof MediaImageSet) == false) goto L21;
        MediaExtra r2 = ((MediaImageSet) r6).getMediaExtra();
        if (r2 == null) goto L21;
        String r4 = r2.getKey();
        if (r4 == null) goto L21;
        if (r4.length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L21;
    L42:
        r1.getClass();
        ValidateIMFileResult r8 = ValidateIMFileResult.a.a(r7, r4);
    L44:
        if (r8 == null) goto L46;
        r0 = r8.getResultType();
    L46:
        r6.setReceiveAuthorizationStateValue(MessagePermissionUtil.h(r0).getValue());
        r6.setValidateIMFileResult(r8);
        return;
    L15:
        r5 = false;
    L21:
        r4 = r6.getKey();
        if (r4 != null) goto L24;
    L32:
        Image r9 = r6.getOrigin();
        if (r9 == null) goto L41;
        r4 = r9.getKey();
        if (r4 == null) goto L41;
        if (r4.length() <= 0) goto L39;
        r3 = true;
    L39:
        if (r3 == true) goto L42;
    L41:
        r4 = null;
        goto L42
    L24:
        if (r4.length() <= 0) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == true) goto L30;
        r4 = null;
    L30:
        if (r4 == null) goto L32;
    L26:
        r10 = false;
        goto L27
    L43:
        r8 = null;
        goto L44
    }
}
