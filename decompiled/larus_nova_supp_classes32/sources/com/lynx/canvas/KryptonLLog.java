package com.lynx.canvas;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonLLog {
    static final String KRYPTON_TAG = "[Krypton]";

    public KryptonLLog() {
    }

    public static void d(String r4, String r5) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r0 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().d(KRYPTON_TAG + r4, r5);
        goto L4
    }

    public static void e(String r4, String r5) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r0 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().e(KRYPTON_TAG + r4, r5);
        goto L4
    }

    public static void i(String r4, String r5) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r0 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().i(KRYPTON_TAG + r4, r5);
        goto L4
    }

    public static void v(String r4, String r5) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r0 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().v(KRYPTON_TAG + r4, r5);
        goto L4
    }

    public static void w(String r4, String r5) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r0 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().w(KRYPTON_TAG + r4, r5);
        goto L4
    }
}
