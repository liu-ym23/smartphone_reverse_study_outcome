package com.bytedance.bdlocation.log;

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
        LogPrinter r8 = new LogPrinter();
        sLogPrinter = r8;
        addPrinter(r8);
    }

    public Logger() {
    }

    public static void addPrinter(Printer r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Map<Class<?>, Printer> r10 = sPrinters;
        if (r10.containsKey(r8.getClass()) == true) goto L8;
        r10.put(r8.getClass(), r8);
        return;
    }

    public static void d(String r8) {
        d("BDLocation", r8);
    }

    public static void e(String r8) {
        e("BDLocation", r8);
    }

    public static void i(String r8) {
        i("BDLocation", r8);
    }

    public static void setEnabled(boolean r8) {
        sLogPrinter.setEnable(r8);
    }

    public static void v(String r8) {
        v("BDLocation", r8);
    }

    public static void w(String r8) {
        w("BDLocation", r8);
    }

    public static void d(String r8, String r10) {
        d(r8, r10, null);
    }

    public static void e(String r8, String r10) {
        e(r8, r10, null);
    }

    public static void i(String r8, String r10) {
        i(r8, r10, null);
    }

    public static void v(String r8, String r10) {
        v(r8, r10, null);
    }

    public static void w(String r8, String r10) {
        w(r8, r10, null);
    }

    public static void d(String r8, String r10, Throwable r11) {
        Iterator<Map.Entry<Class<?>, Printer>> r12 = sPrinters.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().getValue().d(r8, r10, r11);
        goto L4
    }

    public static void e(String r8, String r10, Throwable r11) {
        Iterator<Map.Entry<Class<?>, Printer>> r12 = sPrinters.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().getValue().e(r8, r10, r11);
        goto L4
    }

    public static void i(String r8, String r10, Throwable r11) {
        Iterator<Map.Entry<Class<?>, Printer>> r12 = sPrinters.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().getValue().i(r8, r10, r11);
        goto L4
    }

    public static void v(String r8, String r10, Throwable r11) {
        Iterator<Map.Entry<Class<?>, Printer>> r12 = sPrinters.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().getValue().v(r8, r10, r11);
        goto L4
    }

    public static void w(String r8, String r10, Throwable r11) {
        Iterator<Map.Entry<Class<?>, Printer>> r12 = sPrinters.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().getValue().w(r8, r10, r11);
        goto L4
    }

    public static void e(String r8, Throwable r10) {
        e("BDLocation", r8, r10);
    }
}
