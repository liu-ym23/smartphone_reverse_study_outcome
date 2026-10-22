package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.ies.bullet.service.base.LoaderName;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.a0;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends a0 {
    public final w A;
    public final ResourceFrom B;

    public m(Uri r19, w r20) {
        Intrinsics.checkNotNullParameter(r20, "response");
        if (r19 != null) goto L5;
        Uri r5 = Uri.parse(r20.f4441q.getUrl());
    L6:
        String r10 = r20.f4443t;
        com.bytedance.forest.model.ResourceFrom r11 = r20.f4444u;
        ResourceFrom r16 = null;
        if (r11 == null) goto L9;
        ResourceType r12 = td.e.h(r11, r20);
    L10:
        com.bytedance.forest.model.ResourceFrom r13 = r20.f4444u;
        if (r13 == null) goto L13;
        ResourceFrom r14 = td.e.c(r13, r20);
    L14:
        boolean r15 = r20.f4446w;
        long r17 = r20.f4449z;
        if ((r20 instanceof com.bytedance.forest.postprocessor.g) == true) goto L17;
    L19:
        InputStream r18 = r20.l();
    L20:
        com.bytedance.forest.model.m r21 = r20.f4441q.getGeckoModel();
        fc.a r22 = new fc.a(r21.f4390b, r21.f4391c, !r21.a());
        String r110 = r20.A;
        Long r23 = (Long) r20.f4431c.get("res_load_start");
        if (r23 == null) goto L23;
        long r111 = r23.longValue();
    L24:
        super(r5, r10, r12, r14, r15, r17, r18, r22, r110, r111, 2048);
        this.A = r20;
        com.bytedance.forest.model.c r24 = r20.s;
        this.f5938k = r24.f4365j;
        com.bytedance.forest.model.ResourceFrom r25 = r20.f4444u;
        com.bytedance.forest.model.ResourceFrom r26 = com.bytedance.forest.model.ResourceFrom.d;
        boolean r27 = false;
        if (r25 != r26) goto L27;
        boolean r28 = true;
    L28:
        this.f5940m = r28;
        String r29 = r24.f4366k;
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        this.f5941n = r29;
        String r30 = r24.f4367l;
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        this.f5942o = r30;
        if (r20.f4436l == false) goto L31;
    L32:
        r27 = true;
    L33:
        this.f5943p = r27;
        r20.f4441q.getEnableMemoryCache();
        String r31 = r20.f4441q.getGeckoModel().f4389a;
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        this.f5947u = r31;
        String r32 = r20.f4441q.getGeckoModel().f4390b;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        this.s = r32;
        String r33 = r20.f4441q.getGeckoModel().f4391c;
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        this.f5946t = r33;
        Intrinsics.checkNotNullParameter(LoaderName.f5920b, "<set-?>");
        Scene r34 = r20.f4441q.getScene();
        if (r34 != null) goto L36;
        int r35 = -1;
    L37:
        switch(r35) {
            case -1: goto L44;
            case 0: goto L38;
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L39;
            case 7: goto L39;
            case 8: goto L39;
            case 9: goto L39;
            case 10: goto L39;
            default: goto L38;
        };
    L38:
        ArgusResourceType r36 = ArgusResourceType.f;
    L45:
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        if (r20.f4441q.getScene() != Scene.f4351k) goto L48;
    L49:
        this.f5948v = r20.m();
    L50:
        com.bytedance.forest.model.ResourceFrom r37 = r20.f4445v;
        com.bytedance.forest.model.ResourceFrom r38 = com.bytedance.forest.model.ResourceFrom.f4340c;
        if (r37 != r38) goto L53;
    L54:
        String r39 = r20.f4441q.getOriginUrl();
        if (StringsKt.P(r39, "http://") == false) goto L57;
    L60:
        if (r39 == null) goto L62;
        this.f5952z = r39;
    L62:
        com.bytedance.forest.model.ResourceFrom r40 = r20.f4444u;
        if (r40 != r26) goto L66;
        r40 = null;
    L66:
        if (r40 != null) goto L68;
        r40 = r20.f4445v;
    L68:
        if (r40 == null) goto L78;
        if (r40 != com.bytedance.forest.model.ResourceFrom.f4338a) goto L73;
        r16 = ResourceFrom.f5925a;
        goto L78
    L73:
        if (r40 != r38) goto L76;
        r16 = ResourceFrom.f5927c;
        goto L78
    L76:
        if (r40 != com.bytedance.forest.model.ResourceFrom.f4339b) goto L78;
        r16 = ResourceFrom.f5926b;
    L78:
        this.B = r16;
        return;
    L57:
        if (StringsKt.P(r39, "https://") == true) goto L60;
        r39 = null;
        goto L60
    L53:
        if (r20.f4444u != r38) goto L62;
    L48:
        if (r20.f4441q.getScene() != Scene.f4352l) goto L50;
    L39:
        r36 = ArgusResourceType.d;
        goto L45
    L40:
        r36 = ArgusResourceType.e;
        goto L45
    L41:
        r36 = ArgusResourceType.f4954c;
        goto L45
    L42:
        r36 = ArgusResourceType.f4953b;
        goto L45
    L43:
        r36 = ArgusResourceType.f4952a;
        goto L45
    L44:
        r36 = ArgusResourceType.g;
        goto L45
    L36:
        r35 = b.f5392a[r34.ordinal()];
        goto L37
    L31:
        if (r20.f4437m == false) goto L33;
    L27:
        r28 = false;
        goto L28
    L23:
        r111 = -1;
        goto L24
    L17:
        if (((com.bytedance.forest.postprocessor.g) r20).D == false) goto L19;
        r18 = null;
        goto L20
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r5 = r19;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.service.base.a0
    public final byte[] b() {
        w r5 = this.A;
        if ((r5 instanceof com.bytedance.forest.postprocessor.g) == false) goto L9;
        if (((com.bytedance.forest.postprocessor.g) r5).D == false) goto L9;
        return null;
    L9:
        return r5.k();
    }

    public final Object d() {
        w r5 = this.A;
        if ((r5 instanceof com.bytedance.forest.postprocessor.g) == false) goto L5;
        com.bytedance.forest.postprocessor.g r10 = (com.bytedance.forest.postprocessor.g) r5;
    L6:
        if (r10 != null) goto L8;
    L16:
        return null;
    L8:
        if (r10.D == true) goto L10;
    L12:
        r10 = null;
    L13:
        if (r10 == null) goto L16;
        return r10.o();
    L10:
        if (r10.o() == null) goto L12;
    L5:
        r10 = null;
        goto L6
    }
}
