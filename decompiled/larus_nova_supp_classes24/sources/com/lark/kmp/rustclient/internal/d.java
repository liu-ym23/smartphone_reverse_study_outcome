package com.lark.kmp.rustclient.internal;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.RequestPacket;
import com.lark.kmp.server.pb.improto.Packet;
import com.lark.kmp.server.pb.improto.PayloadType;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final RequestPacket a(u r7) {
        RequestPacket.a r0 = new RequestPacket.a();
        com.lark.kmp.rustclient.api.model.c<?> r1 = r7.a;
        if (r1.d == null) goto L5;
        r0.d = Command.POST_GATEWAY;
    L6:
        com.lark.kmp.rustclient.api.model.c<?> r2 = r7.a;
        r0.e = r2.b;
        ByteString.a r3 = ByteString.Companion;
        ByteString r4 = ByteString.a.e(r3, r2.e.b().encode());
        if (r7.a.d == null) goto L9;
        Packet.a r5 = new Packet.a();
        r5.i = r7.a.b;
        PayloadType r6 = PayloadType.PB2;
        Intrinsics.checkNotNullParameter(r6, "payload_type");
        r5.e = r6;
        r5.h = r4;
        com.lark.kmp.server.pb.improto.Command r8 = r7.a.d;
        Intrinsics.checkNotNullParameter(r8, "cmd");
        r5.f = r8;
        r4 = ByteString.a.e(r3, new Packet(r5, r5.c(), null).encode());
    L9:
        r0.w = r4;
        r0.n = r7.d;
        Long r9 = r7.c;
        if (r9 == null) goto L12;
        r0.k = Long.valueOf(r9.longValue());
    L12:
        com.lark.kmp.server.pb.improto.Command r10 = r7.a.d;
        if (r10 == null) goto L15;
        RequestPacket.PassThrough.a r11 = new RequestPacket.PassThrough.a();
        r11.d = String.valueOf(r10.getValue());
        r0.h = new RequestPacket.PassThrough(r11, r11.c(), null);
    L15:
        String r12 = r7.b;
        if (r12 == null) goto L18;
        r0.f = r12;
    L18:
        Long r13 = r7.e;
        if (r13 == null) goto L22;
        r0.t = Long.valueOf(r13.longValue());
    L22:
        if (r7.a.c == null) goto L24;
        r0.g = Boolean.TRUE;
        RequestPacket.BizConfig.a r14 = new RequestPacket.BizConfig.a();
        RequestPacket.BizConfig.DataSource.b r15 = RequestPacket.BizConfig.DataSource.Companion;
        int r16 = r7.a.c.getNumber();
        r15.getClass();
        r14.d = RequestPacket.BizConfig.DataSource.b.a(r16);
        r0.j = new RequestPacket.BizConfig(r14, r14.c(), null);
    L25:
        r7.a.getClass();
        return new RequestPacket(r0, r0.c(), null);
    L24:
        r0.g = Boolean.FALSE;
        goto L25
    L5:
        r0.d = r1.a();
        goto L6
    }
}
