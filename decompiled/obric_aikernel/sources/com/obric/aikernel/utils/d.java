package com.obric.aikernel.utils;

import android.content.Context;
import android.util.Log;
import com.bytedance.keva.KevaImpl;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5591a = null;

    static {
        f5591a = new d();
    }

    private d() {
    }

    private final double a(long r10) {
        return d(r10 / ((double) 1048576), 2);
    }

    private final long b(File r10) {
        long r11 = 0;
        if (r10.isFile() == false) goto L8;
        if (Files.isSymbolicLink(r10.toPath()) == false) goto L8;
        return 0;
    L8:
        if (r10.isFile() == true) goto L18;
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L16;
        int r13 = 0;
        int r14 = r12.length;
    L13:
        if (r13 >= r14) goto L16;
        File r15 = r12[r13];
        d r16 = f5591a;
        Intrinsics.checkNotNullExpressionValue(r15, "file");
        r11 = r11 + r16.b(r15);
        r13 = r13 + 1;
    L16:
        return r11;
    L18:
        return r10.length();
    }

    private final double d(double r10, int r11) {
        double r12 = 1.0d;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r12 = r12 * ((double) 10);
        r13 = r13 + 1;
        goto L3
    L6:
        return Math.rint(r10 * r12) / r12;
    }

    public final void c(String r21) {
        String r10 = "listFiles()";
        LinkedHashMap r11 = new LinkedHashMap();
        LinkedHashMap r12 = new LinkedHashMap();
        Context r13 = AppContext.INSTANCE.getContext();     // Catch: Exception -> L74
        List r14 = CollectionsKt.listOf(new String[]{"models", "logs", "ALOG", "prs"});     // Catch: Exception -> L74
        Log.d("DiskSpace", "internalDirs: " + r14);     // Catch: Exception -> L74
        Iterator r15 = r14.iterator();     // Catch: Exception -> L74
    L5:
        if (r15.hasNext() == false) goto L11;
        File r16 = new File(r13.getFilesDir(), (String) r15.next());     // Catch: Exception -> L74
        if (r16.exists() == true) goto L9;
        r11.put("inner_" + r16.getName(), Double.valueOf(0.0d));     // Catch: Exception -> L74
        goto L5
    L9:
        d r17 = f5591a;     // Catch: Exception -> L74
        r11.put("inner_" + r16.getName(), Double.valueOf(r17.a(r17.b(r16))));     // Catch: Exception -> L74
        goto L5
    L11:
        File r18 = r13.getFilesDir();     // Catch: Exception -> L74
        Intrinsics.checkNotNullExpressionValue(r18, "context.filesDir");     // Catch: Exception -> L74
        double r19 = a(b(r18));     // Catch: Exception -> L74
        r11.put(KevaImpl.PrivateConstants.FILES_DIR_NAME, Double.valueOf(r19));     // Catch: Exception -> L74
        double r20 = r19 + 0.0d;     // Catch: Exception -> L74
        if (r21 != null) goto L14;
    L64:
        r11.put("grand_total", Double.valueOf(d(r20, 2)));     // Catch: Exception -> L74
        JSONObject r22 = new JSONObject();     // Catch: Exception -> L74
        Iterator r23 = r11.entrySet().iterator();     // Catch: Exception -> L74
    L66:
        if (r23.hasNext() == false) goto L68;
        Map.Entry r24 = (Map.Entry) r23.next();     // Catch: Exception -> L74
        r22.put((String) r24.getKey(), ((Number) r24.getValue()).doubleValue());     // Catch: Exception -> L74
        goto L66
    L68:
        Iterator r25 = r12.entrySet().iterator();     // Catch: Exception -> L74
    L70:
        if (r25.hasNext() == false) goto L72;
        Map.Entry r26 = (Map.Entry) r25.next();     // Catch: Exception -> L74
        r22.put((String) r26.getKey(), (String) r26.getValue());     // Catch: Exception -> L74
        goto L70
    L72:
        TrackerApi.INSTANCE.onEvent("aik_disk_usage_event", r22);     // Catch: Exception -> L74
        return;
    L14:
        if ((!StringsKt.isBlank(r21)) == false) goto L16;
        String r27 = r21;
    L17:
        if (r27 == null) goto L64;
        File r28 = new File(r27);     // Catch: Exception -> L74
        if (r28.exists() == false) goto L64;
        d r29 = f5591a;     // Catch: Exception -> L74
        double r110 = r29.a(r29.b(r28));     // Catch: Exception -> L74
        r11.put("fbe", Double.valueOf(r110));     // Catch: Exception -> L74
        double r30 = r20 + r110;     // Catch: Exception -> L74
        File r111 = new File(r28, "preset_model_decrypt");     // Catch: Exception -> L74
        if (r111.exists() == false) goto L24;
        r11.put("fbe_" + r111.getName(), Double.valueOf(r29.a(r29.b(r111))));     // Catch: Exception -> L74
    L25:
        Iterator r31 = CollectionsKt.listOf(new String[]{"prs/models", "prs/libs"}).iterator();     // Catch: Exception -> L74
    L27:
        if (r31.hasNext() == false) goto L58;
        File r112 = new File(r28, (String) r31.next());     // Catch: Exception -> L74
        if (r112.exists() == false) goto L56;
        d r113 = f5591a;     // Catch: Exception -> L74
        r11.put("fbe_" + r112.getName(), Double.valueOf(r113.a(r113.b(r112))));     // Catch: Exception -> L74
        StringBuilder r114 = new StringBuilder();     // Catch: Exception -> L74
        File[] r115 = r112.listFiles();     // Catch: Exception -> L74
        if (r115 == null) goto L55;
        Intrinsics.checkNotNullExpressionValue(r115, r10);     // Catch: Exception -> L74
        ArrayList r116 = new ArrayList();     // Catch: Exception -> L74
        int r117 = r115.length;     // Catch: Exception -> L74
        int r32 = 0;
    L33:
        if (r32 >= r117) goto L38;
        File r33 = r115[r32];     // Catch: Exception -> L74
        if (r33.isDirectory() == false) goto L37;
        r116.add(r33);     // Catch: Exception -> L74
    L37:
        r32 = r32 + 1;     // Catch: Exception -> L74
        goto L33
    L38:
        Iterator r34 = r116.iterator();     // Catch: Exception -> L74
    L40:
        if (r34.hasNext() == false) goto L55;
        File r35 = (File) r34.next();     // Catch: Exception -> L74
        File[] r118 = r35.listFiles();     // Catch: Exception -> L74
        if (r118 == null) goto L53;
        Intrinsics.checkNotNullExpressionValue(r118, r10);     // Catch: Exception -> L74
        ArrayList r119 = new ArrayList();     // Catch: Exception -> L74
        int r120 = r118.length;     // Catch: Exception -> L74
        int r36 = 0;
    L44:
        if (r36 >= r120) goto L49;
        double r121 = r30;
        File r37 = r118[r36];     // Catch: Exception -> L74
        if (r37.isDirectory() == false) goto L48;
        r119.add(r37);     // Catch: Exception -> L74
    L48:
        r36 = r36 + 1;     // Catch: Exception -> L74
        r30 = r121;
        goto L44
    L49:
        double r122 = r30;
        Iterator r38 = r119.iterator();     // Catch: Exception -> L74
    L51:
        if (r38.hasNext() == false) goto L54;
        File r39 = (File) r38.next();     // Catch: Exception -> L74
        d r40 = f5591a;     // Catch: Exception -> L74
        Intrinsics.checkNotNullExpressionValue(r39, "level2Dir");     // Catch: Exception -> L74
        long r123 = r40.b(r39);     // Catch: Exception -> L74
        StringBuilder r124 = new StringBuilder();     // Catch: Exception -> L74
        r124.append(r35.getName());     // Catch: Exception -> L74
        r124.append('/');     // Catch: Exception -> L74
        r124.append(r39.getName());     // Catch: Exception -> L74
        r124.append(": ");     // Catch: Exception -> L74
        r124.append(r40.a(r123));     // Catch: Exception -> L74
        r124.append(" MB; ");     // Catch: Exception -> L74
        r114.append(r124.toString());     // Catch: Exception -> L74
        r38 = r38;
    L54:
        r10 = r10;
        r30 = r122;
        goto L40
    L53:
        r122 = r30;
    L55:
        String r125 = r10;
        double r126 = r30;
        String r41 = "fbe_extra_" + r112.getName();     // Catch: Exception -> L74
        String r42 = r114.toString();     // Catch: Exception -> L74
        Intrinsics.checkNotNullExpressionValue(r42, "subDirDetails.toString()");     // Catch: Exception -> L74
        r12.put(r41, r42);     // Catch: Exception -> L74
    L57:
        r10 = r125;
        r30 = r126;
        goto L27
    L56:
        r125 = r10;
        r126 = r30;
        r11.put("fbe_" + r112.getName(), Double.valueOf(0.0d));     // Catch: Exception -> L74
        goto L57
    L58:
        double r127 = r30;
        File r43 = new File(r28, "prs/Aee");     // Catch: Exception -> L74
        if (r43.exists() == false) goto L62;
        d r44 = f5591a;     // Catch: Exception -> L74
        Double r45 = Double.valueOf(r44.a(r44.b(r43)));     // Catch: Exception -> L74
        String r46 = "fbe_" + r43.getName();     // Catch: Exception -> L74
    L61:
        r11.put(r46, r45);     // Catch: Exception -> L74
        r20 = r127;
        goto L64
    L62:
        r46 = "fbe_" + r43.getName();     // Catch: Exception -> L74
        r45 = Double.valueOf(0.0d);     // Catch: Exception -> L74
        goto L61
    L24:
        r11.put("fbe_" + r111.getName(), Double.valueOf(0.0d));     // Catch: Exception -> L74
        goto L25
    L16:
        r27 = null;
    L74:
        e = move-exception;
        e.printStackTrace();
    }
}
