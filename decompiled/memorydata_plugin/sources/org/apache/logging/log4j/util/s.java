package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f17940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f17941b = null;
    private static final ThreadLocal<StringBuilder> c = null;

    static {
        c = ThreadLocal.withInitial($$Lambda$s$z4Sacp0dHgNB96bTlXZdt5SF0q4.INSTANCE);
        f17940a = new String[0];
        f17941b = PropertiesUtil.a().a("line.separator", "\n");
    }

    public static String a(String r2) {
        return '\'' + r2 + '\'';
    }

    public static boolean a(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        return false;
    }

    public static boolean b(CharSequence r2) {
        return !a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ StringBuilder lambda$z4Sacp0dHgNB96bTlXZdt5SF0q4() {
        return new StringBuilder();
    }
}
