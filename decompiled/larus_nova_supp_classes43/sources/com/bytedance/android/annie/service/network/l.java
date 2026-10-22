package com.bytedance.android.annie.service.network;

import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(TypedInput r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof TypedByteArray) == false) goto L17;
        String r11 = "UTF-8";
        if (r10.mimeType() == null) goto L11;
        r11 = MimeUtil.parseCharset(r10.mimeType(), "UTF-8");     // Catch: Throwable -> L14
    L11:
        return new String(((TypedByteArray) r10).getBytes(), Charset.forName(r11));
    L18:
        return null;
    L17:
        return null;
    }
}
