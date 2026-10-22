package com.obric.cae.cloud.applog;

import android.util.Pair;
import com.obric.cae.log.CommSenseLog;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import r5.c;
import w4.a;
import x4.b0;

/* JADX INFO: loaded from: classes.dex */
public class AppLogNetworkClient implements b0 {
    private static final String TAG = "AppLogNetworkClient";
    private final a ssNetworkClient;

    public AppLogNetworkClient() {
        this.ssNetworkClient = new a();
    }

    private void printSSNetworkClientMethods() {
        CommSenseLog.d(TAG, "=== SSNetworkClient All Methods ===");     // Catch: Exception -> L13
        Method[] r8 = a.class.getMethods();     // Catch: Exception -> L13
        int r10 = r8.length;     // Catch: Exception -> L13
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L22;
        Method r12 = r8[r11];     // Catch: Exception -> L13
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L13
        r13.append(Modifier.toString(r12.getModifiers()));     // Catch: Exception -> L13
        r13.append(" ");     // Catch: Exception -> L13
        r13.append(r12.getReturnType().getSimpleName());     // Catch: Exception -> L13
        r13.append(" ");     // Catch: Exception -> L13
        r13.append(r12.getName());     // Catch: Exception -> L13
        r13.append("(");     // Catch: Exception -> L13
        Class<?>[] r14 = r12.getParameterTypes();     // Catch: Exception -> L13
        int r15 = 0;
    L7:
        if (r15 >= r14.length) goto L11;
        if (r15 <= 0) goto L10;
        r13.append(", ");     // Catch: Exception -> L13
    L10:
        r13.append(r14[r15].getSimpleName());     // Catch: Exception -> L13
        r15 = r15 + 1;     // Catch: Exception -> L13
        goto L7
    L11:
        r13.append(")");     // Catch: Exception -> L13
        CommSenseLog.d(TAG, r13.toString());     // Catch: Exception -> L13
        r11 = r11 + 1;
        goto L4
    L22:
        return;
    L13:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to print SSNetworkClient methods: " + e.getMessage(), e);
    }

    @Override // x4.b0
    public String get(String r8, Map<String, String> r10) {
        CommSenseLog.d(TAG, "GET request to: " + r8);
        CommSenseLog.d(TAG, "Using SSNetworkClient directly");
        printSSNetworkClientMethods();     // Catch: Exception -> L5
        this.ssNetworkClient.getClass();     // Catch: Exception -> L5
        String r11 = a.d(r8, r10);     // Catch: Exception -> L5
        CommSenseLog.d(TAG, "GET response: " + r11);     // Catch: Exception -> L5
        return r11;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "GET failed: " + e.getMessage(), e);
        throw e;
    }

    public String post(String r8, List<Pair<String, String>> r10) {
        CommSenseLog.d(TAG, "POST request with params to: " + r8);
        StringBuilder r11 = new StringBuilder("POST params count: ");
        if (r10 == null) goto L5;
        int r12 = r10.size();
    L6:
        r11.append(r12);
        CommSenseLog.d(TAG, r11.toString());
        a r13 = this.ssNetworkClient;     // Catch: Exception -> L9
        r13.getClass();     // Catch: Exception -> L9
        c.a r14 = new c.a();     // Catch: Exception -> L9
        r14.f11501a = true;     // Catch: Exception -> L9
        String r15 = r13.f(r8, r10, r14);     // Catch: Exception -> L9
        CommSenseLog.d(TAG, "POST response: " + r15);     // Catch: Exception -> L9
        return r15;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "POST failed: " + e.getMessage(), e);
        throw e;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // x4.b0
    public byte[] postStream(String r8, byte[] r10, Map<String, String> r11) {
        CommSenseLog.d(TAG, "POST stream request to: " + r8);     // Catch: r5.a -> L9
        StringBuilder r12 = new StringBuilder("POST stream data size: ");     // Catch: r5.a -> L9
        if (r10 == null) goto L6;
        int r13 = r10.length;     // Catch: r5.a -> L9
    L7:
        r12.append(r13);     // Catch: r5.a -> L9
        r12.append(" bytes");     // Catch: r5.a -> L9
        CommSenseLog.d(TAG, r12.toString());     // Catch: r5.a -> L9
        this.ssNetworkClient.getClass();     // Catch: r5.a -> L9
        return null;
    L6:
        r13 = 0;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "POST stream failed: " + e.getMessage(), e);
        e.printStackTrace();
        return null;
    }

    public String post(String r8, byte[] r10, String r11) {
        CommSenseLog.d(TAG, "POST request to: " + r8 + " with content type: " + r11);
        StringBuilder r12 = new StringBuilder("POST data size: ");
        if (r10 == null) goto L5;
        int r13 = r10.length;
    L6:
        r12.append(r13);
        r12.append(" bytes");
        CommSenseLog.d(TAG, r12.toString());
        String r14 = this.ssNetworkClient.a(r8, r10, r11);     // Catch: Exception -> L9
        CommSenseLog.d(TAG, "POST response: " + r14);     // Catch: Exception -> L9
        return r14;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "POST failed: " + e.getMessage(), e);
        throw e;
    L5:
        r13 = 0;
        goto L6
    }

    @Override // x4.b0
    public String post(String r8, byte[] r10, Map<String, String> r11) {
        CommSenseLog.d(TAG, "POST request to: " + r8);
        StringBuilder r12 = new StringBuilder("POST data size: ");
        if (r10 == null) goto L5;
        int r13 = r10.length;
    L6:
        r12.append(r13);
        r12.append(" bytes");
        CommSenseLog.d(TAG, r12.toString());
        String r14 = this.ssNetworkClient.b(r8, r10, r11, null);     // Catch: Exception -> L9
        CommSenseLog.d(TAG, "POST response: " + r14);     // Catch: Exception -> L9
        return r14;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "POST failed: " + e.getMessage(), e);
        throw e;
    L5:
        r13 = 0;
        goto L6
    }
}
