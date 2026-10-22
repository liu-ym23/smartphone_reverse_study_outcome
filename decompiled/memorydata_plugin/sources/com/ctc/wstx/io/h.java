package com.ctc.wstx.io;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private static v a(v r9, com.ctc.wstx.a.b r10, String r11, int r12, InputStream r13, String r14, String r15) {
        q r4 = q.a(r14, r.a(r15), r13);
        Reader r8 = r4.a(r10, false, r12);
        URL r16 = r9.a();
        if (r15 == null) goto L8;
        if (r15.length() <= 0) goto L8;
        r16 = com.ctc.wstx.util.n.a(r15, r16);
    L8:
        return l.a(r10, r9, r11, r4, r14, r.a(r15, r16), r12, r8);
    }

    private static v a(v r11, com.ctc.wstx.a.b r12, String r13, int r14, Reader r15, String r16, String r17) {
        URL r2 = null;
        o r6 = o.a(r16, r.a(r17), r15, null);
        Reader r10 = r6.a(r12, false, r14);
        if (r11 == null) goto L6;
        r2 = r11.a();
    L6:
        if (r17 == null) goto L11;
        if (r17.length() <= 0) goto L11;
        r2 = com.ctc.wstx.util.n.a(r17, r2);
    L11:
        return l.a(r12, r11, r13, r6, r16, r.a(r17, r2), r14, r10);
    }

    public static v a(v r7, com.ctc.wstx.a.b r8, String r9, int r10, Object r11) {
        if (ZeusTransformUtils.instanceOf(r11, Source.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r11, StreamSource.class) == false) goto L9;
        return a(r7, r8, r9, r10, (StreamSource) ZeusTransformUtils.preCheckCast(r11, StreamSource.class, "com.obric.memorydata.plugin"));
    L9:
        throw new IllegalArgumentException("Can not use other Source objects than StreamSource: got " + r11.getClass());
    L11:
        if (ZeusTransformUtils.instanceOf(r11, URL.class) == false) goto L15;
        return a(r7, r8, r9, r10, (URL) ZeusTransformUtils.preCheckCast(r11, URL.class, "com.obric.memorydata.plugin"), null);
    L15:
        if (ZeusTransformUtils.instanceOf(r11, InputStream.class) == false) goto L19;
        return a(r7, r8, r9, r10, (InputStream) ZeusTransformUtils.preCheckCast(r11, InputStream.class, "com.obric.memorydata.plugin"), null, null);
    L19:
        if (ZeusTransformUtils.instanceOf(r11, Reader.class) == false) goto L23;
        return a(r7, r8, r9, r10, (Reader) ZeusTransformUtils.preCheckCast(r11, Reader.class, "com.obric.memorydata.plugin"), null, null);
    L23:
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L27;
        return a(r7, r8, r9, r10, (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"));
    L27:
        if (ZeusTransformUtils.instanceOf(r11, File.class) == false) goto L31;
        return a(r7, r8, r9, r10, com.ctc.wstx.util.n.a((File) ZeusTransformUtils.preCheckCast(r11, File.class, "com.obric.memorydata.plugin")), null);
    L31:
        throw new IllegalArgumentException("Unrecognized input argument type for sourceFrom(): " + r11.getClass());
    }

    public static v a(v r7, com.ctc.wstx.a.b r8, String r9, int r10, String r11) {
        return a(r7, r8, r9, r10, new StringReader(r11), null, r9);
    }

    private static v a(v r9, com.ctc.wstx.a.b r10, String r11, int r12, URL r13, String r14) {
        InputStream r0 = com.ctc.wstx.util.n.a(r13);
        r r6 = r.a(r13);
        q r4 = q.a(r14, r6, r0);
        return l.a(r10, r9, r11, r4, r14, r6, r12, r4.a(r10, false, r12));
    }

    private static v a(v r9, com.ctc.wstx.a.b r10, String r11, int r12, StreamSource r13) {
        Reader r0 = r13.getReader();
        String r5 = r13.getPublicId();
        String r1 = r13.getSystemId();
        if (r9 != null) goto L5;
        URL r3 = null;
    L6:
        if (r1 != null) goto L8;
    L11:
        URL r4 = null;
    L12:
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        r r6 = r.a(r1, r3);
        if (r0 != null) goto L24;
        InputStream r14 = r13.getInputStream();
        if (r14 != null) goto L23;
        if (r4 == null) goto L22;
        r14 = com.ctc.wstx.util.n.a(r4);
        goto L23
    L22:
        throw new IllegalArgumentException("Can not create Stax reader for a StreamSource -- neither reader, input stream nor system id was set.");
    L23:
        k r15 = q.a(r5, r6, r14);
    L25:
        k r7 = r15;
        return l.a(r10, r9, r11, r7, r5, r6, r12, r7.a(r10, false, r12));
    L24:
        r15 = o.a(r5, r6, r0, null);
        goto L25
    L8:
        if (r1.length() == 0) goto L11;
        r4 = com.ctc.wstx.util.n.a(r1, r3);
        goto L12
    L5:
        r3 = r9.a();
        goto L6
    }

    public static v a(v r2, String r3, String r4, String r5, javax.xml.stream.d r6, com.ctc.wstx.a.b r7, int r8) {
        javax.xml.stream.d r9 = (javax.xml.stream.d) ZeusTransformUtils.wrapperContextForParams(r6, javax.xml.stream.d.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        URL r1 = null;
    L6:
        if (r1 != null) goto L8;
        r1 = com.ctc.wstx.util.n.a();
    L8:
        Object r10 = r9.resolveEntity(r4, r5, r1.toExternalForm(), r3);
        if (r10 != null) goto L12;
        return null;
    L12:
        return a(r2, r7, r3, r8, r10);
    L5:
        r1 = r2.a();
        goto L6
    }

    public static v a(v r6, URL r7, String r8, String r9, String r10, javax.xml.stream.d r11, com.ctc.wstx.a.b r12, int r13) {
        javax.xml.stream.d r14 = (javax.xml.stream.d) ZeusTransformUtils.wrapperContextForParams(r11, javax.xml.stream.d.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        r7 = r6.a();
        if (r7 != null) goto L7;
        r7 = com.ctc.wstx.util.n.a();
    L7:
        if (r14 == null) goto L12;
        Object r15 = r14.resolveEntity(r9, r10, r7.toExternalForm(), r8);
        if (r15 == null) goto L12;
        return a(r6, r12, r8, r13, r15);
    L12:
        if (r10 != null) goto L20;
        StringBuilder r16 = new StringBuilder().append("Can not resolve ");
        if (r8 != null) goto L16;
        String r17 = "[External DTD subset]";
    L18:
        throw new XMLStreamException(r16.append(r17).append(" without a system id (public id '").append(r9).append("')").toString());
    L16:
        r17 = "entity '" + r8 + "'";
        goto L18
    L20:
        return a(r6, r12, r8, r13, com.ctc.wstx.util.n.a(r10, r7), r9);
    }

    public static Reader a(com.ctc.wstx.a.b r10, InputStream r11, boolean r12, String r13) {
        int r0 = r10.n();
        String r1 = g.a(r13);
        if (r1 != RpcUtils.CHARSET_UTF8) goto L6;
        c r14 = new t(r10, r11, r10.m(r0), 0, 0, true);
    L18:
        if (r12 == false) goto L20;
        r14.a(272);
    L20:
        return r14;
    L6:
        if (r1 != "ISO-8859-1") goto L9;
        r14 = new j(r10, r11, r10.m(r0), 0, 0, true);
        goto L18
    L9:
        if (r1 != "US-ASCII") goto L12;
        r14 = new a(r10, r11, r10.m(r0), 0, 0, true);
        goto L18
    L12:
        if (r1.startsWith("UTF-32") == true) goto L14;
        return new InputStreamReader(r11, r13);
    L23:
        e = move-exception;
        throw new XMLStreamException("[unsupported encoding]: " + e);
    L14:
        if (r1 != "UTF-32BE") goto L16;
        boolean r15 = true;
    L17:
        r14 = new s(r10, r11, r10.m(r0), 0, 0, true, r15);
        goto L18
    L16:
        r15 = false;
        goto L17
    }
}
