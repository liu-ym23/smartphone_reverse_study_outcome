package com.tom_roush.fontbox.b;

import android.util.Log;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15947b;

    public u(String r1, String r2) {
        this.f15946a = r1;
        this.f15947b = r2;
    }

    private p a(r r1, int r2) {
        if (r2 != 12) goto L7;
        return new p(r2, r1.h());
    L7:
        return new p(r2);
    }

    private static Integer a(List<Object> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Object r0 = r6.remove(r6.size() - 1);
        if (ZeusTransformUtils.instanceOf(r0, Integer.class) == true) goto L5;
        p r1 = (p) ZeusTransformUtils.preCheckCast(r0, p.class, "com.obric.memorydata.plugin");
        if (r1.a().a()[0] != 12) goto L13;
        if (r1.a().a()[1] != 12) goto L13;
        return Integer.valueOf(((Integer) ZeusTransformUtils.preCheckCast(r6.remove(r6.size() - 1), Integer.class, "com.obric.memorydata.plugin")).intValue() / ((Integer) ZeusTransformUtils.preCheckCast(r6.remove(r6.size() - 1), Integer.class, "com.obric.memorydata.plugin")).intValue());
    L13:
        throw new IOException("Unexpected char string command: " + r1.a());
    L5:
        return (Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01a2 -> B:41:0x01a5). Please report as a decompilation issue!!! */
    private List<Object> a(byte[] r10, List<byte[]> r11, List<Object> r12) {
        List<byte[]> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<Object> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        r r0 = new r(r10);
    L4:
        if (r0.e() == false) goto L61;
        int r15 = r0.h();
        if (r15 == 10) goto L7;
        if (r15 != 12) goto L49;
        if (r0.c(0) != 16) goto L49;
        r0.g();
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r14.remove(r14.size() - 1), Integer.class, "com.obric.memorydata.plugin");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r14.remove(r14.size() - 1), Integer.class, "com.obric.memorydata.plugin");
        ArrayDeque r8 = new ArrayDeque();
        int r17 = r16.intValue();
        if (r17 == 0) goto L39;
        if (r17 != 1) goto L32;
        r14.add(1);
        Object r18 = new p(12, 16);
    L40:
        r14.add(r18);
    L42:
        if (r0.c(0) != 12) goto L47;
        if (r0.c(1) != 17) goto L47;
        r0.g();
        r0.g();
        r18 = r8.pop();
    L47:
        if (r8.size() <= 0) goto L4;
        StringBuilder r19 = new StringBuilder().append("Value left on the PostScript stack in glyph ").append(this.f15947b).append(" of font ");
    L10:
        Log.w("PdfBox-Android", r19.append(this.f15946a).toString());
        goto L4
    L32:
        if (r17 == 3) goto L37;
        int r110 = 0;
    L35:
        if (r110 >= r6.intValue()) goto L42;
        r8.push(a(r14));
        r110 = r110 + 1;
        goto L35
    L37:
        r8.push(a(r14));
        goto L42
    L39:
        r8.push(a(r14));
        r8.push(a(r14));
        r14.remove(r14.size() - 1);
        r14.add(0);
        r18 = new p(12, 16);
    L49:
        if (r15 < 0) goto L55;
        if (r15 > 31) goto L55;
        Object r111 = a(r0, r15);
    L53:
        r14.add(r111);
    L55:
        if (r15 < 32) goto L60;
        if (r15 > 255) goto L60;
        r111 = b(r0, r15);
    L60:
        throw new IllegalArgumentException();
    L7:
        Object r112 = r14.remove(r14.size() - 1);
        if (ZeusTransformUtils.instanceOf(r112, Integer.class) == false) goto L9;
        Integer r113 = (Integer) ZeusTransformUtils.preCheckCast(r112, Integer.class, "com.obric.memorydata.plugin");
        if (r113.intValue() < 0) goto L20;
        if (r113.intValue() >= r13.size()) goto L20;
        a((byte[]) ZeusTransformUtils.preCheckCast(r13.get(r113.intValue()), byte[].class, "com.obric.memorydata.plugin"), r13, r14);
        Object r114 = r14.get(r14.size() - 1);
        if (ZeusTransformUtils.instanceOf(r114, p.class) == false) goto L4;
        if (((p) ZeusTransformUtils.preCheckCast(r114, p.class, "com.obric.memorydata.plugin")).a().a()[0] != 11) goto L4;
        r14.remove(r14.size() - 1);
    L20:
        Log.w("PdfBox-Android", "CALLSUBR is ignored, operand: " + r113 + ", subrs.size(): " + r13.size() + " in glyph '" + this.f15947b + "' of font " + this.f15946a);
    L22:
        if (ZeusTransformUtils.instanceOf(r14.get(r14.size() - 1), Integer.class) == false) goto L4;
        r14.remove(r14.size() - 1);
        goto L22
    L9:
        r19 = new StringBuilder().append("Parameter ").append(r112).append(" for CALLSUBR is ignored, integer expected in glyph '").append(this.f15947b).append("' of font ");
        goto L10
    L61:
        return r14;
    }

    private Integer b(r r2, int r3) {
        if (r3 < 32) goto L9;
        if (r3 > 246) goto L9;
        return Integer.valueOf(r3 + NetError.ERR_TEMPORARILY_THROTTLED);
    L9:
        if (r3 < 247) goto L15;
        if (r3 > 250) goto L15;
        int r4 = (r3 - 247) * 256;
        return Integer.valueOf((r4 + r2.h()) + 108);
    L15:
        if (r3 < 251) goto L21;
        if (r3 > 254) goto L21;
        int r1 = (-(r3 - 251)) * 256;
        return Integer.valueOf((r1 - r2.h()) + NetError.ERR_ADDRESS_INVALID);
    L21:
        if (r3 != 255) goto L25;
        return Integer.valueOf(r2.k());
    L25:
        throw new IllegalArgumentException();
    }

    public List<Object> a(byte[] r3, List<byte[]> r4) {
        return a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), new ArrayList());
    }
}
