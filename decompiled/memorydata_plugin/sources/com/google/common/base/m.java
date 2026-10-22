package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l f4305b = null;

    /* JADX INFO: renamed from: com.google.common.base.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a implements l {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.base.l
        public e a(String r1) {
            return new JdkPattern(Pattern.compile(r1));
        }

        @Override // com.google.common.base.l
        public boolean a() {
            return true;
        }
    }

    static {
        f4304a = Logger.getLogger(m.class.getName());
        f4305b = b();
    }

    private m() {
    }

    static <T extends Enum<T>> Optional<T> a(Class<T> r2, String r3) {
        WeakReference r4 = (WeakReference) ZeusTransformUtils.preCheckCast(Enums.a(r2).get(r3), WeakReference.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return Optional.absent();
    L6:
        return Optional.of((Enum) ZeusTransformUtils.preCheckCast(r2.cast(r4.get()), Enum.class, "com.obric.memorydata.plugin"));
    }

    static String a(double r2) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(r2)});
    }

    static boolean a() {
        return f4305b.a();
    }

    static boolean a(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    private static l b() {
        return new a(null);
    }

    static String b(String r1) {
        if (a(r1) == false) goto L6;
        return null;
    L6:
        return r1;
    }

    static e c(String r1) {
        n.a(r1);
        return f4305b.a(r1);
    }
}
