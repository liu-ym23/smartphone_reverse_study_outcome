package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;

    static {
        StringBuilder r0 = new StringBuilder("digitAvatar");
        String r2 = File.separator;
        r0.append(r2);
        r0.append("avatarCapture");
        a = r0.toString();
        b = "digitAvatar" + r2 + "avatarCapture_tmp";
        c = "digitAvatar" + r2 + "videoAvatarBg";
    }

    public static File a() {
        File[] r0 = b().listFiles();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length != 0) goto L7;
        boolean r1 = true;
    L9:
        if ((!r1) == true) goto L11;
        return null;
    L11:
        return (File) ArraysKt.first(r0);
    L7:
        r1 = false;
        goto L9
    }

    public static PolarisFileWrapper b() {
        PolarisFileWrapper r1 = new PolarisFileWrapper(s1.getContext().getExternalCacheDir(), a + File.separator + je0.d.b0());
        if (r1.exists() == true) goto L5;
        r1.mkdirs();
    L5:
        return r1;
    }
}
