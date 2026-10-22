package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final /* synthetic */ f3.h<AbsAppletRequestMethodIDL.b> a;
    public final /* synthetic */ AppletRequestMethod b;
    public final /* synthetic */ e3.d c;

    public final void a(b4.c r24) {
        Intrinsics.checkNotNullParameter(r24, "connection");
        String r12 = UUID.randomUUID().toString();
        AppletRequestMethod.b.put(r12, r24);
        if (r24.f.element != 0) goto L84;
        int r0 = r24.b.element;
        if (200 <= r0) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L84;
        f3.h<AbsAppletRequestMethodIDL.b> r10 = this.a;
        Intrinsics.checkNotNullParameter(AbsAppletRequestMethodIDL.b.class, "<this>");
        BaseModel r11 = k3.c.a(AbsAppletRequestMethodIDL.b.class);
        AbsAppletRequestMethodIDL.b r13 = (AbsAppletRequestMethodIDL.b) r11;
        r13.setHttpCode(Integer.valueOf(r24.b.element));
        r13.setClientCode(Integer.valueOf(r24.f.element));
        r13.setHeader(r24.a);
        r13.setSessionId(r12);
        f3.h.a.b(r10, (ResultModel) r11);
        InputStream r14 = r24.d();
        if (r14 != null) goto L14;
        return;
    L14:
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r14));
        long r16 = 0;
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L61 Exception -> L63
    L16:
        String r18 = r15.readLine();     // Catch: Throwable -> L61 Exception -> L63
        if (r18 == null) goto L39;
        if (StringsKt.isBlank(r18) == true) goto L21;
        BufferedReader r21 = r15;
        r17.append(r18);     // Catch: Exception -> L59 Throwable -> L76
        r17.append('\n');     // Catch: Exception -> L59 Throwable -> L76
    L38:
        r15 = r21;
        goto L16
    L21:
        if (r17.length() <= 0) goto L23;
        boolean r19 = true;
    L24:
        if (r19 == false) goto L35;
        r17.append('\n');     // Catch: Throwable -> L61 Exception -> L63
        AppletRequestMethod r110 = this.b;     // Catch: Throwable -> L61 Exception -> L63
        e3.d r111 = this.c;     // Catch: Throwable -> L61 Exception -> L63
        long r112 = r16 + 1;
        r21 = r15;
        AppletRequestMethod.b(r110, r111, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.DATA, r12, Long.valueOf(r16), CollectionsKt.listOf(r17.toString()), null, null, 48, null));     // Catch: Throwable -> L48 Exception -> L50
        StringsKt.clear(r17);     // Catch: Throwable -> L48 Exception -> L50
        r16 = r112;
    L87:
        Unit r20 = Unit.INSTANCE;     // Catch: Exception -> L59 Throwable -> L76
    L59:
        e = e;
    L65:
        AppletRequestMethod r113 = this.b;     // Catch: Throwable -> L76
        e3.d r114 = this.c;     // Catch: Throwable -> L76
        AbsAppletRequestMethodIDL.StreamResponseStatus r115 = AbsAppletRequestMethodIDL.StreamResponseStatus.ERROR;     // Catch: Throwable -> L76
        long r116 = r16 + 1;
        AppletRequestMethod.b(r113, r114, new AbsAppletRequestMethodIDL.StreamResponseData(r115, r12, Long.valueOf(r16), null, Integer.valueOf(r24.f.element), e.getMessage(), 8, null));     // Catch: Throwable -> L74
        if (r24.c() != null) goto L71;
        AppletRequestMethod r22 = this.b;
        e3.d r117 = this.c;
        AbsAppletRequestMethodIDL.StreamResponseData r118 = new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.COMPLETE, r12, Long.valueOf(r116), null, null, null, 56, null);
    L55:
        AppletRequestMethod.b(r22, r117, r118);
    L58:
        r24.a();
        r21.close();
        AppletRequestMethod.b.remove(r12);
        return;
    L71:
        AppletRequestMethod r23 = this.b;
        e3.d r119 = this.c;
        AbsAppletRequestMethodIDL.StreamResponseData r120 = new AbsAppletRequestMethodIDL.StreamResponseData(r115, r12, Long.valueOf(r116), null, Integer.valueOf(r24.f.element), r24.b(), 8, null);
    L57:
        AppletRequestMethod.b(r23, r119, r120);
    L74:
        th = th;
        r112 = r116;
    L79:
        if (r24.c() != null) goto L81;
        AppletRequestMethod.b(this.b, this.c, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.COMPLETE, r12, Long.valueOf(r112), null, null, null, 56, null));
    L82:
        r24.a();
        r21.close();
        AppletRequestMethod.b.remove(r12);
        throw th;
    L81:
        AppletRequestMethod.b(this.b, this.c, new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.ERROR, r12, Long.valueOf(r112), null, Integer.valueOf(r24.f.element), r24.b(), 8, null));
    L50:
        e = e;
    L51:
        r16 = r112;
    L48:
        th = th;
        goto L79
    L33:
        e = e;
        r21 = r15;
    L31:
        th = th;
        r21 = r15;
        goto L79
    L35:
        r21 = r15;
        goto L87
    L23:
        r19 = false;
        goto L24
    L39:
        r21 = r15;
        if (r17.length() <= 0) goto L42;
        boolean r121 = true;
    L43:
        if (r121 == false) goto L53;
        r17.append('\n');     // Catch: Exception -> L59 Throwable -> L76
        AppletRequestMethod r122 = this.b;     // Catch: Exception -> L59 Throwable -> L76
        e3.d r123 = this.c;     // Catch: Exception -> L59 Throwable -> L76
        AbsAppletRequestMethodIDL.StreamResponseStatus r25 = AbsAppletRequestMethodIDL.StreamResponseStatus.DATA;     // Catch: Exception -> L59 Throwable -> L76
        r112 = r16 + 1;
        AppletRequestMethod.b(r122, r123, new AbsAppletRequestMethodIDL.StreamResponseData(r25, r12, Long.valueOf(r16), CollectionsKt.listOf(r17.toString()), null, null, 48, null));     // Catch: Throwable -> L48 Exception -> L50
        StringsKt.clear(r17);     // Catch: Throwable -> L48 Exception -> L50
        r16 = r112;
        goto L53
    L53:
        if (r24.c() != null) goto L56;
        r22 = this.b;
        r117 = this.c;
        r118 = new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.COMPLETE, r12, Long.valueOf(r16), null, null, null, 56, null);
        goto L55
    L56:
        r23 = this.b;
        r119 = this.c;
        r120 = new AbsAppletRequestMethodIDL.StreamResponseData(AbsAppletRequestMethodIDL.StreamResponseStatus.ERROR, r12, Long.valueOf(r16), null, Integer.valueOf(r24.f.element), r24.b(), 8, null);
        goto L57
    L42:
        r121 = false;
    L76:
        th = th;
    L77:
        r112 = r16;
    L63:
        e = e;
        r21 = r15;
    L61:
        th = th;
        r21 = r15;
        goto L77
    L7:
        if (r0 >= 300) goto L9;
        r1 = true;
    L84:
        f3.h<AbsAppletRequestMethodIDL.b> r26 = this.a;
        String r27 = r24.b();
        Intrinsics.checkNotNullParameter(AbsAppletRequestMethodIDL.b.class, "<this>");
        AbsAppletRequestMethodIDL.b r28 = (AbsAppletRequestMethodIDL.b) k3.c.a(AbsAppletRequestMethodIDL.b.class);
        r28.setHttpCode(Integer.valueOf(r24.b.element));
        r28.setClientCode(Integer.valueOf(r24.f.element));
        r28.setHeader(r24.a);
        r28.setSessionId(r12);
        Unit r29 = Unit.INSTANCE;
        f3.h.a.a(r26, r27, null, r28.toJson(), 6);
    }

    public b(f3.h<AbsAppletRequestMethodIDL.b> r1, AppletRequestMethod r10, e3.d r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
