package com.bytedance.android.live.room.api.record;

import android.media.MediaMetadataRetriever;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(MediaMetadataRetriever r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {9};
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r19, r1, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r19.extractMetadata(9);
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
