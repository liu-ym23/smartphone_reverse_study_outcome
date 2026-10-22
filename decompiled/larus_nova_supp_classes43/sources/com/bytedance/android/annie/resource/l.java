package com.bytedance.android.annie.resource;

import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.NetWorker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l extends com.bytedance.android.annie.service.resource.h {
    public final Function1<com.bytedance.android.annie.service.resource.i, Unit> a;
    public final com.bytedance.forest.model.o b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AnnieResType.values().length];
            r0[AnnieResType.WEB_MAIN_RESOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[AnnieResType.WEB_CHILD_RESOURCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[AnnieResType.LYNX_TEMPLATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AnnieResType.LYNX_CHILD_RESOURCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[AnnieResType.LYNX_IMAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[AnnieResType.PRELOAD_CONFIG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[AnnieResType.LYNX_FONT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    @Override // com.bytedance.android.annie.service.resource.h
    public final void a() {
        com.bytedance.forest.model.o r0 = this.b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.annie.service.resource.h
    public final o b() {
        com.bytedance.forest.model.o r0 = this.b;
        if (r0 == null) goto L7;
        Response r1 = r0.b();
        if (r1 == null) goto L7;
        return new o(r1);
    L7:
        return null;
    }

    public static RequestParams c(RequestConfig r10) {
        AnnieResType r1 = r10.a;
        switch(a.a[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        Scene r11 = Scene.OTHER;
    L12:
        RequestParams r0 = new RequestParams(r11);
        r0.m = r10.b;
        r0.u = Boolean.valueOf(r10.c);
        if (r10.c == true) goto L15;
    L17:
        boolean r12 = false;
    L18:
        r0.g = r12;
        r0.k = r10.d;
        r0.j = r10.e;
        r0.i = r10.f;
        r0.A = r10.g;
        r0.x = r10.h;
        r0.l = r10.i;
        r0.a().putAll(r10.a());
        r0.C = r10.k;
        if (r10.l == false) goto L21;
        r0.D = NetWorker.TTNet;
    L21:
        return r0;
    L15:
        if (r10.a == AnnieResType.LYNX_IMAGE) goto L17;
        r12 = true;
        goto L18
    L5:
        r11 = Scene.LYNX_FONT;
        goto L12
    L6:
        r11 = Scene.PRELOAD_CONFIG;
        goto L12
    L7:
        r11 = Scene.LYNX_IMAGE;
        goto L12
    L8:
        r11 = Scene.LYNX_CHILD_RESOURCE;
        goto L12
    L9:
        r11 = Scene.LYNX_TEMPLATE;
        goto L12
    L10:
        r11 = Scene.WEB_CHILD_RESOURCE;
        goto L12
    L11:
        r11 = Scene.WEB_MAIN_DOCUMENT;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(String r10, RequestConfig r11, Function1<? super com.bytedance.android.annie.service.resource.i, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "requestConfig");
        this.a = r12;
        if (r12 != 0) goto L7;
        Forest r13 = ForestLoader.a();
        if (r13 == null) goto L10;
        com.bytedance.forest.model.o r14 = r13.createSyncRequest(n.a(r10), c(r11));
    L11:
        this.b = r14;
        return;
    L10:
        r14 = null;
        goto L11
    L7:
        Forest r15 = ForestLoader.a();
        if (r15 == null) goto L10;
        r14 = r15.fetchResourceAsync(n.a(r10), c(r11), new RequestTaskAdapter$createRequestOption$1(this));
        goto L11
    }
}
