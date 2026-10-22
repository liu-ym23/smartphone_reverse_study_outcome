package com.obric.aikernel.runtime.utils;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f5431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5432b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5433c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Boolean f5434d;

    static {
        f5431a = new i();
        f5432b = "App";
        f5433c = "plugin";
    }

    private i() {
    }

    @JvmStatic
    public static final int c() {
        String r10 = i.class.getSimpleName();
        Integer r11 = f5431a.d("aiassistant.version.AssistantVersion", "AssistantVersion#getVersion");     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        int r12 = r11.intValue();     // Catch: Throwable -> L7
    L10:
        if (r12 == (-1)) goto L19;
    L17:
        d r13 = d.f5417a;
        Intrinsics.checkNotNullExpressionValue(r10, "tag");
        r13.c(r10, "getObricApiVersion, version: " + r12);
        return r12;
    L19:
        Integer r14 = f5431a.d("obric.version.ObricVersion", "ObricVersion#getVersion");     // Catch: Throwable -> L15
        if (r14 == null) goto L17;
        r12 = r14.intValue();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d r15 = d.f5417a;
        Intrinsics.checkNotNullExpressionValue(r10, "tag");
        r15.c(r10, "getObricVersion failed, e: " + th);
    L9:
        r12 = -1;
    L7:
        th = move-exception;
        d r16 = d.f5417a;
        Intrinsics.checkNotNullExpressionValue(r10, "tag");
        r16.c(r10, "getAssistantVersion failed, e: " + th);
        goto L9
    }

    private final Integer d(String r10, String r11) {
        String r12 = null;
        Object r13 = Class.forName(r10).getDeclaredMethod("getVersion", new Class[0]).invoke(null, new Object[0]);
        if ((r13 instanceof Number) == false) goto L5;
        Number r14 = (Number) r13;
    L6:
        if (r14 == null) goto L8;
        Integer r15 = Integer.valueOf(r14.intValue());
    L9:
        if (r15 != null) goto L17;
        d r16 = d.f5417a;
        String r17 = i.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r17, "SecurityUtils::class.java.simpleName");
        StringBuilder r18 = new StringBuilder();
        r18.append(r11);
        r18.append(" returned ");
        if (r13 == null) goto L13;
        r12 = r13.getClass().getName();
    L13:
        if (r12 != null) goto L15;
        r12 = "null";
    L16:
        r18.append(r12);
        r16.c(r17, r18.toString());
        goto L17
    L15:
        Intrinsics.checkNotNullExpressionValue(r12, "result?.javaClass?.name ?: \"null\"");
    L17:
        return r15;
    L8:
        r15 = null;
        goto L9
    L5:
        r14 = null;
        goto L6
    }

    @JvmStatic
    public static final String e() {
        if (h() != true) goto L5;
        return "com.aiassistant.security.fileencrypt.FileEncrypt";
    L5:
        return "com.obric.security.fileencrypt.FileEncrypt";
    }

    @JvmStatic
    public static final String f() {
        if (h() != true) goto L5;
        return "com.aiassistant.security.ssl.AssistantKeyManager";
    L5:
        return "com.obric.security.ssl.ObricKeyManager";
    }

    @JvmStatic
    public static final String g() {
        if (h() != true) goto L5;
        return "com.aiassistant.security.rot_provision.RotProvisionManager";
    L5:
        return "com.obric.security.rot_provision.RotProvisionManager";
    }

    @JvmStatic
    public static final boolean h() {
        Boolean r10 = f5434d;
        if (r10 != null) goto L5;
        i r11 = f5431a;
        monitor-enter(r11);
        Boolean r12 = f5434d;     // Catch: Throwable -> L18
        if (r12 == null) goto L12;
        boolean r13 = r12.booleanValue();     // Catch: Throwable -> L18
    L16:
        monitor-exit(r11);
        return r13;
    L12:
        if (c() < 10) goto L14;
        r13 = true;
    L15:
        f5434d = Boolean.valueOf(r13);     // Catch: Throwable -> L18
        goto L16
    L14:
        r13 = false;
    L18:
        th = move-exception;
        throw th;
    L5:
        return r10.booleanValue();
    }

    public final String a() {
        return f5432b;
    }

    public final String b() {
        return f5433c;
    }
}
