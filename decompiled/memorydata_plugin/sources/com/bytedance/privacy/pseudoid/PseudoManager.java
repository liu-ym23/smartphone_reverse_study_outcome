package com.bytedance.privacy.pseudoid;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.e.c;
import com.bytedance.privacy.e.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PseudoManager {
    public static final String TAG = "PseudoManager";
    private static volatile PseudoManager pseudoManager;

    static {
    }

    public PseudoManager() {
    }

    private void deletePseudoIDs(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (e.a() == false) goto L29;
        String r0 = com.bytedance.privacy.pseudoid.a.a.f3079a.d();
        if (isRPDIDExist(r8, r7, r0) == false) goto L22;
        String r1 = queryRPDID(r8, r7, r0);
        if (r1 != null) goto L9;
    L19:
        c.d(TAG, "RPDID is already stored, but query failed!");
        return;
    L9:
        if (r1.isEmpty() == true) goto L19;
        if (isDeviceIdExist(r8, r7, r1) == false) goto L16;
        int r2 = com.bytedance.privacy.d.a.e(r8, b.b(r7, r1), new Bundle());
        if (r2 == 0) goto L16;
        c.d(TAG, "delete DeviceID failed, result = " + r2);
    L16:
        int r3 = com.bytedance.privacy.d.a.e(r8, b.a(r7, r0), new Bundle());
        if (r3 == 0) goto L22;
        c.d(TAG, "delete RPDID failed, result = " + r3);
    L22:
        if (com.bytedance.privacy.pseudoid.a.a.f3079a.b() == false) goto L30;
        String r4 = com.bytedance.privacy.pseudoid.a.a.f3079a.a();
        if (isRPUIDExist(r8, r7, r4) == false) goto L31;
        int r5 = com.bytedance.privacy.d.a.e(r8, b.c(r7, r4), new Bundle());
        if (r5 == 0) goto L32;
        c.d(TAG, "delete RPUID failed, result = " + r5);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public static PseudoManager getInstance() {
        if (pseudoManager != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pseudoManager != null) goto L9;
        pseudoManager = new PseudoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return pseudoManager;
    }

    private int getPseudoIDFromCloud(Context r3, String r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        if (r6 == null) goto L15;
        if (r4 != null) goto L8;
    L12:
        String r2 = TAG;
        String r8 = "deviceId cannot be empty!!";
    L13:
        c.d(r2, r8);
        return -2;
    L8:
        if (r4.isEmpty() == true) goto L12;
        return requestPseudoID(r7, r4, r5, r6);
    L15:
        r2 = TAG;
        r8 = "context or appID is null!!";
        goto L13
    }

    private boolean isDeviceIdExist(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(com.bytedance.privacy.d.a.q(), com.bytedance.privacy.d.a.r());
        com.bytedance.privacy.d.a.e r7 = com.bytedance.privacy.d.a.d(r2, b.b(r4, r5), r6);
        if (r7.b() == false) goto L5;
        return false;
    L5:
        if (r7.c() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isRPDIDExist(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(com.bytedance.privacy.d.a.q(), com.bytedance.privacy.d.a.r());
        com.bytedance.privacy.d.a.e r7 = com.bytedance.privacy.d.a.d(r2, b.a(r4, r5), r6);
        if (r7.b() == false) goto L5;
        return false;
    L5:
        if (r7.c() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isRPUIDExist(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(com.bytedance.privacy.d.a.q(), com.bytedance.privacy.d.a.r());
        com.bytedance.privacy.d.a.e r7 = com.bytedance.privacy.d.a.d(r2, b.c(r4, r5), r6);
        if (r7.b() == false) goto L5;
        return false;
    L5:
        if (r7.c() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private String queryRPDID(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(com.bytedance.privacy.d.a.q(), com.bytedance.privacy.d.a.s());
        com.bytedance.privacy.d.a.e r7 = com.bytedance.privacy.d.a.d(r2, b.a(r4, r5), r6);
        if (r7.b() == false) goto L5;
    L16:
        String r8 = TAG;
        String r9 = "Query RPDID failed!!";
    L14:
        c.d(r8, r9);
        return null;
    L5:
        if (r7.c() != 0) goto L16;
        String r10 = r7.d();
        if (r10 != null) goto L10;
    L13:
        r8 = TAG;
        r9 = "Query success, but RPDID is null!!";
        goto L14
    L10:
        if (r10.isEmpty() == true) goto L13;
        return r10;
    }

    private String queryRPUID(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(com.bytedance.privacy.d.a.q(), com.bytedance.privacy.d.a.s());
        com.bytedance.privacy.d.a.e r7 = com.bytedance.privacy.d.a.d(r2, b.c(r4, r5), r6);
        if (r7.b() == false) goto L5;
    L16:
        String r8 = TAG;
        String r9 = "Query RPUID failed!!";
    L14:
        c.d(r8, r9);
        return null;
    L5:
        if (r7.c() != 0) goto L16;
        String r10 = r7.d();
        if (r10 != null) goto L10;
    L13:
        r8 = TAG;
        r9 = "Query success, but RPUID is null!!";
        goto L14
    L10:
        if (r10.isEmpty() == true) goto L13;
        return r10;
    }

    private int requestPseudoID(Context r10, String r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        String r6 = TAG;
        c.a(r6, "request PseudoID, PackageName: " + r14.getPackageName());
        c.a(r6, "request PseudoID, appId:" + r13);
        c.a(r6, "request PseudoID, deviceId:" + r11);
        if (r12.isEmpty() == true) goto L5;
        c.a(r6, "request PseudoID, userId:" + r12);
    L5:
        com.bytedance.privacy.pseudoid.b.b r7 = new com.bytedance.privacy.pseudoid.b.b();
        r7.a("POST");
        r7.b(com.bytedance.privacy.pseudoid.b.a.b());
        int r8 = 0;
        com.bytedance.privacy.b.a.a().a(r14, r13);
        Bundle r5 = new Bundle();
        r5.putInt(com.bytedance.privacy.d.a.a(), com.bytedance.privacy.d.a.d());
        r5.putInt(com.bytedance.privacy.d.a.b(), 256);
        r5.putInt(com.bytedance.privacy.d.a.c(), com.bytedance.privacy.d.a.e());
        List<Certificate> r0 = com.bytedance.privacy.b.a.a().a(r14, r13, r11, false, r5);
        int r1 = -22;
        if (r0 != null) goto L8;
    L41:
        c.d(r6, "Get attest cert chain failed!!");
        r1 = -9;
    L42:
        com.bytedance.privacy.b.a.a().a(r14, r13);
        c.b(TAG, "requestPseudoID end, result:" + r1);
        return r1;
    L8:
        if (r0.isEmpty() == true) goto L41;
        r7.c(com.bytedance.privacy.e.a.a(r0, 3));     // Catch: Exception -> L39
        com.bytedance.privacy.pseudoid.b.c r2 = com.bytedance.privacy.pseudoid.b.a.a().a(r7);
        c.a(r6, "response code:" + r2.a());
        if (r2.a() >= 200) goto L15;
    L38:
        c.d(r6, "Network request failed, error code:" + r2.a());
        r1 = -21;
        goto L42
    L15:
        if (r2.a() >= 300) goto L38;
        if (r2.b() != null) goto L20;
        c.d(r6, "Network response pseudoID is null!");
        r1 = -8;
        goto L42
    L20:
        c.a(r6, "PRDID:" + r2.b().a());
        c.a(r6, "PRUID:" + r2.b().b());
        if (r11.isEmpty() == true) goto L30;
        if (r2.b().a().isEmpty() == false) goto L26;
        String r9 = "Network response RPDID is empty!!";
    L25:
        c.d(r6, r9);
        goto L42
    L26:
        r8 = storePseudoDID(r14, r13, r11, r2.b().a());
        if (r8 == 0) goto L30;
        c.d(r6, "storePseudoDID failed!, result:" + r8);
    L37:
        r1 = r8;
    L30:
        if (r12.isEmpty() == true) goto L37;
        if (r2.b().b().isEmpty() == false) goto L34;
        r9 = "Network response RPUID is empty!!";
        goto L25
    L34:
        r1 = storePseudoUID(r14, r13, r12, r2.b().b());
        if (r1 == 0) goto L42;
        r9 = "storePseudoUID failed!, result:" + r1;
    L39:
        e = move-exception;
        c.d(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        r1 = -100;
        goto L42
    }

    private int storePseudoDID(Context r10, String r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (isRPDIDExist(r14, r11, r12) == true) goto L12;
        int r0 = com.bytedance.privacy.d.a.a(r14, r13, r11, b.a(r11, r12), "RPDID", new Bundle());
        if (r0 != (-1)) goto L8;
    L6:
        c.d(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r0 == 0) goto L12;
        c.d(TAG, "Store RPDID failed!! result: " + r0);
        return r0;
    L12:
        if (isDeviceIdExist(r14, r11, r13) == true) goto L19;
        int r9 = com.bytedance.privacy.d.a.a(r14, r12, r11, b.b(r11, r13), "DID", new Bundle());
        if (r9 == (-1)) goto L6;
        if (r9 == 0) goto L21;
        c.d(TAG, "Store deviceID failed!! result: " + r9);
        return r9;
    L21:
        return 0;
    L19:
        return 0;
    }

    private int storePseudoUID(Context r7, String r8, String r9, String r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (isRPUIDExist(r0, r8, r9) == true) goto L11;
        int r6 = com.bytedance.privacy.d.a.a(r0, r10, r8, b.c(r8, r9), "RPUID", new Bundle());
        if (r6 != (-1)) goto L8;
        c.d(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r6 == 0) goto L13;
        c.d(TAG, "Store RPUID failed!! result: " + r6);
        return r6;
    L13:
        return 0;
    L11:
        return 0;
    }

    public String getPseudoDID(Context r17, String r18) {
        String r1 = r18;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        long r3 = System.currentTimeMillis();
        String r6 = TAG;
        c.b(r6, "getPseudoDID enter");
        if (r2 == null) goto L121;
        if (r1 == null) goto L121;
        String r12 = r2.getPackageName();     // Catch: Throwable -> L128 Exception -> L130
    L119:
        e = e;
    L153:
        c.d(TAG, "getPseudoDID failed, error=" + e.getClass().getSimpleName());     // Catch: Throwable -> L140
        long r14 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L137;
        String r13 = r1;
    L138:
        a.a(0, 0, r12, r13, r14);
        return null;
    L137:
        r13 = "";
    L140:
        th = move-exception;
        Throwable r7 = th;
        int r0 = 0;
    L142:
        String r4 = r12;
    L143:
        long r5 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L147;
        r1 = "";
    L147:
        a.a(r0, 0, r4, r1, r5);
        throw r7;
    L117:
        th = move-exception;
        r7 = th;
        r0 = 0;
        goto L142
    L8:
        if (r18.isEmpty() == false) goto L10;
    L110:
        c.d(r6, "AppId size is invalid!!");     // Catch: Throwable -> L117 Exception -> L119
        long r15 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L114;
        String r16 = r1;
    L115:
        a.a(-3, 0, r12, r16, r15);
        return null;
    L114:
        r16 = "";
        goto L115
    L10:
        if (r18.length() > 128) goto L110;
        String r8 = com.bytedance.privacy.pseudoid.a.a.f3079a.d();     // Catch: Throwable -> L117 Exception -> L119
        if (r8.isEmpty() == false) goto L21;
        c.d(r6, "deviceId is empty!");     // Catch: Throwable -> L117 Exception -> L119
        long r19 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L18;
        String r110 = r1;
    L19:
        a.a(-4, 0, r12, r110, r19);
        return null;
    L18:
        r110 = "";
        goto L19
    L21:
        int r10 = -6;
        if (e.a() == false) goto L34;
        if (e.a(1) == false) goto L34;
        c.a(r6, "getPseudoDID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L117 Exception -> L119
        String r9 = r18.intern();     // Catch: Throwable -> L117 Exception -> L119
        monitor-enter(r9);     // Catch: Throwable -> L117 Exception -> L119
        deletePseudoIDs(r2, r1);     // Catch: Throwable -> L30
        monitor-exit(r9);     // Catch: Throwable -> L30
    L46:
        String r11 = r18.intern();     // Catch: Throwable -> L117 Exception -> L119
        monitor-enter(r11);     // Catch: Throwable -> L117 Exception -> L119
    L107:
        th = th;
    L108:
        monitor-exit(r11);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L117 Exception -> L119
    L152:
        if (isRPDIDExist(r2, r1, r8) == false) goto L68;
        String r20 = queryRPDID(r2, r1, r8);     // Catch: Throwable -> L107
        if (TextUtils.isEmpty(r20) == false) goto L55;
        c.d(r6, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L66
    L56:
        monitor-exit(r11);     // Catch: Throwable -> L63
        long r111 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L60;
        String r112 = r1;
    L61:
        a.a(r10, 0, r12, r112, r111);
        return r20;
    L60:
        r112 = "";
        goto L61
    L55:
        r10 = 0;
        goto L56
    L68:
        c.b(r6, "need to get pseudoID from cloud");     // Catch: Throwable -> L107
        if (com.bytedance.privacy.pseudoid.a.a.f3079a.b() == true) goto L72;
        c.b(r6, "Account is not login!!");     // Catch: Throwable -> L107
        String r113 = "";
    L71:
        int r21 = getPseudoIDFromCloud(r2, r8, r113, r1);     // Catch: Throwable -> L107
        if (r21 == 0) goto L94;
        c.d(r6, "get pseudoID from cloud failed, error: " + r21);     // Catch: Throwable -> L107
        monitor-exit(r11);     // Catch: Throwable -> L107
        long r114 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L91;
        String r115 = r1;
    L92:
        a.a(r21, 0, r12, r115, r114);
        return null;
    L91:
        r115 = "";
        goto L92
    L94:
        String r22 = queryRPDID(r2, r1, r8);     // Catch: Throwable -> L107
        if (TextUtils.isEmpty(r22) == false) goto L99;
        c.d(r6, "RPDID store success, but query failed!");     // Catch: Throwable -> L66
    L100:
        monitor-exit(r11);     // Catch: Throwable -> L63
        long r116 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L104;
        String r117 = r1;
    L105:
        a.a(r10, 0, r12, r117, r116);
        return r22;
    L104:
        r117 = "";
        goto L105
    L99:
        r10 = r21;
        goto L100
    L72:
        c.b(r6, "Account is login!!");     // Catch: Throwable -> L107
        r113 = com.bytedance.privacy.pseudoid.a.a.f3079a.a();     // Catch: Throwable -> L107
        if (r113.isEmpty() == false) goto L71;
        c.d(r6, "Account is login, but userId is empty!");     // Catch: Throwable -> L107
        r10 = -5;
        monitor-exit(r11);     // Catch: Throwable -> L83
        long r118 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L80;
        String r119 = r1;
    L81:
        a.a(-5, 0, r12, r119, r118);
        return null;
    L80:
        r119 = "";
    L83:
        th = th;
    L63:
        th = th;
    L66:
        th = th;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L117 Exception -> L119
    L34:
        if (isRPDIDExist(r2, r1, r8) == false) goto L46;
        String r23 = queryRPDID(r2, r1, r8);     // Catch: Throwable -> L117 Exception -> L119
        if (TextUtils.isEmpty(r23) == false) goto L39;
        c.d(r6, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L117 Exception -> L119
    L40:
        long r120 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L43;
        String r121 = r1;
    L44:
        a.a(r10, 0, r12, r121, r120);
        return r23;
    L43:
        r121 = "";
        goto L44
    L39:
        r10 = 0;
    L121:
        c.d(r6, "Context or appId is null!!");     // Catch: Throwable -> L128 Exception -> L130
        long r24 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L126;
        r1 = "";
    L126:
        a.a(-2, 0, "", r1, r24);
        return null;
    L130:
        e = e;
        r12 = "";
    L128:
        th = move-exception;
        r7 = th;
        r4 = "";
        r0 = 0;
        goto L143
    }

    public String getPseudoUID(Context r17, String r18) {
        String r1 = r18;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        long r3 = System.currentTimeMillis();
        String r6 = TAG;
        c.b(r6, "getPseudoUID enter");
        if (r2 == null) goto L122;
        if (r1 == null) goto L122;
        String r12 = r2.getPackageName();     // Catch: Throwable -> L129 Exception -> L131
    L120:
        e = e;
    L155:
        c.d(TAG, "getPseudoUID failed, error=" + e.getClass().getSimpleName());     // Catch: Throwable -> L141
        long r14 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L138;
        String r13 = r1;
    L139:
        a.a(0, 1, r12, r13, r14);
        return null;
    L138:
        r13 = "";
    L141:
        th = move-exception;
        Throwable r7 = th;
        int r0 = 0;
    L143:
        String r4 = r12;
    L144:
        long r5 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L148;
        r1 = "";
    L148:
        a.a(r0, 1, r4, r1, r5);
        throw r7;
    L118:
        th = move-exception;
        r7 = th;
        r0 = 0;
        goto L143
    L8:
        if (r18.isEmpty() == false) goto L10;
    L111:
        c.d(r6, "AppId size is invalid!!");     // Catch: Throwable -> L118 Exception -> L120
        long r15 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L115;
        String r16 = r1;
    L116:
        a.a(-3, 1, r12, r16, r15);
        return null;
    L115:
        r16 = "";
        goto L116
    L10:
        if (r18.length() > 128) goto L111;
        if (com.bytedance.privacy.pseudoid.a.a.f3079a.b() == true) goto L21;
        c.d(r6, "Account is not login, no userId!!");     // Catch: Throwable -> L118 Exception -> L120
        long r19 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L18;
        String r110 = r1;
    L19:
        a.a(-20, 1, r12, r110, r19);
        return null;
    L18:
        r110 = "";
        goto L19
    L21:
        String r8 = com.bytedance.privacy.pseudoid.a.a.f3079a.a();     // Catch: Throwable -> L118 Exception -> L120
        if (r8.isEmpty() == false) goto L30;
        c.d(r6, "Account is login, but userId is empty!");     // Catch: Throwable -> L118 Exception -> L120
        long r111 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L27;
        String r112 = r1;
    L28:
        a.a(-5, 1, r12, r112, r111);
        return null;
    L27:
        r112 = "";
        goto L28
    L30:
        int r10 = -7;
        if (e.a() == false) goto L43;
        if (e.a(1) == false) goto L43;
        c.a(r6, " getPseudoUID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L118 Exception -> L120
        String r9 = r18.intern();     // Catch: Throwable -> L118 Exception -> L120
        monitor-enter(r9);     // Catch: Throwable -> L118 Exception -> L120
        deletePseudoIDs(r2, r1);     // Catch: Throwable -> L39
        monitor-exit(r9);     // Catch: Throwable -> L39
    L55:
        c.b(r6, "need to get pseudoID from cloud");     // Catch: Throwable -> L118 Exception -> L120
        String r11 = com.bytedance.privacy.pseudoid.a.a.f3079a.d();     // Catch: Throwable -> L118 Exception -> L120
        if (r11.isEmpty() == false) goto L64;
        c.d(r6, "getPseudoUID, DID is empty!");     // Catch: Throwable -> L118 Exception -> L120
        long r113 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L61;
        String r114 = r1;
    L62:
        a.a(-4, 1, r12, r114, r113);
        return null;
    L61:
        r114 = "";
        goto L62
    L64:
        String r115 = r18.intern();     // Catch: Throwable -> L118 Exception -> L120
        monitor-enter(r115);     // Catch: Throwable -> L118 Exception -> L120
    L108:
        th = th;
    L109:
        monitor-exit(r115);     // Catch: Throwable -> L108
        throw th;     // Catch: Throwable -> L118 Exception -> L120
    L150:
        if (isRPUIDExist(r2, r1, r8) == false) goto L83;
        String r20 = queryRPUID(r2, r1, r8);     // Catch: Throwable -> L108
    L81:
        th = th;
        goto L109
    L70:
        if (TextUtils.isEmpty(r20) == false) goto L73;
        c.d(r6, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L81
    L74:
        monitor-exit(r115);     // Catch: Throwable -> L104
        long r116 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L78;
        String r117 = r1;
    L79:
        a.a(r10, 1, r12, r117, r116);
        return r20;
    L78:
        r117 = "";
        goto L79
    L73:
        r10 = 0;
        goto L74
    L83:
        r10 = getPseudoIDFromCloud(r2, r11, r8, r1);     // Catch: Throwable -> L108
        if (r10 == 0) goto L93;
        c.d(r6, "get pseudoID from cloud failed, error: " + r10);     // Catch: Throwable -> L106
        monitor-exit(r115);     // Catch: Throwable -> L106
        long r118 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L90;
        String r119 = r1;
    L91:
        a.a(r10, 1, r12, r119, r118);
        return null;
    L90:
        r119 = "";
        goto L91
    L93:
        String r21 = queryRPUID(r2, r1, r8);     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(r21) == false) goto L97;
        c.d(r6, "RPUID store success, but query failed!");     // Catch: Throwable -> L104
    L97:
        monitor-exit(r115);     // Catch: Throwable -> L104
        long r120 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L101;
        String r121 = r1;
    L102:
        a.a(r10, 1, r12, r121, r120);
        return r21;
    L101:
        r121 = "";
    L106:
        th = th;
    L104:
        th = th;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L118 Exception -> L120
    L43:
        if (isRPUIDExist(r2, r1, r8) == false) goto L55;
        String r22 = queryRPUID(r2, r1, r8);     // Catch: Throwable -> L118 Exception -> L120
        if (TextUtils.isEmpty(r22) == false) goto L48;
        c.d(r6, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L118 Exception -> L120
    L49:
        long r122 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L52;
        String r123 = r1;
    L53:
        a.a(r10, 1, r12, r123, r122);
        return r22;
    L52:
        r123 = "";
        goto L53
    L48:
        r10 = 0;
    L122:
        c.d(r6, "Context or app Id is null!!");     // Catch: Throwable -> L129 Exception -> L131
        long r23 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L127;
        r1 = "";
    L127:
        a.a(-2, 1, "", r1, r23);
        return null;
    L131:
        e = e;
        r12 = "";
    L129:
        th = move-exception;
        r7 = th;
        r4 = "";
        r0 = 0;
        goto L144
    }

    public String queryDIDFromRPDID(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L30;
        if (r5 == null) goto L30;
        if (r6 == null) goto L30;
        if (r5.isEmpty() == false) goto L10;
    L29:
        String r7 = TAG;
        String r8 = "AppId or rpDID size is invalid!!";
    L26:
        c.d(r7, r8);
        return null;
    L10:
        if (r5.length() > 128) goto L29;
        if (r6.isEmpty() == true) goto L29;
        Bundle r0 = new Bundle();
        r0.putInt(com.bytedance.privacy.d.a.q(), com.bytedance.privacy.d.a.s());
        com.bytedance.privacy.d.a.e r9 = com.bytedance.privacy.d.a.d(r3, b.b(r5, r6), r0);
        if (r9.b() == false) goto L17;
    L28:
        r7 = TAG;
        r8 = "Query original deviceId failed!!";
        goto L26
    L17:
        if (r9.c() != 0) goto L28;
        String r10 = r9.d();
        if (r10 != null) goto L22;
    L25:
        r7 = TAG;
        r8 = "Query success, but original deviceId is null!!";
        goto L26
    L22:
        if (r10.isEmpty() == true) goto L25;
        return r10;
    L30:
        r7 = TAG;
        r8 = "input param is null!!";
        goto L26
    }
}
