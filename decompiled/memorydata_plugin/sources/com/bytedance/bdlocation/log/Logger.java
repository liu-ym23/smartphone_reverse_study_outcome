package com.bytedance.bdlocation.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    public static final String TAG = "BDLocation";
    private static final LogPrinter sLogPrinter = null;
    private static final Map<Class<?>, Printer> sPrinters = null;

    static {
        sPrinters = new ConcurrentHashMap();
        LogPrinter r0 = new LogPrinter();
        sLogPrinter = r0;
        addPrinter(r0);
    }

    public Logger() {
    }

    public static void addPrinter(Printer r2) {
        Printer r3 = (Printer) ZeusTransformUtils.wrapperContextForParams(r2, Printer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        Map<Class<?>, Printer> r0 = sPrinters;
        if (r0.containsKey(r3.getClass()) == true) goto L9;
        r0.put(r3.getClass(), r3);
        return;
    }

    public static void d(String r1) {
        d("BDLocation", r1);
    }

    public static void d(String r3, String r4) {
        d(r3, r4, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static void d(String r4, String r5, Throwable r6) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Printer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Printer.class, "com.obric.memorydata.plugin")).d(r4, r5, r6);
        goto L4
    }

    public static void e(String r1) {
        e("BDLocation", r1);
    }

    public static void e(String r3, String r4) {
        e(r3, r4, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static void e(String r4, String r5, Throwable r6) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Printer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Printer.class, "com.obric.memorydata.plugin")).e(r4, r5, r6);
        goto L4
    }

    public static void e(String r1, Throwable r2) {
        e("BDLocation", r1, r2);
    }

    public static void i(String r1) {
        i("BDLocation", r1);
    }

    public static void i(String r3, String r4) {
        i(r3, r4, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static void i(String r4, String r5, Throwable r6) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Printer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Printer.class, "com.obric.memorydata.plugin")).i(r4, r5, r6);
        goto L4
    }

    public static void setEnabled(boolean r1) {
        sLogPrinter.setEnable(r1);
    }

    public static void v(String r1) {
        v("BDLocation", r1);
    }

    public static void v(String r3, String r4) {
        v(r3, r4, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static void v(String r4, String r5, Throwable r6) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Printer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Printer.class, "com.obric.memorydata.plugin")).v(r4, r5, r6);
        goto L4
    }

    public static void w(String r1) {
        w("BDLocation", r1);
    }

    public static void w(String r3, String r4) {
        w(r3, r4, (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static void w(String r4, String r5, Throwable r6) {
        Iterator<Map.Entry<Class<?>, Printer>> r0 = sPrinters.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Printer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Printer.class, "com.obric.memorydata.plugin")).w(r4, r5, r6);
        goto L4
    }
}
