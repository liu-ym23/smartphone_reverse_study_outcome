package com.bytedance.applog;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC0098a f1507a;

    /* JADX INFO: renamed from: com.bytedance.applog.a$a, reason: collision with other inner class name */
    public interface InterfaceC0098a {
        boolean a(b r1);
    }

    static {
        f1507a = new AnonymousClass1();
    }

    public static String a(f r2, String r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        if (a(r4) == false) goto L6;
        return r3;
    L6:
        return r3 + "_" + r4.b();
    }

    public static void a(String[] r5) {
        Iterator<b> r0 = b.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).a((String[]) ZeusTransformUtils.preCheckCast(r5.clone(), String[].class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public static boolean a(InterfaceC0098a r4) {
        InterfaceC0098a r5 = (InterfaceC0098a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0098a.class, "com.obric.memorydata.plugin");
        Iterator<b> r0 = b.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r5.a((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static boolean a(f r2) {
        f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        if (AppLog.getInstance() != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(final String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (a(new AnonymousClass2(r1)) == false) goto L7;
        return true;
    }

    public static b b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        Iterator<b> r0 = b.a().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
        if (r5.equals(r2.b()) == false) goto L7;
        return r2;
    L11:
        return null;
    }
}
