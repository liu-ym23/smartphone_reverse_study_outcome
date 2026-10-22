package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f16380a = null;

    public interface a {
        boolean a(h.f r1);
    }

    static {
        f16380a = c.a();
    }

    public static h.a a(h.a r2) {
        h.a r3 = (h.a) ZeusTransformUtils.wrapperContextForParams(r2, h.a.class, "com.obric.memorydata.plugin");
        return f16380a.a(r3);
    }

    public static h.a a(h.a r6, String r7, a r8, h.f... r9) {
        h.a r10 = (h.a) ZeusTransformUtils.wrapperContextForParams(r6, h.a.class, "com.obric.memorydata.plugin");
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r9 == null) goto L5;
        int r2 = r9.length;
    L6:
        if (r2 != 0) goto L8;
        Map r12 = Collections.emptyMap();
    L12:
        List<h.f> r13 = r10.b();
        ArrayList r1 = new ArrayList(r13.size());
        Iterator<h.f> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L23;
        h.f r3 = (h.f) ZeusTransformUtils.preCheckCast(r14.next(), h.f.class, "com.obric.memorydata.plugin");
        if (r11.a(r3) == false) goto L14;
        h.f r4 = (h.f) ZeusTransformUtils.preCheckCast(r12.get(r3.a()), h.f.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L20;
        r1.add(b(r3));
        goto L14
    L20:
        r1.add(r4);
        goto L14
    L23:
        return new d(r7, r1);
    L8:
        HashMap r5 = new HashMap(r2);
        int r15 = r9.length;
    L9:
        if (r0 >= r15) goto L11;
        h.f r16 = r9[r0];
        r5.put(r16.a(), r16);
        r0 = r0 + 1;
        goto L9
    L11:
        r12 = r5;
        goto L12
    L5:
        r2 = 0;
        goto L6
    }

    public static h.a a(h.f r3) {
        Iterator<h.c> r4 = ((h.f) ZeusTransformUtils.wrapperContextForParams(r3, h.f.class, "com.obric.memorydata.plugin")).b().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        h.c r0 = (h.c) ZeusTransformUtils.preCheckCast(r4.next(), h.c.class, "com.obric.memorydata.plugin");
        if (r0.e() == null) goto L4;
        return r0.e();
    L8:
        return null;
    }

    public static h.a a(h r2, String r3) {
        h.a r4 = r2.a(r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        throw new IllegalStateException("Unexpected state, requested language is not found: " + r3);
    }

    public static h.f a(h.a r2, String r3) {
        return a((h.a) ZeusTransformUtils.wrapperContextForParams(r2, h.a.class, "com.obric.memorydata.plugin"), r3.split("/"), 0);
    }

    private static h.f a(h.a r6, String[] r7, int r8) {
        h.a r9 = (h.a) ZeusTransformUtils.wrapperContextForParams(r6, h.a.class, "com.obric.memorydata.plugin");
        String r0 = r7[r8];
        if (r8 != (r7.length - 1)) goto L5;
        boolean r2 = true;
    L6:
        Iterator<h.f> r10 = r9.b().iterator();
    L8:
        if (r10.hasNext() == false) goto L22;
        h.f r4 = (h.f) ZeusTransformUtils.preCheckCast(r10.next(), h.f.class, "com.obric.memorydata.plugin");
        if (r0.equals(r4.a()) == false) goto L8;
        if (r2 == false) goto L13;
        return r4;
    L13:
        h.a r11 = a(r4);
        if (r11 != null) goto L16;
        return null;
    L16:
        return a(r11, r7, r8 + 1);
    L22:
        return null;
    L5:
        r2 = false;
        goto L6
    }

    private static void a(int r4, List<h.f> r5, h.f[] r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r7.add(r4 + r1, r6[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public static void a(h.a r2, String r3, h.f... r4) {
        h.a r5 = (h.a) ZeusTransformUtils.wrapperContextForParams(r2, h.a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length == 0) goto L10;
        a(r5, r3.split("/"), 0, r4);
        return;
    }

    private static void a(h.a r8, String[] r9, int r10, h.f[] r11) {
        h.a r12 = (h.a) ZeusTransformUtils.wrapperContextForParams(r8, h.a.class, "com.obric.memorydata.plugin");
        String r0 = r9[r10];
        int r4 = 0;
        if (r10 != (r9.length - 1)) goto L5;
        boolean r2 = true;
    L6:
        List<h.f> r13 = r12.b();
        int r5 = r13.size();
    L7:
        if (r4 >= r5) goto L21;
        h.f r6 = (h.f) ZeusTransformUtils.preCheckCast(r13.get(r4), h.f.class, "com.obric.memorydata.plugin");
        if (r0.equals(r6.a()) == true) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        if (r2 == false) goto L12;
        a(r4, r13, r11);
        return;
    L12:
        h.a r14 = a(r6);
        if (r14 == null) goto L19;
        a(r14, r9, r10 + 1, r11);
        return;
    L19:
        return;
    L21:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static h.a b(h.a r6, String r7, h.f... r8) {
        h.a r9 = (h.a) ZeusTransformUtils.wrapperContextForParams(r6, h.a.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r8 == null) goto L5;
        int r2 = r8.length;
    L6:
        if (r2 == 0) goto L8;
        HashMap r3 = new HashMap(r2);
        int r4 = r8.length;
    L10:
        if (r0 >= r4) goto L12;
        h.f r5 = r8[r0];
        r3.put(r5.a(), r5);
        r0 = r0 + 1;
        goto L10
    L12:
        List<h.f> r10 = r9.b();
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<h.f> r12 = r10.iterator();
    L14:
        if (r12.hasNext() == false) goto L20;
        h.f r1 = (h.f) ZeusTransformUtils.preCheckCast(r12.next(), h.f.class, "com.obric.memorydata.plugin");
        h.f r13 = (h.f) ZeusTransformUtils.preCheckCast(r3.get(r1.a()), h.f.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L17;
        r11.add(b(r1));
        goto L14
    L17:
        r11.add(r13);
        goto L14
    L20:
        return new d(r7, r11);
    L8:
        return new d(r7, a(r9).b());
    L5:
        r2 = 0;
        goto L6
    }

    public static h.f b(h.f r2) {
        h.f r3 = (h.f) ZeusTransformUtils.wrapperContextForParams(r2, h.f.class, "com.obric.memorydata.plugin");
        return f16380a.a(r3);
    }
}
