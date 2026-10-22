package com.bytedance.ttnet.diagnosis;

import a7.i;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import w8.b;
import z8.a;

/* JADX INFO: loaded from: classes.dex */
public class TTNetDiagnosisService {
    public static final int ACCELERATE_TARGET = 2;
    public static final int DIAGNOSE_TARGET = 3;
    public static final int DIAGNOSE_V2_TARGET = 4;
    public static final int DNS_RESOLVE_TARGET = 0;
    public static final int NET_DETECT_ALL = 67;
    public static final int NET_DETECT_HTTP_GET = 1;
    public static final int NET_DETECT_ICMP_PING = 2;
    public static final int NET_DETECT_UDP_PING = 64;
    public static final int RACE_TARGETS = 1;
    private static final Map<Integer, String> sTypeStringMap = null;

    static {
        HashMap r8 = new HashMap();
        sTypeStringMap = r8;
        r8.put(0, "DNS_RESOLVE_TARGET");
        r8.put(1, "RACE_TARGETS");
        r8.put(2, "ACCELERATE_TARGET");
        r8.put(3, "DIAGNOSE_TARGET");
        r8.put(4, "DIAGNOSE_V2_TARGET");
    }

    public TTNetDiagnosisService() {
    }

    public static IDiagnosisRequest createRequest(int r8, String r10, int r11, int r12) {
        if (isOneTargetRequestType(r8) == false) goto L20;
        if (isValidNetDetect(r8, r11) == false) goto L18;
        if (r8 != 0) goto L8;
    L15:
        ArrayList r13 = new ArrayList();
        r13.add(r10);
        return new a(r8, r13, r11, r12);
    L8:
        if (r8 == 2) goto L15;
        if (r8 == 3) goto L15;
        if (r8 == 4) goto L15;
        return null;
    L18:
        throw new IllegalArgumentException(defpackage.a.d("Illegal netDetectType: ", r11));
    L20:
        throw new IllegalArgumentException(android.aimedia.a.i(new StringBuilder("Type "), requestTypeToString(r8), " of request should be created with multiple targets."));
    }

    private static i getCronetHttpClient() {
        if (b.b() == false) goto L7;
        return i.m(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static boolean isOneTargetRequestType(int r8) {
        if (r8 == 0) goto L16;
        if (r8 != 1) goto L6;
        return false;
    L6:
        if (r8 == 2) goto L16;
        if (r8 == 3) goto L16;
        if (r8 == 4) goto L16;
        throw new IllegalArgumentException(defpackage.a.d("Illegal request type: ", r8));
    L16:
        return true;
    }

    private static boolean isValidNetDetect(int r8, long r10) {
        if (r8 != 0) goto L5;
        return true;
    L5:
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L17;
        if (r8 != 3) goto L11;
    L15:
        return true;
    L11:
        if (r8 == 4) goto L15;
        throw new IllegalArgumentException(defpackage.a.d("Illegal request type: ", r8));
    L17:
        if (r10 != 1) goto L19;
    L24:
        return true;
    L19:
        if (r10 == 2) goto L24;
        if (r10 == 64) goto L24;
        return false;
    L26:
        if ((67 & r10) != 0) goto L28;
    L30:
        return false;
    L28:
        if ((r10 & (-68)) != 0) goto L30;
        return true;
    }

    public static void reportUserLog(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L20;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (getCronetHttpClient() == null) goto L18;
        ICronetClient r10 = i.f111b;     // Catch: Exception -> L13
        if (r10 == null) goto L12;
        Reflect.on(r10).call("reportNetDiagnosisUserLog", new Class[]{String.class}, new Object[]{r8});     // Catch: Exception -> L13
        return;
    L12:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");     // Catch: Exception -> L13
    L18:
        return;
    }

    private static String requestTypeToString(int r8) {
        return sTypeStringMap.get(Integer.valueOf(r8));
    }

    public static IDiagnosisRequest createRequest(int r8, List<String> r10, int r11, int r12) {
        if (isOneTargetRequestType(r8) == true) goto L15;
        if (isValidNetDetect(r8, r11) == false) goto L13;
        if (r8 == 1) goto L11;
        return null;
    L11:
        return new a(r8, r10, r11, r12);
    L13:
        throw new IllegalArgumentException(defpackage.a.d("Illegal netDetectType: ", r11));
    L15:
        throw new IllegalArgumentException(android.aimedia.a.i(new StringBuilder("Type "), requestTypeToString(r8), " of request should be created with only one target."));
    }
}
