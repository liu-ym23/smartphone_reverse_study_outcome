package com.larus.avlink.e.mock;

import android.util.Base64;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final Gson a = null;

    static {
        a = new Gson();
    }

    public static b49.g a(CameraDataFrameJson r12) {
        if (r12 != null) goto L48;
        return null;
    L48:
        Integer r1 = r12.getStage();     // Catch: Exception -> L45
        if (r1 == null) goto L8;
        int r3 = r1.intValue();     // Catch: Exception -> L45
    L9:
        Integer r2 = r12.getScene();     // Catch: Exception -> L45
        if (r2 == null) goto L12;
        int r4 = r2.intValue();     // Catch: Exception -> L45
    L13:
        Integer r5 = r12.getId();     // Catch: Exception -> L45
        if (r5 == null) goto L16;
        int r6 = r5.intValue();     // Catch: Exception -> L45
    L17:
        Integer r7 = r12.getType();     // Catch: Exception -> L45
        if (r7 == null) goto L20;
        int r8 = r7.intValue();     // Catch: Exception -> L45
    L21:
        Integer r9 = r12.getSeq();     // Catch: Exception -> L45
        if (r9 == null) goto L24;
        int r10 = r9.intValue();     // Catch: Exception -> L45
    L25:
        Integer r11 = r12.getCount();     // Catch: Exception -> L45
        if (r11 == null) goto L28;
        int r13 = r11.intValue();     // Catch: Exception -> L45
    L29:
        String r14 = r12.getDataBase64();     // Catch: Exception -> L45
        if (r14 == null) goto L33;
        byte[] r15 = Base64.decode(r14, 0);     // Catch: Exception -> L45
        if (r15 == null) goto L33;
    L34:
        byte[] r16 = r15;
        Integer r17 = r12.getAssId();     // Catch: Exception -> L45
        if (r17 == null) goto L37;
        int r18 = r17.intValue();     // Catch: Exception -> L45
    L38:
        String r19 = r12.getAssDataBase64();     // Catch: Exception -> L45
        if (r19 == null) goto L42;
        byte[] r110 = Base64.decode(r19, 0);     // Catch: Exception -> L45
        if (r110 == null) goto L42;
    L43:
        return new b49.g(r3, r4, r6, r8, r10, r13, r16, r18, r110);
    L42:
        r110 = new byte[0];     // Catch: Exception -> L45
        goto L43
    L37:
        r18 = 0;
    L33:
        r15 = new byte[0];     // Catch: Exception -> L45
        goto L34
    L28:
        r13 = 0;
        goto L29
    L24:
        r10 = 0;
        goto L25
    L20:
        r8 = 0;
        goto L21
    L16:
        r6 = 0;
        goto L17
    L12:
        r4 = 1;
        goto L13
    L8:
        r3 = 0;
    L45:
        e = move-exception;
        FLogger.a.e("CameraMockSerializer", "deserializeDataFrame failed", e);
        return null;
    }

    public static b49.h b(CameraImageInfoJson r13) {
        if (r13 != null) goto L22;
        return null;
    L22:
        Integer r1 = r13.getImageUUID();     // Catch: Exception -> L19
        if (r1 == null) goto L8;
        int r3 = r1.intValue();     // Catch: Exception -> L19
    L9:
        Integer r2 = r13.getSide();     // Catch: Exception -> L19
        if (r2 == null) goto L12;
        int r7 = r2.intValue();     // Catch: Exception -> L19
    L13:
        String r4 = r13.getDataBase64();     // Catch: Exception -> L19
        if (r4 == null) goto L16;
        byte[] r5 = Base64.decode(r4, 0);     // Catch: Exception -> L19
    L17:
        return new b49.h(r3, r5, r13.getWidth(), r13.getHeight(), r13.getFormat(), r7, r13.getLinkType(), 0, 0);
    L16:
        r5 = null;
        goto L17
    L12:
        r7 = 1;
        goto L13
    L8:
        r3 = 0;
    L19:
        e = move-exception;
        FLogger.a.e("CameraMockSerializer", "deserializeImageInfo failed", e);
        return null;
    }

    public static String d(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        String r4 = a.toJson(r3);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        FLogger.a.e("CameraMockSerializer", "mapToJsonString failed", e);
        return "{}";
    }

    public static String e(Object r3) {
        String r4 = a.toJson(r3);     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L4
        return r4;
    L4:
        e = move-exception;
        FLogger.a.e("CameraMockSerializer", "toJson failed", e);
        return "";
    }

    public static Object c(String r2, Class r3) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        return a.fromJson(r2, r3);
    L5:
        e = move-exception;
        FLogger.a.e("CameraMockSerializer", "fromJson failed", e);
        return null;
    }
}
