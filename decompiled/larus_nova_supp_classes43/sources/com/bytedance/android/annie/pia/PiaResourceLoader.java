package com.bytedance.android.annie.pia;

import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.resource.o;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.resource.h;
import com.bytedance.android.annie.service.resource.i;
import com.bytedance.pia.core.api.resource.LoadFrom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PiaResourceLoader implements i47.c {

    public static final class a implements l47.c {
        public final /* synthetic */ h b;

        public a(h r1) {
            this.b = r1;
        }

        public final void release() {
            h r0 = this.b;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    public PiaResourceLoader() {
    }

    public static f c(i r10) {
        if (r10 == null) goto L5;
        WebResourceResponse r1 = r10.e();
    L6:
        if (r10 == null) goto L8;
        byte[] r11 = r10.a();
    L9:
        if (r10 == null) goto L11;
        String r12 = r10.c;
    L13:
        if (r12 != "cdn") goto L15;
        LoadFrom r13 = LoadFrom.Online;
    L16:
        if (r1 == null) goto L20;
        if (r11 != null) goto L19;
        return null;
    L19:
        return new f(r1, r13);
    L20:
        return null;
    L15:
        r13 = LoadFrom.Offline;
        goto L16
    L11:
        r12 = null;
        goto L13
    L8:
        r11 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final i47.e a(LoadFrom r10, i47.d r11) {
        String r12 = String.valueOf(r11.getUrl());
        LoadFrom r0 = LoadFrom.Auto;
        boolean r1 = false;
        if (r10 != r0) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r10 != r0) goto L11;
    L12:
        r1 = true;
    L13:
        o r14 = null;
        if (r13 == false) goto L21;
        WebResourceResponse r15 = com.bytedance.android.annie.service.resource.a.a.j(r12);
        if (r15 != null) goto L18;
        e r16 = null;
    L19:
        if (r16 == null) goto L21;
        return r16;
    L18:
        r16 = new e(r15);
    L21:
        RequestConfig r17 = new RequestConfig(AnnieResType.STATIC);
        r17.b = !r13;
        r17.d = !r1;
        h r18 = n.h(r12, r17);
        if (r18 == null) goto L25;
        r14 = r18.b();
    L25:
        return c(r14);
    L11:
        if (r10 != LoadFrom.Online) goto L13;
    L5:
        if (r10 == LoadFrom.Offline) goto L8;
        r13 = false;
        goto L9
    }

    public final l47.c b(LoadFrom r10, i47.d r11, final l47.a<i47.e> r12, l47.a<Throwable> r13) {
        String r14 = String.valueOf(r11.getUrl());
        LoadFrom r15 = LoadFrom.Auto;
        boolean r0 = false;
        if (r10 != r15) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r10 != r15) goto L11;
    L12:
        r0 = true;
    L13:
        if (r16 == false) goto L21;
        WebResourceResponse r17 = com.bytedance.android.annie.service.resource.a.a.j(r14);
        if (r17 != null) goto L17;
        e r18 = null;
    L18:
        if (r18 == null) goto L21;
        r12.accept(r18);
        return null;
    L17:
        r18 = new e(r17);
    L21:
        RequestConfig r19 = new RequestConfig(AnnieResType.STATIC);
        r19.b = !r16;
        r19.d = !r0;
        return new a(n.g(r14, r19, new PiaResourceLoader$loadAsync$task$1(r12, this)));
    L11:
        if (r10 != LoadFrom.Online) goto L13;
    L5:
        if (r10 == LoadFrom.Offline) goto L8;
        r16 = false;
        goto L9
    }
}
