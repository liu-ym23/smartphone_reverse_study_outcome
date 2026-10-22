package com.bytedance.ies.bullet.forest;

import ai.j0;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.ProcessedData;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends ForestPostProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5403c;
    public final boolean d;

    public h(String r5, String r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 8) == 0) goto L8;
        r12 = false;
    L8:
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "bid");
        super(true);
        this.f5401a = r5;
        this.f5402b = r10;
        this.f5403c = r11;
        this.d = r12;
    }

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public final ProcessedData onProcess(com.bytedance.forest.postprocessor.f r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        ResourceFrom r5 = r15.e;
        String r10 = null;
        if (r5 != null) goto L5;
    L9:
        r5 = r15.f;
        if (r5 != null) goto L13;
        r5 = ResourceFrom.f4340c;
    L13:
        if (r5 == ResourceFrom.f4338a) goto L85;
        if (r5 == ResourceFrom.f4339b) goto L85;
        Map r11 = r15.d;
        if (r11 == null) goto L23;
        String r12 = (String) r11.get("x-hydrate-url");
        if (r12 == null) goto L23;
        if (StringsKt.P(r12, "http") == false) goto L23;
    L24:
        int r13 = 0;
        if (r12 != null) goto L27;
    L39:
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r16 = new StringBuilder("read SSR hydrate url failed, except a http url but received ");
        if (r11 == null) goto L42;
        r10 = (String) r11.get("x-hydrate-url");
    L42:
        r16.append(r10);
        com.bytedance.ies.bullet.base.utils.logger.a.f("LynxSSR", r16.toString());
    L43:
        if (r12 != null) goto L45;
        r12 = "";
    L45:
        InputStream r17 = (InputStream) r15.f4551h.getValue();
        int r18 = 0;
    L47:
        if (r18 >= 4) goto L49;
        r17.read();
        r18 = r18 + 1;
        goto L47
    L49:
        int r19 = r17.read();
        if (r19 != 0) goto L83;
        int r110 = r17.read();
        if (r110 <= 0) goto L81;
        ArrayList r20 = new ArrayList(r110);
        int r21 = 0;
    L55:
        if (r21 >= r110) goto L71;
        int r22 = r17.read();
        int r23 = ((((r17.read() & 255) << 24) + ((r17.read() & 255) << 16)) + ((r17.read() & 255) << 8)) + (r17.read() & 255);
        if (r23 <= 0) goto L69;
        byte[] r111 = new byte[r23];
        int r112 = 0;
    L59:
        if (r112 >= r23) goto L64;
        int r113 = r17.read(r111, r112, r23 - r112);
        if (r113 == (-1)) goto L64;
        r112 = r112 + r113;
    L64:
        if (r112 < r23) goto L66;
        r20.add(new s(r22, r111));
        r21 = r21 + 1;
        goto L55
    L66:
        StringBuilder r114 = j0.v("read SSR response failed, except length of chunk ", r21, r23, " is ", " but received ");
        r114.append(r112);
        throw new IOException(r114.toString());
    L69:
        throw new IOException("read SSR response failed, length of chunk " + r21 + " is " + r23 + '!');
    L71:
        if (r20.size() != r110) goto L78;
        Iterator r115 = r20.iterator();
    L74:
        if (r115.hasNext() == false) goto L77;
        r13 = r13 + ((s) r115.next()).f5418b.length;
        goto L74
    L77:
        return new ProcessedData(r12.length() + r13, new r(r12, r20));
    L78:
        StringBuilder r116 = com.lynx.tasm.p.d(r110, "read SSR response failed, except count of chunks is ", " but received ");
        r116.append(r20.size());
        throw new IOException(r116.toString());
    L81:
        throw new IOException(j0.h(r110, "read SSR response failed, chunk count ", " less than ZERO!"));
    L83:
        throw new IllegalStateException("SSR failed, status:" + r19 + '!');
    L27:
        if (r12.length() == 0) goto L39;
        wc.g r117 = new wc.g("");
        String r24 = this.f5402b;
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r117.f22838c = r24;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r117.f22839h = r12;
        r117.f22852v = true;
        r117.f22850t = 5;
        if (r15.f4550c == true) goto L32;
    L34:
        boolean r25 = false;
    L36:
        if (this.f5403c == false) goto L38;
        zm.c r26 = f.f5397a;
        String r27 = r12;
        f.g(r27, r25, this.f5401a, "ssr_processor", r117, new u(r12, 2));
        goto L43
    L38:
        zm.c r28 = f.f5397a;
        String r29 = r12;
        f.f(r29, r25, this.f5401a, PreloadType.f4333a, true, "ssr_processor", r117);
        goto L43
    L32:
        if (this.d == false) goto L34;
        r25 = true;
    L23:
        r12 = null;
    L85:
        throw new IllegalStateException("a " + r5 + " resource is a CSR template, no need to parse SSR chunks!");
    L5:
        if (r5 != ResourceFrom.d) goto L8;
        r5 = null;
    L8:
        if (r5 != null) goto L13;
        goto L9
    }
}
