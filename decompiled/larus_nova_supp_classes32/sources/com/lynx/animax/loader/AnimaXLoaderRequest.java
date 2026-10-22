package com.lynx.animax.loader;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import u4a.e;
import u4a.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXLoaderRequest implements m {
    public final String a;
    public final AnimaXLoaderScheme b;
    public final Map<String, Object> c;

    public final e a() {
        Map<String, Object> r0 = this.c;
        if (r0 == null) goto L10;
        Object r1 = r0.get("image_width");
        Object r2 = this.c.get("image_height");
        if ((r1 instanceof Integer) == true) goto L7;
        return null;
    L7:
        if ((r2 instanceof Integer) == true) goto L9;
        return null;
    L9:
        return new e(r1, r2);
    L10:
        return null;
    }

    public final String b() {
        String r0 = this.a;
        String r1 = null;
        if (r0 != null) goto L5;
        Uri r2 = null;
    L6:
        if (r2 != null) goto L8;
        String r3 = null;
    L9:
        boolean r4 = true;
        if ("asset".equals(r3) == true) goto L29;
        if (r2 != null) goto L13;
        String r5 = null;
    L15:
        if ("file".equals(r5) == true) goto L29;
        if (r2 == null) goto L20;
        r1 = r2.getScheme();
    L20:
        if ("https".equals(r1) == false) goto L22;
    L25:
        boolean r6 = true;
    L26:
        if (r6 == true) goto L29;
        r4 = false;
        goto L29
    L22:
        if ("http".equals(r1) == true) goto L25;
        r6 = false;
        goto L26
    L13:
        r5 = r2.getScheme();
    L29:
        if (r4 == true) goto L41;
        String r7 = this.a;
        AnimaXLoaderScheme r8 = this.b;
        if (r8 != null) goto L34;
        return r7;
    L34:
        if (r8 != AnimaXLoaderScheme.ASSET) goto L37;
        return y4a.e.a(r7);
    L37:
        if (r8 == AnimaXLoaderScheme.FILE) goto L39;
        return r7;
    L39:
        return new Uri.Builder().scheme("file").authority(NameKeys.UnloadStrategy_No_Strategy).path(r7).build().toString();
    L41:
        return this.a;
    L8:
        r3 = r2.getScheme();
        goto L9
    L5:
        r2 = UriProtector.parse(r0);
        goto L6
    }

    public static AnimaXLoaderRequest createRequest(String r2) {
        return new AnimaXLoaderRequest(r2, null);
    }

    public AnimaXLoaderRequest(String r2, Map<String, Object> r3) {
        this.a = r2;
        this.c = r3;
        if (r3 != null) goto L5;
    L7:
        this.b = null;
        return;
    L5:
        if (r3.get("scheme") == null) goto L7;
        this.b = AnimaXLoaderScheme.values()[((Integer) r3.get("scheme")).intValue()];
    }

    public static AnimaXLoaderRequest createRequestWithParams(String r1, JavaOnlyMap r2) {
        return new AnimaXLoaderRequest(r1, r2);
    }
}
